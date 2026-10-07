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

/* compiled from: Subway.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_subway", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Subway", "Landroidx/compose/material/icons/Icons$Outlined;", "getSubway", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-outlined_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SubwayKt {
    private static ImageVector _subway;

    public static final ImageVector getSubway(Icons.Outlined $this$Subway) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Subway, "<this>");
        if (_subway != null) {
            ImageVector imageVector = _subway;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Subway__u24lambda_u2d1 = new ImageVector.Builder("Outlined.Subway", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(17.8f, 2.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(16.0f, 2.09f, 13.86f, 2.0f, 12.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-4.0f, 0.09f, -5.8f, 0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(3.53f, 3.84f, 2.0f, 6.05f, 2.0f, 8.86f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(2.0f, 22.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(22.0f, 8.86f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -2.81f, -1.53f, -5.02f, -4.2f, -6.06f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(9.17f, 20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.5f, -1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.66f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.5f, 1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(9.17f, 20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(7.01f, 14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(7.01f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(16.5f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 0.55f, -0.45f, 1.0f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-1.0f, -0.45f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(0.45f, -1.0f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.0f, 0.45f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(8.5f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.55f, 0.0f, 1.0f, 0.45f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-0.45f, 1.0f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-1.0f, -0.45f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(0.45f, -1.0f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(20.0f, 20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-3.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-0.38f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-1.15f, -1.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.49f, -0.17f, 2.65f, -1.42f, 2.65f, -2.96f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(18.0f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -2.63f, -3.0f, -3.0f, -6.0f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-6.0f, 0.37f, -6.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(6.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 1.54f, 1.16f, 2.79f, 2.65f, 2.96f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(7.5f, 19.62f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(7.5f, 20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(4.0f, 20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(4.0f, 8.86f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -2.0f, 1.01f, -3.45f, 2.93f, -4.2f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(8.41f, 4.08f, 10.32f, 4.0f, 12.0f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(3.59f, 0.08f, 5.07f, 0.66f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.92f, 0.75f, 2.93f, 2.2f, 2.93f, 4.2f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(20.0f, 20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Subway__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _subway = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _subway;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
