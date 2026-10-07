package androidx.compose.foundation.text;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p000ui.text.AnnotatedString;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.style.TextOverflow;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClickableText.kt */
@Metadata(m286d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ay\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0014"}, m287d2 = {"ClickableText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "onClick", "ClickableText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ClickableTextKt {
    /* JADX WARN: Removed duplicated region for block: B:33:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0149  */
    /* renamed from: ClickableText-4YKlhWE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1023ClickableText4YKlhWE(final AnnotatedString text, Modifier modifier, TextStyle style, boolean softWrap, int overflow, int maxLines, Function1<? super TextLayoutResult, Unit> function1, final Function1<? super Integer, Unit> onClick, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        TextStyle textStyle;
        boolean z;
        int i2;
        TextStyle style2;
        boolean softWrap2;
        int overflow2;
        int maxLines2;
        final Function1 onTextLayout;
        Object it$iv$iv;
        Object value$iv$iv;
        boolean invalid$iv$iv;
        ClickableTextKt$ClickableText$pressIndicator$1$1 value$iv$iv2;
        boolean invalid$iv$iv2;
        Modifier modifier3;
        Function1 onTextLayout2;
        ScopeUpdateScope endRestartGroup;
        int i3;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer2 = $composer.startRestartGroup(-246609449);
        ComposerKt.sourceInformation($composer2, "C(ClickableText)P(7,1,6,5,4:c#ui.text.style.TextOverflow!1,3)73@3340L52,74@3449L184,89@3854L76,82@3639L297:ClickableText.kt#423gt5");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(text) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            textStyle = style;
        } else if (($changed & 896) == 0) {
            textStyle = style;
            $dirty |= $composer2.changed(textStyle) ? 256 : 128;
        } else {
            textStyle = style;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
            z = softWrap;
        } else if (($changed & 7168) == 0) {
            z = softWrap;
            $dirty |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = softWrap;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
            i2 = overflow;
        } else if (($changed & 57344) == 0) {
            i2 = overflow;
            $dirty |= $composer2.changed(i2) ? 16384 : 8192;
        } else {
            i2 = overflow;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= 196608;
        } else if (($changed & 458752) == 0) {
            $dirty |= $composer2.changed(maxLines) ? 131072 : 65536;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer2.changed(function1) ? 1048576 : 524288;
        }
        if ((i & 128) == 0) {
            i3 = (29360128 & $changed) == 0 ? $composer2.changed(onClick) ? 8388608 : 4194304 : 12582912;
            if ((23967451 & $dirty) == 4793490 || !$composer2.getSkipping()) {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i5 != 0) {
                    style2 = textStyle;
                } else {
                    style2 = TextStyle.INSTANCE.getDefault();
                }
                if (i6 != 0) {
                    softWrap2 = z;
                } else {
                    softWrap2 = true;
                }
                if (i7 != 0) {
                    overflow2 = i2;
                } else {
                    overflow2 = TextOverflow.INSTANCE.m4302getClipgIe3tQ8();
                }
                if (i8 != 0) {
                    maxLines2 = maxLines;
                } else {
                    maxLines2 = Integer.MAX_VALUE;
                }
                if (i9 != 0) {
                    onTextLayout = function1;
                } else {
                    onTextLayout = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                            invoke2(textLayoutResult);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextLayoutResult it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    };
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-246609449, $dirty, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:63)");
                }
                $composer2.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                it$iv$iv = $composer2.rememberedValue();
                if (it$iv$iv != Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    $composer2.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer2.endReplaceableGroup();
                final MutableState layoutResult = (MutableState) value$iv$iv;
                Modifier.Companion companion = Modifier.INSTANCE;
                int i10 = (($dirty >> 18) & SdkConfig.SDK_VERSION) | 518;
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
                invalid$iv$iv = $composer2.changed(layoutResult) | $composer2.changed(onClick);
                Object it$iv$iv2 = $composer2.rememberedValue();
                if (!invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(layoutResult, onClick, null);
                    $composer2.updateRememberedValue(value$iv$iv2);
                } else {
                    value$iv$iv2 = it$iv$iv2;
                }
                $composer2.endReplaceableGroup();
                Modifier pressIndicator = SuspendingPointerInputFilterKt.pointerInput(companion, onClick, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv2);
                Modifier then = modifier2.then(pressIndicator);
                int i11 = (($dirty >> 15) & SdkConfig.SDK_VERSION) | 6;
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
                invalid$iv$iv2 = $composer2.changed(layoutResult) | $composer2.changed(onTextLayout);
                Object value$iv$iv3 = $composer2.rememberedValue();
                if (!invalid$iv$iv2 && value$iv$iv3 != Composer.INSTANCE.getEmpty()) {
                    $composer2.endReplaceableGroup();
                    modifier3 = modifier2;
                    onTextLayout2 = onTextLayout;
                    BasicTextKt.m1021BasicText4YKlhWE(text, then, style2, (Function1) value$iv$iv3, overflow2, softWrap2, maxLines2, null, $composer2, ($dirty & 14) | ($dirty & 896) | (57344 & $dirty) | (($dirty << 6) & 458752) | (($dirty << 3) & 3670016), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                value$iv$iv3 = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        layoutResult.setValue(it);
                        onTextLayout.invoke(it);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv3);
                $composer2.endReplaceableGroup();
                modifier3 = modifier2;
                onTextLayout2 = onTextLayout;
                BasicTextKt.m1021BasicText4YKlhWE(text, then, style2, (Function1) value$iv$iv3, overflow2, softWrap2, maxLines2, null, $composer2, ($dirty & 14) | ($dirty & 896) | (57344 & $dirty) | (($dirty << 6) & 458752) | (($dirty << 3) & 3670016), 128);
                if (ComposerKt.isTraceInProgress()) {
                }
            } else {
                $composer2.skipToGroupEnd();
                maxLines2 = maxLines;
                onTextLayout2 = function1;
                modifier3 = modifier2;
                style2 = textStyle;
                softWrap2 = z;
                overflow2 = i2;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            final Modifier modifier4 = modifier3;
            final TextStyle textStyle2 = style2;
            final boolean z2 = softWrap2;
            final int i12 = overflow2;
            final int i13 = maxLines2;
            final Function1 function12 = onTextLayout2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$3
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

                public final void invoke(Composer composer, int i14) {
                    ClickableTextKt.m1023ClickableText4YKlhWE(AnnotatedString.this, modifier4, textStyle2, z2, i12, i13, function12, onClick, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty |= i3;
        if ((23967451 & $dirty) == 4793490) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        $composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
        it$iv$iv = $composer2.rememberedValue();
        if (it$iv$iv != Composer.INSTANCE.getEmpty()) {
        }
        $composer2.endReplaceableGroup();
        final MutableState<TextLayoutResult> layoutResult2 = (MutableState) value$iv$iv;
        Modifier.Companion companion2 = Modifier.INSTANCE;
        int i102 = (($dirty >> 18) & SdkConfig.SDK_VERSION) | 518;
        $composer2.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
        invalid$iv$iv = $composer2.changed(layoutResult2) | $composer2.changed(onClick);
        Object it$iv$iv22 = $composer2.rememberedValue();
        if (invalid$iv$iv) {
        }
        value$iv$iv2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(layoutResult2, onClick, null);
        $composer2.updateRememberedValue(value$iv$iv2);
        $composer2.endReplaceableGroup();
        Modifier pressIndicator2 = SuspendingPointerInputFilterKt.pointerInput(companion2, onClick, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv2);
        Modifier then2 = modifier2.then(pressIndicator2);
        int i112 = (($dirty >> 15) & SdkConfig.SDK_VERSION) | 6;
        $composer2.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
        invalid$iv$iv2 = $composer2.changed(layoutResult2) | $composer2.changed(onTextLayout);
        Object value$iv$iv32 = $composer2.rememberedValue();
        if (!invalid$iv$iv2) {
            $composer2.endReplaceableGroup();
            modifier3 = modifier2;
            onTextLayout2 = onTextLayout;
            BasicTextKt.m1021BasicText4YKlhWE(text, then2, style2, (Function1) value$iv$iv32, overflow2, softWrap2, maxLines2, null, $composer2, ($dirty & 14) | ($dirty & 896) | (57344 & $dirty) | (($dirty << 6) & 458752) | (($dirty << 3) & 3670016), 128);
            if (ComposerKt.isTraceInProgress()) {
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        value$iv$iv32 = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                invoke2(textLayoutResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextLayoutResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                layoutResult2.setValue(it);
                onTextLayout.invoke(it);
            }
        };
        $composer2.updateRememberedValue(value$iv$iv32);
        $composer2.endReplaceableGroup();
        modifier3 = modifier2;
        onTextLayout2 = onTextLayout;
        BasicTextKt.m1021BasicText4YKlhWE(text, then2, style2, (Function1) value$iv$iv32, overflow2, softWrap2, maxLines2, null, $composer2, ($dirty & 14) | ($dirty & 896) | (57344 & $dirty) | (($dirty << 6) & 458752) | (($dirty << 3) & 3670016), 128);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
