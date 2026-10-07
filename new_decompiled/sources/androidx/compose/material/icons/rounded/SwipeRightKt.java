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

/* compiled from: SwipeRight.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_swipeRight", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SwipeRight", "Landroidx/compose/material/icons/Icons$Rounded;", "getSwipeRight", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SwipeRightKt {
    private static ImageVector _swipeRight;

    public static final ImageVector getSwipeRight(Icons.Rounded $this$SwipeRight) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$SwipeRight, "<this>");
        if (_swipeRight != null) {
            ImageVector imageVector = _swipeRight;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_SwipeRight__u24lambda_u2d1 = new ImageVector.Builder("Rounded.SwipeRight", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(12.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(7.19f, 1.0f, 3.7f, 3.39f, 2.41f, 5.92f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(2.16f, 6.41f, 2.53f, 7.0f, 3.09f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.28f, 0.0f, 0.54f, -0.15f, 0.66f, -0.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(4.73f, 4.69f, 7.58f, 2.5f, 12.0f, 2.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(3.03f, 0.0f, 5.79f, 1.14f, 7.91f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-2.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(17.34f, 5.5f, 17.0f, 5.84f, 17.0f, 6.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(17.34f, 7.0f, 17.75f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(21.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(2.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(22.0f, 2.34f, 21.66f, 2.0f, 21.25f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(20.5f, 2.34f, 20.5f, 2.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(1.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(18.18f, 2.13f, 15.22f, 1.0f, 12.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(5.2f, 17.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.65f, 0.6f, -1.13f, 1.24f, -0.99f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(10.0f, 17.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(6.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(10.0f, 5.67f, 10.67f, 5.0f, 11.5f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(13.0f, 5.67f, 13.0f, 6.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(0.91f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.31f, 0.0f, 0.62f, 0.07f, 0.89f, 0.21f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.09f, 2.04f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.77f, 0.38f, 1.21f, 1.22f, 1.09f, 2.07f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.63f, 4.46f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(19.21f, 22.27f, 18.36f, 23.0f, 17.37f, 23.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-6.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.53f, 0.0f, -1.29f, -0.21f, -1.66f, -0.59f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-4.07f, -4.29f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(5.3f, 17.94f, 5.2f, 17.69f, 5.2f, 17.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_SwipeRight__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _swipeRight = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _swipeRight;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
