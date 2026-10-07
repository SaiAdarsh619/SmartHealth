package androidx.lifecycle;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: View.kt */
@Metadata(m286d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, m287d2 = {"findViewTreeLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "Landroid/view/View;", "lifecycle-runtime-ktx_release"}, m288k = 2, m289mv = {1, 6, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class ViewKt {
    public static final LifecycleOwner findViewTreeLifecycleOwner(View $this$findViewTreeLifecycleOwner) {
        Intrinsics.checkNotNullParameter($this$findViewTreeLifecycleOwner, "<this>");
        return ViewTreeLifecycleOwner.get($this$findViewTreeLifecycleOwner);
    }
}
