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

/* compiled from: Support.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_support", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Support", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSupport", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SupportKt {
    private static ImageVector _support;

    public static final ImageVector getSupport(Icons.TwoTone $this$Support) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Support, "<this>");
        if (_support != null) {
            ImageVector imageVector = _support;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Support__u24lambda_u2d5 = new ImageVector.Builder("TwoTone.Support", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(10.3f, 7.32f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(9.13f, 4.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(7.02f, 5.35f, 5.35f, 7.02f, 4.54f, 9.13f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(2.78f, 1.15f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(7.83f, 8.9f, 8.92f, 7.82f, 10.3f, 7.32f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_Support__u24lambda_u2d5.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(7.32f, 13.72f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-2.78f, 1.15f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.81f, 2.1f, 2.48f, 3.78f, 4.59f, 4.59f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.17f, -2.78f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(8.91f, 16.18f, 7.83f, 15.09f, 7.32f, 13.72f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$_get_Support__u24lambda_u2d5.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv3 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv3 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv3 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv3 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(16.67f, 10.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineToRelative(2.78f, -1.15f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(-0.81f, -2.1f, -2.48f, -3.77f, -4.58f, -4.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineToRelative(-1.15f, 2.78f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(15.09f, 7.83f, 16.17f, 8.9f, 16.67f, 10.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        $this$_get_Support__u24lambda_u2d5.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv3, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv3, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv4 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv4 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv4 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv4 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv4 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.moveTo(16.68f, 13.71f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveToRelative(-0.5f, 1.37f, -1.58f, 2.46f, -2.95f, 2.97f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineToRelative(1.15f, 2.78f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveToRelative(2.1f, -0.81f, 3.77f, -2.48f, 4.58f, -4.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineTo(16.68f, 13.71f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.close();
        $this$_get_Support__u24lambda_u2d5.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv4.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv4, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv4, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv4, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv4, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv5 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv5 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv5 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv5 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv5 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.moveTo(12.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.curveToRelative(0.0f, 5.52f, 4.48f, 10.0f, 10.0f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.curveTo(22.0f, 6.48f, 17.52f, 2.0f, 12.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.moveTo(14.87f, 4.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.curveToRelative(2.1f, 0.81f, 3.77f, 2.48f, 4.58f, 4.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.lineToRelative(-2.78f, 1.15f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.curveToRelative(-0.51f, -1.36f, -1.58f, -2.44f, -2.95f, -2.94f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.lineTo(14.87f, 4.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.moveTo(9.13f, 4.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.lineToRelative(1.17f, 2.78f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.curveToRelative(-1.38f, 0.5f, -2.47f, 1.59f, -2.98f, 2.97f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.lineTo(4.54f, 9.13f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.curveTo(5.35f, 7.02f, 7.02f, 5.35f, 9.13f, 4.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.moveTo(9.13f, 19.46f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.curveToRelative(-2.1f, -0.81f, -3.78f, -2.48f, -4.59f, -4.59f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.lineToRelative(2.78f, -1.15f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.curveToRelative(0.51f, 1.38f, 1.59f, 2.46f, 2.97f, 2.96f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.lineTo(9.13f, 19.46f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.moveTo(9.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.curveToRelative(0.0f, -1.66f, 1.34f, -3.0f, 3.0f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.reflectiveCurveToRelative(3.0f, 1.34f, 3.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.reflectiveCurveToRelative(-1.34f, 3.0f, -3.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.reflectiveCurveTo(9.0f, 13.66f, 9.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.moveTo(14.88f, 19.46f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.lineToRelative(-1.15f, -2.78f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.curveToRelative(1.37f, -0.51f, 2.45f, -1.59f, 2.95f, -2.97f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.lineToRelative(2.78f, 1.17f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.curveTo(18.65f, 16.98f, 16.98f, 18.65f, 14.88f, 19.46f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv5.close();
        m2572addPathoIyEayM = $this$_get_Support__u24lambda_u2d5.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv5.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv5, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv5, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv5, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv5, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _support = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _support;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
