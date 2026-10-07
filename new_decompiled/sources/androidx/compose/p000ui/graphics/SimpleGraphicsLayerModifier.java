package androidx.compose.p000ui.graphics;

import androidx.compose.p000ui.layout.LayoutModifier;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.p000ui.platform.InspectorValueInfo;
import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GraphicsLayerModifier.kt */
@Metadata(m286d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B£\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a¢\u0006\u0002\b\u001dø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0013\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020(H\u0016J)\u0010)\u001a\u00020**\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001a\u00020\u0017X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010\r\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010 \u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001c0\u001a¢\u0006\u0002\b\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\u00020\u0017X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001fR\u0019\u0010\u000e\u001a\u00020\u000fX\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00062"}, m287d2 = {"Landroidx/compose/ui/graphics/SimpleGraphicsLayerModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "layerBlock", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "equals", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class SimpleGraphicsLayerModifier extends InspectorValueInfo implements LayoutModifier {
    private final float alpha;
    private final long ambientShadowColor;
    private final float cameraDistance;
    private final boolean clip;
    private final Function1<GraphicsLayerScope, Unit> layerBlock;
    private final RenderEffect renderEffect;
    private final float rotationX;
    private final float rotationY;
    private final float rotationZ;
    private final float scaleX;
    private final float scaleY;
    private final float shadowElevation;
    private final Shape shape;
    private final long spotShadowColor;
    private final long transformOrigin;
    private final float translationX;
    private final float translationY;

    public /* synthetic */ SimpleGraphicsLayerModifier(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, RenderEffect renderEffect, long j2, long j3, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, j, shape, z, renderEffect, j2, j3, function1);
    }

    private SimpleGraphicsLayerModifier(float scaleX, float scaleY, float alpha, float translationX, float translationY, float shadowElevation, float rotationX, float rotationY, float rotationZ, float cameraDistance, long transformOrigin, Shape shape, boolean clip, RenderEffect renderEffect, long ambientShadowColor, long spotShadowColor, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.alpha = alpha;
        this.translationX = translationX;
        this.translationY = translationY;
        this.shadowElevation = shadowElevation;
        this.rotationX = rotationX;
        this.rotationY = rotationY;
        this.rotationZ = rotationZ;
        this.cameraDistance = cameraDistance;
        this.transformOrigin = transformOrigin;
        this.shape = shape;
        this.clip = clip;
        this.renderEffect = renderEffect;
        this.ambientShadowColor = ambientShadowColor;
        this.spotShadowColor = spotShadowColor;
        this.layerBlock = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.graphics.SimpleGraphicsLayerModifier$layerBlock$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GraphicsLayerScope $this$null) {
                float f;
                float f2;
                float f3;
                float f4;
                float f5;
                float f6;
                float f7;
                float f8;
                float f9;
                float f10;
                long j;
                Shape shape2;
                boolean z;
                RenderEffect renderEffect2;
                long j2;
                long j3;
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                f = SimpleGraphicsLayerModifier.this.scaleX;
                $this$null.setScaleX(f);
                f2 = SimpleGraphicsLayerModifier.this.scaleY;
                $this$null.setScaleY(f2);
                f3 = SimpleGraphicsLayerModifier.this.alpha;
                $this$null.setAlpha(f3);
                f4 = SimpleGraphicsLayerModifier.this.translationX;
                $this$null.setTranslationX(f4);
                f5 = SimpleGraphicsLayerModifier.this.translationY;
                $this$null.setTranslationY(f5);
                f6 = SimpleGraphicsLayerModifier.this.shadowElevation;
                $this$null.setShadowElevation(f6);
                f7 = SimpleGraphicsLayerModifier.this.rotationX;
                $this$null.setRotationX(f7);
                f8 = SimpleGraphicsLayerModifier.this.rotationY;
                $this$null.setRotationY(f8);
                f9 = SimpleGraphicsLayerModifier.this.rotationZ;
                $this$null.setRotationZ(f9);
                f10 = SimpleGraphicsLayerModifier.this.cameraDistance;
                $this$null.setCameraDistance(f10);
                j = SimpleGraphicsLayerModifier.this.transformOrigin;
                $this$null.mo2157setTransformOrigin__ExYCQ(j);
                shape2 = SimpleGraphicsLayerModifier.this.shape;
                $this$null.setShape(shape2);
                z = SimpleGraphicsLayerModifier.this.clip;
                $this$null.setClip(z);
                renderEffect2 = SimpleGraphicsLayerModifier.this.renderEffect;
                $this$null.setRenderEffect(renderEffect2);
                j2 = SimpleGraphicsLayerModifier.this.ambientShadowColor;
                $this$null.mo2155setAmbientShadowColor8_81llA(j2);
                j3 = SimpleGraphicsLayerModifier.this.spotShadowColor;
                $this$null.mo2156setSpotShadowColor8_81llA(j3);
            }
        };
    }

    @Override // androidx.compose.p000ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo346measure3p2s80s(MeasureScope measure, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable placeable = measurable.mo3492measureBRTryo0(constraints);
        return MeasureScope.layout$default(measure, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.graphics.SimpleGraphicsLayerModifier$measure$1
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
            public final void invoke2(Placeable.PlacementScope layout) {
                Function1 function1;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable placeable2 = Placeable.this;
                function1 = this.layerBlock;
                Placeable.PlacementScope.placeWithLayer$default(layout, placeable2, 0, 0, 0.0f, function1, 4, null);
            }
        }, 4, null);
    }

    public int hashCode() {
        int result = Float.hashCode(this.scaleX);
        int result2 = ((((((((((((((((((((((((result * 31) + Float.hashCode(this.scaleY)) * 31) + Float.hashCode(this.alpha)) * 31) + Float.hashCode(this.translationX)) * 31) + Float.hashCode(this.translationY)) * 31) + Float.hashCode(this.shadowElevation)) * 31) + Float.hashCode(this.rotationX)) * 31) + Float.hashCode(this.rotationY)) * 31) + Float.hashCode(this.rotationZ)) * 31) + Float.hashCode(this.cameraDistance)) * 31) + TransformOrigin.m2335hashCodeimpl(this.transformOrigin)) * 31) + this.shape.hashCode()) * 31) + Boolean.hashCode(this.clip)) * 31;
        RenderEffect renderEffect = this.renderEffect;
        return ((((result2 + (renderEffect != null ? renderEffect.hashCode() : 0)) * 31) + Color.m2003hashCodeimpl(this.ambientShadowColor)) * 31) + Color.m2003hashCodeimpl(this.spotShadowColor);
    }

    public boolean equals(Object other) {
        SimpleGraphicsLayerModifier otherModifier = other instanceof SimpleGraphicsLayerModifier ? (SimpleGraphicsLayerModifier) other : null;
        if (otherModifier == null) {
            return false;
        }
        if (!(this.scaleX == otherModifier.scaleX)) {
            return false;
        }
        if (!(this.scaleY == otherModifier.scaleY)) {
            return false;
        }
        if (!(this.alpha == otherModifier.alpha)) {
            return false;
        }
        if (!(this.translationX == otherModifier.translationX)) {
            return false;
        }
        if (!(this.translationY == otherModifier.translationY)) {
            return false;
        }
        if (!(this.shadowElevation == otherModifier.shadowElevation)) {
            return false;
        }
        if (!(this.rotationX == otherModifier.rotationX)) {
            return false;
        }
        if (!(this.rotationY == otherModifier.rotationY)) {
            return false;
        }
        if (this.rotationZ == otherModifier.rotationZ) {
            return ((this.cameraDistance > otherModifier.cameraDistance ? 1 : (this.cameraDistance == otherModifier.cameraDistance ? 0 : -1)) == 0) && TransformOrigin.m2332equalsimpl0(this.transformOrigin, otherModifier.transformOrigin) && Intrinsics.areEqual(this.shape, otherModifier.shape) && this.clip == otherModifier.clip && Intrinsics.areEqual(this.renderEffect, otherModifier.renderEffect) && Color.m1997equalsimpl0(this.ambientShadowColor, otherModifier.ambientShadowColor) && Color.m1997equalsimpl0(this.spotShadowColor, otherModifier.spotShadowColor);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SimpleGraphicsLayerModifier(scaleX=").append(this.scaleX).append(", scaleY=").append(this.scaleY).append(", alpha = ").append(this.alpha).append(", translationX=").append(this.translationX).append(", translationY=").append(this.translationY).append(", shadowElevation=").append(this.shadowElevation).append(", rotationX=").append(this.rotationX).append(", rotationY=").append(this.rotationY).append(", rotationZ=").append(this.rotationZ).append(", cameraDistance=").append(this.cameraDistance).append(", transformOrigin=").append((Object) TransformOrigin.m2336toStringimpl(this.transformOrigin)).append(", shape=");
        sb.append(this.shape).append(", clip=").append(this.clip).append(", renderEffect=").append(this.renderEffect).append(", ambientShadowColor=").append((Object) Color.m2004toStringimpl(this.ambientShadowColor)).append(", spotShadowColor=").append((Object) Color.m2004toStringimpl(this.spotShadowColor)).append(')');
        return sb.toString();
    }
}
