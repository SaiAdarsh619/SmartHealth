package androidx.compose.p000ui.semantics;

import androidx.compose.p000ui.ExperimentalComposeUiApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: SemanticsProperties.android.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\"5\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018G@GX\u0087\u008e\u0002¢\u0006\u0018\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, m287d2 = {"<set-?>", "", "testTagsAsResourceId", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "getTestTagsAsResourceId$annotations", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "getTestTagsAsResourceId", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", "setTestTagsAsResourceId", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Z)V", "testTagsAsResourceId$delegate", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SemanticsProperties_androidKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(SemanticsProperties_androidKt.class, "testTagsAsResourceId", "getTestTagsAsResourceId(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1))};
    private static final SemanticsPropertyKey testTagsAsResourceId$delegate = SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId();

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getTestTagsAsResourceId$annotations(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }

    @ExperimentalComposeUiApi
    public static final boolean getTestTagsAsResourceId(SemanticsPropertyReceiver $this$testTagsAsResourceId) {
        Intrinsics.checkNotNullParameter($this$testTagsAsResourceId, "<this>");
        return ((Boolean) testTagsAsResourceId$delegate.getValue($this$testTagsAsResourceId, $$delegatedProperties[0])).booleanValue();
    }

    @ExperimentalComposeUiApi
    public static final void setTestTagsAsResourceId(SemanticsPropertyReceiver $this$testTagsAsResourceId, boolean z) {
        Intrinsics.checkNotNullParameter($this$testTagsAsResourceId, "<this>");
        testTagsAsResourceId$delegate.setValue($this$testTagsAsResourceId, $$delegatedProperties[0], Boolean.valueOf(z));
    }
}
