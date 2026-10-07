package com.example.healthconnect.codelab.presentation.theme;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.MaterialThemeKt;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Theme.kt */
@Metadata(m286d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m287d2 = {"DarkColorPalette", "Landroidx/compose/material/Colors;", "LightColorPalette", "HealthConnectTheme", "", "darkTheme", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "finished_debug"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes7.dex */
public final class ThemeKt {
    private static final Colors DarkColorPalette = ColorsKt.m1337darkColors2qZNXz8$default(ColorKt.getDeepBlue(), ColorKt.getHealthConnectBlue(), ColorKt.getDeepBlue(), 0, ColorKt.getWarmYellow(), ColorKt.getWarmSurface(), ColorKt.getHealthConnectRed(), ColorKt.getWhite(), ColorKt.getWhite(), ColorKt.getDeepBlue(), ColorKt.getDeepBlue(), ColorKt.getWhite(), 8, null);
    private static final Colors LightColorPalette;

    static {
        Colors m1338lightColors2qZNXz8;
        m1338lightColors2qZNXz8 = ColorsKt.m1338lightColors2qZNXz8((r43 & 1) != 0 ? androidx.compose.p000ui.graphics.ColorKt.Color(4284612846L) : ColorKt.getDeepBlue(), (r43 & 2) != 0 ? androidx.compose.p000ui.graphics.ColorKt.Color(4281794739L) : ColorKt.getHealthConnectBlue(), (r43 & 4) != 0 ? androidx.compose.p000ui.graphics.ColorKt.Color(4278442694L) : ColorKt.getDeepBlue(), (r43 & 8) != 0 ? androidx.compose.p000ui.graphics.ColorKt.Color(4278290310L) : 0L, (r43 & 16) != 0 ? Color.INSTANCE.m2033getWhite0d7_KjU() : ColorKt.getWarmYellow(), (r43 & 32) != 0 ? Color.INSTANCE.m2033getWhite0d7_KjU() : ColorKt.getWarmSurface(), (r43 & 64) != 0 ? androidx.compose.p000ui.graphics.ColorKt.Color(4289724448L) : ColorKt.getHealthConnectRed(), (r43 & 128) != 0 ? Color.INSTANCE.m2033getWhite0d7_KjU() : ColorKt.getWhite(), (r43 & 256) != 0 ? Color.INSTANCE.m2022getBlack0d7_KjU() : ColorKt.getWhite(), (r43 & 512) != 0 ? Color.INSTANCE.m2022getBlack0d7_KjU() : ColorKt.getDeepBlue(), (r43 & 1024) != 0 ? Color.INSTANCE.m2022getBlack0d7_KjU() : ColorKt.getDeepBlue(), (r43 & 2048) != 0 ? Color.INSTANCE.m2033getWhite0d7_KjU() : ColorKt.getWhite());
        LightColorPalette = m1338lightColors2qZNXz8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        if ((r13 & 1) != 0) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void HealthConnectTheme(final boolean darkTheme, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-1716436740);
        ComposerKt.sourceInformation($composer2, "C(HealthConnectTheme)P(1)54@1662L21,63@1817L111:Theme.kt#2vya0c");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= ((i & 1) == 0 && $composer2.changed(darkTheme)) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(content) ? 32 : 16;
        }
        if (($dirty & 91) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i & 1) != 0) {
                    darkTheme = DarkThemeKt.isSystemInDarkTheme($composer2, 0);
                    $dirty &= -15;
                }
                int $dirty2 = $dirty;
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1716436740, $dirty2, -1, "com.example.healthconnect.codelab.presentation.theme.HealthConnectTheme (Theme.kt:53)");
                }
                Colors colors = darkTheme ? DarkColorPalette : LightColorPalette;
                MaterialThemeKt.MaterialTheme(colors, TypeKt.getTypography(), ShapeKt.getShapes(), content, $composer2, (($dirty2 << 6) & 7168) | 432, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer2.skipToGroupEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.theme.ThemeKt$HealthConnectTheme$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i2) {
                ThemeKt.HealthConnectTheme(darkTheme, content, composer, $changed | 1, i);
            }
        });
    }
}
