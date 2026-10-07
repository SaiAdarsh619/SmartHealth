package androidx.compose.p000ui.graphics.colorspace;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Lab.kt */
@Metadata(m286d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t¨\u0006\u0013"}, m287d2 = {"Landroidx/compose/ui/graphics/colorspace/Lab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", HintConstants.AUTOFILL_HINT_NAME, "", "id", "", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "fromXyz", "", "v", "getMaxValue", "", "component", "getMinValue", "toXyz", "Companion", "ui-graphics_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class Lab extends ColorSpace {

    /* renamed from: A */
    private static final float f59A = 0.008856452f;

    /* renamed from: B */
    private static final float f60B = 7.787037f;

    /* renamed from: C */
    private static final float f61C = 0.13793103f;

    /* renamed from: D */
    private static final float f62D = 0.20689656f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Lab(String name, int id) {
        super(name, ColorModel.INSTANCE.m2360getLabxdoWZVw(), id, null);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    @Override // androidx.compose.p000ui.graphics.colorspace.ColorSpace
    /* renamed from: isWideGamut */
    public boolean getIsWideGamut() {
        return true;
    }

    @Override // androidx.compose.p000ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return component == 0 ? 0.0f : -128.0f;
    }

    @Override // androidx.compose.p000ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return component == 0 ? 100.0f : 128.0f;
    }

    @Override // androidx.compose.p000ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] v) {
        Intrinsics.checkNotNullParameter(v, "v");
        v[0] = RangesKt.coerceIn(v[0], 0.0f, 100.0f);
        v[1] = RangesKt.coerceIn(v[1], -128.0f, 128.0f);
        v[2] = RangesKt.coerceIn(v[2], -128.0f, 128.0f);
        float fy = (v[0] + 16.0f) / 116.0f;
        float fx = (v[1] * 0.002f) + fy;
        float fz = fy - (v[2] * 0.005f);
        float x = fx > f62D ? fx * fx * fx : (fx - f61C) * 0.12841855f;
        float y = fy > f62D ? fy * fy * fy : (fy - f61C) * 0.12841855f;
        float z = fz > f62D ? fz * fz * fz : (fz - f61C) * 0.12841855f;
        v[0] = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[0] * x;
        v[1] = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[1] * y;
        v[2] = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2] * z;
        return v;
    }

    @Override // androidx.compose.p000ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] v) {
        Intrinsics.checkNotNullParameter(v, "v");
        float x = v[0] / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[0];
        float y = v[1] / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[1];
        float z = v[2] / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2];
        float fx = x > f59A ? (float) Math.pow(x, 0.33333334f) : (x * f60B) + f61C;
        float fy = y > f59A ? (float) Math.pow(y, 0.33333334f) : (y * f60B) + f61C;
        float fz = z > f59A ? (float) Math.pow(z, 0.33333334f) : (f60B * z) + f61C;
        float l = (116.0f * fy) - 16.0f;
        float a = (fx - fy) * 500.0f;
        float b = (fy - fz) * 200.0f;
        v[0] = RangesKt.coerceIn(l, 0.0f, 100.0f);
        v[1] = RangesKt.coerceIn(a, -128.0f, 128.0f);
        v[2] = RangesKt.coerceIn(b, -128.0f, 128.0f);
        return v;
    }
}
