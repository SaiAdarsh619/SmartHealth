package androidx.compose.foundation.text;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Brush;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.SolidColor;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.p000ui.text.TextRange;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.input.ImeOptions;
import androidx.compose.p000ui.text.input.TextFieldValue;
import androidx.compose.p000ui.text.input.VisualTransformation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasicTextField.kt */
@Metadata(m286d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010\"\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020#2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010$¨\u0006%"}, m287d2 = {"BasicTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class BasicTextFieldKt {
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01d6, code lost:
    
        if (r10.changed(r52) != false) goto L152;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x04ee A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x056b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTextField(final String value, final Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function1, MutableInteractionSource interactionSource, Brush cursorBrush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean enabled2;
        boolean singleLine2;
        Modifier modifier2;
        MutableInteractionSource interactionSource2;
        int maxLines2;
        KeyboardActions keyboardActions2;
        SolidColor cursorBrush2;
        KeyboardActions keyboardActions3;
        Function3 decorationBox;
        MutableInteractionSource interactionSource3;
        Brush cursorBrush3;
        VisualTransformation visualTransformation2;
        Function1 onTextLayout;
        TextStyle textStyle2;
        KeyboardOptions keyboardOptions2;
        Modifier modifier3;
        boolean singleLine3;
        int $dirty1;
        boolean readOnly2;
        Object value$iv$iv;
        boolean readOnly3;
        boolean invalid$iv$iv;
        Object it$iv$iv;
        Object value$iv$iv2;
        boolean invalid$iv$iv2;
        Object it$iv$iv2;
        Object value$iv$iv3;
        KeyboardOptions keyboardOptions3;
        boolean enabled3;
        boolean singleLine4;
        int maxLines3;
        Modifier modifier4;
        TextStyle textStyle3;
        KeyboardActions keyboardActions4;
        VisualTransformation visualTransformation3;
        Function1 onTextLayout2;
        MutableInteractionSource interactionSource4;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer2 = $composer.startRestartGroup(-454732590);
        ComposerKt.sourceInformation($composer2, "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)134@7772L39,141@8166L57,147@8519L216,147@8508L227,156@9056L41,160@9174L373,158@9103L980:BasicTextField.kt#423gt5");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(onValueChange) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        int i4 = 2048;
        if (i3 != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(enabled) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer2.changed(readOnly) ? 16384 : 8192;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= 196608;
        } else if (($changed & 458752) == 0) {
            $dirty |= $composer2.changed(textStyle) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer2.changed(keyboardOptions) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer2.changed(keyboardActions) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer2.changed(singleLine) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer2.changed(maxLines) ? 536870912 : 268435456;
        }
        int i11 = i & 1024;
        if (i11 != 0) {
            $dirty12 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty12 |= $composer2.changed(visualTransformation) ? 4 : 2;
        }
        int i12 = i & 2048;
        if (i12 != 0) {
            $dirty12 |= 48;
        } else if (($changed1 & SdkConfig.SDK_VERSION) == 0) {
            $dirty12 |= $composer2.changed(function1) ? 32 : 16;
        }
        int i13 = i & 4096;
        if (i13 != 0) {
            $dirty12 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty12 |= $composer2.changed(interactionSource) ? 256 : 128;
        }
        if (($changed1 & 7168) == 0) {
            if ((i & 8192) != 0) {
            }
            i4 = 1024;
            $dirty12 |= i4;
        }
        int i14 = i & 16384;
        if (i14 != 0) {
            $dirty12 |= 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty12 |= $composer2.changed(function3) ? 16384 : 8192;
        }
        if (($dirty & 1533916891) == 306783378 && (46811 & $dirty12) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier;
            enabled3 = enabled;
            readOnly3 = readOnly;
            textStyle3 = textStyle;
            keyboardOptions3 = keyboardOptions;
            keyboardActions4 = keyboardActions;
            singleLine4 = singleLine;
            maxLines3 = maxLines;
            visualTransformation3 = visualTransformation;
            onTextLayout2 = function1;
            interactionSource4 = interactionSource;
            cursorBrush3 = cursorBrush;
            decorationBox = function3;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier;
                enabled2 = i3 != 0 ? true : enabled;
                boolean readOnly4 = i5 != 0 ? false : readOnly;
                TextStyle textStyle4 = i6 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
                KeyboardOptions keyboardOptions4 = i7 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions5 = i8 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                boolean singleLine5 = i9 != 0 ? false : singleLine;
                int maxLines4 = i10 != 0 ? Integer.MAX_VALUE : maxLines;
                VisualTransformation visualTransformation4 = i11 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                Function1 onTextLayout3 = i12 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                } : function1;
                if (i13 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                    singleLine2 = singleLine5;
                    Object it$iv$iv3 = $composer2.rememberedValue();
                    modifier2 = modifier5;
                    if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv3;
                    }
                    $composer2.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    singleLine2 = singleLine5;
                    modifier2 = modifier5;
                    interactionSource2 = interactionSource;
                }
                if ((i & 8192) != 0) {
                    maxLines2 = maxLines4;
                    keyboardActions2 = keyboardActions5;
                    cursorBrush2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
                    $dirty12 &= -7169;
                } else {
                    maxLines2 = maxLines4;
                    keyboardActions2 = keyboardActions5;
                    cursorBrush2 = cursorBrush;
                }
                if (i14 != 0) {
                    keyboardActions3 = keyboardActions2;
                    maxLines = maxLines2;
                    interactionSource3 = interactionSource2;
                    cursorBrush3 = cursorBrush2;
                    decorationBox = ComposableSingletons$BasicTextFieldKt.INSTANCE.m1025getLambda1$foundation_release();
                    visualTransformation2 = visualTransformation4;
                    onTextLayout = onTextLayout3;
                    textStyle2 = textStyle4;
                    keyboardOptions2 = keyboardOptions4;
                    modifier3 = modifier2;
                    singleLine3 = singleLine2;
                    $dirty1 = $dirty12;
                    readOnly2 = readOnly4;
                } else {
                    keyboardActions3 = keyboardActions2;
                    maxLines = maxLines2;
                    decorationBox = function3;
                    interactionSource3 = interactionSource2;
                    cursorBrush3 = cursorBrush2;
                    visualTransformation2 = visualTransformation4;
                    onTextLayout = onTextLayout3;
                    textStyle2 = textStyle4;
                    keyboardOptions2 = keyboardOptions4;
                    modifier3 = modifier2;
                    singleLine3 = singleLine2;
                    $dirty1 = $dirty12;
                    readOnly2 = readOnly4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8192) != 0) {
                    $dirty12 &= -7169;
                }
                modifier3 = modifier;
                enabled2 = enabled;
                textStyle2 = textStyle;
                keyboardOptions2 = keyboardOptions;
                keyboardActions3 = keyboardActions;
                singleLine3 = singleLine;
                visualTransformation2 = visualTransformation;
                onTextLayout = function1;
                interactionSource3 = interactionSource;
                cursorBrush3 = cursorBrush;
                decorationBox = function3;
                $dirty1 = $dirty12;
                readOnly2 = readOnly;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-454732590, $dirty, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:121)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Object value$iv$iv4 = $composer2.rememberedValue();
            if (value$iv$iv4 == Composer.INSTANCE.getEmpty()) {
                readOnly3 = readOnly2;
                value$iv$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(value, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                $composer2.updateRememberedValue(value$iv$iv4);
            } else {
                readOnly3 = readOnly2;
            }
            $composer2.endReplaceableGroup();
            final MutableState textFieldValueState$delegate = (MutableState) value$iv$iv4;
            final TextFieldValue textFieldValue = TextFieldValue.m4138copy3r_uNRQ$default(m1013BasicTextField$lambda2(textFieldValueState$delegate), value, 0L, (TextRange) null, 6, (Object) null);
            $composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv3 = $composer2.changed(textFieldValue) | $composer2.changed(textFieldValueState$delegate);
            boolean enabled4 = enabled2;
            Object value$iv$iv5 = $composer2.rememberedValue();
            if (!invalid$iv$iv3 && value$iv$iv5 != Composer.INSTANCE.getEmpty()) {
                $composer2.endReplaceableGroup();
                EffectsKt.SideEffect((Function0) value$iv$iv5, $composer2, 0);
                int i15 = $dirty & 14;
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                invalid$iv$iv = $composer2.changed(value);
                it$iv$iv = $composer2.rememberedValue();
                if (!invalid$iv$iv && it$iv$iv != Composer.INSTANCE.getEmpty()) {
                    value$iv$iv2 = it$iv$iv;
                    $composer2.endReplaceableGroup();
                    final MutableState lastTextValue$delegate = (MutableState) value$iv$iv2;
                    ImeOptions imeOptions$foundation_release = keyboardOptions2.toImeOptions$foundation_release(singleLine3);
                    boolean z = !singleLine3;
                    int i16 = !singleLine3 ? 1 : maxLines;
                    int i17 = (($dirty << 3) & 896) | 6;
                    KeyboardOptions keyboardOptions5 = keyboardOptions2;
                    $composer2.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation($composer2, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    invalid$iv$iv2 = $composer2.changed(textFieldValueState$delegate) | $composer2.changed(lastTextValue$delegate) | $composer2.changed(onValueChange);
                    boolean singleLine6 = singleLine3;
                    it$iv$iv2 = $composer2.rememberedValue();
                    if (!invalid$iv$iv2 && it$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                        value$iv$iv3 = it$iv$iv2;
                        $composer2.endReplaceableGroup();
                        CoreTextFieldKt.CoreTextField(textFieldValue, (Function1) value$iv$iv3, modifier3, textStyle2, visualTransformation2, onTextLayout, interactionSource3, cursorBrush3, z, i16, imeOptions$foundation_release, keyboardActions3, enabled4, readOnly3, decorationBox, $composer2, ($dirty & 896) | (($dirty >> 6) & 7168) | (($dirty1 << 12) & 57344) | (($dirty1 << 12) & 458752) | (($dirty1 << 12) & 3670016) | (29360128 & ($dirty1 << 12)), (($dirty >> 18) & SdkConfig.SDK_VERSION) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | ($dirty1 & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        keyboardOptions3 = keyboardOptions5;
                        enabled3 = enabled4;
                        singleLine4 = singleLine6;
                        maxLines3 = maxLines;
                        modifier4 = modifier3;
                        textStyle3 = textStyle2;
                        keyboardActions4 = keyboardActions3;
                        visualTransformation3 = visualTransformation2;
                        onTextLayout2 = onTextLayout;
                        interactionSource4 = interactionSource3;
                    }
                    value$iv$iv3 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue2) {
                            invoke2(textFieldValue2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue newTextFieldValueState) {
                            String m1015BasicTextField$lambda6;
                            Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                            textFieldValueState$delegate.setValue(newTextFieldValueState);
                            m1015BasicTextField$lambda6 = BasicTextFieldKt.m1015BasicTextField$lambda6(lastTextValue$delegate);
                            boolean stringChangedSinceLastInvocation = !Intrinsics.areEqual(m1015BasicTextField$lambda6, newTextFieldValueState.getText());
                            lastTextValue$delegate.setValue(newTextFieldValueState.getText());
                            if (stringChangedSinceLastInvocation) {
                                onValueChange.invoke(newTextFieldValueState.getText());
                            }
                        }
                    };
                    $composer2.updateRememberedValue(value$iv$iv3);
                    $composer2.endReplaceableGroup();
                    CoreTextFieldKt.CoreTextField(textFieldValue, (Function1) value$iv$iv3, modifier3, textStyle2, visualTransformation2, onTextLayout, interactionSource3, cursorBrush3, z, i16, imeOptions$foundation_release, keyboardActions3, enabled4, readOnly3, decorationBox, $composer2, ($dirty & 896) | (($dirty >> 6) & 7168) | (($dirty1 << 12) & 57344) | (($dirty1 << 12) & 458752) | (($dirty1 << 12) & 3670016) | (29360128 & ($dirty1 << 12)), (($dirty >> 18) & SdkConfig.SDK_VERSION) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | ($dirty1 & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    keyboardOptions3 = keyboardOptions5;
                    enabled3 = enabled4;
                    singleLine4 = singleLine6;
                    maxLines3 = maxLines;
                    modifier4 = modifier3;
                    textStyle3 = textStyle2;
                    keyboardActions4 = keyboardActions3;
                    visualTransformation3 = visualTransformation2;
                    onTextLayout2 = onTextLayout;
                    interactionSource4 = interactionSource3;
                }
                value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                $composer2.updateRememberedValue(value$iv$iv2);
                $composer2.endReplaceableGroup();
                final MutableState<String> lastTextValue$delegate2 = (MutableState) value$iv$iv2;
                ImeOptions imeOptions$foundation_release2 = keyboardOptions2.toImeOptions$foundation_release(singleLine3);
                boolean z2 = !singleLine3;
                if (!singleLine3) {
                }
                int i172 = (($dirty << 3) & 896) | 6;
                KeyboardOptions keyboardOptions52 = keyboardOptions2;
                $composer2.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                invalid$iv$iv2 = $composer2.changed(textFieldValueState$delegate) | $composer2.changed(lastTextValue$delegate2) | $composer2.changed(onValueChange);
                boolean singleLine62 = singleLine3;
                it$iv$iv2 = $composer2.rememberedValue();
                if (!invalid$iv$iv2) {
                    value$iv$iv3 = it$iv$iv2;
                    $composer2.endReplaceableGroup();
                    CoreTextFieldKt.CoreTextField(textFieldValue, (Function1) value$iv$iv3, modifier3, textStyle2, visualTransformation2, onTextLayout, interactionSource3, cursorBrush3, z2, i16, imeOptions$foundation_release2, keyboardActions3, enabled4, readOnly3, decorationBox, $composer2, ($dirty & 896) | (($dirty >> 6) & 7168) | (($dirty1 << 12) & 57344) | (($dirty1 << 12) & 458752) | (($dirty1 << 12) & 3670016) | (29360128 & ($dirty1 << 12)), (($dirty >> 18) & SdkConfig.SDK_VERSION) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | ($dirty1 & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    keyboardOptions3 = keyboardOptions52;
                    enabled3 = enabled4;
                    singleLine4 = singleLine62;
                    maxLines3 = maxLines;
                    modifier4 = modifier3;
                    textStyle3 = textStyle2;
                    keyboardActions4 = keyboardActions3;
                    visualTransformation3 = visualTransformation2;
                    onTextLayout2 = onTextLayout;
                    interactionSource4 = interactionSource3;
                }
                value$iv$iv3 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue2) {
                        invoke2(textFieldValue2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextFieldValue newTextFieldValueState) {
                        String m1015BasicTextField$lambda6;
                        Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                        textFieldValueState$delegate.setValue(newTextFieldValueState);
                        m1015BasicTextField$lambda6 = BasicTextFieldKt.m1015BasicTextField$lambda6(lastTextValue$delegate2);
                        boolean stringChangedSinceLastInvocation = !Intrinsics.areEqual(m1015BasicTextField$lambda6, newTextFieldValueState.getText());
                        lastTextValue$delegate2.setValue(newTextFieldValueState.getText());
                        if (stringChangedSinceLastInvocation) {
                            onValueChange.invoke(newTextFieldValueState.getText());
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv3);
                $composer2.endReplaceableGroup();
                CoreTextFieldKt.CoreTextField(textFieldValue, (Function1) value$iv$iv3, modifier3, textStyle2, visualTransformation2, onTextLayout, interactionSource3, cursorBrush3, z2, i16, imeOptions$foundation_release2, keyboardActions3, enabled4, readOnly3, decorationBox, $composer2, ($dirty & 896) | (($dirty >> 6) & 7168) | (($dirty1 << 12) & 57344) | (($dirty1 << 12) & 458752) | (($dirty1 << 12) & 3670016) | (29360128 & ($dirty1 << 12)), (($dirty >> 18) & SdkConfig.SDK_VERSION) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | ($dirty1 & 57344), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                keyboardOptions3 = keyboardOptions52;
                enabled3 = enabled4;
                singleLine4 = singleLine62;
                maxLines3 = maxLines;
                modifier4 = modifier3;
                textStyle3 = textStyle2;
                keyboardActions4 = keyboardActions3;
                visualTransformation3 = visualTransformation2;
                onTextLayout2 = onTextLayout;
                interactionSource4 = interactionSource3;
            }
            value$iv$iv5 = (Function0) new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    TextFieldValue m1013BasicTextField$lambda2;
                    TextFieldValue m1013BasicTextField$lambda22;
                    long selection = TextFieldValue.this.getSelection();
                    m1013BasicTextField$lambda2 = BasicTextFieldKt.m1013BasicTextField$lambda2(textFieldValueState$delegate);
                    if (TextRange.m3950equalsimpl0(selection, m1013BasicTextField$lambda2.getSelection())) {
                        TextRange composition = TextFieldValue.this.getComposition();
                        m1013BasicTextField$lambda22 = BasicTextFieldKt.m1013BasicTextField$lambda2(textFieldValueState$delegate);
                        if (Intrinsics.areEqual(composition, m1013BasicTextField$lambda22.getComposition())) {
                            return;
                        }
                    }
                    textFieldValueState$delegate.setValue(TextFieldValue.this);
                }
            };
            $composer2.updateRememberedValue(value$iv$iv5);
            $composer2.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) value$iv$iv5, $composer2, 0);
            int i152 = $dirty & 14;
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
            invalid$iv$iv = $composer2.changed(value);
            it$iv$iv = $composer2.rememberedValue();
            if (!invalid$iv$iv) {
                value$iv$iv2 = it$iv$iv;
                $composer2.endReplaceableGroup();
                final MutableState<String> lastTextValue$delegate22 = (MutableState) value$iv$iv2;
                ImeOptions imeOptions$foundation_release22 = keyboardOptions2.toImeOptions$foundation_release(singleLine3);
                boolean z22 = !singleLine3;
                if (!singleLine3) {
                }
                int i1722 = (($dirty << 3) & 896) | 6;
                KeyboardOptions keyboardOptions522 = keyboardOptions2;
                $composer2.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation($composer2, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                invalid$iv$iv2 = $composer2.changed(textFieldValueState$delegate) | $composer2.changed(lastTextValue$delegate22) | $composer2.changed(onValueChange);
                boolean singleLine622 = singleLine3;
                it$iv$iv2 = $composer2.rememberedValue();
                if (!invalid$iv$iv2) {
                }
                value$iv$iv3 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue2) {
                        invoke2(textFieldValue2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextFieldValue newTextFieldValueState) {
                        String m1015BasicTextField$lambda6;
                        Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                        textFieldValueState$delegate.setValue(newTextFieldValueState);
                        m1015BasicTextField$lambda6 = BasicTextFieldKt.m1015BasicTextField$lambda6(lastTextValue$delegate22);
                        boolean stringChangedSinceLastInvocation = !Intrinsics.areEqual(m1015BasicTextField$lambda6, newTextFieldValueState.getText());
                        lastTextValue$delegate22.setValue(newTextFieldValueState.getText());
                        if (stringChangedSinceLastInvocation) {
                            onValueChange.invoke(newTextFieldValueState.getText());
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv3);
                $composer2.endReplaceableGroup();
                CoreTextFieldKt.CoreTextField(textFieldValue, (Function1) value$iv$iv3, modifier3, textStyle2, visualTransformation2, onTextLayout, interactionSource3, cursorBrush3, z22, i16, imeOptions$foundation_release22, keyboardActions3, enabled4, readOnly3, decorationBox, $composer2, ($dirty & 896) | (($dirty >> 6) & 7168) | (($dirty1 << 12) & 57344) | (($dirty1 << 12) & 458752) | (($dirty1 << 12) & 3670016) | (29360128 & ($dirty1 << 12)), (($dirty >> 18) & SdkConfig.SDK_VERSION) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | ($dirty1 & 57344), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                keyboardOptions3 = keyboardOptions522;
                enabled3 = enabled4;
                singleLine4 = singleLine622;
                maxLines3 = maxLines;
                modifier4 = modifier3;
                textStyle3 = textStyle2;
                keyboardActions4 = keyboardActions3;
                visualTransformation3 = visualTransformation2;
                onTextLayout2 = onTextLayout;
                interactionSource4 = interactionSource3;
            }
            value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
            $composer2.updateRememberedValue(value$iv$iv2);
            $composer2.endReplaceableGroup();
            final MutableState<String> lastTextValue$delegate222 = (MutableState) value$iv$iv2;
            ImeOptions imeOptions$foundation_release222 = keyboardOptions2.toImeOptions$foundation_release(singleLine3);
            boolean z222 = !singleLine3;
            if (!singleLine3) {
            }
            int i17222 = (($dirty << 3) & 896) | 6;
            KeyboardOptions keyboardOptions5222 = keyboardOptions2;
            $composer2.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1,2,3):Composables.kt#9igjgp");
            invalid$iv$iv2 = $composer2.changed(textFieldValueState$delegate) | $composer2.changed(lastTextValue$delegate222) | $composer2.changed(onValueChange);
            boolean singleLine6222 = singleLine3;
            it$iv$iv2 = $composer2.rememberedValue();
            if (!invalid$iv$iv2) {
            }
            value$iv$iv3 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue2) {
                    invoke2(textFieldValue2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextFieldValue newTextFieldValueState) {
                    String m1015BasicTextField$lambda6;
                    Intrinsics.checkNotNullParameter(newTextFieldValueState, "newTextFieldValueState");
                    textFieldValueState$delegate.setValue(newTextFieldValueState);
                    m1015BasicTextField$lambda6 = BasicTextFieldKt.m1015BasicTextField$lambda6(lastTextValue$delegate222);
                    boolean stringChangedSinceLastInvocation = !Intrinsics.areEqual(m1015BasicTextField$lambda6, newTextFieldValueState.getText());
                    lastTextValue$delegate222.setValue(newTextFieldValueState.getText());
                    if (stringChangedSinceLastInvocation) {
                        onValueChange.invoke(newTextFieldValueState.getText());
                    }
                }
            };
            $composer2.updateRememberedValue(value$iv$iv3);
            $composer2.endReplaceableGroup();
            CoreTextFieldKt.CoreTextField(textFieldValue, (Function1) value$iv$iv3, modifier3, textStyle2, visualTransformation2, onTextLayout, interactionSource3, cursorBrush3, z222, i16, imeOptions$foundation_release222, keyboardActions3, enabled4, readOnly3, decorationBox, $composer2, ($dirty & 896) | (($dirty >> 6) & 7168) | (($dirty1 << 12) & 57344) | (($dirty1 << 12) & 458752) | (($dirty1 << 12) & 3670016) | (29360128 & ($dirty1 << 12)), (($dirty >> 18) & SdkConfig.SDK_VERSION) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | ($dirty1 & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            keyboardOptions3 = keyboardOptions5222;
            enabled3 = enabled4;
            singleLine4 = singleLine6222;
            maxLines3 = maxLines;
            modifier4 = modifier3;
            textStyle3 = textStyle2;
            keyboardActions4 = keyboardActions3;
            visualTransformation3 = visualTransformation2;
            onTextLayout2 = onTextLayout;
            interactionSource4 = interactionSource3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier4;
        final boolean z3 = enabled3;
        final boolean z4 = readOnly3;
        final TextStyle textStyle5 = textStyle3;
        final KeyboardOptions keyboardOptions6 = keyboardOptions3;
        final KeyboardActions keyboardActions6 = keyboardActions4;
        final boolean z5 = singleLine4;
        final int i18 = maxLines3;
        final VisualTransformation visualTransformation5 = visualTransformation3;
        final Function1 function12 = onTextLayout2;
        final MutableInteractionSource mutableInteractionSource = interactionSource4;
        final Brush brush = cursorBrush3;
        final Function3 function32 = decorationBox;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$5
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

            public final void invoke(Composer composer, int i19) {
                BasicTextFieldKt.BasicTextField(value, onValueChange, modifier6, z3, z4, textStyle5, keyboardOptions6, keyboardActions6, z5, i18, visualTransformation5, function12, mutableInteractionSource, brush, function32, composer, $changed | 1, $changed1, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BasicTextField$lambda-2, reason: not valid java name */
    public static final TextFieldValue m1013BasicTextField$lambda2(MutableState<TextFieldValue> mutableState) {
        MutableState<TextFieldValue> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BasicTextField$lambda-6, reason: not valid java name */
    public static final String m1015BasicTextField$lambda6(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x01d6, code lost:
    
        if (r10.changed(r50) != false) goto L152;
     */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0470  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function1, MutableInteractionSource interactionSource, Brush cursorBrush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean singleLine2;
        Modifier modifier2;
        MutableInteractionSource interactionSource2;
        int maxLines2;
        VisualTransformation visualTransformation2;
        SolidColor cursorBrush2;
        int maxLines3;
        VisualTransformation visualTransformation3;
        Function3 decorationBox;
        Modifier modifier3;
        MutableInteractionSource interactionSource3;
        Brush cursorBrush3;
        Function1 onTextLayout;
        KeyboardActions keyboardActions2;
        boolean enabled2;
        boolean readOnly2;
        TextStyle textStyle2;
        KeyboardOptions keyboardOptions2;
        boolean enabled3;
        int $dirty1;
        Object value$iv$iv;
        Object value$iv$iv2;
        Composer $composer2;
        boolean singleLine3;
        KeyboardOptions keyboardOptions3;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-560482651);
        ComposerKt.sourceInformation($composer3, "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)277@15970L39,284@16272L90,282@16210L688:BasicTextField.kt#423gt5");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer3.changed(onValueChange) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        int i4 = 2048;
        if (i3 != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= 196608;
        } else if (($changed & 458752) == 0) {
            $dirty |= $composer3.changed(textStyle) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer3.changed(keyboardOptions) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer3.changed(keyboardActions) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer3.changed(singleLine) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer3.changed(maxLines) ? 536870912 : 268435456;
        }
        int i11 = i & 1024;
        if (i11 != 0) {
            $dirty12 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty12 |= $composer3.changed(visualTransformation) ? 4 : 2;
        }
        int i12 = i & 2048;
        if (i12 != 0) {
            $dirty12 |= 48;
        } else if (($changed1 & SdkConfig.SDK_VERSION) == 0) {
            $dirty12 |= $composer3.changed(function1) ? 32 : 16;
        }
        int i13 = i & 4096;
        if (i13 != 0) {
            $dirty12 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty12 |= $composer3.changed(interactionSource) ? 256 : 128;
        }
        if (($changed1 & 7168) == 0) {
            if ((i & 8192) != 0) {
            }
            i4 = 1024;
            $dirty12 |= i4;
        }
        int i14 = i & 16384;
        if (i14 != 0) {
            $dirty12 |= 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty12 |= $composer3.changed(function3) ? 16384 : 8192;
        }
        if (($dirty & 1533916891) == 306783378 && (46811 & $dirty12) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            enabled2 = enabled;
            readOnly2 = readOnly;
            textStyle2 = textStyle;
            keyboardOptions3 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine3 = singleLine;
            maxLines3 = maxLines;
            visualTransformation3 = visualTransformation;
            onTextLayout = function1;
            interactionSource3 = interactionSource;
            cursorBrush3 = cursorBrush;
            decorationBox = function3;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i3 != 0 ? true : enabled;
                boolean readOnly3 = i5 != 0 ? false : readOnly;
                TextStyle textStyle3 = i6 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
                KeyboardOptions keyboardOptions4 = i7 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions3 = i8 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                boolean singleLine4 = i9 != 0 ? false : singleLine;
                int maxLines4 = i10 != 0 ? Integer.MAX_VALUE : maxLines;
                VisualTransformation visualTransformation4 = i11 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                Function1 onTextLayout2 = i12 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$6
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                } : function1;
                if (i13 != 0) {
                    singleLine2 = singleLine4;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    modifier2 = modifier4;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    singleLine2 = singleLine4;
                    modifier2 = modifier4;
                    interactionSource2 = interactionSource;
                }
                if ((i & 8192) != 0) {
                    maxLines2 = maxLines4;
                    visualTransformation2 = visualTransformation4;
                    cursorBrush2 = new SolidColor(Color.INSTANCE.m2022getBlack0d7_KjU(), null);
                    $dirty12 &= -7169;
                } else {
                    maxLines2 = maxLines4;
                    visualTransformation2 = visualTransformation4;
                    cursorBrush2 = cursorBrush;
                }
                if (i14 != 0) {
                    maxLines3 = maxLines2;
                    visualTransformation3 = visualTransformation2;
                    modifier3 = modifier2;
                    interactionSource3 = interactionSource2;
                    cursorBrush3 = cursorBrush2;
                    decorationBox = ComposableSingletons$BasicTextFieldKt.INSTANCE.m1026getLambda2$foundation_release();
                    onTextLayout = onTextLayout2;
                    keyboardActions2 = keyboardActions3;
                    enabled2 = enabled4;
                    readOnly2 = readOnly3;
                    textStyle2 = textStyle3;
                    keyboardOptions2 = keyboardOptions4;
                    enabled3 = singleLine2;
                    $dirty1 = $dirty12;
                } else {
                    maxLines3 = maxLines2;
                    visualTransformation3 = visualTransformation2;
                    decorationBox = function3;
                    modifier3 = modifier2;
                    interactionSource3 = interactionSource2;
                    cursorBrush3 = cursorBrush2;
                    onTextLayout = onTextLayout2;
                    keyboardActions2 = keyboardActions3;
                    enabled2 = enabled4;
                    readOnly2 = readOnly3;
                    textStyle2 = textStyle3;
                    keyboardOptions2 = keyboardOptions4;
                    enabled3 = singleLine2;
                    $dirty1 = $dirty12;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8192) != 0) {
                    modifier3 = modifier;
                    enabled2 = enabled;
                    readOnly2 = readOnly;
                    textStyle2 = textStyle;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    enabled3 = singleLine;
                    maxLines3 = maxLines;
                    visualTransformation3 = visualTransformation;
                    onTextLayout = function1;
                    interactionSource3 = interactionSource;
                    cursorBrush3 = cursorBrush;
                    decorationBox = function3;
                    $dirty1 = $dirty12 & (-7169);
                } else {
                    modifier3 = modifier;
                    enabled2 = enabled;
                    readOnly2 = readOnly;
                    textStyle2 = textStyle;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    enabled3 = singleLine;
                    maxLines3 = maxLines;
                    visualTransformation3 = visualTransformation;
                    onTextLayout = function1;
                    interactionSource3 = interactionSource;
                    cursorBrush3 = cursorBrush;
                    decorationBox = function3;
                    $dirty1 = $dirty12;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-560482651, $dirty, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:264)");
            }
            ImeOptions imeOptions$foundation_release = keyboardOptions2.toImeOptions$foundation_release(enabled3);
            boolean z = !enabled3;
            int i15 = enabled3 ? 1 : maxLines3;
            int i16 = ($dirty & 14) | ($dirty & SdkConfig.SDK_VERSION);
            $composer3.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer3, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer3.changed(value) | $composer3.changed(onValueChange);
            Object it$iv$iv2 = $composer3.rememberedValue();
            if (!invalid$iv$iv && it$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = it$iv$iv2;
                $composer3.endReplaceableGroup();
                int $dirty2 = $dirty;
                int i17 = ($dirty2 & 14) | ($dirty2 & 896) | (($dirty2 >> 6) & 7168) | (($dirty1 << 12) & 57344) | (($dirty1 << 12) & 458752) | (($dirty1 << 12) & 3670016) | (29360128 & ($dirty1 << 12));
                int i18 = (($dirty2 >> 18) & SdkConfig.SDK_VERSION) | (($dirty2 >> 3) & 896) | (($dirty2 >> 3) & 7168) | ($dirty1 & 57344);
                int $dirty13 = i15;
                $composer2 = $composer3;
                singleLine3 = enabled3;
                keyboardOptions3 = keyboardOptions2;
                CoreTextFieldKt.CoreTextField(value, (Function1) value$iv$iv2, modifier3, textStyle2, visualTransformation3, onTextLayout, interactionSource3, cursorBrush3, z, $dirty13, imeOptions$foundation_release, keyboardActions2, enabled2, readOnly2, decorationBox, $composer2, i17, i18, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            value$iv$iv2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                    invoke2(textFieldValue);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextFieldValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (!Intrinsics.areEqual(TextFieldValue.this, it)) {
                        onValueChange.invoke(it);
                    }
                }
            };
            $composer3.updateRememberedValue(value$iv$iv2);
            $composer3.endReplaceableGroup();
            int $dirty22 = $dirty;
            int i172 = ($dirty22 & 14) | ($dirty22 & 896) | (($dirty22 >> 6) & 7168) | (($dirty1 << 12) & 57344) | (($dirty1 << 12) & 458752) | (($dirty1 << 12) & 3670016) | (29360128 & ($dirty1 << 12));
            int i182 = (($dirty22 >> 18) & SdkConfig.SDK_VERSION) | (($dirty22 >> 3) & 896) | (($dirty22 >> 3) & 7168) | ($dirty1 & 57344);
            int $dirty132 = i15;
            $composer2 = $composer3;
            singleLine3 = enabled3;
            keyboardOptions3 = keyboardOptions2;
            CoreTextFieldKt.CoreTextField(value, (Function1) value$iv$iv2, modifier3, textStyle2, visualTransformation3, onTextLayout, interactionSource3, cursorBrush3, z, $dirty132, imeOptions$foundation_release, keyboardActions2, enabled2, readOnly2, decorationBox, $composer2, i172, i182, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final boolean z2 = enabled2;
        final boolean z3 = readOnly2;
        final TextStyle textStyle4 = textStyle2;
        final KeyboardOptions keyboardOptions5 = keyboardOptions3;
        final KeyboardActions keyboardActions4 = keyboardActions2;
        final boolean z4 = singleLine3;
        final int i19 = maxLines3;
        final VisualTransformation visualTransformation5 = visualTransformation3;
        final Function1 function12 = onTextLayout;
        final MutableInteractionSource mutableInteractionSource = interactionSource3;
        final Brush brush = cursorBrush3;
        final Function3 function32 = decorationBox;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$9
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

            public final void invoke(Composer composer, int i20) {
                BasicTextFieldKt.BasicTextField(TextFieldValue.this, onValueChange, modifier5, z2, z3, textStyle4, keyboardOptions5, keyboardActions4, z4, i19, visualTransformation5, function12, mutableInteractionSource, brush, function32, composer, $changed | 1, $changed1, i);
            }
        });
    }
}
