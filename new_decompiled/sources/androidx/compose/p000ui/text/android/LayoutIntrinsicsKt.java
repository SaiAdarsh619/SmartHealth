package androidx.compose.p000ui.text.android;

import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import androidx.compose.p000ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.p000ui.text.android.style.LetterSpacingSpanPx;
import java.text.BreakIterator;
import java.util.Comparator;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutIntrinsics.kt */
@Metadata(m286d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, m287d2 = {"minIntrinsicWidth", "", "text", "", "paint", "Landroid/text/TextPaint;", "shouldIncreaseMaxIntrinsic", "", "desiredWidth", "charSequence", "textPaint", "ui-text_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LayoutIntrinsicsKt {
    public static final float minIntrinsicWidth(CharSequence text, TextPaint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        BreakIterator iterator = BreakIterator.getLineInstance(paint.getTextLocale());
        iterator.setText(new CharSequenceCharacterIterator(text, 0, text.length()));
        PriorityQueue longestWordCandidates = new PriorityQueue(10, new Comparator() { // from class: androidx.compose.ui.text.android.LayoutIntrinsicsKt$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int m3985minIntrinsicWidth$lambda0;
                m3985minIntrinsicWidth$lambda0 = LayoutIntrinsicsKt.m3985minIntrinsicWidth$lambda0((Pair) obj, (Pair) obj2);
                return m3985minIntrinsicWidth$lambda0;
            }
        });
        int start = 0;
        for (int end = iterator.next(); end != -1; end = iterator.next()) {
            if (longestWordCandidates.size() < 10) {
                longestWordCandidates.add(new Pair(Integer.valueOf(start), Integer.valueOf(end)));
            } else {
                Pair minPair = (Pair) longestWordCandidates.peek();
                if (minPair != null && ((Number) minPair.getSecond()).intValue() - ((Number) minPair.getFirst()).intValue() < end - start) {
                    longestWordCandidates.poll();
                    longestWordCandidates.add(new Pair(Integer.valueOf(start), Integer.valueOf(end)));
                }
            }
            start = end;
        }
        float minWidth = 0.0f;
        PriorityQueue $this$forEach$iv = longestWordCandidates;
        for (Object element$iv : $this$forEach$iv) {
            Pair pair = (Pair) element$iv;
            int start2 = ((Number) pair.component1()).intValue();
            int end2 = ((Number) pair.component2()).intValue();
            float width = Layout.getDesiredWidth(text, start2, end2, paint);
            minWidth = Math.max(minWidth, width);
        }
        return minWidth;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: minIntrinsicWidth$lambda-0, reason: not valid java name */
    public static final int m3985minIntrinsicWidth$lambda0(Pair left, Pair right) {
        return (((Number) left.getSecond()).intValue() - ((Number) left.getFirst()).intValue()) - (((Number) right.getSecond()).intValue() - ((Number) right.getFirst()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldIncreaseMaxIntrinsic(float desiredWidth, CharSequence charSequence, TextPaint textPaint) {
        if (!(desiredWidth == 0.0f) && (charSequence instanceof Spanned)) {
            if (!(textPaint.getLetterSpacing() == 0.0f) || SpannedExtensionsKt.hasSpan((Spanned) charSequence, LetterSpacingSpanPx.class) || SpannedExtensionsKt.hasSpan((Spanned) charSequence, LetterSpacingSpanEm.class)) {
                return true;
            }
        }
        return false;
    }
}
