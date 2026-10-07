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

/* compiled from: Stadium.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_stadium", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Stadium", "Landroidx/compose/material/icons/Icons$Outlined;", "getStadium", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-outlined_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class StadiumKt {
    private static ImageVector _stadium;

    public static final ImageVector getStadium(Icons.Outlined $this$Stadium) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Stadium, "<this>");
        if (_stadium != null) {
            ImageVector imageVector = _stadium;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Stadium__u24lambda_u2d1 = new ImageVector.Builder("Outlined.Stadium", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(7.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(3.0f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(7.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(18.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(18.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(11.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(11.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(13.0f, 18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.0f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-5.05f, -0.15f, -9.0f, -1.44f, -9.0f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -1.66f, 4.48f, -3.0f, 10.0f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(10.0f, 1.34f, 10.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 1.56f, -3.95f, 2.85f, -9.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(13.0f, 18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(5.0f, 10.04f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(6.38f, 10.53f, 8.77f, 11.0f, 12.0f, 11.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(5.62f, -0.47f, 7.0f, -0.96f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(19.0f, 9.86f, 16.22f, 9.0f, 12.0f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(5.0f, 9.86f, 5.0f, 10.04f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(20.0f, 11.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.82f, 0.73f, -4.73f, 1.2f, -8.0f, 1.2f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-6.18f, -0.47f, -8.0f, -1.2f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(6.78f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.61f, 0.41f, 2.36f, 1.01f, 5.0f, 1.28f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(3.86f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(2.64f, -0.27f, 4.39f, -0.87f, 5.0f, -1.28f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(11.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Stadium__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _stadium = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _stadium;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
