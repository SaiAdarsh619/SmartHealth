package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.IntOffsetKt;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.health.platform.client.SdkConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Drawer.kt */
@Metadata(m286d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0096\u0001\u0010\b\u001a\u00020\t2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a3\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00192\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\u0006\u0010#\u001a\u00020\u0014H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a\u0096\u0001\u0010&\u001a\u00020\t2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020'2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001aA\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u00142\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d2\u0006\u0010!\u001a\u00020\u0019H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a \u00100\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0002H\u0002\u001a+\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u0002062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00140\u000bH\u0007¢\u0006\u0002\u00108\u001a+\u00109\u001a\u00020'2\u0006\u00105\u001a\u00020:2\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u00140\u000bH\u0007¢\u0006\u0002\u0010;\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006<"}, m287d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomDrawerOpenFraction", "DrawerVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "EndDrawerPadding", "BottomDrawer", "", "drawerContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "Landroidx/compose/material/BottomDrawerState;", "gesturesEnabled", "", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "scrimColor", "content", "Lkotlin/Function0;", "BottomDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomDrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BottomDrawerScrim", "color", "onDismiss", "visible", "BottomDrawerScrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "ModalDrawer", "Landroidx/compose/material/DrawerState;", "ModalDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/DrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "open", "onClose", "fraction", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateFraction", "a", "b", "pos", "rememberBottomDrawerState", "initialValue", "Landroidx/compose/material/BottomDrawerValue;", "confirmStateChange", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomDrawerState;", "rememberDrawerState", "Landroidx/compose/material/DrawerValue;", "(Landroidx/compose/material/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DrawerState;", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class DrawerKt {
    private static final float BottomDrawerOpenFraction = 0.5f;
    private static final float EndDrawerPadding = C0504Dp.m4382constructorimpl(56);
    private static final float DrawerVelocityThreshold = C0504Dp.m4382constructorimpl(400);
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    public static final DrawerState rememberDrawerState(final DrawerValue initialValue, final Function1<? super DrawerValue, Boolean> function1, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(-1435874229);
        ComposerKt.sourceInformation($composer, "C(rememberDrawerState)P(1)320@10451L61,320@10387L125:Drawer.kt#jmzs0o");
        if ((i & 2) != 0) {
            Function1 confirmStateChange = new Function1<DrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt$rememberDrawerState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(DrawerValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1435874229, $changed, -1, "androidx.compose.material.rememberDrawerState (Drawer.kt:316)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.INSTANCE.Saver(function1);
        int i2 = ($changed & 14) | ($changed & SdkConfig.SDK_VERSION);
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(initialValue) | $composer.changed(function1);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = (Function0) new Function0<DrawerState>() { // from class: androidx.compose.material.DrawerKt$rememberDrawerState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DrawerState invoke() {
                    return new DrawerState(DrawerValue.this, function1);
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        DrawerState drawerState = (DrawerState) RememberSaveableKt.m1652rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv$iv, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return drawerState;
    }

    @ExperimentalMaterialApi
    public static final BottomDrawerState rememberBottomDrawerState(final BottomDrawerValue initialValue, final Function1<? super BottomDrawerValue, Boolean> function1, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(-598115156);
        ComposerKt.sourceInformation($composer, "C(rememberBottomDrawerState)P(1)337@11003L67,337@10933L137:Drawer.kt#jmzs0o");
        if ((i & 2) != 0) {
            Function1 confirmStateChange = new Function1<BottomDrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt$rememberBottomDrawerState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomDrawerValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-598115156, $changed, -1, "androidx.compose.material.rememberBottomDrawerState (Drawer.kt:333)");
        }
        Object[] objArr = new Object[0];
        Saver<BottomDrawerState, BottomDrawerValue> Saver = BottomDrawerState.Companion.Saver(function1);
        int i2 = ($changed & 14) | ($changed & SdkConfig.SDK_VERSION);
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(initialValue) | $composer.changed(function1);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = (Function0) new Function0<BottomDrawerState>() { // from class: androidx.compose.material.DrawerKt$rememberBottomDrawerState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final BottomDrawerState invoke() {
                    return new BottomDrawerState(BottomDrawerValue.this, function1);
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        BottomDrawerState bottomDrawerState = (BottomDrawerState) RememberSaveableKt.m1652rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv$iv, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return bottomDrawerState;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02be  */
    /* renamed from: ModalDrawer-Gs3lGvM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1366ModalDrawerGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> drawerContent, Modifier modifier, DrawerState drawerState, boolean gesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long scrimColor, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        DrawerState drawerState2;
        boolean z;
        Shape shape;
        float f;
        Modifier modifier2;
        DrawerState drawerState3;
        CornerBasedShape drawerShape2;
        long drawerBackgroundColor2;
        long drawerContentColor2;
        Modifier modifier3;
        long scrimColor2;
        Shape drawerShape3;
        float drawerElevation2;
        long drawerBackgroundColor3;
        long drawerContentColor3;
        DrawerState drawerState4;
        int $dirty;
        boolean gesturesEnabled2;
        Object it$iv$iv$iv;
        Object value$iv$iv$iv;
        Modifier modifier4;
        Composer $composer2;
        ScopeUpdateScope endRestartGroup;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(drawerContent, "drawerContent");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(1305806945);
        ComposerKt.sourceInformation($composer3, "C(ModalDrawer)P(2,8,6,7,5,4:c#ui.unit.Dp,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9:c#ui.graphics.Color)376@12880L39,378@12997L6,380@13112L6,381@13160L38,382@13239L10,385@13307L24,386@13336L3205:Drawer.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(drawerContent) ? 4 : 2;
        }
        int i8 = i & 2;
        if (i8 != 0) {
            $dirty2 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                drawerState2 = drawerState;
                if ($composer3.changed(drawerState2)) {
                    i7 = 256;
                    $dirty2 |= i7;
                }
            } else {
                drawerState2 = drawerState;
            }
            i7 = 128;
            $dirty2 |= i7;
        } else {
            drawerState2 = drawerState;
        }
        int i9 = i & 8;
        if (i9 != 0) {
            $dirty2 |= 3072;
            z = gesturesEnabled;
        } else if (($changed & 7168) == 0) {
            z = gesturesEnabled;
            $dirty2 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = gesturesEnabled;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                shape = drawerShape;
                if ($composer3.changed(shape)) {
                    i6 = 16384;
                    $dirty2 |= i6;
                }
            } else {
                shape = drawerShape;
            }
            i6 = 8192;
            $dirty2 |= i6;
        } else {
            shape = drawerShape;
        }
        int i10 = i & 32;
        if (i10 != 0) {
            $dirty2 |= 196608;
            f = drawerElevation;
        } else if ((458752 & $changed) == 0) {
            f = drawerElevation;
            $dirty2 |= $composer3.changed(f) ? 131072 : 65536;
        } else {
            f = drawerElevation;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0 && $composer3.changed(drawerBackgroundColor)) {
                i5 = 1048576;
                $dirty2 |= i5;
            }
            i5 = 524288;
            $dirty2 |= i5;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0 && $composer3.changed(drawerContentColor)) {
                i4 = 8388608;
                $dirty2 |= i4;
            }
            i4 = 4194304;
            $dirty2 |= i4;
        }
        if ((234881024 & $changed) == 0) {
            if ((i & 256) == 0 && $composer3.changed(scrimColor)) {
                i3 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty2 |= i3;
            }
            i3 = 33554432;
            $dirty2 |= i3;
        }
        if ((i & 512) == 0) {
            i2 = (1879048192 & $changed) == 0 ? $composer3.changed(content) ? 536870912 : 268435456 : 805306368;
            if ((1533916891 & $dirty2) == 306783378 || !$composer3.getSkipping()) {
                $composer3.startDefaults();
                if (($changed & 1) != 0 || $composer3.getDefaultsInvalid()) {
                    Modifier.Companion modifier5 = i8 == 0 ? Modifier.INSTANCE : modifier;
                    if ((i & 4) == 0) {
                        modifier2 = modifier5;
                        drawerState3 = rememberDrawerState(DrawerValue.Closed, null, $composer3, 6, 2);
                        $dirty2 &= -897;
                    } else {
                        modifier2 = modifier5;
                        drawerState3 = drawerState2;
                    }
                    boolean gesturesEnabled3 = i9 == 0 ? true : z;
                    if ((i & 16) == 0) {
                        drawerShape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getLarge();
                        $dirty2 &= -57345;
                    } else {
                        drawerShape2 = shape;
                    }
                    float drawerElevation3 = i10 == 0 ? DrawerDefaults.INSTANCE.m1362getElevationD9Ej5fM() : f;
                    if ((i & 64) == 0) {
                        drawerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1321getSurface0d7_KjU();
                        $dirty2 &= -3670017;
                    } else {
                        drawerBackgroundColor2 = drawerBackgroundColor;
                    }
                    if ((i & 128) == 0) {
                        drawerContentColor2 = ColorsKt.m1335contentColorForek8zF_U(drawerBackgroundColor2, $composer3, ($dirty2 >> 18) & 14);
                        $dirty2 &= -29360129;
                    } else {
                        drawerContentColor2 = drawerContentColor;
                    }
                    if ((i & 256) == 0) {
                        modifier3 = modifier2;
                        drawerShape3 = drawerShape2;
                        drawerContentColor3 = drawerContentColor2;
                        scrimColor2 = DrawerDefaults.INSTANCE.getScrimColor($composer3, 6);
                        drawerState4 = drawerState3;
                        gesturesEnabled2 = gesturesEnabled3;
                        drawerElevation2 = drawerElevation3;
                        drawerBackgroundColor3 = drawerBackgroundColor2;
                        $dirty = $dirty2 & (-234881025);
                    } else {
                        modifier3 = modifier2;
                        scrimColor2 = scrimColor;
                        drawerShape3 = drawerShape2;
                        drawerElevation2 = drawerElevation3;
                        drawerBackgroundColor3 = drawerBackgroundColor2;
                        drawerContentColor3 = drawerContentColor2;
                        drawerState4 = drawerState3;
                        $dirty = $dirty2;
                        gesturesEnabled2 = gesturesEnabled3;
                    }
                } else {
                    $composer3.skipToGroupEnd();
                    if ((i & 4) != 0) {
                        $dirty2 &= -897;
                    }
                    if ((i & 16) != 0) {
                        $dirty2 &= -57345;
                    }
                    if ((i & 64) != 0) {
                        $dirty2 &= -3670017;
                    }
                    if ((i & 128) != 0) {
                        $dirty2 &= -29360129;
                    }
                    if ((i & 256) != 0) {
                        modifier3 = modifier;
                        drawerBackgroundColor3 = drawerBackgroundColor;
                        drawerContentColor3 = drawerContentColor;
                        scrimColor2 = scrimColor;
                        drawerState4 = drawerState2;
                        gesturesEnabled2 = z;
                        drawerShape3 = shape;
                        drawerElevation2 = f;
                        $dirty = (-234881025) & $dirty2;
                    } else {
                        modifier3 = modifier;
                        drawerBackgroundColor3 = drawerBackgroundColor;
                        drawerContentColor3 = drawerContentColor;
                        scrimColor2 = scrimColor;
                        drawerState4 = drawerState2;
                        gesturesEnabled2 = z;
                        drawerShape3 = shape;
                        drawerElevation2 = f;
                        $dirty = $dirty2;
                    }
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1305806945, $dirty, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:373)");
                }
                $composer3.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation($composer3, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                $composer3.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                it$iv$iv$iv = $composer3.rememberedValue();
                if (it$iv$iv$iv != Composer.INSTANCE.getEmpty()) {
                    value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                    $composer3.updateRememberedValue(value$iv$iv$iv);
                } else {
                    value$iv$iv$iv = it$iv$iv$iv;
                }
                $composer3.endReplaceableGroup();
                CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                final CoroutineScope scope = wrapper$iv.getCoroutineScope();
                $composer3.endReplaceableGroup();
                final DrawerState drawerState5 = drawerState4;
                final boolean z2 = gesturesEnabled2;
                final int i11 = $dirty;
                final long j = scrimColor2;
                final Shape shape2 = drawerShape3;
                final long j2 = drawerBackgroundColor3;
                modifier4 = modifier3;
                final long j3 = drawerContentColor3;
                final float f2 = drawerElevation2;
                $composer2 = $composer3;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda($composer2, 816674999, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
                        invoke(boxWithConstraintsScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(BoxWithConstraintsScope BoxWithConstraints, Composer $composer4, int $changed2) {
                        float f3;
                        Modifier modifier$iv;
                        Function0 factory$iv$iv$iv;
                        Function0 factory$iv$iv$iv2;
                        Composer $composer$iv;
                        final float minValue;
                        Object value$iv$iv;
                        Object value$iv$iv2;
                        float f4;
                        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                        ComposerKt.sourceInformation($composer4, "C397@13855L7,398@13894L2641:Drawer.kt#jmzs0o");
                        int $dirty3 = $changed2;
                        if (($changed2 & 14) == 0) {
                            $dirty3 |= $composer4.changed(BoxWithConstraints) ? 4 : 2;
                        }
                        if (($dirty3 & 91) == 18 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(816674999, $changed2, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:386)");
                        }
                        long modalDrawerConstraints = BoxWithConstraints.getConstraints();
                        if (!Constraints.m4334getHasBoundedWidthimpl(modalDrawerConstraints)) {
                            throw new IllegalStateException("Drawer shouldn't have infinite width");
                        }
                        float minValue2 = -Constraints.m4338getMaxWidthimpl(modalDrawerConstraints);
                        final float maxValue = 0.0f;
                        Map anchors = MapsKt.mapOf(TuplesKt.m294to(Float.valueOf(minValue2), DrawerValue.Closed), TuplesKt.m294to(Float.valueOf(0.0f), DrawerValue.Open));
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume = $composer4.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        boolean isRtl = consume == LayoutDirection.Rtl;
                        Modifier.Companion companion = Modifier.INSTANCE;
                        SwipeableState<DrawerValue> swipeableState$material_release = DrawerState.this.getSwipeableState$material_release();
                        Orientation orientation = Orientation.Horizontal;
                        f3 = DrawerKt.DrawerVelocityThreshold;
                        modifier$iv = SwipeableKt.m1523swipeablepPrIpRY(companion, swipeableState$material_release, anchors, orientation, (r26 & 8) != 0 ? true : z2, (r26 & 16) != 0 ? false : isRtl, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function2
                            public final FixedThreshold invoke(T t, T t2) {
                                return new FixedThreshold(C0504Dp.m4382constructorimpl(56), null);
                            }
                        } : new Function2<DrawerValue, DrawerValue, ThresholdConfig>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1.1
                            @Override // kotlin.jvm.functions.Function2
                            public final ThresholdConfig invoke(DrawerValue drawerValue, DrawerValue drawerValue2) {
                                Intrinsics.checkNotNullParameter(drawerValue, "<anonymous parameter 0>");
                                Intrinsics.checkNotNullParameter(drawerValue2, "<anonymous parameter 1>");
                                return new FractionalThreshold(0.5f);
                            }
                        }, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, anchors.keySet(), 0.0f, 0.0f, 6, null) : null, (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1522getVelocityThresholdD9Ej5fM() : f3);
                        final DrawerState drawerState6 = DrawerState.this;
                        final int i12 = i11;
                        long j4 = j;
                        Shape shape3 = shape2;
                        long j5 = j2;
                        long j6 = j3;
                        float maxValue2 = f2;
                        Function2<Composer, Integer, Unit> function2 = content;
                        final boolean z3 = z2;
                        final CoroutineScope coroutineScope = scope;
                        final Function3<ColumnScope, Composer, Integer, Unit> function3 = drawerContent;
                        $composer4.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv = (0 << 3) & SdkConfig.SDK_VERSION;
                        $composer4.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume2 = $composer4.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Density density$iv$iv = (Density) consume2;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume3 = $composer4.consume(localLayoutDirection2);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume4 = $composer4.consume(localViewConfiguration);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
                        Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv3;
                            $composer4.createNode(factory$iv$iv$iv);
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv3;
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
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            int $changed3 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                            $composer4.startReplaceableGroup(-1263168067);
                            ComposerKt.sourceInformation($composer4, "C410@14358L45,423@14805L103,413@14416L542,428@14992L33,*430@15092L7,439@15556L55,429@15038L1487:Drawer.kt#jmzs0o");
                            if (($changed3 & 81) == 16 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                                $composer$iv = $composer4;
                            } else {
                                $composer4.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                Modifier modifier$iv2 = Modifier.INSTANCE;
                                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                                int $changed$iv$iv2 = (0 << 3) & SdkConfig.SDK_VERSION;
                                $composer4.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object consume5 = $composer4.consume(localDensity2);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                Density density$iv$iv2 = (Density) consume5;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object consume6 = $composer4.consume(localLayoutDirection3);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume6;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object consume7 = $composer4.consume(localViewConfiguration2);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume7;
                                Function0 factory$iv$iv$iv4 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                                if (!($composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer4.startReusableNode();
                                if ($composer4.getInserting()) {
                                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                                    $composer4.createNode(factory$iv$iv$iv2);
                                } else {
                                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                                    $composer4.useNode();
                                }
                                $composer4.disableReusing();
                                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer4);
                                $composer$iv = $composer4;
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
                                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                    int $changed4 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                    $composer4.startReplaceableGroup(32495683);
                                    ComposerKt.sourceInformation($composer4, "C411@14380L9:Drawer.kt#jmzs0o");
                                    if (($changed4 & 81) == 16 && $composer4.getSkipping()) {
                                        $composer4.skipToGroupEnd();
                                    } else {
                                        function2.invoke($composer4, Integer.valueOf((i12 >> 27) & 14));
                                    }
                                    $composer4.endReplaceableGroup();
                                }
                                $composer4.endReplaceableGroup();
                                $composer4.endReplaceableGroup();
                                $composer4.endNode();
                                $composer4.endReplaceableGroup();
                                $composer4.endReplaceableGroup();
                                boolean isOpen = drawerState6.isOpen();
                                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2
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
                                        if (z3 && drawerState6.getSwipeableState$material_release().getConfirmStateChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C03141(drawerState6, null), 3, null);
                                        }
                                    }

                                    /* compiled from: Drawer.kt */
                                    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                    @DebugMetadata(m296c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1", m297f = "Drawer.kt", m298i = {}, m299l = {421}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                    /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1 */
                                    static final class C03141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ DrawerState $drawerState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        C03141(DrawerState drawerState, Continuation<? super C03141> continuation) {
                                            super(2, continuation);
                                            this.$drawerState = drawerState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new C03141(this.$drawerState, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((C03141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object $result) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch (this.label) {
                                                case 0:
                                                    ResultKt.throwOnFailure($result);
                                                    this.label = 1;
                                                    if (this.$drawerState.close(this) != coroutine_suspended) {
                                                        break;
                                                    } else {
                                                        return coroutine_suspended;
                                                    }
                                                case 1:
                                                    ResultKt.throwOnFailure($result);
                                                    break;
                                                default:
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }
                                };
                                Object key1$iv = Float.valueOf(minValue2);
                                Object key2$iv = Float.valueOf(0.0f);
                                int i13 = (i12 & 896) | 48;
                                $composer4.startReplaceableGroup(1618982084);
                                ComposerKt.sourceInformation($composer4, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                                boolean invalid$iv$iv = $composer4.changed(key1$iv) | $composer4.changed(key2$iv) | $composer4.changed(drawerState6);
                                Object it$iv$iv = $composer4.rememberedValue();
                                if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                                    minValue = minValue2;
                                    value$iv$iv = (Function0) new Function0<Float>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$3$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Float invoke() {
                                            float calculateFraction;
                                            calculateFraction = DrawerKt.calculateFraction(minValue, maxValue, drawerState6.getOffset().getValue().floatValue());
                                            return Float.valueOf(calculateFraction);
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv$iv);
                                } else {
                                    value$iv$iv = it$iv$iv;
                                    minValue = minValue2;
                                }
                                $composer4.endReplaceableGroup();
                                Object key2$iv2 = value$iv$iv;
                                DrawerKt.m1367ScrimBx497Mc(isOpen, function0, (Function0) key2$iv2, j4, $composer4, (i12 >> 15) & 7168);
                                final String navigationMenu = Strings_androidKt.m1511getString4foXLRw(Strings.INSTANCE.m1508getNavigationMenuUdPEhr4(), $composer4, 6);
                                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object consume8 = $composer4.consume(localDensity3);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                Density $this$invoke_u24lambda_u2d4_u24lambda_u2d2 = (Density) consume8;
                                Modifier m803sizeInqDBjuR0 = SizeKt.m803sizeInqDBjuR0(Modifier.INSTANCE, $this$invoke_u24lambda_u2d4_u24lambda_u2d2.mo645toDpu2uoSUM(Constraints.m4340getMinWidthimpl(modalDrawerConstraints)), $this$invoke_u24lambda_u2d4_u24lambda_u2d2.mo645toDpu2uoSUM(Constraints.m4339getMinHeightimpl(modalDrawerConstraints)), $this$invoke_u24lambda_u2d4_u24lambda_u2d2.mo645toDpu2uoSUM(Constraints.m4338getMaxWidthimpl(modalDrawerConstraints)), $this$invoke_u24lambda_u2d4_u24lambda_u2d2.mo645toDpu2uoSUM(Constraints.m4337getMaxHeightimpl(modalDrawerConstraints)));
                                int i14 = (i12 >> 6) & 14;
                                $composer4.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation($composer4, "C(remember)P(1):Composables.kt#9igjgp");
                                boolean invalid$iv$iv2 = $composer4.changed(drawerState6);
                                Object it$iv$iv2 = $composer4.rememberedValue();
                                if (invalid$iv$iv2 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                                    value$iv$iv2 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$5$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                            return IntOffset.m4491boximpl(m1376invokeBjo55l4(density));
                                        }

                                        /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                        public final long m1376invokeBjo55l4(Density offset) {
                                            Intrinsics.checkNotNullParameter(offset, "$this$offset");
                                            return IntOffsetKt.IntOffset(MathKt.roundToInt(DrawerState.this.getOffset().getValue().floatValue()), 0);
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv$iv2);
                                } else {
                                    value$iv$iv2 = it$iv$iv2;
                                }
                                $composer4.endReplaceableGroup();
                                Modifier offset = OffsetKt.offset(m803sizeInqDBjuR0, (Function1) value$iv$iv2);
                                f4 = DrawerKt.EndDrawerPadding;
                                int i15 = i12 >> 12;
                                SurfaceKt.m1513SurfaceFjzlyU(SemanticsModifierKt.semantics$default(PaddingKt.m763paddingqDBjuR0$default(offset, 0.0f, 0.0f, f4, 0.0f, 11, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                        SemanticsPropertiesKt.setPaneTitle(semantics, navigationMenu);
                                        if (drawerState6.isOpen()) {
                                            final DrawerState drawerState7 = drawerState6;
                                            final CoroutineScope coroutineScope2 = coroutineScope;
                                            SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    if (DrawerState.this.getSwipeableState$material_release().getConfirmStateChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(DrawerState.this, null), 3, null);
                                                    }
                                                    return true;
                                                }

                                                /* compiled from: Drawer.kt */
                                                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                                @DebugMetadata(m296c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1", m297f = "Drawer.kt", m298i = {}, m299l = {450}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                                /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1, reason: invalid class name */
                                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ DrawerState $drawerState;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                                        super(2, continuation);
                                                        this.$drawerState = drawerState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new AnonymousClass1(this.$drawerState, continuation);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Object invokeSuspend(Object $result) {
                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        switch (this.label) {
                                                            case 0:
                                                                ResultKt.throwOnFailure($result);
                                                                this.label = 1;
                                                                if (this.$drawerState.close(this) != coroutine_suspended) {
                                                                    break;
                                                                } else {
                                                                    return coroutine_suspended;
                                                                }
                                                            case 1:
                                                                ResultKt.throwOnFailure($result);
                                                                break;
                                                            default:
                                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }
                                            }, 1, null);
                                        }
                                    }
                                }, 1, null), shape3, j5, j6, null, maxValue2, ComposableLambdaKt.composableLambda($composer4, -1941234439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$7
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
                                        ComposerKt.sourceInformation($composer5, "C459@16456L55:Drawer.kt#jmzs0o");
                                        if (($changed5 & 11) == 2 && $composer5.getSkipping()) {
                                            $composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1941234439, $changed5, -1, "androidx.compose.material.ModalDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:458)");
                                        }
                                        Modifier modifier$iv3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        Function3 content$iv = function3;
                                        int $changed$iv3 = ((i12 << 9) & 7168) | 6;
                                        $composer5.startReplaceableGroup(-483455358);
                                        ComposerKt.sourceInformation($composer5, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                        MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer5, (($changed$iv3 >> 3) & 14) | (($changed$iv3 >> 3) & SdkConfig.SDK_VERSION));
                                        int $changed$iv$iv3 = ($changed$iv3 << 3) & SdkConfig.SDK_VERSION;
                                        $composer5.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation($composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume9 = $composer5.consume(localDensity4);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        Density density$iv$iv3 = (Density) consume9;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume10 = $composer5.consume(localLayoutDirection4);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume10;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume11 = $composer5.consume(localViewConfiguration3);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume11;
                                        Function0 factory$iv$iv$iv5 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3 skippableUpdate$iv$iv$iv3 = LayoutKt.materializerOf(modifier$iv3);
                                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 9) & 7168) | 6;
                                        if (!($composer5.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer5.startReusableNode();
                                        if ($composer5.getInserting()) {
                                            $composer5.createNode(factory$iv$iv$iv5);
                                        } else {
                                            $composer5.useNode();
                                        }
                                        $composer5.disableReusing();
                                        Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m1639constructorimpl($composer5);
                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        $composer5.enableReusing();
                                        skippableUpdate$iv$iv$iv3.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & SdkConfig.SDK_VERSION));
                                        $composer5.startReplaceableGroup(2058660585);
                                        $composer5.startReplaceableGroup(-1163856341);
                                        ComposerKt.sourceInformation($composer5, "C79@3994L9:Column.kt#2w3rfo");
                                        if ((($changed$iv$iv$iv3 >> 9) & 14 & 11) == 2 && $composer5.getSkipping()) {
                                            $composer5.skipToGroupEnd();
                                        } else {
                                            content$iv.invoke(ColumnScopeInstance.INSTANCE, $composer5, Integer.valueOf((($changed$iv3 >> 6) & SdkConfig.SDK_VERSION) | 6));
                                        }
                                        $composer5.endReplaceableGroup();
                                        $composer5.endReplaceableGroup();
                                        $composer5.endNode();
                                        $composer5.endReplaceableGroup();
                                        $composer5.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), $composer4, ((i12 >> 9) & SdkConfig.SDK_VERSION) | 1572864 | (i15 & 896) | (i15 & 7168) | (458752 & i12), 16);
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
                        }
                    }
                }), $composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer3.skipToGroupEnd();
                modifier4 = modifier;
                drawerBackgroundColor3 = drawerBackgroundColor;
                drawerContentColor3 = drawerContentColor;
                scrimColor2 = scrimColor;
                drawerState4 = drawerState2;
                gesturesEnabled2 = z;
                drawerShape3 = shape;
                $composer2 = $composer3;
                drawerElevation2 = f;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Modifier modifier6 = modifier4;
            final DrawerState drawerState6 = drawerState4;
            final boolean z3 = gesturesEnabled2;
            final Shape shape3 = drawerShape3;
            final float f3 = drawerElevation2;
            final long j4 = drawerBackgroundColor3;
            final long j5 = drawerContentColor3;
            final long j6 = scrimColor2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$2
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

                public final void invoke(Composer composer, int i12) {
                    DrawerKt.m1366ModalDrawerGs3lGvM(drawerContent, modifier6, drawerState6, z3, shape3, f3, j4, j5, j6, content, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty2 |= i2;
        if ((1533916891 & $dirty2) == 306783378) {
        }
        $composer3.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if ((i & 4) == 0) {
        }
        if (i9 == 0) {
        }
        if ((i & 16) == 0) {
        }
        if (i10 == 0) {
        }
        if ((i & 64) == 0) {
        }
        if ((i & 128) == 0) {
        }
        if ((i & 256) == 0) {
        }
        $composer3.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        $composer3.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation($composer3, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
        $composer3.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
        it$iv$iv$iv = $composer3.rememberedValue();
        if (it$iv$iv$iv != Composer.INSTANCE.getEmpty()) {
        }
        $composer3.endReplaceableGroup();
        CompositionScopedCoroutineScopeCanceller wrapper$iv2 = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
        final CoroutineScope scope2 = wrapper$iv2.getCoroutineScope();
        $composer3.endReplaceableGroup();
        final DrawerState drawerState52 = drawerState4;
        final boolean z22 = gesturesEnabled2;
        final int i112 = $dirty;
        final long j7 = scrimColor2;
        final Shape shape22 = drawerShape3;
        final long j22 = drawerBackgroundColor3;
        modifier4 = modifier3;
        final long j32 = drawerContentColor3;
        final float f22 = drawerElevation2;
        $composer2 = $composer3;
        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda($composer2, 816674999, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
                invoke(boxWithConstraintsScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(BoxWithConstraintsScope BoxWithConstraints, Composer $composer4, int $changed2) {
                float f32;
                Modifier modifier$iv;
                Function0 factory$iv$iv$iv;
                Function0 factory$iv$iv$iv2;
                Composer $composer$iv;
                final float minValue;
                Object value$iv$iv;
                Object value$iv$iv2;
                float f4;
                Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                ComposerKt.sourceInformation($composer4, "C397@13855L7,398@13894L2641:Drawer.kt#jmzs0o");
                int $dirty3 = $changed2;
                if (($changed2 & 14) == 0) {
                    $dirty3 |= $composer4.changed(BoxWithConstraints) ? 4 : 2;
                }
                if (($dirty3 & 91) == 18 && $composer4.getSkipping()) {
                    $composer4.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(816674999, $changed2, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:386)");
                }
                long modalDrawerConstraints = BoxWithConstraints.getConstraints();
                if (!Constraints.m4334getHasBoundedWidthimpl(modalDrawerConstraints)) {
                    throw new IllegalStateException("Drawer shouldn't have infinite width");
                }
                float minValue2 = -Constraints.m4338getMaxWidthimpl(modalDrawerConstraints);
                final float maxValue = 0.0f;
                Map anchors = MapsKt.mapOf(TuplesKt.m294to(Float.valueOf(minValue2), DrawerValue.Closed), TuplesKt.m294to(Float.valueOf(0.0f), DrawerValue.Open));
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = $composer4.consume(localLayoutDirection);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                boolean isRtl = consume == LayoutDirection.Rtl;
                Modifier.Companion companion = Modifier.INSTANCE;
                SwipeableState<DrawerValue> swipeableState$material_release = DrawerState.this.getSwipeableState$material_release();
                Orientation orientation = Orientation.Horizontal;
                f32 = DrawerKt.DrawerVelocityThreshold;
                modifier$iv = SwipeableKt.m1523swipeablepPrIpRY(companion, swipeableState$material_release, anchors, orientation, (r26 & 8) != 0 ? true : z22, (r26 & 16) != 0 ? false : isRtl, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function2
                    public final FixedThreshold invoke(T t, T t2) {
                        return new FixedThreshold(C0504Dp.m4382constructorimpl(56), null);
                    }
                } : new Function2<DrawerValue, DrawerValue, ThresholdConfig>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1.1
                    @Override // kotlin.jvm.functions.Function2
                    public final ThresholdConfig invoke(DrawerValue drawerValue, DrawerValue drawerValue2) {
                        Intrinsics.checkNotNullParameter(drawerValue, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(drawerValue2, "<anonymous parameter 1>");
                        return new FractionalThreshold(0.5f);
                    }
                }, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, anchors.keySet(), 0.0f, 0.0f, 6, null) : null, (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1522getVelocityThresholdD9Ej5fM() : f32);
                final DrawerState drawerState62 = DrawerState.this;
                final int i12 = i112;
                long j42 = j7;
                Shape shape32 = shape22;
                long j52 = j22;
                long j62 = j32;
                float maxValue2 = f22;
                Function2<Composer, Integer, Unit> function2 = content;
                final boolean z32 = z22;
                final CoroutineScope coroutineScope = scope2;
                final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3 = drawerContent;
                $composer4.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                int $changed$iv$iv = (0 << 3) & SdkConfig.SDK_VERSION;
                $composer4.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume2 = $composer4.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Density density$iv$iv = (Density) consume2;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume3 = $composer4.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer4.consume(localViewConfiguration);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
                Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv3;
                    $composer4.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv3;
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
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int $changed3 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                    $composer4.startReplaceableGroup(-1263168067);
                    ComposerKt.sourceInformation($composer4, "C410@14358L45,423@14805L103,413@14416L542,428@14992L33,*430@15092L7,439@15556L55,429@15038L1487:Drawer.kt#jmzs0o");
                    if (($changed3 & 81) == 16 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        $composer$iv = $composer4;
                    } else {
                        $composer4.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        Modifier modifier$iv2 = Modifier.INSTANCE;
                        Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv2 = (0 << 3) & SdkConfig.SDK_VERSION;
                        $composer4.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume5 = $composer4.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Density density$iv$iv2 = (Density) consume5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume6 = $composer4.consume(localLayoutDirection3);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume6;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume7 = $composer4.consume(localViewConfiguration2);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume7;
                        Function0 factory$iv$iv$iv4 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv2 = factory$iv$iv$iv4;
                            $composer4.createNode(factory$iv$iv$iv2);
                        } else {
                            factory$iv$iv$iv2 = factory$iv$iv$iv4;
                            $composer4.useNode();
                        }
                        $composer4.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer4);
                        $composer$iv = $composer4;
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
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            int $changed4 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                            $composer4.startReplaceableGroup(32495683);
                            ComposerKt.sourceInformation($composer4, "C411@14380L9:Drawer.kt#jmzs0o");
                            if (($changed4 & 81) == 16 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                            } else {
                                function2.invoke($composer4, Integer.valueOf((i12 >> 27) & 14));
                            }
                            $composer4.endReplaceableGroup();
                        }
                        $composer4.endReplaceableGroup();
                        $composer4.endReplaceableGroup();
                        $composer4.endNode();
                        $composer4.endReplaceableGroup();
                        $composer4.endReplaceableGroup();
                        boolean isOpen = drawerState62.isOpen();
                        Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2
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
                                if (z32 && drawerState62.getSwipeableState$material_release().getConfirmStateChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C03141(drawerState62, null), 3, null);
                                }
                            }

                            /* compiled from: Drawer.kt */
                            @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                            @DebugMetadata(m296c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1", m297f = "Drawer.kt", m298i = {}, m299l = {421}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                            /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1 */
                            static final class C03141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C03141(DrawerState drawerState, Continuation<? super C03141> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = drawerState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C03141(this.$drawerState, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((C03141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object $result) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result);
                                            this.label = 1;
                                            if (this.$drawerState.close(this) != coroutine_suspended) {
                                                break;
                                            } else {
                                                return coroutine_suspended;
                                            }
                                        case 1:
                                            ResultKt.throwOnFailure($result);
                                            break;
                                        default:
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                        };
                        Object key1$iv = Float.valueOf(minValue2);
                        Object key2$iv = Float.valueOf(0.0f);
                        int i13 = (i12 & 896) | 48;
                        $composer4.startReplaceableGroup(1618982084);
                        ComposerKt.sourceInformation($composer4, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                        boolean invalid$iv$iv = $composer4.changed(key1$iv) | $composer4.changed(key2$iv) | $composer4.changed(drawerState62);
                        Object it$iv$iv = $composer4.rememberedValue();
                        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            minValue = minValue2;
                            value$iv$iv = (Function0) new Function0<Float>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    float calculateFraction;
                                    calculateFraction = DrawerKt.calculateFraction(minValue, maxValue, drawerState62.getOffset().getValue().floatValue());
                                    return Float.valueOf(calculateFraction);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                            minValue = minValue2;
                        }
                        $composer4.endReplaceableGroup();
                        Object key2$iv2 = value$iv$iv;
                        DrawerKt.m1367ScrimBx497Mc(isOpen, function0, (Function0) key2$iv2, j42, $composer4, (i12 >> 15) & 7168);
                        final String navigationMenu = Strings_androidKt.m1511getString4foXLRw(Strings.INSTANCE.m1508getNavigationMenuUdPEhr4(), $composer4, 6);
                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume8 = $composer4.consume(localDensity3);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Density $this$invoke_u24lambda_u2d4_u24lambda_u2d2 = (Density) consume8;
                        Modifier m803sizeInqDBjuR0 = SizeKt.m803sizeInqDBjuR0(Modifier.INSTANCE, $this$invoke_u24lambda_u2d4_u24lambda_u2d2.mo645toDpu2uoSUM(Constraints.m4340getMinWidthimpl(modalDrawerConstraints)), $this$invoke_u24lambda_u2d4_u24lambda_u2d2.mo645toDpu2uoSUM(Constraints.m4339getMinHeightimpl(modalDrawerConstraints)), $this$invoke_u24lambda_u2d4_u24lambda_u2d2.mo645toDpu2uoSUM(Constraints.m4338getMaxWidthimpl(modalDrawerConstraints)), $this$invoke_u24lambda_u2d4_u24lambda_u2d2.mo645toDpu2uoSUM(Constraints.m4337getMaxHeightimpl(modalDrawerConstraints)));
                        int i14 = (i12 >> 6) & 14;
                        $composer4.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation($composer4, "C(remember)P(1):Composables.kt#9igjgp");
                        boolean invalid$iv$iv2 = $composer4.changed(drawerState62);
                        Object it$iv$iv2 = $composer4.rememberedValue();
                        if (invalid$iv$iv2 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv2 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$5$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                    return IntOffset.m4491boximpl(m1376invokeBjo55l4(density));
                                }

                                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                public final long m1376invokeBjo55l4(Density offset) {
                                    Intrinsics.checkNotNullParameter(offset, "$this$offset");
                                    return IntOffsetKt.IntOffset(MathKt.roundToInt(DrawerState.this.getOffset().getValue().floatValue()), 0);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv$iv2);
                        } else {
                            value$iv$iv2 = it$iv$iv2;
                        }
                        $composer4.endReplaceableGroup();
                        Modifier offset = OffsetKt.offset(m803sizeInqDBjuR0, (Function1) value$iv$iv2);
                        f4 = DrawerKt.EndDrawerPadding;
                        int i15 = i12 >> 12;
                        SurfaceKt.m1513SurfaceFjzlyU(SemanticsModifierKt.semantics$default(PaddingKt.m763paddingqDBjuR0$default(offset, 0.0f, 0.0f, f4, 0.0f, 11, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                SemanticsPropertiesKt.setPaneTitle(semantics, navigationMenu);
                                if (drawerState62.isOpen()) {
                                    final DrawerState drawerState7 = drawerState62;
                                    final CoroutineScope coroutineScope2 = coroutineScope;
                                    SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            if (DrawerState.this.getSwipeableState$material_release().getConfirmStateChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(DrawerState.this, null), 3, null);
                                            }
                                            return true;
                                        }

                                        /* compiled from: Drawer.kt */
                                        @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                        @DebugMetadata(m296c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1", m297f = "Drawer.kt", m298i = {}, m299l = {450}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                        /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1, reason: invalid class name */
                                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ DrawerState $drawerState;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                                super(2, continuation);
                                                this.$drawerState = drawerState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                return new AnonymousClass1(this.$drawerState, continuation);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Object invokeSuspend(Object $result) {
                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                switch (this.label) {
                                                    case 0:
                                                        ResultKt.throwOnFailure($result);
                                                        this.label = 1;
                                                        if (this.$drawerState.close(this) != coroutine_suspended) {
                                                            break;
                                                        } else {
                                                            return coroutine_suspended;
                                                        }
                                                    case 1:
                                                        ResultKt.throwOnFailure($result);
                                                        break;
                                                    default:
                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }
                                    }, 1, null);
                                }
                            }
                        }, 1, null), shape32, j52, j62, null, maxValue2, ComposableLambdaKt.composableLambda($composer4, -1941234439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$7
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
                                ComposerKt.sourceInformation($composer5, "C459@16456L55:Drawer.kt#jmzs0o");
                                if (($changed5 & 11) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1941234439, $changed5, -1, "androidx.compose.material.ModalDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:458)");
                                }
                                Modifier modifier$iv3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                Function3 content$iv = function3;
                                int $changed$iv3 = ((i12 << 9) & 7168) | 6;
                                $composer5.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation($composer5, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer5, (($changed$iv3 >> 3) & 14) | (($changed$iv3 >> 3) & SdkConfig.SDK_VERSION));
                                int $changed$iv$iv3 = ($changed$iv3 << 3) & SdkConfig.SDK_VERSION;
                                $composer5.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation($composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object consume9 = $composer5.consume(localDensity4);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                Density density$iv$iv3 = (Density) consume9;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object consume10 = $composer5.consume(localLayoutDirection4);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume10;
                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                Object consume11 = $composer5.consume(localViewConfiguration3);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume11;
                                Function0 factory$iv$iv$iv5 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3 skippableUpdate$iv$iv$iv3 = LayoutKt.materializerOf(modifier$iv3);
                                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 9) & 7168) | 6;
                                if (!($composer5.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer5.startReusableNode();
                                if ($composer5.getInserting()) {
                                    $composer5.createNode(factory$iv$iv$iv5);
                                } else {
                                    $composer5.useNode();
                                }
                                $composer5.disableReusing();
                                Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m1639constructorimpl($composer5);
                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.INSTANCE.getSetDensity());
                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                $composer5.enableReusing();
                                skippableUpdate$iv$iv$iv3.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & SdkConfig.SDK_VERSION));
                                $composer5.startReplaceableGroup(2058660585);
                                $composer5.startReplaceableGroup(-1163856341);
                                ComposerKt.sourceInformation($composer5, "C79@3994L9:Column.kt#2w3rfo");
                                if ((($changed$iv$iv$iv3 >> 9) & 14 & 11) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                } else {
                                    content$iv.invoke(ColumnScopeInstance.INSTANCE, $composer5, Integer.valueOf((($changed$iv3 >> 6) & SdkConfig.SDK_VERSION) | 6));
                                }
                                $composer5.endReplaceableGroup();
                                $composer5.endReplaceableGroup();
                                $composer5.endNode();
                                $composer5.endReplaceableGroup();
                                $composer5.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), $composer4, ((i12 >> 9) & SdkConfig.SDK_VERSION) | 1572864 | (i15 & 896) | (i15 & 7168) | (458752 & i12), 16);
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
                }
            }
        }), $composer2, 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02be  */
    @ExperimentalMaterialApi
    /* renamed from: BottomDrawer-Gs3lGvM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1363BottomDrawerGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> drawerContent, Modifier modifier, BottomDrawerState drawerState, boolean gesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long scrimColor, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        BottomDrawerState bottomDrawerState;
        boolean z;
        Shape shape;
        float f;
        Modifier modifier2;
        BottomDrawerState drawerState2;
        CornerBasedShape drawerShape2;
        long drawerBackgroundColor2;
        long drawerContentColor2;
        long scrimColor2;
        int $dirty;
        Shape drawerShape3;
        float drawerElevation2;
        long drawerBackgroundColor3;
        long drawerContentColor3;
        Modifier modifier3;
        BottomDrawerState drawerState3;
        boolean gesturesEnabled2;
        Object it$iv$iv$iv;
        Object value$iv$iv$iv;
        Modifier modifier4;
        Composer $composer2;
        ScopeUpdateScope endRestartGroup;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(drawerContent, "drawerContent");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(625649286);
        ComposerKt.sourceInformation($composer3, "C(BottomDrawer)P(2,8,6,7,5,4:c#ui.unit.Dp,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9:c#ui.graphics.Color)499@18420L51,501@18549L6,503@18664L6,504@18712L38,505@18791L10,508@18859L24,510@18889L3335:Drawer.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(drawerContent) ? 4 : 2;
        }
        int i8 = i & 2;
        if (i8 != 0) {
            $dirty2 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                bottomDrawerState = drawerState;
                if ($composer3.changed(bottomDrawerState)) {
                    i7 = 256;
                    $dirty2 |= i7;
                }
            } else {
                bottomDrawerState = drawerState;
            }
            i7 = 128;
            $dirty2 |= i7;
        } else {
            bottomDrawerState = drawerState;
        }
        int i9 = i & 8;
        if (i9 != 0) {
            $dirty2 |= 3072;
            z = gesturesEnabled;
        } else if (($changed & 7168) == 0) {
            z = gesturesEnabled;
            $dirty2 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = gesturesEnabled;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                shape = drawerShape;
                if ($composer3.changed(shape)) {
                    i6 = 16384;
                    $dirty2 |= i6;
                }
            } else {
                shape = drawerShape;
            }
            i6 = 8192;
            $dirty2 |= i6;
        } else {
            shape = drawerShape;
        }
        int i10 = i & 32;
        if (i10 != 0) {
            $dirty2 |= 196608;
            f = drawerElevation;
        } else if ((458752 & $changed) == 0) {
            f = drawerElevation;
            $dirty2 |= $composer3.changed(f) ? 131072 : 65536;
        } else {
            f = drawerElevation;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0 && $composer3.changed(drawerBackgroundColor)) {
                i5 = 1048576;
                $dirty2 |= i5;
            }
            i5 = 524288;
            $dirty2 |= i5;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0 && $composer3.changed(drawerContentColor)) {
                i4 = 8388608;
                $dirty2 |= i4;
            }
            i4 = 4194304;
            $dirty2 |= i4;
        }
        if ((234881024 & $changed) == 0) {
            if ((i & 256) == 0 && $composer3.changed(scrimColor)) {
                i3 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty2 |= i3;
            }
            i3 = 33554432;
            $dirty2 |= i3;
        }
        if ((i & 512) == 0) {
            i2 = (1879048192 & $changed) == 0 ? $composer3.changed(content) ? 536870912 : 268435456 : 805306368;
            if ((1533916891 & $dirty2) == 306783378 || !$composer3.getSkipping()) {
                $composer3.startDefaults();
                if (($changed & 1) != 0 || $composer3.getDefaultsInvalid()) {
                    Modifier.Companion modifier5 = i8 == 0 ? Modifier.INSTANCE : modifier;
                    if ((i & 4) == 0) {
                        modifier2 = modifier5;
                        drawerState2 = rememberBottomDrawerState(BottomDrawerValue.Closed, null, $composer3, 6, 2);
                        $dirty2 &= -897;
                    } else {
                        modifier2 = modifier5;
                        drawerState2 = bottomDrawerState;
                    }
                    boolean gesturesEnabled3 = i9 == 0 ? true : z;
                    if ((i & 16) == 0) {
                        drawerShape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getLarge();
                        $dirty2 &= -57345;
                    } else {
                        drawerShape2 = shape;
                    }
                    float drawerElevation3 = i10 == 0 ? DrawerDefaults.INSTANCE.m1362getElevationD9Ej5fM() : f;
                    if ((i & 64) == 0) {
                        drawerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1321getSurface0d7_KjU();
                        $dirty2 &= -3670017;
                    } else {
                        drawerBackgroundColor2 = drawerBackgroundColor;
                    }
                    if ((i & 128) == 0) {
                        drawerContentColor2 = ColorsKt.m1335contentColorForek8zF_U(drawerBackgroundColor2, $composer3, ($dirty2 >> 18) & 14);
                        $dirty2 &= -29360129;
                    } else {
                        drawerContentColor2 = drawerContentColor;
                    }
                    if ((i & 256) == 0) {
                        $dirty = $dirty2 & (-234881025);
                        drawerShape3 = drawerShape2;
                        drawerContentColor3 = drawerContentColor2;
                        scrimColor2 = DrawerDefaults.INSTANCE.getScrimColor($composer3, 6);
                        drawerState3 = drawerState2;
                        gesturesEnabled2 = gesturesEnabled3;
                        drawerElevation2 = drawerElevation3;
                        drawerBackgroundColor3 = drawerBackgroundColor2;
                        modifier3 = modifier2;
                    } else {
                        scrimColor2 = scrimColor;
                        $dirty = $dirty2;
                        drawerShape3 = drawerShape2;
                        drawerElevation2 = drawerElevation3;
                        drawerBackgroundColor3 = drawerBackgroundColor2;
                        drawerContentColor3 = drawerContentColor2;
                        modifier3 = modifier2;
                        drawerState3 = drawerState2;
                        gesturesEnabled2 = gesturesEnabled3;
                    }
                } else {
                    $composer3.skipToGroupEnd();
                    if ((i & 4) != 0) {
                        $dirty2 &= -897;
                    }
                    if ((i & 16) != 0) {
                        $dirty2 &= -57345;
                    }
                    if ((i & 64) != 0) {
                        $dirty2 &= -3670017;
                    }
                    if ((i & 128) != 0) {
                        $dirty2 &= -29360129;
                    }
                    if ((i & 256) != 0) {
                        drawerBackgroundColor3 = drawerBackgroundColor;
                        drawerContentColor3 = drawerContentColor;
                        scrimColor2 = scrimColor;
                        $dirty = (-234881025) & $dirty2;
                        drawerState3 = bottomDrawerState;
                        gesturesEnabled2 = z;
                        drawerShape3 = shape;
                        drawerElevation2 = f;
                        modifier3 = modifier;
                    } else {
                        drawerBackgroundColor3 = drawerBackgroundColor;
                        drawerContentColor3 = drawerContentColor;
                        scrimColor2 = scrimColor;
                        $dirty = $dirty2;
                        drawerState3 = bottomDrawerState;
                        gesturesEnabled2 = z;
                        drawerShape3 = shape;
                        drawerElevation2 = f;
                        modifier3 = modifier;
                    }
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(625649286, $dirty, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:496)");
                }
                $composer3.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation($composer3, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                $composer3.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                it$iv$iv$iv = $composer3.rememberedValue();
                if (it$iv$iv$iv != Composer.INSTANCE.getEmpty()) {
                    value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                    $composer3.updateRememberedValue(value$iv$iv$iv);
                } else {
                    value$iv$iv$iv = it$iv$iv$iv;
                }
                $composer3.endReplaceableGroup();
                CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                CoroutineScope scope = wrapper$iv.getCoroutineScope();
                $composer3.endReplaceableGroup();
                modifier4 = modifier3;
                $composer2 = $composer3;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda($composer2, 1220102512, true, new DrawerKt$BottomDrawer$1(gesturesEnabled2, drawerState3, content, $dirty, scrimColor2, drawerShape3, drawerBackgroundColor3, drawerContentColor3, drawerElevation2, scope, drawerContent)), $composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer3.skipToGroupEnd();
                modifier4 = modifier;
                drawerBackgroundColor3 = drawerBackgroundColor;
                drawerContentColor3 = drawerContentColor;
                scrimColor2 = scrimColor;
                drawerState3 = bottomDrawerState;
                gesturesEnabled2 = z;
                drawerShape3 = shape;
                $composer2 = $composer3;
                drawerElevation2 = f;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Modifier modifier6 = modifier4;
            final BottomDrawerState bottomDrawerState2 = drawerState3;
            final boolean z2 = gesturesEnabled2;
            final Shape shape2 = drawerShape3;
            final float f2 = drawerElevation2;
            final long j = drawerBackgroundColor3;
            final long j2 = drawerContentColor3;
            final long j3 = scrimColor2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2
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
                    DrawerKt.m1363BottomDrawerGs3lGvM(drawerContent, modifier6, bottomDrawerState2, z2, shape2, f2, j, j2, j3, content, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty2 |= i2;
        if ((1533916891 & $dirty2) == 306783378) {
        }
        $composer3.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if ((i & 4) == 0) {
        }
        if (i9 == 0) {
        }
        if ((i & 16) == 0) {
        }
        if (i10 == 0) {
        }
        if ((i & 64) == 0) {
        }
        if ((i & 128) == 0) {
        }
        if ((i & 256) == 0) {
        }
        $composer3.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        $composer3.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation($composer3, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
        $composer3.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
        it$iv$iv$iv = $composer3.rememberedValue();
        if (it$iv$iv$iv != Composer.INSTANCE.getEmpty()) {
        }
        $composer3.endReplaceableGroup();
        CompositionScopedCoroutineScopeCanceller wrapper$iv2 = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
        CoroutineScope scope2 = wrapper$iv2.getCoroutineScope();
        $composer3.endReplaceableGroup();
        modifier4 = modifier3;
        $composer2 = $composer3;
        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda($composer2, 1220102512, true, new DrawerKt$BottomDrawer$1(gesturesEnabled2, drawerState3, content, $dirty, scrimColor2, drawerShape3, drawerBackgroundColor3, drawerContentColor3, drawerElevation2, scope2, drawerContent)), $composer2, 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateFraction(float a, float b, float pos) {
        return RangesKt.coerceIn((pos - a) / (b - a), 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomDrawerScrim-3J-VO9M, reason: not valid java name */
    public static final void m1364BottomDrawerScrim3JVO9M(final long color, final Function0<Unit> function0, final boolean visible, Composer $composer, final int $changed) {
        Modifier.Companion dismissModifier;
        DrawerKt$BottomDrawerScrim$dismissModifier$1$1 value$iv$iv;
        Object value$iv$iv2;
        Composer $composer2 = $composer.startRestartGroup(-513067266);
        ComposerKt.sourceInformation($composer2, "C(BottomDrawerScrim)P(0:c#ui.graphics.Color)625@22930L121,629@23078L30,647@23631L62,643@23522L171:Drawer.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(color) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(function0) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(visible) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-513067266, $dirty2, -1, "androidx.compose.material.BottomDrawerScrim (Drawer.kt:619)");
            }
            if (color != Color.INSTANCE.m2032getUnspecified0d7_KjU()) {
                final State alpha$delegate = AnimateAsStateKt.animateFloatAsState(visible ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, $composer2, 0, 12);
                final String closeDrawer = Strings_androidKt.m1511getString4foXLRw(Strings.INSTANCE.m1504getCloseDrawerUdPEhr4(), $composer2, 6);
                $composer2.startReplaceableGroup(-1298949409);
                ComposerKt.sourceInformation($composer2, "632@23216L73,635@23342L122");
                if (visible) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    int i = (($dirty2 >> 3) & 14) | 64;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer2.changed(function0);
                    Object it$iv$iv = $composer2.rememberedValue();
                    if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = new DrawerKt$BottomDrawerScrim$dismissModifier$1$1(function0, null);
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv);
                    int i2 = $dirty2 & SdkConfig.SDK_VERSION;
                    $composer2.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
                    boolean invalid$iv$iv2 = $composer2.changed(closeDrawer) | $composer2.changed(function0);
                    Object it$iv$iv2 = $composer2.rememberedValue();
                    if (!invalid$iv$iv2 && it$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                        value$iv$iv2 = it$iv$iv2;
                        $composer2.endReplaceableGroup();
                        dismissModifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) value$iv$iv2);
                    }
                    value$iv$iv2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$dismissModifier$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            SemanticsPropertiesKt.setContentDescription(semantics, closeDrawer);
                            final Function0<Unit> function02 = function0;
                            SemanticsPropertiesKt.onClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$dismissModifier$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    function02.invoke();
                                    return true;
                                }
                            }, 1, null);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv$iv2);
                    $composer2.endReplaceableGroup();
                    dismissModifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) value$iv$iv2);
                } else {
                    dismissModifier = Modifier.INSTANCE;
                }
                $composer2.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(dismissModifier);
                Object key1$iv = Color.m1986boximpl(color);
                int i3 = $dirty2 & 14;
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv3 = $composer2.changed(key1$iv) | $composer2.changed(alpha$delegate);
                Object value$iv$iv3 = $composer2.rememberedValue();
                if (!invalid$iv$iv3) {
                    Object key1$iv2 = Composer.INSTANCE.getEmpty();
                    if (value$iv$iv3 != key1$iv2) {
                        $composer2.endReplaceableGroup();
                        CanvasKt.Canvas(then, (Function1) value$iv$iv3, $composer2, 0);
                    }
                }
                value$iv$iv3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope Canvas) {
                        float m1365BottomDrawerScrim_3J_VO9M$lambda2;
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        long j = color;
                        m1365BottomDrawerScrim_3J_VO9M$lambda2 = DrawerKt.m1365BottomDrawerScrim_3J_VO9M$lambda2(alpha$delegate);
                        DrawScope.m2485drawRectnJ9OG0$default(Canvas, j, 0L, 0L, m1365BottomDrawerScrim_3J_VO9M$lambda2, null, null, 0, 118, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv3);
                $composer2.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) value$iv$iv3, $composer2, 0);
            }
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i4) {
                DrawerKt.m1364BottomDrawerScrim3JVO9M(color, function0, visible, composer, $changed | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomDrawerScrim_3J_VO9M$lambda-2, reason: not valid java name */
    public static final float m1365BottomDrawerScrim_3J_VO9M$lambda2(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a5  */
    /* renamed from: Scrim-Bx497Mc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1367ScrimBx497Mc(final boolean open, final Function0<Unit> function0, final Function0<Float> function02, final long color, Composer $composer, final int $changed) {
        Modifier.Companion dismissDrawer;
        Composer $composer2 = $composer.startRestartGroup(1983403750);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(3,2,1,0:c#ui.graphics.Color)660@23848L30,676@24292L51,672@24201L142:Drawer.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(open) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(function0) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(function02) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(color) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1983403750, $dirty2, -1, "androidx.compose.material.Scrim (Drawer.kt:654)");
            }
            final String closeDrawer = Strings_androidKt.m1511getString4foXLRw(Strings.INSTANCE.m1504getCloseDrawerUdPEhr4(), $composer2, 6);
            $composer2.startReplaceableGroup(1010554047);
            ComposerKt.sourceInformation($composer2, "663@23967L35,664@24051L108");
            if (open) {
                Modifier.Companion companion = Modifier.INSTANCE;
                int i = (($dirty2 >> 3) & 14) | 64;
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer2.changed(function0);
                DrawerKt$Scrim$dismissDrawer$1$1 value$iv$iv = $composer2.rememberedValue();
                if (invalid$iv$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = new DrawerKt$Scrim$dismissDrawer$1$1(function0, null);
                    $composer2.updateRememberedValue(value$iv$iv);
                }
                $composer2.endReplaceableGroup();
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv);
                int i2 = $dirty2 & SdkConfig.SDK_VERSION;
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv2 = $composer2.changed(closeDrawer) | $composer2.changed(function0);
                Object value$iv$iv2 = $composer2.rememberedValue();
                if (!invalid$iv$iv2 && value$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                    $composer2.endReplaceableGroup();
                    dismissDrawer = SemanticsModifierKt.semantics(pointerInput, true, (Function1) value$iv$iv2);
                }
                value$iv$iv2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        SemanticsPropertiesKt.setContentDescription(semantics, closeDrawer);
                        final Function0<Unit> function03 = function0;
                        SemanticsPropertiesKt.onClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                function03.invoke();
                                return true;
                            }
                        }, 1, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv2);
                $composer2.endReplaceableGroup();
                dismissDrawer = SemanticsModifierKt.semantics(pointerInput, true, (Function1) value$iv$iv2);
            } else {
                dismissDrawer = Modifier.INSTANCE;
            }
            $composer2.endReplaceableGroup();
            Modifier then = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(dismissDrawer);
            Object key1$iv = Color.m1986boximpl(color);
            int i3 = (($dirty2 >> 9) & 14) | (($dirty2 >> 3) & SdkConfig.SDK_VERSION);
            $composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv3 = $composer2.changed(key1$iv) | $composer2.changed(function02);
            Object value$iv$iv3 = $composer2.rememberedValue();
            if (!invalid$iv$iv3 && value$iv$iv3 != Composer.INSTANCE.getEmpty()) {
                $composer2.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) value$iv$iv3, $composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            value$iv$iv3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope Canvas) {
                    Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                    DrawScope.m2485drawRectnJ9OG0$default(Canvas, color, 0L, 0L, function02.invoke().floatValue(), null, null, 0, 118, null);
                }
            };
            $composer2.updateRememberedValue(value$iv$iv3);
            $composer2.endReplaceableGroup();
            CanvasKt.Canvas(then, (Function1) value$iv$iv3, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i4) {
                DrawerKt.m1367ScrimBx497Mc(open, function0, function02, color, composer, $changed | 1);
            }
        });
    }
}
