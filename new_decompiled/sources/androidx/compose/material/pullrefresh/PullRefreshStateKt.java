package androidx.compose.material.pullrefresh;

import androidx.compose.material.ExperimentalMaterialApi;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PullRefreshState.kt */
@Metadata(m286d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a?\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, m287d2 = {"DragMultiplier", "", "rememberPullRefreshState", "Landroidx/compose/material/pullrefresh/PullRefreshState;", "refreshing", "", "onRefresh", "Lkotlin/Function0;", "", "refreshThreshold", "Landroidx/compose/ui/unit/Dp;", "refreshingOffset", "rememberPullRefreshState-UuyPYSY", "(ZLkotlin/jvm/functions/Function0;FFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/pullrefresh/PullRefreshState;", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class PullRefreshStateKt {
    private static final float DragMultiplier = 0.5f;

    @ExperimentalMaterialApi
    /* renamed from: rememberPullRefreshState-UuyPYSY, reason: not valid java name */
    public static final PullRefreshState m1608rememberPullRefreshStateUuyPYSY(final boolean refreshing, Function0<Unit> onRefresh, float refreshThreshold, float refreshingOffset, Composer $composer, int $changed, int i) {
        Object value$iv$iv$iv;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(onRefresh, "onRefresh");
        $composer.startReplaceableGroup(-174977512);
        ComposerKt.sourceInformation($composer, "C(rememberPullRefreshState)P(2!1,1:c#ui.unit.Dp,3:c#ui.unit.Dp)62@2491L24,63@2541L31,*67@2657L7,74@2929L104,78@3039L58:PullRefreshState.kt#t44y28");
        float refreshThreshold2 = (i & 4) != 0 ? PullRefreshDefaults.INSTANCE.m1595getRefreshThresholdD9Ej5fM() : refreshThreshold;
        float refreshingOffset2 = (i & 8) != 0 ? PullRefreshDefaults.INSTANCE.m1596getRefreshingOffsetD9Ej5fM() : refreshingOffset;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-174977512, $changed, -1, "androidx.compose.material.pullrefresh.rememberPullRefreshState (PullRefreshState.kt:54)");
        }
        int $this$dp$iv = C0504Dp.m4381compareTo0680j_4(refreshThreshold2, C0504Dp.m4382constructorimpl(0));
        if (!($this$dp$iv > 0)) {
            throw new IllegalArgumentException("The refresh trigger must be greater than zero!".toString());
        }
        $composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation($composer, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv$iv = $composer.rememberedValue();
        if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
            $composer.updateRememberedValue(value$iv$iv$iv);
        } else {
            value$iv$iv$iv = it$iv$iv$iv;
        }
        $composer.endReplaceableGroup();
        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
        CoroutineScope scope = wrapper$iv.getCoroutineScope();
        $composer.endReplaceableGroup();
        State onRefreshState = SnapshotStateKt.rememberUpdatedState(onRefresh, $composer, ($changed >> 3) & 14);
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density $this$rememberPullRefreshState_UuyPYSY_u24lambda_u2d1 = (Density) consume;
        float thresholdPx = $this$rememberPullRefreshState_UuyPYSY_u24lambda_u2d1.mo648toPx0680j_4(refreshThreshold2);
        float refreshingOffsetPx = $this$rememberPullRefreshState_UuyPYSY_u24lambda_u2d1.mo648toPx0680j_4(refreshingOffset2);
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(scope);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new PullRefreshState(scope, onRefreshState, refreshingOffsetPx, thresholdPx);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        final PullRefreshState state = (PullRefreshState) value$iv$iv;
        EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshStateKt$rememberPullRefreshState$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PullRefreshState.this.setRefreshing$material_release(refreshing);
            }
        }, $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return state;
    }
}
