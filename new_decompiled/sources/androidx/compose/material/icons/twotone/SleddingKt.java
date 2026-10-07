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

/* compiled from: Sledding.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_sledding", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Sledding", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSledding", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SleddingKt {
    private static ImageVector _sledding;

    public static final ImageVector getSledding(Icons.TwoTone $this$Sledding) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Sledding, "<this>");
        if (_sledding != null) {
            ImageVector imageVector = _sledding;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Sledding__u24lambda_u2d1 = new ImageVector.Builder("TwoTone.Sledding", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(14.0f, 4.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 1.1f, -0.9f, 2.0f, -2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-2.0f, -0.9f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(14.0f, 3.4f, 14.0f, 4.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(22.8f, 20.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.68f, 2.1f, -2.94f, 3.25f, -5.04f, 2.57f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(1.0f, 17.36f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.46f, -1.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(3.93f, 1.28f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.46f, -1.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(1.93f, 14.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.46f, -1.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(4.0f, 13.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(9.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(5.47f, -2.35f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.39f, -0.17f, 0.84f, -0.21f, 1.28f, -0.07f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.95f, 0.31f, 1.46f, 1.32f, 1.16f, 2.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-1.05f, 3.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(13.0f, 12.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.89f, -0.15f, 1.76f, 0.32f, 2.14f, 1.14f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(2.08f, 4.51f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.93f, 0.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.46f, 1.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-3.32f, -1.08f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(14.9f, 20.3f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(3.32f, 1.08f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.0f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.31f, 0.43f, 2.72f, -0.29f, 3.15f, -1.61f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.43f, -1.31f, -0.29f, -2.72f, -1.61f, -3.15f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.46f, -1.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(22.33f, 15.88f, 23.49f, 18.14f, 22.8f, 20.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(6.0f, 14.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.01f, 0.33f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.22f, -0.42f, -0.28f, -0.92f, -0.12f, -1.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(7.92f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(6.0f, 10.82f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(14.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(13.94f, 18.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-6.66f, -2.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.46f, 1.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(6.66f, 2.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(13.94f, 18.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(14.63f, 17.05f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-1.18f, -2.56f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-3.97f, 0.89f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(14.63f, 17.05f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Sledding__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _sledding = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _sledding;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
