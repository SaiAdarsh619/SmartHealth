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

/* compiled from: EditLocationAlt.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_editLocationAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EditLocationAlt", "Landroidx/compose/material/icons/Icons$Rounded;", "getEditLocationAlt", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class EditLocationAltKt {
    private static ImageVector _editLocationAlt;

    public static final ImageVector getEditLocationAlt(Icons.Rounded $this$EditLocationAlt) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$EditLocationAlt, "<this>");
        if (_editLocationAlt != null) {
            ImageVector imageVector = _editLocationAlt;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_EditLocationAlt__u24lambda_u2d3 = new ImageVector.Builder("Rounded.EditLocationAlt", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(13.54f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.55f, 0.0f, -1.0f, -0.45f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(8.46f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(9.0f, 8.2f, 9.11f, 7.94f, 9.29f, 7.76f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(5.32f, -5.32f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(13.78f, 2.16f, 12.9f, 2.0f, 12.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-4.2f, 0.0f, -8.0f, 3.22f, -8.0f, 8.2f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 3.18f, 2.44f, 6.92f, 7.33f, 11.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.38f, 0.33f, 0.96f, 0.33f, 1.34f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(17.56f, 17.12f, 20.0f, 13.37f, 20.0f, 10.2f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -1.01f, -0.16f, -1.94f, -0.45f, -2.8f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-5.31f, 5.31f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(14.06f, 12.89f, 13.8f, 13.0f, 13.54f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_EditLocationAlt__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(11.0f, 11.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.12f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(6.16f, -6.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-2.12f, -2.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-6.16f, 6.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$_get_EditLocationAlt__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv3 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv3 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv3 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv3 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(20.71f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineTo(20.0f, 1.29f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineToRelative(-0.72f, 0.72f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineToRelative(2.12f, 2.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineToRelative(0.72f, -0.72f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveTo(21.1f, 3.02f, 21.1f, 2.39f, 20.71f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        m2572addPathoIyEayM = $this$_get_EditLocationAlt__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv3, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv3, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _editLocationAlt = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _editLocationAlt;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
