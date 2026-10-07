package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.ClipScrollableContainerKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.IntOffsetKt;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.health.platform.client.SdkConfig;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyGrid.kt */
@Metadata(m286d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u009e\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052#\u0010\u0006\u001a\u001f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\fH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u001d\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010 \u001a\u0018\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002\u001a\u009c\u0001\u0010&\u001a\u0019\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020(0\u0007¢\u0006\u0002\b\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#2#\u0010\u0006\u001a\u001f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010)\u001a\u00020*H\u0003ø\u0001\u0000¢\u0006\u0002\u0010+\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, m287d2 = {"LazyGrid", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "slotSizesSums", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "", "", "Lkotlin/ExtensionFunctionType;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/runtime/Composer;I)V", "refreshOverscrollInfo", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "result", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "rememberLazyGridMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureResult;", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyGridKt {
    /* JADX WARN: Removed duplicated region for block: B:105:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02e8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyGrid(Modifier modifier, final LazyGridState state, final Function2<? super Density, ? super Constraints, ? extends List<Integer>> slotSizesSums, PaddingValues contentPadding, boolean reverseLayout, final boolean isVertical, FlingBehavior flingBehavior, final boolean userScrollEnabled, final Arrangement.Vertical verticalArrangement, final Arrangement.Horizontal horizontalArrangement, final Function1<? super LazyGridScope, Unit> content, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        FlingBehavior flingBehavior2;
        PaddingValues contentPadding2;
        boolean reverseLayout2;
        int $dirty;
        Object it$iv$iv$iv;
        Object value$iv$iv$iv;
        boolean invalid$iv$iv;
        Composer $composer2;
        boolean reverseLayout3;
        Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i2;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(slotSizesSums, "slotSizesSums");
        Intrinsics.checkNotNullParameter(verticalArrangement, "verticalArrangement");
        Intrinsics.checkNotNullParameter(horizontalArrangement, "horizontalArrangement");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(152645664);
        ComposerKt.sourceInformation($composer3, "C(LazyGrid)P(5,8,7,1,6,4,2,9,10,3)66@3100L15,76@3541L18,78@3584L44,80@3654L65,82@3737L24,83@3790L92,88@3956L275,103@4272L42,110@4552L215,121@5041L7,106@4407L1113:LazyGrid.kt#7791vq");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        int i6 = i & 1;
        if (i6 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer3.changed(state) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changed(slotSizesSums) ? 256 : 128;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changed(contentPadding) ? 2048 : 1024;
        }
        int i8 = i & 16;
        if (i8 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty2 |= $composer3.changed(reverseLayout) ? 16384 : 8192;
        }
        if ((i & 32) == 0) {
            i5 = ($changed & 458752) == 0 ? $composer3.changed(isVertical) ? 131072 : 65536 : 196608;
            if (($changed & 3670016) == 0) {
                if ((i & 64) == 0 && $composer3.changed(flingBehavior)) {
                    i4 = 1048576;
                    $dirty2 |= i4;
                }
                i4 = 524288;
                $dirty2 |= i4;
            }
            if ((i & 128) == 0) {
                $dirty2 |= 12582912;
            } else if (($changed & 29360128) == 0) {
                $dirty2 |= $composer3.changed(userScrollEnabled) ? 8388608 : 4194304;
            }
            if ((i & 256) != 0) {
                i3 = ($changed & 234881024) == 0 ? $composer3.changed(verticalArrangement) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432 : 100663296;
                if ((i & 512) == 0) {
                    i2 = (1879048192 & $changed) == 0 ? $composer3.changed(horizontalArrangement) ? 536870912 : 268435456 : 805306368;
                    if ((i & 1024) == 0) {
                        $dirty1 |= 6;
                    } else if (($changed1 & 14) == 0) {
                        $dirty1 |= $composer3.changed(content) ? 4 : 2;
                    }
                    if ((1533916891 & $dirty2) != 306783378 && ($dirty1 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        contentPadding2 = contentPadding;
                        reverseLayout3 = reverseLayout;
                        flingBehavior2 = flingBehavior;
                        modifier3 = modifier2;
                        $composer2 = $composer3;
                    } else {
                        $composer3.startDefaults();
                        if (($changed & 1) != 0 || $composer3.getDefaultsInvalid()) {
                            if (i6 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            PaddingValues contentPadding3 = i7 == 0 ? PaddingKt.m752PaddingValues0680j_4(C0504Dp.m4382constructorimpl(0)) : contentPadding;
                            boolean reverseLayout4 = i8 == 0 ? false : reverseLayout;
                            if ((i & 64) == 0) {
                                contentPadding2 = contentPadding3;
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior($composer3, 6);
                                reverseLayout2 = reverseLayout4;
                                $dirty = $dirty2 & (-3670017);
                            } else {
                                flingBehavior2 = flingBehavior;
                                contentPadding2 = contentPadding3;
                                reverseLayout2 = reverseLayout4;
                                $dirty = $dirty2;
                            }
                        } else {
                            $composer3.skipToGroupEnd();
                            if ((i & 64) != 0) {
                                contentPadding2 = contentPadding;
                                reverseLayout2 = reverseLayout;
                                flingBehavior2 = flingBehavior;
                                $dirty = $dirty2 & (-3670017);
                            } else {
                                contentPadding2 = contentPadding;
                                reverseLayout2 = reverseLayout;
                                flingBehavior2 = flingBehavior;
                                $dirty = $dirty2;
                            }
                        }
                        $composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(152645664, $dirty, $dirty1, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)");
                        }
                        OverscrollEffect overscrollEffect = ScrollableDefaults.INSTANCE.overscrollEffect($composer3, 6);
                        LazyGridItemProvider itemProvider = LazyGridItemProviderKt.rememberLazyGridItemProvider(state, content, $composer3, (($dirty >> 3) & 14) | (($dirty1 << 3) & SdkConfig.SDK_VERSION));
                        LazyLayoutSemanticState semanticState = LazySemanticsKt.rememberLazyGridSemanticState(state, itemProvider, reverseLayout2, $composer3, (($dirty >> 3) & 14) | (($dirty >> 6) & 896));
                        $composer3.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation($composer3, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                        it$iv$iv$iv = $composer3.rememberedValue();
                        boolean reverseLayout5 = reverseLayout2;
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
                        Object key2$iv = Boolean.valueOf(isVertical);
                        int i9 = (($dirty >> 3) & 14) | (($dirty >> 12) & SdkConfig.SDK_VERSION);
                        $composer3.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation($composer3, "C(remember)P(1,2):Composables.kt#9igjgp");
                        invalid$iv$iv = $composer3.changed(state) | $composer3.changed(key2$iv);
                        Object value$iv$iv = $composer3.rememberedValue();
                        if (!invalid$iv$iv && value$iv$iv != Composer.INSTANCE.getEmpty()) {
                            $composer3.endReplaceableGroup();
                            LazyGridItemPlacementAnimator placementAnimator = (LazyGridItemPlacementAnimator) value$iv$iv;
                            state.setPlacementAnimator$foundation_release(placementAnimator);
                            int $dirty3 = $dirty;
                            Modifier modifier4 = modifier2;
                            Function2 measurePolicy = rememberLazyGridMeasurePolicy(itemProvider, state, overscrollEffect, slotSizesSums, contentPadding2, reverseLayout5, isVertical, horizontalArrangement, verticalArrangement, placementAnimator, $composer3, ($dirty & SdkConfig.SDK_VERSION) | Ints.MAX_POWER_OF_TWO | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (($dirty << 3) & 3670016) | (($dirty >> 6) & 29360128) | ($dirty & 234881024), 0);
                            state.setVertical$foundation_release(isVertical);
                            $composer2 = $composer3;
                            ScrollPositionUpdater(itemProvider, state, $composer2, $dirty3 & SdkConfig.SDK_VERSION);
                            Orientation orientation = !isVertical ? Orientation.Vertical : Orientation.Horizontal;
                            Modifier overscroll = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier4.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), itemProvider, semanticState, orientation, userScrollEnabled, $composer2, ($dirty3 >> 9) & 57344), orientation), overscrollEffect);
                            ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume = $composer2.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            reverseLayout3 = reverseLayout5;
                            LazyLayoutKt.LazyLayout(itemProvider, ScrollableKt.scrollable(overscroll, state, orientation, overscrollEffect, userScrollEnabled, scrollableDefaults.reverseDirection((LayoutDirection) consume, orientation, reverseLayout5), flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), measurePolicy, $composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                        }
                        value$iv$iv = new LazyGridItemPlacementAnimator(scope, isVertical);
                        $composer3.updateRememberedValue(value$iv$iv);
                        $composer3.endReplaceableGroup();
                        LazyGridItemPlacementAnimator placementAnimator2 = (LazyGridItemPlacementAnimator) value$iv$iv;
                        state.setPlacementAnimator$foundation_release(placementAnimator2);
                        int $dirty32 = $dirty;
                        Modifier modifier42 = modifier2;
                        Function2 measurePolicy2 = rememberLazyGridMeasurePolicy(itemProvider, state, overscrollEffect, slotSizesSums, contentPadding2, reverseLayout5, isVertical, horizontalArrangement, verticalArrangement, placementAnimator2, $composer3, ($dirty & SdkConfig.SDK_VERSION) | Ints.MAX_POWER_OF_TWO | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (($dirty << 3) & 3670016) | (($dirty >> 6) & 29360128) | ($dirty & 234881024), 0);
                        state.setVertical$foundation_release(isVertical);
                        $composer2 = $composer3;
                        ScrollPositionUpdater(itemProvider, state, $composer2, $dirty32 & SdkConfig.SDK_VERSION);
                        Orientation orientation2 = !isVertical ? Orientation.Vertical : Orientation.Horizontal;
                        Modifier overscroll2 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier42.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), itemProvider, semanticState, orientation2, userScrollEnabled, $composer2, ($dirty32 >> 9) & 57344), orientation2), overscrollEffect);
                        ScrollableDefaults scrollableDefaults2 = ScrollableDefaults.INSTANCE;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume2 = $composer2.consume(localLayoutDirection2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        reverseLayout3 = reverseLayout5;
                        LazyLayoutKt.LazyLayout(itemProvider, ScrollableKt.scrollable(overscroll2, state, orientation2, overscrollEffect, userScrollEnabled, scrollableDefaults2.reverseDirection((LayoutDirection) consume2, orientation2, reverseLayout5), flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), measurePolicy2, $composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier42;
                    }
                    endRestartGroup = $composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        return;
                    }
                    final Modifier modifier5 = modifier3;
                    final PaddingValues paddingValues = contentPadding2;
                    final boolean z = reverseLayout3;
                    final FlingBehavior flingBehavior3 = flingBehavior2;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$LazyGrid$1
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
                            LazyGridKt.LazyGrid(Modifier.this, state, slotSizesSums, paddingValues, z, isVertical, flingBehavior3, userScrollEnabled, verticalArrangement, horizontalArrangement, content, composer, $changed | 1, $changed1, i);
                        }
                    });
                    return;
                }
                $dirty2 |= i2;
                if ((i & 1024) == 0) {
                }
                if ((1533916891 & $dirty2) != 306783378) {
                }
                $composer3.startDefaults();
                if (($changed & 1) != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 == 0) {
                }
                if (i8 == 0) {
                }
                if ((i & 64) == 0) {
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                OverscrollEffect overscrollEffect2 = ScrollableDefaults.INSTANCE.overscrollEffect($composer3, 6);
                LazyGridItemProvider itemProvider2 = LazyGridItemProviderKt.rememberLazyGridItemProvider(state, content, $composer3, (($dirty >> 3) & 14) | (($dirty1 << 3) & SdkConfig.SDK_VERSION));
                LazyLayoutSemanticState semanticState2 = LazySemanticsKt.rememberLazyGridSemanticState(state, itemProvider2, reverseLayout2, $composer3, (($dirty >> 3) & 14) | (($dirty >> 6) & 896));
                $composer3.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation($composer3, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                $composer3.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                it$iv$iv$iv = $composer3.rememberedValue();
                boolean reverseLayout52 = reverseLayout2;
                if (it$iv$iv$iv != Composer.INSTANCE.getEmpty()) {
                }
                $composer3.endReplaceableGroup();
                CompositionScopedCoroutineScopeCanceller wrapper$iv2 = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                CoroutineScope scope2 = wrapper$iv2.getCoroutineScope();
                $composer3.endReplaceableGroup();
                Object key2$iv2 = Boolean.valueOf(isVertical);
                int i92 = (($dirty >> 3) & 14) | (($dirty >> 12) & SdkConfig.SDK_VERSION);
                $composer3.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer3, "C(remember)P(1,2):Composables.kt#9igjgp");
                invalid$iv$iv = $composer3.changed(state) | $composer3.changed(key2$iv2);
                Object value$iv$iv2 = $composer3.rememberedValue();
                if (!invalid$iv$iv) {
                    $composer3.endReplaceableGroup();
                    LazyGridItemPlacementAnimator placementAnimator22 = (LazyGridItemPlacementAnimator) value$iv$iv2;
                    state.setPlacementAnimator$foundation_release(placementAnimator22);
                    int $dirty322 = $dirty;
                    Modifier modifier422 = modifier2;
                    Function2 measurePolicy22 = rememberLazyGridMeasurePolicy(itemProvider2, state, overscrollEffect2, slotSizesSums, contentPadding2, reverseLayout52, isVertical, horizontalArrangement, verticalArrangement, placementAnimator22, $composer3, ($dirty & SdkConfig.SDK_VERSION) | Ints.MAX_POWER_OF_TWO | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (($dirty << 3) & 3670016) | (($dirty >> 6) & 29360128) | ($dirty & 234881024), 0);
                    state.setVertical$foundation_release(isVertical);
                    $composer2 = $composer3;
                    ScrollPositionUpdater(itemProvider2, state, $composer2, $dirty322 & SdkConfig.SDK_VERSION);
                    Orientation orientation22 = !isVertical ? Orientation.Vertical : Orientation.Horizontal;
                    Modifier overscroll22 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier422.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), itemProvider2, semanticState2, orientation22, userScrollEnabled, $composer2, ($dirty322 >> 9) & 57344), orientation22), overscrollEffect2);
                    ScrollableDefaults scrollableDefaults22 = ScrollableDefaults.INSTANCE;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume22 = $composer2.consume(localLayoutDirection22);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    reverseLayout3 = reverseLayout52;
                    LazyLayoutKt.LazyLayout(itemProvider2, ScrollableKt.scrollable(overscroll22, state, orientation22, overscrollEffect2, userScrollEnabled, scrollableDefaults22.reverseDirection((LayoutDirection) consume22, orientation22, reverseLayout52), flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), measurePolicy22, $composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier422;
                    endRestartGroup = $composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                value$iv$iv2 = new LazyGridItemPlacementAnimator(scope2, isVertical);
                $composer3.updateRememberedValue(value$iv$iv2);
                $composer3.endReplaceableGroup();
                LazyGridItemPlacementAnimator placementAnimator222 = (LazyGridItemPlacementAnimator) value$iv$iv2;
                state.setPlacementAnimator$foundation_release(placementAnimator222);
                int $dirty3222 = $dirty;
                Modifier modifier4222 = modifier2;
                Function2 measurePolicy222 = rememberLazyGridMeasurePolicy(itemProvider2, state, overscrollEffect2, slotSizesSums, contentPadding2, reverseLayout52, isVertical, horizontalArrangement, verticalArrangement, placementAnimator222, $composer3, ($dirty & SdkConfig.SDK_VERSION) | Ints.MAX_POWER_OF_TWO | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (($dirty << 3) & 3670016) | (($dirty >> 6) & 29360128) | ($dirty & 234881024), 0);
                state.setVertical$foundation_release(isVertical);
                $composer2 = $composer3;
                ScrollPositionUpdater(itemProvider2, state, $composer2, $dirty3222 & SdkConfig.SDK_VERSION);
                Orientation orientation222 = !isVertical ? Orientation.Vertical : Orientation.Horizontal;
                Modifier overscroll222 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier4222.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), itemProvider2, semanticState2, orientation222, userScrollEnabled, $composer2, ($dirty3222 >> 9) & 57344), orientation222), overscrollEffect2);
                ScrollableDefaults scrollableDefaults222 = ScrollableDefaults.INSTANCE;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection222 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume222 = $composer2.consume(localLayoutDirection222);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                reverseLayout3 = reverseLayout52;
                LazyLayoutKt.LazyLayout(itemProvider2, ScrollableKt.scrollable(overscroll222, state, orientation222, overscrollEffect2, userScrollEnabled, scrollableDefaults222.reverseDirection((LayoutDirection) consume222, orientation222, reverseLayout52), flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), measurePolicy222, $composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier4222;
                endRestartGroup = $composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            $dirty2 |= i3;
            if ((i & 512) == 0) {
            }
            $dirty2 |= i2;
            if ((i & 1024) == 0) {
            }
            if ((1533916891 & $dirty2) != 306783378) {
            }
            $composer3.startDefaults();
            if (($changed & 1) != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 == 0) {
            }
            if (i8 == 0) {
            }
            if ((i & 64) == 0) {
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            OverscrollEffect overscrollEffect22 = ScrollableDefaults.INSTANCE.overscrollEffect($composer3, 6);
            LazyGridItemProvider itemProvider22 = LazyGridItemProviderKt.rememberLazyGridItemProvider(state, content, $composer3, (($dirty >> 3) & 14) | (($dirty1 << 3) & SdkConfig.SDK_VERSION));
            LazyLayoutSemanticState semanticState22 = LazySemanticsKt.rememberLazyGridSemanticState(state, itemProvider22, reverseLayout2, $composer3, (($dirty >> 3) & 14) | (($dirty >> 6) & 896));
            $composer3.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation($composer3, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
            it$iv$iv$iv = $composer3.rememberedValue();
            boolean reverseLayout522 = reverseLayout2;
            if (it$iv$iv$iv != Composer.INSTANCE.getEmpty()) {
            }
            $composer3.endReplaceableGroup();
            CompositionScopedCoroutineScopeCanceller wrapper$iv22 = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
            CoroutineScope scope22 = wrapper$iv22.getCoroutineScope();
            $composer3.endReplaceableGroup();
            Object key2$iv22 = Boolean.valueOf(isVertical);
            int i922 = (($dirty >> 3) & 14) | (($dirty >> 12) & SdkConfig.SDK_VERSION);
            $composer3.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer3, "C(remember)P(1,2):Composables.kt#9igjgp");
            invalid$iv$iv = $composer3.changed(state) | $composer3.changed(key2$iv22);
            Object value$iv$iv22 = $composer3.rememberedValue();
            if (!invalid$iv$iv) {
            }
            value$iv$iv22 = new LazyGridItemPlacementAnimator(scope22, isVertical);
            $composer3.updateRememberedValue(value$iv$iv22);
            $composer3.endReplaceableGroup();
            LazyGridItemPlacementAnimator placementAnimator2222 = (LazyGridItemPlacementAnimator) value$iv$iv22;
            state.setPlacementAnimator$foundation_release(placementAnimator2222);
            int $dirty32222 = $dirty;
            Modifier modifier42222 = modifier2;
            Function2 measurePolicy2222 = rememberLazyGridMeasurePolicy(itemProvider22, state, overscrollEffect22, slotSizesSums, contentPadding2, reverseLayout522, isVertical, horizontalArrangement, verticalArrangement, placementAnimator2222, $composer3, ($dirty & SdkConfig.SDK_VERSION) | Ints.MAX_POWER_OF_TWO | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (($dirty << 3) & 3670016) | (($dirty >> 6) & 29360128) | ($dirty & 234881024), 0);
            state.setVertical$foundation_release(isVertical);
            $composer2 = $composer3;
            ScrollPositionUpdater(itemProvider22, state, $composer2, $dirty32222 & SdkConfig.SDK_VERSION);
            Orientation orientation2222 = !isVertical ? Orientation.Vertical : Orientation.Horizontal;
            Modifier overscroll2222 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier42222.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), itemProvider22, semanticState22, orientation2222, userScrollEnabled, $composer2, ($dirty32222 >> 9) & 57344), orientation2222), overscrollEffect22);
            ScrollableDefaults scrollableDefaults2222 = ScrollableDefaults.INSTANCE;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2222 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2222 = $composer2.consume(localLayoutDirection2222);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            reverseLayout3 = reverseLayout522;
            LazyLayoutKt.LazyLayout(itemProvider22, ScrollableKt.scrollable(overscroll2222, state, orientation2222, overscrollEffect22, userScrollEnabled, scrollableDefaults2222.reverseDirection((LayoutDirection) consume2222, orientation2222, reverseLayout522), flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), measurePolicy2222, $composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier42222;
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        $dirty2 |= i5;
        if (($changed & 3670016) == 0) {
        }
        if ((i & 128) == 0) {
        }
        if ((i & 256) != 0) {
        }
        $dirty2 |= i3;
        if ((i & 512) == 0) {
        }
        $dirty2 |= i2;
        if ((i & 1024) == 0) {
        }
        if ((1533916891 & $dirty2) != 306783378) {
        }
        $composer3.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
        if ((i & 64) == 0) {
        }
        $composer3.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        OverscrollEffect overscrollEffect222 = ScrollableDefaults.INSTANCE.overscrollEffect($composer3, 6);
        LazyGridItemProvider itemProvider222 = LazyGridItemProviderKt.rememberLazyGridItemProvider(state, content, $composer3, (($dirty >> 3) & 14) | (($dirty1 << 3) & SdkConfig.SDK_VERSION));
        LazyLayoutSemanticState semanticState222 = LazySemanticsKt.rememberLazyGridSemanticState(state, itemProvider222, reverseLayout2, $composer3, (($dirty >> 3) & 14) | (($dirty >> 6) & 896));
        $composer3.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation($composer3, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
        $composer3.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
        it$iv$iv$iv = $composer3.rememberedValue();
        boolean reverseLayout5222 = reverseLayout2;
        if (it$iv$iv$iv != Composer.INSTANCE.getEmpty()) {
        }
        $composer3.endReplaceableGroup();
        CompositionScopedCoroutineScopeCanceller wrapper$iv222 = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
        CoroutineScope scope222 = wrapper$iv222.getCoroutineScope();
        $composer3.endReplaceableGroup();
        Object key2$iv222 = Boolean.valueOf(isVertical);
        int i9222 = (($dirty >> 3) & 14) | (($dirty >> 12) & SdkConfig.SDK_VERSION);
        $composer3.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer3, "C(remember)P(1,2):Composables.kt#9igjgp");
        invalid$iv$iv = $composer3.changed(state) | $composer3.changed(key2$iv222);
        Object value$iv$iv222 = $composer3.rememberedValue();
        if (!invalid$iv$iv) {
        }
        value$iv$iv222 = new LazyGridItemPlacementAnimator(scope222, isVertical);
        $composer3.updateRememberedValue(value$iv$iv222);
        $composer3.endReplaceableGroup();
        LazyGridItemPlacementAnimator placementAnimator22222 = (LazyGridItemPlacementAnimator) value$iv$iv222;
        state.setPlacementAnimator$foundation_release(placementAnimator22222);
        int $dirty322222 = $dirty;
        Modifier modifier422222 = modifier2;
        Function2 measurePolicy22222 = rememberLazyGridMeasurePolicy(itemProvider222, state, overscrollEffect222, slotSizesSums, contentPadding2, reverseLayout5222, isVertical, horizontalArrangement, verticalArrangement, placementAnimator22222, $composer3, ($dirty & SdkConfig.SDK_VERSION) | Ints.MAX_POWER_OF_TWO | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (($dirty << 3) & 3670016) | (($dirty >> 6) & 29360128) | ($dirty & 234881024), 0);
        state.setVertical$foundation_release(isVertical);
        $composer2 = $composer3;
        ScrollPositionUpdater(itemProvider222, state, $composer2, $dirty322222 & SdkConfig.SDK_VERSION);
        Orientation orientation22222 = !isVertical ? Orientation.Vertical : Orientation.Horizontal;
        Modifier overscroll22222 = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier422222.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), itemProvider222, semanticState222, orientation22222, userScrollEnabled, $composer2, ($dirty322222 >> 9) & 57344), orientation22222), overscrollEffect222);
        ScrollableDefaults scrollableDefaults22222 = ScrollableDefaults.INSTANCE;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22222 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume22222 = $composer2.consume(localLayoutDirection22222);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        reverseLayout3 = reverseLayout5222;
        LazyLayoutKt.LazyLayout(itemProvider222, ScrollableKt.scrollable(overscroll22222, state, orientation22222, overscrollEffect222, userScrollEnabled, scrollableDefaults22222.reverseDirection((LayoutDirection) consume22222, orientation22222, reverseLayout5222), flingBehavior2, state.getInternalInteractionSource()), state.getPrefetchState(), measurePolicy22222, $composer2, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier422222;
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ScrollPositionUpdater(final LazyGridItemProvider itemProvider, final LazyGridState state, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(950944068);
        ComposerKt.sourceInformation($composer2, "C(ScrollPositionUpdater):LazyGrid.kt#7791vq");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(itemProvider) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(state) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(950944068, $changed, -1, "androidx.compose.foundation.lazy.grid.ScrollPositionUpdater (LazyGrid.kt:140)");
            }
            if (itemProvider.getItemCount() > 0) {
                state.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(itemProvider);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$ScrollPositionUpdater$1
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
                LazyGridKt.ScrollPositionUpdater(LazyGridItemProvider.this, state, composer, $changed | 1);
            }
        });
    }

    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy(final LazyGridItemProvider itemProvider, final LazyGridState state, final OverscrollEffect overscrollEffect, final Function2<? super Density, ? super Constraints, ? extends List<Integer>> function2, final PaddingValues contentPadding, final boolean reverseLayout, final boolean isVertical, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, final LazyGridItemPlacementAnimator placementAnimator, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(1958911962);
        ComposerKt.sourceInformation($composer, "C(rememberLazyGridMeasurePolicy)P(3,8,4,7!1,6,2!1,9)172@6984L8296:LazyGrid.kt#7791vq");
        Arrangement.Horizontal horizontalArrangement2 = (i & 128) != 0 ? null : horizontalArrangement;
        Arrangement.Vertical verticalArrangement2 = (i & 256) != 0 ? null : verticalArrangement;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1958911962, $changed, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridMeasurePolicy (LazyGrid.kt:151)");
        }
        Object[] keys$iv = {state, overscrollEffect, function2, contentPadding, Boolean.valueOf(reverseLayout), Boolean.valueOf(isVertical), horizontalArrangement2, verticalArrangement2, placementAnimator};
        $composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= $composer.changed(key$iv);
        }
        Object value$iv$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
            final Arrangement.Vertical vertical = verticalArrangement2;
            final Arrangement.Horizontal horizontal = horizontalArrangement2;
            value$iv$iv = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m924invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* JADX WARN: Can't wrap try/catch for region: R(31:0|1|(1:3)(1:127)|4|(1:6)(1:126)|7|(1:9)(1:125)|10|(1:12)(1:124)|13|(2:113|(2:118|(1:123)(1:122))(1:117))(1:17)|18|(2:20|(1:22)(2:106|107))(2:108|(1:110)(2:111|112))|23|(2:25|(1:27)(1:101))(2:102|(1:104)(1:105))|28|(1:30)(1:100)|31|(7:(5:(1:(1:34)(20:90|(1:92)(1:98)|93|(1:95)(1:97)|96|36|37|38|39|40|41|42|(5:73|74|76|77|78)(4:45|46|47|48)|49|50|51|52|53|54|55))(1:99)|52|53|54|55)|76|77|78|49|50|51)|35|36|37|38|39|40|41|42|(0)|73|74|(2:(0)|(1:68))) */
                /* JADX WARN: Code restructure failed: missing block: B:82:0x02b3, code lost:
                
                    r0 = th;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:83:0x02b4, code lost:
                
                    r10 = r19;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:85:0x02b9, code lost:
                
                    r0 = th;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:86:0x02ba, code lost:
                
                    r10 = r19;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:88:0x02c8, code lost:
                
                    r0 = th;
                 */
                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final LazyGridMeasureResult m924invoke0kLqBqw(final LazyLayoutMeasureScope $this$null, final long containerConstraints) {
                    int i2;
                    int i3;
                    int i4;
                    float spacing;
                    float spacing2;
                    int m4338getMaxWidthimpl;
                    int spaceBetweenLines;
                    long j;
                    LazyGridState lazyGridState;
                    Snapshot snapshot$iv;
                    Snapshot previous$iv$iv;
                    Snapshot previous$iv$iv2;
                    int firstVisibleLineIndex;
                    int firstVisibleLineScrollOffset;
                    int firstVisibleLineIndex2;
                    Intrinsics.checkNotNullParameter($this$null, "$this$null");
                    CheckScrollableContainerConstraintsKt.m510checkScrollableContainerConstraintsK40F9xA(containerConstraints, isVertical ? Orientation.Vertical : Orientation.Horizontal);
                    if (isVertical) {
                        i2 = $this$null.mo642roundToPx0680j_4(contentPadding.mo740calculateLeftPaddingu2uoSUM($this$null.getLayoutDirection()));
                    } else {
                        i2 = $this$null.mo642roundToPx0680j_4(PaddingKt.calculateStartPadding(contentPadding, $this$null.getLayoutDirection()));
                    }
                    int startPadding = i2;
                    if (isVertical) {
                        i3 = $this$null.mo642roundToPx0680j_4(contentPadding.mo741calculateRightPaddingu2uoSUM($this$null.getLayoutDirection()));
                    } else {
                        i3 = $this$null.mo642roundToPx0680j_4(PaddingKt.calculateEndPadding(contentPadding, $this$null.getLayoutDirection()));
                    }
                    int endPadding = i3;
                    int topPadding = $this$null.mo642roundToPx0680j_4(contentPadding.getTop());
                    int bottomPadding = $this$null.mo642roundToPx0680j_4(contentPadding.getBottom());
                    final int totalVerticalPadding = topPadding + bottomPadding;
                    final int totalHorizontalPadding = startPadding + endPadding;
                    int totalMainAxisPadding = isVertical ? totalVerticalPadding : totalHorizontalPadding;
                    if (isVertical && !reverseLayout) {
                        i4 = topPadding;
                    } else if (isVertical && reverseLayout) {
                        i4 = bottomPadding;
                    } else {
                        i4 = (isVertical || reverseLayout) ? endPadding : startPadding;
                    }
                    final int beforeContentPadding = i4;
                    final int afterContentPadding = totalMainAxisPadding - beforeContentPadding;
                    long contentConstraints = ConstraintsKt.m4354offsetNN6EwU(containerConstraints, -totalHorizontalPadding, -totalVerticalPadding);
                    state.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(itemProvider);
                    final LazyGridSpanLayoutProvider spanLayoutProvider = itemProvider.getSpanLayoutProvider();
                    final List resolvedSlotSizesSums = function2.invoke($this$null, Constraints.m4326boximpl(containerConstraints));
                    spanLayoutProvider.setSlotsPerLine(resolvedSlotSizesSums.size());
                    state.setDensity$foundation_release($this$null);
                    state.setSlotsPerLine$foundation_release(resolvedSlotSizesSums.size());
                    if (isVertical) {
                        Arrangement.Vertical vertical2 = vertical;
                        if (vertical2 == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        spacing = vertical2.getSpacing();
                    } else {
                        Arrangement.Horizontal horizontal2 = horizontal;
                        if (horizontal2 == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        spacing = horizontal2.getSpacing();
                    }
                    float spaceBetweenLinesDp = spacing;
                    int spaceBetweenLines2 = $this$null.mo642roundToPx0680j_4(spaceBetweenLinesDp);
                    if (isVertical) {
                        Arrangement.Horizontal horizontal3 = horizontal;
                        spacing2 = horizontal3 != null ? horizontal3.getSpacing() : C0504Dp.m4382constructorimpl(0);
                    } else {
                        Arrangement.Vertical vertical3 = vertical;
                        spacing2 = vertical3 != null ? vertical3.getSpacing() : C0504Dp.m4382constructorimpl(0);
                    }
                    float spaceBetweenSlotsDp = spacing2;
                    final int spaceBetweenSlots = $this$null.mo642roundToPx0680j_4(spaceBetweenSlotsDp);
                    int itemsCount = itemProvider.getItemCount();
                    if (isVertical) {
                        m4338getMaxWidthimpl = Constraints.m4337getMaxHeightimpl(containerConstraints) - totalVerticalPadding;
                    } else {
                        m4338getMaxWidthimpl = Constraints.m4338getMaxWidthimpl(containerConstraints) - totalHorizontalPadding;
                    }
                    int mainAxisAvailableSize = m4338getMaxWidthimpl;
                    try {
                        try {
                            try {
                                if (!reverseLayout) {
                                    spaceBetweenLines = spaceBetweenLines2;
                                } else {
                                    if (mainAxisAvailableSize <= 0) {
                                        spaceBetweenLines = spaceBetweenLines2;
                                        j = IntOffsetKt.IntOffset(isVertical ? startPadding : startPadding + mainAxisAvailableSize, isVertical ? topPadding + mainAxisAvailableSize : topPadding);
                                        final long visualItemOffset = j;
                                        LazyGridItemProvider lazyGridItemProvider = itemProvider;
                                        final boolean z = isVertical;
                                        final boolean z2 = reverseLayout;
                                        final LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator = placementAnimator;
                                        int endPadding2 = spaceBetweenLines;
                                        LazyMeasuredItemProvider measuredItemProvider = new LazyMeasuredItemProvider(lazyGridItemProvider, $this$null, endPadding2, new MeasuredItemFactory() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
                                            @Override // androidx.compose.foundation.lazy.grid.MeasuredItemFactory
                                            /* renamed from: createItem-PU_OBEw, reason: not valid java name */
                                            public final LazyMeasuredItem mo926createItemPU_OBEw(int index, Object key, int crossAxisSize, int mainAxisSpacing, List<? extends Placeable> placeables) {
                                                Intrinsics.checkNotNullParameter(key, "key");
                                                Intrinsics.checkNotNullParameter(placeables, "placeables");
                                                return new LazyMeasuredItem(index, key, z, crossAxisSize, mainAxisSpacing, z2, LazyLayoutMeasureScope.this.getLayoutDirection(), beforeContentPadding, afterContentPadding, placeables, lazyGridItemPlacementAnimator, visualItemOffset, null);
                                            }
                                        });
                                        boolean z3 = isVertical;
                                        final boolean z4 = isVertical;
                                        final LazyMeasuredLineProvider measuredLineProvider = new LazyMeasuredLineProvider(z3, resolvedSlotSizesSums, spaceBetweenSlots, itemsCount, endPadding2, measuredItemProvider, spanLayoutProvider, new MeasuredLineFactory() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
                                            @Override // androidx.compose.foundation.lazy.grid.MeasuredLineFactory
                                            /* renamed from: createLine-H9FfpSk, reason: not valid java name */
                                            public final LazyMeasuredLine mo927createLineH9FfpSk(int index, LazyMeasuredItem[] items, List<GridItemSpan> spans, int mainAxisSpacing) {
                                                Intrinsics.checkNotNullParameter(items, "items");
                                                Intrinsics.checkNotNullParameter(spans, "spans");
                                                return new LazyMeasuredLine(index, items, spans, z4, resolvedSlotSizesSums.size(), $this$null.getLayoutDirection(), mainAxisSpacing, spaceBetweenSlots, null);
                                            }
                                        });
                                        state.setPrefetchInfoRetriever$foundation_release(new Function1<LineIndex, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ ArrayList<Pair<? extends Integer, ? extends Constraints>> invoke(LineIndex lineIndex) {
                                                return m925invokebKFJvoY(lineIndex.m958unboximpl());
                                            }

                                            /* renamed from: invoke-bKFJvoY, reason: not valid java name */
                                            public final ArrayList<Pair<Integer, Constraints>> m925invokebKFJvoY(int line) {
                                                LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = LazyGridSpanLayoutProvider.this.getLineConfiguration(line);
                                                int index = ItemIndex.m898constructorimpl(lineConfiguration.getFirstItemIndex());
                                                int slot = 0;
                                                ArrayList result = new ArrayList(lineConfiguration.getSpans().size());
                                                List $this$fastForEach$iv = lineConfiguration.getSpans();
                                                LazyMeasuredLineProvider lazyMeasuredLineProvider = measuredLineProvider;
                                                int index$iv = 0;
                                                int size = $this$fastForEach$iv.size();
                                                while (index$iv < size) {
                                                    Object item$iv = $this$fastForEach$iv.get(index$iv);
                                                    long it = ((GridItemSpan) item$iv).getPackedValue();
                                                    int span = GridItemSpan.m892getCurrentLineSpanimpl(it);
                                                    result.add(TuplesKt.m294to(Integer.valueOf(index), Constraints.m4326boximpl(lazyMeasuredLineProvider.m944childConstraintsJhjzzOo$foundation_release(slot, span))));
                                                    int arg0$iv = index;
                                                    index = ItemIndex.m898constructorimpl(arg0$iv + 1);
                                                    slot += span;
                                                    index$iv++;
                                                    lineConfiguration = lineConfiguration;
                                                }
                                                return result;
                                            }
                                        });
                                        Snapshot.Companion this_$iv = Snapshot.INSTANCE;
                                        lazyGridState = state;
                                        snapshot$iv = this_$iv.createNonObservableSnapshot();
                                        previous$iv$iv = snapshot$iv.makeCurrent();
                                        firstVisibleLineIndex = lazyGridState.getFirstVisibleItemIndex();
                                        if (firstVisibleLineIndex >= itemsCount || itemsCount <= 0) {
                                            int firstVisibleLineIndex3 = spanLayoutProvider.m938getLineIndexOfItem_Ze7BM(lazyGridState.getFirstVisibleItemIndex());
                                            firstVisibleLineScrollOffset = lazyGridState.getFirstVisibleItemScrollOffset();
                                            firstVisibleLineIndex2 = firstVisibleLineIndex3;
                                        } else {
                                            try {
                                                int firstVisibleLineIndex4 = spanLayoutProvider.m938getLineIndexOfItem_Ze7BM(itemsCount - 1);
                                                firstVisibleLineIndex2 = firstVisibleLineIndex4;
                                                firstVisibleLineScrollOffset = 0;
                                            } catch (Throwable th) {
                                                th = th;
                                                previous$iv$iv2 = previous$iv$iv;
                                                try {
                                                    snapshot$iv.restoreCurrent(previous$iv$iv2);
                                                    throw th;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    snapshot$iv.dispose();
                                                    throw th;
                                                }
                                            }
                                        }
                                        Unit unit = Unit.INSTANCE;
                                        snapshot$iv.restoreCurrent(previous$iv$iv);
                                        snapshot$iv.dispose();
                                        LazyGridMeasureResult it = LazyGridMeasureKt.m928measureLazyGrid0cYbdkg(itemsCount, measuredLineProvider, measuredItemProvider, mainAxisAvailableSize, beforeContentPadding, afterContentPadding, endPadding2, firstVisibleLineIndex2, firstVisibleLineScrollOffset, state.getScrollToBeConsumed(), contentConstraints, isVertical, vertical, horizontal, reverseLayout, $this$null, placementAnimator, itemProvider.getSpanLayoutProvider(), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                                return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                            }

                                            public final MeasureResult invoke(int width, int height, Function1<? super Placeable.PlacementScope, Unit> placement) {
                                                Intrinsics.checkNotNullParameter(placement, "placement");
                                                return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m4352constrainWidthK40F9xA(containerConstraints, totalHorizontalPadding + width), ConstraintsKt.m4351constrainHeightK40F9xA(containerConstraints, totalVerticalPadding + height), MapsKt.emptyMap(), placement);
                                            }
                                        });
                                        LazyGridState lazyGridState2 = state;
                                        OverscrollEffect overscrollEffect2 = overscrollEffect;
                                        lazyGridState2.applyMeasureResult$foundation_release(it);
                                        LazyGridKt.refreshOverscrollInfo(overscrollEffect2, it);
                                        return it;
                                    }
                                    spaceBetweenLines = spaceBetweenLines2;
                                }
                                snapshot$iv.restoreCurrent(previous$iv$iv);
                                snapshot$iv.dispose();
                                LazyGridMeasureResult it2 = LazyGridMeasureKt.m928measureLazyGrid0cYbdkg(itemsCount, measuredLineProvider, measuredItemProvider, mainAxisAvailableSize, beforeContentPadding, afterContentPadding, endPadding2, firstVisibleLineIndex2, firstVisibleLineScrollOffset, state.getScrollToBeConsumed(), contentConstraints, isVertical, vertical, horizontal, reverseLayout, $this$null, placementAnimator, itemProvider.getSpanLayoutProvider(), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                        return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                    }

                                    public final MeasureResult invoke(int width, int height, Function1<? super Placeable.PlacementScope, Unit> placement) {
                                        Intrinsics.checkNotNullParameter(placement, "placement");
                                        return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m4352constrainWidthK40F9xA(containerConstraints, totalHorizontalPadding + width), ConstraintsKt.m4351constrainHeightK40F9xA(containerConstraints, totalVerticalPadding + height), MapsKt.emptyMap(), placement);
                                    }
                                });
                                LazyGridState lazyGridState22 = state;
                                OverscrollEffect overscrollEffect22 = overscrollEffect;
                                lazyGridState22.applyMeasureResult$foundation_release(it2);
                                LazyGridKt.refreshOverscrollInfo(overscrollEffect22, it2);
                                return it2;
                            } catch (Throwable th3) {
                                th = th3;
                                snapshot$iv.dispose();
                                throw th;
                            }
                            Unit unit2 = Unit.INSTANCE;
                        } catch (Throwable th4) {
                            th = th4;
                            previous$iv$iv2 = previous$iv$iv;
                            snapshot$iv.restoreCurrent(previous$iv$iv2);
                            throw th;
                        }
                        firstVisibleLineScrollOffset = lazyGridState.getFirstVisibleItemScrollOffset();
                        firstVisibleLineIndex2 = firstVisibleLineIndex3;
                    } catch (Throwable th5) {
                        th = th5;
                        previous$iv$iv2 = previous$iv$iv;
                        snapshot$iv.restoreCurrent(previous$iv$iv2);
                        throw th;
                    }
                    j = IntOffsetKt.IntOffset(startPadding, topPadding);
                    final long visualItemOffset2 = j;
                    LazyGridItemProvider lazyGridItemProvider2 = itemProvider;
                    final boolean z5 = isVertical;
                    final boolean z22 = reverseLayout;
                    final LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator2 = placementAnimator;
                    int endPadding22 = spaceBetweenLines;
                    LazyMeasuredItemProvider measuredItemProvider2 = new LazyMeasuredItemProvider(lazyGridItemProvider2, $this$null, endPadding22, new MeasuredItemFactory() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
                        @Override // androidx.compose.foundation.lazy.grid.MeasuredItemFactory
                        /* renamed from: createItem-PU_OBEw, reason: not valid java name */
                        public final LazyMeasuredItem mo926createItemPU_OBEw(int index, Object key, int crossAxisSize, int mainAxisSpacing, List<? extends Placeable> placeables) {
                            Intrinsics.checkNotNullParameter(key, "key");
                            Intrinsics.checkNotNullParameter(placeables, "placeables");
                            return new LazyMeasuredItem(index, key, z5, crossAxisSize, mainAxisSpacing, z22, LazyLayoutMeasureScope.this.getLayoutDirection(), beforeContentPadding, afterContentPadding, placeables, lazyGridItemPlacementAnimator2, visualItemOffset2, null);
                        }
                    });
                    boolean z32 = isVertical;
                    final boolean z42 = isVertical;
                    final LazyMeasuredLineProvider measuredLineProvider2 = new LazyMeasuredLineProvider(z32, resolvedSlotSizesSums, spaceBetweenSlots, itemsCount, endPadding22, measuredItemProvider2, spanLayoutProvider, new MeasuredLineFactory() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
                        @Override // androidx.compose.foundation.lazy.grid.MeasuredLineFactory
                        /* renamed from: createLine-H9FfpSk, reason: not valid java name */
                        public final LazyMeasuredLine mo927createLineH9FfpSk(int index, LazyMeasuredItem[] items, List<GridItemSpan> spans, int mainAxisSpacing) {
                            Intrinsics.checkNotNullParameter(items, "items");
                            Intrinsics.checkNotNullParameter(spans, "spans");
                            return new LazyMeasuredLine(index, items, spans, z42, resolvedSlotSizesSums.size(), $this$null.getLayoutDirection(), mainAxisSpacing, spaceBetweenSlots, null);
                        }
                    });
                    state.setPrefetchInfoRetriever$foundation_release(new Function1<LineIndex, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ ArrayList<Pair<? extends Integer, ? extends Constraints>> invoke(LineIndex lineIndex) {
                            return m925invokebKFJvoY(lineIndex.m958unboximpl());
                        }

                        /* renamed from: invoke-bKFJvoY, reason: not valid java name */
                        public final ArrayList<Pair<Integer, Constraints>> m925invokebKFJvoY(int line) {
                            LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = LazyGridSpanLayoutProvider.this.getLineConfiguration(line);
                            int index = ItemIndex.m898constructorimpl(lineConfiguration.getFirstItemIndex());
                            int slot = 0;
                            ArrayList result = new ArrayList(lineConfiguration.getSpans().size());
                            List $this$fastForEach$iv = lineConfiguration.getSpans();
                            LazyMeasuredLineProvider lazyMeasuredLineProvider = measuredLineProvider2;
                            int index$iv = 0;
                            int size = $this$fastForEach$iv.size();
                            while (index$iv < size) {
                                Object item$iv = $this$fastForEach$iv.get(index$iv);
                                long it3 = ((GridItemSpan) item$iv).getPackedValue();
                                int span = GridItemSpan.m892getCurrentLineSpanimpl(it3);
                                result.add(TuplesKt.m294to(Integer.valueOf(index), Constraints.m4326boximpl(lazyMeasuredLineProvider.m944childConstraintsJhjzzOo$foundation_release(slot, span))));
                                int arg0$iv = index;
                                index = ItemIndex.m898constructorimpl(arg0$iv + 1);
                                slot += span;
                                index$iv++;
                                lineConfiguration = lineConfiguration;
                            }
                            return result;
                        }
                    });
                    Snapshot.Companion this_$iv2 = Snapshot.INSTANCE;
                    lazyGridState = state;
                    snapshot$iv = this_$iv2.createNonObservableSnapshot();
                    previous$iv$iv = snapshot$iv.makeCurrent();
                    firstVisibleLineIndex = lazyGridState.getFirstVisibleItemIndex();
                    if (firstVisibleLineIndex >= itemsCount) {
                    }
                    int firstVisibleLineIndex32 = spanLayoutProvider.m938getLineIndexOfItem_Ze7BM(lazyGridState.getFirstVisibleItemIndex());
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        }
        $composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshOverscrollInfo(OverscrollEffect overscrollEffect, LazyGridMeasureResult result) {
        Object obj;
        LazyMeasuredItem[] items;
        boolean canScrollForward = result.getCanScrollForward();
        LazyMeasuredLine firstVisibleLine = result.getFirstVisibleLine();
        if (firstVisibleLine == null || (items = firstVisibleLine.getItems()) == null || (obj = (LazyMeasuredItem) ArraysKt.firstOrNull(items)) == null) {
            obj = 0;
        }
        boolean canScrollBackward = (Intrinsics.areEqual(obj, (Object) 0) && result.getFirstVisibleLineScrollOffset() == 0) ? false : true;
        overscrollEffect.setEnabled(canScrollForward || canScrollBackward);
    }
}
