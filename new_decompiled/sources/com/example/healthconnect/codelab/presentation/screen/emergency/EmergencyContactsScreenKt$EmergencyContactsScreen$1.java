package com.example.healthconnect.codelab.presentation.screen.emergency;

import android.content.Context;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: EmergencyContactsScreen.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes12.dex */
final class EmergencyContactsScreenKt$EmergencyContactsScreen$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<Boolean> $hasSmsPermission$delegate;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EmergencyContactsScreenKt$EmergencyContactsScreen$1(LifecycleOwner lifecycleOwner, Context context, MutableState<Boolean> mutableState) {
        super(1);
        this.$lifecycleOwner = lifecycleOwner;
        this.$context = context;
        this.$hasSmsPermission$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final Context context = this.$context;
        final MutableState<Boolean> mutableState = this.$hasSmsPermission$delegate;
        final LifecycleEventObserver observer = new LifecycleEventObserver() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$EmergencyContactsScreen$1$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                EmergencyContactsScreenKt$EmergencyContactsScreen$1.invoke$lambda$0(context, mutableState, lifecycleOwner, event);
            }
        };
        this.$lifecycleOwner.getLifecycle().addObserver(observer);
        final LifecycleOwner lifecycleOwner = this.$lifecycleOwner;
        return new DisposableEffectResult() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.EmergencyContactsScreenKt$EmergencyContactsScreen$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                LifecycleOwner.this.getLifecycle().removeObserver(observer);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(Context context, MutableState hasSmsPermission$delegate, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(hasSmsPermission$delegate, "$hasSmsPermission$delegate");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_RESUME) {
            EmergencyContactsScreenKt.EmergencyContactsScreen$lambda$11(hasSmsPermission$delegate, ContextCompat.checkSelfPermission(context, "android.permission.SEND_SMS") == 0);
        }
    }
}
