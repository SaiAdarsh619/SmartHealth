package androidx.compose.material.icons.sharp;

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

/* compiled from: Female.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_female", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Female", "Landroidx/compose/material/icons/Icons$Sharp;", "getFemale", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-sharp_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class FemaleKt {
    private static ImageVector _female;

    public static final ImageVector getFemale(Icons.Sharp $this$Female) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Female, "<this>");
        if (_female != null) {
            ImageVector imageVector = _female;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Female__u24lambda_u2d1 = new ImageVector.Builder("Sharp.Female", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(17.5f, 9.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(17.5f, 6.46f, 15.04f, 4.0f, 12.0f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(6.5f, 6.46f, 6.5f, 9.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 2.7f, 1.94f, 4.93f, 4.5f, 5.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(17.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-2.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(15.56f, 14.43f, 17.5f, 12.2f, 17.5f, 9.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(8.5f, 9.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(8.5f, 7.57f, 10.07f, 6.0f, 12.0f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(3.5f, 1.57f, 3.5f, 3.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(13.93f, 13.0f, 12.0f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(8.5f, 11.43f, 8.5f, 9.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Female__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _female = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _female;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
