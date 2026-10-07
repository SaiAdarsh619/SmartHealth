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

/* compiled from: Wifi2Bar.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_wifi2Bar", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Wifi2Bar", "Landroidx/compose/material/icons/Icons$Rounded;", "getWifi2Bar", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class Wifi2BarKt {
    private static ImageVector _wifi2Bar;

    public static final ImageVector getWifi2Bar(Icons.Rounded $this$Wifi2Bar) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Wifi2Bar, "<this>");
        if (_wifi2Bar != null) {
            ImageVector imageVector = _wifi2Bar;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Wifi2Bar__u24lambda_u2d1 = new ImageVector.Builder("Rounded.Wifi2Bar", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(12.0f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(0.9f, 2.0f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(13.1f, 16.0f, 12.0f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(5.38f, 14.37f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.63f, -0.63f, -0.59f, -1.71f, 0.13f, -2.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(7.33f, 10.79f, 9.57f, 10.0f, 12.0f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(2.43f, 0.0f, 4.67f, 0.79f, 6.49f, 2.13f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.72f, 0.53f, 0.76f, 1.6f, 0.13f, 2.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.53f, 0.54f, -1.37f, 0.57f, -1.98f, 0.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(15.33f, 13.55f, 13.73f, 13.0f, 12.0f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.73f, 0.0f, -3.33f, 0.55f, -4.64f, 1.49f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(6.75f, 14.93f, 5.91f, 14.9f, 5.38f, 14.37f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Wifi2Bar__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _wifi2Bar = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _wifi2Bar;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
