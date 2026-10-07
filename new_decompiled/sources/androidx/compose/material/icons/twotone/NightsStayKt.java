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

/* compiled from: NightsStay.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_nightsStay", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NightsStay", "Landroidx/compose/material/icons/Icons$TwoTone;", "getNightsStay", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class NightsStayKt {
    private static ImageVector _nightsStay;

    public static final ImageVector getNightsStay(Icons.TwoTone $this$NightsStay) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$NightsStay, "<this>");
        if (_nightsStay != null) {
            ImageVector imageVector = _nightsStay;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_NightsStay__u24lambda_u2d3 = new ImageVector.Builder("TwoTone.NightsStay", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(8.1f, 14.15f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(9.77f, 14.63f, 11.0f, 16.17f, 11.0f, 18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 0.68f, -0.19f, 1.31f, -0.48f, 1.87f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.48f, 0.09f, 0.97f, 0.14f, 1.48f, 0.14f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.48f, 0.0f, 2.9f, -0.41f, 4.13f, -1.15f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-2.62f, -0.92f, -5.23f, -2.82f, -6.8f, -5.86f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(7.74f, 9.94f, 7.78f, 7.09f, 8.29f, 4.9f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-2.57f, 1.33f, -4.3f, 4.01f, -4.3f, 7.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.01f, 0.0f, 0.01f, 0.0f, 0.02f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(5.66f, 12.0f, 7.18f, 12.83f, 8.1f, 14.15f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_NightsStay__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(19.78f, 17.51f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-2.47f, 0.0f, -6.57f, -1.33f, -8.68f, -5.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(8.77f, 7.57f, 10.6f, 3.6f, 11.63f, 2.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(6.27f, 2.2f, 1.98f, 6.59f, 1.98f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 0.14f, 0.02f, 0.28f, 0.02f, 0.42f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(2.61f, 12.16f, 3.28f, 12.0f, 3.98f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, -3.09f, 1.73f, -5.77f, 4.3f, -7.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(7.78f, 7.09f, 7.74f, 9.94f, 9.32f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(1.57f, 3.04f, 4.18f, 4.95f, 6.8f, 5.86f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-1.23f, 0.74f, -2.65f, 1.15f, -4.13f, 1.15f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.5f, 0.0f, -1.0f, -0.05f, -1.48f, -0.14f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.37f, 0.7f, -0.94f, 1.27f, -1.64f, 1.64f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.98f, 0.32f, 2.03f, 0.5f, 3.11f, 0.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(3.5f, 0.0f, 6.58f, -1.8f, 8.37f, -4.52f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(20.18f, 17.5f, 19.98f, 17.51f, 19.78f, 17.51f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$_get_NightsStay__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv3 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv3 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv3 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv3 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(7.0f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineToRelative(-0.18f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(6.4f, 14.84f, 5.3f, 14.0f, 4.0f, 14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(-1.66f, 0.0f, -3.0f, 1.34f, -3.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.reflectiveCurveToRelative(1.34f, 3.0f, 3.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.62f, 0.0f, 2.49f, 0.0f, 3.0f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(9.0f, 16.9f, 8.1f, 16.0f, 7.0f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        m2572addPathoIyEayM = $this$_get_NightsStay__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv3, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv3, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _nightsStay = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _nightsStay;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
