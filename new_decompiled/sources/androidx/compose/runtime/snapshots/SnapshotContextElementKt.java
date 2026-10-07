package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ExperimentalComposeApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapshotContextElement.kt */
@Metadata(m286d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¨\u0006\u0003"}, m287d2 = {"asContextElement", "Landroidx/compose/runtime/snapshots/SnapshotContextElement;", "Landroidx/compose/runtime/snapshots/Snapshot;", "runtime_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SnapshotContextElementKt {
    @ExperimentalComposeApi
    public static final SnapshotContextElement asContextElement(Snapshot $this$asContextElement) {
        Intrinsics.checkNotNullParameter($this$asContextElement, "<this>");
        return new SnapshotContextElementImpl($this$asContextElement);
    }
}
