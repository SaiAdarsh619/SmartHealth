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

/* compiled from: DoneOutline.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_doneOutline", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DoneOutline", "Landroidx/compose/material/icons/Icons$Sharp;", "getDoneOutline", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-sharp_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class DoneOutlineKt {
    private static ImageVector _doneOutline;

    public static final ImageVector getDoneOutline(Icons.Sharp $this$DoneOutline) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$DoneOutline, "<this>");
        if (_doneOutline != null) {
            ImageVector imageVector = _doneOutline;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_DoneOutline__u24lambda_u2d1 = new ImageVector.Builder("Sharp.DoneOutline", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(19.77f, 4.93f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.4f, 1.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(8.43f, 19.07f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-5.6f, -5.6f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.4f, -1.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(4.2f, 4.2f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(19.77f, 4.93f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveToRelative(0.0f, -2.83f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(8.43f, 13.44f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-4.2f, -4.2f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(0.0f, 13.47f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(8.43f, 8.43f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(24.0f, 6.33f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineTo(19.77f, 2.1f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_DoneOutline__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _doneOutline = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _doneOutline;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
