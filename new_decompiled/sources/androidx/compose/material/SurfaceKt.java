package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.ClipKt;
import androidx.compose.p000ui.draw.ShadowKt;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.p000ui.graphics.RectangleShapeKt;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.semantics.Role;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.health.platform.client.SdkConfig;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Surface.kt */
@Metadata(m286d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a¬\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0088\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001af\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00142\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#\u001a\u0096\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00142\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010'\u001a/\u0010(\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u000eH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u001a;\u0010.\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00062"}, m287d2 = {"Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "content", "Landroidx/compose/runtime/Composable;", "Surface-9VG74zQ", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Surface-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Surface-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-Ny5ogXk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surfaceColorAtElevation", "elevationOverlay", "Landroidx/compose/material/ElevationOverlay;", "absoluteElevation", "surfaceColorAtElevation-cq6XJ1M", "(JLandroidx/compose/material/ElevationOverlay;FLandroidx/compose/runtime/Composer;I)J", "surface", "backgroundColor", "surface-8ww4TTg", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SurfaceKt {
    /* JADX WARN: Removed duplicated region for block: B:40:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0187  */
    /* renamed from: Surface-F-jzlyU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1513SurfaceFjzlyU(Modifier modifier, Shape shape, long color, long contentColor, BorderStroke border, float elevation, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Shape shape2;
        long color2;
        long contentColor2;
        BorderStroke border2;
        float elevation2;
        Shape shape3;
        long contentColor3;
        BorderStroke border3;
        int $dirty;
        Modifier modifier3;
        long color3;
        float elevation3;
        BorderStroke border4;
        long color4;
        Modifier modifier4;
        Shape shape4;
        ScopeUpdateScope endRestartGroup;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(1412203386);
        ComposerKt.sourceInformation($composer2, "C(Surface)P(5,6,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp)106@5259L6,107@5301L22,*112@5476L7,113@5500L793:Surface.kt#jmzs0o");
        int $dirty2 = $changed;
        int i5 = i & 1;
        if (i5 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty2 |= 48;
            shape2 = shape;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            shape2 = shape;
            $dirty2 |= $composer2.changed(shape2) ? 32 : 16;
        } else {
            shape2 = shape;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                color2 = color;
                if ($composer2.changed(color2)) {
                    i4 = 256;
                    $dirty2 |= i4;
                }
            } else {
                color2 = color;
            }
            i4 = 128;
            $dirty2 |= i4;
        } else {
            color2 = color;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i3 = 2048;
                    $dirty2 |= i3;
                }
            } else {
                contentColor2 = contentColor;
            }
            i3 = 1024;
            $dirty2 |= i3;
        } else {
            contentColor2 = contentColor;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty2 |= 24576;
            border2 = border;
        } else if ((57344 & $changed) == 0) {
            border2 = border;
            $dirty2 |= $composer2.changed(border2) ? 16384 : 8192;
        } else {
            border2 = border;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 458752) == 0) {
            $dirty2 |= $composer2.changed(elevation) ? 131072 : 65536;
        }
        if ((i & 64) == 0) {
            i2 = ($changed & 3670016) == 0 ? $composer2.changed(content) ? 1048576 : 524288 : 1572864;
            if (($dirty2 & 2995931) == 599186 || !$composer2.getSkipping()) {
                $composer2.startDefaults();
                if (($changed & 1) != 0 || $composer2.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i6 != 0) {
                        shape2 = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i & 4) != 0) {
                        $dirty2 &= -897;
                        color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1321getSurface0d7_KjU();
                    }
                    if ((i & 8) != 0) {
                        long contentColor4 = ColorsKt.m1335contentColorForek8zF_U(color2, $composer2, ($dirty2 >> 6) & 14);
                        $dirty2 &= -7169;
                        contentColor2 = contentColor4;
                    }
                    if (i7 != 0) {
                        border2 = null;
                    }
                    if (i8 == 0) {
                        elevation2 = C0504Dp.m4382constructorimpl(0);
                        shape3 = shape2;
                        contentColor3 = contentColor2;
                        border3 = border2;
                        $dirty = $dirty2;
                        modifier3 = modifier2;
                        color3 = color2;
                    } else {
                        elevation2 = elevation;
                        shape3 = shape2;
                        contentColor3 = contentColor2;
                        border3 = border2;
                        $dirty = $dirty2;
                        modifier3 = modifier2;
                        color3 = color2;
                    }
                } else {
                    $composer2.skipToGroupEnd();
                    if ((i & 4) != 0) {
                        $dirty2 &= -897;
                    }
                    if ((i & 8) != 0) {
                        elevation2 = elevation;
                        shape3 = shape2;
                        contentColor3 = contentColor2;
                        border3 = border2;
                        $dirty = $dirty2 & (-7169);
                        modifier3 = modifier2;
                        color3 = color2;
                    } else {
                        elevation2 = elevation;
                        shape3 = shape2;
                        contentColor3 = contentColor2;
                        border3 = border2;
                        $dirty = $dirty2;
                        modifier3 = modifier2;
                        color3 = color2;
                    }
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1412203386, $dirty, -1, "androidx.compose.material.Surface (Surface.kt:103)");
                }
                ProvidableCompositionLocal<C0504Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(localAbsoluteElevation);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                float arg0$iv = ((C0504Dp) consume).m4396unboximpl();
                final float absoluteElevation = C0504Dp.m4382constructorimpl(arg0$iv + elevation2);
                final Modifier modifier5 = modifier3;
                final Shape shape5 = shape3;
                final long j = color3;
                Modifier modifier6 = modifier3;
                final int i9 = $dirty;
                Shape shape6 = shape3;
                final BorderStroke borderStroke = border3;
                final float f = elevation2;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1986boximpl(contentColor3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C0504Dp.m4380boximpl(absoluteElevation))}, ComposableLambdaKt.composableLambda($composer2, -1822160838, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1
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
                        long m1520surfaceColorAtElevationcq6XJ1M;
                        Modifier m1519surface8ww4TTg;
                        ComposerKt.sourceInformation($composer3, "C123@5914L7,121@5785L221,117@5649L638:Surface.kt#jmzs0o");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1822160838, $changed2, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:116)");
                            }
                            Modifier modifier7 = Modifier.this;
                            Shape shape7 = shape5;
                            long j2 = j;
                            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume2 = $composer3.consume(localElevationOverlay);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            m1520surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1520surfaceColorAtElevationcq6XJ1M(j2, (ElevationOverlay) consume2, absoluteElevation, $composer3, (i9 >> 6) & 14);
                            m1519surface8ww4TTg = SurfaceKt.m1519surface8ww4TTg(modifier7, shape7, m1520surfaceColorAtElevationcq6XJ1M, borderStroke, f);
                            Modifier modifier$iv = SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics(m1519surface8ww4TTg, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }
                            }), Unit.INSTANCE, new C03592(null));
                            Function2<Composer, Integer, Unit> function2 = content;
                            int i10 = i9;
                            $composer3.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, true, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & SdkConfig.SDK_VERSION));
                            int $changed$iv$iv = (384 << 3) & SdkConfig.SDK_VERSION;
                            $composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume3 = $composer3.consume(localDensity);
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
                            $composer3.startReplaceableGroup(-2137368960);
                            ComposerKt.sourceInformation($composer3, "C72@3384L9:Box.kt#2w3rfo");
                            if (($changed$iv & 11) == 2 && $composer3.getSkipping()) {
                                $composer3.skipToGroupEnd();
                            } else {
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                int $changed3 = ((384 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                $composer3.startReplaceableGroup(1539610176);
                                ComposerKt.sourceInformation($composer3, "C133@6268L9:Surface.kt#jmzs0o");
                                if (($changed3 & 81) == 16 && $composer3.getSkipping()) {
                                    $composer3.skipToGroupEnd();
                                } else {
                                    function2.invoke($composer3, Integer.valueOf((i10 >> 18) & 14));
                                }
                                $composer3.endReplaceableGroup();
                            }
                            $composer3.endReplaceableGroup();
                            $composer3.endReplaceableGroup();
                            $composer3.endNode();
                            $composer3.endReplaceableGroup();
                            $composer3.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }

                    /* compiled from: Surface.kt */
                    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                    @DebugMetadata(m296c = "androidx.compose.material.SurfaceKt$Surface$1$2", m297f = "Surface.kt", m298i = {}, m299l = {}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                    /* renamed from: androidx.compose.material.SurfaceKt$Surface$1$2 */
                    static final class C03592 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                        int label;

                        C03592(Continuation<? super C03592> continuation) {
                            super(2, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C03592(continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            return ((C03592) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure(obj);
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }
                }), $composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                elevation3 = elevation2;
                border4 = border3;
                color4 = color3;
                modifier4 = modifier6;
                shape4 = shape6;
            } else {
                $composer2.skipToGroupEnd();
                elevation3 = elevation;
                shape4 = shape2;
                color4 = color2;
                contentColor3 = contentColor2;
                border4 = border2;
                modifier4 = modifier2;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Modifier modifier7 = modifier4;
            final Shape shape7 = shape4;
            final long j2 = color4;
            final long j3 = contentColor3;
            final BorderStroke borderStroke2 = border4;
            final float f2 = elevation3;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$2
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
                    SurfaceKt.m1513SurfaceFjzlyU(Modifier.this, shape7, j2, j3, borderStroke2, f2, content, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty2 |= i2;
        if (($dirty2 & 2995931) == 599186) {
        }
        $composer2.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if ((i & 4) != 0) {
        }
        if ((i & 8) != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 == 0) {
        }
        $composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<C0504Dp> localAbsoluteElevation2 = ElevationOverlayKt.getLocalAbsoluteElevation();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer2.consume(localAbsoluteElevation2);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        float arg0$iv2 = ((C0504Dp) consume2).m4396unboximpl();
        final float absoluteElevation2 = C0504Dp.m4382constructorimpl(arg0$iv2 + elevation2);
        final Modifier modifier52 = modifier3;
        final Shape shape52 = shape3;
        final long j4 = color3;
        Modifier modifier62 = modifier3;
        final int i92 = $dirty;
        Shape shape62 = shape3;
        final BorderStroke borderStroke3 = border3;
        final float f3 = elevation2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1986boximpl(contentColor3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C0504Dp.m4380boximpl(absoluteElevation2))}, ComposableLambdaKt.composableLambda($composer2, -1822160838, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1
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
                long m1520surfaceColorAtElevationcq6XJ1M;
                Modifier m1519surface8ww4TTg;
                ComposerKt.sourceInformation($composer3, "C123@5914L7,121@5785L221,117@5649L638:Surface.kt#jmzs0o");
                if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1822160838, $changed2, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:116)");
                    }
                    Modifier modifier72 = Modifier.this;
                    Shape shape72 = shape52;
                    long j22 = j4;
                    ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume22 = $composer3.consume(localElevationOverlay);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    m1520surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1520surfaceColorAtElevationcq6XJ1M(j22, (ElevationOverlay) consume22, absoluteElevation2, $composer3, (i92 >> 6) & 14);
                    m1519surface8ww4TTg = SurfaceKt.m1519surface8ww4TTg(modifier72, shape72, m1520surfaceColorAtElevationcq6XJ1M, borderStroke3, f3);
                    Modifier modifier$iv = SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics(m1519surface8ww4TTg, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        }
                    }), Unit.INSTANCE, new C03592(null));
                    Function2<Composer, Integer, Unit> function2 = content;
                    int i10 = i92;
                    $composer3.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, true, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv = (384 << 3) & SdkConfig.SDK_VERSION;
                    $composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume3 = $composer3.consume(localDensity);
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
                    $composer3.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer3, "C72@3384L9:Box.kt#2w3rfo");
                    if (($changed$iv & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                    } else {
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int $changed3 = ((384 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        $composer3.startReplaceableGroup(1539610176);
                        ComposerKt.sourceInformation($composer3, "C133@6268L9:Surface.kt#jmzs0o");
                        if (($changed3 & 81) == 16 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                        } else {
                            function2.invoke($composer3, Integer.valueOf((i10 >> 18) & 14));
                        }
                        $composer3.endReplaceableGroup();
                    }
                    $composer3.endReplaceableGroup();
                    $composer3.endReplaceableGroup();
                    $composer3.endNode();
                    $composer3.endReplaceableGroup();
                    $composer3.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer3.skipToGroupEnd();
            }

            /* compiled from: Surface.kt */
            @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            @DebugMetadata(m296c = "androidx.compose.material.SurfaceKt$Surface$1$2", m297f = "Surface.kt", m298i = {}, m299l = {}, m300m = "invokeSuspend", m301n = {}, m302s = {})
            /* renamed from: androidx.compose.material.SurfaceKt$Surface$1$2 */
            static final class C03592 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                int label;

                C03592(Continuation<? super C03592> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C03592(continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                    return ((C03592) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
        }), $composer2, 56);
        if (ComposerKt.isTraceInProgress()) {
        }
        elevation3 = elevation2;
        border4 = border3;
        color4 = color3;
        modifier4 = modifier62;
        shape4 = shape62;
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ce  */
    @ExperimentalMaterialApi
    /* renamed from: Surface-LPr_se0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1514SurfaceLPr_se0(final Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Shape shape2;
        long j;
        long color2;
        long contentColor2;
        int $dirty;
        float elevation2;
        float elevation3;
        MutableInteractionSource interactionSource2;
        Modifier modifier2;
        boolean enabled2;
        Shape shape3;
        BorderStroke border2;
        long color3;
        long contentColor3;
        int $dirty2;
        Object value$iv$iv;
        Composer $composer2;
        ScopeUpdateScope endRestartGroup;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(1560876237);
        ComposerKt.sourceInformation($composer3, "C(Surface)P(8,7,5,9,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)213@10696L6,214@10738L22,217@10872L39,*220@11004L7,221@11028L1013:Surface.kt#jmzs0o");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changed(onClick) ? 4 : 2;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty3 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 32 : 16;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer3.changed(enabled) ? 256 : 128;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty3 |= 3072;
            shape2 = shape;
        } else if (($changed & 7168) == 0) {
            shape2 = shape;
            $dirty3 |= $composer3.changed(shape2) ? 2048 : 1024;
        } else {
            shape2 = shape;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                j = color;
                if ($composer3.changed(j)) {
                    i4 = 16384;
                    $dirty3 |= i4;
                }
            } else {
                j = color;
            }
            i4 = 8192;
            $dirty3 |= i4;
        } else {
            j = color;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0 && $composer3.changed(contentColor)) {
                i3 = 131072;
                $dirty3 |= i3;
            }
            i3 = 65536;
            $dirty3 |= i3;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty3 |= $composer3.changed(border) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty3 |= $composer3.changed(elevation) ? 8388608 : 4194304;
        }
        int i10 = i & 256;
        if (i10 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty3 |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 512) == 0) {
            i2 = (1879048192 & $changed) == 0 ? $composer3.changed(content) ? 536870912 : 268435456 : 805306368;
            if ((1533916891 & $dirty3) == 306783378 || !$composer3.getSkipping()) {
                $composer3.startDefaults();
                if (($changed & 1) != 0 || $composer3.getDefaultsInvalid()) {
                    Modifier.Companion modifier3 = i5 == 0 ? Modifier.INSTANCE : modifier;
                    boolean enabled3 = i6 == 0 ? true : enabled;
                    Shape shape4 = i7 == 0 ? RectangleShapeKt.getRectangleShape() : shape2;
                    if ((i & 16) == 0) {
                        color2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1321getSurface0d7_KjU();
                        $dirty3 &= -57345;
                    } else {
                        color2 = j;
                    }
                    if ((i & 32) == 0) {
                        contentColor2 = ColorsKt.m1335contentColorForek8zF_U(color2, $composer3, ($dirty3 >> 12) & 14);
                        $dirty3 &= -458753;
                    } else {
                        contentColor2 = contentColor;
                    }
                    BorderStroke border3 = i8 == 0 ? null : border;
                    if (i9 == 0) {
                        $dirty = $dirty3;
                        elevation2 = C0504Dp.m4382constructorimpl(0);
                    } else {
                        $dirty = $dirty3;
                        elevation2 = elevation;
                    }
                    if (i10 == 0) {
                        float elevation4 = elevation2;
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                        Object it$iv$iv = $composer3.rememberedValue();
                        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                            $composer3.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                        }
                        $composer3.endReplaceableGroup();
                        elevation3 = elevation4;
                        interactionSource2 = (MutableInteractionSource) value$iv$iv;
                        modifier2 = modifier3;
                        enabled2 = enabled3;
                        shape3 = shape4;
                        border2 = border3;
                        color3 = color2;
                        contentColor3 = contentColor2;
                        $dirty2 = $dirty;
                    } else {
                        elevation3 = elevation2;
                        interactionSource2 = interactionSource;
                        modifier2 = modifier3;
                        enabled2 = enabled3;
                        shape3 = shape4;
                        border2 = border3;
                        color3 = color2;
                        contentColor3 = contentColor2;
                        $dirty2 = $dirty;
                    }
                } else {
                    $composer3.skipToGroupEnd();
                    if ((i & 16) != 0) {
                        $dirty3 &= -57345;
                    }
                    if ((i & 32) != 0) {
                        modifier2 = modifier;
                        enabled2 = enabled;
                        contentColor3 = contentColor;
                        border2 = border;
                        elevation3 = elevation;
                        interactionSource2 = interactionSource;
                        shape3 = shape2;
                        color3 = j;
                        $dirty2 = $dirty3 & (-458753);
                    } else {
                        modifier2 = modifier;
                        enabled2 = enabled;
                        contentColor3 = contentColor;
                        border2 = border;
                        elevation3 = elevation;
                        interactionSource2 = interactionSource;
                        shape3 = shape2;
                        color3 = j;
                        $dirty2 = $dirty3;
                    }
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1560876237, $dirty2, -1, "androidx.compose.material.Surface (Surface.kt:208)");
                }
                ProvidableCompositionLocal<C0504Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = $composer3.consume(localAbsoluteElevation);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                float arg0$iv = ((C0504Dp) consume).m4396unboximpl();
                final float absoluteElevation = C0504Dp.m4382constructorimpl(arg0$iv + elevation3);
                final Modifier modifier4 = modifier2;
                final Shape shape5 = shape3;
                final long j2 = color3;
                final int i11 = $dirty2;
                final BorderStroke borderStroke = border2;
                final float f = elevation3;
                final MutableInteractionSource mutableInteractionSource = interactionSource2;
                final boolean z = enabled2;
                $composer2 = $composer3;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1986boximpl(contentColor3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C0504Dp.m4380boximpl(absoluteElevation))}, ComposableLambdaKt.composableLambda($composer2, 2031491085, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$4
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
                        long m1520surfaceColorAtElevationcq6XJ1M;
                        Modifier m1519surface8ww4TTg;
                        Modifier modifier$iv;
                        ComposerKt.sourceInformation($composer4, "C232@11484L7,230@11355L221,240@11795L16,225@11177L858:Surface.kt#jmzs0o");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2031491085, $changed2, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:224)");
                            }
                            Modifier minimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(Modifier.this);
                            Shape shape6 = shape5;
                            long j3 = j2;
                            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume2 = $composer4.consume(localElevationOverlay);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            m1520surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1520surfaceColorAtElevationcq6XJ1M(j3, (ElevationOverlay) consume2, absoluteElevation, $composer4, (i11 >> 12) & 14);
                            m1519surface8ww4TTg = SurfaceKt.m1519surface8ww4TTg(minimumTouchTargetSize, shape6, m1520surfaceColorAtElevationcq6XJ1M, borderStroke, f);
                            modifier$iv = ClickableKt.m511clickableO2vRcR0(m1519surface8ww4TTg, mutableInteractionSource, RippleKt.m1618rememberRipple9IZ8Weo(false, 0.0f, 0L, $composer4, 0, 7), (r14 & 4) != 0 ? true : z, (r14 & 8) != 0 ? null : null, (r14 & 16) != 0 ? null : Role.m3825boximpl(Role.INSTANCE.m3832getButtono7Vup1c()), onClick);
                            Function2<Composer, Integer, Unit> function2 = content;
                            int i12 = i11;
                            $composer4.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, true, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & SdkConfig.SDK_VERSION));
                            int $changed$iv$iv = (384 << 3) & SdkConfig.SDK_VERSION;
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
                            } else {
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                int $changed3 = ((384 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                $composer4.startReplaceableGroup(-390905273);
                                ComposerKt.sourceInformation($composer4, "C247@12016L9:Surface.kt#jmzs0o");
                                if (($changed3 & 81) == 16 && $composer4.getSkipping()) {
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
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }), $composer2, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer3.skipToGroupEnd();
                modifier2 = modifier;
                enabled2 = enabled;
                contentColor3 = contentColor;
                border2 = border;
                elevation3 = elevation;
                interactionSource2 = interactionSource;
                shape3 = shape2;
                color3 = j;
                $composer2 = $composer3;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Modifier modifier5 = modifier2;
            final boolean z2 = enabled2;
            final Shape shape6 = shape3;
            final long j3 = color3;
            final long j4 = contentColor3;
            final BorderStroke borderStroke2 = border2;
            final float f2 = elevation3;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$5
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
                    SurfaceKt.m1514SurfaceLPr_se0(onClick, modifier5, z2, shape6, j3, j4, borderStroke2, f2, mutableInteractionSource2, content, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty3 |= i2;
        if ((1533916891 & $dirty3) == 306783378) {
        }
        $composer3.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if ((i & 16) == 0) {
        }
        if ((i & 32) == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        $composer3.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<C0504Dp> localAbsoluteElevation2 = ElevationOverlayKt.getLocalAbsoluteElevation();
        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer3.consume(localAbsoluteElevation2);
        ComposerKt.sourceInformationMarkerEnd($composer3);
        float arg0$iv2 = ((C0504Dp) consume2).m4396unboximpl();
        final float absoluteElevation2 = C0504Dp.m4382constructorimpl(arg0$iv2 + elevation3);
        final Modifier modifier42 = modifier2;
        final Shape shape52 = shape3;
        final long j22 = color3;
        final int i112 = $dirty2;
        final BorderStroke borderStroke3 = border2;
        final float f3 = elevation3;
        final MutableInteractionSource mutableInteractionSource3 = interactionSource2;
        final boolean z3 = enabled2;
        $composer2 = $composer3;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1986boximpl(contentColor3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C0504Dp.m4380boximpl(absoluteElevation2))}, ComposableLambdaKt.composableLambda($composer2, 2031491085, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$4
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
                long m1520surfaceColorAtElevationcq6XJ1M;
                Modifier m1519surface8ww4TTg;
                Modifier modifier$iv;
                ComposerKt.sourceInformation($composer4, "C232@11484L7,230@11355L221,240@11795L16,225@11177L858:Surface.kt#jmzs0o");
                if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2031491085, $changed2, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:224)");
                    }
                    Modifier minimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(Modifier.this);
                    Shape shape62 = shape52;
                    long j32 = j22;
                    ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume22 = $composer4.consume(localElevationOverlay);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    m1520surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1520surfaceColorAtElevationcq6XJ1M(j32, (ElevationOverlay) consume22, absoluteElevation2, $composer4, (i112 >> 12) & 14);
                    m1519surface8ww4TTg = SurfaceKt.m1519surface8ww4TTg(minimumTouchTargetSize, shape62, m1520surfaceColorAtElevationcq6XJ1M, borderStroke3, f3);
                    modifier$iv = ClickableKt.m511clickableO2vRcR0(m1519surface8ww4TTg, mutableInteractionSource3, RippleKt.m1618rememberRipple9IZ8Weo(false, 0.0f, 0L, $composer4, 0, 7), (r14 & 4) != 0 ? true : z3, (r14 & 8) != 0 ? null : null, (r14 & 16) != 0 ? null : Role.m3825boximpl(Role.INSTANCE.m3832getButtono7Vup1c()), onClick);
                    Function2<Composer, Integer, Unit> function2 = content;
                    int i12 = i112;
                    $composer4.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, true, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv = (384 << 3) & SdkConfig.SDK_VERSION;
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
                    } else {
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int $changed3 = ((384 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        $composer4.startReplaceableGroup(-390905273);
                        ComposerKt.sourceInformation($composer4, "C247@12016L9:Surface.kt#jmzs0o");
                        if (($changed3 & 81) == 16 && $composer4.getSkipping()) {
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
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer4.skipToGroupEnd();
            }
        }), $composer2, 56);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    @ExperimentalMaterialApi
    /* renamed from: Surface-Ny5ogXk, reason: not valid java name */
    public static final void m1515SurfaceNy5ogXk(final boolean selected, final Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean z;
        int i2;
        int $dirty;
        long color2;
        long contentColor2;
        BorderStroke border2;
        float elevation2;
        BorderStroke border3;
        float elevation3;
        MutableInteractionSource interactionSource2;
        Modifier modifier2;
        int $dirty2;
        long contentColor3;
        boolean enabled2;
        long color3;
        Shape shape2;
        Object value$iv$iv;
        Composer $composer2;
        int $dirty3;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(262027249);
        ComposerKt.sourceInformation($composer3, "C(Surface)P(9,8,7,5,10,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)329@16529L6,330@16571L22,333@16705L39,*336@16837L7,337@16861L1052:Surface.kt#jmzs0o");
        int $dirty4 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer3.changed(selected) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty4 |= $composer3.changed(onClick) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty4 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty4 |= 3072;
            z = enabled;
        } else if (($changed & 7168) == 0) {
            z = enabled;
            $dirty4 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty4 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty4 |= $composer3.changed(shape) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                i2 = i6;
                if ($composer3.changed(color)) {
                    i4 = 131072;
                    $dirty4 |= i4;
                }
            } else {
                i2 = i6;
            }
            i4 = 65536;
            $dirty4 |= i4;
        } else {
            i2 = i6;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                $dirty3 = $dirty4;
                if ($composer3.changed(contentColor)) {
                    i3 = 1048576;
                    $dirty = $dirty3 | i3;
                }
            } else {
                $dirty3 = $dirty4;
            }
            i3 = 524288;
            $dirty = $dirty3 | i3;
        } else {
            $dirty = $dirty4;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if ((29360128 & $changed) == 0) {
            $dirty |= $composer3.changed(border) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer3.changed(elevation) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer3.changed(interactionSource) ? 536870912 : 268435456;
        }
        if ((i & 1024) != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changed(content) ? 4 : 2;
        }
        if (($dirty & 1533916891) == 306783378 && ($dirty1 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            shape2 = shape;
            color3 = color;
            contentColor3 = contentColor;
            border3 = border;
            elevation3 = elevation;
            interactionSource2 = interactionSource;
            $composer2 = $composer3;
            enabled2 = z;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i5 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled3 = i2 != 0 ? true : z;
                Shape shape3 = i7 != 0 ? RectangleShapeKt.getRectangleShape() : shape;
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    color2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1321getSurface0d7_KjU();
                } else {
                    color2 = color;
                }
                if ((i & 64) != 0) {
                    contentColor2 = ColorsKt.m1335contentColorForek8zF_U(color2, $composer3, ($dirty >> 15) & 14);
                    $dirty &= -3670017;
                } else {
                    contentColor2 = contentColor;
                }
                BorderStroke border4 = i8 != 0 ? null : border;
                if (i9 != 0) {
                    border2 = border4;
                    elevation2 = C0504Dp.m4382constructorimpl(0);
                } else {
                    border2 = border4;
                    elevation2 = elevation;
                }
                if (i10 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    float elevation4 = elevation2;
                    Object it$iv$iv = $composer3.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    border3 = border2;
                    elevation3 = elevation4;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    modifier2 = modifier3;
                    $dirty2 = $dirty;
                    contentColor3 = contentColor2;
                    enabled2 = enabled3;
                    color3 = color2;
                    shape2 = shape3;
                } else {
                    border3 = border2;
                    elevation3 = elevation2;
                    interactionSource2 = interactionSource;
                    modifier2 = modifier3;
                    $dirty2 = $dirty;
                    contentColor3 = contentColor2;
                    enabled2 = enabled3;
                    color3 = color2;
                    shape2 = shape3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    modifier2 = modifier;
                    shape2 = shape;
                    color3 = color;
                    contentColor3 = contentColor;
                    border3 = border;
                    elevation3 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty & (-3670017);
                    enabled2 = z;
                } else {
                    modifier2 = modifier;
                    shape2 = shape;
                    color3 = color;
                    contentColor3 = contentColor;
                    border3 = border;
                    elevation3 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty;
                    enabled2 = z;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(262027249, $dirty2, $dirty1, "androidx.compose.material.Surface (Surface.kt:323)");
            }
            ProvidableCompositionLocal<C0504Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            float arg0$iv = ((C0504Dp) consume).m4396unboximpl();
            final float absoluteElevation = C0504Dp.m4382constructorimpl(arg0$iv + elevation3);
            final Modifier modifier4 = modifier2;
            final int $dirty12 = $dirty1;
            final Shape shape4 = shape2;
            final long j = color3;
            final int i11 = $dirty2;
            final BorderStroke borderStroke = border3;
            final float f = elevation3;
            final MutableInteractionSource mutableInteractionSource = interactionSource2;
            final boolean z2 = enabled2;
            $composer2 = $composer3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1986boximpl(contentColor3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C0504Dp.m4380boximpl(absoluteElevation))}, ComposableLambdaKt.composableLambda($composer2, -1391199439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$7
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
                    long m1520surfaceColorAtElevationcq6XJ1M;
                    Modifier m1519surface8ww4TTg;
                    ComposerKt.sourceInformation($composer4, "C348@17317L7,346@17188L221,357@17670L16,341@17010L897:Surface.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1391199439, $changed2, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:340)");
                        }
                        Modifier minimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(Modifier.this);
                        Shape shape5 = shape4;
                        long j2 = j;
                        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume2 = $composer4.consume(localElevationOverlay);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        m1520surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1520surfaceColorAtElevationcq6XJ1M(j2, (ElevationOverlay) consume2, absoluteElevation, $composer4, (i11 >> 15) & 14);
                        m1519surface8ww4TTg = SurfaceKt.m1519surface8ww4TTg(minimumTouchTargetSize, shape5, m1520surfaceColorAtElevationcq6XJ1M, borderStroke, f);
                        Modifier modifier$iv = SelectableKt.m980selectableO2vRcR0(m1519surface8ww4TTg, selected, mutableInteractionSource, RippleKt.m1618rememberRipple9IZ8Weo(false, 0.0f, 0L, $composer4, 0, 7), z2, Role.m3825boximpl(Role.INSTANCE.m3837getTabo7Vup1c()), onClick);
                        Function2<Composer, Integer, Unit> function2 = content;
                        int i12 = $dirty12;
                        $composer4.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, true, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv = (384 << 3) & SdkConfig.SDK_VERSION;
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
                        } else {
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            int $changed3 = ((384 >> 6) & SdkConfig.SDK_VERSION) | 6;
                            $composer4.startReplaceableGroup(23612267);
                            ComposerKt.sourceInformation($composer4, "C364@17888L9:Surface.kt#jmzs0o");
                            if (($changed3 & 81) == 16 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                            } else {
                                function2.invoke($composer4, Integer.valueOf(i12 & 14));
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
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier2;
        final boolean z3 = enabled2;
        final Shape shape5 = shape2;
        final long j2 = color3;
        final long j3 = contentColor3;
        final BorderStroke borderStroke2 = border3;
        final float f2 = elevation3;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$8
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
                SurfaceKt.m1515SurfaceNy5ogXk(selected, onClick, modifier5, z3, shape5, j2, j3, borderStroke2, f2, mutableInteractionSource2, content, composer, $changed | 1, $changed1, i);
            }
        });
    }

    @ExperimentalMaterialApi
    /* renamed from: Surface-Ny5ogXk, reason: not valid java name */
    public static final void m1516SurfaceNy5ogXk(final boolean checked, final Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean z;
        int i2;
        int $dirty;
        long color2;
        long contentColor2;
        BorderStroke border2;
        float elevation2;
        BorderStroke border3;
        float elevation3;
        MutableInteractionSource interactionSource2;
        Modifier modifier2;
        int $dirty2;
        long contentColor3;
        boolean enabled2;
        long color3;
        Shape shape2;
        Object value$iv$iv;
        Composer $composer2;
        int $dirty3;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(1341569296);
        ComposerKt.sourceInformation($composer3, "C(Surface)P(1,9,8,6,10,2:c#ui.graphics.Color,4:c#ui.graphics.Color!1,5:c#ui.unit.Dp,7)446@22479L6,447@22521L22,450@22655L39,*453@22787L7,454@22811L1065:Surface.kt#jmzs0o");
        int $dirty4 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer3.changed(checked) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty4 |= $composer3.changed(onCheckedChange) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty4 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty4 |= 3072;
            z = enabled;
        } else if (($changed & 7168) == 0) {
            z = enabled;
            $dirty4 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty4 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty4 |= $composer3.changed(shape) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                i2 = i6;
                if ($composer3.changed(color)) {
                    i4 = 131072;
                    $dirty4 |= i4;
                }
            } else {
                i2 = i6;
            }
            i4 = 65536;
            $dirty4 |= i4;
        } else {
            i2 = i6;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                $dirty3 = $dirty4;
                if ($composer3.changed(contentColor)) {
                    i3 = 1048576;
                    $dirty = $dirty3 | i3;
                }
            } else {
                $dirty3 = $dirty4;
            }
            i3 = 524288;
            $dirty = $dirty3 | i3;
        } else {
            $dirty = $dirty4;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if ((29360128 & $changed) == 0) {
            $dirty |= $composer3.changed(border) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer3.changed(elevation) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer3.changed(interactionSource) ? 536870912 : 268435456;
        }
        if ((i & 1024) != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changed(content) ? 4 : 2;
        }
        if (($dirty & 1533916891) == 306783378 && ($dirty1 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            shape2 = shape;
            color3 = color;
            contentColor3 = contentColor;
            border3 = border;
            elevation3 = elevation;
            interactionSource2 = interactionSource;
            $composer2 = $composer3;
            enabled2 = z;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i5 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled3 = i2 != 0 ? true : z;
                Shape shape3 = i7 != 0 ? RectangleShapeKt.getRectangleShape() : shape;
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    color2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1321getSurface0d7_KjU();
                } else {
                    color2 = color;
                }
                if ((i & 64) != 0) {
                    contentColor2 = ColorsKt.m1335contentColorForek8zF_U(color2, $composer3, ($dirty >> 15) & 14);
                    $dirty &= -3670017;
                } else {
                    contentColor2 = contentColor;
                }
                BorderStroke border4 = i8 != 0 ? null : border;
                if (i9 != 0) {
                    border2 = border4;
                    elevation2 = C0504Dp.m4382constructorimpl(0);
                } else {
                    border2 = border4;
                    elevation2 = elevation;
                }
                if (i10 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    float elevation4 = elevation2;
                    Object it$iv$iv = $composer3.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    border3 = border2;
                    elevation3 = elevation4;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    modifier2 = modifier3;
                    $dirty2 = $dirty;
                    contentColor3 = contentColor2;
                    enabled2 = enabled3;
                    color3 = color2;
                    shape2 = shape3;
                } else {
                    border3 = border2;
                    elevation3 = elevation2;
                    interactionSource2 = interactionSource;
                    modifier2 = modifier3;
                    $dirty2 = $dirty;
                    contentColor3 = contentColor2;
                    enabled2 = enabled3;
                    color3 = color2;
                    shape2 = shape3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    modifier2 = modifier;
                    shape2 = shape;
                    color3 = color;
                    contentColor3 = contentColor;
                    border3 = border;
                    elevation3 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty & (-3670017);
                    enabled2 = z;
                } else {
                    modifier2 = modifier;
                    shape2 = shape;
                    color3 = color;
                    contentColor3 = contentColor;
                    border3 = border;
                    elevation3 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty;
                    enabled2 = z;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1341569296, $dirty2, $dirty1, "androidx.compose.material.Surface (Surface.kt:440)");
            }
            ProvidableCompositionLocal<C0504Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            float arg0$iv = ((C0504Dp) consume).m4396unboximpl();
            final float absoluteElevation = C0504Dp.m4382constructorimpl(arg0$iv + elevation3);
            final Modifier modifier4 = modifier2;
            final int $dirty12 = $dirty1;
            final Shape shape4 = shape2;
            final long j = color3;
            final int i11 = $dirty2;
            final BorderStroke borderStroke = border3;
            final float f = elevation3;
            final MutableInteractionSource mutableInteractionSource = interactionSource2;
            final boolean z2 = enabled2;
            $composer2 = $composer3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1986boximpl(contentColor3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C0504Dp.m4380boximpl(absoluteElevation))}, ComposableLambdaKt.composableLambda($composer2, -311657392, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$10
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
                    long m1520surfaceColorAtElevationcq6XJ1M;
                    Modifier m1519surface8ww4TTg;
                    ComposerKt.sourceInformation($composer4, "C465@23267L7,463@23138L221,474@23616L16,458@22960L910:Surface.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-311657392, $changed2, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:457)");
                        }
                        Modifier minimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(Modifier.this);
                        Shape shape5 = shape4;
                        long j2 = j;
                        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume2 = $composer4.consume(localElevationOverlay);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        m1520surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1520surfaceColorAtElevationcq6XJ1M(j2, (ElevationOverlay) consume2, absoluteElevation, $composer4, (i11 >> 15) & 14);
                        m1519surface8ww4TTg = SurfaceKt.m1519surface8ww4TTg(minimumTouchTargetSize, shape5, m1520surfaceColorAtElevationcq6XJ1M, borderStroke, f);
                        Modifier modifier$iv = ToggleableKt.m984toggleableO2vRcR0(m1519surface8ww4TTg, checked, mutableInteractionSource, RippleKt.m1618rememberRipple9IZ8Weo(false, 0.0f, 0L, $composer4, 0, 7), z2, Role.m3825boximpl(Role.INSTANCE.m3836getSwitcho7Vup1c()), onCheckedChange);
                        Function2<Composer, Integer, Unit> function2 = content;
                        int i12 = $dirty12;
                        $composer4.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, true, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv = (384 << 3) & SdkConfig.SDK_VERSION;
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
                        } else {
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            int $changed3 = ((384 >> 6) & SdkConfig.SDK_VERSION) | 6;
                            $composer4.startReplaceableGroup(1103154314);
                            ComposerKt.sourceInformation($composer4, "C481@23851L9:Surface.kt#jmzs0o");
                            if (($changed3 & 81) == 16 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                            } else {
                                function2.invoke($composer4, Integer.valueOf(i12 & 14));
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
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier2;
        final boolean z3 = enabled2;
        final Shape shape5 = shape2;
        final long j2 = color3;
        final long j3 = contentColor3;
        final BorderStroke borderStroke2 = border3;
        final float f2 = elevation3;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$11
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
                SurfaceKt.m1516SurfaceNy5ogXk(checked, onCheckedChange, modifier5, z3, shape5, j2, j3, borderStroke2, f2, mutableInteractionSource2, content, composer, $changed | 1, $changed1, i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This API is deprecated with the introduction a newer Surface function overload that accepts an onClick().", replaceWith = @ReplaceWith(expression = "Surface(onClick, modifier, enabled, shape, color, contentColor, border, elevation, interactionSource, content)", imports = {}))
    @ExperimentalMaterialApi
    /* renamed from: Surface-9VG74zQ, reason: not valid java name */
    public static final void m1512Surface9VG74zQ(final Function0<Unit> onClick, Modifier modifier, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, Indication indication, boolean enabled, String onClickLabel, Role role, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, final int i) {
        int $dirty;
        Modifier modifier2;
        long color2;
        long contentColor2;
        long color3;
        float elevation2;
        float elevation3;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        Indication indication2;
        MutableInteractionSource interactionSource4;
        float elevation4;
        Role role2;
        Indication indication3;
        boolean enabled2;
        String onClickLabel2;
        BorderStroke border2;
        long color4;
        Modifier modifier3;
        Shape shape2;
        int $dirty2;
        Object value$iv$iv;
        Composer $composer2;
        Role role3;
        String onClickLabel3;
        boolean enabled3;
        Indication indication4;
        MutableInteractionSource interactionSource5;
        float elevation5;
        BorderStroke border3;
        long color5;
        Modifier modifier4;
        Shape shape3;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(1585925488);
        ComposerKt.sourceInformation($composer3, "C(Surface)P(9,8,12,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,7,6,5,10,11:c#ui.semantics.Role)575@29078L6,576@29120L22,579@29254L39,580@29341L7,*586@29528L7,587@29552L1119:Surface.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changed(onClick) ? 4 : 2;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty3 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 32 : 16;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer3.changed(shape) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0 && $composer3.changed(color)) {
                i4 = 2048;
                $dirty3 |= i4;
            }
            i4 = 1024;
            $dirty3 |= i4;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0 && $composer3.changed(contentColor)) {
                i3 = 16384;
                $dirty3 |= i3;
            }
            i3 = 8192;
            $dirty3 |= i3;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty3 |= 196608;
        } else if (($changed & 458752) == 0) {
            $dirty3 |= $composer3.changed(border) ? 131072 : 65536;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty3 |= $composer3.changed(elevation) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty3 |= $composer3.changed(interactionSource) ? 8388608 : 4194304;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0 && $composer3.changed(indication)) {
                i2 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty3 |= i2;
            }
            i2 = 33554432;
            $dirty3 |= i2;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty3 |= $composer3.changed(enabled) ? 536870912 : 268435456;
        }
        int i11 = i & 1024;
        if (i11 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changed(onClickLabel) ? 4 : 2;
        }
        int i12 = i & 2048;
        if (i12 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & SdkConfig.SDK_VERSION) == 0) {
            $dirty1 |= $composer3.changed(role) ? 32 : 16;
        }
        if ((i & 4096) != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty1 |= $composer3.changed(content) ? 256 : 128;
        }
        final int $dirty12 = $dirty1;
        if ((1533916891 & $dirty3) == 306783378 && ($dirty12 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier;
            shape3 = shape;
            color5 = color;
            contentColor2 = contentColor;
            border3 = border;
            elevation5 = elevation;
            interactionSource5 = interactionSource;
            indication4 = indication;
            enabled3 = enabled;
            onClickLabel3 = onClickLabel;
            role3 = role;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i5 != 0 ? Modifier.INSTANCE : modifier;
                Shape shape4 = i6 != 0 ? RectangleShapeKt.getRectangleShape() : shape;
                if ((i & 8) != 0) {
                    $dirty = $dirty3 & (-7169);
                    modifier2 = modifier5;
                    color2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1321getSurface0d7_KjU();
                } else {
                    $dirty = $dirty3;
                    modifier2 = modifier5;
                    color2 = color;
                }
                if ((i & 16) != 0) {
                    contentColor2 = ColorsKt.m1335contentColorForek8zF_U(color2, $composer3, ($dirty >> 9) & 14);
                    $dirty &= -57345;
                } else {
                    contentColor2 = contentColor;
                }
                BorderStroke border4 = i7 != 0 ? null : border;
                if (i8 != 0) {
                    color3 = color2;
                    elevation2 = C0504Dp.m4382constructorimpl(0);
                } else {
                    color3 = color2;
                    elevation2 = elevation;
                }
                if (i9 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    elevation3 = elevation2;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    elevation3 = elevation2;
                    interactionSource2 = interactionSource;
                }
                if ((i & 256) != 0) {
                    ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
                    interactionSource3 = interactionSource2;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(localIndication);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    indication2 = (Indication) consume;
                    $dirty &= -234881025;
                } else {
                    interactionSource3 = interactionSource2;
                    indication2 = indication;
                }
                boolean enabled4 = i10 != 0 ? true : enabled;
                String onClickLabel4 = i11 != 0 ? null : onClickLabel;
                if (i12 != 0) {
                    interactionSource4 = interactionSource3;
                    elevation4 = elevation3;
                    indication3 = indication2;
                    enabled2 = enabled4;
                    onClickLabel2 = onClickLabel4;
                    role2 = null;
                    border2 = border4;
                    color4 = color3;
                    modifier3 = modifier2;
                    shape2 = shape4;
                    $dirty2 = $dirty;
                } else {
                    interactionSource4 = interactionSource3;
                    elevation4 = elevation3;
                    role2 = role;
                    indication3 = indication2;
                    enabled2 = enabled4;
                    onClickLabel2 = onClickLabel4;
                    border2 = border4;
                    color4 = color3;
                    modifier3 = modifier2;
                    shape2 = shape4;
                    $dirty2 = $dirty;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty3 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 256) != 0) {
                    modifier3 = modifier;
                    shape2 = shape;
                    color4 = color;
                    contentColor2 = contentColor;
                    border2 = border;
                    elevation4 = elevation;
                    interactionSource4 = interactionSource;
                    indication3 = indication;
                    enabled2 = enabled;
                    onClickLabel2 = onClickLabel;
                    role2 = role;
                    $dirty2 = $dirty3 & (-234881025);
                } else {
                    modifier3 = modifier;
                    shape2 = shape;
                    color4 = color;
                    contentColor2 = contentColor;
                    border2 = border;
                    elevation4 = elevation;
                    interactionSource4 = interactionSource;
                    indication3 = indication;
                    enabled2 = enabled;
                    onClickLabel2 = onClickLabel;
                    role2 = role;
                    $dirty2 = $dirty3;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1585925488, $dirty2, $dirty12, "androidx.compose.material.Surface (Surface.kt:571)");
            }
            ProvidableCompositionLocal<C0504Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            float arg0$iv = ((C0504Dp) consume2).m4396unboximpl();
            final float absoluteElevation = C0504Dp.m4382constructorimpl(arg0$iv + elevation4);
            final Modifier modifier6 = modifier3;
            final Shape shape5 = shape2;
            final long j = color4;
            final int i13 = $dirty2;
            final BorderStroke borderStroke = border2;
            final float f = elevation4;
            final MutableInteractionSource mutableInteractionSource = interactionSource4;
            final Indication indication5 = indication3;
            final boolean z = enabled2;
            final String str = onClickLabel2;
            final Role role4 = role2;
            $composer2 = $composer3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1986boximpl(contentColor2)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C0504Dp.m4380boximpl(absoluteElevation))}, ComposableLambdaKt.composableLambda($composer2, 149594672, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$13
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
                    long m1520surfaceColorAtElevationcq6XJ1M;
                    Modifier m1519surface8ww4TTg;
                    ComposerKt.sourceInformation($composer4, "C598@29997L7,596@29868L221,591@29701L964:Surface.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(149594672, $changed2, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:590)");
                        }
                        Modifier minimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(Modifier.this);
                        Shape shape6 = shape5;
                        long j2 = j;
                        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume3 = $composer4.consume(localElevationOverlay);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        m1520surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1520surfaceColorAtElevationcq6XJ1M(j2, (ElevationOverlay) consume3, absoluteElevation, $composer4, (i13 >> 9) & 14);
                        m1519surface8ww4TTg = SurfaceKt.m1519surface8ww4TTg(minimumTouchTargetSize, shape6, m1520surfaceColorAtElevationcq6XJ1M, borderStroke, f);
                        Modifier modifier$iv = m1519surface8ww4TTg.then(ClickableKt.m511clickableO2vRcR0(Modifier.INSTANCE, mutableInteractionSource, indication5, z, str, role4, onClick));
                        Function2<Composer, Integer, Unit> function2 = content;
                        int i14 = $dirty12;
                        $composer4.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, true, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv = (384 << 3) & SdkConfig.SDK_VERSION;
                        $composer4.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume4 = $composer4.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Density density$iv$iv = (Density) consume4;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume5 = $composer4.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume5;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume6 = $composer4.consume(localViewConfiguration);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume6;
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
                            int $changed3 = ((384 >> 6) & SdkConfig.SDK_VERSION) | 6;
                            $composer4.startReplaceableGroup(-1300719946);
                            ComposerKt.sourceInformation($composer4, "C616@30646L9:Surface.kt#jmzs0o");
                            if (($changed3 & 81) == 16 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                            } else {
                                function2.invoke($composer4, Integer.valueOf((i14 >> 6) & 14));
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
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            role3 = role2;
            onClickLabel3 = onClickLabel2;
            enabled3 = enabled2;
            indication4 = indication3;
            interactionSource5 = interactionSource4;
            elevation5 = elevation4;
            border3 = border2;
            color5 = color4;
            modifier4 = modifier3;
            shape3 = shape2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier7 = modifier4;
        final Shape shape6 = shape3;
        final long j2 = color5;
        final long j3 = contentColor2;
        final BorderStroke borderStroke2 = border3;
        final float f2 = elevation5;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource5;
        final Indication indication6 = indication4;
        final boolean z2 = enabled3;
        final String str2 = onClickLabel3;
        final Role role5 = role3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$14
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

            public final void invoke(Composer composer, int i14) {
                SurfaceKt.m1512Surface9VG74zQ(onClick, modifier7, shape6, j2, j3, borderStroke2, f2, mutableInteractionSource2, indication6, z2, str2, role5, content, composer, $changed | 1, $changed1, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: surface-8ww4TTg, reason: not valid java name */
    public static final Modifier m1519surface8ww4TTg(Modifier $this$surface_u2d8ww4TTg, Shape shape, long backgroundColor, BorderStroke border, float elevation) {
        Modifier m1677shadows4CzXII;
        m1677shadows4CzXII = ShadowKt.m1677shadows4CzXII($this$surface_u2d8ww4TTg, elevation, (r15 & 2) != 0 ? RectangleShapeKt.getRectangleShape() : shape, (r15 & 4) != 0 ? C0504Dp.m4381compareTo0680j_4(r8, C0504Dp.m4382constructorimpl((float) 0)) > 0 : false, (r15 & 8) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (r15 & 16) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L);
        Modifier.Companion companion = Modifier.INSTANCE;
        if (border != null) {
            companion = BorderKt.border(companion, border, shape);
        }
        return ClipKt.clip(BackgroundKt.m494backgroundbw27NRU(m1677shadows4CzXII.then(companion), backgroundColor, shape), shape);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: surfaceColorAtElevation-cq6XJ1M, reason: not valid java name */
    public static final long m1520surfaceColorAtElevationcq6XJ1M(long color, ElevationOverlay elevationOverlay, float absoluteElevation, Composer $composer, int $changed) {
        long j;
        $composer.startReplaceableGroup(1561611256);
        ComposerKt.sourceInformation($composer, "C(surfaceColorAtElevation)P(1:c#ui.graphics.Color,2,0:c#ui.unit.Dp)637@31177L6,638@31248L31:Surface.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1561611256, $changed, -1, "androidx.compose.material.surfaceColorAtElevation (Surface.kt:632)");
        }
        if (Color.m1997equalsimpl0(color, MaterialTheme.INSTANCE.getColors($composer, 6).m1321getSurface0d7_KjU()) && elevationOverlay != null) {
            j = elevationOverlay.mo1351apply7g2Lkgo(color, absoluteElevation, $composer, ($changed & 14) | (($changed >> 3) & SdkConfig.SDK_VERSION) | (($changed << 3) & 896));
        } else {
            j = color;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return j;
    }
}
