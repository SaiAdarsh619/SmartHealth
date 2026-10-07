package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.LayoutModifierKt;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimatedContent.kt */
@Metadata(m286d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f21\u0010\r\u001a-\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0012¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0013\u001aU\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172>\b\u0002\u0010\u0018\u001a8\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u001c0\u000eH\u0007ø\u0001\u0000\u001a¬\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2%\b\u0002\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u000721\u0010\r\u001a-\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0012¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010 \u001a\u0015\u0010!\u001a\u00020\t*\u00020\"2\u0006\u0010#\u001a\u00020$H\u0087\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, m287d2 = {"AnimatedContent", "", "S", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/animation/ContentTransform;", "Lkotlin/ExtensionFunctionType;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "content", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "SizeTransform", "Landroidx/compose/animation/SizeTransform;", "clip", "", "sizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "initialSize", "targetSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/animation/core/Transition;", "contentKey", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "with", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "animation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AnimatedContentKt {
    @ExperimentalAnimationApi
    public static final <S> void AnimatedContent(final S s, Modifier modifier, Function1<? super AnimatedContentScope<S>, ContentTransform> function1, Alignment contentAlignment, final Function4<? super AnimatedVisibilityScope, ? super S, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 function12;
        Alignment contentAlignment2;
        Modifier modifier3;
        Function1 transitionSpec;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(2124549995);
        ComposerKt.sourceInformation($composer2, "C(AnimatedContent)P(3,2,4,1)129@6620L70,130@6706L116:AnimatedContent.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(s) ? 4 : 2;
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
            $dirty |= 384;
            function12 = function1;
        } else if (($changed & 896) == 0) {
            function12 = function1;
            $dirty |= $composer2.changed(function12) ? 256 : 128;
        } else {
            function12 = function1;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            contentAlignment2 = contentAlignment;
        } else if (($changed & 7168) == 0) {
            contentAlignment2 = contentAlignment;
            $dirty |= $composer2.changed(contentAlignment2) ? 2048 : 1024;
        } else {
            contentAlignment2 = contentAlignment;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changed(content) ? 16384 : 8192;
        }
        if ((46811 & $dirty) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            transitionSpec = function12;
            modifier3 = modifier2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            Function1 transitionSpec2 = i3 != 0 ? new Function1<AnimatedContentScope<S>, ContentTransform>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$1
                @Override // kotlin.jvm.functions.Function1
                public final ContentTransform invoke(AnimatedContentScope<S> animatedContentScope) {
                    Intrinsics.checkNotNullParameter(animatedContentScope, "$this$null");
                    return AnimatedContentKt.with(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m377scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
                }
            } : function12;
            Alignment contentAlignment3 = i4 != 0 ? Alignment.INSTANCE.getTopStart() : contentAlignment2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2124549995, $dirty, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:118)");
            }
            Transition transition = androidx.compose.animation.core.TransitionKt.updateTransition(s, "AnimatedContent", $composer2, ($dirty & 8) | 48 | ($dirty & 14), 0);
            AnimatedContent(transition, modifier4, transitionSpec2, contentAlignment3, null, content, $composer2, ($dirty & SdkConfig.SDK_VERSION) | ($dirty & 896) | ($dirty & 7168) | (($dirty << 3) & 458752), 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            transitionSpec = transitionSpec2;
            contentAlignment2 = contentAlignment3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final Function1 function13 = transitionSpec;
        final Alignment alignment = contentAlignment2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$2
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
                AnimatedContentKt.AnimatedContent(s, modifier5, function13, alignment, content, composer, $changed | 1, i);
            }
        });
    }

    public static /* synthetic */ SizeTransform SizeTransform$default(boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function2 = new Function2<IntSize, IntSize, SpringSpec<IntSize>>() { // from class: androidx.compose.animation.AnimatedContentKt$SizeTransform$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ SpringSpec<IntSize> invoke(IntSize intSize, IntSize intSize2) {
                    return m330invokeTemP2vQ(intSize.getPackedValue(), intSize2.getPackedValue());
                }

                /* renamed from: invoke-TemP2vQ, reason: not valid java name */
                public final SpringSpec<IntSize> m330invokeTemP2vQ(long j, long j2) {
                    return AnimationSpecKt.spring$default(0.0f, 0.0f, IntSize.m4534boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 3, null);
                }
            };
        }
        return SizeTransform(z, function2);
    }

    @ExperimentalAnimationApi
    public static final SizeTransform SizeTransform(boolean clip, Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> sizeAnimationSpec) {
        Intrinsics.checkNotNullParameter(sizeAnimationSpec, "sizeAnimationSpec");
        return new SizeTransformImpl(clip, sizeAnimationSpec);
    }

    @ExperimentalAnimationApi
    public static final ContentTransform with(EnterTransition $this$with, ExitTransition exit) {
        Intrinsics.checkNotNullParameter($this$with, "<this>");
        Intrinsics.checkNotNullParameter(exit, "exit");
        return new ContentTransform($this$with, exit, 0.0f, null, 12, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01ec A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0370  */
    @ExperimentalAnimationApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <S> void AnimatedContent(final Transition<S> transition, Modifier modifier, Function1<? super AnimatedContentScope<S>, ContentTransform> function1, Alignment contentAlignment, Function1<? super S, ? extends Object> function12, final Function4<? super AnimatedVisibilityScope, ? super S, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 transitionSpec;
        Alignment contentAlignment2;
        Function1 contentKey;
        final int $dirty;
        LayoutDirection layoutDirection;
        boolean invalid$iv$iv;
        Object value$iv$iv;
        boolean invalid$iv$iv2;
        Object it$iv$iv;
        Object value$iv$iv2;
        boolean invalid$iv$iv3;
        Object it$iv$iv2;
        LinkedHashMap value$iv$iv3;
        Map contentMap;
        SnapshotStateList currentlyVisible;
        AnimatedContentScope rootScope;
        Function1 transitionSpec2;
        String str;
        Alignment contentAlignment3;
        int i2;
        AnimatedContentScope rootScope2;
        boolean invalid$iv$iv4;
        Function1 transitionSpec3;
        Object value$iv$iv4;
        Function1 transitionSpec4;
        Object value$iv$iv5;
        int $changed$iv$iv;
        Modifier modifier3;
        SnapshotStateList $this$indexOfFirst$iv;
        int $i$f$indexOfFirst;
        int index$iv;
        Iterator it;
        int id;
        List $this$indexOfFirst$iv2;
        int $i$f$indexOfFirst2;
        ScopeUpdateScope endRestartGroup;
        int i3;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-114689412);
        ComposerKt.sourceInformation($composer2, "C(AnimatedContent)P(3,4,1,2)585@27783L7,586@27811L92,591@27992L51,592@28065L62,663@31511L58,664@31603L45,674@31918L52,665@31653L323:AnimatedContent.kt#xbi5r1");
        int $dirty2 = $changed;
        if ((i & Integer.MIN_VALUE) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(transition) ? 4 : 2;
        }
        int i4 = i & 1;
        if (i4 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty2 |= 384;
            transitionSpec = function1;
        } else if (($changed & 896) == 0) {
            transitionSpec = function1;
            $dirty2 |= $composer2.changed(transitionSpec) ? 256 : 128;
        } else {
            transitionSpec = function1;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty2 |= 3072;
            contentAlignment2 = contentAlignment;
        } else if (($changed & 7168) == 0) {
            contentAlignment2 = contentAlignment;
            $dirty2 |= $composer2.changed(contentAlignment2) ? 2048 : 1024;
        } else {
            contentAlignment2 = contentAlignment;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty2 |= 24576;
            contentKey = function12;
        } else if ((57344 & $changed) == 0) {
            contentKey = function12;
            $dirty2 |= $composer2.changed(contentKey) ? 16384 : 8192;
        } else {
            contentKey = function12;
        }
        if ((i & 16) == 0) {
            i3 = (458752 & $changed) == 0 ? $composer2.changed(content) ? 131072 : 65536 : 196608;
            $dirty = $dirty2;
            if ((374491 & $dirty) == 74898 || !$composer2.getSkipping()) {
                Modifier modifier4 = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (i5 != 0) {
                    transitionSpec = new Function1<AnimatedContentScope<S>, ContentTransform>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$3
                        @Override // kotlin.jvm.functions.Function1
                        public final ContentTransform invoke(AnimatedContentScope<S> animatedContentScope) {
                            Intrinsics.checkNotNullParameter(animatedContentScope, "$this$null");
                            return AnimatedContentKt.with(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m377scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
                        }
                    };
                }
                if (i6 != 0) {
                    contentAlignment2 = Alignment.INSTANCE.getTopStart();
                }
                if (i7 != 0) {
                    contentKey = new Function1<S, S>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$4
                        @Override // kotlin.jvm.functions.Function1
                        public final S invoke(S s) {
                            return s;
                        }
                    };
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-114689412, $dirty, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:574)");
                }
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                String str2 = "C:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(localLayoutDirection);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                layoutDirection = (LayoutDirection) consume;
                int i8 = $dirty & 14;
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                invalid$iv$iv = $composer2.changed(transition);
                Object it$iv$iv3 = $composer2.rememberedValue();
                if (!invalid$iv$iv || it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = new AnimatedContentScope(transition, contentAlignment2, layoutDirection);
                    $composer2.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv3;
                }
                $composer2.endReplaceableGroup();
                AnimatedContentScope rootScope3 = (AnimatedContentScope) value$iv$iv;
                int i9 = $dirty & 14;
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                invalid$iv$iv2 = $composer2.changed(transition);
                it$iv$iv = $composer2.rememberedValue();
                if (!invalid$iv$iv2 && it$iv$iv != Composer.INSTANCE.getEmpty()) {
                    value$iv$iv2 = it$iv$iv;
                    $composer2.endReplaceableGroup();
                    SnapshotStateList currentlyVisible2 = (SnapshotStateList) value$iv$iv2;
                    int i10 = $dirty & 14;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                    invalid$iv$iv3 = $composer2.changed(transition);
                    it$iv$iv2 = $composer2.rememberedValue();
                    if (!invalid$iv$iv3 && it$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                        value$iv$iv3 = it$iv$iv2;
                        $composer2.endReplaceableGroup();
                        contentMap = (Map) value$iv$iv3;
                        if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                            if (currentlyVisible2.size() != 1 || !Intrinsics.areEqual(currentlyVisible2.get(0), transition.getCurrentState())) {
                                currentlyVisible2.clear();
                                currentlyVisible2.add(transition.getCurrentState());
                            }
                            if (contentMap.size() != 1 || contentMap.containsKey(transition.getCurrentState())) {
                                contentMap.clear();
                            }
                            rootScope3.setContentAlignment$animation_release(contentAlignment2);
                            rootScope3.setLayoutDirection$animation_release(layoutDirection);
                        }
                        if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState()) && !currentlyVisible2.contains(transition.getTargetState())) {
                            $this$indexOfFirst$iv = currentlyVisible2;
                            $i$f$indexOfFirst = 0;
                            index$iv = 0;
                            it = $this$indexOfFirst$iv.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    index$iv = -1;
                                    break;
                                }
                                $this$indexOfFirst$iv2 = $this$indexOfFirst$iv;
                                $i$f$indexOfFirst2 = $i$f$indexOfFirst;
                                if (Intrinsics.areEqual(contentKey.invoke(it.next()), contentKey.invoke(transition.getTargetState()))) {
                                    break;
                                }
                                index$iv++;
                                $i$f$indexOfFirst = $i$f$indexOfFirst2;
                                $this$indexOfFirst$iv = $this$indexOfFirst$iv2;
                            }
                            id = index$iv;
                            if (id != -1) {
                                currentlyVisible2.add(transition.getTargetState());
                            } else {
                                currentlyVisible2.set(id, transition.getTargetState());
                            }
                        }
                        if (contentMap.containsKey(transition.getTargetState())) {
                            contentMap.clear();
                            SnapshotStateList $this$fastForEach$iv = currentlyVisible2;
                            int index$iv2 = 0;
                            int size = $this$fastForEach$iv.size();
                            while (index$iv2 < size) {
                                final Object item$iv = $this$fastForEach$iv.get(index$iv2);
                                final SnapshotStateList currentlyVisible3 = currentlyVisible2;
                                final AnimatedContentScope rootScope4 = rootScope3;
                                LayoutDirection layoutDirection2 = layoutDirection;
                                final Function1 function13 = transitionSpec;
                                contentMap.put(item$iv, ComposableLambdaKt.composableLambda($composer2, 963631013, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1
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

                                    public final void invoke(Composer $composer3, int $changed2) {
                                        ContentTransform value$iv$iv6;
                                        Object value$iv$iv7;
                                        Object value$iv$iv8;
                                        ComposerKt.sourceInformation($composer3, "C625@29605L38,629@29819L142,632@29994L111,637@30288L1164:AnimatedContent.kt#xbi5r1");
                                        if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                                            $composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(963631013, $changed2, -1, "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous> (AnimatedContent.kt:624)");
                                        }
                                        Function1<AnimatedContentScope<S>, ContentTransform> function14 = function13;
                                        Object obj = rootScope4;
                                        $composer3.startReplaceableGroup(-492369756);
                                        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                                        Object it$iv$iv4 = $composer3.rememberedValue();
                                        if (it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
                                            value$iv$iv6 = function14.invoke(obj);
                                            $composer3.updateRememberedValue(value$iv$iv6);
                                        } else {
                                            value$iv$iv6 = it$iv$iv4;
                                        }
                                        $composer3.endReplaceableGroup();
                                        final ContentTransform specOnEnter = (ContentTransform) value$iv$iv6;
                                        Object key1$iv = Boolean.valueOf(Intrinsics.areEqual(transition.getSegment().getTargetState(), item$iv));
                                        Function1<AnimatedContentScope<S>, ContentTransform> function15 = function13;
                                        Object obj2 = rootScope4;
                                        $composer3.startReplaceableGroup(1157296644);
                                        ComposerKt.sourceInformation($composer3, "C(remember)P(1):Composables.kt#9igjgp");
                                        boolean invalid$iv$iv5 = $composer3.changed(key1$iv);
                                        Object it$iv$iv5 = $composer3.rememberedValue();
                                        if (invalid$iv$iv5 || it$iv$iv5 == Composer.INSTANCE.getEmpty()) {
                                            value$iv$iv7 = function15.invoke(obj2).getInitialContentExit();
                                            $composer3.updateRememberedValue(value$iv$iv7);
                                        } else {
                                            value$iv$iv7 = it$iv$iv5;
                                        }
                                        $composer3.endReplaceableGroup();
                                        ExitTransition exit = (ExitTransition) value$iv$iv7;
                                        S s = item$iv;
                                        Transition<S> transition2 = transition;
                                        $composer3.startReplaceableGroup(-492369756);
                                        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                                        Object it$iv$iv6 = $composer3.rememberedValue();
                                        if (it$iv$iv6 == Composer.INSTANCE.getEmpty()) {
                                            value$iv$iv8 = new AnimatedContentScope.ChildData(Intrinsics.areEqual(s, transition2.getTargetState()));
                                            $composer3.updateRememberedValue(value$iv$iv8);
                                        } else {
                                            value$iv$iv8 = it$iv$iv6;
                                        }
                                        $composer3.endReplaceableGroup();
                                        AnimatedContentScope.ChildData childData = (AnimatedContentScope.ChildData) value$iv$iv8;
                                        EnterTransition targetContentEnter = specOnEnter.getTargetContentEnter();
                                        Modifier layout = LayoutModifierKt.layout(Modifier.INSTANCE, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1.1
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                                return m329invoke3p2s80s(measureScope, measurable, constraints.getValue());
                                            }

                                            /* renamed from: invoke-3p2s80s, reason: not valid java name */
                                            public final MeasureResult m329invoke3p2s80s(MeasureScope layout2, Measurable measurable, long constraints) {
                                                Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                                                Intrinsics.checkNotNullParameter(measurable, "measurable");
                                                final Placeable placeable = measurable.mo3492measureBRTryo0(constraints);
                                                int width = placeable.getWidth();
                                                int height = placeable.getHeight();
                                                final ContentTransform contentTransform = ContentTransform.this;
                                                return MeasureScope.layout$default(layout2, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.5.1.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                        invoke2(placementScope);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(Placeable.PlacementScope layout3) {
                                                        Intrinsics.checkNotNullParameter(layout3, "$this$layout");
                                                        layout3.place(Placeable.this, 0, 0, contentTransform.getTargetContentZIndex());
                                                    }
                                                }, 4, null);
                                            }
                                        });
                                        childData.setTarget(Intrinsics.areEqual(item$iv, transition.getTargetState()));
                                        Modifier then = layout.then(childData);
                                        Transition<S> transition3 = transition;
                                        final S s2 = item$iv;
                                        Function1 function16 = new Function1<S, Boolean>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Multi-variable type inference failed */
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Boolean invoke(Object obj3) {
                                                return invoke((C00343<S>) obj3);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Boolean invoke(S s3) {
                                                return Boolean.valueOf(Intrinsics.areEqual(s3, s2));
                                            }
                                        };
                                        final AnimatedContentScope<S> animatedContentScope = rootScope4;
                                        final S s3 = item$iv;
                                        final Function4<AnimatedVisibilityScope, S, Composer, Integer, Unit> function4 = content;
                                        final int i11 = $dirty;
                                        final SnapshotStateList<S> snapshotStateList = currentlyVisible3;
                                        AnimatedVisibilityKt.AnimatedVisibility(transition3, function16, then, targetContentEnter, exit, ComposableLambdaKt.composableLambda($composer3, -1816907410, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1.4
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                                invoke(animatedVisibilityScope, composer, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer4, int $changed3) {
                                                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                                ComposerKt.sourceInformation($composer4, "C649@31000L253,657@31410L24:AnimatedContent.kt#xbi5r1");
                                                int $dirty3 = $changed3;
                                                if (($changed3 & 14) == 0) {
                                                    $dirty3 |= $composer4.changed(AnimatedVisibility) ? 4 : 2;
                                                }
                                                if (($dirty3 & 91) != 18 || !$composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1816907410, $dirty3, -1, "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous>.<anonymous> (AnimatedContent.kt:647)");
                                                    }
                                                    final SnapshotStateList<S> snapshotStateList2 = snapshotStateList;
                                                    final S s4 = s3;
                                                    final AnimatedContentScope<S> animatedContentScope2 = animatedContentScope;
                                                    EffectsKt.DisposableEffect(AnimatedVisibility, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.5.1.4.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                                            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                                            final SnapshotStateList<S> snapshotStateList3 = snapshotStateList2;
                                                            final S s5 = s4;
                                                            final AnimatedContentScope<S> animatedContentScope3 = animatedContentScope2;
                                                            return new DisposableEffectResult() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$4$1$invoke$$inlined$onDispose$1
                                                                @Override // androidx.compose.runtime.DisposableEffectResult
                                                                public void dispose() {
                                                                    SnapshotStateList.this.remove(s5);
                                                                    animatedContentScope3.getTargetSizeMap$animation_release().remove(s5);
                                                                }
                                                            };
                                                        }
                                                    }, $composer4, $dirty3 & 14);
                                                    animatedContentScope.getTargetSizeMap$animation_release().put(s3, ((AnimatedVisibilityScopeImpl) AnimatedVisibility).getTargetSize$animation_release());
                                                    function4.invoke(AnimatedVisibility, s3, $composer4, Integer.valueOf(($dirty3 & 14) | ((i11 >> 9) & 896)));
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer4.skipToGroupEnd();
                                            }
                                        }), $composer3, 196608 | ($dirty & 14), 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                                index$iv2++;
                                rootScope3 = rootScope4;
                                size = size;
                                $this$fastForEach$iv = $this$fastForEach$iv;
                                currentlyVisible2 = currentlyVisible3;
                                layoutDirection = layoutDirection2;
                                transitionSpec = transitionSpec;
                                str2 = str2;
                                contentAlignment2 = contentAlignment2;
                            }
                            currentlyVisible = currentlyVisible2;
                            rootScope = rootScope3;
                            transitionSpec2 = transitionSpec;
                            str = str2;
                            contentAlignment3 = contentAlignment2;
                            i2 = 0;
                        } else {
                            currentlyVisible = currentlyVisible2;
                            rootScope = rootScope3;
                            transitionSpec2 = transitionSpec;
                            str = "C:CompositionLocal.kt#9igjgp";
                            contentAlignment3 = contentAlignment2;
                            i2 = 0;
                        }
                        Object key2$iv = transition.getSegment();
                        $composer2.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
                        rootScope2 = rootScope;
                        invalid$iv$iv4 = $composer2.changed(rootScope2) | $composer2.changed(key2$iv);
                        Object it$iv$iv4 = $composer2.rememberedValue();
                        if (!invalid$iv$iv4 || it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
                            transitionSpec3 = transitionSpec2;
                            value$iv$iv4 = (ContentTransform) transitionSpec3.invoke(rootScope2);
                            $composer2.updateRememberedValue(value$iv$iv4);
                        } else {
                            value$iv$iv4 = it$iv$iv4;
                            transitionSpec3 = transitionSpec2;
                        }
                        $composer2.endReplaceableGroup();
                        ContentTransform contentTransform = (ContentTransform) value$iv$iv4;
                        Modifier sizeModifier = rootScope2.createSizeAnimationModifier$animation_release(contentTransform, $composer2, 72);
                        Modifier then = modifier4.then(sizeModifier);
                        $composer2.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                        transitionSpec4 = transitionSpec3;
                        value$iv$iv5 = $composer2.rememberedValue();
                        if (value$iv$iv5 != Composer.INSTANCE.getEmpty()) {
                            value$iv$iv5 = new AnimatedContentMeasurePolicy(rootScope2);
                            $composer2.updateRememberedValue(value$iv$iv5);
                        }
                        $composer2.endReplaceableGroup();
                        AnimatedContentMeasurePolicy animatedContentMeasurePolicy = (AnimatedContentMeasurePolicy) value$iv$iv5;
                        $composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        String str3 = str;
                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str3);
                        Object consume2 = $composer2.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        Density density$iv = (Density) consume2;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str3);
                        Object consume3 = $composer2.consume(localLayoutDirection2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        LayoutDirection layoutDirection$iv = (LayoutDirection) consume3;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str3);
                        Object consume4 = $composer2.consume(localViewConfiguration);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume4;
                        Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(then);
                        $changed$iv$iv = ((384 << 9) & 7168) | 6;
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if ($composer2.getInserting()) {
                            $composer2.useNode();
                        } else {
                            $composer2.createNode(factory$iv$iv);
                        }
                        $composer2.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv = Updater.m1639constructorimpl($composer2);
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, animatedContentMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, density$iv, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, layoutDirection$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, viewConfiguration$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer2.enableReusing();
                        skippableUpdate$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                        $composer2.startReplaceableGroup(2058660585);
                        $composer2.startReplaceableGroup(-451584589);
                        ComposerKt.sourceInformation($composer2, "C:AnimatedContent.kt#xbi5r1");
                        if ((($changed$iv$iv >> 9) & 14 & 11) == 2 || !$composer2.getSkipping()) {
                            SnapshotStateList $this$forEach$iv = currentlyVisible;
                            int $i$f$forEach = 0;
                            for (Object element$iv : $this$forEach$iv) {
                                Iterable $this$forEach$iv2 = $this$forEach$iv;
                                int $i$f$forEach2 = $i$f$forEach;
                                LayoutDirection layoutDirection$iv2 = layoutDirection$iv;
                                $composer2.startMovableGroup(-1739565921, contentKey.invoke(element$iv));
                                ComposerKt.sourceInformation($composer2, "670@31842L8");
                                Function2 function2 = (Function2) contentMap.get(element$iv);
                                if (function2 != null) {
                                    function2.invoke($composer2, Integer.valueOf(i2));
                                    Unit unit = Unit.INSTANCE;
                                }
                                $composer2.endMovableGroup();
                                $i$f$forEach = $i$f$forEach2;
                                $this$forEach$iv = $this$forEach$iv2;
                                layoutDirection$iv = layoutDirection$iv2;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                        }
                        $composer2.endReplaceableGroup();
                        $composer2.endReplaceableGroup();
                        $composer2.endNode();
                        $composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                    }
                    value$iv$iv3 = new LinkedHashMap();
                    $composer2.updateRememberedValue(value$iv$iv3);
                    $composer2.endReplaceableGroup();
                    contentMap = (Map) value$iv$iv3;
                    if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                    }
                    if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                        $this$indexOfFirst$iv = currentlyVisible2;
                        $i$f$indexOfFirst = 0;
                        index$iv = 0;
                        it = $this$indexOfFirst$iv.iterator();
                        while (true) {
                            if (it.hasNext()) {
                            }
                            index$iv++;
                            $i$f$indexOfFirst = $i$f$indexOfFirst2;
                            $this$indexOfFirst$iv = $this$indexOfFirst$iv2;
                        }
                        id = index$iv;
                        if (id != -1) {
                        }
                    }
                    if (contentMap.containsKey(transition.getTargetState())) {
                    }
                    Object key2$iv2 = transition.getSegment();
                    $composer2.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
                    rootScope2 = rootScope;
                    invalid$iv$iv4 = $composer2.changed(rootScope2) | $composer2.changed(key2$iv2);
                    Object it$iv$iv42 = $composer2.rememberedValue();
                    if (invalid$iv$iv4) {
                    }
                    transitionSpec3 = transitionSpec2;
                    value$iv$iv4 = (ContentTransform) transitionSpec3.invoke(rootScope2);
                    $composer2.updateRememberedValue(value$iv$iv4);
                    $composer2.endReplaceableGroup();
                    ContentTransform contentTransform2 = (ContentTransform) value$iv$iv4;
                    Modifier sizeModifier2 = rootScope2.createSizeAnimationModifier$animation_release(contentTransform2, $composer2, 72);
                    Modifier then2 = modifier4.then(sizeModifier2);
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                    transitionSpec4 = transitionSpec3;
                    value$iv$iv5 = $composer2.rememberedValue();
                    if (value$iv$iv5 != Composer.INSTANCE.getEmpty()) {
                    }
                    $composer2.endReplaceableGroup();
                    AnimatedContentMeasurePolicy animatedContentMeasurePolicy2 = (AnimatedContentMeasurePolicy) value$iv$iv5;
                    $composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    String str32 = str;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str32);
                    Object consume22 = $composer2.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Density density$iv2 = (Density) consume22;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str32);
                    Object consume32 = $composer2.consume(localLayoutDirection22);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    LayoutDirection layoutDirection$iv3 = (LayoutDirection) consume32;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str32);
                    Object consume42 = $composer2.consume(localViewConfiguration2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ViewConfiguration viewConfiguration$iv2 = (ViewConfiguration) consume42;
                    Function0 factory$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3 skippableUpdate$iv$iv2 = LayoutKt.materializerOf(then2);
                    $changed$iv$iv = ((384 << 9) & 7168) | 6;
                    if (!($composer2.getApplier() instanceof Applier)) {
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                    }
                    $composer2.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv2 = Updater.m1639constructorimpl($composer2);
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv2, animatedContentMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv2, density$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv2, layoutDirection$iv3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv2, viewConfiguration$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    $composer2.enableReusing();
                    skippableUpdate$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                    $composer2.startReplaceableGroup(2058660585);
                    $composer2.startReplaceableGroup(-451584589);
                    ComposerKt.sourceInformation($composer2, "C:AnimatedContent.kt#xbi5r1");
                    if ((($changed$iv$iv >> 9) & 14 & 11) == 2) {
                    }
                    SnapshotStateList $this$forEach$iv3 = currentlyVisible;
                    int $i$f$forEach3 = 0;
                    while (r19.hasNext()) {
                    }
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    $composer2.endNode();
                    $composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier4;
                }
                value$iv$iv2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                $composer2.updateRememberedValue(value$iv$iv2);
                $composer2.endReplaceableGroup();
                SnapshotStateList currentlyVisible22 = (SnapshotStateList) value$iv$iv2;
                int i102 = $dirty & 14;
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                invalid$iv$iv3 = $composer2.changed(transition);
                it$iv$iv2 = $composer2.rememberedValue();
                if (!invalid$iv$iv3) {
                    value$iv$iv3 = it$iv$iv2;
                    $composer2.endReplaceableGroup();
                    contentMap = (Map) value$iv$iv3;
                    if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                    }
                    if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                    }
                    if (contentMap.containsKey(transition.getTargetState())) {
                    }
                    Object key2$iv22 = transition.getSegment();
                    $composer2.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
                    rootScope2 = rootScope;
                    invalid$iv$iv4 = $composer2.changed(rootScope2) | $composer2.changed(key2$iv22);
                    Object it$iv$iv422 = $composer2.rememberedValue();
                    if (invalid$iv$iv4) {
                    }
                    transitionSpec3 = transitionSpec2;
                    value$iv$iv4 = (ContentTransform) transitionSpec3.invoke(rootScope2);
                    $composer2.updateRememberedValue(value$iv$iv4);
                    $composer2.endReplaceableGroup();
                    ContentTransform contentTransform22 = (ContentTransform) value$iv$iv4;
                    Modifier sizeModifier22 = rootScope2.createSizeAnimationModifier$animation_release(contentTransform22, $composer2, 72);
                    Modifier then22 = modifier4.then(sizeModifier22);
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                    transitionSpec4 = transitionSpec3;
                    value$iv$iv5 = $composer2.rememberedValue();
                    if (value$iv$iv5 != Composer.INSTANCE.getEmpty()) {
                    }
                    $composer2.endReplaceableGroup();
                    AnimatedContentMeasurePolicy animatedContentMeasurePolicy22 = (AnimatedContentMeasurePolicy) value$iv$iv5;
                    $composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                    String str322 = str;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str322);
                    Object consume222 = $composer2.consume(localDensity22);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Density density$iv22 = (Density) consume222;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection222 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str322);
                    Object consume322 = $composer2.consume(localLayoutDirection222);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    LayoutDirection layoutDirection$iv32 = (LayoutDirection) consume322;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration22 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str322);
                    Object consume422 = $composer2.consume(localViewConfiguration22);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ViewConfiguration viewConfiguration$iv22 = (ViewConfiguration) consume422;
                    Function0 factory$iv$iv22 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3 skippableUpdate$iv$iv22 = LayoutKt.materializerOf(then22);
                    $changed$iv$iv = ((384 << 9) & 7168) | 6;
                    if (!($composer2.getApplier() instanceof Applier)) {
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                    }
                    $composer2.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv22 = Updater.m1639constructorimpl($composer2);
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv22, animatedContentMeasurePolicy22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv22, density$iv22, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv22, layoutDirection$iv32, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv22, viewConfiguration$iv22, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    $composer2.enableReusing();
                    skippableUpdate$iv$iv22.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                    $composer2.startReplaceableGroup(2058660585);
                    $composer2.startReplaceableGroup(-451584589);
                    ComposerKt.sourceInformation($composer2, "C:AnimatedContent.kt#xbi5r1");
                    if ((($changed$iv$iv >> 9) & 14 & 11) == 2) {
                    }
                    SnapshotStateList $this$forEach$iv32 = currentlyVisible;
                    int $i$f$forEach32 = 0;
                    while (r19.hasNext()) {
                    }
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    $composer2.endNode();
                    $composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier4;
                }
                value$iv$iv3 = new LinkedHashMap();
                $composer2.updateRememberedValue(value$iv$iv3);
                $composer2.endReplaceableGroup();
                contentMap = (Map) value$iv$iv3;
                if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                }
                if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                }
                if (contentMap.containsKey(transition.getTargetState())) {
                }
                Object key2$iv222 = transition.getSegment();
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
                rootScope2 = rootScope;
                invalid$iv$iv4 = $composer2.changed(rootScope2) | $composer2.changed(key2$iv222);
                Object it$iv$iv4222 = $composer2.rememberedValue();
                if (invalid$iv$iv4) {
                }
                transitionSpec3 = transitionSpec2;
                value$iv$iv4 = (ContentTransform) transitionSpec3.invoke(rootScope2);
                $composer2.updateRememberedValue(value$iv$iv4);
                $composer2.endReplaceableGroup();
                ContentTransform contentTransform222 = (ContentTransform) value$iv$iv4;
                Modifier sizeModifier222 = rootScope2.createSizeAnimationModifier$animation_release(contentTransform222, $composer2, 72);
                Modifier then222 = modifier4.then(sizeModifier222);
                $composer2.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                transitionSpec4 = transitionSpec3;
                value$iv$iv5 = $composer2.rememberedValue();
                if (value$iv$iv5 != Composer.INSTANCE.getEmpty()) {
                }
                $composer2.endReplaceableGroup();
                AnimatedContentMeasurePolicy animatedContentMeasurePolicy222 = (AnimatedContentMeasurePolicy) value$iv$iv5;
                $composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
                String str3222 = str;
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str3222);
                Object consume2222 = $composer2.consume(localDensity222);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density density$iv222 = (Density) consume2222;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2222 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str3222);
                Object consume3222 = $composer2.consume(localLayoutDirection2222);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LayoutDirection layoutDirection$iv322 = (LayoutDirection) consume3222;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration222 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str3222);
                Object consume4222 = $composer2.consume(localViewConfiguration222);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ViewConfiguration viewConfiguration$iv222 = (ViewConfiguration) consume4222;
                Function0 factory$iv$iv222 = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv222 = LayoutKt.materializerOf(then222);
                $changed$iv$iv = ((384 << 9) & 7168) | 6;
                if (!($composer2.getApplier() instanceof Applier)) {
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                }
                $composer2.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv222 = Updater.m1639constructorimpl($composer2);
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv222, animatedContentMeasurePolicy222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv222, density$iv222, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv222, layoutDirection$iv322, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv222, viewConfiguration$iv222, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer2.enableReusing();
                skippableUpdate$iv$iv222.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                $composer2.startReplaceableGroup(2058660585);
                $composer2.startReplaceableGroup(-451584589);
                ComposerKt.sourceInformation($composer2, "C:AnimatedContent.kt#xbi5r1");
                if ((($changed$iv$iv >> 9) & 14 & 11) == 2) {
                }
                SnapshotStateList $this$forEach$iv322 = currentlyVisible;
                int $i$f$forEach322 = 0;
                while (r19.hasNext()) {
                }
                $composer2.endReplaceableGroup();
                $composer2.endReplaceableGroup();
                $composer2.endNode();
                $composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier4;
            } else {
                $composer2.skipToGroupEnd();
                modifier3 = modifier2;
                transitionSpec4 = transitionSpec;
                contentAlignment3 = contentAlignment2;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            final Modifier modifier5 = modifier3;
            final Function1 function14 = transitionSpec4;
            final Alignment alignment = contentAlignment3;
            final Function1 function15 = contentKey;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$8
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

                public final void invoke(Composer composer, int i11) {
                    AnimatedContentKt.AnimatedContent(transition, modifier5, function14, alignment, function15, content, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty2 |= i3;
        $dirty = $dirty2;
        if ((374491 & $dirty) == 74898) {
        }
        if (i4 == 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
        String str22 = "C:CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume5 = $composer2.consume(localLayoutDirection3);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        layoutDirection = (LayoutDirection) consume5;
        int i82 = $dirty & 14;
        $composer2.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
        invalid$iv$iv = $composer2.changed(transition);
        Object it$iv$iv32 = $composer2.rememberedValue();
        if (invalid$iv$iv) {
        }
        value$iv$iv = new AnimatedContentScope(transition, contentAlignment2, layoutDirection);
        $composer2.updateRememberedValue(value$iv$iv);
        $composer2.endReplaceableGroup();
        AnimatedContentScope rootScope32 = (AnimatedContentScope) value$iv$iv;
        int i92 = $dirty & 14;
        $composer2.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
        invalid$iv$iv2 = $composer2.changed(transition);
        it$iv$iv = $composer2.rememberedValue();
        if (!invalid$iv$iv2) {
            value$iv$iv2 = it$iv$iv;
            $composer2.endReplaceableGroup();
            SnapshotStateList currentlyVisible222 = (SnapshotStateList) value$iv$iv2;
            int i1022 = $dirty & 14;
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
            invalid$iv$iv3 = $composer2.changed(transition);
            it$iv$iv2 = $composer2.rememberedValue();
            if (!invalid$iv$iv3) {
            }
            value$iv$iv3 = new LinkedHashMap();
            $composer2.updateRememberedValue(value$iv$iv3);
            $composer2.endReplaceableGroup();
            contentMap = (Map) value$iv$iv3;
            if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
            }
            if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
            }
            if (contentMap.containsKey(transition.getTargetState())) {
            }
            Object key2$iv2222 = transition.getSegment();
            $composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
            rootScope2 = rootScope;
            invalid$iv$iv4 = $composer2.changed(rootScope2) | $composer2.changed(key2$iv2222);
            Object it$iv$iv42222 = $composer2.rememberedValue();
            if (invalid$iv$iv4) {
            }
            transitionSpec3 = transitionSpec2;
            value$iv$iv4 = (ContentTransform) transitionSpec3.invoke(rootScope2);
            $composer2.updateRememberedValue(value$iv$iv4);
            $composer2.endReplaceableGroup();
            ContentTransform contentTransform2222 = (ContentTransform) value$iv$iv4;
            Modifier sizeModifier2222 = rootScope2.createSizeAnimationModifier$animation_release(contentTransform2222, $composer2, 72);
            Modifier then2222 = modifier4.then(sizeModifier2222);
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            transitionSpec4 = transitionSpec3;
            value$iv$iv5 = $composer2.rememberedValue();
            if (value$iv$iv5 != Composer.INSTANCE.getEmpty()) {
            }
            $composer2.endReplaceableGroup();
            AnimatedContentMeasurePolicy animatedContentMeasurePolicy2222 = (AnimatedContentMeasurePolicy) value$iv$iv5;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity2222 = CompositionLocalsKt.getLocalDensity();
            String str32222 = str;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str32222);
            Object consume22222 = $composer2.consume(localDensity2222);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv2222 = (Density) consume22222;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22222 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str32222);
            Object consume32222 = $composer2.consume(localLayoutDirection22222);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv3222 = (LayoutDirection) consume32222;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2222 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str32222);
            Object consume42222 = $composer2.consume(localViewConfiguration2222);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv2222 = (ViewConfiguration) consume42222;
            Function0 factory$iv$iv2222 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv2222 = LayoutKt.materializerOf(then2222);
            $changed$iv$iv = ((384 << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv2222 = Updater.m1639constructorimpl($composer2);
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv2222, animatedContentMeasurePolicy2222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv2222, density$iv2222, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv2222, layoutDirection$iv3222, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv2222, viewConfiguration$iv2222, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv2222.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & SdkConfig.SDK_VERSION));
            $composer2.startReplaceableGroup(2058660585);
            $composer2.startReplaceableGroup(-451584589);
            ComposerKt.sourceInformation($composer2, "C:AnimatedContent.kt#xbi5r1");
            if ((($changed$iv$iv >> 9) & 14 & 11) == 2) {
            }
            SnapshotStateList $this$forEach$iv3222 = currentlyVisible;
            int $i$f$forEach3222 = 0;
            while (r19.hasNext()) {
            }
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier4;
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        value$iv$iv2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
        $composer2.updateRememberedValue(value$iv$iv2);
        $composer2.endReplaceableGroup();
        SnapshotStateList currentlyVisible2222 = (SnapshotStateList) value$iv$iv2;
        int i10222 = $dirty & 14;
        $composer2.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
        invalid$iv$iv3 = $composer2.changed(transition);
        it$iv$iv2 = $composer2.rememberedValue();
        if (!invalid$iv$iv3) {
        }
        value$iv$iv3 = new LinkedHashMap();
        $composer2.updateRememberedValue(value$iv$iv3);
        $composer2.endReplaceableGroup();
        contentMap = (Map) value$iv$iv3;
        if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
        }
        if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
        }
        if (contentMap.containsKey(transition.getTargetState())) {
        }
        Object key2$iv22222 = transition.getSegment();
        $composer2.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
        rootScope2 = rootScope;
        invalid$iv$iv4 = $composer2.changed(rootScope2) | $composer2.changed(key2$iv22222);
        Object it$iv$iv422222 = $composer2.rememberedValue();
        if (invalid$iv$iv4) {
        }
        transitionSpec3 = transitionSpec2;
        value$iv$iv4 = (ContentTransform) transitionSpec3.invoke(rootScope2);
        $composer2.updateRememberedValue(value$iv$iv4);
        $composer2.endReplaceableGroup();
        ContentTransform contentTransform22222 = (ContentTransform) value$iv$iv4;
        Modifier sizeModifier22222 = rootScope2.createSizeAnimationModifier$animation_release(contentTransform22222, $composer2, 72);
        Modifier then22222 = modifier4.then(sizeModifier22222);
        $composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
        transitionSpec4 = transitionSpec3;
        value$iv$iv5 = $composer2.rememberedValue();
        if (value$iv$iv5 != Composer.INSTANCE.getEmpty()) {
        }
        $composer2.endReplaceableGroup();
        AnimatedContentMeasurePolicy animatedContentMeasurePolicy22222 = (AnimatedContentMeasurePolicy) value$iv$iv5;
        $composer2.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        ProvidableCompositionLocal<Density> localDensity22222 = CompositionLocalsKt.getLocalDensity();
        String str322222 = str;
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str322222);
        Object consume222222 = $composer2.consume(localDensity22222);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        Density density$iv22222 = (Density) consume222222;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection222222 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str322222);
        Object consume322222 = $composer2.consume(localLayoutDirection222222);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        LayoutDirection layoutDirection$iv32222 = (LayoutDirection) consume322222;
        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration22222 = CompositionLocalsKt.getLocalViewConfiguration();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str322222);
        Object consume422222 = $composer2.consume(localViewConfiguration22222);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        ViewConfiguration viewConfiguration$iv22222 = (ViewConfiguration) consume422222;
        Function0 factory$iv$iv22222 = ComposeUiNode.INSTANCE.getConstructor();
        Function3 skippableUpdate$iv$iv22222 = LayoutKt.materializerOf(then22222);
        $changed$iv$iv = ((384 << 9) & 7168) | 6;
        if (!($composer2.getApplier() instanceof Applier)) {
        }
        $composer2.startReusableNode();
        if ($composer2.getInserting()) {
        }
        $composer2.disableReusing();
        Composer $this$Layout_u24lambda_u2d0$iv22222 = Updater.m1639constructorimpl($composer2);
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv22222, animatedContentMeasurePolicy22222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv22222, density$iv22222, ComposeUiNode.INSTANCE.getSetDensity());
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv22222, layoutDirection$iv32222, ComposeUiNode.INSTANCE.getSetLayoutDirection());
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv22222, viewConfiguration$iv22222, ComposeUiNode.INSTANCE.getSetViewConfiguration());
        $composer2.enableReusing();
        skippableUpdate$iv$iv22222.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & SdkConfig.SDK_VERSION));
        $composer2.startReplaceableGroup(2058660585);
        $composer2.startReplaceableGroup(-451584589);
        ComposerKt.sourceInformation($composer2, "C:AnimatedContent.kt#xbi5r1");
        if ((($changed$iv$iv >> 9) & 14 & 11) == 2) {
        }
        SnapshotStateList $this$forEach$iv32222 = currentlyVisible;
        int $i$f$forEach32222 = 0;
        while (r19.hasNext()) {
        }
        $composer2.endReplaceableGroup();
        $composer2.endReplaceableGroup();
        $composer2.endNode();
        $composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4;
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
