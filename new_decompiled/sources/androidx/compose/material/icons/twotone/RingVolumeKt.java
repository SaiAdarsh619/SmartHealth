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

/* compiled from: RingVolume.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_ringVolume", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RingVolume", "Landroidx/compose/material/icons/Icons$TwoTone;", "getRingVolume", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class RingVolumeKt {
    private static ImageVector _ringVolume;

    public static final ImageVector getRingVolume(Icons.TwoTone $this$RingVolume) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$RingVolume, "<this>");
        if (_ringVolume != null) {
            ImageVector imageVector = _ringVolume;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_RingVolume__u24lambda_u2d2 = new ImageVector.Builder("TwoTone.RingVolume", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(18.6f, 17.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.66f, 0.37f, 1.28f, 0.79f, 1.87f, 1.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.07f, -1.07f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.91f, -0.75f, -1.9f, -1.38f, -2.94f, -1.9f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(1.7f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(3.53f, 18.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.58f, -0.47f, 1.21f, -0.89f, 1.87f, -1.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-1.71f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.05f, 0.51f, -2.03f, 1.15f, -2.95f, 1.9f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.08f, 1.08f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_RingVolume__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(12.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(7.46f, 12.0f, 3.34f, 13.78f, 0.29f, 16.67f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.18f, 0.18f, -0.29f, 0.43f, -0.29f, 0.71f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 0.28f, 0.11f, 0.53f, 0.29f, 0.71f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.48f, 2.48f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.18f, 0.18f, 0.43f, 0.29f, 0.71f, 0.29f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.27f, 0.0f, 0.52f, -0.11f, 0.7f, -0.28f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.79f, -0.74f, 1.69f, -1.36f, 2.66f, -1.85f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.33f, -0.16f, 0.56f, -0.5f, 0.56f, -0.9f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(-3.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(1.45f, -0.48f, 3.0f, -0.73f, 4.6f, -0.73f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(1.6f, 0.0f, 3.15f, 0.25f, 4.6f, 0.72f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(3.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 0.39f, 0.23f, 0.74f, 0.56f, 0.9f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.98f, 0.49f, 1.87f, 1.12f, 2.66f, 1.85f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.18f, 0.18f, 0.43f, 0.28f, 0.7f, 0.28f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.28f, 0.0f, 0.53f, -0.11f, 0.71f, -0.29f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.48f, -2.48f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.18f, -0.18f, 0.29f, -0.43f, 0.29f, -0.71f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, -0.27f, -0.11f, -0.52f, -0.29f, -0.7f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(20.66f, 13.78f, 16.54f, 12.0f, 12.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(5.4f, 17.23f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.66f, 0.37f, -1.29f, 0.8f, -1.87f, 1.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-1.07f, -1.07f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.91f, -0.75f, 1.9f, -1.39f, 2.95f, -1.9f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(1.7f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(20.47f, 18.49f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.59f, -0.48f, -1.21f, -0.9f, -1.87f, -1.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(-1.7f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(1.04f, 0.51f, 2.03f, 1.15f, 2.94f, 1.9f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-1.07f, 1.07f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(16.19f, 8.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.41f, 1.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(3.45f, -3.52f, 3.56f, -3.55f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-1.41f, -1.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-3.56f, 3.55f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(11.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(6.4f, 9.81f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(7.81f, 8.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(4.26f, 4.84f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(2.84f, 6.26f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.11f, 0.03f, 3.56f, 3.55f, 3.56f, 3.55f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        m2572addPathoIyEayM = $this$_get_RingVolume__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _ringVolume = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _ringVolume;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
