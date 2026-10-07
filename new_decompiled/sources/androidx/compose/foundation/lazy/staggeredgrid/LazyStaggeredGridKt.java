package androidx.compose.foundation.lazy.staggeredgrid;

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
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyStaggeredGrid.kt */
@Metadata(m286d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u009e\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u000bH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u001d\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010 \u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, m287d2 = {"LazyStaggeredGrid", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "slotSizesSums", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridKt {
    @ExperimentalFoundationApi
    public static final void LazyStaggeredGrid(final LazyStaggeredGridState state, final Orientation orientation, final Function2<? super Density, ? super Constraints, int[]> slotSizesSums, Modifier modifier, PaddingValues contentPadding, boolean reverseLayout, FlingBehavior flingBehavior, boolean userScrollEnabled, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, final Function1<? super LazyStaggeredGridScope, Unit> content, Composer $composer, final int $changed, final int $changed1, final int i) {
        FlingBehavior flingBehavior2;
        int $dirty;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(slotSizesSums, "slotSizesSums");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(845690866);
        ComposerKt.sourceInformation($composer2, "C(LazyStaggeredGrid)P(8,5,7,4,1,6,2,9,10,3)53@2453L15,63@2948L18,65@2991L49,66@3065L254,77@3344L74,79@3424L42,89@3832L7,99@4197L215,81@3472L1067:LazyStaggeredGrid.kt#fzvcnm");
        Modifier modifier2 = (i & 8) != 0 ? Modifier.INSTANCE : modifier;
        PaddingValues contentPadding2 = (i & 16) != 0 ? PaddingKt.m752PaddingValues0680j_4(C0504Dp.m4382constructorimpl(0)) : contentPadding;
        boolean reverseLayout2 = (i & 32) != 0 ? false : reverseLayout;
        if ((i & 64) != 0) {
            FlingBehavior flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior($composer2, 6);
            int $dirty2 = $changed & (-3670017);
            $dirty = $dirty2;
            flingBehavior2 = flingBehavior3;
        } else {
            flingBehavior2 = flingBehavior;
            $dirty = $changed;
        }
        int $dirty3 = i & 128;
        boolean userScrollEnabled2 = $dirty3 != 0 ? true : userScrollEnabled;
        Arrangement.Vertical verticalArrangement2 = (i & 256) != 0 ? Arrangement.INSTANCE.getTop() : verticalArrangement;
        Arrangement.Horizontal horizontalArrangement2 = (i & 512) != 0 ? Arrangement.INSTANCE.getStart() : horizontalArrangement;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(845690866, $dirty, $changed1, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:39)");
        }
        OverscrollEffect overscrollEffect = ScrollableDefaults.INSTANCE.overscrollEffect($composer2, 6);
        LazyLayoutItemProvider itemProvider = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProvider(state, content, $composer2, (($changed1 << 3) & SdkConfig.SDK_VERSION) | 8);
        int $dirty4 = $dirty;
        final boolean reverseLayout3 = reverseLayout2;
        final Modifier modifier3 = modifier2;
        Function2 measurePolicy = LazyStaggeredGridMeasurePolicyKt.rememberStaggeredGridMeasurePolicy(state, itemProvider, contentPadding2, reverseLayout2, orientation, verticalArrangement2, horizontalArrangement2, slotSizesSums, overscrollEffect, $composer2, (($dirty >> 6) & 896) | 8 | (($dirty >> 6) & 7168) | (($dirty << 9) & 57344) | (($dirty >> 9) & 458752) | (($dirty >> 9) & 3670016) | (($dirty << 15) & 29360128));
        LazyLayoutSemanticState semanticState = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(state, itemProvider, reverseLayout3, $composer2, (($dirty4 >> 9) & 896) | 8);
        ScrollPositionUpdater(itemProvider, state, $composer2, 64);
        Modifier overscroll = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(modifier3.then(state.getRemeasurementModifier()), orientation), overscrollEffect);
        ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer2.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        LazyLayoutKt.LazyLayout(itemProvider, LazyLayoutSemanticsKt.lazyLayoutSemantics(ScrollableKt.scrollable(overscroll, state, orientation, overscrollEffect, userScrollEnabled2, scrollableDefaults.reverseDirection((LayoutDirection) consume, orientation, reverseLayout3), flingBehavior2, state.getMutableInteractionSource()), itemProvider, semanticState, orientation, userScrollEnabled2, $composer2, (($dirty4 << 6) & 7168) | (($dirty4 >> 9) & 57344)), state.getPrefetchState(), measurePolicy, $composer2, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final PaddingValues paddingValues = contentPadding2;
        final FlingBehavior flingBehavior4 = flingBehavior2;
        final boolean z = userScrollEnabled2;
        final Arrangement.Vertical vertical = verticalArrangement2;
        final Arrangement.Horizontal horizontal = horizontalArrangement2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$LazyStaggeredGrid$1
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
                LazyStaggeredGridKt.LazyStaggeredGrid(LazyStaggeredGridState.this, orientation, slotSizesSums, modifier3, paddingValues, reverseLayout3, flingBehavior4, z, vertical, horizontal, content, composer, $changed | 1, $changed1, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ScrollPositionUpdater(final LazyLayoutItemProvider itemProvider, final LazyStaggeredGridState state, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(231106410);
        ComposerKt.sourceInformation($composer2, "C(ScrollPositionUpdater):LazyStaggeredGrid.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(231106410, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.ScrollPositionUpdater (LazyStaggeredGrid.kt:114)");
        }
        if (itemProvider.getItemCount() > 0) {
            state.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(itemProvider);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$ScrollPositionUpdater$1
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
                LazyStaggeredGridKt.ScrollPositionUpdater(LazyLayoutItemProvider.this, state, composer, $changed | 1);
            }
        });
    }
}
