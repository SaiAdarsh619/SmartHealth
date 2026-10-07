package androidx.compose.material.pullrefresh;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p000ui.graphics.GraphicsLayerScope;
import androidx.compose.p000ui.layout.OnRemeasuredModifierKt;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* compiled from: PullRefreshIndicatorTransform.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, m287d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $scale;
    final /* synthetic */ PullRefreshState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2(PullRefreshState pullRefreshState, boolean z) {
        super(3);
        this.$state = pullRefreshState;
        this.$scale = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-1, reason: not valid java name */
    public static final int m1605invoke$lambda1(MutableState<Integer> mutableState) {
        MutableState<Integer> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2, reason: not valid java name */
    public static final void m1606invoke$lambda2(MutableState<Integer> mutableState, int value) {
        mutableState.setValue(Integer.valueOf(value));
    }

    public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        $composer.startReplaceableGroup(1223983161);
        ComposerKt.sourceInformation($composer, "C49@1983L30,52@2051L22:PullRefreshIndicatorTransform.kt#t44y28");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1223983161, $changed, -1, "androidx.compose.material.pullrefresh.pullRefreshIndicatorTransform.<anonymous> (PullRefreshIndicatorTransform.kt:48)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        final MutableState height$delegate = (MutableState) value$iv$iv;
        Modifier.Companion companion = Modifier.INSTANCE;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(height$delegate);
        Object it$iv$iv2 = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv2 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                    m1607invokeozmzZPI(intSize.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                public final void m1607invokeozmzZPI(long it) {
                    PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2.m1606invoke$lambda2(height$delegate, IntSize.m4541getHeightimpl(it));
                }
            };
            $composer.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(companion, (Function1) value$iv$iv2);
        final PullRefreshState pullRefreshState = this.$state;
        final boolean z = this.$scale;
        Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(onSizeChanged, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GraphicsLayerScope graphicsLayer2) {
                Intrinsics.checkNotNullParameter(graphicsLayer2, "$this$graphicsLayer");
                graphicsLayer2.setTranslationY(PullRefreshState.this.getPosition$material_release() - PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2.m1605invoke$lambda1(height$delegate));
                if (z && !PullRefreshState.this.getRefreshing$material_release()) {
                    float scaleFraction = RangesKt.coerceIn(EasingKt.getLinearOutSlowInEasing().transform(PullRefreshState.this.getPosition$material_release() / PullRefreshState.this.getThreshold()), 0.0f, 1.0f);
                    graphicsLayer2.setScaleX(scaleFraction);
                    graphicsLayer2.setScaleY(scaleFraction);
                }
            }
        });
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return graphicsLayer;
    }
}
