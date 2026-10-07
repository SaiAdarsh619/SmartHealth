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

/* compiled from: DoubleArrow.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_doubleArrow", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DoubleArrow", "Landroidx/compose/material/icons/Icons$Rounded;", "getDoubleArrow", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class DoubleArrowKt {
    private static ImageVector _doubleArrow;

    public static final ImageVector getDoubleArrow(Icons.Rounded $this$DoubleArrow) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$DoubleArrow, "<this>");
        if (_doubleArrow != null) {
            ImageVector imageVector = _doubleArrow;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_DoubleArrow__u24lambda_u2d2 = new ImageVector.Builder("Rounded.DoubleArrow", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(20.08f, 11.42f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-4.04f, -5.65f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(15.7f, 5.29f, 15.15f, 5.0f, 14.56f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.49f, 0.0f, -2.35f, 1.68f, -1.49f, 2.89f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(16.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-2.93f, 4.11f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.87f, 1.21f, 0.0f, 2.89f, 1.49f, 2.89f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.59f, 0.0f, 1.15f, -0.29f, 1.49f, -0.77f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.04f, -5.65f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(20.33f, 12.23f, 20.33f, 11.77f, 20.08f, 11.42f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_DoubleArrow__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(13.08f, 11.42f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(9.05f, 5.77f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(8.7f, 5.29f, 8.15f, 5.0f, 7.56f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(6.07f, 5.0f, 5.2f, 6.68f, 6.07f, 7.89f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(9.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-2.93f, 4.11f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(5.2f, 17.32f, 6.07f, 19.0f, 7.56f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.59f, 0.0f, 1.15f, -0.29f, 1.49f, -0.77f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(4.04f, -5.65f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(13.33f, 12.23f, 13.33f, 11.77f, 13.08f, 11.42f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        m2572addPathoIyEayM = $this$_get_DoubleArrow__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _doubleArrow = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _doubleArrow;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
