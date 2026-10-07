package androidx.compose.material.icons.rounded;

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

/* compiled from: Grade.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_grade", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Grade", "Landroidx/compose/material/icons/Icons$Rounded;", "getGrade", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class GradeKt {
    private static ImageVector _grade;

    public static final ImageVector getGrade(Icons.Rounded $this$Grade) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Grade, "<this>");
        if (_grade != null) {
            ImageVector imageVector = _grade;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Grade__u24lambda_u2d1 = new ImageVector.Builder("Rounded.Grade", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(12.0f, 17.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(5.17f, 3.12f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.38f, 0.23f, 0.85f, -0.11f, 0.75f, -0.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-1.37f, -5.88f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.56f, -3.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.33f, -0.29f, 0.16f, -0.84f, -0.29f, -0.88f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-6.01f, -0.51f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-2.35f, -5.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.17f, -0.41f, -0.75f, -0.41f, -0.92f, 0.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(9.19f, 8.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-6.01f, 0.51f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.44f, 0.04f, -0.62f, 0.59f, -0.28f, 0.88f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.56f, 3.95f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-1.37f, 5.88f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.1f, 0.43f, 0.37f, 0.77f, 0.75f, 0.54f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(12.0f, 17.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Grade__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _grade = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _grade;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
