package com.example.healthconnect.codelab.presentation.screen.privacypolicy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: PrivacyPolicyScreen.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes13.dex */
public final class ComposableSingletons$PrivacyPolicyScreenKt {
    public static final ComposableSingletons$PrivacyPolicyScreenKt INSTANCE = new ComposableSingletons$PrivacyPolicyScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f394lambda1 = ComposableLambdaKt.composableLambdaInstance(32813724, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.privacypolicy.ComposableSingletons$PrivacyPolicyScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C68@2440L21:PrivacyPolicyScreen.kt#y5g8r1");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(32813724, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.privacypolicy.ComposableSingletons$PrivacyPolicyScreenKt.lambda-1.<anonymous> (PrivacyPolicyScreen.kt:67)");
            }
            PrivacyPolicyScreenKt.PrivacyPolicyScreen($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$finished_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4715getLambda1$finished_debug() {
        return f394lambda1;
    }
}
