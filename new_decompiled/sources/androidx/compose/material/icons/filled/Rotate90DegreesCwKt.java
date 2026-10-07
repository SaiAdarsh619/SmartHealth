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

/* compiled from: Rotate90DegreesCw.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_rotate90DegreesCw", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Rotate90DegreesCw", "Landroidx/compose/material/icons/Icons$Filled;", "getRotate90DegreesCw", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-filled_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class Rotate90DegreesCwKt {
    private static ImageVector _rotate90DegreesCw;

    public static final ImageVector getRotate90DegreesCw(Icons.Filled $this$Rotate90DegreesCw) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Rotate90DegreesCw, "<this>");
        if (_rotate90DegreesCw != null) {
            ImageVector imageVector = _rotate90DegreesCw;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Rotate90DegreesCw__u24lambda_u2d1 = new ImageVector.Builder("Filled.Rotate90DegreesCw", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(4.64f, 19.37f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(3.03f, 3.03f, 7.67f, 3.44f, 11.15f, 1.25f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-1.46f, -1.46f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-2.66f, 1.43f, -6.04f, 1.03f, -8.28f, -1.21f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-2.73f, -2.73f, -2.73f, -7.17f, 0.0f, -9.9f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(7.42f, 6.69f, 9.21f, 6.03f, 11.0f, 6.03f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.0f, -4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-4.0f, -4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(3.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-2.3f, 0.0f, -4.61f, 0.87f, -6.36f, 2.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(1.12f, 10.15f, 1.12f, 15.85f, 4.64f, 19.37f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(11.0f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(6.0f, 6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(6.0f, -6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-6.0f, -6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(11.0f, 13.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Rotate90DegreesCw__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _rotate90DegreesCw = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _rotate90DegreesCw;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
