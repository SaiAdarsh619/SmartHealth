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
import androidx.compose.p000ui.unit.Density;
import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Size.kt */
@Metadata(m286d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BQ\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\u001c\u0010 \u001a\u00020\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001aH\u0016J)\u0010\"\u001a\u00020#*\u00020$2\u0006\u0010\u001d\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0012H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001c\u0010)\u001a\u00020\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\u001c\u0010*\u001a\u00020\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001aH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R!\u0010\u0011\u001a\u00020\u0012*\u00020\u00138BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, m287d2 = {"Landroidx/compose/foundation/layout/SizeModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "targetConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/unit/Density;", "getTargetConstraints-OenEA2s", "(Landroidx/compose/ui/unit/Density;)J", "equals", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class SizeModifier extends InspectorValueInfo implements LayoutModifier {
    private final boolean enforceIncoming;
    private final float maxHeight;
    private final float maxWidth;
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ SizeModifier(float f, float f2, float f3, float f4, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z, function1);
    }

    public /* synthetic */ SizeModifier(float f, float f2, float f3, float f4, boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM() : f2, (i & 4) != 0 ? C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM() : f3, (i & 8) != 0 ? C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM() : f4, z, function1, null);
    }

    private SizeModifier(float minWidth, float minHeight, float maxWidth, float maxHeight, boolean enforceIncoming, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.minWidth = minWidth;
        this.minHeight = minHeight;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.enforceIncoming = enforceIncoming;
    }

    /* renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    private final long m811getTargetConstraintsOenEA2s(Density $this$targetConstraints) {
        int maxWidth;
        int maxHeight;
        int it;
        int it2;
        if (!C0504Dp.m4387equalsimpl0(this.maxWidth, C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM())) {
            maxWidth = $this$targetConstraints.mo642roundToPx0680j_4(((C0504Dp) RangesKt.coerceAtLeast(C0504Dp.m4380boximpl(this.maxWidth), C0504Dp.m4380boximpl(C0504Dp.m4382constructorimpl(0)))).m4396unboximpl());
        } else {
            maxWidth = Integer.MAX_VALUE;
        }
        if (!C0504Dp.m4387equalsimpl0(this.maxHeight, C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM())) {
            maxHeight = $this$targetConstraints.mo642roundToPx0680j_4(((C0504Dp) RangesKt.coerceAtLeast(C0504Dp.m4380boximpl(this.maxHeight), C0504Dp.m4380boximpl(C0504Dp.m4382constructorimpl(0)))).m4396unboximpl());
        } else {
            maxHeight = Integer.MAX_VALUE;
        }
        int i = 0;
        if (!C0504Dp.m4387equalsimpl0(this.minWidth, C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM())) {
            it = RangesKt.coerceAtLeast(RangesKt.coerceAtMost($this$targetConstraints.mo642roundToPx0680j_4(this.minWidth), maxWidth), 0);
            if (it == Integer.MAX_VALUE) {
                it = 0;
            }
        } else {
            it = 0;
        }
        if (!C0504Dp.m4387equalsimpl0(this.minHeight, C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM()) && (it2 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost($this$targetConstraints.mo642roundToPx0680j_4(this.minHeight), maxHeight), 0)) != Integer.MAX_VALUE) {
            i = it2;
        }
        int minHeight = i;
        return ConstraintsKt.Constraints(it, maxWidth, minHeight, maxHeight);
    }

    @Override // androidx.compose.p000ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo346measure3p2s80s(MeasureScope measure, Measurable measurable, long constraints) {
        int resolvedMinWidth;
        int resolvedMaxWidth;
        int resolvedMinHeight;
        int resolvedMaxHeight;
        long targetConstraints;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long targetConstraints2 = m811getTargetConstraintsOenEA2s(measure);
        if (this.enforceIncoming) {
            targetConstraints = ConstraintsKt.m4350constrainN9IONVI(constraints, targetConstraints2);
        } else {
            if (!C0504Dp.m4387equalsimpl0(this.minWidth, C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM())) {
                resolvedMinWidth = Constraints.m4340getMinWidthimpl(targetConstraints2);
            } else {
                resolvedMinWidth = RangesKt.coerceAtMost(Constraints.m4340getMinWidthimpl(constraints), Constraints.m4338getMaxWidthimpl(targetConstraints2));
            }
            if (!C0504Dp.m4387equalsimpl0(this.maxWidth, C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM())) {
                resolvedMaxWidth = Constraints.m4338getMaxWidthimpl(targetConstraints2);
            } else {
                resolvedMaxWidth = RangesKt.coerceAtLeast(Constraints.m4338getMaxWidthimpl(constraints), Constraints.m4340getMinWidthimpl(targetConstraints2));
            }
            if (!C0504Dp.m4387equalsimpl0(this.minHeight, C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM())) {
                resolvedMinHeight = Constraints.m4339getMinHeightimpl(targetConstraints2);
            } else {
                resolvedMinHeight = RangesKt.coerceAtMost(Constraints.m4339getMinHeightimpl(constraints), Constraints.m4337getMaxHeightimpl(targetConstraints2));
            }
            if (!C0504Dp.m4387equalsimpl0(this.maxHeight, C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM())) {
                resolvedMaxHeight = Constraints.m4337getMaxHeightimpl(targetConstraints2);
            } else {
                resolvedMaxHeight = RangesKt.coerceAtLeast(Constraints.m4337getMaxHeightimpl(constraints), Constraints.m4339getMinHeightimpl(targetConstraints2));
            }
            targetConstraints = ConstraintsKt.Constraints(resolvedMinWidth, resolvedMaxWidth, resolvedMinHeight, resolvedMaxHeight);
        }
        final Placeable placeable = measurable.mo3492measureBRTryo0(targetConstraints);
        return MeasureScope.layout$default(measure, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.SizeModifier$measure$1
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
        long constraints = m811getTargetConstraintsOenEA2s($this$minIntrinsicWidth);
        if (Constraints.m4336getHasFixedWidthimpl(constraints)) {
            return Constraints.m4338getMaxWidthimpl(constraints);
        }
        return ConstraintsKt.m4352constrainWidthK40F9xA(constraints, measurable.minIntrinsicWidth(height));
    }

    @Override // androidx.compose.p000ui.layout.LayoutModifier
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long constraints = m811getTargetConstraintsOenEA2s($this$minIntrinsicHeight);
        if (Constraints.m4335getHasFixedHeightimpl(constraints)) {
            return Constraints.m4337getMaxHeightimpl(constraints);
        }
        return ConstraintsKt.m4351constrainHeightK40F9xA(constraints, measurable.minIntrinsicHeight(width));
    }

    @Override // androidx.compose.p000ui.layout.LayoutModifier
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long constraints = m811getTargetConstraintsOenEA2s($this$maxIntrinsicWidth);
        if (Constraints.m4336getHasFixedWidthimpl(constraints)) {
            return Constraints.m4338getMaxWidthimpl(constraints);
        }
        return ConstraintsKt.m4352constrainWidthK40F9xA(constraints, measurable.maxIntrinsicWidth(height));
    }

    @Override // androidx.compose.p000ui.layout.LayoutModifier
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long constraints = m811getTargetConstraintsOenEA2s($this$maxIntrinsicHeight);
        if (Constraints.m4335getHasFixedHeightimpl(constraints)) {
            return Constraints.m4337getMaxHeightimpl(constraints);
        }
        return ConstraintsKt.m4351constrainHeightK40F9xA(constraints, measurable.maxIntrinsicHeight(width));
    }

    public boolean equals(Object other) {
        return (other instanceof SizeModifier) && C0504Dp.m4387equalsimpl0(this.minWidth, ((SizeModifier) other).minWidth) && C0504Dp.m4387equalsimpl0(this.minHeight, ((SizeModifier) other).minHeight) && C0504Dp.m4387equalsimpl0(this.maxWidth, ((SizeModifier) other).maxWidth) && C0504Dp.m4387equalsimpl0(this.maxHeight, ((SizeModifier) other).maxHeight) && this.enforceIncoming == ((SizeModifier) other).enforceIncoming;
    }

    public int hashCode() {
        return ((((((C0504Dp.m4388hashCodeimpl(this.minWidth) * 31) + C0504Dp.m4388hashCodeimpl(this.minHeight)) * 31) + C0504Dp.m4388hashCodeimpl(this.maxWidth)) * 31) + C0504Dp.m4388hashCodeimpl(this.maxHeight)) * 31;
    }
}
