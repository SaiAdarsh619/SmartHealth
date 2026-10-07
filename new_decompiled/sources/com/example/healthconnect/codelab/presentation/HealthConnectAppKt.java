package com.example.healthconnect.codelab.presentation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.example.healthconnect.codelab.data.HealthConnectManager;
import com.example.healthconnect.codelab.presentation.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HealthConnectApp.kt */
@Metadata(m286d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m287d2 = {"TAG", "", "HealthConnectApp", "", "healthConnectManager", "Lcom/example/healthconnect/codelab/data/HealthConnectManager;", "(Lcom/example/healthconnect/codelab/data/HealthConnectManager;Landroidx/compose/runtime/Composer;I)V", "finished_debug"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes10.dex */
public final class HealthConnectAppKt {
    public static final String TAG = "Health Connect Codelab";

    public static final void HealthConnectApp(final HealthConnectManager healthConnectManager, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(healthConnectManager, "healthConnectManager");
        Composer $composer2 = $composer.startRestartGroup(-1167673024);
        ComposerKt.sourceInformation($composer2, "C(HealthConnectApp)48@2171L1912:HealthConnectApp.kt#v9vxs7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1167673024, $changed, -1, "com.example.healthconnect.codelab.presentation.HealthConnectApp (HealthConnectApp.kt:47)");
        }
        ThemeKt.HealthConnectTheme(false, ComposableLambdaKt.composableLambda($composer2, -1213180265, true, new HealthConnectAppKt$HealthConnectApp$1(healthConnectManager)), $composer2, 48, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.HealthConnectAppKt$HealthConnectApp$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                HealthConnectAppKt.HealthConnectApp(HealthConnectManager.this, composer, $changed | 1);
            }
        });
    }
}
