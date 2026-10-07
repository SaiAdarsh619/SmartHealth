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

/* compiled from: Waves.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_waves", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Waves", "Landroidx/compose/material/icons/Icons$TwoTone;", "getWaves", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class WavesKt {
    private static ImageVector _waves;

    public static final ImageVector getWaves(Icons.TwoTone $this$Waves) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Waves, "<this>");
        if (_waves != null) {
            ImageVector imageVector = _waves;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Waves__u24lambda_u2d1 = new ImageVector.Builder("TwoTone.Waves", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(17.0f, 16.99f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.35f, 0.0f, -2.2f, 0.42f, -2.95f, 0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.65f, 0.33f, -1.18f, 0.6f, -2.05f, 0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.9f, 0.0f, -1.4f, -0.25f, -2.05f, -0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.75f, -0.38f, -1.57f, -0.8f, -2.95f, -0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-2.2f, 0.42f, -2.95f, 0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.65f, 0.33f, -1.17f, 0.6f, -2.05f, 0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(1.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.35f, 0.0f, 2.2f, -0.42f, 2.95f, -0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.65f, -0.33f, 1.17f, -0.6f, 2.05f, -0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.4f, 0.25f, 2.05f, 0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.75f, 0.38f, 1.57f, 0.8f, 2.95f, 0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(2.2f, -0.42f, 2.95f, -0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.65f, -0.33f, 1.18f, -0.6f, 2.05f, -0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.9f, 0.0f, 1.4f, 0.25f, 2.05f, 0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.75f, 0.38f, 1.58f, 0.8f, 2.95f, 0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-1.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.9f, 0.0f, -1.4f, -0.25f, -2.05f, -0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.75f, -0.38f, -1.6f, -0.8f, -2.95f, -0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(17.0f, 12.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.35f, 0.0f, -2.2f, 0.43f, -2.95f, 0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.65f, 0.32f, -1.18f, 0.6f, -2.05f, 0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.9f, 0.0f, -1.4f, -0.25f, -2.05f, -0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.75f, -0.38f, -1.57f, -0.8f, -2.95f, -0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-2.2f, 0.43f, -2.95f, 0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.65f, 0.32f, -1.17f, 0.6f, -2.05f, 0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(1.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.35f, 0.0f, 2.2f, -0.43f, 2.95f, -0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.65f, -0.35f, 1.15f, -0.6f, 2.05f, -0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.4f, 0.25f, 2.05f, 0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.75f, 0.38f, 1.57f, 0.8f, 2.95f, 0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(2.2f, -0.43f, 2.95f, -0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.65f, -0.35f, 1.15f, -0.6f, 2.05f, -0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.4f, 0.25f, 2.05f, 0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.75f, 0.38f, 1.58f, 0.8f, 2.95f, 0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-1.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.9f, 0.0f, -1.4f, -0.25f, -2.05f, -0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.75f, -0.38f, -1.6f, -0.8f, -2.95f, -0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(19.95f, 4.46f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.75f, -0.38f, -1.58f, -0.8f, -2.95f, -0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-2.2f, 0.42f, -2.95f, 0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.65f, 0.32f, -1.18f, 0.6f, -2.05f, 0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.9f, 0.0f, -1.4f, -0.25f, -2.05f, -0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.75f, -0.37f, -1.57f, -0.8f, -2.95f, -0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-2.2f, 0.42f, -2.95f, 0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.65f, 0.33f, -1.17f, 0.6f, -2.05f, 0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(1.93f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.35f, 0.0f, 2.2f, -0.43f, 2.95f, -0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.65f, -0.33f, 1.17f, -0.6f, 2.05f, -0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.4f, 0.25f, 2.05f, 0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.75f, 0.38f, 1.57f, 0.8f, 2.95f, 0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(2.2f, -0.43f, 2.95f, -0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.65f, -0.32f, 1.18f, -0.6f, 2.05f, -0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.9f, 0.0f, 1.4f, 0.25f, 2.05f, 0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.75f, 0.38f, 1.58f, 0.8f, 2.95f, 0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(22.0f, 5.04f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.9f, 0.0f, -1.4f, -0.25f, -2.05f, -0.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(17.0f, 8.09f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.35f, 0.0f, -2.2f, 0.43f, -2.95f, 0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.65f, 0.35f, -1.15f, 0.6f, -2.05f, 0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-1.4f, -0.25f, -2.05f, -0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.75f, -0.38f, -1.57f, -0.8f, -2.95f, -0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-2.2f, 0.43f, -2.95f, 0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.65f, 0.35f, -1.15f, 0.6f, -2.05f, 0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(1.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.35f, 0.0f, 2.2f, -0.43f, 2.95f, -0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.65f, -0.32f, 1.18f, -0.6f, 2.05f, -0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.4f, 0.25f, 2.05f, 0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.75f, 0.38f, 1.57f, 0.8f, 2.95f, 0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(2.2f, -0.43f, 2.95f, -0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.65f, -0.32f, 1.18f, -0.6f, 2.05f, -0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.9f, 0.0f, 1.4f, 0.25f, 2.05f, 0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.75f, 0.38f, 1.58f, 0.8f, 2.95f, 0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(22.0f, 9.49f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.9f, 0.0f, -1.4f, -0.25f, -2.05f, -0.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.75f, -0.38f, -1.6f, -0.8f, -2.95f, -0.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Waves__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _waves = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _waves;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
