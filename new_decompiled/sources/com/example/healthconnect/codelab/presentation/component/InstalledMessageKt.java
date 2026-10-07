package com.example.healthconnect.codelab.presentation.component;

import androidx.compose.material.TextKt;
import androidx.compose.p000ui.res.StringResources_androidKt;
import androidx.compose.p000ui.text.style.TextAlign;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.example.healthconnect.codelab.C0965R;
import com.example.healthconnect.codelab.presentation.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: InstalledMessage.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m287d2 = {"InstalledMessage", "", "(Landroidx/compose/runtime/Composer;I)V", "InstalledMessagePreview", "finished_debug"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes3.dex */
public final class InstalledMessageKt {
    public static final void InstalledMessage(Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(2106540976);
        ComposerKt.sourceInformation($composer3, "C(InstalledMessage)31@1195L55,30@1178L111:InstalledMessage.kt#wkenw8");
        if ($changed != 0 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2106540976, $changed, -1, "com.example.healthconnect.codelab.presentation.component.InstalledMessage (InstalledMessage.kt:29)");
            }
            $composer2 = $composer3;
            TextKt.m1585TextfLXpl1I(StringResources_androidKt.stringResource(C0965R.string.installed_welcome_message, $composer3, 0), null, 0L, 0L, null, null, null, 0L, null, TextAlign.m4261boximpl(TextAlign.INSTANCE.m4270getJustifye0LSkKk()), 0L, 0, false, 0, null, null, $composer2, 0, 0, 65022);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.component.InstalledMessageKt$InstalledMessage$1
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
                InstalledMessageKt.InstalledMessage(composer, $changed | 1);
            }
        });
    }

    public static final void InstalledMessagePreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1990387778);
        ComposerKt.sourceInformation($composer2, "C(InstalledMessagePreview)39@1348L47:InstalledMessage.kt#wkenw8");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1990387778, $changed, -1, "com.example.healthconnect.codelab.presentation.component.InstalledMessagePreview (InstalledMessage.kt:38)");
            }
            ThemeKt.HealthConnectTheme(false, ComposableSingletons$InstalledMessageKt.INSTANCE.m4698getLambda1$finished_debug(), $composer2, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.component.InstalledMessageKt$InstalledMessagePreview$1
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
                InstalledMessageKt.InstalledMessagePreview(composer, $changed | 1);
            }
        });
    }
}
