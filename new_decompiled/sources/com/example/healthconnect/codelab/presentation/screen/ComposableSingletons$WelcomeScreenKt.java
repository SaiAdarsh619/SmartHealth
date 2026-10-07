package com.example.healthconnect.codelab.presentation.screen;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.example.healthconnect.codelab.data.HealthConnectAvailability;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: WelcomeScreen.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$WelcomeScreenKt {
    public static final ComposableSingletons$WelcomeScreenKt INSTANCE = new ComposableSingletons$WelcomeScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f381lambda1 = ComposableLambdaKt.composableLambdaInstance(390977399, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.ComposableSingletons$WelcomeScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C112@4514L128:WelcomeScreen.kt#j0z0ov");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(390977399, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.ComposableSingletons$WelcomeScreenKt.lambda-1.<anonymous> (WelcomeScreen.kt:111)");
                }
                WelcomeScreenKt.WelcomeScreen(HealthConnectAvailability.INSTALLED, new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.ComposableSingletons$WelcomeScreenKt$lambda-1$1.1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                }, null, $composer, 54, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f382lambda2 = ComposableLambdaKt.composableLambdaInstance(-409568306, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.ComposableSingletons$WelcomeScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C123@4733L132:WelcomeScreen.kt#j0z0ov");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-409568306, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.ComposableSingletons$WelcomeScreenKt.lambda-2.<anonymous> (WelcomeScreen.kt:122)");
                }
                WelcomeScreenKt.WelcomeScreen(HealthConnectAvailability.NOT_INSTALLED, new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.ComposableSingletons$WelcomeScreenKt$lambda-2$1.1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                }, null, $composer, 54, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f383lambda3 = ComposableLambdaKt.composableLambdaInstance(-448401662, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.ComposableSingletons$WelcomeScreenKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C134@4956L132:WelcomeScreen.kt#j0z0ov");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-448401662, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.ComposableSingletons$WelcomeScreenKt.lambda-3.<anonymous> (WelcomeScreen.kt:133)");
                }
                WelcomeScreenKt.WelcomeScreen(HealthConnectAvailability.NOT_SUPPORTED, new Function0<Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.ComposableSingletons$WelcomeScreenKt$lambda-3$1.1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                }, null, $composer, 54, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* renamed from: getLambda-1$finished_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4702getLambda1$finished_debug() {
        return f381lambda1;
    }

    /* renamed from: getLambda-2$finished_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4703getLambda2$finished_debug() {
        return f382lambda2;
    }

    /* renamed from: getLambda-3$finished_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4704getLambda3$finished_debug() {
        return f383lambda3;
    }
}
