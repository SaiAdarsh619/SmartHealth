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

/* compiled from: SearchOff.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_searchOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SearchOff", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSearchOff", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SearchOffKt {
    private static ImageVector _searchOff;

    public static final ImageVector getSearchOff(Icons.TwoTone $this$SearchOff) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$SearchOff, "<this>");
        if (_searchOff != null) {
            ImageVector imageVector = _searchOff;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_SearchOff__u24lambda_u2d2 = new ImageVector.Builder("TwoTone.SearchOff", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(15.5f, 14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-0.79f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.28f, -0.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(15.41f, 12.59f, 16.0f, 11.11f, 16.0f, 9.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(16.0f, 5.91f, 13.09f, 3.0f, 9.5f, 3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(6.08f, 3.0f, 3.28f, 5.64f, 3.03f, 9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.02f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(5.3f, 6.75f, 7.18f, 5.0f, 9.5f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(11.99f, 5.0f, 14.0f, 7.01f, 14.0f, 9.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(11.99f, 14.0f, 9.5f, 14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.17f, 0.0f, -0.33f, -0.03f, -0.5f, -0.05f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(2.02f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(9.17f, 15.99f, 9.33f, 16.0f, 9.5f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(1.61f, 0.0f, 3.09f, -0.59f, 4.23f, -1.57f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(14.0f, 14.71f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(0.79f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(5.0f, 4.99f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(20.49f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(15.5f, 14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_SearchOff__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(6.47f, 10.82f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-2.47f, 2.47f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-2.47f, -2.47f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-0.71f, 0.71f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.47f, 2.47f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-2.47f, 2.47f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(0.71f, 0.71f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.47f, -2.47f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.47f, 2.47f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(0.71f, -0.71f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-2.47f, -2.47f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.47f, -2.47f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        m2572addPathoIyEayM = $this$_get_SearchOff__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _searchOff = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _searchOff;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
