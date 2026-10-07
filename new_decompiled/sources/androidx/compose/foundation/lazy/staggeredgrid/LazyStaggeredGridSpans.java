package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* compiled from: LazyStaggeredGridSpans.kt */
@Metadata(m286d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\bJ\u0016\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m287d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpans;", "", "()V", "anchor", "", "spans", "", "ensureCapacity", "", "capacity", "newOffset", "ensureValidIndex", "requestedIndex", "findNextItemIndex", "item", "target", "findPreviousItemIndex", "getSpan", "lowerBound", "reset", "setSpan", "span", "upperBound", "Companion", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridSpans {
    private static final int MaxCapacity = 131072;
    public static final int Unset = -1;
    private int anchor;
    private int[] spans = new int[16];

    public final void setSpan(int item, int span) {
        if (!(item >= 0)) {
            throw new IllegalArgumentException("Negative spans are not supported".toString());
        }
        ensureValidIndex(item);
        this.spans[item - this.anchor] = span + 1;
    }

    public final int getSpan(int item) {
        if (item < getAnchor() || item >= upperBound()) {
            return -1;
        }
        return this.spans[item - this.anchor] - 1;
    }

    public final int upperBound() {
        return this.anchor + this.spans.length;
    }

    /* renamed from: lowerBound, reason: from getter */
    public final int getAnchor() {
        return this.anchor;
    }

    public final void reset() {
        ArraysKt.fill$default(this.spans, 0, 0, 0, 6, (Object) null);
    }

    public final int findPreviousItemIndex(int item, int target) {
        for (int i = item - 1; -1 < i; i--) {
            int span = getSpan(i);
            if (span == target || span == -1) {
                return i;
            }
        }
        return -1;
    }

    public final int findNextItemIndex(int item, int target) {
        int upperBound = upperBound();
        for (int i = item + 1; i < upperBound; i++) {
            int span = getSpan(i);
            if (span == target || span == -1) {
                return i;
            }
        }
        int i2 = upperBound();
        return i2;
    }

    public final void ensureValidIndex(int requestedIndex) {
        int requestedCapacity = requestedIndex - this.anchor;
        if (requestedCapacity >= 0 && requestedCapacity < 131072) {
            ensureCapacity$default(this, requestedCapacity + 1, 0, 2, null);
            return;
        }
        int oldAnchor = this.anchor;
        this.anchor = Math.max(requestedIndex - (this.spans.length / 2), 0);
        int delta = this.anchor - oldAnchor;
        if (delta >= 0) {
            if (delta < this.spans.length) {
                ArraysKt.copyInto(this.spans, this.spans, 0, delta, this.spans.length);
            }
            ArraysKt.fill(this.spans, 0, Math.max(0, this.spans.length - delta), this.spans.length);
            return;
        }
        int delta2 = -delta;
        if (this.spans.length + delta2 < 131072) {
            ensureCapacity(this.spans.length + delta2 + 1, delta2);
            return;
        }
        if (delta2 < this.spans.length) {
            ArraysKt.copyInto(this.spans, this.spans, delta2, 0, this.spans.length - delta2);
        }
        ArraysKt.fill(this.spans, 0, 0, Math.min(this.spans.length, delta2));
    }

    static /* synthetic */ void ensureCapacity$default(LazyStaggeredGridSpans lazyStaggeredGridSpans, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        lazyStaggeredGridSpans.ensureCapacity(i, i2);
    }

    private final void ensureCapacity(int capacity, int newOffset) {
        if (!(capacity <= 131072)) {
            throw new IllegalArgumentException(("Requested span capacity " + capacity + " is larger than max supported: 131072!").toString());
        }
        if (this.spans.length < capacity) {
            int newSize = this.spans.length;
            while (newSize < capacity) {
                newSize *= 2;
            }
            this.spans = ArraysKt.copyInto$default(this.spans, new int[newSize], newOffset, 0, 0, 12, (Object) null);
        }
    }
}
