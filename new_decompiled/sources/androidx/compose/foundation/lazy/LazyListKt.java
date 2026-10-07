package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.ClipScrollableContainerKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.compose.p000ui.unit.IntOffsetKt;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.health.platform.client.SdkConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyList.kt */
@Metadata(m286d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u008e\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001a\u001d\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u001e\u001a\u0018\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002\u001a\u0097\u0001\u0010$\u001a\u0019\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0%¢\u0006\u0002\b\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010+\u001a\u00020,H\u0003ø\u0001\u0000¢\u0006\u0002\u0010-\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, m287d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "(Landroidx/compose/foundation/lazy/LazyListItemProvider;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)V", "refreshOverscrollInfo", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "result", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "rememberLazyListMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "placementAnimator", "Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "(Landroidx/compose/foundation/lazy/LazyListItemProvider;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;Landroidx/compose/runtime/Composer;III)Lkotlin/jvm/functions/Function2;", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyListKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyList(final Modifier modifier, final LazyListState state, final PaddingValues contentPadding, final boolean reverseLayout, final boolean isVertical, final FlingBehavior flingBehavior, final boolean userScrollEnabled, Alignment.Horizontal horizontalAlignment, Arrangement.Vertical verticalArrangement, Alignment.Vertical verticalAlignment, Arrangement.Horizontal horizontalArrangement, final Function1<? super LazyListScope, Unit> content, Composer $composer, final int $changed, final int $changed1, final int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int $dirty1;
        Alignment.Horizontal horizontalAlignment2;
        Arrangement.Vertical verticalArrangement2;
        Alignment.Vertical verticalAlignment2;
        Arrangement.Horizontal horizontalArrangement2;
        Object it$iv$iv;
        Object value$iv$iv;
        Object value$iv$iv$iv;
        boolean invalid$iv$iv;
        int $dirty12;
        Composer $composer2;
        ScopeUpdateScope endRestartGroup;
        int i6;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(flingBehavior, "flingBehavior");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(955299798);
        ComposerKt.sourceInformation($composer3, "C(LazyList)P(6,8,1,7,5,2,9,3,11,10,4)76@3572L18,77@3614L44,79@3691L77,80@3796L39,81@3852L24,82@3905L92,87@4071L334,102@4411L42,109@4691L215,116@4970L68,117@5052L48,122@5324L7,105@4546L1257:LazyList.kt#428nma");
        int $dirty = $changed;
        int $dirty13 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(modifier) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer3.changed(state) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(contentPadding) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changed(reverseLayout) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer3.changed(isVertical) ? 16384 : 8192;
        }
        if ((i & 32) == 0) {
            i6 = ($changed & 458752) == 0 ? $composer3.changed(flingBehavior) ? 131072 : 65536 : 196608;
            if ((i & 64) == 0) {
                $dirty |= 1572864;
            } else if (($changed & 3670016) == 0) {
                $dirty |= $composer3.changed(userScrollEnabled) ? 1048576 : 524288;
            }
            i2 = i & 128;
            if (i2 == 0) {
                $dirty |= 12582912;
            } else if (($changed & 29360128) == 0) {
                $dirty |= $composer3.changed(horizontalAlignment) ? 8388608 : 4194304;
            }
            i3 = i & 256;
            if (i3 == 0) {
                $dirty |= 100663296;
            } else if (($changed & 234881024) == 0) {
                $dirty |= $composer3.changed(verticalArrangement) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
            }
            i4 = i & 512;
            if (i4 == 0) {
                $dirty |= 805306368;
            } else if (($changed & 1879048192) == 0) {
                $dirty |= $composer3.changed(verticalAlignment) ? 536870912 : 268435456;
            }
            i5 = i & 1024;
            if (i5 == 0) {
                $dirty13 |= 6;
            } else if (($changed1 & 14) == 0) {
                $dirty13 |= $composer3.changed(horizontalArrangement) ? 4 : 2;
            }
            if ((i & 2048) == 0) {
                $dirty13 |= 48;
            } else if (($changed1 & SdkConfig.SDK_VERSION) == 0) {
                $dirty13 |= $composer3.changed(content) ? 32 : 16;
            }
            $dirty1 = $dirty13;
            if ((1533916891 & $dirty) != 306783378 && ($dirty1 & 91) == 18 && $composer3.getSkipping()) {
                $composer3.skipToGroupEnd();
                horizontalAlignment2 = horizontalAlignment;
                verticalArrangement2 = verticalArrangement;
                verticalAlignment2 = verticalAlignment;
                horizontalArrangement2 = horizontalArrangement;
                $composer2 = $composer3;
                $dirty12 = $dirty1;
            } else {
                horizontalAlignment2 = i2 == 0 ? null : horizontalAlignment;
                verticalArrangement2 = i3 == 0 ? null : verticalArrangement;
                verticalAlignment2 = i4 == 0 ? null : verticalAlignment;
                horizontalArrangement2 = i5 == 0 ? null : horizontalArrangement;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(955299798, $dirty, $dirty1, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:50)");
                }
                OverscrollEffect overscrollEffect = ScrollableDefaults.INSTANCE.overscrollEffect($composer3, 6);
                LazyListItemProvider itemProvider = LazyListItemProviderKt.rememberLazyListItemProvider(state, content, $composer3, (($dirty >> 3) & 14) | ($dirty1 & SdkConfig.SDK_VERSION));
                int $dirty2 = $dirty;
                LazyLayoutSemanticState semanticState = LazySemanticsKt.rememberLazyListSemanticState(state, itemProvider, reverseLayout, isVertical, $composer3, (($dirty >> 3) & 14) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168));
                $composer3.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                it$iv$iv = $composer3.rememberedValue();
                if (it$iv$iv != Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = new LazyListBeyondBoundsInfo();
                    $composer3.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer3.endReplaceableGroup();
                LazyListBeyondBoundsInfo beyondBoundsInfo = (LazyListBeyondBoundsInfo) value$iv$iv;
                $composer3.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation($composer3, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                $composer3.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                value$iv$iv$iv = $composer3.rememberedValue();
                if (value$iv$iv$iv != Composer.INSTANCE.getEmpty()) {
                    value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                    $composer3.updateRememberedValue(value$iv$iv$iv);
                }
                $composer3.endReplaceableGroup();
                CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                CoroutineScope scope = wrapper$iv.getCoroutineScope();
                $composer3.endReplaceableGroup();
                Object key2$iv = Boolean.valueOf(isVertical);
                int i7 = (($dirty2 >> 3) & 14) | (($dirty2 >> 9) & SdkConfig.SDK_VERSION);
                $composer3.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer3, "C(remember)P(1,2):Composables.kt#9igjgp");
                invalid$iv$iv = $composer3.changed(state) | $composer3.changed(key2$iv);
                Object value$iv$iv2 = $composer3.rememberedValue();
                if (!invalid$iv$iv && value$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                    $composer3.endReplaceableGroup();
                    LazyListItemPlacementAnimator placementAnimator = (LazyListItemPlacementAnimator) value$iv$iv2;
                    state.setPlacementAnimator$foundation_release(placementAnimator);
                    Function2 measurePolicy = rememberLazyListMeasurePolicy(itemProvider, state, beyondBoundsInfo, overscrollEffect, contentPadding, reverseLayout, isVertical, horizontalAlignment2, verticalAlignment2, horizontalArrangement2, verticalArrangement2, placementAnimator, $composer3, ($dirty2 & SdkConfig.SDK_VERSION) | (MutableVector.$stable << 6) | (($dirty2 << 6) & 57344) | (($dirty2 << 6) & 458752) | (($dirty2 << 6) & 3670016) | ($dirty2 & 29360128) | (234881024 & ($dirty2 >> 3)) | (($dirty1 << 27) & 1879048192), (($dirty2 >> 24) & 14) | 64, 0);
                    ScrollPositionUpdater(itemProvider, state, $composer3, $dirty2 & SdkConfig.SDK_VERSION);
                    Orientation orientation = !isVertical ? Orientation.Vertical : Orientation.Horizontal;
                    $dirty12 = $dirty1;
                    Modifier overscroll = OverscrollKt.overscroll(LazyListPinningModifierKt.lazyListPinningModifier(LazyBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), itemProvider, semanticState, orientation, userScrollEnabled, $composer3, ($dirty2 >> 6) & 57344), orientation), state, beyondBoundsInfo, reverseLayout, $composer3, ($dirty2 & SdkConfig.SDK_VERSION) | (MutableVector.$stable << 6) | ($dirty2 & 7168)), state, beyondBoundsInfo, $composer3, ($dirty2 & SdkConfig.SDK_VERSION) | (MutableVector.$stable << 6)), overscrollEffect);
                    ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer2 = $composer3;
                    LazyLayoutKt.LazyLayout(itemProvider, ScrollableKt.scrollable(overscroll, state, orientation, overscrollEffect, userScrollEnabled, scrollableDefaults.reverseDirection((LayoutDirection) consume, orientation, reverseLayout), flingBehavior, state.getInternalInteractionSource()), state.getPrefetchState(), measurePolicy, $composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                value$iv$iv2 = new LazyListItemPlacementAnimator(scope, isVertical);
                $composer3.updateRememberedValue(value$iv$iv2);
                $composer3.endReplaceableGroup();
                LazyListItemPlacementAnimator placementAnimator2 = (LazyListItemPlacementAnimator) value$iv$iv2;
                state.setPlacementAnimator$foundation_release(placementAnimator2);
                Function2 measurePolicy2 = rememberLazyListMeasurePolicy(itemProvider, state, beyondBoundsInfo, overscrollEffect, contentPadding, reverseLayout, isVertical, horizontalAlignment2, verticalAlignment2, horizontalArrangement2, verticalArrangement2, placementAnimator2, $composer3, ($dirty2 & SdkConfig.SDK_VERSION) | (MutableVector.$stable << 6) | (($dirty2 << 6) & 57344) | (($dirty2 << 6) & 458752) | (($dirty2 << 6) & 3670016) | ($dirty2 & 29360128) | (234881024 & ($dirty2 >> 3)) | (($dirty1 << 27) & 1879048192), (($dirty2 >> 24) & 14) | 64, 0);
                ScrollPositionUpdater(itemProvider, state, $composer3, $dirty2 & SdkConfig.SDK_VERSION);
                Orientation orientation2 = !isVertical ? Orientation.Vertical : Orientation.Horizontal;
                $dirty12 = $dirty1;
                Modifier overscroll2 = OverscrollKt.overscroll(LazyListPinningModifierKt.lazyListPinningModifier(LazyBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), itemProvider, semanticState, orientation2, userScrollEnabled, $composer3, ($dirty2 >> 6) & 57344), orientation2), state, beyondBoundsInfo, reverseLayout, $composer3, ($dirty2 & SdkConfig.SDK_VERSION) | (MutableVector.$stable << 6) | ($dirty2 & 7168)), state, beyondBoundsInfo, $composer3, ($dirty2 & SdkConfig.SDK_VERSION) | (MutableVector.$stable << 6)), overscrollEffect);
                ScrollableDefaults scrollableDefaults2 = ScrollableDefaults.INSTANCE;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume2 = $composer3.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2 = $composer3;
                LazyLayoutKt.LazyLayout(itemProvider, ScrollableKt.scrollable(overscroll2, state, orientation2, overscrollEffect, userScrollEnabled, scrollableDefaults2.reverseDirection((LayoutDirection) consume2, orientation2, reverseLayout), flingBehavior, state.getInternalInteractionSource()), state.getPrefetchState(), measurePolicy2, $composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            final Alignment.Horizontal horizontal = horizontalAlignment2;
            final Arrangement.Vertical vertical = verticalArrangement2;
            final Alignment.Vertical vertical2 = verticalAlignment2;
            final Arrangement.Horizontal horizontal2 = horizontalArrangement2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt$LazyList$1
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

                public final void invoke(Composer composer, int i8) {
                    LazyListKt.LazyList(Modifier.this, state, contentPadding, reverseLayout, isVertical, flingBehavior, userScrollEnabled, horizontal, vertical, vertical2, horizontal2, content, composer, $changed | 1, $changed1, i);
                }
            });
            return;
        }
        $dirty |= i6;
        if ((i & 64) == 0) {
        }
        i2 = i & 128;
        if (i2 == 0) {
        }
        i3 = i & 256;
        if (i3 == 0) {
        }
        i4 = i & 512;
        if (i4 == 0) {
        }
        i5 = i & 1024;
        if (i5 == 0) {
        }
        if ((i & 2048) == 0) {
        }
        $dirty1 = $dirty13;
        if ((1533916891 & $dirty) != 306783378) {
        }
        if (i2 == 0) {
        }
        if (i3 == 0) {
        }
        if (i4 == 0) {
        }
        if (i5 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        OverscrollEffect overscrollEffect2 = ScrollableDefaults.INSTANCE.overscrollEffect($composer3, 6);
        LazyListItemProvider itemProvider2 = LazyListItemProviderKt.rememberLazyListItemProvider(state, content, $composer3, (($dirty >> 3) & 14) | ($dirty1 & SdkConfig.SDK_VERSION));
        int $dirty22 = $dirty;
        LazyLayoutSemanticState semanticState2 = LazySemanticsKt.rememberLazyListSemanticState(state, itemProvider2, reverseLayout, isVertical, $composer3, (($dirty >> 3) & 14) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168));
        $composer3.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
        it$iv$iv = $composer3.rememberedValue();
        if (it$iv$iv != Composer.INSTANCE.getEmpty()) {
        }
        $composer3.endReplaceableGroup();
        LazyListBeyondBoundsInfo beyondBoundsInfo2 = (LazyListBeyondBoundsInfo) value$iv$iv;
        $composer3.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation($composer3, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
        $composer3.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
        value$iv$iv$iv = $composer3.rememberedValue();
        if (value$iv$iv$iv != Composer.INSTANCE.getEmpty()) {
        }
        $composer3.endReplaceableGroup();
        CompositionScopedCoroutineScopeCanceller wrapper$iv2 = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
        CoroutineScope scope2 = wrapper$iv2.getCoroutineScope();
        $composer3.endReplaceableGroup();
        Object key2$iv2 = Boolean.valueOf(isVertical);
        int i72 = (($dirty22 >> 3) & 14) | (($dirty22 >> 9) & SdkConfig.SDK_VERSION);
        $composer3.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer3, "C(remember)P(1,2):Composables.kt#9igjgp");
        invalid$iv$iv = $composer3.changed(state) | $composer3.changed(key2$iv2);
        Object value$iv$iv22 = $composer3.rememberedValue();
        if (!invalid$iv$iv) {
            $composer3.endReplaceableGroup();
            LazyListItemPlacementAnimator placementAnimator22 = (LazyListItemPlacementAnimator) value$iv$iv22;
            state.setPlacementAnimator$foundation_release(placementAnimator22);
            Function2 measurePolicy22 = rememberLazyListMeasurePolicy(itemProvider2, state, beyondBoundsInfo2, overscrollEffect2, contentPadding, reverseLayout, isVertical, horizontalAlignment2, verticalAlignment2, horizontalArrangement2, verticalArrangement2, placementAnimator22, $composer3, ($dirty22 & SdkConfig.SDK_VERSION) | (MutableVector.$stable << 6) | (($dirty22 << 6) & 57344) | (($dirty22 << 6) & 458752) | (($dirty22 << 6) & 3670016) | ($dirty22 & 29360128) | (234881024 & ($dirty22 >> 3)) | (($dirty1 << 27) & 1879048192), (($dirty22 >> 24) & 14) | 64, 0);
            ScrollPositionUpdater(itemProvider2, state, $composer3, $dirty22 & SdkConfig.SDK_VERSION);
            Orientation orientation22 = !isVertical ? Orientation.Vertical : Orientation.Horizontal;
            $dirty12 = $dirty1;
            Modifier overscroll22 = OverscrollKt.overscroll(LazyListPinningModifierKt.lazyListPinningModifier(LazyBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), itemProvider2, semanticState2, orientation22, userScrollEnabled, $composer3, ($dirty22 >> 6) & 57344), orientation22), state, beyondBoundsInfo2, reverseLayout, $composer3, ($dirty22 & SdkConfig.SDK_VERSION) | (MutableVector.$stable << 6) | ($dirty22 & 7168)), state, beyondBoundsInfo2, $composer3, ($dirty22 & SdkConfig.SDK_VERSION) | (MutableVector.$stable << 6)), overscrollEffect2);
            ScrollableDefaults scrollableDefaults22 = ScrollableDefaults.INSTANCE;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume22 = $composer3.consume(localLayoutDirection22);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            LazyLayoutKt.LazyLayout(itemProvider2, ScrollableKt.scrollable(overscroll22, state, orientation22, overscrollEffect2, userScrollEnabled, scrollableDefaults22.reverseDirection((LayoutDirection) consume22, orientation22, reverseLayout), flingBehavior, state.getInternalInteractionSource()), state.getPrefetchState(), measurePolicy22, $composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        value$iv$iv22 = new LazyListItemPlacementAnimator(scope2, isVertical);
        $composer3.updateRememberedValue(value$iv$iv22);
        $composer3.endReplaceableGroup();
        LazyListItemPlacementAnimator placementAnimator222 = (LazyListItemPlacementAnimator) value$iv$iv22;
        state.setPlacementAnimator$foundation_release(placementAnimator222);
        Function2 measurePolicy222 = rememberLazyListMeasurePolicy(itemProvider2, state, beyondBoundsInfo2, overscrollEffect2, contentPadding, reverseLayout, isVertical, horizontalAlignment2, verticalAlignment2, horizontalArrangement2, verticalArrangement2, placementAnimator222, $composer3, ($dirty22 & SdkConfig.SDK_VERSION) | (MutableVector.$stable << 6) | (($dirty22 << 6) & 57344) | (($dirty22 << 6) & 458752) | (($dirty22 << 6) & 3670016) | ($dirty22 & 29360128) | (234881024 & ($dirty22 >> 3)) | (($dirty1 << 27) & 1879048192), (($dirty22 >> 24) & 14) | 64, 0);
        ScrollPositionUpdater(itemProvider2, state, $composer3, $dirty22 & SdkConfig.SDK_VERSION);
        Orientation orientation222 = !isVertical ? Orientation.Vertical : Orientation.Horizontal;
        $dirty12 = $dirty1;
        Modifier overscroll222 = OverscrollKt.overscroll(LazyListPinningModifierKt.lazyListPinningModifier(LazyBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), itemProvider2, semanticState2, orientation222, userScrollEnabled, $composer3, ($dirty22 >> 6) & 57344), orientation222), state, beyondBoundsInfo2, reverseLayout, $composer3, ($dirty22 & SdkConfig.SDK_VERSION) | (MutableVector.$stable << 6) | ($dirty22 & 7168)), state, beyondBoundsInfo2, $composer3, ($dirty22 & SdkConfig.SDK_VERSION) | (MutableVector.$stable << 6)), overscrollEffect2);
        ScrollableDefaults scrollableDefaults222 = ScrollableDefaults.INSTANCE;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection222 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume222 = $composer3.consume(localLayoutDirection222);
        ComposerKt.sourceInformationMarkerEnd($composer3);
        $composer2 = $composer3;
        LazyLayoutKt.LazyLayout(itemProvider2, ScrollableKt.scrollable(overscroll222, state, orientation222, overscrollEffect2, userScrollEnabled, scrollableDefaults222.reverseDirection((LayoutDirection) consume222, orientation222, reverseLayout), flingBehavior, state.getInternalInteractionSource()), state.getPrefetchState(), measurePolicy222, $composer2, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalFoundationApi
    public static final void ScrollPositionUpdater(final LazyListItemProvider itemProvider, final LazyListState state, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(3173830);
        ComposerKt.sourceInformation($composer2, "C(ScrollPositionUpdater):LazyList.kt#428nma");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(itemProvider) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(state) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(3173830, $changed, -1, "androidx.compose.foundation.lazy.ScrollPositionUpdater (LazyList.kt:141)");
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt$ScrollPositionUpdater$1
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
                LazyListKt.ScrollPositionUpdater(LazyListItemProvider.this, state, composer, $changed | 1);
            }
        });
    }

    @ExperimentalFoundationApi
    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy(final LazyListItemProvider itemProvider, final LazyListState state, final LazyListBeyondBoundsInfo beyondBoundsInfo, final OverscrollEffect overscrollEffect, final PaddingValues contentPadding, final boolean reverseLayout, final boolean isVertical, Alignment.Horizontal horizontalAlignment, Alignment.Vertical verticalAlignment, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, final LazyListItemPlacementAnimator placementAnimator, Composer $composer, int $changed, int $changed1, int i) {
        $composer.startReplaceableGroup(-1404987696);
        ComposerKt.sourceInformation($composer, "C(rememberLazyListMeasurePolicy)P(5,9!1,6!1,8,4!1,10!1,11)177@7545L6605:LazyList.kt#428nma");
        Alignment.Horizontal horizontalAlignment2 = (i & 128) != 0 ? null : horizontalAlignment;
        Alignment.Vertical verticalAlignment2 = (i & 256) != 0 ? null : verticalAlignment;
        Arrangement.Horizontal horizontalArrangement2 = (i & 512) != 0 ? null : horizontalArrangement;
        Arrangement.Vertical verticalArrangement2 = (i & 1024) != 0 ? null : verticalArrangement;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1404987696, $changed, $changed1, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:152)");
        }
        Object[] keys$iv = {state, beyondBoundsInfo, overscrollEffect, contentPadding, Boolean.valueOf(reverseLayout), Boolean.valueOf(isVertical), horizontalAlignment2, verticalAlignment2, horizontalArrangement2, verticalArrangement2, placementAnimator};
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
            final Alignment.Horizontal horizontal2 = horizontalAlignment2;
            final Alignment.Vertical vertical2 = verticalAlignment2;
            value$iv$iv = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m869invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyListMeasureResult m869invoke0kLqBqw(final LazyLayoutMeasureScope $this$null, final long containerConstraints) {
                    int i2;
                    int i3;
                    int i4;
                    float spacing;
                    int m4338getMaxWidthimpl;
                    final long visualItemOffset;
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
                    state.setDensity$foundation_release($this$null);
                    itemProvider.getItemScope().setMaxSize(Constraints.m4338getMaxWidthimpl(contentConstraints), Constraints.m4337getMaxHeightimpl(contentConstraints));
                    if (isVertical) {
                        Arrangement.Vertical vertical3 = vertical;
                        if (vertical3 == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        spacing = vertical3.getSpacing();
                    } else {
                        Arrangement.Horizontal horizontal3 = horizontal;
                        if (horizontal3 == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        spacing = horizontal3.getSpacing();
                    }
                    float spaceBetweenItemsDp = spacing;
                    final int spaceBetweenItems = $this$null.mo642roundToPx0680j_4(spaceBetweenItemsDp);
                    final int itemsCount = itemProvider.getItemCount();
                    if (isVertical) {
                        m4338getMaxWidthimpl = Constraints.m4337getMaxHeightimpl(containerConstraints) - totalVerticalPadding;
                    } else {
                        m4338getMaxWidthimpl = Constraints.m4338getMaxWidthimpl(containerConstraints) - totalHorizontalPadding;
                    }
                    int mainAxisAvailableSize = m4338getMaxWidthimpl;
                    if (!reverseLayout || mainAxisAvailableSize > 0) {
                        visualItemOffset = IntOffsetKt.IntOffset(startPadding, topPadding);
                    } else {
                        visualItemOffset = IntOffsetKt.IntOffset(isVertical ? startPadding : startPadding + mainAxisAvailableSize, isVertical ? topPadding + mainAxisAvailableSize : topPadding);
                    }
                    boolean z = isVertical;
                    LazyListItemProvider lazyListItemProvider = itemProvider;
                    final boolean z2 = isVertical;
                    final Alignment.Horizontal horizontal4 = horizontal2;
                    final Alignment.Vertical vertical4 = vertical2;
                    final boolean z3 = reverseLayout;
                    final LazyListItemPlacementAnimator lazyListItemPlacementAnimator = placementAnimator;
                    LazyMeasuredItemProvider measuredItemProvider = new LazyMeasuredItemProvider(contentConstraints, z, lazyListItemProvider, $this$null, new MeasuredItemFactory() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                        @Override // androidx.compose.foundation.lazy.MeasuredItemFactory
                        /* renamed from: createItem-HK0c1C0, reason: not valid java name */
                        public final LazyMeasuredItem mo870createItemHK0c1C0(int index, Object key, List<? extends Placeable> placeables) {
                            Intrinsics.checkNotNullParameter(key, "key");
                            Intrinsics.checkNotNullParameter(placeables, "placeables");
                            int spacing2 = index == itemsCount + (-1) ? 0 : spaceBetweenItems;
                            return new LazyMeasuredItem(index, placeables, z2, horizontal4, vertical4, $this$null.getLayoutDirection(), z3, beforeContentPadding, afterContentPadding, lazyListItemPlacementAnimator, spacing2, visualItemOffset, key, null);
                        }
                    }, null);
                    state.m881setPremeasureConstraintsBRTryo0$foundation_release(measuredItemProvider.getChildConstraints());
                    Snapshot.Companion this_$iv = Snapshot.INSTANCE;
                    LazyListState lazyListState = state;
                    Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
                    try {
                        Snapshot previous$iv$iv = snapshot$iv.makeCurrent();
                        try {
                            int firstVisibleItemIndex = DataIndex.m847constructorimpl(lazyListState.getFirstVisibleItemIndex());
                            try {
                                int firstVisibleScrollOffset = lazyListState.getFirstVisibleItemScrollOffset();
                                try {
                                    Unit unit = Unit.INSTANCE;
                                    try {
                                        snapshot$iv.restoreCurrent(previous$iv$iv);
                                        snapshot$iv.dispose();
                                        LazyListMeasureResult it = LazyListMeasureKt.m873measureLazyListnXYdgZc(itemsCount, measuredItemProvider, mainAxisAvailableSize, beforeContentPadding, afterContentPadding, spaceBetweenItems, firstVisibleItemIndex, firstVisibleScrollOffset, state.getScrollToBeConsumed(), contentConstraints, isVertical, itemProvider.getHeaderIndexes(), vertical, horizontal, reverseLayout, $this$null, placementAnimator, beyondBoundsInfo, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1.2
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
                                        LazyListState lazyListState2 = state;
                                        OverscrollEffect overscrollEffect2 = overscrollEffect;
                                        lazyListState2.applyMeasureResult$foundation_release(it);
                                        LazyListKt.refreshOverscrollInfo(overscrollEffect2, it);
                                        return it;
                                    } catch (Throwable th) {
                                        th = th;
                                        snapshot$iv.dispose();
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    snapshot$iv.restoreCurrent(previous$iv$iv);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        }
        $composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshOverscrollInfo(OverscrollEffect overscrollEffect, LazyListMeasureResult result) {
        boolean canScrollForward = result.getCanScrollForward();
        LazyMeasuredItem firstVisibleItem = result.getFirstVisibleItem();
        boolean canScrollBackward = ((firstVisibleItem != null ? firstVisibleItem.getIndex() : 0) == 0 && result.getFirstVisibleItemScrollOffset() == 0) ? false : true;
        overscrollEffect.setEnabled(canScrollForward || canScrollBackward);
    }
}
