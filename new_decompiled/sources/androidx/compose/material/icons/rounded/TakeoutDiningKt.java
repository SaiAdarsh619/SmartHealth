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

/* compiled from: TakeoutDining.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_takeoutDining", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TakeoutDining", "Landroidx/compose/material/icons/Icons$Rounded;", "getTakeoutDining", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TakeoutDiningKt {
    private static ImageVector _takeoutDining;

    public static final ImageVector getTakeoutDining(Icons.Rounded $this$TakeoutDining) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$TakeoutDining, "<this>");
        if (_takeoutDining != null) {
            ImageVector imageVector = _takeoutDining;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_TakeoutDining__u24lambda_u2d2 = new ImageVector.Builder("Rounded.TakeoutDining", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(21.29f, 6.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.39f, -0.39f, -1.01f, -0.39f, -1.4f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(19.0f, 7.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.03f, -0.56f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-3.46f, -3.48f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(15.19f, 3.21f, 14.68f, 3.0f, 14.15f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-4.3f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(9.32f, 3.0f, 8.81f, 3.21f, 8.43f, 3.59f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(4.97f, 7.07f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(5.0f, 7.57f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(4.11f, 6.7f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(3.72f, 6.32f, 3.1f, 6.32f, 2.72f, 6.71f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(2.7f, 6.73f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(2.32f, 7.12f, 2.32f, 7.75f, 2.72f, 8.13f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(4.66f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(14.69f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.92f, -1.84f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(21.67f, 7.78f, 21.68f, 7.14f, 21.29f, 6.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_TakeoutDining__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(5.79f, 18.15f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(5.87f, 19.19f, 6.74f, 20.0f, 7.79f, 20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(8.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(1.05f, 0.0f, 1.92f, -0.81f, 1.99f, -1.85f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(0.49f, -6.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(5.3f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(5.79f, 18.15f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        m2572addPathoIyEayM = $this$_get_TakeoutDining__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _takeoutDining = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _takeoutDining;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
