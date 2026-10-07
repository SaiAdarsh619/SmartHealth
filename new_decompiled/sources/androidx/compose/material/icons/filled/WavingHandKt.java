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

/* compiled from: WavingHand.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_wavingHand", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WavingHand", "Landroidx/compose/material/icons/Icons$Filled;", "getWavingHand", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-filled_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class WavingHandKt {
    private static ImageVector _wavingHand;

    public static final ImageVector getWavingHand(Icons.Filled $this$WavingHand) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$WavingHand, "<this>");
        if (_wavingHand != null) {
            ImageVector imageVector = _wavingHand;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_WavingHand__u24lambda_u2d1 = new ImageVector.Builder("Filled.WavingHand", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(23.0f, 17.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 3.31f, -2.69f, 6.0f, -6.0f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(2.48f, 0.0f, 4.5f, -2.02f, 4.5f, -4.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(23.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(1.0f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -3.31f, 2.69f, -6.0f, 6.0f, -6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(4.52f, 2.5f, 2.5f, 4.52f, 2.5f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(8.01f, 4.32f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-4.6f, 4.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-3.22f, 3.22f, -3.22f, 8.45f, 0.0f, 11.67f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(8.45f, 3.22f, 11.67f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(7.07f, -7.07f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.49f, -0.49f, 0.49f, -1.28f, 0.0f, -1.77f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.49f, -0.49f, -1.28f, -0.49f, -1.77f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-4.42f, 4.42f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.71f, -0.71f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(6.54f, -6.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.49f, -0.49f, 0.49f, -1.28f, 0.0f, -1.77f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-1.28f, -0.49f, -1.77f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-5.83f, 5.83f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.71f, -0.71f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(6.89f, -6.89f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.49f, -0.49f, 0.49f, -1.28f, 0.0f, -1.77f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-1.28f, -0.49f, -1.77f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-6.89f, 6.89f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(11.02f, 9.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(5.48f, -5.48f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.49f, -0.49f, 0.49f, -1.28f, 0.0f, -1.77f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-1.28f, -0.49f, -1.77f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-7.62f, 7.62f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.22f, 1.57f, 1.11f, 3.84f, -0.33f, 5.28f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.71f, -0.71f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.17f, -1.17f, 1.17f, -3.07f, 0.0f, -4.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.35f, -0.35f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.07f, -4.07f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.49f, -0.49f, 0.49f, -1.28f, 0.0f, -1.77f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(9.29f, 3.83f, 8.5f, 3.83f, 8.01f, 4.32f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_WavingHand__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _wavingHand = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _wavingHand;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
