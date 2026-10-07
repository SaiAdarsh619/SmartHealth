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

/* compiled from: Savings.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_savings", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Savings", "Landroidx/compose/material/icons/Icons$Outlined;", "getSavings", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-outlined_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SavingsKt {
    private static ImageVector _savings;

    public static final ImageVector getSavings(Icons.Outlined $this$Savings) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Savings, "<this>");
        if (_savings != null) {
            ImageVector imageVector = _savings;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Savings__u24lambda_u2d1 = new ImageVector.Builder("Outlined.Savings", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(15.0f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.55f, 0.45f, -1.0f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.0f, 0.45f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 0.55f, -0.45f, 1.0f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(15.0f, 10.55f, 15.0f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(8.0f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(22.0f, 7.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(6.97f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-2.82f, 0.94f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(17.5f, 21.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(12.0f, 21.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-5.5f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(4.5f, 21.0f, 2.0f, 12.54f, 2.0f, 9.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(4.46f, 4.0f, 7.5f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(5.0f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.91f, -1.21f, 2.36f, -2.0f, 4.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(17.33f, 2.0f, 18.0f, 2.67f, 18.0f, 3.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 0.21f, -0.04f, 0.4f, -0.12f, 0.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.14f, 0.34f, -0.26f, 0.73f, -0.32f, 1.15f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(2.27f, 2.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(22.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(20.0f, 9.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(15.5f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.65f, 0.09f, -1.29f, 0.26f, -1.91f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(14.79f, 4.34f, 14.0f, 5.06f, 13.67f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(7.5f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(5.57f, 6.0f, 4.0f, 7.57f, 4.0f, 9.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 1.88f, 1.22f, 6.65f, 2.01f, 9.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(8.0f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(2.01f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.55f, -5.15f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(20.0f, 13.03f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(9.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Savings__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _savings = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _savings;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
