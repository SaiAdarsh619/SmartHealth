package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.DrawModifierKt;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.graphics.ClipOp;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.Shadow;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.graphics.SolidColor;
import androidx.compose.p000ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p000ui.graphics.drawscope.DrawContext;
import androidx.compose.p000ui.graphics.drawscope.DrawTransform;
import androidx.compose.p000ui.layout.LayoutIdKt;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.font.FontFamily;
import androidx.compose.p000ui.text.font.FontStyle;
import androidx.compose.p000ui.text.font.FontSynthesis;
import androidx.compose.p000ui.text.font.FontWeight;
import androidx.compose.p000ui.text.input.TextFieldValue;
import androidx.compose.p000ui.text.input.VisualTransformation;
import androidx.compose.p000ui.text.intl.LocaleList;
import androidx.compose.p000ui.text.style.BaselineShift;
import androidx.compose.p000ui.text.style.TextAlign;
import androidx.compose.p000ui.text.style.TextDecoration;
import androidx.compose.p000ui.text.style.TextDirection;
import androidx.compose.p000ui.text.style.TextGeometricTransform;
import androidx.compose.p000ui.text.style.TextIndent;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
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
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: OutlinedTextField.kt */
@Metadata(m286d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0087\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010+\u001a\u0087\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010,\u001aÄ\u0001\u0010-\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0019\u0010\u0018\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\r¢\u0006\u0002\b\u00172\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u00100\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0006\u0010\"\u001a\u00020\u00112\u0006\u00101\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\t0\r2\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0006\u00106\u001a\u000207H\u0001ø\u0001\u0000¢\u0006\u0002\u00108\u001aU\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u0002022\u0006\u00106\u001a\u000207H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010C\u001a]\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020\u00112\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u0002022\u0006\u00106\u001a\u000207H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001a)\u0010M\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010N\u001a\u0002042\u0006\u00106\u001a\u000207H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001a|\u0010Q\u001a\u00020\t*\u00020R2\u0006\u0010S\u001a\u00020$2\u0006\u0010T\u001a\u00020$2\b\u0010U\u001a\u0004\u0018\u00010V2\b\u0010W\u001a\u0004\u0018\u00010V2\u0006\u0010X\u001a\u00020V2\b\u0010Y\u001a\u0004\u0018\u00010V2\b\u0010Z\u001a\u0004\u0018\u00010V2\u0006\u0010[\u001a\u00020V2\u0006\u00101\u001a\u0002022\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010A\u001a\u0002022\u0006\u0010\\\u001a\u00020]2\u0006\u00106\u001a\u000207H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u0005\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006^"}, m287d2 = {"BorderId", "", "OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", OutlinedTextFieldKt.BorderId, "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-zUg2_y0", "(IIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "isLabelInMiddleSection", "calculateWidth-O3s9Psw", "(IIIIIZJFLandroidx/compose/foundation/layout/PaddingValues;)I", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "height", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "borderPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class OutlinedTextFieldKt {
    public static final String BorderId = "border";
    private static final float OutlinedTextFieldInnerPadding = C0504Dp.m4382constructorimpl(4);
    private static final float OutlinedTextFieldTopPadding = C0504Dp.m4382constructorimpl(8);

    /* JADX WARN: Code restructure failed: missing block: B:55:0x01d0, code lost:
    
        if (r7.changed(r82) != false) goto L152;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedTextField(final String value, final Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        boolean readOnly2;
        TextStyle textStyle2;
        boolean isError2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        int maxLines2;
        KeyboardActions keyboardActions3;
        TextStyle textStyle3;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        CornerBasedShape shape2;
        boolean readOnly3;
        KeyboardActions keyboardActions4;
        MutableInteractionSource interactionSource4;
        Function2 leadingIcon;
        Function2 trailingIcon;
        VisualTransformation visualTransformation2;
        Function2 label;
        Function2 placeholder;
        boolean singleLine2;
        KeyboardOptions keyboardOptions3;
        Modifier modifier3;
        boolean enabled3;
        TextFieldColors colors2;
        TextStyle textStyle4;
        Shape shape3;
        int $dirty;
        int $dirty1;
        Object value$iv$iv;
        TextFieldColors colors3;
        Shape shape4;
        boolean isError3;
        TextStyle textStyle5;
        Composer $composer2;
        boolean enabled4;
        Modifier modifier4;
        KeyboardOptions keyboardOptions4;
        KeyboardActions keyboardActions5;
        boolean singleLine3;
        Function2 placeholder2;
        Function2 leadingIcon2;
        Function2 trailingIcon2;
        MutableInteractionSource interactionSource5;
        boolean readOnly4;
        VisualTransformation visualTransformation3;
        Function2 label2;
        int i2;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-2099955827);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)138@7622L7,149@8182L39,150@8256L6,151@8318L25,171@9089L24,180@9455L20,160@8646L2022:OutlinedTextField.kt#jmzs0o");
        int $dirty2 = $changed;
        int $dirty12 = $changed1;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer3.changed(onValueChange) ? 32 : 16;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i7 = i & 8;
        int i8 = 2048;
        if (i7 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i9 = i & 16;
        if (i9 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty2 |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0 && $composer3.changed(textStyle)) {
                i5 = 131072;
                $dirty2 |= i5;
            }
            i5 = 65536;
            $dirty2 |= i5;
        }
        int i10 = i & 64;
        if (i10 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty2 |= $composer3.changed(function2) ? 1048576 : 524288;
        }
        int i11 = i & 128;
        if (i11 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty2 |= $composer3.changed(function22) ? 8388608 : 4194304;
        }
        int i12 = i & 256;
        if (i12 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer3.changed(function23) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i13 = i & 512;
        if (i13 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty2 |= $composer3.changed(function24) ? 536870912 : 268435456;
        }
        int i14 = i & 1024;
        if (i14 != 0) {
            $dirty12 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty12 |= $composer3.changed(isError) ? 4 : 2;
        }
        int i15 = i & 2048;
        if (i15 != 0) {
            $dirty12 |= 48;
        } else if (($changed1 & SdkConfig.SDK_VERSION) == 0) {
            $dirty12 |= $composer3.changed(visualTransformation) ? 32 : 16;
        }
        if (($changed1 & 896) == 0) {
            if ((i & 4096) == 0 && $composer3.changed(keyboardOptions)) {
                i4 = 256;
                $dirty12 |= i4;
            }
            i4 = 128;
            $dirty12 |= i4;
        }
        if (($changed1 & 7168) == 0) {
            if ((i & 8192) != 0) {
            }
            i8 = 1024;
            $dirty12 |= i8;
        }
        int i16 = i & 16384;
        if (i16 != 0) {
            $dirty12 |= 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty12 |= $composer3.changed(singleLine) ? 16384 : 8192;
        }
        int i17 = i & 32768;
        if (i17 != 0) {
            $dirty12 |= 196608;
        } else if (($changed1 & 458752) == 0) {
            $dirty12 |= $composer3.changed(maxLines) ? 131072 : 65536;
        }
        int i18 = i & 65536;
        if (i18 != 0) {
            $dirty12 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty12 |= $composer3.changed(interactionSource) ? 1048576 : 524288;
        }
        if (($changed1 & 29360128) == 0) {
            if ((i & 131072) == 0 && $composer3.changed(shape)) {
                i3 = 8388608;
                $dirty12 |= i3;
            }
            i3 = 4194304;
            $dirty12 |= i3;
        }
        if (($changed1 & 234881024) == 0) {
            if ((i & 262144) == 0 && $composer3.changed(colors)) {
                i2 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty12 |= i2;
            }
            i2 = 33554432;
            $dirty12 |= i2;
        }
        if (($dirty2 & 1533916891) == 306783378 && (191739611 & $dirty12) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            enabled4 = enabled;
            readOnly4 = readOnly;
            textStyle5 = textStyle;
            label2 = function2;
            placeholder2 = function22;
            leadingIcon2 = function23;
            trailingIcon2 = function24;
            isError3 = isError;
            visualTransformation3 = visualTransformation;
            keyboardOptions4 = keyboardOptions;
            keyboardActions5 = keyboardActions;
            singleLine3 = singleLine;
            maxLines2 = maxLines;
            interactionSource5 = interactionSource;
            shape4 = shape;
            colors3 = colors;
            $composer2 = $composer3;
            modifier4 = modifier2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                boolean enabled5 = i7 != 0 ? true : enabled;
                boolean readOnly5 = i9 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    enabled2 = enabled5;
                    readOnly2 = readOnly5;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle2 = (TextStyle) consume;
                    $dirty2 &= -458753;
                } else {
                    enabled2 = enabled5;
                    readOnly2 = readOnly5;
                    textStyle2 = textStyle;
                }
                Function2 label3 = i10 != 0 ? null : function2;
                Function2 placeholder3 = i11 != 0 ? null : function22;
                Function2 leadingIcon3 = i12 != 0 ? null : function23;
                Function2 trailingIcon3 = i13 != 0 ? null : function24;
                isError2 = i14 != 0 ? false : isError;
                VisualTransformation visualTransformation4 = i15 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                if ((i & 4096) != 0) {
                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    $dirty12 &= -897;
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                int $dirty3 = $dirty2;
                if ((i & 8192) != 0) {
                    keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                    $dirty12 &= -7169;
                } else {
                    keyboardActions2 = keyboardActions;
                }
                boolean singleLine4 = i16 != 0 ? false : singleLine;
                maxLines2 = i17 != 0 ? Integer.MAX_VALUE : maxLines;
                if (i18 != 0) {
                    keyboardActions3 = keyboardActions2;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    textStyle3 = textStyle2;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    keyboardActions3 = keyboardActions2;
                    textStyle3 = textStyle2;
                    interactionSource2 = interactionSource;
                }
                if ((i & 131072) != 0) {
                    interactionSource3 = interactionSource2;
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall();
                    $dirty12 &= -29360129;
                } else {
                    interactionSource3 = interactionSource2;
                    shape2 = shape;
                }
                if ((262144 & i) != 0) {
                    readOnly3 = readOnly2;
                    keyboardActions4 = keyboardActions3;
                    interactionSource4 = interactionSource3;
                    leadingIcon = leadingIcon3;
                    trailingIcon = trailingIcon3;
                    visualTransformation2 = visualTransformation4;
                    label = label3;
                    placeholder = placeholder3;
                    singleLine2 = singleLine4;
                    keyboardOptions3 = keyboardOptions2;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    textStyle4 = textStyle3;
                    shape3 = shape2;
                    $dirty = $dirty12 & (-234881025);
                    colors2 = TextFieldDefaults.INSTANCE.m1563outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 48, 2097151);
                    $dirty1 = $dirty3;
                } else {
                    readOnly3 = readOnly2;
                    keyboardActions4 = keyboardActions3;
                    interactionSource4 = interactionSource3;
                    leadingIcon = leadingIcon3;
                    trailingIcon = trailingIcon3;
                    visualTransformation2 = visualTransformation4;
                    label = label3;
                    placeholder = placeholder3;
                    singleLine2 = singleLine4;
                    keyboardOptions3 = keyboardOptions2;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    colors2 = colors;
                    textStyle4 = textStyle3;
                    shape3 = shape2;
                    $dirty = $dirty12;
                    $dirty1 = $dirty3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 4096) != 0) {
                    $dirty12 &= -897;
                }
                if ((i & 8192) != 0) {
                    $dirty12 &= -7169;
                }
                if ((i & 131072) != 0) {
                    $dirty12 &= -29360129;
                }
                if ((262144 & i) != 0) {
                    $dirty12 &= -234881025;
                }
                enabled3 = enabled;
                readOnly3 = readOnly;
                textStyle4 = textStyle;
                label = function2;
                placeholder = function22;
                leadingIcon = function23;
                trailingIcon = function24;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                keyboardOptions3 = keyboardOptions;
                keyboardActions4 = keyboardActions;
                singleLine2 = singleLine;
                maxLines2 = maxLines;
                interactionSource4 = interactionSource;
                shape3 = shape;
                colors2 = colors;
                modifier3 = modifier2;
                int i19 = $dirty12;
                $dirty1 = $dirty2;
                $dirty = i19;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2099955827, $dirty1, $dirty, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:132)");
            }
            $composer3.startReplaceableGroup(1961395022);
            ComposerKt.sourceInformation($composer3, "*155@8495L18");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle4.m3975getColor0d7_KjU();
            long textColor = ($this$takeOrElse_u2dDxMtmZc$iv > Color.INSTANCE.m2032getUnspecified0d7_KjU() ? 1 : ($this$takeOrElse_u2dDxMtmZc$iv == Color.INSTANCE.m2032getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? $this$takeOrElse_u2dDxMtmZc$iv : colors2.textColor(enabled3, $composer3, (($dirty1 >> 9) & 14) | (($dirty >> 21) & SdkConfig.SDK_VERSION)).getValue().m2006unboximpl();
            $composer3.endReplaceableGroup();
            TextStyle mergedTextStyle = textStyle4.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
            final boolean z = enabled3;
            final boolean z2 = singleLine2;
            final VisualTransformation visualTransformation5 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource = interactionSource4;
            final boolean z3 = isError2;
            final Function2 function25 = label;
            final Function2 function26 = placeholder;
            final Function2 function27 = leadingIcon;
            final Function2 function28 = trailingIcon;
            final TextFieldColors textFieldColors = colors2;
            final int i20 = $dirty1;
            final int i21 = $dirty;
            final Shape shape5 = shape3;
            colors3 = colors2;
            shape4 = shape3;
            isError3 = isError2;
            textStyle5 = textStyle4;
            $composer2 = $composer3;
            enabled4 = enabled3;
            modifier4 = modifier3;
            BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m784defaultMinSizeVpY3zN4(BackgroundKt.m494backgroundbw27NRU(label != null ? PaddingKt.m763paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier3, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                }
            }), 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null) : modifier3, colors2.backgroundColor(enabled3, $composer3, (($dirty1 >> 9) & 14) | (($dirty >> 21) & SdkConfig.SDK_VERSION)).getValue().m2006unboximpl(), shape3), TextFieldDefaults.INSTANCE.m1560getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1559getMinHeightD9Ej5fM()), enabled3, readOnly3, mergedTextStyle, keyboardOptions3, keyboardActions4, singleLine2, maxLines2, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, interactionSource4, new SolidColor(colors2.cursorColor(isError2, $composer3, ($dirty & 14) | (($dirty >> 21) & SdkConfig.SDK_VERSION)).getValue().m2006unboximpl(), null), ComposableLambdaKt.composableLambda($composer3, 986454116, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function29, Composer composer, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function29, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                    ComposerKt.sourceInformation($composer4, "C188@9818L834:OutlinedTextField.kt#jmzs0o");
                    int $dirty4 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty4 |= $composer4.changed(innerTextField) ? 4 : 2;
                    }
                    int $dirty5 = $dirty4;
                    if (($dirty5 & 91) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(986454116, $dirty5, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:187)");
                        }
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        String str = value;
                        boolean z4 = z;
                        boolean z5 = z2;
                        VisualTransformation visualTransformation6 = visualTransformation5;
                        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                        boolean z6 = z3;
                        Function2<Composer, Integer, Unit> function29 = function25;
                        Function2<Composer, Integer, Unit> function210 = function26;
                        Function2<Composer, Integer, Unit> function211 = function27;
                        Function2<Composer, Integer, Unit> function212 = function28;
                        TextFieldColors textFieldColors2 = textFieldColors;
                        final boolean z7 = z;
                        final boolean z8 = z3;
                        final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
                        final TextFieldColors textFieldColors3 = textFieldColors;
                        final Shape shape6 = shape5;
                        final int i22 = i20;
                        final int i23 = i21;
                        textFieldDefaults.OutlinedTextFieldDecorationBox(str, innerTextField, z4, z5, visualTransformation6, mutableInteractionSource2, z6, function29, function210, function211, function212, textFieldColors2, null, ComposableLambdaKt.composableLambda($composer4, 329542189, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C202@10417L203:OutlinedTextField.kt#jmzs0o");
                                if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(329542189, $changed3, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:201)");
                                    }
                                    TextFieldDefaults.INSTANCE.m1557BorderBoxnbWgWpA(z7, z8, mutableInteractionSource3, textFieldColors3, shape6, 0.0f, 0.0f, $composer5, ((i22 >> 9) & 14) | 12582912 | ((i23 << 3) & SdkConfig.SDK_VERSION) | ((i23 >> 12) & 896) | ((i23 >> 15) & 7168) | ((i23 >> 9) & 57344), 96);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }), $composer4, (i20 & 14) | (($dirty5 << 3) & SdkConfig.SDK_VERSION) | ((i20 >> 3) & 896) | ((i21 >> 3) & 7168) | ((i21 << 9) & 57344) | ((i21 >> 3) & 458752) | ((i21 << 18) & 3670016) | ((i20 << 3) & 29360128) | ((i20 << 3) & 234881024) | ((i20 << 3) & 1879048192), ((i20 >> 27) & 14) | 27648 | ((i21 >> 21) & SdkConfig.SDK_VERSION), 4096);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, ($dirty1 & 14) | ($dirty1 & SdkConfig.SDK_VERSION) | ($dirty1 & 7168) | ($dirty1 & 57344) | (($dirty << 12) & 3670016) | (KeyboardActions.$stable << 21) | (($dirty << 12) & 29360128) | (($dirty << 12) & 234881024) | (($dirty << 12) & 1879048192), (($dirty >> 3) & 14) | 24576 | (($dirty >> 12) & 896), 2048);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            keyboardOptions4 = keyboardOptions3;
            keyboardActions5 = keyboardActions4;
            singleLine3 = singleLine2;
            placeholder2 = placeholder;
            leadingIcon2 = leadingIcon;
            trailingIcon2 = trailingIcon;
            interactionSource5 = interactionSource4;
            readOnly4 = readOnly3;
            visualTransformation3 = visualTransformation2;
            label2 = label;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier4;
        final boolean z4 = enabled4;
        final boolean z5 = readOnly4;
        final TextStyle textStyle6 = textStyle5;
        final Function2 function29 = label2;
        final Function2 function210 = placeholder2;
        final Function2 function211 = leadingIcon2;
        final Function2 function212 = trailingIcon2;
        final boolean z6 = isError3;
        final VisualTransformation visualTransformation6 = visualTransformation3;
        final KeyboardOptions keyboardOptions5 = keyboardOptions4;
        final KeyboardActions keyboardActions6 = keyboardActions5;
        final boolean z7 = singleLine3;
        final int i22 = maxLines2;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource5;
        final Shape shape6 = shape4;
        final TextFieldColors textFieldColors2 = colors3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$4
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

            public final void invoke(Composer composer, int i23) {
                OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier5, z4, z5, textStyle6, function29, function210, function211, function212, z6, visualTransformation6, keyboardOptions5, keyboardActions6, z7, i22, mutableInteractionSource2, shape6, textFieldColors2, composer, $changed | 1, $changed1, i);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x01d0, code lost:
    
        if (r7.changed(r82) != false) goto L152;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedTextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        boolean readOnly2;
        TextStyle textStyle2;
        boolean isError2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        int maxLines2;
        KeyboardActions keyboardActions3;
        TextStyle textStyle3;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        Shape shape2;
        boolean readOnly3;
        KeyboardActions keyboardActions4;
        MutableInteractionSource interactionSource4;
        Function2 leadingIcon;
        Function2 trailingIcon;
        VisualTransformation visualTransformation2;
        Function2 label;
        Function2 placeholder;
        boolean singleLine2;
        KeyboardOptions keyboardOptions3;
        Modifier modifier3;
        boolean enabled3;
        TextFieldColors colors2;
        TextStyle textStyle4;
        Shape shape3;
        int $dirty;
        int $dirty1;
        Object value$iv$iv;
        TextFieldColors colors3;
        Shape shape4;
        boolean isError3;
        TextStyle textStyle5;
        Composer $composer2;
        boolean enabled4;
        Modifier modifier4;
        KeyboardOptions keyboardOptions4;
        KeyboardActions keyboardActions5;
        boolean singleLine3;
        Function2 placeholder2;
        Function2 leadingIcon2;
        Function2 trailingIcon2;
        MutableInteractionSource interactionSource5;
        boolean readOnly4;
        VisualTransformation visualTransformation3;
        Function2 label2;
        int i2;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-288998816);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)286@15446L7,297@16000L39,298@16078L22,299@16150L25,319@16921L24,328@17287L20,308@16478L2027:OutlinedTextField.kt#jmzs0o");
        int $dirty2 = $changed;
        int $dirty12 = $changed1;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer3.changed(onValueChange) ? 32 : 16;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i7 = i & 8;
        int i8 = 2048;
        if (i7 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i9 = i & 16;
        if (i9 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty2 |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0 && $composer3.changed(textStyle)) {
                i5 = 131072;
                $dirty2 |= i5;
            }
            i5 = 65536;
            $dirty2 |= i5;
        }
        int i10 = i & 64;
        if (i10 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty2 |= $composer3.changed(function2) ? 1048576 : 524288;
        }
        int i11 = i & 128;
        if (i11 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty2 |= $composer3.changed(function22) ? 8388608 : 4194304;
        }
        int i12 = i & 256;
        if (i12 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer3.changed(function23) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i13 = i & 512;
        if (i13 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty2 |= $composer3.changed(function24) ? 536870912 : 268435456;
        }
        int i14 = i & 1024;
        if (i14 != 0) {
            $dirty12 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty12 |= $composer3.changed(isError) ? 4 : 2;
        }
        int i15 = i & 2048;
        if (i15 != 0) {
            $dirty12 |= 48;
        } else if (($changed1 & SdkConfig.SDK_VERSION) == 0) {
            $dirty12 |= $composer3.changed(visualTransformation) ? 32 : 16;
        }
        if (($changed1 & 896) == 0) {
            if ((i & 4096) == 0 && $composer3.changed(keyboardOptions)) {
                i4 = 256;
                $dirty12 |= i4;
            }
            i4 = 128;
            $dirty12 |= i4;
        }
        if (($changed1 & 7168) == 0) {
            if ((i & 8192) != 0) {
            }
            i8 = 1024;
            $dirty12 |= i8;
        }
        int i16 = i & 16384;
        if (i16 != 0) {
            $dirty12 |= 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty12 |= $composer3.changed(singleLine) ? 16384 : 8192;
        }
        int i17 = i & 32768;
        if (i17 != 0) {
            $dirty12 |= 196608;
        } else if (($changed1 & 458752) == 0) {
            $dirty12 |= $composer3.changed(maxLines) ? 131072 : 65536;
        }
        int i18 = i & 65536;
        if (i18 != 0) {
            $dirty12 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty12 |= $composer3.changed(interactionSource) ? 1048576 : 524288;
        }
        if (($changed1 & 29360128) == 0) {
            if ((i & 131072) == 0 && $composer3.changed(shape)) {
                i3 = 8388608;
                $dirty12 |= i3;
            }
            i3 = 4194304;
            $dirty12 |= i3;
        }
        if (($changed1 & 234881024) == 0) {
            if ((i & 262144) == 0 && $composer3.changed(colors)) {
                i2 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty12 |= i2;
            }
            i2 = 33554432;
            $dirty12 |= i2;
        }
        if (($dirty2 & 1533916891) == 306783378 && (191739611 & $dirty12) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            enabled4 = enabled;
            readOnly4 = readOnly;
            textStyle5 = textStyle;
            label2 = function2;
            placeholder2 = function22;
            leadingIcon2 = function23;
            trailingIcon2 = function24;
            isError3 = isError;
            visualTransformation3 = visualTransformation;
            keyboardOptions4 = keyboardOptions;
            keyboardActions5 = keyboardActions;
            singleLine3 = singleLine;
            maxLines2 = maxLines;
            interactionSource5 = interactionSource;
            shape4 = shape;
            colors3 = colors;
            $composer2 = $composer3;
            modifier4 = modifier2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                boolean enabled5 = i7 != 0 ? true : enabled;
                boolean readOnly5 = i9 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    enabled2 = enabled5;
                    readOnly2 = readOnly5;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle2 = (TextStyle) consume;
                    $dirty2 &= -458753;
                } else {
                    enabled2 = enabled5;
                    readOnly2 = readOnly5;
                    textStyle2 = textStyle;
                }
                Function2 label3 = i10 != 0 ? null : function2;
                Function2 placeholder3 = i11 != 0 ? null : function22;
                Function2 leadingIcon3 = i12 != 0 ? null : function23;
                Function2 trailingIcon3 = i13 != 0 ? null : function24;
                isError2 = i14 != 0 ? false : isError;
                VisualTransformation visualTransformation4 = i15 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                if ((i & 4096) != 0) {
                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                    $dirty12 &= -897;
                } else {
                    keyboardOptions2 = keyboardOptions;
                }
                int $dirty3 = $dirty2;
                if ((i & 8192) != 0) {
                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                    $dirty12 &= -7169;
                } else {
                    keyboardActions2 = keyboardActions;
                }
                boolean singleLine4 = i16 != 0 ? false : singleLine;
                maxLines2 = i17 != 0 ? Integer.MAX_VALUE : maxLines;
                if (i18 != 0) {
                    keyboardActions3 = keyboardActions2;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    textStyle3 = textStyle2;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    keyboardActions3 = keyboardActions2;
                    textStyle3 = textStyle2;
                    interactionSource2 = interactionSource;
                }
                if ((i & 131072) != 0) {
                    interactionSource3 = interactionSource2;
                    shape2 = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape($composer3, 6);
                    $dirty12 &= -29360129;
                } else {
                    interactionSource3 = interactionSource2;
                    shape2 = shape;
                }
                if ((262144 & i) != 0) {
                    readOnly3 = readOnly2;
                    keyboardActions4 = keyboardActions3;
                    interactionSource4 = interactionSource3;
                    leadingIcon = leadingIcon3;
                    trailingIcon = trailingIcon3;
                    visualTransformation2 = visualTransformation4;
                    label = label3;
                    placeholder = placeholder3;
                    singleLine2 = singleLine4;
                    keyboardOptions3 = keyboardOptions2;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    textStyle4 = textStyle3;
                    shape3 = shape2;
                    $dirty = $dirty12 & (-234881025);
                    colors2 = TextFieldDefaults.INSTANCE.m1563outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 48, 2097151);
                    $dirty1 = $dirty3;
                } else {
                    readOnly3 = readOnly2;
                    keyboardActions4 = keyboardActions3;
                    interactionSource4 = interactionSource3;
                    leadingIcon = leadingIcon3;
                    trailingIcon = trailingIcon3;
                    visualTransformation2 = visualTransformation4;
                    label = label3;
                    placeholder = placeholder3;
                    singleLine2 = singleLine4;
                    keyboardOptions3 = keyboardOptions2;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    colors2 = colors;
                    textStyle4 = textStyle3;
                    shape3 = shape2;
                    $dirty = $dirty12;
                    $dirty1 = $dirty3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 4096) != 0) {
                    $dirty12 &= -897;
                }
                if ((i & 8192) != 0) {
                    $dirty12 &= -7169;
                }
                if ((i & 131072) != 0) {
                    $dirty12 &= -29360129;
                }
                if ((262144 & i) != 0) {
                    $dirty12 &= -234881025;
                }
                enabled3 = enabled;
                readOnly3 = readOnly;
                textStyle4 = textStyle;
                label = function2;
                placeholder = function22;
                leadingIcon = function23;
                trailingIcon = function24;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                keyboardOptions3 = keyboardOptions;
                keyboardActions4 = keyboardActions;
                singleLine2 = singleLine;
                maxLines2 = maxLines;
                interactionSource4 = interactionSource;
                shape3 = shape;
                colors2 = colors;
                modifier3 = modifier2;
                int i19 = $dirty12;
                $dirty1 = $dirty2;
                $dirty = i19;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-288998816, $dirty1, $dirty, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:280)");
            }
            $composer3.startReplaceableGroup(1961402854);
            ComposerKt.sourceInformation($composer3, "*303@16327L18");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle4.m3975getColor0d7_KjU();
            long textColor = ($this$takeOrElse_u2dDxMtmZc$iv > Color.INSTANCE.m2032getUnspecified0d7_KjU() ? 1 : ($this$takeOrElse_u2dDxMtmZc$iv == Color.INSTANCE.m2032getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? $this$takeOrElse_u2dDxMtmZc$iv : colors2.textColor(enabled3, $composer3, (($dirty1 >> 9) & 14) | (($dirty >> 21) & SdkConfig.SDK_VERSION)).getValue().m2006unboximpl();
            $composer3.endReplaceableGroup();
            TextStyle mergedTextStyle = textStyle4.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
            final boolean z = enabled3;
            final boolean z2 = singleLine2;
            final VisualTransformation visualTransformation5 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource = interactionSource4;
            final boolean z3 = isError2;
            final Function2 function25 = label;
            final Function2 function26 = placeholder;
            final Function2 function27 = leadingIcon;
            final Function2 function28 = trailingIcon;
            final TextFieldColors textFieldColors = colors2;
            final int i20 = $dirty1;
            final int i21 = $dirty;
            final Shape shape5 = shape3;
            colors3 = colors2;
            shape4 = shape3;
            isError3 = isError2;
            textStyle5 = textStyle4;
            $composer2 = $composer3;
            enabled4 = enabled3;
            modifier4 = modifier3;
            BasicTextFieldKt.BasicTextField(value, onValueChange, SizeKt.m784defaultMinSizeVpY3zN4(BackgroundKt.m494backgroundbw27NRU(label != null ? PaddingKt.m763paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier3, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$6
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                }
            }), 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null) : modifier3, colors2.backgroundColor(enabled3, $composer3, (($dirty1 >> 9) & 14) | (($dirty >> 21) & SdkConfig.SDK_VERSION)).getValue().m2006unboximpl(), shape3), TextFieldDefaults.INSTANCE.m1560getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1559getMinHeightD9Ej5fM()), enabled3, readOnly3, mergedTextStyle, keyboardOptions3, keyboardActions4, singleLine2, maxLines2, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, interactionSource4, new SolidColor(colors2.cursorColor(isError2, $composer3, ($dirty & 14) | (($dirty >> 21) & SdkConfig.SDK_VERSION)).getValue().m2006unboximpl(), null), ComposableLambdaKt.composableLambda($composer3, -1219079113, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function29, Composer composer, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function29, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
                    ComposerKt.sourceInformation($composer4, "C336@17650L839:OutlinedTextField.kt#jmzs0o");
                    int $dirty4 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty4 |= $composer4.changed(innerTextField) ? 4 : 2;
                    }
                    int $dirty5 = $dirty4;
                    if (($dirty5 & 91) == 18 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1219079113, $dirty5, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:335)");
                    }
                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                    String text = TextFieldValue.this.getText();
                    boolean z4 = z;
                    boolean z5 = z2;
                    VisualTransformation visualTransformation6 = visualTransformation5;
                    MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                    boolean z6 = z3;
                    Function2<Composer, Integer, Unit> function29 = function25;
                    Function2<Composer, Integer, Unit> function210 = function26;
                    Function2<Composer, Integer, Unit> function211 = function27;
                    Function2<Composer, Integer, Unit> function212 = function28;
                    TextFieldColors textFieldColors2 = textFieldColors;
                    final boolean z7 = z;
                    final boolean z8 = z3;
                    final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
                    final TextFieldColors textFieldColors3 = textFieldColors;
                    final Shape shape6 = shape5;
                    final int i22 = i20;
                    final int i23 = i21;
                    textFieldDefaults.OutlinedTextFieldDecorationBox(text, innerTextField, z4, z5, visualTransformation6, mutableInteractionSource2, z6, function29, function210, function211, function212, textFieldColors2, null, ComposableLambdaKt.composableLambda($composer4, 1225313536, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$7.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer5, int $changed3) {
                            ComposerKt.sourceInformation($composer5, "C350@18254L203:OutlinedTextField.kt#jmzs0o");
                            if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1225313536, $changed3, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:349)");
                                }
                                TextFieldDefaults.INSTANCE.m1557BorderBoxnbWgWpA(z7, z8, mutableInteractionSource3, textFieldColors3, shape6, 0.0f, 0.0f, $composer5, ((i22 >> 9) & 14) | 12582912 | ((i23 << 3) & SdkConfig.SDK_VERSION) | ((i23 >> 12) & 896) | ((i23 >> 15) & 7168) | ((i23 >> 9) & 57344), 96);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer5.skipToGroupEnd();
                        }
                    }), $composer4, (($dirty5 << 3) & SdkConfig.SDK_VERSION) | ((i20 >> 3) & 896) | ((i21 >> 3) & 7168) | ((i21 << 9) & 57344) | ((i21 >> 3) & 458752) | ((i21 << 18) & 3670016) | ((i20 << 3) & 29360128) | ((i20 << 3) & 234881024) | ((i20 << 3) & 1879048192), ((i20 >> 27) & 14) | 27648 | ((i21 >> 21) & SdkConfig.SDK_VERSION), 4096);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), $composer2, ($dirty1 & 14) | ($dirty1 & SdkConfig.SDK_VERSION) | ($dirty1 & 7168) | ($dirty1 & 57344) | (($dirty << 12) & 3670016) | (KeyboardActions.$stable << 21) | (($dirty << 12) & 29360128) | (($dirty << 12) & 234881024) | (($dirty << 12) & 1879048192), (($dirty >> 3) & 14) | 24576 | (($dirty >> 12) & 896), 2048);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            keyboardOptions4 = keyboardOptions3;
            keyboardActions5 = keyboardActions4;
            singleLine3 = singleLine2;
            placeholder2 = placeholder;
            leadingIcon2 = leadingIcon;
            trailingIcon2 = trailingIcon;
            interactionSource5 = interactionSource4;
            readOnly4 = readOnly3;
            visualTransformation3 = visualTransformation2;
            label2 = label;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier4;
        final boolean z4 = enabled4;
        final boolean z5 = readOnly4;
        final TextStyle textStyle6 = textStyle5;
        final Function2 function29 = label2;
        final Function2 function210 = placeholder2;
        final Function2 function211 = leadingIcon2;
        final Function2 function212 = trailingIcon2;
        final boolean z6 = isError3;
        final VisualTransformation visualTransformation6 = visualTransformation3;
        final KeyboardOptions keyboardOptions5 = keyboardOptions4;
        final KeyboardActions keyboardActions6 = keyboardActions5;
        final boolean z7 = singleLine3;
        final int i22 = maxLines2;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource5;
        final Shape shape6 = shape4;
        final TextFieldColors textFieldColors2 = colors3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$8
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

            public final void invoke(Composer composer, int i23) {
                OutlinedTextFieldKt.OutlinedTextField(TextFieldValue.this, onValueChange, modifier5, z4, z5, textStyle6, function29, function210, function211, function212, z6, visualTransformation6, keyboardOptions5, keyboardActions6, z7, i22, mutableInteractionSource2, shape6, textFieldColors2, composer, $changed | 1, $changed1, i);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0a0f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x065b  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x067f  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0795  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x07a1  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x087b  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x07a5  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x069e  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x067a  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0644  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0247  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedTextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> textField, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final boolean singleLine, final float animationProgress, final Function1<? super Size, Unit> onLabelMeasured, final Function2<? super Composer, ? super Integer, Unit> border, final PaddingValues paddingValues, Composer $composer, final int $changed, final int $changed1) {
        int $dirty1;
        int $changed$iv$iv;
        LayoutDirection layoutDirection;
        Composer $composer2;
        String str;
        float f;
        float f2;
        int $changed$iv;
        int $changed2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(textField, "textField");
        Intrinsics.checkNotNullParameter(onLabelMeasured, "onLabelMeasured");
        Intrinsics.checkNotNullParameter(border, "border");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer $composer3 = $composer.startRestartGroup(-2049536174);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextFieldLayout)P(4,9,7,2,3,10,8!1,5)383@19226L239,391@19513L7,392@19525L2308:OutlinedTextField.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(modifier) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer3.changed(textField) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(function3) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer3.changed(function2) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer3.changed(function22) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer3.changed(function23) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            $dirty |= $composer3.changed(singleLine) ? 1048576 : 524288;
        }
        if ((29360128 & $changed) == 0) {
            $dirty |= $composer3.changed(animationProgress) ? 8388608 : 4194304;
        }
        if ((234881024 & $changed) == 0) {
            $dirty |= $composer3.changed(onLabelMeasured) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((1879048192 & $changed) == 0) {
            $dirty |= $composer3.changed(border) ? 536870912 : 268435456;
        }
        if (($changed1 & 14) == 0) {
            $dirty12 |= $composer3.changed(paddingValues) ? 4 : 2;
        }
        if ((1533916891 & $dirty) != 306783378 || ($dirty12 & 11) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2049536174, $dirty, $dirty12, "androidx.compose.material.OutlinedTextFieldLayout (OutlinedTextField.kt:370)");
            }
            Object[] keys$iv = {onLabelMeasured, Boolean.valueOf(singleLine), Float.valueOf(animationProgress), paddingValues};
            $dirty1 = $dirty12;
            $composer3.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer3, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            int length = keys$iv.length;
            int $changed$iv2 = 0;
            while ($changed$iv2 < length) {
                int i = length;
                Object key$iv = keys$iv[$changed$iv2];
                invalid$iv |= $composer3.changed(key$iv);
                $changed$iv2++;
                length = i;
            }
            Object value$iv$iv = $composer3.rememberedValue();
            if (!invalid$iv && value$iv$iv != Composer.INSTANCE.getEmpty()) {
                $composer3.endReplaceableGroup();
                OutlinedTextFieldMeasurePolicy measurePolicy = (OutlinedTextFieldMeasurePolicy) value$iv$iv;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = $composer3.consume(localLayoutDirection);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection2 = (LayoutDirection) consume;
                int $changed$iv3 = ($dirty << 3) & SdkConfig.SDK_VERSION;
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume2 = $composer3.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv = (Density) consume2;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume3 = $composer3.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv = (LayoutDirection) consume3;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer3.consume(localViewConfiguration);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume4;
                Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier);
                $changed$iv$iv = (($changed$iv3 << 9) & 7168) | 6;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if (!$composer3.getInserting()) {
                    $composer3.createNode(factory$iv$iv);
                } else {
                    $composer3.useNode();
                }
                $composer3.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv = Updater.m1639constructorimpl($composer3);
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, density$iv, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, layoutDirection$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, viewConfiguration$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer3.enableReusing();
                skippableUpdate$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                $composer3.startReplaceableGroup(2058660585);
                $composer3.startReplaceableGroup(118153609);
                ComposerKt.sourceInformation($composer3, "C400@20029L8,439@21477L182,447@21710L54:OutlinedTextField.kt#jmzs0o");
                if ((($changed$iv$iv >> 9) & 14 & 11) == 2 || !$composer3.getSkipping()) {
                    border.invoke($composer3, Integer.valueOf(($dirty >> 27) & 14));
                    $composer3.startReplaceableGroup(1169914597);
                    ComposerKt.sourceInformation($composer3, "403@20090L219");
                    if (function22 != null) {
                        layoutDirection = layoutDirection2;
                        $composer2 = $composer3;
                    } else {
                        Modifier modifier$iv = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.LeadingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                        $composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv2 = (48 << 3) & SdkConfig.SDK_VERSION;
                        $composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume5 = $composer3.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Density density$iv$iv = (Density) consume5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume6 = $composer3.consume(localLayoutDirection3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume6;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                        $composer2 = $composer3;
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume7 = $composer3.consume(localViewConfiguration2);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume7;
                        Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                        int $changed$iv$iv$iv = (($changed$iv$iv2 << 9) & 7168) | 6;
                        layoutDirection = layoutDirection2;
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(factory$iv$iv$iv);
                        } else {
                            $composer3.useNode();
                        }
                        $composer3.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer3);
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer3.enableReusing();
                        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                        $composer3.startReplaceableGroup(2058660585);
                        int $changed$iv4 = ($changed$iv$iv$iv >> 9) & 14;
                        $composer3.startReplaceableGroup(-2137368960);
                        ComposerKt.sourceInformation($composer3, "C72@3384L9:Box.kt#2w3rfo");
                        if (($changed$iv4 & 11) == 2 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                        } else {
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            int $changed3 = ((48 >> 6) & SdkConfig.SDK_VERSION) | 6;
                            $composer3.startReplaceableGroup(1691709354);
                            ComposerKt.sourceInformation($composer3, "C407@20282L9:OutlinedTextField.kt#jmzs0o");
                            if (($changed3 & 81) == 16 && $composer3.getSkipping()) {
                                $composer3.skipToGroupEnd();
                            } else {
                                function22.invoke($composer3, Integer.valueOf(($dirty >> 12) & 14));
                            }
                            $composer3.endReplaceableGroup();
                        }
                        $composer3.endReplaceableGroup();
                        $composer3.endReplaceableGroup();
                        $composer3.endNode();
                        $composer3.endReplaceableGroup();
                        $composer3.endReplaceableGroup();
                    }
                    $composer3.endReplaceableGroup();
                    $composer3.startReplaceableGroup(1169914882);
                    ComposerKt.sourceInformation($composer3, "411@20376L221");
                    if (function23 != null) {
                        str = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh";
                    } else {
                        Modifier modifier$iv2 = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.TrailingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                        Alignment contentAlignment$iv2 = Alignment.INSTANCE.getCenter();
                        $composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv3 = (48 << 3) & SdkConfig.SDK_VERSION;
                        $composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume8 = $composer3.consume(localDensity3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Density density$iv$iv2 = (Density) consume8;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume9 = $composer3.consume(localLayoutDirection4);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume9;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                        str = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh";
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume10 = $composer3.consume(localViewConfiguration3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume10;
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                        int $changed$iv$iv$iv2 = (($changed$iv$iv3 << 9) & 7168) | 6;
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(factory$iv$iv$iv2);
                        } else {
                            $composer3.useNode();
                        }
                        $composer3.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer3);
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer3.enableReusing();
                        skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                        $composer3.startReplaceableGroup(2058660585);
                        int $changed$iv5 = ($changed$iv$iv$iv2 >> 9) & 14;
                        $composer3.startReplaceableGroup(-2137368960);
                        ComposerKt.sourceInformation($composer3, "C72@3384L9:Box.kt#2w3rfo");
                        if (($changed$iv5 & 11) == 2 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                        } else {
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            int $changed4 = ((48 >> 6) & SdkConfig.SDK_VERSION) | 6;
                            $composer3.startReplaceableGroup(-1351586719);
                            ComposerKt.sourceInformation($composer3, "C415@20569L10:OutlinedTextField.kt#jmzs0o");
                            if (($changed4 & 81) == 16 && $composer3.getSkipping()) {
                                $composer3.skipToGroupEnd();
                            } else {
                                function23.invoke($composer3, Integer.valueOf(($dirty >> 15) & 14));
                            }
                            $composer3.endReplaceableGroup();
                        }
                        $composer3.endReplaceableGroup();
                        $composer3.endReplaceableGroup();
                        $composer3.endNode();
                        $composer3.endReplaceableGroup();
                        $composer3.endReplaceableGroup();
                    }
                    $composer3.endReplaceableGroup();
                    LayoutDirection layoutDirection3 = layoutDirection;
                    float startTextFieldPadding = PaddingKt.calculateStartPadding(paddingValues, layoutDirection3);
                    float endTextFieldPadding = PaddingKt.calculateEndPadding(paddingValues, layoutDirection3);
                    Modifier.Companion companion = Modifier.INSTANCE;
                    if (function22 == null) {
                        float other$iv = TextFieldImplKt.getHorizontalIconPadding();
                        float other$iv2 = C0504Dp.m4382constructorimpl(startTextFieldPadding - other$iv);
                        float minimumValue$iv = C0504Dp.m4382constructorimpl(0);
                        float $this$coerceAtLeast_u2dYgX7TsA$iv = C0504Dp.m4382constructorimpl(RangesKt.coerceAtLeast(other$iv2, minimumValue$iv));
                        f = $this$coerceAtLeast_u2dYgX7TsA$iv;
                    } else {
                        f = startTextFieldPadding;
                    }
                    if (function23 == null) {
                        float other$iv3 = TextFieldImplKt.getHorizontalIconPadding();
                        float other$iv4 = C0504Dp.m4382constructorimpl(endTextFieldPadding - other$iv3);
                        float minimumValue$iv2 = C0504Dp.m4382constructorimpl(0);
                        float $this$coerceAtLeast_u2dYgX7TsA$iv2 = C0504Dp.m4382constructorimpl(RangesKt.coerceAtLeast(other$iv4, minimumValue$iv2));
                        f2 = $this$coerceAtLeast_u2dYgX7TsA$iv2;
                    } else {
                        f2 = endTextFieldPadding;
                    }
                    Modifier padding = PaddingKt.m763paddingqDBjuR0$default(companion, f, 0.0f, f2, 0.0f, 10, null);
                    $composer3.startReplaceableGroup(1169915893);
                    ComposerKt.sourceInformation($composer3, "436@21390L59");
                    if (function3 != null) {
                        function3.invoke(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.PlaceholderId).then(padding), $composer3, Integer.valueOf(($dirty >> 3) & SdkConfig.SDK_VERSION));
                    }
                    $composer3.endReplaceableGroup();
                    Modifier modifier$iv3 = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.TextFieldId).then(padding);
                    $composer3.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv3, true, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv4 = (384 << 3) & SdkConfig.SDK_VERSION;
                    $composer3.startReplaceableGroup(-1323940314);
                    String str2 = str;
                    ComposerKt.sourceInformation($composer3, str2);
                    ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume11 = $composer3.consume(localDensity4);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Density density$iv$iv3 = (Density) consume11;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume12 = $composer3.consume(localLayoutDirection5);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume12;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration4 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume13 = $composer3.consume(localViewConfiguration4);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume13;
                    Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv3 = LayoutKt.materializerOf(modifier$iv3);
                    int $changed$iv$iv$iv3 = (($changed$iv$iv4 << 9) & 7168) | 6;
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if (!$composer3.getInserting()) {
                        $composer3.createNode(factory$iv$iv$iv3);
                    } else {
                        $composer3.useNode();
                    }
                    $composer3.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m1639constructorimpl($composer3);
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    $composer3.enableReusing();
                    skippableUpdate$iv$iv$iv3.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & SdkConfig.SDK_VERSION));
                    $composer3.startReplaceableGroup(2058660585);
                    $changed$iv = ($changed$iv$iv$iv3 >> 9) & 14;
                    $composer3.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer3, "C72@3384L9:Box.kt#2w3rfo");
                    if (($changed$iv & 11) != 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                    } else {
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        $changed2 = ((384 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        $composer3.startReplaceableGroup(-1205597937);
                        ComposerKt.sourceInformation($composer3, "C443@21634L11:OutlinedTextField.kt#jmzs0o");
                        if (($changed2 & 81) == 16 || !$composer3.getSkipping()) {
                            textField.invoke($composer3, Integer.valueOf(($dirty >> 3) & 14));
                        } else {
                            $composer3.skipToGroupEnd();
                        }
                        $composer3.endReplaceableGroup();
                    }
                    $composer3.endReplaceableGroup();
                    $composer3.endReplaceableGroup();
                    $composer3.endNode();
                    $composer3.endReplaceableGroup();
                    $composer3.endReplaceableGroup();
                    if (function2 != null) {
                        Modifier modifier$iv4 = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.LabelId);
                        $composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv4 = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv4 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv4, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv5 = (6 << 3) & SdkConfig.SDK_VERSION;
                        $composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer3, str2);
                        ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume14 = $composer3.consume(localDensity5);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Density density$iv$iv4 = (Density) consume14;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume15 = $composer3.consume(localLayoutDirection6);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        LayoutDirection layoutDirection$iv$iv4 = (LayoutDirection) consume15;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration5 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume16 = $composer3.consume(localViewConfiguration5);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ViewConfiguration viewConfiguration$iv$iv4 = (ViewConfiguration) consume16;
                        Function0 factory$iv$iv$iv4 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv4 = LayoutKt.materializerOf(modifier$iv4);
                        int $changed$iv$iv$iv4 = (($changed$iv$iv5 << 9) & 7168) | 6;
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(factory$iv$iv$iv4);
                        } else {
                            $composer3.useNode();
                        }
                        $composer3.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv4 = Updater.m1639constructorimpl($composer3);
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv4, density$iv$iv4, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv4, layoutDirection$iv$iv4, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv4, viewConfiguration$iv$iv4, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer3.enableReusing();
                        skippableUpdate$iv$iv$iv4.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv4 >> 3) & SdkConfig.SDK_VERSION));
                        $composer3.startReplaceableGroup(2058660585);
                        int $changed$iv6 = ($changed$iv$iv$iv4 >> 9) & 14;
                        $composer3.startReplaceableGroup(-2137368960);
                        ComposerKt.sourceInformation($composer3, "C72@3384L9:Box.kt#2w3rfo");
                        if (($changed$iv6 & 11) == 2 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                        } else {
                            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                            int $changed5 = ((6 >> 6) & SdkConfig.SDK_VERSION) | 6;
                            $composer3.startReplaceableGroup(-55131805);
                            ComposerKt.sourceInformation($composer3, "C447@21755L7:OutlinedTextField.kt#jmzs0o");
                            if (($changed5 & 81) == 16 && $composer3.getSkipping()) {
                                $composer3.skipToGroupEnd();
                            } else {
                                function2.invoke($composer3, Integer.valueOf(($dirty >> 9) & 14));
                            }
                            $composer3.endReplaceableGroup();
                        }
                        $composer3.endReplaceableGroup();
                        $composer3.endReplaceableGroup();
                        $composer3.endNode();
                        $composer3.endReplaceableGroup();
                        $composer3.endReplaceableGroup();
                    }
                } else {
                    $composer3.skipToGroupEnd();
                    $composer2 = $composer3;
                }
                $composer3.endReplaceableGroup();
                $composer2.endReplaceableGroup();
                $composer2.endNode();
                $composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            value$iv$iv = new OutlinedTextFieldMeasurePolicy(onLabelMeasured, singleLine, animationProgress, paddingValues);
            $composer3.updateRememberedValue(value$iv$iv);
            $composer3.endReplaceableGroup();
            OutlinedTextFieldMeasurePolicy measurePolicy2 = (OutlinedTextFieldMeasurePolicy) value$iv$iv;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection7 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume17 = $composer3.consume(localLayoutDirection7);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection22 = (LayoutDirection) consume17;
            int $changed$iv32 = ($dirty << 3) & SdkConfig.SDK_VERSION;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume22 = $composer3.consume(localDensity6);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv2 = (Density) consume22;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume32 = $composer3.consume(localLayoutDirection22);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv2 = (LayoutDirection) consume32;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration6 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume42 = $composer3.consume(localViewConfiguration6);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv2 = (ViewConfiguration) consume42;
            Function0 factory$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv2 = LayoutKt.materializerOf(modifier);
            $changed$iv$iv = (($changed$iv32 << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if (!$composer3.getInserting()) {
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv2 = Updater.m1639constructorimpl($composer3);
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv2, measurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv2, density$iv2, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv2, layoutDirection$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv2, viewConfiguration$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer3.enableReusing();
            skippableUpdate$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & SdkConfig.SDK_VERSION));
            $composer3.startReplaceableGroup(2058660585);
            $composer3.startReplaceableGroup(118153609);
            ComposerKt.sourceInformation($composer3, "C400@20029L8,439@21477L182,447@21710L54:OutlinedTextField.kt#jmzs0o");
            if ((($changed$iv$iv >> 9) & 14 & 11) == 2) {
            }
            border.invoke($composer3, Integer.valueOf(($dirty >> 27) & 14));
            $composer3.startReplaceableGroup(1169914597);
            ComposerKt.sourceInformation($composer3, "403@20090L219");
            if (function22 != null) {
            }
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(1169914882);
            ComposerKt.sourceInformation($composer3, "411@20376L221");
            if (function23 != null) {
            }
            $composer3.endReplaceableGroup();
            LayoutDirection layoutDirection32 = layoutDirection;
            float startTextFieldPadding2 = PaddingKt.calculateStartPadding(paddingValues, layoutDirection32);
            float endTextFieldPadding2 = PaddingKt.calculateEndPadding(paddingValues, layoutDirection32);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            if (function22 == null) {
            }
            if (function23 == null) {
            }
            Modifier padding2 = PaddingKt.m763paddingqDBjuR0$default(companion2, f, 0.0f, f2, 0.0f, 10, null);
            $composer3.startReplaceableGroup(1169915893);
            ComposerKt.sourceInformation($composer3, "436@21390L59");
            if (function3 != null) {
            }
            $composer3.endReplaceableGroup();
            Modifier modifier$iv32 = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.TextFieldId).then(padding2);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv32 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv32 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv32, true, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & SdkConfig.SDK_VERSION));
            int $changed$iv$iv42 = (384 << 3) & SdkConfig.SDK_VERSION;
            $composer3.startReplaceableGroup(-1323940314);
            String str22 = str;
            ComposerKt.sourceInformation($composer3, str22);
            ProvidableCompositionLocal<Density> localDensity42 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume112 = $composer3.consume(localDensity42);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv32 = (Density) consume112;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection52 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume122 = $composer3.consume(localLayoutDirection52);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv32 = (LayoutDirection) consume122;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration42 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume132 = $composer3.consume(localViewConfiguration42);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv32 = (ViewConfiguration) consume132;
            Function0 factory$iv$iv$iv32 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv32 = LayoutKt.materializerOf(modifier$iv32);
            int $changed$iv$iv$iv32 = (($changed$iv$iv42 << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if (!$composer3.getInserting()) {
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv32 = Updater.m1639constructorimpl($composer3);
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv32, measurePolicy$iv32, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv32, density$iv$iv32, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv32, layoutDirection$iv$iv32, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv32, viewConfiguration$iv$iv32, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer3.enableReusing();
            skippableUpdate$iv$iv$iv32.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv32 >> 3) & SdkConfig.SDK_VERSION));
            $composer3.startReplaceableGroup(2058660585);
            $changed$iv = ($changed$iv$iv$iv32 >> 9) & 14;
            $composer3.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation($composer3, "C72@3384L9:Box.kt#2w3rfo");
            if (($changed$iv & 11) != 2) {
            }
            BoxScopeInstance boxScopeInstance32 = BoxScopeInstance.INSTANCE;
            $changed2 = ((384 >> 6) & SdkConfig.SDK_VERSION) | 6;
            $composer3.startReplaceableGroup(-1205597937);
            ComposerKt.sourceInformation($composer3, "C443@21634L11:OutlinedTextField.kt#jmzs0o");
            if (($changed2 & 81) == 16) {
            }
            textField.invoke($composer3, Integer.valueOf(($dirty >> 3) & 14));
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            if (function2 != null) {
            }
            $composer3.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer3.skipToGroupEnd();
            $dirty1 = $dirty12;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextFieldLayout$2
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
                OutlinedTextFieldKt.OutlinedTextFieldLayout(Modifier.this, textField, function3, function2, function22, function23, singleLine, animationProgress, onLabelMeasured, border, paddingValues, composer, $changed | 1, $changed1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-O3s9Psw, reason: not valid java name */
    public static final int m1451calculateWidthO3s9Psw(int leadingPlaceableWidth, int trailingPlaceableWidth, int textFieldPlaceableWidth, int labelPlaceableWidth, int placeholderPlaceableWidth, boolean isLabelInMiddleSection, long constraints, float density, PaddingValues paddingValues) {
        int focusedLabelWidth = 0;
        int middleSection = Math.max(textFieldPlaceableWidth, Math.max(isLabelInMiddleSection ? labelPlaceableWidth : 0, placeholderPlaceableWidth));
        int wrappedWidth = leadingPlaceableWidth + middleSection + trailingPlaceableWidth;
        if (!isLabelInMiddleSection) {
            float arg0$iv = paddingValues.mo740calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr);
            float other$iv = paddingValues.mo741calculateRightPaddingu2uoSUM(LayoutDirection.Ltr);
            float labelHorizontalPadding = C0504Dp.m4382constructorimpl(arg0$iv + other$iv) * density;
            focusedLabelWidth = labelPlaceableWidth + MathKt.roundToInt(labelHorizontalPadding);
        }
        return Math.max(wrappedWidth, Math.max(focusedLabelWidth, Constraints.m4340getMinWidthimpl(constraints)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-zUg2_y0, reason: not valid java name */
    public static final int m1450calculateHeightzUg2_y0(int leadingPlaceableHeight, int trailingPlaceableHeight, int textFieldPlaceableHeight, int labelPlaceableHeight, int placeholderPlaceableHeight, long constraints, float density, PaddingValues paddingValues) {
        int inputFieldHeight = Math.max(textFieldPlaceableHeight, placeholderPlaceableHeight);
        float topPadding = paddingValues.getTop() * density;
        float bottomPadding = paddingValues.getBottom() * density;
        float middleSectionHeight = inputFieldHeight + bottomPadding + Math.max(topPadding, labelPlaceableHeight / 2.0f);
        return Math.max(Constraints.m4339getMinHeightimpl(constraints), Math.max(leadingPlaceableHeight, Math.max(trailingPlaceableHeight, MathKt.roundToInt(middleSectionHeight))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope $this$place, int height, int width, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable textFieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable borderPlaceable, float animationProgress, boolean singleLine, float density, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        int i;
        int placeholderVerticalPosition;
        int i2;
        float widthOrZero;
        int topPadding = MathKt.roundToInt(paddingValues.getTop() * density);
        int startPadding = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * density);
        float iconPadding = TextFieldImplKt.getHorizontalIconPadding() * density;
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, leadingPlaceable, 0, Alignment.INSTANCE.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.INSTANCE.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (labelPlaceable != null) {
            if (singleLine) {
                i2 = Alignment.INSTANCE.getCenterVertically().align(labelPlaceable.getHeight(), height);
            } else {
                i2 = topPadding;
            }
            int startPositionY = i2;
            float f = 1;
            float positionY = (startPositionY * (f - animationProgress)) - ((labelPlaceable.getHeight() / 2) * animationProgress);
            if (leadingPlaceable == null) {
                widthOrZero = 0.0f;
            } else {
                widthOrZero = (TextFieldImplKt.widthOrZero(leadingPlaceable) - iconPadding) * (f - animationProgress);
            }
            int positionX = MathKt.roundToInt(widthOrZero) + startPadding;
            Placeable.PlacementScope.placeRelative$default($this$place, labelPlaceable, positionX, MathKt.roundToInt(positionY), 0.0f, 4, null);
        }
        if (singleLine) {
            i = Alignment.INSTANCE.getCenterVertically().align(textFieldPlaceable.getHeight(), height);
        } else {
            i = topPadding;
        }
        int textVerticalPosition = Math.max(i, TextFieldImplKt.heightOrZero(labelPlaceable) / 2);
        Placeable.PlacementScope.placeRelative$default($this$place, textFieldPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textVerticalPosition, 0.0f, 4, null);
        if (placeholderPlaceable != null) {
            if (singleLine) {
                placeholderVerticalPosition = Alignment.INSTANCE.getCenterVertically().align(placeholderPlaceable.getHeight(), height);
            } else {
                placeholderVerticalPosition = topPadding;
            }
            Placeable.PlacementScope.placeRelative$default($this$place, placeholderPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), placeholderVerticalPosition, 0.0f, 4, null);
        }
        Placeable.PlacementScope.m3540place70tqf50$default($this$place, borderPlaceable, IntOffset.INSTANCE.m4510getZeronOccac(), 0.0f, 2, null);
    }

    /* renamed from: outlineCutout-12SF9DM, reason: not valid java name */
    public static final Modifier m1452outlineCutout12SF9DM(Modifier outlineCutout, final long labelSize, final PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(outlineCutout, "$this$outlineCutout");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return DrawModifierKt.drawWithContent(outlineCutout, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$outlineCutout$1

            /* compiled from: OutlinedTextField.kt */
            @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    iArr[LayoutDirection.Rtl.ordinal()] = 1;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope drawWithContent) {
                float f;
                float right;
                Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                float labelWidth = Size.m1829getWidthimpl(labelSize);
                if (labelWidth > 0.0f) {
                    f = OutlinedTextFieldKt.OutlinedTextFieldInnerPadding;
                    float innerPadding = drawWithContent.mo648toPx0680j_4(f);
                    float leftLtr = drawWithContent.mo648toPx0680j_4(paddingValues.mo740calculateLeftPaddingu2uoSUM(drawWithContent.getLayoutDirection())) - innerPadding;
                    float f2 = 2;
                    float rightLtr = leftLtr + labelWidth + (f2 * innerPadding);
                    float left = WhenMappings.$EnumSwitchMapping$0[drawWithContent.getLayoutDirection().ordinal()] == 1 ? Size.m1829getWidthimpl(drawWithContent.mo2490getSizeNHjbRc()) - rightLtr : RangesKt.coerceAtLeast(leftLtr, 0.0f);
                    if (WhenMappings.$EnumSwitchMapping$0[drawWithContent.getLayoutDirection().ordinal()] == 1) {
                        right = Size.m1829getWidthimpl(drawWithContent.mo2490getSizeNHjbRc()) - RangesKt.coerceAtLeast(leftLtr, 0.0f);
                    } else {
                        right = rightLtr;
                    }
                    float labelHeight = Size.m1826getHeightimpl(labelSize);
                    ContentDrawScope $this$clipRect_u2drOu3jXo$iv = drawWithContent;
                    float top$iv = (-labelHeight) / f2;
                    float bottom$iv = labelHeight / f2;
                    int clipOp$iv = ClipOp.INSTANCE.m1984getDifferencertfAjoo();
                    DrawContext $this$withTransform_u24lambda_u2d6$iv$iv = $this$clipRect_u2drOu3jXo$iv.getDrawContext();
                    long previousSize$iv$iv = $this$withTransform_u24lambda_u2d6$iv$iv.mo2415getSizeNHjbRc();
                    $this$withTransform_u24lambda_u2d6$iv$iv.getCanvas().save();
                    DrawTransform $this$clipRect_rOu3jXo_u24lambda_u2d4$iv = $this$withTransform_u24lambda_u2d6$iv$iv.getTransform();
                    $this$clipRect_rOu3jXo_u24lambda_u2d4$iv.mo2418clipRectN_I0leg(left, top$iv, right, bottom$iv, clipOp$iv);
                    drawWithContent.drawContent();
                    $this$withTransform_u24lambda_u2d6$iv$iv.getCanvas().restore();
                    $this$withTransform_u24lambda_u2d6$iv$iv.mo2416setSizeuvyYCjk(previousSize$iv$iv);
                    return;
                }
                drawWithContent.drawContent();
            }
        });
    }

    public static final float getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }
}
