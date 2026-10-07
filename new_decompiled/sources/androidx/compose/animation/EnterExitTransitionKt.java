package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.ClipKt;
import androidx.compose.p000ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p000ui.graphics.GraphicsLayerScope;
import androidx.compose.p000ui.graphics.TransformOrigin;
import androidx.compose.p000ui.graphics.TransformOriginKt;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.IntOffsetKt;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.IntSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterExitTransition.kt */
@Metadata(m286d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aT\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001aT\u0010\u001b\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b0\u0016H\u0007ø\u0001\u0000\u001aT\u0010\u001f\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0011\u001a\u00020 2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a\"\u0010#\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010$\u001a\u00020\u0002H\u0007\u001a\"\u0010%\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010'\u001a\u00020\u0002H\u0007\u001a9\u0010(\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u000bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a9\u0010-\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010.\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u000bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001aT\u00101\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u00102\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u00103\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001aT\u00104\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u00102\u001a\u00020\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u00105\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b0\u0016H\u0007ø\u0001\u0000\u001aT\u00106\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u00102\u001a\u00020 2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a>\u00108\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102!\u00109\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00060\u0016H\u0007ø\u0001\u0000\u001a@\u0010:\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a@\u0010<\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010=\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a>\u0010>\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102!\u0010?\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00060\u0016H\u0007ø\u0001\u0000\u001a@\u0010@\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010A\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a@\u0010B\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010C\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a/\u0010D\u001a\u00020E*\b\u0012\u0004\u0012\u00020G0F2\u0006\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020&2\u0006\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\u0010L\u001aB\u0010M\u001a\u00020E*\u00020E2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020G0F2\u000e\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0P2\u000e\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0P2\u0006\u0010S\u001a\u00020KH\u0002\u001aB\u0010T\u001a\u00020E*\u00020E2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020G0F2\u000e\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0P2\u000e\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0P2\u0006\u0010S\u001a\u00020KH\u0002\u001a\f\u0010V\u001a\u00020\u001c*\u00020\u0012H\u0002\u001a\f\u0010V\u001a\u00020\u001c*\u00020 H\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006W"}, m287d2 = {"DefaultAlpha", "Landroidx/compose/runtime/MutableState;", "", "DefaultAlphaAndScaleSpring", "Landroidx/compose/animation/core/SpringSpec;", "DefaultOffsetAnimationSpec", "Landroidx/compose/ui/unit/IntOffset;", "DefaultSizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "TransformOriginVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/graphics/TransformOrigin;", "Landroidx/compose/animation/core/AnimationVector2D;", "expandHorizontally", "Landroidx/compose/animation/EnterTransition;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "expandFrom", "Landroidx/compose/ui/Alignment$Horizontal;", "clip", "", "initialWidth", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "fullWidth", "expandIn", "Landroidx/compose/ui/Alignment;", "initialSize", "fullSize", "expandVertically", "Landroidx/compose/ui/Alignment$Vertical;", "initialHeight", "fullHeight", "fadeIn", "initialAlpha", "fadeOut", "Landroidx/compose/animation/ExitTransition;", "targetAlpha", "scaleIn", "initialScale", "transformOrigin", "scaleIn-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/EnterTransition;", "scaleOut", "targetScale", "scaleOut-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/ExitTransition;", "shrinkHorizontally", "shrinkTowards", "targetWidth", "shrinkOut", "targetSize", "shrinkVertically", "targetHeight", "slideIn", "initialOffset", "slideInHorizontally", "initialOffsetX", "slideInVertically", "initialOffsetY", "slideOut", "targetOffset", "slideOutHorizontally", "targetOffsetX", "slideOutVertically", "targetOffsetY", "createModifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "enter", "exit", "label", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "shrinkExpand", "transition", "expand", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/ChangeSize;", "shrink", "labelPrefix", "slideInOut", "Landroidx/compose/animation/Slide;", "toAlignment", "animation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class EnterExitTransitionKt {
    private static final TwoWayConverter<TransformOrigin, AnimationVector2D> TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(new Function1<TransformOrigin, AnimationVector2D>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AnimationVector2D invoke(TransformOrigin transformOrigin) {
            return m380invoke__ExYCQ(transformOrigin.getPackedValue());
        }

        /* renamed from: invoke-__ExYCQ, reason: not valid java name */
        public final AnimationVector2D m380invoke__ExYCQ(long it) {
            return new AnimationVector2D(TransformOrigin.m2333getPivotFractionXimpl(it), TransformOrigin.m2334getPivotFractionYimpl(it));
        }
    }, new Function1<AnimationVector2D, TransformOrigin>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TransformOrigin invoke(AnimationVector2D animationVector2D) {
            return TransformOrigin.m2325boximpl(m381invokeLIALnN8(animationVector2D));
        }

        /* renamed from: invoke-LIALnN8, reason: not valid java name */
        public final long m381invokeLIALnN8(AnimationVector2D it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return TransformOriginKt.TransformOrigin(it.getV1(), it.getV2());
        }
    });
    private static final MutableState<Float> DefaultAlpha = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), null, 2, null);
    private static final SpringSpec<Float> DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
    private static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m4491boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
    private static final SpringSpec<IntSize> DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m4534boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);

    /* compiled from: EnterExitTransition.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            iArr[EnterExitState.Visible.ordinal()] = 1;
            iArr[EnterExitState.PreEnter.ordinal()] = 2;
            iArr[EnterExitState.PostExit.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ EnterTransition fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeIn(finiteAnimationSpec, f);
    }

    public static final EnterTransition fadeIn(FiniteAnimationSpec<Float> animationSpec, float initialAlpha) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData(new Fade(initialAlpha, animationSpec), null, null, null, 14, null));
    }

    public static /* synthetic */ ExitTransition fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeOut(finiteAnimationSpec, f);
    }

    public static final ExitTransition fadeOut(FiniteAnimationSpec<Float> animationSpec, float targetAlpha) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData(new Fade(targetAlpha, animationSpec), null, null, null, 14, null));
    }

    public static /* synthetic */ EnterTransition slideIn$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m4491boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        return slideIn(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideIn(FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super IntSize, IntOffset> initialOffset) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(initialOffset, "initialOffset");
        return new EnterTransitionImpl(new TransitionData(null, new Slide(initialOffset, animationSpec), null, null, 13, null));
    }

    public static /* synthetic */ ExitTransition slideOut$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m4491boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        return slideOut(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOut(FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super IntSize, IntOffset> targetOffset) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(targetOffset, "targetOffset");
        return new ExitTransitionImpl(new TransitionData(null, new Slide(targetOffset, animationSpec), null, null, 13, null));
    }

    /* renamed from: scaleIn-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ EnterTransition m377scaleInL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.INSTANCE.m2338getCenterSzJe1aQ();
        }
        return m376scaleInL8ZKhE(finiteAnimationSpec, f, j);
    }

    @ExperimentalAnimationApi
    /* renamed from: scaleIn-L8ZKh-E, reason: not valid java name */
    public static final EnterTransition m376scaleInL8ZKhE(FiniteAnimationSpec<Float> animationSpec, float initialScale, long transformOrigin) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData(null, null, null, new Scale(initialScale, transformOrigin, animationSpec, null), 7, null));
    }

    /* renamed from: scaleOut-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ ExitTransition m379scaleOutL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.INSTANCE.m2338getCenterSzJe1aQ();
        }
        return m378scaleOutL8ZKhE(finiteAnimationSpec, f, j);
    }

    @ExperimentalAnimationApi
    /* renamed from: scaleOut-L8ZKh-E, reason: not valid java name */
    public static final ExitTransition m378scaleOutL8ZKhE(FiniteAnimationSpec<Float> animationSpec, float targetScale, long transformOrigin) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData(null, null, null, new Scale(targetScale, transformOrigin, animationSpec, null), 7, null));
    }

    public static /* synthetic */ EnterTransition expandIn$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m4534boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.INSTANCE.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandIn$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                    return IntSize.m4534boximpl(m383invokemzRDjE0(intSize.getPackedValue()));
                }

                /* renamed from: invoke-mzRDjE0, reason: not valid java name */
                public final long m383invokemzRDjE0(long it) {
                    return IntSizeKt.IntSize(0, 0);
                }
            };
        }
        return expandIn(finiteAnimationSpec, alignment, z, function1);
    }

    public static final EnterTransition expandIn(FiniteAnimationSpec<IntSize> animationSpec, Alignment expandFrom, boolean clip, Function1<? super IntSize, IntSize> initialSize) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(expandFrom, "expandFrom");
        Intrinsics.checkNotNullParameter(initialSize, "initialSize");
        return new EnterTransitionImpl(new TransitionData(null, null, new ChangeSize(expandFrom, initialSize, animationSpec, clip), null, 11, null));
    }

    public static /* synthetic */ ExitTransition shrinkOut$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m4534boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.INSTANCE.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkOut$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                    return IntSize.m4534boximpl(m388invokemzRDjE0(intSize.getPackedValue()));
                }

                /* renamed from: invoke-mzRDjE0, reason: not valid java name */
                public final long m388invokemzRDjE0(long it) {
                    return IntSizeKt.IntSize(0, 0);
                }
            };
        }
        return shrinkOut(finiteAnimationSpec, alignment, z, function1);
    }

    public static final ExitTransition shrinkOut(FiniteAnimationSpec<IntSize> animationSpec, Alignment shrinkTowards, boolean clip, Function1<? super IntSize, IntSize> targetSize) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(shrinkTowards, "shrinkTowards");
        Intrinsics.checkNotNullParameter(targetSize, "targetSize");
        return new ExitTransitionImpl(new TransitionData(null, null, new ChangeSize(shrinkTowards, targetSize, animationSpec, clip), null, 11, null));
    }

    public static /* synthetic */ EnterTransition expandHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m4534boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.INSTANCE.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandHorizontally$1
                public final Integer invoke(int it) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return expandHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final EnterTransition expandHorizontally(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Horizontal expandFrom, boolean clip, final Function1<? super Integer, Integer> initialWidth) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(expandFrom, "expandFrom");
        Intrinsics.checkNotNullParameter(initialWidth, "initialWidth");
        return expandIn(animationSpec, toAlignment(expandFrom), clip, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandHorizontally$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m4534boximpl(m382invokemzRDjE0(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m382invokemzRDjE0(long it) {
                return IntSizeKt.IntSize(initialWidth.invoke(Integer.valueOf(IntSize.m4542getWidthimpl(it))).intValue(), IntSize.m4541getHeightimpl(it));
            }
        });
    }

    public static /* synthetic */ EnterTransition expandVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m4534boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.INSTANCE.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandVertically$1
                public final Integer invoke(int it) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return expandVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final EnterTransition expandVertically(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Vertical expandFrom, boolean clip, final Function1<? super Integer, Integer> initialHeight) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(expandFrom, "expandFrom");
        Intrinsics.checkNotNullParameter(initialHeight, "initialHeight");
        return expandIn(animationSpec, toAlignment(expandFrom), clip, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandVertically$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m4534boximpl(m384invokemzRDjE0(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m384invokemzRDjE0(long it) {
                return IntSizeKt.IntSize(IntSize.m4542getWidthimpl(it), initialHeight.invoke(Integer.valueOf(IntSize.m4541getHeightimpl(it))).intValue());
            }
        });
    }

    public static /* synthetic */ ExitTransition shrinkHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m4534boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.INSTANCE.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkHorizontally$1
                public final Integer invoke(int it) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return shrinkHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final ExitTransition shrinkHorizontally(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Horizontal shrinkTowards, boolean clip, final Function1<? super Integer, Integer> targetWidth) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(shrinkTowards, "shrinkTowards");
        Intrinsics.checkNotNullParameter(targetWidth, "targetWidth");
        return shrinkOut(animationSpec, toAlignment(shrinkTowards), clip, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkHorizontally$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m4534boximpl(m387invokemzRDjE0(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m387invokemzRDjE0(long it) {
                return IntSizeKt.IntSize(targetWidth.invoke(Integer.valueOf(IntSize.m4542getWidthimpl(it))).intValue(), IntSize.m4541getHeightimpl(it));
            }
        });
    }

    public static /* synthetic */ ExitTransition shrinkVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m4534boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.INSTANCE.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$1
                public final Integer invoke(int it) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return shrinkVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final ExitTransition shrinkVertically(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Vertical shrinkTowards, boolean clip, final Function1<? super Integer, Integer> targetHeight) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(shrinkTowards, "shrinkTowards");
        Intrinsics.checkNotNullParameter(targetHeight, "targetHeight");
        return shrinkOut(animationSpec, toAlignment(shrinkTowards), clip, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m4534boximpl(m389invokemzRDjE0(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m389invokemzRDjE0(long it) {
                return IntSizeKt.IntSize(IntSize.m4542getWidthimpl(it), targetHeight.invoke(Integer.valueOf(IntSize.m4541getHeightimpl(it))).intValue());
            }
        });
    }

    public static /* synthetic */ EnterTransition slideInHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m4491boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInHorizontally$1
                public final Integer invoke(int it) {
                    return Integer.valueOf((-it) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideInHorizontally(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInHorizontally(FiniteAnimationSpec<IntOffset> animationSpec, final Function1<? super Integer, Integer> initialOffsetX) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(initialOffsetX, "initialOffsetX");
        return slideIn(animationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInHorizontally$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m4491boximpl(m390invokemHKZG7I(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m390invokemHKZG7I(long it) {
                return IntOffsetKt.IntOffset(initialOffsetX.invoke(Integer.valueOf(IntSize.m4542getWidthimpl(it))).intValue(), 0);
            }
        });
    }

    public static /* synthetic */ EnterTransition slideInVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m4491boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInVertically$1
                public final Integer invoke(int it) {
                    return Integer.valueOf((-it) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideInVertically(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInVertically(FiniteAnimationSpec<IntOffset> animationSpec, final Function1<? super Integer, Integer> initialOffsetY) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(initialOffsetY, "initialOffsetY");
        return slideIn(animationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInVertically$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m4491boximpl(m393invokemHKZG7I(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m393invokemHKZG7I(long it) {
                return IntOffsetKt.IntOffset(0, initialOffsetY.invoke(Integer.valueOf(IntSize.m4541getHeightimpl(it))).intValue());
            }
        });
    }

    public static /* synthetic */ ExitTransition slideOutHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m4491boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutHorizontally$1
                public final Integer invoke(int it) {
                    return Integer.valueOf((-it) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideOutHorizontally(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutHorizontally(FiniteAnimationSpec<IntOffset> animationSpec, final Function1<? super Integer, Integer> targetOffsetX) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(targetOffsetX, "targetOffsetX");
        return slideOut(animationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutHorizontally$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m4491boximpl(m394invokemHKZG7I(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m394invokemHKZG7I(long it) {
                return IntOffsetKt.IntOffset(targetOffsetX.invoke(Integer.valueOf(IntSize.m4542getWidthimpl(it))).intValue(), 0);
            }
        });
    }

    public static /* synthetic */ ExitTransition slideOutVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m4491boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutVertically$1
                public final Integer invoke(int it) {
                    return Integer.valueOf((-it) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideOutVertically(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutVertically(FiniteAnimationSpec<IntOffset> animationSpec, final Function1<? super Integer, Integer> targetOffsetY) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(targetOffsetY, "targetOffsetY");
        return slideOut(animationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutVertically$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m4491boximpl(m395invokemHKZG7I(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m395invokemHKZG7I(long it) {
                return IntOffsetKt.IntOffset(0, targetOffsetY.invoke(Integer.valueOf(IntSize.m4541getHeightimpl(it))).intValue());
            }
        });
    }

    private static final Alignment toAlignment(Alignment.Horizontal $this$toAlignment) {
        return Intrinsics.areEqual($this$toAlignment, Alignment.INSTANCE.getStart()) ? Alignment.INSTANCE.getCenterStart() : Intrinsics.areEqual($this$toAlignment, Alignment.INSTANCE.getEnd()) ? Alignment.INSTANCE.getCenterEnd() : Alignment.INSTANCE.getCenter();
    }

    private static final Alignment toAlignment(Alignment.Vertical $this$toAlignment) {
        return Intrinsics.areEqual($this$toAlignment, Alignment.INSTANCE.getTop()) ? Alignment.INSTANCE.getTopCenter() : Intrinsics.areEqual($this$toAlignment, Alignment.INSTANCE.getBottom()) ? Alignment.INSTANCE.getBottomCenter() : Alignment.INSTANCE.getCenter();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:102:0x05f4  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0628  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x063f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0645  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x068b  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x069c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x06fa  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0666  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0687  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0632  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x05f9  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x05cf  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x05f0  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x05a8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x05ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Modifier createModifier(Transition<EnterExitState> transition, final EnterTransition enter, final ExitTransition exit, String label, Composer $composer, int $changed) {
        Object value$iv$iv;
        TransformOrigin transformOrigin;
        Object value$iv$iv2;
        String str;
        String str2;
        String str3;
        TransformOrigin transformOrigin2;
        Modifier modifier;
        MutableState shouldAnimateAlpha$delegate;
        MutableState<Float> mutableState;
        Modifier modifier2;
        Object value$iv$iv3;
        Object value$iv$iv4;
        State alpha$delegate;
        float f;
        String str4;
        TransformOrigin m2325boximpl;
        EnterExitState it;
        TransformOrigin transformOrigin3;
        EnterExitState it2;
        TransformOrigin transformOrigin4;
        boolean invalid$iv$iv;
        Object value$iv$iv5;
        float f2;
        String str5;
        float f3;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(enter, "enter");
        Intrinsics.checkNotNullParameter(exit, "exit");
        Intrinsics.checkNotNullParameter(label, "label");
        $composer.startReplaceableGroup(914000546);
        ComposerKt.sourceInformation($composer, "C(createModifier)809@35485L38,810@35533L37,814@35628L43,815@35681L42,822@36052L40,823@36123L40:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(914000546, $changed, -1, "androidx.compose.animation.createModifier (EnterExitTransition.kt:797)");
        }
        Modifier modifier3 = shrinkExpand(slideInOut(Modifier.INSTANCE, transition, SnapshotStateKt.rememberUpdatedState(enter.getData().getSlide(), $composer, 0), SnapshotStateKt.rememberUpdatedState(exit.getData().getSlide(), $composer, 0), label), transition, SnapshotStateKt.rememberUpdatedState(enter.getData().getChangeSize(), $composer, 0), SnapshotStateKt.rememberUpdatedState(exit.getData().getChangeSize(), $composer, 0), label);
        int i = $changed & 14;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = $composer.changed(transition);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv2 || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        MutableState shouldAnimateAlpha$delegate2 = (MutableState) value$iv$iv;
        int i2 = $changed & 14;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv3 = $composer.changed(transition);
        Object it$iv$iv2 = $composer.rememberedValue();
        if (invalid$iv$iv3 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            transformOrigin = null;
            value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            $composer.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
            transformOrigin = null;
        }
        $composer.endReplaceableGroup();
        MutableState shouldAnimateScale$delegate = (MutableState) value$iv$iv2;
        if (transition.getCurrentState() != transition.getTargetState() || transition.isSeeking()) {
            if (enter.getData().getFade() != null || exit.getData().getFade() != null) {
                m372createModifier$lambda2(shouldAnimateAlpha$delegate2, true);
            }
            if (enter.getData().getScale() != null || exit.getData().getScale() != null) {
                m374createModifier$lambda5(shouldAnimateScale$delegate, true);
            }
        } else {
            m372createModifier$lambda2(shouldAnimateAlpha$delegate2, false);
            m374createModifier$lambda5(shouldAnimateScale$delegate, false);
        }
        $composer.startReplaceableGroup(1657240746);
        ComposerKt.sourceInformation($composer, "847@37107L27,837@36586L796");
        float f4 = 1.0f;
        if (m369createModifier$lambda1(shouldAnimateAlpha$delegate2)) {
            Function3 transitionSpec$iv = new Function3<Transition.Segment<EnterExitState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$alpha$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> animateFloat, Composer $composer2, int $changed2) {
                    SpringSpec springSpec;
                    SpringSpec springSpec2;
                    SpringSpec springSpec3;
                    SpringSpec springSpec4;
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    $composer2.startReplaceableGroup(-57153604);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-57153604, $changed2, -1, "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:838)");
                    }
                    if (animateFloat.isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
                        Fade fade = EnterTransition.this.getData().getFade();
                        if (fade == null || (springSpec2 = fade.getAnimationSpec()) == null) {
                            springSpec4 = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                            springSpec2 = springSpec4;
                        }
                    } else if (!animateFloat.isTransitioningTo(EnterExitState.Visible, EnterExitState.PostExit)) {
                        springSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                        springSpec2 = springSpec;
                    } else {
                        Fade fade2 = exit.getData().getFade();
                        if (fade2 == null || (springSpec2 = fade2.getAnimationSpec()) == null) {
                            springSpec3 = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                            springSpec2 = springSpec3;
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceableGroup();
                    return springSpec2;
                }
            };
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
            Object value$iv$iv6 = $composer.rememberedValue();
            if (value$iv$iv6 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv6 = label + " alpha";
                $composer.updateRememberedValue(value$iv$iv6);
            }
            $composer.endReplaceableGroup();
            String label$iv = (String) value$iv$iv6;
            int $changed$iv = ($changed & 14) | 384;
            $composer.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation($composer, "C(animateFloat)P(2)938@37489L78:Transition.kt#pdpnli");
            TwoWayConverter typeConverter$iv$iv = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv = (($changed$iv << 3) & 57344) | ($changed$iv & 14) | (($changed$iv << 3) & 896) | (($changed$iv << 3) & 7168);
            $composer.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation($composer, "C(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli");
            EnterExitState currentState = transition.getCurrentState();
            int $changed2 = ($changed$iv$iv >> 9) & SdkConfig.SDK_VERSION;
            EnterExitState it3 = currentState;
            $composer.startReplaceableGroup(755689166);
            ComposerKt.sourceInformation($composer, "C:EnterExitTransition.kt#xbi5r1");
            if (ComposerKt.isTraceInProgress()) {
                shouldAnimateAlpha$delegate = shouldAnimateAlpha$delegate2;
                ComposerKt.traceEventStart(755689166, $changed2, -1, "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:848)");
            } else {
                shouldAnimateAlpha$delegate = shouldAnimateAlpha$delegate2;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it3.ordinal()]) {
                case 1:
                    f2 = 1.0f;
                    break;
                case 2:
                    Fade fade = enter.getData().getFade();
                    if (fade == null) {
                        f2 = 1.0f;
                        break;
                    } else {
                        f2 = fade.getAlpha();
                        break;
                    }
                case 3:
                    Fade fade2 = exit.getData().getFade();
                    if (fade2 == null) {
                        f2 = 1.0f;
                        break;
                    } else {
                        f2 = fade2.getAlpha();
                        break;
                    }
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceableGroup();
            Object initialValue$iv$iv = Float.valueOf(f2);
            EnterExitState targetState = transition.getTargetState();
            int $changed3 = ($changed$iv$iv >> 9) & SdkConfig.SDK_VERSION;
            EnterExitState it4 = targetState;
            $composer.startReplaceableGroup(755689166);
            ComposerKt.sourceInformation($composer, "C:EnterExitTransition.kt#xbi5r1");
            if (ComposerKt.isTraceInProgress()) {
                str5 = "C:EnterExitTransition.kt#xbi5r1";
                ComposerKt.traceEventStart(755689166, $changed3, -1, "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:848)");
            } else {
                str5 = "C:EnterExitTransition.kt#xbi5r1";
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it4.ordinal()]) {
                case 1:
                    f3 = 1.0f;
                    break;
                case 2:
                    Fade fade3 = enter.getData().getFade();
                    if (fade3 == null) {
                        f3 = 1.0f;
                        break;
                    } else {
                        f3 = fade3.getAlpha();
                        break;
                    }
                case 3:
                    Fade fade4 = exit.getData().getFade();
                    if (fade4 == null) {
                        f3 = 1.0f;
                        break;
                    } else {
                        f3 = fade4.getAlpha();
                        break;
                    }
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceableGroup();
            Object targetValue$iv$iv = Float.valueOf(f3);
            FiniteAnimationSpec<Float> animationSpec$iv$iv = transitionSpec$iv.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv$iv >> 3) & SdkConfig.SDK_VERSION));
            str2 = "C(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli";
            str = str5;
            str3 = "C(remember)P(1):Composables.kt#9igjgp";
            transformOrigin2 = null;
            modifier = modifier3;
            mutableState = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv, targetValue$iv$iv, animationSpec$iv$iv, typeConverter$iv$iv, label$iv, $composer, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            $composer.endReplaceableGroup();
            $composer.endReplaceableGroup();
        } else {
            str = "C:EnterExitTransition.kt#xbi5r1";
            str2 = "C(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli";
            str3 = "C(remember)P(1):Composables.kt#9igjgp";
            transformOrigin2 = transformOrigin;
            modifier = modifier3;
            shouldAnimateAlpha$delegate = shouldAnimateAlpha$delegate2;
            mutableState = DefaultAlpha;
        }
        $composer.endReplaceableGroup();
        final State alpha$delegate2 = mutableState;
        if (m373createModifier$lambda4(shouldAnimateScale$delegate)) {
            $composer.startReplaceableGroup(1657241646);
            ComposerKt.sourceInformation($composer, "870@37998L27,860@37475L800,886@38768L536,899@39348L157");
            Function3 transitionSpec$iv2 = new Function3<Transition.Segment<EnterExitState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$scale$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> animateFloat, Composer $composer2, int $changed4) {
                    SpringSpec springSpec;
                    SpringSpec springSpec2;
                    SpringSpec springSpec3;
                    SpringSpec springSpec4;
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    $composer2.startReplaceableGroup(-53984035);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-53984035, $changed4, -1, "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:861)");
                    }
                    if (animateFloat.isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
                        Scale scale = EnterTransition.this.getData().getScale();
                        if (scale == null || (springSpec2 = scale.getAnimationSpec()) == null) {
                            springSpec4 = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                            springSpec2 = springSpec4;
                        }
                    } else if (!animateFloat.isTransitioningTo(EnterExitState.Visible, EnterExitState.PostExit)) {
                        springSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                        springSpec2 = springSpec;
                    } else {
                        Scale scale2 = exit.getData().getScale();
                        if (scale2 == null || (springSpec2 = scale2.getAnimationSpec()) == null) {
                            springSpec3 = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                            springSpec2 = springSpec3;
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceableGroup();
                    return springSpec2;
                }
            };
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv3 = $composer.rememberedValue();
            if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv4 = label + " scale";
                $composer.updateRememberedValue(value$iv$iv4);
            } else {
                value$iv$iv4 = it$iv$iv3;
            }
            $composer.endReplaceableGroup();
            String label$iv2 = (String) value$iv$iv4;
            int $changed$iv2 = ($changed & 14) | 384;
            $composer.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation($composer, "C(animateFloat)P(2)938@37489L78:Transition.kt#pdpnli");
            TwoWayConverter typeConverter$iv$iv2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv2 = (($changed$iv2 << 3) & 57344) | ($changed$iv2 & 14) | (($changed$iv2 << 3) & 896) | (($changed$iv2 << 3) & 7168);
            $composer.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation($composer, str2);
            EnterExitState currentState2 = transition.getCurrentState();
            int $changed4 = ($changed$iv$iv2 >> 9) & SdkConfig.SDK_VERSION;
            EnterExitState it5 = currentState2;
            $composer.startReplaceableGroup(-596129937);
            String str6 = str;
            ComposerKt.sourceInformation($composer, str6);
            if (ComposerKt.isTraceInProgress()) {
                alpha$delegate = alpha$delegate2;
                ComposerKt.traceEventStart(-596129937, $changed4, -1, "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:871)");
            } else {
                alpha$delegate = alpha$delegate2;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it5.ordinal()]) {
                case 1:
                    f = 1.0f;
                    break;
                case 2:
                    Scale scale = enter.getData().getScale();
                    if (scale == null) {
                        f = 1.0f;
                        break;
                    } else {
                        f = scale.getScale();
                        break;
                    }
                case 3:
                    Scale scale2 = exit.getData().getScale();
                    if (scale2 == null) {
                        f = 1.0f;
                        break;
                    } else {
                        f = scale2.getScale();
                        break;
                    }
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceableGroup();
            Object initialValue$iv$iv2 = Float.valueOf(f);
            EnterExitState targetState2 = transition.getTargetState();
            int $changed5 = ($changed$iv$iv2 >> 9) & SdkConfig.SDK_VERSION;
            EnterExitState it6 = targetState2;
            $composer.startReplaceableGroup(-596129937);
            ComposerKt.sourceInformation($composer, str6);
            if (ComposerKt.isTraceInProgress()) {
                str4 = str6;
                ComposerKt.traceEventStart(-596129937, $changed5, -1, "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:871)");
            } else {
                str4 = str6;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it6.ordinal()]) {
                case 1:
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer.endReplaceableGroup();
                    Object targetValue$iv$iv2 = Float.valueOf(f4);
                    FiniteAnimationSpec<Float> animationSpec$iv$iv2 = transitionSpec$iv2.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                    String str7 = str4;
                    final State alpha$delegate3 = alpha$delegate;
                    final State scale$delegate = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv2, targetValue$iv$iv2, animationSpec$iv$iv2, typeConverter$iv$iv2, label$iv2, $composer, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    if (transition.getCurrentState() == EnterExitState.PreEnter) {
                        Scale scale3 = enter.getData().getScale();
                        m2325boximpl = (scale3 == null && (scale3 = exit.getData().getScale()) == null) ? transformOrigin2 : TransformOrigin.m2325boximpl(scale3.m403getTransformOriginSzJe1aQ());
                    } else {
                        Scale scale4 = exit.getData().getScale();
                        m2325boximpl = (scale4 == null && (scale4 = enter.getData().getScale()) == null) ? transformOrigin2 : TransformOrigin.m2325boximpl(scale4.m403getTransformOriginSzJe1aQ());
                    }
                    TransformOrigin transformOriginWhenVisible = m2325boximpl;
                    TwoWayConverter typeConverter$iv = TransformOriginVectorConverter;
                    int $changed$iv3 = ($changed & 14) | 3136;
                    $composer.startReplaceableGroup(-142660079);
                    ComposerKt.sourceInformation($composer, str2);
                    Function3 transitionSpec$iv3 = new Function3<Transition.Segment<EnterExitState>, Composer, Integer, SpringSpec<TransformOrigin>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$$inlined$animateValue$1
                        public final SpringSpec<TransformOrigin> invoke(Transition.Segment<EnterExitState> segment, Composer $composer2, int $changed6) {
                            Intrinsics.checkNotNullParameter(segment, "$this$null");
                            $composer2.startReplaceableGroup(-895531546);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-895531546, $changed6, -1, "androidx.compose.animation.core.animateValue.<anonymous> (Transition.kt:851)");
                            }
                            SpringSpec<TransformOrigin> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            $composer2.endReplaceableGroup();
                            return spring$default;
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ SpringSpec<TransformOrigin> invoke(Transition.Segment<EnterExitState> segment, Composer composer, Integer num) {
                            return invoke(segment, composer, num.intValue());
                        }
                    };
                    EnterExitState currentState3 = transition.getCurrentState();
                    int $changed6 = ($changed$iv3 >> 9) & SdkConfig.SDK_VERSION;
                    it = currentState3;
                    $composer.startReplaceableGroup(-288165413);
                    ComposerKt.sourceInformation($composer, str7);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-288165413, $changed6, -1, "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:889)");
                    }
                    switch (WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
                        case 1:
                            transformOrigin3 = transformOriginWhenVisible;
                            break;
                        case 2:
                            Scale scale5 = enter.getData().getScale();
                            if (scale5 != null || (scale5 = exit.getData().getScale()) != null) {
                                transformOrigin3 = TransformOrigin.m2325boximpl(scale5.m403getTransformOriginSzJe1aQ());
                                break;
                            } else {
                                transformOrigin3 = transformOrigin2;
                                break;
                            }
                            break;
                        case 3:
                            Scale scale6 = exit.getData().getScale();
                            if (scale6 != null || (scale6 = enter.getData().getScale()) != null) {
                                transformOrigin3 = TransformOrigin.m2325boximpl(scale6.m403getTransformOriginSzJe1aQ());
                                break;
                            } else {
                                transformOrigin3 = transformOrigin2;
                                break;
                            }
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    long packedValue = transformOrigin3 != null ? transformOrigin3.getPackedValue() : TransformOrigin.INSTANCE.m2338getCenterSzJe1aQ();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer.endReplaceableGroup();
                    Object initialValue$iv = TransformOrigin.m2325boximpl(packedValue);
                    EnterExitState targetState3 = transition.getTargetState();
                    int $changed7 = ($changed$iv3 >> 9) & SdkConfig.SDK_VERSION;
                    it2 = targetState3;
                    $composer.startReplaceableGroup(-288165413);
                    ComposerKt.sourceInformation($composer, str7);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-288165413, $changed7, -1, "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:889)");
                    }
                    switch (WhenMappings.$EnumSwitchMapping$0[it2.ordinal()]) {
                        case 1:
                            transformOrigin4 = transformOriginWhenVisible;
                            break;
                        case 2:
                            Scale scale7 = enter.getData().getScale();
                            if (scale7 != null || (scale7 = exit.getData().getScale()) != null) {
                                transformOrigin4 = TransformOrigin.m2325boximpl(scale7.m403getTransformOriginSzJe1aQ());
                                break;
                            } else {
                                transformOrigin4 = transformOrigin2;
                                break;
                            }
                        case 3:
                            Scale scale8 = exit.getData().getScale();
                            if (scale8 != null || (scale8 = enter.getData().getScale()) != null) {
                                transformOrigin4 = TransformOrigin.m2325boximpl(scale8.m403getTransformOriginSzJe1aQ());
                                break;
                            } else {
                                transformOrigin4 = transformOrigin2;
                                break;
                            }
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    long packedValue2 = transformOrigin4 != null ? transformOrigin4.getPackedValue() : TransformOrigin.INSTANCE.m2338getCenterSzJe1aQ();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer.endReplaceableGroup();
                    Object targetValue$iv = TransformOrigin.m2325boximpl(packedValue2);
                    SpringSpec<TransformOrigin> animationSpec$iv = transitionSpec$iv3.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv3 >> 3) & SdkConfig.SDK_VERSION));
                    final State transformOrigin$delegate = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, initialValue$iv, targetValue$iv, animationSpec$iv, typeConverter$iv, "TransformOriginInterruptionHandling", $composer, ($changed$iv3 & 14) | (($changed$iv3 << 9) & 57344) | (($changed$iv3 << 6) & 458752));
                    $composer.endReplaceableGroup();
                    $composer.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation($composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    invalid$iv$iv = $composer.changed(alpha$delegate3) | $composer.changed(scale$delegate) | $composer.changed(transformOrigin$delegate);
                    Object it$iv$iv4 = $composer.rememberedValue();
                    if (!invalid$iv$iv || it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv5 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$1$1
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
                            public final void invoke2(GraphicsLayerScope graphicsLayer) {
                                float m375createModifier$lambda8;
                                float m370createModifier$lambda11;
                                float m370createModifier$lambda112;
                                long m371createModifier$lambda13;
                                Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                                m375createModifier$lambda8 = EnterExitTransitionKt.m375createModifier$lambda8(alpha$delegate3);
                                graphicsLayer.setAlpha(m375createModifier$lambda8);
                                m370createModifier$lambda11 = EnterExitTransitionKt.m370createModifier$lambda11(scale$delegate);
                                graphicsLayer.setScaleX(m370createModifier$lambda11);
                                m370createModifier$lambda112 = EnterExitTransitionKt.m370createModifier$lambda11(scale$delegate);
                                graphicsLayer.setScaleY(m370createModifier$lambda112);
                                m371createModifier$lambda13 = EnterExitTransitionKt.m371createModifier$lambda13(transformOrigin$delegate);
                                graphicsLayer.mo2157setTransformOrigin__ExYCQ(m371createModifier$lambda13);
                            }
                        };
                        $composer.updateRememberedValue(value$iv$iv5);
                    } else {
                        value$iv$iv5 = it$iv$iv4;
                    }
                    $composer.endReplaceableGroup();
                    modifier2 = GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) value$iv$iv5);
                    $composer.endReplaceableGroup();
                    break;
                case 2:
                    Scale scale9 = enter.getData().getScale();
                    if (scale9 != null) {
                        f4 = scale9.getScale();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer.endReplaceableGroup();
                    Object targetValue$iv$iv22 = Float.valueOf(f4);
                    FiniteAnimationSpec<Float> animationSpec$iv$iv22 = transitionSpec$iv2.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                    String str72 = str4;
                    final State<Float> alpha$delegate32 = alpha$delegate;
                    final State<Float> scale$delegate2 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv2, targetValue$iv$iv22, animationSpec$iv$iv22, typeConverter$iv$iv2, label$iv2, $composer, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    if (transition.getCurrentState() == EnterExitState.PreEnter) {
                    }
                    TransformOrigin transformOriginWhenVisible2 = m2325boximpl;
                    TwoWayConverter typeConverter$iv2 = TransformOriginVectorConverter;
                    int $changed$iv32 = ($changed & 14) | 3136;
                    $composer.startReplaceableGroup(-142660079);
                    ComposerKt.sourceInformation($composer, str2);
                    Function3 transitionSpec$iv32 = new Function3<Transition.Segment<EnterExitState>, Composer, Integer, SpringSpec<TransformOrigin>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$$inlined$animateValue$1
                        public final SpringSpec<TransformOrigin> invoke(Transition.Segment<EnterExitState> segment, Composer $composer2, int $changed62) {
                            Intrinsics.checkNotNullParameter(segment, "$this$null");
                            $composer2.startReplaceableGroup(-895531546);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-895531546, $changed62, -1, "androidx.compose.animation.core.animateValue.<anonymous> (Transition.kt:851)");
                            }
                            SpringSpec<TransformOrigin> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            $composer2.endReplaceableGroup();
                            return spring$default;
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ SpringSpec<TransformOrigin> invoke(Transition.Segment<EnterExitState> segment, Composer composer, Integer num) {
                            return invoke(segment, composer, num.intValue());
                        }
                    };
                    EnterExitState currentState32 = transition.getCurrentState();
                    int $changed62 = ($changed$iv32 >> 9) & SdkConfig.SDK_VERSION;
                    it = currentState32;
                    $composer.startReplaceableGroup(-288165413);
                    ComposerKt.sourceInformation($composer, str72);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    switch (WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
                    }
                    if (transformOrigin3 != null) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer.endReplaceableGroup();
                    Object initialValue$iv2 = TransformOrigin.m2325boximpl(packedValue);
                    EnterExitState targetState32 = transition.getTargetState();
                    int $changed72 = ($changed$iv32 >> 9) & SdkConfig.SDK_VERSION;
                    it2 = targetState32;
                    $composer.startReplaceableGroup(-288165413);
                    ComposerKt.sourceInformation($composer, str72);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    switch (WhenMappings.$EnumSwitchMapping$0[it2.ordinal()]) {
                    }
                    if (transformOrigin4 != null) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer.endReplaceableGroup();
                    Object targetValue$iv2 = TransformOrigin.m2325boximpl(packedValue2);
                    SpringSpec<TransformOrigin> animationSpec$iv2 = transitionSpec$iv32.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv32 >> 3) & SdkConfig.SDK_VERSION));
                    final State<TransformOrigin> transformOrigin$delegate2 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, initialValue$iv2, targetValue$iv2, animationSpec$iv2, typeConverter$iv2, "TransformOriginInterruptionHandling", $composer, ($changed$iv32 & 14) | (($changed$iv32 << 9) & 57344) | (($changed$iv32 << 6) & 458752));
                    $composer.endReplaceableGroup();
                    $composer.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation($composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    invalid$iv$iv = $composer.changed(alpha$delegate32) | $composer.changed(scale$delegate2) | $composer.changed(transformOrigin$delegate2);
                    Object it$iv$iv42 = $composer.rememberedValue();
                    if (invalid$iv$iv) {
                        break;
                    }
                    value$iv$iv5 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$1$1
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
                        public final void invoke2(GraphicsLayerScope graphicsLayer) {
                            float m375createModifier$lambda8;
                            float m370createModifier$lambda11;
                            float m370createModifier$lambda112;
                            long m371createModifier$lambda13;
                            Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                            m375createModifier$lambda8 = EnterExitTransitionKt.m375createModifier$lambda8(alpha$delegate32);
                            graphicsLayer.setAlpha(m375createModifier$lambda8);
                            m370createModifier$lambda11 = EnterExitTransitionKt.m370createModifier$lambda11(scale$delegate2);
                            graphicsLayer.setScaleX(m370createModifier$lambda11);
                            m370createModifier$lambda112 = EnterExitTransitionKt.m370createModifier$lambda11(scale$delegate2);
                            graphicsLayer.setScaleY(m370createModifier$lambda112);
                            m371createModifier$lambda13 = EnterExitTransitionKt.m371createModifier$lambda13(transformOrigin$delegate2);
                            graphicsLayer.mo2157setTransformOrigin__ExYCQ(m371createModifier$lambda13);
                        }
                    };
                    $composer.updateRememberedValue(value$iv$iv5);
                    $composer.endReplaceableGroup();
                    modifier2 = GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) value$iv$iv5);
                    $composer.endReplaceableGroup();
                    break;
                case 3:
                    Scale scale10 = exit.getData().getScale();
                    if (scale10 != null) {
                        f4 = scale10.getScale();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer.endReplaceableGroup();
                    Object targetValue$iv$iv222 = Float.valueOf(f4);
                    FiniteAnimationSpec<Float> animationSpec$iv$iv222 = transitionSpec$iv2.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                    String str722 = str4;
                    final State<Float> alpha$delegate322 = alpha$delegate;
                    final State<Float> scale$delegate22 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv2, targetValue$iv$iv222, animationSpec$iv$iv222, typeConverter$iv$iv2, label$iv2, $composer, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
                    $composer.endReplaceableGroup();
                    $composer.endReplaceableGroup();
                    if (transition.getCurrentState() == EnterExitState.PreEnter) {
                    }
                    TransformOrigin transformOriginWhenVisible22 = m2325boximpl;
                    TwoWayConverter typeConverter$iv22 = TransformOriginVectorConverter;
                    int $changed$iv322 = ($changed & 14) | 3136;
                    $composer.startReplaceableGroup(-142660079);
                    ComposerKt.sourceInformation($composer, str2);
                    Function3 transitionSpec$iv322 = new Function3<Transition.Segment<EnterExitState>, Composer, Integer, SpringSpec<TransformOrigin>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$$inlined$animateValue$1
                        public final SpringSpec<TransformOrigin> invoke(Transition.Segment<EnterExitState> segment, Composer $composer2, int $changed622) {
                            Intrinsics.checkNotNullParameter(segment, "$this$null");
                            $composer2.startReplaceableGroup(-895531546);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-895531546, $changed622, -1, "androidx.compose.animation.core.animateValue.<anonymous> (Transition.kt:851)");
                            }
                            SpringSpec<TransformOrigin> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            $composer2.endReplaceableGroup();
                            return spring$default;
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ SpringSpec<TransformOrigin> invoke(Transition.Segment<EnterExitState> segment, Composer composer, Integer num) {
                            return invoke(segment, composer, num.intValue());
                        }
                    };
                    EnterExitState currentState322 = transition.getCurrentState();
                    int $changed622 = ($changed$iv322 >> 9) & SdkConfig.SDK_VERSION;
                    it = currentState322;
                    $composer.startReplaceableGroup(-288165413);
                    ComposerKt.sourceInformation($composer, str722);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    switch (WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
                    }
                    if (transformOrigin3 != null) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer.endReplaceableGroup();
                    Object initialValue$iv22 = TransformOrigin.m2325boximpl(packedValue);
                    EnterExitState targetState322 = transition.getTargetState();
                    int $changed722 = ($changed$iv322 >> 9) & SdkConfig.SDK_VERSION;
                    it2 = targetState322;
                    $composer.startReplaceableGroup(-288165413);
                    ComposerKt.sourceInformation($composer, str722);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    switch (WhenMappings.$EnumSwitchMapping$0[it2.ordinal()]) {
                    }
                    if (transformOrigin4 != null) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer.endReplaceableGroup();
                    Object targetValue$iv22 = TransformOrigin.m2325boximpl(packedValue2);
                    SpringSpec<TransformOrigin> animationSpec$iv22 = transitionSpec$iv322.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv322 >> 3) & SdkConfig.SDK_VERSION));
                    final State<TransformOrigin> transformOrigin$delegate22 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, initialValue$iv22, targetValue$iv22, animationSpec$iv22, typeConverter$iv22, "TransformOriginInterruptionHandling", $composer, ($changed$iv322 & 14) | (($changed$iv322 << 9) & 57344) | (($changed$iv322 << 6) & 458752));
                    $composer.endReplaceableGroup();
                    $composer.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation($composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    invalid$iv$iv = $composer.changed(alpha$delegate322) | $composer.changed(scale$delegate22) | $composer.changed(transformOrigin$delegate22);
                    Object it$iv$iv422 = $composer.rememberedValue();
                    if (invalid$iv$iv) {
                    }
                    value$iv$iv5 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$1$1
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
                        public final void invoke2(GraphicsLayerScope graphicsLayer) {
                            float m375createModifier$lambda8;
                            float m370createModifier$lambda11;
                            float m370createModifier$lambda112;
                            long m371createModifier$lambda13;
                            Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                            m375createModifier$lambda8 = EnterExitTransitionKt.m375createModifier$lambda8(alpha$delegate322);
                            graphicsLayer.setAlpha(m375createModifier$lambda8);
                            m370createModifier$lambda11 = EnterExitTransitionKt.m370createModifier$lambda11(scale$delegate22);
                            graphicsLayer.setScaleX(m370createModifier$lambda11);
                            m370createModifier$lambda112 = EnterExitTransitionKt.m370createModifier$lambda11(scale$delegate22);
                            graphicsLayer.setScaleY(m370createModifier$lambda112);
                            m371createModifier$lambda13 = EnterExitTransitionKt.m371createModifier$lambda13(transformOrigin$delegate22);
                            graphicsLayer.mo2157setTransformOrigin__ExYCQ(m371createModifier$lambda13);
                        }
                    };
                    $composer.updateRememberedValue(value$iv$iv5);
                    $composer.endReplaceableGroup();
                    modifier2 = GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) value$iv$iv5);
                    $composer.endReplaceableGroup();
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else {
            Modifier modifier4 = modifier;
            if (m369createModifier$lambda1(shouldAnimateAlpha$delegate)) {
                $composer.startReplaceableGroup(1657243735);
                ComposerKt.sourceInformation($composer, "906@39585L42");
                $composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer, str3);
                boolean invalid$iv$iv4 = $composer.changed(alpha$delegate2);
                Object it$iv$iv5 = $composer.rememberedValue();
                if (invalid$iv$iv4 || it$iv$iv5 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv3 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$2$1
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
                        public final void invoke2(GraphicsLayerScope graphicsLayer) {
                            float m375createModifier$lambda8;
                            Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                            m375createModifier$lambda8 = EnterExitTransitionKt.m375createModifier$lambda8(alpha$delegate2);
                            graphicsLayer.setAlpha(m375createModifier$lambda8);
                        }
                    };
                    $composer.updateRememberedValue(value$iv$iv3);
                } else {
                    value$iv$iv3 = it$iv$iv5;
                }
                $composer.endReplaceableGroup();
                modifier2 = GraphicsLayerModifierKt.graphicsLayer(modifier4, (Function1) value$iv$iv3);
                $composer.endReplaceableGroup();
            } else {
                $composer.startReplaceableGroup(1657243827);
                $composer.endReplaceableGroup();
                modifier2 = modifier4;
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return modifier2;
    }

    /* renamed from: createModifier$lambda-1, reason: not valid java name */
    private static final boolean m369createModifier$lambda1(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* renamed from: createModifier$lambda-2, reason: not valid java name */
    private static final void m372createModifier$lambda2(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* renamed from: createModifier$lambda-4, reason: not valid java name */
    private static final boolean m373createModifier$lambda4(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* renamed from: createModifier$lambda-5, reason: not valid java name */
    private static final void m374createModifier$lambda5(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createModifier$lambda-8, reason: not valid java name */
    public static final float m375createModifier$lambda8(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createModifier$lambda-11, reason: not valid java name */
    public static final float m370createModifier$lambda11(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createModifier$lambda-13, reason: not valid java name */
    public static final long m371createModifier$lambda13(State<TransformOrigin> state) {
        Object thisObj$iv = state.getValue();
        return ((TransformOrigin) thisObj$iv).getPackedValue();
    }

    private static final Modifier slideInOut(Modifier $this$slideInOut, final Transition<EnterExitState> transition, final State<Slide> state, final State<Slide> state2, final String labelPrefix) {
        return ComposedModifierKt.composed$default($this$slideInOut, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInOut$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* renamed from: invoke$lambda-1, reason: not valid java name */
            private static final boolean m391invoke$lambda1(MutableState<Boolean> mutableState) {
                MutableState<Boolean> $this$getValue$iv = mutableState;
                return $this$getValue$iv.getValue().booleanValue();
            }

            /* renamed from: invoke$lambda-2, reason: not valid java name */
            private static final void m392invoke$lambda2(MutableState<Boolean> mutableState, boolean value) {
                mutableState.setValue(Boolean.valueOf(value));
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Object key1$iv;
                Modifier modifier;
                Object value$iv$iv;
                Object value$iv$iv2;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(158379472);
                ComposerKt.sourceInformation($composer, "C931@40494L46,943@40919L33,941@40843L119,945@40986L88:EnterExitTransition.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(158379472, $changed, -1, "androidx.compose.animation.slideInOut.<anonymous> (EnterExitTransition.kt:928)");
                }
                Object key1$iv2 = transition;
                $composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer.changed(key1$iv2);
                Object it$iv$iv = $composer.rememberedValue();
                if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    key1$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    $composer.updateRememberedValue(key1$iv);
                } else {
                    key1$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                MutableState shouldAnimate$delegate = (MutableState) key1$iv;
                if (transition.getCurrentState() == transition.getTargetState() && !transition.isSeeking()) {
                    m392invoke$lambda2(shouldAnimate$delegate, false);
                } else if (state.getValue() != null || state2.getValue() != null) {
                    m392invoke$lambda2(shouldAnimate$delegate, true);
                }
                if (m391invoke$lambda1(shouldAnimate$delegate)) {
                    Transition<EnterExitState> transition2 = transition;
                    TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE);
                    String str = labelPrefix;
                    $composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                    Object it$iv$iv2 = $composer.rememberedValue();
                    if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = str + " slide";
                        $composer.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv2;
                    }
                    $composer.endReplaceableGroup();
                    Transition.DeferredAnimation animation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition2, vectorConverter, (String) value$iv$iv, $composer, 448, 0);
                    Object key1$iv3 = transition;
                    State<Slide> state3 = state;
                    State<Slide> state4 = state2;
                    $composer.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv2 = $composer.changed(key1$iv3);
                    Object it$iv$iv3 = $composer.rememberedValue();
                    if (invalid$iv$iv2 || it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv2 = new SlideModifier(animation, state3, state4);
                        $composer.updateRememberedValue(value$iv$iv2);
                    } else {
                        value$iv$iv2 = it$iv$iv3;
                    }
                    $composer.endReplaceableGroup();
                    SlideModifier modifier2 = (SlideModifier) value$iv$iv2;
                    modifier = composed.then(modifier2);
                } else {
                    modifier = composed;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return modifier;
            }
        }, 1, null);
    }

    private static final Modifier shrinkExpand(Modifier $this$shrinkExpand, final Transition<EnterExitState> transition, final State<ChangeSize> state, final State<ChangeSize> state2, final String labelPrefix) {
        return ComposedModifierKt.composed$default($this$shrinkExpand, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* renamed from: invoke$lambda-1, reason: not valid java name */
            private static final boolean m385invoke$lambda1(MutableState<Boolean> mutableState) {
                MutableState<Boolean> $this$getValue$iv = mutableState;
                return $this$getValue$iv.getValue().booleanValue();
            }

            /* renamed from: invoke$lambda-2, reason: not valid java name */
            private static final void m386invoke$lambda2(MutableState<Boolean> mutableState, boolean value) {
                mutableState.setValue(Boolean.valueOf(value));
            }

            /* JADX WARN: Removed duplicated region for block: B:38:0x0231  */
            /* JADX WARN: Removed duplicated region for block: B:45:0x0262  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x0286  */
            /* JADX WARN: Removed duplicated region for block: B:65:0x0236  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Object key1$iv;
                Modifier modifier;
                Alignment alignment;
                Alignment alignment2;
                Object value$iv$iv;
                Object value$iv$iv2;
                Object value$iv$iv3;
                ChangeSize value;
                boolean z;
                boolean disableClip;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(-140634085);
                ComposerKt.sourceInformation($composer, "C1014@43572L46,1024@43926L396,1037@44436L41,1035@44362L125,1046@44797L218:EnterExitTransition.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-140634085, $changed, -1, "androidx.compose.animation.shrinkExpand.<anonymous> (EnterExitTransition.kt:1010)");
                }
                Object key1$iv2 = transition;
                $composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer.changed(key1$iv2);
                Object it$iv$iv = $composer.rememberedValue();
                if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    key1$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    $composer.updateRememberedValue(key1$iv);
                } else {
                    key1$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                MutableState shouldAnimate$delegate = (MutableState) key1$iv;
                if (transition.getCurrentState() == transition.getTargetState() && !transition.isSeeking()) {
                    m386invoke$lambda2(shouldAnimate$delegate, false);
                } else if (state.getValue() != null || state2.getValue() != null) {
                    m386invoke$lambda2(shouldAnimate$delegate, true);
                }
                if (m385invoke$lambda1(shouldAnimate$delegate)) {
                    Transition.Segment $this$invoke_u24lambda_u2d3 = transition.getSegment();
                    boolean it = $this$invoke_u24lambda_u2d3.isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible);
                    State<ChangeSize> state3 = state;
                    State<ChangeSize> state4 = state2;
                    if (it) {
                        ChangeSize value2 = state3.getValue();
                        if (value2 == null || (alignment = value2.getAlignment()) == null) {
                            ChangeSize value3 = state4.getValue();
                            alignment = value3 != null ? value3.getAlignment() : null;
                        }
                    } else {
                        ChangeSize value4 = state4.getValue();
                        if (value4 == null || (alignment2 = value4.getAlignment()) == null) {
                            ChangeSize value5 = state3.getValue();
                            alignment = value5 != null ? value5.getAlignment() : null;
                        } else {
                            alignment = alignment2;
                        }
                    }
                    State alignment3 = SnapshotStateKt.rememberUpdatedState(alignment, $composer, 0);
                    Transition<EnterExitState> transition2 = transition;
                    TwoWayConverter<IntSize, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntSize.INSTANCE);
                    String str = labelPrefix;
                    $composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                    Object it$iv$iv2 = $composer.rememberedValue();
                    if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = str + " shrink/expand";
                        $composer.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv2;
                    }
                    $composer.endReplaceableGroup();
                    Transition.DeferredAnimation sizeAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition2, vectorConverter, (String) value$iv$iv, $composer, 448, 0);
                    $composer.startMovableGroup(-1553214439, Boolean.valueOf(transition.getCurrentState() == transition.getTargetState()));
                    ComposerKt.sourceInformation($composer, "1042@44682L54,1040@44598L152");
                    Transition<EnterExitState> transition3 = transition;
                    TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter2 = VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE);
                    String str2 = labelPrefix;
                    $composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                    Object it$iv$iv3 = $composer.rememberedValue();
                    if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv2 = str2 + " InterruptionHandlingOffset";
                        $composer.updateRememberedValue(value$iv$iv2);
                    } else {
                        value$iv$iv2 = it$iv$iv3;
                    }
                    $composer.endReplaceableGroup();
                    Transition.DeferredAnimation offsetAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition3, vectorConverter2, (String) value$iv$iv2, $composer, 448, 0);
                    $composer.endMovableGroup();
                    Object key1$iv3 = transition;
                    State<ChangeSize> state5 = state;
                    State<ChangeSize> state6 = state2;
                    $composer.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv2 = $composer.changed(key1$iv3);
                    Object it$iv$iv4 = $composer.rememberedValue();
                    if (!invalid$iv$iv2) {
                        Object key1$iv4 = Composer.INSTANCE.getEmpty();
                        if (it$iv$iv4 != key1$iv4) {
                            value$iv$iv3 = it$iv$iv4;
                            $composer.endReplaceableGroup();
                            ExpandShrinkModifier expandShrinkModifier = (ExpandShrinkModifier) value$iv$iv3;
                            if (transition.getCurrentState() != transition.getTargetState()) {
                                expandShrinkModifier.setCurrentAlignment(null);
                            } else if (expandShrinkModifier.getCurrentAlignment() == null) {
                                Alignment alignment4 = (Alignment) alignment3.getValue();
                                if (alignment4 == null) {
                                    alignment4 = Alignment.INSTANCE.getTopStart();
                                }
                                expandShrinkModifier.setCurrentAlignment(alignment4);
                            }
                            value = state.getValue();
                            if (!(value == null && !value.getClip())) {
                                ChangeSize value6 = state2.getValue();
                                if (!((value6 == null || value6.getClip()) ? false : true)) {
                                    z = false;
                                    disableClip = z;
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    if (!disableClip) {
                                        companion = ClipKt.clipToBounds(companion);
                                    }
                                    modifier = composed.then(companion).then(expandShrinkModifier);
                                }
                            }
                            z = true;
                            disableClip = z;
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            if (!disableClip) {
                            }
                            modifier = composed.then(companion2).then(expandShrinkModifier);
                        }
                    }
                    value$iv$iv3 = new ExpandShrinkModifier(sizeAnimation, offsetAnimation, state5, state6, alignment3);
                    $composer.updateRememberedValue(value$iv$iv3);
                    $composer.endReplaceableGroup();
                    ExpandShrinkModifier expandShrinkModifier2 = (ExpandShrinkModifier) value$iv$iv3;
                    if (transition.getCurrentState() != transition.getTargetState()) {
                    }
                    value = state.getValue();
                    if (!(value == null && !value.getClip())) {
                    }
                    z = true;
                    disableClip = z;
                    Modifier.Companion companion22 = Modifier.INSTANCE;
                    if (!disableClip) {
                    }
                    modifier = composed.then(companion22).then(expandShrinkModifier2);
                } else {
                    modifier = composed;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return modifier;
            }
        }, 1, null);
    }
}
