package androidx.compose.material;

import androidx.compose.p000ui.graphics.Color;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* compiled from: Checkbox.kt */
@Metadata(m286d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JG\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, m287d2 = {"Landroidx/compose/material/CheckboxDefaults;", "", "()V", "colors", "Landroidx/compose/material/CheckboxColors;", "checkedColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedColor", "checkmarkColor", "disabledColor", "disabledIndeterminateColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/CheckboxColors;", "material_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class CheckboxDefaults {
    public static final int $stable = 0;
    public static final CheckboxDefaults INSTANCE = new CheckboxDefaults();

    private CheckboxDefaults() {
    }

    /* renamed from: colors-zjMxDiM, reason: not valid java name */
    public final CheckboxColors m1282colorszjMxDiM(long checkedColor, long uncheckedColor, long checkmarkColor, long disabledColor, long disabledIndeterminateColor, Composer $composer, int $changed, int i) {
        long uncheckedColor2;
        long disabledColor2;
        Object value$iv$iv;
        long m1994copywmQWz5c;
        long m1994copywmQWz5c2;
        long m1994copywmQWz5c3;
        long m1994copywmQWz5c4;
        long m1994copywmQWz5c5;
        $composer.startReplaceableGroup(469524104);
        ComposerKt.sourceInformation($composer, "C(colors)P(0:c#ui.graphics.Color,4:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)221@9467L6,222@9531L6,223@9614L6,224@9675L6,224@9718L8,225@9812L8,227@9861L922:Checkbox.kt#jmzs0o");
        long checkedColor2 = (i & 1) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1319getSecondary0d7_KjU() : checkedColor;
        if ((i & 2) != 0) {
            m1994copywmQWz5c5 = Color.m1994copywmQWz5c(r6, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r6) : 0.6f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r6) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r6) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            uncheckedColor2 = m1994copywmQWz5c5;
        } else {
            uncheckedColor2 = uncheckedColor;
        }
        long checkmarkColor2 = (i & 4) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1321getSurface0d7_KjU() : checkmarkColor;
        if ((i & 8) != 0) {
            m1994copywmQWz5c4 = Color.m1994copywmQWz5c(r6, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r6) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r6) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r6) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            disabledColor2 = m1994copywmQWz5c4;
        } else {
            disabledColor2 = disabledColor;
        }
        long disabledIndeterminateColor2 = (i & 16) != 0 ? Color.m1994copywmQWz5c(r45, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r45) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r45) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r45) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(checkedColor2) : 0.0f) : disabledIndeterminateColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(469524104, $changed, -1, "androidx.compose.material.CheckboxDefaults.colors (Checkbox.kt:220)");
        }
        Object[] keys$iv = {Color.m1986boximpl(checkedColor2), Color.m1986boximpl(uncheckedColor2), Color.m1986boximpl(checkmarkColor2), Color.m1986boximpl(disabledColor2), Color.m1986boximpl(disabledIndeterminateColor2)};
        $composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= $composer.changed(key$iv);
        }
        value$iv$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
            m1994copywmQWz5c = Color.m1994copywmQWz5c(r45, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r45) : 0.0f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r45) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r45) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(checkmarkColor2) : 0.0f);
            m1994copywmQWz5c2 = Color.m1994copywmQWz5c(r45, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r45) : 0.0f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r45) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r45) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(checkedColor2) : 0.0f);
            m1994copywmQWz5c3 = Color.m1994copywmQWz5c(r45, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r45) : 0.0f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r45) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r45) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(disabledColor2) : 0.0f);
            value$iv$iv = new DefaultCheckboxColors(checkmarkColor2, m1994copywmQWz5c, checkedColor2, m1994copywmQWz5c2, disabledColor2, m1994copywmQWz5c3, disabledIndeterminateColor2, checkedColor2, uncheckedColor2, disabledColor2, disabledIndeterminateColor2, null);
            $composer.updateRememberedValue(value$iv$iv);
        }
        $composer.endReplaceableGroup();
        DefaultCheckboxColors defaultCheckboxColors = (DefaultCheckboxColors) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultCheckboxColors;
    }
}
