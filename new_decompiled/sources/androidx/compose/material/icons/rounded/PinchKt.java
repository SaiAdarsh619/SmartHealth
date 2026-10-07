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

/* compiled from: Pinch.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_pinch", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Pinch", "Landroidx/compose/material/icons/Icons$Rounded;", "getPinch", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class PinchKt {
    private static ImageVector _pinch;

    public static final ImageVector getPinch(Icons.Rounded $this$Pinch) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Pinch, "<this>");
        if (_pinch != null) {
            ImageVector imageVector = _pinch;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Pinch__u24lambda_u2d1 = new ImageVector.Builder("Rounded.Pinch", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(8.2f, 17.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.65f, 0.6f, -1.13f, 1.24f, -0.99f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(13.0f, 17.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(6.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(13.0f, 5.67f, 13.67f, 5.0f, 14.5f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(16.0f, 5.67f, 16.0f, 6.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(0.91f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.31f, 0.0f, 0.62f, 0.07f, 0.89f, 0.21f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.09f, 2.04f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.77f, 0.38f, 1.21f, 1.22f, 1.09f, 2.07f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.63f, 4.46f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(22.21f, 22.27f, 21.36f, 23.0f, 20.37f, 23.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-6.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.53f, 0.0f, -1.29f, -0.21f, -1.66f, -0.59f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-4.07f, -4.29f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(8.3f, 17.94f, 8.2f, 17.69f, 8.2f, 17.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(9.5f, 5.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(9.5f, 5.66f, 9.84f, 6.0f, 10.25f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(11.0f, 5.66f, 11.0f, 5.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(6.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(6.34f, 1.0f, 6.0f, 1.34f, 6.0f, 1.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(6.34f, 2.5f, 6.75f, 2.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(1.69f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(2.5f, 8.44f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(6.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(2.5f, 6.34f, 2.16f, 6.0f, 1.75f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(1.0f, 6.34f, 1.0f, 6.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(3.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(5.66f, 11.0f, 6.0f, 10.66f, 6.0f, 10.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(5.66f, 9.5f, 5.25f, 9.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(3.56f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(9.5f, 3.56f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(5.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Pinch__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _pinch = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _pinch;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
