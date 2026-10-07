package androidx.compose.material;

import androidx.compose.p000ui.graphics.Color;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;

/* compiled from: RadioButton.kt */
@Metadata(m286d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, m287d2 = {"Landroidx/compose/material/RadioButtonDefaults;", "", "()V", "colors", "Landroidx/compose/material/RadioButtonColors;", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledColor", "colors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/RadioButtonColors;", "material_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class RadioButtonDefaults {
    public static final int $stable = 0;
    public static final RadioButtonDefaults INSTANCE = new RadioButtonDefaults();

    private RadioButtonDefaults() {
    }

    /* renamed from: colors-RGew2ao, reason: not valid java name */
    public final RadioButtonColors m1483colorsRGew2ao(long selectedColor, long unselectedColor, long disabledColor, Composer $composer, int $changed, int i) {
        long unselectedColor2;
        long m1994copywmQWz5c;
        $composer.startReplaceableGroup(1370708026);
        ComposerKt.sourceInformation($composer, "C(colors)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color,0:c#ui.graphics.Color)157@6487L6,158@6552L6,159@6634L6,159@6677L8,161@6729L197:RadioButton.kt#jmzs0o");
        long selectedColor2 = (i & 1) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1319getSecondary0d7_KjU() : selectedColor;
        if ((i & 2) != 0) {
            m1994copywmQWz5c = Color.m1994copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r7) : 0.6f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            unselectedColor2 = m1994copywmQWz5c;
        } else {
            unselectedColor2 = unselectedColor;
        }
        long disabledColor2 = (i & 4) != 0 ? Color.m1994copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r7) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f) : disabledColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1370708026, $changed, -1, "androidx.compose.material.RadioButtonDefaults.colors (RadioButton.kt:156)");
        }
        Object key1$iv = Color.m1986boximpl(selectedColor2);
        Object key2$iv = Color.m1986boximpl(unselectedColor2);
        Object key3$iv = Color.m1986boximpl(disabledColor2);
        int i2 = ($changed & 14) | ($changed & SdkConfig.SDK_VERSION) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(key1$iv) | $composer.changed(key2$iv) | $composer.changed(key3$iv);
        Object value$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new DefaultRadioButtonColors(selectedColor2, unselectedColor2, disabledColor2, null);
            $composer.updateRememberedValue(value$iv$iv);
        }
        $composer.endReplaceableGroup();
        DefaultRadioButtonColors defaultRadioButtonColors = (DefaultRadioButtonColors) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultRadioButtonColors;
    }
}
