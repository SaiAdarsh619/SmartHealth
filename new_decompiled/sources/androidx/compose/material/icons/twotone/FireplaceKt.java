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

/* compiled from: Fireplace.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_fireplace", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Fireplace", "Landroidx/compose/material/icons/Icons$TwoTone;", "getFireplace", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class FireplaceKt {
    private static ImageVector _fireplace;

    public static final ImageVector getFireplace(Icons.TwoTone $this$Fireplace) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Fireplace, "<this>");
        if (_fireplace != null) {
            ImageVector imageVector = _fireplace;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Fireplace__u24lambda_u2d3 = new ImageVector.Builder("TwoTone.Fireplace", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(4.0f, 20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.23f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.75f, -0.93f, -1.2f, -2.04f, -1.23f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.02f, -0.53f, -0.73f, -4.43f, 6.0f, -8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 0.0f, -0.8f, 2.61f, 2.15f, 4.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(15.91f, 12.15f, 17.0f, 13.11f, 17.0f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 1.13f, -0.39f, 2.16f, -1.02f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_Fireplace__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(12.01f, 12.46f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.15f, 0.42f, -0.15f, 0.82f, -0.08f, 1.28f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.1f, 0.55f, 0.33f, 1.04f, 0.2f, 1.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.13f, 0.59f, -0.77f, 1.38f, -1.53f, 1.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(1.28f, 1.05f, 3.2f, 0.37f, 3.39f, -1.32f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(14.16f, 14.11f, 12.55f, 13.67f, 12.01f, 12.46f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$_get_Fireplace__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv3 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv3 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv3 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv3 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineToRelative(20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineTo(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineTo(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(12.0f, 18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(-1.58f, 0.0f, -2.97f, -1.88f, -3.0f, -3.06f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.0f, -0.05f, -0.01f, -0.13f, -0.01f, -0.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(-0.13f, -1.73f, 1.0f, -3.2f, 2.47f, -4.37f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.47f, 1.01f, 1.27f, 2.03f, 2.57f, 2.92f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(14.61f, 13.69f, 15.0f, 14.13f, 15.0f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(15.0f, 16.65f, 13.65f, 18.0f, 12.0f, 18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(20.0f, 20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineToRelative(-2.02f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.63f, -0.84f, 1.02f, -1.87f, 1.02f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.0f, -1.89f, -1.09f, -2.85f, -1.85f, -3.37f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(12.2f, 9.61f, 13.0f, 7.0f, 13.0f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(-6.73f, 3.57f, -6.02f, 7.47f, -6.0f, 8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.03f, 0.96f, 0.49f, 2.07f, 1.23f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineTo(6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineToRelative(16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineTo(20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        m2572addPathoIyEayM = $this$_get_Fireplace__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv3, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv3, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _fireplace = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _fireplace;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
