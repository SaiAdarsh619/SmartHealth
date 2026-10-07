package androidx.compose.material.icons.twotone;

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

/* compiled from: NoPhotography.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_noPhotography", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoPhotography", "Landroidx/compose/material/icons/Icons$TwoTone;", "getNoPhotography", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class NoPhotographyKt {
    private static ImageVector _noPhotography;

    public static final ImageVector getNoPhotography(Icons.TwoTone $this$NoPhotography) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$NoPhotography, "<this>");
        if (_noPhotography != null) {
            ImageVector imageVector = _noPhotography;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_NoPhotography__u24lambda_u2d2 = new ImageVector.Builder("TwoTone.NoPhotography", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(10.94f, 8.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(8.9f, 6.07f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(9.88f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(4.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.83f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(10.17f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-3.12f, -3.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(16.96f, 13.71f, 17.0f, 13.36f, 17.0f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -2.76f, -2.24f, -5.0f, -5.0f, -5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(11.64f, 8.0f, 11.29f, 8.04f, 10.94f, 8.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(12.0f, 18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-2.76f, 0.0f, -5.0f, -2.24f, -5.0f, -5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.91f, 0.25f, -1.76f, 0.68f, -2.49f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(4.17f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(12.17f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-1.68f, -1.68f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(13.76f, 17.75f, 12.91f, 18.0f, 12.0f, 18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_NoPhotography__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(8.9f, 6.07f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(7.48f, 4.66f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(9.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.83f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(1.1f, 0.0f, 2.0f, 0.9f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 0.05f, -0.01f, 0.1f, -0.02f, 0.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(20.0f, 17.17f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(-4.05f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-1.83f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(9.88f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(8.9f, 6.07f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(20.49f, 23.31f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(18.17f, 21.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, -0.59f, 0.27f, -1.12f, 0.68f, -1.49f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(2.1f, 2.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(7.0f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.01f, 2.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.43f, 1.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(4.1f, 4.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.43f, 1.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(19.0f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.82f, 1.82f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.08f, 1.08f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(20.49f, 23.31f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(9.19f, 12.02f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(9.08f, 12.33f, 9.0f, 12.65f, 9.0f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 1.65f, 1.35f, 3.0f, 3.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.35f, 0.0f, 0.67f, -0.08f, 0.98f, -0.19f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(9.19f, 12.02f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(16.17f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-1.68f, -1.68f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(13.76f, 17.75f, 12.91f, 18.0f, 12.0f, 18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-2.76f, 0.0f, -5.0f, -2.24f, -5.0f, -5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, -0.91f, 0.25f, -1.76f, 0.68f, -2.49f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(4.17f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(16.17f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(14.81f, 11.98f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.08f, 2.08f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(16.96f, 13.71f, 17.0f, 13.36f, 17.0f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, -2.76f, -2.24f, -5.0f, -5.0f, -5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.36f, 0.0f, -0.71f, 0.04f, -1.06f, 0.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.08f, 2.08f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(13.85f, 10.5f, 14.5f, 11.15f, 14.81f, 11.98f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        m2572addPathoIyEayM = $this$_get_NoPhotography__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _noPhotography = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _noPhotography;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
