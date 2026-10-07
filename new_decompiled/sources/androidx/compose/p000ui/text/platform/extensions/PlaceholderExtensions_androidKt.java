package androidx.compose.p000ui.text.platform.extensions;

import android.text.Spannable;
import androidx.compose.p000ui.text.AnnotatedString;
import androidx.compose.p000ui.text.Placeholder;
import androidx.compose.p000ui.text.PlaceholderVerticalAlign;
import androidx.compose.p000ui.text.android.style.PlaceholderSpan;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.TextUnit;
import androidx.compose.p000ui.unit.TextUnitType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlaceholderExtensions.android.kt */
@Metadata(m286d1 = {"\u0000:\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a,\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a(\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00190\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\"!\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"!\u0010\u0007\u001a\u00020\u0001*\u00020\b8BX\u0082\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, m287d2 = {"spanUnit", "", "Landroidx/compose/ui/unit/TextUnit;", "getSpanUnit--R2X_6o$annotations", "(J)V", "getSpanUnit--R2X_6o", "(J)I", "spanVerticalAlign", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "getSpanVerticalAlign-do9X-Gg$annotations", "(I)V", "getSpanVerticalAlign-do9X-Gg", "(I)I", "setPlaceholder", "", "Landroid/text/Spannable;", "placeholder", "Landroidx/compose/ui/text/Placeholder;", "start", "end", "density", "Landroidx/compose/ui/unit/Density;", "setPlaceholders", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "ui-text_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class PlaceholderExtensions_androidKt {
    /* renamed from: getSpanUnit--R2X_6o$annotations, reason: not valid java name */
    private static /* synthetic */ void m4164getSpanUnitR2X_6o$annotations(long j) {
    }

    /* renamed from: getSpanVerticalAlign-do9X-Gg$annotations, reason: not valid java name */
    private static /* synthetic */ void m4166getSpanVerticalAligndo9XGg$annotations(int i) {
    }

    public static final void setPlaceholders(Spannable $this$setPlaceholders, List<AnnotatedString.Range<Placeholder>> placeholders, Density density) {
        Intrinsics.checkNotNullParameter($this$setPlaceholders, "<this>");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        int size = placeholders.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            AnnotatedString.Range item$iv = placeholders.get(index$iv);
            AnnotatedString.Range it = item$iv;
            Placeholder placeholder = it.component1();
            int start = it.getStart();
            int end = it.getEnd();
            setPlaceholder($this$setPlaceholders, placeholder, start, end, density);
        }
    }

    private static final void setPlaceholder(Spannable $this$setPlaceholder, Placeholder placeholder, int start, int end, Density density) {
        SpannableExtensions_androidKt.setSpan($this$setPlaceholder, new PlaceholderSpan(TextUnit.m4563getValueimpl(placeholder.getWidth()), m4163getSpanUnitR2X_6o(placeholder.getWidth()), TextUnit.m4563getValueimpl(placeholder.getHeight()), m4163getSpanUnitR2X_6o(placeholder.getHeight()), density.getDensity() * density.getFontScale(), m4165getSpanVerticalAligndo9XGg(placeholder.getPlaceholderVerticalAlign())), start, end);
    }

    /* renamed from: getSpanUnit--R2X_6o, reason: not valid java name */
    private static final int m4163getSpanUnitR2X_6o(long $this$spanUnit) {
        long m4562getTypeUIouoOA = TextUnit.m4562getTypeUIouoOA($this$spanUnit);
        if (TextUnitType.m4591equalsimpl0(m4562getTypeUIouoOA, TextUnitType.INSTANCE.m4596getSpUIouoOA())) {
            return 0;
        }
        return TextUnitType.m4591equalsimpl0(m4562getTypeUIouoOA, TextUnitType.INSTANCE.m4595getEmUIouoOA()) ? 1 : 2;
    }

    /* renamed from: getSpanVerticalAlign-do9X-Gg, reason: not valid java name */
    private static final int m4165getSpanVerticalAligndo9XGg(int $this$spanVerticalAlign) {
        if (PlaceholderVerticalAlign.m3891equalsimpl0($this$spanVerticalAlign, PlaceholderVerticalAlign.INSTANCE.m3895getAboveBaselineJ6kI3mc())) {
            return 0;
        }
        if (PlaceholderVerticalAlign.m3891equalsimpl0($this$spanVerticalAlign, PlaceholderVerticalAlign.INSTANCE.m3901getTopJ6kI3mc())) {
            return 1;
        }
        if (PlaceholderVerticalAlign.m3891equalsimpl0($this$spanVerticalAlign, PlaceholderVerticalAlign.INSTANCE.m3896getBottomJ6kI3mc())) {
            return 2;
        }
        if (PlaceholderVerticalAlign.m3891equalsimpl0($this$spanVerticalAlign, PlaceholderVerticalAlign.INSTANCE.m3897getCenterJ6kI3mc())) {
            return 3;
        }
        if (PlaceholderVerticalAlign.m3891equalsimpl0($this$spanVerticalAlign, PlaceholderVerticalAlign.INSTANCE.m3900getTextTopJ6kI3mc())) {
            return 4;
        }
        if (PlaceholderVerticalAlign.m3891equalsimpl0($this$spanVerticalAlign, PlaceholderVerticalAlign.INSTANCE.m3898getTextBottomJ6kI3mc())) {
            return 5;
        }
        if (PlaceholderVerticalAlign.m3891equalsimpl0($this$spanVerticalAlign, PlaceholderVerticalAlign.INSTANCE.m3899getTextCenterJ6kI3mc())) {
            return 6;
        }
        throw new IllegalStateException("Invalid PlaceholderVerticalAlign".toString());
    }
}
