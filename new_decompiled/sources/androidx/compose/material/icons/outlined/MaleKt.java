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

/* compiled from: Male.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_male", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Male", "Landroidx/compose/material/icons/Icons$Outlined;", "getMale", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-outlined_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class MaleKt {
    private static ImageVector _male;

    public static final ImageVector getMale(Icons.Outlined $this$Male) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Male, "<this>");
        if (_male != null) {
            ImageVector imageVector = _male;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Male__u24lambda_u2d1 = new ImageVector.Builder("Outlined.Male", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(9.5f, 11.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.93f, 0.0f, 3.5f, 1.57f, 3.5f, 3.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(11.43f, 18.0f, 9.5f, 18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(6.0f, 16.43f, 6.0f, 14.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(7.57f, 11.0f, 9.5f, 11.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(9.5f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(6.46f, 9.0f, 4.0f, 11.46f, 4.0f, 14.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(6.46f, 20.0f, 9.5f, 20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(5.5f, -2.46f, 5.5f, -5.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -1.16f, -0.36f, -2.23f, -0.97f, -3.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(18.0f, 7.42f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-3.97f, 3.97f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(11.73f, 9.36f, 10.66f, 9.0f, 9.5f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Male__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _male = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _male;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
