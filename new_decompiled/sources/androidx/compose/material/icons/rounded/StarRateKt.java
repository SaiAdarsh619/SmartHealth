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

/* compiled from: StarRate.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_starRate", "Landroidx/compose/ui/graphics/vector/ImageVector;", "StarRate", "Landroidx/compose/material/icons/Icons$Rounded;", "getStarRate", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class StarRateKt {
    private static ImageVector _starRate;

    public static final ImageVector getStarRate(Icons.Rounded $this$StarRate) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$StarRate, "<this>");
        if (_starRate != null) {
            ImageVector imageVector = _starRate;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_StarRate__u24lambda_u2d1 = new ImageVector.Builder("Rounded.StarRate", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(14.43f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-1.47f, -4.84f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.29f, -0.95f, -1.63f, -0.95f, -1.91f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(9.57f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(5.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.97f, 0.0f, -1.37f, 1.25f, -0.58f, 1.81f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(3.64f, 2.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-1.43f, 4.61f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.29f, 0.93f, 0.79f, 1.68f, 1.56f, 1.09f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(12.0f, 17.31f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(3.69f, 2.81f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.77f, 0.59f, 1.85f, -0.16f, 1.56f, -1.09f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-1.43f, -4.61f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(3.64f, -2.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.79f, -0.57f, 0.39f, -1.81f, -0.58f, -1.81f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(14.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_StarRate__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _starRate = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _starRate;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
