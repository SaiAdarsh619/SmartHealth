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

/* compiled from: _3p.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"__3p", "Landroidx/compose/ui/graphics/vector/ImageVector;", "_3p", "Landroidx/compose/material/icons/Icons$TwoTone;", "get_3p", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class _3pKt {
    private static ImageVector __3p;

    public static final ImageVector get_3p(Icons.TwoTone $this$_3p) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$_3p, "<this>");
        if (__3p != null) {
            ImageVector imageVector = __3p;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get__3p__u24lambda_u2d2 = new ImageVector.Builder("TwoTone._3p", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(4.0f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(13.17f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(5.17f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(12.0f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.1f, 0.0f, 2.0f, 0.9f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-0.9f, 2.0f, -2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-2.0f, -0.9f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(10.9f, 6.0f, 12.0f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(16.0f, 14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-0.57f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.81f, 0.48f, -1.53f, 1.22f, -1.85f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(10.07f, 11.21f, 11.01f, 11.0f, 12.0f, 11.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.99f, 0.0f, 1.93f, 0.21f, 2.78f, 0.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(15.52f, 11.9f, 16.0f, 12.62f, 16.0f, 13.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get__3p__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(20.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(4.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(2.0f, 22.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(4.0f, -4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(22.0f, 2.9f, 21.1f, 2.0f, 20.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(20.0f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(5.17f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(4.0f, 17.17f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(12.0f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(-2.0f, 0.9f, -2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveTo(10.9f, 10.0f, 12.0f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(16.0f, 13.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, -0.81f, -0.48f, -1.53f, -1.22f, -1.85f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(13.93f, 11.21f, 12.99f, 11.0f, 12.0f, 11.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.99f, 0.0f, -1.93f, 0.21f, -2.78f, 0.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(8.48f, 11.9f, 8.0f, 12.62f, 8.0f, 13.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(13.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        m2572addPathoIyEayM = $this$_get__3p__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        __3p = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = __3p;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
