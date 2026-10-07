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

/* compiled from: RawOff.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_rawOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RawOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getRawOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class RawOffKt {
    private static ImageVector _rawOff;

    public static final ImageVector getRawOff(Icons.Rounded $this$RawOff) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$RawOff, "<this>");
        if (_rawOff != null) {
            ImageVector imageVector = _rawOff;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_RawOff__u24lambda_u2d2 = new ImageVector.Builder("Rounded.RawOff", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(20.55f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.33f, 0.0f, -0.63f, 0.23f, -0.71f, 0.55f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(19.24f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.56f, -2.26f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(18.58f, 9.3f, 18.19f, 9.0f, 17.74f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(16.9f, 9.3f, 16.8f, 9.74f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(16.24f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.6f, -2.45f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(15.56f, 9.23f, 15.27f, 9.0f, 14.93f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.47f, 0.0f, -0.82f, 0.44f, -0.71f, 0.9f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.5f, 1.99f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(2.42f, 2.42f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.01f, 0.01f, -0.02f, 0.01f, -0.03f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.58f, -2.32f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.58f, 2.32f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(18.43f, 14.7f, 18.81f, 15.0f, 19.24f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(0.81f, -0.3f, 0.92f, -0.72f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.09f, -4.38f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(21.37f, 9.44f, 21.02f, 9.0f, 20.55f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_RawOff__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(3.51f, 3.51f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0.0f, 1.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(6.17f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(4.31f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(3.0f, 14.69f, 3.31f, 15.0f, 3.69f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(0.11f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.38f, 0.0f, 0.69f, -0.31f, 0.69f, -0.69f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(1.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(0.72f, 1.59f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(6.43f, 14.84f, 6.68f, 15.0f, 6.95f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.5f, 0.0f, 0.83f, -0.51f, 0.64f, -0.97f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(7.1f, 12.9f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(7.6f, 12.6f, 8.0f, 12.1f, 8.0f, 11.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(-0.67f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.43f, 1.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(8.98f, 14.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(8.86f, 14.56f, 9.21f, 15.0f, 9.68f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.33f, 0.0f, 0.62f, -0.23f, 0.7f, -0.55f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(0.24f, -0.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(0.04f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(8.4f, 8.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0.0f, -1.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(3.51f, 3.51f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(6.5f, 11.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(-1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(11.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        m2572addPathoIyEayM = $this$_get_RawOff__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _rawOff = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _rawOff;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
