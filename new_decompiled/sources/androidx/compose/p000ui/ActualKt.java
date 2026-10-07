package androidx.compose.p000ui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Actual.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¨\u0006\u0005"}, m287d2 = {"areObjectsOfSameType", "", "a", "", "b", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ActualKt {
    public static final boolean areObjectsOfSameType(Object a, Object b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        return a.getClass() == b.getClass();
    }
}
