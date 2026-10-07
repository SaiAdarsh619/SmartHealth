package androidx.compose.material;

import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.DpOffset;
import androidx.compose.p000ui.unit.IntOffsetKt;
import androidx.compose.p000ui.unit.IntRect;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.p000ui.window.PopupPositionProvider;
import androidx.health.connect.client.records.Vo2MaxRecord;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: Menu.kt */
@Metadata(m286d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007ø\u0001\u0000¢\u0006\u0002\u0010\nJ5\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\fJ\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u001b\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003JF\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, m287d2 = {"Landroidx/compose/material/DropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "contentOffset", "Landroidx/compose/ui/unit/DpOffset;", "density", "Landroidx/compose/ui/unit/Density;", "onPositionCalculated", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", "", "(JLandroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentOffset-RKDOV3M", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getOnPositionCalculated", "()Lkotlin/jvm/functions/Function2;", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "component1", "component1-RKDOV3M", "component2", "component3", "copy", "copy-rOJDEFc", "(JLandroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function2;)Landroidx/compose/material/DropdownMenuPositionProvider;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "material_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DropdownMenuPositionProvider implements PopupPositionProvider {
    private final long contentOffset;
    private final Density density;
    private final Function2<IntRect, IntRect, Unit> onPositionCalculated;

    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, density, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-rOJDEFc$default, reason: not valid java name */
    public static /* synthetic */ DropdownMenuPositionProvider m1378copyrOJDEFc$default(DropdownMenuPositionProvider dropdownMenuPositionProvider, long j, Density density, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = dropdownMenuPositionProvider.contentOffset;
        }
        if ((i & 2) != 0) {
            density = dropdownMenuPositionProvider.density;
        }
        if ((i & 4) != 0) {
            function2 = dropdownMenuPositionProvider.onPositionCalculated;
        }
        return dropdownMenuPositionProvider.m1380copyrOJDEFc(j, density, function2);
    }

    /* renamed from: component1-RKDOV3M, reason: not valid java name and from getter */
    public final long getContentOffset() {
        return this.contentOffset;
    }

    /* renamed from: component2, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    public final Function2<IntRect, IntRect, Unit> component3() {
        return this.onPositionCalculated;
    }

    /* renamed from: copy-rOJDEFc, reason: not valid java name */
    public final DropdownMenuPositionProvider m1380copyrOJDEFc(long contentOffset, Density density, Function2<? super IntRect, ? super IntRect, Unit> onPositionCalculated) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(onPositionCalculated, "onPositionCalculated");
        return new DropdownMenuPositionProvider(contentOffset, density, onPositionCalculated, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DropdownMenuPositionProvider)) {
            return false;
        }
        DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) other;
        return DpOffset.m4442equalsimpl0(this.contentOffset, dropdownMenuPositionProvider.contentOffset) && Intrinsics.areEqual(this.density, dropdownMenuPositionProvider.density) && Intrinsics.areEqual(this.onPositionCalculated, dropdownMenuPositionProvider.onPositionCalculated);
    }

    public int hashCode() {
        return (((DpOffset.m4447hashCodeimpl(this.contentOffset) * 31) + this.density.hashCode()) * 31) + this.onPositionCalculated.hashCode();
    }

    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + ((Object) DpOffset.m4450toStringimpl(this.contentOffset)) + ", density=" + this.density + ", onPositionCalculated=" + this.onPositionCalculated + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DropdownMenuPositionProvider(long contentOffset, Density density, Function2<? super IntRect, ? super IntRect, Unit> function2) {
        this.contentOffset = contentOffset;
        this.density = density;
        this.onPositionCalculated = function2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, density, r4, null);
        Function2 function22;
        if ((i & 4) == 0) {
            function22 = function2;
        } else {
            function22 = new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material.DropdownMenuPositionProvider.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                    invoke2(intRect, intRect2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(IntRect intRect, IntRect intRect2) {
                    Intrinsics.checkNotNullParameter(intRect, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(intRect2, "<anonymous parameter 1>");
                }
            };
        }
    }

    /* renamed from: getContentOffset-RKDOV3M, reason: not valid java name */
    public final long m1381getContentOffsetRKDOV3M() {
        return this.contentOffset;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final Function2<IntRect, IntRect, Unit> getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x016f A[LOOP:1: B:22:0x0138->B:30:0x016f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c A[SYNTHETIC] */
    @Override // androidx.compose.p000ui.window.PopupPositionProvider
    /* renamed from: calculatePosition-llwVHH4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long mo1125calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        Sequence $this$firstOrNull$iv;
        Object obj;
        Object element$iv;
        int contentOffsetX;
        int it;
        Intrinsics.checkNotNullParameter(anchorBounds, "anchorBounds");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Density $this$calculatePosition_llwVHH4_u24lambda_u2d0 = this.density;
        int verticalMargin = $this$calculatePosition_llwVHH4_u24lambda_u2d0.mo642roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
        Density $this$calculatePosition_llwVHH4_u24lambda_u2d1 = this.density;
        int contentOffsetX2 = $this$calculatePosition_llwVHH4_u24lambda_u2d1.mo642roundToPx0680j_4(DpOffset.m4443getXD9Ej5fM(this.contentOffset));
        Density $this$calculatePosition_llwVHH4_u24lambda_u2d2 = this.density;
        int contentOffsetY = $this$calculatePosition_llwVHH4_u24lambda_u2d2.mo642roundToPx0680j_4(DpOffset.m4445getYD9Ej5fM(this.contentOffset));
        int toRight = anchorBounds.getLeft() + contentOffsetX2;
        int toLeft = (anchorBounds.getRight() - contentOffsetX2) - IntSize.m4542getWidthimpl(popupContentSize);
        int toDisplayRight = IntSize.m4542getWidthimpl(windowSize) - IntSize.m4542getWidthimpl(popupContentSize);
        if (layoutDirection == LayoutDirection.Ltr) {
            Integer[] numArr = new Integer[3];
            numArr[0] = Integer.valueOf(toRight);
            numArr[1] = Integer.valueOf(toLeft);
            numArr[2] = Integer.valueOf(anchorBounds.getLeft() >= 0 ? toDisplayRight : 0);
            $this$firstOrNull$iv = SequencesKt.sequenceOf(numArr);
        } else {
            Integer[] numArr2 = new Integer[3];
            numArr2[0] = Integer.valueOf(toLeft);
            numArr2[1] = Integer.valueOf(toRight);
            numArr2[2] = Integer.valueOf(anchorBounds.getRight() <= IntSize.m4542getWidthimpl(windowSize) ? 0 : toDisplayRight);
            $this$firstOrNull$iv = SequencesKt.sequenceOf(numArr2);
        }
        Iterator it2 = $this$firstOrNull$iv.iterator();
        while (true) {
            obj = null;
            if (it2.hasNext()) {
                element$iv = it2.next();
                int it3 = ((Number) element$iv).intValue();
                if (it3 >= 0 && it3 + IntSize.m4542getWidthimpl(popupContentSize) <= IntSize.m4542getWidthimpl(windowSize)) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        Integer num = (Integer) element$iv;
        int x = num != null ? num.intValue() : toLeft;
        int toBottom = Math.max(anchorBounds.getBottom() + contentOffsetY, verticalMargin);
        int toTop = (anchorBounds.getTop() - contentOffsetY) - IntSize.m4541getHeightimpl(popupContentSize);
        int toCenter = anchorBounds.getTop() - (IntSize.m4541getHeightimpl(popupContentSize) / 2);
        int toDisplayBottom = (IntSize.m4541getHeightimpl(windowSize) - IntSize.m4541getHeightimpl(popupContentSize)) - verticalMargin;
        Sequence $this$firstOrNull$iv2 = SequencesKt.sequenceOf(Integer.valueOf(toBottom), Integer.valueOf(toTop), Integer.valueOf(toCenter), Integer.valueOf(toDisplayBottom));
        Iterator it4 = $this$firstOrNull$iv2.iterator();
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            Object element$iv2 = it4.next();
            int it5 = ((Number) element$iv2).intValue();
            if (it5 >= verticalMargin) {
                contentOffsetX = contentOffsetX2;
                if (it5 + IntSize.m4541getHeightimpl(popupContentSize) <= IntSize.m4541getHeightimpl(windowSize) - verticalMargin) {
                    it = 1;
                    if (it == 0) {
                        obj = element$iv2;
                        break;
                    }
                    contentOffsetX2 = contentOffsetX;
                }
            } else {
                contentOffsetX = contentOffsetX2;
            }
            it = 0;
            if (it == 0) {
            }
        }
        Integer num2 = (Integer) obj;
        int y = num2 != null ? num2.intValue() : toTop;
        this.onPositionCalculated.invoke(anchorBounds, new IntRect(x, y, x + IntSize.m4542getWidthimpl(popupContentSize), y + IntSize.m4541getHeightimpl(popupContentSize)));
        return IntOffsetKt.IntOffset(x, y);
    }
}
