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

/* compiled from: Update.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_update", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Update", "Landroidx/compose/material/icons/Icons$Filled;", "getUpdate", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-filled_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class UpdateKt {
    private static ImageVector _update;

    public static final ImageVector getUpdate(Icons.Filled $this$Update) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Update, "<this>");
        if (_update != null) {
            ImageVector imageVector = _update;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Update__u24lambda_u2d1 = new ImageVector.Builder("Filled.Update", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(21.0f, 10.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-6.78f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(2.74f, -2.82f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-2.73f, -2.7f, -7.15f, -2.8f, -9.88f, -0.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-2.73f, 2.71f, -2.73f, 7.08f, 0.0f, 9.79f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(7.15f, 2.71f, 9.88f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(18.32f, 15.65f, 19.0f, 14.08f, 19.0f, 12.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 1.98f, -0.88f, 4.55f, -2.64f, 6.29f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-3.51f, 3.48f, -9.21f, 3.48f, -12.72f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-3.5f, -3.47f, -3.53f, -9.11f, -0.02f, -12.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(9.14f, -3.47f, 12.65f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(21.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(10.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(12.5f, 8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(4.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(3.5f, 2.08f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.72f, 1.21f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(11.0f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(12.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Update__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _update = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _update;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
