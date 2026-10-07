package androidx.compose.p000ui.text.input;

import android.view.inputmethod.EditorInfo;
import androidx.compose.p000ui.text.TextRange;
import androidx.core.view.inputmethod.EditorInfoCompat;
import com.google.common.primitives.Ints;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextInputServiceAndroid.android.kt */
@Metadata(m286d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m287d2 = {"DEBUG_CLASS", "", "hasFlag", "", "bits", "", "flag", "update", "", "Landroid/view/inputmethod/EditorInfo;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TextInputServiceAndroid_androidKt {
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    public static final void update(EditorInfo $this$update, ImeOptions imeOptions, TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter($this$update, "<this>");
        Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        int imeAction = imeOptions.getImeAction();
        int i = 6;
        if (ImeAction.m4091equalsimpl0(imeAction, ImeAction.INSTANCE.m4095getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m4091equalsimpl0(imeAction, ImeAction.INSTANCE.m4099getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m4091equalsimpl0(imeAction, ImeAction.INSTANCE.m4097getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m4091equalsimpl0(imeAction, ImeAction.INSTANCE.m4098getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m4091equalsimpl0(imeAction, ImeAction.INSTANCE.m4100getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m4091equalsimpl0(imeAction, ImeAction.INSTANCE.m4101getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m4091equalsimpl0(imeAction, ImeAction.INSTANCE.m4102getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m4091equalsimpl0(imeAction, ImeAction.INSTANCE.m4096getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        $this$update.imeOptions = i;
        int keyboardType = imeOptions.getKeyboardType();
        if (KeyboardType.m4124equalsimpl0(keyboardType, KeyboardType.INSTANCE.m4135getTextPjHm6EE())) {
            $this$update.inputType = 1;
        } else if (KeyboardType.m4124equalsimpl0(keyboardType, KeyboardType.INSTANCE.m4128getAsciiPjHm6EE())) {
            $this$update.inputType = 1;
            $this$update.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m4124equalsimpl0(keyboardType, KeyboardType.INSTANCE.m4131getNumberPjHm6EE())) {
            $this$update.inputType = 2;
        } else if (KeyboardType.m4124equalsimpl0(keyboardType, KeyboardType.INSTANCE.m4134getPhonePjHm6EE())) {
            $this$update.inputType = 3;
        } else if (KeyboardType.m4124equalsimpl0(keyboardType, KeyboardType.INSTANCE.m4136getUriPjHm6EE())) {
            $this$update.inputType = 17;
        } else if (KeyboardType.m4124equalsimpl0(keyboardType, KeyboardType.INSTANCE.m4130getEmailPjHm6EE())) {
            $this$update.inputType = 33;
        } else if (KeyboardType.m4124equalsimpl0(keyboardType, KeyboardType.INSTANCE.m4133getPasswordPjHm6EE())) {
            $this$update.inputType = 129;
        } else if (KeyboardType.m4124equalsimpl0(keyboardType, KeyboardType.INSTANCE.m4132getNumberPasswordPjHm6EE())) {
            $this$update.inputType = 18;
        } else if (KeyboardType.m4124equalsimpl0(keyboardType, KeyboardType.INSTANCE.m4129getDecimalPjHm6EE())) {
            $this$update.inputType = 8194;
        } else {
            throw new IllegalStateException("Invalid Keyboard Type".toString());
        }
        if (!imeOptions.getSingleLine() && hasFlag($this$update.inputType, 1)) {
            $this$update.inputType |= 131072;
            if (ImeAction.m4091equalsimpl0(imeOptions.getImeAction(), ImeAction.INSTANCE.m4095getDefaulteUduSuo())) {
                $this$update.imeOptions |= Ints.MAX_POWER_OF_TWO;
            }
        }
        if (hasFlag($this$update.inputType, 1)) {
            int capitalization = imeOptions.getCapitalization();
            if (KeyboardCapitalization.m4113equalsimpl0(capitalization, KeyboardCapitalization.INSTANCE.m4117getCharactersIUNYP9k())) {
                $this$update.inputType |= 4096;
            } else if (KeyboardCapitalization.m4113equalsimpl0(capitalization, KeyboardCapitalization.INSTANCE.m4120getWordsIUNYP9k())) {
                $this$update.inputType |= 8192;
            } else if (KeyboardCapitalization.m4113equalsimpl0(capitalization, KeyboardCapitalization.INSTANCE.m4119getSentencesIUNYP9k())) {
                $this$update.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                $this$update.inputType |= 32768;
            }
        }
        $this$update.initialSelStart = TextRange.m3957getStartimpl(textFieldValue.getSelection());
        $this$update.initialSelEnd = TextRange.m3952getEndimpl(textFieldValue.getSelection());
        EditorInfoCompat.setInitialSurroundingText($this$update, textFieldValue.getText());
        $this$update.imeOptions |= 33554432;
    }

    private static final boolean hasFlag(int bits, int flag) {
        return (bits & flag) == flag;
    }
}
