package androidx.compose.animation.core;

import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InfiniteTransition.kt */
@Metadata(m286d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a5\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0007¢\u0006\u0002\u0010\n\u001aY\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\f0\u0004\"\u0004\b\u0000\u0010\f\"\b\b\u0001\u0010\r*\u00020\u000e*\u00020\u00012\u0006\u0010\u0006\u001a\u0002H\f2\u0006\u0010\u0007\u001a\u0002H\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r0\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\f0\tH\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, m287d2 = {"rememberInfiniteTransition", "Landroidx/compose/animation/core/InfiniteTransition;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/InfiniteTransition;", "animateFloat", "Landroidx/compose/runtime/State;", "", "initialValue", "targetValue", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "(Landroidx/compose/animation/core/InfiniteTransition;FFLandroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animateValue", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/InfiniteTransition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animation-core_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class InfiniteTransitionKt {
    public static final InfiniteTransition rememberInfiniteTransition(Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(-840193660);
        ComposerKt.sourceInformation($composer, "C(rememberInfiniteTransition)44@1855L33,45@1912L5:InfiniteTransition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-840193660, $changed, -1, "androidx.compose.animation.core.rememberInfiniteTransition (InfiniteTransition.kt:43)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new InfiniteTransition();
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        InfiniteTransition infiniteTransition = (InfiniteTransition) value$iv$iv;
        infiniteTransition.run$animation_core_release($composer, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return infiniteTransition;
    }

    public static final <T, V extends AnimationVector> State<T> animateValue(final InfiniteTransition $this$animateValue, final T t, final T t2, TwoWayConverter<T, V> typeConverter, final InfiniteRepeatableSpec<T> animationSpec, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$animateValue, "<this>");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        $composer.startReplaceableGroup(-1695411770);
        ComposerKt.sourceInformation($composer, "C(animateValue)P(1,2,3)223@8915L144,229@9065L357,241@9428L166:InfiniteTransition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1695411770, $changed, -1, "androidx.compose.animation.core.animateValue (InfiniteTransition.kt:216)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object value$iv$iv = $composer.rememberedValue();
        if (value$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new InfiniteTransition.TransitionAnimationState($this$animateValue, t, t2, typeConverter, animationSpec);
            $composer.updateRememberedValue(value$iv$iv);
        }
        $composer.endReplaceableGroup();
        final InfiniteTransition.TransitionAnimationState transitionAnimation = (InfiniteTransition.TransitionAnimationState) value$iv$iv;
        EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$1
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
                if (!Intrinsics.areEqual(t, transitionAnimation.getInitialValue()) || !Intrinsics.areEqual(t2, transitionAnimation.getTargetValue())) {
                    transitionAnimation.updateValues(t, t2, animationSpec);
                }
            }
        }, $composer, 0);
        EffectsKt.DisposableEffect(transitionAnimation, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                InfiniteTransition.this.addAnimation$animation_core_release(transitionAnimation);
                final InfiniteTransition infiniteTransition = InfiniteTransition.this;
                final InfiniteTransition.TransitionAnimationState<T, V> transitionAnimationState = transitionAnimation;
                return new DisposableEffectResult() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$2$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        InfiniteTransition.this.removeAnimation$animation_core_release(transitionAnimationState);
                    }
                };
            }
        }, $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return transitionAnimation;
    }

    public static final State<Float> animateFloat(InfiniteTransition $this$animateFloat, float initialValue, float targetValue, InfiniteRepeatableSpec<Float> animationSpec, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$animateFloat, "<this>");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        $composer.startReplaceableGroup(469472752);
        ComposerKt.sourceInformation($composer, "C(animateFloat)P(1,2)274@10633L77:InfiniteTransition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(469472752, $changed, -1, "androidx.compose.animation.core.animateFloat (InfiniteTransition.kt:269)");
        }
        State<Float> animateValue = animateValue($this$animateFloat, Float.valueOf(initialValue), Float.valueOf(targetValue), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), animationSpec, $composer, ($changed & SdkConfig.SDK_VERSION) | 8 | ($changed & 896) | (($changed << 3) & 57344));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValue;
    }
}
