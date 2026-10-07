package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.ZIndexModifierKt;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.layout.SubcomposeLayoutKt;
import androidx.compose.p000ui.layout.SubcomposeMeasureScope;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.ConstraintsKt;
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
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BackdropScaffold.kt */
@Metadata(m286d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\tH\u0003¢\u0006\u0002\u0010\u000b\u001aõ\u0001\u0010\f\u001a\u00020\u00042\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010 \u001a\u00020\u001a2\b\b\u0002\u0010!\u001a\u00020\u001a2\u0019\b\u0002\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040#¢\u0006\u0002\b\tH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001ah\u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t¢\u0006\u0002\b)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0#2\"\u0010,\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00040-¢\u0006\u0002\b\t¢\u0006\u0002\b)H\u0003ø\u0001\u0000¢\u0006\u0002\u0010/\u001a3\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u001a2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u00103\u001a\u00020\u0014H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aE\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u00062\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020.092\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140#2\b\b\u0002\u0010;\u001a\u00020$H\u0007¢\u0006\u0002\u0010<\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006="}, m287d2 = {"AnimationSlideOffset", "Landroidx/compose/ui/unit/Dp;", "F", "BackLayerTransition", "", "target", "Landroidx/compose/material/BackdropValue;", "appBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "(Landroidx/compose/material/BackdropValue;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BackdropScaffold", "backLayerContent", "frontLayerContent", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/BackdropScaffoldState;", "gesturesEnabled", "", "peekHeight", "headerHeight", "persistentAppBar", "stickyFrontLayer", "backLayerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "backLayerContentColor", "frontLayerShape", "Landroidx/compose/ui/graphics/Shape;", "frontLayerElevation", "frontLayerBackgroundColor", "frontLayerContentColor", "frontLayerScrimColor", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "BackdropScaffold-BZszfkY", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BackdropScaffoldState;ZFFZZJJLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BackdropStack", "backLayer", "Landroidx/compose/ui/UiComposable;", "calculateBackLayerConstraints", "Landroidx/compose/ui/unit/Constraints;", "frontLayer", "Lkotlin/Function2;", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "Scrim", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberBackdropScaffoldState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "snackbarHostState", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BackdropScaffoldState;", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class BackdropScaffoldKt {
    private static final float AnimationSlideOffset = C0504Dp.m4382constructorimpl(20);

    @ExperimentalMaterialApi
    public static final BackdropScaffoldState rememberBackdropScaffoldState(final BackdropValue initialValue, final AnimationSpec<Float> animationSpec, final Function1<? super BackdropValue, Boolean> function1, final SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(-862178912);
        ComposerKt.sourceInformation($composer, "C(rememberBackdropScaffoldState)P(2)171@6447L32,173@6518L538:BackdropScaffold.kt#jmzs0o");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
            animationSpec = animationSpec2;
        }
        if ((i & 4) != 0) {
            Function1 confirmStateChange = new Function1<BackdropValue, Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt$rememberBackdropScaffoldState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BackdropValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if ((i & 8) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new SnackbarHostState();
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) value$iv$iv;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-862178912, $changed, -1, "androidx.compose.material.rememberBackdropScaffoldState (BackdropScaffold.kt:167)");
        }
        BackdropScaffoldState backdropScaffoldState = (BackdropScaffoldState) RememberSaveableKt.m1652rememberSaveable(new Object[]{animationSpec, function1, snackbarHostState}, (Saver) BackdropScaffoldState.INSTANCE.Saver(animationSpec, function1, snackbarHostState), (String) null, (Function0) new Function0<BackdropScaffoldState>() { // from class: androidx.compose.material.BackdropScaffoldKt$rememberBackdropScaffoldState$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BackdropScaffoldState invoke() {
                return new BackdropScaffoldState(BackdropValue.this, animationSpec, function1, snackbarHostState);
            }
        }, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return backdropScaffoldState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x01ac, code lost:
    
        if (r9.changed(r66) != false) goto L129;
     */
    /* JADX WARN: Removed duplicated region for block: B:139:0x059a  */
    @ExperimentalMaterialApi
    /* renamed from: BackdropScaffold-BZszfkY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1236BackdropScaffoldBZszfkY(final Function2<? super Composer, ? super Integer, Unit> appBar, final Function2<? super Composer, ? super Integer, Unit> backLayerContent, final Function2<? super Composer, ? super Integer, Unit> frontLayerContent, Modifier modifier, BackdropScaffoldState scaffoldState, boolean gesturesEnabled, float peekHeight, float headerHeight, boolean persistentAppBar, boolean stickyFrontLayer, long backLayerBackgroundColor, long backLayerContentColor, Shape frontLayerShape, float frontLayerElevation, long frontLayerBackgroundColor, long frontLayerContentColor, long frontLayerScrimColor, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        int i2;
        int i3;
        int i4;
        int $dirty;
        Shape shape;
        Function3 function32;
        int i5;
        int i6;
        int i7;
        int i8;
        BackdropScaffoldState scaffoldState2;
        boolean persistentAppBar2;
        boolean stickyFrontLayer2;
        int $dirty1;
        long backLayerBackgroundColor2;
        long backLayerContentColor2;
        int $dirty12;
        float peekHeight2;
        Shape frontLayerShape2;
        float frontLayerElevation2;
        long frontLayerBackgroundColor2;
        float headerHeight2;
        long frontLayerContentColor2;
        long frontLayerBackgroundColor3;
        long frontLayerBackgroundColor4;
        BackdropScaffoldState scaffoldState3;
        Shape frontLayerShape3;
        float frontLayerElevation3;
        Function3 snackbarHost;
        int $dirty13;
        long frontLayerScrimColor2;
        long frontLayerContentColor3;
        long frontLayerBackgroundColor5;
        long backLayerContentColor3;
        int $dirty2;
        boolean gesturesEnabled2;
        float peekHeight3;
        float headerHeight3;
        Object value$iv$iv;
        boolean persistentAppBar3;
        BackdropScaffoldState scaffoldState4;
        boolean gesturesEnabled3;
        float peekHeight4;
        float headerHeight4;
        Modifier modifier3;
        boolean stickyFrontLayer3;
        long backLayerBackgroundColor3;
        int i9;
        int i10;
        int i11;
        Intrinsics.checkNotNullParameter(appBar, "appBar");
        Intrinsics.checkNotNullParameter(backLayerContent, "backLayerContent");
        Intrinsics.checkNotNullParameter(frontLayerContent, "frontLayerContent");
        Composer $composer2 = $composer.startRestartGroup(1397420093);
        ComposerKt.sourceInformation($composer2, "C(BackdropScaffold)P(!1,2,5,12,15,10,13:c#ui.unit.Dp,11:c#ui.unit.Dp,14,17,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,8:c#ui.graphics.Color)260@11766L40,266@12093L6,267@12144L41,268@12241L15,270@12387L6,271@12439L42,272@12542L20,*275@12690L7,276@12764L7,288@13147L100,293@13271L3282:BackdropScaffold.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty14 = $changed1;
        int i12 = 2;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer2.changed(appBar) ? 4 : 2;
        }
        int i13 = 32;
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty3 |= $composer2.changed(backLayerContent) ? 32 : 16;
        }
        int i14 = 128;
        if ((i & 4) != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer2.changed(frontLayerContent) ? 256 : 128;
        }
        int i15 = i & 8;
        if (i15 != 0) {
            $dirty3 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 7168) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i16 = 8192;
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0 && $composer2.changed(scaffoldState)) {
                i11 = 16384;
                $dirty3 |= i11;
            }
            i11 = 8192;
            $dirty3 |= i11;
        }
        int i17 = i & 32;
        if (i17 != 0) {
            $dirty3 |= 196608;
        } else if (($changed & 458752) == 0) {
            $dirty3 |= $composer2.changed(gesturesEnabled) ? 131072 : 65536;
        }
        int i18 = i & 64;
        if (i18 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty3 |= $composer2.changed(peekHeight) ? 1048576 : 524288;
        }
        int i19 = i & 128;
        if (i19 != 0) {
            $dirty3 |= 12582912;
            i2 = i19;
        } else if (($changed & 29360128) == 0) {
            i2 = i19;
            $dirty3 |= $composer2.changed(headerHeight) ? 8388608 : 4194304;
        } else {
            i2 = i19;
        }
        int i20 = i & 256;
        if (i20 != 0) {
            $dirty3 |= 100663296;
            i3 = i20;
        } else if (($changed & 234881024) == 0) {
            i3 = i20;
            $dirty3 |= $composer2.changed(persistentAppBar) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i3 = i20;
        }
        int i21 = i & 512;
        if (i21 != 0) {
            $dirty = $dirty3 | 805306368;
            i4 = i21;
        } else {
            if (($changed & 1879048192) == 0) {
                i4 = i21;
                $dirty3 |= $composer2.changed(stickyFrontLayer) ? 536870912 : 268435456;
            } else {
                i4 = i21;
            }
            $dirty = $dirty3;
        }
        if (($changed1 & 14) == 0) {
            if ((i & 1024) == 0 && $composer2.changed(backLayerBackgroundColor)) {
                i12 = 4;
            }
            $dirty14 |= i12;
        }
        if (($changed1 & SdkConfig.SDK_VERSION) == 0) {
            if ((i & 2048) != 0) {
            }
            i13 = 16;
            $dirty14 |= i13;
        }
        if (($changed1 & 896) == 0) {
            if ((i & 4096) == 0) {
                shape = frontLayerShape;
                if ($composer2.changed(shape)) {
                    i14 = 256;
                }
            } else {
                shape = frontLayerShape;
            }
            $dirty14 |= i14;
        } else {
            shape = frontLayerShape;
        }
        int i22 = i & 8192;
        if (i22 != 0) {
            $dirty14 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty14 |= $composer2.changed(frontLayerElevation) ? 2048 : 1024;
        }
        if (($changed1 & 57344) == 0) {
            if ((i & 16384) == 0 && $composer2.changed(frontLayerBackgroundColor)) {
                i16 = 16384;
            }
            $dirty14 |= i16;
        }
        if ((458752 & $changed1) == 0) {
            if ((i & 32768) == 0 && $composer2.changed(frontLayerContentColor)) {
                i10 = 131072;
                $dirty14 |= i10;
            }
            i10 = 65536;
            $dirty14 |= i10;
        }
        if ((3670016 & $changed1) == 0) {
            if ((i & 65536) == 0 && $composer2.changed(frontLayerScrimColor)) {
                i9 = 1048576;
                $dirty14 |= i9;
            }
            i9 = 524288;
            $dirty14 |= i9;
        }
        int i23 = i & 131072;
        if (i23 != 0) {
            $dirty14 |= 12582912;
            function32 = function3;
        } else if (($changed1 & 29360128) == 0) {
            function32 = function3;
            $dirty14 |= $composer2.changed(function32) ? 8388608 : 4194304;
        } else {
            function32 = function3;
        }
        int $dirty15 = $dirty14;
        if (($dirty & 1533916891) == 306783378 && (23967451 & $dirty15) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            scaffoldState4 = scaffoldState;
            gesturesEnabled3 = gesturesEnabled;
            peekHeight4 = peekHeight;
            persistentAppBar3 = persistentAppBar;
            stickyFrontLayer3 = stickyFrontLayer;
            backLayerBackgroundColor3 = backLayerBackgroundColor;
            backLayerContentColor3 = backLayerContentColor;
            frontLayerElevation3 = frontLayerElevation;
            frontLayerBackgroundColor5 = frontLayerBackgroundColor;
            frontLayerContentColor3 = frontLayerContentColor;
            frontLayerScrimColor2 = frontLayerScrimColor;
            modifier3 = modifier2;
            frontLayerShape3 = shape;
            snackbarHost = function32;
            headerHeight4 = headerHeight;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier modifier4 = i15 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 16) != 0) {
                    i5 = i22;
                    i6 = i2;
                    i7 = i3;
                    i8 = i4;
                    scaffoldState2 = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, $composer2, 6, 14);
                    $dirty &= -57345;
                } else {
                    i5 = i22;
                    i6 = i2;
                    i7 = i3;
                    i8 = i4;
                    scaffoldState2 = scaffoldState;
                }
                boolean gesturesEnabled4 = i17 != 0 ? true : gesturesEnabled;
                float peekHeight5 = i18 != 0 ? BackdropScaffoldDefaults.INSTANCE.m1234getPeekHeightD9Ej5fM() : peekHeight;
                float headerHeight5 = i6 != 0 ? BackdropScaffoldDefaults.INSTANCE.m1233getHeaderHeightD9Ej5fM() : headerHeight;
                persistentAppBar2 = i7 != 0 ? true : persistentAppBar;
                stickyFrontLayer2 = i8 != 0 ? true : stickyFrontLayer;
                BackdropScaffoldState scaffoldState5 = scaffoldState2;
                if ((i & 1024) != 0) {
                    $dirty1 = $dirty15 & (-15);
                    backLayerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1317getPrimary0d7_KjU();
                } else {
                    $dirty1 = $dirty15;
                    backLayerBackgroundColor2 = backLayerBackgroundColor;
                }
                if ((i & 2048) != 0) {
                    backLayerContentColor2 = ColorsKt.m1335contentColorForek8zF_U(backLayerBackgroundColor2, $composer2, $dirty1 & 14);
                    $dirty12 = $dirty1 & (-113);
                } else {
                    backLayerContentColor2 = backLayerContentColor;
                    $dirty12 = $dirty1;
                }
                boolean gesturesEnabled5 = gesturesEnabled4;
                if ((i & 4096) != 0) {
                    peekHeight2 = peekHeight5;
                    frontLayerShape2 = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape($composer2, 6);
                    $dirty12 &= -897;
                } else {
                    peekHeight2 = peekHeight5;
                    frontLayerShape2 = frontLayerShape;
                }
                float frontLayerElevation4 = i5 != 0 ? BackdropScaffoldDefaults.INSTANCE.m1232getFrontLayerElevationD9Ej5fM() : frontLayerElevation;
                Shape frontLayerShape4 = frontLayerShape2;
                if ((i & 16384) != 0) {
                    frontLayerElevation2 = frontLayerElevation4;
                    frontLayerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1321getSurface0d7_KjU();
                    $dirty12 &= -57345;
                } else {
                    frontLayerElevation2 = frontLayerElevation4;
                    frontLayerBackgroundColor2 = frontLayerBackgroundColor;
                }
                if ((i & 32768) != 0) {
                    headerHeight2 = headerHeight5;
                    frontLayerContentColor2 = ColorsKt.m1335contentColorForek8zF_U(frontLayerBackgroundColor2, $composer2, ($dirty12 >> 12) & 14);
                    $dirty12 &= -458753;
                } else {
                    headerHeight2 = headerHeight5;
                    frontLayerContentColor2 = frontLayerContentColor;
                }
                if ((i & 65536) != 0) {
                    frontLayerBackgroundColor3 = frontLayerBackgroundColor2;
                    frontLayerBackgroundColor4 = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor($composer2, 6);
                    $dirty12 &= -3670017;
                } else {
                    frontLayerBackgroundColor3 = frontLayerBackgroundColor2;
                    frontLayerBackgroundColor4 = frontLayerScrimColor;
                }
                if (i23 != 0) {
                    frontLayerShape3 = frontLayerShape4;
                    frontLayerElevation3 = frontLayerElevation2;
                    snackbarHost = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1341getLambda1$material_release();
                    $dirty13 = $dirty12;
                    frontLayerScrimColor2 = frontLayerBackgroundColor4;
                    frontLayerContentColor3 = frontLayerContentColor2;
                    modifier2 = modifier4;
                    frontLayerBackgroundColor5 = frontLayerBackgroundColor3;
                    backLayerContentColor3 = backLayerContentColor2;
                    $dirty2 = $dirty;
                    scaffoldState3 = scaffoldState5;
                    gesturesEnabled2 = gesturesEnabled5;
                    peekHeight3 = peekHeight2;
                    headerHeight3 = headerHeight2;
                } else {
                    scaffoldState3 = scaffoldState5;
                    frontLayerShape3 = frontLayerShape4;
                    frontLayerElevation3 = frontLayerElevation2;
                    snackbarHost = function3;
                    $dirty13 = $dirty12;
                    frontLayerScrimColor2 = frontLayerBackgroundColor4;
                    frontLayerContentColor3 = frontLayerContentColor2;
                    modifier2 = modifier4;
                    frontLayerBackgroundColor5 = frontLayerBackgroundColor3;
                    backLayerContentColor3 = backLayerContentColor2;
                    $dirty2 = $dirty;
                    gesturesEnabled2 = gesturesEnabled5;
                    peekHeight3 = peekHeight2;
                    headerHeight3 = headerHeight2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 1024) != 0) {
                    $dirty15 &= -15;
                }
                if ((i & 2048) != 0) {
                    $dirty15 &= -113;
                }
                if ((i & 4096) != 0) {
                    $dirty15 &= -897;
                }
                if ((i & 16384) != 0) {
                    $dirty15 &= -57345;
                }
                if ((i & 32768) != 0) {
                    $dirty15 &= -458753;
                }
                if ((i & 65536) != 0) {
                    gesturesEnabled2 = gesturesEnabled;
                    peekHeight3 = peekHeight;
                    headerHeight3 = headerHeight;
                    persistentAppBar2 = persistentAppBar;
                    backLayerContentColor3 = backLayerContentColor;
                    frontLayerElevation3 = frontLayerElevation;
                    frontLayerBackgroundColor5 = frontLayerBackgroundColor;
                    frontLayerContentColor3 = frontLayerContentColor;
                    frontLayerScrimColor2 = frontLayerScrimColor;
                    $dirty13 = (-3670017) & $dirty15;
                    frontLayerShape3 = shape;
                    snackbarHost = function32;
                    $dirty2 = $dirty;
                    scaffoldState3 = scaffoldState;
                    stickyFrontLayer2 = stickyFrontLayer;
                    backLayerBackgroundColor2 = backLayerBackgroundColor;
                } else {
                    scaffoldState3 = scaffoldState;
                    gesturesEnabled2 = gesturesEnabled;
                    peekHeight3 = peekHeight;
                    headerHeight3 = headerHeight;
                    persistentAppBar2 = persistentAppBar;
                    backLayerContentColor3 = backLayerContentColor;
                    frontLayerElevation3 = frontLayerElevation;
                    frontLayerBackgroundColor5 = frontLayerBackgroundColor;
                    frontLayerContentColor3 = frontLayerContentColor;
                    frontLayerScrimColor2 = frontLayerScrimColor;
                    frontLayerShape3 = shape;
                    snackbarHost = function32;
                    $dirty13 = $dirty15;
                    $dirty2 = $dirty;
                    stickyFrontLayer2 = stickyFrontLayer;
                    backLayerBackgroundColor2 = backLayerBackgroundColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1397420093, $dirty2, $dirty13, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:255)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$BackdropScaffold_BZszfkY_u24lambda_u2d1 = (Density) consume;
            final float peekHeightPx = $this$BackdropScaffold_BZszfkY_u24lambda_u2d1.mo648toPx0680j_4(peekHeight3);
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$BackdropScaffold_BZszfkY_u24lambda_u2d2 = (Density) consume2;
            final float headerHeightPx = $this$BackdropScaffold_BZszfkY_u24lambda_u2d2.mo648toPx0680j_4(headerHeight3);
            final boolean z = persistentAppBar2;
            final BackdropScaffoldState backdropScaffoldState = scaffoldState3;
            final int i24 = $dirty2;
            boolean persistentAppBar4 = persistentAppBar2;
            final Function2 backLayer = ComposableLambdaKt.composableLambda($composer2, 1744778315, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$backLayer$1
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
                    ComposerKt.sourceInformation($composer3, "C:BackdropScaffold.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1744778315, $changed2, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:278)");
                        }
                        if (z) {
                            $composer3.startReplaceableGroup(-1017265331);
                            ComposerKt.sourceInformation($composer3, "280@12876L82");
                            Function2<Composer, Integer, Unit> function2 = appBar;
                            int i25 = i24;
                            Function2<Composer, Integer, Unit> function22 = backLayerContent;
                            $composer3.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation($composer3, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                            Modifier modifier$iv = Modifier.INSTANCE;
                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                            int $changed$iv$iv = (0 << 3) & SdkConfig.SDK_VERSION;
                            $composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume3 = $composer3.consume(localDensity3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Density density$iv$iv = (Density) consume3;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume4 = $composer3.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume4;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume5 = $composer3.consume(localViewConfiguration);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume5;
                            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                            if (!($composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer3.startReusableNode();
                            if ($composer3.getInserting()) {
                                $composer3.createNode(factory$iv$iv$iv);
                            } else {
                                $composer3.useNode();
                            }
                            $composer3.disableReusing();
                            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer3);
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            $composer3.enableReusing();
                            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                            $composer3.startReplaceableGroup(2058660585);
                            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                            $composer3.startReplaceableGroup(-1163856341);
                            ComposerKt.sourceInformation($composer3, "C79@3994L9:Column.kt#2w3rfo");
                            if (($changed$iv & 11) == 2 && $composer3.getSkipping()) {
                                $composer3.skipToGroupEnd();
                            } else {
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                int $changed3 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                $composer3.startReplaceableGroup(-18835878);
                                ComposerKt.sourceInformation($composer3, "C281@12901L8,282@12926L18:BackdropScaffold.kt#jmzs0o");
                                if (($changed3 & 81) != 16 || !$composer3.getSkipping()) {
                                    function2.invoke($composer3, Integer.valueOf(i25 & 14));
                                    function22.invoke($composer3, Integer.valueOf((i25 >> 3) & 14));
                                } else {
                                    $composer3.skipToGroupEnd();
                                }
                                $composer3.endReplaceableGroup();
                            }
                            $composer3.endReplaceableGroup();
                            $composer3.endReplaceableGroup();
                            $composer3.endNode();
                            $composer3.endReplaceableGroup();
                            $composer3.endReplaceableGroup();
                            $composer3.endReplaceableGroup();
                        } else {
                            $composer3.startReplaceableGroup(-1017265219);
                            ComposerKt.sourceInformation($composer3, "285@12988L72");
                            BackdropScaffoldKt.BackLayerTransition(backdropScaffoldState.getTargetValue(), appBar, backLayerContent, $composer3, ((i24 << 3) & SdkConfig.SDK_VERSION) | ((i24 << 3) & 896));
                            $composer3.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            });
            Object key1$iv = Float.valueOf(headerHeightPx);
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(key1$iv);
            Object it$iv$iv = $composer2.rememberedValue();
            if (!invalid$iv$iv && it$iv$iv != Composer.INSTANCE.getEmpty()) {
                value$iv$iv = it$iv$iv;
                $composer2.endReplaceableGroup();
                final Function1 calculateBackLayerConstraints = (Function1) value$iv$iv;
                final Modifier modifier5 = modifier2;
                final boolean z2 = stickyFrontLayer2;
                final boolean z3 = gesturesEnabled2;
                final BackdropScaffoldState backdropScaffoldState2 = scaffoldState3;
                final int i25 = $dirty2;
                final Shape shape2 = frontLayerShape3;
                final long j = frontLayerBackgroundColor5;
                final long j2 = frontLayerContentColor3;
                final float f = frontLayerElevation3;
                final int i26 = $dirty13;
                final float f2 = headerHeight3;
                final float f3 = peekHeight3;
                final long j3 = frontLayerScrimColor2;
                final Function3 function33 = snackbarHost;
                BackdropScaffoldState scaffoldState6 = scaffoldState3;
                boolean gesturesEnabled6 = gesturesEnabled2;
                SurfaceKt.m1513SurfaceFjzlyU(null, null, backLayerBackgroundColor2, backLayerContentColor3, null, 0.0f, ComposableLambdaKt.composableLambda($composer2, -1049909631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1
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
                        Object value$iv$iv$iv;
                        ComposerKt.sourceInformation($composer3, "C297@13395L24,298@13428L3119:BackdropScaffold.kt#jmzs0o");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1049909631, $changed2, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:296)");
                            }
                            $composer3.startReplaceableGroup(773894976);
                            ComposerKt.sourceInformation($composer3, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                            $composer3.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                            Object it$iv$iv$iv = $composer3.rememberedValue();
                            if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                                value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                                $composer3.updateRememberedValue(value$iv$iv$iv);
                            } else {
                                value$iv$iv$iv = it$iv$iv$iv;
                            }
                            $composer3.endReplaceableGroup();
                            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                            final CoroutineScope scope = wrapper$iv.getCoroutineScope();
                            $composer3.endReplaceableGroup();
                            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.this, 0.0f, 1, null);
                            Function2<Composer, Integer, Unit> function2 = backLayer;
                            Function1<Constraints, Constraints> function1 = calculateBackLayerConstraints;
                            final float f4 = headerHeightPx;
                            final boolean z4 = z2;
                            final boolean z5 = z3;
                            final BackdropScaffoldState backdropScaffoldState3 = backdropScaffoldState2;
                            final float f5 = peekHeightPx;
                            final int i27 = i25;
                            final Shape shape3 = shape2;
                            final long j4 = j;
                            final long j5 = j2;
                            final float f6 = f;
                            final int i28 = i26;
                            final float f7 = f2;
                            final float f8 = f3;
                            final Function2<Composer, Integer, Unit> function22 = frontLayerContent;
                            final long j6 = j3;
                            final Function3<SnackbarHostState, Composer, Integer, Unit> function34 = function33;
                            BackdropScaffoldKt.BackdropStack(fillMaxSize$default, function2, function1, ComposableLambdaKt.composableLambda($composer3, 1800047509, true, new Function4<Constraints, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(Constraints constraints, Float f9, Composer composer, Integer num) {
                                    m1241invokejYbf7pk(constraints.getValue(), f9.floatValue(), composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:45:0x028d  */
                                /* JADX WARN: Removed duplicated region for block: B:48:0x0299  */
                                /* JADX WARN: Removed duplicated region for block: B:56:0x0372  */
                                /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
                                /* JADX WARN: Removed duplicated region for block: B:66:0x029d  */
                                /* renamed from: invoke-jYbf7pk, reason: not valid java name */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final void m1241invokejYbf7pk(long constraints, float backLayerHeight, Composer $composer4, int $changed3) {
                                    float revealedHeight;
                                    Modifier.Companion companion;
                                    Modifier m1523swipeablepPrIpRY;
                                    Object value$iv$iv2;
                                    float m4382constructorimpl;
                                    int $changed$iv;
                                    int $changed4;
                                    ComposerKt.sourceInformation($composer4, "CP(1:c#ui.unit.Constraints)344@15194L57,342@15132L942,366@16117L420:BackdropScaffold.kt#jmzs0o");
                                    int $dirty4 = $changed3;
                                    if (($changed3 & 14) == 0) {
                                        $dirty4 |= $composer4.changed(constraints) ? 4 : 2;
                                    }
                                    if (($changed3 & SdkConfig.SDK_VERSION) == 0) {
                                        $dirty4 |= $composer4.changed(backLayerHeight) ? 32 : 16;
                                    }
                                    if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1800047509, $changed3, -1, "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous> (BackdropScaffold.kt:302)");
                                        }
                                        float fullHeight = Constraints.m4337getMaxHeightimpl(constraints);
                                        float revealedHeight2 = fullHeight - f4;
                                        if (!z4) {
                                            revealedHeight = revealedHeight2;
                                        } else {
                                            revealedHeight = Math.min(revealedHeight2, backLayerHeight);
                                        }
                                        if (z5) {
                                            companion = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, backdropScaffoldState3.getNestedScrollConnection(), null, 2, null);
                                        } else {
                                            companion = Modifier.INSTANCE;
                                        }
                                        Modifier nestedScroll = companion;
                                        m1523swipeablepPrIpRY = SwipeableKt.m1523swipeablepPrIpRY(Modifier.INSTANCE.then(nestedScroll), backdropScaffoldState3, r19, Orientation.Vertical, (r26 & 8) != 0 ? true : z5, (r26 & 16) != 0 ? false : false, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function2
                                            public final FixedThreshold invoke(T t, T t2) {
                                                return new FixedThreshold(C0504Dp.m4382constructorimpl(56), null);
                                            }
                                        } : null, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, MapsKt.mapOf(TuplesKt.m294to(Float.valueOf(f5), BackdropValue.Concealed), TuplesKt.m294to(Float.valueOf(revealedHeight), BackdropValue.Revealed)).keySet(), 0.0f, 0.0f, 6, null) : null, (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1522getVelocityThresholdD9Ej5fM() : 0.0f);
                                        final BackdropScaffoldState backdropScaffoldState4 = backdropScaffoldState3;
                                        final CoroutineScope coroutineScope = scope;
                                        Modifier swipeable = SemanticsModifierKt.semantics$default(m1523swipeablepPrIpRY, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1
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
                                                if (BackdropScaffoldState.this.isConcealed()) {
                                                    final BackdropScaffoldState backdropScaffoldState5 = BackdropScaffoldState.this;
                                                    final CoroutineScope coroutineScope2 = coroutineScope;
                                                    SemanticsPropertiesKt.collapse$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Boolean invoke() {
                                                            if (BackdropScaffoldState.this.getConfirmStateChange$material_release().invoke(BackdropValue.Revealed).booleanValue()) {
                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(BackdropScaffoldState.this, null), 3, null);
                                                            }
                                                            return true;
                                                        }

                                                        /* compiled from: BackdropScaffold.kt */
                                                        @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                                        @DebugMetadata(m296c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$1$1", m297f = "BackdropScaffold.kt", m298i = {}, m299l = {330}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                                        /* renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$1$1, reason: invalid class name */
                                                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                            final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                            int label;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            AnonymousClass1(BackdropScaffoldState backdropScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                                                super(2, continuation);
                                                                this.$scaffoldState = backdropScaffoldState;
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                return new AnonymousClass1(this.$scaffoldState, continuation);
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
                                                                        if (this.$scaffoldState.reveal(this) != coroutine_suspended) {
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
                                                } else {
                                                    final BackdropScaffoldState backdropScaffoldState6 = BackdropScaffoldState.this;
                                                    final CoroutineScope coroutineScope3 = coroutineScope;
                                                    SemanticsPropertiesKt.expand$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Boolean invoke() {
                                                            if (BackdropScaffoldState.this.getConfirmStateChange$material_release().invoke(BackdropValue.Concealed).booleanValue()) {
                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(BackdropScaffoldState.this, null), 3, null);
                                                            }
                                                            return true;
                                                        }

                                                        /* compiled from: BackdropScaffold.kt */
                                                        @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                                        @DebugMetadata(m296c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$2$1", m297f = "BackdropScaffold.kt", m298i = {}, m299l = {336}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                                        /* renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$2$1, reason: invalid class name */
                                                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                            final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                            int label;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            AnonymousClass1(BackdropScaffoldState backdropScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                                                super(2, continuation);
                                                                this.$scaffoldState = backdropScaffoldState;
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                return new AnonymousClass1(this.$scaffoldState, continuation);
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
                                                                        if (this.$scaffoldState.conceal(this) != coroutine_suspended) {
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
                                        }, 1, null);
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        Object key1$iv2 = backdropScaffoldState3;
                                        final BackdropScaffoldState backdropScaffoldState5 = backdropScaffoldState3;
                                        int i29 = (i27 >> 12) & 14;
                                        $composer4.startReplaceableGroup(1157296644);
                                        ComposerKt.sourceInformation($composer4, "C(remember)P(1):Composables.kt#9igjgp");
                                        boolean invalid$iv$iv2 = $composer4.changed(key1$iv2);
                                        Object it$iv$iv2 = $composer4.rememberedValue();
                                        if (invalid$iv$iv2 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                                            value$iv$iv2 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$1$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                                    return IntOffset.m4491boximpl(m1242invokeBjo55l4(density));
                                                }

                                                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                                public final long m1242invokeBjo55l4(Density offset) {
                                                    Intrinsics.checkNotNullParameter(offset, "$this$offset");
                                                    return IntOffsetKt.IntOffset(0, MathKt.roundToInt(BackdropScaffoldState.this.getOffset().getValue().floatValue()));
                                                }
                                            };
                                            $composer4.updateRememberedValue(value$iv$iv2);
                                        } else {
                                            value$iv$iv2 = it$iv$iv2;
                                        }
                                        $composer4.endReplaceableGroup();
                                        Modifier then = OffsetKt.offset(companion2, (Function1) value$iv$iv2).then(swipeable);
                                        Shape shape4 = shape3;
                                        long j7 = j4;
                                        long j8 = j5;
                                        float f9 = f6;
                                        final float fullHeight2 = f8;
                                        final Function2<Composer, Integer, Unit> function23 = function22;
                                        final int i30 = i27;
                                        final long j9 = j6;
                                        final BackdropScaffoldState backdropScaffoldState6 = backdropScaffoldState3;
                                        final int i31 = i28;
                                        final boolean z6 = z5;
                                        final CoroutineScope coroutineScope2 = scope;
                                        SurfaceKt.m1513SurfaceFjzlyU(then, shape4, j7, j8, null, f9, ComposableLambdaKt.composableLambda($composer4, -1065299503, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackdropScaffold.1.1.2
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
                                                Composer $composer$iv;
                                                ComposerKt.sourceInformation($composer5, "C351@15517L543:BackdropScaffold.kt#jmzs0o");
                                                if (($changed5 & 11) != 2 || !$composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1065299503, $changed5, -1, "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:350)");
                                                    }
                                                    Modifier modifier$iv = PaddingKt.m763paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, fullHeight2, 7, null);
                                                    Function2<Composer, Integer, Unit> function24 = function23;
                                                    int i32 = i30;
                                                    long j10 = j9;
                                                    final BackdropScaffoldState backdropScaffoldState7 = backdropScaffoldState6;
                                                    int i33 = i31;
                                                    final boolean z7 = z6;
                                                    final CoroutineScope coroutineScope3 = coroutineScope2;
                                                    $composer5.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation($composer5, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                                                    int $changed$iv$iv = (0 << 3) & SdkConfig.SDK_VERSION;
                                                    $composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation($composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                                    ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object consume3 = $composer5.consume(localDensity3);
                                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                                    Density density$iv$iv = (Density) consume3;
                                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                    ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object consume4 = $composer5.consume(localLayoutDirection);
                                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                                    LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume4;
                                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                    ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object consume5 = $composer5.consume(localViewConfiguration);
                                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                                    ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume5;
                                                    Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                                                    int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                    if (!($composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    $composer5.startReusableNode();
                                                    if ($composer5.getInserting()) {
                                                        $composer5.createNode(factory$iv$iv$iv);
                                                    } else {
                                                        $composer5.useNode();
                                                    }
                                                    $composer5.disableReusing();
                                                    Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer5);
                                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                    $composer5.enableReusing();
                                                    skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                                                    $composer5.startReplaceableGroup(2058660585);
                                                    int $changed$iv2 = ($changed$iv$iv$iv >> 9) & 14;
                                                    $composer5.startReplaceableGroup(-2137368960);
                                                    ComposerKt.sourceInformation($composer5, "C72@3384L9:Box.kt#2w3rfo");
                                                    if (($changed$iv2 & 11) == 2 && $composer5.getSkipping()) {
                                                        $composer5.skipToGroupEnd();
                                                        $composer$iv = $composer5;
                                                    } else {
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        int $changed6 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                                        $composer5.startReplaceableGroup(-1889954677);
                                                        ComposerKt.sourceInformation($composer5, "C352@15582L19,353@15622L420:BackdropScaffold.kt#jmzs0o");
                                                        if (($changed6 & 81) != 16 || !$composer5.getSkipping()) {
                                                            function24.invoke($composer5, Integer.valueOf((i32 >> 6) & 14));
                                                            $composer$iv = $composer5;
                                                            BackdropScaffoldKt.m1237Scrim3JVO9M(j10, new Function0<Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1
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
                                                                    if (z7 && backdropScaffoldState7.getConfirmStateChange$material_release().invoke(BackdropValue.Concealed).booleanValue()) {
                                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C02861(backdropScaffoldState7, null), 3, null);
                                                                    }
                                                                }

                                                                /* compiled from: BackdropScaffold.kt */
                                                                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                                                @DebugMetadata(m296c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1$1", m297f = "BackdropScaffold.kt", m298i = {}, m299l = {358}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                                                /* renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1$1 */
                                                                static final class C02861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                    final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                                    int label;

                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    C02861(BackdropScaffoldState backdropScaffoldState, Continuation<? super C02861> continuation) {
                                                                        super(2, continuation);
                                                                        this.$scaffoldState = backdropScaffoldState;
                                                                    }

                                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                        return new C02861(this.$scaffoldState, continuation);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function2
                                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                        return ((C02861) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                    }

                                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                    public final Object invokeSuspend(Object $result) {
                                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                        switch (this.label) {
                                                                            case 0:
                                                                                ResultKt.throwOnFailure($result);
                                                                                this.label = 1;
                                                                                if (this.$scaffoldState.conceal(this) != coroutine_suspended) {
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
                                                            }, backdropScaffoldState7.getTargetValue() == BackdropValue.Revealed, $composer5, (i33 >> 18) & 14);
                                                        } else {
                                                            $composer5.skipToGroupEnd();
                                                            $composer$iv = $composer5;
                                                        }
                                                        $composer5.endReplaceableGroup();
                                                    }
                                                    $composer$iv.endReplaceableGroup();
                                                    $composer5.endReplaceableGroup();
                                                    $composer5.endNode();
                                                    $composer5.endReplaceableGroup();
                                                    $composer5.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer5.skipToGroupEnd();
                                            }
                                        }), $composer4, ((i28 >> 3) & SdkConfig.SDK_VERSION) | 1572864 | ((i28 >> 6) & 896) | ((i28 >> 6) & 7168) | ((i28 << 6) & 458752), 16);
                                        Modifier.Companion companion3 = Modifier.INSTANCE;
                                        if (backdropScaffoldState3.isRevealed()) {
                                            if (revealedHeight == fullHeight - f4) {
                                                m4382constructorimpl = f7;
                                                Modifier modifier$iv = PaddingKt.m763paddingqDBjuR0$default(companion3, 0.0f, 0.0f, 0.0f, m4382constructorimpl, 7, null);
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getBottomCenter();
                                                Function3<SnackbarHostState, Composer, Integer, Unit> function35 = function34;
                                                BackdropScaffoldState backdropScaffoldState7 = backdropScaffoldState3;
                                                int i32 = i28;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & SdkConfig.SDK_VERSION));
                                                int $changed$iv$iv = (48 << 3) & SdkConfig.SDK_VERSION;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object consume3 = $composer4.consume(localDensity3);
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
                                                $composer4.startReplaceableGroup(-2137368960);
                                                ComposerKt.sourceInformation($composer4, "C72@3384L9:Box.kt#2w3rfo");
                                                if (($changed$iv & 11) != 2 && $composer4.getSkipping()) {
                                                    $composer4.skipToGroupEnd();
                                                } else {
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    $changed4 = ((48 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                                    $composer4.startReplaceableGroup(1815906203);
                                                    ComposerKt.sourceInformation($composer4, "C375@16478L45:BackdropScaffold.kt#jmzs0o");
                                                    if (($changed4 & 81) == 16 || !$composer4.getSkipping()) {
                                                        function35.invoke(backdropScaffoldState7.getSnackbarHostState(), $composer4, Integer.valueOf((i32 >> 18) & SdkConfig.SDK_VERSION));
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
                                                if (!ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        m4382constructorimpl = C0504Dp.m4382constructorimpl(0);
                                        Modifier modifier$iv2 = PaddingKt.m763paddingqDBjuR0$default(companion3, 0.0f, 0.0f, 0.0f, m4382constructorimpl, 7, null);
                                        Alignment contentAlignment$iv2 = Alignment.INSTANCE.getBottomCenter();
                                        Function3<SnackbarHostState, Composer, Integer, Unit> function352 = function34;
                                        BackdropScaffoldState backdropScaffoldState72 = backdropScaffoldState3;
                                        int i322 = i28;
                                        $composer4.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                        MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & SdkConfig.SDK_VERSION));
                                        int $changed$iv$iv2 = (48 << 3) & SdkConfig.SDK_VERSION;
                                        $composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity32 = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume32 = $composer4.consume(localDensity32);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        Density density$iv$iv2 = (Density) consume32;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume42 = $composer4.consume(localLayoutDirection2);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume42;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume52 = $composer4.consume(localViewConfiguration2);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume52;
                                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                        }
                                        $composer4.startReusableNode();
                                        if (!$composer4.getInserting()) {
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
                                        $composer4.startReplaceableGroup(-2137368960);
                                        ComposerKt.sourceInformation($composer4, "C72@3384L9:Box.kt#2w3rfo");
                                        if (($changed$iv & 11) != 2) {
                                        }
                                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                        $changed4 = ((48 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                        $composer4.startReplaceableGroup(1815906203);
                                        ComposerKt.sourceInformation($composer4, "C375@16478L45:BackdropScaffold.kt#jmzs0o");
                                        if (($changed4 & 81) == 16) {
                                        }
                                        function352.invoke(backdropScaffoldState72.getSnackbarHostState(), $composer4, Integer.valueOf((i322 >> 18) & SdkConfig.SDK_VERSION));
                                        $composer4.endReplaceableGroup();
                                        $composer4.endReplaceableGroup();
                                        $composer4.endReplaceableGroup();
                                        $composer4.endNode();
                                        $composer4.endReplaceableGroup();
                                        $composer4.endReplaceableGroup();
                                        if (!ComposerKt.isTraceInProgress()) {
                                        }
                                    } else {
                                        $composer4.skipToGroupEnd();
                                    }
                                }
                            }), $composer3, 3120);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }), $composer2, (($dirty13 << 6) & 896) | 1572864 | (($dirty13 << 6) & 7168), 51);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                persistentAppBar3 = persistentAppBar4;
                scaffoldState4 = scaffoldState6;
                gesturesEnabled3 = gesturesEnabled6;
                peekHeight4 = peekHeight3;
                headerHeight4 = headerHeight3;
                modifier3 = modifier2;
                stickyFrontLayer3 = stickyFrontLayer2;
                backLayerBackgroundColor3 = backLayerBackgroundColor2;
            }
            value$iv$iv = (Function1) new Function1<Constraints, Constraints>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Constraints invoke(Constraints constraints) {
                    return Constraints.m4326boximpl(m1243invokeZezNO4M(constraints.getValue()));
                }

                /* renamed from: invoke-ZezNO4M, reason: not valid java name */
                public final long m1243invokeZezNO4M(long it) {
                    long m4328copyZbe2FdA;
                    m4328copyZbe2FdA = Constraints.m4328copyZbe2FdA(it, (r12 & 1) != 0 ? Constraints.m4340getMinWidthimpl(it) : 0, (r12 & 2) != 0 ? Constraints.m4338getMaxWidthimpl(it) : 0, (r12 & 4) != 0 ? Constraints.m4339getMinHeightimpl(it) : 0, (r12 & 8) != 0 ? Constraints.m4337getMaxHeightimpl(it) : 0);
                    return ConstraintsKt.m4355offsetNN6EwU$default(m4328copyZbe2FdA, 0, -MathKt.roundToInt(headerHeightPx), 1, null);
                }
            };
            $composer2.updateRememberedValue(value$iv$iv);
            $composer2.endReplaceableGroup();
            final Function1<? super Constraints, Constraints> calculateBackLayerConstraints2 = (Function1) value$iv$iv;
            final Modifier modifier52 = modifier2;
            final boolean z22 = stickyFrontLayer2;
            final boolean z32 = gesturesEnabled2;
            final BackdropScaffoldState backdropScaffoldState22 = scaffoldState3;
            final int i252 = $dirty2;
            final Shape shape22 = frontLayerShape3;
            final long j4 = frontLayerBackgroundColor5;
            final long j22 = frontLayerContentColor3;
            final float f4 = frontLayerElevation3;
            final int i262 = $dirty13;
            final float f22 = headerHeight3;
            final float f32 = peekHeight3;
            final long j32 = frontLayerScrimColor2;
            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function332 = snackbarHost;
            BackdropScaffoldState scaffoldState62 = scaffoldState3;
            boolean gesturesEnabled62 = gesturesEnabled2;
            SurfaceKt.m1513SurfaceFjzlyU(null, null, backLayerBackgroundColor2, backLayerContentColor3, null, 0.0f, ComposableLambdaKt.composableLambda($composer2, -1049909631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1
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
                    Object value$iv$iv$iv;
                    ComposerKt.sourceInformation($composer3, "C297@13395L24,298@13428L3119:BackdropScaffold.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1049909631, $changed2, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:296)");
                        }
                        $composer3.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation($composer3, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                        Object it$iv$iv$iv = $composer3.rememberedValue();
                        if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                            $composer3.updateRememberedValue(value$iv$iv$iv);
                        } else {
                            value$iv$iv$iv = it$iv$iv$iv;
                        }
                        $composer3.endReplaceableGroup();
                        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                        final CoroutineScope scope = wrapper$iv.getCoroutineScope();
                        $composer3.endReplaceableGroup();
                        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.this, 0.0f, 1, null);
                        Function2<Composer, Integer, Unit> function2 = backLayer;
                        Function1<Constraints, Constraints> function1 = calculateBackLayerConstraints2;
                        final float f42 = headerHeightPx;
                        final boolean z4 = z22;
                        final boolean z5 = z32;
                        final BackdropScaffoldState backdropScaffoldState3 = backdropScaffoldState22;
                        final float f5 = peekHeightPx;
                        final int i27 = i252;
                        final Shape shape3 = shape22;
                        final long j42 = j4;
                        final long j5 = j22;
                        final float f6 = f4;
                        final int i28 = i262;
                        final float f7 = f22;
                        final float f8 = f32;
                        final Function2<? super Composer, ? super Integer, Unit> function22 = frontLayerContent;
                        final long j6 = j32;
                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34 = function332;
                        BackdropScaffoldKt.BackdropStack(fillMaxSize$default, function2, function1, ComposableLambdaKt.composableLambda($composer3, 1800047509, true, new Function4<Constraints, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(Constraints constraints, Float f9, Composer composer, Integer num) {
                                m1241invokejYbf7pk(constraints.getValue(), f9.floatValue(), composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:45:0x028d  */
                            /* JADX WARN: Removed duplicated region for block: B:48:0x0299  */
                            /* JADX WARN: Removed duplicated region for block: B:56:0x0372  */
                            /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
                            /* JADX WARN: Removed duplicated region for block: B:66:0x029d  */
                            /* renamed from: invoke-jYbf7pk, reason: not valid java name */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final void m1241invokejYbf7pk(long constraints, float backLayerHeight, Composer $composer4, int $changed3) {
                                float revealedHeight;
                                Modifier.Companion companion;
                                Modifier m1523swipeablepPrIpRY;
                                Object value$iv$iv2;
                                float m4382constructorimpl;
                                int $changed$iv;
                                int $changed4;
                                ComposerKt.sourceInformation($composer4, "CP(1:c#ui.unit.Constraints)344@15194L57,342@15132L942,366@16117L420:BackdropScaffold.kt#jmzs0o");
                                int $dirty4 = $changed3;
                                if (($changed3 & 14) == 0) {
                                    $dirty4 |= $composer4.changed(constraints) ? 4 : 2;
                                }
                                if (($changed3 & SdkConfig.SDK_VERSION) == 0) {
                                    $dirty4 |= $composer4.changed(backLayerHeight) ? 32 : 16;
                                }
                                if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1800047509, $changed3, -1, "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous> (BackdropScaffold.kt:302)");
                                    }
                                    float fullHeight = Constraints.m4337getMaxHeightimpl(constraints);
                                    float revealedHeight2 = fullHeight - f42;
                                    if (!z4) {
                                        revealedHeight = revealedHeight2;
                                    } else {
                                        revealedHeight = Math.min(revealedHeight2, backLayerHeight);
                                    }
                                    if (z5) {
                                        companion = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, backdropScaffoldState3.getNestedScrollConnection(), null, 2, null);
                                    } else {
                                        companion = Modifier.INSTANCE;
                                    }
                                    Modifier nestedScroll = companion;
                                    m1523swipeablepPrIpRY = SwipeableKt.m1523swipeablepPrIpRY(Modifier.INSTANCE.then(nestedScroll), backdropScaffoldState3, r19, Orientation.Vertical, (r26 & 8) != 0 ? true : z5, (r26 & 16) != 0 ? false : false, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function2
                                        public final FixedThreshold invoke(T t, T t2) {
                                            return new FixedThreshold(C0504Dp.m4382constructorimpl(56), null);
                                        }
                                    } : null, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, MapsKt.mapOf(TuplesKt.m294to(Float.valueOf(f5), BackdropValue.Concealed), TuplesKt.m294to(Float.valueOf(revealedHeight), BackdropValue.Revealed)).keySet(), 0.0f, 0.0f, 6, null) : null, (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1522getVelocityThresholdD9Ej5fM() : 0.0f);
                                    final BackdropScaffoldState backdropScaffoldState4 = backdropScaffoldState3;
                                    final CoroutineScope coroutineScope = scope;
                                    Modifier swipeable = SemanticsModifierKt.semantics$default(m1523swipeablepPrIpRY, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1
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
                                            if (BackdropScaffoldState.this.isConcealed()) {
                                                final BackdropScaffoldState backdropScaffoldState5 = BackdropScaffoldState.this;
                                                final CoroutineScope coroutineScope2 = coroutineScope;
                                                SemanticsPropertiesKt.collapse$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Boolean invoke() {
                                                        if (BackdropScaffoldState.this.getConfirmStateChange$material_release().invoke(BackdropValue.Revealed).booleanValue()) {
                                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(BackdropScaffoldState.this, null), 3, null);
                                                        }
                                                        return true;
                                                    }

                                                    /* compiled from: BackdropScaffold.kt */
                                                    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                                    @DebugMetadata(m296c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$1$1", m297f = "BackdropScaffold.kt", m298i = {}, m299l = {330}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                                    /* renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$1$1, reason: invalid class name */
                                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                        final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                        int label;

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        AnonymousClass1(BackdropScaffoldState backdropScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                                            super(2, continuation);
                                                            this.$scaffoldState = backdropScaffoldState;
                                                        }

                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                            return new AnonymousClass1(this.$scaffoldState, continuation);
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
                                                                    if (this.$scaffoldState.reveal(this) != coroutine_suspended) {
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
                                            } else {
                                                final BackdropScaffoldState backdropScaffoldState6 = BackdropScaffoldState.this;
                                                final CoroutineScope coroutineScope3 = coroutineScope;
                                                SemanticsPropertiesKt.expand$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Boolean invoke() {
                                                        if (BackdropScaffoldState.this.getConfirmStateChange$material_release().invoke(BackdropValue.Concealed).booleanValue()) {
                                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(BackdropScaffoldState.this, null), 3, null);
                                                        }
                                                        return true;
                                                    }

                                                    /* compiled from: BackdropScaffold.kt */
                                                    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                                    @DebugMetadata(m296c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$2$1", m297f = "BackdropScaffold.kt", m298i = {}, m299l = {336}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                                    /* renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$2$1, reason: invalid class name */
                                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                        final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                        int label;

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        AnonymousClass1(BackdropScaffoldState backdropScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                                            super(2, continuation);
                                                            this.$scaffoldState = backdropScaffoldState;
                                                        }

                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                            return new AnonymousClass1(this.$scaffoldState, continuation);
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
                                                                    if (this.$scaffoldState.conceal(this) != coroutine_suspended) {
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
                                    }, 1, null);
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    Object key1$iv2 = backdropScaffoldState3;
                                    final BackdropScaffoldState backdropScaffoldState5 = backdropScaffoldState3;
                                    int i29 = (i27 >> 12) & 14;
                                    $composer4.startReplaceableGroup(1157296644);
                                    ComposerKt.sourceInformation($composer4, "C(remember)P(1):Composables.kt#9igjgp");
                                    boolean invalid$iv$iv2 = $composer4.changed(key1$iv2);
                                    Object it$iv$iv2 = $composer4.rememberedValue();
                                    if (invalid$iv$iv2 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                                        value$iv$iv2 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$1$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                                return IntOffset.m4491boximpl(m1242invokeBjo55l4(density));
                                            }

                                            /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                            public final long m1242invokeBjo55l4(Density offset) {
                                                Intrinsics.checkNotNullParameter(offset, "$this$offset");
                                                return IntOffsetKt.IntOffset(0, MathKt.roundToInt(BackdropScaffoldState.this.getOffset().getValue().floatValue()));
                                            }
                                        };
                                        $composer4.updateRememberedValue(value$iv$iv2);
                                    } else {
                                        value$iv$iv2 = it$iv$iv2;
                                    }
                                    $composer4.endReplaceableGroup();
                                    Modifier then = OffsetKt.offset(companion2, (Function1) value$iv$iv2).then(swipeable);
                                    Shape shape4 = shape3;
                                    long j7 = j42;
                                    long j8 = j5;
                                    float f9 = f6;
                                    final float fullHeight2 = f8;
                                    final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
                                    final int i30 = i27;
                                    final long j9 = j6;
                                    final BackdropScaffoldState backdropScaffoldState6 = backdropScaffoldState3;
                                    final int i31 = i28;
                                    final boolean z6 = z5;
                                    final CoroutineScope coroutineScope2 = scope;
                                    SurfaceKt.m1513SurfaceFjzlyU(then, shape4, j7, j8, null, f9, ComposableLambdaKt.composableLambda($composer4, -1065299503, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackdropScaffold.1.1.2
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
                                            Composer $composer$iv;
                                            ComposerKt.sourceInformation($composer5, "C351@15517L543:BackdropScaffold.kt#jmzs0o");
                                            if (($changed5 & 11) != 2 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1065299503, $changed5, -1, "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:350)");
                                                }
                                                Modifier modifier$iv = PaddingKt.m763paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, fullHeight2, 7, null);
                                                Function2<Composer, Integer, Unit> function24 = function23;
                                                int i32 = i30;
                                                long j10 = j9;
                                                final BackdropScaffoldState backdropScaffoldState7 = backdropScaffoldState6;
                                                int i33 = i31;
                                                final boolean z7 = z6;
                                                final CoroutineScope coroutineScope3 = coroutineScope2;
                                                $composer5.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer5, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                                                int $changed$iv$iv = (0 << 3) & SdkConfig.SDK_VERSION;
                                                $composer5.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                                                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object consume3 = $composer5.consume(localDensity3);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                Density density$iv$iv = (Density) consume3;
                                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object consume4 = $composer5.consume(localLayoutDirection);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume4;
                                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object consume5 = $composer5.consume(localViewConfiguration);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume5;
                                                Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer5.startReusableNode();
                                                if ($composer5.getInserting()) {
                                                    $composer5.createNode(factory$iv$iv$iv);
                                                } else {
                                                    $composer5.useNode();
                                                }
                                                $composer5.disableReusing();
                                                Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer5);
                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                $composer5.enableReusing();
                                                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                                                $composer5.startReplaceableGroup(2058660585);
                                                int $changed$iv2 = ($changed$iv$iv$iv >> 9) & 14;
                                                $composer5.startReplaceableGroup(-2137368960);
                                                ComposerKt.sourceInformation($composer5, "C72@3384L9:Box.kt#2w3rfo");
                                                if (($changed$iv2 & 11) == 2 && $composer5.getSkipping()) {
                                                    $composer5.skipToGroupEnd();
                                                    $composer$iv = $composer5;
                                                } else {
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    int $changed6 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                                    $composer5.startReplaceableGroup(-1889954677);
                                                    ComposerKt.sourceInformation($composer5, "C352@15582L19,353@15622L420:BackdropScaffold.kt#jmzs0o");
                                                    if (($changed6 & 81) != 16 || !$composer5.getSkipping()) {
                                                        function24.invoke($composer5, Integer.valueOf((i32 >> 6) & 14));
                                                        $composer$iv = $composer5;
                                                        BackdropScaffoldKt.m1237Scrim3JVO9M(j10, new Function0<Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1
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
                                                                if (z7 && backdropScaffoldState7.getConfirmStateChange$material_release().invoke(BackdropValue.Concealed).booleanValue()) {
                                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C02861(backdropScaffoldState7, null), 3, null);
                                                                }
                                                            }

                                                            /* compiled from: BackdropScaffold.kt */
                                                            @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                                            @DebugMetadata(m296c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1$1", m297f = "BackdropScaffold.kt", m298i = {}, m299l = {358}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                                            /* renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1$1 */
                                                            static final class C02861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                                int label;

                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                C02861(BackdropScaffoldState backdropScaffoldState, Continuation<? super C02861> continuation) {
                                                                    super(2, continuation);
                                                                    this.$scaffoldState = backdropScaffoldState;
                                                                }

                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                    return new C02861(this.$scaffoldState, continuation);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function2
                                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                    return ((C02861) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                }

                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                public final Object invokeSuspend(Object $result) {
                                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                    switch (this.label) {
                                                                        case 0:
                                                                            ResultKt.throwOnFailure($result);
                                                                            this.label = 1;
                                                                            if (this.$scaffoldState.conceal(this) != coroutine_suspended) {
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
                                                        }, backdropScaffoldState7.getTargetValue() == BackdropValue.Revealed, $composer5, (i33 >> 18) & 14);
                                                    } else {
                                                        $composer5.skipToGroupEnd();
                                                        $composer$iv = $composer5;
                                                    }
                                                    $composer5.endReplaceableGroup();
                                                }
                                                $composer$iv.endReplaceableGroup();
                                                $composer5.endReplaceableGroup();
                                                $composer5.endNode();
                                                $composer5.endReplaceableGroup();
                                                $composer5.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer5.skipToGroupEnd();
                                        }
                                    }), $composer4, ((i28 >> 3) & SdkConfig.SDK_VERSION) | 1572864 | ((i28 >> 6) & 896) | ((i28 >> 6) & 7168) | ((i28 << 6) & 458752), 16);
                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                    if (backdropScaffoldState3.isRevealed()) {
                                        if (revealedHeight == fullHeight - f42) {
                                            m4382constructorimpl = f7;
                                            Modifier modifier$iv2 = PaddingKt.m763paddingqDBjuR0$default(companion3, 0.0f, 0.0f, 0.0f, m4382constructorimpl, 7, null);
                                            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getBottomCenter();
                                            Function3<SnackbarHostState, Composer, Integer, Unit> function352 = function34;
                                            BackdropScaffoldState backdropScaffoldState72 = backdropScaffoldState3;
                                            int i322 = i28;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & SdkConfig.SDK_VERSION));
                                            int $changed$iv$iv2 = (48 << 3) & SdkConfig.SDK_VERSION;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity32 = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object consume32 = $composer4.consume(localDensity32);
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            Density density$iv$iv2 = (Density) consume32;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object consume42 = $composer4.consume(localLayoutDirection2);
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume42;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object consume52 = $composer4.consume(localViewConfiguration2);
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume52;
                                            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
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
                                            $composer4.startReplaceableGroup(-2137368960);
                                            ComposerKt.sourceInformation($composer4, "C72@3384L9:Box.kt#2w3rfo");
                                            if (($changed$iv & 11) != 2 && $composer4.getSkipping()) {
                                                $composer4.skipToGroupEnd();
                                            } else {
                                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                                $changed4 = ((48 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                                $composer4.startReplaceableGroup(1815906203);
                                                ComposerKt.sourceInformation($composer4, "C375@16478L45:BackdropScaffold.kt#jmzs0o");
                                                if (($changed4 & 81) == 16 || !$composer4.getSkipping()) {
                                                    function352.invoke(backdropScaffoldState72.getSnackbarHostState(), $composer4, Integer.valueOf((i322 >> 18) & SdkConfig.SDK_VERSION));
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
                                            if (!ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    m4382constructorimpl = C0504Dp.m4382constructorimpl(0);
                                    Modifier modifier$iv22 = PaddingKt.m763paddingqDBjuR0$default(companion3, 0.0f, 0.0f, 0.0f, m4382constructorimpl, 7, null);
                                    Alignment contentAlignment$iv22 = Alignment.INSTANCE.getBottomCenter();
                                    Function3<SnackbarHostState, Composer, Integer, Unit> function3522 = function34;
                                    BackdropScaffoldState backdropScaffoldState722 = backdropScaffoldState3;
                                    int i3222 = i28;
                                    $composer4.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicy$iv22 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv22, false, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & SdkConfig.SDK_VERSION));
                                    int $changed$iv$iv22 = (48 << 3) & SdkConfig.SDK_VERSION;
                                    $composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    ProvidableCompositionLocal<Density> localDensity322 = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume322 = $composer4.consume(localDensity322);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    Density density$iv$iv22 = (Density) consume322;
                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22 = CompositionLocalsKt.getLocalLayoutDirection();
                                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume422 = $composer4.consume(localLayoutDirection22);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    LayoutDirection layoutDirection$iv$iv22 = (LayoutDirection) consume422;
                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration22 = CompositionLocalsKt.getLocalViewConfiguration();
                                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume522 = $composer4.consume(localViewConfiguration22);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ViewConfiguration viewConfiguration$iv$iv22 = (ViewConfiguration) consume522;
                                    Function0 factory$iv$iv$iv22 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3 skippableUpdate$iv$iv$iv22 = LayoutKt.materializerOf(modifier$iv22);
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
                                    $composer4.startReplaceableGroup(-2137368960);
                                    ComposerKt.sourceInformation($composer4, "C72@3384L9:Box.kt#2w3rfo");
                                    if (($changed$iv & 11) != 2) {
                                    }
                                    BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                                    $changed4 = ((48 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                    $composer4.startReplaceableGroup(1815906203);
                                    ComposerKt.sourceInformation($composer4, "C375@16478L45:BackdropScaffold.kt#jmzs0o");
                                    if (($changed4 & 81) == 16) {
                                    }
                                    function3522.invoke(backdropScaffoldState722.getSnackbarHostState(), $composer4, Integer.valueOf((i3222 >> 18) & SdkConfig.SDK_VERSION));
                                    $composer4.endReplaceableGroup();
                                    $composer4.endReplaceableGroup();
                                    $composer4.endReplaceableGroup();
                                    $composer4.endNode();
                                    $composer4.endReplaceableGroup();
                                    $composer4.endReplaceableGroup();
                                    if (!ComposerKt.isTraceInProgress()) {
                                    }
                                } else {
                                    $composer4.skipToGroupEnd();
                                }
                            }
                        }), $composer3, 3120);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, (($dirty13 << 6) & 896) | 1572864 | (($dirty13 << 6) & 7168), 51);
            if (ComposerKt.isTraceInProgress()) {
            }
            persistentAppBar3 = persistentAppBar4;
            scaffoldState4 = scaffoldState62;
            gesturesEnabled3 = gesturesEnabled62;
            peekHeight4 = peekHeight3;
            headerHeight4 = headerHeight3;
            modifier3 = modifier2;
            stickyFrontLayer3 = stickyFrontLayer2;
            backLayerBackgroundColor3 = backLayerBackgroundColor2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier3;
        final BackdropScaffoldState backdropScaffoldState3 = scaffoldState4;
        final boolean z4 = gesturesEnabled3;
        final float f5 = peekHeight4;
        final float f6 = headerHeight4;
        final boolean z5 = persistentAppBar3;
        final boolean z6 = stickyFrontLayer3;
        final long j5 = backLayerBackgroundColor3;
        final long j6 = backLayerContentColor3;
        final Shape shape3 = frontLayerShape3;
        final float f7 = frontLayerElevation3;
        final long j7 = frontLayerBackgroundColor5;
        final long j8 = frontLayerContentColor3;
        final long j9 = frontLayerScrimColor2;
        final Function3 function34 = snackbarHost;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2
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

            public final void invoke(Composer composer, int i27) {
                BackdropScaffoldKt.m1236BackdropScaffoldBZszfkY(appBar, backLayerContent, frontLayerContent, modifier6, backdropScaffoldState3, z4, f5, f6, z5, z6, j5, j6, shape3, f7, j7, j8, j9, function34, composer, $changed | 1, $changed1, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m1237Scrim3JVO9M(final long color, final Function0<Unit> function0, final boolean visible, Composer $composer, final int $changed) {
        Modifier.Companion dismissModifier;
        Composer $composer2 = $composer.startRestartGroup(-92141505);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(0:c#ui.graphics.Color)388@16708L121,401@17118L62,397@17009L171:BackdropScaffold.kt#jmzs0o");
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
                ComposerKt.traceEventStart(-92141505, $dirty2, -1, "androidx.compose.material.Scrim (BackdropScaffold.kt:382)");
            }
            if (color != Color.INSTANCE.m2032getUnspecified0d7_KjU()) {
                final State alpha$delegate = AnimateAsStateKt.animateFloatAsState(visible ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, $composer2, 0, 12);
                $composer2.startReplaceableGroup(1010547004);
                ComposerKt.sourceInformation($composer2, "393@16915L37");
                if (visible) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Unit unit = Unit.INSTANCE;
                    int i = (($dirty2 >> 3) & 14) | 64;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer2.changed(function0);
                    BackdropScaffoldKt$Scrim$dismissModifier$1$1 value$iv$iv = $composer2.rememberedValue();
                    if (invalid$iv$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = new BackdropScaffoldKt$Scrim$dismissModifier$1$1(function0, null);
                        $composer2.updateRememberedValue(value$iv$iv);
                    }
                    $composer2.endReplaceableGroup();
                    dismissModifier = SuspendingPointerInputFilterKt.pointerInput(companion, unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv);
                } else {
                    dismissModifier = Modifier.INSTANCE;
                }
                $composer2.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(dismissModifier);
                Object key1$iv = Color.m1986boximpl(color);
                int i2 = $dirty2 & 14;
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv2 = $composer2.changed(key1$iv) | $composer2.changed(alpha$delegate);
                Object value$iv$iv2 = $composer2.rememberedValue();
                if (!invalid$iv$iv2) {
                    Object key1$iv2 = Composer.INSTANCE.getEmpty();
                    if (value$iv$iv2 != key1$iv2) {
                        $composer2.endReplaceableGroup();
                        CanvasKt.Canvas(then, (Function1) value$iv$iv2, $composer2, 0);
                    }
                }
                value$iv$iv2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$Scrim$1$1
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
                        float m1238Scrim_3J_VO9M$lambda4;
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        long j = color;
                        m1238Scrim_3J_VO9M$lambda4 = BackdropScaffoldKt.m1238Scrim_3J_VO9M$lambda4(alpha$delegate);
                        DrawScope.m2485drawRectnJ9OG0$default(Canvas, j, 0L, 0L, m1238Scrim_3J_VO9M$lambda4, null, null, 0, 118, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv2);
                $composer2.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) value$iv$iv2, $composer2, 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$Scrim$2
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
                BackdropScaffoldKt.m1237Scrim3JVO9M(color, function0, visible, composer, $changed | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim_3J_VO9M$lambda-4, reason: not valid java name */
    public static final float m1238Scrim_3J_VO9M$lambda4(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BackLayerTransition(final BackdropValue target, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed) {
        Composer $composer2;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        Composer $composer3 = $composer.startRestartGroup(-950970976);
        ComposerKt.sourceInformation($composer3, "C(BackLayerTransition)P(2)421@17840L112,*424@18002L7,429@18176L486:BackdropScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(target) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer3.changed(function2) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(function24) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            function23 = function2;
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-950970976, $dirty2, -1, "androidx.compose.material.BackLayerTransition (BackdropScaffold.kt:414)");
            }
            State animationProgress$delegate = AnimateAsStateKt.animateFloatAsState(target == BackdropValue.Revealed ? 0.0f : 2.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, $composer3, 0, 12);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density $this$BackLayerTransition_u24lambda_u2d8 = (Density) consume;
            float animationSlideOffset = $this$BackLayerTransition_u24lambda_u2d8.mo648toPx0680j_4(AnimationSlideOffset);
            float f = 1;
            float appBarFloat = RangesKt.coerceIn(m1235BackLayerTransition$lambda7(animationProgress$delegate) - f, 0.0f, 1.0f);
            float contentFloat = RangesKt.coerceIn(f - m1235BackLayerTransition$lambda7(animationProgress$delegate), 0.0f, 1.0f);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Modifier modifier$iv = Modifier.INSTANCE;
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
            int $changed$iv$iv = (0 << 3) & SdkConfig.SDK_VERSION;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv = (Density) consume2;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer3.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer3);
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer3.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
            $composer3.startReplaceableGroup(2058660585);
            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
            $composer3.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation($composer3, "C72@3384L9:Box.kt#2w3rfo");
            if (($changed$iv & 11) == 2 && $composer3.getSkipping()) {
                $composer3.skipToGroupEnd();
                function23 = function2;
                function24 = function22;
                $composer2 = $composer3;
            } else {
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int $changed2 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                $composer3.startReplaceableGroup(2065804710);
                ComposerKt.sourceInformation($composer3, "C430@18190L226,438@18425L231:BackdropScaffold.kt#jmzs0o");
                if (($changed2 & 81) == 16 && $composer3.getSkipping()) {
                    $composer3.skipToGroupEnd();
                    function23 = function2;
                    function24 = function22;
                    $composer2 = $composer3;
                } else {
                    Modifier modifier$iv2 = GraphicsLayerModifierKt.m2133graphicsLayerpANQ8Wg$default(ZIndexModifierKt.zIndex(Modifier.INSTANCE, appBarFloat), 0.0f, 0.0f, appBarFloat, 0.0f, (f - appBarFloat) * animationSlideOffset, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 65515, null);
                    $composer3.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv2 = (0 << 3) & SdkConfig.SDK_VERSION;
                    $composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume5 = $composer3.consume(localDensity3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Density density$iv$iv2 = (Density) consume5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume6 = $composer3.consume(localLayoutDirection2);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume6;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume7 = $composer3.consume(localViewConfiguration2);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume7;
                    Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                    $composer2 = $composer3;
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        $composer3.createNode(factory$iv$iv$iv2);
                    } else {
                        $composer3.useNode();
                    }
                    $composer3.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer3);
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    $composer3.enableReusing();
                    skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                    $composer3.startReplaceableGroup(2058660585);
                    int $changed$iv2 = ($changed$iv$iv$iv2 >> 9) & 14;
                    $composer3.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer3, "C72@3384L9:Box.kt#2w3rfo");
                    if (($changed$iv2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        function23 = function2;
                    } else {
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        int $changed3 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        $composer3.startReplaceableGroup(-1057690836);
                        ComposerKt.sourceInformation($composer3, "C436@18398L8:BackdropScaffold.kt#jmzs0o");
                        if (($changed3 & 81) == 16 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                            function23 = function2;
                        } else {
                            function23 = function2;
                            function23.invoke($composer3, Integer.valueOf(($dirty2 >> 3) & 14));
                        }
                        $composer3.endReplaceableGroup();
                    }
                    $composer3.endReplaceableGroup();
                    $composer3.endReplaceableGroup();
                    $composer3.endNode();
                    $composer3.endReplaceableGroup();
                    $composer3.endReplaceableGroup();
                    Modifier modifier$iv3 = GraphicsLayerModifierKt.m2133graphicsLayerpANQ8Wg$default(ZIndexModifierKt.zIndex(Modifier.INSTANCE, contentFloat), 0.0f, 0.0f, contentFloat, 0.0f, (f - contentFloat) * (-animationSlideOffset), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 65515, null);
                    $composer3.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv3, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv3 = (0 << 3) & SdkConfig.SDK_VERSION;
                    $composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume8 = $composer3.consume(localDensity4);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Density density$iv$iv3 = (Density) consume8;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume9 = $composer3.consume(localLayoutDirection3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume9;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume10 = $composer3.consume(localViewConfiguration3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume10;
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
                        function24 = function22;
                    } else {
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        int $changed4 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        $composer3.startReplaceableGroup(-676544093);
                        ComposerKt.sourceInformation($composer3, "C444@18637L9:BackdropScaffold.kt#jmzs0o");
                        if (($changed4 & 81) == 16 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                            function24 = function22;
                        } else {
                            function24 = function22;
                            function24.invoke($composer3, Integer.valueOf(($dirty2 >> 6) & 14));
                        }
                        $composer3.endReplaceableGroup();
                    }
                    $composer3.endReplaceableGroup();
                    $composer3.endReplaceableGroup();
                    $composer3.endNode();
                    $composer3.endReplaceableGroup();
                    $composer3.endReplaceableGroup();
                }
                $composer3.endReplaceableGroup();
            }
            $composer3.endReplaceableGroup();
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$2
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
                BackdropScaffoldKt.BackLayerTransition(BackdropValue.this, function23, function24, composer, $changed | 1);
            }
        });
    }

    /* renamed from: BackLayerTransition$lambda-7, reason: not valid java name */
    private static final float m1235BackLayerTransition$lambda7(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BackdropStack(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function1<? super Constraints, Constraints> function1, final Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1248995194);
        ComposerKt.sourceInformation($composer2, "C(BackdropStack)P(3)457@18967L890,457@18940L917:BackdropScaffold.kt#jmzs0o");
        final int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(function2) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(function1) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(function4) ? 2048 : 1024;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1248995194, $dirty, -1, "androidx.compose.material.BackdropStack (BackdropScaffold.kt:451)");
            }
            int i = (($dirty >> 3) & 14) | (($dirty >> 3) & SdkConfig.SDK_VERSION) | (($dirty >> 3) & 896);
            $composer2.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(function2) | $composer2.changed(function1) | $composer2.changed(function4);
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1244invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1244invoke0kLqBqw(SubcomposeMeasureScope SubcomposeLayout, final long constraints) {
                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                        final Placeable backLayerPlaceable = ((Measurable) CollectionsKt.first((List) SubcomposeLayout.subcompose(BackdropLayers.Back, function2))).mo3492measureBRTryo0(function1.invoke(Constraints.m4326boximpl(constraints)).getValue());
                        final float backLayerHeight = backLayerPlaceable.getHeight();
                        BackdropLayers backdropLayers = BackdropLayers.Front;
                        final Function4<Constraints, Float, Composer, Integer, Unit> function42 = function4;
                        final int i2 = $dirty;
                        List $this$fastMap$iv = SubcomposeLayout.subcompose(backdropLayers, ComposableLambdaKt.composableLambdaInstance(-1222642649, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1$placeables$1
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
                                ComposerKt.sourceInformation($composer3, "C466@19305L40:BackdropScaffold.kt#jmzs0o");
                                if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                                    $composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1222642649, $changed2, -1, "androidx.compose.material.BackdropStack.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:465)");
                                }
                                function42.invoke(Constraints.m4326boximpl(constraints), Float.valueOf(backLayerHeight), $composer3, Integer.valueOf((i2 >> 3) & 896));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        List target$iv = new ArrayList($this$fastMap$iv.size());
                        int index$iv$iv = 0;
                        int size = $this$fastMap$iv.size();
                        while (index$iv$iv < size) {
                            Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
                            target$iv.add(((Measurable) item$iv$iv).mo3492measureBRTryo0(constraints));
                            index$iv$iv++;
                            backLayerHeight = backLayerHeight;
                            $this$fastMap$iv = $this$fastMap$iv;
                        }
                        final List placeables = target$iv;
                        int maxWidth = Math.max(Constraints.m4340getMinWidthimpl(constraints), backLayerPlaceable.getWidth());
                        int maxHeight = Math.max(Constraints.m4339getMinHeightimpl(constraints), backLayerPlaceable.getHeight());
                        int size2 = placeables.size();
                        for (int index$iv = 0; index$iv < size2; index$iv++) {
                            Object item$iv = placeables.get(index$iv);
                            Placeable it = (Placeable) item$iv;
                            maxWidth = Math.max(maxWidth, it.getWidth());
                            maxHeight = Math.max(maxHeight, it.getHeight());
                        }
                        return MeasureScope.layout$default(SubcomposeLayout, maxWidth, maxHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1.2
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
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                Placeable.PlacementScope.placeRelative$default(layout, Placeable.this, 0, 0, 0.0f, 4, null);
                                List $this$fastForEach$iv = placeables;
                                int size3 = $this$fastForEach$iv.size();
                                for (int index$iv2 = 0; index$iv2 < size3; index$iv2++) {
                                    Object item$iv2 = $this$fastForEach$iv.get(index$iv2);
                                    Placeable it2 = (Placeable) item$iv2;
                                    Placeable.PlacementScope.placeRelative$default(layout, it2, 0, 0, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier, (Function2) value$iv$iv, $composer2, $dirty & 14, 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$2
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
                BackdropScaffoldKt.BackdropStack(Modifier.this, function2, function1, function4, composer, $changed | 1);
            }
        });
    }
}
