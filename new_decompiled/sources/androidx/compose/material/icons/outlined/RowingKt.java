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

/* compiled from: Rowing.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_rowing", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Rowing", "Landroidx/compose/material/icons/Icons$Outlined;", "getRowing", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-outlined_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class RowingKt {
    private static ImageVector _rowing;

    public static final ImageVector getRowing(Icons.Outlined $this$Rowing) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Rowing, "<this>");
        if (_rowing != null) {
            ImageVector imageVector = _rowing;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Rowing__u24lambda_u2d1 = new ImageVector.Builder("Outlined.Rowing", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(8.5f, 14.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(4.0f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.5f, 1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(9.0f, 17.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-2.5f, -2.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(15.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(0.9f, 2.0f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(21.0f, 21.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(18.0f, 24.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-2.99f, -3.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(15.01f, 19.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-7.1f, -7.09f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.31f, 0.05f, -0.61f, 0.07f, -0.91f, 0.07f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-2.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.66f, 0.03f, 3.61f, -0.87f, 4.67f, -2.04f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.4f, -1.55f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.19f, -0.21f, 0.43f, -0.38f, 0.69f, -0.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.29f, -0.14f, 0.62f, -0.23f, 0.96f, -0.23f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(0.03f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(15.99f, 6.01f, 17.0f, 7.02f, 17.0f, 8.26f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(5.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 0.84f, -0.35f, 1.61f, -0.92f, 2.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-3.58f, -3.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-2.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.63f, 0.52f, -1.43f, 1.02f, -2.29f, 1.39f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(16.5f, 18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(18.0f, 18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(3.0f, 3.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Rowing__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _rowing = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _rowing;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
