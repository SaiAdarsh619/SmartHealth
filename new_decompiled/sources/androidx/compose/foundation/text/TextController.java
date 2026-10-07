package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate;
import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.DrawModifierKt;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.graphics.Canvas;
import androidx.compose.p000ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p000ui.graphics.Path;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.input.pointer.PointerIconKt;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p000ui.layout.AlignmentLineKt;
import androidx.compose.p000ui.layout.IntrinsicMeasurable;
import androidx.compose.p000ui.layout.IntrinsicMeasureScope;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.LayoutCoordinatesKt;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.text.AnnotatedString;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.IntOffsetKt;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.runtime.RememberObserver;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: CoreText.kt */
@Metadata(m286d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020 H\u0016J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J\u000e\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020 2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\f\u0010.\u001a\u00020\u0006*\u00020\u0006H\u0003R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006/"}, m287d2 = {"Landroidx/compose/foundation/text/TextController;", "Landroidx/compose/runtime/RememberObserver;", "state", "Landroidx/compose/foundation/text/TextState;", "(Landroidx/compose/foundation/text/TextState;)V", "coreModifiers", "Landroidx/compose/ui/Modifier;", "longPressDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getLongPressDragObserver", "()Landroidx/compose/foundation/text/TextDragObserver;", "setLongPressDragObserver", "(Landroidx/compose/foundation/text/TextDragObserver;)V", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "modifiers", "getModifiers", "()Landroidx/compose/ui/Modifier;", "selectionModifiers", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "<set-?>", "semanticsModifier", "getSemanticsModifier$foundation_release", "getState", "()Landroidx/compose/foundation/text/TextState;", "createSemanticsModifierFor", "text", "Landroidx/compose/ui/text/AnnotatedString;", "onAbandoned", "", "onForgotten", "onRemembered", "outOfBoundary", "", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "outOfBoundary-0a9Yr6o", "(JJ)Z", "setTextDelegate", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "update", "drawTextAndSelectionBehind", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TextController implements RememberObserver {
    private final Modifier coreModifiers;
    public TextDragObserver longPressDragObserver;
    private final MeasurePolicy measurePolicy;
    private Modifier selectionModifiers;
    private SelectionRegistrar selectionRegistrar;
    private Modifier semanticsModifier;
    private final TextState state;

    public TextController(TextState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
        this.measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.TextController$measurePolicy$1
            /* JADX WARN: Code restructure failed: missing block: B:7:0x0060, code lost:
            
                r10 = r5.selectionRegistrar;
             */
            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public MeasureResult mo331measure3p2s80s(MeasureScope measure, List<? extends Measurable> list, long constraints) {
                List $this$fastMapIndexedNotNull$iv;
                TextLayoutResult prevLayout;
                Pair pair;
                SelectionRegistrar selectionRegistrar;
                List<? extends Measurable> measurables = list;
                Intrinsics.checkNotNullParameter(measure, "$this$measure");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                TextLayoutResult prevLayout2 = TextController.this.getState().getLayoutResult();
                TextLayoutResult layoutResult = TextController.this.getState().getTextDelegate().m1083layoutNN6EwU(constraints, measure.getLayoutDirection(), prevLayout2);
                if (!Intrinsics.areEqual(prevLayout2, layoutResult)) {
                    TextController.this.getState().getOnTextLayout().invoke(layoutResult);
                    if (prevLayout2 != null) {
                        TextController textController = TextController.this;
                        if (!Intrinsics.areEqual(prevLayout2.getLayoutInput().getText(), layoutResult.getLayoutInput().getText()) && selectionRegistrar != null) {
                            selectionRegistrar.notifySelectableChange(textController.getState().getSelectableId());
                        }
                    }
                }
                TextController.this.getState().setLayoutResult(layoutResult);
                if (!(list.size() >= layoutResult.getPlaceholderRects().size())) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                List $this$fastMapIndexedNotNull$iv2 = layoutResult.getPlaceholderRects();
                List target$iv = new ArrayList($this$fastMapIndexedNotNull$iv2.size());
                int index$iv$iv = 0;
                int size = $this$fastMapIndexedNotNull$iv2.size();
                while (index$iv$iv < size) {
                    Object item$iv$iv = $this$fastMapIndexedNotNull$iv2.get(index$iv$iv);
                    int index$iv = index$iv$iv;
                    Rect rect = (Rect) item$iv$iv;
                    if (rect != null) {
                        prevLayout = prevLayout2;
                        $this$fastMapIndexedNotNull$iv = $this$fastMapIndexedNotNull$iv2;
                        pair = new Pair(measurables.get(index$iv).mo3492measureBRTryo0(ConstraintsKt.Constraints$default(0, (int) Math.floor(rect.getWidth()), 0, (int) Math.floor(rect.getHeight()), 5, null)), IntOffset.m4491boximpl(IntOffsetKt.IntOffset(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()))));
                    } else {
                        $this$fastMapIndexedNotNull$iv = $this$fastMapIndexedNotNull$iv2;
                        prevLayout = prevLayout2;
                        pair = null;
                    }
                    if (pair != null) {
                        target$iv.add(pair);
                    }
                    index$iv$iv++;
                    measurables = list;
                    $this$fastMapIndexedNotNull$iv2 = $this$fastMapIndexedNotNull$iv;
                    prevLayout2 = prevLayout;
                }
                final List placeables = target$iv;
                return measure.layout(IntSize.m4542getWidthimpl(layoutResult.getSize()), IntSize.m4541getHeightimpl(layoutResult.getSize()), MapsKt.mapOf(TuplesKt.m294to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(layoutResult.getFirstBaseline()))), TuplesKt.m294to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(layoutResult.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.TextController$measurePolicy$1$measure$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope layout) {
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        List $this$fastForEach$iv = placeables;
                        int size2 = $this$fastForEach$iv.size();
                        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                            Object item$iv = $this$fastForEach$iv.get(index$iv2);
                            Pair<Placeable, IntOffset> pair2 = (Pair) item$iv;
                            Placeable placeable = pair2.component1();
                            long position = pair2.component2().getPackedValue();
                            Placeable.PlacementScope.m3540place70tqf50$default(layout, placeable, position, 0.0f, 2, null);
                        }
                    }
                });
            }

            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
                Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                TextController.this.getState().getTextDelegate().layoutIntrinsics($this$minIntrinsicWidth.getLayoutDirection());
                return TextController.this.getState().getTextDelegate().getMinIntrinsicWidth();
            }

            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
                Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return IntSize.m4541getHeightimpl(TextDelegate.m1080layoutNN6EwU$default(TextController.this.getState().getTextDelegate(), ConstraintsKt.Constraints(0, width, 0, Integer.MAX_VALUE), $this$minIntrinsicHeight.getLayoutDirection(), null, 4, null).getSize());
            }

            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
                Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                TextController.this.getState().getTextDelegate().layoutIntrinsics($this$maxIntrinsicWidth.getLayoutDirection());
                return TextController.this.getState().getTextDelegate().getMaxIntrinsicWidth();
            }

            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
                Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return IntSize.m4541getHeightimpl(TextDelegate.m1080layoutNN6EwU$default(TextController.this.getState().getTextDelegate(), ConstraintsKt.Constraints(0, width, 0, Integer.MAX_VALUE), $this$maxIntrinsicHeight.getLayoutDirection(), null, 4, null).getSize());
            }
        };
        this.coreModifiers = OnGloballyPositionedModifierKt.onGloballyPositioned(drawTextAndSelectionBehind(Modifier.INSTANCE), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.TextController$coreModifiers$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x0039, code lost:
            
                r2 = r5.this$0.selectionRegistrar;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(LayoutCoordinates it) {
                SelectionRegistrar selectionRegistrar;
                SelectionRegistrar selectionRegistrar2;
                Intrinsics.checkNotNullParameter(it, "it");
                TextController.this.getState().setLayoutCoordinates(it);
                selectionRegistrar = TextController.this.selectionRegistrar;
                if (SelectionRegistrarKt.hasSelection(selectionRegistrar, TextController.this.getState().getSelectableId())) {
                    long newGlobalPosition = LayoutCoordinatesKt.positionInWindow(it);
                    if (!Offset.m1757equalsimpl0(newGlobalPosition, TextController.this.getState().getPreviousGlobalPosition()) && selectionRegistrar2 != null) {
                        selectionRegistrar2.notifyPositionChange(TextController.this.getState().getSelectableId());
                    }
                    TextController.this.getState().m1118setPreviousGlobalPositionk4lQ0M(newGlobalPosition);
                }
            }
        });
        this.semanticsModifier = createSemanticsModifierFor(this.state.getTextDelegate().getText());
        this.selectionModifiers = Modifier.INSTANCE;
    }

    public final TextState getState() {
        return this.state;
    }

    public final TextDragObserver getLongPressDragObserver() {
        TextDragObserver textDragObserver = this.longPressDragObserver;
        if (textDragObserver != null) {
            return textDragObserver;
        }
        Intrinsics.throwUninitializedPropertyAccessException("longPressDragObserver");
        return null;
    }

    public final void setLongPressDragObserver(TextDragObserver textDragObserver) {
        Intrinsics.checkNotNullParameter(textDragObserver, "<set-?>");
        this.longPressDragObserver = textDragObserver;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.compose.foundation.text.TextController$update$mouseSelectionObserver$1, java.lang.Object] */
    public final void update(final SelectionRegistrar selectionRegistrar) {
        Modifier.Companion companion;
        this.selectionRegistrar = selectionRegistrar;
        if (selectionRegistrar != null) {
            if (TouchMode_androidKt.isInTouchMode()) {
                setLongPressDragObserver(new TextDragObserver() { // from class: androidx.compose.foundation.text.TextController$update$1
                    private long lastPosition = Offset.INSTANCE.m1776getZeroF1C5BW0();
                    private long dragTotalDistance = Offset.INSTANCE.m1776getZeroF1C5BW0();

                    public final long getLastPosition() {
                        return this.lastPosition;
                    }

                    public final void setLastPosition(long j) {
                        this.lastPosition = j;
                    }

                    public final long getDragTotalDistance() {
                        return this.dragTotalDistance;
                    }

                    public final void setDragTotalDistance(long j) {
                        this.dragTotalDistance = j;
                    }

                    @Override // androidx.compose.foundation.text.TextDragObserver
                    /* renamed from: onDown-k-4lQ0M, reason: not valid java name */
                    public void mo1073onDownk4lQ0M(long point) {
                    }

                    @Override // androidx.compose.foundation.text.TextDragObserver
                    public void onUp() {
                    }

                    @Override // androidx.compose.foundation.text.TextDragObserver
                    /* renamed from: onStart-k-4lQ0M, reason: not valid java name */
                    public void mo1075onStartk4lQ0M(long startPoint) {
                        boolean m1072outOfBoundary0a9Yr6o;
                        LayoutCoordinates it = TextController.this.getState().getLayoutCoordinates();
                        if (it != null) {
                            TextController textController = TextController.this;
                            SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                            if (!it.isAttached()) {
                                return;
                            }
                            m1072outOfBoundary0a9Yr6o = textController.m1072outOfBoundary0a9Yr6o(startPoint, startPoint);
                            if (m1072outOfBoundary0a9Yr6o) {
                                selectionRegistrar2.notifySelectionUpdateSelectAll(textController.getState().getSelectableId());
                            } else {
                                selectionRegistrar2.mo1197notifySelectionUpdateStartd4ec7I(it, startPoint, SelectionAdjustment.INSTANCE.getWord());
                            }
                            this.lastPosition = startPoint;
                        }
                        if (SelectionRegistrarKt.hasSelection(selectionRegistrar, TextController.this.getState().getSelectableId())) {
                            this.dragTotalDistance = Offset.INSTANCE.m1776getZeroF1C5BW0();
                        }
                    }

                    @Override // androidx.compose.foundation.text.TextDragObserver
                    /* renamed from: onDrag-k-4lQ0M, reason: not valid java name */
                    public void mo1074onDragk4lQ0M(long delta) {
                        boolean m1072outOfBoundary0a9Yr6o;
                        LayoutCoordinates it = TextController.this.getState().getLayoutCoordinates();
                        if (it != null) {
                            SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                            TextController textController = TextController.this;
                            if (it.isAttached() && SelectionRegistrarKt.hasSelection(selectionRegistrar2, textController.getState().getSelectableId())) {
                                this.dragTotalDistance = Offset.m1765plusMKHz9U(this.dragTotalDistance, delta);
                                long newPosition = Offset.m1765plusMKHz9U(this.lastPosition, this.dragTotalDistance);
                                m1072outOfBoundary0a9Yr6o = textController.m1072outOfBoundary0a9Yr6o(this.lastPosition, newPosition);
                                if (!m1072outOfBoundary0a9Yr6o) {
                                    boolean consumed = selectionRegistrar2.mo1196notifySelectionUpdate5iVPX68(it, newPosition, this.lastPosition, false, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate());
                                    if (consumed) {
                                        this.lastPosition = newPosition;
                                        this.dragTotalDistance = Offset.INSTANCE.m1776getZeroF1C5BW0();
                                    }
                                }
                            }
                        }
                    }

                    @Override // androidx.compose.foundation.text.TextDragObserver
                    public void onStop() {
                        if (SelectionRegistrarKt.hasSelection(selectionRegistrar, TextController.this.getState().getSelectableId())) {
                            selectionRegistrar.notifySelectionUpdateEnd();
                        }
                    }

                    @Override // androidx.compose.foundation.text.TextDragObserver
                    public void onCancel() {
                        if (SelectionRegistrarKt.hasSelection(selectionRegistrar, TextController.this.getState().getSelectableId())) {
                            selectionRegistrar.notifySelectionUpdateEnd();
                        }
                    }
                });
                companion = SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, getLongPressDragObserver(), new TextController$update$2(this, null));
            } else {
                ?? r0 = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.TextController$update$mouseSelectionObserver$1
                    private long lastPosition = Offset.INSTANCE.m1776getZeroF1C5BW0();

                    public final long getLastPosition() {
                        return this.lastPosition;
                    }

                    public final void setLastPosition(long j) {
                        this.lastPosition = j;
                    }

                    @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
                    /* renamed from: onExtend-k-4lQ0M, reason: not valid java name */
                    public boolean mo1077onExtendk4lQ0M(long downPosition) {
                        LayoutCoordinates layoutCoordinates = TextController.this.getState().getLayoutCoordinates();
                        if (layoutCoordinates == null) {
                            return false;
                        }
                        SelectionRegistrar it = selectionRegistrar;
                        TextController textController = TextController.this;
                        if (!layoutCoordinates.isAttached()) {
                            return false;
                        }
                        boolean consumed = it.mo1196notifySelectionUpdate5iVPX68(layoutCoordinates, downPosition, this.lastPosition, false, SelectionAdjustment.INSTANCE.getNone());
                        if (consumed) {
                            this.lastPosition = downPosition;
                        }
                        return SelectionRegistrarKt.hasSelection(it, textController.getState().getSelectableId());
                    }

                    @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
                    /* renamed from: onExtendDrag-k-4lQ0M, reason: not valid java name */
                    public boolean mo1078onExtendDragk4lQ0M(long dragPosition) {
                        LayoutCoordinates layoutCoordinates = TextController.this.getState().getLayoutCoordinates();
                        if (layoutCoordinates != null) {
                            SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                            TextController textController = TextController.this;
                            if (!layoutCoordinates.isAttached() || !SelectionRegistrarKt.hasSelection(selectionRegistrar2, textController.getState().getSelectableId())) {
                                return false;
                            }
                            boolean consumed = selectionRegistrar2.mo1196notifySelectionUpdate5iVPX68(layoutCoordinates, dragPosition, this.lastPosition, false, SelectionAdjustment.INSTANCE.getNone());
                            if (consumed) {
                                this.lastPosition = dragPosition;
                                return true;
                            }
                            return true;
                        }
                        return true;
                    }

                    @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
                    /* renamed from: onStart-3MmeM6k, reason: not valid java name */
                    public boolean mo1079onStart3MmeM6k(long downPosition, SelectionAdjustment adjustment) {
                        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
                        LayoutCoordinates it = TextController.this.getState().getLayoutCoordinates();
                        if (it == null) {
                            return false;
                        }
                        SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                        TextController textController = TextController.this;
                        if (!it.isAttached()) {
                            return false;
                        }
                        selectionRegistrar2.mo1197notifySelectionUpdateStartd4ec7I(it, downPosition, adjustment);
                        this.lastPosition = downPosition;
                        return SelectionRegistrarKt.hasSelection(selectionRegistrar2, textController.getState().getSelectableId());
                    }

                    @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
                    /* renamed from: onDrag-3MmeM6k, reason: not valid java name */
                    public boolean mo1076onDrag3MmeM6k(long dragPosition, SelectionAdjustment adjustment) {
                        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
                        LayoutCoordinates it = TextController.this.getState().getLayoutCoordinates();
                        if (it != null) {
                            SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                            TextController textController = TextController.this;
                            if (!it.isAttached() || !SelectionRegistrarKt.hasSelection(selectionRegistrar2, textController.getState().getSelectableId())) {
                                return false;
                            }
                            boolean consumed = selectionRegistrar2.mo1196notifySelectionUpdate5iVPX68(it, dragPosition, this.lastPosition, false, adjustment);
                            if (consumed) {
                                this.lastPosition = dragPosition;
                            }
                        }
                        return true;
                    }
                };
                companion = PointerIconKt.pointerHoverIcon$default(SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, (Object) r0, new TextController$update$3(r0, null)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
            }
        } else {
            companion = Modifier.INSTANCE;
        }
        this.selectionModifiers = companion;
    }

    public final void setTextDelegate(TextDelegate textDelegate) {
        Intrinsics.checkNotNullParameter(textDelegate, "textDelegate");
        if (this.state.getTextDelegate() == textDelegate) {
            return;
        }
        this.state.setTextDelegate(textDelegate);
        this.semanticsModifier = createSemanticsModifierFor(this.state.getTextDelegate().getText());
    }

    public final MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: outOfBoundary-0a9Yr6o, reason: not valid java name */
    public final boolean m1072outOfBoundary0a9Yr6o(long start, long end) {
        TextLayoutResult it = this.state.getLayoutResult();
        if (it == null) {
            return false;
        }
        int lastOffset = it.getLayoutInput().getText().getText().length();
        int rawStartOffset = it.m3932getOffsetForPositionk4lQ0M(start);
        int rawEndOffset = it.m3932getOffsetForPositionk4lQ0M(end);
        return (rawStartOffset >= lastOffset + (-1) && rawEndOffset >= lastOffset + (-1)) || (rawStartOffset < 0 && rawEndOffset < 0);
    }

    private final Modifier drawTextAndSelectionBehind(Modifier $this$drawTextAndSelectionBehind) {
        return DrawModifierKt.drawBehind(GraphicsLayerModifierKt.m2133graphicsLayerpANQ8Wg$default($this$drawTextAndSelectionBehind, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, SupportMenu.USER_MASK, null), new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.TextController$drawTextAndSelectionBehind$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawBehind) {
                SelectionRegistrar selectionRegistrar;
                int offset;
                int offset2;
                Map<Long, Selection> subselections;
                Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
                TextLayoutResult it = TextController.this.getState().getLayoutResult();
                if (it != null) {
                    TextController textController = TextController.this;
                    textController.getState().getDrawScopeInvalidation();
                    selectionRegistrar = textController.selectionRegistrar;
                    Selection selection = (selectionRegistrar == null || (subselections = selectionRegistrar.getSubselections()) == null) ? null : subselections.get(Long.valueOf(textController.getState().getSelectableId()));
                    if (selection != null) {
                        if (!selection.getHandlesCrossed()) {
                            offset = selection.getStart().getOffset();
                        } else {
                            offset = selection.getEnd().getOffset();
                        }
                        int start = offset;
                        if (!selection.getHandlesCrossed()) {
                            offset2 = selection.getEnd().getOffset();
                        } else {
                            offset2 = selection.getStart().getOffset();
                        }
                        int end = offset2;
                        if (start != end) {
                            Path selectionPath = it.getMultiParagraph().getPathForRange(start, end);
                            DrawScope.m2481drawPathLG529CI$default(drawBehind, selectionPath, textController.getState().getSelectionBackgroundColor(), 0.0f, null, null, 0, 60, null);
                        }
                    }
                    Canvas canvas = drawBehind.getDrawContext().getCanvas();
                    TextDelegate.INSTANCE.paint(canvas, it);
                }
            }
        });
    }

    /* renamed from: getSemanticsModifier$foundation_release, reason: from getter */
    public final Modifier getSemanticsModifier() {
        return this.semanticsModifier;
    }

    private final Modifier createSemanticsModifierFor(final AnnotatedString text) {
        return SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.TextController$createSemanticsModifierFor$1
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
                SemanticsPropertiesKt.setText(semantics, AnnotatedString.this);
                final TextController textController = this;
                SemanticsPropertiesKt.getTextLayoutResult$default(semantics, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.TextController$createSemanticsModifierFor$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(List<TextLayoutResult> it) {
                        boolean z;
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (TextController.this.getState().getLayoutResult() != null) {
                            TextLayoutResult layoutResult = TextController.this.getState().getLayoutResult();
                            Intrinsics.checkNotNull(layoutResult);
                            it.add(layoutResult);
                            z = true;
                        } else {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                }, 1, null);
            }
        }, 1, null);
    }

    public final Modifier getModifiers() {
        return this.coreModifiers.then(this.semanticsModifier).then(this.selectionModifiers);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        SelectionRegistrar selectionRegistrar = this.selectionRegistrar;
        if (selectionRegistrar != null) {
            this.state.setSelectable(selectionRegistrar.subscribe(new MultiWidgetSelectionDelegate(this.state.getSelectableId(), new Function0<LayoutCoordinates>() { // from class: androidx.compose.foundation.text.TextController$onRemembered$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final LayoutCoordinates invoke() {
                    return TextController.this.getState().getLayoutCoordinates();
                }
            }, new Function0<TextLayoutResult>() { // from class: androidx.compose.foundation.text.TextController$onRemembered$1$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextLayoutResult invoke() {
                    return TextController.this.getState().getLayoutResult();
                }
            })));
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        SelectionRegistrar selectionRegistrar;
        Selectable it = this.state.getSelectable();
        if (it == null || (selectionRegistrar = this.selectionRegistrar) == null) {
            return;
        }
        selectionRegistrar.unsubscribe(it);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        SelectionRegistrar selectionRegistrar;
        Selectable it = this.state.getSelectable();
        if (it == null || (selectionRegistrar = this.selectionRegistrar) == null) {
            return;
        }
        selectionRegistrar.unsubscribe(it);
    }
}
