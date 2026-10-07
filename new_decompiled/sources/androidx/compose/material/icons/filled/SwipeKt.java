package androidx.compose.material.icons.filled;

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
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_swipe", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Swipe", "Landroidx/compose/material/icons/Icons$Filled;", "getSwipe", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-filled_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SwipeKt {
    private static ImageVector _swipe;

    public static final ImageVector getSwipe(Icons.Filled $this$Swipe) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Swipe, "<this>");
        if (_swipe != null) {
            ImageVector imageVector = _swipe;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Swipe__u24lambda_u2d2 = new ImageVector.Builder("Filled.Swipe", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(18.89f, 14.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-4.09f, -2.04f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.28f, -0.14f, -0.58f, -0.21f, -0.89f, -0.21f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(13.0f, 5.67f, 12.33f, 5.0f, 11.5f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(10.0f, 5.67f, 10.0f, 6.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(10.74f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(6.75f, 16.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.33f, -0.07f, -0.68f, 0.03f, -0.92f, 0.28f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(5.0f, 17.62f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.54f, 4.79f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(9.92f, 22.79f, 10.68f, 23.0f, 11.21f, 23.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(6.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.0f, 0.0f, 1.84f, -0.73f, 1.98f, -1.72f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.63f, -4.46f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(20.1f, 15.97f, 19.66f, 15.14f, 18.89f, 14.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_Swipe__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(20.13f, 3.87f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(18.69f, 2.17f, 15.6f, 1.0f, 12.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveTo(5.31f, 2.17f, 3.87f, 3.87f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(4.93f, 4.93f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(1.0f, -1.29f, 3.7f, -2.43f, 7.07f, -2.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(6.07f, 1.14f, 7.07f, 2.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(17.0f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(20.13f, 3.87f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        m2572addPathoIyEayM = $this$_get_Swipe__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _swipe = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _swipe;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
