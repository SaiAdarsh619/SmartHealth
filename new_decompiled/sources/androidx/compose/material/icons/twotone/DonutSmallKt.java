package androidx.compose.material.icons.twotone;

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

/* compiled from: DonutSmall.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_donutSmall", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DonutSmall", "Landroidx/compose/material/icons/Icons$TwoTone;", "getDonutSmall", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class DonutSmallKt {
    private static ImageVector _donutSmall;

    public static final ImageVector getDonutSmall(Icons.TwoTone $this$DonutSmall) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$DonutSmall, "<this>");
        if (_donutSmall != null) {
            ImageVector imageVector = _donutSmall;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_DonutSmall__u24lambda_u2d2 = new ImageVector.Builder("TwoTone.DonutSmall", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(15.99f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(3.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(18.6f, 7.0f, 17.0f, 5.4f, 15.0f, 4.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(3.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.37f, 0.28f, 0.71f, 0.62f, 0.99f, 0.99f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(4.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 3.35f, 2.04f, 6.24f, 5.0f, 7.42f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-3.44f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.23f, -0.93f, -2.0f, -2.4f, -2.0f, -3.99f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(7.0f, 10.4f, 7.77f, 8.93f, 9.0f, 8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(9.0f, 4.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(6.04f, 5.76f, 4.0f, 8.65f, 4.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(15.0f, 15.99f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(3.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(2.0f, -0.82f, 3.6f, -2.42f, 4.42f, -4.42f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-3.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.28f, 0.37f, -0.62f, 0.71f, -0.99f, 0.99f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_DonutSmall__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(14.82f, 11.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(7.13f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.47f, -4.72f, -4.23f, -8.48f, -8.95f, -8.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(7.13f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.85f, 0.31f, 1.51f, 0.97f, 1.82f, 1.82f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(15.0f, 4.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(17.0f, 5.4f, 18.6f, 7.0f, 19.42f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(-3.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.28f, -0.37f, -0.62f, -0.71f, -0.99f, -0.99f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(15.0f, 4.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(2.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 5.19f, 3.95f, 9.45f, 9.0f, 9.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(-7.13f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(9.84f, 14.4f, 9.0f, 13.3f, 9.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, -1.3f, 0.84f, -2.4f, 2.0f, -2.82f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(11.0f, 2.05f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-5.05f, 0.5f, -9.0f, 4.76f, -9.0f, 9.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(9.0f, 4.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(3.44f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-1.23f, 0.92f, -2.0f, 2.39f, -2.0f, 3.98f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 1.59f, 0.77f, 3.06f, 2.0f, 3.99f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(3.44f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(6.04f, 18.24f, 4.0f, 15.35f, 4.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, -3.35f, 2.04f, -6.24f, 5.0f, -7.42f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(13.0f, 14.82f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(7.13f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(4.72f, -0.47f, 8.48f, -4.23f, 8.95f, -8.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(-7.13f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.31f, 0.85f, -0.97f, 1.51f, -1.82f, 1.82f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(15.0f, 15.99f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.37f, -0.28f, 0.71f, -0.61f, 0.99f, -0.99f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(3.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(18.6f, 17.0f, 17.0f, 18.6f, 15.0f, 19.42f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(-3.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        m2572addPathoIyEayM = $this$_get_DonutSmall__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _donutSmall = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _donutSmall;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
