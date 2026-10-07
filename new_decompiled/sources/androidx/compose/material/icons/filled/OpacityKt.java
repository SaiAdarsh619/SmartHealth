package androidx.compose.material.icons.filled;

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

/* compiled from: Opacity.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_opacity", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Opacity", "Landroidx/compose/material/icons/Icons$Filled;", "getOpacity", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-filled_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class OpacityKt {
    private static ImageVector _opacity;

    public static final ImageVector getOpacity(Icons.Filled $this$Opacity) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Opacity, "<this>");
        if (_opacity != null) {
            ImageVector imageVector = _opacity;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Opacity__u24lambda_u2d1 = new ImageVector.Builder("Filled.Opacity", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(17.66f, 8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(12.0f, 2.35f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(6.34f, 8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(4.78f, 9.56f, 4.0f, 11.64f, 4.0f, 13.64f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(0.78f, 4.11f, 2.34f, 5.67f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(3.61f, 2.35f, 5.66f, 2.35f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(4.1f, -0.79f, 5.66f, -2.35f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(20.0f, 15.64f, 20.0f, 13.64f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(19.22f, 9.56f, 17.66f, 8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(6.0f, 14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.01f, -2.0f, 0.62f, -3.27f, 1.76f, -4.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(12.0f, 5.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.24f, 4.38f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(17.38f, 10.77f, 17.99f, 12.0f, 18.0f, 14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Opacity__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _opacity = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _opacity;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
