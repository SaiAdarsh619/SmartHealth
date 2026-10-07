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

/* compiled from: Masks.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_masks", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Masks", "Landroidx/compose/material/icons/Icons$Rounded;", "getMasks", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class MasksKt {
    private static ImageVector _masks;

    public static final ImageVector getMasks(Icons.Rounded $this$Masks) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Masks, "<this>");
        if (_masks != null) {
            ImageVector imageVector = _masks;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Masks__u24lambda_u2d1 = new ImageVector.Builder("Rounded.Masks", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(19.5f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.31f, 0.0f, -2.37f, 1.01f, -2.48f, 2.3f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(15.14f, 7.8f, 14.18f, 6.5f, 12.0f, 6.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-2.19f, 0.0f, -3.14f, 1.3f, -5.02f, 1.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(6.87f, 7.02f, 5.81f, 6.0f, 4.5f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(3.12f, 6.0f, 2.0f, 7.12f, 2.0f, 8.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 6.0f, 3.6f, 7.81f, 6.52f, 7.98f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(9.53f, 17.62f, 10.72f, 18.0f, 12.0f, 18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(2.47f, -0.38f, 3.48f, -1.02f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(18.4f, 16.81f, 22.0f, 15.0f, 22.0f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(8.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(22.0f, 7.12f, 20.88f, 6.0f, 19.5f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(3.5f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(8.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.55f, 0.45f, -1.0f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.0f, 0.45f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 1.28f, 0.38f, 2.47f, 1.01f, 3.48f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(4.99f, 14.27f, 3.5f, 12.65f, 3.5f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(14.3f, 11.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.4f, -0.17f, -0.72f, -0.36f, -1.01f, -0.53f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(12.83f, 10.2f, 12.49f, 10.0f, 12.0f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.49f, 0.0f, -0.84f, 0.2f, -1.31f, 0.48f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.28f, 0.17f, -0.6f, 0.35f, -0.98f, 0.51f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(9.37f, 11.14f, 9.0f, 10.91f, 9.0f, 10.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.2f, 0.11f, -0.38f, 0.29f, -0.45f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.34f, -0.14f, 0.62f, -0.31f, 0.88f, -0.46f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(10.72f, 9.3f, 11.23f, 9.0f, 12.0f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.27f, 0.3f, 1.8f, 0.62f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.27f, 0.16f, 0.55f, 0.33f, 0.9f, 0.48f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.18f, 0.08f, 0.29f, 0.26f, 0.29f, 0.45f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(15.0f, 10.91f, 14.63f, 11.15f, 14.3f, 11.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(20.5f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 3.65f, -1.49f, 5.27f, -3.01f, 5.98f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.64f, -1.01f, 1.01f, -2.2f, 1.01f, -3.48f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.55f, 0.45f, -1.0f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.0f, 0.45f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Masks__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _masks = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _masks;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
