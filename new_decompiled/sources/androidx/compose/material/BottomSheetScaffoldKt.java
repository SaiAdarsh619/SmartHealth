package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.Density;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BottomSheetScaffold.kt */
@Metadata(m286d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aá\u0002\u0010\u0003\u001a\u00020\u00042\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f¢\u0006\u0002\b\b2\u0019\b\u0002\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\b2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f¢\u0006\u0002\b\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u00012 \b\u0002\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0002\b\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u001f\u001a\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u00012\b\b\u0002\u0010\"\u001a\u00020\u001b2\b\b\u0002\u0010#\u001a\u00020\u001b2\b\b\u0002\u0010$\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020\u001b2\b\b\u0002\u0010&\u001a\u00020\u001b2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aw\u0010+\u001a\u00020\u00042\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\b2\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\b2\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\b2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\b2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u0010\u0013\u001a\u00020\u0014H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a+\u00103\u001a\u00020\r2\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u00020\u0011H\u0007¢\u0006\u0002\u00109\u001a;\u0010:\u001a\u0002072\u0006\u0010;\u001a\u00020<2\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u0002000>2\u0014\b\u0002\u0010?\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00160\u0006H\u0007¢\u0006\u0002\u0010@\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006A"}, m287d2 = {"FabEndSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/BottomSheetScaffoldState;", "topBar", "Lkotlin/Function0;", "snackbarHost", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "sheetGesturesEnabled", "", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetPeekHeight", "drawerContent", "drawerGesturesEnabled", "drawerShape", "drawerElevation", "drawerBackgroundColor", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-bGncdBI", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;IIII)V", "BottomSheetScaffoldStack", "body", "bottomSheet", "bottomSheetOffset", "Landroidx/compose/runtime/State;", "", "BottomSheetScaffoldStack-SlNgfk0", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/State;ILandroidx/compose/runtime/Composer;I)V", "rememberBottomSheetScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "bottomSheetState", "Landroidx/compose/material/BottomSheetState;", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "rememberBottomSheetState", "initialValue", "Landroidx/compose/material/BottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetState;", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class BottomSheetScaffoldKt {
    private static final float FabEndSpacing = C0504Dp.m4382constructorimpl(16);

    @ExperimentalMaterialApi
    public static final BottomSheetState rememberBottomSheetState(final BottomSheetValue initialValue, final AnimationSpec<Float> animationSpec, final Function1<? super BottomSheetValue, Boolean> function1, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(1808153344);
        ComposerKt.sourceInformation($composer, "C(rememberBottomSheetState)P(2)156@5647L371:BottomSheetScaffold.kt#jmzs0o");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
            animationSpec = animationSpec2;
        }
        if ((i & 4) != 0) {
            Function1 confirmStateChange = new Function1<BottomSheetValue, Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$rememberBottomSheetState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomSheetValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1808153344, $changed, -1, "androidx.compose.material.rememberBottomSheetState (BottomSheetScaffold.kt:151)");
        }
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.m1652rememberSaveable(new Object[]{animationSpec}, (Saver) BottomSheetState.INSTANCE.Saver(animationSpec, function1), (String) null, (Function0) new Function0<BottomSheetState>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$rememberBottomSheetState$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BottomSheetState invoke() {
                return new BottomSheetState(BottomSheetValue.this, animationSpec, function1);
            }
        }, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return bottomSheetState;
    }

    @ExperimentalMaterialApi
    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(DrawerState drawerState, BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Object value$iv$iv2;
        $composer.startReplaceableGroup(-1353009744);
        ComposerKt.sourceInformation($composer, "C(rememberBottomSheetScaffoldState)P(1)196@6892L39,197@6974L52,198@7071L32,200@7145L248:BottomSheetScaffold.kt#jmzs0o");
        if ((i & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, $composer, 6, 2);
        }
        if ((i & 2) != 0) {
            bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed, null, null, $composer, 6, 6);
        }
        if ((i & 4) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = new SnackbarHostState();
                $composer.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) value$iv$iv2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1353009744, $changed, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:195)");
        }
        int i2 = ($changed & 14) | ($changed & SdkConfig.SDK_VERSION) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(drawerState) | $composer.changed(bottomSheetState) | $composer.changed(snackbarHostState);
        Object it$iv$iv2 = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new BottomSheetScaffoldState(drawerState, bottomSheetState, snackbarHostState);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    @ExperimentalMaterialApi
    /* renamed from: BottomSheetScaffold-bGncdBI, reason: not valid java name */
    public static final void m1260BottomSheetScaffoldbGncdBI(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> sheetContent, Modifier modifier, BottomSheetScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, int floatingActionButtonPosition, boolean sheetGesturesEnabled, Shape sheetShape, float sheetElevation, long sheetBackgroundColor, long sheetContentColor, float sheetPeekHeight, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, boolean drawerGesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long drawerScrimColor, long backgroundColor, long contentColor, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        Modifier modifier2;
        Function3 function33;
        int i2;
        int i3;
        int i4;
        int i5;
        long j;
        int $dirty2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        BottomSheetScaffoldState scaffoldState2;
        CornerBasedShape sheetShape2;
        int $dirty;
        long sheetBackgroundColor2;
        long sheetContentColor2;
        long sheetBackgroundColor3;
        CornerBasedShape drawerShape2;
        Shape drawerShape3;
        float drawerElevation2;
        long drawerBackgroundColor2;
        float sheetPeekHeight2;
        long drawerContentColor2;
        long drawerBackgroundColor3;
        int i11;
        long drawerScrimColor2;
        long drawerScrimColor3;
        long backgroundColor2;
        int $dirty22;
        BottomSheetScaffoldState scaffoldState3;
        Function3 snackbarHost;
        Shape drawerShape4;
        float drawerElevation3;
        float sheetPeekHeight3;
        long drawerScrimColor4;
        long contentColor2;
        Function2 topBar;
        long backgroundColor3;
        int $dirty23;
        Function2 floatingActionButton;
        int floatingActionButtonPosition2;
        boolean sheetGesturesEnabled2;
        Shape sheetShape3;
        Modifier modifier3;
        float sheetElevation2;
        long sheetContentColor3;
        Function3 drawerContent;
        boolean drawerGesturesEnabled2;
        long drawerContentColor3;
        int $dirty1;
        long drawerBackgroundColor4;
        long sheetBackgroundColor4;
        int $dirty3;
        Composer $composer2;
        long contentColor3;
        long backgroundColor4;
        long drawerScrimColor5;
        long drawerContentColor4;
        long drawerBackgroundColor5;
        float drawerElevation4;
        Shape drawerShape5;
        boolean drawerGesturesEnabled3;
        Function3 drawerContent2;
        float sheetPeekHeight4;
        long sheetContentColor4;
        long sheetBackgroundColor5;
        float sheetElevation3;
        Shape sheetShape4;
        boolean sheetGesturesEnabled3;
        int floatingActionButtonPosition3;
        Function2 floatingActionButton2;
        Function3 snackbarHost2;
        Function2 topBar2;
        BottomSheetScaffoldState scaffoldState4;
        Modifier modifier4;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        Intrinsics.checkNotNullParameter(sheetContent, "sheetContent");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(46422755);
        ComposerKt.sourceInformation($composer3, "C(BottomSheetScaffold)P(15,12,13,22,21,10,11:c#material.FabPosition,18,20,17:c#ui.unit.Dp,14:c#ui.graphics.Color,16:c#ui.graphics.Color,19:c#ui.unit.Dp,4,7,9,6:c#ui.unit.Dp,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,0:c#ui.graphics.Color,2:c#ui.graphics.Color)261@10736L34,267@11105L6,269@11236L6,270@11283L37,274@11540L6,276@11655L6,277@11703L38,278@11788L10,279@11843L6,280@11888L32,283@11991L24,284@12020L3903:BottomSheetScaffold.kt#jmzs0o");
        int $dirty4 = $changed;
        int $dirty12 = $changed1;
        int $dirty24 = $changed2;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer3.changed(sheetContent) ? 4 : 2;
        }
        int i22 = i & 2;
        if (i22 != 0) {
            $dirty4 |= 48;
            modifier2 = modifier;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0 && $composer3.changed(scaffoldState)) {
                i21 = 256;
                $dirty4 |= i21;
            }
            i21 = 128;
            $dirty4 |= i21;
        }
        int i23 = i & 8;
        if (i23 != 0) {
            $dirty4 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty4 |= $composer3.changed(function2) ? 2048 : 1024;
        }
        int i24 = i & 16;
        if (i24 != 0) {
            $dirty4 |= 24576;
            function33 = function3;
        } else if (($changed & 57344) == 0) {
            function33 = function3;
            $dirty4 |= $composer3.changed(function33) ? 16384 : 8192;
        } else {
            function33 = function3;
        }
        int i25 = i & 32;
        if (i25 != 0) {
            $dirty4 |= 196608;
        } else if (($changed & 458752) == 0) {
            $dirty4 |= $composer3.changed(function22) ? 131072 : 65536;
        }
        int i26 = i & 64;
        if (i26 != 0) {
            $dirty4 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty4 |= $composer3.changed(floatingActionButtonPosition) ? 1048576 : 524288;
        }
        int i27 = i & 128;
        if (i27 != 0) {
            $dirty4 |= 12582912;
            i2 = i27;
        } else if (($changed & 29360128) == 0) {
            i2 = i27;
            $dirty4 |= $composer3.changed(sheetGesturesEnabled) ? 8388608 : 4194304;
        } else {
            i2 = i27;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0 && $composer3.changed(sheetShape)) {
                i20 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty4 |= i20;
            }
            i20 = 33554432;
            $dirty4 |= i20;
        }
        int i28 = i & 512;
        if (i28 != 0) {
            $dirty4 |= 805306368;
            i3 = i28;
        } else if (($changed & 1879048192) == 0) {
            i3 = i28;
            $dirty4 |= $composer3.changed(sheetElevation) ? 536870912 : 268435456;
        } else {
            i3 = i28;
        }
        if (($changed1 & 14) == 0) {
            if ((i & 1024) == 0 && $composer3.changed(sheetBackgroundColor)) {
                i19 = 4;
                $dirty12 |= i19;
            }
            i19 = 2;
            $dirty12 |= i19;
        }
        if (($changed1 & SdkConfig.SDK_VERSION) == 0) {
            if ((i & 2048) == 0 && $composer3.changed(sheetContentColor)) {
                i18 = 32;
                $dirty12 |= i18;
            }
            i18 = 16;
            $dirty12 |= i18;
        }
        int i29 = i & 4096;
        if (i29 != 0) {
            $dirty12 |= 384;
            i4 = i29;
        } else {
            i4 = i29;
            if (($changed1 & 896) == 0) {
                $dirty12 |= $composer3.changed(sheetPeekHeight) ? 256 : 128;
            }
        }
        int i30 = i & 8192;
        if (i30 != 0) {
            $dirty12 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty12 |= $composer3.changed(function32) ? 2048 : 1024;
        }
        int i31 = i & 16384;
        if (i31 != 0) {
            $dirty12 |= 24576;
            i5 = i31;
        } else if (($changed1 & 57344) == 0) {
            i5 = i31;
            $dirty12 |= $composer3.changed(drawerGesturesEnabled) ? 16384 : 8192;
        } else {
            i5 = i31;
        }
        if (($changed1 & 458752) == 0) {
            if ((i & 32768) == 0 && $composer3.changed(drawerShape)) {
                i17 = 131072;
                $dirty12 |= i17;
            }
            i17 = 65536;
            $dirty12 |= i17;
        }
        int i32 = i & 65536;
        if (i32 != 0) {
            $dirty12 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty12 |= $composer3.changed(drawerElevation) ? 1048576 : 524288;
        }
        if (($changed1 & 29360128) == 0) {
            if ((i & 131072) == 0 && $composer3.changed(drawerBackgroundColor)) {
                i16 = 8388608;
                $dirty12 |= i16;
            }
            i16 = 4194304;
            $dirty12 |= i16;
        }
        if (($changed1 & 234881024) == 0) {
            if ((i & 262144) == 0 && $composer3.changed(drawerContentColor)) {
                i15 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty12 |= i15;
            }
            i15 = 33554432;
            $dirty12 |= i15;
        }
        if (($changed1 & 1879048192) == 0) {
            if ((i & 524288) == 0 && $composer3.changed(drawerScrimColor)) {
                i14 = 536870912;
                $dirty12 |= i14;
            }
            i14 = 268435456;
            $dirty12 |= i14;
        }
        int $dirty13 = $dirty12;
        if (($changed2 & 14) == 0) {
            if ((i & 1048576) == 0 && $composer3.changed(backgroundColor)) {
                i13 = 4;
                $dirty24 |= i13;
            }
            i13 = 2;
            $dirty24 |= i13;
        }
        if (($changed2 & SdkConfig.SDK_VERSION) == 0) {
            if ((2097152 & i) == 0) {
                j = contentColor;
                if ($composer3.changed(j)) {
                    i12 = 32;
                    $dirty24 |= i12;
                }
            } else {
                j = contentColor;
            }
            i12 = 16;
            $dirty24 |= i12;
        } else {
            j = contentColor;
        }
        if ((4194304 & i) != 0) {
            $dirty24 |= 384;
        } else if (($changed2 & 896) == 0) {
            $dirty24 |= $composer3.changed(content) ? 256 : 128;
        }
        if ((1533916891 & $dirty4) == 306783378 && ($dirty13 & 1533916891) == 306783378 && ($dirty24 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            scaffoldState4 = scaffoldState;
            topBar2 = function2;
            floatingActionButton2 = function22;
            floatingActionButtonPosition3 = floatingActionButtonPosition;
            sheetGesturesEnabled3 = sheetGesturesEnabled;
            sheetShape4 = sheetShape;
            sheetElevation3 = sheetElevation;
            sheetBackgroundColor5 = sheetBackgroundColor;
            sheetContentColor4 = sheetContentColor;
            sheetPeekHeight4 = sheetPeekHeight;
            drawerContent2 = function32;
            drawerGesturesEnabled3 = drawerGesturesEnabled;
            drawerShape5 = drawerShape;
            drawerElevation4 = drawerElevation;
            drawerBackgroundColor5 = drawerBackgroundColor;
            drawerContentColor4 = drawerContentColor;
            drawerScrimColor5 = drawerScrimColor;
            backgroundColor4 = backgroundColor;
            contentColor3 = j;
            $composer2 = $composer3;
            snackbarHost2 = function33;
            modifier4 = modifier2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i22 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    $dirty2 = $dirty24;
                    i7 = i4;
                    i6 = i2;
                    i8 = i5;
                    i9 = i30;
                    i10 = i3;
                    scaffoldState2 = rememberBottomSheetScaffoldState(null, null, null, $composer3, 0, 7);
                    $dirty4 &= -897;
                } else {
                    $dirty2 = $dirty24;
                    i6 = i2;
                    i7 = i4;
                    i8 = i5;
                    i9 = i30;
                    i10 = i3;
                    scaffoldState2 = scaffoldState;
                }
                Function2 topBar3 = i23 != 0 ? null : function2;
                Function3 snackbarHost3 = i24 != 0 ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1342getLambda1$material_release() : function33;
                Function2 floatingActionButton3 = i25 != 0 ? null : function22;
                int floatingActionButtonPosition4 = i26 != 0 ? FabPosition.INSTANCE.m1405getEnd5ygKITE() : floatingActionButtonPosition;
                boolean sheetGesturesEnabled4 = i6 != 0 ? true : sheetGesturesEnabled;
                BottomSheetScaffoldState scaffoldState5 = scaffoldState2;
                if ((i & 256) != 0) {
                    sheetShape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getLarge();
                    $dirty4 &= -234881025;
                } else {
                    sheetShape2 = sheetShape;
                }
                float sheetElevation4 = i10 != 0 ? BottomSheetScaffoldDefaults.INSTANCE.m1258getSheetElevationD9Ej5fM() : sheetElevation;
                if ((i & 1024) != 0) {
                    $dirty = $dirty4;
                    sheetBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1321getSurface0d7_KjU();
                    $dirty13 &= -15;
                } else {
                    $dirty = $dirty4;
                    sheetBackgroundColor2 = sheetBackgroundColor;
                }
                Function2 topBar4 = topBar3;
                if ((i & 2048) != 0) {
                    sheetContentColor2 = ColorsKt.m1335contentColorForek8zF_U(sheetBackgroundColor2, $composer3, $dirty13 & 14);
                    $dirty13 &= -113;
                } else {
                    sheetContentColor2 = sheetContentColor;
                }
                float sheetPeekHeight5 = i7 != 0 ? BottomSheetScaffoldDefaults.INSTANCE.m1259getSheetPeekHeightD9Ej5fM() : sheetPeekHeight;
                Function3 drawerContent3 = i9 != 0 ? null : function32;
                boolean drawerGesturesEnabled4 = i8 != 0 ? true : drawerGesturesEnabled;
                if ((i & 32768) != 0) {
                    sheetBackgroundColor3 = sheetBackgroundColor2;
                    drawerShape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getLarge();
                    $dirty13 &= -458753;
                } else {
                    sheetBackgroundColor3 = sheetBackgroundColor2;
                    drawerShape2 = drawerShape;
                }
                float drawerElevation5 = i32 != 0 ? DrawerDefaults.INSTANCE.m1362getElevationD9Ej5fM() : drawerElevation;
                if ((i & 131072) != 0) {
                    drawerShape3 = drawerShape2;
                    drawerElevation2 = drawerElevation5;
                    drawerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1321getSurface0d7_KjU();
                    $dirty13 &= -29360129;
                } else {
                    drawerShape3 = drawerShape2;
                    drawerElevation2 = drawerElevation5;
                    drawerBackgroundColor2 = drawerBackgroundColor;
                }
                if ((i & 262144) != 0) {
                    sheetPeekHeight2 = sheetPeekHeight5;
                    drawerContentColor2 = ColorsKt.m1335contentColorForek8zF_U(drawerBackgroundColor2, $composer3, ($dirty13 >> 21) & 14);
                    $dirty13 &= -234881025;
                } else {
                    sheetPeekHeight2 = sheetPeekHeight5;
                    drawerContentColor2 = drawerContentColor;
                }
                if ((i & 524288) != 0) {
                    drawerBackgroundColor3 = drawerBackgroundColor2;
                    i11 = 6;
                    drawerScrimColor2 = DrawerDefaults.INSTANCE.getScrimColor($composer3, 6);
                    $dirty13 &= -1879048193;
                } else {
                    drawerBackgroundColor3 = drawerBackgroundColor2;
                    i11 = 6;
                    drawerScrimColor2 = drawerScrimColor;
                }
                if ((i & 1048576) != 0) {
                    drawerScrimColor3 = drawerScrimColor2;
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, i11).m1310getBackground0d7_KjU();
                    $dirty22 = $dirty2 & (-15);
                } else {
                    drawerScrimColor3 = drawerScrimColor2;
                    backgroundColor2 = backgroundColor;
                    $dirty22 = $dirty2;
                }
                if ((i & 2097152) != 0) {
                    scaffoldState3 = scaffoldState5;
                    snackbarHost = snackbarHost3;
                    drawerShape4 = drawerShape3;
                    drawerElevation3 = drawerElevation2;
                    sheetPeekHeight3 = sheetPeekHeight2;
                    drawerScrimColor4 = drawerScrimColor3;
                    topBar = topBar4;
                    backgroundColor3 = backgroundColor2;
                    $dirty23 = $dirty22 & (-113);
                    floatingActionButton = floatingActionButton3;
                    floatingActionButtonPosition2 = floatingActionButtonPosition4;
                    sheetGesturesEnabled2 = sheetGesturesEnabled4;
                    sheetShape3 = sheetShape2;
                    modifier3 = modifier2;
                    sheetElevation2 = sheetElevation4;
                    sheetContentColor3 = sheetContentColor2;
                    drawerContent = drawerContent3;
                    drawerGesturesEnabled2 = drawerGesturesEnabled4;
                    drawerContentColor3 = drawerContentColor2;
                    $dirty1 = $dirty13;
                    drawerBackgroundColor4 = drawerBackgroundColor3;
                    sheetBackgroundColor4 = sheetBackgroundColor3;
                    contentColor2 = ColorsKt.m1335contentColorForek8zF_U(backgroundColor2, $composer3, $dirty22 & 14);
                    $dirty3 = $dirty;
                } else {
                    scaffoldState3 = scaffoldState5;
                    snackbarHost = snackbarHost3;
                    drawerShape4 = drawerShape3;
                    drawerElevation3 = drawerElevation2;
                    sheetPeekHeight3 = sheetPeekHeight2;
                    drawerScrimColor4 = drawerScrimColor3;
                    contentColor2 = contentColor;
                    topBar = topBar4;
                    backgroundColor3 = backgroundColor2;
                    $dirty23 = $dirty22;
                    floatingActionButton = floatingActionButton3;
                    floatingActionButtonPosition2 = floatingActionButtonPosition4;
                    sheetGesturesEnabled2 = sheetGesturesEnabled4;
                    sheetShape3 = sheetShape2;
                    modifier3 = modifier2;
                    sheetElevation2 = sheetElevation4;
                    sheetContentColor3 = sheetContentColor2;
                    drawerContent = drawerContent3;
                    drawerGesturesEnabled2 = drawerGesturesEnabled4;
                    drawerContentColor3 = drawerContentColor2;
                    $dirty1 = $dirty13;
                    drawerBackgroundColor4 = drawerBackgroundColor3;
                    sheetBackgroundColor4 = sheetBackgroundColor3;
                    $dirty3 = $dirty;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty4 &= -897;
                }
                if ((i & 256) != 0) {
                    $dirty4 &= -234881025;
                }
                if ((i & 1024) != 0) {
                    $dirty13 &= -15;
                }
                if ((i & 2048) != 0) {
                    $dirty13 &= -113;
                }
                if ((32768 & i) != 0) {
                    $dirty13 &= -458753;
                }
                if ((i & 131072) != 0) {
                    $dirty13 &= -29360129;
                }
                if ((262144 & i) != 0) {
                    $dirty13 &= -234881025;
                }
                if ((i & 524288) != 0) {
                    $dirty13 &= -1879048193;
                }
                if ((i & 1048576) != 0) {
                    $dirty24 &= -15;
                }
                if ((2097152 & i) != 0) {
                    scaffoldState3 = scaffoldState;
                    topBar = function2;
                    floatingActionButton = function22;
                    floatingActionButtonPosition2 = floatingActionButtonPosition;
                    sheetGesturesEnabled2 = sheetGesturesEnabled;
                    sheetShape3 = sheetShape;
                    sheetElevation2 = sheetElevation;
                    sheetBackgroundColor4 = sheetBackgroundColor;
                    sheetContentColor3 = sheetContentColor;
                    sheetPeekHeight3 = sheetPeekHeight;
                    drawerContent = function32;
                    drawerGesturesEnabled2 = drawerGesturesEnabled;
                    drawerShape4 = drawerShape;
                    drawerElevation3 = drawerElevation;
                    drawerBackgroundColor4 = drawerBackgroundColor;
                    drawerContentColor3 = drawerContentColor;
                    drawerScrimColor4 = drawerScrimColor;
                    backgroundColor3 = backgroundColor;
                    $dirty23 = $dirty24 & (-113);
                    contentColor2 = j;
                    snackbarHost = function33;
                    modifier3 = modifier2;
                    $dirty1 = $dirty13;
                    $dirty3 = $dirty4;
                } else {
                    scaffoldState3 = scaffoldState;
                    topBar = function2;
                    floatingActionButton = function22;
                    floatingActionButtonPosition2 = floatingActionButtonPosition;
                    sheetGesturesEnabled2 = sheetGesturesEnabled;
                    sheetShape3 = sheetShape;
                    sheetElevation2 = sheetElevation;
                    sheetBackgroundColor4 = sheetBackgroundColor;
                    sheetContentColor3 = sheetContentColor;
                    sheetPeekHeight3 = sheetPeekHeight;
                    drawerContent = function32;
                    drawerGesturesEnabled2 = drawerGesturesEnabled;
                    drawerShape4 = drawerShape;
                    drawerElevation3 = drawerElevation;
                    drawerBackgroundColor4 = drawerBackgroundColor;
                    drawerContentColor3 = drawerContentColor;
                    drawerScrimColor4 = drawerScrimColor;
                    backgroundColor3 = backgroundColor;
                    $dirty23 = $dirty24;
                    contentColor2 = j;
                    snackbarHost = function33;
                    modifier3 = modifier2;
                    $dirty1 = $dirty13;
                    $dirty3 = $dirty4;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(46422755, $dirty3, $dirty1, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:258)");
            }
            $composer3.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation($composer3, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
            Object value$iv$iv$iv = $composer3.rememberedValue();
            if (value$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                $composer3.updateRememberedValue(value$iv$iv$iv);
            }
            $composer3.endReplaceableGroup();
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
            CoroutineScope scope = wrapper$iv.getCoroutineScope();
            $composer3.endReplaceableGroup();
            int $dirty5 = $dirty3;
            $composer2 = $composer3;
            BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda($composer2, -440488519, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(scaffoldState3, sheetGesturesEnabled2, drawerContent, drawerGesturesEnabled2, drawerShape4, drawerElevation3, drawerBackgroundColor4, drawerContentColor3, drawerScrimColor4, $dirty1, sheetPeekHeight3, scope, floatingActionButtonPosition2, $dirty5, backgroundColor3, contentColor2, $dirty23, topBar, content, sheetShape3, sheetBackgroundColor4, sheetContentColor3, sheetElevation2, sheetContent, floatingActionButton, snackbarHost)), $composer2, (($dirty5 >> 3) & 14) | 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentColor3 = contentColor2;
            backgroundColor4 = backgroundColor3;
            drawerScrimColor5 = drawerScrimColor4;
            drawerContentColor4 = drawerContentColor3;
            drawerBackgroundColor5 = drawerBackgroundColor4;
            drawerElevation4 = drawerElevation3;
            drawerShape5 = drawerShape4;
            drawerGesturesEnabled3 = drawerGesturesEnabled2;
            drawerContent2 = drawerContent;
            sheetPeekHeight4 = sheetPeekHeight3;
            sheetContentColor4 = sheetContentColor3;
            sheetBackgroundColor5 = sheetBackgroundColor4;
            sheetElevation3 = sheetElevation2;
            sheetShape4 = sheetShape3;
            sheetGesturesEnabled3 = sheetGesturesEnabled2;
            floatingActionButtonPosition3 = floatingActionButtonPosition2;
            floatingActionButton2 = floatingActionButton;
            snackbarHost2 = snackbarHost;
            topBar2 = topBar;
            scaffoldState4 = scaffoldState3;
            modifier4 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier4;
        final BottomSheetScaffoldState bottomSheetScaffoldState = scaffoldState4;
        final Function2 function23 = topBar2;
        final Function3 function34 = snackbarHost2;
        final Function2 function24 = floatingActionButton2;
        final int i33 = floatingActionButtonPosition3;
        final boolean z = sheetGesturesEnabled3;
        final Shape shape = sheetShape4;
        final float f = sheetElevation3;
        final long j2 = sheetBackgroundColor5;
        final long j3 = sheetContentColor4;
        final float f2 = sheetPeekHeight4;
        final Function3 function35 = drawerContent2;
        final boolean z2 = drawerGesturesEnabled3;
        final Shape shape2 = drawerShape5;
        final float f3 = drawerElevation4;
        final long j4 = drawerBackgroundColor5;
        final long j5 = drawerContentColor4;
        final long j6 = drawerScrimColor5;
        final long j7 = backgroundColor4;
        final long j8 = contentColor3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

            public final void invoke(Composer composer, int i34) {
                BottomSheetScaffoldKt.m1260BottomSheetScaffoldbGncdBI(sheetContent, modifier5, bottomSheetScaffoldState, function23, function34, function24, i33, z, shape, f, j2, j3, f2, function35, z2, shape2, f3, j4, j5, j6, j7, j8, content, composer, $changed | 1, $changed1, $changed2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomSheetScaffoldStack-SlNgfk0, reason: not valid java name */
    public static final void m1261BottomSheetScaffoldStackSlNgfk0(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final State<Float> state, final int floatingActionButtonPosition, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(172426443);
        ComposerKt.sourceInformation($composer2, "C(BottomSheetScaffoldStack)P(!2,3,5!,4:c#material.FabPosition)390@16235L1315:BottomSheetScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(function2) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(function22) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(function23) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(function24) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changed(state) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer2.changed(floatingActionButtonPosition) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((374491 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(172426443, $dirty2, -1, "androidx.compose.material.BottomSheetScaffoldStack (BottomSheetScaffold.kt:382)");
            }
            MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldStack$2
                @Override // androidx.compose.p000ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo331measure3p2s80s(final MeasureScope Layout, final List<? extends Measurable> measurables, final long constraints) {
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    final Placeable placeable = ((Measurable) CollectionsKt.first((List) measurables)).mo3492measureBRTryo0(constraints);
                    int width = placeable.getWidth();
                    int height = placeable.getHeight();
                    final State<Float> state2 = state;
                    final int i = floatingActionButtonPosition;
                    return MeasureScope.layout$default(Layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldStack$2$measure$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
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
                            float f;
                            int fabOffsetX;
                            long m4328copyZbe2FdA;
                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                            Placeable.PlacementScope.placeRelative$default(layout, Placeable.this, 0, 0, 0.0f, 4, null);
                            Iterable $this$map$iv = CollectionsKt.drop(measurables, 1);
                            long j = constraints;
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                Measurable it = (Measurable) item$iv$iv;
                                m4328copyZbe2FdA = Constraints.m4328copyZbe2FdA(j, (r12 & 1) != 0 ? Constraints.m4340getMinWidthimpl(j) : 0, (r12 & 2) != 0 ? Constraints.m4338getMaxWidthimpl(j) : 0, (r12 & 4) != 0 ? Constraints.m4339getMinHeightimpl(j) : 0, (r12 & 8) != 0 ? Constraints.m4337getMaxHeightimpl(j) : 0);
                                destination$iv$iv.add(it.mo3492measureBRTryo0(m4328copyZbe2FdA));
                            }
                            ArrayList arrayList = (List) destination$iv$iv;
                            Placeable sheetPlaceable = (Placeable) arrayList.get(0);
                            Placeable fabPlaceable = (Placeable) arrayList.get(1);
                            Placeable snackbarPlaceable = (Placeable) arrayList.get(2);
                            int sheetOffsetY = MathKt.roundToInt(state2.getValue().floatValue());
                            Placeable.PlacementScope.placeRelative$default(layout, sheetPlaceable, 0, sheetOffsetY, 0.0f, 4, null);
                            if (FabPosition.m1400equalsimpl0(i, FabPosition.INSTANCE.m1404getCenter5ygKITE())) {
                                fabOffsetX = (Placeable.this.getWidth() - fabPlaceable.getWidth()) / 2;
                            } else {
                                int width2 = Placeable.this.getWidth() - fabPlaceable.getWidth();
                                MeasureScope measureScope = Layout;
                                f = BottomSheetScaffoldKt.FabEndSpacing;
                                fabOffsetX = width2 - measureScope.mo642roundToPx0680j_4(f);
                            }
                            int fabOffsetY = sheetOffsetY - (fabPlaceable.getHeight() / 2);
                            Placeable.PlacementScope.placeRelative$default(layout, fabPlaceable, fabOffsetX, fabOffsetY, 0.0f, 4, null);
                            int snackbarOffsetX = (Placeable.this.getWidth() - snackbarPlaceable.getWidth()) / 2;
                            int snackbarOffsetY = Placeable.this.getHeight() - snackbarPlaceable.getHeight();
                            Placeable.PlacementScope.placeRelative$default(layout, snackbarPlaceable, snackbarOffsetX, snackbarOffsetY, 0.0f, 4, null);
                        }
                    }, 4, null);
                }
            };
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
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
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
            $composer2.startReplaceableGroup(-1162539198);
            ComposerKt.sourceInformation($composer2, "C392@16275L6,393@16294L13,394@16320L22,395@16355L14:BottomSheetScaffold.kt#jmzs0o");
            if ((($changed$iv$iv >> 9) & 14 & 11) != 2 || !$composer2.getSkipping()) {
                function2.invoke($composer2, Integer.valueOf($dirty2 & 14));
                function22.invoke($composer2, Integer.valueOf(($dirty2 >> 3) & 14));
                function23.invoke($composer2, Integer.valueOf(($dirty2 >> 6) & 14));
                function24.invoke($composer2, Integer.valueOf(($dirty2 >> 9) & 14));
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldStack$3
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
                BottomSheetScaffoldKt.m1261BottomSheetScaffoldStackSlNgfk0(function2, function22, function23, function24, state, floatingActionButtonPosition, composer, $changed | 1);
            }
        });
    }
}
