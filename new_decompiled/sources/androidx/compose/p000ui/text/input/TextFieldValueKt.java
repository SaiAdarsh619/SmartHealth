package androidx.compose.p000ui.text.input;

import androidx.compose.p000ui.text.AnnotatedString;
import androidx.compose.p000ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldValue.kt */
@Metadata(m286d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0007"}, m287d2 = {"getSelectedText", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/input/TextFieldValue;", "getTextAfterSelection", "maxChars", "", "getTextBeforeSelection", "ui-text_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TextFieldValueKt {
    public static final AnnotatedString getTextBeforeSelection(TextFieldValue $this$getTextBeforeSelection, int maxChars) {
        Intrinsics.checkNotNullParameter($this$getTextBeforeSelection, "<this>");
        return $this$getTextBeforeSelection.getText().subSequence(Math.max(0, TextRange.m3955getMinimpl($this$getTextBeforeSelection.getSelection()) - maxChars), TextRange.m3955getMinimpl($this$getTextBeforeSelection.getSelection()));
    }

    public static final AnnotatedString getTextAfterSelection(TextFieldValue $this$getTextAfterSelection, int maxChars) {
        Intrinsics.checkNotNullParameter($this$getTextAfterSelection, "<this>");
        return $this$getTextAfterSelection.getText().subSequence(TextRange.m3954getMaximpl($this$getTextAfterSelection.getSelection()), Math.min(TextRange.m3954getMaximpl($this$getTextAfterSelection.getSelection()) + maxChars, $this$getTextAfterSelection.getText().length()));
    }

    public static final AnnotatedString getSelectedText(TextFieldValue $this$getSelectedText) {
        Intrinsics.checkNotNullParameter($this$getSelectedText, "<this>");
        return $this$getSelectedText.getText().m3861subSequence5zctL8($this$getSelectedText.getSelection());
    }
}
