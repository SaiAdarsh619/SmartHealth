package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.p000ui.semantics.CollectionInfo;
import androidx.compose.p000ui.semantics.ScrollAxisRange;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazySemantics.kt */
@Metadata(m286d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\t¨\u0006\n"}, m287d2 = {"rememberLazyListSemanticState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "reverseScrolling", "", "isVertical", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazySemanticsKt {
    public static final LazyLayoutSemanticState rememberLazyListSemanticState(final LazyListState state, final LazyLayoutItemProvider itemProvider, final boolean reverseScrolling, final boolean isVertical, Composer $composer, int $changed) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        $composer.startReplaceableGroup(1624527721);
        ComposerKt.sourceInformation($composer, "C(rememberLazyListSemanticState)P(3,1,2)36@1405L1916:LazySemantics.kt#428nma");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1624527721, $changed, -1, "androidx.compose.foundation.lazy.rememberLazyListSemanticState (LazySemantics.kt:30)");
        }
        Object[] keys$iv = {state, itemProvider, Boolean.valueOf(reverseScrolling), Boolean.valueOf(isVertical)};
        $composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= $composer.changed(key$iv);
        }
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new LazyLayoutSemanticState() { // from class: androidx.compose.foundation.lazy.LazySemanticsKt$rememberLazyListSemanticState$1$1
                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public ScrollAxisRange scrollAxisRange() {
                    final LazyListState lazyListState = state;
                    Function0<Float> function0 = new Function0<Float>() { // from class: androidx.compose.foundation.lazy.LazySemanticsKt$rememberLazyListSemanticState$1$1$scrollAxisRange$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Float invoke() {
                            return Float.valueOf(LazyListState.this.getFirstVisibleItemIndex() + (LazyListState.this.getFirstVisibleItemScrollOffset() / 100000.0f));
                        }
                    };
                    final LazyListState lazyListState2 = state;
                    final LazyLayoutItemProvider lazyLayoutItemProvider = itemProvider;
                    return new ScrollAxisRange(function0, new Function0<Float>() { // from class: androidx.compose.foundation.lazy.LazySemanticsKt$rememberLazyListSemanticState$1$1$scrollAxisRange$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Float invoke() {
                            float firstVisibleItemIndex;
                            if (LazyListState.this.getCanScrollForward()) {
                                firstVisibleItemIndex = lazyLayoutItemProvider.getItemCount() + 1.0f;
                            } else {
                                firstVisibleItemIndex = LazyListState.this.getFirstVisibleItemIndex() + (LazyListState.this.getFirstVisibleItemScrollOffset() / 100000.0f);
                            }
                            return Float.valueOf(firstVisibleItemIndex);
                        }
                    }, reverseScrolling);
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public Object animateScrollBy(float delta, Continuation<? super Unit> continuation) {
                    Object animateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(state, delta, null, continuation, 2, null);
                    return animateScrollBy$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollBy$default : Unit.INSTANCE;
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public Object scrollToItem(int index, Continuation<? super Unit> continuation) {
                    Object scrollToItem$default = LazyListState.scrollToItem$default(state, index, 0, continuation, 2, null);
                    return scrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollToItem$default : Unit.INSTANCE;
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
                public CollectionInfo collectionInfo() {
                    if (isVertical) {
                        return new CollectionInfo(-1, 1);
                    }
                    return new CollectionInfo(1, -1);
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        LazySemanticsKt$rememberLazyListSemanticState$1$1 lazySemanticsKt$rememberLazyListSemanticState$1$1 = (LazySemanticsKt$rememberLazyListSemanticState$1$1) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return lazySemanticsKt$rememberLazyListSemanticState$1$1;
    }
}
