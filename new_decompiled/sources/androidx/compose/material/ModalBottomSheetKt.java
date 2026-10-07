package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
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
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.OnGloballyPositionedModifierKt;
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
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ModalBottomSheet.kt */
@Metadata(m286d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u001a\u008c\u0001\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a3\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a;\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001b0\u0003H\u0007¢\u0006\u0002\u0010%\u001aC\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010&\u001a\u00020\u001b2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001b0\u0003H\u0007¢\u0006\u0002\u0010'\u001a,\u0010(\u001a\u00020\b*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010)\u001a\u00020#2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0+H\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006,"}, m287d2 = {"ModalBottomSheetLayout", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material/ModalBottomSheetState;", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "Landroidx/compose/ui/unit/Dp;", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "scrimColor", "content", "Lkotlin/Function0;", "ModalBottomSheetLayout-BzaUkTc", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ModalBottomSheetState;Landroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "color", "onDismiss", "visible", "", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberModalBottomSheetState", "initialValue", "Landroidx/compose/material/ModalBottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "skipHalfExpanded", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "bottomSheetSwipeable", "fullHeight", "sheetHeightState", "Landroidx/compose/runtime/State;", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ModalBottomSheetKt {
    @ExperimentalMaterialApi
    public static final ModalBottomSheetState rememberModalBottomSheetState(final ModalBottomSheetValue initialValue, final AnimationSpec<Float> animationSpec, final boolean skipHalfExpanded, final Function1<? super ModalBottomSheetValue, Boolean> function1, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(-409288536);
        ComposerKt.sourceInformation($composer, "C(rememberModalBottomSheetState)P(2!1,3)245@9606L533:ModalBottomSheet.kt#jmzs0o");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
            animationSpec = animationSpec2;
        }
        if ((i & 8) != 0) {
            Function1 confirmStateChange = new Function1<ModalBottomSheetValue, Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ModalBottomSheetValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-409288536, $changed, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:239)");
        }
        ModalBottomSheetState modalBottomSheetState = (ModalBottomSheetState) RememberSaveableKt.m1652rememberSaveable(new Object[]{initialValue, animationSpec, Boolean.valueOf(skipHalfExpanded), function1}, (Saver) ModalBottomSheetState.INSTANCE.Saver(animationSpec, skipHalfExpanded, function1), (String) null, (Function0) new Function0<ModalBottomSheetState>() { // from class: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ModalBottomSheetState invoke() {
                return new ModalBottomSheetState(ModalBottomSheetValue.this, animationSpec, skipHalfExpanded, function1);
            }
        }, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return modalBottomSheetState;
    }

    @ExperimentalMaterialApi
    public static final ModalBottomSheetState rememberModalBottomSheetState(ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> function1, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(-1928569212);
        ComposerKt.sourceInformation($composer, "C(rememberModalBottomSheetState)P(2)275@10738L174:ModalBottomSheet.kt#jmzs0o");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
            animationSpec = animationSpec2;
        }
        if ((i & 4) != 0) {
            Function1 confirmStateChange = new Function1<ModalBottomSheetValue, Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$3
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ModalBottomSheetValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1928569212, $changed, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:271)");
        }
        ModalBottomSheetState rememberModalBottomSheetState = rememberModalBottomSheetState(initialValue, animationSpec, false, function1, $composer, ($changed & 14) | 448 | (($changed << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberModalBottomSheetState;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x018d  */
    @ExperimentalMaterialApi
    /* renamed from: ModalBottomSheetLayout-BzaUkTc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1430ModalBottomSheetLayoutBzaUkTc(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> sheetContent, Modifier modifier, ModalBottomSheetState sheetState, Shape sheetShape, float sheetElevation, long sheetBackgroundColor, long sheetContentColor, long scrimColor, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Shape shape;
        float f;
        long j;
        long j2;
        int $dirty;
        Modifier modifier2;
        ModalBottomSheetState sheetState2;
        CornerBasedShape sheetShape2;
        long sheetBackgroundColor2;
        long sheetContentColor2;
        long scrimColor2;
        int $dirty2;
        ModalBottomSheetState sheetState3;
        Shape sheetShape3;
        float sheetElevation2;
        long sheetBackgroundColor3;
        long sheetContentColor3;
        Object it$iv$iv$iv;
        Object value$iv$iv$iv;
        Composer $composer2;
        ScopeUpdateScope endRestartGroup;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(sheetContent, "sheetContent");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(-1633763156);
        ComposerKt.sourceInformation($composer3, "C(ModalBottomSheetLayout)P(4,1,8,7,6:c#ui.unit.Dp,3:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color)316@12777L37,317@12854L6,319@12977L6,320@13024L37,321@13112L10,324@13180L24,325@13209L2723:ModalBottomSheet.kt#jmzs0o");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changed(sheetContent) ? 4 : 2;
        }
        int i8 = i & 2;
        if (i8 != 0) {
            $dirty3 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0 && $composer3.changed(sheetState)) {
                i7 = 256;
                $dirty3 |= i7;
            }
            i7 = 128;
            $dirty3 |= i7;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                shape = sheetShape;
                if ($composer3.changed(shape)) {
                    i6 = 2048;
                    $dirty3 |= i6;
                }
            } else {
                shape = sheetShape;
            }
            i6 = 1024;
            $dirty3 |= i6;
        } else {
            shape = sheetShape;
        }
        int i9 = i & 16;
        if (i9 != 0) {
            $dirty3 |= 24576;
            f = sheetElevation;
        } else if ((57344 & $changed) == 0) {
            f = sheetElevation;
            $dirty3 |= $composer3.changed(f) ? 16384 : 8192;
        } else {
            f = sheetElevation;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0 && $composer3.changed(sheetBackgroundColor)) {
                i5 = 131072;
                $dirty3 |= i5;
            }
            i5 = 65536;
            $dirty3 |= i5;
        }
        if ((3670016 & $changed) == 0) {
            if ((i & 64) == 0) {
                j = sheetContentColor;
                if ($composer3.changed(j)) {
                    i4 = 1048576;
                    $dirty3 |= i4;
                }
            } else {
                j = sheetContentColor;
            }
            i4 = 524288;
            $dirty3 |= i4;
        } else {
            j = sheetContentColor;
        }
        if ((29360128 & $changed) == 0) {
            if ((i & 128) == 0) {
                j2 = scrimColor;
                if ($composer3.changed(j2)) {
                    i3 = 8388608;
                    $dirty3 |= i3;
                }
            } else {
                j2 = scrimColor;
            }
            i3 = 4194304;
            $dirty3 |= i3;
        } else {
            j2 = scrimColor;
        }
        if ((i & 256) == 0) {
            i2 = (234881024 & $changed) == 0 ? $composer3.changed(content) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432 : 100663296;
            $dirty = $dirty3;
            if ((191739611 & $dirty) == 38347922 || !$composer3.getSkipping()) {
                $composer3.startDefaults();
                if (($changed & 1) != 0 || $composer3.getDefaultsInvalid()) {
                    modifier2 = i8 == 0 ? Modifier.INSTANCE : modifier;
                    if ((i & 4) == 0) {
                        sheetState2 = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, null, null, $composer3, 6, 6);
                        $dirty &= -897;
                    } else {
                        sheetState2 = sheetState;
                    }
                    if ((i & 8) == 0) {
                        sheetShape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getLarge();
                        $dirty &= -7169;
                    } else {
                        sheetShape2 = shape;
                    }
                    float sheetElevation3 = i9 == 0 ? ModalBottomSheetDefaults.INSTANCE.m1429getElevationD9Ej5fM() : f;
                    if ((i & 32) == 0) {
                        sheetBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1321getSurface0d7_KjU();
                        $dirty &= -458753;
                    } else {
                        sheetBackgroundColor2 = sheetBackgroundColor;
                    }
                    if ((i & 64) == 0) {
                        sheetContentColor2 = ColorsKt.m1335contentColorForek8zF_U(sheetBackgroundColor2, $composer3, ($dirty >> 15) & 14);
                        $dirty &= -3670017;
                    } else {
                        sheetContentColor2 = sheetContentColor;
                    }
                    if ((i & 128) == 0) {
                        $dirty2 = $dirty & (-29360129);
                        sheetState3 = sheetState2;
                        sheetBackgroundColor3 = sheetBackgroundColor2;
                        sheetContentColor3 = sheetContentColor2;
                        scrimColor2 = ModalBottomSheetDefaults.INSTANCE.getScrimColor($composer3, 6);
                        sheetShape3 = sheetShape2;
                        sheetElevation2 = sheetElevation3;
                    } else {
                        scrimColor2 = scrimColor;
                        $dirty2 = $dirty;
                        sheetState3 = sheetState2;
                        sheetShape3 = sheetShape2;
                        sheetElevation2 = sheetElevation3;
                        sheetBackgroundColor3 = sheetBackgroundColor2;
                        sheetContentColor3 = sheetContentColor2;
                    }
                } else {
                    $composer3.skipToGroupEnd();
                    if ((i & 4) != 0) {
                        $dirty &= -897;
                    }
                    if ((i & 8) != 0) {
                        $dirty &= -7169;
                    }
                    if ((i & 32) != 0) {
                        $dirty &= -458753;
                    }
                    if ((i & 64) != 0) {
                        $dirty &= -3670017;
                    }
                    if ((i & 128) != 0) {
                        $dirty &= -29360129;
                    }
                    modifier2 = modifier;
                    sheetState3 = sheetState;
                    sheetBackgroundColor3 = sheetBackgroundColor;
                    $dirty2 = $dirty;
                    scrimColor2 = j2;
                    sheetContentColor3 = j;
                    sheetShape3 = shape;
                    sheetElevation2 = f;
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1633763156, $dirty2, -1, "androidx.compose.material.ModalBottomSheetLayout (ModalBottomSheet.kt:312)");
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
                final ModalBottomSheetState modalBottomSheetState = sheetState3;
                final int i10 = $dirty2;
                final Shape shape2 = sheetShape3;
                final long j3 = sheetBackgroundColor3;
                final long j4 = sheetContentColor3;
                final float f2 = sheetElevation2;
                $composer2 = $composer3;
                final long j5 = scrimColor2;
                BoxWithConstraintsKt.BoxWithConstraints(modifier2, null, false, ComposableLambdaKt.composableLambda($composer2, 1607356310, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1
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
                        Object value$iv$iv;
                        final float fullHeight;
                        Object value$iv$iv2;
                        Modifier bottomSheetSwipeable;
                        Object value$iv$iv3;
                        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                        ComposerKt.sourceInformation($composer4, "C327@13328L41,328@13378L384,344@13922L434,355@14475L89,340@13771L2155:ModalBottomSheet.kt#jmzs0o");
                        int $dirty4 = $changed2;
                        if (($changed2 & 14) == 0) {
                            $dirty4 |= $composer4.changed(BoxWithConstraints) ? 4 : 2;
                        }
                        if (($dirty4 & 91) != 18 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1607356310, $changed2, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous> (ModalBottomSheet.kt:325)");
                            }
                            float fullHeight2 = Constraints.m4337getMaxHeightimpl(BoxWithConstraints.getConstraints());
                            $composer4.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation($composer4, "C(remember):Composables.kt#9igjgp");
                            Object it$iv$iv = $composer4.rememberedValue();
                            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                $composer4.updateRememberedValue(value$iv$iv);
                            } else {
                                value$iv$iv = it$iv$iv;
                            }
                            $composer4.endReplaceableGroup();
                            final MutableState sheetHeightState = (MutableState) value$iv$iv;
                            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Function2<Composer, Integer, Unit> function2 = content;
                            int i11 = i10;
                            long j6 = j5;
                            final ModalBottomSheetState modalBottomSheetState2 = ModalBottomSheetState.this;
                            final CoroutineScope coroutineScope = scope;
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
                                $composer4.startReplaceableGroup(-402723888);
                                ComposerKt.sourceInformation($composer4, "C329@13420L9,330@13442L310:ModalBottomSheet.kt#jmzs0o");
                                if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                                    function2.invoke($composer4, Integer.valueOf((i11 >> 24) & 14));
                                    ModalBottomSheetKt.m1431Scrim3JVO9M(j6, new Function0<Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1
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
                                            if (ModalBottomSheetState.this.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C03301(ModalBottomSheetState.this, null), 3, null);
                                            }
                                        }

                                        /* compiled from: ModalBottomSheet.kt */
                                        @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                        @DebugMetadata(m296c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1", m297f = "ModalBottomSheet.kt", m298i = {}, m299l = {335}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                        /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1 */
                                        static final class C03301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ ModalBottomSheetState $sheetState;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            C03301(ModalBottomSheetState modalBottomSheetState, Continuation<? super C03301> continuation) {
                                                super(2, continuation);
                                                this.$sheetState = modalBottomSheetState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                return new C03301(this.$sheetState, continuation);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                return ((C03301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Object invokeSuspend(Object $result) {
                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                switch (this.label) {
                                                    case 0:
                                                        ResultKt.throwOnFailure($result);
                                                        this.label = 1;
                                                        if (this.$sheetState.hide(this) != coroutine_suspended) {
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
                                    }, modalBottomSheetState2.getTargetValue() != ModalBottomSheetValue.Hidden, $composer4, (i11 >> 21) & 14);
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
                            Modifier nestedScroll$default = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ModalBottomSheetState.this.getNestedScrollConnection(), null, 2, null);
                            Object key1$iv = ModalBottomSheetState.this;
                            Object key2$iv = Float.valueOf(fullHeight2);
                            final ModalBottomSheetState modalBottomSheetState3 = ModalBottomSheetState.this;
                            int i12 = (i10 >> 6) & 14;
                            $composer4.startReplaceableGroup(511388516);
                            ComposerKt.sourceInformation($composer4, "C(remember)P(1,2):Composables.kt#9igjgp");
                            boolean invalid$iv$iv = $composer4.changed(key1$iv) | $composer4.changed(key2$iv);
                            Object it$iv$iv2 = $composer4.rememberedValue();
                            if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                                fullHeight = fullHeight2;
                                value$iv$iv2 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                        return IntOffset.m4491boximpl(m1435invokeBjo55l4(density));
                                    }

                                    /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                    public final long m1435invokeBjo55l4(Density offset) {
                                        int y;
                                        Intrinsics.checkNotNullParameter(offset, "$this$offset");
                                        if (ModalBottomSheetState.this.getAnchors$material_release().isEmpty()) {
                                            y = MathKt.roundToInt(fullHeight);
                                        } else {
                                            y = MathKt.roundToInt(ModalBottomSheetState.this.getOffset().getValue().floatValue());
                                        }
                                        return IntOffsetKt.IntOffset(0, y);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv$iv2);
                            } else {
                                value$iv$iv2 = it$iv$iv2;
                                fullHeight = fullHeight2;
                            }
                            $composer4.endReplaceableGroup();
                            bottomSheetSwipeable = ModalBottomSheetKt.bottomSheetSwipeable(OffsetKt.offset(nestedScroll$default, (Function1) value$iv$iv2), ModalBottomSheetState.this, fullHeight, sheetHeightState);
                            $composer4.startReplaceableGroup(1157296644);
                            ComposerKt.sourceInformation($composer4, "C(remember)P(1):Composables.kt#9igjgp");
                            boolean invalid$iv$iv2 = $composer4.changed(sheetHeightState);
                            Object it$iv$iv3 = $composer4.rememberedValue();
                            if (invalid$iv$iv2 || it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                                value$iv$iv3 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                        invoke2(layoutCoordinates);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(LayoutCoordinates it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        sheetHeightState.setValue(Float.valueOf(IntSize.m4541getHeightimpl(it.mo3497getSizeYbymL2g())));
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv$iv3);
                            } else {
                                value$iv$iv3 = it$iv$iv3;
                            }
                            $composer4.endReplaceableGroup();
                            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(bottomSheetSwipeable, (Function1) value$iv$iv3);
                            final ModalBottomSheetState modalBottomSheetState4 = ModalBottomSheetState.this;
                            final CoroutineScope coroutineScope2 = scope;
                            Modifier semantics$default = SemanticsModifierKt.semantics$default(onGloballyPositioned, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1.4
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
                                    if (ModalBottomSheetState.this.isVisible()) {
                                        final ModalBottomSheetState modalBottomSheetState5 = ModalBottomSheetState.this;
                                        final CoroutineScope coroutineScope3 = coroutineScope2;
                                        SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.1.4.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                if (ModalBottomSheetState.this.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C16751(ModalBottomSheetState.this, null), 3, null);
                                                }
                                                return true;
                                            }

                                            /* compiled from: ModalBottomSheet.kt */
                                            @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                            @DebugMetadata(m296c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$1$1", m297f = "ModalBottomSheet.kt", m298i = {}, m299l = {363}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                            /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$1$1, reason: invalid class name and collision with other inner class name */
                                            static final class C16751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ ModalBottomSheetState $sheetState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                C16751(ModalBottomSheetState modalBottomSheetState, Continuation<? super C16751> continuation) {
                                                    super(2, continuation);
                                                    this.$sheetState = modalBottomSheetState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new C16751(this.$sheetState, continuation);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                    return ((C16751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object $result) {
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    switch (this.label) {
                                                        case 0:
                                                            ResultKt.throwOnFailure($result);
                                                            this.label = 1;
                                                            if (this.$sheetState.hide(this) != coroutine_suspended) {
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
                                        if (ModalBottomSheetState.this.getCurrentValue() == ModalBottomSheetValue.HalfExpanded) {
                                            final ModalBottomSheetState modalBottomSheetState6 = ModalBottomSheetState.this;
                                            final CoroutineScope coroutineScope4 = coroutineScope2;
                                            SemanticsPropertiesKt.expand$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.1.4.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    if (ModalBottomSheetState.this.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.Expanded).booleanValue()) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, null, new AnonymousClass1(ModalBottomSheetState.this, null), 3, null);
                                                    }
                                                    return true;
                                                }

                                                /* compiled from: ModalBottomSheet.kt */
                                                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                                @DebugMetadata(m296c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$2$1", m297f = "ModalBottomSheet.kt", m298i = {}, m299l = {370}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                                /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$2$1, reason: invalid class name */
                                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ ModalBottomSheetState $sheetState;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                                        super(2, continuation);
                                                        this.$sheetState = modalBottomSheetState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new AnonymousClass1(this.$sheetState, continuation);
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
                                                                if (this.$sheetState.expand$material_release(this) != coroutine_suspended) {
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
                                        } else if (ModalBottomSheetState.this.getHasHalfExpandedState$material_release()) {
                                            final ModalBottomSheetState modalBottomSheetState7 = ModalBottomSheetState.this;
                                            final CoroutineScope coroutineScope5 = coroutineScope2;
                                            SemanticsPropertiesKt.collapse$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.1.4.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    if (ModalBottomSheetState.this.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.HalfExpanded).booleanValue()) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope5, null, null, new AnonymousClass1(ModalBottomSheetState.this, null), 3, null);
                                                    }
                                                    return true;
                                                }

                                                /* compiled from: ModalBottomSheet.kt */
                                                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                                @DebugMetadata(m296c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$3$1", m297f = "ModalBottomSheet.kt", m298i = {}, m299l = {377}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                                /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$3$1, reason: invalid class name */
                                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ ModalBottomSheetState $sheetState;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                                        super(2, continuation);
                                                        this.$sheetState = modalBottomSheetState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new AnonymousClass1(this.$sheetState, continuation);
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
                                                                if (this.$sheetState.halfExpand$material_release(this) != coroutine_suspended) {
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
                                }
                            }, 1, null);
                            Shape shape3 = shape2;
                            long j7 = j3;
                            long j8 = j4;
                            float f3 = f2;
                            final Function3<ColumnScope, Composer, Integer, Unit> function3 = sheetContent;
                            final int i13 = i10;
                            SurfaceKt.m1513SurfaceFjzlyU(semantics$default, shape3, j7, j8, null, f3, ComposableLambdaKt.composableLambda($composer4, -1793508390, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1.5
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
                                    ComposerKt.sourceInformation($composer5, "C388@15886L30:ModalBottomSheet.kt#jmzs0o");
                                    if (($changed4 & 11) == 2 && $composer5.getSkipping()) {
                                        $composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1793508390, $changed4, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous>.<anonymous> (ModalBottomSheet.kt:387)");
                                    }
                                    Function3 content$iv = function3;
                                    int $changed$iv2 = (i13 << 9) & 7168;
                                    $composer5.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation($composer5, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                    Modifier modifier$iv2 = Modifier.INSTANCE;
                                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                    Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                    MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer5, (($changed$iv2 >> 3) & 14) | (($changed$iv2 >> 3) & SdkConfig.SDK_VERSION));
                                    int $changed$iv$iv2 = ($changed$iv2 << 3) & SdkConfig.SDK_VERSION;
                                    $composer5.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation($composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume4 = $composer5.consume(localDensity2);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    Density density$iv$iv2 = (Density) consume4;
                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                    ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume5 = $composer5.consume(localLayoutDirection2);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                    ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume6 = $composer5.consume(localViewConfiguration2);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                                    Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                                    if (!($composer5.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer5.startReusableNode();
                                    if ($composer5.getInserting()) {
                                        $composer5.createNode(factory$iv$iv$iv2);
                                    } else {
                                        $composer5.useNode();
                                    }
                                    $composer5.disableReusing();
                                    Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer5);
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                    $composer5.enableReusing();
                                    skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                                    $composer5.startReplaceableGroup(2058660585);
                                    $composer5.startReplaceableGroup(-1163856341);
                                    ComposerKt.sourceInformation($composer5, "C79@3994L9:Column.kt#2w3rfo");
                                    if ((($changed$iv$iv$iv2 >> 9) & 14 & 11) == 2 && $composer5.getSkipping()) {
                                        $composer5.skipToGroupEnd();
                                    } else {
                                        content$iv.invoke(ColumnScopeInstance.INSTANCE, $composer5, Integer.valueOf((($changed$iv2 >> 6) & SdkConfig.SDK_VERSION) | 6));
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
                            }), $composer4, ((i10 >> 6) & SdkConfig.SDK_VERSION) | 1572864 | ((i10 >> 9) & 896) | ((i10 >> 9) & 7168) | ((i10 << 3) & 458752), 16);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }), $composer2, (($dirty2 >> 3) & 14) | 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer3.skipToGroupEnd();
                modifier2 = modifier;
                sheetState3 = sheetState;
                sheetBackgroundColor3 = sheetBackgroundColor;
                scrimColor2 = j2;
                sheetContentColor3 = j;
                sheetShape3 = shape;
                $composer2 = $composer3;
                sheetElevation2 = f;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Modifier modifier3 = modifier2;
            final ModalBottomSheetState modalBottomSheetState2 = sheetState3;
            final Shape shape3 = sheetShape3;
            final float f3 = sheetElevation2;
            final long j6 = sheetBackgroundColor3;
            final long j7 = sheetContentColor3;
            final long j8 = scrimColor2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2
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
                    ModalBottomSheetKt.m1430ModalBottomSheetLayoutBzaUkTc(sheetContent, modifier3, modalBottomSheetState2, shape3, f3, j6, j7, j8, content, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty3 |= i2;
        $dirty = $dirty3;
        if ((191739611 & $dirty) == 38347922) {
        }
        $composer3.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if ((i & 4) == 0) {
        }
        if ((i & 8) == 0) {
        }
        if (i9 == 0) {
        }
        if ((i & 32) == 0) {
        }
        if ((i & 64) == 0) {
        }
        if ((i & 128) == 0) {
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
        final ModalBottomSheetState modalBottomSheetState3 = sheetState3;
        final int i102 = $dirty2;
        final Shape shape22 = sheetShape3;
        final long j32 = sheetBackgroundColor3;
        final long j42 = sheetContentColor3;
        final float f22 = sheetElevation2;
        $composer2 = $composer3;
        final long j52 = scrimColor2;
        BoxWithConstraintsKt.BoxWithConstraints(modifier2, null, false, ComposableLambdaKt.composableLambda($composer2, 1607356310, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1
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
                Object value$iv$iv;
                final float fullHeight;
                Object value$iv$iv2;
                Modifier bottomSheetSwipeable;
                Object value$iv$iv3;
                Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                ComposerKt.sourceInformation($composer4, "C327@13328L41,328@13378L384,344@13922L434,355@14475L89,340@13771L2155:ModalBottomSheet.kt#jmzs0o");
                int $dirty4 = $changed2;
                if (($changed2 & 14) == 0) {
                    $dirty4 |= $composer4.changed(BoxWithConstraints) ? 4 : 2;
                }
                if (($dirty4 & 91) != 18 || !$composer4.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1607356310, $changed2, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous> (ModalBottomSheet.kt:325)");
                    }
                    float fullHeight2 = Constraints.m4337getMaxHeightimpl(BoxWithConstraints.getConstraints());
                    $composer4.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer4, "C(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer4.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        $composer4.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer4.endReplaceableGroup();
                    final MutableState<Float> sheetHeightState = (MutableState) value$iv$iv;
                    Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Function2<Composer, Integer, Unit> function2 = content;
                    int i11 = i102;
                    long j62 = j52;
                    final ModalBottomSheetState modalBottomSheetState22 = ModalBottomSheetState.this;
                    final CoroutineScope coroutineScope = scope2;
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
                        $composer4.startReplaceableGroup(-402723888);
                        ComposerKt.sourceInformation($composer4, "C329@13420L9,330@13442L310:ModalBottomSheet.kt#jmzs0o");
                        if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                            function2.invoke($composer4, Integer.valueOf((i11 >> 24) & 14));
                            ModalBottomSheetKt.m1431Scrim3JVO9M(j62, new Function0<Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1
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
                                    if (ModalBottomSheetState.this.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C03301(ModalBottomSheetState.this, null), 3, null);
                                    }
                                }

                                /* compiled from: ModalBottomSheet.kt */
                                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                @DebugMetadata(m296c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1", m297f = "ModalBottomSheet.kt", m298i = {}, m299l = {335}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1 */
                                static final class C03301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ ModalBottomSheetState $sheetState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    C03301(ModalBottomSheetState modalBottomSheetState, Continuation<? super C03301> continuation) {
                                        super(2, continuation);
                                        this.$sheetState = modalBottomSheetState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new C03301(this.$sheetState, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((C03301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object $result) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                this.label = 1;
                                                if (this.$sheetState.hide(this) != coroutine_suspended) {
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
                            }, modalBottomSheetState22.getTargetValue() != ModalBottomSheetValue.Hidden, $composer4, (i11 >> 21) & 14);
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
                    Modifier nestedScroll$default = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ModalBottomSheetState.this.getNestedScrollConnection(), null, 2, null);
                    Object key1$iv = ModalBottomSheetState.this;
                    Object key2$iv = Float.valueOf(fullHeight2);
                    final ModalBottomSheetState modalBottomSheetState32 = ModalBottomSheetState.this;
                    int i12 = (i102 >> 6) & 14;
                    $composer4.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation($composer4, "C(remember)P(1,2):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer4.changed(key1$iv) | $composer4.changed(key2$iv);
                    Object it$iv$iv2 = $composer4.rememberedValue();
                    if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                        fullHeight = fullHeight2;
                        value$iv$iv2 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                return IntOffset.m4491boximpl(m1435invokeBjo55l4(density));
                            }

                            /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                            public final long m1435invokeBjo55l4(Density offset) {
                                int y;
                                Intrinsics.checkNotNullParameter(offset, "$this$offset");
                                if (ModalBottomSheetState.this.getAnchors$material_release().isEmpty()) {
                                    y = MathKt.roundToInt(fullHeight);
                                } else {
                                    y = MathKt.roundToInt(ModalBottomSheetState.this.getOffset().getValue().floatValue());
                                }
                                return IntOffsetKt.IntOffset(0, y);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv$iv2);
                    } else {
                        value$iv$iv2 = it$iv$iv2;
                        fullHeight = fullHeight2;
                    }
                    $composer4.endReplaceableGroup();
                    bottomSheetSwipeable = ModalBottomSheetKt.bottomSheetSwipeable(OffsetKt.offset(nestedScroll$default, (Function1) value$iv$iv2), ModalBottomSheetState.this, fullHeight, sheetHeightState);
                    $composer4.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer4, "C(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv2 = $composer4.changed(sheetHeightState);
                    Object it$iv$iv3 = $composer4.rememberedValue();
                    if (invalid$iv$iv2 || it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv3 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                invoke2(layoutCoordinates);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LayoutCoordinates it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                sheetHeightState.setValue(Float.valueOf(IntSize.m4541getHeightimpl(it.mo3497getSizeYbymL2g())));
                            }
                        };
                        $composer4.updateRememberedValue(value$iv$iv3);
                    } else {
                        value$iv$iv3 = it$iv$iv3;
                    }
                    $composer4.endReplaceableGroup();
                    Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(bottomSheetSwipeable, (Function1) value$iv$iv3);
                    final ModalBottomSheetState modalBottomSheetState4 = ModalBottomSheetState.this;
                    final CoroutineScope coroutineScope2 = scope2;
                    Modifier semantics$default = SemanticsModifierKt.semantics$default(onGloballyPositioned, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1.4
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
                            if (ModalBottomSheetState.this.isVisible()) {
                                final ModalBottomSheetState modalBottomSheetState5 = ModalBottomSheetState.this;
                                final CoroutineScope coroutineScope3 = coroutineScope2;
                                SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.1.4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        if (ModalBottomSheetState.this.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C16751(ModalBottomSheetState.this, null), 3, null);
                                        }
                                        return true;
                                    }

                                    /* compiled from: ModalBottomSheet.kt */
                                    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                    @DebugMetadata(m296c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$1$1", m297f = "ModalBottomSheet.kt", m298i = {}, m299l = {363}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                    /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$1$1, reason: invalid class name and collision with other inner class name */
                                    static final class C16751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ ModalBottomSheetState $sheetState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        C16751(ModalBottomSheetState modalBottomSheetState, Continuation<? super C16751> continuation) {
                                            super(2, continuation);
                                            this.$sheetState = modalBottomSheetState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new C16751(this.$sheetState, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((C16751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object $result) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch (this.label) {
                                                case 0:
                                                    ResultKt.throwOnFailure($result);
                                                    this.label = 1;
                                                    if (this.$sheetState.hide(this) != coroutine_suspended) {
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
                                if (ModalBottomSheetState.this.getCurrentValue() == ModalBottomSheetValue.HalfExpanded) {
                                    final ModalBottomSheetState modalBottomSheetState6 = ModalBottomSheetState.this;
                                    final CoroutineScope coroutineScope4 = coroutineScope2;
                                    SemanticsPropertiesKt.expand$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.1.4.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            if (ModalBottomSheetState.this.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.Expanded).booleanValue()) {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, null, new AnonymousClass1(ModalBottomSheetState.this, null), 3, null);
                                            }
                                            return true;
                                        }

                                        /* compiled from: ModalBottomSheet.kt */
                                        @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                        @DebugMetadata(m296c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$2$1", m297f = "ModalBottomSheet.kt", m298i = {}, m299l = {370}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                        /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$2$1, reason: invalid class name */
                                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ ModalBottomSheetState $sheetState;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                                super(2, continuation);
                                                this.$sheetState = modalBottomSheetState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                return new AnonymousClass1(this.$sheetState, continuation);
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
                                                        if (this.$sheetState.expand$material_release(this) != coroutine_suspended) {
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
                                } else if (ModalBottomSheetState.this.getHasHalfExpandedState$material_release()) {
                                    final ModalBottomSheetState modalBottomSheetState7 = ModalBottomSheetState.this;
                                    final CoroutineScope coroutineScope5 = coroutineScope2;
                                    SemanticsPropertiesKt.collapse$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.1.4.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            if (ModalBottomSheetState.this.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.HalfExpanded).booleanValue()) {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope5, null, null, new AnonymousClass1(ModalBottomSheetState.this, null), 3, null);
                                            }
                                            return true;
                                        }

                                        /* compiled from: ModalBottomSheet.kt */
                                        @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                        @DebugMetadata(m296c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$3$1", m297f = "ModalBottomSheet.kt", m298i = {}, m299l = {377}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                        /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$3$1, reason: invalid class name */
                                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ ModalBottomSheetState $sheetState;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                                super(2, continuation);
                                                this.$sheetState = modalBottomSheetState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                return new AnonymousClass1(this.$sheetState, continuation);
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
                                                        if (this.$sheetState.halfExpand$material_release(this) != coroutine_suspended) {
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
                        }
                    }, 1, null);
                    Shape shape32 = shape22;
                    long j72 = j32;
                    long j82 = j42;
                    float f32 = f22;
                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3 = sheetContent;
                    final int i13 = i102;
                    SurfaceKt.m1513SurfaceFjzlyU(semantics$default, shape32, j72, j82, null, f32, ComposableLambdaKt.composableLambda($composer4, -1793508390, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1.5
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
                            ComposerKt.sourceInformation($composer5, "C388@15886L30:ModalBottomSheet.kt#jmzs0o");
                            if (($changed4 & 11) == 2 && $composer5.getSkipping()) {
                                $composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1793508390, $changed4, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous>.<anonymous> (ModalBottomSheet.kt:387)");
                            }
                            Function3 content$iv = function3;
                            int $changed$iv2 = (i13 << 9) & 7168;
                            $composer5.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation($composer5, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                            Modifier modifier$iv2 = Modifier.INSTANCE;
                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer5, (($changed$iv2 >> 3) & 14) | (($changed$iv2 >> 3) & SdkConfig.SDK_VERSION));
                            int $changed$iv$iv2 = ($changed$iv2 << 3) & SdkConfig.SDK_VERSION;
                            $composer5.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation($composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume4 = $composer5.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            Density density$iv$iv2 = (Density) consume4;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume5 = $composer5.consume(localLayoutDirection2);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume6 = $composer5.consume(localViewConfiguration2);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                            if (!($composer5.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer5.startReusableNode();
                            if ($composer5.getInserting()) {
                                $composer5.createNode(factory$iv$iv$iv2);
                            } else {
                                $composer5.useNode();
                            }
                            $composer5.disableReusing();
                            Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer5);
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            $composer5.enableReusing();
                            skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                            $composer5.startReplaceableGroup(2058660585);
                            $composer5.startReplaceableGroup(-1163856341);
                            ComposerKt.sourceInformation($composer5, "C79@3994L9:Column.kt#2w3rfo");
                            if ((($changed$iv$iv$iv2 >> 9) & 14 & 11) == 2 && $composer5.getSkipping()) {
                                $composer5.skipToGroupEnd();
                            } else {
                                content$iv.invoke(ColumnScopeInstance.INSTANCE, $composer5, Integer.valueOf((($changed$iv2 >> 6) & SdkConfig.SDK_VERSION) | 6));
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
                    }), $composer4, ((i102 >> 6) & SdkConfig.SDK_VERSION) | 1572864 | ((i102 >> 9) & 896) | ((i102 >> 9) & 7168) | ((i102 << 3) & 458752), 16);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer4.skipToGroupEnd();
            }
        }), $composer2, (($dirty2 >> 3) & 14) | 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier bottomSheetSwipeable(Modifier $this$bottomSheetSwipeable, ModalBottomSheetState sheetState, float fullHeight, State<Float> state) {
        Modifier.Companion modifier;
        Map anchors;
        Float sheetHeight = state.getValue();
        if (sheetHeight == null) {
            modifier = Modifier.INSTANCE;
        } else {
            float f = 2;
            if (sheetHeight.floatValue() < fullHeight / f || sheetState.getIsSkipHalfExpanded()) {
                anchors = MapsKt.mapOf(TuplesKt.m294to(Float.valueOf(fullHeight), ModalBottomSheetValue.Hidden), TuplesKt.m294to(Float.valueOf(fullHeight - sheetHeight.floatValue()), ModalBottomSheetValue.Expanded));
            } else {
                anchors = MapsKt.mapOf(TuplesKt.m294to(Float.valueOf(fullHeight), ModalBottomSheetValue.Hidden), TuplesKt.m294to(Float.valueOf(fullHeight / f), ModalBottomSheetValue.HalfExpanded), TuplesKt.m294to(Float.valueOf(Math.max(0.0f, fullHeight - sheetHeight.floatValue())), ModalBottomSheetValue.Expanded));
            }
            modifier = SwipeableKt.m1523swipeablepPrIpRY(Modifier.INSTANCE, sheetState, anchors, Orientation.Vertical, (r26 & 8) != 0 ? true : sheetState.getCurrentValue() != ModalBottomSheetValue.Hidden, (r26 & 16) != 0 ? false : false, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function2
                public final FixedThreshold invoke(T t, T t2) {
                    return new FixedThreshold(C0504Dp.m4382constructorimpl(56), null);
                }
            } : null, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, anchors.keySet(), 0.0f, 0.0f, 6, null) : null, (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1522getVelocityThresholdD9Ej5fM() : 0.0f);
        }
        return $this$bottomSheetSwipeable.then(modifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m1431Scrim3JVO9M(final long color, final Function0<Unit> function0, final boolean visible, Composer $composer, final int $changed) {
        Modifier.Companion dismissModifier;
        ModalBottomSheetKt$Scrim$dismissModifier$1$1 value$iv$iv;
        Object value$iv$iv2;
        Composer $composer2 = $composer.startRestartGroup(-526532668);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(0:c#ui.graphics.Color)435@17137L121,439@17284L29,455@17799L62,451@17690L171:ModalBottomSheet.kt#jmzs0o");
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
                ComposerKt.traceEventStart(-526532668, $dirty2, -1, "androidx.compose.material.Scrim (ModalBottomSheet.kt:429)");
            }
            if (color != Color.INSTANCE.m2032getUnspecified0d7_KjU()) {
                final State alpha$delegate = AnimateAsStateKt.animateFloatAsState(visible ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, $composer2, 0, 12);
                final String closeSheet = Strings_androidKt.m1511getString4foXLRw(Strings.INSTANCE.m1505getCloseSheetUdPEhr4(), $composer2, 6);
                $composer2.startReplaceableGroup(1010547488);
                ComposerKt.sourceInformation($composer2, "442@17421L37,443@17511L121");
                if (visible) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    int i = (($dirty2 >> 3) & 14) | 64;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer2.changed(function0);
                    Object it$iv$iv = $composer2.rememberedValue();
                    if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = new ModalBottomSheetKt$Scrim$dismissModifier$1$1(function0, null);
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv);
                    int i2 = $dirty2 & SdkConfig.SDK_VERSION;
                    $composer2.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
                    boolean invalid$iv$iv2 = $composer2.changed(closeSheet) | $composer2.changed(function0);
                    Object it$iv$iv2 = $composer2.rememberedValue();
                    if (!invalid$iv$iv2 && it$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                        value$iv$iv2 = it$iv$iv2;
                        $composer2.endReplaceableGroup();
                        dismissModifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) value$iv$iv2);
                    }
                    value$iv$iv2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1
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
                            SemanticsPropertiesKt.setContentDescription(semantics, closeSheet);
                            final Function0<Unit> function02 = function0;
                            SemanticsPropertiesKt.onClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1.1
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
                value$iv$iv3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$1$1
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
                        float m1432Scrim_3J_VO9M$lambda0;
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        long j = color;
                        m1432Scrim_3J_VO9M$lambda0 = ModalBottomSheetKt.m1432Scrim_3J_VO9M$lambda0(alpha$delegate);
                        DrawScope.m2485drawRectnJ9OG0$default(Canvas, j, 0L, 0L, m1432Scrim_3J_VO9M$lambda0, null, null, 0, 118, null);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$2
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
                ModalBottomSheetKt.m1431Scrim3JVO9M(color, function0, visible, composer, $changed | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim_3J_VO9M$lambda-0, reason: not valid java name */
    public static final float m1432Scrim_3J_VO9M$lambda0(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }
}
