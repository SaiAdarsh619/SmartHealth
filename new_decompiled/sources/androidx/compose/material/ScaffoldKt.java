package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.layout.SubcomposeLayoutKt;
import androidx.compose.p000ui.layout.SubcomposeMeasureScope;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.health.platform.client.SdkConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Scaffold.kt */
@Metadata(m286d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a¢\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\u0019\b\u0002\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192 \b\u0002\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\b\b\u0002\u0010&\u001a\u00020\"2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a£\u0001\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00172\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a!\u00103\u001a\u00020\r2\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u0014H\u0007¢\u0006\u0002\u00107\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00068"}, m287d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/ScaffoldState;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "isFloatingActionButtonDocked", "", "drawerContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "drawerGesturesEnabled", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-27mzLpw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ScaffoldLayout", "isFabDocked", "fabPosition", "Landroidx/compose/ui/UiComposable;", "snackbar", "fab", "ScaffoldLayout-MDYNRJg", "(ZILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "rememberScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ScaffoldState;", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ScaffoldKt {
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new Function0<FabPlacement>() { // from class: androidx.compose.material.ScaffoldKt$LocalFabPlacement$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FabPlacement invoke() {
            return null;
        }
    });
    private static final float FabSpacing = C0504Dp.m4382constructorimpl(16);

    public static final ScaffoldState rememberScaffoldState(DrawerState drawerState, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Object value$iv$iv2;
        $composer.startReplaceableGroup(1569641925);
        ComposerKt.sourceInformation($composer, "C(rememberScaffoldState)63@2263L39,64@2347L32,65@2399L62:Scaffold.kt#jmzs0o");
        if ((i & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, $composer, 6, 2);
        }
        if ((i & 2) != 0) {
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
            ComposerKt.traceEventStart(1569641925, $changed, -1, "androidx.compose.material.rememberScaffoldState (Scaffold.kt:62)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv2 = $composer.rememberedValue();
        if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new ScaffoldState(drawerState, snackbarHostState);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        ScaffoldState scaffoldState = (ScaffoldState) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return scaffoldState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x01d7, code lost:
    
        if (r11.changed(r68) != false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01f1, code lost:
    
        if (r11.changed(r70) != false) goto L164;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0306  */
    /* renamed from: Scaffold-27mzLpw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1484Scaffold27mzLpw(Modifier modifier, ScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function23, int floatingActionButtonPosition, boolean isFloatingActionButtonDocked, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, boolean drawerGesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long drawerScrimColor, long backgroundColor, long contentColor, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, final int i) {
        int i2;
        Modifier modifier2;
        ScaffoldState scaffoldState2;
        Function2 topBar;
        Function2 bottomBar;
        Function3 snackbarHost;
        Function2 floatingActionButton;
        int floatingActionButtonPosition2;
        Function3 drawerContent;
        boolean drawerGesturesEnabled2;
        CornerBasedShape drawerShape2;
        float drawerElevation2;
        Shape drawerShape3;
        int $dirty1;
        long drawerBackgroundColor2;
        long drawerContentColor2;
        long drawerBackgroundColor3;
        long drawerScrimColor2;
        long backgroundColor2;
        int $dirty;
        Shape drawerShape4;
        long contentColor2;
        long backgroundColor3;
        int $dirty12;
        Modifier modifier3;
        boolean isFloatingActionButtonDocked2;
        ScaffoldState scaffoldState3;
        ScaffoldState scaffoldState4;
        Function2 topBar2;
        boolean isFloatingActionButtonDocked3;
        ScaffoldState scaffoldState5;
        Modifier modifier4;
        Shape drawerShape5;
        Function3 drawerContent2;
        boolean drawerGesturesEnabled3;
        float drawerElevation3;
        Function3 snackbarHost2;
        Function2 floatingActionButton2;
        int floatingActionButtonPosition3;
        long drawerContentColor3;
        long drawerBackgroundColor4;
        long drawerScrimColor3;
        long backgroundColor4;
        long contentColor3;
        Function2 topBar3;
        Function2 bottomBar2;
        ScopeUpdateScope endRestartGroup;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(1037492569);
        ComposerKt.sourceInformation($composer2, "C(Scaffold)P(14,15,17,1,16,11,12:c#material.FabPosition,13,5,8,10,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,9:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color)160@7052L23,169@7562L6,171@7677L6,172@7725L38,173@7810L10,174@7865L6,175@7910L32:Scaffold.kt#jmzs0o");
        int $dirty2 = $changed;
        int $dirty13 = $changed1;
        int i8 = i & 1;
        if (i8 != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            if ((i & 2) == 0 && $composer2.changed(scaffoldState)) {
                i7 = 32;
                $dirty2 |= i7;
            }
            i7 = 16;
            $dirty2 |= i7;
        }
        int i9 = i & 4;
        int i10 = 128;
        if (i9 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changed(function2) ? 256 : 128;
        }
        int i11 = i & 8;
        int i12 = 2048;
        if (i11 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer2.changed(function22) ? 2048 : 1024;
        }
        int i13 = i & 16;
        int i14 = 16384;
        if (i13 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty2 |= $composer2.changed(function3) ? 16384 : 8192;
        }
        int i15 = i & 32;
        if (i15 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 458752) == 0) {
            $dirty2 |= $composer2.changed(function23) ? 131072 : 65536;
        }
        int i16 = i & 64;
        if (i16 != 0) {
            $dirty2 |= 1572864;
            i2 = floatingActionButtonPosition;
        } else if (($changed & 3670016) == 0) {
            i2 = floatingActionButtonPosition;
            $dirty2 |= $composer2.changed(i2) ? 1048576 : 524288;
        } else {
            i2 = floatingActionButtonPosition;
        }
        int i17 = i & 128;
        if (i17 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty2 |= $composer2.changed(isFloatingActionButtonDocked) ? 8388608 : 4194304;
        }
        int i18 = i & 256;
        if (i18 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer2.changed(function32) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i19 = i & 512;
        if (i19 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty2 |= $composer2.changed(drawerGesturesEnabled) ? 536870912 : 268435456;
        }
        if (($changed1 & 14) == 0) {
            if ((i & 1024) == 0 && $composer2.changed(drawerShape)) {
                i6 = 4;
                $dirty13 |= i6;
            }
            i6 = 2;
            $dirty13 |= i6;
        }
        int i20 = i & 2048;
        if (i20 != 0) {
            $dirty13 |= 48;
        } else if (($changed1 & SdkConfig.SDK_VERSION) == 0) {
            $dirty13 |= $composer2.changed(drawerElevation) ? 32 : 16;
        }
        if (($changed1 & 896) == 0) {
            if ((i & 4096) == 0 && $composer2.changed(drawerBackgroundColor)) {
                i10 = 256;
            }
            $dirty13 |= i10;
        }
        if (($changed1 & 7168) == 0) {
            if ((i & 8192) != 0) {
            }
            i12 = 1024;
            $dirty13 |= i12;
        }
        if (($changed1 & 57344) == 0) {
            if ((i & 16384) != 0) {
            }
            i14 = 8192;
            $dirty13 |= i14;
        }
        if (($changed1 & 458752) == 0) {
            if ((i & 32768) == 0 && $composer2.changed(backgroundColor)) {
                i5 = 131072;
                $dirty13 |= i5;
            }
            i5 = 65536;
            $dirty13 |= i5;
        }
        if (($changed1 & 3670016) == 0) {
            if ((i & 65536) == 0 && $composer2.changed(contentColor)) {
                i4 = 1048576;
                $dirty13 |= i4;
            }
            i4 = 524288;
            $dirty13 |= i4;
        }
        if ((i & 131072) == 0) {
            i3 = ($changed1 & 29360128) == 0 ? $composer2.changed(content) ? 8388608 : 4194304 : 12582912;
            if (($dirty2 & 1533916891) != 306783378 && (23967451 & $dirty13) == 4793490 && $composer2.getSkipping()) {
                $composer2.skipToGroupEnd();
                modifier4 = modifier;
                scaffoldState5 = scaffoldState;
                topBar3 = function2;
                bottomBar2 = function22;
                snackbarHost2 = function3;
                floatingActionButton2 = function23;
                isFloatingActionButtonDocked3 = isFloatingActionButtonDocked;
                drawerContent2 = function32;
                drawerGesturesEnabled3 = drawerGesturesEnabled;
                drawerShape5 = drawerShape;
                drawerElevation3 = drawerElevation;
                drawerBackgroundColor4 = drawerBackgroundColor;
                drawerContentColor3 = drawerContentColor;
                drawerScrimColor3 = drawerScrimColor;
                backgroundColor4 = backgroundColor;
                contentColor3 = contentColor;
                floatingActionButtonPosition3 = i2;
            } else {
                $composer2.startDefaults();
                if (($changed & 1) != 0 || $composer2.getDefaultsInvalid()) {
                    Modifier.Companion modifier5 = i8 == 0 ? Modifier.INSTANCE : modifier;
                    if ((i & 2) == 0) {
                        modifier2 = modifier5;
                        scaffoldState2 = rememberScaffoldState(null, null, $composer2, 0, 3);
                        $dirty2 &= -113;
                    } else {
                        modifier2 = modifier5;
                        scaffoldState2 = scaffoldState;
                    }
                    topBar = i9 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1343getLambda1$material_release() : function2;
                    bottomBar = i11 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1344getLambda2$material_release() : function22;
                    snackbarHost = i13 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1345getLambda3$material_release() : function3;
                    floatingActionButton = i15 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1346getLambda4$material_release() : function23;
                    floatingActionButtonPosition2 = i16 == 0 ? FabPosition.INSTANCE.m1405getEnd5ygKITE() : floatingActionButtonPosition;
                    boolean isFloatingActionButtonDocked4 = i17 == 0 ? false : isFloatingActionButtonDocked;
                    drawerContent = i18 == 0 ? null : function32;
                    drawerGesturesEnabled2 = i19 == 0 ? true : drawerGesturesEnabled;
                    int $dirty3 = $dirty2;
                    ScaffoldState scaffoldState6 = scaffoldState2;
                    if ((i & 1024) == 0) {
                        drawerShape2 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getLarge();
                        $dirty13 &= -15;
                    } else {
                        drawerShape2 = drawerShape;
                    }
                    drawerElevation2 = i20 == 0 ? DrawerDefaults.INSTANCE.m1362getElevationD9Ej5fM() : drawerElevation;
                    if ((i & 4096) == 0) {
                        drawerShape3 = drawerShape2;
                        $dirty1 = $dirty13 & (-897);
                        drawerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1321getSurface0d7_KjU();
                    } else {
                        drawerShape3 = drawerShape2;
                        $dirty1 = $dirty13;
                        drawerBackgroundColor2 = drawerBackgroundColor;
                    }
                    boolean isFloatingActionButtonDocked5 = isFloatingActionButtonDocked4;
                    if ((i & 8192) == 0) {
                        drawerContentColor2 = ColorsKt.m1335contentColorForek8zF_U(drawerBackgroundColor2, $composer2, ($dirty1 >> 6) & 14);
                        $dirty1 &= -7169;
                    } else {
                        drawerContentColor2 = drawerContentColor;
                    }
                    if ((i & 16384) == 0) {
                        drawerBackgroundColor3 = drawerBackgroundColor2;
                        drawerScrimColor2 = DrawerDefaults.INSTANCE.getScrimColor($composer2, 6);
                        $dirty1 &= -57345;
                    } else {
                        drawerBackgroundColor3 = drawerBackgroundColor2;
                        drawerScrimColor2 = drawerScrimColor;
                    }
                    if ((32768 & i) == 0) {
                        backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1310getBackground0d7_KjU();
                        $dirty1 &= -458753;
                    } else {
                        backgroundColor2 = backgroundColor;
                    }
                    if ((i & 65536) == 0) {
                        $dirty = $dirty3;
                        drawerShape4 = drawerShape3;
                        $dirty12 = $dirty1 & (-3670017);
                        contentColor2 = ColorsKt.m1335contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty1 >> 15) & 14);
                        isFloatingActionButtonDocked2 = isFloatingActionButtonDocked5;
                        backgroundColor3 = backgroundColor2;
                        modifier3 = modifier2;
                        scaffoldState3 = scaffoldState6;
                    } else {
                        $dirty = $dirty3;
                        drawerShape4 = drawerShape3;
                        contentColor2 = contentColor;
                        backgroundColor3 = backgroundColor2;
                        $dirty12 = $dirty1;
                        modifier3 = modifier2;
                        isFloatingActionButtonDocked2 = isFloatingActionButtonDocked5;
                        scaffoldState3 = scaffoldState6;
                    }
                } else {
                    $composer2.skipToGroupEnd();
                    if ((i & 2) != 0) {
                        $dirty2 &= -113;
                    }
                    if ((i & 1024) != 0) {
                        $dirty13 &= -15;
                    }
                    if ((i & 4096) != 0) {
                        $dirty13 &= -897;
                    }
                    if ((i & 8192) != 0) {
                        $dirty13 &= -7169;
                    }
                    if ((i & 16384) != 0) {
                        $dirty13 &= -57345;
                    }
                    if ((32768 & i) != 0) {
                        $dirty13 &= -458753;
                    }
                    if ((i & 65536) != 0) {
                        $dirty13 &= -3670017;
                    }
                    topBar = function2;
                    bottomBar = function22;
                    snackbarHost = function3;
                    isFloatingActionButtonDocked2 = isFloatingActionButtonDocked;
                    drawerContent = function32;
                    drawerGesturesEnabled2 = drawerGesturesEnabled;
                    drawerShape4 = drawerShape;
                    drawerElevation2 = drawerElevation;
                    drawerBackgroundColor3 = drawerBackgroundColor;
                    drawerContentColor2 = drawerContentColor;
                    drawerScrimColor2 = drawerScrimColor;
                    backgroundColor3 = backgroundColor;
                    contentColor2 = contentColor;
                    $dirty = $dirty2;
                    $dirty12 = $dirty13;
                    floatingActionButtonPosition2 = i2;
                    modifier3 = modifier;
                    scaffoldState3 = scaffoldState;
                    floatingActionButton = function23;
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1037492569, $dirty, $dirty12, "androidx.compose.material.Scaffold (Scaffold.kt:158)");
                }
                final long j = backgroundColor3;
                final long j2 = contentColor2;
                final int i21 = $dirty12;
                final boolean z = isFloatingActionButtonDocked2;
                final int i22 = floatingActionButtonPosition2;
                final Function2 function24 = topBar;
                final Function2 function25 = floatingActionButton;
                final Function2 function26 = bottomBar;
                final int i23 = $dirty;
                final Function3 function33 = snackbarHost;
                final ScaffoldState scaffoldState7 = scaffoldState3;
                boolean isFloatingActionButtonDocked6 = isFloatingActionButtonDocked2;
                final Function3 child = ComposableLambdaKt.composableLambda($composer2, 1823402604, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier6, Composer composer, Integer num) {
                        invoke(modifier6, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Modifier childModifier, Composer $composer3, int $changed2) {
                        Intrinsics.checkNotNullParameter(childModifier, "childModifier");
                        ComposerKt.sourceInformation($composer3, "C179@8062L525:Scaffold.kt#jmzs0o");
                        int $dirty4 = $changed2;
                        if (($changed2 & 14) == 0) {
                            $dirty4 |= $composer3.changed(childModifier) ? 4 : 2;
                        }
                        int $dirty5 = $dirty4;
                        if (($dirty5 & 91) != 18 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1823402604, $dirty5, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:178)");
                            }
                            long j3 = j;
                            long j4 = j2;
                            final boolean z2 = z;
                            final int i24 = i22;
                            final Function2<Composer, Integer, Unit> function27 = function24;
                            final Function3<PaddingValues, Composer, Integer, Unit> function34 = content;
                            final Function2<Composer, Integer, Unit> function28 = function25;
                            final Function2<Composer, Integer, Unit> function29 = function26;
                            final int i25 = i23;
                            final int i26 = i21;
                            final Function3<SnackbarHostState, Composer, Integer, Unit> function35 = function33;
                            final ScaffoldState scaffoldState8 = scaffoldState7;
                            SurfaceKt.m1513SurfaceFjzlyU(childModifier, null, j3, j4, null, 0.0f, ComposableLambdaKt.composableLambda($composer3, -1128984656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.1
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

                                public final void invoke(Composer $composer4, int $changed3) {
                                    ComposerKt.sourceInformation($composer4, "C180@8164L413:Scaffold.kt#jmzs0o");
                                    if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1128984656, $changed3, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:179)");
                                        }
                                        boolean z3 = z2;
                                        int i27 = i24;
                                        Function2<Composer, Integer, Unit> function210 = function27;
                                        Function3<PaddingValues, Composer, Integer, Unit> function36 = function34;
                                        final Function3<SnackbarHostState, Composer, Integer, Unit> function37 = function35;
                                        final ScaffoldState scaffoldState9 = scaffoldState8;
                                        final int i28 = i25;
                                        ScaffoldKt.m1485ScaffoldLayoutMDYNRJg(z3, i27, function210, function36, ComposableLambdaKt.composableLambda($composer4, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.1.1
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
                                                ComposerKt.sourceInformation($composer5, "C186@8417L45:Scaffold.kt#jmzs0o");
                                                if (($changed4 & 11) == 2 && $composer5.getSkipping()) {
                                                    $composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(533782017, $changed4, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:185)");
                                                }
                                                function37.invoke(scaffoldState9.getSnackbarHostState(), $composer5, Integer.valueOf((i28 >> 9) & SdkConfig.SDK_VERSION));
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), function28, function29, $composer4, ((i25 >> 21) & 14) | 24576 | ((i25 >> 15) & SdkConfig.SDK_VERSION) | (i25 & 896) | ((i26 >> 12) & 7168) | (458752 & i25) | ((i25 << 9) & 3670016));
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer4.skipToGroupEnd();
                                }
                            }), $composer3, 1572864 | ($dirty5 & 14) | ((i21 >> 9) & 896) | ((i21 >> 9) & 7168), 50);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                });
                if (drawerContent == null) {
                    $composer2.startReplaceableGroup(-1013848234);
                    ComposerKt.sourceInformation($composer2, "195@8636L487");
                    scaffoldState4 = scaffoldState3;
                    topBar2 = topBar;
                    DrawerKt.m1366ModalDrawerGs3lGvM(drawerContent, modifier3, scaffoldState3.getDrawerState(), drawerGesturesEnabled2, drawerShape4, drawerElevation2, drawerBackgroundColor3, drawerContentColor2, drawerScrimColor2, ComposableLambdaKt.composableLambda($composer2, 100842932, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
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
                            ComposerKt.sourceInformation($composer3, "C205@9096L15:Scaffold.kt#jmzs0o");
                            if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                                $composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(100842932, $changed2, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:205)");
                            }
                            child.invoke(Modifier.INSTANCE, $composer3, 54);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), $composer2, (($dirty >> 24) & 14) | 805306368 | (($dirty << 3) & SdkConfig.SDK_VERSION) | (($dirty >> 18) & 7168) | (($dirty12 << 12) & 57344) | (($dirty12 << 12) & 458752) | (($dirty12 << 12) & 3670016) | (($dirty12 << 12) & 29360128) | (($dirty12 << 12) & 234881024), 0);
                    $composer2.endReplaceableGroup();
                } else {
                    scaffoldState4 = scaffoldState3;
                    topBar2 = topBar;
                    $composer2.startReplaceableGroup(-1013847725);
                    ComposerKt.sourceInformation($composer2, "208@9145L15");
                    child.invoke(modifier3, $composer2, Integer.valueOf(($dirty & 14) | 48));
                    $composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                isFloatingActionButtonDocked3 = isFloatingActionButtonDocked6;
                scaffoldState5 = scaffoldState4;
                modifier4 = modifier3;
                drawerShape5 = drawerShape4;
                drawerContent2 = drawerContent;
                drawerGesturesEnabled3 = drawerGesturesEnabled2;
                drawerElevation3 = drawerElevation2;
                snackbarHost2 = snackbarHost;
                floatingActionButton2 = floatingActionButton;
                floatingActionButtonPosition3 = floatingActionButtonPosition2;
                drawerContentColor3 = drawerContentColor2;
                drawerBackgroundColor4 = drawerBackgroundColor3;
                drawerScrimColor3 = drawerScrimColor2;
                backgroundColor4 = backgroundColor3;
                contentColor3 = contentColor2;
                topBar3 = topBar2;
                bottomBar2 = bottomBar;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Modifier modifier6 = modifier4;
            final ScaffoldState scaffoldState8 = scaffoldState5;
            final Function2 function27 = topBar3;
            final Function2 function28 = bottomBar2;
            final Function3 function34 = snackbarHost2;
            final Function2 function29 = floatingActionButton2;
            final int i24 = floatingActionButtonPosition3;
            final boolean z2 = isFloatingActionButtonDocked3;
            final Function3 function35 = drawerContent2;
            final boolean z3 = drawerGesturesEnabled3;
            final Shape shape = drawerShape5;
            final float f = drawerElevation3;
            final long j3 = drawerBackgroundColor4;
            final long j4 = drawerContentColor3;
            final long j5 = drawerScrimColor3;
            final long j6 = backgroundColor4;
            final long j7 = contentColor3;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$2
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

                public final void invoke(Composer composer, int i25) {
                    ScaffoldKt.m1484Scaffold27mzLpw(Modifier.this, scaffoldState8, function27, function28, function34, function29, i24, z2, function35, z3, shape, f, j3, j4, j5, j6, j7, content, composer, $changed | 1, $changed1, i);
                }
            });
            return;
        }
        $dirty13 |= i3;
        if (($dirty2 & 1533916891) != 306783378) {
        }
        $composer2.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if ((i & 2) == 0) {
        }
        if (i9 == 0) {
        }
        if (i11 == 0) {
        }
        if (i13 == 0) {
        }
        if (i15 == 0) {
        }
        if (i16 == 0) {
        }
        if (i17 == 0) {
        }
        if (i18 == 0) {
        }
        if (i19 == 0) {
        }
        int $dirty32 = $dirty2;
        ScaffoldState scaffoldState62 = scaffoldState2;
        if ((i & 1024) == 0) {
        }
        if (i20 == 0) {
        }
        if ((i & 4096) == 0) {
        }
        boolean isFloatingActionButtonDocked52 = isFloatingActionButtonDocked4;
        if ((i & 8192) == 0) {
        }
        if ((i & 16384) == 0) {
        }
        if ((32768 & i) == 0) {
        }
        if ((i & 65536) == 0) {
        }
        $composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final long j8 = backgroundColor3;
        final long j22 = contentColor2;
        final int i212 = $dirty12;
        final boolean z4 = isFloatingActionButtonDocked2;
        final int i222 = floatingActionButtonPosition2;
        final Function2<? super Composer, ? super Integer, Unit> function242 = topBar;
        final Function2<? super Composer, ? super Integer, Unit> function252 = floatingActionButton;
        final Function2<? super Composer, ? super Integer, Unit> function262 = bottomBar;
        final int i232 = $dirty;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function332 = snackbarHost;
        final ScaffoldState scaffoldState72 = scaffoldState3;
        boolean isFloatingActionButtonDocked62 = isFloatingActionButtonDocked2;
        final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> child2 = ComposableLambdaKt.composableLambda($composer2, 1823402604, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier62, Composer composer, Integer num) {
                invoke(modifier62, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Modifier childModifier, Composer $composer3, int $changed2) {
                Intrinsics.checkNotNullParameter(childModifier, "childModifier");
                ComposerKt.sourceInformation($composer3, "C179@8062L525:Scaffold.kt#jmzs0o");
                int $dirty4 = $changed2;
                if (($changed2 & 14) == 0) {
                    $dirty4 |= $composer3.changed(childModifier) ? 4 : 2;
                }
                int $dirty5 = $dirty4;
                if (($dirty5 & 91) != 18 || !$composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1823402604, $dirty5, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:178)");
                    }
                    long j32 = j8;
                    long j42 = j22;
                    final boolean z22 = z4;
                    final int i242 = i222;
                    final Function2<? super Composer, ? super Integer, Unit> function272 = function242;
                    final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function342 = content;
                    final Function2<? super Composer, ? super Integer, Unit> function282 = function252;
                    final Function2<? super Composer, ? super Integer, Unit> function292 = function262;
                    final int i25 = i232;
                    final int i26 = i212;
                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function352 = function332;
                    final ScaffoldState scaffoldState82 = scaffoldState72;
                    SurfaceKt.m1513SurfaceFjzlyU(childModifier, null, j32, j42, null, 0.0f, ComposableLambdaKt.composableLambda($composer3, -1128984656, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.1
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

                        public final void invoke(Composer $composer4, int $changed3) {
                            ComposerKt.sourceInformation($composer4, "C180@8164L413:Scaffold.kt#jmzs0o");
                            if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1128984656, $changed3, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:179)");
                                }
                                boolean z32 = z22;
                                int i27 = i242;
                                Function2<Composer, Integer, Unit> function210 = function272;
                                Function3<PaddingValues, Composer, Integer, Unit> function36 = function342;
                                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function37 = function352;
                                final ScaffoldState scaffoldState9 = scaffoldState82;
                                final int i28 = i25;
                                ScaffoldKt.m1485ScaffoldLayoutMDYNRJg(z32, i27, function210, function36, ComposableLambdaKt.composableLambda($composer4, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.1.1
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
                                        ComposerKt.sourceInformation($composer5, "C186@8417L45:Scaffold.kt#jmzs0o");
                                        if (($changed4 & 11) == 2 && $composer5.getSkipping()) {
                                            $composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(533782017, $changed4, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:185)");
                                        }
                                        function37.invoke(scaffoldState9.getSnackbarHostState(), $composer5, Integer.valueOf((i28 >> 9) & SdkConfig.SDK_VERSION));
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), function282, function292, $composer4, ((i25 >> 21) & 14) | 24576 | ((i25 >> 15) & SdkConfig.SDK_VERSION) | (i25 & 896) | ((i26 >> 12) & 7168) | (458752 & i25) | ((i25 << 9) & 3670016));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer4.skipToGroupEnd();
                        }
                    }), $composer3, 1572864 | ($dirty5 & 14) | ((i212 >> 9) & 896) | ((i212 >> 9) & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer3.skipToGroupEnd();
            }
        });
        if (drawerContent == null) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        isFloatingActionButtonDocked3 = isFloatingActionButtonDocked62;
        scaffoldState5 = scaffoldState4;
        modifier4 = modifier3;
        drawerShape5 = drawerShape4;
        drawerContent2 = drawerContent;
        drawerGesturesEnabled3 = drawerGesturesEnabled2;
        drawerElevation3 = drawerElevation2;
        snackbarHost2 = snackbarHost;
        floatingActionButton2 = floatingActionButton;
        floatingActionButtonPosition3 = floatingActionButtonPosition2;
        drawerContentColor3 = drawerContentColor2;
        drawerBackgroundColor4 = drawerBackgroundColor3;
        drawerScrimColor3 = drawerScrimColor2;
        backgroundColor4 = backgroundColor3;
        contentColor3 = contentColor2;
        topBar3 = topBar2;
        bottomBar2 = bottomBar;
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScaffoldLayout-MDYNRJg, reason: not valid java name */
    public static final void m1485ScaffoldLayoutMDYNRJg(final boolean isFabDocked, final int fabPosition, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, Composer $composer, final int $changed) {
        int i;
        Composer $composer2 = $composer.startRestartGroup(-1401632215);
        ComposerKt.sourceInformation($composer2, "C(ScaffoldLayout)P(4,3:c#material.FabPosition,6,1,5,2)236@10234L4586,236@10217L4603:Scaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(isFabDocked) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(fabPosition) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(function2) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(function3) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changed(function22) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer2.changed(function23) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            $dirty |= $composer2.changed(function24) ? 1048576 : 524288;
        }
        if ((2995931 & $dirty) != 599186 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1401632215, $dirty, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:227)");
            }
            Object[] keys$iv = {function2, function22, function23, FabPosition.m1397boximpl(fabPosition), Boolean.valueOf(isFabDocked), function24, function3};
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : keys$iv) {
                invalid$iv |= $composer2.changed(key$iv);
            }
            Object value$iv$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
                i = 0;
                final int i2 = $dirty;
                value$iv$iv = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1487invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1487invoke0kLqBqw(final SubcomposeMeasureScope SubcomposeLayout, long constraints) {
                        final long looseConstraints;
                        final Function2<Composer, Integer, Unit> function25;
                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                        final int layoutWidth = Constraints.m4338getMaxWidthimpl(constraints);
                        final int layoutHeight = Constraints.m4337getMaxHeightimpl(constraints);
                        looseConstraints = Constraints.m4328copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m4340getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m4338getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m4339getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m4337getMaxHeightimpl(constraints) : 0);
                        final Function2<Composer, Integer, Unit> function26 = function2;
                        final Function2<Composer, Integer, Unit> function27 = function22;
                        final Function2<Composer, Integer, Unit> function28 = function23;
                        final int i3 = fabPosition;
                        final boolean z = isFabDocked;
                        function25 = function24;
                        final int i4 = i2;
                        final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                        return MeasureScope.layout$default(SubcomposeLayout, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1.1
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
                                Object maxElem$iv;
                                Object maxElem$iv2;
                                FabPlacement fabPlacement;
                                Object maxElem$iv3;
                                Integer num;
                                long m4328copyZbe2FdA;
                                float f;
                                int i5;
                                float f2;
                                Object maxElem$iv4;
                                Object maxElem$iv5;
                                int fabLeftOffset;
                                float f3;
                                float f4;
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                List $this$fastMap$iv = SubcomposeMeasureScope.this.subcompose(ScaffoldLayoutContent.TopBar, function26);
                                long j = looseConstraints;
                                List target$iv = new ArrayList($this$fastMap$iv.size());
                                int size = $this$fastMap$iv.size();
                                for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                                    Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
                                    Measurable it = (Measurable) item$iv$iv;
                                    target$iv.add(it.mo3492measureBRTryo0(j));
                                }
                                List topBarPlaceables = target$iv;
                                if (topBarPlaceables.isEmpty()) {
                                    maxElem$iv = null;
                                } else {
                                    maxElem$iv = topBarPlaceables.get(0);
                                    Placeable it2 = (Placeable) maxElem$iv;
                                    int maxValue$iv = it2.getHeight();
                                    int i$iv = 1;
                                    int lastIndex = CollectionsKt.getLastIndex(topBarPlaceables);
                                    if (1 <= lastIndex) {
                                        while (true) {
                                            Object e$iv = topBarPlaceables.get(i$iv);
                                            Placeable it3 = (Placeable) e$iv;
                                            int v$iv = it3.getHeight();
                                            if (maxValue$iv < v$iv) {
                                                maxElem$iv = e$iv;
                                                maxValue$iv = v$iv;
                                            }
                                            if (i$iv == lastIndex) {
                                                break;
                                            } else {
                                                i$iv++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable = (Placeable) maxElem$iv;
                                int topBarHeight = placeable != null ? placeable.getHeight() : 0;
                                List $this$fastMap$iv2 = SubcomposeMeasureScope.this.subcompose(ScaffoldLayoutContent.Snackbar, function27);
                                long j2 = looseConstraints;
                                List target$iv2 = new ArrayList($this$fastMap$iv2.size());
                                int size2 = $this$fastMap$iv2.size();
                                for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                                    Object item$iv$iv2 = $this$fastMap$iv2.get(index$iv$iv2);
                                    Measurable it4 = (Measurable) item$iv$iv2;
                                    target$iv2.add(it4.mo3492measureBRTryo0(j2));
                                }
                                List $this$fastMaxBy$iv = target$iv2;
                                if ($this$fastMaxBy$iv.isEmpty()) {
                                    maxElem$iv2 = null;
                                } else {
                                    maxElem$iv2 = $this$fastMaxBy$iv.get(0);
                                    Placeable it5 = (Placeable) maxElem$iv2;
                                    int maxValue$iv2 = it5.getHeight();
                                    int i$iv2 = 1;
                                    int lastIndex2 = CollectionsKt.getLastIndex($this$fastMaxBy$iv);
                                    if (1 <= lastIndex2) {
                                        while (true) {
                                            Object e$iv2 = $this$fastMaxBy$iv.get(i$iv2);
                                            Placeable it6 = (Placeable) e$iv2;
                                            int v$iv2 = it6.getHeight();
                                            if (maxValue$iv2 < v$iv2) {
                                                maxElem$iv2 = e$iv2;
                                                maxValue$iv2 = v$iv2;
                                            }
                                            if (i$iv2 == lastIndex2) {
                                                break;
                                            } else {
                                                i$iv2++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable2 = (Placeable) maxElem$iv2;
                                int snackbarHeight = placeable2 != null ? placeable2.getHeight() : 0;
                                List $this$fastMap$iv3 = SubcomposeMeasureScope.this.subcompose(ScaffoldLayoutContent.Fab, function28);
                                long j3 = looseConstraints;
                                int $i$f$fastMap = 0;
                                List target$iv3 = new ArrayList($this$fastMap$iv3.size());
                                int index$iv$iv3 = 0;
                                int size3 = $this$fastMap$iv3.size();
                                while (index$iv$iv3 < size3) {
                                    Object item$iv$iv3 = $this$fastMap$iv3.get(index$iv$iv3);
                                    int $i$f$fastMap2 = $i$f$fastMap;
                                    Measurable measurable = (Measurable) item$iv$iv3;
                                    target$iv3.add(measurable.mo3492measureBRTryo0(j3));
                                    index$iv$iv3++;
                                    $this$fastMap$iv3 = $this$fastMap$iv3;
                                    $i$f$fastMap = $i$f$fastMap2;
                                }
                                List fabPlaceables = target$iv3;
                                if (fabPlaceables.isEmpty()) {
                                    fabPlacement = null;
                                } else {
                                    if (fabPlaceables.isEmpty()) {
                                        maxElem$iv4 = null;
                                    } else {
                                        maxElem$iv4 = fabPlaceables.get(0);
                                        Placeable it7 = (Placeable) maxElem$iv4;
                                        int maxValue$iv3 = it7.getWidth();
                                        int i$iv3 = 1;
                                        int lastIndex3 = CollectionsKt.getLastIndex(fabPlaceables);
                                        if (1 <= lastIndex3) {
                                            while (true) {
                                                Object e$iv3 = fabPlaceables.get(i$iv3);
                                                Placeable it8 = (Placeable) e$iv3;
                                                int v$iv3 = it8.getWidth();
                                                if (maxValue$iv3 < v$iv3) {
                                                    maxElem$iv4 = e$iv3;
                                                    maxValue$iv3 = v$iv3;
                                                }
                                                if (i$iv3 == lastIndex3) {
                                                    break;
                                                } else {
                                                    i$iv3++;
                                                }
                                            }
                                        }
                                    }
                                    Placeable placeable3 = (Placeable) maxElem$iv4;
                                    int fabWidth = placeable3 != null ? placeable3.getWidth() : 0;
                                    if (fabPlaceables.isEmpty()) {
                                        maxElem$iv5 = null;
                                    } else {
                                        maxElem$iv5 = fabPlaceables.get(0);
                                        Placeable it9 = (Placeable) maxElem$iv5;
                                        int maxValue$iv4 = it9.getHeight();
                                        int i$iv4 = 1;
                                        int lastIndex4 = CollectionsKt.getLastIndex(fabPlaceables);
                                        if (1 <= lastIndex4) {
                                            while (true) {
                                                Object e$iv4 = fabPlaceables.get(i$iv4);
                                                Placeable it10 = (Placeable) e$iv4;
                                                int v$iv4 = it10.getHeight();
                                                if (maxValue$iv4 < v$iv4) {
                                                    maxElem$iv5 = e$iv4;
                                                    maxValue$iv4 = v$iv4;
                                                }
                                                if (i$iv4 == lastIndex4) {
                                                    break;
                                                } else {
                                                    i$iv4++;
                                                }
                                            }
                                        }
                                    }
                                    Placeable placeable4 = (Placeable) maxElem$iv5;
                                    int fabHeight = placeable4 != null ? placeable4.getHeight() : 0;
                                    if (fabWidth == 0 || fabHeight == 0) {
                                        fabPlacement = null;
                                    } else {
                                        if (!FabPosition.m1400equalsimpl0(i3, FabPosition.INSTANCE.m1405getEnd5ygKITE())) {
                                            fabLeftOffset = (layoutWidth - fabWidth) / 2;
                                        } else if (SubcomposeMeasureScope.this.getLayoutDirection() == LayoutDirection.Ltr) {
                                            int i6 = layoutWidth;
                                            SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeMeasureScope.this;
                                            f4 = ScaffoldKt.FabSpacing;
                                            fabLeftOffset = (i6 - subcomposeMeasureScope.mo642roundToPx0680j_4(f4)) - fabWidth;
                                        } else {
                                            SubcomposeMeasureScope subcomposeMeasureScope2 = SubcomposeMeasureScope.this;
                                            f3 = ScaffoldKt.FabSpacing;
                                            fabLeftOffset = subcomposeMeasureScope2.mo642roundToPx0680j_4(f3);
                                        }
                                        fabPlacement = new FabPlacement(z, fabLeftOffset, fabWidth, fabHeight);
                                    }
                                }
                                final FabPlacement fabPlacement2 = fabPlacement;
                                SubcomposeMeasureScope subcomposeMeasureScope3 = SubcomposeMeasureScope.this;
                                ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                                final Function2<Composer, Integer, Unit> function29 = function25;
                                final int i7 = i4;
                                List $this$fastMap$iv4 = subcomposeMeasureScope3.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(1529070963, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num2) {
                                        invoke(composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer3, int $changed2) {
                                        ComposerKt.sourceInformation($composer3, "C289@12424L144:Scaffold.kt#jmzs0o");
                                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1529070963, $changed2, -1, "androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:288)");
                                            }
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ScaffoldKt.getLocalFabPlacement().provides(FabPlacement.this)}, function29, $composer3, ((i7 >> 15) & SdkConfig.SDK_VERSION) | 8);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer3.skipToGroupEnd();
                                    }
                                }));
                                long j4 = looseConstraints;
                                List target$iv4 = new ArrayList($this$fastMap$iv4.size());
                                int size4 = $this$fastMap$iv4.size();
                                int index$iv$iv4 = 0;
                                while (index$iv$iv4 < size4) {
                                    Object item$iv$iv4 = $this$fastMap$iv4.get(index$iv$iv4);
                                    int i8 = size4;
                                    Measurable it11 = (Measurable) item$iv$iv4;
                                    target$iv4.add(it11.mo3492measureBRTryo0(j4));
                                    index$iv$iv4++;
                                    $this$fastMap$iv4 = $this$fastMap$iv4;
                                    size4 = i8;
                                }
                                List $this$fastMaxBy$iv2 = target$iv4;
                                if ($this$fastMaxBy$iv2.isEmpty()) {
                                    maxElem$iv3 = null;
                                } else {
                                    maxElem$iv3 = $this$fastMaxBy$iv2.get(0);
                                    Placeable it12 = (Placeable) maxElem$iv3;
                                    int maxValue$iv5 = it12.getHeight();
                                    int i$iv5 = 1;
                                    int lastIndex5 = CollectionsKt.getLastIndex($this$fastMaxBy$iv2);
                                    if (1 <= lastIndex5) {
                                        while (true) {
                                            Object e$iv5 = $this$fastMaxBy$iv2.get(i$iv5);
                                            Placeable it13 = (Placeable) e$iv5;
                                            int v$iv5 = it13.getHeight();
                                            if (maxValue$iv5 < v$iv5) {
                                                maxElem$iv3 = e$iv5;
                                                maxValue$iv5 = v$iv5;
                                            }
                                            if (i$iv5 == lastIndex5) {
                                                break;
                                            } else {
                                                i$iv5++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable5 = (Placeable) maxElem$iv3;
                                final int bottomBarHeight = placeable5 != null ? placeable5.getHeight() : 0;
                                if (fabPlacement2 != null) {
                                    SubcomposeMeasureScope subcomposeMeasureScope4 = SubcomposeMeasureScope.this;
                                    boolean z2 = z;
                                    if (bottomBarHeight == 0) {
                                        int height = fabPlacement2.getHeight();
                                        f2 = ScaffoldKt.FabSpacing;
                                        i5 = height + subcomposeMeasureScope4.mo642roundToPx0680j_4(f2);
                                    } else if (z2) {
                                        i5 = bottomBarHeight + (fabPlacement2.getHeight() / 2);
                                    } else {
                                        int height2 = fabPlacement2.getHeight() + bottomBarHeight;
                                        f = ScaffoldKt.FabSpacing;
                                        i5 = height2 + subcomposeMeasureScope4.mo642roundToPx0680j_4(f);
                                    }
                                    num = Integer.valueOf(i5);
                                } else {
                                    num = null;
                                }
                                Integer fabOffsetFromBottom = num;
                                int snackbarOffsetFromBottom = snackbarHeight != 0 ? snackbarHeight + (fabOffsetFromBottom != null ? fabOffsetFromBottom.intValue() : bottomBarHeight) : 0;
                                int bodyContentHeight = layoutHeight - topBarHeight;
                                SubcomposeMeasureScope subcomposeMeasureScope5 = SubcomposeMeasureScope.this;
                                ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                                final SubcomposeMeasureScope subcomposeMeasureScope6 = SubcomposeMeasureScope.this;
                                final Function3<PaddingValues, Composer, Integer, Unit> function33 = function32;
                                final int i9 = i4;
                                List $this$fastMap$iv5 = subcomposeMeasureScope5.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(-1132241596, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num2) {
                                        invoke(composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer3, int $changed2) {
                                        ComposerKt.sourceInformation($composer3, "C321@13846L21:Scaffold.kt#jmzs0o");
                                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1132241596, $changed2, -1, "androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:319)");
                                            }
                                            PaddingValues innerPadding = PaddingKt.m756PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, SubcomposeMeasureScope.this.mo645toDpu2uoSUM(bottomBarHeight), 7, null);
                                            function33.invoke(innerPadding, $composer3, Integer.valueOf((i9 >> 6) & SdkConfig.SDK_VERSION));
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer3.skipToGroupEnd();
                                    }
                                }));
                                long j5 = looseConstraints;
                                List target$iv5 = new ArrayList($this$fastMap$iv5.size());
                                List $this$fastForEach$iv$iv = $this$fastMap$iv5;
                                int size5 = $this$fastForEach$iv$iv.size();
                                int $i$f$fastMap3 = 0;
                                while ($i$f$fastMap3 < size5) {
                                    Object item$iv$iv5 = $this$fastForEach$iv$iv.get($i$f$fastMap3);
                                    List $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                                    Measurable it14 = (Measurable) item$iv$iv5;
                                    long j6 = j5;
                                    m4328copyZbe2FdA = Constraints.m4328copyZbe2FdA(r22, (r12 & 1) != 0 ? Constraints.m4340getMinWidthimpl(r22) : 0, (r12 & 2) != 0 ? Constraints.m4338getMaxWidthimpl(r22) : 0, (r12 & 4) != 0 ? Constraints.m4339getMinHeightimpl(r22) : 0, (r12 & 8) != 0 ? Constraints.m4337getMaxHeightimpl(j5) : bodyContentHeight);
                                    target$iv5.add(it14.mo3492measureBRTryo0(m4328copyZbe2FdA));
                                    $i$f$fastMap3++;
                                    size5 = size5;
                                    $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                                    j5 = j6;
                                }
                                List bodyContentPlaceables = target$iv5;
                                List $this$fastForEach$iv = bodyContentPlaceables;
                                int index$iv = 0;
                                for (int size6 = $this$fastForEach$iv.size(); index$iv < size6; size6 = size6) {
                                    Object item$iv = $this$fastForEach$iv.get(index$iv);
                                    Placeable it15 = (Placeable) item$iv;
                                    Placeable.PlacementScope.place$default(layout, it15, 0, topBarHeight, 0.0f, 4, null);
                                    index$iv++;
                                    bottomBarHeight = bottomBarHeight;
                                    $this$fastForEach$iv = $this$fastForEach$iv;
                                }
                                int bottomBarHeight2 = bottomBarHeight;
                                List $this$fastForEach$iv2 = topBarPlaceables;
                                int index$iv2 = 0;
                                for (int size7 = $this$fastForEach$iv2.size(); index$iv2 < size7; size7 = size7) {
                                    Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
                                    Placeable it16 = (Placeable) item$iv2;
                                    Placeable.PlacementScope.place$default(layout, it16, 0, 0, 0.0f, 4, null);
                                    index$iv2++;
                                    $this$fastForEach$iv2 = $this$fastForEach$iv2;
                                }
                                int i10 = layoutHeight;
                                List $this$fastForEach$iv3 = $this$fastMaxBy$iv;
                                int size8 = $this$fastForEach$iv3.size();
                                int index$iv3 = 0;
                                while (index$iv3 < size8) {
                                    Object item$iv3 = $this$fastForEach$iv3.get(index$iv3);
                                    Placeable it17 = (Placeable) item$iv3;
                                    Placeable.PlacementScope.place$default(layout, it17, 0, i10 - snackbarOffsetFromBottom, 0.0f, 4, null);
                                    index$iv3++;
                                    size8 = size8;
                                    i10 = i10;
                                    $this$fastForEach$iv3 = $this$fastForEach$iv3;
                                }
                                int i11 = layoutHeight;
                                List $this$fastForEach$iv4 = $this$fastMaxBy$iv2;
                                int size9 = $this$fastForEach$iv4.size();
                                int index$iv4 = 0;
                                while (index$iv4 < size9) {
                                    Object item$iv4 = $this$fastForEach$iv4.get(index$iv4);
                                    Placeable it18 = (Placeable) item$iv4;
                                    Placeable.PlacementScope.place$default(layout, it18, 0, i11 - bottomBarHeight2, 0.0f, 4, null);
                                    index$iv4++;
                                    size9 = size9;
                                    i11 = i11;
                                    $this$fastForEach$iv4 = $this$fastForEach$iv4;
                                }
                                int i12 = layoutHeight;
                                List $this$fastForEach$iv5 = fabPlaceables;
                                int size10 = $this$fastForEach$iv5.size();
                                int index$iv5 = 0;
                                while (index$iv5 < size10) {
                                    Object item$iv5 = $this$fastForEach$iv5.get(index$iv5);
                                    Placeable it19 = (Placeable) item$iv5;
                                    Placeable.PlacementScope.place$default(layout, it19, fabPlacement2 != null ? fabPlacement2.getLeft() : 0, i12 - (fabOffsetFromBottom != null ? fabOffsetFromBottom.intValue() : 0), 0.0f, 4, null);
                                    index$iv5++;
                                    size10 = size10;
                                    i12 = i12;
                                    $this$fastForEach$iv5 = $this$fastForEach$iv5;
                                }
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                i = 0;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) value$iv$iv, $composer2, i, 1);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$2
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

            public final void invoke(Composer composer, int i3) {
                ScaffoldKt.m1485ScaffoldLayoutMDYNRJg(isFabDocked, fabPosition, function2, function3, function22, function23, function24, composer, $changed | 1);
            }
        });
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }
}
