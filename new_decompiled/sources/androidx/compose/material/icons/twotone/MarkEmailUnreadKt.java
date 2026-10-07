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

/* compiled from: MarkEmailUnread.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_markEmailUnread", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MarkEmailUnread", "Landroidx/compose/material/icons/Icons$TwoTone;", "getMarkEmailUnread", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class MarkEmailUnreadKt {
    private static ImageVector _markEmailUnread;

    public static final ImageVector getMarkEmailUnread(Icons.TwoTone $this$MarkEmailUnread) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$MarkEmailUnread, "<this>");
        if (_markEmailUnread != null) {
            ImageVector imageVector = _markEmailUnread;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_MarkEmailUnread__u24lambda_u2d2 = new ImageVector.Builder("TwoTone.MarkEmailUnread", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(4.0f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(10.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.22f, 1.07f, 0.79f, 2.0f, 1.57f, 2.71f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(12.0f, 11.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(4.0f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(4.0f, 8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(9.9f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.32f, 0.07f, -0.66f, 0.1f, -1.0f, 0.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.6f, 0.0f, -1.16f, -0.12f, -1.7f, -0.32f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(12.0f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(4.0f, 8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_MarkEmailUnread__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(20.0f, 9.9f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.74f, -0.15f, 1.42f, -0.48f, 2.0f, -0.92f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(18.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 1.1f, -0.9f, 2.0f, -2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, -1.1f, 0.9f, -2.0f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(10.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(14.04f, 4.32f, 14.0f, 4.66f, 14.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(0.04f, 0.68f, 0.1f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(8.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(3.67f, -2.29f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.47f, 0.43f, 1.02f, 0.76f, 1.63f, 0.98f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(12.0f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(4.0f, 8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(9.9f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(16.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 1.66f, 1.34f, 3.0f, 3.0f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(3.0f, -1.34f, 3.0f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(-1.34f, -3.0f, -3.0f, -3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveTo(16.0f, 3.34f, 16.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        m2572addPathoIyEayM = $this$_get_MarkEmailUnread__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _markEmailUnread = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _markEmailUnread;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
