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

/* compiled from: SupervisedUserCircle.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_supervisedUserCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SupervisedUserCircle", "Landroidx/compose/material/icons/Icons$Outlined;", "getSupervisedUserCircle", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-outlined_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SupervisedUserCircleKt {
    private static ImageVector _supervisedUserCircle;

    public static final ImageVector getSupervisedUserCircle(Icons.Outlined $this$SupervisedUserCircle) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$SupervisedUserCircle, "<this>");
        if (_supervisedUserCircle != null) {
            ImageVector imageVector = _supervisedUserCircle;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_SupervisedUserCircle__u24lambda_u2d1 = new ImageVector.Builder("Outlined.SupervisedUserCircle", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(12.5f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -1.65f, -1.35f, -3.0f, -3.0f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-3.0f, 1.35f, -3.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.35f, 3.0f, 3.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(3.0f, -1.35f, 3.0f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(9.5f, 11.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.55f, 0.0f, -1.0f, -0.45f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(0.45f, -1.0f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.0f, 0.45f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-0.45f, 1.0f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(16.0f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.11f, 0.0f, 2.0f, -0.89f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -1.11f, -0.89f, -2.0f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.11f, 0.0f, -2.01f, 0.89f, -2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 1.11f, 0.89f, 2.0f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(11.99f, 2.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-5.52f, 0.0f, -10.0f, 4.48f, -10.0f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-4.48f, -10.0f, -10.0f, -10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(5.84f, 17.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.68f, -0.54f, 2.27f, -1.11f, 3.66f, -1.11f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.07f, 0.0f, 0.15f, 0.01f, 0.23f, 0.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.24f, -0.64f, 0.67f, -1.29f, 1.3f, -1.86f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.56f, -0.1f, -1.09f, -0.16f, -1.53f, -0.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.3f, 0.0f, -3.39f, 0.45f, -4.73f, 1.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.5f, -1.04f, -0.78f, -2.2f, -0.78f, -3.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -4.41f, 3.59f, -8.0f, 8.0f, -8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(8.0f, 3.59f, 8.0f, 8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 1.2f, -0.27f, 2.34f, -0.75f, 3.37f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.0f, -0.59f, -2.36f, -0.87f, -3.24f, -0.87f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.52f, 0.0f, -4.5f, 0.81f, -4.5f, 2.7f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(2.78f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-2.27f, -0.13f, -4.29f, -1.21f, -5.66f, -2.86f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_SupervisedUserCircle__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _supervisedUserCircle = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _supervisedUserCircle;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
