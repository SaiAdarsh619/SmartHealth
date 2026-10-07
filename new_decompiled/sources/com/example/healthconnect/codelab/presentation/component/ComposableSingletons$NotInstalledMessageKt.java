package com.example.healthconnect.codelab.presentation.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: NotInstalledMessage.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes3.dex */
public final class ComposableSingletons$NotInstalledMessageKt {
    public static final ComposableSingletons$NotInstalledMessageKt INSTANCE = new ComposableSingletons$NotInstalledMessageKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f378lambda1 = ComposableLambdaKt.composableLambdaInstance(621245791, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.component.ComposableSingletons$NotInstalledMessageKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C79@2979L21:NotInstalledMessage.kt#wkenw8");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(621245791, $changed, -1, "com.example.healthconnect.codelab.presentation.component.ComposableSingletons$NotInstalledMessageKt.lambda-1.<anonymous> (NotInstalledMessage.kt:78)");
            }
            NotInstalledMessageKt.NotInstalledMessage($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$finished_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4699getLambda1$finished_debug() {
        return f378lambda1;
    }
}
