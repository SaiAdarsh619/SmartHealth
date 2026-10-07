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

/* compiled from: Bathtub.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_bathtub", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Bathtub", "Landroidx/compose/material/icons/Icons$TwoTone;", "getBathtub", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class BathtubKt {
    private static ImageVector _bathtub;

    public static final ImageVector getBathtub(Icons.TwoTone $this$Bathtub) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Bathtub, "<this>");
        if (_bathtub != null) {
            ImageVector imageVector = _bathtub;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Bathtub__u24lambda_u2d3 = new ImageVector.Builder("TwoTone.Bathtub", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(4.0f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_Bathtub__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(7.0f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveToRelative(-2.0f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.arcToRelative(2.0f, 2.0f, 0.0f, true, true, 4.0f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.arcToRelative(2.0f, 2.0f, 0.0f, true, true, -4.0f, 0.0f);
        $this$_get_Bathtub__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv3 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv3 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv3 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv3 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(20.0f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineTo(4.83f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(20.0f, 3.27f, 18.73f, 2.0f, 17.17f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(-0.75f, 0.0f, -1.47f, 0.3f, -2.0f, 0.83f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineToRelative(-1.25f, 1.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(13.76f, 4.03f, 13.59f, 4.0f, 13.41f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(-0.4f, 0.0f, -0.77f, 0.12f, -1.08f, 0.32f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineToRelative(2.76f, 2.76f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.2f, -0.31f, 0.32f, -0.68f, 0.32f, -1.08f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.0f, -0.18f, -0.03f, -0.34f, -0.07f, -0.51f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineToRelative(1.25f, -1.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(16.74f, 4.09f, 16.95f, 4.0f, 17.17f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(17.63f, 4.0f, 18.0f, 4.37f, 18.0f, 4.83f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineTo(13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineToRelative(-6.85f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(-0.3f, -0.21f, -0.57f, -0.45f, -0.82f, -0.72f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineToRelative(-1.4f, -1.55f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(-0.19f, -0.21f, -0.43f, -0.38f, -0.69f, -0.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(7.93f, 10.08f, 7.59f, 10.0f, 7.24f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(6.0f, 10.01f, 5.0f, 11.01f, 5.0f, 12.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineTo(13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineTo(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineToRelative(14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(-6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineTo(20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(20.0f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(-4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineToRelative(16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineTo(19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        m2572addPathoIyEayM = $this$_get_Bathtub__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv3, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv3, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _bathtub = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _bathtub;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
