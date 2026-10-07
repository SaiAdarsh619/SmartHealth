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

/* compiled from: EditLocation.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_editLocation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EditLocation", "Landroidx/compose/material/icons/Icons$TwoTone;", "getEditLocation", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class EditLocationKt {
    private static ImageVector _editLocation;

    public static final ImageVector getEditLocation(Icons.TwoTone $this$EditLocation) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$EditLocation, "<this>");
        if (_editLocation != null) {
            ImageVector imageVector = _editLocation;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_EditLocation__u24lambda_u2d3 = new ImageVector.Builder("TwoTone.EditLocation", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(14.11f, 14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-0.83f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(8.74f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(7.91f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.59f, -0.59f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(11.91f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(8.61f, 4.05f, 6.0f, 6.6f, 6.0f, 10.2f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 2.34f, 1.95f, 5.44f, 6.0f, 9.14f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(4.05f, -3.7f, 6.0f, -6.79f, 6.0f, -9.14f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.03f, 0.0f, -0.06f, 0.0f, -0.08f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-3.3f, 3.3f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(14.11f, 14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_EditLocation__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(18.17f, 4.91f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(17.1f, 3.84f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-5.55f, 5.55f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(1.08f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(1.08f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(18.17f, 4.91f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(16.0f, 2.74f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.29f, -1.29f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.58f, -0.59f, 1.52f, -0.59f, 2.11f, -0.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 0.0f, 0.01f, 0.01f, 0.01f, 0.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.15f, 1.15f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.59f, 0.59f, 0.59f, 1.54f, 0.0f, 2.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(19.88f, 5.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-0.02f, 0.02f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(19.28f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-6.0f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(8.74f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(16.0f, 2.74f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(13.72f, 2.19f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-0.55f, 0.55f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(11.9f, 4.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(8.6f, 4.06f, 6.0f, 6.61f, 6.0f, 10.21f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 2.34f, 1.95f, 5.44f, 6.0f, 9.14f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(4.05f, -3.7f, 6.0f, -6.79f, 6.0f, -9.14f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(-0.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.8f, -1.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.13f, 0.6f, 0.2f, 1.24f, 0.2f, 1.9f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 3.32f, -2.67f, 7.25f, -8.0f, 11.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-5.33f, -4.55f, -8.0f, -8.48f, -8.0f, -11.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, -4.98f, 3.8f, -8.2f, 8.0f, -8.2f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(12.58f, 2.01f, 13.16f, 2.07f, 13.72f, 2.19f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$_get_EditLocation__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv3 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv3 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv3 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv3 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(18.17f, 4.91f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineToRelative(-1.07f, -1.07f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineToRelative(-5.55f, 5.55f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineToRelative(0.0f, 1.08f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineToRelative(1.08f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        m2572addPathoIyEayM = $this$_get_EditLocation__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv3, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv3, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _editLocation = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _editLocation;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
