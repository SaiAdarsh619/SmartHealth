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

/* compiled from: AutoDelete.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_autoDelete", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AutoDelete", "Landroidx/compose/material/icons/Icons$TwoTone;", "getAutoDelete", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AutoDeleteKt {
    private static ImageVector _autoDelete;

    public static final ImageVector getAutoDelete(Icons.TwoTone $this$AutoDelete) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$AutoDelete, "<this>");
        if (_autoDelete != null) {
            ImageVector imageVector = _autoDelete;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_AutoDelete__u24lambda_u2d4 = new ImageVector.Builder("TwoTone.AutoDelete", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(12.0f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(5.08f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(9.03f, 16.67f, 9.0f, 16.34f, 9.0f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -2.38f, 1.19f, -4.47f, 3.0f, -5.74f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_AutoDelete__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(15.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-3.5f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-5.0f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-3.5f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(0.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(14.0f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$_get_AutoDelete__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv3 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv3 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv3 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv3 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(16.0f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(-0.7f, 0.0f, -1.37f, 0.1f, -2.0f, 0.29f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineTo(5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineTo(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineToRelative(5.68f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(1.12f, 2.36f, 3.53f, 4.0f, 6.32f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(3.87f, 0.0f, 7.0f, -3.13f, 7.0f, -7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(23.0f, 12.13f, 19.87f, 9.0f, 16.0f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(9.0f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.0f, 0.34f, 0.03f, 0.67f, 0.08f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineTo(7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineToRelative(8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(3.26f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(10.19f, 11.53f, 9.0f, 13.62f, 9.0f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(16.0f, 21.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(-2.76f, 0.0f, -5.0f, -2.24f, -5.0f, -5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.reflectiveCurveToRelative(2.24f, -5.0f, 5.0f, -5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.reflectiveCurveToRelative(5.0f, 2.24f, 5.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.reflectiveCurveTo(18.76f, 21.0f, 16.0f, 21.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        $this$_get_AutoDelete__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv3, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv3, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv4 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv4 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv4 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv4 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv4 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.moveTo(16.5f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineToRelative(-1.5f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineToRelative(0.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineToRelative(3.6f, 2.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineToRelative(0.8f, -1.2f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineToRelative(-2.9f, -1.7f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.close();
        m2572addPathoIyEayM = $this$_get_AutoDelete__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv4.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv4, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv4, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv4, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv4, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _autoDelete = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _autoDelete;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
