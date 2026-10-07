package androidx.compose.p000ui.unit;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* compiled from: IntOffset.kt */
@Metadata(m286d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a-\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\"\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0011\u001a\"\u0010\u0013\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0011\u001a\"\u0010\u0013\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0011\u001a\u001a\u0010\u0016\u001a\u00020\u0001*\u00020\u000eH\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001a\u0010\u0019\u001a\u00020\u000e*\u00020\u0001H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0018\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, m287d2 = {"IntOffset", "Landroidx/compose/ui/unit/IntOffset;", "x", "", "y", "(II)J", "lerp", "start", "stop", "fraction", "", "lerp-81ZRxRo", "(JJF)J", "minus", "Landroidx/compose/ui/geometry/Offset;", "offset", "minus-Nv-tHpc", "(JJ)J", "minus-oCl6YwE", "plus", "plus-Nv-tHpc", "plus-oCl6YwE", "round", "round-k-4lQ0M", "(J)J", "toOffset", "toOffset--gyyYBs", "ui-unit_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class IntOffsetKt {
    public static final long IntOffset(int x, int y) {
        return IntOffset.m4494constructorimpl((x << 32) | (y & 4294967295L));
    }

    /* renamed from: lerp-81ZRxRo, reason: not valid java name */
    public static final long m4511lerp81ZRxRo(long start, long stop, float fraction) {
        return IntOffset(MathHelpersKt.lerp(IntOffset.m4500getXimpl(start), IntOffset.m4500getXimpl(stop), fraction), MathHelpersKt.lerp(IntOffset.m4501getYimpl(start), IntOffset.m4501getYimpl(stop), fraction));
    }

    /* renamed from: toOffset--gyyYBs, reason: not valid java name */
    public static final long m4517toOffsetgyyYBs(long $this$toOffset_u2d_u2dgyyYBs) {
        return OffsetKt.Offset(IntOffset.m4500getXimpl($this$toOffset_u2d_u2dgyyYBs), IntOffset.m4501getYimpl($this$toOffset_u2d_u2dgyyYBs));
    }

    /* renamed from: plus-Nv-tHpc, reason: not valid java name */
    public static final long m4514plusNvtHpc(long $this$plus_u2dNv_u2dtHpc, long offset) {
        return OffsetKt.Offset(Offset.m1760getXimpl($this$plus_u2dNv_u2dtHpc) + IntOffset.m4500getXimpl(offset), Offset.m1761getYimpl($this$plus_u2dNv_u2dtHpc) + IntOffset.m4501getYimpl(offset));
    }

    /* renamed from: minus-Nv-tHpc, reason: not valid java name */
    public static final long m4512minusNvtHpc(long $this$minus_u2dNv_u2dtHpc, long offset) {
        return OffsetKt.Offset(Offset.m1760getXimpl($this$minus_u2dNv_u2dtHpc) - IntOffset.m4500getXimpl(offset), Offset.m1761getYimpl($this$minus_u2dNv_u2dtHpc) - IntOffset.m4501getYimpl(offset));
    }

    /* renamed from: plus-oCl6YwE, reason: not valid java name */
    public static final long m4515plusoCl6YwE(long $this$plus_u2doCl6YwE, long offset) {
        return OffsetKt.Offset(IntOffset.m4500getXimpl($this$plus_u2doCl6YwE) + Offset.m1760getXimpl(offset), IntOffset.m4501getYimpl($this$plus_u2doCl6YwE) + Offset.m1761getYimpl(offset));
    }

    /* renamed from: minus-oCl6YwE, reason: not valid java name */
    public static final long m4513minusoCl6YwE(long $this$minus_u2doCl6YwE, long offset) {
        return OffsetKt.Offset(IntOffset.m4500getXimpl($this$minus_u2doCl6YwE) - Offset.m1760getXimpl(offset), IntOffset.m4501getYimpl($this$minus_u2doCl6YwE) - Offset.m1761getYimpl(offset));
    }

    /* renamed from: round-k-4lQ0M, reason: not valid java name */
    public static final long m4516roundk4lQ0M(long $this$round_u2dk_u2d4lQ0M) {
        return IntOffset(MathKt.roundToInt(Offset.m1760getXimpl($this$round_u2dk_u2d4lQ0M)), MathKt.roundToInt(Offset.m1761getYimpl($this$round_u2dk_u2d4lQ0M)));
    }
}
