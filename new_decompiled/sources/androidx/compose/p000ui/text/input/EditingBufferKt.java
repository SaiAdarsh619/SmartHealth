package androidx.compose.p000ui.text.input;

import androidx.compose.p000ui.text.TextRange;
import androidx.compose.p000ui.text.TextRangeKt;
import kotlin.Metadata;

/* compiled from: EditingBuffer.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0006"}, m287d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", "target", "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m4087updateRangeAfterDeletepWDy79M(long target, long deleted) {
        int targetMin = TextRange.m3955getMinimpl(target);
        int targetMax = TextRange.m3954getMaximpl(target);
        if (TextRange.m3959intersects5zctL8(deleted, target)) {
            if (TextRange.m3947contains5zctL8(deleted, target)) {
                targetMin = TextRange.m3955getMinimpl(deleted);
                targetMax = targetMin;
            } else if (TextRange.m3947contains5zctL8(target, deleted)) {
                targetMax -= TextRange.m3953getLengthimpl(deleted);
            } else if (TextRange.m3948containsimpl(deleted, targetMin)) {
                targetMin = TextRange.m3955getMinimpl(deleted);
                targetMax -= TextRange.m3953getLengthimpl(deleted);
            } else {
                targetMax = TextRange.m3955getMinimpl(deleted);
            }
        } else if (targetMax > TextRange.m3955getMinimpl(deleted)) {
            targetMin -= TextRange.m3953getLengthimpl(deleted);
            targetMax -= TextRange.m3953getLengthimpl(deleted);
        }
        return TextRangeKt.TextRange(targetMin, targetMax);
    }
}
