package androidx.compose.foundation.layout;

import androidx.compose.p000ui.layout.IntrinsicMeasurable;
import androidx.compose.p000ui.layout.IntrinsicMeasureScope;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: RowColumnImpl.kt */
@Metadata(m286d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u0012\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a.\u0010\u0018\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a.\u0010\u0019\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a.\u0010\u001a\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001ad\u0010\u001b\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u001d\u0010\u001d\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u001d\u0010 \u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0002\u001aE\u0010#\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u001d\u0010\u001d\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0002\u001at\u0010%\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u001d\u0010&\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u001d\u0010'\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0017H\u0002\u001aa\u0010*\u001a\u00020+2\u0006\u0010\u0016\u001a\u00020\u00172*\u0010,\u001a&\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u0002010-2\u0006\u00102\u001a\u0002032\u0006\u0010 \u001a\u0002042\u0006\u0010\u0000\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106\"\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u001a\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001a\u0010\r\u001a\u00020\n*\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\f\"\u001a\u0010\u000e\u001a\u00020\u000f*\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00067"}, m287d2 = {"crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "Landroidx/compose/foundation/layout/RowColumnParentData;", "getCrossAxisAlignment", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Landroidx/compose/foundation/layout/CrossAxisAlignment;", "data", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getData", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Landroidx/compose/foundation/layout/RowColumnParentData;", "fill", "", "getFill", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Z", "isRelative", "weight", "", "getWeight", "(Landroidx/compose/foundation/layout/RowColumnParentData;)F", "MaxIntrinsicHeightMeasureBlock", "Lkotlin/Function3;", "", "", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "MaxIntrinsicWidthMeasureBlock", "MinIntrinsicHeightMeasureBlock", "MinIntrinsicWidthMeasureBlock", "intrinsicCrossAxisSize", "children", "mainAxisSize", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "crossAxisSize", "mainAxisAvailable", "mainAxisSpacing", "intrinsicMainAxisSize", "crossAxisAvailable", "intrinsicSize", "intrinsicMainSize", "intrinsicCrossSize", "layoutOrientation", "intrinsicOrientation", "rowColumnMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "arrangement", "Lkotlin/Function5;", "", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "", "arrangementSpacing", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/foundation/layout/SizeMode;", "rowColumnMeasurePolicy-TDGSqEk", "(Landroidx/compose/foundation/layout/LayoutOrientation;Lkotlin/jvm/functions/Function5;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;)Landroidx/compose/ui/layout/MeasurePolicy;", "foundation-layout_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class RowColumnImplKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(Placeable $this$rowColumnMeasurePolicy_TDGSqEk_u24mainAxisSize, LayoutOrientation $orientation) {
        return $orientation == LayoutOrientation.Horizontal ? $this$rowColumnMeasurePolicy_TDGSqEk_u24mainAxisSize.getWidth() : $this$rowColumnMeasurePolicy_TDGSqEk_u24mainAxisSize.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(Placeable $this$rowColumnMeasurePolicy_TDGSqEk_u24crossAxisSize, LayoutOrientation $orientation) {
        return $orientation == LayoutOrientation.Horizontal ? $this$rowColumnMeasurePolicy_TDGSqEk_u24crossAxisSize.getHeight() : $this$rowColumnMeasurePolicy_TDGSqEk_u24crossAxisSize.getWidth();
    }

    /* renamed from: rowColumnMeasurePolicy-TDGSqEk, reason: not valid java name */
    public static final MeasurePolicy m780rowColumnMeasurePolicyTDGSqEk(final LayoutOrientation orientation, final Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> arrangement, final float arrangementSpacing, final SizeMode crossAxisSize, final CrossAxisAlignment crossAxisAlignment) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(arrangement, "arrangement");
        Intrinsics.checkNotNullParameter(crossAxisSize, "crossAxisSize");
        Intrinsics.checkNotNullParameter(crossAxisAlignment, "crossAxisAlignment");
        return new MeasurePolicy() { // from class: androidx.compose.foundation.layout.RowColumnImplKt$rowColumnMeasurePolicy$1
            /* JADX WARN: Removed duplicated region for block: B:100:0x01a0  */
            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public MeasureResult mo331measure3p2s80s(final MeasureScope measure, final List<? extends Measurable> list, long constraints) {
                int targetSpace;
                int fixedSpace;
                int crossAxisSpace;
                boolean anyAlignBy;
                int weightedSpace;
                int i;
                int targetSpace2;
                int remainingToTarget;
                float weight;
                boolean fill;
                int remainingToTarget2;
                int rowColumnMeasurePolicy_TDGSqEk$mainAxisSize;
                int rowColumnMeasurePolicy_TDGSqEk$crossAxisSize;
                boolean z;
                boolean isRelative;
                float weight2;
                int afterCrossAxisAlignmentLine;
                final int crossAxisLayoutSize;
                int layoutWidth;
                int layoutHeight;
                CrossAxisAlignment crossAxisAlignment2;
                int rowColumnMeasurePolicy_TDGSqEk$crossAxisSize2;
                int rowColumnMeasurePolicy_TDGSqEk$crossAxisSize3;
                float weight3;
                int i2;
                int rowColumnMeasurePolicy_TDGSqEk$mainAxisSize2;
                int rowColumnMeasurePolicy_TDGSqEk$mainAxisSize3;
                int rowColumnMeasurePolicy_TDGSqEk$crossAxisSize4;
                boolean z2;
                boolean isRelative2;
                RowColumnParentData data;
                List<? extends Measurable> measurables = list;
                Intrinsics.checkNotNullParameter(measure, "$this$measure");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                OrientationIndependentConstraints constraints2 = new OrientationIndependentConstraints(constraints, LayoutOrientation.this, null);
                int arrangementSpacingPx = measure.mo642roundToPx0680j_4(arrangementSpacing);
                int fixedSpace2 = 0;
                int crossAxisSpace2 = 0;
                boolean anyAlignBy2 = false;
                final Placeable[] placeables = new Placeable[list.size()];
                int size = list.size();
                final RowColumnParentData[] rowColumnParentData = new RowColumnParentData[size];
                for (int i3 = 0; i3 < size; i3++) {
                    data = RowColumnImplKt.getData(measurables.get(i3));
                    rowColumnParentData[i3] = data;
                }
                int size2 = list.size();
                float totalWeight = 0.0f;
                int weightChildrenCount = 0;
                int spaceAfterLastNoWeight = 0;
                for (int i4 = 0; i4 < size2; i4++) {
                    Measurable child = measurables.get(i4);
                    RowColumnParentData parentData = rowColumnParentData[i4];
                    weight3 = RowColumnImplKt.getWeight(parentData);
                    if (weight3 > 0.0f) {
                        totalWeight += weight3;
                        weightChildrenCount++;
                    } else {
                        int mainAxisMax = constraints2.getMainAxisMax();
                        if (mainAxisMax == Integer.MAX_VALUE) {
                            i2 = Integer.MAX_VALUE;
                        } else {
                            i2 = mainAxisMax - fixedSpace2;
                        }
                        Placeable placeable = child.mo3492measureBRTryo0(OrientationIndependentConstraints.copy$default(constraints2, 0, i2, 0, 0, 8, null).m751toBoxConstraintsOenEA2s(LayoutOrientation.this));
                        rowColumnMeasurePolicy_TDGSqEk$mainAxisSize2 = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(placeable, LayoutOrientation.this);
                        int spaceAfterLastNoWeight2 = Math.min(arrangementSpacingPx, (mainAxisMax - fixedSpace2) - rowColumnMeasurePolicy_TDGSqEk$mainAxisSize2);
                        rowColumnMeasurePolicy_TDGSqEk$mainAxisSize3 = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(placeable, LayoutOrientation.this);
                        fixedSpace2 += rowColumnMeasurePolicy_TDGSqEk$mainAxisSize3 + spaceAfterLastNoWeight2;
                        rowColumnMeasurePolicy_TDGSqEk$crossAxisSize4 = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable, LayoutOrientation.this);
                        crossAxisSpace2 = Math.max(crossAxisSpace2, rowColumnMeasurePolicy_TDGSqEk$crossAxisSize4);
                        if (!anyAlignBy2) {
                            isRelative2 = RowColumnImplKt.isRelative(parentData);
                            if (!isRelative2) {
                                z2 = false;
                                anyAlignBy2 = z2;
                                placeables[i4] = placeable;
                                spaceAfterLastNoWeight = spaceAfterLastNoWeight2;
                            }
                        }
                        z2 = true;
                        anyAlignBy2 = z2;
                        placeables[i4] = placeable;
                        spaceAfterLastNoWeight = spaceAfterLastNoWeight2;
                    }
                }
                int weightedSpace2 = 0;
                if (weightChildrenCount != 0) {
                    if (totalWeight > 0.0f && constraints2.getMainAxisMax() != Integer.MAX_VALUE) {
                        targetSpace = constraints2.getMainAxisMax();
                    } else {
                        targetSpace = constraints2.getMainAxisMin();
                    }
                    int remainingToTarget3 = (targetSpace - fixedSpace2) - ((weightChildrenCount - 1) * arrangementSpacingPx);
                    float weightUnitSpace = totalWeight > 0.0f ? remainingToTarget3 / totalWeight : 0.0f;
                    int i5 = 0;
                    for (RowColumnParentData rowColumnParentData2 : rowColumnParentData) {
                        weight2 = RowColumnImplKt.getWeight(rowColumnParentData2);
                        i5 += MathKt.roundToInt(weight2 * weightUnitSpace);
                    }
                    int remainder = remainingToTarget3 - i5;
                    int i6 = 0;
                    int size3 = list.size();
                    while (i6 < size3) {
                        if (placeables[i6] != null) {
                            i = size3;
                            targetSpace2 = targetSpace;
                            remainingToTarget = remainingToTarget3;
                        } else {
                            i = size3;
                            Measurable child2 = measurables.get(i6);
                            RowColumnParentData parentData2 = rowColumnParentData[i6];
                            weight = RowColumnImplKt.getWeight(parentData2);
                            if (!(weight > 0.0f)) {
                                throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                            }
                            int remainderUnit = MathKt.getSign(remainder);
                            int remainder2 = remainder - remainderUnit;
                            int remainder3 = MathKt.roundToInt(weightUnitSpace * weight) + remainderUnit;
                            targetSpace2 = targetSpace;
                            int childMainAxisSize = Math.max(0, remainder3);
                            fill = RowColumnImplKt.getFill(parentData2);
                            if (fill) {
                                remainingToTarget = remainingToTarget3;
                                if (childMainAxisSize != Integer.MAX_VALUE) {
                                    remainingToTarget2 = childMainAxisSize;
                                    Placeable placeable2 = child2.mo3492measureBRTryo0(new OrientationIndependentConstraints(remainingToTarget2, childMainAxisSize, 0, constraints2.getCrossAxisMax()).m751toBoxConstraintsOenEA2s(LayoutOrientation.this));
                                    rowColumnMeasurePolicy_TDGSqEk$mainAxisSize = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(placeable2, LayoutOrientation.this);
                                    weightedSpace2 += rowColumnMeasurePolicy_TDGSqEk$mainAxisSize;
                                    rowColumnMeasurePolicy_TDGSqEk$crossAxisSize = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable2, LayoutOrientation.this);
                                    crossAxisSpace2 = Math.max(crossAxisSpace2, rowColumnMeasurePolicy_TDGSqEk$crossAxisSize);
                                    if (!anyAlignBy2) {
                                        isRelative = RowColumnImplKt.isRelative(parentData2);
                                        if (!isRelative) {
                                            z = false;
                                            anyAlignBy2 = z;
                                            placeables[i6] = placeable2;
                                            remainder = remainder2;
                                        }
                                    }
                                    z = true;
                                    anyAlignBy2 = z;
                                    placeables[i6] = placeable2;
                                    remainder = remainder2;
                                }
                            } else {
                                remainingToTarget = remainingToTarget3;
                            }
                            remainingToTarget2 = 0;
                            Placeable placeable22 = child2.mo3492measureBRTryo0(new OrientationIndependentConstraints(remainingToTarget2, childMainAxisSize, 0, constraints2.getCrossAxisMax()).m751toBoxConstraintsOenEA2s(LayoutOrientation.this));
                            rowColumnMeasurePolicy_TDGSqEk$mainAxisSize = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(placeable22, LayoutOrientation.this);
                            weightedSpace2 += rowColumnMeasurePolicy_TDGSqEk$mainAxisSize;
                            rowColumnMeasurePolicy_TDGSqEk$crossAxisSize = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable22, LayoutOrientation.this);
                            crossAxisSpace2 = Math.max(crossAxisSpace2, rowColumnMeasurePolicy_TDGSqEk$crossAxisSize);
                            if (!anyAlignBy2) {
                            }
                            z = true;
                            anyAlignBy2 = z;
                            placeables[i6] = placeable22;
                            remainder = remainder2;
                        }
                        i6++;
                        measurables = list;
                        size3 = i;
                        targetSpace = targetSpace2;
                        remainingToTarget3 = remainingToTarget;
                    }
                    fixedSpace = fixedSpace2;
                    crossAxisSpace = crossAxisSpace2;
                    anyAlignBy = anyAlignBy2;
                    weightedSpace = RangesKt.coerceAtMost(((weightChildrenCount - 1) * arrangementSpacingPx) + weightedSpace2, constraints2.getMainAxisMax() - fixedSpace2);
                } else {
                    fixedSpace = fixedSpace2 - spaceAfterLastNoWeight;
                    crossAxisSpace = crossAxisSpace2;
                    anyAlignBy = anyAlignBy2;
                    weightedSpace = 0;
                }
                final Ref.IntRef beforeCrossAxisAlignmentLine = new Ref.IntRef();
                int afterCrossAxisAlignmentLine2 = 0;
                if (!anyAlignBy) {
                    afterCrossAxisAlignmentLine = 0;
                } else {
                    int length = placeables.length;
                    for (int i7 = 0; i7 < length; i7++) {
                        Placeable placeable3 = placeables[i7];
                        Intrinsics.checkNotNull(placeable3);
                        crossAxisAlignment2 = RowColumnImplKt.getCrossAxisAlignment(rowColumnParentData[i7]);
                        Integer alignmentLinePosition = crossAxisAlignment2 != null ? crossAxisAlignment2.calculateAlignmentLinePosition$foundation_layout_release(placeable3) : null;
                        if (alignmentLinePosition != null) {
                            int i8 = beforeCrossAxisAlignmentLine.element;
                            int it = alignmentLinePosition.intValue();
                            if (it == Integer.MIN_VALUE) {
                                it = 0;
                            }
                            beforeCrossAxisAlignmentLine.element = Math.max(i8, it);
                            rowColumnMeasurePolicy_TDGSqEk$crossAxisSize2 = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable3, LayoutOrientation.this);
                            LayoutOrientation layoutOrientation = LayoutOrientation.this;
                            int it2 = alignmentLinePosition.intValue();
                            if (it2 == Integer.MIN_VALUE) {
                                rowColumnMeasurePolicy_TDGSqEk$crossAxisSize3 = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable3, layoutOrientation);
                            } else {
                                rowColumnMeasurePolicy_TDGSqEk$crossAxisSize3 = it2;
                            }
                            afterCrossAxisAlignmentLine2 = Math.max(afterCrossAxisAlignmentLine2, rowColumnMeasurePolicy_TDGSqEk$crossAxisSize2 - rowColumnMeasurePolicy_TDGSqEk$crossAxisSize3);
                        }
                    }
                    afterCrossAxisAlignmentLine = afterCrossAxisAlignmentLine2;
                }
                int afterCrossAxisAlignmentLine3 = fixedSpace + weightedSpace;
                final int mainAxisLayoutSize = Math.max(afterCrossAxisAlignmentLine3, constraints2.getMainAxisMin());
                if (constraints2.getCrossAxisMax() != Integer.MAX_VALUE && crossAxisSize == SizeMode.Expand) {
                    crossAxisLayoutSize = constraints2.getCrossAxisMax();
                } else {
                    crossAxisLayoutSize = Math.max(crossAxisSpace, Math.max(constraints2.getCrossAxisMin(), beforeCrossAxisAlignmentLine.element + afterCrossAxisAlignmentLine));
                }
                if (LayoutOrientation.this == LayoutOrientation.Horizontal) {
                    layoutWidth = mainAxisLayoutSize;
                } else {
                    layoutWidth = crossAxisLayoutSize;
                }
                if (LayoutOrientation.this == LayoutOrientation.Horizontal) {
                    layoutHeight = crossAxisLayoutSize;
                } else {
                    layoutHeight = mainAxisLayoutSize;
                }
                int size4 = list.size();
                final int[] mainAxisPositions = new int[size4];
                for (int i9 = 0; i9 < size4; i9++) {
                    mainAxisPositions[i9] = 0;
                }
                final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> function5 = arrangement;
                final LayoutOrientation layoutOrientation2 = LayoutOrientation.this;
                final CrossAxisAlignment crossAxisAlignment3 = crossAxisAlignment;
                return MeasureScope.layout$default(measure, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.RowColumnImplKt$rowColumnMeasurePolicy$1$measure$4
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
                        CrossAxisAlignment crossAxisAlignment4;
                        int rowColumnMeasurePolicy_TDGSqEk$crossAxisSize5;
                        LayoutDirection layoutDirection;
                        int i10;
                        int i11;
                        int[] iArr;
                        Ref.IntRef intRef;
                        int rowColumnMeasurePolicy_TDGSqEk$mainAxisSize4;
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        int size5 = list.size();
                        int[] childrenMainAxisSize = new int[size5];
                        for (int i12 = 0; i12 < size5; i12++) {
                            Placeable placeable4 = placeables[i12];
                            Intrinsics.checkNotNull(placeable4);
                            rowColumnMeasurePolicy_TDGSqEk$mainAxisSize4 = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(placeable4, layoutOrientation2);
                            childrenMainAxisSize[i12] = rowColumnMeasurePolicy_TDGSqEk$mainAxisSize4;
                        }
                        function5.invoke(Integer.valueOf(mainAxisLayoutSize), childrenMainAxisSize, measure.getLayoutDirection(), measure, mainAxisPositions);
                        Placeable[] placeableArr = placeables;
                        RowColumnParentData[] rowColumnParentDataArr = rowColumnParentData;
                        CrossAxisAlignment crossAxisAlignment5 = crossAxisAlignment3;
                        int i13 = crossAxisLayoutSize;
                        LayoutOrientation layoutOrientation3 = layoutOrientation2;
                        MeasureScope measureScope = measure;
                        Ref.IntRef intRef2 = beforeCrossAxisAlignmentLine;
                        int[] iArr2 = mainAxisPositions;
                        int index$iv = 0;
                        int length2 = placeableArr.length;
                        int i14 = 0;
                        while (i14 < length2) {
                            Placeable placeable5 = placeableArr[i14];
                            int index$iv2 = index$iv + 1;
                            int index = index$iv;
                            Intrinsics.checkNotNull(placeable5);
                            RowColumnParentData parentData3 = rowColumnParentDataArr[index];
                            crossAxisAlignment4 = RowColumnImplKt.getCrossAxisAlignment(parentData3);
                            if (crossAxisAlignment4 == null) {
                                crossAxisAlignment4 = crossAxisAlignment5;
                            }
                            CrossAxisAlignment childCrossAlignment = crossAxisAlignment4;
                            rowColumnMeasurePolicy_TDGSqEk$crossAxisSize5 = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable5, layoutOrientation3);
                            int i15 = i13 - rowColumnMeasurePolicy_TDGSqEk$crossAxisSize5;
                            if (layoutOrientation3 == LayoutOrientation.Horizontal) {
                                layoutDirection = LayoutDirection.Ltr;
                            } else {
                                layoutDirection = measureScope.getLayoutDirection();
                            }
                            Placeable[] placeableArr2 = placeableArr;
                            int crossAxis = childCrossAlignment.align$foundation_layout_release(i15, layoutDirection, placeable5, intRef2.element);
                            if (layoutOrientation3 == LayoutOrientation.Horizontal) {
                                i10 = i14;
                                i11 = length2;
                                iArr = iArr2;
                                intRef = intRef2;
                                Placeable.PlacementScope.place$default(layout, placeable5, iArr2[index], crossAxis, 0.0f, 4, null);
                            } else {
                                i10 = i14;
                                i11 = length2;
                                iArr = iArr2;
                                intRef = intRef2;
                                Placeable.PlacementScope.place$default(layout, placeable5, crossAxis, iArr[index], 0.0f, 4, null);
                            }
                            i14 = i10 + 1;
                            index$iv = index$iv2;
                            placeableArr = placeableArr2;
                            intRef2 = intRef;
                            iArr2 = iArr;
                            length2 = i11;
                        }
                    }
                }, 4, null);
            }

            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
                Function3 MinIntrinsicWidthMeasureBlock;
                Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                MinIntrinsicWidthMeasureBlock = RowColumnImplKt.MinIntrinsicWidthMeasureBlock(LayoutOrientation.this);
                return ((Number) MinIntrinsicWidthMeasureBlock.invoke(measurables, Integer.valueOf(height), Integer.valueOf($this$minIntrinsicWidth.mo642roundToPx0680j_4(arrangementSpacing)))).intValue();
            }

            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
                Function3 MinIntrinsicHeightMeasureBlock;
                Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                MinIntrinsicHeightMeasureBlock = RowColumnImplKt.MinIntrinsicHeightMeasureBlock(LayoutOrientation.this);
                return ((Number) MinIntrinsicHeightMeasureBlock.invoke(measurables, Integer.valueOf(width), Integer.valueOf($this$minIntrinsicHeight.mo642roundToPx0680j_4(arrangementSpacing)))).intValue();
            }

            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
                Function3 MaxIntrinsicWidthMeasureBlock;
                Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                MaxIntrinsicWidthMeasureBlock = RowColumnImplKt.MaxIntrinsicWidthMeasureBlock(LayoutOrientation.this);
                return ((Number) MaxIntrinsicWidthMeasureBlock.invoke(measurables, Integer.valueOf(height), Integer.valueOf($this$maxIntrinsicWidth.mo642roundToPx0680j_4(arrangementSpacing)))).intValue();
            }

            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
                Function3 MaxIntrinsicHeightMeasureBlock;
                Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                MaxIntrinsicHeightMeasureBlock = RowColumnImplKt.MaxIntrinsicHeightMeasureBlock(LayoutOrientation.this);
                return ((Number) MaxIntrinsicHeightMeasureBlock.invoke(measurables, Integer.valueOf(width), Integer.valueOf($this$maxIntrinsicHeight.mo642roundToPx0680j_4(arrangementSpacing)))).intValue();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RowColumnParentData getData(IntrinsicMeasurable $this$data) {
        Object parentData = $this$data.getParentData();
        if (parentData instanceof RowColumnParentData) {
            return (RowColumnParentData) parentData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float getWeight(RowColumnParentData $this$weight) {
        if ($this$weight != null) {
            return $this$weight.getWeight();
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getFill(RowColumnParentData $this$fill) {
        if ($this$fill != null) {
            return $this$fill.getFill();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CrossAxisAlignment getCrossAxisAlignment(RowColumnParentData $this$crossAxisAlignment) {
        if ($this$crossAxisAlignment != null) {
            return $this$crossAxisAlignment.getCrossAxisAlignment();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isRelative(RowColumnParentData $this$isRelative) {
        CrossAxisAlignment crossAxisAlignment = getCrossAxisAlignment($this$isRelative);
        if (crossAxisAlignment != null) {
            return crossAxisAlignment.isRelative$foundation_layout_release();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MinIntrinsicWidthMeasureBlock(LayoutOrientation orientation) {
        if (orientation == LayoutOrientation.Horizontal) {
            return IntrinsicMeasureBlocks.INSTANCE.getHorizontalMinWidth();
        }
        return IntrinsicMeasureBlocks.INSTANCE.getVerticalMinWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MinIntrinsicHeightMeasureBlock(LayoutOrientation orientation) {
        if (orientation == LayoutOrientation.Horizontal) {
            return IntrinsicMeasureBlocks.INSTANCE.getHorizontalMinHeight();
        }
        return IntrinsicMeasureBlocks.INSTANCE.getVerticalMinHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MaxIntrinsicWidthMeasureBlock(LayoutOrientation orientation) {
        if (orientation == LayoutOrientation.Horizontal) {
            return IntrinsicMeasureBlocks.INSTANCE.getHorizontalMaxWidth();
        }
        return IntrinsicMeasureBlocks.INSTANCE.getVerticalMaxWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MaxIntrinsicHeightMeasureBlock(LayoutOrientation orientation) {
        if (orientation == LayoutOrientation.Horizontal) {
            return IntrinsicMeasureBlocks.INSTANCE.getHorizontalMaxHeight();
        }
        return IntrinsicMeasureBlocks.INSTANCE.getVerticalMaxHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int intrinsicSize(List<? extends IntrinsicMeasurable> list, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function22, int crossAxisAvailable, int mainAxisSpacing, LayoutOrientation layoutOrientation, LayoutOrientation intrinsicOrientation) {
        if (layoutOrientation == intrinsicOrientation) {
            return intrinsicMainAxisSize(list, function2, crossAxisAvailable, mainAxisSpacing);
        }
        return intrinsicCrossAxisSize(list, function22, function2, crossAxisAvailable, mainAxisSpacing);
    }

    private static final int intrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2, int crossAxisAvailable, int mainAxisSpacing) {
        int weightUnitSpace = 0;
        int fixedSpace = 0;
        float totalWeight = 0.0f;
        int index$iv = 0;
        int size = list.size();
        while (true) {
            if (index$iv >= size) {
                return MathKt.roundToInt(weightUnitSpace * totalWeight) + fixedSpace + ((list.size() - 1) * mainAxisSpacing);
            }
            Object item$iv = list.get(index$iv);
            IntrinsicMeasurable child = (IntrinsicMeasurable) item$iv;
            float weight = getWeight(getData(child));
            int size2 = function2.invoke(child, Integer.valueOf(crossAxisAvailable)).intValue();
            if (weight == 0.0f) {
                fixedSpace += size2;
            } else if (weight > 0.0f) {
                totalWeight += weight;
                weightUnitSpace = Math.max(weightUnitSpace, MathKt.roundToInt(size2 / weight));
            }
            index$iv++;
        }
    }

    private static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function22, int mainAxisAvailable, int mainAxisSpacing) {
        int i;
        float f;
        int i2;
        int fixedSpace = Math.min((list.size() - 1) * mainAxisSpacing, mainAxisAvailable);
        int crossAxisMax = 0;
        float totalWeight = 0.0f;
        int index$iv = 0;
        int size = list.size();
        while (true) {
            f = 0.0f;
            if (index$iv >= size) {
                break;
            }
            Object item$iv = list.get(index$iv);
            IntrinsicMeasurable child = (IntrinsicMeasurable) item$iv;
            float weight = getWeight(getData(child));
            if ((weight == 0.0f ? 1 : 0) != 0) {
                int mainAxisSpace = Math.min(function2.invoke(child, Integer.MAX_VALUE).intValue(), mainAxisAvailable - fixedSpace);
                fixedSpace += mainAxisSpace;
                crossAxisMax = Math.max(crossAxisMax, function22.invoke(child, Integer.valueOf(mainAxisSpace)).intValue());
            } else if (weight > 0.0f) {
                totalWeight += weight;
            }
            index$iv++;
        }
        if (!(totalWeight == 0.0f)) {
            if (mainAxisAvailable == Integer.MAX_VALUE) {
                i = Integer.MAX_VALUE;
            } else {
                i = MathKt.roundToInt(Math.max(mainAxisAvailable - fixedSpace, 0) / totalWeight);
            }
        }
        int weightUnitSpace = i;
        int index$iv2 = 0;
        int size2 = list.size();
        while (index$iv2 < size2) {
            Object item$iv2 = list.get(index$iv2);
            IntrinsicMeasurable child2 = (IntrinsicMeasurable) item$iv2;
            float weight2 = getWeight(getData(child2));
            if (weight2 > f) {
                if (weightUnitSpace != Integer.MAX_VALUE) {
                    i2 = MathKt.roundToInt(weightUnitSpace * weight2);
                } else {
                    i2 = Integer.MAX_VALUE;
                }
                crossAxisMax = Math.max(crossAxisMax, function22.invoke(child2, Integer.valueOf(i2)).intValue());
            }
            index$iv2++;
            f = 0.0f;
        }
        return crossAxisMax;
    }
}
