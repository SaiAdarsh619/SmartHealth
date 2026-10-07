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

/* compiled from: People.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_people", "Landroidx/compose/ui/graphics/vector/ImageVector;", "People", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPeople", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class PeopleKt {
    private static ImageVector _people;

    public static final ImageVector getPeople(Icons.TwoTone $this$People) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$People, "<this>");
        if (_people != null) {
            ImageVector imageVector = _people;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_People__u24lambda_u2d3 = new ImageVector.Builder("TwoTone.People", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(9.0f, 8.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveToRelative(-1.5f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.arcToRelative(1.5f, 1.5f, 0.0f, true, true, 3.0f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.arcToRelative(1.5f, 1.5f, 0.0f, true, true, -3.0f, 0.0f);
        $this$_get_People__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(4.34f, 17.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(9.32f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.84f, -0.58f, -2.87f, -1.25f, -4.66f, -1.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.reflectiveCurveToRelative(-3.82f, 0.67f, -4.66f, 1.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$_get_People__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv3 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv3 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv3 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv3 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(9.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(1.93f, 0.0f, 3.5f, -1.57f, 3.5f, -3.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.reflectiveCurveTo(10.93f, 5.0f, 9.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.reflectiveCurveTo(5.5f, 6.57f, 5.5f, 8.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.reflectiveCurveTo(7.07f, 12.0f, 9.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(9.0f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.83f, 0.0f, 1.5f, 0.67f, 1.5f, 1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.reflectiveCurveTo(9.83f, 10.0f, 9.0f, 10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.reflectiveCurveToRelative(-1.5f, -0.67f, -1.5f, -1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.reflectiveCurveTo(8.17f, 7.0f, 9.0f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(9.0f, 13.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(-2.34f, 0.0f, -7.0f, 1.17f, -7.0f, 3.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineTo(2.0f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineToRelative(14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(-1.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.0f, -2.33f, -4.66f, -3.5f, -7.0f, -3.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(4.34f, 17.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.84f, -0.58f, 2.87f, -1.25f, 4.66f, -1.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.reflectiveCurveToRelative(3.82f, 0.67f, 4.66f, 1.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineTo(4.34f, 17.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(16.04f, 13.81f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(1.16f, 0.84f, 1.96f, 1.96f, 1.96f, 3.44f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.lineTo(18.0f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.horizontalLineToRelative(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.verticalLineToRelative(-1.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.0f, -2.02f, -3.5f, -3.17f, -5.96f, -3.44f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.moveTo(15.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(1.93f, 0.0f, 3.5f, -1.57f, 3.5f, -3.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.reflectiveCurveTo(16.93f, 5.0f, 15.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(-0.54f, 0.0f, -1.04f, 0.13f, -1.5f, 0.35f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.63f, 0.89f, 1.0f, 1.98f, 1.0f, 3.15f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.reflectiveCurveToRelative(-0.37f, 2.26f, -1.0f, 3.15f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.curveToRelative(0.46f, 0.22f, 0.96f, 0.35f, 1.5f, 0.35f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv3.close();
        m2572addPathoIyEayM = $this$_get_People__u24lambda_u2d3.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv3, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv3, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _people = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _people;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
