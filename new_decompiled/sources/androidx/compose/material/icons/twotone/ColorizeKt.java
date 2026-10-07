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

/* compiled from: Colorize.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_colorize", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Colorize", "Landroidx/compose/material/icons/Icons$TwoTone;", "getColorize", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ColorizeKt {
    private static ImageVector _colorize;

    public static final ImageVector getColorize(Icons.TwoTone $this$Colorize) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Colorize, "<this>");
        if (_colorize != null) {
            ImageVector imageVector = _colorize;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Colorize__u24lambda_u2d2 = new ImageVector.Builder("TwoTone.Colorize", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(15.896f, 9.023f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.92f, -0.92f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(17.67f, 5.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.92f, 0.92f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_Colorize__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(20.71f, 5.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-2.34f, -2.34f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.2f, -0.2f, -0.45f, -0.29f, -0.71f, -0.29f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(-0.51f, 0.1f, -0.7f, 0.29f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-3.12f, 3.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-1.93f, -1.91f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-1.41f, 1.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.42f, 1.42f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(3.0f, 16.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(3.0f, 21.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(4.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(8.92f, -8.92f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.42f, 1.42f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.41f, -1.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-1.92f, -1.92f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(3.12f, -3.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.4f, -0.4f, 0.4f, -1.03f, 0.01f, -1.42f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(6.92f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(5.0f, 17.08f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(8.06f, -8.06f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.92f, 1.92f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(6.92f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(15.9f, 9.03f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-0.93f, -0.93f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.69f, -2.69f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(0.92f, 0.92f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-2.68f, 2.7f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        m2572addPathoIyEayM = $this$_get_Colorize__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _colorize = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _colorize;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
