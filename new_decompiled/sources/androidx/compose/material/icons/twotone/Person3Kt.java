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

/* compiled from: Person3.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_person3", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Person3", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPerson3", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class Person3Kt {
    private static ImageVector _person3;

    public static final ImageVector getPerson3(Icons.TwoTone $this$Person3) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Person3, "<this>");
        if (_person3 != null) {
            ImageVector imageVector = _person3;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Person3__u24lambda_u2d4 = new ImageVector.Builder("TwoTone.Person3", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(10.0f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.8f, 0.0f, 1.34f, -0.94f, 0.76f, -1.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.87f, -1.04f, -0.26f, -2.0f, -0.26f, -2.37f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.41f, -0.24f, -0.77f, -0.62f, -0.92f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.29f, -0.12f, -0.55f, -0.31f, -0.75f, -0.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(12.96f, 4.33f, 12.58f, 4.0f, 12.0f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-0.96f, 0.33f, -1.13f, 0.53f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.2f, 0.24f, -0.46f, 0.42f, -0.75f, 0.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(9.74f, 5.23f, 9.5f, 5.59f, 9.5f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 0.37f, 0.61f, 1.33f, -0.26f, 2.37f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(8.66f, 9.06f, 9.2f, 10.0f, 10.0f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_Person3__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(17.48f, 16.34f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(16.29f, 15.73f, 14.37f, 15.0f, 12.0f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-2.37f, 0.0f, -4.29f, 0.73f, -5.48f, 1.34f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(6.2f, 16.5f, 6.0f, 16.84f, 6.0f, 17.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(-0.78f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(18.0f, 16.84f, 17.8f, 16.5f, 17.48f, 16.34f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$_get_Person3__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv3 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv3 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv3 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv3 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(18.39f, 14.56f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(16.71f, 13.7f, 14.53f, 13.0f, 12.0f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(-2.53f, 0.0f, -4.71f, 0.7f, -6.39f, 1.56f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(4.61f, 15.07f, 4.0f, 16.1f, 4.0f, 17.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineTo(20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineToRelative(16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(-2.78f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(20.0f, 16.1f, 19.39f, 15.07f, 18.39f, 14.56f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(18.0f, 18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineTo(6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(-0.78f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.0f, -0.38f, 0.2f, -0.72f, 0.52f, -0.88f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(7.71f, 15.73f, 9.63f, 15.0f, 12.0f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(2.37f, 0.0f, 4.29f, 0.73f, 5.48f, 1.34f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(17.8f, 16.5f, 18.0f, 16.84f, 18.0f, 17.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineTo(18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        $this$_get_Person3__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv3, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv3, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv4 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv4 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv4 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv4 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv4 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.moveTo(10.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveToRelative(0.17f, 0.0f, 3.83f, 0.0f, 4.0f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveToRelative(1.66f, 0.0f, 3.0f, -1.34f, 3.0f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveToRelative(0.0f, -0.73f, -0.27f, -1.4f, -0.71f, -1.92f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveTo(16.42f, 6.75f, 16.5f, 6.38f, 16.5f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveToRelative(0.0f, -1.25f, -0.77f, -2.32f, -1.86f, -2.77f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveTo(14.0f, 2.48f, 13.06f, 2.0f, 12.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.reflectiveCurveToRelative(-2.0f, 0.48f, -2.64f, 1.23f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveTo(8.27f, 3.68f, 7.5f, 4.75f, 7.5f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveToRelative(0.0f, 0.38f, 0.08f, 0.75f, 0.21f, 1.08f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveTo(7.27f, 7.6f, 7.0f, 8.27f, 7.0f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveTo(7.0f, 10.66f, 8.34f, 12.0f, 10.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.moveTo(9.24f, 8.37f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveTo(10.11f, 7.33f, 9.5f, 6.37f, 9.5f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveToRelative(0.0f, -0.41f, 0.24f, -0.77f, 0.62f, -0.92f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveToRelative(0.29f, -0.12f, 0.55f, -0.31f, 0.75f, -0.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveTo(11.04f, 4.33f, 11.42f, 4.0f, 12.0f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.reflectiveCurveToRelative(0.96f, 0.33f, 1.13f, 0.53f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveToRelative(0.2f, 0.24f, 0.46f, 0.42f, 0.75f, 0.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveTo(14.26f, 5.23f, 14.5f, 5.59f, 14.5f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveToRelative(0.0f, 0.37f, -0.61f, 1.33f, 0.26f, 2.37f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveTo(15.34f, 9.06f, 14.8f, 10.0f, 14.0f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.horizontalLineToRelative(-4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.curveTo(9.2f, 10.0f, 8.66f, 9.06f, 9.24f, 8.37f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv4.close();
        m2572addPathoIyEayM = $this$_get_Person3__u24lambda_u2d4.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv4.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv4, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv4, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv4, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv4, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _person3 = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _person3;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
