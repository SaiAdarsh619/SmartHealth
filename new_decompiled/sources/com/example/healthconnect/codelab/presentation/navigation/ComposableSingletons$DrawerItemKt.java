package com.example.healthconnect.codelab.presentation.navigation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawerItem.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes11.dex */
public final class ComposableSingletons$DrawerItemKt {
    public static final ComposableSingletons$DrawerItemKt INSTANCE = new ComposableSingletons$DrawerItemKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f380lambda1 = ComposableLambdaKt.composableLambdaInstance(-1111545996, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.ComposableSingletons$DrawerItemKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C65@2124L113:DrawerItem.kt#n2bxm1");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1111545996, $changed, -1, "com.example.healthconnect.codelab.presentation.navigation.ComposableSingletons$DrawerItemKt.lambda-1.<anonymous> (DrawerItem.kt:64)");
                }
                DrawerItemKt.DrawerItem(Screen.Vitals, true, new Function1<Screen, Unit>() { // from class: com.example.healthconnect.codelab.presentation.navigation.ComposableSingletons$DrawerItemKt$lambda-1$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Screen screen) {
                        invoke2(screen);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Screen it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                }, $composer, 438);
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
    public final Function2<Composer, Integer, Unit> m4701getLambda1$finished_debug() {
        return f380lambda1;
    }
}
