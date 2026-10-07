package androidx.compose.material;

import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.ColorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* compiled from: Switch.kt */
@Metadata(m286d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jy\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, m287d2 = {"Landroidx/compose/material/SwitchDefaults;", "", "()V", "colors", "Landroidx/compose/material/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedTrackAlpha", "", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedTrackAlpha", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "colors-SQMK_m0", "(JJFJJFJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material/SwitchColors;", "material_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SwitchDefaults {
    public static final int $stable = 0;
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();

    private SwitchDefaults() {
    }

    /* renamed from: colors-SQMK_m0, reason: not valid java name */
    public final SwitchColors m1526colorsSQMK_m0(long checkedThumbColor, long checkedTrackColor, float checkedTrackAlpha, long uncheckedThumbColor, long uncheckedTrackColor, float uncheckedTrackAlpha, long disabledCheckedThumbColor, long disabledCheckedTrackColor, long disabledUncheckedThumbColor, long disabledUncheckedTrackColor, Composer $composer, int $changed, int $changed1, int i) {
        long checkedThumbColor2;
        long disabledCheckedThumbColor2;
        long disabledCheckedThumbColor3;
        long disabledCheckedTrackColor2;
        long uncheckedThumbColor2;
        long disabledUncheckedThumbColor2;
        long disabledUncheckedTrackColor2;
        long m1994copywmQWz5c;
        long m1994copywmQWz5c2;
        long m1994copywmQWz5c3;
        long m1994copywmQWz5c4;
        long m1994copywmQWz5c5;
        long m1994copywmQWz5c6;
        long m1994copywmQWz5c7;
        long m1994copywmQWz5c8;
        $composer.startReplaceableGroup(-1032127534);
        ComposerKt.sourceInformation($composer, "C(colors)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color!1,7:c#ui.graphics.Color,9:c#ui.graphics.Color,8,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color)279@11288L6,282@11460L6,283@11527L6,286@11689L8,287@11740L6,289@11857L8,290@11908L6,292@12029L8,293@12080L6,295@12201L8,296@12252L6:Switch.kt#jmzs0o");
        long checkedThumbColor3 = (i & 1) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1320getSecondaryVariant0d7_KjU() : checkedThumbColor;
        long checkedTrackColor2 = (i & 2) != 0 ? checkedThumbColor3 : checkedTrackColor;
        float checkedTrackAlpha2 = (i & 4) != 0 ? 0.54f : checkedTrackAlpha;
        long uncheckedThumbColor3 = (i & 8) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1321getSurface0d7_KjU() : uncheckedThumbColor;
        long uncheckedTrackColor2 = (i & 16) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU() : uncheckedTrackColor;
        float uncheckedTrackAlpha2 = (i & 32) != 0 ? 0.38f : uncheckedTrackAlpha;
        if ((i & 64) != 0) {
            m1994copywmQWz5c8 = Color.m1994copywmQWz5c(r29, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r29) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r29) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r29) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(checkedThumbColor3) : 0.0f);
            checkedThumbColor2 = checkedThumbColor3;
            disabledCheckedThumbColor2 = ColorKt.m2042compositeOverOWjLjI(m1994copywmQWz5c8, MaterialTheme.INSTANCE.getColors($composer, 6).m1321getSurface0d7_KjU());
        } else {
            checkedThumbColor2 = checkedThumbColor3;
            disabledCheckedThumbColor2 = disabledCheckedThumbColor;
        }
        if ((i & 128) != 0) {
            m1994copywmQWz5c7 = Color.m1994copywmQWz5c(r29, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r29) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r29) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r29) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(checkedTrackColor2) : 0.0f);
            disabledCheckedThumbColor3 = disabledCheckedThumbColor2;
            long disabledCheckedThumbColor4 = MaterialTheme.INSTANCE.getColors($composer, 6).m1321getSurface0d7_KjU();
            disabledCheckedTrackColor2 = ColorKt.m2042compositeOverOWjLjI(m1994copywmQWz5c7, disabledCheckedThumbColor4);
        } else {
            disabledCheckedThumbColor3 = disabledCheckedThumbColor2;
            disabledCheckedTrackColor2 = disabledCheckedTrackColor;
        }
        if ((i & 256) != 0) {
            m1994copywmQWz5c6 = Color.m1994copywmQWz5c(r29, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r29) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r29) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r29) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(uncheckedThumbColor3) : 0.0f);
            uncheckedThumbColor2 = uncheckedThumbColor3;
            long uncheckedThumbColor4 = MaterialTheme.INSTANCE.getColors($composer, 6).m1321getSurface0d7_KjU();
            disabledUncheckedThumbColor2 = ColorKt.m2042compositeOverOWjLjI(m1994copywmQWz5c6, uncheckedThumbColor4);
        } else {
            uncheckedThumbColor2 = uncheckedThumbColor3;
            disabledUncheckedThumbColor2 = disabledUncheckedThumbColor;
        }
        if ((i & 512) != 0) {
            m1994copywmQWz5c5 = Color.m1994copywmQWz5c(r29, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r29) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r29) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r29) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(uncheckedTrackColor2) : 0.0f);
            disabledUncheckedTrackColor2 = ColorKt.m2042compositeOverOWjLjI(m1994copywmQWz5c5, MaterialTheme.INSTANCE.getColors($composer, 6).m1321getSurface0d7_KjU());
        } else {
            disabledUncheckedTrackColor2 = disabledUncheckedTrackColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1032127534, $changed, $changed1, "androidx.compose.material.SwitchDefaults.colors (Switch.kt:278)");
        }
        m1994copywmQWz5c = Color.m1994copywmQWz5c(r30, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r30) : checkedTrackAlpha2, (r12 & 2) != 0 ? Color.m2002getRedimpl(r30) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r30) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(checkedTrackColor2) : 0.0f);
        m1994copywmQWz5c2 = Color.m1994copywmQWz5c(r34, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r34) : uncheckedTrackAlpha2, (r12 & 2) != 0 ? Color.m2002getRedimpl(r34) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r34) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(uncheckedTrackColor2) : 0.0f);
        m1994copywmQWz5c3 = Color.m1994copywmQWz5c(r38, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r38) : checkedTrackAlpha2, (r12 & 2) != 0 ? Color.m2002getRedimpl(r38) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r38) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(disabledCheckedTrackColor2) : 0.0f);
        m1994copywmQWz5c4 = Color.m1994copywmQWz5c(r14, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r14) : uncheckedTrackAlpha2, (r12 & 2) != 0 ? Color.m2002getRedimpl(r14) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r14) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(disabledUncheckedTrackColor2) : 0.0f);
        DefaultSwitchColors defaultSwitchColors = new DefaultSwitchColors(checkedThumbColor2, m1994copywmQWz5c, uncheckedThumbColor2, m1994copywmQWz5c2, disabledCheckedThumbColor3, m1994copywmQWz5c3, disabledUncheckedThumbColor2, m1994copywmQWz5c4, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultSwitchColors;
    }
}
