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

/* compiled from: PermContactCalendar.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_permContactCalendar", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PermContactCalendar", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPermContactCalendar", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class PermContactCalendarKt {
    private static ImageVector _permContactCalendar;

    public static final ImageVector getPermContactCalendar(Icons.TwoTone $this$PermContactCalendar) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$PermContactCalendar, "<this>");
        if (_permContactCalendar != null) {
            ImageVector imageVector = _permContactCalendar;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_PermContactCalendar__u24lambda_u2d2 = new ImageVector.Builder("TwoTone.PermContactCalendar", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(16.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(5.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(19.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(12.0f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.65f, 0.0f, 3.0f, 1.35f, 3.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-1.35f, 3.0f, -3.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-3.0f, -1.35f, -3.0f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.35f, -3.0f, 3.0f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(18.0f, 18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(6.0f, 18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-1.53f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -2.5f, 3.97f, -3.58f, 6.0f, -3.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(6.0f, 1.08f, 6.0f, 3.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(18.0f, 18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_PermContactCalendar__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(20.84f, 4.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.05f, -0.12f, -0.11f, -0.23f, -0.18f, -0.34f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.14f, -0.21f, -0.33f, -0.4f, -0.54f, -0.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.11f, -0.07f, -0.22f, -0.13f, -0.34f, -0.18f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.24f, -0.1f, -0.5f, -0.16f, -0.78f, -0.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(-1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(18.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(8.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(8.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(6.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(5.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.42f, 0.0f, -0.8f, 0.13f, -1.12f, 0.34f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.21f, 0.14f, -0.4f, 0.33f, -0.54f, 0.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.07f, 0.11f, -0.13f, 0.22f, -0.18f, 0.34f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.1f, 0.24f, -0.16f, 0.5f, -0.16f, 0.78f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 1.1f, 0.89f, 2.0f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.28f, 0.0f, 0.54f, -0.06f, 0.78f, -0.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.12f, -0.05f, 0.23f, -0.11f, 0.34f, -0.18f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.21f, -0.14f, 0.4f, -0.33f, 0.54f, -0.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.21f, -0.32f, 0.34f, -0.71f, 0.34f, -1.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(21.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, -0.28f, -0.06f, -0.54f, -0.16f, -0.78f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(19.0f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(5.0f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(5.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(12.0f, 12.88f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-2.03f, 0.0f, -6.0f, 1.08f, -6.0f, 3.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(6.0f, 18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(-1.53f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, -2.51f, -3.97f, -3.59f, -6.0f, -3.59f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(8.31f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.69f, -0.56f, 2.38f, -1.12f, 3.69f, -1.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(3.01f, 0.56f, 3.69f, 1.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(8.31f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(12.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(1.65f, 0.0f, 3.0f, -1.35f, 3.0f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(-1.35f, -3.0f, -3.0f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(-3.0f, 1.35f, -3.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(1.35f, 3.0f, 3.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(12.0f, 8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.55f, 0.0f, 1.0f, 0.45f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(-0.45f, 1.0f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(-1.0f, -0.45f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(0.45f, -1.0f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        m2572addPathoIyEayM = $this$_get_PermContactCalendar__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _permContactCalendar = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _permContactCalendar;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
