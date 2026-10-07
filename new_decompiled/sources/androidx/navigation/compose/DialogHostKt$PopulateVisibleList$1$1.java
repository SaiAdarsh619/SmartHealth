package androidx.navigation.compose;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: DialogHost.kt */
@Metadata(m288k = 3, m289mv = {1, 6, 0}, m291xi = 48)
/* loaded from: classes14.dex */
final class DialogHostKt$PopulateVisibleList$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ NavBackStackEntry $entry;
    final /* synthetic */ List<NavBackStackEntry> $this_PopulateVisibleList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DialogHostKt$PopulateVisibleList$1$1(NavBackStackEntry navBackStackEntry, List<NavBackStackEntry> list) {
        super(1);
        this.$entry = navBackStackEntry;
        this.$this_PopulateVisibleList = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final List<NavBackStackEntry> list = this.$this_PopulateVisibleList;
        final NavBackStackEntry navBackStackEntry = this.$entry;
        final LifecycleEventObserver observer = new LifecycleEventObserver() { // from class: androidx.navigation.compose.DialogHostKt$PopulateVisibleList$1$1$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                DialogHostKt$PopulateVisibleList$1$1.m4664invoke$lambda0(list, navBackStackEntry, lifecycleOwner, event);
            }
        };
        this.$entry.getLifecycle().addObserver(observer);
        final NavBackStackEntry navBackStackEntry2 = this.$entry;
        return new DisposableEffectResult() { // from class: androidx.navigation.compose.DialogHostKt$PopulateVisibleList$1$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                NavBackStackEntry.this.getLifecycle().removeObserver(observer);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0, reason: not valid java name */
    public static final void m4664invoke$lambda0(List this_PopulateVisibleList, NavBackStackEntry entry, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(this_PopulateVisibleList, "$this_PopulateVisibleList");
        Intrinsics.checkNotNullParameter(entry, "$entry");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_START && !this_PopulateVisibleList.contains(entry)) {
            this_PopulateVisibleList.add(entry);
        }
        if (event == Lifecycle.Event.ON_STOP) {
            this_PopulateVisibleList.remove(entry);
        }
    }
}
