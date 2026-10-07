package androidx.compose.foundation.text;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.DrawModifierKt;
import androidx.compose.p000ui.focus.FocusManager;
import androidx.compose.p000ui.focus.FocusRequester;
import androidx.compose.p000ui.focus.FocusState;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.graphics.Brush;
import androidx.compose.p000ui.graphics.Canvas;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.SolidColor;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.hapticfeedback.HapticFeedback;
import androidx.compose.p000ui.input.key.KeyEvent;
import androidx.compose.p000ui.input.key.KeyInputModifierKt;
import androidx.compose.p000ui.input.pointer.PointerIconKt;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p000ui.layout.AlignmentLineKt;
import androidx.compose.p000ui.layout.IntrinsicMeasurable;
import androidx.compose.p000ui.layout.IntrinsicMeasureScope;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.ClipboardManager;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.TextToolbar;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.text.AnnotatedString;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.p000ui.text.TextRange;
import androidx.compose.p000ui.text.TextRangeKt;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.font.FontFamily;
import androidx.compose.p000ui.text.input.ImeOptions;
import androidx.compose.p000ui.text.input.OffsetMapping;
import androidx.compose.p000ui.text.input.PasswordVisualTransformation;
import androidx.compose.p000ui.text.input.TextFieldValue;
import androidx.compose.p000ui.text.input.TextInputService;
import androidx.compose.p000ui.text.input.TextInputSession;
import androidx.compose.p000ui.text.input.TransformedText;
import androidx.compose.p000ui.text.input.VisualTransformation;
import androidx.compose.p000ui.text.style.ResolvedTextDirection;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.health.platform.client.SdkConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CoreTextField.kt */
@Metadata(m286d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aä\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u001323\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0001¢\u0006\u0002\u0010\"\u001a0\u0010#\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%2\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001eH\u0003¢\u0006\u0002\u0010'\u001a\u001d\u0010(\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010*\u001a\u0015\u0010+\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010,\u001a(\u0010-\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a\u0010\u00102\u001a\u00020\u00012\u0006\u00100\u001a\u000201H\u0002\u001a \u00103\u001a\u00020\u00012\u0006\u00100\u001a\u0002012\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0013H\u0002\u001a5\u00107\u001a\u00020\u0001*\u0002082\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020=H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010>\u001a\u001c\u0010?\u001a\u00020\u0007*\u00020\u00072\u0006\u00100\u001a\u0002012\u0006\u0010$\u001a\u00020%H\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006@"}, m287d2 = {"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "notifyTextInputServiceOnFocusChange", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "state", "Landroidx/compose/foundation/text/TextFieldState;", "onBlur", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewKeyEventToDeselectOnBack", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class CoreTextFieldKt {
    /* JADX WARN: Code restructure failed: missing block: B:162:0x04d5, code lost:
    
        if (r2 == null) goto L267;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0620  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x06e5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x073d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0782 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0797  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x085c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x08a5  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x08f2  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0904  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x095f  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x090f  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x08a8  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x07c9  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0747  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0703  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x062f  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0562  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x04d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CoreTextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, TextStyle textStyle, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function1, MutableInteractionSource interactionSource, Brush cursorBrush, boolean softWrap, int maxLines, ImeOptions imeOptions, KeyboardActions keyboardActions, boolean enabled, boolean readOnly, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        SolidColor cursorBrush2;
        ImeOptions imeOptions2;
        Modifier modifier3;
        Function3 decorationBox;
        boolean softWrap2;
        Brush cursorBrush3;
        KeyboardActions keyboardActions2;
        boolean readOnly2;
        TextStyle textStyle2;
        ImeOptions imeOptions3;
        VisualTransformation visualTransformation2;
        Function1 onTextLayout;
        MutableInteractionSource interactionSource2;
        int $dirty1;
        int maxLines2;
        final boolean readOnly3;
        int $dirty;
        TextInputService textInputService;
        int $dirty12;
        TextFieldScrollerPosition scrollerPosition;
        boolean invalid$iv$iv;
        Object it$iv$iv;
        TextRange composition;
        TextFieldScrollerPosition scrollerPosition2;
        int $dirty2;
        Object it$iv$iv2;
        Object value$iv$iv;
        Object value$iv$iv2;
        final TextFieldState state;
        Object value$iv$iv3;
        Modifier modifier4;
        Object value$iv$iv4;
        Object it$iv$iv$iv;
        Object value$iv$iv$iv;
        Object it$iv$iv3;
        Object value$iv$iv5;
        TextInputService textInputService2;
        final FocusRequester focusRequester;
        boolean z;
        Modifier selectionModifier;
        boolean z2;
        boolean enabled2;
        final int maxLines3;
        ImeOptions imeOptions4;
        Composer $composer2;
        boolean enabled3;
        VisualTransformation visualTransformation3;
        Modifier modifier5;
        MutableInteractionSource interactionSource3;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(109313709);
        ComposerKt.sourceInformation($composer3, "C(CoreTextField)P(13,9,7,12,14,8,4!1,11,6,3,5,2,10)199@11067L7,200@11128L7,201@11196L7,202@11261L7,210@11570L42,207@11477L135,213@11653L268,225@12226L21,226@12264L324,254@12987L26,257@13073L51,263@13376L7,264@13427L7,265@13484L7,269@13595L24,270@13653L37,492@21995L86,496@22087L515,542@23735L4354:CoreTextField.kt#423gt5");
        int $dirty3 = $changed;
        int $dirty13 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty3 |= $composer3.changed(onValueChange) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty3 |= $composer3.changed(textStyle) ? 2048 : 1024;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty3 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty3 |= $composer3.changed(visualTransformation) ? 16384 : 8192;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty3 |= 196608;
        } else if (($changed & 458752) == 0) {
            $dirty3 |= $composer3.changed(function1) ? 131072 : 65536;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty3 |= $composer3.changed(interactionSource) ? 1048576 : 524288;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0 && $composer3.changed(cursorBrush)) {
                i3 = 8388608;
                $dirty3 |= i3;
            }
            i3 = 4194304;
            $dirty3 |= i3;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty3 |= $composer3.changed(softWrap) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty3 |= $composer3.changed(maxLines) ? 536870912 : 268435456;
        }
        if (($changed1 & 14) == 0) {
            if ((i & 1024) == 0 && $composer3.changed(imeOptions)) {
                i2 = 4;
                $dirty13 |= i2;
            }
            i2 = 2;
            $dirty13 |= i2;
        }
        int i11 = i & 2048;
        if (i11 != 0) {
            $dirty13 |= 48;
        } else if (($changed1 & SdkConfig.SDK_VERSION) == 0) {
            $dirty13 |= $composer3.changed(keyboardActions) ? 32 : 16;
        }
        int i12 = i & 4096;
        if (i12 != 0) {
            $dirty13 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty13 |= $composer3.changed(enabled) ? 256 : 128;
        }
        int i13 = i & 8192;
        if (i13 != 0) {
            $dirty13 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty13 |= $composer3.changed(readOnly) ? 2048 : 1024;
        }
        int i14 = i & 16384;
        if (i14 != 0) {
            $dirty13 |= 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty13 |= $composer3.changed(function3) ? 16384 : 8192;
        }
        if (($dirty3 & 1533916891) == 306783378 && (46811 & $dirty13) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier5 = modifier;
            textStyle2 = textStyle;
            visualTransformation3 = visualTransformation;
            onTextLayout = function1;
            interactionSource3 = interactionSource;
            cursorBrush3 = cursorBrush;
            softWrap2 = softWrap;
            maxLines3 = maxLines;
            imeOptions4 = imeOptions;
            keyboardActions2 = keyboardActions;
            enabled3 = enabled;
            readOnly2 = readOnly;
            decorationBox = function3;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier6 = i4 != 0 ? Modifier.INSTANCE : modifier;
                TextStyle textStyle3 = i5 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
                VisualTransformation visualTransformation4 = i6 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                Function1 onTextLayout2 = i7 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1
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
                MutableInteractionSource interactionSource4 = i8 != 0 ? null : interactionSource;
                if ((i & 128) != 0) {
                    modifier2 = modifier6;
                    cursorBrush2 = new SolidColor(Color.INSTANCE.m2032getUnspecified0d7_KjU(), null);
                    $dirty3 &= -29360129;
                } else {
                    modifier2 = modifier6;
                    cursorBrush2 = cursorBrush;
                }
                boolean softWrap3 = i9 != 0 ? true : softWrap;
                int maxLines4 = i10 != 0 ? Integer.MAX_VALUE : maxLines;
                if ((i & 1024) != 0) {
                    imeOptions2 = ImeOptions.INSTANCE.getDefault();
                    $dirty13 &= -15;
                } else {
                    imeOptions2 = imeOptions;
                }
                KeyboardActions keyboardActions3 = i11 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                boolean enabled4 = i12 != 0 ? true : enabled;
                boolean readOnly4 = i13 != 0 ? false : readOnly;
                if (i14 != 0) {
                    modifier3 = modifier2;
                    softWrap2 = softWrap3;
                    cursorBrush3 = cursorBrush2;
                    keyboardActions2 = keyboardActions3;
                    readOnly2 = readOnly4;
                    decorationBox = ComposableSingletons$CoreTextFieldKt.INSTANCE.m1028getLambda1$foundation_release();
                    textStyle2 = textStyle3;
                    imeOptions3 = imeOptions2;
                    visualTransformation2 = visualTransformation4;
                    onTextLayout = onTextLayout2;
                    interactionSource2 = interactionSource4;
                    $dirty1 = $dirty13;
                    maxLines2 = maxLines4;
                    readOnly3 = enabled4;
                    $dirty = $dirty3;
                } else {
                    modifier3 = modifier2;
                    decorationBox = function3;
                    softWrap2 = softWrap3;
                    cursorBrush3 = cursorBrush2;
                    keyboardActions2 = keyboardActions3;
                    readOnly2 = readOnly4;
                    textStyle2 = textStyle3;
                    imeOptions3 = imeOptions2;
                    visualTransformation2 = visualTransformation4;
                    onTextLayout = onTextLayout2;
                    interactionSource2 = interactionSource4;
                    $dirty1 = $dirty13;
                    maxLines2 = maxLines4;
                    readOnly3 = enabled4;
                    $dirty = $dirty3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                if ((i & 1024) != 0) {
                    $dirty13 &= -15;
                }
                modifier3 = modifier;
                textStyle2 = textStyle;
                visualTransformation2 = visualTransformation;
                onTextLayout = function1;
                interactionSource2 = interactionSource;
                cursorBrush3 = cursorBrush;
                softWrap2 = softWrap;
                maxLines2 = maxLines;
                imeOptions3 = imeOptions;
                keyboardActions2 = keyboardActions;
                readOnly3 = enabled;
                readOnly2 = readOnly;
                decorationBox = function3;
                $dirty = $dirty3;
                $dirty1 = $dirty13;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(109313709, $dirty, $dirty1, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:176)");
            }
            FocusRequester focusRequester2 = new FocusRequester();
            $composer3.startReplaceableGroup(-55013261);
            ComposerKt.sourceInformation($composer3, "198@11028L7");
            if (!readOnly3 || readOnly2) {
                textInputService = null;
            } else {
                ProvidableCompositionLocal<TextInputService> localTextInputService = CompositionLocalsKt.getLocalTextInputService();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = $composer3.consume(localTextInputService);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                textInputService = (TextInputService) consume;
            }
            $composer3.endReplaceableGroup();
            final TextInputService textInputService3 = textInputService;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Density density = (Density) consume2;
            ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(localFontFamilyResolver);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            FontFamily.Resolver fontFamilyResolver = (FontFamily.Resolver) consume3;
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer3.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            long selectionBackgroundColor = ((SelectionColors) consume4).getSelectionBackgroundColor();
            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer3.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            FocusManager focusManager = (FocusManager) consume5;
            boolean singleLine = maxLines2 == 1 && !softWrap2 && imeOptions3.getSingleLine();
            final Orientation orientation = singleLine ? Orientation.Horizontal : Orientation.Vertical;
            Object[] objArr = {orientation};
            Saver<TextFieldScrollerPosition, Object> saver = TextFieldScrollerPosition.INSTANCE.getSaver();
            $composer3.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer3, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv2 = $composer3.changed(orientation);
            Object value$iv$iv6 = $composer3.rememberedValue();
            if (invalid$iv$iv2) {
                $dirty12 = $dirty1;
            } else {
                $dirty12 = $dirty1;
                if (value$iv$iv6 != Composer.INSTANCE.getEmpty()) {
                    $composer3.endReplaceableGroup();
                    scrollerPosition = (TextFieldScrollerPosition) RememberSaveableKt.m1652rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) value$iv$iv6, $composer3, 72, 4);
                    int i15 = ($dirty & 14) | (($dirty >> 9) & SdkConfig.SDK_VERSION);
                    $composer3.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation($composer3, "C(remember)P(1,2):Composables.kt#9igjgp");
                    invalid$iv$iv = $composer3.changed(value) | $composer3.changed(visualTransformation2);
                    it$iv$iv = $composer3.rememberedValue();
                    if (!invalid$iv$iv && it$iv$iv != Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = it$iv$iv;
                        scrollerPosition2 = scrollerPosition;
                        $dirty2 = $dirty;
                        $composer3.endReplaceableGroup();
                        final TransformedText transformedText = (TransformedText) value$iv$iv;
                        AnnotatedString visualText = transformedText.getText();
                        final OffsetMapping offsetMapping = transformedText.getOffsetMapping();
                        RecomposeScope scope = ComposablesKt.getCurrentRecomposeScope($composer3, 0);
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                        value$iv$iv2 = $composer3.rememberedValue();
                        int maxLines5 = maxLines2;
                        if (value$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                            value$iv$iv2 = new TextFieldState(new TextDelegate(visualText, textStyle2, 0, softWrap2, 0, density, fontFamilyResolver, null, 148, null), scope);
                            $composer3.updateRememberedValue(value$iv$iv2);
                        }
                        $composer3.endReplaceableGroup();
                        state = (TextFieldState) value$iv$iv2;
                        state.m1106updatefnh65Uc(value.getText(), visualText, textStyle2, softWrap2, density, fontFamilyResolver, onValueChange, keyboardActions2, focusManager, selectionBackgroundColor);
                        state.getProcessor().reset(value, state.getInputSession());
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                        value$iv$iv3 = $composer3.rememberedValue();
                        if (value$iv$iv3 != Composer.INSTANCE.getEmpty()) {
                            modifier4 = modifier3;
                            value$iv$iv3 = new UndoManager(0, 1, null);
                            $composer3.updateRememberedValue(value$iv$iv3);
                        } else {
                            modifier4 = modifier3;
                        }
                        $composer3.endReplaceableGroup();
                        UndoManager undoManager = (UndoManager) value$iv$iv3;
                        UndoManager.snapshotIfNeeded$default(undoManager, value, 0L, 2, null);
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                        value$iv$iv4 = $composer3.rememberedValue();
                        if (value$iv$iv4 != Composer.INSTANCE.getEmpty()) {
                            value$iv$iv4 = new TextFieldSelectionManager(undoManager);
                            $composer3.updateRememberedValue(value$iv$iv4);
                        }
                        $composer3.endReplaceableGroup();
                        final TextFieldSelectionManager manager = (TextFieldSelectionManager) value$iv$iv4;
                        manager.setOffsetMapping$foundation_release(offsetMapping);
                        manager.setVisualTransformation$foundation_release(visualTransformation2);
                        manager.setOnValueChange$foundation_release(state.getOnValueChange());
                        manager.setState$foundation_release(state);
                        manager.setValue$foundation_release(value);
                        ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume6 = $composer3.consume(localClipboardManager);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        manager.setClipboardManager$foundation_release((ClipboardManager) consume6);
                        ProvidableCompositionLocal<TextToolbar> localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume7 = $composer3.consume(localTextToolbar);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        manager.setTextToolbar((TextToolbar) consume7);
                        ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume8 = $composer3.consume(localHapticFeedback);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        manager.setHapticFeedBack((HapticFeedback) consume8);
                        manager.setFocusRequester(focusRequester2);
                        manager.setEditable(!readOnly2);
                        $composer3.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation($composer3, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                        it$iv$iv$iv = $composer3.rememberedValue();
                        if (it$iv$iv$iv != Composer.INSTANCE.getEmpty()) {
                            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                            $composer3.updateRememberedValue(value$iv$iv$iv);
                        } else {
                            value$iv$iv$iv = it$iv$iv$iv;
                        }
                        $composer3.endReplaceableGroup();
                        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                        final CoroutineScope coroutineScope = wrapper$iv.getCoroutineScope();
                        $composer3.endReplaceableGroup();
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                        it$iv$iv3 = $composer3.rememberedValue();
                        if (it$iv$iv3 != Composer.INSTANCE.getEmpty()) {
                            value$iv$iv5 = BringIntoViewRequesterKt.BringIntoViewRequester();
                            $composer3.updateRememberedValue(value$iv$iv5);
                        } else {
                            value$iv$iv5 = it$iv$iv3;
                        }
                        $composer3.endReplaceableGroup();
                        final BringIntoViewRequester bringIntoViewRequester = (BringIntoViewRequester) value$iv$iv5;
                        final ImeOptions imeOptions5 = imeOptions3;
                        Modifier focusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(Modifier.INSTANCE, readOnly3, focusRequester2, interactionSource2, new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                                invoke2(focusState);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(FocusState it) {
                                TextLayoutResultProxy layoutResult;
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (TextFieldState.this.getHasFocus() == it.isFocused()) {
                                    return;
                                }
                                TextFieldState.this.setHasFocus(it.isFocused());
                                if (textInputService3 != null) {
                                    CoreTextFieldKt.notifyTextInputServiceOnFocusChange(textInputService3, TextFieldState.this, value, imeOptions5);
                                    if (it.isFocused() && (layoutResult = TextFieldState.this.getLayoutResult()) != null) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(bringIntoViewRequester, value, TextFieldState.this, layoutResult, offsetMapping, null), 3, null);
                                    }
                                }
                                if (!it.isFocused()) {
                                    TextFieldSelectionManager.m1203deselect_kEHs6E$foundation_release$default(manager, null, 1, null);
                                }
                            }
                        });
                        $composer3.startReplaceableGroup(-55008775);
                        ComposerKt.sourceInformation($composer3, "318@15664L163");
                        if (readOnly3 && !readOnly2) {
                            EffectsKt.DisposableEffect(state, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                    final TextFieldState textFieldState = TextFieldState.this;
                                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2$invoke$$inlined$onDispose$1
                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                        public void dispose() {
                                            if (TextFieldState.this.getHasFocus()) {
                                                CoreTextFieldKt.onBlur(TextFieldState.this);
                                            }
                                        }
                                    };
                                }
                            }, $composer3, 8);
                        }
                        $composer3.endReplaceableGroup();
                        if (TouchMode_androidKt.isInTouchMode()) {
                            textInputService2 = textInputService3;
                            focusRequester = focusRequester2;
                            z = false;
                            selectionModifier = PointerIconKt.pointerHoverIcon$default(TextFieldGestureModifiersKt.mouseDragGestureDetector(Modifier.INSTANCE, manager.getMouseSelectionObserver(), readOnly3), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                        } else {
                            Modifier selectionModifier2 = TextFieldGestureModifiersKt.longPressDragGestureFilter(Modifier.INSTANCE, manager.getTouchSelectionObserver(), readOnly3);
                            focusRequester = focusRequester2;
                            final boolean z3 = readOnly2;
                            selectionModifier = TextFieldPressGestureFilterKt.tapPressTextFieldModifier(Modifier.INSTANCE, interactionSource2, readOnly3, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                    m1029invokek4lQ0M(offset.getPackedValue());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                                public final void m1029invokek4lQ0M(long offset) {
                                    CoreTextFieldKt.tapToFocus(TextFieldState.this, focusRequester, !z3);
                                    if (TextFieldState.this.getHasFocus()) {
                                        if (TextFieldState.this.getHandleState() != HandleState.Selection) {
                                            TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                            if (layoutResult != null) {
                                                TextFieldState textFieldState = TextFieldState.this;
                                                TextFieldDelegate.INSTANCE.m1089setCursorOffsetULxng0E$foundation_release(offset, layoutResult, textFieldState.getProcessor(), offsetMapping, textFieldState.getOnValueChange());
                                                if (textFieldState.getTextDelegate().getText().length() > 0) {
                                                    textFieldState.setHandleState(HandleState.Cursor);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        manager.m1206deselect_kEHs6E$foundation_release(Offset.m1749boximpl(offset));
                                    }
                                }
                            }).then(selectionModifier2);
                            textInputService2 = textInputService3;
                            z = false;
                        }
                        Modifier pointerModifier = selectionModifier;
                        final Modifier drawModifier = DrawModifierKt.drawBehind(Modifier.INSTANCE, new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                invoke2(drawScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DrawScope drawBehind) {
                                Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
                                TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                if (layoutResult == null) {
                                    return;
                                }
                                TextFieldValue textFieldValue = value;
                                OffsetMapping offsetMapping2 = offsetMapping;
                                TextFieldState textFieldState = TextFieldState.this;
                                Canvas canvas = drawBehind.getDrawContext().getCanvas();
                                TextFieldDelegate.INSTANCE.draw$foundation_release(canvas, textFieldValue, offsetMapping2, layoutResult.getValue(), textFieldState.getSelectionPaint());
                            }
                        });
                        final Modifier onPositionedModifier = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.INSTANCE, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                invoke2(layoutCoordinates);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LayoutCoordinates it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                TextFieldState.this.setLayoutCoordinates(it);
                                if (readOnly3) {
                                    if (TextFieldState.this.getHandleState() == HandleState.Selection) {
                                        if (TextFieldState.this.getShowFloatingToolbar()) {
                                            manager.showSelectionToolbar$foundation_release();
                                        } else {
                                            manager.hideSelectionToolbar$foundation_release();
                                        }
                                        TextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(manager, true));
                                        TextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(manager, false));
                                    } else if (TextFieldState.this.getHandleState() == HandleState.Cursor) {
                                        TextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(manager, true));
                                    }
                                }
                                TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                if (layoutResult == null) {
                                    return;
                                }
                                layoutResult.setInnerTextFieldCoordinates(it);
                            }
                        });
                        final boolean isPassword = visualTransformation2 instanceof PasswordVisualTransformation;
                        MutableInteractionSource interactionSource5 = interactionSource2;
                        final VisualTransformation visualTransformation5 = visualTransformation2;
                        final ImeOptions imeOptions6 = imeOptions3;
                        z2 = z;
                        final TextInputService textInputService4 = textInputService2;
                        final FocusRequester focusRequester3 = focusRequester;
                        final boolean z4 = readOnly3;
                        final TextFieldScrollerPosition scrollerPosition3 = scrollerPosition2;
                        final int $dirty14 = $dirty12;
                        final boolean z5 = readOnly2;
                        enabled2 = readOnly3;
                        final ImeOptions imeOptions7 = imeOptions3;
                        Modifier semanticsModifier = SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                SemanticsPropertiesKt.m3843setImeAction4L7nppU(semantics, ImeOptions.this.getImeAction());
                                SemanticsPropertiesKt.setEditableText(semantics, transformedText.getText());
                                SemanticsPropertiesKt.m3846setTextSelectionRangeFDrldGo(semantics, value.getSelection());
                                if (!z4) {
                                    SemanticsPropertiesKt.disabled(semantics);
                                }
                                if (isPassword) {
                                    SemanticsPropertiesKt.password(semantics);
                                }
                                final TextFieldState textFieldState = state;
                                SemanticsPropertiesKt.getTextLayoutResult$default(semantics, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(List<TextLayoutResult> it) {
                                        boolean z6;
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        if (TextFieldState.this.getLayoutResult() != null) {
                                            TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                            Intrinsics.checkNotNull(layoutResult);
                                            it.add(layoutResult.getValue());
                                            z6 = true;
                                        } else {
                                            z6 = false;
                                        }
                                        return Boolean.valueOf(z6);
                                    }
                                }, 1, null);
                                final TextFieldState textFieldState2 = state;
                                SemanticsPropertiesKt.setText$default(semantics, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(AnnotatedString it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        TextFieldState.this.getOnValueChange().invoke(new TextFieldValue(it.getText(), TextRangeKt.TextRange(it.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                        return true;
                                    }
                                }, 1, null);
                                final OffsetMapping offsetMapping2 = offsetMapping;
                                final boolean z6 = z4;
                                final TextFieldValue textFieldValue = value;
                                final TextFieldSelectionManager textFieldSelectionManager = manager;
                                final TextFieldState textFieldState3 = state;
                                SemanticsPropertiesKt.setSelection$default(semantics, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                        return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                                    }

                                    public final Boolean invoke(int selectionStart, int selectionEnd, boolean traversalMode) {
                                        int start;
                                        int end;
                                        if (traversalMode) {
                                            start = selectionStart;
                                        } else {
                                            start = OffsetMapping.this.transformedToOriginal(selectionStart);
                                        }
                                        if (traversalMode) {
                                            end = selectionEnd;
                                        } else {
                                            end = OffsetMapping.this.transformedToOriginal(selectionEnd);
                                        }
                                        boolean z7 = false;
                                        if (z6 && (start != TextRange.m3957getStartimpl(textFieldValue.getSelection()) || end != TextRange.m3952getEndimpl(textFieldValue.getSelection()))) {
                                            if (RangesKt.coerceAtMost(start, end) >= 0 && RangesKt.coerceAtLeast(start, end) <= textFieldValue.getText().length()) {
                                                if (traversalMode || start == end) {
                                                    textFieldSelectionManager.exitSelectionMode$foundation_release();
                                                } else {
                                                    textFieldSelectionManager.enterSelectionMode$foundation_release();
                                                }
                                                textFieldState3.getOnValueChange().invoke(new TextFieldValue(textFieldValue.getText(), TextRangeKt.TextRange(start, end), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                z7 = true;
                                            } else {
                                                textFieldSelectionManager.exitSelectionMode$foundation_release();
                                            }
                                        }
                                        return Boolean.valueOf(z7);
                                    }
                                }, 1, null);
                                final TextFieldState textFieldState4 = state;
                                final FocusRequester focusRequester4 = focusRequester3;
                                final boolean z7 = z5;
                                SemanticsPropertiesKt.onClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        CoreTextFieldKt.tapToFocus(TextFieldState.this, focusRequester4, !z7);
                                        return true;
                                    }
                                }, 1, null);
                                final TextFieldSelectionManager textFieldSelectionManager2 = manager;
                                SemanticsPropertiesKt.onLongClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.5
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        TextFieldSelectionManager.this.enterSelectionMode$foundation_release();
                                        return true;
                                    }
                                }, 1, null);
                                if (!TextRange.m3951getCollapsedimpl(value.getSelection()) && !isPassword) {
                                    final TextFieldSelectionManager textFieldSelectionManager3 = manager;
                                    SemanticsPropertiesKt.copyText$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.6
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                            return true;
                                        }
                                    }, 1, null);
                                    if (z4 && !z5) {
                                        final TextFieldSelectionManager textFieldSelectionManager4 = manager;
                                        SemanticsPropertiesKt.cutText$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.7
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                TextFieldSelectionManager.this.cut$foundation_release();
                                                return true;
                                            }
                                        }, 1, null);
                                    }
                                }
                                if (z4 && !z5) {
                                    final TextFieldSelectionManager textFieldSelectionManager5 = manager;
                                    SemanticsPropertiesKt.pasteText$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.8
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            TextFieldSelectionManager.this.paste$foundation_release();
                                            return true;
                                        }
                                    }, 1, null);
                                }
                            }
                        });
                        final Modifier cursorModifier = TextFieldCursorKt.cursor(Modifier.INSTANCE, state, value, offsetMapping, cursorBrush3, (enabled2 || readOnly2) ? z2 : true);
                        EffectsKt.DisposableEffect(manager, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                final TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                                    }
                                };
                            }
                        }, $composer3, 8);
                        EffectsKt.DisposableEffect(imeOptions7, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                if (TextInputService.this != null && state.getHasFocus()) {
                                    state.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(TextInputService.this, value, state.getProcessor(), imeOptions7, state.getOnValueChange(), state.getOnImeActionPerformed()));
                                }
                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                    }
                                };
                            }
                        }, $composer3, $dirty14 & 14);
                        Modifier.Companion companion = Modifier.INSTANCE;
                        Function1<TextFieldValue, Unit> onValueChange2 = state.getOnValueChange();
                        boolean z6 = !readOnly2;
                        boolean z7 = maxLines5 != 1 ? true : z2;
                        maxLines3 = maxLines5;
                        imeOptions4 = imeOptions7;
                        Modifier textKeyInputModifier = TextFieldKeyInputKt.textFieldKeyInput(companion, state, manager, value, onValueChange2, z6, z7, offsetMapping, undoManager);
                        Modifier modifier7 = modifier4;
                        Modifier decorationBoxModifier = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(modifier7.then(focusModifier), state, manager).then(textKeyInputModifier), scrollerPosition3, interactionSource5, enabled2).then(pointerModifier).then(semanticsModifier), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                invoke2(layoutCoordinates);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LayoutCoordinates it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                if (layoutResult == null) {
                                    return;
                                }
                                layoutResult.setDecorationBoxCoordinates(it);
                            }
                        });
                        if (enabled2 && state.getHasFocus() && TouchMode_androidKt.isInTouchMode()) {
                            z2 = true;
                        }
                        final boolean showHandleAndMagnifier = z2;
                        final Modifier magnifierModifier = !showHandleAndMagnifier ? TextFieldSelectionManager_androidKt.textFieldMagnifier(Modifier.INSTANCE, manager) : Modifier.INSTANCE;
                        $composer2 = $composer3;
                        enabled3 = enabled2;
                        final Function3 function32 = decorationBox;
                        visualTransformation3 = visualTransformation5;
                        modifier5 = modifier7;
                        final TextStyle textStyle4 = textStyle2;
                        final boolean z8 = readOnly2;
                        final Function1 function12 = onTextLayout;
                        CoreTextFieldRootBox(decorationBoxModifier, manager, ComposableLambdaKt.composableLambda($composer2, -1885146845, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
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

                            public final void invoke(Composer $composer4, int $changed2) {
                                ComposerKt.sourceInformation($composer4, "C543@23798L4285:CoreTextField.kt#423gt5");
                                if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1885146845, $changed2, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:542)");
                                    }
                                    Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function33 = function32;
                                    final TextFieldState textFieldState = state;
                                    final int i16 = maxLines3;
                                    final TextStyle textStyle5 = textStyle4;
                                    final TextFieldScrollerPosition textFieldScrollerPosition = scrollerPosition3;
                                    final TextFieldValue textFieldValue = value;
                                    final VisualTransformation visualTransformation6 = visualTransformation5;
                                    final Modifier modifier8 = cursorModifier;
                                    final Modifier modifier9 = drawModifier;
                                    final Modifier modifier10 = onPositionedModifier;
                                    final Modifier modifier11 = magnifierModifier;
                                    final BringIntoViewRequester bringIntoViewRequester2 = bringIntoViewRequester;
                                    final TextFieldSelectionManager textFieldSelectionManager = manager;
                                    final boolean z9 = showHandleAndMagnifier;
                                    final boolean z10 = z8;
                                    final Function1<TextLayoutResult, Unit> function13 = function12;
                                    final Density density2 = density;
                                    function33.invoke(ComposableLambdaKt.composableLambda($composer4, 207445534, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
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

                                        public final void invoke(Composer $composer5, int $changed3) {
                                            ComposerKt.sourceInformation($composer5, "C564@24781L3292:CoreTextField.kt#423gt5");
                                            if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(207445534, $changed3, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:543)");
                                                }
                                                Modifier maxLinesHeight = MaxLinesHeightModifierKt.maxLinesHeight(SizeKt.m788heightInVpY3zN4$default(Modifier.INSTANCE, TextFieldState.this.m1104getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), i16, textStyle5);
                                                TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                                                TextFieldValue textFieldValue2 = textFieldValue;
                                                VisualTransformation visualTransformation7 = visualTransformation6;
                                                final TextFieldState textFieldState2 = TextFieldState.this;
                                                Modifier coreTextFieldModifier = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(maxLinesHeight, textFieldScrollerPosition2, textFieldValue2, visualTransformation7, new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final TextLayoutResultProxy invoke() {
                                                        return TextFieldState.this.getLayoutResult();
                                                    }
                                                }).then(modifier8).then(modifier9), textStyle5).then(modifier10).then(modifier11), bringIntoViewRequester2);
                                                final TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                                final TextFieldState textFieldState3 = TextFieldState.this;
                                                final boolean z11 = z9;
                                                final boolean z12 = z10;
                                                final Function1<TextLayoutResult, Unit> function14 = function13;
                                                final Density density3 = density2;
                                                final int i17 = i16;
                                                SimpleLayoutKt.SimpleLayout(coreTextFieldModifier, ComposableLambdaKt.composableLambda($composer5, 19580180, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
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

                                                    /* JADX WARN: Removed duplicated region for block: B:40:0x0188  */
                                                    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
                                                    /*
                                                        Code decompiled incorrectly, please refer to instructions dump.
                                                    */
                                                    public final void invoke(Composer $composer6, int $changed4) {
                                                        boolean z13;
                                                        ComposerKt.sourceInformation($composer6, "C565@24835L2620,617@27473L327,629@28001L40:CoreTextField.kt#423gt5");
                                                        if (($changed4 & 11) != 2 || !$composer6.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(19580180, $changed4, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:564)");
                                                            }
                                                            final TextFieldState textFieldState4 = textFieldState3;
                                                            final Function1<TextLayoutResult, Unit> function15 = function14;
                                                            final Density density4 = density3;
                                                            final int i18 = i17;
                                                            MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                                @Override // androidx.compose.p000ui.layout.MeasurePolicy
                                                                /* renamed from: measure-3p2s80s */
                                                                public MeasureResult mo331measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long constraints) {
                                                                    Intrinsics.checkNotNullParameter(measure, "$this$measure");
                                                                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                                                                    Snapshot.Companion this_$iv = Snapshot.INSTANCE;
                                                                    TextFieldState textFieldState5 = TextFieldState.this;
                                                                    Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
                                                                    try {
                                                                        Snapshot previous$iv$iv = snapshot$iv.makeCurrent();
                                                                        try {
                                                                            TextLayoutResultProxy layoutResult = textFieldState5.getLayoutResult();
                                                                            TextLayoutResult prevResult = layoutResult != null ? layoutResult.getValue() : null;
                                                                            snapshot$iv.dispose();
                                                                            Triple<Integer, Integer, TextLayoutResult> m1088layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m1088layout_EkL_Y$foundation_release(TextFieldState.this.getTextDelegate(), constraints, measure.getLayoutDirection(), prevResult);
                                                                            int width = m1088layout_EkL_Y$foundation_release.component1().intValue();
                                                                            int height = m1088layout_EkL_Y$foundation_release.component2().intValue();
                                                                            TextLayoutResult result = m1088layout_EkL_Y$foundation_release.component3();
                                                                            if (!Intrinsics.areEqual(prevResult, result)) {
                                                                                TextFieldState.this.setLayoutResult(new TextLayoutResultProxy(result));
                                                                                function15.invoke(result);
                                                                            }
                                                                            TextFieldState textFieldState6 = TextFieldState.this;
                                                                            Density $this$measure_3p2s80s_u24lambda_u2d1 = density4;
                                                                            textFieldState6.m1105setMinHeightForSingleLineField0680j_4($this$measure_3p2s80s_u24lambda_u2d1.mo645toDpu2uoSUM(i18 == 1 ? TextDelegateKt.ceilToIntPx(result.getLineBottom(0)) : 0));
                                                                            return measure.layout(width, height, MapsKt.mapOf(TuplesKt.m294to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(result.getFirstBaseline()))), TuplesKt.m294to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(result.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                                    invoke2(placementScope);
                                                                                    return Unit.INSTANCE;
                                                                                }

                                                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                                public final void invoke2(Placeable.PlacementScope layout) {
                                                                                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                                                                }
                                                                            });
                                                                        } finally {
                                                                            snapshot$iv.restoreCurrent(previous$iv$iv);
                                                                        }
                                                                    } catch (Throwable th) {
                                                                        snapshot$iv.dispose();
                                                                        throw th;
                                                                    }
                                                                }

                                                                @Override // androidx.compose.p000ui.layout.MeasurePolicy
                                                                public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
                                                                    Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
                                                                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                                                                    TextFieldState.this.getTextDelegate().layoutIntrinsics($this$maxIntrinsicWidth.getLayoutDirection());
                                                                    return TextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                                }
                                                            };
                                                            $composer6.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation($composer6, "C(Layout)P(!1,2)74@2907L7,75@2962L7,76@3021L7,77@3033L460:Layout.kt#80mrfh");
                                                            Modifier modifier$iv = Modifier.INSTANCE;
                                                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                                            ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object consume9 = $composer6.consume(localDensity2);
                                                            ComposerKt.sourceInformationMarkerEnd($composer6);
                                                            Density density$iv = (Density) consume9;
                                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                            ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object consume10 = $composer6.consume(localLayoutDirection);
                                                            ComposerKt.sourceInformationMarkerEnd($composer6);
                                                            LayoutDirection layoutDirection$iv = (LayoutDirection) consume10;
                                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                            ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                            Object consume11 = $composer6.consume(localViewConfiguration);
                                                            ComposerKt.sourceInformationMarkerEnd($composer6);
                                                            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume11;
                                                            Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier$iv);
                                                            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
                                                            if (!($composer6.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            $composer6.startReusableNode();
                                                            if ($composer6.getInserting()) {
                                                                $composer6.createNode(factory$iv$iv);
                                                            } else {
                                                                $composer6.useNode();
                                                            }
                                                            $composer6.disableReusing();
                                                            Composer $this$Layout_u24lambda_u2d0$iv = Updater.m1639constructorimpl($composer6);
                                                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, density$iv, ComposeUiNode.INSTANCE.getSetDensity());
                                                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, layoutDirection$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, viewConfiguration$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                            $composer6.enableReusing();
                                                            skippableUpdate$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer6)), $composer6, Integer.valueOf(($changed$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                                                            $composer6.startReplaceableGroup(2058660585);
                                                            $composer6.startReplaceableGroup(1714611517);
                                                            ComposerKt.sourceInformation($composer6, "C:CoreTextField.kt#423gt5");
                                                            if ((($changed$iv$iv >> 9) & 14 & 11) == 2 && $composer6.getSkipping()) {
                                                                $composer6.skipToGroupEnd();
                                                            }
                                                            $composer6.endReplaceableGroup();
                                                            $composer6.endReplaceableGroup();
                                                            $composer6.endNode();
                                                            $composer6.endReplaceableGroup();
                                                            TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                                                            if (textFieldState3.getHandleState() == HandleState.Selection && textFieldState3.getLayoutCoordinates() != null) {
                                                                LayoutCoordinates layoutCoordinates = textFieldState3.getLayoutCoordinates();
                                                                Intrinsics.checkNotNull(layoutCoordinates);
                                                                if (layoutCoordinates.isAttached() && z11) {
                                                                    z13 = true;
                                                                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager3, z13, $composer6, 8);
                                                                    if (textFieldState3.getHandleState() == HandleState.Cursor && !z12 && z11) {
                                                                        CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, $composer6, 8);
                                                                    }
                                                                    if (!ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                            }
                                                            z13 = false;
                                                            CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager3, z13, $composer6, 8);
                                                            if (textFieldState3.getHandleState() == HandleState.Cursor) {
                                                                CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, $composer6, 8);
                                                            }
                                                            if (!ComposerKt.isTraceInProgress()) {
                                                            }
                                                        } else {
                                                            $composer6.skipToGroupEnd();
                                                        }
                                                    }
                                                }), $composer5, 48, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer5.skipToGroupEnd();
                                        }
                                    }), $composer4, Integer.valueOf((($dirty14 >> 9) & SdkConfig.SDK_VERSION) | 6));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }), $composer2, 448);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interactionSource3 = interactionSource5;
                    }
                    TransformedText transformed = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation2, value.getText());
                    composition = value.getComposition();
                    if (composition == null) {
                        scrollerPosition2 = scrollerPosition;
                        $dirty2 = $dirty;
                        long it = composition.getPackedValue();
                        it$iv$iv2 = TextFieldDelegate.INSTANCE.m1087applyCompositionDecoration72CqOWE(it, transformed);
                    } else {
                        scrollerPosition2 = scrollerPosition;
                        $dirty2 = $dirty;
                    }
                    it$iv$iv2 = transformed;
                    value$iv$iv = it$iv$iv2;
                    $composer3.updateRememberedValue(value$iv$iv);
                    $composer3.endReplaceableGroup();
                    final TransformedText transformedText2 = (TransformedText) value$iv$iv;
                    AnnotatedString visualText2 = transformedText2.getText();
                    final OffsetMapping offsetMapping2 = transformedText2.getOffsetMapping();
                    RecomposeScope scope2 = ComposablesKt.getCurrentRecomposeScope($composer3, 0);
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    value$iv$iv2 = $composer3.rememberedValue();
                    int maxLines52 = maxLines2;
                    if (value$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                    }
                    $composer3.endReplaceableGroup();
                    state = (TextFieldState) value$iv$iv2;
                    state.m1106updatefnh65Uc(value.getText(), visualText2, textStyle2, softWrap2, density, fontFamilyResolver, onValueChange, keyboardActions2, focusManager, selectionBackgroundColor);
                    state.getProcessor().reset(value, state.getInputSession());
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    value$iv$iv3 = $composer3.rememberedValue();
                    if (value$iv$iv3 != Composer.INSTANCE.getEmpty()) {
                    }
                    $composer3.endReplaceableGroup();
                    UndoManager undoManager2 = (UndoManager) value$iv$iv3;
                    UndoManager.snapshotIfNeeded$default(undoManager2, value, 0L, 2, null);
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    value$iv$iv4 = $composer3.rememberedValue();
                    if (value$iv$iv4 != Composer.INSTANCE.getEmpty()) {
                    }
                    $composer3.endReplaceableGroup();
                    final TextFieldSelectionManager manager2 = (TextFieldSelectionManager) value$iv$iv4;
                    manager2.setOffsetMapping$foundation_release(offsetMapping2);
                    manager2.setVisualTransformation$foundation_release(visualTransformation2);
                    manager2.setOnValueChange$foundation_release(state.getOnValueChange());
                    manager2.setState$foundation_release(state);
                    manager2.setValue$foundation_release(value);
                    ProvidableCompositionLocal<ClipboardManager> localClipboardManager2 = CompositionLocalsKt.getLocalClipboardManager();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume62 = $composer3.consume(localClipboardManager2);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    manager2.setClipboardManager$foundation_release((ClipboardManager) consume62);
                    ProvidableCompositionLocal<TextToolbar> localTextToolbar2 = CompositionLocalsKt.getLocalTextToolbar();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume72 = $composer3.consume(localTextToolbar2);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    manager2.setTextToolbar((TextToolbar) consume72);
                    ProvidableCompositionLocal<HapticFeedback> localHapticFeedback2 = CompositionLocalsKt.getLocalHapticFeedback();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume82 = $composer3.consume(localHapticFeedback2);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    manager2.setHapticFeedBack((HapticFeedback) consume82);
                    manager2.setFocusRequester(focusRequester2);
                    manager2.setEditable(!readOnly2);
                    $composer3.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation($composer3, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    it$iv$iv$iv = $composer3.rememberedValue();
                    if (it$iv$iv$iv != Composer.INSTANCE.getEmpty()) {
                    }
                    $composer3.endReplaceableGroup();
                    CompositionScopedCoroutineScopeCanceller wrapper$iv2 = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                    final CoroutineScope coroutineScope2 = wrapper$iv2.getCoroutineScope();
                    $composer3.endReplaceableGroup();
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    it$iv$iv3 = $composer3.rememberedValue();
                    if (it$iv$iv3 != Composer.INSTANCE.getEmpty()) {
                    }
                    $composer3.endReplaceableGroup();
                    final BringIntoViewRequester bringIntoViewRequester2 = (BringIntoViewRequester) value$iv$iv5;
                    final ImeOptions imeOptions52 = imeOptions3;
                    Modifier focusModifier2 = TextFieldGestureModifiersKt.textFieldFocusModifier(Modifier.INSTANCE, readOnly3, focusRequester2, interactionSource2, new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                            invoke2(focusState);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(FocusState it2) {
                            TextLayoutResultProxy layoutResult;
                            Intrinsics.checkNotNullParameter(it2, "it");
                            if (TextFieldState.this.getHasFocus() == it2.isFocused()) {
                                return;
                            }
                            TextFieldState.this.setHasFocus(it2.isFocused());
                            if (textInputService3 != null) {
                                CoreTextFieldKt.notifyTextInputServiceOnFocusChange(textInputService3, TextFieldState.this, value, imeOptions52);
                                if (it2.isFocused() && (layoutResult = TextFieldState.this.getLayoutResult()) != null) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(bringIntoViewRequester2, value, TextFieldState.this, layoutResult, offsetMapping2, null), 3, null);
                                }
                            }
                            if (!it2.isFocused()) {
                                TextFieldSelectionManager.m1203deselect_kEHs6E$foundation_release$default(manager2, null, 1, null);
                            }
                        }
                    });
                    $composer3.startReplaceableGroup(-55008775);
                    ComposerKt.sourceInformation($composer3, "318@15664L163");
                    if (readOnly3) {
                        EffectsKt.DisposableEffect(state, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                final TextFieldState textFieldState = TextFieldState.this;
                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        if (TextFieldState.this.getHasFocus()) {
                                            CoreTextFieldKt.onBlur(TextFieldState.this);
                                        }
                                    }
                                };
                            }
                        }, $composer3, 8);
                    }
                    $composer3.endReplaceableGroup();
                    if (TouchMode_androidKt.isInTouchMode()) {
                    }
                    Modifier pointerModifier2 = selectionModifier;
                    final Modifier drawModifier2 = DrawModifierKt.drawBehind(Modifier.INSTANCE, new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope drawBehind) {
                            Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
                            TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                            if (layoutResult == null) {
                                return;
                            }
                            TextFieldValue textFieldValue = value;
                            OffsetMapping offsetMapping22 = offsetMapping2;
                            TextFieldState textFieldState = TextFieldState.this;
                            Canvas canvas = drawBehind.getDrawContext().getCanvas();
                            TextFieldDelegate.INSTANCE.draw$foundation_release(canvas, textFieldValue, offsetMapping22, layoutResult.getValue(), textFieldState.getSelectionPaint());
                        }
                    });
                    final Modifier onPositionedModifier2 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.INSTANCE, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                            invoke2(layoutCoordinates);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LayoutCoordinates it2) {
                            Intrinsics.checkNotNullParameter(it2, "it");
                            TextFieldState.this.setLayoutCoordinates(it2);
                            if (readOnly3) {
                                if (TextFieldState.this.getHandleState() == HandleState.Selection) {
                                    if (TextFieldState.this.getShowFloatingToolbar()) {
                                        manager2.showSelectionToolbar$foundation_release();
                                    } else {
                                        manager2.hideSelectionToolbar$foundation_release();
                                    }
                                    TextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(manager2, true));
                                    TextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(manager2, false));
                                } else if (TextFieldState.this.getHandleState() == HandleState.Cursor) {
                                    TextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(manager2, true));
                                }
                            }
                            TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                            if (layoutResult == null) {
                                return;
                            }
                            layoutResult.setInnerTextFieldCoordinates(it2);
                        }
                    });
                    final boolean isPassword2 = visualTransformation2 instanceof PasswordVisualTransformation;
                    MutableInteractionSource interactionSource52 = interactionSource2;
                    final VisualTransformation visualTransformation52 = visualTransformation2;
                    final ImeOptions imeOptions62 = imeOptions3;
                    z2 = z;
                    final TextInputService textInputService42 = textInputService2;
                    final FocusRequester focusRequester32 = focusRequester;
                    final boolean z42 = readOnly3;
                    final TextFieldScrollerPosition scrollerPosition32 = scrollerPosition2;
                    final int $dirty142 = $dirty12;
                    final boolean z52 = readOnly2;
                    enabled2 = readOnly3;
                    final ImeOptions imeOptions72 = imeOptions3;
                    Modifier semanticsModifier2 = SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            SemanticsPropertiesKt.m3843setImeAction4L7nppU(semantics, ImeOptions.this.getImeAction());
                            SemanticsPropertiesKt.setEditableText(semantics, transformedText2.getText());
                            SemanticsPropertiesKt.m3846setTextSelectionRangeFDrldGo(semantics, value.getSelection());
                            if (!z42) {
                                SemanticsPropertiesKt.disabled(semantics);
                            }
                            if (isPassword2) {
                                SemanticsPropertiesKt.password(semantics);
                            }
                            final TextFieldState textFieldState = state;
                            SemanticsPropertiesKt.getTextLayoutResult$default(semantics, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(List<TextLayoutResult> it2) {
                                    boolean z62;
                                    Intrinsics.checkNotNullParameter(it2, "it");
                                    if (TextFieldState.this.getLayoutResult() != null) {
                                        TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                        Intrinsics.checkNotNull(layoutResult);
                                        it2.add(layoutResult.getValue());
                                        z62 = true;
                                    } else {
                                        z62 = false;
                                    }
                                    return Boolean.valueOf(z62);
                                }
                            }, 1, null);
                            final TextFieldState textFieldState2 = state;
                            SemanticsPropertiesKt.setText$default(semantics, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(AnnotatedString it2) {
                                    Intrinsics.checkNotNullParameter(it2, "it");
                                    TextFieldState.this.getOnValueChange().invoke(new TextFieldValue(it2.getText(), TextRangeKt.TextRange(it2.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                    return true;
                                }
                            }, 1, null);
                            final OffsetMapping offsetMapping22 = offsetMapping2;
                            final boolean z62 = z42;
                            final TextFieldValue textFieldValue = value;
                            final TextFieldSelectionManager textFieldSelectionManager = manager2;
                            final TextFieldState textFieldState3 = state;
                            SemanticsPropertiesKt.setSelection$default(semantics, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                    return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                                }

                                public final Boolean invoke(int selectionStart, int selectionEnd, boolean traversalMode) {
                                    int start;
                                    int end;
                                    if (traversalMode) {
                                        start = selectionStart;
                                    } else {
                                        start = OffsetMapping.this.transformedToOriginal(selectionStart);
                                    }
                                    if (traversalMode) {
                                        end = selectionEnd;
                                    } else {
                                        end = OffsetMapping.this.transformedToOriginal(selectionEnd);
                                    }
                                    boolean z72 = false;
                                    if (z62 && (start != TextRange.m3957getStartimpl(textFieldValue.getSelection()) || end != TextRange.m3952getEndimpl(textFieldValue.getSelection()))) {
                                        if (RangesKt.coerceAtMost(start, end) >= 0 && RangesKt.coerceAtLeast(start, end) <= textFieldValue.getText().length()) {
                                            if (traversalMode || start == end) {
                                                textFieldSelectionManager.exitSelectionMode$foundation_release();
                                            } else {
                                                textFieldSelectionManager.enterSelectionMode$foundation_release();
                                            }
                                            textFieldState3.getOnValueChange().invoke(new TextFieldValue(textFieldValue.getText(), TextRangeKt.TextRange(start, end), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                            z72 = true;
                                        } else {
                                            textFieldSelectionManager.exitSelectionMode$foundation_release();
                                        }
                                    }
                                    return Boolean.valueOf(z72);
                                }
                            }, 1, null);
                            final TextFieldState textFieldState4 = state;
                            final FocusRequester focusRequester4 = focusRequester32;
                            final boolean z72 = z52;
                            SemanticsPropertiesKt.onClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    CoreTextFieldKt.tapToFocus(TextFieldState.this, focusRequester4, !z72);
                                    return true;
                                }
                            }, 1, null);
                            final TextFieldSelectionManager textFieldSelectionManager2 = manager2;
                            SemanticsPropertiesKt.onLongClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.5
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    TextFieldSelectionManager.this.enterSelectionMode$foundation_release();
                                    return true;
                                }
                            }, 1, null);
                            if (!TextRange.m3951getCollapsedimpl(value.getSelection()) && !isPassword2) {
                                final TextFieldSelectionManager textFieldSelectionManager3 = manager2;
                                SemanticsPropertiesKt.copyText$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.6
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                        return true;
                                    }
                                }, 1, null);
                                if (z42 && !z52) {
                                    final TextFieldSelectionManager textFieldSelectionManager4 = manager2;
                                    SemanticsPropertiesKt.cutText$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.7
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            TextFieldSelectionManager.this.cut$foundation_release();
                                            return true;
                                        }
                                    }, 1, null);
                                }
                            }
                            if (z42 && !z52) {
                                final TextFieldSelectionManager textFieldSelectionManager5 = manager2;
                                SemanticsPropertiesKt.pasteText$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.8
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        TextFieldSelectionManager.this.paste$foundation_release();
                                        return true;
                                    }
                                }, 1, null);
                            }
                        }
                    });
                    final Modifier cursorModifier2 = TextFieldCursorKt.cursor(Modifier.INSTANCE, state, value, offsetMapping2, cursorBrush3, (enabled2 || readOnly2) ? z2 : true);
                    EffectsKt.DisposableEffect(manager2, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                            final TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                                }
                            };
                        }
                    }, $composer3, 8);
                    EffectsKt.DisposableEffect(imeOptions72, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                            if (TextInputService.this != null && state.getHasFocus()) {
                                state.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(TextInputService.this, value, state.getProcessor(), imeOptions72, state.getOnValueChange(), state.getOnImeActionPerformed()));
                            }
                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                }
                            };
                        }
                    }, $composer3, $dirty142 & 14);
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    Function1<TextFieldValue, Unit> onValueChange22 = state.getOnValueChange();
                    boolean z62 = !readOnly2;
                    if (maxLines52 != 1) {
                    }
                    maxLines3 = maxLines52;
                    imeOptions4 = imeOptions72;
                    Modifier textKeyInputModifier2 = TextFieldKeyInputKt.textFieldKeyInput(companion2, state, manager2, value, onValueChange22, z62, z7, offsetMapping2, undoManager2);
                    Modifier modifier72 = modifier4;
                    Modifier decorationBoxModifier2 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(modifier72.then(focusModifier2), state, manager2).then(textKeyInputModifier2), scrollerPosition32, interactionSource52, enabled2).then(pointerModifier2).then(semanticsModifier2), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                            invoke2(layoutCoordinates);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LayoutCoordinates it2) {
                            Intrinsics.checkNotNullParameter(it2, "it");
                            TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                            if (layoutResult == null) {
                                return;
                            }
                            layoutResult.setDecorationBoxCoordinates(it2);
                        }
                    });
                    if (enabled2) {
                        z2 = true;
                    }
                    final boolean showHandleAndMagnifier2 = z2;
                    if (!showHandleAndMagnifier2) {
                    }
                    $composer2 = $composer3;
                    enabled3 = enabled2;
                    final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function322 = decorationBox;
                    visualTransformation3 = visualTransformation52;
                    modifier5 = modifier72;
                    final TextStyle textStyle42 = textStyle2;
                    final boolean z82 = readOnly2;
                    final Function1<? super TextLayoutResult, Unit> function122 = onTextLayout;
                    CoreTextFieldRootBox(decorationBoxModifier2, manager2, ComposableLambdaKt.composableLambda($composer2, -1885146845, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
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

                        public final void invoke(Composer $composer4, int $changed2) {
                            ComposerKt.sourceInformation($composer4, "C543@23798L4285:CoreTextField.kt#423gt5");
                            if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1885146845, $changed2, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:542)");
                                }
                                Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function33 = function322;
                                final TextFieldState textFieldState = state;
                                final int i16 = maxLines3;
                                final TextStyle textStyle5 = textStyle42;
                                final TextFieldScrollerPosition textFieldScrollerPosition = scrollerPosition32;
                                final TextFieldValue textFieldValue = value;
                                final VisualTransformation visualTransformation6 = visualTransformation52;
                                final Modifier modifier8 = cursorModifier2;
                                final Modifier modifier9 = drawModifier2;
                                final Modifier modifier10 = onPositionedModifier2;
                                final Modifier modifier11 = magnifierModifier;
                                final BringIntoViewRequester bringIntoViewRequester22 = bringIntoViewRequester2;
                                final TextFieldSelectionManager textFieldSelectionManager = manager2;
                                final boolean z9 = showHandleAndMagnifier2;
                                final boolean z10 = z82;
                                final Function1<? super TextLayoutResult, Unit> function13 = function122;
                                final Density density2 = density;
                                function33.invoke(ComposableLambdaKt.composableLambda($composer4, 207445534, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
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

                                    public final void invoke(Composer $composer5, int $changed3) {
                                        ComposerKt.sourceInformation($composer5, "C564@24781L3292:CoreTextField.kt#423gt5");
                                        if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(207445534, $changed3, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:543)");
                                            }
                                            Modifier maxLinesHeight = MaxLinesHeightModifierKt.maxLinesHeight(SizeKt.m788heightInVpY3zN4$default(Modifier.INSTANCE, TextFieldState.this.m1104getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), i16, textStyle5);
                                            TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                                            TextFieldValue textFieldValue2 = textFieldValue;
                                            VisualTransformation visualTransformation7 = visualTransformation6;
                                            final TextFieldState textFieldState2 = TextFieldState.this;
                                            Modifier coreTextFieldModifier = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(maxLinesHeight, textFieldScrollerPosition2, textFieldValue2, visualTransformation7, new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final TextLayoutResultProxy invoke() {
                                                    return TextFieldState.this.getLayoutResult();
                                                }
                                            }).then(modifier8).then(modifier9), textStyle5).then(modifier10).then(modifier11), bringIntoViewRequester22);
                                            final TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                            final TextFieldState textFieldState3 = TextFieldState.this;
                                            final boolean z11 = z9;
                                            final boolean z12 = z10;
                                            final Function1<? super TextLayoutResult, Unit> function14 = function13;
                                            final Density density3 = density2;
                                            final int i17 = i16;
                                            SimpleLayoutKt.SimpleLayout(coreTextFieldModifier, ComposableLambdaKt.composableLambda($composer5, 19580180, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
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

                                                /* JADX WARN: Removed duplicated region for block: B:40:0x0188  */
                                                /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
                                                /*
                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                */
                                                public final void invoke(Composer $composer6, int $changed4) {
                                                    boolean z13;
                                                    ComposerKt.sourceInformation($composer6, "C565@24835L2620,617@27473L327,629@28001L40:CoreTextField.kt#423gt5");
                                                    if (($changed4 & 11) != 2 || !$composer6.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(19580180, $changed4, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:564)");
                                                        }
                                                        final TextFieldState textFieldState4 = textFieldState3;
                                                        final Function1<? super TextLayoutResult, Unit> function15 = function14;
                                                        final Density density4 = density3;
                                                        final int i18 = i17;
                                                        MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                            @Override // androidx.compose.p000ui.layout.MeasurePolicy
                                                            /* renamed from: measure-3p2s80s */
                                                            public MeasureResult mo331measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long constraints) {
                                                                Intrinsics.checkNotNullParameter(measure, "$this$measure");
                                                                Intrinsics.checkNotNullParameter(measurables, "measurables");
                                                                Snapshot.Companion this_$iv = Snapshot.INSTANCE;
                                                                TextFieldState textFieldState5 = TextFieldState.this;
                                                                Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
                                                                try {
                                                                    Snapshot previous$iv$iv = snapshot$iv.makeCurrent();
                                                                    try {
                                                                        TextLayoutResultProxy layoutResult = textFieldState5.getLayoutResult();
                                                                        TextLayoutResult prevResult = layoutResult != null ? layoutResult.getValue() : null;
                                                                        snapshot$iv.dispose();
                                                                        Triple<Integer, Integer, TextLayoutResult> m1088layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m1088layout_EkL_Y$foundation_release(TextFieldState.this.getTextDelegate(), constraints, measure.getLayoutDirection(), prevResult);
                                                                        int width = m1088layout_EkL_Y$foundation_release.component1().intValue();
                                                                        int height = m1088layout_EkL_Y$foundation_release.component2().intValue();
                                                                        TextLayoutResult result = m1088layout_EkL_Y$foundation_release.component3();
                                                                        if (!Intrinsics.areEqual(prevResult, result)) {
                                                                            TextFieldState.this.setLayoutResult(new TextLayoutResultProxy(result));
                                                                            function15.invoke(result);
                                                                        }
                                                                        TextFieldState textFieldState6 = TextFieldState.this;
                                                                        Density $this$measure_3p2s80s_u24lambda_u2d1 = density4;
                                                                        textFieldState6.m1105setMinHeightForSingleLineField0680j_4($this$measure_3p2s80s_u24lambda_u2d1.mo645toDpu2uoSUM(i18 == 1 ? TextDelegateKt.ceilToIntPx(result.getLineBottom(0)) : 0));
                                                                        return measure.layout(width, height, MapsKt.mapOf(TuplesKt.m294to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(result.getFirstBaseline()))), TuplesKt.m294to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(result.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                                invoke2(placementScope);
                                                                                return Unit.INSTANCE;
                                                                            }

                                                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                            public final void invoke2(Placeable.PlacementScope layout) {
                                                                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                                                            }
                                                                        });
                                                                    } finally {
                                                                        snapshot$iv.restoreCurrent(previous$iv$iv);
                                                                    }
                                                                } catch (Throwable th) {
                                                                    snapshot$iv.dispose();
                                                                    throw th;
                                                                }
                                                            }

                                                            @Override // androidx.compose.p000ui.layout.MeasurePolicy
                                                            public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
                                                                Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
                                                                Intrinsics.checkNotNullParameter(measurables, "measurables");
                                                                TextFieldState.this.getTextDelegate().layoutIntrinsics($this$maxIntrinsicWidth.getLayoutDirection());
                                                                return TextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                            }
                                                        };
                                                        $composer6.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation($composer6, "C(Layout)P(!1,2)74@2907L7,75@2962L7,76@3021L7,77@3033L460:Layout.kt#80mrfh");
                                                        Modifier modifier$iv = Modifier.INSTANCE;
                                                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                                        ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object consume9 = $composer6.consume(localDensity2);
                                                        ComposerKt.sourceInformationMarkerEnd($composer6);
                                                        Density density$iv = (Density) consume9;
                                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                        ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object consume10 = $composer6.consume(localLayoutDirection);
                                                        ComposerKt.sourceInformationMarkerEnd($composer6);
                                                        LayoutDirection layoutDirection$iv = (LayoutDirection) consume10;
                                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                        ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                        Object consume11 = $composer6.consume(localViewConfiguration);
                                                        ComposerKt.sourceInformationMarkerEnd($composer6);
                                                        ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume11;
                                                        Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier$iv);
                                                        int $changed$iv$iv = ((0 << 9) & 7168) | 6;
                                                        if (!($composer6.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        $composer6.startReusableNode();
                                                        if ($composer6.getInserting()) {
                                                            $composer6.createNode(factory$iv$iv);
                                                        } else {
                                                            $composer6.useNode();
                                                        }
                                                        $composer6.disableReusing();
                                                        Composer $this$Layout_u24lambda_u2d0$iv = Updater.m1639constructorimpl($composer6);
                                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, density$iv, ComposeUiNode.INSTANCE.getSetDensity());
                                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, layoutDirection$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, viewConfiguration$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                        $composer6.enableReusing();
                                                        skippableUpdate$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer6)), $composer6, Integer.valueOf(($changed$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                                                        $composer6.startReplaceableGroup(2058660585);
                                                        $composer6.startReplaceableGroup(1714611517);
                                                        ComposerKt.sourceInformation($composer6, "C:CoreTextField.kt#423gt5");
                                                        if ((($changed$iv$iv >> 9) & 14 & 11) == 2 && $composer6.getSkipping()) {
                                                            $composer6.skipToGroupEnd();
                                                        }
                                                        $composer6.endReplaceableGroup();
                                                        $composer6.endReplaceableGroup();
                                                        $composer6.endNode();
                                                        $composer6.endReplaceableGroup();
                                                        TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                                                        if (textFieldState3.getHandleState() == HandleState.Selection && textFieldState3.getLayoutCoordinates() != null) {
                                                            LayoutCoordinates layoutCoordinates = textFieldState3.getLayoutCoordinates();
                                                            Intrinsics.checkNotNull(layoutCoordinates);
                                                            if (layoutCoordinates.isAttached() && z11) {
                                                                z13 = true;
                                                                CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager3, z13, $composer6, 8);
                                                                if (textFieldState3.getHandleState() == HandleState.Cursor && !z12 && z11) {
                                                                    CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, $composer6, 8);
                                                                }
                                                                if (!ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                        }
                                                        z13 = false;
                                                        CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager3, z13, $composer6, 8);
                                                        if (textFieldState3.getHandleState() == HandleState.Cursor) {
                                                            CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, $composer6, 8);
                                                        }
                                                        if (!ComposerKt.isTraceInProgress()) {
                                                        }
                                                    } else {
                                                        $composer6.skipToGroupEnd();
                                                    }
                                                }
                                            }), $composer5, 48, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), $composer4, Integer.valueOf((($dirty142 >> 9) & SdkConfig.SDK_VERSION) | 6));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer4.skipToGroupEnd();
                        }
                    }), $composer2, 448);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    interactionSource3 = interactionSource52;
                }
            }
            value$iv$iv6 = (Function0) new Function0<TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextFieldScrollerPosition invoke() {
                    return new TextFieldScrollerPosition(Orientation.this, 0.0f, 2, null);
                }
            };
            $composer3.updateRememberedValue(value$iv$iv6);
            $composer3.endReplaceableGroup();
            scrollerPosition = (TextFieldScrollerPosition) RememberSaveableKt.m1652rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) value$iv$iv6, $composer3, 72, 4);
            int i152 = ($dirty & 14) | (($dirty >> 9) & SdkConfig.SDK_VERSION);
            $composer3.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer3, "C(remember)P(1,2):Composables.kt#9igjgp");
            invalid$iv$iv = $composer3.changed(value) | $composer3.changed(visualTransformation2);
            it$iv$iv = $composer3.rememberedValue();
            if (!invalid$iv$iv) {
                value$iv$iv = it$iv$iv;
                scrollerPosition2 = scrollerPosition;
                $dirty2 = $dirty;
                $composer3.endReplaceableGroup();
                final TransformedText transformedText22 = (TransformedText) value$iv$iv;
                AnnotatedString visualText22 = transformedText22.getText();
                final OffsetMapping offsetMapping22 = transformedText22.getOffsetMapping();
                RecomposeScope scope22 = ComposablesKt.getCurrentRecomposeScope($composer3, 0);
                $composer3.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                value$iv$iv2 = $composer3.rememberedValue();
                int maxLines522 = maxLines2;
                if (value$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                }
                $composer3.endReplaceableGroup();
                state = (TextFieldState) value$iv$iv2;
                state.m1106updatefnh65Uc(value.getText(), visualText22, textStyle2, softWrap2, density, fontFamilyResolver, onValueChange, keyboardActions2, focusManager, selectionBackgroundColor);
                state.getProcessor().reset(value, state.getInputSession());
                $composer3.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                value$iv$iv3 = $composer3.rememberedValue();
                if (value$iv$iv3 != Composer.INSTANCE.getEmpty()) {
                }
                $composer3.endReplaceableGroup();
                UndoManager undoManager22 = (UndoManager) value$iv$iv3;
                UndoManager.snapshotIfNeeded$default(undoManager22, value, 0L, 2, null);
                $composer3.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                value$iv$iv4 = $composer3.rememberedValue();
                if (value$iv$iv4 != Composer.INSTANCE.getEmpty()) {
                }
                $composer3.endReplaceableGroup();
                final TextFieldSelectionManager manager22 = (TextFieldSelectionManager) value$iv$iv4;
                manager22.setOffsetMapping$foundation_release(offsetMapping22);
                manager22.setVisualTransformation$foundation_release(visualTransformation2);
                manager22.setOnValueChange$foundation_release(state.getOnValueChange());
                manager22.setState$foundation_release(state);
                manager22.setValue$foundation_release(value);
                ProvidableCompositionLocal<ClipboardManager> localClipboardManager22 = CompositionLocalsKt.getLocalClipboardManager();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume622 = $composer3.consume(localClipboardManager22);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                manager22.setClipboardManager$foundation_release((ClipboardManager) consume622);
                ProvidableCompositionLocal<TextToolbar> localTextToolbar22 = CompositionLocalsKt.getLocalTextToolbar();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume722 = $composer3.consume(localTextToolbar22);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                manager22.setTextToolbar((TextToolbar) consume722);
                ProvidableCompositionLocal<HapticFeedback> localHapticFeedback22 = CompositionLocalsKt.getLocalHapticFeedback();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume822 = $composer3.consume(localHapticFeedback22);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                manager22.setHapticFeedBack((HapticFeedback) consume822);
                manager22.setFocusRequester(focusRequester2);
                manager22.setEditable(!readOnly2);
                $composer3.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation($composer3, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                $composer3.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                it$iv$iv$iv = $composer3.rememberedValue();
                if (it$iv$iv$iv != Composer.INSTANCE.getEmpty()) {
                }
                $composer3.endReplaceableGroup();
                CompositionScopedCoroutineScopeCanceller wrapper$iv22 = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                final CoroutineScope coroutineScope22 = wrapper$iv22.getCoroutineScope();
                $composer3.endReplaceableGroup();
                $composer3.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                it$iv$iv3 = $composer3.rememberedValue();
                if (it$iv$iv3 != Composer.INSTANCE.getEmpty()) {
                }
                $composer3.endReplaceableGroup();
                final BringIntoViewRequester bringIntoViewRequester22 = (BringIntoViewRequester) value$iv$iv5;
                final ImeOptions imeOptions522 = imeOptions3;
                Modifier focusModifier22 = TextFieldGestureModifiersKt.textFieldFocusModifier(Modifier.INSTANCE, readOnly3, focusRequester2, interactionSource2, new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                        invoke2(focusState);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(FocusState it2) {
                        TextLayoutResultProxy layoutResult;
                        Intrinsics.checkNotNullParameter(it2, "it");
                        if (TextFieldState.this.getHasFocus() == it2.isFocused()) {
                            return;
                        }
                        TextFieldState.this.setHasFocus(it2.isFocused());
                        if (textInputService3 != null) {
                            CoreTextFieldKt.notifyTextInputServiceOnFocusChange(textInputService3, TextFieldState.this, value, imeOptions522);
                            if (it2.isFocused() && (layoutResult = TextFieldState.this.getLayoutResult()) != null) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(bringIntoViewRequester22, value, TextFieldState.this, layoutResult, offsetMapping22, null), 3, null);
                            }
                        }
                        if (!it2.isFocused()) {
                            TextFieldSelectionManager.m1203deselect_kEHs6E$foundation_release$default(manager22, null, 1, null);
                        }
                    }
                });
                $composer3.startReplaceableGroup(-55008775);
                ComposerKt.sourceInformation($composer3, "318@15664L163");
                if (readOnly3) {
                }
                $composer3.endReplaceableGroup();
                if (TouchMode_androidKt.isInTouchMode()) {
                }
                Modifier pointerModifier22 = selectionModifier;
                final Modifier drawModifier22 = DrawModifierKt.drawBehind(Modifier.INSTANCE, new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope drawBehind) {
                        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
                        TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                        if (layoutResult == null) {
                            return;
                        }
                        TextFieldValue textFieldValue = value;
                        OffsetMapping offsetMapping222 = offsetMapping22;
                        TextFieldState textFieldState = TextFieldState.this;
                        Canvas canvas = drawBehind.getDrawContext().getCanvas();
                        TextFieldDelegate.INSTANCE.draw$foundation_release(canvas, textFieldValue, offsetMapping222, layoutResult.getValue(), textFieldState.getSelectionPaint());
                    }
                });
                final Modifier onPositionedModifier22 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.INSTANCE, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutCoordinates it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        TextFieldState.this.setLayoutCoordinates(it2);
                        if (readOnly3) {
                            if (TextFieldState.this.getHandleState() == HandleState.Selection) {
                                if (TextFieldState.this.getShowFloatingToolbar()) {
                                    manager22.showSelectionToolbar$foundation_release();
                                } else {
                                    manager22.hideSelectionToolbar$foundation_release();
                                }
                                TextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(manager22, true));
                                TextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(manager22, false));
                            } else if (TextFieldState.this.getHandleState() == HandleState.Cursor) {
                                TextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(manager22, true));
                            }
                        }
                        TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                        if (layoutResult == null) {
                            return;
                        }
                        layoutResult.setInnerTextFieldCoordinates(it2);
                    }
                });
                final boolean isPassword22 = visualTransformation2 instanceof PasswordVisualTransformation;
                MutableInteractionSource interactionSource522 = interactionSource2;
                final VisualTransformation visualTransformation522 = visualTransformation2;
                final ImeOptions imeOptions622 = imeOptions3;
                z2 = z;
                final TextInputService textInputService422 = textInputService2;
                final FocusRequester focusRequester322 = focusRequester;
                final boolean z422 = readOnly3;
                final TextFieldScrollerPosition scrollerPosition322 = scrollerPosition2;
                final int $dirty1422 = $dirty12;
                final boolean z522 = readOnly2;
                enabled2 = readOnly3;
                final ImeOptions imeOptions722 = imeOptions3;
                Modifier semanticsModifier22 = SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        SemanticsPropertiesKt.m3843setImeAction4L7nppU(semantics, ImeOptions.this.getImeAction());
                        SemanticsPropertiesKt.setEditableText(semantics, transformedText22.getText());
                        SemanticsPropertiesKt.m3846setTextSelectionRangeFDrldGo(semantics, value.getSelection());
                        if (!z422) {
                            SemanticsPropertiesKt.disabled(semantics);
                        }
                        if (isPassword22) {
                            SemanticsPropertiesKt.password(semantics);
                        }
                        final TextFieldState textFieldState = state;
                        SemanticsPropertiesKt.getTextLayoutResult$default(semantics, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(List<TextLayoutResult> it2) {
                                boolean z622;
                                Intrinsics.checkNotNullParameter(it2, "it");
                                if (TextFieldState.this.getLayoutResult() != null) {
                                    TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                    Intrinsics.checkNotNull(layoutResult);
                                    it2.add(layoutResult.getValue());
                                    z622 = true;
                                } else {
                                    z622 = false;
                                }
                                return Boolean.valueOf(z622);
                            }
                        }, 1, null);
                        final TextFieldState textFieldState2 = state;
                        SemanticsPropertiesKt.setText$default(semantics, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(AnnotatedString it2) {
                                Intrinsics.checkNotNullParameter(it2, "it");
                                TextFieldState.this.getOnValueChange().invoke(new TextFieldValue(it2.getText(), TextRangeKt.TextRange(it2.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                return true;
                            }
                        }, 1, null);
                        final OffsetMapping offsetMapping222 = offsetMapping22;
                        final boolean z622 = z422;
                        final TextFieldValue textFieldValue = value;
                        final TextFieldSelectionManager textFieldSelectionManager = manager22;
                        final TextFieldState textFieldState3 = state;
                        SemanticsPropertiesKt.setSelection$default(semantics, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                            }

                            public final Boolean invoke(int selectionStart, int selectionEnd, boolean traversalMode) {
                                int start;
                                int end;
                                if (traversalMode) {
                                    start = selectionStart;
                                } else {
                                    start = OffsetMapping.this.transformedToOriginal(selectionStart);
                                }
                                if (traversalMode) {
                                    end = selectionEnd;
                                } else {
                                    end = OffsetMapping.this.transformedToOriginal(selectionEnd);
                                }
                                boolean z72 = false;
                                if (z622 && (start != TextRange.m3957getStartimpl(textFieldValue.getSelection()) || end != TextRange.m3952getEndimpl(textFieldValue.getSelection()))) {
                                    if (RangesKt.coerceAtMost(start, end) >= 0 && RangesKt.coerceAtLeast(start, end) <= textFieldValue.getText().length()) {
                                        if (traversalMode || start == end) {
                                            textFieldSelectionManager.exitSelectionMode$foundation_release();
                                        } else {
                                            textFieldSelectionManager.enterSelectionMode$foundation_release();
                                        }
                                        textFieldState3.getOnValueChange().invoke(new TextFieldValue(textFieldValue.getText(), TextRangeKt.TextRange(start, end), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                        z72 = true;
                                    } else {
                                        textFieldSelectionManager.exitSelectionMode$foundation_release();
                                    }
                                }
                                return Boolean.valueOf(z72);
                            }
                        }, 1, null);
                        final TextFieldState textFieldState4 = state;
                        final FocusRequester focusRequester4 = focusRequester322;
                        final boolean z72 = z522;
                        SemanticsPropertiesKt.onClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                CoreTextFieldKt.tapToFocus(TextFieldState.this, focusRequester4, !z72);
                                return true;
                            }
                        }, 1, null);
                        final TextFieldSelectionManager textFieldSelectionManager2 = manager22;
                        SemanticsPropertiesKt.onLongClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.5
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                TextFieldSelectionManager.this.enterSelectionMode$foundation_release();
                                return true;
                            }
                        }, 1, null);
                        if (!TextRange.m3951getCollapsedimpl(value.getSelection()) && !isPassword22) {
                            final TextFieldSelectionManager textFieldSelectionManager3 = manager22;
                            SemanticsPropertiesKt.copyText$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.6
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                    return true;
                                }
                            }, 1, null);
                            if (z422 && !z522) {
                                final TextFieldSelectionManager textFieldSelectionManager4 = manager22;
                                SemanticsPropertiesKt.cutText$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.7
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        TextFieldSelectionManager.this.cut$foundation_release();
                                        return true;
                                    }
                                }, 1, null);
                            }
                        }
                        if (z422 && !z522) {
                            final TextFieldSelectionManager textFieldSelectionManager5 = manager22;
                            SemanticsPropertiesKt.pasteText$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.8
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    TextFieldSelectionManager.this.paste$foundation_release();
                                    return true;
                                }
                            }, 1, null);
                        }
                    }
                });
                final Modifier cursorModifier22 = TextFieldCursorKt.cursor(Modifier.INSTANCE, state, value, offsetMapping22, cursorBrush3, (enabled2 || readOnly2) ? z2 : true);
                EffectsKt.DisposableEffect(manager22, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        final TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                            }
                        };
                    }
                }, $composer3, 8);
                EffectsKt.DisposableEffect(imeOptions722, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        if (TextInputService.this != null && state.getHasFocus()) {
                            state.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(TextInputService.this, value, state.getProcessor(), imeOptions722, state.getOnValueChange(), state.getOnImeActionPerformed()));
                        }
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                            }
                        };
                    }
                }, $composer3, $dirty1422 & 14);
                Modifier.Companion companion22 = Modifier.INSTANCE;
                Function1<TextFieldValue, Unit> onValueChange222 = state.getOnValueChange();
                boolean z622 = !readOnly2;
                if (maxLines522 != 1) {
                }
                maxLines3 = maxLines522;
                imeOptions4 = imeOptions722;
                Modifier textKeyInputModifier22 = TextFieldKeyInputKt.textFieldKeyInput(companion22, state, manager22, value, onValueChange222, z622, z7, offsetMapping22, undoManager22);
                Modifier modifier722 = modifier4;
                Modifier decorationBoxModifier22 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(modifier722.then(focusModifier22), state, manager22).then(textKeyInputModifier22), scrollerPosition322, interactionSource522, enabled2).then(pointerModifier22).then(semanticsModifier22), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutCoordinates it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                        if (layoutResult == null) {
                            return;
                        }
                        layoutResult.setDecorationBoxCoordinates(it2);
                    }
                });
                if (enabled2) {
                }
                final boolean showHandleAndMagnifier22 = z2;
                if (!showHandleAndMagnifier22) {
                }
                $composer2 = $composer3;
                enabled3 = enabled2;
                final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3222 = decorationBox;
                visualTransformation3 = visualTransformation522;
                modifier5 = modifier722;
                final TextStyle textStyle422 = textStyle2;
                final boolean z822 = readOnly2;
                final Function1<? super TextLayoutResult, Unit> function1222 = onTextLayout;
                CoreTextFieldRootBox(decorationBoxModifier22, manager22, ComposableLambdaKt.composableLambda($composer2, -1885146845, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
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

                    public final void invoke(Composer $composer4, int $changed2) {
                        ComposerKt.sourceInformation($composer4, "C543@23798L4285:CoreTextField.kt#423gt5");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1885146845, $changed2, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:542)");
                            }
                            Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function33 = function3222;
                            final TextFieldState textFieldState = state;
                            final int i16 = maxLines3;
                            final TextStyle textStyle5 = textStyle422;
                            final TextFieldScrollerPosition textFieldScrollerPosition = scrollerPosition322;
                            final TextFieldValue textFieldValue = value;
                            final VisualTransformation visualTransformation6 = visualTransformation522;
                            final Modifier modifier8 = cursorModifier22;
                            final Modifier modifier9 = drawModifier22;
                            final Modifier modifier10 = onPositionedModifier22;
                            final Modifier modifier11 = magnifierModifier;
                            final BringIntoViewRequester bringIntoViewRequester222 = bringIntoViewRequester22;
                            final TextFieldSelectionManager textFieldSelectionManager = manager22;
                            final boolean z9 = showHandleAndMagnifier22;
                            final boolean z10 = z822;
                            final Function1<? super TextLayoutResult, Unit> function13 = function1222;
                            final Density density2 = density;
                            function33.invoke(ComposableLambdaKt.composableLambda($composer4, 207445534, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
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

                                public final void invoke(Composer $composer5, int $changed3) {
                                    ComposerKt.sourceInformation($composer5, "C564@24781L3292:CoreTextField.kt#423gt5");
                                    if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(207445534, $changed3, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:543)");
                                        }
                                        Modifier maxLinesHeight = MaxLinesHeightModifierKt.maxLinesHeight(SizeKt.m788heightInVpY3zN4$default(Modifier.INSTANCE, TextFieldState.this.m1104getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), i16, textStyle5);
                                        TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                                        TextFieldValue textFieldValue2 = textFieldValue;
                                        VisualTransformation visualTransformation7 = visualTransformation6;
                                        final TextFieldState textFieldState2 = TextFieldState.this;
                                        Modifier coreTextFieldModifier = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(maxLinesHeight, textFieldScrollerPosition2, textFieldValue2, visualTransformation7, new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final TextLayoutResultProxy invoke() {
                                                return TextFieldState.this.getLayoutResult();
                                            }
                                        }).then(modifier8).then(modifier9), textStyle5).then(modifier10).then(modifier11), bringIntoViewRequester222);
                                        final TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                        final TextFieldState textFieldState3 = TextFieldState.this;
                                        final boolean z11 = z9;
                                        final boolean z12 = z10;
                                        final Function1<? super TextLayoutResult, Unit> function14 = function13;
                                        final Density density3 = density2;
                                        final int i17 = i16;
                                        SimpleLayoutKt.SimpleLayout(coreTextFieldModifier, ComposableLambdaKt.composableLambda($composer5, 19580180, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
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

                                            /* JADX WARN: Removed duplicated region for block: B:40:0x0188  */
                                            /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final void invoke(Composer $composer6, int $changed4) {
                                                boolean z13;
                                                ComposerKt.sourceInformation($composer6, "C565@24835L2620,617@27473L327,629@28001L40:CoreTextField.kt#423gt5");
                                                if (($changed4 & 11) != 2 || !$composer6.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(19580180, $changed4, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:564)");
                                                    }
                                                    final TextFieldState textFieldState4 = textFieldState3;
                                                    final Function1<? super TextLayoutResult, Unit> function15 = function14;
                                                    final Density density4 = density3;
                                                    final int i18 = i17;
                                                    MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                        @Override // androidx.compose.p000ui.layout.MeasurePolicy
                                                        /* renamed from: measure-3p2s80s */
                                                        public MeasureResult mo331measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long constraints) {
                                                            Intrinsics.checkNotNullParameter(measure, "$this$measure");
                                                            Intrinsics.checkNotNullParameter(measurables, "measurables");
                                                            Snapshot.Companion this_$iv = Snapshot.INSTANCE;
                                                            TextFieldState textFieldState5 = TextFieldState.this;
                                                            Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
                                                            try {
                                                                Snapshot previous$iv$iv = snapshot$iv.makeCurrent();
                                                                try {
                                                                    TextLayoutResultProxy layoutResult = textFieldState5.getLayoutResult();
                                                                    TextLayoutResult prevResult = layoutResult != null ? layoutResult.getValue() : null;
                                                                    snapshot$iv.dispose();
                                                                    Triple<Integer, Integer, TextLayoutResult> m1088layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m1088layout_EkL_Y$foundation_release(TextFieldState.this.getTextDelegate(), constraints, measure.getLayoutDirection(), prevResult);
                                                                    int width = m1088layout_EkL_Y$foundation_release.component1().intValue();
                                                                    int height = m1088layout_EkL_Y$foundation_release.component2().intValue();
                                                                    TextLayoutResult result = m1088layout_EkL_Y$foundation_release.component3();
                                                                    if (!Intrinsics.areEqual(prevResult, result)) {
                                                                        TextFieldState.this.setLayoutResult(new TextLayoutResultProxy(result));
                                                                        function15.invoke(result);
                                                                    }
                                                                    TextFieldState textFieldState6 = TextFieldState.this;
                                                                    Density $this$measure_3p2s80s_u24lambda_u2d1 = density4;
                                                                    textFieldState6.m1105setMinHeightForSingleLineField0680j_4($this$measure_3p2s80s_u24lambda_u2d1.mo645toDpu2uoSUM(i18 == 1 ? TextDelegateKt.ceilToIntPx(result.getLineBottom(0)) : 0));
                                                                    return measure.layout(width, height, MapsKt.mapOf(TuplesKt.m294to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(result.getFirstBaseline()))), TuplesKt.m294to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(result.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                            invoke2(placementScope);
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                        public final void invoke2(Placeable.PlacementScope layout) {
                                                                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                                                        }
                                                                    });
                                                                } finally {
                                                                    snapshot$iv.restoreCurrent(previous$iv$iv);
                                                                }
                                                            } catch (Throwable th) {
                                                                snapshot$iv.dispose();
                                                                throw th;
                                                            }
                                                        }

                                                        @Override // androidx.compose.p000ui.layout.MeasurePolicy
                                                        public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
                                                            Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
                                                            Intrinsics.checkNotNullParameter(measurables, "measurables");
                                                            TextFieldState.this.getTextDelegate().layoutIntrinsics($this$maxIntrinsicWidth.getLayoutDirection());
                                                            return TextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                        }
                                                    };
                                                    $composer6.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation($composer6, "C(Layout)P(!1,2)74@2907L7,75@2962L7,76@3021L7,77@3033L460:Layout.kt#80mrfh");
                                                    Modifier modifier$iv = Modifier.INSTANCE;
                                                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                                    ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object consume9 = $composer6.consume(localDensity2);
                                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                                    Density density$iv = (Density) consume9;
                                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                    ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object consume10 = $composer6.consume(localLayoutDirection);
                                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                                    LayoutDirection layoutDirection$iv = (LayoutDirection) consume10;
                                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                    ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                    Object consume11 = $composer6.consume(localViewConfiguration);
                                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                                    ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume11;
                                                    Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier$iv);
                                                    int $changed$iv$iv = ((0 << 9) & 7168) | 6;
                                                    if (!($composer6.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    $composer6.startReusableNode();
                                                    if ($composer6.getInserting()) {
                                                        $composer6.createNode(factory$iv$iv);
                                                    } else {
                                                        $composer6.useNode();
                                                    }
                                                    $composer6.disableReusing();
                                                    Composer $this$Layout_u24lambda_u2d0$iv = Updater.m1639constructorimpl($composer6);
                                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, density$iv, ComposeUiNode.INSTANCE.getSetDensity());
                                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, layoutDirection$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, viewConfiguration$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                    $composer6.enableReusing();
                                                    skippableUpdate$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer6)), $composer6, Integer.valueOf(($changed$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                                                    $composer6.startReplaceableGroup(2058660585);
                                                    $composer6.startReplaceableGroup(1714611517);
                                                    ComposerKt.sourceInformation($composer6, "C:CoreTextField.kt#423gt5");
                                                    if ((($changed$iv$iv >> 9) & 14 & 11) == 2 && $composer6.getSkipping()) {
                                                        $composer6.skipToGroupEnd();
                                                    }
                                                    $composer6.endReplaceableGroup();
                                                    $composer6.endReplaceableGroup();
                                                    $composer6.endNode();
                                                    $composer6.endReplaceableGroup();
                                                    TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                                                    if (textFieldState3.getHandleState() == HandleState.Selection && textFieldState3.getLayoutCoordinates() != null) {
                                                        LayoutCoordinates layoutCoordinates = textFieldState3.getLayoutCoordinates();
                                                        Intrinsics.checkNotNull(layoutCoordinates);
                                                        if (layoutCoordinates.isAttached() && z11) {
                                                            z13 = true;
                                                            CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager3, z13, $composer6, 8);
                                                            if (textFieldState3.getHandleState() == HandleState.Cursor && !z12 && z11) {
                                                                CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, $composer6, 8);
                                                            }
                                                            if (!ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                    }
                                                    z13 = false;
                                                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager3, z13, $composer6, 8);
                                                    if (textFieldState3.getHandleState() == HandleState.Cursor) {
                                                        CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, $composer6, 8);
                                                    }
                                                    if (!ComposerKt.isTraceInProgress()) {
                                                    }
                                                } else {
                                                    $composer6.skipToGroupEnd();
                                                }
                                            }
                                        }), $composer5, 48, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer5.skipToGroupEnd();
                                }
                            }), $composer4, Integer.valueOf((($dirty1422 >> 9) & SdkConfig.SDK_VERSION) | 6));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }), $composer2, 448);
                if (ComposerKt.isTraceInProgress()) {
                }
                interactionSource3 = interactionSource522;
            }
            TransformedText transformed2 = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation2, value.getText());
            composition = value.getComposition();
            if (composition == null) {
            }
            it$iv$iv2 = transformed2;
            value$iv$iv = it$iv$iv2;
            $composer3.updateRememberedValue(value$iv$iv);
            $composer3.endReplaceableGroup();
            final TransformedText transformedText222 = (TransformedText) value$iv$iv;
            AnnotatedString visualText222 = transformedText222.getText();
            final OffsetMapping offsetMapping222 = transformedText222.getOffsetMapping();
            RecomposeScope scope222 = ComposablesKt.getCurrentRecomposeScope($composer3, 0);
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
            value$iv$iv2 = $composer3.rememberedValue();
            int maxLines5222 = maxLines2;
            if (value$iv$iv2 != Composer.INSTANCE.getEmpty()) {
            }
            $composer3.endReplaceableGroup();
            state = (TextFieldState) value$iv$iv2;
            state.m1106updatefnh65Uc(value.getText(), visualText222, textStyle2, softWrap2, density, fontFamilyResolver, onValueChange, keyboardActions2, focusManager, selectionBackgroundColor);
            state.getProcessor().reset(value, state.getInputSession());
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
            value$iv$iv3 = $composer3.rememberedValue();
            if (value$iv$iv3 != Composer.INSTANCE.getEmpty()) {
            }
            $composer3.endReplaceableGroup();
            UndoManager undoManager222 = (UndoManager) value$iv$iv3;
            UndoManager.snapshotIfNeeded$default(undoManager222, value, 0L, 2, null);
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
            value$iv$iv4 = $composer3.rememberedValue();
            if (value$iv$iv4 != Composer.INSTANCE.getEmpty()) {
            }
            $composer3.endReplaceableGroup();
            final TextFieldSelectionManager manager222 = (TextFieldSelectionManager) value$iv$iv4;
            manager222.setOffsetMapping$foundation_release(offsetMapping222);
            manager222.setVisualTransformation$foundation_release(visualTransformation2);
            manager222.setOnValueChange$foundation_release(state.getOnValueChange());
            manager222.setState$foundation_release(state);
            manager222.setValue$foundation_release(value);
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager222 = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6222 = $composer3.consume(localClipboardManager222);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            manager222.setClipboardManager$foundation_release((ClipboardManager) consume6222);
            ProvidableCompositionLocal<TextToolbar> localTextToolbar222 = CompositionLocalsKt.getLocalTextToolbar();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume7222 = $composer3.consume(localTextToolbar222);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            manager222.setTextToolbar((TextToolbar) consume7222);
            ProvidableCompositionLocal<HapticFeedback> localHapticFeedback222 = CompositionLocalsKt.getLocalHapticFeedback();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume8222 = $composer3.consume(localHapticFeedback222);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            manager222.setHapticFeedBack((HapticFeedback) consume8222);
            manager222.setFocusRequester(focusRequester2);
            manager222.setEditable(!readOnly2);
            $composer3.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation($composer3, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
            it$iv$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv$iv != Composer.INSTANCE.getEmpty()) {
            }
            $composer3.endReplaceableGroup();
            CompositionScopedCoroutineScopeCanceller wrapper$iv222 = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
            final CoroutineScope coroutineScope222 = wrapper$iv222.getCoroutineScope();
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
            it$iv$iv3 = $composer3.rememberedValue();
            if (it$iv$iv3 != Composer.INSTANCE.getEmpty()) {
            }
            $composer3.endReplaceableGroup();
            final BringIntoViewRequester bringIntoViewRequester222 = (BringIntoViewRequester) value$iv$iv5;
            final ImeOptions imeOptions5222 = imeOptions3;
            Modifier focusModifier222 = TextFieldGestureModifiersKt.textFieldFocusModifier(Modifier.INSTANCE, readOnly3, focusRequester2, interactionSource2, new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                    invoke2(focusState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(FocusState it2) {
                    TextLayoutResultProxy layoutResult;
                    Intrinsics.checkNotNullParameter(it2, "it");
                    if (TextFieldState.this.getHasFocus() == it2.isFocused()) {
                        return;
                    }
                    TextFieldState.this.setHasFocus(it2.isFocused());
                    if (textInputService3 != null) {
                        CoreTextFieldKt.notifyTextInputServiceOnFocusChange(textInputService3, TextFieldState.this, value, imeOptions5222);
                        if (it2.isFocused() && (layoutResult = TextFieldState.this.getLayoutResult()) != null) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope222, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(bringIntoViewRequester222, value, TextFieldState.this, layoutResult, offsetMapping222, null), 3, null);
                        }
                    }
                    if (!it2.isFocused()) {
                        TextFieldSelectionManager.m1203deselect_kEHs6E$foundation_release$default(manager222, null, 1, null);
                    }
                }
            });
            $composer3.startReplaceableGroup(-55008775);
            ComposerKt.sourceInformation($composer3, "318@15664L163");
            if (readOnly3) {
            }
            $composer3.endReplaceableGroup();
            if (TouchMode_androidKt.isInTouchMode()) {
            }
            Modifier pointerModifier222 = selectionModifier;
            final Modifier drawModifier222 = DrawModifierKt.drawBehind(Modifier.INSTANCE, new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope drawBehind) {
                    Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
                    TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                    if (layoutResult == null) {
                        return;
                    }
                    TextFieldValue textFieldValue = value;
                    OffsetMapping offsetMapping2222 = offsetMapping222;
                    TextFieldState textFieldState = TextFieldState.this;
                    Canvas canvas = drawBehind.getDrawContext().getCanvas();
                    TextFieldDelegate.INSTANCE.draw$foundation_release(canvas, textFieldValue, offsetMapping2222, layoutResult.getValue(), textFieldState.getSelectionPaint());
                }
            });
            final Modifier onPositionedModifier222 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.INSTANCE, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                    invoke2(layoutCoordinates);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutCoordinates it2) {
                    Intrinsics.checkNotNullParameter(it2, "it");
                    TextFieldState.this.setLayoutCoordinates(it2);
                    if (readOnly3) {
                        if (TextFieldState.this.getHandleState() == HandleState.Selection) {
                            if (TextFieldState.this.getShowFloatingToolbar()) {
                                manager222.showSelectionToolbar$foundation_release();
                            } else {
                                manager222.hideSelectionToolbar$foundation_release();
                            }
                            TextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(manager222, true));
                            TextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(manager222, false));
                        } else if (TextFieldState.this.getHandleState() == HandleState.Cursor) {
                            TextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(manager222, true));
                        }
                    }
                    TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                    if (layoutResult == null) {
                        return;
                    }
                    layoutResult.setInnerTextFieldCoordinates(it2);
                }
            });
            final boolean isPassword222 = visualTransformation2 instanceof PasswordVisualTransformation;
            MutableInteractionSource interactionSource5222 = interactionSource2;
            final VisualTransformation visualTransformation5222 = visualTransformation2;
            final ImeOptions imeOptions6222 = imeOptions3;
            z2 = z;
            final TextInputService textInputService4222 = textInputService2;
            final FocusRequester focusRequester3222 = focusRequester;
            final boolean z4222 = readOnly3;
            final TextFieldScrollerPosition scrollerPosition3222 = scrollerPosition2;
            final int $dirty14222 = $dirty12;
            final boolean z5222 = readOnly2;
            enabled2 = readOnly3;
            final ImeOptions imeOptions7222 = imeOptions3;
            Modifier semanticsModifier222 = SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    SemanticsPropertiesKt.m3843setImeAction4L7nppU(semantics, ImeOptions.this.getImeAction());
                    SemanticsPropertiesKt.setEditableText(semantics, transformedText222.getText());
                    SemanticsPropertiesKt.m3846setTextSelectionRangeFDrldGo(semantics, value.getSelection());
                    if (!z4222) {
                        SemanticsPropertiesKt.disabled(semantics);
                    }
                    if (isPassword222) {
                        SemanticsPropertiesKt.password(semantics);
                    }
                    final TextFieldState textFieldState = state;
                    SemanticsPropertiesKt.getTextLayoutResult$default(semantics, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(List<TextLayoutResult> it2) {
                            boolean z6222;
                            Intrinsics.checkNotNullParameter(it2, "it");
                            if (TextFieldState.this.getLayoutResult() != null) {
                                TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                Intrinsics.checkNotNull(layoutResult);
                                it2.add(layoutResult.getValue());
                                z6222 = true;
                            } else {
                                z6222 = false;
                            }
                            return Boolean.valueOf(z6222);
                        }
                    }, 1, null);
                    final TextFieldState textFieldState2 = state;
                    SemanticsPropertiesKt.setText$default(semantics, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(AnnotatedString it2) {
                            Intrinsics.checkNotNullParameter(it2, "it");
                            TextFieldState.this.getOnValueChange().invoke(new TextFieldValue(it2.getText(), TextRangeKt.TextRange(it2.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                            return true;
                        }
                    }, 1, null);
                    final OffsetMapping offsetMapping2222 = offsetMapping222;
                    final boolean z6222 = z4222;
                    final TextFieldValue textFieldValue = value;
                    final TextFieldSelectionManager textFieldSelectionManager = manager222;
                    final TextFieldState textFieldState3 = state;
                    SemanticsPropertiesKt.setSelection$default(semantics, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                            return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                        }

                        public final Boolean invoke(int selectionStart, int selectionEnd, boolean traversalMode) {
                            int start;
                            int end;
                            if (traversalMode) {
                                start = selectionStart;
                            } else {
                                start = OffsetMapping.this.transformedToOriginal(selectionStart);
                            }
                            if (traversalMode) {
                                end = selectionEnd;
                            } else {
                                end = OffsetMapping.this.transformedToOriginal(selectionEnd);
                            }
                            boolean z72 = false;
                            if (z6222 && (start != TextRange.m3957getStartimpl(textFieldValue.getSelection()) || end != TextRange.m3952getEndimpl(textFieldValue.getSelection()))) {
                                if (RangesKt.coerceAtMost(start, end) >= 0 && RangesKt.coerceAtLeast(start, end) <= textFieldValue.getText().length()) {
                                    if (traversalMode || start == end) {
                                        textFieldSelectionManager.exitSelectionMode$foundation_release();
                                    } else {
                                        textFieldSelectionManager.enterSelectionMode$foundation_release();
                                    }
                                    textFieldState3.getOnValueChange().invoke(new TextFieldValue(textFieldValue.getText(), TextRangeKt.TextRange(start, end), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                    z72 = true;
                                } else {
                                    textFieldSelectionManager.exitSelectionMode$foundation_release();
                                }
                            }
                            return Boolean.valueOf(z72);
                        }
                    }, 1, null);
                    final TextFieldState textFieldState4 = state;
                    final FocusRequester focusRequester4 = focusRequester3222;
                    final boolean z72 = z5222;
                    SemanticsPropertiesKt.onClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            CoreTextFieldKt.tapToFocus(TextFieldState.this, focusRequester4, !z72);
                            return true;
                        }
                    }, 1, null);
                    final TextFieldSelectionManager textFieldSelectionManager2 = manager222;
                    SemanticsPropertiesKt.onLongClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.5
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            TextFieldSelectionManager.this.enterSelectionMode$foundation_release();
                            return true;
                        }
                    }, 1, null);
                    if (!TextRange.m3951getCollapsedimpl(value.getSelection()) && !isPassword222) {
                        final TextFieldSelectionManager textFieldSelectionManager3 = manager222;
                        SemanticsPropertiesKt.copyText$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.6
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                return true;
                            }
                        }, 1, null);
                        if (z4222 && !z5222) {
                            final TextFieldSelectionManager textFieldSelectionManager4 = manager222;
                            SemanticsPropertiesKt.cutText$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.7
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    TextFieldSelectionManager.this.cut$foundation_release();
                                    return true;
                                }
                            }, 1, null);
                        }
                    }
                    if (z4222 && !z5222) {
                        final TextFieldSelectionManager textFieldSelectionManager5 = manager222;
                        SemanticsPropertiesKt.pasteText$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.8
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                TextFieldSelectionManager.this.paste$foundation_release();
                                return true;
                            }
                        }, 1, null);
                    }
                }
            });
            final Modifier cursorModifier222 = TextFieldCursorKt.cursor(Modifier.INSTANCE, state, value, offsetMapping222, cursorBrush3, (enabled2 || readOnly2) ? z2 : true);
            EffectsKt.DisposableEffect(manager222, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    final TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                        }
                    };
                }
            }, $composer3, 8);
            EffectsKt.DisposableEffect(imeOptions7222, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    if (TextInputService.this != null && state.getHasFocus()) {
                        state.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(TextInputService.this, value, state.getProcessor(), imeOptions7222, state.getOnValueChange(), state.getOnImeActionPerformed()));
                    }
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                        }
                    };
                }
            }, $composer3, $dirty14222 & 14);
            Modifier.Companion companion222 = Modifier.INSTANCE;
            Function1<TextFieldValue, Unit> onValueChange2222 = state.getOnValueChange();
            boolean z6222 = !readOnly2;
            if (maxLines5222 != 1) {
            }
            maxLines3 = maxLines5222;
            imeOptions4 = imeOptions7222;
            Modifier textKeyInputModifier222 = TextFieldKeyInputKt.textFieldKeyInput(companion222, state, manager222, value, onValueChange2222, z6222, z7, offsetMapping222, undoManager222);
            Modifier modifier7222 = modifier4;
            Modifier decorationBoxModifier222 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(modifier7222.then(focusModifier222), state, manager222).then(textKeyInputModifier222), scrollerPosition3222, interactionSource5222, enabled2).then(pointerModifier222).then(semanticsModifier222), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                    invoke2(layoutCoordinates);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutCoordinates it2) {
                    Intrinsics.checkNotNullParameter(it2, "it");
                    TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                    if (layoutResult == null) {
                        return;
                    }
                    layoutResult.setDecorationBoxCoordinates(it2);
                }
            });
            if (enabled2) {
            }
            final boolean showHandleAndMagnifier222 = z2;
            if (!showHandleAndMagnifier222) {
            }
            $composer2 = $composer3;
            enabled3 = enabled2;
            final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function32222 = decorationBox;
            visualTransformation3 = visualTransformation5222;
            modifier5 = modifier7222;
            final TextStyle textStyle4222 = textStyle2;
            final boolean z8222 = readOnly2;
            final Function1<? super TextLayoutResult, Unit> function12222 = onTextLayout;
            CoreTextFieldRootBox(decorationBoxModifier222, manager222, ComposableLambdaKt.composableLambda($composer2, -1885146845, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
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

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C543@23798L4285:CoreTextField.kt#423gt5");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1885146845, $changed2, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:542)");
                        }
                        Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function33 = function32222;
                        final TextFieldState textFieldState = state;
                        final int i16 = maxLines3;
                        final TextStyle textStyle5 = textStyle4222;
                        final TextFieldScrollerPosition textFieldScrollerPosition = scrollerPosition3222;
                        final TextFieldValue textFieldValue = value;
                        final VisualTransformation visualTransformation6 = visualTransformation5222;
                        final Modifier modifier8 = cursorModifier222;
                        final Modifier modifier9 = drawModifier222;
                        final Modifier modifier10 = onPositionedModifier222;
                        final Modifier modifier11 = magnifierModifier;
                        final BringIntoViewRequester bringIntoViewRequester2222 = bringIntoViewRequester222;
                        final TextFieldSelectionManager textFieldSelectionManager = manager222;
                        final boolean z9 = showHandleAndMagnifier222;
                        final boolean z10 = z8222;
                        final Function1<? super TextLayoutResult, Unit> function13 = function12222;
                        final Density density2 = density;
                        function33.invoke(ComposableLambdaKt.composableLambda($composer4, 207445534, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
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

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C564@24781L3292:CoreTextField.kt#423gt5");
                                if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(207445534, $changed3, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:543)");
                                    }
                                    Modifier maxLinesHeight = MaxLinesHeightModifierKt.maxLinesHeight(SizeKt.m788heightInVpY3zN4$default(Modifier.INSTANCE, TextFieldState.this.m1104getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), i16, textStyle5);
                                    TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                                    TextFieldValue textFieldValue2 = textFieldValue;
                                    VisualTransformation visualTransformation7 = visualTransformation6;
                                    final TextFieldState textFieldState2 = TextFieldState.this;
                                    Modifier coreTextFieldModifier = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(maxLinesHeight, textFieldScrollerPosition2, textFieldValue2, visualTransformation7, new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final TextLayoutResultProxy invoke() {
                                            return TextFieldState.this.getLayoutResult();
                                        }
                                    }).then(modifier8).then(modifier9), textStyle5).then(modifier10).then(modifier11), bringIntoViewRequester2222);
                                    final TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                    final TextFieldState textFieldState3 = TextFieldState.this;
                                    final boolean z11 = z9;
                                    final boolean z12 = z10;
                                    final Function1<? super TextLayoutResult, Unit> function14 = function13;
                                    final Density density3 = density2;
                                    final int i17 = i16;
                                    SimpleLayoutKt.SimpleLayout(coreTextFieldModifier, ComposableLambdaKt.composableLambda($composer5, 19580180, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
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

                                        /* JADX WARN: Removed duplicated region for block: B:40:0x0188  */
                                        /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
                                        /*
                                            Code decompiled incorrectly, please refer to instructions dump.
                                        */
                                        public final void invoke(Composer $composer6, int $changed4) {
                                            boolean z13;
                                            ComposerKt.sourceInformation($composer6, "C565@24835L2620,617@27473L327,629@28001L40:CoreTextField.kt#423gt5");
                                            if (($changed4 & 11) != 2 || !$composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(19580180, $changed4, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:564)");
                                                }
                                                final TextFieldState textFieldState4 = textFieldState3;
                                                final Function1<? super TextLayoutResult, Unit> function15 = function14;
                                                final Density density4 = density3;
                                                final int i18 = i17;
                                                MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                    @Override // androidx.compose.p000ui.layout.MeasurePolicy
                                                    /* renamed from: measure-3p2s80s */
                                                    public MeasureResult mo331measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long constraints) {
                                                        Intrinsics.checkNotNullParameter(measure, "$this$measure");
                                                        Intrinsics.checkNotNullParameter(measurables, "measurables");
                                                        Snapshot.Companion this_$iv = Snapshot.INSTANCE;
                                                        TextFieldState textFieldState5 = TextFieldState.this;
                                                        Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
                                                        try {
                                                            Snapshot previous$iv$iv = snapshot$iv.makeCurrent();
                                                            try {
                                                                TextLayoutResultProxy layoutResult = textFieldState5.getLayoutResult();
                                                                TextLayoutResult prevResult = layoutResult != null ? layoutResult.getValue() : null;
                                                                snapshot$iv.dispose();
                                                                Triple<Integer, Integer, TextLayoutResult> m1088layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m1088layout_EkL_Y$foundation_release(TextFieldState.this.getTextDelegate(), constraints, measure.getLayoutDirection(), prevResult);
                                                                int width = m1088layout_EkL_Y$foundation_release.component1().intValue();
                                                                int height = m1088layout_EkL_Y$foundation_release.component2().intValue();
                                                                TextLayoutResult result = m1088layout_EkL_Y$foundation_release.component3();
                                                                if (!Intrinsics.areEqual(prevResult, result)) {
                                                                    TextFieldState.this.setLayoutResult(new TextLayoutResultProxy(result));
                                                                    function15.invoke(result);
                                                                }
                                                                TextFieldState textFieldState6 = TextFieldState.this;
                                                                Density $this$measure_3p2s80s_u24lambda_u2d1 = density4;
                                                                textFieldState6.m1105setMinHeightForSingleLineField0680j_4($this$measure_3p2s80s_u24lambda_u2d1.mo645toDpu2uoSUM(i18 == 1 ? TextDelegateKt.ceilToIntPx(result.getLineBottom(0)) : 0));
                                                                return measure.layout(width, height, MapsKt.mapOf(TuplesKt.m294to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(result.getFirstBaseline()))), TuplesKt.m294to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(result.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                        invoke2(placementScope);
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                    public final void invoke2(Placeable.PlacementScope layout) {
                                                                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                                                    }
                                                                });
                                                            } finally {
                                                                snapshot$iv.restoreCurrent(previous$iv$iv);
                                                            }
                                                        } catch (Throwable th) {
                                                            snapshot$iv.dispose();
                                                            throw th;
                                                        }
                                                    }

                                                    @Override // androidx.compose.p000ui.layout.MeasurePolicy
                                                    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
                                                        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
                                                        Intrinsics.checkNotNullParameter(measurables, "measurables");
                                                        TextFieldState.this.getTextDelegate().layoutIntrinsics($this$maxIntrinsicWidth.getLayoutDirection());
                                                        return TextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                    }
                                                };
                                                $composer6.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer6, "C(Layout)P(!1,2)74@2907L7,75@2962L7,76@3021L7,77@3033L460:Layout.kt#80mrfh");
                                                Modifier modifier$iv = Modifier.INSTANCE;
                                                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                                ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object consume9 = $composer6.consume(localDensity2);
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                Density density$iv = (Density) consume9;
                                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                                ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object consume10 = $composer6.consume(localLayoutDirection);
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                LayoutDirection layoutDirection$iv = (LayoutDirection) consume10;
                                                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                                ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                                Object consume11 = $composer6.consume(localViewConfiguration);
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume11;
                                                Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier$iv);
                                                int $changed$iv$iv = ((0 << 9) & 7168) | 6;
                                                if (!($composer6.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer6.startReusableNode();
                                                if ($composer6.getInserting()) {
                                                    $composer6.createNode(factory$iv$iv);
                                                } else {
                                                    $composer6.useNode();
                                                }
                                                $composer6.disableReusing();
                                                Composer $this$Layout_u24lambda_u2d0$iv = Updater.m1639constructorimpl($composer6);
                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, density$iv, ComposeUiNode.INSTANCE.getSetDensity());
                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, layoutDirection$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, viewConfiguration$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                                $composer6.enableReusing();
                                                skippableUpdate$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer6)), $composer6, Integer.valueOf(($changed$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                                                $composer6.startReplaceableGroup(2058660585);
                                                $composer6.startReplaceableGroup(1714611517);
                                                ComposerKt.sourceInformation($composer6, "C:CoreTextField.kt#423gt5");
                                                if ((($changed$iv$iv >> 9) & 14 & 11) == 2 && $composer6.getSkipping()) {
                                                    $composer6.skipToGroupEnd();
                                                }
                                                $composer6.endReplaceableGroup();
                                                $composer6.endReplaceableGroup();
                                                $composer6.endNode();
                                                $composer6.endReplaceableGroup();
                                                TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                                                if (textFieldState3.getHandleState() == HandleState.Selection && textFieldState3.getLayoutCoordinates() != null) {
                                                    LayoutCoordinates layoutCoordinates = textFieldState3.getLayoutCoordinates();
                                                    Intrinsics.checkNotNull(layoutCoordinates);
                                                    if (layoutCoordinates.isAttached() && z11) {
                                                        z13 = true;
                                                        CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager3, z13, $composer6, 8);
                                                        if (textFieldState3.getHandleState() == HandleState.Cursor && !z12 && z11) {
                                                            CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, $composer6, 8);
                                                        }
                                                        if (!ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                }
                                                z13 = false;
                                                CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager3, z13, $composer6, 8);
                                                if (textFieldState3.getHandleState() == HandleState.Cursor) {
                                                    CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, $composer6, 8);
                                                }
                                                if (!ComposerKt.isTraceInProgress()) {
                                                }
                                            } else {
                                                $composer6.skipToGroupEnd();
                                            }
                                        }
                                    }), $composer5, 48, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }), $composer4, Integer.valueOf((($dirty14222 >> 9) & SdkConfig.SDK_VERSION) | 6));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, 448);
            if (ComposerKt.isTraceInProgress()) {
            }
            interactionSource3 = interactionSource5222;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier8 = modifier5;
        final TextStyle textStyle5 = textStyle2;
        final VisualTransformation visualTransformation6 = visualTransformation3;
        final Function1 function13 = onTextLayout;
        final MutableInteractionSource mutableInteractionSource = interactionSource3;
        final Brush brush = cursorBrush3;
        final boolean z9 = softWrap2;
        final int i16 = maxLines3;
        final ImeOptions imeOptions8 = imeOptions4;
        final KeyboardActions keyboardActions4 = keyboardActions2;
        final boolean z10 = enabled3;
        final boolean z11 = readOnly2;
        final Function3 function33 = decorationBox;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$6
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

            public final void invoke(Composer composer, int i17) {
                CoreTextFieldKt.CoreTextField(TextFieldValue.this, onValueChange, modifier8, textStyle5, visualTransformation6, function13, mutableInteractionSource, brush, z9, i16, imeOptions8, keyboardActions4, z10, z11, function33, composer, $changed | 1, $changed1, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CoreTextFieldRootBox(final Modifier modifier, final TextFieldSelectionManager manager, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-20551815);
        ComposerKt.sourceInformation($composer2, "C(CoreTextFieldRootBox)P(2,1)642@28247L95:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-20551815, $changed, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:637)");
        }
        int $changed$iv = ($changed & 14) | 384;
        $composer2.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, true, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & SdkConfig.SDK_VERSION));
        int $changed$iv$iv = ($changed$iv << 3) & SdkConfig.SDK_VERSION;
        $composer2.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer2.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        Density density$iv$iv = (Density) consume;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer2.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = $composer2.consume(localViewConfiguration);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
        Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
        Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier);
        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
        if (!($composer2.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer2.startReusableNode();
        if ($composer2.getInserting()) {
            $composer2.createNode(factory$iv$iv$iv);
        } else {
            $composer2.useNode();
        }
        $composer2.disableReusing();
        Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer2);
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
        $composer2.enableReusing();
        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
        $composer2.startReplaceableGroup(2058660585);
        $composer2.startReplaceableGroup(-2137368960);
        ComposerKt.sourceInformation($composer2, "C72@3384L9:Box.kt#2w3rfo");
        if ((($changed$iv$iv$iv >> 9) & 14 & 11) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int $changed2 = (($changed$iv >> 6) & SdkConfig.SDK_VERSION) | 6;
            $composer2.startReplaceableGroup(1524757375);
            ComposerKt.sourceInformation($composer2, "C643@28303L33:CoreTextField.kt#423gt5");
            if (($changed2 & 81) == 16 && $composer2.getSkipping()) {
                $composer2.skipToGroupEnd();
            } else {
                ContextMenu_androidKt.ContextMenuArea(manager, function2, $composer2, (($changed >> 3) & SdkConfig.SDK_VERSION) | 8);
            }
            $composer2.endReplaceableGroup();
        }
        $composer2.endReplaceableGroup();
        $composer2.endReplaceableGroup();
        $composer2.endNode();
        $composer2.endReplaceableGroup();
        $composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextFieldRootBox$2
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

                public final void invoke(Composer composer, int i) {
                    CoreTextFieldKt.CoreTextFieldRootBox(Modifier.this, manager, function2, composer, $changed | 1);
                }
            });
        }
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier $this$previewKeyEventToDeselectOnBack, final TextFieldState state, final TextFieldSelectionManager manager) {
        return KeyInputModifierKt.onPreviewKeyEvent($this$previewKeyEventToDeselectOnBack, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$previewKeyEventToDeselectOnBack$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m1030invokeZmokQxo(keyEvent.m3219unboximpl());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m1030invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z;
                Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
                if (TextFieldState.this.getHandleState() == HandleState.Selection && KeyEventHelpers_androidKt.m1035cancelsTextSelectionZmokQxo(keyEvent)) {
                    z = true;
                    TextFieldSelectionManager.m1203deselect_kEHs6E$foundation_release$default(manager, null, 1, null);
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tapToFocus(TextFieldState state, FocusRequester focusRequester, boolean allowKeyboard) {
        TextInputSession inputSession;
        if (!state.getHasFocus()) {
            focusRequester.requestFocus();
        } else {
            if (!allowKeyboard || (inputSession = state.getInputSession()) == null) {
                return;
            }
            inputSession.showSoftwareKeyboard();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyTextInputServiceOnFocusChange(TextInputService textInputService, TextFieldState state, TextFieldValue value, ImeOptions imeOptions) {
        if (state.getHasFocus()) {
            state.setInputSession(TextFieldDelegate.INSTANCE.onFocus$foundation_release(textInputService, value, state.getProcessor(), imeOptions, state.getOnValueChange(), state.getOnImeActionPerformed()));
        } else {
            onBlur(state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBlur(TextFieldState state) {
        TextInputSession session = state.getInputSession();
        if (session != null) {
            TextFieldDelegate.INSTANCE.onBlur$foundation_release(session, state.getProcessor(), state.getOnValueChange());
        }
        state.setInputSession(null);
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester $this$bringSelectionEndIntoView, TextFieldValue value, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> continuation) {
        Rect selectionEndBounds;
        int selectionEndInTransformed = offsetMapping.originalToTransformed(TextRange.m3954getMaximpl(value.getSelection()));
        if (selectionEndInTransformed < textLayoutResult.getLayoutInput().getText().length()) {
            selectionEndBounds = textLayoutResult.getBoundingBox(selectionEndInTransformed);
        } else if (selectionEndInTransformed != 0) {
            selectionEndBounds = textLayoutResult.getBoundingBox(selectionEndInTransformed - 1);
        } else {
            long defaultSize = TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), null, 0, 24, null);
            selectionEndBounds = new Rect(0.0f, 0.0f, 1.0f, IntSize.m4541getHeightimpl(defaultSize));
        }
        Object bringIntoView = $this$bringSelectionEndIntoView.bringIntoView(selectionEndBounds, continuation);
        return bringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? bringIntoView : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectionToolbarAndHandles(final TextFieldSelectionManager manager, final boolean show, Composer $composer, final int $changed) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer $composer2 = $composer.startRestartGroup(626339208);
        ComposerKt.sourceInformation($composer2, "C(SelectionToolbarAndHandles)979@41906L202:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(626339208, $changed, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:960)");
        }
        if (show) {
            TextFieldState state = manager.getState();
            TextLayoutResult textLayoutResult = null;
            if (state != null && (layoutResult = state.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
                TextFieldState state2 = manager.getState();
                if (!(state2 != null ? state2.getIsLayoutResultStale() : true)) {
                    textLayoutResult = value;
                }
            }
            if (textLayoutResult != null) {
                TextLayoutResult it = textLayoutResult;
                if (!TextRange.m3951getCollapsedimpl(manager.getValue$foundation_release().getSelection())) {
                    int startOffset = manager.getOffsetMapping().originalToTransformed(TextRange.m3957getStartimpl(manager.getValue$foundation_release().getSelection()));
                    int endOffset = manager.getOffsetMapping().originalToTransformed(TextRange.m3952getEndimpl(manager.getValue$foundation_release().getSelection()));
                    ResolvedTextDirection startDirection = it.getBidiRunDirection(startOffset);
                    ResolvedTextDirection endDirection = it.getBidiRunDirection(Math.max(endOffset - 1, 0));
                    $composer2.startReplaceableGroup(-498393098);
                    ComposerKt.sourceInformation($composer2, "972@41583L203");
                    TextFieldState state3 = manager.getState();
                    if (state3 != null && state3.getShowSelectionHandleStart()) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, startDirection, manager, $composer2, 518);
                    }
                    $composer2.endReplaceableGroup();
                    TextFieldState state4 = manager.getState();
                    if (state4 != null && state4.getShowSelectionHandleEnd()) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, endDirection, manager, $composer2, 518);
                    }
                }
                TextFieldState textFieldState = manager.getState();
                if (textFieldState != null) {
                    if (manager.isTextChanged$foundation_release()) {
                        textFieldState.setShowFloatingToolbar(false);
                    }
                    if (textFieldState.getHasFocus()) {
                        if (textFieldState.getShowFloatingToolbar()) {
                            manager.showSelectionToolbar$foundation_release();
                        } else {
                            manager.hideSelectionToolbar$foundation_release();
                        }
                    }
                }
            }
        } else {
            manager.hideSelectionToolbar$foundation_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$SelectionToolbarAndHandles$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                CoreTextFieldKt.SelectionToolbarAndHandles(TextFieldSelectionManager.this, show, composer, $changed | 1);
            }
        });
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionManager manager, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Intrinsics.checkNotNullParameter(manager, "manager");
        Composer $composer2 = $composer.startRestartGroup(-1436003720);
        ComposerKt.sourceInformation($composer2, "C(TextFieldCursorHandle)1005@42951L50,1006@43064L7,1013@43321L205,1007@43081L483:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1436003720, $changed, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1003)");
        }
        TextFieldState state = manager.getState();
        if (state != null && state.getShowCursorHandle()) {
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(manager);
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = manager.cursorDragObserver$foundation_release();
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            TextDragObserver observer = (TextDragObserver) value$iv$iv;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final long position = manager.m1208getCursorPositiontuRUvjQ$foundation_release((Density) consume);
            Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, observer, new CoreTextFieldKt$TextFieldCursorHandle$1(observer, null));
            Object key1$iv = Offset.m1749boximpl(position);
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv2 = $composer2.changed(key1$iv);
            Object it$iv$iv2 = $composer2.rememberedValue();
            if (invalid$iv$iv2 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        semantics.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, position, null));
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            AndroidCursorHandle_androidKt.m1012CursorHandleULxng0E(position, SemanticsModifierKt.semantics$default(pointerInput, false, (Function1) value$iv$iv2, 1, null), null, $composer2, 384);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer, $changed | 1);
            }
        });
    }
}
