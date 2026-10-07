package androidx.compose.material.icons.outlined;

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

/* compiled from: Swipe.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_swipe", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Swipe", "Landroidx/compose/material/icons/Icons$Outlined;", "getSwipe", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-outlined_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SwipeKt {
    private static ImageVector _swipe;

    public static final ImageVector getSwipe(Icons.Outlined $this$Swipe) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Swipe, "<this>");
        if (_swipe != null) {
            ImageVector imageVector = _swipe;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Swipe__u24lambda_u2d2 = new ImageVector.Builder("Outlined.Swipe", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(20.5f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(2.02f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(18.18f, 2.13f, 15.22f, 1.0f, 12.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(5.82f, 2.13f, 3.5f, 4.02f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(3.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(5.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(4.09f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(2.11f, -1.86f, 4.88f, -3.0f, 7.91f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(5.79f, 1.14f, 7.91f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(17.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(3.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(22.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(5.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(20.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_Swipe__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(18.89f, 13.77f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-3.8f, -1.67f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(14.96f, 12.04f, 14.81f, 12.0f, 14.65f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(0.0f, -4.37f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, -1.32f, -0.96f, -2.5f, -2.27f, -2.62f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(10.25f, 4.88f, 9.0f, 6.05f, 9.0f, 7.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(8.15f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-1.87f, -0.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.19f, -0.03f, -1.02f, -0.15f, -1.73f, 0.56f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(4.0f, 17.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(5.12f, 5.19f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(9.49f, 22.79f, 10.0f, 23.0f, 10.53f, 23.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(6.55f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.98f, 0.0f, 1.81f, -0.7f, 1.97f, -1.67f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(0.92f, -5.44f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(20.12f, 15.03f, 19.68f, 14.17f, 18.89f, 13.77f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(18.0f, 15.56f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(17.08f, 21.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(-6.55f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-3.7f, -3.78f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(11.0f, 18.11f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(7.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(11.0f, 7.22f, 11.22f, 7.0f, 11.5f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveTo(12.0f, 7.22f, 12.0f, 7.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(6.18f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(1.76f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(18.0f, 15.56f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        m2572addPathoIyEayM = $this$_get_Swipe__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _swipe = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _swipe;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
