package androidx.compose.material.icons.sharp;

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

/* compiled from: Palette.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_palette", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Palette", "Landroidx/compose/material/icons/Icons$Sharp;", "getPalette", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-sharp_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class PaletteKt {
    private static ImageVector _palette;

    public static final ImageVector getPalette(Icons.Sharp $this$Palette) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Palette, "<this>");
        if (_palette != null) {
            ImageVector imageVector = _palette;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Palette__u24lambda_u2d1 = new ImageVector.Builder("Sharp.Palette", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(12.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(6.49f, 2.0f, 2.0f, 6.49f, 2.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(4.49f, 10.0f, 10.0f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.38f, 0.0f, 2.5f, -1.12f, 2.5f, -2.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.61f, -0.23f, -1.2f, -0.64f, -1.67f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.08f, -0.1f, -0.13f, -0.21f, -0.13f, -0.33f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(3.31f, 0.0f, 6.0f, -2.69f, 6.0f, -6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(22.0f, 6.04f, 17.51f, 2.0f, 12.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(17.5f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.83f, 0.0f, -1.5f, -0.67f, -1.5f, -1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.83f, 0.67f, -1.5f, 1.5f, -1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(19.0f, 12.33f, 18.33f, 13.0f, 17.5f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(14.5f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(13.67f, 9.0f, 13.0f, 8.33f, 13.0f, 7.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(13.0f, 6.67f, 13.67f, 6.0f, 14.5f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(16.0f, 6.67f, 16.0f, 7.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(16.0f, 8.33f, 15.33f, 9.0f, 14.5f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(5.0f, 11.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(5.0f, 10.67f, 5.67f, 10.0f, 6.5f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(8.0f, 10.67f, 8.0f, 11.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(8.0f, 12.33f, 7.33f, 13.0f, 6.5f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(5.0f, 12.33f, 5.0f, 11.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(11.0f, 7.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(11.0f, 8.33f, 10.33f, 9.0f, 9.5f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(8.0f, 8.33f, 8.0f, 7.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(8.0f, 6.67f, 8.67f, 6.0f, 9.5f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(11.0f, 6.67f, 11.0f, 7.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Palette__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _palette = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _palette;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
