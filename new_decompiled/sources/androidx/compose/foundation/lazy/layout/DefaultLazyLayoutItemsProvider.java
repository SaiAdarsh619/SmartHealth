package androidx.compose.foundation.lazy.layout;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.health.platform.client.SdkConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: LazyLayoutItemProvider.kt */
@ExperimentalFoundationApi
@Metadata(m286d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003BN\u00121\u0010\u0004\u001a-\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\b\u000b¢\u0006\u0002\b\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0015\u0010\u001f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0017¢\u0006\u0002\u0010 J*\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u001b2\u0006\u0010\"\u001a\u00020\u00102\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0003J\u0012\u0010$\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\u0006H\u0016JT\u0010&\u001a\u0002H'\"\u0004\b\u0001\u0010'2\u0006\u0010\t\u001a\u00020\u000626\u0010(\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b()\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(*\u0012\u0004\u0012\u0002H'0\u0005H\u0082\b¢\u0006\u0002\u0010+R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R>\u0010\u0004\u001a-\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\b\u000b¢\u0006\u0002\b\f¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006,"}, m287d2 = {"Landroidx/compose/foundation/lazy/layout/DefaultLazyLayoutItemsProvider;", "IntervalContent", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "itemContentProvider", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "index", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "nearestItemsRange", "Lkotlin/ranges/IntRange;", "(Lkotlin/jvm/functions/Function4;Landroidx/compose/foundation/lazy/layout/IntervalList;Lkotlin/ranges/IntRange;)V", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/IntervalList;", "getItemContentProvider", "()Lkotlin/jvm/functions/Function4;", "Lkotlin/jvm/functions/Function4;", "itemCount", "getItemCount", "()I", "keyToIndexMap", "", "", "getKeyToIndexMap", "()Ljava/util/Map;", "Item", "(ILandroidx/compose/runtime/Composer;I)V", "generateKeyToIndexMap", "range", "list", "getContentType", "getKey", "withLocalIntervalIndex", "T", "block", "localIndex", "content", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class DefaultLazyLayoutItemsProvider<IntervalContent extends LazyLayoutIntervalContent> implements LazyLayoutItemProvider {
    private final IntervalList<IntervalContent> intervals;
    private final Function4<IntervalContent, Integer, Composer, Integer, Unit> itemContentProvider;
    private final Map<Object, Integer> keyToIndexMap;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultLazyLayoutItemsProvider(Function4<? super IntervalContent, ? super Integer, ? super Composer, ? super Integer, Unit> itemContentProvider, IntervalList<? extends IntervalContent> intervals, IntRange nearestItemsRange) {
        Intrinsics.checkNotNullParameter(itemContentProvider, "itemContentProvider");
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        Intrinsics.checkNotNullParameter(nearestItemsRange, "nearestItemsRange");
        this.itemContentProvider = itemContentProvider;
        this.intervals = intervals;
        this.keyToIndexMap = generateKeyToIndexMap(nearestItemsRange, this.intervals);
    }

    public final Function4<IntervalContent, Integer, Composer, Integer, Unit> getItemContentProvider() {
        return this.itemContentProvider;
    }

    public final IntervalList<IntervalContent> getIntervals() {
        return this.intervals;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int getItemCount() {
        return this.intervals.getSize();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public Map<Object, Integer> getKeyToIndexMap() {
        return this.keyToIndexMap;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public void Item(final int index, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1877726744);
        ComposerKt.sourceInformation($composer2, "C(Item)*117@4203L31:LazyLayoutItemProvider.kt#wow0x6");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(index) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(this) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1877726744, $changed, -1, "androidx.compose.foundation.lazy.layout.DefaultLazyLayoutItemsProvider.Item (LazyLayoutItemProvider.kt:115)");
            }
            IntervalList.Interval interval$iv = this.intervals.get(index);
            int localIntervalIndex$iv = index - interval$iv.getStartIndex();
            this.itemContentProvider.invoke(interval$iv.getValue(), Integer.valueOf(localIntervalIndex$iv), $composer2, 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>(this) { // from class: androidx.compose.foundation.lazy.layout.DefaultLazyLayoutItemsProvider$Item$2
            final /* synthetic */ DefaultLazyLayoutItemsProvider<IntervalContent> $tmp0_rcvr;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$tmp0_rcvr = this;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                this.$tmp0_rcvr.Item(index, composer, $changed | 1);
            }
        });
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public Object getKey(int index) {
        Object invoke;
        IntervalList.Interval interval$iv = this.intervals.get(index);
        int localIntervalIndex$iv = index - interval$iv.getStartIndex();
        IntervalContent content = interval$iv.getValue();
        Function1<Integer, Object> key = content.getKey();
        return (key == null || (invoke = key.invoke(Integer.valueOf(localIntervalIndex$iv))) == null) ? Lazy_androidKt.getDefaultLazyLayoutKey(index) : invoke;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public Object getContentType(int index) {
        IntervalList.Interval interval$iv = this.intervals.get(index);
        int localIntervalIndex$iv = index - interval$iv.getStartIndex();
        IntervalContent content = interval$iv.getValue();
        return content.getType().invoke(Integer.valueOf(localIntervalIndex$iv));
    }

    private final <T> T withLocalIntervalIndex(int index, Function2<? super Integer, ? super IntervalContent, ? extends T> block) {
        IntervalList.Interval<IntervalContent> interval = this.intervals.get(index);
        return block.invoke(Integer.valueOf(index - interval.getStartIndex()), (Object) interval.getValue());
    }

    @ExperimentalFoundationApi
    private final Map<Object, Integer> generateKeyToIndexMap(IntRange range, IntervalList<? extends LazyLayoutIntervalContent> list) {
        final int first = range.getFirst();
        if (first >= 0) {
            final int last = Math.min(range.getLast(), list.getSize() - 1);
            if (last < first) {
                return MapsKt.emptyMap();
            }
            final HashMap map = new HashMap();
            list.forEach(first, last, new Function1<IntervalList.Interval<? extends LazyLayoutIntervalContent>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.DefaultLazyLayoutItemsProvider$generateKeyToIndexMap$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IntervalList.Interval<? extends LazyLayoutIntervalContent> interval) {
                    invoke2(interval);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(IntervalList.Interval<? extends LazyLayoutIntervalContent> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it.getValue().getKey() != null) {
                        Function1 keyFactory = it.getValue().getKey();
                        if (keyFactory == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        int start = Math.max(first, it.getStartIndex());
                        int end = Math.min(last, (it.getStartIndex() + it.getSize()) - 1);
                        int i = start;
                        if (i > end) {
                            return;
                        }
                        while (true) {
                            map.put(keyFactory.invoke(Integer.valueOf(i - it.getStartIndex())), Integer.valueOf(i));
                            if (i == end) {
                                return;
                            } else {
                                i++;
                            }
                        }
                    }
                }
            });
            return map;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
