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

/* compiled from: FaceRetouchingNatural.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_faceRetouchingNatural", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FaceRetouchingNatural", "Landroidx/compose/material/icons/Icons$Rounded;", "getFaceRetouchingNatural", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class FaceRetouchingNaturalKt {
    private static ImageVector _faceRetouchingNatural;

    public static final ImageVector getFaceRetouchingNatural(Icons.Rounded $this$FaceRetouchingNatural) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$FaceRetouchingNatural, "<this>");
        if (_faceRetouchingNatural != null) {
            ImageVector imageVector = _faceRetouchingNatural;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_FaceRetouchingNatural__u24lambda_u2d4 = new ImageVector.Builder("Rounded.FaceRetouchingNatural", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(22.01f, 4.05f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(20.6f, 3.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.65f, -1.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.18f, -0.39f, -0.73f, -0.39f, -0.91f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(18.4f, 3.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-1.41f, 0.65f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.39f, 0.18f, -0.39f, 0.73f, 0.0f, 0.91f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(18.4f, 5.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.65f, 1.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.18f, 0.39f, 0.73f, 0.39f, 0.91f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(20.6f, 5.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.41f, -0.65f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(22.4f, 4.78f, 22.4f, 4.22f, 22.01f, 4.05f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_FaceRetouchingNatural__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(9.0f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveToRelative(-1.25f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.arcToRelative(1.25f, 1.25f, 0.0f, true, true, 2.5f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.arcToRelative(1.25f, 1.25f, 0.0f, true, true, -2.5f, 0.0f);
        $this$_get_FaceRetouchingNatural__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv3 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv3 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv3 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv3 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(15.0f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveToRelative(-1.25f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.arcToRelative(1.25f, 1.25f, 0.0f, true, true, 2.5f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.arcToRelative(1.25f, 1.25f, 0.0f, true, true, -2.5f, 0.0f);
        $this$_get_FaceRetouchingNatural__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv3, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv3, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv4 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv4 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv4 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv4 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv4 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.moveTo(19.5f, 8.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveToRelative(-0.78f, 0.0f, -1.49f, -0.46f, -1.82f, -1.17f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineToRelative(-0.41f, -0.9f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.lineToRelative(-0.9f, -0.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveTo(15.66f, 5.99f, 15.2f, 5.28f, 15.2f, 4.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveToRelative(0.0f, -0.66f, 0.34f, -1.26f, 0.87f, -1.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveTo(14.83f, 2.32f, 13.45f, 2.0f, 12.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveToRelative(0.0f, -1.45f, -0.32f, -2.83f, -0.87f, -4.07f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveTo(20.76f, 8.46f, 20.16f, 8.8f, 19.5f, 8.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.moveTo(12.0f, 20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveToRelative(-4.41f, 0.0f, -8.0f, -3.59f, -8.0f, -8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveToRelative(0.0f, -0.05f, 0.01f, -0.1f, 0.0f, -0.14f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveToRelative(2.6f, -0.98f, 4.69f, -2.99f, 5.74f, -5.55f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveTo(11.58f, 8.56f, 14.37f, 10.0f, 17.5f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveToRelative(0.75f, 0.0f, 1.47f, -0.09f, 2.17f, -0.24f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveTo(19.88f, 10.47f, 20.0f, 11.22f, 20.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveTo(20.0f, 16.41f, 16.41f, 20.0f, 12.0f, 20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.close();
        m2572addPathoIyEayM = $this$_get_FaceRetouchingNatural__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv4.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv4, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv4, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv4, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv4, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _faceRetouchingNatural = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _faceRetouchingNatural;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
