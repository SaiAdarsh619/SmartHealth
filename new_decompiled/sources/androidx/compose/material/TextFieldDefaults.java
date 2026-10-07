package androidx.compose.material;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.p000ui.text.input.VisualTransformation;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldDefaults.kt */
@Metadata(m286d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JS\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%J×\u0001\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00103\u001a\u0002042\u0013\b\u0002\u00105\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+H\u0007¢\u0006\u0002\u00106JÂ\u0001\u00107\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00103\u001a\u000204H\u0007¢\u0006\u0002\u00108Jç\u0001\u00109\u001a\u00020 2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010@\u001a\u00020;2\b\b\u0002\u0010A\u001a\u00020;2\b\b\u0002\u0010B\u001a\u00020;2\b\b\u0002\u0010C\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ=\u0010R\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010XJç\u0001\u0010Y\u001a\u00020 2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010Z\u001a\u00020;2\b\b\u0002\u0010[\u001a\u00020;2\b\b\u0002\u0010\\\u001a\u00020;2\b\b\u0002\u0010]\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010QJ=\u0010_\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010XJ=\u0010a\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bb\u0010XJM\u0010c\u001a\u00020d*\u00020d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010e\u001a\u00020\u00062\b\b\u0002\u0010f\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bg\u0010hR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\f\u0010\bR\u001c\u0010\r\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0016\u0010\bR\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006i"}, m287d2 = {"Landroidx/compose/material/TextFieldDefaults;", "", "()V", "BackgroundOpacity", "", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "IconOpacity", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "OutlinedTextFieldShape", "Landroidx/compose/ui/graphics/Shape;", "getOutlinedTextFieldShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "TextFieldShape", "getTextFieldShape", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "UnfocusedIndicatorLineOpacity", "BorderBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material/TextFieldColors;", "shape", "focusedBorderThickness", "unfocusedBorderThickness", "BorderBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "OutlinedTextFieldDecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", OutlinedTextFieldKt.BorderId, "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "TextFieldDecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;III)V", "outlinedTextFieldColors", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-dx8h9Zs", "(JJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "outlinedTextFieldPadding", "start", "top", "end", "bottom", "outlinedTextFieldPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-dx8h9Zs", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "indicatorLine", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "material_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TextFieldDefaults {
    public static final float BackgroundOpacity = 0.12f;
    public static final float IconOpacity = 0.54f;
    public static final float UnfocusedIndicatorLineOpacity = 0.42f;
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = C0504Dp.m4382constructorimpl(56);
    private static final float MinWidth = C0504Dp.m4382constructorimpl(280);
    private static final float UnfocusedBorderThickness = C0504Dp.m4382constructorimpl(1);
    private static final float FocusedBorderThickness = C0504Dp.m4382constructorimpl(2);

    private TextFieldDefaults() {
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1559getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m1560getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    public final Shape getTextFieldShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1117199624, "C214@7704L6:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1117199624, $changed, -1, "androidx.compose.material.TextFieldDefaults.<get-TextFieldShape> (TextFieldDefaults.kt:214)");
        }
        CornerBasedShape copy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes($composer, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return copy$default;
    }

    public final Shape getOutlinedTextFieldShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1899109048, "C223@8006L6:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1899109048, $changed, -1, "androidx.compose.material.TextFieldDefaults.<get-OutlinedTextFieldShape> (TextFieldDefaults.kt:223)");
        }
        CornerBasedShape small = MaterialTheme.INSTANCE.getShapes($composer, 6).getSmall();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return small;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m1561getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m1558getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* renamed from: indicatorLine-gv0btCI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1553indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, int i, Object obj) {
        float f3;
        float f4;
        if ((i & 16) == 0) {
            f3 = f;
        } else {
            f3 = FocusedBorderThickness;
        }
        if ((i & 32) == 0) {
            f4 = f2;
        } else {
            f4 = UnfocusedBorderThickness;
        }
        return textFieldDefaults.m1562indicatorLinegv0btCI(modifier, z, z2, interactionSource, textFieldColors, f3, f4);
    }

    @ExperimentalMaterialApi
    /* renamed from: indicatorLine-gv0btCI, reason: not valid java name */
    public final Modifier m1562indicatorLinegv0btCI(Modifier indicatorLine, final boolean enabled, final boolean isError, final InteractionSource interactionSource, final TextFieldColors colors, final float focusedIndicatorLineThickness, final float unfocusedIndicatorLineThickness) {
        Intrinsics.checkNotNullParameter(indicatorLine, "$this$indicatorLine");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(colors, "colors");
        return ComposedModifierKt.composed(indicatorLine, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.TextFieldDefaults$indicatorLine-gv0btCI$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("indicatorLine");
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
                $this$null.getProperties().set("isError", Boolean.valueOf(isError));
                $this$null.getProperties().set("interactionSource", interactionSource);
                $this$null.getProperties().set("colors", colors);
                $this$null.getProperties().set("focusedIndicatorLineThickness", C0504Dp.m4380boximpl(focusedIndicatorLineThickness));
                $this$null.getProperties().set("unfocusedIndicatorLineThickness", C0504Dp.m4380boximpl(unfocusedIndicatorLineThickness));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material.TextFieldDefaults$indicatorLine$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                State stroke;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(1398930845);
                ComposerKt.sourceInformation($composer, "C280@10408L217:TextFieldDefaults.kt#jmzs0o");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1398930845, $changed, -1, "androidx.compose.material.TextFieldDefaults.indicatorLine.<anonymous> (TextFieldDefaults.kt:279)");
                }
                stroke = TextFieldDefaultsKt.m1569animateBorderStrokeAsStateNuRrP5Q(enabled, isError, interactionSource, colors, focusedIndicatorLineThickness, unfocusedIndicatorLineThickness, $composer, 0);
                Modifier drawIndicatorLine = TextFieldKt.drawIndicatorLine(Modifier.INSTANCE, (BorderStroke) stroke.getValue());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return drawIndicatorLine;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0172  */
    @ExperimentalMaterialApi
    /* renamed from: BorderBox-nbWgWpA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1557BorderBoxnbWgWpA(final boolean enabled, final boolean isError, final InteractionSource interactionSource, final TextFieldColors colors, Shape shape, float focusedBorderThickness, float unfocusedBorderThickness, Composer $composer, final int $changed, final int i) {
        Shape shape2;
        float focusedBorderThickness2;
        float f;
        Shape shape3;
        float focusedBorderThickness3;
        float unfocusedBorderThickness2;
        int $dirty;
        State borderStroke;
        float unfocusedBorderThickness3;
        float unfocusedBorderThickness4;
        Shape shape4;
        ScopeUpdateScope endRestartGroup;
        int i2;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Composer $composer2 = $composer.startRestartGroup(943754022);
        ComposerKt.sourceInformation($composer2, "C(BorderBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)313@11762L22,317@11946L203,325@12158L47:TextFieldDefaults.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer2.changed(isError) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changed(interactionSource) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer2.changed(colors) ? 2048 : 1024;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                if ($composer2.changed(shape2)) {
                    i5 = 16384;
                    $dirty2 |= i5;
                }
            } else {
                shape2 = shape;
            }
            i5 = 8192;
            $dirty2 |= i5;
        } else {
            shape2 = shape;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                focusedBorderThickness2 = focusedBorderThickness;
                if ($composer2.changed(focusedBorderThickness2)) {
                    i4 = 131072;
                    $dirty2 |= i4;
                }
            } else {
                focusedBorderThickness2 = focusedBorderThickness;
            }
            i4 = 65536;
            $dirty2 |= i4;
        } else {
            focusedBorderThickness2 = focusedBorderThickness;
        }
        if ((3670016 & $changed) == 0) {
            if ((i & 64) == 0) {
                f = unfocusedBorderThickness;
                if ($composer2.changed(f)) {
                    i3 = 1048576;
                    $dirty2 |= i3;
                }
            } else {
                f = unfocusedBorderThickness;
            }
            i3 = 524288;
            $dirty2 |= i3;
        } else {
            f = unfocusedBorderThickness;
        }
        if ((i & 128) == 0) {
            i2 = (29360128 & $changed) == 0 ? $composer2.changed(this) ? 8388608 : 4194304 : 12582912;
            if ((23967451 & $dirty2) == 4793490 || !$composer2.getSkipping()) {
                $composer2.startDefaults();
                if (($changed & 1) != 0 || $composer2.getDefaultsInvalid()) {
                    if ((i & 16) != 0) {
                        shape2 = getOutlinedTextFieldShape($composer2, ($dirty2 >> 21) & 14);
                        $dirty2 &= -57345;
                    }
                    if ((i & 32) != 0) {
                        $dirty2 &= -458753;
                        focusedBorderThickness2 = FocusedBorderThickness;
                    }
                    if ((i & 64) == 0) {
                        $dirty = $dirty2 & (-3670017);
                        shape3 = shape2;
                        unfocusedBorderThickness2 = UnfocusedBorderThickness;
                        focusedBorderThickness3 = focusedBorderThickness2;
                    } else {
                        shape3 = shape2;
                        focusedBorderThickness3 = focusedBorderThickness2;
                        unfocusedBorderThickness2 = f;
                        $dirty = $dirty2;
                    }
                } else {
                    $composer2.skipToGroupEnd();
                    if ((i & 16) != 0) {
                        $dirty2 &= -57345;
                    }
                    if ((i & 32) != 0) {
                        $dirty2 &= -458753;
                    }
                    if ((i & 64) != 0) {
                        $dirty2 &= -3670017;
                    }
                    shape3 = shape2;
                    focusedBorderThickness3 = focusedBorderThickness2;
                    unfocusedBorderThickness2 = f;
                    $dirty = $dirty2;
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(943754022, $dirty, -1, "androidx.compose.material.TextFieldDefaults.BorderBox (TextFieldDefaults.kt:308)");
                }
                Shape shape5 = shape3;
                borderStroke = TextFieldDefaultsKt.m1569animateBorderStrokeAsStateNuRrP5Q(enabled, isError, interactionSource, colors, focusedBorderThickness3, unfocusedBorderThickness2, $composer2, ($dirty & 14) | ($dirty & SdkConfig.SDK_VERSION) | ($dirty & 896) | ($dirty & 7168) | (($dirty >> 3) & 57344) | (($dirty >> 3) & 458752));
                BoxKt.Box(BorderKt.border(Modifier.INSTANCE, (BorderStroke) borderStroke.getValue(), shape5), $composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                unfocusedBorderThickness3 = unfocusedBorderThickness2;
                unfocusedBorderThickness4 = focusedBorderThickness3;
                shape4 = shape5;
            } else {
                $composer2.skipToGroupEnd();
                shape4 = shape2;
                unfocusedBorderThickness4 = focusedBorderThickness2;
                unfocusedBorderThickness3 = f;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Shape shape6 = shape4;
            final float f2 = unfocusedBorderThickness4;
            final float f3 = unfocusedBorderThickness3;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldDefaults$BorderBox$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i6) {
                    TextFieldDefaults.this.m1557BorderBoxnbWgWpA(enabled, isError, interactionSource, colors, shape6, f2, f3, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty2 |= i2;
        if ((23967451 & $dirty2) == 4793490) {
        }
        $composer2.startDefaults();
        if (($changed & 1) != 0) {
        }
        if ((i & 16) != 0) {
        }
        if ((i & 32) != 0) {
        }
        if ((i & 64) == 0) {
        }
        $composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Shape shape52 = shape3;
        borderStroke = TextFieldDefaultsKt.m1569animateBorderStrokeAsStateNuRrP5Q(enabled, isError, interactionSource, colors, focusedBorderThickness3, unfocusedBorderThickness2, $composer2, ($dirty & 14) | ($dirty & SdkConfig.SDK_VERSION) | ($dirty & 896) | ($dirty & 7168) | (($dirty >> 3) & 57344) | (($dirty >> 3) & 458752));
        BoxKt.Box(BorderKt.border(Modifier.INSTANCE, (BorderStroke) borderStroke.getValue(), shape52), $composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        unfocusedBorderThickness3 = unfocusedBorderThickness2;
        unfocusedBorderThickness4 = focusedBorderThickness3;
        shape4 = shape52;
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* renamed from: textFieldWithLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1555textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getFirstBaselineOffset();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldBottomPadding();
        }
        return textFieldDefaults.m1566textFieldWithLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @ExperimentalMaterialApi
    /* renamed from: textFieldWithLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1566textFieldWithLabelPaddinga9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.m755PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1556textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m1567textFieldWithoutLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @ExperimentalMaterialApi
    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1567textFieldWithoutLabelPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m755PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: outlinedTextFieldPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1554outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m1564outlinedTextFieldPaddinga9UjIt4(f, f2, f3, f4);
    }

    @ExperimentalMaterialApi
    /* renamed from: outlinedTextFieldPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1564outlinedTextFieldPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m755PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: textFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m1565textFieldColorsdx8h9Zs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long textColor2;
        long disabledTextColor2;
        long backgroundColor2;
        long focusedIndicatorColor2;
        long unfocusedIndicatorColor2;
        long disabledIndicatorColor2;
        long leadingIconColor2;
        long disabledLeadingIconColor2;
        long trailingIconColor2;
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
        $composer.startReplaceableGroup(231892599);
        ComposerKt.sourceInformation($composer, "C(textFieldColors)P(17:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,19:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,15:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,18:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,20:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,16:c#ui.graphics.Color,5:c#ui.graphics.Color)376@14082L7,376@14113L7,377@14186L8,378@14244L6,379@14337L6,380@14401L6,382@14480L6,382@14521L4,384@14595L6,385@14747L8,386@14809L6,388@14883L6,389@15012L8,392@15141L6,393@15272L8,394@15337L6,396@15412L6,396@15453L4,397@15511L6,397@15546L6,398@15629L8,399@15687L6,400@15749L6,400@15784L6,401@15870L8:TextFieldDefaults.kt#jmzs0o");
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
        if ((i & 4) != 0) {
            m1994copywmQWz5c13 = Color.m1994copywmQWz5c(r14, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r14) : 0.12f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r14) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r14) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            backgroundColor2 = m1994copywmQWz5c13;
        } else {
            backgroundColor2 = backgroundColor;
        }
        long cursorColor2 = (i & 8) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1317getPrimary0d7_KjU() : cursorColor;
        long errorCursorColor2 = (i & 16) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1311getError0d7_KjU() : errorCursorColor;
        if ((i & 32) != 0) {
            m1994copywmQWz5c12 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getHigh($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1317getPrimary0d7_KjU()) : 0.0f);
            focusedIndicatorColor2 = m1994copywmQWz5c12;
        } else {
            focusedIndicatorColor2 = focusedIndicatorColor;
        }
        if ((i & 64) != 0) {
            m1994copywmQWz5c11 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : 0.42f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            unfocusedIndicatorColor2 = m1994copywmQWz5c11;
        } else {
            unfocusedIndicatorColor2 = unfocusedIndicatorColor;
        }
        if ((i & 128) != 0) {
            m1994copywmQWz5c10 = Color.m1994copywmQWz5c(r90, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r90) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r90) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r90) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(unfocusedIndicatorColor2) : 0.0f);
            disabledIndicatorColor2 = m1994copywmQWz5c10;
        } else {
            disabledIndicatorColor2 = disabledIndicatorColor;
        }
        long errorIndicatorColor2 = (i & 256) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1311getError0d7_KjU() : errorIndicatorColor;
        if ((i & 512) != 0) {
            m1994copywmQWz5c9 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : 0.54f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            leadingIconColor2 = m1994copywmQWz5c9;
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i & 1024) != 0) {
            m1994copywmQWz5c8 = Color.m1994copywmQWz5c(r90, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r90) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r90) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r90) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(leadingIconColor2) : 0.0f);
            disabledLeadingIconColor2 = m1994copywmQWz5c8;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (i & 2048) != 0 ? leadingIconColor2 : errorLeadingIconColor;
        if ((i & 4096) != 0) {
            m1994copywmQWz5c7 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : 0.54f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            trailingIconColor2 = m1994copywmQWz5c7;
        } else {
            trailingIconColor2 = trailingIconColor;
        }
        if ((i & 8192) != 0) {
            m1994copywmQWz5c6 = Color.m1994copywmQWz5c(r90, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r90) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r90) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r90) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(trailingIconColor2) : 0.0f);
            disabledTrailingIconColor2 = m1994copywmQWz5c6;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (i & 16384) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1311getError0d7_KjU() : errorTrailingIconColor;
        if ((32768 & i) != 0) {
            m1994copywmQWz5c5 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getHigh($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1317getPrimary0d7_KjU()) : 0.0f);
            focusedLabelColor2 = m1994copywmQWz5c5;
        } else {
            focusedLabelColor2 = focusedLabelColor;
        }
        if ((65536 & i) != 0) {
            m1994copywmQWz5c4 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            unfocusedLabelColor2 = m1994copywmQWz5c4;
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor;
        }
        if ((131072 & i) != 0) {
            m1994copywmQWz5c3 = Color.m1994copywmQWz5c(r90, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r90) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r90) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r90) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(unfocusedLabelColor2) : 0.0f);
            disabledLabelColor2 = m1994copywmQWz5c3;
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        long errorLabelColor2 = (262144 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1311getError0d7_KjU() : errorLabelColor;
        if ((524288 & i) != 0) {
            m1994copywmQWz5c2 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            placeholderColor2 = m1994copywmQWz5c2;
        } else {
            placeholderColor2 = placeholderColor;
        }
        if ((i & 1048576) != 0) {
            m1994copywmQWz5c = Color.m1994copywmQWz5c(r90, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r90) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r90) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r90) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(placeholderColor2) : 0.0f);
            disabledPlaceholderColor2 = m1994copywmQWz5c;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(231892599, $changed, $changed1, "androidx.compose.material.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:375)");
        }
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(textColor2, disabledTextColor2, cursorColor2, errorCursorColor2, focusedIndicatorColor2, unfocusedIndicatorColor2, errorIndicatorColor2, disabledIndicatorColor2, leadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, trailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, backgroundColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, disabledPlaceholderColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    /* renamed from: outlinedTextFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m1563outlinedTextFieldColorsdx8h9Zs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long textColor2;
        long disabledTextColor2;
        long focusedBorderColor2;
        long unfocusedBorderColor2;
        long disabledBorderColor2;
        long leadingIconColor2;
        long disabledLeadingIconColor2;
        long trailingIconColor2;
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
        $composer.startReplaceableGroup(1762667317);
        ComposerKt.sourceInformation($composer, "C(outlinedTextFieldColors)P(17:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,13:c#ui.graphics.Color,19:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,18:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,20:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,16:c#ui.graphics.Color,5:c#ui.graphics.Color)434@17398L7,434@17429L7,435@17502L8,437@17608L6,438@17672L6,440@17748L6,440@17789L4,442@17860L6,442@17903L8,443@17998L8,444@18057L6,446@18131L6,447@18260L8,450@18389L6,451@18520L8,452@18585L6,454@18660L6,454@18701L4,455@18759L6,455@18794L6,456@18877L8,457@18935L6,458@18997L6,458@19032L6,459@19118L8:TextFieldDefaults.kt#jmzs0o");
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
            m1994copywmQWz5c13 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(textColor2) : 0.0f);
            disabledTextColor2 = m1994copywmQWz5c13;
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        long backgroundColor2 = (i & 4) != 0 ? Color.INSTANCE.m2031getTransparent0d7_KjU() : backgroundColor;
        long cursorColor2 = (i & 8) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1317getPrimary0d7_KjU() : cursorColor;
        long errorCursorColor2 = (i & 16) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1311getError0d7_KjU() : errorCursorColor;
        if ((i & 32) != 0) {
            m1994copywmQWz5c12 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getHigh($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1317getPrimary0d7_KjU()) : 0.0f);
            focusedBorderColor2 = m1994copywmQWz5c12;
        } else {
            focusedBorderColor2 = focusedBorderColor;
        }
        if ((i & 64) != 0) {
            m1994copywmQWz5c11 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            unfocusedBorderColor2 = m1994copywmQWz5c11;
        } else {
            unfocusedBorderColor2 = unfocusedBorderColor;
        }
        if ((i & 128) != 0) {
            m1994copywmQWz5c10 = Color.m1994copywmQWz5c(r90, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r90) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r90) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r90) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(unfocusedBorderColor2) : 0.0f);
            disabledBorderColor2 = m1994copywmQWz5c10;
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        long errorBorderColor2 = (i & 256) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1311getError0d7_KjU() : errorBorderColor;
        if ((i & 512) != 0) {
            m1994copywmQWz5c9 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : 0.54f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            leadingIconColor2 = m1994copywmQWz5c9;
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i & 1024) != 0) {
            m1994copywmQWz5c8 = Color.m1994copywmQWz5c(r90, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r90) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r90) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r90) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(leadingIconColor2) : 0.0f);
            disabledLeadingIconColor2 = m1994copywmQWz5c8;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (i & 2048) != 0 ? leadingIconColor2 : errorLeadingIconColor;
        if ((i & 4096) != 0) {
            m1994copywmQWz5c7 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : 0.54f, (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            trailingIconColor2 = m1994copywmQWz5c7;
        } else {
            trailingIconColor2 = trailingIconColor;
        }
        if ((i & 8192) != 0) {
            m1994copywmQWz5c6 = Color.m1994copywmQWz5c(r90, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r90) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r90) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r90) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(trailingIconColor2) : 0.0f);
            disabledTrailingIconColor2 = m1994copywmQWz5c6;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (i & 16384) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1311getError0d7_KjU() : errorTrailingIconColor;
        if ((32768 & i) != 0) {
            m1994copywmQWz5c5 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getHigh($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1317getPrimary0d7_KjU()) : 0.0f);
            focusedLabelColor2 = m1994copywmQWz5c5;
        } else {
            focusedLabelColor2 = focusedLabelColor;
        }
        if ((65536 & i) != 0) {
            m1994copywmQWz5c4 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            unfocusedLabelColor2 = m1994copywmQWz5c4;
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor;
        }
        if ((131072 & i) != 0) {
            m1994copywmQWz5c3 = Color.m1994copywmQWz5c(r90, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r90) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r90) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r90) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(unfocusedLabelColor2) : 0.0f);
            disabledLabelColor2 = m1994copywmQWz5c3;
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        long errorLabelColor2 = (262144 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1311getError0d7_KjU() : errorLabelColor;
        if ((524288 & i) != 0) {
            m1994copywmQWz5c2 = Color.m1994copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1316getOnSurface0d7_KjU()) : 0.0f);
            placeholderColor2 = m1994copywmQWz5c2;
        } else {
            placeholderColor2 = placeholderColor;
        }
        if ((i & 1048576) != 0) {
            m1994copywmQWz5c = Color.m1994copywmQWz5c(r90, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r90) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r90) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r90) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(placeholderColor2) : 0.0f);
            disabledPlaceholderColor2 = m1994copywmQWz5c;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1762667317, $changed, $changed1, "androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:433)");
        }
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(textColor2, disabledTextColor2, cursorColor2, errorCursorColor2, focusedBorderColor2, unfocusedBorderColor2, errorBorderColor2, disabledBorderColor2, leadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, trailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, backgroundColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, disabledPlaceholderColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x01b5, code lost:
    
        if (r7.changed(r80) == false) goto L138;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02b2  */
    @ExperimentalMaterialApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void TextFieldDecorationBox(final String value, final Function2<? super Composer, ? super Integer, Unit> innerTextField, final boolean enabled, final boolean singleLine, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean isError, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, TextFieldColors colors, PaddingValues contentPadding, Composer $composer, final int $changed, final int $changed1, final int i) {
        int i2;
        int i3;
        Function2 label;
        int i4;
        int i5;
        int i6;
        TextFieldColors colors2;
        PaddingValues contentPadding2;
        Function2 placeholder;
        int $dirty1;
        Function2 leadingIcon;
        Function2 trailingIcon;
        boolean isError2;
        TextFieldColors colors3;
        Function2 label2;
        Composer $composer2;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        Intrinsics.checkNotNullParameter(visualTransformation, "visualTransformation");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Composer $composer3 = $composer.startRestartGroup(1171040065);
        ComposerKt.sourceInformation($composer3, "C(TextFieldDecorationBox)P(11,3,2,9,12,4,5,6,8,7,10)553@25007L17,561@25241L569:TextFieldDefaults.kt#jmzs0o");
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
            $dirty |= $composer3.changed(innerTextField) ? 32 : 16;
        }
        int i9 = 256;
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(enabled) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changed(singleLine) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer3.changed(visualTransformation) ? 16384 : 8192;
        }
        if ((i & 32) == 0) {
            i8 = ($changed & 458752) == 0 ? $composer3.changed(interactionSource) ? 131072 : 65536 : 196608;
            i2 = i & 64;
            if (i2 == 0) {
                $dirty |= 1572864;
            } else if (($changed & 3670016) == 0) {
                $dirty |= $composer3.changed(isError) ? 1048576 : 524288;
            }
            i3 = i & 128;
            if (i3 == 0) {
                $dirty |= 12582912;
                label = function2;
            } else if (($changed & 29360128) == 0) {
                label = function2;
                $dirty |= $composer3.changed(label) ? 8388608 : 4194304;
            } else {
                label = function2;
            }
            i4 = i & 256;
            if (i4 == 0) {
                $dirty |= 100663296;
            } else if (($changed & 234881024) == 0) {
                $dirty |= $composer3.changed(function22) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
            }
            i5 = i & 512;
            if (i5 == 0) {
                $dirty |= 805306368;
            } else if (($changed & 1879048192) == 0) {
                $dirty |= $composer3.changed(function23) ? 536870912 : 268435456;
            }
            i6 = i & 1024;
            if (i6 == 0) {
                $dirty12 |= 6;
            } else if (($changed1 & 14) == 0) {
                $dirty12 |= $composer3.changed(function24) ? 4 : 2;
            }
            if (($changed1 & SdkConfig.SDK_VERSION) == 0) {
                if ((i & 2048) == 0 && $composer3.changed(colors)) {
                    i7 = 32;
                    $dirty12 |= i7;
                }
                i7 = 16;
                $dirty12 |= i7;
            }
            if (($changed1 & 896) == 0) {
                if ((i & 4096) != 0) {
                }
                i9 = 128;
                $dirty12 |= i9;
            }
            if ((i & 8192) == 0) {
                $dirty12 |= 3072;
            } else if (($changed1 & 7168) == 0) {
                $dirty12 |= $composer3.changed(this) ? 2048 : 1024;
            }
            if (($dirty & 1533916891) != 306783378 && ($dirty12 & 5851) == 1170 && $composer3.getSkipping()) {
                $composer3.skipToGroupEnd();
                isError2 = isError;
                placeholder = function22;
                leadingIcon = function23;
                trailingIcon = function24;
                colors3 = colors;
                contentPadding2 = contentPadding;
                $composer2 = $composer3;
                label2 = label;
            } else {
                $composer3.startDefaults();
                if (($changed & 1) != 0 || $composer3.getDefaultsInvalid()) {
                    boolean isError3 = i2 == 0 ? false : isError;
                    if (i3 != 0) {
                        label = null;
                    }
                    Function2 placeholder2 = i4 == 0 ? null : function22;
                    Function2 leadingIcon2 = i5 == 0 ? null : function23;
                    Function2 trailingIcon2 = i6 == 0 ? null : function24;
                    if ((i & 2048) == 0) {
                        colors2 = m1565textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, ($dirty12 >> 6) & SdkConfig.SDK_VERSION, 2097151);
                        $dirty12 &= -113;
                    } else {
                        colors2 = colors;
                    }
                    if ((i & 4096) == 0) {
                        placeholder = placeholder2;
                        leadingIcon = leadingIcon2;
                        trailingIcon = trailingIcon2;
                        isError2 = isError3;
                        colors3 = colors2;
                        contentPadding2 = label == null ? m1556textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null) : m1555textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        label2 = label;
                        $dirty1 = $dirty12 & (-897);
                    } else {
                        contentPadding2 = contentPadding;
                        placeholder = placeholder2;
                        $dirty1 = $dirty12;
                        leadingIcon = leadingIcon2;
                        trailingIcon = trailingIcon2;
                        isError2 = isError3;
                        colors3 = colors2;
                        label2 = label;
                    }
                } else {
                    $composer3.skipToGroupEnd();
                    if ((i & 2048) != 0) {
                        $dirty12 &= -113;
                    }
                    if ((i & 4096) != 0) {
                        isError2 = isError;
                        placeholder = function22;
                        leadingIcon = function23;
                        trailingIcon = function24;
                        colors3 = colors;
                        contentPadding2 = contentPadding;
                        $dirty1 = $dirty12 & (-897);
                        label2 = label;
                    } else {
                        isError2 = isError;
                        placeholder = function22;
                        leadingIcon = function23;
                        trailingIcon = function24;
                        colors3 = colors;
                        contentPadding2 = contentPadding;
                        $dirty1 = $dirty12;
                        label2 = label;
                    }
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1171040065, $dirty, $dirty1, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:541)");
                }
                $composer2 = $composer3;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, value, innerTextField, visualTransformation, label2, placeholder, leadingIcon, trailingIcon, singleLine, enabled, isError2, interactionSource, contentPadding2, colors3, null, $composer2, (($dirty << 3) & SdkConfig.SDK_VERSION) | 6 | (($dirty << 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 9) & 57344) | (($dirty >> 9) & 458752) | (3670016 & ($dirty >> 9)) | (($dirty1 << 21) & 29360128) | (($dirty << 15) & 234881024) | (($dirty << 21) & 1879048192), (($dirty >> 18) & 14) | (($dirty >> 12) & SdkConfig.SDK_VERSION) | ($dirty1 & 896) | (($dirty1 << 6) & 7168), 16384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final boolean z = isError2;
            final Function2 function25 = label2;
            final Function2 function26 = placeholder;
            final Function2 function27 = leadingIcon;
            final Function2 function28 = trailingIcon;
            final TextFieldColors textFieldColors = colors3;
            final PaddingValues paddingValues = contentPadding2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldDefaults$TextFieldDecorationBox$1
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

                public final void invoke(Composer composer, int i10) {
                    TextFieldDefaults.this.TextFieldDecorationBox(value, innerTextField, enabled, singleLine, visualTransformation, interactionSource, z, function25, function26, function27, function28, textFieldColors, paddingValues, composer, $changed | 1, $changed1, i);
                }
            });
            return;
        }
        $dirty |= i8;
        i2 = i & 64;
        if (i2 == 0) {
        }
        i3 = i & 128;
        if (i3 == 0) {
        }
        i4 = i & 256;
        if (i4 == 0) {
        }
        i5 = i & 512;
        if (i5 == 0) {
        }
        i6 = i & 1024;
        if (i6 == 0) {
        }
        if (($changed1 & SdkConfig.SDK_VERSION) == 0) {
        }
        if (($changed1 & 896) == 0) {
        }
        if ((i & 8192) == 0) {
        }
        if (($dirty & 1533916891) != 306783378) {
        }
        $composer3.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i2 == 0) {
        }
        if (i3 != 0) {
        }
        if (i4 == 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if ((i & 2048) == 0) {
        }
        if ((i & 4096) == 0) {
        }
        $composer3.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        $composer2 = $composer3;
        TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, value, innerTextField, visualTransformation, label2, placeholder, leadingIcon, trailingIcon, singleLine, enabled, isError2, interactionSource, contentPadding2, colors3, null, $composer2, (($dirty << 3) & SdkConfig.SDK_VERSION) | 6 | (($dirty << 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 9) & 57344) | (($dirty >> 9) & 458752) | (3670016 & ($dirty >> 9)) | (($dirty1 << 21) & 29360128) | (($dirty << 15) & 234881024) | (($dirty << 21) & 1879048192), (($dirty >> 18) & 14) | (($dirty >> 12) & SdkConfig.SDK_VERSION) | ($dirty1 & 896) | (($dirty1 << 6) & 7168), 16384);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x01b9, code lost:
    
        if (r8.changed(r79) == false) goto L138;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0297  */
    @ExperimentalMaterialApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void OutlinedTextFieldDecorationBox(final String value, final Function2<? super Composer, ? super Integer, Unit> innerTextField, final boolean enabled, final boolean singleLine, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean isError, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, TextFieldColors colors, PaddingValues contentPadding, Function2<? super Composer, ? super Integer, Unit> function25, Composer $composer, final int $changed, final int $changed1, final int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        TextFieldColors colors2;
        PaddingValues contentPadding2;
        PaddingValues contentPadding3;
        Function2 border;
        Function2 placeholder;
        Function2 leadingIcon;
        Function2 trailingIcon;
        Function2 label;
        boolean isError2;
        TextFieldColors colors3;
        int $dirty1;
        Composer $composer2;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        Intrinsics.checkNotNullParameter(visualTransformation, "visualTransformation");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Composer $composer3 = $composer.startRestartGroup(-1280721485);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextFieldDecorationBox)P(12,4,3,10,13,5,6,7,9,8,11,1,2)645@30340L25,651@30571L600:TextFieldDefaults.kt#jmzs0o");
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
            $dirty |= $composer3.changed(innerTextField) ? 32 : 16;
        }
        int i10 = 256;
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(enabled) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changed(singleLine) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer3.changed(visualTransformation) ? 16384 : 8192;
        }
        if ((i & 32) == 0) {
            i9 = ($changed & 458752) == 0 ? $composer3.changed(interactionSource) ? 131072 : 65536 : 196608;
            i2 = i & 64;
            if (i2 == 0) {
                $dirty |= 1572864;
            } else if (($changed & 3670016) == 0) {
                $dirty |= $composer3.changed(isError) ? 1048576 : 524288;
            }
            i3 = i & 128;
            if (i3 == 0) {
                $dirty |= 12582912;
            } else if (($changed & 29360128) == 0) {
                $dirty |= $composer3.changed(function2) ? 8388608 : 4194304;
            }
            i4 = i & 256;
            if (i4 == 0) {
                $dirty |= 100663296;
            } else if (($changed & 234881024) == 0) {
                $dirty |= $composer3.changed(function22) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
            }
            i5 = i & 512;
            if (i5 == 0) {
                $dirty |= 805306368;
            } else if (($changed & 1879048192) == 0) {
                $dirty |= $composer3.changed(function23) ? 536870912 : 268435456;
            }
            i6 = i & 1024;
            if (i6 == 0) {
                $dirty12 |= 6;
            } else if (($changed1 & 14) == 0) {
                $dirty12 |= $composer3.changed(function24) ? 4 : 2;
            }
            if (($changed1 & SdkConfig.SDK_VERSION) == 0) {
                if ((i & 2048) == 0 && $composer3.changed(colors)) {
                    i8 = 32;
                    $dirty12 |= i8;
                }
                i8 = 16;
                $dirty12 |= i8;
            }
            if (($changed1 & 896) == 0) {
                if ((i & 4096) != 0) {
                }
                i10 = 128;
                $dirty12 |= i10;
            }
            i7 = i & 8192;
            if (i7 == 0) {
                $dirty12 |= 3072;
            } else if (($changed1 & 7168) == 0) {
                $dirty12 |= $composer3.changed(function25) ? 2048 : 1024;
            }
            if ((i & 16384) == 0) {
                $dirty12 |= 24576;
            } else if (($changed1 & 57344) == 0) {
                $dirty12 |= $composer3.changed(this) ? 16384 : 8192;
            }
            if (($dirty & 1533916891) != 306783378 && (46811 & $dirty12) == 9362 && $composer3.getSkipping()) {
                $composer3.skipToGroupEnd();
                isError2 = isError;
                label = function2;
                placeholder = function22;
                leadingIcon = function23;
                trailingIcon = function24;
                colors3 = colors;
                contentPadding3 = contentPadding;
                border = function25;
                $composer2 = $composer3;
            } else {
                $composer3.startDefaults();
                if (($changed & 1) != 0 || $composer3.getDefaultsInvalid()) {
                    boolean isError3 = i2 == 0 ? false : isError;
                    Function2 label2 = i3 == 0 ? null : function2;
                    Function2 placeholder2 = i4 == 0 ? null : function22;
                    Function2 leadingIcon2 = i5 == 0 ? null : function23;
                    Function2 trailingIcon2 = i6 == 0 ? null : function24;
                    if ((i & 2048) == 0) {
                        colors2 = m1563outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, ($dirty12 >> 9) & SdkConfig.SDK_VERSION, 2097151);
                        $dirty12 &= -113;
                    } else {
                        colors2 = colors;
                    }
                    Function2 placeholder3 = placeholder2;
                    if ((i & 4096) == 0) {
                        contentPadding2 = m1554outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        $dirty12 &= -897;
                    } else {
                        contentPadding2 = contentPadding;
                    }
                    if (i7 == 0) {
                        final boolean z = isError3;
                        final TextFieldColors textFieldColors = colors2;
                        final int i11 = $dirty;
                        final int i12 = $dirty12;
                        contentPadding3 = contentPadding2;
                        placeholder = placeholder3;
                        border = ComposableLambdaKt.composableLambda($composer3, 1261916269, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldDefaults$OutlinedTextFieldDecorationBox$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer4, int $changed2) {
                                ComposerKt.sourceInformation($composer4, "C648@30490L54:TextFieldDefaults.kt#jmzs0o");
                                if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1261916269, $changed2, -1, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox.<anonymous> (TextFieldDefaults.kt:647)");
                                }
                                TextFieldDefaults.INSTANCE.m1557BorderBoxnbWgWpA(enabled, z, interactionSource, textFieldColors, null, 0.0f, 0.0f, $composer4, ((i11 >> 6) & 14) | 12582912 | ((i11 >> 15) & SdkConfig.SDK_VERSION) | ((i11 >> 9) & 896) | ((i12 << 6) & 7168), SdkConfig.SDK_VERSION);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        leadingIcon = leadingIcon2;
                        trailingIcon = trailingIcon2;
                        label = label2;
                        isError2 = isError3;
                        colors3 = colors2;
                        $dirty1 = $dirty12;
                    } else {
                        contentPadding3 = contentPadding2;
                        border = function25;
                        placeholder = placeholder3;
                        leadingIcon = leadingIcon2;
                        trailingIcon = trailingIcon2;
                        label = label2;
                        isError2 = isError3;
                        colors3 = colors2;
                        $dirty1 = $dirty12;
                    }
                } else {
                    $composer3.skipToGroupEnd();
                    if ((i & 2048) != 0) {
                        $dirty12 &= -113;
                    }
                    if ((i & 4096) != 0) {
                        isError2 = isError;
                        label = function2;
                        placeholder = function22;
                        leadingIcon = function23;
                        trailingIcon = function24;
                        colors3 = colors;
                        contentPadding3 = contentPadding;
                        border = function25;
                        $dirty1 = $dirty12 & (-897);
                    } else {
                        isError2 = isError;
                        label = function2;
                        placeholder = function22;
                        leadingIcon = function23;
                        trailingIcon = function24;
                        colors3 = colors;
                        contentPadding3 = contentPadding;
                        border = function25;
                        $dirty1 = $dirty12;
                    }
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1280721485, $dirty, $dirty1, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:633)");
                }
                $composer2 = $composer3;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, value, innerTextField, visualTransformation, label, placeholder, leadingIcon, trailingIcon, singleLine, enabled, isError2, interactionSource, contentPadding3, colors3, border, $composer2, (($dirty << 3) & SdkConfig.SDK_VERSION) | 6 | (($dirty << 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 9) & 57344) | (($dirty >> 9) & 458752) | (($dirty >> 9) & 3670016) | (($dirty1 << 21) & 29360128) | (($dirty << 15) & 234881024) | (($dirty << 21) & 1879048192), (($dirty >> 18) & 14) | (($dirty >> 12) & SdkConfig.SDK_VERSION) | ($dirty1 & 896) | (($dirty1 << 6) & 7168) | (($dirty1 << 3) & 57344), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final boolean z2 = isError2;
            final Function2 function26 = label;
            final Function2 function27 = placeholder;
            final Function2 function28 = leadingIcon;
            final Function2 function29 = trailingIcon;
            final TextFieldColors textFieldColors2 = colors3;
            final PaddingValues paddingValues = contentPadding3;
            final Function2 function210 = border;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldDefaults$OutlinedTextFieldDecorationBox$2
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

                public final void invoke(Composer composer, int i13) {
                    TextFieldDefaults.this.OutlinedTextFieldDecorationBox(value, innerTextField, enabled, singleLine, visualTransformation, interactionSource, z2, function26, function27, function28, function29, textFieldColors2, paddingValues, function210, composer, $changed | 1, $changed1, i);
                }
            });
            return;
        }
        $dirty |= i9;
        i2 = i & 64;
        if (i2 == 0) {
        }
        i3 = i & 128;
        if (i3 == 0) {
        }
        i4 = i & 256;
        if (i4 == 0) {
        }
        i5 = i & 512;
        if (i5 == 0) {
        }
        i6 = i & 1024;
        if (i6 == 0) {
        }
        if (($changed1 & SdkConfig.SDK_VERSION) == 0) {
        }
        if (($changed1 & 896) == 0) {
        }
        i7 = i & 8192;
        if (i7 == 0) {
        }
        if ((i & 16384) == 0) {
        }
        if (($dirty & 1533916891) != 306783378) {
        }
        $composer3.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i2 == 0) {
        }
        if (i3 == 0) {
        }
        if (i4 == 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if ((i & 2048) == 0) {
        }
        Function2 placeholder32 = placeholder2;
        if ((i & 4096) == 0) {
        }
        if (i7 == 0) {
        }
        $composer3.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        $composer2 = $composer3;
        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, value, innerTextField, visualTransformation, label, placeholder, leadingIcon, trailingIcon, singleLine, enabled, isError2, interactionSource, contentPadding3, colors3, border, $composer2, (($dirty << 3) & SdkConfig.SDK_VERSION) | 6 | (($dirty << 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 9) & 57344) | (($dirty >> 9) & 458752) | (($dirty >> 9) & 3670016) | (($dirty1 << 21) & 29360128) | (($dirty << 15) & 234881024) | (($dirty << 21) & 1879048192), (($dirty >> 18) & 14) | (($dirty >> 12) & SdkConfig.SDK_VERSION) | ($dirty1 & 896) | (($dirty1 << 6) & 7168) | (($dirty1 << 3) & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
