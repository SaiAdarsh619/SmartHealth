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

/* compiled from: BusAlert.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_busAlert", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BusAlert", "Landroidx/compose/material/icons/Icons$Outlined;", "getBusAlert", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-outlined_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class BusAlertKt {
    private static ImageVector _busAlert;

    public static final ImageVector getBusAlert(Icons.Outlined $this$BusAlert) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$BusAlert, "<this>");
        if (_busAlert != null) {
            ImageVector imageVector = _busAlert;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_BusAlert__u24lambda_u2d4 = new ImageVector.Builder("Outlined.BusAlert", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(6.5f, 15.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveToRelative(-1.5f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.arcToRelative(1.5f, 1.5f, 0.0f, true, true, 3.0f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.arcToRelative(1.5f, 1.5f, 0.0f, true, true, -3.0f, 0.0f);
        $this$_get_BusAlert__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(13.5f, 15.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveToRelative(-1.5f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.arcToRelative(1.5f, 1.5f, 0.0f, true, true, 3.0f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.arcToRelative(1.5f, 1.5f, 0.0f, true, true, -3.0f, 0.0f);
        $this$_get_BusAlert__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv3 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv3 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv3 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv3 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(4.0f, 11.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineTo(8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineToRelative(7.29f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(11.1f, 7.37f, 11.0f, 6.7f, 11.0f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineTo(4.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.83f, -0.71f, 2.98f, -1.09f, 6.65f, -0.98f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.1f, -0.7f, 0.3f, -1.37f, 0.59f, -1.99f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(2.97f, 2.67f, 2.0f, 5.02f, 2.0f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(9.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.0f, 0.95f, 0.38f, 1.81f, 1.0f, 2.44f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineTo(21.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineToRelative(1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(-1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineToRelative(8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineToRelative(1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(-2.06f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.62f, -0.63f, 1.0f, -1.49f, 1.0f, -2.44f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineTo(13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(-1.91f, 0.0f, -3.63f, -0.76f, -4.89f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(16.0f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.0f, 1.1f, -0.9f, 2.0f, -2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineTo(6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(-3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineToRelative(12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineTo(16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        $this$_get_BusAlert__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv3, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv3, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv4 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv4 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv4 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv4 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv4 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.moveTo(18.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveToRelative(-2.76f, 0.0f, -5.0f, 2.24f, -5.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.reflectiveCurveToRelative(2.24f, 5.0f, 5.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.reflectiveCurveToRelative(5.0f, -2.24f, 5.0f, -5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.reflectiveCurveTo(20.76f, 1.0f, 18.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.moveTo(18.5f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.horizontalLineToRelative(-1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.verticalLineTo(8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.horizontalLineToRelative(1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.verticalLineTo(9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.moveTo(18.5f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.horizontalLineToRelative(-1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.verticalLineTo(3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.horizontalLineToRelative(1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.verticalLineTo(7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.close();
        m2572addPathoIyEayM = $this$_get_BusAlert__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv4.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv4, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv4, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv4, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv4, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _busAlert = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _busAlert;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
