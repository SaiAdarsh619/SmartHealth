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

/* compiled from: RoomPreferences.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"_roomPreferences", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RoomPreferences", "Landroidx/compose/material/icons/Icons$Rounded;", "getRoomPreferences", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended-rounded_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class RoomPreferencesKt {
    private static ImageVector _roomPreferences;

    public static final ImageVector getRoomPreferences(Icons.Rounded $this$RoomPreferences) {
        ImageVector.Builder m2572addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$RoomPreferences, "<this>");
        if (_roomPreferences != null) {
            ImageVector imageVector = _roomPreferences;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_RoomPreferences__u24lambda_u2d1 = new ImageVector.Builder("Rounded.RoomPreferences", C0504Dp.m4382constructorimpl(24.0f), C0504Dp.m4382constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (DefaultConstructorMarker) null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m2300getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m2310getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u2d0$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(21.75f, 17.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.22f, -0.03f, -0.42f, -0.06f, -0.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.84f, -0.73f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.18f, -0.16f, 0.22f, -0.42f, 0.1f, -0.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.59f, -1.02f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.12f, -0.21f, -0.37f, -0.3f, -0.59f, -0.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-1.06f, 0.36f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.32f, -0.27f, -0.68f, -0.48f, -1.08f, -0.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.22f, -1.09f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.05f, -0.23f, -0.25f, -0.4f, -0.49f, -0.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-1.18f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.24f, 0.0f, -0.44f, 0.17f, -0.49f, 0.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.22f, 1.09f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.4f, 0.15f, -0.76f, 0.36f, -1.08f, 0.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-1.06f, -0.36f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.23f, -0.08f, -0.47f, 0.02f, -0.59f, 0.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.59f, 1.02f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.12f, 0.21f, -0.08f, 0.47f, 0.1f, 0.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.84f, 0.73f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.03f, 0.21f, -0.06f, 0.41f, -0.06f, 0.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(0.03f, 0.42f, 0.06f, 0.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.84f, 0.73f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.18f, 0.16f, -0.22f, 0.42f, -0.1f, 0.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.59f, 1.02f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.12f, 0.21f, 0.37f, 0.3f, 0.59f, 0.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.06f, -0.36f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.32f, 0.27f, 0.68f, 0.48f, 1.08f, 0.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.22f, 1.09f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.05f, 0.23f, 0.25f, 0.4f, 0.49f, 0.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(1.18f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.24f, 0.0f, 0.44f, -0.17f, 0.49f, -0.4f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.22f, -1.09f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.4f, -0.15f, 0.76f, -0.36f, 1.08f, -0.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(1.06f, 0.36f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.23f, 0.08f, 0.47f, -0.02f, 0.59f, -0.22f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(0.59f, -1.02f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.12f, -0.21f, 0.08f, -0.47f, -0.1f, -0.63f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.lineToRelative(-0.84f, -0.73f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(21.72f, 17.42f, 21.75f, 17.22f, 21.75f, 17.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(18.0f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(19.1f, 19.0f, 18.0f, 19.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(14.0f, 11.26f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(3.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineTo(5.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(-4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(6.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(5.45f, 3.0f, 5.0f, 3.45f, 5.0f, 4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.verticalLineToRelative(15.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(0.45f, 1.0f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.horizontalLineToRelative(8.26f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(11.47f, 19.87f, 11.0f, 18.49f, 11.0f, 17.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveTo(11.0f, 14.62f, 12.19f, 12.53f, 14.0f, 11.26f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        $this$PathData_u24lambda_u2d0$iv$iv$iv.moveTo(10.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, -0.55f, 0.45f, -1.0f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveToRelative(1.0f, 0.45f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.curveToRelative(0.0f, 0.55f, -0.45f, 1.0f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.reflectiveCurveTo(10.0f, 12.55f, 10.0f, 12.0f);
        $this$PathData_u24lambda_u2d0$iv$iv$iv.close();
        m2572addPathoIyEayM = $this$_get_RoomPreferences__u24lambda_u2d1.m2572addPathoIyEayM($this$PathData_u24lambda_u2d0$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _roomPreferences = m2572addPathoIyEayM.build();
        ImageVector imageVector2 = _roomPreferences;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
