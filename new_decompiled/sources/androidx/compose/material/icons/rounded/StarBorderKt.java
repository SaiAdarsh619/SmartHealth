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

/* compiled from: StarBorder.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_starBorder", "Landroidx/compose/ui/graphics/vector/ImageVector;", "StarBorder", "Landroidx/compose/material/icons/Icons$Rounded;", "getStarBorder", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class StarBorderKt {
    private static ImageVector _starBorder;

    public static final ImageVector getStarBorder(Icons.Rounded $this$StarBorder) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$StarBorder, "<this>");
        if (_starBorder != null) {
            ImageVector imageVector = _starBorder;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_StarBorder__u24lambda_u2d1 = new ImageVector.Builder("Rounded.StarBorder", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(19.65f, 9.04f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-4.84f, -0.42f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-1.89f, -4.45f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.34f, -0.81f, -1.5f, -0.81f, -1.84f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(9.19f, 8.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-4.83f, 0.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.88f, 0.07f, -1.24f, 1.17f, -0.57f, 1.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(3.67f, 3.18f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-1.1f, 4.72f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.2f, 0.86f, 0.73f, 1.54f, 1.49f, 1.08f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.15f, -2.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.15f, 2.51f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.76f, 0.46f, 1.69f, -0.22f, 1.49f, -1.08f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-1.1f, -4.73f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(3.67f, -3.18f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.67f, -0.58f, 0.32f, -1.68f, -0.56f, -1.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(12.0f, 15.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-3.76f, 2.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.0f, -4.28f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-3.32f, -2.88f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.38f, -0.38f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(12.0f, 6.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.71f, 4.04f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.38f, 0.38f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-3.32f, 2.88f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.0f, 4.28f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(12.0f, 15.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_StarBorder__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _starBorder = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _starBorder;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
