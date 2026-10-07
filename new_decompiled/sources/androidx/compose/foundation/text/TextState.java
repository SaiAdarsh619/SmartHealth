package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoreText.kt */
@Metadata(m286d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\b0\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R%\u0010#\u001a\u00020$X\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010&R%\u00101\u001a\u000202X\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00069"}, m287d2 = {"Landroidx/compose/foundation/text/TextState;", "", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "selectableId", "", "(Landroidx/compose/foundation/text/TextDelegate;J)V", "<set-?>", "", "drawScopeInvalidation", "getDrawScopeInvalidation", "()Lkotlin/Unit;", "setDrawScopeInvalidation", "(Lkotlin/Unit;)V", "drawScopeInvalidation$delegate", "Landroidx/compose/runtime/MutableState;", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "value", "Landroidx/compose/ui/text/TextLayoutResult;", "layoutResult", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "setLayoutResult", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "onTextLayout", "Lkotlin/Function1;", "getOnTextLayout", "()Lkotlin/jvm/functions/Function1;", "setOnTextLayout", "(Lkotlin/jvm/functions/Function1;)V", "previousGlobalPosition", "Landroidx/compose/ui/geometry/Offset;", "getPreviousGlobalPosition-F1C5BW0", "()J", "setPreviousGlobalPosition-k-4lQ0M", "(J)V", "J", "selectable", "Landroidx/compose/foundation/text/selection/Selectable;", "getSelectable", "()Landroidx/compose/foundation/text/selection/Selectable;", "setSelectable", "(Landroidx/compose/foundation/text/selection/Selectable;)V", "getSelectableId", "selectionBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "getSelectionBackgroundColor-0d7_KjU", "setSelectionBackgroundColor-8_81llA", "getTextDelegate", "()Landroidx/compose/foundation/text/TextDelegate;", "setTextDelegate", "(Landroidx/compose/foundation/text/TextDelegate;)V", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TextState {

    /* renamed from: drawScopeInvalidation$delegate, reason: from kotlin metadata */
    private final MutableState drawScopeInvalidation;
    private LayoutCoordinates layoutCoordinates;
    private TextLayoutResult layoutResult;
    private Function1<? super TextLayoutResult, Unit> onTextLayout;
    private long previousGlobalPosition;
    private Selectable selectable;
    private final long selectableId;
    private long selectionBackgroundColor;
    private TextDelegate textDelegate;

    public TextState(TextDelegate textDelegate, long selectableId) {
        Intrinsics.checkNotNullParameter(textDelegate, "textDelegate");
        this.textDelegate = textDelegate;
        this.selectableId = selectableId;
        this.onTextLayout = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.TextState$onTextLayout$1
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
        this.previousGlobalPosition = Offset.INSTANCE.m1776getZeroF1C5BW0();
        this.selectionBackgroundColor = Color.INSTANCE.m2032getUnspecified0d7_KjU();
        this.drawScopeInvalidation = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
    }

    public final TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public final void setTextDelegate(TextDelegate textDelegate) {
        Intrinsics.checkNotNullParameter(textDelegate, "<set-?>");
        this.textDelegate = textDelegate;
    }

    public final long getSelectableId() {
        return this.selectableId;
    }

    public final Function1<TextLayoutResult, Unit> getOnTextLayout() {
        return this.onTextLayout;
    }

    public final void setOnTextLayout(Function1<? super TextLayoutResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onTextLayout = function1;
    }

    public final Selectable getSelectable() {
        return this.selectable;
    }

    public final void setSelectable(Selectable selectable) {
        this.selectable = selectable;
    }

    public final LayoutCoordinates getLayoutCoordinates() {
        return this.layoutCoordinates;
    }

    public final void setLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this.layoutCoordinates = layoutCoordinates;
    }

    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult;
    }

    public final void setLayoutResult(TextLayoutResult value) {
        setDrawScopeInvalidation(Unit.INSTANCE);
        this.layoutResult = value;
    }

    /* renamed from: getPreviousGlobalPosition-F1C5BW0, reason: not valid java name and from getter */
    public final long getPreviousGlobalPosition() {
        return this.previousGlobalPosition;
    }

    /* renamed from: setPreviousGlobalPosition-k-4lQ0M, reason: not valid java name */
    public final void m1118setPreviousGlobalPositionk4lQ0M(long j) {
        this.previousGlobalPosition = j;
    }

    /* renamed from: getSelectionBackgroundColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectionBackgroundColor() {
        return this.selectionBackgroundColor;
    }

    /* renamed from: setSelectionBackgroundColor-8_81llA, reason: not valid java name */
    public final void m1119setSelectionBackgroundColor8_81llA(long j) {
        this.selectionBackgroundColor = j;
    }

    private final void setDrawScopeInvalidation(Unit unit) {
        MutableState $this$setValue$iv = this.drawScopeInvalidation;
        $this$setValue$iv.setValue(unit);
    }

    public final Unit getDrawScopeInvalidation() {
        State $this$getValue$iv = this.drawScopeInvalidation;
        $this$getValue$iv.getValue();
        return Unit.INSTANCE;
    }
}
