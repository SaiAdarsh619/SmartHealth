package androidx.compose.p000ui.draw;

import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.geometry.SizeKt;
import androidx.compose.p000ui.graphics.ColorFilter;
import androidx.compose.p000ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p000ui.graphics.painter.Painter;
import androidx.compose.p000ui.layout.ContentScale;
import androidx.compose.p000ui.layout.IntrinsicMeasurable;
import androidx.compose.p000ui.layout.IntrinsicMeasureScope;
import androidx.compose.p000ui.layout.LayoutModifier;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.layout.ScaleFactorKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.p000ui.platform.InspectorValueInfo;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.IntSizeKt;
import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: PainterModifier.kt */
@Metadata(m286d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BX\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\u0010\u0015J\u001d\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\u0013\u0010)\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010+H\u0096\u0002J\b\u0010,\u001a\u00020-H\u0016J\u001d\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010(J\b\u00102\u001a\u000203H\u0016J\f\u00104\u001a\u00020\u0013*\u000205H\u0016J\u0019\u00106\u001a\u00020\u0007*\u00020%H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00108J\u0019\u00109\u001a\u00020\u0007*\u00020%H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u00108J\u001c\u0010;\u001a\u00020-*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020-H\u0016J\u001c\u0010@\u001a\u00020-*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010A\u001a\u00020-H\u0016J)\u0010B\u001a\u00020C*\u00020D2\u0006\u0010=\u001a\u00020E2\u0006\u00100\u001a\u00020/H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bF\u0010GJ\u001c\u0010H\u001a\u00020-*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020-H\u0016J\u001c\u0010I\u001a\u00020-*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010A\u001a\u00020-H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006J"}, m287d2 = {"Landroidx/compose/ui/draw/PainterModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Lkotlin/jvm/functions/Function1;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getAlpha", "()F", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getSizeToIntrinsics", "()Z", "useIntrinsicSize", "getUseIntrinsicSize", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "equals", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "toString", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class PainterModifier extends InspectorValueInfo implements LayoutModifier, DrawModifier {
    private final Alignment alignment;
    private final float alpha;
    private final ColorFilter colorFilter;
    private final ContentScale contentScale;
    private final Painter painter;
    private final boolean sizeToIntrinsics;

    public /* synthetic */ PainterModifier(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, z, (i & 4) != 0 ? Alignment.INSTANCE.getCenter() : alignment, (i & 8) != 0 ? ContentScale.INSTANCE.getInside() : contentScale, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : colorFilter, function1);
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PainterModifier(Painter painter, boolean sizeToIntrinsics, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        Intrinsics.checkNotNullParameter(painter, "painter");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.painter = painter;
        this.sizeToIntrinsics = sizeToIntrinsics;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = alpha;
        this.colorFilter = colorFilter;
    }

    private final boolean getUseIntrinsicSize() {
        if (!this.sizeToIntrinsics) {
            return false;
        }
        long $this$isSpecified$iv = this.painter.getIntrinsicSize();
        return (($this$isSpecified$iv > Size.INSTANCE.m1837getUnspecifiedNHjbRc() ? 1 : ($this$isSpecified$iv == Size.INSTANCE.m1837getUnspecifiedNHjbRc() ? 0 : -1)) != 0 ? 1 : 0) != 0;
    }

    @Override // androidx.compose.p000ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo346measure3p2s80s(MeasureScope measure, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable placeable = measurable.mo3492measureBRTryo0(m1676modifyConstraintsZezNO4M(constraints));
        return MeasureScope.layout$default(measure, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterModifier$measure$1
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
        if (getUseIntrinsicSize()) {
            long constraints = m1676modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, height, 7, null));
            int layoutWidth = measurable.minIntrinsicWidth(height);
            return Math.max(Constraints.m4340getMinWidthimpl(constraints), layoutWidth);
        }
        return measurable.minIntrinsicWidth(height);
    }

    @Override // androidx.compose.p000ui.layout.LayoutModifier
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long constraints = m1676modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, height, 7, null));
            int layoutWidth = measurable.maxIntrinsicWidth(height);
            return Math.max(Constraints.m4340getMinWidthimpl(constraints), layoutWidth);
        }
        return measurable.maxIntrinsicWidth(height);
    }

    @Override // androidx.compose.p000ui.layout.LayoutModifier
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long constraints = m1676modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, width, 0, 0, 13, null));
            int layoutHeight = measurable.minIntrinsicHeight(width);
            return Math.max(Constraints.m4339getMinHeightimpl(constraints), layoutHeight);
        }
        return measurable.minIntrinsicHeight(width);
    }

    @Override // androidx.compose.p000ui.layout.LayoutModifier
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long constraints = m1676modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, width, 0, 0, 13, null));
            int layoutHeight = measurable.maxIntrinsicHeight(width);
            return Math.max(Constraints.m4339getMinHeightimpl(constraints), layoutHeight);
        }
        return measurable.maxIntrinsicHeight(width);
    }

    /* renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m1673calculateScaledSizeE7KxVPU(long dstSize) {
        float srcWidth;
        float srcHeight;
        if (!getUseIntrinsicSize()) {
            return dstSize;
        }
        if (!m1675hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.getIntrinsicSize())) {
            srcWidth = Size.m1829getWidthimpl(dstSize);
        } else {
            srcWidth = Size.m1829getWidthimpl(this.painter.getIntrinsicSize());
        }
        if (!m1674hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.getIntrinsicSize())) {
            srcHeight = Size.m1826getHeightimpl(dstSize);
        } else {
            srcHeight = Size.m1826getHeightimpl(this.painter.getIntrinsicSize());
        }
        long srcSize = SizeKt.Size(srcWidth, srcHeight);
        if (!(Size.m1829getWidthimpl(dstSize) == 0.0f)) {
            if (!(Size.m1826getHeightimpl(dstSize) == 0.0f)) {
                return ScaleFactorKt.m3574timesUQTWf7w(srcSize, this.contentScale.mo3483computeScaleFactorH7hwNQA(srcSize, dstSize));
            }
        }
        return Size.INSTANCE.m1838getZeroNHjbRc();
    }

    /* renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m1676modifyConstraintsZezNO4M(long constraints) {
        int m4340getMinWidthimpl;
        int m4339getMinHeightimpl;
        long m4328copyZbe2FdA;
        long m4328copyZbe2FdA2;
        boolean hasBoundedDimens = Constraints.m4334getHasBoundedWidthimpl(constraints) && Constraints.m4333getHasBoundedHeightimpl(constraints);
        boolean hasFixedDimens = Constraints.m4336getHasFixedWidthimpl(constraints) && Constraints.m4335getHasFixedHeightimpl(constraints);
        if ((!getUseIntrinsicSize() && hasBoundedDimens) || hasFixedDimens) {
            m4328copyZbe2FdA2 = Constraints.m4328copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m4340getMinWidthimpl(constraints) : Constraints.m4338getMaxWidthimpl(constraints), (r12 & 2) != 0 ? Constraints.m4338getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m4339getMinHeightimpl(constraints) : Constraints.m4337getMaxHeightimpl(constraints), (r12 & 8) != 0 ? Constraints.m4337getMaxHeightimpl(constraints) : 0);
            return m4328copyZbe2FdA2;
        }
        long intrinsicSize = this.painter.getIntrinsicSize();
        if (m1675hasSpecifiedAndFiniteWidthuvyYCjk(intrinsicSize)) {
            m4340getMinWidthimpl = MathKt.roundToInt(Size.m1829getWidthimpl(intrinsicSize));
        } else {
            m4340getMinWidthimpl = Constraints.m4340getMinWidthimpl(constraints);
        }
        int intrinsicWidth = m4340getMinWidthimpl;
        if (m1674hasSpecifiedAndFiniteHeightuvyYCjk(intrinsicSize)) {
            m4339getMinHeightimpl = MathKt.roundToInt(Size.m1826getHeightimpl(intrinsicSize));
        } else {
            m4339getMinHeightimpl = Constraints.m4339getMinHeightimpl(constraints);
        }
        int intrinsicHeight = m4339getMinHeightimpl;
        int constrainedWidth = ConstraintsKt.m4352constrainWidthK40F9xA(constraints, intrinsicWidth);
        int constrainedHeight = ConstraintsKt.m4351constrainHeightK40F9xA(constraints, intrinsicHeight);
        long scaledSize = m1673calculateScaledSizeE7KxVPU(SizeKt.Size(constrainedWidth, constrainedHeight));
        int minWidth = ConstraintsKt.m4352constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.m1829getWidthimpl(scaledSize)));
        int minHeight = ConstraintsKt.m4351constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.m1826getHeightimpl(scaledSize)));
        m4328copyZbe2FdA = Constraints.m4328copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m4340getMinWidthimpl(constraints) : minWidth, (r12 & 2) != 0 ? Constraints.m4338getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m4339getMinHeightimpl(constraints) : minHeight, (r12 & 8) != 0 ? Constraints.m4337getMaxHeightimpl(constraints) : 0);
        return m4328copyZbe2FdA;
    }

    @Override // androidx.compose.p000ui.draw.DrawModifier
    public void draw(ContentDrawScope $this$draw) {
        float srcWidth;
        float srcHeight;
        long scaledSize;
        Intrinsics.checkNotNullParameter($this$draw, "<this>");
        long intrinsicSize = this.painter.getIntrinsicSize();
        if (m1675hasSpecifiedAndFiniteWidthuvyYCjk(intrinsicSize)) {
            srcWidth = Size.m1829getWidthimpl(intrinsicSize);
        } else {
            srcWidth = Size.m1829getWidthimpl($this$draw.mo2490getSizeNHjbRc());
        }
        if (m1674hasSpecifiedAndFiniteHeightuvyYCjk(intrinsicSize)) {
            srcHeight = Size.m1826getHeightimpl(intrinsicSize);
        } else {
            srcHeight = Size.m1826getHeightimpl($this$draw.mo2490getSizeNHjbRc());
        }
        long srcSize = SizeKt.Size(srcWidth, srcHeight);
        if (!(Size.m1829getWidthimpl($this$draw.mo2490getSizeNHjbRc()) == 0.0f)) {
            if (!(Size.m1826getHeightimpl($this$draw.mo2490getSizeNHjbRc()) == 0.0f)) {
                scaledSize = ScaleFactorKt.m3574timesUQTWf7w(srcSize, this.contentScale.mo3483computeScaleFactorH7hwNQA(srcSize, $this$draw.mo2490getSizeNHjbRc()));
                long alignedPosition = this.alignment.mo1656alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m1829getWidthimpl(scaledSize)), MathKt.roundToInt(Size.m1826getHeightimpl(scaledSize))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m1829getWidthimpl($this$draw.mo2490getSizeNHjbRc())), MathKt.roundToInt(Size.m1826getHeightimpl($this$draw.mo2490getSizeNHjbRc()))), $this$draw.getLayoutDirection());
                float dx = IntOffset.m4500getXimpl(alignedPosition);
                float dy = IntOffset.m4501getYimpl(alignedPosition);
                ContentDrawScope $this$translate$iv = $this$draw;
                $this$translate$iv.getDrawContext().getTransform().translate(dx, dy);
                this.painter.m2565drawx_KDEd0($this$translate$iv, scaledSize, this.alpha, this.colorFilter);
                $this$translate$iv.getDrawContext().getTransform().translate(-dx, -dy);
                $this$draw.drawContent();
            }
        }
        scaledSize = Size.INSTANCE.m1838getZeroNHjbRc();
        long alignedPosition2 = this.alignment.mo1656alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m1829getWidthimpl(scaledSize)), MathKt.roundToInt(Size.m1826getHeightimpl(scaledSize))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m1829getWidthimpl($this$draw.mo2490getSizeNHjbRc())), MathKt.roundToInt(Size.m1826getHeightimpl($this$draw.mo2490getSizeNHjbRc()))), $this$draw.getLayoutDirection());
        float dx2 = IntOffset.m4500getXimpl(alignedPosition2);
        float dy2 = IntOffset.m4501getYimpl(alignedPosition2);
        ContentDrawScope $this$translate$iv2 = $this$draw;
        $this$translate$iv2.getDrawContext().getTransform().translate(dx2, dy2);
        this.painter.m2565drawx_KDEd0($this$translate$iv2, scaledSize, this.alpha, this.colorFilter);
        $this$translate$iv2.getDrawContext().getTransform().translate(-dx2, -dy2);
        $this$draw.drawContent();
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    private final boolean m1675hasSpecifiedAndFiniteWidthuvyYCjk(long $this$hasSpecifiedAndFiniteWidth_u2duvyYCjk) {
        if (Size.m1825equalsimpl0($this$hasSpecifiedAndFiniteWidth_u2duvyYCjk, Size.INSTANCE.m1837getUnspecifiedNHjbRc())) {
            return false;
        }
        float m1829getWidthimpl = Size.m1829getWidthimpl($this$hasSpecifiedAndFiniteWidth_u2duvyYCjk);
        return !Float.isInfinite(m1829getWidthimpl) && !Float.isNaN(m1829getWidthimpl);
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    private final boolean m1674hasSpecifiedAndFiniteHeightuvyYCjk(long $this$hasSpecifiedAndFiniteHeight_u2duvyYCjk) {
        if (Size.m1825equalsimpl0($this$hasSpecifiedAndFiniteHeight_u2duvyYCjk, Size.INSTANCE.m1837getUnspecifiedNHjbRc())) {
            return false;
        }
        float m1826getHeightimpl = Size.m1826getHeightimpl($this$hasSpecifiedAndFiniteHeight_u2duvyYCjk);
        return !Float.isInfinite(m1826getHeightimpl) && !Float.isNaN(m1826getHeightimpl);
    }

    public int hashCode() {
        int result = this.painter.hashCode();
        int result2 = ((((((((result * 31) + Boolean.hashCode(this.sizeToIntrinsics)) * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.hashCode(this.alpha)) * 31;
        ColorFilter colorFilter = this.colorFilter;
        return result2 + (colorFilter != null ? colorFilter.hashCode() : 0);
    }

    public boolean equals(Object other) {
        PainterModifier otherModifier = other instanceof PainterModifier ? (PainterModifier) other : null;
        if (otherModifier != null && Intrinsics.areEqual(this.painter, otherModifier.painter) && this.sizeToIntrinsics == otherModifier.sizeToIntrinsics && Intrinsics.areEqual(this.alignment, otherModifier.alignment) && Intrinsics.areEqual(this.contentScale, otherModifier.contentScale)) {
            return ((this.alpha > otherModifier.alpha ? 1 : (this.alpha == otherModifier.alpha ? 0 : -1)) == 0) && Intrinsics.areEqual(this.colorFilter, otherModifier.colorFilter);
        }
        return false;
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
