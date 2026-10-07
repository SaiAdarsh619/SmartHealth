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

/* compiled from: Sanitizer.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_sanitizer", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Sanitizer", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSanitizer", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SanitizerKt {
    private static ImageVector _sanitizer;

    public static final ImageVector getSanitizer(Icons.TwoTone $this$Sanitizer) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Sanitizer, "<this>");
        if (_sanitizer != null) {
            ImageVector imageVector = _sanitizer;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Sanitizer__u24lambda_u2d2 = new ImageVector.Builder("TwoTone.Sanitizer", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(10.0f, 8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-2.21f, 0.0f, -4.0f, 1.79f, -4.0f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(14.0f, 9.79f, 12.21f, 8.0f, 10.0f, 8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(13.0f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_Sanitizer__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(15.5f, 6.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(15.5f, 5.66f, 17.0f, 4.0f, 17.0f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(1.5f, 1.66f, 1.5f, 2.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(18.5f, 7.33f, 17.83f, 8.0f, 17.0f, 8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveTo(15.5f, 7.33f, 15.5f, 6.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(19.5f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(1.38f, 0.0f, 2.5f, -1.12f, 2.5f, -2.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, -1.67f, -2.5f, -4.5f, -2.5f, -4.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveTo(17.0f, 10.83f, 17.0f, 12.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(17.0f, 13.88f, 18.12f, 15.0f, 19.5f, 15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(13.0f, 14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(16.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 1.1f, -0.9f, 2.0f, -2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(-8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, -2.97f, 2.16f, -5.43f, 5.0f, -5.91f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(1.13f, 0.0f, 2.15f, 0.39f, 2.99f, 1.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-1.43f, 1.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(14.1f, 4.17f, 13.57f, 4.0f, 13.0f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(2.09f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(13.84f, 6.57f, 16.0f, 9.03f, 16.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(14.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, -2.21f, -1.79f, -4.0f, -4.0f, -4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(-4.0f, 1.79f, -4.0f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        m2572addPathoIyEayM = $this$_get_Sanitizer__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _sanitizer = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _sanitizer;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
