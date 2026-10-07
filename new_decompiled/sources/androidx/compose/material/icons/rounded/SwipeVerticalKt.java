package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons;
import androidx.compose.p000ui.graphics.Brush;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.SolidColor;
import androidx.compose.p000ui.graphics.StrokeCap;
import androidx.compose.p000ui.graphics.StrokeJoin;
import androidx.compose.p000ui.graphics.vector.ImageVector;
import androidx.compose.p000ui.graphics.vector.PathBuilder;
import androidx.compose.p000ui.graphics.vector.VectorKt;
import androidx.compose.p000ui.unit.C0504Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwipeVertical.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_swipeVertical", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SwipeVertical", "Landroidx/compose/material/icons/Icons$Rounded;", "getSwipeVertical", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SwipeVerticalKt {
    private static ImageVector _swipeVertical;

    public static final ImageVector getSwipeVertical(Icons.Rounded $this$SwipeVertical) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$SwipeVertical, "<this>");
        if (_swipeVertical != null) {
            ImageVector imageVector = _swipeVertical;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_SwipeVertical__u24lambda_u2d1 = new ImageVector.Builder("Rounded.SwipeVertical", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(0.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 3.22f, 1.13f, 6.18f, 3.02f, 8.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(1.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(1.34f, 20.5f, 1.0f, 20.84f, 1.0f, 21.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(1.34f, 22.0f, 1.75f, 22.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-3.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(6.0f, 17.34f, 5.66f, 17.0f, 5.25f, 17.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.41f, 0.0f, -0.75f, 0.34f, -0.75f, 0.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(2.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.86f, -2.11f, -3.0f, -4.88f, -3.0f, -7.91f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.14f, -5.79f, 3.0f, -7.91f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(2.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(4.5f, 6.66f, 4.84f, 7.0f, 5.25f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(5.66f, 7.0f, 6.0f, 6.66f, 6.0f, 6.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(1.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(1.34f, 2.0f, 1.0f, 2.34f, 1.0f, 2.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(1.34f, 3.5f, 1.75f, 3.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(1.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(1.13f, 5.82f, 0.0f, 8.78f, 0.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(8.83f, 19.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.26f, -0.6f, 0.09f, -1.28f, 0.73f, -1.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(3.58f, -0.71f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(8.79f, 7.17f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.34f, -0.76f, 0.0f, -1.64f, 0.76f, -1.98f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.76f, -0.34f, 1.64f, 0.0f, 1.98f, 0.76f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(2.43f, 5.49f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.84f, -0.37f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.28f, -0.13f, 0.59f, -0.18f, 0.9f, -0.17f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.56f, 0.21f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.86f, 0.04f, 1.6f, 0.63f, 1.83f, 1.45f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.23f, 4.33f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.27f, 0.96f, -0.2f, 1.97f, -1.11f, 2.37f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-5.63f, 2.49f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.48f, 0.21f, -1.26f, 0.33f, -1.76f, 0.14f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-5.45f, -2.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(9.13f, 19.53f, 8.93f, 19.34f, 8.83f, 19.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_SwipeVertical__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _swipeVertical = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _swipeVertical;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
