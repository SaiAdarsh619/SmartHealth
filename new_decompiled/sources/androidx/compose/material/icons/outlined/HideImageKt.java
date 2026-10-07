package androidx.compose.material.icons.outlined;

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

/* compiled from: HideImage.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_hideImage", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HideImage", "Landroidx/compose/material/icons/Icons$Outlined;", "getHideImage", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-outlined_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class HideImageKt {
    private static ImageVector _hideImage;

    public static final ImageVector getHideImage(Icons.Outlined $this$HideImage) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$HideImage, "<this>");
        if (_hideImage != null) {
            ImageVector imageVector = _hideImage;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_HideImage__u24lambda_u2d2 = new ImageVector.Builder("Outlined.HideImage", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(19.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(11.17f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(5.83f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_HideImage__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(2.81f, 2.81f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(1.39f, 4.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(3.0f, 5.83f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(13.17f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.61f, 1.61f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(1.41f, -1.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(2.81f, 2.81f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(5.0f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineTo(7.83f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(7.07f, 7.07f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(11.25f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(9.0f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-3.0f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(8.17f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineTo(5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        m2572addPathoIyEayM = $this$_get_HideImage__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _hideImage = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _hideImage;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
