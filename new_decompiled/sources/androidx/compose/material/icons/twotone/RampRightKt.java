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

/* compiled from: RampRight.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_rampRight", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RampRight", "Landroidx/compose/material/icons/Icons$TwoTone;", "getRampRight", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-twotone_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class RampRightKt {
    private static ImageVector _rampRight;

    public static final ImageVector getRampRight(Icons.TwoTone $this$RampRight) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$RampRight, "<this>");
        if (_rampRight != null) {
            ImageVector imageVector = _rampRight;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_RampRight__u24lambda_u2d1 = new ImageVector.Builder("TwoTone.RampRight", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(11.0f, 21.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(6.83f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.59f, 1.59f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(16.0f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-4.0f, -4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(8.0f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.41f, 1.41f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(11.0f, 6.83f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(9.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 4.27f, -4.03f, 7.13f, -6.0f, 8.27f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.46f, 1.46f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(8.37f, 17.56f, 9.9f, 16.19f, 11.0f, 14.7f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(11.0f, 21.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_RampRight__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _rampRight = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _rampRight;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
