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

/* compiled from: Animation.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_animation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Animation", "Landroidx/compose/material/icons/Icons$Filled;", "getAnimation", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-filled_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AnimationKt {
    private static ImageVector _animation;

    public static final ImageVector getAnimation(Icons.Filled $this$Animation) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Animation, "<this>");
        if (_animation != null) {
            ImageVector imageVector = _animation;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Animation__u24lambda_u2d1 = new ImageVector.Builder("Filled.Animation", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(15.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-2.71f, 0.0f, -5.05f, 1.54f, -6.22f, 3.78f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.28f, 0.67f, -2.34f, 1.72f, -3.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(3.54f, 9.95f, 2.0f, 12.29f, 2.0f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 3.87f, 3.13f, 7.0f, 7.0f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(2.71f, 0.0f, 5.05f, -1.54f, 6.22f, -3.78f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.28f, -0.67f, 2.34f, -1.72f, 3.0f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(20.46f, 14.05f, 22.0f, 11.71f, 22.0f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -3.87f, -3.13f, -7.0f, -7.0f, -7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(9.0f, 20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-2.76f, 0.0f, -5.0f, -2.24f, -5.0f, -5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -1.12f, 0.37f, -2.16f, 1.0f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 3.87f, 3.13f, 7.0f, 7.0f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.84f, 0.63f, -1.88f, 1.0f, -3.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(12.0f, 17.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-2.76f, 0.0f, -5.0f, -2.24f, -5.0f, -5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -1.12f, 0.37f, -2.16f, 1.0f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 3.86f, 3.13f, 6.99f, 7.0f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.84f, 0.63f, -1.88f, 1.0f, -3.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(16.7f, 13.7f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.53f, 0.19f, -1.1f, 0.3f, -1.7f, 0.3f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-2.76f, 0.0f, -5.0f, -2.24f, -5.0f, -5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.6f, 0.11f, -1.17f, 0.3f, -1.7f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.53f, -0.19f, 1.1f, -0.3f, 1.7f, -0.3f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(2.76f, 0.0f, 5.0f, 2.24f, 5.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 0.6f, -0.11f, 1.17f, -0.3f, 1.7f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(19.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -3.86f, -3.13f, -6.99f, -7.0f, -7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.84f, -0.63f, 1.87f, -1.0f, 3.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(2.76f, 0.0f, 5.0f, 2.24f, 5.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 1.12f, -0.37f, 2.16f, -1.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Animation__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _animation = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _animation;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
