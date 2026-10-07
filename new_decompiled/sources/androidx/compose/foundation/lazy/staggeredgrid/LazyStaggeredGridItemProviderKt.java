package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyNearestItemsRangeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyStaggeredGridItemProvider.kt */
@Metadata(m286d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010\t¨\u0006\n"}, m287d2 = {"rememberStaggeredGridItemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridItemProviderKt {
    @ExperimentalFoundationApi
    public static final LazyLayoutItemProvider rememberStaggeredGridItemProvider(final LazyStaggeredGridState state, Function1<? super LazyStaggeredGridScope, Unit> content, Composer $composer, int $changed) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(content, "content");
        $composer.startReplaceableGroup(290499291);
        ComposerKt.sourceInformation($composer, "C(rememberStaggeredGridItemProvider)P(1)33@1373L29,34@1436L175,39@1623L501:LazyStaggeredGridItemProvider.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(290499291, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridItemProvider (LazyStaggeredGridItemProvider.kt:29)");
        }
        final State latestContent = SnapshotStateKt.rememberUpdatedState(content, $composer, ($changed >> 3) & 14);
        final State nearestItemsRangeState = LazyNearestItemsRangeKt.rememberLazyNearestItemsRangeState(new Function0<Integer>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$nearestItemsRangeState$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(LazyStaggeredGridState.this.getFirstVisibleItemIndex());
            }
        }, new Function0<Integer>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$nearestItemsRangeState$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return 90;
            }
        }, new Function0<Integer>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$nearestItemsRangeState$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return 200;
            }
        }, $composer, 432);
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(state);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            final State itemProviderState = SnapshotStateKt.derivedStateOf(new Function0<LazyLayoutItemProvider>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$itemProviderState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final LazyLayoutItemProvider invoke() {
                    LazyStaggeredGridScopeImpl scope = new LazyStaggeredGridScopeImpl();
                    latestContent.getValue().invoke(scope);
                    return LazyLayoutItemProviderKt.LazyLayoutItemProvider(scope.getIntervals(), nearestItemsRangeState.getValue(), ComposableSingletons$LazyStaggeredGridItemProviderKt.INSTANCE.m966getLambda1$foundation_release());
                }
            });
            value$iv$iv = new LazyLayoutItemProvider(itemProviderState) { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$1
                private final /* synthetic */ LazyLayoutItemProvider $$delegate_0;

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
                public void Item(int i, Composer composer, int i2) {
                    composer.startReplaceableGroup(-1058165788);
                    ComposerKt.sourceInformation(composer, "C(Item)-1@-2:LazyStaggeredGridItemProvider.kt#fzvcnm");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1058165788, i2, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridItemProvider.<anonymous>.<no name provided>.Item (LazyStaggeredGridItemProvider.kt:-1)");
                    }
                    this.$$delegate_0.Item(i, composer, i2 & 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceableGroup();
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
                public Object getContentType(int i) {
                    return this.$$delegate_0.getContentType(i);
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
                public int getItemCount() {
                    return this.$$delegate_0.getItemCount();
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
                public Object getKey(int i) {
                    return this.$$delegate_0.getKey(i);
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
                public Map<Object, Integer> getKeyToIndexMap() {
                    return this.$$delegate_0.getKeyToIndexMap();
                }

                {
                    this.$$delegate_0 = LazyLayoutItemProviderKt.DelegatingLazyLayoutItemProvider(itemProviderState);
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        C0207x329c90aa c0207x329c90aa = (C0207x329c90aa) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return c0207x329c90aa;
    }
}
