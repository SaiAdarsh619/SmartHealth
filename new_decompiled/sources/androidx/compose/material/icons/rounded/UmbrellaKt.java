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

/* compiled from: Umbrella.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_umbrella", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Umbrella", "Landroidx/compose/material/icons/Icons$Rounded;", "getUmbrella", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class UmbrellaKt {
    private static ImageVector _umbrella;

    public static final ImageVector getUmbrella(Icons.Rounded $this$Umbrella) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Umbrella, "<this>");
        if (_umbrella != null) {
            ImageVector imageVector = _umbrella;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Umbrella__u24lambda_u2d1 = new ImageVector.Builder("Rounded.Umbrella", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(17.12f, 6.28f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(14.5f, 6.92f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(13.0f, 5.77f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(3.88f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(3.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.26f, 0.22f, -0.48f, 0.5f, -0.48f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.23f, 0.0f, 0.43f, 0.16f, 0.49f, 0.36f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(14.1f, 3.7f, 14.49f, 4.0f, 14.94f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.1f, -0.02f, -0.2f, -0.05f, -0.3f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(15.59f, 1.72f, 14.63f, 1.0f, 13.5f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(12.12f, 1.0f, 11.0f, 2.07f, 11.0f, 3.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(0.48f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(1.89f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(9.5f, 6.92f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(6.88f, 6.28f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(6.5f, 6.19f, 6.16f, 6.55f, 6.28f, 6.92f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.77f, 14.39f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(11.2f, 21.77f, 11.6f, 22.0f, 12.0f, 22.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(0.8f, -0.23f, 0.95f, -0.69f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.77f, -14.39f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(17.84f, 6.55f, 17.5f, 6.19f, 17.12f, 6.28f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(11.0f, 14.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(9.03f, 8.86f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.92f, 0.23f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.76f, -0.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(11.0f, 8.29f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(14.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(13.0f, 14.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(8.29f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.28f, 0.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.76f, 0.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.92f, -0.23f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(13.0f, 14.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Umbrella__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _umbrella = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _umbrella;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
