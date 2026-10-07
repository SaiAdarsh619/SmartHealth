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

/* compiled from: ScreenLockRotation.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_screenLockRotation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ScreenLockRotation", "Landroidx/compose/material/icons/Icons$Rounded;", "getScreenLockRotation", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ScreenLockRotationKt {
    private static ImageVector _screenLockRotation;

    public static final ImageVector getScreenLockRotation(Icons.Rounded $this$ScreenLockRotation) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$ScreenLockRotation, "<this>");
        if (_screenLockRotation != null) {
            ImageVector imageVector = _screenLockRotation;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_ScreenLockRotation__u24lambda_u2d3 = new ImageVector.Builder("Rounded.ScreenLockRotation", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(20.41f, 11.36f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.35f, -0.35f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0.0f, 1.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(19.0f, 12.77f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-4.24f, 4.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(6.98f, 9.23f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.24f, -4.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.35f, 0.35f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0.0f, -1.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.35f, -0.36f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.79f, -0.79f, -2.03f, -0.79f, -2.82f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(5.57f, 7.82f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.78f, 0.78f, -0.78f, 2.05f, 0.0f, 2.83f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(7.78f, 7.78f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.79f, 0.79f, 2.03f, 0.79f, 2.82f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.24f, -4.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(21.2f, 13.41f, 21.2f, 12.14f, 20.41f, 11.36f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_ScreenLockRotation__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(10.85f, 17.85f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(10.54f, 17.54f, 10.0f, 17.76f, 10.0f, 18.21f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(1.53f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-3.17f, -0.82f, -5.59f, -3.54f, -5.95f, -6.86f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(3.99f, 12.37f, 3.56f, 12.0f, 3.06f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.6f, 0.0f, -1.07f, 0.53f, -1.0f, 1.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(2.62f, 18.11f, 6.87f, 22.0f, 12.0f, 22.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.59f, 0.0f, 1.17f, -0.06f, 1.73f, -0.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.4f, -0.07f, 0.55f, -0.56f, 0.27f, -0.85f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(10.85f, 17.85f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$_get_ScreenLockRotation__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv3 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv3 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv3 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv3 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(16.0f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineToRelative(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineTo(5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineTo(3.11f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.0f, -1.0f, -0.68f, -1.92f, -1.66f, -2.08f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(17.08f, 0.82f, 16.0f, 1.79f, 16.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(15.0f, 8.55f, 15.45f, 9.0f, 16.0f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(17.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.0f, -0.55f, 0.45f, -1.0f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.reflectiveCurveToRelative(1.0f, 0.45f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineTo(3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        m2572addPathoIyEayM = $this$_get_ScreenLockRotation__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv3, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv3, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _screenLockRotation = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _screenLockRotation;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
