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

/* compiled from: ReportOff.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_reportOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ReportOff", "Landroidx/compose/material/icons/Icons$TwoTone;", "getReportOff", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ReportOffKt {
    private static ImageVector _reportOff;

    public static final ImageVector getReportOff(Icons.TwoTone $this$ReportOff) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$ReportOff, "<this>");
        if (_reportOff != null) {
            ImageVector imageVector = _reportOff;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_ReportOff__u24lambda_u2d4 = new ImageVector.Builder("TwoTone.ReportOff", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(19.0f, 9.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(14.9f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(9.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.22f, 0.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(11.0f, 7.33f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(2.33f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(5.78f, 5.79f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.22f, -0.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(6.05f, 8.04f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(5.0f, 9.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(5.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(9.1f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(5.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.05f, -1.05f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-9.9f, -9.91f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(13.0f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 0.55f, -0.45f, 1.0f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-1.0f, -0.45f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(0.45f, -1.0f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.0f, 0.45f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_ReportOff__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(9.1f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(5.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(19.0f, 9.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(5.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-0.22f, 0.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.42f, 1.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(0.8f, -0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(8.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(15.73f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(8.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-0.8f, 0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.41f, 1.42f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$_get_ReportOff__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv3 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv3 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv3 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv3 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(12.0f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveToRelative(-1.0f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.arcToRelative(1.0f, 1.0f, 0.0f, true, true, 2.0f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.arcToRelative(1.0f, 1.0f, 0.0f, true, true, -2.0f, 0.0f);
        $this$_get_ReportOff__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv3, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv3, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv4 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv4 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv4 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv4 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv4 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.moveTo(13.0f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.horizontalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.verticalLineToRelative(0.33f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineToRelative(2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.moveTo(2.41f, 1.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineTo(1.0f, 2.99f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineToRelative(3.64f, 3.64f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineTo(3.0f, 8.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.verticalLineToRelative(7.46f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineTo(8.27f, 21.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.horizontalLineToRelative(7.46f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineToRelative(1.64f, -1.64f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineTo(21.01f, 23.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineToRelative(1.41f, -1.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineTo(2.41f, 1.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.moveTo(14.9f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.horizontalLineTo(9.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineTo(5.0f, 14.9f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.verticalLineTo(9.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineToRelative(1.05f, -1.05f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineToRelative(9.9f, 9.9f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineTo(14.9f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.close();
        m2572addPathoIyEayM = $this$_get_ReportOff__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv4.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv4, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv4, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv4, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv4, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _reportOff = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _reportOff;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
