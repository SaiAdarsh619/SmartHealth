package androidx.compose.foundation.layout;

import androidx.compose.p000ui.layout.IntrinsicMeasurable;
import androidx.compose.p000ui.layout.IntrinsicMeasureScope;
import androidx.compose.p000ui.layout.LayoutModifier;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.p000ui.platform.InspectorValueInfo;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Size.kt */
@Metadata(m286d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0016\u001a\u00020\u0015*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u001c\u0010\u001b\u001a\u00020\u0015*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0015H\u0016J)\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u001c\u0010%\u001a\u00020\u0015*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u001c\u0010&\u001a\u00020\u0015*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0015H\u0016R\u001c\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\r\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, m287d2 = {"Landroidx/compose/foundation/layout/UnspecifiedConstraintsModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinHeight-D9Ej5fM", "()F", "F", "getMinWidth-D9Ej5fM", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class UnspecifiedConstraintsModifier extends InspectorValueInfo implements LayoutModifier {
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ UnspecifiedConstraintsModifier(float f, float f2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, function1);
    }

    public /* synthetic */ UnspecifiedConstraintsModifier(float f, float f2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM() : f2, function1, null);
    }

    /* renamed from: getMinWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMinWidth() {
        return this.minWidth;
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMinHeight() {
        return this.minHeight;
    }

    private UnspecifiedConstraintsModifier(float minWidth, float minHeight, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.minWidth = minWidth;
        this.minHeight = minHeight;
    }

    @Override // androidx.compose.p000ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo346measure3p2s80s(MeasureScope measure, Measurable measurable, long constraints) {
        int m4340getMinWidthimpl;
        int m4339getMinHeightimpl;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (!C0504Dp.m4387equalsimpl0(this.minWidth, C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM()) && Constraints.m4340getMinWidthimpl(constraints) == 0) {
            m4340getMinWidthimpl = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(measure.mo642roundToPx0680j_4(this.minWidth), Constraints.m4338getMaxWidthimpl(constraints)), 0);
        } else {
            m4340getMinWidthimpl = Constraints.m4340getMinWidthimpl(constraints);
        }
        int m4338getMaxWidthimpl = Constraints.m4338getMaxWidthimpl(constraints);
        if (!C0504Dp.m4387equalsimpl0(this.minHeight, C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM()) && Constraints.m4339getMinHeightimpl(constraints) == 0) {
            m4339getMinHeightimpl = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(measure.mo642roundToPx0680j_4(this.minHeight), Constraints.m4337getMaxHeightimpl(constraints)), 0);
        } else {
            m4339getMinHeightimpl = Constraints.m4339getMinHeightimpl(constraints);
        }
        long wrappedConstraints = ConstraintsKt.Constraints(m4340getMinWidthimpl, m4338getMaxWidthimpl, m4339getMinHeightimpl, Constraints.m4337getMaxHeightimpl(constraints));
        final Placeable placeable = measurable.mo3492measureBRTryo0(wrappedConstraints);
        return MeasureScope.layout$default(measure, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.UnspecifiedConstraintsModifier$measure$1
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
                Placeable.PlacementScope.placeRelative$default(layout, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.p000ui.layout.LayoutModifier
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return RangesKt.coerceAtLeast(measurable.minIntrinsicWidth(height), !C0504Dp.m4387equalsimpl0(this.minWidth, C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM()) ? $this$minIntrinsicWidth.mo642roundToPx0680j_4(this.minWidth) : 0);
    }

    @Override // androidx.compose.p000ui.layout.LayoutModifier
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return RangesKt.coerceAtLeast(measurable.maxIntrinsicWidth(height), !C0504Dp.m4387equalsimpl0(this.minWidth, C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM()) ? $this$maxIntrinsicWidth.mo642roundToPx0680j_4(this.minWidth) : 0);
    }

    @Override // androidx.compose.p000ui.layout.LayoutModifier
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return RangesKt.coerceAtLeast(measurable.minIntrinsicHeight(width), !C0504Dp.m4387equalsimpl0(this.minHeight, C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM()) ? $this$minIntrinsicHeight.mo642roundToPx0680j_4(this.minHeight) : 0);
    }

    @Override // androidx.compose.p000ui.layout.LayoutModifier
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return RangesKt.coerceAtLeast(measurable.maxIntrinsicHeight(width), !C0504Dp.m4387equalsimpl0(this.minHeight, C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM()) ? $this$maxIntrinsicHeight.mo642roundToPx0680j_4(this.minHeight) : 0);
    }

    public boolean equals(Object other) {
        return (other instanceof UnspecifiedConstraintsModifier) && C0504Dp.m4387equalsimpl0(this.minWidth, ((UnspecifiedConstraintsModifier) other).minWidth) && C0504Dp.m4387equalsimpl0(this.minHeight, ((UnspecifiedConstraintsModifier) other).minHeight);
    }

    public int hashCode() {
        return (C0504Dp.m4388hashCodeimpl(this.minWidth) * 31) + C0504Dp.m4388hashCodeimpl(this.minHeight);
    }
}
