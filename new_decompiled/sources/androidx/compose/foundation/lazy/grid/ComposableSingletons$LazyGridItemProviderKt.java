package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyGridItemProvider.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ComposableSingletons$LazyGridItemProviderKt {
    public static final ComposableSingletons$LazyGridItemProviderKt INSTANCE = new ComposableSingletons$LazyGridItemProviderKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function4<LazyGridIntervalContent, Integer, Composer, Integer, Unit> f342lambda1 = ComposableLambdaKt.composableLambdaInstance(637163000, false, new Function4<LazyGridIntervalContent, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.ComposableSingletons$LazyGridItemProviderKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridIntervalContent lazyGridIntervalContent, Integer num, Composer composer, Integer num2) {
            invoke(lazyGridIntervalContent, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyGridIntervalContent interval, int index, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(interval, "interval");
            ComposerKt.sourceInformation($composer, "CP(1)87@3403L36:LazyGridItemProvider.kt#7791vq");
            int $dirty = $changed;
            if (($changed & 14) == 0) {
                $dirty |= $composer.changed(interval) ? 4 : 2;
            }
            if (($changed & SdkConfig.SDK_VERSION) == 0) {
                $dirty |= $composer.changed(index) ? 32 : 16;
            }
            if (($dirty & 731) == 146 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(637163000, $dirty, -1, "androidx.compose.foundation.lazy.grid.ComposableSingletons$LazyGridItemProviderKt.lambda-1.<anonymous> (LazyGridItemProvider.kt:86)");
            }
            interval.getItem().invoke(LazyGridItemScopeImpl.INSTANCE, Integer.valueOf(index), $composer, Integer.valueOf(($dirty & SdkConfig.SDK_VERSION) | 6));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$foundation_release, reason: not valid java name */
    public final Function4<LazyGridIntervalContent, Integer, Composer, Integer, Unit> m886getLambda1$foundation_release() {
        return f342lambda1;
    }
}
