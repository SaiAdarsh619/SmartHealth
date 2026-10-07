package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.ColorKt;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;

/* compiled from: Chip.kt */
@Metadata(m286d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 Jo\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)JQ\u0010*\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010 Jo\u0010,\u001a\u00020\"2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, m287d2 = {"Landroidx/compose/material/ChipDefaults;", "", "()V", "ContentOpacity", "", "LeadingIconOpacity", "LeadingIconSize", "Landroidx/compose/ui/unit/Dp;", "getLeadingIconSize-D9Ej5fM", "()F", "F", "MinHeight", "getMinHeight-D9Ej5fM", "OutlinedBorderOpacity", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "SelectedIconSize", "getSelectedIconSize-D9Ej5fM", "outlinedBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "chipColors", "Landroidx/compose/material/ChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconContentColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconContentColor", "chipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ChipColors;", "filterChipColors", "Landroidx/compose/material/SelectableChipColors;", "leadingIconColor", "disabledLeadingIconColor", "selectedBackgroundColor", "selectedContentColor", "selectedLeadingIconColor", "filterChipColors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/SelectableChipColors;", "outlinedChipColors", "outlinedChipColors-5tl4gsc", "outlinedFilterChipColors", "outlinedFilterChipColors-J08w3-E", "material_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
@ExperimentalMaterialApi
/* loaded from: classes.dex */
public final class ChipDefaults {
    public static final int $stable = 0;
    public static final float ContentOpacity = 0.87f;
    public static final float LeadingIconOpacity = 0.54f;
    public static final float OutlinedBorderOpacity = 0.12f;
    public static final ChipDefaults INSTANCE = new ChipDefaults();
    private static final float MinHeight = C0504Dp.m4382constructorimpl(32);
    private static final float OutlinedBorderSize = C0504Dp.m4382constructorimpl(1);
    private static final float LeadingIconSize = C0504Dp.m4382constructorimpl(20);
    private static final float SelectedIconSize = C0504Dp.m4382constructorimpl(18);

    private ChipDefaults() {
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1300getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: chipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m1297chipColors5tl4gsc(long backgroundColor, long contentColor, long leadingIconContentColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconContentColor, Composer $composer, int $changed, int i) {
        long backgroundColor2;
        long contentColor2;
        long leadingIconContentColor2;
        long disabledBackgroundColor2;
        long disabledContentColor2;
        long m1994copywmQWz5c;
        long m1994copywmQWz5c2;
        long m1994copywmQWz5c3;
        long m1994copywmQWz5c4;
        long m1994copywmQWz5c5;
        $composer.startReplaceableGroup(1838505436);
        ComposerKt.sourceInformation($composer, "C(chipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)384@16784L6,385@16878L6,386@16939L6,389@17141L6,390@17201L8,391@17276L6,393@17383L8,396@17531L8:Chip.kt#jmzs0o");
        if ((i & 1) != 0) {
            m1994copywmQWz5c5 = Color.m1994copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r4) : 0.12f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            backgroundColor2 = ColorKt.m2042compositeOverOWjLjI(m1994copywmQWz5c5, MaterialTheme.INSTANCE.getColors($composer, 6).m1321getSurface0d7_KjU());
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((i & 2) != 0) {
            m1994copywmQWz5c4 = Color.m1994copywmQWz5c(r6, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r6) : 0.87f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r6) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r6) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            contentColor2 = m1994copywmQWz5c4;
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 4) != 0) {
            m1994copywmQWz5c3 = Color.m1994copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r8) : 0.54f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(contentColor2) : 0.0f);
            leadingIconContentColor2 = m1994copywmQWz5c3;
        } else {
            leadingIconContentColor2 = leadingIconContentColor;
        }
        if ((i & 8) != 0) {
            m1994copywmQWz5c2 = Color.m1994copywmQWz5c(r6, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r6) : 0.12f * ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r6) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r6) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            disabledBackgroundColor2 = ColorKt.m2042compositeOverOWjLjI(m1994copywmQWz5c2, MaterialTheme.INSTANCE.getColors($composer, 6).m1321getSurface0d7_KjU());
        } else {
            disabledBackgroundColor2 = disabledBackgroundColor;
        }
        if ((i & 16) != 0) {
            m1994copywmQWz5c = Color.m1994copywmQWz5c(r29, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r29) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.87f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r29) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r29) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(contentColor2) : 0.0f);
            disabledContentColor2 = m1994copywmQWz5c;
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        long disabledLeadingIconContentColor2 = (i & 32) != 0 ? Color.m1994copywmQWz5c(r29, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r29) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.54f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r29) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r29) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(leadingIconContentColor2) : 0.0f) : disabledLeadingIconContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1838505436, $changed, -1, "androidx.compose.material.ChipDefaults.chipColors (Chip.kt:383)");
        }
        DefaultChipColors defaultChipColors = new DefaultChipColors(backgroundColor2, contentColor2, leadingIconContentColor2, disabledBackgroundColor2, disabledContentColor2, disabledLeadingIconContentColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultChipColors;
    }

    /* renamed from: outlinedChipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m1303outlinedChipColors5tl4gsc(long backgroundColor, long contentColor, long leadingIconContentColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long leadingIconContentColor2;
        long disabledContentColor2;
        long disabledLeadingIconContentColor2;
        long m1994copywmQWz5c;
        long m1994copywmQWz5c2;
        long m1994copywmQWz5c3;
        long m1994copywmQWz5c4;
        $composer.startReplaceableGroup(-1763922662);
        ComposerKt.sourceInformation($composer, "C(outlinedChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)420@18727L6,421@18787L6,425@19070L8,428@19218L8,429@19270L342:Chip.kt#jmzs0o");
        long backgroundColor2 = (i & 1) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1321getSurface0d7_KjU() : backgroundColor;
        if ((i & 2) != 0) {
            m1994copywmQWz5c4 = Color.m1994copywmQWz5c(r3, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r3) : 0.87f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r3) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r3) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            contentColor2 = m1994copywmQWz5c4;
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 4) != 0) {
            m1994copywmQWz5c3 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : 0.54f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(contentColor2) : 0.0f);
            leadingIconContentColor2 = m1994copywmQWz5c3;
        } else {
            leadingIconContentColor2 = leadingIconContentColor;
        }
        long disabledBackgroundColor2 = (i & 8) != 0 ? backgroundColor2 : disabledBackgroundColor;
        if ((i & 16) != 0) {
            m1994copywmQWz5c2 = Color.m1994copywmQWz5c(r31, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r31) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.87f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r31) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r31) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(contentColor2) : 0.0f);
            disabledContentColor2 = m1994copywmQWz5c2;
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if ((i & 32) != 0) {
            m1994copywmQWz5c = Color.m1994copywmQWz5c(r31, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r31) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.54f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r31) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r31) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(leadingIconContentColor2) : 0.0f);
            disabledLeadingIconContentColor2 = m1994copywmQWz5c;
        } else {
            disabledLeadingIconContentColor2 = disabledLeadingIconContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1763922662, $changed, -1, "androidx.compose.material.ChipDefaults.outlinedChipColors (Chip.kt:419)");
        }
        ChipColors m1297chipColors5tl4gsc = m1297chipColors5tl4gsc(backgroundColor2, contentColor2, leadingIconContentColor2, disabledBackgroundColor2, disabledContentColor2, disabledLeadingIconContentColor2, $composer, ($changed & 14) | ($changed & SdkConfig.SDK_VERSION) | ($changed & 896) | ($changed & 7168) | (57344 & $changed) | (458752 & $changed) | (3670016 & $changed), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m1297chipColors5tl4gsc;
    }

    /* renamed from: filterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m1298filterChipColorsJ08w3E(long backgroundColor, long contentColor, long leadingIconColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconColor, long selectedBackgroundColor, long selectedContentColor, long selectedLeadingIconColor, Composer $composer, int $changed, int i) {
        long backgroundColor2;
        long leadingIconColor2;
        long disabledBackgroundColor2;
        long disabledContentColor2;
        long disabledLeadingIconColor2;
        long selectedBackgroundColor2;
        long selectedContentColor2;
        long selectedLeadingIconColor2;
        long m1994copywmQWz5c;
        long m1994copywmQWz5c2;
        long m1994copywmQWz5c3;
        long m1994copywmQWz5c4;
        long m1994copywmQWz5c5;
        long m1994copywmQWz5c6;
        long m1994copywmQWz5c7;
        long m1994copywmQWz5c8;
        $composer.startReplaceableGroup(830140629);
        ComposerKt.sourceInformation($composer, "C(filterChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color)454@20609L6,455@20703L6,456@20764L6,459@20951L6,460@21011L8,461@21086L6,463@21193L8,466@21328L8,468@21424L6,471@21583L6,474@21744L6:Chip.kt#jmzs0o");
        if ((i & 1) != 0) {
            m1994copywmQWz5c8 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : 0.12f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            backgroundColor2 = ColorKt.m2042compositeOverOWjLjI(m1994copywmQWz5c8, MaterialTheme.INSTANCE.getColors($composer, 6).m1321getSurface0d7_KjU());
        } else {
            backgroundColor2 = backgroundColor;
        }
        long contentColor2 = (i & 2) != 0 ? Color.m1994copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r7) : 0.87f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f) : contentColor;
        if ((i & 4) != 0) {
            m1994copywmQWz5c7 = Color.m1994copywmQWz5c(r9, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r9) : 0.54f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r9) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r9) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(contentColor2) : 0.0f);
            leadingIconColor2 = m1994copywmQWz5c7;
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i & 8) != 0) {
            m1994copywmQWz5c6 = Color.m1994copywmQWz5c(r16, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r16) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.12f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r16) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r16) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            disabledBackgroundColor2 = ColorKt.m2042compositeOverOWjLjI(m1994copywmQWz5c6, MaterialTheme.INSTANCE.getColors($composer, 6).m1321getSurface0d7_KjU());
        } else {
            disabledBackgroundColor2 = disabledBackgroundColor;
        }
        if ((i & 16) != 0) {
            m1994copywmQWz5c5 = Color.m1994copywmQWz5c(r42, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r42) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.87f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r42) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r42) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(contentColor2) : 0.0f);
            disabledContentColor2 = m1994copywmQWz5c5;
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if ((i & 32) != 0) {
            m1994copywmQWz5c4 = Color.m1994copywmQWz5c(r42, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r42) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.54f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r42) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r42) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(leadingIconColor2) : 0.0f);
            disabledLeadingIconColor2 = m1994copywmQWz5c4;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i & 64) != 0) {
            m1994copywmQWz5c3 = Color.m1994copywmQWz5c(r9, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r9) : 0.12f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r9) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r9) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            selectedBackgroundColor2 = ColorKt.m2042compositeOverOWjLjI(m1994copywmQWz5c3, backgroundColor2);
        } else {
            selectedBackgroundColor2 = selectedBackgroundColor;
        }
        if ((i & 128) != 0) {
            m1994copywmQWz5c2 = Color.m1994copywmQWz5c(r9, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r9) : 0.16f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r9) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r9) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            selectedContentColor2 = ColorKt.m2042compositeOverOWjLjI(m1994copywmQWz5c2, contentColor2);
        } else {
            selectedContentColor2 = selectedContentColor;
        }
        if ((i & 256) != 0) {
            m1994copywmQWz5c = Color.m1994copywmQWz5c(r3, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r3) : 0.16f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r3) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r3) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            selectedLeadingIconColor2 = ColorKt.m2042compositeOverOWjLjI(m1994copywmQWz5c, leadingIconColor2);
        } else {
            selectedLeadingIconColor2 = selectedLeadingIconColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(830140629, $changed, -1, "androidx.compose.material.ChipDefaults.filterChipColors (Chip.kt:453)");
        }
        long j = leadingIconColor2;
        long leadingIconColor3 = disabledBackgroundColor2;
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(backgroundColor2, contentColor2, j, leadingIconColor3, disabledContentColor2, disabledLeadingIconColor2, selectedBackgroundColor2, selectedContentColor2, selectedLeadingIconColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }

    /* renamed from: outlinedFilterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m1304outlinedFilterChipColorsJ08w3E(long backgroundColor, long contentColor, long leadingIconColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconColor, long selectedBackgroundColor, long selectedContentColor, long selectedLeadingIconColor, Composer $composer, int $changed, int i) {
        long leadingIconColor2;
        long disabledContentColor2;
        long disabledLeadingIconColor2;
        long selectedBackgroundColor2;
        long selectedContentColor2;
        long selectedLeadingIconColor2;
        long m1994copywmQWz5c;
        long m1994copywmQWz5c2;
        long m1994copywmQWz5c3;
        long m1994copywmQWz5c4;
        long m1994copywmQWz5c5;
        long m1994copywmQWz5c6;
        $composer.startReplaceableGroup(346878099);
        ComposerKt.sourceInformation($composer, "C(outlinedFilterChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color)505@23394L6,506@23454L6,510@23714L8,513@23849L8,515@23945L6,518@24105L6,521@24266L6:Chip.kt#jmzs0o");
        long backgroundColor2 = (i & 1) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1321getSurface0d7_KjU() : backgroundColor;
        long contentColor2 = (i & 2) != 0 ? Color.m1994copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r7) : 0.87f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f) : contentColor;
        if ((i & 4) != 0) {
            m1994copywmQWz5c6 = Color.m1994copywmQWz5c(r9, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r9) : 0.54f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r9) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r9) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(contentColor2) : 0.0f);
            leadingIconColor2 = m1994copywmQWz5c6;
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        long disabledBackgroundColor2 = (i & 8) != 0 ? backgroundColor2 : disabledBackgroundColor;
        if ((i & 16) != 0) {
            m1994copywmQWz5c5 = Color.m1994copywmQWz5c(r42, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r42) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.87f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r42) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r42) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(contentColor2) : 0.0f);
            disabledContentColor2 = m1994copywmQWz5c5;
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if ((i & 32) != 0) {
            m1994copywmQWz5c4 = Color.m1994copywmQWz5c(r42, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r42) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.54f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r42) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r42) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(leadingIconColor2) : 0.0f);
            disabledLeadingIconColor2 = m1994copywmQWz5c4;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i & 64) != 0) {
            m1994copywmQWz5c3 = Color.m1994copywmQWz5c(r9, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r9) : 0.16f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r9) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r9) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            selectedBackgroundColor2 = ColorKt.m2042compositeOverOWjLjI(m1994copywmQWz5c3, backgroundColor2);
        } else {
            selectedBackgroundColor2 = selectedBackgroundColor;
        }
        if ((i & 128) != 0) {
            m1994copywmQWz5c2 = Color.m1994copywmQWz5c(r9, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r9) : 0.16f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r9) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r9) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            selectedContentColor2 = ColorKt.m2042compositeOverOWjLjI(m1994copywmQWz5c2, contentColor2);
        } else {
            selectedContentColor2 = selectedContentColor;
        }
        if ((i & 256) != 0) {
            m1994copywmQWz5c = Color.m1994copywmQWz5c(r3, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r3) : 0.16f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r3) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r3) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            selectedLeadingIconColor2 = ColorKt.m2042compositeOverOWjLjI(m1994copywmQWz5c, leadingIconColor2);
        } else {
            selectedLeadingIconColor2 = selectedLeadingIconColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(346878099, $changed, -1, "androidx.compose.material.ChipDefaults.outlinedFilterChipColors (Chip.kt:504)");
        }
        long j = leadingIconColor2;
        long leadingIconColor3 = disabledBackgroundColor2;
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(backgroundColor2, contentColor2, j, leadingIconColor3, disabledContentColor2, disabledLeadingIconColor2, selectedBackgroundColor2, selectedContentColor2, selectedLeadingIconColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }

    public final BorderStroke getOutlinedBorder(Composer $composer, int $changed) {
        long m1994copywmQWz5c;
        $composer.startReplaceableGroup(-1650225597);
        ComposerKt.sourceInformation($composer, "C542@25113L6:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1650225597, $changed, -1, "androidx.compose.material.ChipDefaults.<get-outlinedBorder> (Chip.kt:541)");
        }
        float f = OutlinedBorderSize;
        m1994copywmQWz5c = Color.m1994copywmQWz5c(r2, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r2) : 0.12f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r2) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r2) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
        BorderStroke m509BorderStrokecXLIe8U = BorderStrokeKt.m509BorderStrokecXLIe8U(f, m1994copywmQWz5c);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m509BorderStrokecXLIe8U;
    }

    /* renamed from: getOutlinedBorderSize-D9Ej5fM, reason: not valid java name */
    public final float m1301getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    /* renamed from: getLeadingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1299getLeadingIconSizeD9Ej5fM() {
        return LeadingIconSize;
    }

    /* renamed from: getSelectedIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1302getSelectedIconSizeD9Ej5fM() {
        return SelectedIconSize;
    }
}
