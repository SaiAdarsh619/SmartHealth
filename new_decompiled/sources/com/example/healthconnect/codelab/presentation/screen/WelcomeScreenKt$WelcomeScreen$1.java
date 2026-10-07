package com.example.healthconnect.codelab.presentation.screen;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: WelcomeScreen.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes4.dex */
final class WelcomeScreenKt$WelcomeScreen$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ State<Function0<Unit>> $currentOnAvailabilityCheck$delegate;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    WelcomeScreenKt$WelcomeScreen$1(LifecycleOwner lifecycleOwner, State<? extends Function0<Unit>> state) {
        super(1);
        this.$lifecycleOwner = lifecycleOwner;
        this.$currentOnAvailabilityCheck$delegate = state;
    }

    @Override // kotlin.jvm.functions.Function1
    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final State<Function0<Unit>> state = this.$currentOnAvailabilityCheck$delegate;
        final LifecycleEventObserver observer = new LifecycleEventObserver() { // from class: com.example.healthconnect.codelab.presentation.screen.WelcomeScreenKt$WelcomeScreen$1$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                WelcomeScreenKt$WelcomeScreen$1.invoke$lambda$0(State.this, lifecycleOwner, event);
            }
        };
        this.$lifecycleOwner.getLifecycle().addObserver(observer);
        final LifecycleOwner lifecycleOwner = this.$lifecycleOwner;
        return new DisposableEffectResult() { // from class: com.example.healthconnect.codelab.presentation.screen.WelcomeScreenKt$WelcomeScreen$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                LifecycleOwner.this.getLifecycle().removeObserver(observer);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(State currentOnAvailabilityCheck$delegate, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Function0 WelcomeScreen$lambda$0;
        Intrinsics.checkNotNullParameter(currentOnAvailabilityCheck$delegate, "$currentOnAvailabilityCheck$delegate");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_RESUME) {
            WelcomeScreen$lambda$0 = WelcomeScreenKt.WelcomeScreen$lambda$0(currentOnAvailabilityCheck$delegate);
            WelcomeScreen$lambda$0.invoke();
        }
    }
}
