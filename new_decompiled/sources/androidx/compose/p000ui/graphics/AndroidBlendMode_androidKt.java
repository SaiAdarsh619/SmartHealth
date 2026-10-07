package androidx.compose.p000ui.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import android.os.Build;
import kotlin.Metadata;

/* compiled from: AndroidBlendMode.android.kt */
@Metadata(m286d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\t\u001a\u00020\n*\u00020\u0002H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, m287d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "ui-graphics_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AndroidBlendMode_androidKt {
    /* renamed from: isSupported-s9anfk8, reason: not valid java name */
    public static final boolean m1851isSupporteds9anfk8(int $this$isSupported_u2ds9anfk8) {
        return Build.VERSION.SDK_INT >= 29 || BlendMode.m1909equalsimpl0($this$isSupported_u2ds9anfk8, BlendMode.INSTANCE.m1940getSrcOver0nO6VwU()) || m1853toPorterDuffModes9anfk8($this$isSupported_u2ds9anfk8) != PorterDuff.Mode.SRC_OVER;
    }

    /* renamed from: toPorterDuffMode-s9anfk8, reason: not valid java name */
    public static final PorterDuff.Mode m1853toPorterDuffModes9anfk8(int $this$toPorterDuffMode_u2ds9anfk8) {
        if (BlendMode.m1909equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m1913getClear0nO6VwU())) {
            return PorterDuff.Mode.CLEAR;
        }
        if (BlendMode.m1909equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m1936getSrc0nO6VwU())) {
            return PorterDuff.Mode.SRC;
        }
        if (BlendMode.m1909equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m1919getDst0nO6VwU())) {
            return PorterDuff.Mode.DST;
        }
        if (BlendMode.m1909equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m1940getSrcOver0nO6VwU())) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (BlendMode.m1909equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m1923getDstOver0nO6VwU())) {
            return PorterDuff.Mode.DST_OVER;
        }
        if (BlendMode.m1909equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m1938getSrcIn0nO6VwU())) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (BlendMode.m1909equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m1921getDstIn0nO6VwU())) {
            return PorterDuff.Mode.DST_IN;
        }
        if (BlendMode.m1909equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m1939getSrcOut0nO6VwU())) {
            return PorterDuff.Mode.SRC_OUT;
        }
        if (BlendMode.m1909equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m1922getDstOut0nO6VwU())) {
            return PorterDuff.Mode.DST_OUT;
        }
        if (BlendMode.m1909equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m1937getSrcAtop0nO6VwU())) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (BlendMode.m1909equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m1920getDstAtop0nO6VwU())) {
            return PorterDuff.Mode.DST_ATOP;
        }
        if (BlendMode.m1909equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m1941getXor0nO6VwU())) {
            return PorterDuff.Mode.XOR;
        }
        if (BlendMode.m1909equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m1932getPlus0nO6VwU())) {
            return PorterDuff.Mode.ADD;
        }
        if (BlendMode.m1909equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m1934getScreen0nO6VwU())) {
            return PorterDuff.Mode.SCREEN;
        }
        if (BlendMode.m1909equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m1931getOverlay0nO6VwU())) {
            return PorterDuff.Mode.OVERLAY;
        }
        if (BlendMode.m1909equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m1917getDarken0nO6VwU())) {
            return PorterDuff.Mode.DARKEN;
        }
        if (BlendMode.m1909equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m1927getLighten0nO6VwU())) {
            return PorterDuff.Mode.LIGHTEN;
        }
        if (BlendMode.m1909equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m1929getModulate0nO6VwU())) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* renamed from: toAndroidBlendMode-s9anfk8, reason: not valid java name */
    public static final BlendMode m1852toAndroidBlendModes9anfk8(int $this$toAndroidBlendMode_u2ds9anfk8) {
        return BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1913getClear0nO6VwU()) ? BlendMode.CLEAR : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1936getSrc0nO6VwU()) ? BlendMode.SRC : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1919getDst0nO6VwU()) ? BlendMode.DST : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1940getSrcOver0nO6VwU()) ? BlendMode.SRC_OVER : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1923getDstOver0nO6VwU()) ? BlendMode.DST_OVER : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1938getSrcIn0nO6VwU()) ? BlendMode.SRC_IN : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1921getDstIn0nO6VwU()) ? BlendMode.DST_IN : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1939getSrcOut0nO6VwU()) ? BlendMode.SRC_OUT : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1922getDstOut0nO6VwU()) ? BlendMode.DST_OUT : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1937getSrcAtop0nO6VwU()) ? BlendMode.SRC_ATOP : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1920getDstAtop0nO6VwU()) ? BlendMode.DST_ATOP : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1941getXor0nO6VwU()) ? BlendMode.XOR : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1932getPlus0nO6VwU()) ? BlendMode.PLUS : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1929getModulate0nO6VwU()) ? BlendMode.MODULATE : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1934getScreen0nO6VwU()) ? BlendMode.SCREEN : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1931getOverlay0nO6VwU()) ? BlendMode.OVERLAY : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1917getDarken0nO6VwU()) ? BlendMode.DARKEN : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1927getLighten0nO6VwU()) ? BlendMode.LIGHTEN : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1916getColorDodge0nO6VwU()) ? BlendMode.COLOR_DODGE : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1915getColorBurn0nO6VwU()) ? BlendMode.COLOR_BURN : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1925getHardlight0nO6VwU()) ? BlendMode.HARD_LIGHT : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1935getSoftlight0nO6VwU()) ? BlendMode.SOFT_LIGHT : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1918getDifference0nO6VwU()) ? BlendMode.DIFFERENCE : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1924getExclusion0nO6VwU()) ? BlendMode.EXCLUSION : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1930getMultiply0nO6VwU()) ? BlendMode.MULTIPLY : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1926getHue0nO6VwU()) ? BlendMode.HUE : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1933getSaturation0nO6VwU()) ? BlendMode.SATURATION : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1914getColor0nO6VwU()) ? BlendMode.COLOR : BlendMode.m1909equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m1928getLuminosity0nO6VwU()) ? BlendMode.LUMINOSITY : BlendMode.SRC_OVER;
    }
}
