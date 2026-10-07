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

/* compiled from: Grass.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_grass", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Grass", "Landroidx/compose/material/icons/Icons$Rounded;", "getGrass", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class GrassKt {
    private static ImageVector _grass;

    public static final ImageVector getGrass(Icons.Rounded $this$Grass) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Grass, "<this>");
        if (_grass != null) {
            ImageVector imageVector = _grass;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Grass__u24lambda_u2d1 = new ImageVector.Builder("Rounded.Grass", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(15.64f, 11.02f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.55f, -1.47f, 1.43f, -2.78f, 2.56f, -3.83f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.38f, -0.36f, 0.04f, -1.0f, -0.46f, -0.85f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-3.32f, 0.98f, -5.75f, 4.05f, -5.74f, 7.69f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(12.95f, 12.75f, 14.2f, 11.72f, 15.64f, 11.02f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(11.42f, 8.85f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.6f, -1.56f, -1.63f, -2.91f, -2.96f, -3.87f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(8.04f, 4.68f, 7.5f, 5.17f, 7.74f, 5.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(8.54f, 7.15f, 9.0f, 8.88f, 9.0f, 10.71f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 0.21f, -0.03f, 0.41f, -0.04f, 0.61f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.43f, 0.24f, 0.83f, 0.52f, 1.22f, 0.82f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(10.39f, 10.96f, 10.83f, 9.85f, 11.42f, 8.85f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(12.0f, 20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.55f, 0.0f, -1.0f, -0.45f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(0.45f, -1.0f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(4.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.57f, -2.19f, -2.04f, -4.02f, -4.0f, -5.06f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.0f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.16f, -0.08f, -0.26f, -0.25f, -0.26f, -0.44f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.27f, 0.22f, -0.49f, 0.49f, -0.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.01f, 0.0f, 0.02f, 0.0f, 0.02f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(8.42f, 12.0f, 12.0f, 15.58f, 12.0f, 20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(20.26f, 12.94f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(20.26f, 12.94f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.96f, 1.04f, -3.44f, 2.87f, -4.0f, 5.06f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(21.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.55f, 0.0f, 1.0f, 0.45f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-0.45f, 1.0f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.68f, -0.07f, -1.35f, -0.2f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.15f, -0.72f, -0.38f, -1.42f, -0.67f, -2.07f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(14.52f, 13.58f, 17.07f, 12.0f, 20.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.01f, 0.0f, 0.02f, 0.0f, 0.02f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.27f, 0.0f, 0.49f, 0.23f, 0.49f, 0.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(20.52f, 12.69f, 20.41f, 12.85f, 20.26f, 12.94f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Grass__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _grass = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _grass;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
