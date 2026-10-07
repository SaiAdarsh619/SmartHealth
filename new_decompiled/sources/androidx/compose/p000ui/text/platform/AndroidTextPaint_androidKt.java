package androidx.compose.p000ui.text.platform;

import android.graphics.Paint;
import android.text.TextPaint;
import androidx.compose.p000ui.graphics.StrokeCap;
import androidx.compose.p000ui.graphics.StrokeJoin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: AndroidTextPaint.android.kt */
@Metadata(m286d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\n\u001a\u00020\u000b*\u00020\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, m287d2 = {"setAlpha", "", "Landroid/text/TextPaint;", "alpha", "", "toAndroidCap", "Landroid/graphics/Paint$Cap;", "Landroidx/compose/ui/graphics/StrokeCap;", "toAndroidCap-BeK7IIE", "(I)Landroid/graphics/Paint$Cap;", "toAndroidJoin", "Landroid/graphics/Paint$Join;", "Landroidx/compose/ui/graphics/StrokeJoin;", "toAndroidJoin-Ww9F2mQ", "(I)Landroid/graphics/Paint$Join;", "ui-text_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AndroidTextPaint_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toAndroidJoin-Ww9F2mQ, reason: not valid java name */
    public static final Paint.Join m4161toAndroidJoinWw9F2mQ(int $this$toAndroidJoin_u2dWw9F2mQ) {
        return StrokeJoin.m2306equalsimpl0($this$toAndroidJoin_u2dWw9F2mQ, StrokeJoin.INSTANCE.m2311getMiterLxFBmk8()) ? Paint.Join.MITER : StrokeJoin.m2306equalsimpl0($this$toAndroidJoin_u2dWw9F2mQ, StrokeJoin.INSTANCE.m2312getRoundLxFBmk8()) ? Paint.Join.ROUND : StrokeJoin.m2306equalsimpl0($this$toAndroidJoin_u2dWw9F2mQ, StrokeJoin.INSTANCE.m2310getBevelLxFBmk8()) ? Paint.Join.BEVEL : Paint.Join.MITER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toAndroidCap-BeK7IIE, reason: not valid java name */
    public static final Paint.Cap m4160toAndroidCapBeK7IIE(int $this$toAndroidCap_u2dBeK7IIE) {
        return StrokeCap.m2296equalsimpl0($this$toAndroidCap_u2dBeK7IIE, StrokeCap.INSTANCE.m2300getButtKaPHkGw()) ? Paint.Cap.BUTT : StrokeCap.m2296equalsimpl0($this$toAndroidCap_u2dBeK7IIE, StrokeCap.INSTANCE.m2301getRoundKaPHkGw()) ? Paint.Cap.ROUND : StrokeCap.m2296equalsimpl0($this$toAndroidCap_u2dBeK7IIE, StrokeCap.INSTANCE.m2302getSquareKaPHkGw()) ? Paint.Cap.SQUARE : Paint.Cap.BUTT;
    }

    public static final void setAlpha(TextPaint $this$setAlpha, float alpha) {
        Intrinsics.checkNotNullParameter($this$setAlpha, "<this>");
        if (!Float.isNaN(alpha)) {
            int alphaInt = MathKt.roundToInt(RangesKt.coerceIn(alpha, 0.0f, 1.0f) * 255);
            $this$setAlpha.setAlpha(alphaInt);
        }
    }
}
