package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.p000ui.text.TextRange;
import androidx.compose.p000ui.text.style.ResolvedTextDirection;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: TextFieldSelectionManager.kt */
@Metadata(m286d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a%\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0010"}, m287d2 = {"TextFieldSelectionHandle", "", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "(ZLandroidx/compose/ui/text/style/ResolvedTextDirection;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;J)J", "isSelectionHandleInVisibleBound", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TextFieldSelectionManagerKt {

    /* compiled from: TextFieldSelectionManager.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            iArr[Handle.Cursor.ordinal()] = 1;
            iArr[Handle.SelectionStart.ordinal()] = 2;
            iArr[Handle.SelectionEnd.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void TextFieldSelectionHandle(final boolean isStartHandle, final ResolvedTextDirection direction, final TextFieldSelectionManager manager, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(manager, "manager");
        Composer $composer2 = $composer.startRestartGroup(-1344558920);
        ComposerKt.sourceInformation($composer2, "C(TextFieldSelectionHandle)P(1)811@30545L90,816@30701L327:TextFieldSelectionManager.kt#eksfi3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1344558920, $changed, -1, "androidx.compose.foundation.text.selection.TextFieldSelectionHandle (TextFieldSelectionManager.kt:806)");
        }
        Object key1$iv = Boolean.valueOf(isStartHandle);
        int i = ($changed & 14) | 64;
        $composer2.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer2.changed(key1$iv) | $composer2.changed(manager);
        Object it$iv$iv = $composer2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = manager.handleDragObserver$foundation_release(isStartHandle);
            $composer2.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer2.endReplaceableGroup();
        TextDragObserver observer = (TextDragObserver) value$iv$iv;
        long position = manager.m1209getHandlePositiontuRUvjQ$foundation_release(isStartHandle);
        AndroidSelectionHandles_androidKt.m1121SelectionHandle8fL75g(position, isStartHandle, direction, TextRange.m3956getReversedimpl(manager.getValue$foundation_release().getSelection()), SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, observer, new TextFieldSelectionManagerKt$TextFieldSelectionHandle$1(observer, null)), null, $composer2, (($changed << 3) & SdkConfig.SDK_VERSION) | 196608 | (($changed << 3) & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i2) {
                TextFieldSelectionManagerKt.TextFieldSelectionHandle(isStartHandle, direction, manager, composer, $changed | 1);
            }
        });
    }

    public static final boolean isSelectionHandleInVisibleBound(TextFieldSelectionManager $this$isSelectionHandleInVisibleBound, boolean isStartHandle) {
        LayoutCoordinates layoutCoordinates;
        Rect visibleBounds;
        Intrinsics.checkNotNullParameter($this$isSelectionHandleInVisibleBound, "<this>");
        TextFieldState state = $this$isSelectionHandleInVisibleBound.getState();
        if (state != null && (layoutCoordinates = state.getLayoutCoordinates()) != null && (visibleBounds = SelectionManagerKt.visibleBounds(layoutCoordinates)) != null) {
            return SelectionManagerKt.m1185containsInclusiveUv8p0NA(visibleBounds, $this$isSelectionHandleInVisibleBound.m1209getHandlePositiontuRUvjQ$foundation_release(isStartHandle));
        }
        return false;
    }

    /* renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c, reason: not valid java name */
    public static final long m1210calculateSelectionMagnifierCenterAndroidO0kMr_c(TextFieldSelectionManager manager, long magnifierSize) {
        int rawTextOffset;
        TextLayoutResultProxy layoutResult;
        LayoutCoordinates containerCoordinates;
        TextLayoutResultProxy layoutResult2;
        Intrinsics.checkNotNullParameter(manager, "manager");
        if (manager.getValue$foundation_release().getText().length() == 0) {
            return Offset.INSTANCE.m1775getUnspecifiedF1C5BW0();
        }
        Handle draggingHandle = manager.getDraggingHandle();
        switch (draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()]) {
            case -1:
                return Offset.INSTANCE.m1775getUnspecifiedF1C5BW0();
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
            case 2:
                rawTextOffset = TextRange.m3957getStartimpl(manager.getValue$foundation_release().getSelection());
                break;
            case 3:
                rawTextOffset = TextRange.m3952getEndimpl(manager.getValue$foundation_release().getSelection());
                break;
        }
        int textOffset = RangesKt.coerceIn(manager.getOffsetMapping().originalToTransformed(rawTextOffset), (ClosedRange<Integer>) StringsKt.getIndices(manager.getValue$foundation_release().getText()));
        TextFieldState state = manager.getState();
        if (state != null && (layoutResult = state.getLayoutResult()) != null) {
            TextLayoutResult layoutResult3 = layoutResult.getValue();
            if (layoutResult3 != null) {
                long offsetCenter = layoutResult3.getBoundingBox(textOffset).m1790getCenterF1C5BW0();
                TextFieldState state2 = manager.getState();
                if (state2 != null && (containerCoordinates = state2.getLayoutCoordinates()) != null) {
                    TextFieldState state3 = manager.getState();
                    if (state3 != null && (layoutResult2 = state3.getLayoutResult()) != null) {
                        LayoutCoordinates fieldCoordinates = layoutResult2.getInnerTextFieldCoordinates();
                        if (fieldCoordinates != null) {
                            Offset m1207getCurrentDragPosition_m7T9E = manager.m1207getCurrentDragPosition_m7T9E();
                            if (m1207getCurrentDragPosition_m7T9E == null) {
                                return Offset.INSTANCE.m1775getUnspecifiedF1C5BW0();
                            }
                            long it = m1207getCurrentDragPosition_m7T9E.getPackedValue();
                            float dragX = Offset.m1760getXimpl(fieldCoordinates.mo3498localPositionOfR5De75A(containerCoordinates, it));
                            int line = layoutResult3.getLineForOffset(textOffset);
                            int lineStartOffset = layoutResult3.getLineStart(line);
                            int lineEndOffset = layoutResult3.getLineEnd(line, true);
                            boolean areHandlesCrossed = TextRange.m3957getStartimpl(manager.getValue$foundation_release().getSelection()) > TextRange.m3952getEndimpl(manager.getValue$foundation_release().getSelection());
                            float lineStart = TextSelectionDelegateKt.getHorizontalPosition(layoutResult3, lineStartOffset, true, areHandlesCrossed);
                            float lineEnd = TextSelectionDelegateKt.getHorizontalPosition(layoutResult3, lineEndOffset, false, areHandlesCrossed);
                            float lineMin = Math.min(lineStart, lineEnd);
                            float lineMax = Math.max(lineStart, lineEnd);
                            float centerX = RangesKt.coerceIn(dragX, lineMin, lineMax);
                            if (Math.abs(dragX - centerX) > IntSize.m4542getWidthimpl(magnifierSize) / 2) {
                                return Offset.INSTANCE.m1775getUnspecifiedF1C5BW0();
                            }
                            return containerCoordinates.mo3498localPositionOfR5De75A(fieldCoordinates, OffsetKt.Offset(centerX, Offset.m1761getYimpl(offsetCenter)));
                        }
                    }
                    return Offset.INSTANCE.m1775getUnspecifiedF1C5BW0();
                }
                return Offset.INSTANCE.m1775getUnspecifiedF1C5BW0();
            }
        }
        return Offset.INSTANCE.m1775getUnspecifiedF1C5BW0();
    }
}
