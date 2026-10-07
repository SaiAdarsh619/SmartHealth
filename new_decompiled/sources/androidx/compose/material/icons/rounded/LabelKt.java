package androidx.compose.material.icons.rounded;

import androidx.compose.material.TextFieldImplKt;
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

/* compiled from: Label.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_label", "Landroidx/compose/ui/graphics/vector/ImageVector;", TextFieldImplKt.LabelId, "Landroidx/compose/material/icons/Icons$Rounded;", "getLabel", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LabelKt {
    private static ImageVector _label;

    public static final ImageVector getLabel(Icons.Rounded $this$Label) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Label, "<this>");
        if (_label != null) {
            ImageVector imageVector = _label;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Label__u24lambda_u2d1 = new ImageVector.Builder("Rounded.Label", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(17.63f, 5.84f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(17.27f, 5.33f, 16.67f, 5.0f, 16.0f, 5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(5.0f, 5.01f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(3.9f, 5.01f, 3.0f, 5.9f, 3.0f, 7.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(10.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 1.1f, 0.9f, 1.99f, 2.0f, 1.99f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(16.0f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.67f, 0.0f, 1.27f, -0.33f, 1.63f, -0.84f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(3.96f, -5.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.25f, -0.35f, 0.25f, -0.81f, 0.0f, -1.16f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-3.96f, -5.58f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_Label__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _label = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _label;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
