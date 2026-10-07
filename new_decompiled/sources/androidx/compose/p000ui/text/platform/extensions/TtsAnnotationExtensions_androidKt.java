package androidx.compose.p000ui.text.platform.extensions;

import android.text.style.TtsSpan;
import androidx.compose.p000ui.text.TtsAnnotation;
import androidx.compose.p000ui.text.VerbatimTtsAnnotation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TtsAnnotationExtensions.android.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003¨\u0006\u0004"}, m287d2 = {"toSpan", "Landroid/text/style/TtsSpan;", "Landroidx/compose/ui/text/TtsAnnotation;", "Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "ui-text_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TtsAnnotationExtensions_androidKt {
    public static final TtsSpan toSpan(TtsAnnotation $this$toSpan) {
        Intrinsics.checkNotNullParameter($this$toSpan, "<this>");
        if ($this$toSpan instanceof VerbatimTtsAnnotation) {
            return toSpan((VerbatimTtsAnnotation) $this$toSpan);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final TtsSpan toSpan(VerbatimTtsAnnotation $this$toSpan) {
        Intrinsics.checkNotNullParameter($this$toSpan, "<this>");
        TtsSpan.VerbatimBuilder builder = new TtsSpan.VerbatimBuilder($this$toSpan.getVerbatim());
        TtsSpan build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }
}
