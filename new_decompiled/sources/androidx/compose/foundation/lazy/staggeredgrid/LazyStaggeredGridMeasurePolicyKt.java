package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.IntOffsetKt;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyStaggeredGridMeasurePolicy.kt */
@Metadata(m286d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0086\u0001\u0010\u0000\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u001d\u0010\u0014\u001a\u0019\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u0001¢\u0006\u0002\b\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a,\u0010\u001a\u001a\u00020\u001b*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a,\u0010\u001f\u001a\u00020\u001b*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a$\u0010 \u001a\u00020\u001b*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002ø\u0001\u0000¢\u0006\u0002\u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, m287d2 = {"rememberStaggeredGridMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "slotSizesSums", "Landroidx/compose/ui/unit/Density;", "", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "afterPadding", "Landroidx/compose/ui/unit/Dp;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/unit/LayoutDirection;)F", "beforePadding", "startPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/unit/LayoutDirection;)F", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridMeasurePolicyKt {

    /* compiled from: LazyStaggeredGridMeasurePolicy.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            iArr[Orientation.Vertical.ordinal()] = 1;
            iArr[Orientation.Horizontal.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @ExperimentalFoundationApi
    public static final Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> rememberStaggeredGridMeasurePolicy(final LazyStaggeredGridState state, final LazyLayoutItemProvider itemProvider, final PaddingValues contentPadding, final boolean reverseLayout, final Orientation orientation, final Arrangement.Vertical verticalArrangement, final Arrangement.Horizontal horizontalArrangement, final Function2<? super Density, ? super Constraints, int[]> slotSizesSums, final OverscrollEffect overscrollEffect, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(verticalArrangement, "verticalArrangement");
        Intrinsics.checkNotNullParameter(horizontalArrangement, "horizontalArrangement");
        Intrinsics.checkNotNullParameter(slotSizesSums, "slotSizesSums");
        Intrinsics.checkNotNullParameter(overscrollEffect, "overscrollEffect");
        $composer.startReplaceableGroup(1688989793);
        ComposerKt.sourceInformation($composer, "C(rememberStaggeredGridMeasurePolicy)P(7,2!1,5,3,8!1,6)50@2203L2884:LazyStaggeredGridMeasurePolicy.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1688989793, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridMeasurePolicy (LazyStaggeredGridMeasurePolicy.kt:40)");
        }
        Object[] keys$iv = {state, itemProvider, contentPadding, Boolean.valueOf(reverseLayout), orientation, verticalArrangement, horizontalArrangement, slotSizesSums, overscrollEffect};
        $composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= $composer.changed(key$iv);
        }
        Object value$iv$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyStaggeredGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m977invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyStaggeredGridMeasureResult m977invoke0kLqBqw(LazyLayoutMeasureScope $this$null, long constraints) {
                    float beforePadding;
                    float afterPadding;
                    float startPadding;
                    long m4328copyZbe2FdA;
                    Intrinsics.checkNotNullParameter($this$null, "$this$null");
                    CheckScrollableContainerConstraintsKt.m510checkScrollableContainerConstraintsK40F9xA(constraints, Orientation.this);
                    int[] resolvedSlotSums = slotSizesSums.invoke($this$null, Constraints.m4326boximpl(constraints));
                    boolean isVertical = Orientation.this == Orientation.Vertical;
                    state.setLaneWidthsPrefixSum$foundation_release(resolvedSlotSums);
                    state.setVertical$foundation_release(isVertical);
                    beforePadding = LazyStaggeredGridMeasurePolicyKt.beforePadding(contentPadding, Orientation.this, reverseLayout, $this$null.getLayoutDirection());
                    int beforeContentPadding = $this$null.mo642roundToPx0680j_4(beforePadding);
                    afterPadding = LazyStaggeredGridMeasurePolicyKt.afterPadding(contentPadding, Orientation.this, reverseLayout, $this$null.getLayoutDirection());
                    int afterContentPadding = $this$null.mo642roundToPx0680j_4(afterPadding);
                    startPadding = LazyStaggeredGridMeasurePolicyKt.startPadding(contentPadding, Orientation.this, $this$null.getLayoutDirection());
                    int startContentPadding = $this$null.mo642roundToPx0680j_4(startPadding);
                    int maxMainAxisSize = isVertical ? Constraints.m4337getMaxHeightimpl(constraints) : Constraints.m4338getMaxWidthimpl(constraints);
                    int mainAxisAvailableSize = (maxMainAxisSize - beforeContentPadding) - afterContentPadding;
                    long contentOffset = isVertical ? IntOffsetKt.IntOffset(startContentPadding, beforeContentPadding) : IntOffsetKt.IntOffset(beforeContentPadding, startContentPadding);
                    int mainAxisSpacing = $this$null.mo642roundToPx0680j_4(isVertical ? verticalArrangement.getSpacing() : horizontalArrangement.getSpacing());
                    int crossAxisSpacing = $this$null.mo642roundToPx0680j_4(isVertical ? horizontalArrangement.getSpacing() : verticalArrangement.getSpacing());
                    PaddingValues $this$invoke_0kLqBqw_u24lambda_u2d0 = contentPadding;
                    float arg0$iv = PaddingKt.calculateStartPadding($this$invoke_0kLqBqw_u24lambda_u2d0, $this$null.getLayoutDirection());
                    float other$iv = PaddingKt.calculateEndPadding($this$invoke_0kLqBqw_u24lambda_u2d0, $this$null.getLayoutDirection());
                    int horizontalPadding = $this$null.mo642roundToPx0680j_4(C0504Dp.m4382constructorimpl(arg0$iv + other$iv));
                    PaddingValues $this$invoke_0kLqBqw_u24lambda_u2d1 = contentPadding;
                    float arg0$iv2 = $this$invoke_0kLqBqw_u24lambda_u2d1.getTop();
                    float other$iv2 = $this$invoke_0kLqBqw_u24lambda_u2d1.getBottom();
                    int verticalPadding = $this$null.mo642roundToPx0680j_4(C0504Dp.m4382constructorimpl(arg0$iv2 + other$iv2));
                    m4328copyZbe2FdA = Constraints.m4328copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m4340getMinWidthimpl(constraints) : ConstraintsKt.m4352constrainWidthK40F9xA(constraints, horizontalPadding), (r12 & 2) != 0 ? Constraints.m4338getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m4339getMinHeightimpl(constraints) : ConstraintsKt.m4351constrainHeightK40F9xA(constraints, verticalPadding), (r12 & 8) != 0 ? Constraints.m4337getMaxHeightimpl(constraints) : 0);
                    LazyStaggeredGridMeasureResult it = LazyStaggeredGridMeasureKt.m976measureStaggeredGridyR9pz_M($this$null, state, itemProvider, resolvedSlotSums, m4328copyZbe2FdA, isVertical, contentOffset, mainAxisAvailableSize, mainAxisSpacing, crossAxisSpacing, beforeContentPadding, afterContentPadding);
                    LazyStaggeredGridState lazyStaggeredGridState = state;
                    OverscrollEffect overscrollEffect2 = overscrollEffect;
                    lazyStaggeredGridState.applyMeasureResult$foundation_release(it);
                    overscrollEffect2.setEnabled(it.getCanScrollForward() || it.getCanScrollBackward());
                    return it;
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        }
        $composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float startPadding(PaddingValues $this$startPadding, Orientation orientation, LayoutDirection layoutDirection) {
        switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
                return PaddingKt.calculateStartPadding($this$startPadding, layoutDirection);
            case 2:
                return $this$startPadding.getTop();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float beforePadding(PaddingValues $this$beforePadding, Orientation orientation, boolean reverseLayout, LayoutDirection layoutDirection) {
        switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
                return reverseLayout ? $this$beforePadding.getBottom() : $this$beforePadding.getTop();
            case 2:
                if (reverseLayout) {
                    return PaddingKt.calculateEndPadding($this$beforePadding, layoutDirection);
                }
                return PaddingKt.calculateStartPadding($this$beforePadding, layoutDirection);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float afterPadding(PaddingValues $this$afterPadding, Orientation orientation, boolean reverseLayout, LayoutDirection layoutDirection) {
        switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
                return reverseLayout ? $this$afterPadding.getTop() : $this$afterPadding.getBottom();
            case 2:
                if (reverseLayout) {
                    return PaddingKt.calculateStartPadding($this$afterPadding, layoutDirection);
                }
                return PaddingKt.calculateEndPadding($this$afterPadding, layoutDirection);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
