package com.example.healthconnect.codelab.presentation.screen.inputreadings;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.TextKt;
import androidx.compose.p000ui.res.StringResources_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.example.healthconnect.codelab.C0965R;
import com.example.healthconnect.codelab.presentation.model.VitalType;
import com.example.healthconnect.codelab.presentation.model.VitalUiModel;
import com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel;
import java.time.Instant;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputReadingsScreen.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes12.dex */
public final class ComposableSingletons$InputReadingsScreenKt {
    public static final ComposableSingletons$InputReadingsScreenKt INSTANCE = new ComposableSingletons$InputReadingsScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f392lambda1 = ComposableLambdaKt.composableLambdaInstance(1226533544, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.inputreadings.ComposableSingletons$InputReadingsScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            ComposerKt.sourceInformation($composer, "C123@4954L49,123@4942L62:InputReadingsScreen.kt#ddqsl8");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1226533544, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.inputreadings.ComposableSingletons$InputReadingsScreenKt.lambda-1.<anonymous> (InputReadingsScreen.kt:122)");
            }
            TextKt.m1585TextfLXpl1I(StringResources_androidKt.stringResource(C0965R.string.permissions_button_label, $composer, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 0, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f393lambda2 = ComposableLambdaKt.composableLambdaInstance(-1579786331, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.inputreadings.ComposableSingletons$InputReadingsScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C230@8378L612:InputReadingsScreen.kt#ddqsl8");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1579786331, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.inputreadings.ComposableSingletons$InputReadingsScreenKt.lambda-2.<anonymous> (InputReadingsScreen.kt:229)");
                }
                Set emptySet = SetsKt.emptySet();
                InputReadingsViewModel.UiState.Done done = InputReadingsViewModel.UiState.Done.INSTANCE;
                VitalType vitalType = VitalType.HEART_RATE;
                Instant now = Instant.now();
                Intrinsics.checkNotNullExpressionValue(now, "now()");
                VitalType vitalType2 = VitalType.SPO2;
                Instant now2 = Instant.now();
                Intrinsics.checkNotNullExpressionValue(now2, "now()");
                InputReadingsScreenKt.InputReadingsScreen(emptySet, true, CollectionsKt.listOf((Object[]) new VitalUiModel[]{new VitalUiModel(vitalType, "72", now), new VitalUiModel(vitalType2, "98", now2)}), done, null, null, null, null, null, $composer, 3638, 496);
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
    public final Function3<RowScope, Composer, Integer, Unit> m4713getLambda1$finished_debug() {
        return f392lambda1;
    }

    /* renamed from: getLambda-2$finished_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4714getLambda2$finished_debug() {
        return f393lambda2;
    }
}
