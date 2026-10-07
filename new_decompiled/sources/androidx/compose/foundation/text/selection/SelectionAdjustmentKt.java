package androidx.compose.foundation.text.selection;

import androidx.compose.p000ui.text.TextRangeKt;
import kotlin.Metadata;

/* compiled from: SelectionAdjustment.kt */
@Metadata(m286d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, m287d2 = {"ensureAtLeastOneChar", "Landroidx/compose/ui/text/TextRange;", "offset", "", "lastOffset", "isStartHandle", "", "previousHandlesCrossed", "(IIZZ)J", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SelectionAdjustmentKt {
    public static final long ensureAtLeastOneChar(int offset, int lastOffset, boolean isStartHandle, boolean previousHandlesCrossed) {
        if (lastOffset == 0) {
            return TextRangeKt.TextRange(offset, offset);
        }
        if (offset == 0) {
            if (isStartHandle) {
                return TextRangeKt.TextRange(1, 0);
            }
            return TextRangeKt.TextRange(0, 1);
        }
        if (offset == lastOffset) {
            if (isStartHandle) {
                return TextRangeKt.TextRange(lastOffset - 1, lastOffset);
            }
            return TextRangeKt.TextRange(lastOffset, lastOffset - 1);
        }
        if (isStartHandle) {
            if (!previousHandlesCrossed) {
                return TextRangeKt.TextRange(offset - 1, offset);
            }
            return TextRangeKt.TextRange(offset + 1, offset);
        }
        if (!previousHandlesCrossed) {
            return TextRangeKt.TextRange(offset, offset + 1);
        }
        return TextRangeKt.TextRange(offset, offset - 1);
    }
}
