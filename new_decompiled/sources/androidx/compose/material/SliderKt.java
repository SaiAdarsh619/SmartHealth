package androidx.compose.material;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.GestureCancellationException;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.ShadowKt;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.p000ui.graphics.PointMode;
import androidx.compose.p000ui.graphics.RectangleShapeKt;
import androidx.compose.p000ui.graphics.StrokeCap;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.p000ui.util.MathHelpersKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.health.platform.client.SdkConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Slider.kt */
@Metadata(m286d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aS\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u001b\u001a\u007f\u0010\u001c\u001a\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0016\u0012\u0004\u0012\u00020\u00120\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010!\u001a\u00020\"2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u0010'\u001ak\u0010(\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010%\u001a\u00020&2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00103\u001a}\u00104\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010!\u001a\u00020\"2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\b\b\u0002\u00105\u001a\u00020/2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u00106\u001aK\u00107\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u00108\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010%\u001a\u00020&2\u0006\u0010-\u001a\u00020\b2\u0006\u00105\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00109\u001aS\u0010:\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\bH\u0003¢\u0006\u0002\u0010=\u001a1\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010D\u001a \u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bH\u0002\u001a0\u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\bH\u0002\u001a<\u0010I\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\bH\u0002\u001a.\u0010P\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\bH\u0002\u001a\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010!\u001a\u00020\"H\u0002\u001aI\u0010T\u001a\u00020\u0012*\u00020U2\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010V\u001a\u00020\u00032\u0006\u00105\u001a\u00020/2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010W\u001a\u00020\u0003H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010Y\u001a;\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\b\u0018\u00010[*\u00020]2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH\u0082@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bb\u0010c\u001a\u0098\u0001\u0010d\u001a\u00020\u0001*\u00020\u00012\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\b0f2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\b0f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010h\u001a\u00020 2\u0006\u0010R\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0018\u0010i\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00120\u00140f2\u001e\u0010j\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120k0fH\u0002\u001a\\\u0010l\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00142\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010!\u001a\u00020\"H\u0002\u001aj\u0010m\u001a\u00020\u0001*\u00020\u00012\u0006\u0010?\u001a\u00020@2\u0006\u00105\u001a\u00020/2\u0006\u0010R\u001a\u00020\b2\u0006\u0010h\u001a\u00020 2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\b0f2\u0018\u0010i\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00140f2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010\u001f\u001a\u00020 H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u000b\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\f\u0010\r\"\u0013\u0010\u000e\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u000f\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\r\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006p"}, m287d2 = {"DefaultSliderConstraints", "Landroidx/compose/ui/Modifier;", "SliderHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SliderMinWidth", "SliderToTickAnimation", "Landroidx/compose/animation/core/TweenSpec;", "", "ThumbDefaultElevation", "ThumbPressedElevation", "ThumbRadius", "getThumbRadius", "()F", "ThumbRippleRadius", "TrackHeight", "getTrackHeight", "CorrectValueSideEffect", "", "scaleToOffset", "Lkotlin/Function1;", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "trackRange", "valueState", "Landroidx/compose/runtime/MutableState;", "value", "(Lkotlin/jvm/functions/Function1;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/MutableState;FLandroidx/compose/runtime/Composer;I)V", "RangeSlider", "onValueChange", "modifier", "enabled", "", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "colors", "Landroidx/compose/material/SliderColors;", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "positionFractionStart", "positionFractionEnd", "tickFractions", "", "width", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "startThumbSemantics", "endThumbSemantics", "(ZFFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Slider", "interactionSource", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "positionFraction", "(ZFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "Track", "thumbPx", "trackStrokeWidth", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/SliderColors;ZFFLjava/util/List;FFLandroidx/compose/runtime/Composer;I)V", "animateToTarget", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "current", "target", "velocity", "(Landroidx/compose/foundation/gestures/DraggableState;FFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calcFraction", "a", "b", "pos", "scale", "a1", "b1", "x1", "a2", "b2", "x", "snapValueToTick", "minPx", "maxPx", "stepsToTickFractions", "SliderThumb", "Landroidx/compose/foundation/layout/BoxScope;", "offset", "thumbSize", "SliderThumb-PcYyNuk", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/ui/Modifier;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;ZFLandroidx/compose/runtime/Composer;I)V", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderPressDragModifier", "rawOffsetStart", "Landroidx/compose/runtime/State;", "rawOffsetEnd", "isRtl", "gestureEndAction", "onDrag", "Lkotlin/Function2;", "sliderSemantics", "sliderTapModifier", "rawOffset", "pressOffset", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SliderKt {
    private static final float ThumbRadius = C0504Dp.m4382constructorimpl(10);
    private static final float ThumbRippleRadius = C0504Dp.m4382constructorimpl(24);
    private static final float ThumbDefaultElevation = C0504Dp.m4382constructorimpl(1);
    private static final float ThumbPressedElevation = C0504Dp.m4382constructorimpl(6);
    private static final float TrackHeight = C0504Dp.m4382constructorimpl(4);
    private static final float SliderHeight = C0504Dp.m4382constructorimpl(48);
    private static final float SliderMinWidth = C0504Dp.m4382constructorimpl(144);
    private static final Modifier DefaultSliderConstraints = SizeKt.m788heightInVpY3zN4$default(SizeKt.m807widthInVpY3zN4$default(Modifier.INSTANCE, SliderMinWidth, 0.0f, 2, null), 0.0f, SliderHeight, 1, null);
    private static final TweenSpec<Float> SliderToTickAnimation = new TweenSpec<>(100, 0, null, 6, null);

    /* JADX WARN: Removed duplicated region for block: B:73:0x031b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Slider(final float value, final Function1<? super Float, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> closedFloatingPointRange, int steps, Function0<Unit> function0, MutableInteractionSource interactionSource, SliderColors colors, Composer $composer, final int $changed, final int i) {
        ClosedFloatingPointRange closedFloatingPointRange2;
        int i2;
        Function0 function02;
        boolean enabled2;
        ClosedFloatingPointRange valueRange;
        int steps2;
        Function0 onValueChangeFinished;
        Modifier modifier2;
        MutableInteractionSource interactionSource2;
        SliderColors colors2;
        Object value$iv$iv;
        Object value$iv$iv2;
        MutableInteractionSource interactionSource3;
        SliderColors colors3;
        boolean enabled3;
        ClosedFloatingPointRange valueRange2;
        int steps3;
        Function0 onValueChangeFinished2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer2 = $composer.startRestartGroup(-1962335196);
        ComposerKt.sourceInformation($composer2, "C(Slider)P(7,4,3,1,8,6,5,2)153@7382L39,154@7465L8,157@7558L35,158@7618L59,161@7682L3395:Slider.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(onValueChange) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(enabled) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                closedFloatingPointRange2 = closedFloatingPointRange;
                if ($composer2.changed(closedFloatingPointRange2)) {
                    i4 = 16384;
                    $dirty |= i4;
                }
            } else {
                closedFloatingPointRange2 = closedFloatingPointRange;
            }
            i4 = 8192;
            $dirty |= i4;
        } else {
            closedFloatingPointRange2 = closedFloatingPointRange;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= 196608;
            i2 = steps;
        } else if ((458752 & $changed) == 0) {
            i2 = steps;
            $dirty |= $composer2.changed(i2) ? 131072 : 65536;
        } else {
            i2 = steps;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
            function02 = function0;
        } else if ((3670016 & $changed) == 0) {
            function02 = function0;
            $dirty |= $composer2.changed(function02) ? 1048576 : 524288;
        } else {
            function02 = function0;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 8388608 : 4194304;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0 && $composer2.changed(colors)) {
                i3 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty |= i3;
            }
            i3 = 33554432;
            $dirty |= i3;
        }
        if (($dirty & 191739611) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            enabled3 = enabled;
            interactionSource3 = interactionSource;
            colors3 = colors;
            valueRange2 = closedFloatingPointRange2;
            onValueChangeFinished2 = function02;
            steps3 = i2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i5 != 0 ? Modifier.INSTANCE : modifier;
                enabled2 = i6 != 0 ? true : enabled;
                if ((i & 16) != 0) {
                    valueRange = RangesKt.rangeTo(0.0f, 1.0f);
                    $dirty &= -57345;
                } else {
                    valueRange = closedFloatingPointRange2;
                }
                steps2 = i7 != 0 ? 0 : i2;
                onValueChangeFinished = i8 != 0 ? null : function02;
                if (i9 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer2.rememberedValue();
                    modifier2 = modifier3;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    modifier2 = modifier3;
                    interactionSource2 = interactionSource;
                }
                if ((i & 256) != 0) {
                    colors2 = SliderDefaults.INSTANCE.m1488colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, 6, 1023);
                    $dirty &= -234881025;
                } else {
                    colors2 = colors;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 256) != 0) {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    colors2 = colors;
                    $dirty &= -234881025;
                    valueRange = closedFloatingPointRange2;
                    steps2 = i2;
                    onValueChangeFinished = function02;
                    interactionSource2 = interactionSource;
                } else {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    interactionSource2 = interactionSource;
                    colors2 = colors;
                    valueRange = closedFloatingPointRange2;
                    steps2 = i2;
                    onValueChangeFinished = function02;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1962335196, $dirty, -1, "androidx.compose.material.Slider (Slider.kt:144)");
            }
            if (!(steps2 >= 0)) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            State onValueChangeState = SnapshotStateKt.rememberUpdatedState(onValueChange, $composer2, ($dirty >> 3) & 14);
            Object key1$iv = Integer.valueOf(steps2);
            int i10 = ($dirty >> 15) & 14;
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(key1$iv);
            Object it$iv$iv2 = $composer2.rememberedValue();
            if (!invalid$iv$iv && it$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = it$iv$iv2;
                $composer2.endReplaceableGroup();
                List tickFractions = (List) value$iv$iv2;
                Modifier minimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(modifier2);
                float arg0$iv = ThumbRadius;
                float m4382constructorimpl = C0504Dp.m4382constructorimpl(2 * arg0$iv);
                float arg0$iv2 = ThumbRadius;
                BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m796requiredSizeInqDBjuR0$default(minimumTouchTargetSize, m4382constructorimpl, C0504Dp.m4382constructorimpl(2 * arg0$iv2), 0.0f, 0.0f, 12, null), value, enabled2, onValueChange, onValueChangeFinished, valueRange, steps2), enabled2, interactionSource2), null, false, ComposableLambdaKt.composableLambda($composer2, 2085116814, true, new SliderKt$Slider$3(valueRange, $dirty, value, interactionSource2, enabled2, tickFractions, colors2, onValueChangeState, onValueChangeFinished)), $composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interactionSource3 = interactionSource2;
                colors3 = colors2;
                enabled3 = enabled2;
                valueRange2 = valueRange;
                steps3 = steps2;
                onValueChangeFinished2 = onValueChangeFinished;
            }
            value$iv$iv2 = stepsToTickFractions(steps2);
            $composer2.updateRememberedValue(value$iv$iv2);
            $composer2.endReplaceableGroup();
            List tickFractions2 = (List) value$iv$iv2;
            Modifier minimumTouchTargetSize2 = TouchTargetKt.minimumTouchTargetSize(modifier2);
            float arg0$iv3 = ThumbRadius;
            float m4382constructorimpl2 = C0504Dp.m4382constructorimpl(2 * arg0$iv3);
            float arg0$iv22 = ThumbRadius;
            BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(sliderSemantics(SizeKt.m796requiredSizeInqDBjuR0$default(minimumTouchTargetSize2, m4382constructorimpl2, C0504Dp.m4382constructorimpl(2 * arg0$iv22), 0.0f, 0.0f, 12, null), value, enabled2, onValueChange, onValueChangeFinished, valueRange, steps2), enabled2, interactionSource2), null, false, ComposableLambdaKt.composableLambda($composer2, 2085116814, true, new SliderKt$Slider$3(valueRange, $dirty, value, interactionSource2, enabled2, tickFractions2, colors2, onValueChangeState, onValueChangeFinished)), $composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
            }
            interactionSource3 = interactionSource2;
            colors3 = colors2;
            enabled3 = enabled2;
            valueRange2 = valueRange;
            steps3 = steps2;
            onValueChangeFinished2 = onValueChangeFinished;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier2;
        final boolean z = enabled3;
        final ClosedFloatingPointRange closedFloatingPointRange3 = valueRange2;
        final int i11 = steps3;
        final Function0 function03 = onValueChangeFinished2;
        final MutableInteractionSource mutableInteractionSource = interactionSource3;
        final SliderColors sliderColors = colors3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$Slider$4
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

            public final void invoke(Composer composer, int i12) {
                SliderKt.Slider(value, onValueChange, modifier4, z, closedFloatingPointRange3, i11, function03, mutableInteractionSource, sliderColors, composer, $changed | 1, i);
            }
        });
    }

    @ExperimentalMaterialApi
    public static final void RangeSlider(final ClosedFloatingPointRange<Float> value, final Function1<? super ClosedFloatingPointRange<Float>, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> closedFloatingPointRange, int steps, Function0<Unit> function0, SliderColors colors, Composer $composer, final int $changed, final int i) {
        boolean enabled2;
        ClosedFloatingPointRange valueRange;
        int steps2;
        Function0 onValueChangeFinished;
        SliderColors colors2;
        Modifier modifier2;
        boolean enabled3;
        ClosedFloatingPointRange valueRange2;
        int steps3;
        Function0 onValueChangeFinished2;
        int $dirty;
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Composer $composer2;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-1556183027);
        ComposerKt.sourceInformation($composer3, "C(RangeSlider)P(6,3,2,1,7,5,4)298@13418L8,300@13490L39,301@13587L39,304@13708L35,305@13768L59,309@13833L5053:Slider.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer3.changed(onValueChange) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 7168) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                valueRange = closedFloatingPointRange;
                if ($composer3.changed(valueRange)) {
                    i3 = 16384;
                    $dirty2 |= i3;
                }
            } else {
                valueRange = closedFloatingPointRange;
            }
            i3 = 8192;
            $dirty2 |= i3;
        } else {
            valueRange = closedFloatingPointRange;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= 196608;
            steps2 = steps;
        } else if ((458752 & $changed) == 0) {
            steps2 = steps;
            $dirty2 |= $composer3.changed(steps2) ? 131072 : 65536;
        } else {
            steps2 = steps;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            onValueChangeFinished = function0;
        } else if ((3670016 & $changed) == 0) {
            onValueChangeFinished = function0;
            $dirty2 |= $composer3.changed(onValueChangeFinished) ? 1048576 : 524288;
        } else {
            onValueChangeFinished = function0;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0 && $composer3.changed(colors)) {
                i2 = 8388608;
                $dirty2 |= i2;
            }
            i2 = 4194304;
            $dirty2 |= i2;
        }
        if (($dirty2 & 23967451) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            colors2 = colors;
            enabled3 = enabled2;
            valueRange2 = valueRange;
            steps3 = steps2;
            onValueChangeFinished2 = onValueChangeFinished;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier;
                if (i5 != 0) {
                    enabled2 = true;
                }
                if ((i & 16) != 0) {
                    ClosedFloatingPointRange valueRange3 = RangesKt.rangeTo(0.0f, 1.0f);
                    $dirty2 &= -57345;
                    valueRange = valueRange3;
                }
                if (i6 != 0) {
                    steps2 = 0;
                }
                if (i7 != 0) {
                    onValueChangeFinished = null;
                }
                if ((i & 128) != 0) {
                    modifier2 = modifier3;
                    colors2 = SliderDefaults.INSTANCE.m1488colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 6, 1023);
                    enabled3 = enabled2;
                    valueRange2 = valueRange;
                    steps3 = steps2;
                    onValueChangeFinished2 = onValueChangeFinished;
                    $dirty = $dirty2 & (-29360129);
                } else {
                    colors2 = colors;
                    modifier2 = modifier3;
                    enabled3 = enabled2;
                    valueRange2 = valueRange;
                    steps3 = steps2;
                    onValueChangeFinished2 = onValueChangeFinished;
                    $dirty = $dirty2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 128) != 0) {
                    modifier2 = modifier;
                    colors2 = colors;
                    enabled3 = enabled2;
                    valueRange2 = valueRange;
                    steps3 = steps2;
                    onValueChangeFinished2 = onValueChangeFinished;
                    $dirty = $dirty2 & (-29360129);
                } else {
                    modifier2 = modifier;
                    colors2 = colors;
                    enabled3 = enabled2;
                    valueRange2 = valueRange;
                    steps3 = steps2;
                    onValueChangeFinished2 = onValueChangeFinished;
                    $dirty = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1556183027, $dirty, -1, "androidx.compose.material.RangeSlider (Slider.kt:289)");
            }
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer3.endReplaceableGroup();
            MutableInteractionSource startInteractionSource = (MutableInteractionSource) value$iv$iv;
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
            Object it$iv$iv2 = $composer3.rememberedValue();
            if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer3.endReplaceableGroup();
            MutableInteractionSource endInteractionSource = (MutableInteractionSource) value$iv$iv2;
            if (!(steps3 >= 0)) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            State onValueChangeState = SnapshotStateKt.rememberUpdatedState(onValueChange, $composer3, ($dirty >> 3) & 14);
            Object key1$iv = Integer.valueOf(steps3);
            int i8 = ($dirty >> 15) & 14;
            $composer3.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer3, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer3.changed(key1$iv);
            Object it$iv$iv3 = $composer3.rememberedValue();
            if (invalid$iv$iv || it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv3 = stepsToTickFractions(steps3);
                $composer3.updateRememberedValue(value$iv$iv3);
            } else {
                value$iv$iv3 = it$iv$iv3;
            }
            $composer3.endReplaceableGroup();
            List tickFractions = (List) value$iv$iv3;
            Modifier minimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(modifier2);
            float arg0$iv = ThumbRadius;
            float arg0$iv2 = C0504Dp.m4382constructorimpl(4 * arg0$iv);
            float arg0$iv3 = ThumbRadius;
            $composer2 = $composer3;
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m796requiredSizeInqDBjuR0$default(minimumTouchTargetSize, arg0$iv2, C0504Dp.m4382constructorimpl(2 * arg0$iv3), 0.0f, 0.0f, 12, null), null, false, ComposableLambdaKt.composableLambda($composer2, 652589923, true, new SliderKt$RangeSlider$2(valueRange2, value, $dirty, onValueChangeState, startInteractionSource, endInteractionSource, enabled3, steps3, onValueChangeFinished2, tickFractions, colors2)), $composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier2;
        final boolean z = enabled3;
        final ClosedFloatingPointRange closedFloatingPointRange2 = valueRange2;
        final int i9 = steps3;
        final Function0 function02 = onValueChangeFinished2;
        final SliderColors sliderColors = colors2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$3
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

            public final void invoke(Composer composer, int i10) {
                SliderKt.RangeSlider(value, onValueChange, modifier4, z, closedFloatingPointRange2, i9, function02, sliderColors, composer, $changed | 1, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SliderImpl(final boolean enabled, final float positionFraction, final List<Float> list, final SliderColors colors, final float width, final MutableInteractionSource interactionSource, final Modifier modifier, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1679682785);
        ComposerKt.sourceInformation($composer2, "C(SliderImpl)P(1,4,5!1,6)587@24705L712:Slider.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1679682785, $changed, -1, "androidx.compose.material.SliderImpl (Slider.kt:578)");
        }
        Modifier modifier$iv = modifier.then(DefaultSliderConstraints);
        $composer2.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
        int $changed$iv$iv = (0 << 3) & SdkConfig.SDK_VERSION;
        $composer2.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer2.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        Density density$iv$iv = (Density) consume;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer2.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = $composer2.consume(localViewConfiguration);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
        Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
        if (!($composer2.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer2.startReusableNode();
        if ($composer2.getInserting()) {
            factory$iv$iv$iv = factory$iv$iv$iv2;
            $composer2.createNode(factory$iv$iv$iv);
        } else {
            factory$iv$iv$iv = factory$iv$iv$iv2;
            $composer2.useNode();
        }
        $composer2.disableReusing();
        Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer2);
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
        $composer2.enableReusing();
        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
        $composer2.startReplaceableGroup(2058660585);
        int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
        $composer2.startReplaceableGroup(-2137368960);
        ComposerKt.sourceInformation($composer2, "C72@3384L9:Box.kt#2w3rfo");
        if (($changed$iv & 11) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int $changed2 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
            BoxScope $this$SliderImpl_u24lambda_u2d8 = boxScope;
            $composer2.startReplaceableGroup(231316251);
            ComposerKt.sourceInformation($composer2, "C*591@24865L7,600@25110L216,610@25335L76:Slider.kt#jmzs0o");
            int $dirty = $changed2;
            if (($changed2 & 14) == 0) {
                $dirty |= $composer2.changed($this$SliderImpl_u24lambda_u2d8) ? 4 : 2;
            }
            if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer2.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density $this$SliderImpl_u24lambda_u2d8_u24lambda_u2d7 = (Density) consume4;
                float trackStrokeWidth = $this$SliderImpl_u24lambda_u2d8_u24lambda_u2d7.mo648toPx0680j_4(TrackHeight);
                float thumbPx = $this$SliderImpl_u24lambda_u2d8_u24lambda_u2d7.mo648toPx0680j_4(ThumbRadius);
                float widthDp = $this$SliderImpl_u24lambda_u2d8_u24lambda_u2d7.mo644toDpu2uoSUM(width);
                float arg0$iv = ThumbRadius;
                float thumbSize = C0504Dp.m4382constructorimpl(2 * arg0$iv);
                float offset = C0504Dp.m4382constructorimpl(widthDp * positionFraction);
                Track(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), colors, enabled, 0.0f, positionFraction, list, thumbPx, trackStrokeWidth, $composer2, (($changed >> 6) & SdkConfig.SDK_VERSION) | 265222 | (($changed << 6) & 896) | (($changed << 9) & 57344));
                m1489SliderThumbPcYyNuk($this$SliderImpl_u24lambda_u2d8, Modifier.INSTANCE, offset, interactionSource, colors, enabled, thumbSize, $composer2, ($dirty & 14) | 1572912 | (($changed >> 6) & 7168) | (($changed << 3) & 57344) | (($changed << 15) & 458752));
            } else {
                $composer2.skipToGroupEnd();
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
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$SliderImpl$2
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
                SliderKt.SliderImpl(enabled, positionFraction, list, colors, width, interactionSource, modifier, composer, $changed | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RangeSliderImpl(final boolean enabled, final float positionFractionStart, final float positionFractionEnd, final List<Float> list, final SliderColors colors, final float width, final MutableInteractionSource startInteractionSource, final MutableInteractionSource endInteractionSource, final Modifier modifier, final Modifier startThumbSemantics, final Modifier endThumbSemantics, Composer $composer, final int $changed, final int $changed1) {
        Object value$iv$iv;
        boolean invalid$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-278895713);
        ComposerKt.sourceInformation($composer2, "C(RangeSliderImpl)P(1,6,5,9!1,10,7!1,4,8)629@25862L35,630@25930L33,631@25968L1522:Slider.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-278895713, $changed, $changed1, "androidx.compose.material.RangeSliderImpl (Slider.kt:615)");
        }
        final String startContentDescription = Strings_androidKt.m1511getString4foXLRw(Strings.INSTANCE.m1510getSliderRangeStartUdPEhr4(), $composer2, 6);
        final String endContentDescription = Strings_androidKt.m1511getString4foXLRw(Strings.INSTANCE.m1509getSliderRangeEndUdPEhr4(), $composer2, 6);
        Modifier modifier$iv = modifier.then(DefaultSliderConstraints);
        $composer2.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
        int $changed$iv$iv = (0 << 3) & SdkConfig.SDK_VERSION;
        $composer2.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer2.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        Density density$iv$iv = (Density) consume;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer2.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = $composer2.consume(localViewConfiguration);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
        Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
        Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
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
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
        $composer2.enableReusing();
        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
        $composer2.startReplaceableGroup(2058660585);
        int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
        $composer2.startReplaceableGroup(-2137368960);
        ComposerKt.sourceInformation($composer2, "C72@3384L9:Box.kt#2w3rfo");
        if (($changed$iv & 11) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int $changed2 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
            BoxScope $this$RangeSliderImpl_u24lambda_u2d12 = boxScope;
            $composer2.startReplaceableGroup(2044256857);
            ComposerKt.sourceInformation($composer2, "C*635@26128L7,644@26436L301,659@26833L48,657@26747L369,670@27211L46,668@27125L359:Slider.kt#jmzs0o");
            int $dirty = $changed2;
            if (($changed2 & 14) == 0) {
                $dirty |= $composer2.changed($this$RangeSliderImpl_u24lambda_u2d12) ? 4 : 2;
            }
            if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer2.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density $this$RangeSliderImpl_u24lambda_u2d12_u24lambda_u2d9 = (Density) consume4;
                float trackStrokeWidth = $this$RangeSliderImpl_u24lambda_u2d12_u24lambda_u2d9.mo648toPx0680j_4(TrackHeight);
                float thumbPx = $this$RangeSliderImpl_u24lambda_u2d12_u24lambda_u2d9.mo648toPx0680j_4(ThumbRadius);
                float widthDp = $this$RangeSliderImpl_u24lambda_u2d12_u24lambda_u2d9.mo644toDpu2uoSUM(width);
                Unit unit = Unit.INSTANCE;
                float arg0$iv = ThumbRadius;
                float thumbSize = C0504Dp.m4382constructorimpl(2 * arg0$iv);
                float offsetStart = C0504Dp.m4382constructorimpl(widthDp * positionFractionStart);
                float offsetEnd = C0504Dp.m4382constructorimpl(widthDp * positionFractionEnd);
                Track(SizeKt.fillMaxSize$default($this$RangeSliderImpl_u24lambda_u2d12.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart()), 0.0f, 1, null), colors, enabled, positionFractionStart, positionFractionEnd, list, thumbPx, trackStrokeWidth, $composer2, (($changed >> 9) & SdkConfig.SDK_VERSION) | 262144 | (($changed << 6) & 896) | (($changed << 6) & 7168) | (($changed << 6) & 57344));
                Modifier.Companion companion = Modifier.INSTANCE;
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv2 = $composer2.changed(startContentDescription);
                Object it$iv$iv = $composer2.rememberedValue();
                if (!invalid$iv$iv2 && it$iv$iv != Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = it$iv$iv;
                    $composer2.endReplaceableGroup();
                    m1489SliderThumbPcYyNuk($this$RangeSliderImpl_u24lambda_u2d12, FocusableKt.focusable(SemanticsModifierKt.semantics(companion, true, (Function1) value$iv$iv), true, startInteractionSource).then(startThumbSemantics), offsetStart, startInteractionSource, colors, enabled, thumbSize, $composer2, ($dirty & 14) | 1572864 | (($changed >> 9) & 7168) | ($changed & 57344) | (($changed << 15) & 458752));
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                    invalid$iv$iv = $composer2.changed(endContentDescription);
                    Object value$iv$iv2 = $composer2.rememberedValue();
                    if (!invalid$iv$iv && value$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                        $composer2.endReplaceableGroup();
                        m1489SliderThumbPcYyNuk($this$RangeSliderImpl_u24lambda_u2d12, FocusableKt.focusable(SemanticsModifierKt.semantics(companion2, true, (Function1) value$iv$iv2), true, endInteractionSource).then(endThumbSemantics), offsetEnd, endInteractionSource, colors, enabled, thumbSize, $composer2, ($dirty & 14) | 1572864 | (($changed >> 12) & 7168) | (57344 & $changed) | (($changed << 15) & 458752));
                    }
                    value$iv$iv2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$1$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            SemanticsPropertiesKt.setContentDescription(semantics, endContentDescription);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv$iv2);
                    $composer2.endReplaceableGroup();
                    m1489SliderThumbPcYyNuk($this$RangeSliderImpl_u24lambda_u2d12, FocusableKt.focusable(SemanticsModifierKt.semantics(companion2, true, (Function1) value$iv$iv2), true, endInteractionSource).then(endThumbSemantics), offsetEnd, endInteractionSource, colors, enabled, thumbSize, $composer2, ($dirty & 14) | 1572864 | (($changed >> 12) & 7168) | (57344 & $changed) | (($changed << 15) & 458752));
                }
                value$iv$iv = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$1$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        SemanticsPropertiesKt.setContentDescription(semantics, startContentDescription);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
                $composer2.endReplaceableGroup();
                m1489SliderThumbPcYyNuk($this$RangeSliderImpl_u24lambda_u2d12, FocusableKt.focusable(SemanticsModifierKt.semantics(companion, true, (Function1) value$iv$iv), true, startInteractionSource).then(startThumbSemantics), offsetStart, startInteractionSource, colors, enabled, thumbSize, $composer2, ($dirty & 14) | 1572864 | (($changed >> 9) & 7168) | ($changed & 57344) | (($changed << 15) & 458752));
                Modifier.Companion companion22 = Modifier.INSTANCE;
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                invalid$iv$iv = $composer2.changed(endContentDescription);
                Object value$iv$iv22 = $composer2.rememberedValue();
                if (!invalid$iv$iv) {
                    $composer2.endReplaceableGroup();
                    m1489SliderThumbPcYyNuk($this$RangeSliderImpl_u24lambda_u2d12, FocusableKt.focusable(SemanticsModifierKt.semantics(companion22, true, (Function1) value$iv$iv22), true, endInteractionSource).then(endThumbSemantics), offsetEnd, endInteractionSource, colors, enabled, thumbSize, $composer2, ($dirty & 14) | 1572864 | (($changed >> 12) & 7168) | (57344 & $changed) | (($changed << 15) & 458752));
                }
                value$iv$iv22 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$1$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        SemanticsPropertiesKt.setContentDescription(semantics, endContentDescription);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv22);
                $composer2.endReplaceableGroup();
                m1489SliderThumbPcYyNuk($this$RangeSliderImpl_u24lambda_u2d12, FocusableKt.focusable(SemanticsModifierKt.semantics(companion22, true, (Function1) value$iv$iv22), true, endInteractionSource).then(endThumbSemantics), offsetEnd, endInteractionSource, colors, enabled, thumbSize, $composer2, ($dirty & 14) | 1572864 | (($changed >> 12) & 7168) | (57344 & $changed) | (($changed << 15) & 458752));
            } else {
                $composer2.skipToGroupEnd();
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
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$2
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
                SliderKt.RangeSliderImpl(enabled, positionFractionStart, positionFractionEnd, list, colors, width, startInteractionSource, endInteractionSource, modifier, startThumbSemantics, endThumbSemantics, composer, $changed | 1, $changed1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: SliderThumb-PcYyNuk, reason: not valid java name */
    public static final void m1489SliderThumbPcYyNuk(final BoxScope $this$SliderThumb_u2dPcYyNuk, final Modifier modifier, final float offset, final MutableInteractionSource interactionSource, final SliderColors colors, final boolean enabled, final float thumbSize, Composer $composer, final int $changed) {
        Object value$iv$iv;
        SliderKt$SliderThumb$1$1$1 value$iv$iv2;
        Modifier m1677shadows4CzXII;
        Composer $composer2 = $composer.startRestartGroup(428907178);
        ComposerKt.sourceInformation($composer2, "C(SliderThumb)P(3,4:c#ui.unit.Dp,2!,5:c#ui.unit.Dp)691@27703L1553:Slider.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed($this$SliderThumb_u2dPcYyNuk) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(offset) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changed(colors) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer2.changed(enabled) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            $dirty |= $composer2.changed(thumbSize) ? 1048576 : 524288;
        }
        int $dirty2 = $dirty;
        if ((2995931 & $dirty2) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(428907178, $dirty2, -1, "androidx.compose.material.SliderThumb (Slider.kt:683)");
            }
            Modifier modifier$iv = $this$SliderThumb_u2dPcYyNuk.align(PaddingKt.m763paddingqDBjuR0$default(Modifier.INSTANCE, offset, 0.0f, 0.0f, 0.0f, 14, null), Alignment.INSTANCE.getCenterStart());
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
            int $changed$iv$iv = (0 << 3) & SdkConfig.SDK_VERSION;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
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
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
            $composer2.startReplaceableGroup(2058660585);
            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
            $composer2.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation($composer2, "C72@3384L9:Box.kt#2w3rfo");
            if (($changed$iv & 11) == 2 && $composer2.getSkipping()) {
                $composer2.skipToGroupEnd();
            } else {
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int $changed2 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                $composer2.startReplaceableGroup(-587645648);
                ComposerKt.sourceInformation($composer2, "C695@27834L46,696@27923L658,696@27889L692,719@28937L59,723@29201L19,714@28743L507:Slider.kt#jmzs0o");
                if (($changed2 & 81) == 16 && $composer2.getSkipping()) {
                    $composer2.skipToGroupEnd();
                } else {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer2.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = SnapshotStateKt.mutableStateListOf();
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    SnapshotStateList interactions = (SnapshotStateList) value$iv$iv;
                    int i = (($dirty2 >> 9) & 14) | 560;
                    $composer2.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer2.changed(interactionSource) | $composer2.changed(interactions);
                    Object it$iv$iv2 = $composer2.rememberedValue();
                    if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv2 = new SliderKt$SliderThumb$1$1$1(interactionSource, interactions, null);
                        $composer2.updateRememberedValue(value$iv$iv2);
                    } else {
                        value$iv$iv2 = it$iv$iv2;
                    }
                    $composer2.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv2, $composer2, (($dirty2 >> 9) & 14) | 64);
                    float elevation = !interactions.isEmpty() ? ThumbPressedElevation : ThumbDefaultElevation;
                    m1677shadows4CzXII = ShadowKt.m1677shadows4CzXII(HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m802sizeVpY3zN4(modifier, thumbSize, thumbSize), interactionSource, RippleKt.m1618rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0L, $composer2, 54, 4)), interactionSource, false, 2, null), enabled ? elevation : C0504Dp.m4382constructorimpl(0), (r15 & 2) != 0 ? RectangleShapeKt.getRectangleShape() : RoundedCornerShapeKt.getCircleShape(), (r15 & 4) != 0 ? C0504Dp.m4381compareTo0680j_4(r8, C0504Dp.m4382constructorimpl((float) 0)) > 0 : false, (r15 & 8) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (r15 & 16) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L);
                    SpacerKt.Spacer(BackgroundKt.m494backgroundbw27NRU(m1677shadows4CzXII, colors.thumbColor(enabled, $composer2, (($dirty2 >> 15) & 14) | (($dirty2 >> 9) & SdkConfig.SDK_VERSION)).getValue().m2006unboximpl(), RoundedCornerShapeKt.getCircleShape()), $composer2, 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$SliderThumb$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i2) {
                SliderKt.m1489SliderThumbPcYyNuk(BoxScope.this, modifier, offset, interactionSource, colors, enabled, thumbSize, composer, $changed | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Track(final Modifier modifier, final SliderColors colors, final boolean enabled, final float positionFractionStart, final float positionFractionEnd, final List<Float> list, final float thumbPx, final float trackStrokeWidth, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1833126050);
        ComposerKt.sourceInformation($composer2, "C(Track)P(2!2,4!1,6)739@29549L35,740@29619L34,741@29689L34,742@29757L33,743@29795L1514:Slider.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1833126050, $changed, -1, "androidx.compose.material.Track (Slider.kt:729)");
        }
        final State inactiveTrackColor = colors.trackColor(enabled, false, $composer2, (($changed >> 6) & 14) | 48 | (($changed << 3) & 896));
        final State activeTrackColor = colors.trackColor(enabled, true, $composer2, (($changed >> 6) & 14) | 48 | (($changed << 3) & 896));
        final State inactiveTickColor = colors.tickColor(enabled, false, $composer2, (($changed >> 6) & 14) | 48 | (($changed << 3) & 896));
        final State activeTickColor = colors.tickColor(enabled, true, $composer2, (($changed >> 6) & 14) | 48 | (($changed << 3) & 896));
        CanvasKt.Canvas(modifier, new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.SliderKt$Track$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope Canvas) {
                ArrayList answer$iv$iv$iv;
                Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                boolean isRtl = Canvas.getLayoutDirection() == LayoutDirection.Rtl;
                long sliderLeft = OffsetKt.Offset(thumbPx, Offset.m1761getYimpl(Canvas.mo2489getCenterF1C5BW0()));
                long sliderRight = OffsetKt.Offset(Size.m1829getWidthimpl(Canvas.mo2490getSizeNHjbRc()) - thumbPx, Offset.m1761getYimpl(Canvas.mo2489getCenterF1C5BW0()));
                long sliderStart = isRtl ? sliderRight : sliderLeft;
                long sliderEnd = isRtl ? sliderLeft : sliderRight;
                long sliderEnd2 = sliderEnd;
                long sliderStart2 = sliderStart;
                DrawScope.m2477drawLineNGM6Ib0$default(Canvas, inactiveTrackColor.getValue().m2006unboximpl(), sliderStart, sliderEnd, trackStrokeWidth, StrokeCap.INSTANCE.m2301getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                long sliderValueEnd = OffsetKt.Offset(Offset.m1760getXimpl(sliderStart2) + ((Offset.m1760getXimpl(sliderEnd2) - Offset.m1760getXimpl(sliderStart2)) * positionFractionEnd), Offset.m1761getYimpl(Canvas.mo2489getCenterF1C5BW0()));
                long sliderValueStart = OffsetKt.Offset(Offset.m1760getXimpl(sliderStart2) + ((Offset.m1760getXimpl(sliderEnd2) - Offset.m1760getXimpl(sliderStart2)) * positionFractionStart), Offset.m1761getYimpl(Canvas.mo2489getCenterF1C5BW0()));
                DrawScope.m2477drawLineNGM6Ib0$default(Canvas, activeTrackColor.getValue().m2006unboximpl(), sliderValueStart, sliderValueEnd, trackStrokeWidth, StrokeCap.INSTANCE.m2301getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                Iterable $this$groupBy$iv = list;
                float f = positionFractionEnd;
                float f2 = positionFractionStart;
                Map destination$iv$iv = new LinkedHashMap();
                for (Object element$iv$iv : $this$groupBy$iv) {
                    float it = ((Number) element$iv$iv).floatValue();
                    Boolean valueOf = Boolean.valueOf(it > f || it < f2);
                    Object value$iv$iv$iv = destination$iv$iv.get(valueOf);
                    if (value$iv$iv$iv == null) {
                        answer$iv$iv$iv = new ArrayList();
                        destination$iv$iv.put(valueOf, answer$iv$iv$iv);
                    } else {
                        answer$iv$iv$iv = value$iv$iv$iv;
                    }
                    List list$iv$iv = (List) answer$iv$iv$iv;
                    list$iv$iv.add(element$iv$iv);
                }
                State<Color> state = inactiveTickColor;
                State<Color> state2 = activeTickColor;
                float f3 = trackStrokeWidth;
                for (Map.Entry element$iv : destination$iv$iv.entrySet()) {
                    boolean outsideFraction = ((Boolean) element$iv.getKey()).booleanValue();
                    Iterable list2 = (List) element$iv.getValue();
                    Iterable $this$map$iv = list2;
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        long sliderStart3 = sliderStart2;
                        State<Color> state3 = state2;
                        long sliderEnd3 = sliderEnd2;
                        destination$iv$iv2.add(Offset.m1749boximpl(OffsetKt.Offset(Offset.m1760getXimpl(OffsetKt.m1783lerpWko1d7g(sliderStart3, sliderEnd3, ((Number) item$iv$iv).floatValue())), Offset.m1761getYimpl(Canvas.mo2489getCenterF1C5BW0()))));
                        sliderEnd2 = sliderEnd3;
                        state = state;
                        state2 = state3;
                        isRtl = isRtl;
                        sliderStart2 = sliderStart3;
                    }
                    boolean isRtl2 = isRtl;
                    long sliderStart4 = sliderStart2;
                    State<Color> state4 = state2;
                    State<Color> state5 = state;
                    long sliderEnd4 = sliderEnd2;
                    DrawScope.m2482drawPointsF8ZwMP8$default(Canvas, (List) destination$iv$iv2, PointMode.INSTANCE.m2262getPointsr_lszbg(), (outsideFraction ? state5 : state4).getValue().m2006unboximpl(), f3, StrokeCap.INSTANCE.m2301getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                    f3 = f3;
                    state2 = state4;
                    state = state5;
                    isRtl = isRtl2;
                    sliderStart2 = sliderStart4;
                    sliderEnd2 = sliderEnd4;
                }
            }
        }, $composer2, $changed & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$Track$2
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
                SliderKt.Track(Modifier.this, colors, enabled, positionFractionStart, positionFractionEnd, list, thumbPx, trackStrokeWidth, composer, $changed | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float snapValueToTick(float current, List<Float> list, float minPx, float maxPx) {
        Object minElem$iv;
        List<Float> $this$minByOrNull$iv = list;
        Iterator iterator$iv = $this$minByOrNull$iv.iterator();
        if (iterator$iv.hasNext()) {
            minElem$iv = iterator$iv.next();
            if (iterator$iv.hasNext()) {
                float it = ((Number) minElem$iv).floatValue();
                float minValue$iv = Math.abs(MathHelpersKt.lerp(minPx, maxPx, it) - current);
                do {
                    Object e$iv = iterator$iv.next();
                    float it2 = ((Number) e$iv).floatValue();
                    float v$iv = Math.abs(MathHelpersKt.lerp(minPx, maxPx, it2) - current);
                    if (Float.compare(minValue$iv, v$iv) > 0) {
                        minElem$iv = e$iv;
                        minValue$iv = v$iv;
                    }
                } while (iterator$iv.hasNext());
            }
        } else {
            minElem$iv = null;
        }
        Object minElem$iv2 = (Float) minElem$iv;
        if (minElem$iv2 == null) {
            return current;
        }
        float $this$snapValueToTick_u24lambda_u2d17 = ((Number) minElem$iv2).floatValue();
        return MathHelpersKt.lerp(minPx, maxPx, $this$snapValueToTick_u24lambda_u2d17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0066 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: awaitSlop-8vUncbI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m1492awaitSlop8vUncbI(AwaitPointerEventScope $this$awaitSlop_u2d8vUncbI, long id, int type, Continuation<? super Pair<PointerInputChange, Float>> continuation) {
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$1;
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$12;
        final Ref.FloatRef initialDelta;
        Object m1358awaitHorizontalPointerSlopOrCancellationgDDlDlE;
        PointerInputChange afterSlopResult;
        if (continuation instanceof SliderKt$awaitSlop$1) {
            sliderKt$awaitSlop$1 = (SliderKt$awaitSlop$1) continuation;
            if ((sliderKt$awaitSlop$1.label & Integer.MIN_VALUE) != 0) {
                sliderKt$awaitSlop$1.label -= Integer.MIN_VALUE;
                sliderKt$awaitSlop$12 = sliderKt$awaitSlop$1;
                Object $result = sliderKt$awaitSlop$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (sliderKt$awaitSlop$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        initialDelta = new Ref.FloatRef();
                        Function2 postPointerSlop = new Function2<PointerInputChange, Float, Unit>() { // from class: androidx.compose.material.SliderKt$awaitSlop$postPointerSlop$1
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Float f) {
                                invoke(pointerInputChange, f.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(PointerInputChange pointerInput, float offset) {
                                Intrinsics.checkNotNullParameter(pointerInput, "pointerInput");
                                pointerInput.consume();
                                Ref.FloatRef.this.element = offset;
                            }
                        };
                        sliderKt$awaitSlop$12.L$0 = initialDelta;
                        sliderKt$awaitSlop$12.label = 1;
                        m1358awaitHorizontalPointerSlopOrCancellationgDDlDlE = DragGestureDetectorCopyKt.m1358awaitHorizontalPointerSlopOrCancellationgDDlDlE($this$awaitSlop_u2d8vUncbI, id, type, postPointerSlop, sliderKt$awaitSlop$12);
                        if (m1358awaitHorizontalPointerSlopOrCancellationgDDlDlE == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        initialDelta = (Ref.FloatRef) sliderKt$awaitSlop$12.L$0;
                        ResultKt.throwOnFailure($result);
                        m1358awaitHorizontalPointerSlopOrCancellationgDDlDlE = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                afterSlopResult = (PointerInputChange) m1358awaitHorizontalPointerSlopOrCancellationgDDlDlE;
                if (afterSlopResult == null) {
                    return TuplesKt.m294to(afterSlopResult, Boxing.boxFloat(initialDelta.element));
                }
                return null;
            }
        }
        sliderKt$awaitSlop$1 = new SliderKt$awaitSlop$1(continuation);
        sliderKt$awaitSlop$12 = sliderKt$awaitSlop$1;
        Object $result2 = sliderKt$awaitSlop$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (sliderKt$awaitSlop$12.label) {
        }
        afterSlopResult = (PointerInputChange) m1358awaitHorizontalPointerSlopOrCancellationgDDlDlE;
        if (afterSlopResult == null) {
        }
    }

    private static final List<Float> stepsToTickFractions(int steps) {
        if (steps == 0) {
            return CollectionsKt.emptyList();
        }
        int i = steps + 2;
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            int it = i2;
            arrayList.add(Float.valueOf(it / (steps + 1)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float scale(float a1, float b1, float x1, float a2, float b2) {
        return MathHelpersKt.lerp(a2, b2, calcFraction(a1, b1, x1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> scale(float a1, float b1, ClosedFloatingPointRange<Float> closedFloatingPointRange, float a2, float b2) {
        return RangesKt.rangeTo(scale(a1, b1, closedFloatingPointRange.getStart().floatValue(), a2, b2), scale(a1, b1, closedFloatingPointRange.getEndInclusive().floatValue(), a2, b2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calcFraction(float a, float b, float pos) {
        return RangesKt.coerceIn(((b - a) > 0.0f ? 1 : ((b - a) == 0.0f ? 0 : -1)) == 0 ? 0.0f : (pos - a) / (b - a), 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CorrectValueSideEffect(final Function1<? super Float, Float> function1, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final ClosedFloatingPointRange<Float> closedFloatingPointRange2, final MutableState<Float> mutableState, final float value, Composer $composer, final int $changed) {
        int i;
        Composer $composer2 = $composer.startRestartGroup(-743965752);
        ComposerKt.sourceInformation($composer2, "C(CorrectValueSideEffect)P(!1,3!1,4)838@33163L300,838@33152L311:Slider.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(function1) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(closedFloatingPointRange) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(closedFloatingPointRange2) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(mutableState) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changed(value) ? 16384 : 8192;
        }
        if ((46811 & $dirty) != 9362 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-743965752, $changed, -1, "androidx.compose.material.CorrectValueSideEffect (Slider.kt:831)");
            }
            Object[] keys$iv = {closedFloatingPointRange, function1, Float.valueOf(value), mutableState, closedFloatingPointRange2};
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : keys$iv) {
                invalid$iv |= $composer2.changed(key$iv);
            }
            Object value$iv$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
                i = 0;
                value$iv$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.SliderKt$CorrectValueSideEffect$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        float error = (closedFloatingPointRange.getEndInclusive().floatValue() - closedFloatingPointRange.getStart().floatValue()) / 1000;
                        float newOffset = function1.invoke(Float.valueOf(value)).floatValue();
                        if (Math.abs(newOffset - mutableState.getValue().floatValue()) > error && closedFloatingPointRange2.contains(mutableState.getValue())) {
                            mutableState.setValue(Float.valueOf(newOffset));
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                i = 0;
            }
            $composer2.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) value$iv$iv, $composer2, i);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$CorrectValueSideEffect$2
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

            public final void invoke(Composer composer, int i2) {
                SliderKt.CorrectValueSideEffect(function1, closedFloatingPointRange, closedFloatingPointRange2, mutableState, value, composer, $changed | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier sliderSemantics(Modifier $this$sliderSemantics, float value, final boolean enabled, final Function1<? super Float, Unit> function1, final Function0<Unit> function0, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final int steps) {
        final float coerced = RangesKt.coerceIn(value, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default($this$sliderSemantics, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt$sliderSemantics$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semantics) {
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                if (!enabled) {
                    SemanticsPropertiesKt.disabled(semantics);
                }
                final ClosedFloatingPointRange<Float> closedFloatingPointRange2 = closedFloatingPointRange;
                final int i = steps;
                final float f = coerced;
                final Function1<Float, Unit> function12 = function1;
                final Function0<Unit> function02 = function0;
                SemanticsPropertiesKt.setProgress$default(semantics, null, new Function1<Float, Boolean>() { // from class: androidx.compose.material.SliderKt$sliderSemantics$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Float f2) {
                        return invoke(f2.floatValue());
                    }

                    public final Boolean invoke(float targetValue) {
                        float newValue = RangesKt.coerceIn(targetValue, closedFloatingPointRange2.getStart().floatValue(), closedFloatingPointRange2.getEndInclusive().floatValue());
                        boolean z = true;
                        if (i > 0) {
                            float distance = newValue;
                            int i2 = 0;
                            int i3 = i + 1;
                            if (0 <= i3) {
                                while (true) {
                                    float stepValue = MathHelpersKt.lerp(closedFloatingPointRange2.getStart().floatValue(), closedFloatingPointRange2.getEndInclusive().floatValue(), i2 / (i + 1));
                                    if (Math.abs(stepValue - newValue) <= distance) {
                                        distance = Math.abs(stepValue - newValue);
                                        newValue = stepValue;
                                    }
                                    if (i2 == i3) {
                                        break;
                                    }
                                    i2++;
                                }
                            }
                        }
                        float resolvedValue = newValue;
                        if (resolvedValue == f) {
                            z = false;
                        } else {
                            function12.invoke(Float.valueOf(resolvedValue));
                            Function0<Unit> function03 = function02;
                            if (function03 != null) {
                                function03.invoke();
                            }
                        }
                        return Boolean.valueOf(z);
                    }
                }, 1, null);
            }
        }, 1, null), value, closedFloatingPointRange, steps);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier sliderTapModifier(Modifier $this$sliderTapModifier, final DraggableState draggableState, final MutableInteractionSource interactionSource, final float maxPx, final boolean isRtl, final State<Float> state, final State<? extends Function1<? super Float, Unit>> state2, final MutableState<Float> mutableState, final boolean enabled) {
        return ComposedModifierKt.composed($this$sliderTapModifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("sliderTapModifier");
                $this$null.getProperties().set("draggableState", DraggableState.this);
                $this$null.getProperties().set("interactionSource", interactionSource);
                $this$null.getProperties().set("maxPx", Float.valueOf(maxPx));
                $this$null.getProperties().set("isRtl", Boolean.valueOf(isRtl));
                $this$null.getProperties().set("rawOffset", state);
                $this$null.getProperties().set("gestureEndAction", state2);
                $this$null.getProperties().set("pressOffset", mutableState);
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material.SliderKt$sliderTapModifier$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Modifier modifier;
                Object value$iv$iv$iv;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(1945228890);
                ComposerKt.sourceInformation($composer, "C906@35562L24:Slider.kt#jmzs0o");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1945228890, $changed, -1, "androidx.compose.material.sliderTapModifier.<anonymous> (Slider.kt:904)");
                }
                if (enabled) {
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
                    modifier = SuspendingPointerInputFilterKt.pointerInput(composed, new Object[]{draggableState, interactionSource, Float.valueOf(maxPx), Boolean.valueOf(isRtl)}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new C03521(isRtl, maxPx, mutableState, state, scope, draggableState, state2, null));
                } else {
                    modifier = composed;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return modifier;
            }

            /* compiled from: Slider.kt */
            @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            @DebugMetadata(m296c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1", m297f = "Slider.kt", m298i = {}, m299l = {909}, m300m = "invokeSuspend", m301n = {}, m302s = {})
            /* renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1 */
            static final class C03521 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ DraggableState $draggableState;
                final /* synthetic */ State<Function1<Float, Unit>> $gestureEndAction;
                final /* synthetic */ boolean $isRtl;
                final /* synthetic */ float $maxPx;
                final /* synthetic */ MutableState<Float> $pressOffset;
                final /* synthetic */ State<Float> $rawOffset;
                final /* synthetic */ CoroutineScope $scope;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C03521(boolean z, float f, MutableState<Float> mutableState, State<Float> state, CoroutineScope coroutineScope, DraggableState draggableState, State<? extends Function1<? super Float, Unit>> state2, Continuation<? super C03521> continuation) {
                    super(2, continuation);
                    this.$isRtl = z;
                    this.$maxPx = f;
                    this.$pressOffset = mutableState;
                    this.$rawOffset = state;
                    this.$scope = coroutineScope;
                    this.$draggableState = draggableState;
                    this.$gestureEndAction = state2;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C03521 c03521 = new C03521(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, this.$scope, this.$draggableState, this.$gestureEndAction, continuation);
                    c03521.L$0 = obj;
                    return c03521;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                    return ((C03521) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* compiled from: Slider.kt */
                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                @DebugMetadata(m296c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$1", m297f = "Slider.kt", m298i = {}, m299l = {914}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                /* renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                    final /* synthetic */ boolean $isRtl;
                    final /* synthetic */ float $maxPx;
                    final /* synthetic */ MutableState<Float> $pressOffset;
                    final /* synthetic */ State<Float> $rawOffset;
                    /* synthetic */ long J$0;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(boolean z, float f, MutableState<Float> mutableState, State<Float> state, Continuation<? super AnonymousClass1> continuation) {
                        super(3, continuation);
                        this.$isRtl = z;
                        this.$maxPx = f;
                        this.$pressOffset = mutableState;
                        this.$rawOffset = state;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                        return m1493invoked4ec7I(pressGestureScope, offset.getPackedValue(), continuation);
                    }

                    /* renamed from: invoke-d-4ec7I, reason: not valid java name */
                    public final Object m1493invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, continuation);
                        anonymousClass1.L$0 = pressGestureScope;
                        anonymousClass1.J$0 = j;
                        return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) {
                        AnonymousClass1 anonymousClass1;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                PressGestureScope $this$detectTapGestures = (PressGestureScope) this.L$0;
                                long pos = this.J$0;
                                float to = this.$isRtl ? this.$maxPx - Offset.m1760getXimpl(pos) : Offset.m1760getXimpl(pos);
                                this.$pressOffset.setValue(Boxing.boxFloat(to - this.$rawOffset.getValue().floatValue()));
                                try {
                                    this.label = 1;
                                } catch (GestureCancellationException e) {
                                    anonymousClass1 = this;
                                    anonymousClass1.$pressOffset.setValue(Boxing.boxFloat(0.0f));
                                }
                                return $this$detectTapGestures.awaitRelease(this) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                            case 1:
                                anonymousClass1 = this;
                                try {
                                    ResultKt.throwOnFailure($result);
                                } catch (GestureCancellationException e2) {
                                    anonymousClass1.$pressOffset.setValue(Boxing.boxFloat(0.0f));
                                }
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object detectTapGestures;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, null);
                            final CoroutineScope coroutineScope = this.$scope;
                            final DraggableState draggableState = this.$draggableState;
                            final State<Function1<Float, Unit>> state = this.$gestureEndAction;
                            Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.material.SliderKt.sliderTapModifier.2.1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                    m1494invokek4lQ0M(offset.getPackedValue());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                                public final void m1494invokek4lQ0M(long it) {
                                    BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(draggableState, state, null), 3, null);
                                }

                                /* compiled from: Slider.kt */
                                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                @DebugMetadata(m296c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1", m297f = "Slider.kt", m298i = {}, m299l = {921}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                /* renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1, reason: invalid class name */
                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ DraggableState $draggableState;
                                    final /* synthetic */ State<Function1<Float, Unit>> $gestureEndAction;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    AnonymousClass1(DraggableState draggableState, State<? extends Function1<? super Float, Unit>> state, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$draggableState = draggableState;
                                        this.$gestureEndAction = state;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$draggableState, this.$gestureEndAction, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    /* compiled from: Slider.kt */
                                    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                                    @DebugMetadata(m296c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1$1", m297f = "Slider.kt", m298i = {}, m299l = {}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                                    /* renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1$1, reason: invalid class name and collision with other inner class name */
                                    static final class C16771 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
                                        private /* synthetic */ Object L$0;
                                        int label;

                                        C16771(Continuation<? super C16771> continuation) {
                                            super(2, continuation);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            C16771 c16771 = new C16771(continuation);
                                            c16771.L$0 = obj;
                                            return c16771;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
                                            return ((C16771) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch (this.label) {
                                                case 0:
                                                    ResultKt.throwOnFailure(obj);
                                                    DragScope $this$drag = (DragScope) this.L$0;
                                                    $this$drag.dragBy(0.0f);
                                                    return Unit.INSTANCE;
                                                default:
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                        }
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object $result) {
                                        AnonymousClass1 anonymousClass1;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                this.label = 1;
                                                if (this.$draggableState.drag(MutatePriority.UserInput, new C16771(null), this) != coroutine_suspended) {
                                                    anonymousClass1 = this;
                                                    break;
                                                } else {
                                                    return coroutine_suspended;
                                                }
                                            case 1:
                                                anonymousClass1 = this;
                                                ResultKt.throwOnFailure($result);
                                                break;
                                            default:
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        anonymousClass1.$gestureEndAction.getValue().invoke(Boxing.boxFloat(0.0f));
                                        return Unit.INSTANCE;
                                    }
                                }
                            };
                            this.label = 1;
                            detectTapGestures = TapGestureDetectorKt.detectTapGestures($this$pointerInput, (r13 & 1) != 0 ? null : null, (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? TapGestureDetectorKt.NoPressGesture : anonymousClass1, (r13 & 8) != 0 ? null : function1, this);
                            if (detectTapGestures != coroutine_suspended) {
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        case 1:
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object animateToTarget(DraggableState draggableState, float current, float target, float velocity, Continuation<? super Unit> continuation) {
        Object drag$default = DraggableState.drag$default(draggableState, null, new SliderKt$animateToTarget$2(current, target, velocity, null), continuation, 1, null);
        return drag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? drag$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier rangeSliderPressDragModifier(Modifier $this$rangeSliderPressDragModifier, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, State<Float> state, State<Float> state2, boolean enabled, boolean isRtl, float maxPx, ClosedFloatingPointRange<Float> closedFloatingPointRange, State<? extends Function1<? super Boolean, Unit>> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4) {
        if (enabled) {
            return SuspendingPointerInputFilterKt.pointerInput($this$rangeSliderPressDragModifier, new Object[]{startInteractionSource, endInteractionSource, Float.valueOf(maxPx), Boolean.valueOf(isRtl), closedFloatingPointRange}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SliderKt$rangeSliderPressDragModifier$1(startInteractionSource, endInteractionSource, state, state2, state4, isRtl, maxPx, state3, null));
        }
        return $this$rangeSliderPressDragModifier;
    }

    public static final float getThumbRadius() {
        return ThumbRadius;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }
}
