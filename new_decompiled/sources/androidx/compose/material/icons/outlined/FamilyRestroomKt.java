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

/* compiled from: FamilyRestroom.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_familyRestroom", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FamilyRestroom", "Landroidx/compose/material/icons/Icons$Outlined;", "getFamilyRestroom", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-outlined_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class FamilyRestroomKt {
    private static ImageVector _familyRestroom;

    public static final ImageVector getFamilyRestroom(Icons.Outlined $this$FamilyRestroom) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$FamilyRestroom, "<this>");
        if (_familyRestroom != null) {
            ImageVector imageVector = _familyRestroom;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_FamilyRestroom__u24lambda_u2d1 = new ImageVector.Builder("Outlined.FamilyRestroom", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(16.0f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -1.11f, 0.89f, -2.0f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(2.0f, 0.89f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-0.89f, 2.0f, -2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(16.0f, 5.11f, 16.0f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(20.0f, 22.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-2.54f, -7.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(19.68f, 7.55f, 18.92f, 7.0f, 18.06f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-0.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.86f, 0.0f, -1.63f, 0.55f, -1.9f, 1.37f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.86f, 2.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(16.26f, 11.55f, 17.0f, 12.68f, 17.0f, 14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(20.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(12.5f, 11.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.83f, 0.0f, 1.5f, -0.67f, 1.5f, -1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-0.67f, -1.5f, -1.5f, -1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(11.0f, 9.17f, 11.0f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(11.67f, 11.5f, 12.5f, 11.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(5.5f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.11f, 0.0f, 2.0f, -0.89f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-0.89f, -2.0f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(-2.0f, 0.89f, -2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(4.39f, 6.0f, 5.5f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(7.5f, 22.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(2.9f, 7.0f, 2.0f, 7.9f, 2.0f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(7.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(14.0f, 22.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.82f, -0.68f, -1.5f, -1.5f, -1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.82f, 0.0f, -1.5f, 0.68f, -1.5f, 1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_FamilyRestroom__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _familyRestroom = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _familyRestroom;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
