package com.example.healthconnect.codelab.presentation.screen.profile;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.AppBarKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileScreen.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes9.dex */
public final class ComposableSingletons$ProfileScreenKt {
    public static final ComposableSingletons$ProfileScreenKt INSTANCE = new ComposableSingletons$ProfileScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f395lambda1 = ComposableLambdaKt.composableLambdaInstance(-1759983825, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ComposableSingletons$ProfileScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C29@1130L20:ProfileScreen.kt#amutfg");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1759983825, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.profile.ComposableSingletons$ProfileScreenKt.lambda-1.<anonymous> (ProfileScreen.kt:29)");
            }
            TextKt.m1585TextfLXpl1I("User Profile", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 6, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f396lambda2 = ComposableLambdaKt.composableLambdaInstance(471212139, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ComposableSingletons$ProfileScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C28@1093L73:ProfileScreen.kt#amutfg");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(471212139, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.profile.ComposableSingletons$ProfileScreenKt.lambda-2.<anonymous> (ProfileScreen.kt:27)");
                }
                AppBarKt.m1230TopAppBarxWeB9s(ComposableSingletons$ProfileScreenKt.INSTANCE.m4716getLambda1$finished_debug(), null, null, null, 0L, 0L, 0.0f, $composer, 6, 126);
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
    public static Function2<Composer, Integer, Unit> f397lambda3 = ComposableLambdaKt.composableLambdaInstance(-604297278, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ComposableSingletons$ProfileScreenKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C89@3574L11:ProfileScreen.kt#amutfg");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-604297278, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.profile.ComposableSingletons$ProfileScreenKt.lambda-3.<anonymous> (ProfileScreen.kt:89)");
            }
            TextKt.m1585TextfLXpl1I(HttpHeaders.AGE, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 6, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-4, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f398lambda4 = ComposableLambdaKt.composableLambdaInstance(-545373140, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ComposableSingletons$ProfileScreenKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            ComposerKt.sourceInformation($composer, "C190@7792L20:ProfileScreen.kt#amutfg");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-545373140, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.profile.ComposableSingletons$ProfileScreenKt.lambda-4.<anonymous> (ProfileScreen.kt:189)");
            }
            TextKt.m1585TextfLXpl1I("Save Profile", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 6, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$finished_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4716getLambda1$finished_debug() {
        return f395lambda1;
    }

    /* renamed from: getLambda-2$finished_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4717getLambda2$finished_debug() {
        return f396lambda2;
    }

    /* renamed from: getLambda-3$finished_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4718getLambda3$finished_debug() {
        return f397lambda3;
    }

    /* renamed from: getLambda-4$finished_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m4719getLambda4$finished_debug() {
        return f398lambda4;
    }
}
