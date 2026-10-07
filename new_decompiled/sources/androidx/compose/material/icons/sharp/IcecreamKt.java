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

/* compiled from: Icecream.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_icecream", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Icecream", "Landroidx/compose/material/icons/Icons$Sharp;", "getIcecream", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-sharp_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class IcecreamKt {
    private static ImageVector _icecream;

    public static final ImageVector getIcecream(Icons.Sharp $this$Icecream) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Icecream, "<this>");
        if (_icecream != null) {
            ImageVector imageVector = _icecream;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Icecream__u24lambda_u2d1 = new ImageVector.Builder("Sharp.Icecream", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(18.38f, 6.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(17.79f, 3.24f, 15.14f, 1.0f, 12.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(6.21f, 3.24f, 5.62f, 6.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(4.08f, 6.81f, 3.0f, 8.29f, 3.0f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 2.21f, 1.79f, 4.0f, 4.0f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.12f, 0.0f, 0.23f, -0.02f, 0.34f, -0.02f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(12.07f, 23.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.61f, -9.03f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(16.79f, 13.98f, 16.89f, 14.0f, 17.0f, 14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(2.21f, 0.0f, 4.0f, -1.79f, 4.0f, -4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(21.0f, 8.29f, 19.92f, 6.81f, 18.38f, 6.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(12.05f, 18.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-2.73f, -5.21f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(10.15f, 13.79f, 11.06f, 14.0f, 12.0f, 14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.95f, 0.0f, 1.88f, -0.21f, 2.72f, -0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(12.05f, 18.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Icecream__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _icecream = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _icecream;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
