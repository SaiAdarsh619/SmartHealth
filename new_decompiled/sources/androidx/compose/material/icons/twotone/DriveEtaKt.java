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

/* compiled from: DriveEta.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_driveEta", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DriveEta", "Landroidx/compose/material/icons/Icons$TwoTone;", "getDriveEta", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class DriveEtaKt {
    private static ImageVector _driveEta;

    public static final ImageVector getDriveEta(Icons.TwoTone $this$DriveEta) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$DriveEta, "<this>");
        if (_driveEta != null) {
            ImageVector imageVector = _driveEta;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_DriveEta__u24lambda_u2d4 = new ImageVector.Builder("TwoTone.DriveEta", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(5.12f, 11.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.12f, 0.34f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(5.0f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-4.66f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.12f, -0.34f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(5.12f, 11.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(7.5f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.83f, 0.0f, -1.5f, -0.67f, -1.5f, -1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(6.67f, 12.0f, 7.5f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(8.33f, 15.0f, 7.5f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(16.5f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.83f, 0.0f, -1.5f, -0.67f, -1.5f, -1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(0.67f, -1.5f, 1.5f, -1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_DriveEta__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(18.92f, 5.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(18.72f, 4.42f, 18.16f, 4.0f, 17.5f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(-11.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.66f, 0.0f, -1.21f, 0.42f, -1.42f, 1.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(3.0f, 11.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(-1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(-8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-2.08f, -5.99f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(6.85f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(10.29f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.04f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(5.81f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.04f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(19.0f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(-4.66f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(0.12f, -0.34f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(13.77f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(0.11f, 0.34f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$_get_DriveEta__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv3 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv3 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv3 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv3 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(7.5f, 13.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveToRelative(-1.5f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.arcToRelative(1.5f, 1.5f, 0.0f, true, true, 3.0f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.arcToRelative(1.5f, 1.5f, 0.0f, true, true, -3.0f, 0.0f);
        $this$_get_DriveEta__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv3, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv3, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv4 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv4 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv4 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv4 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv4 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.moveTo(16.5f, 13.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.moveToRelative(-1.5f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.arcToRelative(1.5f, 1.5f, 0.0f, true, true, 3.0f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.arcToRelative(1.5f, 1.5f, 0.0f, true, true, -3.0f, 0.0f);
        m2572addPathoIyEayM = $this$_get_DriveEta__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv4.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv4, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv4, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv4, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv4, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _driveEta = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _driveEta;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
