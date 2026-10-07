package androidx.compose.foundation;

import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.CacheDrawScope;
import androidx.compose.p000ui.draw.DrawModifierKt;
import androidx.compose.p000ui.draw.DrawResult;
import androidx.compose.p000ui.geometry.CornerRadius;
import androidx.compose.p000ui.geometry.CornerRadiusKt;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.geometry.RoundRect;
import androidx.compose.p000ui.geometry.RoundRectKt;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.geometry.SizeKt;
import androidx.compose.p000ui.graphics.AndroidPath_androidKt;
import androidx.compose.p000ui.graphics.BlendMode;
import androidx.compose.p000ui.graphics.Brush;
import androidx.compose.p000ui.graphics.Canvas;
import androidx.compose.p000ui.graphics.ClipOp;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.ColorFilter;
import androidx.compose.p000ui.graphics.ImageBitmap;
import androidx.compose.p000ui.graphics.ImageBitmapConfig;
import androidx.compose.p000ui.graphics.ImageBitmapKt;
import androidx.compose.p000ui.graphics.Outline;
import androidx.compose.p000ui.graphics.Path;
import androidx.compose.p000ui.graphics.PathOperation;
import androidx.compose.p000ui.graphics.RectangleShapeKt;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.graphics.SolidColor;
import androidx.compose.p000ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.p000ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p000ui.graphics.drawscope.DrawContext;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.graphics.drawscope.DrawStyle;
import androidx.compose.p000ui.graphics.drawscope.DrawTransform;
import androidx.compose.p000ui.graphics.drawscope.Fill;
import androidx.compose.p000ui.graphics.drawscope.Stroke;
import androidx.compose.p000ui.node.Ref;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.IntSizeKt;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: Border.kt */
@Metadata(m286d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\u000b\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a/\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a1\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\u001cH\u0002\u001a:\u0010\u001d\u001a\u00020\u001b*\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001aA\u0010#\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u001aW\u0010+\u001a\u00020\u001b*\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010!\u001a\u00020,2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.\u001a\u0012\u0010/\u001a\u00020 *\b\u0012\u0004\u0012\u00020 0\u001fH\u0002\u001a!\u00100\u001a\u000201*\u0002012\u0006\u00102\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00065"}, m287d2 = {"createInsetRoundedRect", "Landroidx/compose/ui/geometry/RoundRect;", "widthPx", "", "roundedRect", "createRoundRectPath", "Landroidx/compose/ui/graphics/Path;", "targetPath", "strokeWidth", "fillArea", "", OutlinedTextFieldKt.BorderId, "Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/BorderStroke;", "shape", "Landroidx/compose/ui/graphics/Shape;", "width", "Landroidx/compose/ui/unit/Dp;", "brush", "Landroidx/compose/ui/graphics/Brush;", "border-ziNgDLE", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "border-xT4_qwU", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "drawContentWithoutBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "drawGenericBorder", "borderCacheRef", "Landroidx/compose/ui/node/Ref;", "Landroidx/compose/foundation/BorderCache;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "drawRectBorder", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "strokeWidthPx", "drawRectBorder-NsqcLGU", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;JJZF)Landroidx/compose/ui/draw/DrawResult;", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "drawRoundRectBorder-SYlcjDY", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/node/Ref;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "obtain", "shrink", "Landroidx/compose/ui/geometry/CornerRadius;", "value", "shrink-Kibmq7A", "(JF)J", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class BorderKt {
    public static /* synthetic */ Modifier border$default(Modifier modifier, BorderStroke borderStroke, Shape shape, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return border(modifier, borderStroke, shape);
    }

    public static final Modifier border(Modifier $this$border, BorderStroke border, Shape shape) {
        Intrinsics.checkNotNullParameter($this$border, "<this>");
        Intrinsics.checkNotNullParameter(border, "border");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m502borderziNgDLE($this$border, border.getWidth(), border.getBrush(), shape);
    }

    /* renamed from: border-xT4_qwU$default, reason: not valid java name */
    public static /* synthetic */ Modifier m501borderxT4_qwU$default(Modifier modifier, float f, long j, Shape shape, int i, Object obj) {
        if ((i & 4) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return m500borderxT4_qwU(modifier, f, j, shape);
    }

    /* renamed from: border-xT4_qwU, reason: not valid java name */
    public static final Modifier m500borderxT4_qwU(Modifier border, float width, long color, Shape shape) {
        Intrinsics.checkNotNullParameter(border, "$this$border");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m502borderziNgDLE(border, width, new SolidColor(color, null), shape);
    }

    /* renamed from: border-ziNgDLE, reason: not valid java name */
    public static final Modifier m502borderziNgDLE(Modifier border, final float width, final Brush brush, final Shape shape) {
        Intrinsics.checkNotNullParameter(border, "$this$border");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return ComposedModifierKt.composed(border, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.BorderKt$border-ziNgDLE$$inlined$debugInspectorInfo$1
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
                $this$null.setName(OutlinedTextFieldKt.BorderId);
                $this$null.getProperties().set("width", C0504Dp.m4380boximpl(width));
                if (brush instanceof SolidColor) {
                    $this$null.getProperties().set("color", Color.m1986boximpl(((SolidColor) brush).getValue()));
                    $this$null.setValue(Color.m1986boximpl(((SolidColor) brush).getValue()));
                } else {
                    $this$null.getProperties().set("brush", brush);
                }
                $this$null.getProperties().set("shape", shape);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.BorderKt$border$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Object value$iv$iv;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(-1498088849);
                ComposerKt.sourceInformation($composer, "C97@4024L31:Border.kt#71ulvw");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1498088849, $changed, -1, "androidx.compose.foundation.border.<anonymous> (Border.kt:93)");
                }
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv = $composer.rememberedValue();
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = new Ref();
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                final Ref borderCacheRef = (Ref) value$iv$iv;
                Modifier.Companion companion = Modifier.INSTANCE;
                final float f = width;
                final Shape shape2 = shape;
                final Brush brush2 = brush;
                Modifier then = composed.then(DrawModifierKt.drawWithCache(companion, new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.BorderKt$border$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DrawResult invoke(CacheDrawScope drawWithCache) {
                        DrawResult m503drawRectBorderNsqcLGU;
                        DrawResult m504drawRoundRectBorderSYlcjDY;
                        DrawResult drawGenericBorder;
                        DrawResult drawContentWithoutBorder;
                        Intrinsics.checkNotNullParameter(drawWithCache, "$this$drawWithCache");
                        boolean hasValidBorderParams = drawWithCache.mo648toPx0680j_4(f) >= 0.0f && Size.m1828getMinDimensionimpl(drawWithCache.m1672getSizeNHjbRc()) > 0.0f;
                        if (!hasValidBorderParams) {
                            drawContentWithoutBorder = BorderKt.drawContentWithoutBorder(drawWithCache);
                            return drawContentWithoutBorder;
                        }
                        float f2 = 2;
                        float strokeWidthPx = Math.min(C0504Dp.m4387equalsimpl0(f, C0504Dp.INSTANCE.m4400getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil(drawWithCache.mo648toPx0680j_4(f)), (float) Math.ceil(Size.m1828getMinDimensionimpl(drawWithCache.m1672getSizeNHjbRc()) / f2));
                        float halfStroke = strokeWidthPx / f2;
                        long topLeft = OffsetKt.Offset(halfStroke, halfStroke);
                        long borderSize = SizeKt.Size(Size.m1829getWidthimpl(drawWithCache.m1672getSizeNHjbRc()) - strokeWidthPx, Size.m1826getHeightimpl(drawWithCache.m1672getSizeNHjbRc()) - strokeWidthPx);
                        boolean fillArea = f2 * strokeWidthPx > Size.m1828getMinDimensionimpl(drawWithCache.m1672getSizeNHjbRc());
                        Outline outline = shape2.mo532createOutlinePq9zytI(drawWithCache.m1672getSizeNHjbRc(), drawWithCache.getLayoutDirection(), drawWithCache);
                        if (outline instanceof Outline.Generic) {
                            drawGenericBorder = BorderKt.drawGenericBorder(drawWithCache, borderCacheRef, brush2, (Outline.Generic) outline, fillArea, strokeWidthPx);
                            return drawGenericBorder;
                        }
                        if (outline instanceof Outline.Rounded) {
                            m504drawRoundRectBorderSYlcjDY = BorderKt.m504drawRoundRectBorderSYlcjDY(drawWithCache, borderCacheRef, brush2, (Outline.Rounded) outline, topLeft, borderSize, fillArea, strokeWidthPx);
                            return m504drawRoundRectBorderSYlcjDY;
                        }
                        if (outline instanceof Outline.Rectangle) {
                            m503drawRectBorderNsqcLGU = BorderKt.m503drawRectBorderNsqcLGU(drawWithCache, brush2, topLeft, borderSize, fillArea, strokeWidthPx);
                            return m503drawRectBorderNsqcLGU;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                }));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return then;
            }
        });
    }

    private static final BorderCache obtain(Ref<BorderCache> ref) {
        BorderCache value = ref.getValue();
        if (value != null) {
            return value;
        }
        BorderCache it = new BorderCache(null, null, null, null, 15, null);
        ref.setValue(it);
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult drawContentWithoutBorder(CacheDrawScope $this$drawContentWithoutBorder) {
        return $this$drawContentWithoutBorder.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderKt$drawContentWithoutBorder$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope onDrawWithContent) {
                Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                onDrawWithContent.drawContent();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00cd, code lost:
    
        if (androidx.compose.p000ui.graphics.ImageBitmapConfig.m2176equalsimpl(r13, r1 != null ? androidx.compose.p000ui.graphics.ImageBitmapConfig.m2174boximpl(r1.mo1868getConfig_sVssgQ()) : null) != false) goto L23;
     */
    /* JADX WARN: Type inference failed for: r37v2, types: [T, androidx.compose.ui.graphics.ImageBitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final DrawResult drawGenericBorder(CacheDrawScope $this$drawGenericBorder, Ref<BorderCache> ref, final Brush brush, final Outline.Generic outline, boolean fillArea, float strokeWidth) {
        int config;
        ColorFilter colorFilter;
        Ref.ObjectRef cacheImageBitmap;
        ImageBitmap targetImageBitmap$iv;
        Canvas targetCanvas$iv;
        if (fillArea) {
            return $this$drawGenericBorder.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderKt$drawGenericBorder$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                    invoke2(contentDrawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ContentDrawScope onDrawWithContent) {
                    Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                    onDrawWithContent.drawContent();
                    DrawScope.m2480drawPathGBMwjPU$default(onDrawWithContent, Outline.Generic.this.getPath(), brush, 0.0f, null, null, 0, 60, null);
                }
            });
        }
        if (brush instanceof SolidColor) {
            int config2 = ImageBitmapConfig.INSTANCE.m2181getAlpha8_sVssgQ();
            ColorFilter colorFilter2 = ColorFilter.Companion.m2037tintxETnrds$default(ColorFilter.INSTANCE, ((SolidColor) brush).getValue(), 0, 2, null);
            config = config2;
            colorFilter = colorFilter2;
        } else {
            int config3 = ImageBitmapConfig.INSTANCE.m2182getArgb8888_sVssgQ();
            config = config3;
            colorFilter = null;
        }
        final Rect pathBounds = outline.getPath().getBounds();
        BorderCache borderCache = obtain(ref);
        Path maskPath = borderCache.obtainPath();
        maskPath.reset();
        maskPath.addRect(pathBounds);
        maskPath.mo1893opN5in7k0(maskPath, outline.getPath(), PathOperation.INSTANCE.m2248getDifferenceb3I0S0c());
        Ref.ObjectRef cacheImageBitmap2 = new Ref.ObjectRef();
        final long pathBoundsSize = IntSizeKt.IntSize((int) Math.ceil(pathBounds.getWidth()), (int) Math.ceil(pathBounds.getHeight()));
        ImageBitmap targetImageBitmap$iv2 = borderCache.imageBitmap;
        Canvas targetCanvas$iv2 = borderCache.canvas;
        ImageBitmapConfig m2174boximpl = targetImageBitmap$iv2 != null ? ImageBitmapConfig.m2174boximpl(targetImageBitmap$iv2.mo1868getConfig_sVssgQ()) : null;
        boolean z = false;
        if (!(m2174boximpl == null ? false : ImageBitmapConfig.m2177equalsimpl0(m2174boximpl.m2180unboximpl(), ImageBitmapConfig.INSTANCE.m2182getArgb8888_sVssgQ()))) {
        }
        z = true;
        boolean compatibleConfig$iv = z;
        if (targetImageBitmap$iv2 == null || targetCanvas$iv2 == null || Size.m1829getWidthimpl($this$drawGenericBorder.m1672getSizeNHjbRc()) > targetImageBitmap$iv2.getWidth() || Size.m1826getHeightimpl($this$drawGenericBorder.m1672getSizeNHjbRc()) > targetImageBitmap$iv2.getHeight() || !compatibleConfig$iv) {
            cacheImageBitmap = cacheImageBitmap2;
            ImageBitmap it$iv = ImageBitmapKt.m2187ImageBitmapx__hDU$default(IntSize.m4542getWidthimpl(pathBoundsSize), IntSize.m4541getHeightimpl(pathBoundsSize), config, false, null, 24, null);
            borderCache.imageBitmap = it$iv;
            Canvas it$iv2 = androidx.compose.p000ui.graphics.CanvasKt.Canvas(it$iv);
            borderCache.canvas = it$iv2;
            targetImageBitmap$iv = it$iv;
            targetCanvas$iv = it$iv2;
        } else {
            cacheImageBitmap = cacheImageBitmap2;
            targetCanvas$iv = targetCanvas$iv2;
            targetImageBitmap$iv = targetImageBitmap$iv2;
        }
        CanvasDrawScope it$iv3 = borderCache.canvasDrawScope;
        if (it$iv3 == null) {
            it$iv3 = new CanvasDrawScope();
            borderCache.canvasDrawScope = it$iv3;
        }
        CanvasDrawScope targetDrawScope$iv = it$iv3;
        long drawSize$iv = IntSizeKt.m4552toSizeozmzZPI(pathBoundsSize);
        LayoutDirection layoutDirection$iv$iv = $this$drawGenericBorder.getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams = targetDrawScope$iv.getDrawParams();
        Density prevDensity$iv$iv = drawParams.getDensity();
        LayoutDirection prevLayoutDirection$iv$iv = drawParams.getLayoutDirection();
        Canvas prevCanvas$iv$iv = drawParams.getCanvas();
        long prevSize$iv$iv = drawParams.getSize();
        CanvasDrawScope.DrawParams $this$draw_yzxVdVo_u24lambda_u2d0$iv$iv = targetDrawScope$iv.getDrawParams();
        $this$draw_yzxVdVo_u24lambda_u2d0$iv$iv.setDensity($this$drawGenericBorder);
        $this$draw_yzxVdVo_u24lambda_u2d0$iv$iv.setLayoutDirection(layoutDirection$iv$iv);
        $this$draw_yzxVdVo_u24lambda_u2d0$iv$iv.setCanvas(targetCanvas$iv);
        $this$draw_yzxVdVo_u24lambda_u2d0$iv$iv.m2414setSizeuvyYCjk(drawSize$iv);
        targetCanvas$iv.save();
        CanvasDrawScope $this$drawBorderCache_EMwLDEs_u24lambda_u2d3$iv = targetDrawScope$iv;
        DrawScope.m2485drawRectnJ9OG0$default($this$drawBorderCache_EMwLDEs_u24lambda_u2d3$iv, Color.INSTANCE.m2022getBlack0d7_KjU(), 0L, drawSize$iv, 0.0f, null, null, BlendMode.INSTANCE.m1913getClear0nO6VwU(), 58, null);
        float left$iv = -pathBounds.getLeft();
        float top$iv = -pathBounds.getTop();
        $this$drawBorderCache_EMwLDEs_u24lambda_u2d3$iv.getDrawContext().getTransform().translate(left$iv, top$iv);
        ?? r37 = targetImageBitmap$iv;
        DrawScope.m2480drawPathGBMwjPU$default($this$drawBorderCache_EMwLDEs_u24lambda_u2d3$iv, outline.getPath(), brush, 0.0f, new Stroke(strokeWidth * 2, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
        float f = 1;
        float scaleX$iv = (Size.m1829getWidthimpl($this$drawBorderCache_EMwLDEs_u24lambda_u2d3$iv.mo2490getSizeNHjbRc()) + f) / Size.m1829getWidthimpl($this$drawBorderCache_EMwLDEs_u24lambda_u2d3$iv.mo2490getSizeNHjbRc());
        float scaleY$iv = (Size.m1826getHeightimpl($this$drawBorderCache_EMwLDEs_u24lambda_u2d3$iv.mo2490getSizeNHjbRc()) + f) / Size.m1826getHeightimpl($this$drawBorderCache_EMwLDEs_u24lambda_u2d3$iv.mo2490getSizeNHjbRc());
        long pivot$iv = $this$drawBorderCache_EMwLDEs_u24lambda_u2d3$iv.mo2489getCenterF1C5BW0();
        DrawContext $this$withTransform_u24lambda_u2d6$iv$iv = $this$drawBorderCache_EMwLDEs_u24lambda_u2d3$iv.getDrawContext();
        long previousSize$iv$iv = $this$withTransform_u24lambda_u2d6$iv$iv.mo2415getSizeNHjbRc();
        $this$withTransform_u24lambda_u2d6$iv$iv.getCanvas().save();
        DrawTransform $this$scale_Fgt4K4Q_u24lambda_u2d2$iv = $this$withTransform_u24lambda_u2d6$iv$iv.getTransform();
        $this$scale_Fgt4K4Q_u24lambda_u2d2$iv.mo2422scale0AR0LA0(scaleX$iv, scaleY$iv, pivot$iv);
        final Ref.ObjectRef cacheImageBitmap3 = cacheImageBitmap;
        DrawScope.m2480drawPathGBMwjPU$default($this$drawBorderCache_EMwLDEs_u24lambda_u2d3$iv, maskPath, brush, 0.0f, null, null, BlendMode.INSTANCE.m1913getClear0nO6VwU(), 28, null);
        $this$withTransform_u24lambda_u2d6$iv$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u2d6$iv$iv.mo2416setSizeuvyYCjk(previousSize$iv$iv);
        $this$drawBorderCache_EMwLDEs_u24lambda_u2d3$iv.getDrawContext().getTransform().translate(-left$iv, -top$iv);
        targetCanvas$iv.restore();
        CanvasDrawScope.DrawParams $this$draw_yzxVdVo_u24lambda_u2d1$iv$iv = targetDrawScope$iv.getDrawParams();
        $this$draw_yzxVdVo_u24lambda_u2d1$iv$iv.setDensity(prevDensity$iv$iv);
        $this$draw_yzxVdVo_u24lambda_u2d1$iv$iv.setLayoutDirection(prevLayoutDirection$iv$iv);
        $this$draw_yzxVdVo_u24lambda_u2d1$iv$iv.setCanvas(prevCanvas$iv$iv);
        $this$draw_yzxVdVo_u24lambda_u2d1$iv$iv.m2414setSizeuvyYCjk(prevSize$iv$iv);
        r37.prepareToDraw();
        cacheImageBitmap3.element = r37;
        final ColorFilter colorFilter3 = colorFilter;
        return $this$drawGenericBorder.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderKt$drawGenericBorder$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope onDrawWithContent) {
                Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                onDrawWithContent.drawContent();
                ContentDrawScope $this$translate$iv = onDrawWithContent;
                float left$iv2 = Rect.this.getLeft();
                float top$iv2 = Rect.this.getTop();
                Ref.ObjectRef<ImageBitmap> objectRef = cacheImageBitmap3;
                long j = pathBoundsSize;
                ColorFilter colorFilter4 = colorFilter3;
                $this$translate$iv.getDrawContext().getTransform().translate(left$iv2, top$iv2);
                DrawScope.m2474drawImageAZ2fEMs$default($this$translate$iv, objectRef.element, 0L, j, 0L, 0L, 0.0f, null, colorFilter4, 0, 0, 890, null);
                $this$translate$iv.getDrawContext().getTransform().translate(-left$iv2, -top$iv2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawRoundRectBorder-SYlcjDY, reason: not valid java name */
    public static final DrawResult m504drawRoundRectBorderSYlcjDY(CacheDrawScope $this$drawRoundRectBorder_u2dSYlcjDY, androidx.compose.p000ui.node.Ref<BorderCache> ref, final Brush brush, Outline.Rounded outline, final long topLeft, final long borderSize, final boolean fillArea, final float strokeWidth) {
        if (RoundRectKt.isSimple(outline.getRoundRect())) {
            final long cornerRadius = outline.getRoundRect().m1810getTopLeftCornerRadiuskKHJgLs();
            final float halfStroke = strokeWidth / 2;
            final Stroke borderStroke = new Stroke(strokeWidth, 0.0f, 0, 0, null, 30, null);
            return $this$drawRoundRectBorder_u2dSYlcjDY.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderKt$drawRoundRectBorder$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                    invoke2(contentDrawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ContentDrawScope onDrawWithContent) {
                    long m505shrinkKibmq7A;
                    Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                    onDrawWithContent.drawContent();
                    if (fillArea) {
                        DrawScope.m2486drawRoundRectZuiqVtQ$default(onDrawWithContent, brush, 0L, 0L, cornerRadius, 0.0f, null, null, 0, 246, null);
                        return;
                    }
                    if (CornerRadius.m1735getXimpl(cornerRadius) < halfStroke) {
                        ContentDrawScope $this$clipRect_u2drOu3jXo$iv = onDrawWithContent;
                        float left$iv = strokeWidth;
                        float top$iv = strokeWidth;
                        float right$iv = Size.m1829getWidthimpl(onDrawWithContent.mo2490getSizeNHjbRc()) - strokeWidth;
                        float bottom$iv = Size.m1826getHeightimpl(onDrawWithContent.mo2490getSizeNHjbRc()) - strokeWidth;
                        int clipOp$iv = ClipOp.INSTANCE.m1984getDifferencertfAjoo();
                        Brush brush2 = brush;
                        long j = cornerRadius;
                        DrawContext $this$withTransform_u24lambda_u2d6$iv$iv = $this$clipRect_u2drOu3jXo$iv.getDrawContext();
                        long previousSize$iv$iv = $this$withTransform_u24lambda_u2d6$iv$iv.mo2415getSizeNHjbRc();
                        $this$withTransform_u24lambda_u2d6$iv$iv.getCanvas().save();
                        DrawTransform $this$clipRect_rOu3jXo_u24lambda_u2d4$iv = $this$withTransform_u24lambda_u2d6$iv$iv.getTransform();
                        $this$clipRect_rOu3jXo_u24lambda_u2d4$iv.mo2418clipRectN_I0leg(left$iv, top$iv, right$iv, bottom$iv, clipOp$iv);
                        DrawScope.m2486drawRoundRectZuiqVtQ$default($this$clipRect_u2drOu3jXo$iv, brush2, 0L, 0L, j, 0.0f, null, null, 0, 246, null);
                        $this$withTransform_u24lambda_u2d6$iv$iv.getCanvas().restore();
                        $this$withTransform_u24lambda_u2d6$iv$iv.mo2416setSizeuvyYCjk(previousSize$iv$iv);
                        return;
                    }
                    Brush brush3 = brush;
                    long j2 = topLeft;
                    long j3 = borderSize;
                    m505shrinkKibmq7A = BorderKt.m505shrinkKibmq7A(cornerRadius, halfStroke);
                    DrawScope.m2486drawRoundRectZuiqVtQ$default(onDrawWithContent, brush3, j2, j3, m505shrinkKibmq7A, 0.0f, borderStroke, null, 0, 208, null);
                }
            });
        }
        Path path = obtain(ref).obtainPath();
        final Path roundedRectPath = createRoundRectPath(path, outline.getRoundRect(), strokeWidth, fillArea);
        return $this$drawRoundRectBorder_u2dSYlcjDY.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderKt$drawRoundRectBorder$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope onDrawWithContent) {
                Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                onDrawWithContent.drawContent();
                DrawScope.m2480drawPathGBMwjPU$default(onDrawWithContent, Path.this, brush, 0.0f, null, null, 0, 60, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawRectBorder-NsqcLGU, reason: not valid java name */
    public static final DrawResult m503drawRectBorderNsqcLGU(CacheDrawScope $this$drawRectBorder_u2dNsqcLGU, final Brush brush, long topLeft, long borderSize, boolean fillArea, float strokeWidthPx) {
        final long rectTopLeft = fillArea ? Offset.INSTANCE.m1776getZeroF1C5BW0() : topLeft;
        final long size = fillArea ? $this$drawRectBorder_u2dNsqcLGU.m1672getSizeNHjbRc() : borderSize;
        final DrawStyle style = fillArea ? Fill.INSTANCE : new Stroke(strokeWidthPx, 0.0f, 0, 0, null, 30, null);
        return $this$drawRectBorder_u2dNsqcLGU.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderKt$drawRectBorder$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope onDrawWithContent) {
                Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                onDrawWithContent.drawContent();
                DrawScope.m2484drawRectAsUm42w$default(onDrawWithContent, Brush.this, rectTopLeft, size, 0.0f, style, null, 0, 104, null);
            }
        });
    }

    private static final Path createRoundRectPath(Path targetPath, RoundRect roundedRect, float strokeWidth, boolean fillArea) {
        targetPath.reset();
        targetPath.addRoundRect(roundedRect);
        if (!fillArea) {
            Path insetPath = AndroidPath_androidKt.Path();
            insetPath.addRoundRect(createInsetRoundedRect(strokeWidth, roundedRect));
            targetPath.mo1893opN5in7k0(targetPath, insetPath, PathOperation.INSTANCE.m2248getDifferenceb3I0S0c());
        }
        return targetPath;
    }

    private static final RoundRect createInsetRoundedRect(float widthPx, RoundRect roundedRect) {
        return new RoundRect(widthPx, widthPx, roundedRect.getWidth() - widthPx, roundedRect.getHeight() - widthPx, m505shrinkKibmq7A(roundedRect.m1810getTopLeftCornerRadiuskKHJgLs(), widthPx), m505shrinkKibmq7A(roundedRect.m1811getTopRightCornerRadiuskKHJgLs(), widthPx), m505shrinkKibmq7A(roundedRect.m1809getBottomRightCornerRadiuskKHJgLs(), widthPx), m505shrinkKibmq7A(roundedRect.m1808getBottomLeftCornerRadiuskKHJgLs(), widthPx), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: shrink-Kibmq7A, reason: not valid java name */
    public static final long m505shrinkKibmq7A(long $this$shrink_u2dKibmq7A, float value) {
        return CornerRadiusKt.CornerRadius(Math.max(0.0f, CornerRadius.m1735getXimpl($this$shrink_u2dKibmq7A) - value), Math.max(0.0f, CornerRadius.m1736getYimpl($this$shrink_u2dKibmq7A) - value));
    }
}
