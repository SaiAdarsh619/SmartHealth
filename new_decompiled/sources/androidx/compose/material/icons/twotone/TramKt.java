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

/* compiled from: Tram.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_tram", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Tram", "Landroidx/compose/material/icons/Icons$TwoTone;", "getTram", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TramKt {
    private static ImageVector _tram;

    public static final ImageVector getTram(Icons.TwoTone $this$Tram) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Tram, "<this>");
        if (_tram != null) {
            ImageVector imageVector = _tram;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Tram__u24lambda_u2d2 = new ImageVector.Builder("TwoTone.Tram", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(12.97f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-1.94f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-2.75f, 0.08f, -3.62f, 0.58f, -3.9f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(9.74f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.28f, -0.42f, -1.15f, -0.92f, -3.9f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(7.0f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 0.45f, 0.3f, 0.84f, 0.74f, 0.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(3.11f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.22f, -0.26f, -0.35f, -0.59f, -0.35f, -0.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.39f, 0.15f, -0.73f, 0.39f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(7.0f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(13.5f, 17.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 0.36f, -0.13f, 0.69f, -0.35f, 0.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(3.11f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.44f, -0.11f, 0.74f, -0.5f, 0.74f, -0.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(-1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-3.89f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.24f, 0.27f, 0.39f, 0.61f, 0.39f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$_get_Tram__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(13.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(0.75f, -1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(17.0f, 3.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(17.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(7.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(1.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(4.75f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(11.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-3.13f, 0.09f, -6.0f, 0.73f, -6.0f, 3.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(5.0f, 17.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 1.5f, 1.11f, 2.73f, 2.55f, 2.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(6.0f, 21.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(0.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(-0.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineToRelative(-1.55f, -1.55f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(-0.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(0.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(17.89f, 19.73f, 19.0f, 18.5f, 19.0f, 17.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(19.0f, 8.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, -2.77f, -2.87f, -3.41f, -6.0f, -3.5f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(11.03f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(1.94f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(2.75f, 0.08f, 3.62f, 0.58f, 3.9f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(7.13f, 8.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.28f, -0.42f, 1.15f, -0.92f, 3.9f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(10.85f, 17.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(7.74f, 17.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveTo(7.3f, 17.84f, 7.0f, 17.45f, 7.0f, 17.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(-1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(3.89f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(-0.24f, 0.27f, -0.39f, 0.61f, -0.39f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 0.36f, 0.13f, 0.69f, 0.35f, 0.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(17.0f, 17.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, 0.45f, -0.3f, 0.84f, -0.74f, 0.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(-3.11f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.22f, -0.26f, 0.35f, -0.59f, 0.35f, -0.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.curveToRelative(0.0f, -0.39f, -0.15f, -0.73f, -0.39f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(17.0f, 16.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.moveTo(17.0f, 14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.lineTo(7.0f, 14.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(-4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.horizontalLineToRelative(10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.verticalLineToRelative(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv2.close();
        m2572addPathoIyEayM = $this$_get_Tram__u24lambda_u2d2.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _tram = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _tram;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
