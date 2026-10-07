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

/* compiled from: TypeSpecimen.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_typeSpecimen", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TypeSpecimen", "Landroidx/compose/material/icons/Icons$Rounded;", "getTypeSpecimen", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TypeSpecimenKt {
    private static ImageVector _typeSpecimen;

    public static final ImageVector getTypeSpecimen(Icons.Rounded $this$TypeSpecimen) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$TypeSpecimen, "<this>");
        if (_typeSpecimen != null) {
            ImageVector imageVector = _typeSpecimen;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_TypeSpecimen__u24lambda_u2d3 = new ImageVector.Builder("Rounded.TypeSpecimen", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(3.0f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(3.0f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(2.45f, 6.0f, 2.0f, 6.45f, 2.0f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(4.0f, 6.45f, 3.55f, 6.0f, 3.0f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_TypeSpecimen__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(20.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(6.9f, 2.0f, 6.0f, 2.9f, 6.0f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(22.0f, 2.9f, 21.1f, 2.0f, 20.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(16.46f, 14.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-0.63f, -1.82f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(-3.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-0.65f, 1.82f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.1f, 0.29f, -0.38f, 0.48f, -0.68f, 0.48f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.51f, 0.0f, -0.86f, -0.51f, -0.68f, -0.98f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.73f, -7.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(13.08f, 5.8f, 13.52f, 5.5f, 14.0f, 5.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.48f, 0.0f, 0.92f, 0.3f, 1.09f, 0.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.73f, 7.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.18f, 0.47f, -0.17f, 0.98f, -0.68f, 0.98f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(16.83f, 14.5f, 16.56f, 14.31f, 16.46f, 14.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$_get_TypeSpecimen__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv3 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv3 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv3 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv3 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(13.96f, 7.17f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineToRelative(-1.31f, 3.72f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineToRelative(2.69f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineToRelative(-1.3f, -3.72f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        m2572addPathoIyEayM = $this$_get_TypeSpecimen__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv3, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv3, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _typeSpecimen = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _typeSpecimen;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
