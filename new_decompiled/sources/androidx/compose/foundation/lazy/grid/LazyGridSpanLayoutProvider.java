package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: LazyGridSpanLayoutProvider.kt */
@Metadata(m286d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0003+,-B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001e\u001a\u00020\u0006H\u0002ø\u0001\u0000J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006J\u001e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\b\u0010'\u001a\u00020(H\u0002J\u0018\u0010)\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0002R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006."}, m287d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;)V", "bucketSize", "", "getBucketSize", "()I", "buckets", "Ljava/util/ArrayList;", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$Bucket;", "Lkotlin/collections/ArrayList;", "cachedBucket", "", "cachedBucketIndex", "lastLineIndex", "lastLineStartItemIndex", "lastLineStartKnownSpan", "previousDefaultSpans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "value", "slotsPerLine", "getSlotsPerLine", "setSlotsPerLine", "(I)V", "totalSize", "getTotalSize", "getDefaultSpans", "currentSlotsPerLine", "getLineConfiguration", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LineConfiguration;", "lineIndex", "getLineIndexOfItem", "Landroidx/compose/foundation/lazy/grid/LineIndex;", "itemIndex", "getLineIndexOfItem--_Ze7BM", "(I)I", "invalidateCache", "", "spanOf", "maxSpan", "Bucket", "LazyGridItemSpanScopeImpl", "LineConfiguration", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyGridSpanLayoutProvider {
    private final ArrayList<Bucket> buckets;
    private final List<Integer> cachedBucket;
    private int cachedBucketIndex;
    private final LazyGridItemProvider itemProvider;
    private int lastLineIndex;
    private int lastLineStartItemIndex;
    private int lastLineStartKnownSpan;
    private List<GridItemSpan> previousDefaultSpans;
    private int slotsPerLine;

    public LazyGridSpanLayoutProvider(LazyGridItemProvider itemProvider) {
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        this.itemProvider = itemProvider;
        ArrayList $this$buckets_u24lambda_u2d0 = new ArrayList();
        int i = 0;
        $this$buckets_u24lambda_u2d0.add(new Bucket(i, i, 2, null));
        this.buckets = $this$buckets_u24lambda_u2d0;
        this.cachedBucketIndex = -1;
        this.cachedBucket = new ArrayList();
        this.previousDefaultSpans = CollectionsKt.emptyList();
    }

    /* compiled from: LazyGridSpanLayoutProvider.kt */
    @Metadata(m286d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001e\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m287d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LineConfiguration;", "", "firstItemIndex", "", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "(ILjava/util/List;)V", "getFirstItemIndex", "()I", "getSpans", "()Ljava/util/List;", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public static final class LineConfiguration {
        public static final int $stable = 8;
        private final int firstItemIndex;
        private final List<GridItemSpan> spans;

        public LineConfiguration(int firstItemIndex, List<GridItemSpan> spans) {
            Intrinsics.checkNotNullParameter(spans, "spans");
            this.firstItemIndex = firstItemIndex;
            this.spans = spans;
        }

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final List<GridItemSpan> getSpans() {
            return this.spans;
        }
    }

    private final int getBucketSize() {
        return ((int) Math.sqrt((getTotalSize() * 1.0d) / this.slotsPerLine)) + 1;
    }

    private final List<GridItemSpan> getDefaultSpans(int currentSlotsPerLine) {
        if (currentSlotsPerLine == this.previousDefaultSpans.size()) {
            return this.previousDefaultSpans;
        }
        ArrayList arrayList = new ArrayList(currentSlotsPerLine);
        for (int i = 0; i < currentSlotsPerLine; i++) {
            arrayList.add(GridItemSpan.m888boximpl(LazyGridSpanKt.GridItemSpan(1)));
        }
        ArrayList it = arrayList;
        this.previousDefaultSpans = it;
        return it;
    }

    public final int getTotalSize() {
        return this.itemProvider.getItemCount();
    }

    public final int getSlotsPerLine() {
        return this.slotsPerLine;
    }

    public final void setSlotsPerLine(int value) {
        if (value != this.slotsPerLine) {
            this.slotsPerLine = value;
            invalidateCache();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b4 A[ADDED_TO_REGION, LOOP:0: B:26:0x00b4->B:55:0x00b4, LOOP_START, PHI: r2 r4 r5
      0x00b4: PHI (r2v7 'currentLine' int) = (r2v6 'currentLine' int), (r2v8 'currentLine' int) binds: [B:25:0x00b2, B:55:0x00b4] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r4v6 'currentItemIndex' int) = (r4v5 'currentItemIndex' int), (r4v9 'currentItemIndex' int) binds: [B:25:0x00b2, B:55:0x00b4] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r5v4 'knownCurrentItemSpan' int) = (r5v3 'knownCurrentItemSpan' int), (r5v11 'knownCurrentItemSpan' int) binds: [B:25:0x00b2, B:55:0x00b4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final LineConfiguration getLineConfiguration(int lineIndex) {
        boolean cacheThisBucket;
        int it;
        int it2;
        if (!this.itemProvider.getHasCustomSpans()) {
            int firstItemIndex = this.slotsPerLine * lineIndex;
            return new LineConfiguration(firstItemIndex, getDefaultSpans(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(this.slotsPerLine, getTotalSize() - firstItemIndex), 0)));
        }
        int firstItemIndex2 = getBucketSize();
        int bucketIndex = Math.min(lineIndex / firstItemIndex2, this.buckets.size() - 1);
        int currentLine = getBucketSize() * bucketIndex;
        int currentItemIndex = this.buckets.get(bucketIndex).getFirstItemIndex();
        int knownCurrentItemSpan = this.buckets.get(bucketIndex).getFirstItemKnownSpan();
        int i = this.lastLineIndex;
        if (currentLine <= i && i <= lineIndex) {
            currentLine = this.lastLineIndex;
            currentItemIndex = this.lastLineStartItemIndex;
            knownCurrentItemSpan = this.lastLineStartKnownSpan;
        } else if (bucketIndex == this.cachedBucketIndex && lineIndex - currentLine < this.cachedBucket.size()) {
            currentItemIndex = this.cachedBucket.get(lineIndex - currentLine).intValue();
            currentLine = lineIndex;
            knownCurrentItemSpan = 0;
        }
        if (currentLine % getBucketSize() == 0) {
            int i2 = lineIndex - currentLine;
            if (2 <= i2 && i2 < getBucketSize()) {
                cacheThisBucket = true;
                if (cacheThisBucket) {
                    this.cachedBucketIndex = bucketIndex;
                    this.cachedBucket.clear();
                }
                if (currentLine > lineIndex) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                while (currentLine < lineIndex && currentItemIndex < getTotalSize()) {
                    if (cacheThisBucket) {
                        this.cachedBucket.add(Integer.valueOf(currentItemIndex));
                    }
                    int spansUsed = 0;
                    while (spansUsed < this.slotsPerLine && currentItemIndex < getTotalSize()) {
                        if (knownCurrentItemSpan == 0) {
                            it2 = knownCurrentItemSpan;
                            knownCurrentItemSpan = spanOf(currentItemIndex, this.slotsPerLine - spansUsed);
                        } else {
                            it2 = 0;
                        }
                        if (spansUsed + knownCurrentItemSpan > this.slotsPerLine) {
                            break;
                        }
                        currentItemIndex++;
                        spansUsed += knownCurrentItemSpan;
                        knownCurrentItemSpan = it2;
                    }
                    currentLine++;
                    if (currentLine % getBucketSize() == 0 && currentItemIndex < getTotalSize()) {
                        int currentLineBucket = currentLine / getBucketSize();
                        if (!(this.buckets.size() == currentLineBucket)) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                        this.buckets.add(new Bucket(currentItemIndex, knownCurrentItemSpan));
                    }
                }
                this.lastLineIndex = lineIndex;
                this.lastLineStartItemIndex = currentItemIndex;
                this.lastLineStartKnownSpan = knownCurrentItemSpan;
                int firstItemIndex3 = currentItemIndex;
                List spans = new ArrayList();
                int spansUsed2 = 0;
                while (spansUsed2 < this.slotsPerLine && currentItemIndex < getTotalSize()) {
                    if (knownCurrentItemSpan == 0) {
                        it = knownCurrentItemSpan;
                        knownCurrentItemSpan = spanOf(currentItemIndex, this.slotsPerLine - spansUsed2);
                    } else {
                        it = 0;
                    }
                    if (spansUsed2 + knownCurrentItemSpan > this.slotsPerLine) {
                        break;
                    }
                    currentItemIndex++;
                    spans.add(GridItemSpan.m888boximpl(LazyGridSpanKt.GridItemSpan(knownCurrentItemSpan)));
                    spansUsed2 += knownCurrentItemSpan;
                    knownCurrentItemSpan = it;
                }
                return new LineConfiguration(firstItemIndex3, spans);
            }
        }
        cacheThisBucket = false;
        if (cacheThisBucket) {
        }
        if (currentLine > lineIndex) {
        }
    }

    /* renamed from: getLineIndexOfItem--_Ze7BM, reason: not valid java name */
    public final int m938getLineIndexOfItem_Ze7BM(final int itemIndex) {
        int i = 0;
        if (getTotalSize() <= 0) {
            return LineIndex.m948constructorimpl(0);
        }
        if (!(itemIndex < getTotalSize())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!this.itemProvider.getHasCustomSpans()) {
            return LineIndex.m948constructorimpl(itemIndex / this.slotsPerLine);
        }
        int it = CollectionsKt.binarySearch$default(this.buckets, 0, 0, new Function1<Bucket, Integer>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$getLineIndexOfItem$lowerBoundBucket$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(LazyGridSpanLayoutProvider.Bucket it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                return Integer.valueOf(it2.getFirstItemIndex() - itemIndex);
            }
        }, 3, (Object) null);
        int i2 = 2;
        if (it < 0) {
            it = (-it) - 2;
        }
        int currentLine = getBucketSize() * it;
        int span = this.buckets.get(it).getFirstItemIndex();
        if (!(span <= itemIndex)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int spansUsed = 0;
        while (span < itemIndex) {
            int currentItemIndex = span + 1;
            int span2 = spanOf(span, this.slotsPerLine - spansUsed);
            if (spansUsed + span2 < this.slotsPerLine) {
                spansUsed += span2;
            } else if (spansUsed + span2 == this.slotsPerLine) {
                currentLine++;
                spansUsed = 0;
            } else {
                currentLine++;
                spansUsed = span2;
            }
            if (currentLine % getBucketSize() == 0) {
                int currentLineBucket = currentLine / getBucketSize();
                if (currentLineBucket >= this.buckets.size()) {
                    this.buckets.add(new Bucket(currentItemIndex - (spansUsed > 0 ? 1 : 0), i, i2, null));
                }
            }
            span = currentItemIndex;
        }
        if (spanOf(itemIndex, this.slotsPerLine - spansUsed) + spansUsed > this.slotsPerLine) {
            currentLine++;
        }
        return LineIndex.m948constructorimpl(currentLine);
    }

    private final int spanOf(int itemIndex, int maxSpan) {
        LazyGridItemProvider $this$spanOf_u24lambda_u2d7 = this.itemProvider;
        LazyGridItemSpanScopeImpl $this$spanOf_u24lambda_u2d7_u24lambda_u2d6 = LazyGridItemSpanScopeImpl.INSTANCE;
        $this$spanOf_u24lambda_u2d7_u24lambda_u2d6.setMaxCurrentLineSpan(maxSpan);
        $this$spanOf_u24lambda_u2d7_u24lambda_u2d6.setMaxLineSpan(this.slotsPerLine);
        return RangesKt.coerceIn(GridItemSpan.m892getCurrentLineSpanimpl($this$spanOf_u24lambda_u2d7.mo923getSpan_orMbw($this$spanOf_u24lambda_u2d7_u24lambda_u2d6, itemIndex)), 1, this.slotsPerLine);
    }

    private final void invalidateCache() {
        this.buckets.clear();
        int i = 0;
        this.buckets.add(new Bucket(i, i, 2, null));
        this.lastLineIndex = 0;
        this.lastLineStartItemIndex = 0;
        this.cachedBucketIndex = -1;
        this.cachedBucket.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyGridSpanLayoutProvider.kt */
    @Metadata(m286d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, m287d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$Bucket;", "", "firstItemIndex", "", "firstItemKnownSpan", "(II)V", "getFirstItemIndex", "()I", "getFirstItemKnownSpan", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    static final class Bucket {
        private final int firstItemIndex;
        private final int firstItemKnownSpan;

        public Bucket(int firstItemIndex, int firstItemKnownSpan) {
            this.firstItemIndex = firstItemIndex;
            this.firstItemKnownSpan = firstItemKnownSpan;
        }

        public /* synthetic */ Bucket(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i3 & 2) != 0 ? 0 : i2);
        }

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final int getFirstItemKnownSpan() {
            return this.firstItemKnownSpan;
        }
    }

    /* compiled from: LazyGridSpanLayoutProvider.kt */
    @Metadata(m286d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, m287d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LazyGridItemSpanScopeImpl;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "()V", "maxCurrentLineSpan", "", "getMaxCurrentLineSpan", "()I", "setMaxCurrentLineSpan", "(I)V", "maxLineSpan", "getMaxLineSpan", "setMaxLineSpan", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    private static final class LazyGridItemSpanScopeImpl implements LazyGridItemSpanScope {
        public static final LazyGridItemSpanScopeImpl INSTANCE = new LazyGridItemSpanScopeImpl();
        private static int maxCurrentLineSpan;
        private static int maxLineSpan;

        private LazyGridItemSpanScopeImpl() {
        }

        @Override // androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
        public int getMaxCurrentLineSpan() {
            return maxCurrentLineSpan;
        }

        public void setMaxCurrentLineSpan(int i) {
            maxCurrentLineSpan = i;
        }

        @Override // androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
        public int getMaxLineSpan() {
            return maxLineSpan;
        }

        public void setMaxLineSpan(int i) {
            maxLineSpan = i;
        }
    }
}
