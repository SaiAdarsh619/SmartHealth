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

/* compiled from: SportsTennis.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_sportsTennis", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SportsTennis", "Landroidx/compose/material/icons/Icons$Outlined;", "getSportsTennis", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-outlined_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SportsTennisKt {
    private static ImageVector _sportsTennis;

    public static final ImageVector getSportsTennis(Icons.Outlined $this$SportsTennis) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$SportsTennis, "<this>");
        if (_sportsTennis != null) {
            ImageVector imageVector = _sportsTennis;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_SportsTennis__u24lambda_u2d2 = new ImageVector.Builder("Outlined.SportsTennis", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(19.52f, 2.49f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-2.34f, -2.34f, -6.62f, -1.87f, -9.55f, 1.06f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.6f, 1.6f, -2.52f, 3.87f, -2.54f, 5.46f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.02f, 1.58f, 0.26f, 3.89f, -1.35f, 5.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-4.24f, 4.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.42f, 1.42f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.24f, -4.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.61f, -1.61f, 3.92f, -1.33f, 5.5f, -1.35f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(3.86f, -0.94f, 5.46f, -2.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(21.38f, 9.11f, 21.86f, 4.83f, 19.52f, 2.49f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(10.32f, 11.68f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.53f, -1.53f, -1.05f, -4.61f, 1.06f, -6.72f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(5.18f, -2.59f, 6.72f, -1.06f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.53f, 1.53f, 1.05f, 4.61f, -1.06f, 6.72f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(11.86f, 13.21f, 10.32f, 11.68f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_SportsTennis__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(18.0f, 17.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.53f, 0.0f, 1.04f, 0.21f, 1.41f, 0.59f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.78f, 0.78f, 0.78f, 2.05f, 0.0f, 2.83f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(19.04f, 20.79f, 18.53f, 21.0f, 18.0f, 21.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(-1.04f, -0.21f, -1.41f, -0.59f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.78f, -0.78f, -0.78f, -2.05f, 0.0f, -2.83f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(16.96f, 17.21f, 17.47f, 17.0f, 18.0f, 17.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(18.0f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-1.02f, 0.0f, -2.05f, 0.39f, -2.83f, 1.17f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-1.56f, 1.56f, -1.56f, 4.09f, 0.0f, 5.66f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(15.95f, 22.61f, 16.98f, 23.0f, 18.0f, 23.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(2.05f, -0.39f, 2.83f, -1.17f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(1.56f, -1.56f, 1.56f, -4.09f, 0.0f, -5.66f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(20.05f, 15.39f, 19.02f, 15.0f, 18.0f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(18.0f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        m2572addPathoIyEayM = $this$_get_SportsTennis__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _sportsTennis = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _sportsTennis;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
