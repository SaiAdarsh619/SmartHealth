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

/* compiled from: EuroSymbol.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_euroSymbol", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EuroSymbol", "Landroidx/compose/material/icons/Icons$Rounded;", "getEuroSymbol", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class EuroSymbolKt {
    private static ImageVector _euroSymbol;

    public static final ImageVector getEuroSymbol(Icons.Rounded $this$EuroSymbol) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$EuroSymbol, "<this>");
        if (_euroSymbol != null) {
            ImageVector imageVector = _euroSymbol;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_EuroSymbol__u24lambda_u2d1 = new ImageVector.Builder("Rounded.EuroSymbol", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(15.0f, 18.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-2.51f, 0.0f, -4.68f, -1.42f, -5.76f, -3.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-0.45f, -1.0f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(8.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.05f, -0.33f, -0.08f, -0.66f, -0.08f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(0.03f, -0.67f, 0.08f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-0.45f, -1.0f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(9.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(10.32f, 6.92f, 12.5f, 5.5f, 15.0f, 5.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.25f, 0.0f, 2.42f, 0.36f, 3.42f, 0.97f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.5f, 0.31f, 1.15f, 0.26f, 1.57f, -0.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.58f, -0.58f, 0.45f, -1.53f, -0.25f, -1.96f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(18.36f, 3.5f, 16.73f, 3.0f, 15.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-3.92f, 0.0f, -7.24f, 2.51f, -8.48f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(0.45f, 1.0f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.06f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.04f, 0.33f, -0.06f, 0.66f, -0.06f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(0.02f, 0.67f, 0.06f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(0.45f, 1.0f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.52f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.24f, 3.49f, 4.56f, 6.0f, 8.48f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.74f, 0.0f, 3.36f, -0.49f, 4.74f, -1.35f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.69f, -0.43f, 0.82f, -1.39f, 0.24f, -1.97f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.42f, -0.42f, -1.07f, -0.47f, -1.57f, -0.15f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.99f, 0.62f, -2.15f, 0.97f, -3.41f, 0.97f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_EuroSymbol__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _euroSymbol = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _euroSymbol;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
