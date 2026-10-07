package androidx.compose.material;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.RotateKt;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.vector.ImageVector;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExposedDropdownMenu.kt */
@Metadata(m286d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0007¢\u0006\u0002\u0010\tJñ\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$Jñ\u0001\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010&\u001a\u00020\r2\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\r2\b\b\u0002\u0010)\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010$\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006+"}, m287d2 = {"Landroidx/compose/material/ExposedDropdownMenuDefaults;", "", "()V", "TrailingIcon", "", "expanded", "", "onIconClick", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "outlinedTextFieldColors", "Landroidx/compose/material/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "focusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-DlUQjxs", "(JJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-DlUQjxs", "material_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
@ExperimentalMaterialApi
/* loaded from: classes.dex */
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;
    public static final ExposedDropdownMenuDefaults INSTANCE = new ExposedDropdownMenuDefaults();

    private ExposedDropdownMenuDefaults() {
    }

    @ExperimentalMaterialApi
    public final void TrailingIcon(final boolean expanded, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Composer $composer2 = $composer.startRestartGroup(876077373);
        ComposerKt.sourceInformation($composer2, "C(TrailingIcon)294@11256L394:ExposedDropdownMenu.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(expanded) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(function0) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                Function0 onIconClick = new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                };
                function0 = onIconClick;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(876077373, $dirty2, -1, "androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.kt:286)");
            }
            IconButtonKt.IconButton(function0, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                    Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                }
            }), false, null, ComposableLambdaKt.composableLambda($composer2, 726122713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    float f;
                    ComposerKt.sourceInformation($composer3, "C295@11350L290:ExposedDropdownMenu.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(726122713, $changed2, -1, "androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon.<anonymous> (ExposedDropdownMenu.kt:294)");
                        }
                        ImageVector arrowDropDown = ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE);
                        Modifier.Companion companion = Modifier.INSTANCE;
                        if (expanded) {
                            f = 180.0f;
                        } else {
                            f = 360.0f;
                        }
                        IconKt.m1415Iconww6aTOc(arrowDropDown, "Trailing icon for exposed dropdown menu", RotateKt.rotate(companion, f), 0L, $composer3, 48, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, (($dirty2 >> 3) & 14) | 24576, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Function0<Unit> function02 = function0;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i3) {
                ExposedDropdownMenuDefaults.this.TrailingIcon(expanded, function02, composer, $changed | 1, i);
            }
        });
    }

    /* renamed from: textFieldColors-DlUQjxs, reason: not valid java name */
    public final TextFieldColors m1388textFieldColorsDlUQjxs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long focusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long textColor2;
        long disabledTextColor2;
        long backgroundColor2;
        long focusedIndicatorColor2;
        long unfocusedIndicatorColor2;
        long disabledIndicatorColor2;
        long leadingIconColor2;
        long disabledLeadingIconColor2;
        long trailingIconColor2;
        long focusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long placeholderColor2;
        long disabledPlaceholderColor2;
        long m1994copywmQWz5c;
        long m1994copywmQWz5c2;
        long m1994copywmQWz5c3;
        long m1994copywmQWz5c4;
        long m1994copywmQWz5c5;
        long m1994copywmQWz5c6;
        long m1994copywmQWz5c7;
        long m1994copywmQWz5c8;
        long m1994copywmQWz5c9;
        long m1994copywmQWz5c10;
        long m1994copywmQWz5c11;
        long m1994copywmQWz5c12;
        long m1994copywmQWz5c13;
        long m1994copywmQWz5c14;
        long m1994copywmQWz5c15;
        $composer.startReplaceableGroup(1208167904);
        ComposerKt.sourceInformation($composer, "C(textFieldColors)P(18:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,16:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,19:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)353@14329L7,353@14360L7,354@14433L8,356@14503L6,357@14614L6,358@14678L6,360@14757L6,360@14798L4,362@14872L6,365@15072L8,366@15134L6,368@15208L6,369@15355L8,372@15484L6,374@15614L6,374@15655L4,375@15749L8,376@15814L6,378@15889L6,378@15930L4,379@15988L6,379@16023L6,380@16106L8,381@16164L6,382@16226L6,382@16261L6,383@16347L8:ExposedDropdownMenu.kt#jmzs0o");
        if ((i & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long m2006unboximpl = ((Color) consume).m2006unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd($composer);
            textColor2 = Color.m1994copywmQWz5c(m2006unboximpl, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(m2006unboximpl) : ((Number) consume2).floatValue(), (r12 & 2) != 0 ? Color.m2002getRedimpl(m2006unboximpl) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(m2006unboximpl) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(m2006unboximpl) : 0.0f);
        } else {
            textColor2 = textColor;
        }
        if ((i & 2) != 0) {
            m1994copywmQWz5c15 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(textColor2) : 0.0f);
            disabledTextColor2 = m1994copywmQWz5c15;
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i & 4) != 0) {
            m1994copywmQWz5c14 = Color.m1994copywmQWz5c(r14, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r14) : 0.12f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r14) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r14) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            backgroundColor2 = m1994copywmQWz5c14;
        } else {
            backgroundColor2 = backgroundColor;
        }
        long cursorColor2 = (i & 8) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1317getPrimary0d7_KjU() : cursorColor;
        long errorCursorColor2 = (i & 16) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1311getError0d7_KjU() : errorCursorColor;
        if ((i & 32) != 0) {
            m1994copywmQWz5c13 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getHigh($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1317getPrimary0d7_KjU()) : 0.0f);
            focusedIndicatorColor2 = m1994copywmQWz5c13;
        } else {
            focusedIndicatorColor2 = focusedIndicatorColor;
        }
        if ((i & 64) != 0) {
            m1994copywmQWz5c12 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : 0.42f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            unfocusedIndicatorColor2 = m1994copywmQWz5c12;
        } else {
            unfocusedIndicatorColor2 = unfocusedIndicatorColor;
        }
        if ((i & 128) != 0) {
            m1994copywmQWz5c11 = Color.m1994copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(unfocusedIndicatorColor2) : 0.0f);
            disabledIndicatorColor2 = m1994copywmQWz5c11;
        } else {
            disabledIndicatorColor2 = disabledIndicatorColor;
        }
        long errorIndicatorColor2 = (i & 256) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1311getError0d7_KjU() : errorIndicatorColor;
        if ((i & 512) != 0) {
            m1994copywmQWz5c10 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : 0.54f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            leadingIconColor2 = m1994copywmQWz5c10;
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i & 1024) != 0) {
            m1994copywmQWz5c9 = Color.m1994copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(leadingIconColor2) : 0.0f);
            disabledLeadingIconColor2 = m1994copywmQWz5c9;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (i & 2048) != 0 ? leadingIconColor2 : errorLeadingIconColor;
        if ((i & 4096) != 0) {
            m1994copywmQWz5c8 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : 0.54f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            trailingIconColor2 = m1994copywmQWz5c8;
        } else {
            trailingIconColor2 = trailingIconColor;
        }
        if ((i & 8192) != 0) {
            m1994copywmQWz5c7 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getHigh($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1317getPrimary0d7_KjU()) : 0.0f);
            focusedTrailingIconColor2 = m1994copywmQWz5c7;
        } else {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        }
        if ((i & 16384) != 0) {
            m1994copywmQWz5c6 = Color.m1994copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(trailingIconColor2) : 0.0f);
            disabledTrailingIconColor2 = m1994copywmQWz5c6;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (32768 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1311getError0d7_KjU() : errorTrailingIconColor;
        if ((65536 & i) != 0) {
            m1994copywmQWz5c5 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getHigh($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1317getPrimary0d7_KjU()) : 0.0f);
            focusedLabelColor2 = m1994copywmQWz5c5;
        } else {
            focusedLabelColor2 = focusedLabelColor;
        }
        if ((131072 & i) != 0) {
            m1994copywmQWz5c4 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            unfocusedLabelColor2 = m1994copywmQWz5c4;
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor;
        }
        if ((262144 & i) != 0) {
            m1994copywmQWz5c3 = Color.m1994copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(unfocusedLabelColor2) : 0.0f);
            disabledLabelColor2 = m1994copywmQWz5c3;
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        long errorLabelColor2 = (524288 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1311getError0d7_KjU() : errorLabelColor;
        if ((1048576 & i) != 0) {
            m1994copywmQWz5c2 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            placeholderColor2 = m1994copywmQWz5c2;
        } else {
            placeholderColor2 = placeholderColor;
        }
        if ((i & 2097152) != 0) {
            m1994copywmQWz5c = Color.m1994copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(placeholderColor2) : 0.0f);
            disabledPlaceholderColor2 = m1994copywmQWz5c;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1208167904, $changed, $changed1, "androidx.compose.material.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:352)");
        }
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(textColor2, disabledTextColor2, cursorColor2, errorCursorColor2, focusedIndicatorColor2, unfocusedIndicatorColor2, errorIndicatorColor2, disabledIndicatorColor2, leadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, trailingIconColor2, focusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, backgroundColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, disabledPlaceholderColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultTextFieldForExposedDropdownMenusColors;
    }

    /* renamed from: outlinedTextFieldColors-DlUQjxs, reason: not valid java name */
    public final TextFieldColors m1387outlinedTextFieldColorsDlUQjxs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long focusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long textColor2;
        long disabledTextColor2;
        long focusedBorderColor2;
        long unfocusedBorderColor2;
        long disabledBorderColor2;
        long leadingIconColor2;
        long disabledLeadingIconColor2;
        long trailingIconColor2;
        long focusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long placeholderColor2;
        long disabledPlaceholderColor2;
        long m1994copywmQWz5c;
        long m1994copywmQWz5c2;
        long m1994copywmQWz5c3;
        long m1994copywmQWz5c4;
        long m1994copywmQWz5c5;
        long m1994copywmQWz5c6;
        long m1994copywmQWz5c7;
        long m1994copywmQWz5c8;
        long m1994copywmQWz5c9;
        long m1994copywmQWz5c10;
        long m1994copywmQWz5c11;
        long m1994copywmQWz5c12;
        long m1994copywmQWz5c13;
        long m1994copywmQWz5c14;
        $composer.startReplaceableGroup(1162641182);
        ComposerKt.sourceInformation($composer, "C(outlinedTextFieldColors)P(18:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,16:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,19:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)456@20314L7,456@20345L7,457@20418L8,459@20524L6,460@20588L6,462@20664L6,462@20705L4,464@20776L6,464@20819L8,465@20914L8,466@20973L6,468@21047L6,469@21194L8,472@21323L6,474@21453L6,474@21494L4,475@21588L8,476@21653L6,478@21728L6,478@21769L4,479@21827L6,479@21862L6,480@21945L8,481@22003L6,482@22065L6,482@22100L6,483@22186L8:ExposedDropdownMenu.kt#jmzs0o");
        if ((i & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long m2006unboximpl = ((Color) consume).m2006unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd($composer);
            textColor2 = Color.m1994copywmQWz5c(m2006unboximpl, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(m2006unboximpl) : ((Number) consume2).floatValue(), (r12 & 2) != 0 ? Color.m2002getRedimpl(m2006unboximpl) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(m2006unboximpl) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(m2006unboximpl) : 0.0f);
        } else {
            textColor2 = textColor;
        }
        if ((i & 2) != 0) {
            m1994copywmQWz5c14 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(textColor2) : 0.0f);
            disabledTextColor2 = m1994copywmQWz5c14;
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        long backgroundColor2 = (i & 4) != 0 ? Color.INSTANCE.m2031getTransparent0d7_KjU() : backgroundColor;
        long cursorColor2 = (i & 8) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1317getPrimary0d7_KjU() : cursorColor;
        long errorCursorColor2 = (i & 16) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1311getError0d7_KjU() : errorCursorColor;
        if ((i & 32) != 0) {
            m1994copywmQWz5c13 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getHigh($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1317getPrimary0d7_KjU()) : 0.0f);
            focusedBorderColor2 = m1994copywmQWz5c13;
        } else {
            focusedBorderColor2 = focusedBorderColor;
        }
        if ((i & 64) != 0) {
            m1994copywmQWz5c12 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            unfocusedBorderColor2 = m1994copywmQWz5c12;
        } else {
            unfocusedBorderColor2 = unfocusedBorderColor;
        }
        if ((i & 128) != 0) {
            m1994copywmQWz5c11 = Color.m1994copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(unfocusedBorderColor2) : 0.0f);
            disabledBorderColor2 = m1994copywmQWz5c11;
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        long errorBorderColor2 = (i & 256) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1311getError0d7_KjU() : errorBorderColor;
        if ((i & 512) != 0) {
            m1994copywmQWz5c10 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : 0.54f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            leadingIconColor2 = m1994copywmQWz5c10;
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i & 1024) != 0) {
            m1994copywmQWz5c9 = Color.m1994copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(leadingIconColor2) : 0.0f);
            disabledLeadingIconColor2 = m1994copywmQWz5c9;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (i & 2048) != 0 ? leadingIconColor2 : errorLeadingIconColor;
        if ((i & 4096) != 0) {
            m1994copywmQWz5c8 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : 0.54f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            trailingIconColor2 = m1994copywmQWz5c8;
        } else {
            trailingIconColor2 = trailingIconColor;
        }
        if ((i & 8192) != 0) {
            m1994copywmQWz5c7 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getHigh($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1317getPrimary0d7_KjU()) : 0.0f);
            focusedTrailingIconColor2 = m1994copywmQWz5c7;
        } else {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        }
        if ((i & 16384) != 0) {
            m1994copywmQWz5c6 = Color.m1994copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(trailingIconColor2) : 0.0f);
            disabledTrailingIconColor2 = m1994copywmQWz5c6;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (32768 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1311getError0d7_KjU() : errorTrailingIconColor;
        if ((65536 & i) != 0) {
            m1994copywmQWz5c5 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getHigh($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1317getPrimary0d7_KjU()) : 0.0f);
            focusedLabelColor2 = m1994copywmQWz5c5;
        } else {
            focusedLabelColor2 = focusedLabelColor;
        }
        if ((131072 & i) != 0) {
            m1994copywmQWz5c4 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            unfocusedLabelColor2 = m1994copywmQWz5c4;
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor;
        }
        if ((262144 & i) != 0) {
            m1994copywmQWz5c3 = Color.m1994copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(unfocusedLabelColor2) : 0.0f);
            disabledLabelColor2 = m1994copywmQWz5c3;
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        long errorLabelColor2 = (524288 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1311getError0d7_KjU() : errorLabelColor;
        if ((1048576 & i) != 0) {
            m1994copywmQWz5c2 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            placeholderColor2 = m1994copywmQWz5c2;
        } else {
            placeholderColor2 = placeholderColor;
        }
        if ((i & 2097152) != 0) {
            m1994copywmQWz5c = Color.m1994copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(placeholderColor2) : 0.0f);
            disabledPlaceholderColor2 = m1994copywmQWz5c;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1162641182, $changed, $changed1, "androidx.compose.material.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:455)");
        }
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(textColor2, disabledTextColor2, cursorColor2, errorCursorColor2, focusedBorderColor2, unfocusedBorderColor2, errorBorderColor2, disabledBorderColor2, leadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, trailingIconColor2, focusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, backgroundColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, disabledPlaceholderColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultTextFieldForExposedDropdownMenusColors;
    }
}
