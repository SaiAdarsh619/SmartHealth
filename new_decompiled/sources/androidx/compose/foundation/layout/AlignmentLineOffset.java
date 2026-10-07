package androidx.compose.foundation.layout;

import androidx.compose.p000ui.layout.AlignmentLine;
import androidx.compose.p000ui.layout.LayoutModifier;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.p000ui.platform.InspectorValueInfo;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.TextUnit;
import androidx.compose.p000ui.unit.TextUnitKt;
import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlignmentLine.kt */
@Metadata(m286d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J)\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$R\u001c\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000f\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, m287d2 = {"Landroidx/compose/foundation/layout/AlignmentLineOffsetTextUnit;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "before", "Landroidx/compose/ui/unit/TextUnit;", "after", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/layout/AlignmentLine;JJLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfter-XSAIIZE", "()J", "J", "getAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "getBefore-XSAIIZE", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* renamed from: androidx.compose.foundation.layout.AlignmentLineOffsetTextUnit, reason: from toString */
/* loaded from: classes.dex */
final class AlignmentLineOffset extends InspectorValueInfo implements LayoutModifier {
    private final long after;
    private final AlignmentLine alignmentLine;
    private final long before;

    public /* synthetic */ AlignmentLineOffset(AlignmentLine alignmentLine, long j, long j2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignmentLine, j, j2, function1);
    }

    public final AlignmentLine getAlignmentLine() {
        return this.alignmentLine;
    }

    /* renamed from: getBefore-XSAIIZE, reason: not valid java name and from getter */
    public final long getBefore() {
        return this.before;
    }

    /* renamed from: getAfter-XSAIIZE, reason: not valid java name and from getter */
    public final long getAfter() {
        return this.after;
    }

    private AlignmentLineOffset(AlignmentLine alignmentLine, long before, long after, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.alignmentLine = alignmentLine;
        this.before = before;
        this.after = after;
    }

    @Override // androidx.compose.p000ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo346measure3p2s80s(MeasureScope measure, Measurable measurable, long constraints) {
        MeasureResult m681alignmentLineOffsetMeasuretjqqzMA;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        m681alignmentLineOffsetMeasuretjqqzMA = AlignmentLineKt.m681alignmentLineOffsetMeasuretjqqzMA(measure, this.alignmentLine, !TextUnitKt.m4581isUnspecifiedR2X_6o(this.before) ? measure.mo643toDpGaN1DYA(this.before) : C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM(), !TextUnitKt.m4581isUnspecifiedR2X_6o(this.after) ? measure.mo643toDpGaN1DYA(this.after) : C0504Dp.INSTANCE.m4402getUnspecifiedD9Ej5fM(), measurable, constraints);
        return m681alignmentLineOffsetMeasuretjqqzMA;
    }

    public int hashCode() {
        int result = this.alignmentLine.hashCode();
        return (((result * 31) + TextUnit.m4564hashCodeimpl(this.before)) * 31) + TextUnit.m4564hashCodeimpl(this.after);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        AlignmentLineOffset otherModifier = other instanceof AlignmentLineOffset ? (AlignmentLineOffset) other : null;
        if (otherModifier == null) {
            return false;
        }
        return Intrinsics.areEqual(this.alignmentLine, otherModifier.alignmentLine) && TextUnit.m4560equalsimpl0(this.before, otherModifier.before) && TextUnit.m4560equalsimpl0(this.after, otherModifier.after);
    }

    public String toString() {
        return "AlignmentLineOffset(alignmentLine=" + this.alignmentLine + ", before=" + ((Object) TextUnit.m4570toStringimpl(this.before)) + ", after=" + ((Object) TextUnit.m4570toStringimpl(this.after)) + ')';
    }
}
