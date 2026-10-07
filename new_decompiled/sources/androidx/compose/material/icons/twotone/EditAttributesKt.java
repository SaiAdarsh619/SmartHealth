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

/* compiled from: EditAttributes.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_editAttributes", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EditAttributes", "Landroidx/compose/material/icons/Icons$TwoTone;", "getEditAttributes", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class EditAttributesKt {
    private static ImageVector _editAttributes;

    public static final ImageVector getEditAttributes(Icons.TwoTone $this$EditAttributes) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$EditAttributes, "<this>");
        if (_editAttributes != null) {
            ImageVector imageVector = _editAttributes;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_EditAttributes__u24lambda_u2d2 = new ImageVector.Builder("TwoTone.EditAttributes", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(17.63f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(6.37f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(5.09f, 9.0f, 4.0f, 10.37f, 4.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.09f, 3.0f, 2.37f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(11.26f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.28f, 0.0f, 2.37f, -1.37f, 2.37f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-1.09f, -3.0f, -2.37f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(7.24f, 14.46f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-2.57f, -2.57f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.7f, -0.7f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.87f, 1.87f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(3.52f, -3.52f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.7f, 0.7f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-4.22f, 4.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_EditAttributes__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(17.63f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(6.37f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(3.96f, 7.0f, 2.0f, 9.24f, 2.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(1.96f, 5.0f, 4.37f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(11.26f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(2.41f, 0.0f, 4.37f, -2.24f, 4.37f, -5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(-1.96f, -5.0f, -4.37f, -5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(17.63f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(6.37f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(5.09f, 15.0f, 4.0f, 13.63f, 4.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(1.09f, -3.0f, 2.37f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(11.26f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(18.91f, 9.0f, 20.0f, 10.37f, 20.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(-1.09f, 3.0f, -2.37f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(7.24f, 13.06f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-1.87f, -1.87f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-0.7f, 0.7f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.57f, 2.57f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(4.22f, -4.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-0.7f, -0.7f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        m2572addPathoIyEayM = $this$_get_EditAttributes__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _editAttributes = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _editAttributes;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
