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

/* compiled from: NoFlash.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_noFlash", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoFlash", "Landroidx/compose/material/icons/Icons$TwoTone;", "getNoFlash", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class NoFlashKt {
    private static ImageVector _noFlash;

    public static final ImageVector getNoFlash(Icons.TwoTone $this$NoFlash) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$NoFlash, "<this>");
        if (_noFlash != null) {
            ImageVector imageVector = _noFlash;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_NoFlash__u24lambda_u2d2 = new ImageVector.Builder("TwoTone.NoFlash", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(13.42f, 16.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(2.55f, 2.55f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(15.96f, 20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-8.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(3.02f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.59f, -0.65f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.15f, -0.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.5f, 1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(7.68f, 12.43f, 6.5f, 13.82f, 6.5f, 15.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 1.93f, 1.57f, 3.5f, 3.5f, 3.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(11.68f, 19.0f, 13.07f, 17.82f, 13.42f, 16.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(16.0f, 13.17f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.0f, -1.77f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-1.77f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(16.0f, 13.17f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_NoFlash__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(20.4f, 5.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(22.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(19.0f, 11.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(-1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(20.4f, 5.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(16.0f, 11.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(1.77f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(11.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, -0.88f, -0.72f, -1.6f, -1.6f, -1.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(-2.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(12.58f, 8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(-1.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(3.4f, 3.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(17.97f, 17.97f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(2.1f, 2.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(0.69f, 3.51f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(5.66f, 5.66f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(6.14f, 9.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(3.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(2.72f, 9.4f, 2.0f, 10.12f, 2.0f, 11.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(9.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(2.0f, 21.28f, 2.72f, 22.0f, 3.6f, 22.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(12.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.75f, 0.0f, 1.38f, -0.52f, 1.55f, -1.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.54f, 2.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.41f, -1.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(17.97f, 17.97f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(11.5f, 15.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 0.83f, -0.67f, 1.5f, -1.5f, 1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(-1.5f, -0.67f, -1.5f, -1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveTo(9.17f, 14.0f, 10.0f, 14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveTo(11.5f, 14.67f, 11.5f, 15.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(15.96f, 20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(-8.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(2.14f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(0.88f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(0.59f, -0.65f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(0.15f, -0.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.5f, 1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(7.68f, 12.43f, 6.5f, 13.82f, 6.5f, 15.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 1.93f, 1.57f, 3.5f, 3.5f, 3.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(1.68f, 0.0f, 3.07f, -1.18f, 3.42f, -2.76f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.55f, 2.55f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(15.96f, 20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        m2572addPathoIyEayM = $this$_get_NoFlash__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _noFlash = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _noFlash;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
