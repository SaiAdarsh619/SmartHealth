package androidx.compose.p000ui.draw;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.BlurEffect;
import androidx.compose.p000ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p000ui.graphics.GraphicsLayerScope;
import androidx.compose.p000ui.graphics.RectangleShapeKt;
import androidx.compose.p000ui.graphics.RenderEffectKt;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.graphics.TileMode;
import androidx.compose.p000ui.unit.C0504Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Blur.kt */
@Metadata(m286d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, m287d2 = {"blur", "Landroidx/compose/ui/Modifier;", "radius", "Landroidx/compose/ui/unit/Dp;", "edgeTreatment", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "blur-F8QBwvs", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "radiusX", "radiusY", "blur-1fqS-gw", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class BlurKt {
    /* renamed from: blur-1fqS-gw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1659blur1fqSgw$default(Modifier modifier, float f, float f2, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 4) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m1662boximpl(BlurredEdgeTreatment.INSTANCE.m1669getRectangleGoahg());
        }
        return m1658blur1fqSgw(modifier, f, f2, blurredEdgeTreatment.m1668unboximpl());
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0030, code lost:
    
        if (r2 <= 0) goto L10;
     */
    /* renamed from: blur-1fqS-gw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Modifier m1658blur1fqSgw(Modifier blur, final float radiusX, final float radiusY, final Shape edgeTreatment) {
        boolean clip;
        int tileMode;
        Intrinsics.checkNotNullParameter(blur, "$this$blur");
        if (edgeTreatment != null) {
            clip = true;
            tileMode = TileMode.INSTANCE.m2320getClamp3opZhB0();
        } else {
            clip = false;
            tileMode = TileMode.INSTANCE.m2321getDecal3opZhB0();
        }
        int $this$dp$iv = C0504Dp.m4381compareTo0680j_4(radiusX, C0504Dp.m4382constructorimpl(0));
        if ($this$dp$iv > 0) {
            int $this$dp$iv2 = C0504Dp.m4381compareTo0680j_4(radiusY, C0504Dp.m4382constructorimpl(0));
        }
        if (!clip) {
            return blur;
        }
        final int i = tileMode;
        final boolean z = clip;
        return GraphicsLayerModifierKt.graphicsLayer(blur, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.draw.BlurKt$blur$1
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
                BlurEffect blurEffect;
                Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                float horizontalBlurPixels = graphicsLayer.mo648toPx0680j_4(radiusX);
                float verticalBlurPixels = graphicsLayer.mo648toPx0680j_4(radiusY);
                if (horizontalBlurPixels > 0.0f && verticalBlurPixels > 0.0f) {
                    blurEffect = RenderEffectKt.m2264BlurEffect3YTHUZs(horizontalBlurPixels, verticalBlurPixels, i);
                } else {
                    blurEffect = null;
                }
                graphicsLayer.setRenderEffect(blurEffect);
                Shape shape = edgeTreatment;
                if (shape == null) {
                    shape = RectangleShapeKt.getRectangleShape();
                }
                graphicsLayer.setShape(shape);
                graphicsLayer.setClip(z);
            }
        });
    }

    /* renamed from: blur-F8QBwvs$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1661blurF8QBwvs$default(Modifier modifier, float f, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m1662boximpl(BlurredEdgeTreatment.INSTANCE.m1669getRectangleGoahg());
        }
        return m1660blurF8QBwvs(modifier, f, blurredEdgeTreatment.m1668unboximpl());
    }

    /* renamed from: blur-F8QBwvs, reason: not valid java name */
    public static final Modifier m1660blurF8QBwvs(Modifier blur, float radius, Shape edgeTreatment) {
        Intrinsics.checkNotNullParameter(blur, "$this$blur");
        return m1658blur1fqSgw(blur, radius, radius, edgeTreatment);
    }
}
