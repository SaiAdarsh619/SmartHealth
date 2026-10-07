package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.health.platform.client.SdkConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Crossfade.kt */
@Metadata(m286d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001aX\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0086\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\n2&\u0010\t\u001a\"\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, m287d2 = {"Crossfade", "", "T", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "label", "", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/animation/core/Transition;", "contentKey", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class CrossfadeKt {
    public static final <T> void Crossfade(final T t, Modifier modifier, FiniteAnimationSpec<Float> finiteAnimationSpec, String label, final Function3<? super T, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String label2;
        Modifier modifier3;
        FiniteAnimationSpec animationSpec;
        String label3;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-310686752);
        ComposerKt.sourceInformation($composer2, "C(Crossfade)P(4,3!1,2)55@2280L36,56@2332L53:Crossfade.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(t) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            label2 = label;
        } else if (($changed & 7168) == 0) {
            label2 = label;
            $dirty |= $composer2.changed(label2) ? 2048 : 1024;
        } else {
            label2 = label;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer2.changed(content) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (i3 == 4 && (46811 & $dirty2) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            animationSpec = finiteAnimationSpec;
            modifier3 = modifier2;
            label3 = label2;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            animationSpec = i3 != 0 ? AnimationSpecKt.tween$default(0, 0, null, 7, null) : finiteAnimationSpec;
            if (i4 != 0) {
                label2 = "Crossfade";
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-310686752, $dirty2, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:48)");
            }
            Transition transition = androidx.compose.animation.core.TransitionKt.updateTransition(t, label2, $composer2, ($dirty2 & 8) | ($dirty2 & 14) | (($dirty2 >> 6) & SdkConfig.SDK_VERSION), 0);
            label3 = label2;
            Crossfade(transition, modifier3, (FiniteAnimationSpec<Float>) animationSpec, (Function1) null, content, $composer2, ($dirty2 & SdkConfig.SDK_VERSION) | 512 | ($dirty2 & 57344), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final FiniteAnimationSpec finiteAnimationSpec2 = animationSpec;
        final String str = label3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i5) {
                CrossfadeKt.Crossfade(t, modifier4, finiteAnimationSpec2, str, content, composer, $changed | 1, i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Crossfade API now has a new label parameter added.")
    public static final /* synthetic */ void Crossfade(final Object targetState, Modifier modifier, FiniteAnimationSpec animationSpec, final Function3 content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        FiniteAnimationSpec animationSpec2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(523603005);
        ComposerKt.sourceInformation($composer2, "C(Crossfade)P(3,2)71@2743L29,72@2788L53:Crossfade.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(targetState) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(content) ? 2048 : 1024;
        }
        if (i3 == 4 && ($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            animationSpec2 = animationSpec;
        } else {
            Modifier.Companion modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            animationSpec2 = i3 != 0 ? AnimationSpecKt.tween$default(0, 0, null, 7, null) : animationSpec;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(523603005, $dirty, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:65)");
            }
            Transition transition = androidx.compose.animation.core.TransitionKt.updateTransition(targetState, (String) null, $composer2, ($dirty & 8) | ($dirty & 14), 2);
            Crossfade(transition, modifier3, (FiniteAnimationSpec<Float>) animationSpec2, (Function1) null, content, $composer2, ($dirty & SdkConfig.SDK_VERSION) | 512 | (($dirty << 3) & 57344), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier2;
        final FiniteAnimationSpec finiteAnimationSpec = animationSpec2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i4) {
                CrossfadeKt.Crossfade(targetState, modifier4, finiteAnimationSpec, content, composer, $changed | 1, i);
            }
        });
    }

    @ExperimentalAnimationApi
    public static final <T> void Crossfade(final Transition<T> transition, Modifier modifier, FiniteAnimationSpec<Float> finiteAnimationSpec, Function1<? super T, ? extends Object> function1, final Function3<? super T, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 contentKey;
        Modifier modifier3;
        FiniteAnimationSpec animationSpec;
        Object value$iv$iv;
        LinkedHashMap value$iv$iv2;
        Object value$iv$iv3;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(679005231);
        ComposerKt.sourceInformation($composer2, "C(Crossfade)P(3!1,2)103@4375L64,104@4461L66,138@5750L159:Crossfade.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & Integer.MIN_VALUE) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(transition) ? 4 : 2;
        }
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 128;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 3072;
            contentKey = function1;
        } else if (($changed & 7168) == 0) {
            contentKey = function1;
            $dirty |= $composer2.changed(contentKey) ? 2048 : 1024;
        } else {
            contentKey = function1;
        }
        if ((i & 8) != 0) {
            $dirty |= 24576;
        } else if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changed(content) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (i3 == 2 && (46811 & $dirty2) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            animationSpec = finiteAnimationSpec;
            modifier3 = modifier2;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            animationSpec = i3 != 0 ? AnimationSpecKt.tween$default(0, 0, null, 7, null) : finiteAnimationSpec;
            if (i4 != 0) {
                contentKey = new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3
                    @Override // kotlin.jvm.functions.Function1
                    public final T invoke(T t) {
                        return t;
                    }
                };
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(679005231, $dirty2, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:97)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                SnapshotStateList $this$Crossfade_u24lambda_u2d1_u24lambda_u2d0 = SnapshotStateKt.mutableStateListOf();
                $this$Crossfade_u24lambda_u2d1_u24lambda_u2d0.add(transition.getCurrentState());
                Unit unit = Unit.INSTANCE;
                value$iv$iv = $this$Crossfade_u24lambda_u2d1_u24lambda_u2d0;
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            List currentlyVisible = (SnapshotStateList) value$iv$iv;
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv2 = $composer2.rememberedValue();
            if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = new LinkedHashMap();
                $composer2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            Map contentMap = (Map) value$iv$iv2;
            $composer2.startReplaceableGroup(-1621449213);
            ComposerKt.sourceInformation($composer2, "111@4841L21");
            if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState()) && (currentlyVisible.size() != 1 || !Intrinsics.areEqual(currentlyVisible.get(0), transition.getTargetState()))) {
                List list = currentlyVisible;
                int i5 = $dirty2 & 14;
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer2.changed(transition);
                Object it$iv$iv3 = $composer2.rememberedValue();
                if (!invalid$iv$iv && it$iv$iv3 != Composer.INSTANCE.getEmpty()) {
                    value$iv$iv3 = it$iv$iv3;
                    $composer2.endReplaceableGroup();
                    CollectionsKt.removeAll(list, (Function1) value$iv$iv3);
                    contentMap.clear();
                }
                value$iv$iv3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(T t) {
                        return Boolean.valueOf(!Intrinsics.areEqual(t, transition.getTargetState()));
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                        return invoke((CrossfadeKt$Crossfade$4$1<T>) obj);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv3);
                $composer2.endReplaceableGroup();
                CollectionsKt.removeAll(list, (Function1) value$iv$iv3);
                contentMap.clear();
            }
            $composer2.endReplaceableGroup();
            if (!contentMap.containsKey(transition.getTargetState())) {
                List $this$indexOfFirst$iv = currentlyVisible;
                int $i$f$indexOfFirst = 0;
                int index$iv = 0;
                Iterator<T> it = $this$indexOfFirst$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        index$iv = -1;
                        break;
                    }
                    List $this$indexOfFirst$iv2 = $this$indexOfFirst$iv;
                    int $i$f$indexOfFirst2 = $i$f$indexOfFirst;
                    if (Intrinsics.areEqual(contentKey.invoke(it.next()), contentKey.invoke(transition.getTargetState()))) {
                        break;
                    }
                    index$iv++;
                    $this$indexOfFirst$iv = $this$indexOfFirst$iv2;
                    $i$f$indexOfFirst = $i$f$indexOfFirst2;
                }
                int replacementId = index$iv;
                if (replacementId == -1) {
                    currentlyVisible.add(transition.getTargetState());
                } else {
                    currentlyVisible.set(replacementId, transition.getTargetState());
                }
                contentMap.clear();
                List $this$fastForEach$iv = currentlyVisible;
                int size = $this$fastForEach$iv.size();
                int index$iv2 = 0;
                while (index$iv2 < size) {
                    T t = $this$fastForEach$iv.get(index$iv2);
                    contentMap.put(t, ComposableLambdaKt.composableLambda($composer2, -1426421288, true, new CrossfadeKt$Crossfade$5$1(transition, $dirty2, animationSpec, t, content)));
                    index$iv2++;
                    size = size;
                    $this$fastForEach$iv = $this$fastForEach$iv;
                }
            }
            int $changed$iv = ($dirty2 >> 3) & 14;
            $composer2.startReplaceableGroup(-1990474327);
            ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & SdkConfig.SDK_VERSION));
            int $changed$iv$iv = ($changed$iv << 3) & SdkConfig.SDK_VERSION;
            $composer2.startReplaceableGroup(1376089335);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier3);
            int $i$f$Layout = $changed$iv$iv << 9;
            int $changed$iv$iv$iv = $i$f$Layout & 7168;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer2);
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            $composer2.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
            $composer2.startReplaceableGroup(2058660585);
            $composer2.startReplaceableGroup(-1253629305);
            ComposerKt.sourceInformation($composer2, "C72@3384L9:Box.kt#2w3rfo");
            if ((((($changed$iv$iv$iv >> 9) & 14) & 11) ^ 2) == 0 && $composer2.getSkipping()) {
                $composer2.skipToGroupEnd();
            } else {
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int $changed2 = (($changed$iv >> 6) & SdkConfig.SDK_VERSION) | 6;
                $composer2.startReplaceableGroup(1930908853);
                ComposerKt.sourceInformation($composer2, "C:Crossfade.kt#xbi5r1");
                if (($changed2 & 81) == 16 && $composer2.getSkipping()) {
                    $composer2.skipToGroupEnd();
                } else {
                    List $this$fastForEach$iv2 = currentlyVisible;
                    int $i$f$fastForEach = $this$fastForEach$iv2.size();
                    int index$iv3 = 0;
                    while (index$iv3 < $i$f$fastForEach) {
                        Object item$iv = $this$fastForEach$iv2.get(index$iv3);
                        List $this$fastForEach$iv3 = $this$fastForEach$iv2;
                        int i6 = $i$f$fastForEach;
                        MeasurePolicy measurePolicy$iv2 = measurePolicy$iv;
                        $composer2.startMovableGroup(-450541366, contentKey.invoke(item$iv));
                        ComposerKt.sourceInformation($composer2, "141@5871L8");
                        Function2 function2 = (Function2) contentMap.get(item$iv);
                        if (function2 != null) {
                            function2.invoke($composer2, 0);
                            Unit unit2 = Unit.INSTANCE;
                        }
                        $composer2.endMovableGroup();
                        index$iv3++;
                        $i$f$fastForEach = i6;
                        $this$fastForEach$iv2 = $this$fastForEach$iv3;
                        measurePolicy$iv = measurePolicy$iv2;
                    }
                }
                $composer2.endReplaceableGroup();
            }
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final FiniteAnimationSpec finiteAnimationSpec2 = animationSpec;
        final Function1 function12 = contentKey;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i7) {
                CrossfadeKt.Crossfade(transition, modifier4, finiteAnimationSpec2, function12, content, composer, $changed | 1, i);
            }
        });
    }
}
