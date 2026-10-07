package androidx.compose.ui.graphics;

import android.graphics.PorterDuff;
import android.os.Build;
import kotlin.Metadata;
/* compiled from: AndroidBlendMode.android.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\t\u001a\u00020\n*\u00020\u0002H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidBlendMode_androidKt {
    /* renamed from: isSupported-s9anfk8  reason: not valid java name */
    public static final boolean m1535isSupporteds9anfk8(int $this$isSupported_u2ds9anfk8) {
        return Build.VERSION.SDK_INT >= 29 || BlendMode.m1593equalsimpl0($this$isSupported_u2ds9anfk8, BlendMode.Companion.m1624getSrcOver0nO6VwU()) || m1537toPorterDuffModes9anfk8($this$isSupported_u2ds9anfk8) != PorterDuff.Mode.SRC_OVER;
    }

    /* renamed from: toPorterDuffMode-s9anfk8  reason: not valid java name */
    public static final PorterDuff.Mode m1537toPorterDuffModes9anfk8(int $this$toPorterDuffMode_u2ds9anfk8) {
        if (BlendMode.m1593equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m1597getClear0nO6VwU())) {
            return PorterDuff.Mode.CLEAR;
        }
        if (BlendMode.m1593equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m1620getSrc0nO6VwU())) {
            return PorterDuff.Mode.SRC;
        }
        if (BlendMode.m1593equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m1603getDst0nO6VwU())) {
            return PorterDuff.Mode.DST;
        }
        if (BlendMode.m1593equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m1624getSrcOver0nO6VwU())) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (BlendMode.m1593equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m1607getDstOver0nO6VwU())) {
            return PorterDuff.Mode.DST_OVER;
        }
        if (BlendMode.m1593equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m1622getSrcIn0nO6VwU())) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (BlendMode.m1593equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m1605getDstIn0nO6VwU())) {
            return PorterDuff.Mode.DST_IN;
        }
        if (BlendMode.m1593equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m1623getSrcOut0nO6VwU())) {
            return PorterDuff.Mode.SRC_OUT;
        }
        if (BlendMode.m1593equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m1606getDstOut0nO6VwU())) {
            return PorterDuff.Mode.DST_OUT;
        }
        if (BlendMode.m1593equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m1621getSrcAtop0nO6VwU())) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (BlendMode.m1593equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m1604getDstAtop0nO6VwU())) {
            return PorterDuff.Mode.DST_ATOP;
        }
        if (BlendMode.m1593equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m1625getXor0nO6VwU())) {
            return PorterDuff.Mode.XOR;
        }
        if (BlendMode.m1593equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m1616getPlus0nO6VwU())) {
            return PorterDuff.Mode.ADD;
        }
        if (BlendMode.m1593equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m1618getScreen0nO6VwU())) {
            return PorterDuff.Mode.SCREEN;
        }
        if (BlendMode.m1593equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m1615getOverlay0nO6VwU())) {
            return PorterDuff.Mode.OVERLAY;
        }
        if (BlendMode.m1593equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m1601getDarken0nO6VwU())) {
            return PorterDuff.Mode.DARKEN;
        }
        if (BlendMode.m1593equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m1611getLighten0nO6VwU())) {
            return PorterDuff.Mode.LIGHTEN;
        }
        if (BlendMode.m1593equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.m1613getModulate0nO6VwU())) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* renamed from: toAndroidBlendMode-s9anfk8  reason: not valid java name */
    public static final android.graphics.BlendMode m1536toAndroidBlendModes9anfk8(int $this$toAndroidBlendMode_u2ds9anfk8) {
        return BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1597getClear0nO6VwU()) ? android.graphics.BlendMode.CLEAR : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1620getSrc0nO6VwU()) ? android.graphics.BlendMode.SRC : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1603getDst0nO6VwU()) ? android.graphics.BlendMode.DST : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1624getSrcOver0nO6VwU()) ? android.graphics.BlendMode.SRC_OVER : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1607getDstOver0nO6VwU()) ? android.graphics.BlendMode.DST_OVER : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1622getSrcIn0nO6VwU()) ? android.graphics.BlendMode.SRC_IN : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1605getDstIn0nO6VwU()) ? android.graphics.BlendMode.DST_IN : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1623getSrcOut0nO6VwU()) ? android.graphics.BlendMode.SRC_OUT : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1606getDstOut0nO6VwU()) ? android.graphics.BlendMode.DST_OUT : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1621getSrcAtop0nO6VwU()) ? android.graphics.BlendMode.SRC_ATOP : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1604getDstAtop0nO6VwU()) ? android.graphics.BlendMode.DST_ATOP : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1625getXor0nO6VwU()) ? android.graphics.BlendMode.XOR : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1616getPlus0nO6VwU()) ? android.graphics.BlendMode.PLUS : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1613getModulate0nO6VwU()) ? android.graphics.BlendMode.MODULATE : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1618getScreen0nO6VwU()) ? android.graphics.BlendMode.SCREEN : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1615getOverlay0nO6VwU()) ? android.graphics.BlendMode.OVERLAY : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1601getDarken0nO6VwU()) ? android.graphics.BlendMode.DARKEN : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1611getLighten0nO6VwU()) ? android.graphics.BlendMode.LIGHTEN : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1600getColorDodge0nO6VwU()) ? android.graphics.BlendMode.COLOR_DODGE : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1599getColorBurn0nO6VwU()) ? android.graphics.BlendMode.COLOR_BURN : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1609getHardlight0nO6VwU()) ? android.graphics.BlendMode.HARD_LIGHT : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1619getSoftlight0nO6VwU()) ? android.graphics.BlendMode.SOFT_LIGHT : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1602getDifference0nO6VwU()) ? android.graphics.BlendMode.DIFFERENCE : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1608getExclusion0nO6VwU()) ? android.graphics.BlendMode.EXCLUSION : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1614getMultiply0nO6VwU()) ? android.graphics.BlendMode.MULTIPLY : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1610getHue0nO6VwU()) ? android.graphics.BlendMode.HUE : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1617getSaturation0nO6VwU()) ? android.graphics.BlendMode.SATURATION : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1598getColor0nO6VwU()) ? android.graphics.BlendMode.COLOR : BlendMode.m1593equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.m1612getLuminosity0nO6VwU()) ? android.graphics.BlendMode.LUMINOSITY : android.graphics.BlendMode.SRC_OVER;
    }
}
