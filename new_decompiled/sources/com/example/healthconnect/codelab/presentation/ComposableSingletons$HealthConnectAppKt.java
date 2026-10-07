package com.example.healthconnect.codelab.presentation;

import androidx.compose.material.IconKt;
import androidx.compose.material.SnackbarData;
import androidx.compose.material.SnackbarHostKt;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.material.SnackbarKt;
import androidx.compose.material.TextKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.rounded.MenuKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.res.StringResources_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.example.healthconnect.codelab.C0965R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HealthConnectApp.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes10.dex */
public final class ComposableSingletons$HealthConnectAppKt {
    public static final ComposableSingletons$HealthConnectAppKt INSTANCE = new ComposableSingletons$HealthConnectAppKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f373lambda1 = ComposableLambdaKt.composableLambdaInstance(792716214, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.ComposableSingletons$HealthConnectAppKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C60@2575L33,60@2570L39:HealthConnectApp.kt#v9vxs7");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(792716214, $changed, -1, "com.example.healthconnect.codelab.presentation.ComposableSingletons$HealthConnectAppKt.lambda-1.<anonymous> (HealthConnectApp.kt:59)");
            }
            TextKt.m1585TextfLXpl1I(StringResources_androidKt.stringResource(C0965R.string.app_name, $composer, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 0, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f374lambda2 = ComposableLambdaKt.composableLambdaInstance(1906314095, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.ComposableSingletons$HealthConnectAppKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C73@3232L29,71@3099L196:HealthConnectApp.kt#v9vxs7");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1906314095, $changed, -1, "com.example.healthconnect.codelab.presentation.ComposableSingletons$HealthConnectAppKt.lambda-2.<anonymous> (HealthConnectApp.kt:70)");
                }
                IconKt.m1415Iconww6aTOc(MenuKt.getMenu(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(C0965R.string.menu, $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
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
    public static Function3<SnackbarData, Composer, Integer, Unit> f375lambda3 = ComposableLambdaKt.composableLambdaInstance(1530270475, false, new Function3<SnackbarData, Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.ComposableSingletons$HealthConnectAppKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(SnackbarData snackbarData, Composer composer, Integer num) {
            invoke(snackbarData, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(SnackbarData data, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(data, "data");
            ComposerKt.sourceInformation($composer, "C91@3835L29:HealthConnectApp.kt#v9vxs7");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1530270475, $changed, -1, "com.example.healthconnect.codelab.presentation.ComposableSingletons$HealthConnectAppKt.lambda-3.<anonymous> (HealthConnectApp.kt:90)");
            }
            SnackbarKt.m1496SnackbarsPrSdHI(data, null, false, null, 0L, 0L, 0L, 0.0f, $composer, 8, 254);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-4, reason: not valid java name */
    public static Function3<SnackbarHostState, Composer, Integer, Unit> f376lambda4 = ComposableLambdaKt.composableLambdaInstance(1966255486, false, new Function3<SnackbarHostState, Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.ComposableSingletons$HealthConnectAppKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(SnackbarHostState snackbarHostState, Composer composer, Integer num) {
            invoke(snackbarHostState, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(SnackbarHostState it, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(it, "it");
            ComposerKt.sourceInformation($composer, "C90@3788L94:HealthConnectApp.kt#v9vxs7");
            int $dirty = $changed;
            if (($changed & 14) == 0) {
                $dirty |= $composer.changed(it) ? 4 : 2;
            }
            if (($dirty & 91) != 18 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1966255486, $dirty, -1, "com.example.healthconnect.codelab.presentation.ComposableSingletons$HealthConnectAppKt.lambda-4.<anonymous> (HealthConnectApp.kt:89)");
                }
                SnackbarHostKt.SnackbarHost(it, null, ComposableSingletons$HealthConnectAppKt.INSTANCE.m4696getLambda3$finished_debug(), $composer, ($dirty & 14) | 384, 2);
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
    public final Function2<Composer, Integer, Unit> m4694getLambda1$finished_debug() {
        return f373lambda1;
    }

    /* renamed from: getLambda-2$finished_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4695getLambda2$finished_debug() {
        return f374lambda2;
    }

    /* renamed from: getLambda-3$finished_debug, reason: not valid java name */
    public final Function3<SnackbarData, Composer, Integer, Unit> m4696getLambda3$finished_debug() {
        return f375lambda3;
    }

    /* renamed from: getLambda-4$finished_debug, reason: not valid java name */
    public final Function3<SnackbarHostState, Composer, Integer, Unit> m4697getLambda4$finished_debug() {
        return f376lambda4;
    }
}
