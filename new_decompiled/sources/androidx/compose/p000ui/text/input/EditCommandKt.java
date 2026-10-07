package androidx.compose.p000ui.text.input;

import androidx.health.connect.client.records.OvulationTestRecord;
import kotlin.Metadata;

/* compiled from: EditCommand.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¨\u0006\u0005"}, m287d2 = {"isSurrogatePair", "", OvulationTestRecord.Result.HIGH, "", "low", "ui-text_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class EditCommandKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isSurrogatePair(char high, char low) {
        return Character.isHighSurrogate(high) && Character.isLowSurrogate(low);
    }
}
