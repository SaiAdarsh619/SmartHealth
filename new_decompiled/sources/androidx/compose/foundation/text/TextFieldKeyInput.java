package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.p000ui.input.key.KeyEventType;
import androidx.compose.p000ui.input.key.KeyEvent_androidKt;
import androidx.compose.p000ui.text.TextRange;
import androidx.compose.p000ui.text.input.CommitTextCommand;
import androidx.compose.p000ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.p000ui.text.input.EditCommand;
import androidx.compose.p000ui.text.input.EditProcessor;
import androidx.compose.p000ui.text.input.FinishComposingTextCommand;
import androidx.compose.p000ui.text.input.OffsetMapping;
import androidx.compose.p000ui.text.input.TextFieldValue;
import androidx.core.app.NotificationCompat;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: TextFieldKeyInput.kt */
@Metadata(m286d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\b\u0000\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\u0010\u0016J!\u0010&\u001a\u00020\u00152\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\b)H\u0002J\u001b\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020,ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.J\u001f\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010+\u001a\u00020,H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102J\f\u00103\u001a\u00020\u0015*\u000204H\u0002J\u0012\u00103\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020405H\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00066"}, m287d2 = {"Landroidx/compose/foundation/text/TextFieldKeyInput;", "", "state", "Landroidx/compose/foundation/text/TextFieldState;", "selectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "editable", "", "singleLine", "preparedSelectionState", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "keyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "onValueChange", "Lkotlin/Function1;", "", "(Landroidx/compose/foundation/text/TextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/ui/text/input/TextFieldValue;ZZLandroidx/compose/foundation/text/selection/TextPreparedSelectionState;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/UndoManager;Landroidx/compose/foundation/text/KeyMapping;Lkotlin/jvm/functions/Function1;)V", "getEditable", "()Z", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "getPreparedSelectionState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "getSelectionManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "getSingleLine", "getState", "()Landroidx/compose/foundation/text/TextFieldState;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "getValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "commandExecutionContext", "block", "Landroidx/compose/foundation/text/selection/TextFieldPreparedSelection;", "Lkotlin/ExtensionFunctionType;", "process", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/key/KeyEvent;", "process-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "typedCommand", "Landroidx/compose/ui/text/input/CommitTextCommand;", "typedCommand-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/text/input/CommitTextCommand;", "apply", "Landroidx/compose/ui/text/input/EditCommand;", "", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TextFieldKeyInput {
    private final boolean editable;
    private final KeyMapping keyMapping;
    private final OffsetMapping offsetMapping;
    private final Function1<TextFieldValue, Unit> onValueChange;
    private final TextPreparedSelectionState preparedSelectionState;
    private final TextFieldSelectionManager selectionManager;
    private final boolean singleLine;
    private final TextFieldState state;
    private final UndoManager undoManager;
    private final TextFieldValue value;

    /* JADX WARN: Multi-variable type inference failed */
    public TextFieldKeyInput(TextFieldState state, TextFieldSelectionManager selectionManager, TextFieldValue value, boolean editable, boolean singleLine, TextPreparedSelectionState preparedSelectionState, OffsetMapping offsetMapping, UndoManager undoManager, KeyMapping keyMapping, Function1<? super TextFieldValue, Unit> onValueChange) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(selectionManager, "selectionManager");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(preparedSelectionState, "preparedSelectionState");
        Intrinsics.checkNotNullParameter(offsetMapping, "offsetMapping");
        Intrinsics.checkNotNullParameter(keyMapping, "keyMapping");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        this.state = state;
        this.selectionManager = selectionManager;
        this.value = value;
        this.editable = editable;
        this.singleLine = singleLine;
        this.preparedSelectionState = preparedSelectionState;
        this.offsetMapping = offsetMapping;
        this.undoManager = undoManager;
        this.keyMapping = keyMapping;
        this.onValueChange = onValueChange;
    }

    public /* synthetic */ TextFieldKeyInput(TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z, boolean z2, TextPreparedSelectionState textPreparedSelectionState, OffsetMapping offsetMapping, UndoManager undoManager, KeyMapping keyMapping, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textFieldState, textFieldSelectionManager, (i & 4) != 0 ? new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null) : textFieldValue, (i & 8) != 0 ? true : z, (i & 16) != 0 ? false : z2, textPreparedSelectionState, (i & 64) != 0 ? OffsetMapping.INSTANCE.getIdentity() : offsetMapping, (i & 128) != 0 ? null : undoManager, (i & 256) != 0 ? KeyMapping_androidKt.getPlatformDefaultKeyMapping() : keyMapping, (i & 512) != 0 ? new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue2) {
                invoke2(textFieldValue2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldValue it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }
        } : function1);
    }

    public final TextFieldState getState() {
        return this.state;
    }

    public final TextFieldSelectionManager getSelectionManager() {
        return this.selectionManager;
    }

    public final TextFieldValue getValue() {
        return this.value;
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final TextPreparedSelectionState getPreparedSelectionState() {
        return this.preparedSelectionState;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void apply(List<? extends EditCommand> list) {
        EditProcessor processor = this.state.getProcessor();
        List $this$apply_u24lambda_u2d0 = CollectionsKt.toMutableList((Collection) list);
        $this$apply_u24lambda_u2d0.add(0, new FinishComposingTextCommand());
        TextFieldValue newTextFieldValue = processor.apply($this$apply_u24lambda_u2d0);
        this.onValueChange.invoke(newTextFieldValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void apply(EditCommand $this$apply) {
        apply(CollectionsKt.listOf($this$apply));
    }

    /* renamed from: typedCommand-ZmokQxo, reason: not valid java name */
    private final CommitTextCommand m1090typedCommandZmokQxo(KeyEvent event) {
        if (TextFieldKeyInput_androidKt.m1093isTypedEventZmokQxo(event)) {
            String text = StringHelpers_jvmKt.appendCodePointX(new StringBuilder(), KeyEvent_androidKt.m3232getUtf16CodePointZmokQxo(event)).toString();
            Intrinsics.checkNotNullExpressionValue(text, "StringBuilder().appendCo…              .toString()");
            return new CommitTextCommand(text, 1);
        }
        return null;
    }

    /* renamed from: process-ZmokQxo, reason: not valid java name */
    public final boolean m1091processZmokQxo(KeyEvent event) {
        final KeyCommand command;
        Intrinsics.checkNotNullParameter(event, "event");
        CommitTextCommand it = m1090typedCommandZmokQxo(event);
        if (it != null) {
            if (!this.editable) {
                return false;
            }
            apply(it);
            this.preparedSelectionState.resetCachedX();
            return true;
        }
        if (!KeyEventType.m3223equalsimpl0(KeyEvent_androidKt.m3231getTypeZmokQxo(event), KeyEventType.INSTANCE.m3227getKeyDownCS__XNY()) || (command = this.keyMapping.mo1036mapZmokQxo(event)) == null || (command.getEditsText() && !this.editable)) {
            return false;
        }
        final Ref.BooleanRef consumed = new Ref.BooleanRef();
        consumed.element = true;
        commandExecutionContext(new Function1<TextFieldPreparedSelection, Unit>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2

            /* compiled from: TextFieldKeyInput.kt */
            @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[KeyCommand.values().length];
                    iArr[KeyCommand.COPY.ordinal()] = 1;
                    iArr[KeyCommand.PASTE.ordinal()] = 2;
                    iArr[KeyCommand.CUT.ordinal()] = 3;
                    iArr[KeyCommand.LEFT_CHAR.ordinal()] = 4;
                    iArr[KeyCommand.RIGHT_CHAR.ordinal()] = 5;
                    iArr[KeyCommand.LEFT_WORD.ordinal()] = 6;
                    iArr[KeyCommand.RIGHT_WORD.ordinal()] = 7;
                    iArr[KeyCommand.PREV_PARAGRAPH.ordinal()] = 8;
                    iArr[KeyCommand.NEXT_PARAGRAPH.ordinal()] = 9;
                    iArr[KeyCommand.UP.ordinal()] = 10;
                    iArr[KeyCommand.DOWN.ordinal()] = 11;
                    iArr[KeyCommand.PAGE_UP.ordinal()] = 12;
                    iArr[KeyCommand.PAGE_DOWN.ordinal()] = 13;
                    iArr[KeyCommand.LINE_START.ordinal()] = 14;
                    iArr[KeyCommand.LINE_END.ordinal()] = 15;
                    iArr[KeyCommand.LINE_LEFT.ordinal()] = 16;
                    iArr[KeyCommand.LINE_RIGHT.ordinal()] = 17;
                    iArr[KeyCommand.HOME.ordinal()] = 18;
                    iArr[KeyCommand.END.ordinal()] = 19;
                    iArr[KeyCommand.DELETE_PREV_CHAR.ordinal()] = 20;
                    iArr[KeyCommand.DELETE_NEXT_CHAR.ordinal()] = 21;
                    iArr[KeyCommand.DELETE_PREV_WORD.ordinal()] = 22;
                    iArr[KeyCommand.DELETE_NEXT_WORD.ordinal()] = 23;
                    iArr[KeyCommand.DELETE_FROM_LINE_START.ordinal()] = 24;
                    iArr[KeyCommand.DELETE_TO_LINE_END.ordinal()] = 25;
                    iArr[KeyCommand.NEW_LINE.ordinal()] = 26;
                    iArr[KeyCommand.TAB.ordinal()] = 27;
                    iArr[KeyCommand.SELECT_ALL.ordinal()] = 28;
                    iArr[KeyCommand.SELECT_LEFT_CHAR.ordinal()] = 29;
                    iArr[KeyCommand.SELECT_RIGHT_CHAR.ordinal()] = 30;
                    iArr[KeyCommand.SELECT_LEFT_WORD.ordinal()] = 31;
                    iArr[KeyCommand.SELECT_RIGHT_WORD.ordinal()] = 32;
                    iArr[KeyCommand.SELECT_PREV_PARAGRAPH.ordinal()] = 33;
                    iArr[KeyCommand.SELECT_NEXT_PARAGRAPH.ordinal()] = 34;
                    iArr[KeyCommand.SELECT_LINE_START.ordinal()] = 35;
                    iArr[KeyCommand.SELECT_LINE_END.ordinal()] = 36;
                    iArr[KeyCommand.SELECT_LINE_LEFT.ordinal()] = 37;
                    iArr[KeyCommand.SELECT_LINE_RIGHT.ordinal()] = 38;
                    iArr[KeyCommand.SELECT_UP.ordinal()] = 39;
                    iArr[KeyCommand.SELECT_DOWN.ordinal()] = 40;
                    iArr[KeyCommand.SELECT_PAGE_UP.ordinal()] = 41;
                    iArr[KeyCommand.SELECT_PAGE_DOWN.ordinal()] = 42;
                    iArr[KeyCommand.SELECT_HOME.ordinal()] = 43;
                    iArr[KeyCommand.SELECT_END.ordinal()] = 44;
                    iArr[KeyCommand.DESELECT.ordinal()] = 45;
                    iArr[KeyCommand.UNDO.ordinal()] = 46;
                    iArr[KeyCommand.REDO.ordinal()] = 47;
                    iArr[KeyCommand.CHARACTER_PALETTE.ordinal()] = 48;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldPreparedSelection textFieldPreparedSelection) {
                invoke2(textFieldPreparedSelection);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldPreparedSelection commandExecutionContext) {
                TextFieldValue it2;
                Function1 function1;
                TextFieldValue it3;
                Function1 function12;
                Intrinsics.checkNotNullParameter(commandExecutionContext, "$this$commandExecutionContext");
                switch (WhenMappings.$EnumSwitchMapping$0[KeyCommand.this.ordinal()]) {
                    case 1:
                        this.getSelectionManager().copy$foundation_release(false);
                        break;
                    case 2:
                        this.getSelectionManager().paste$foundation_release();
                        break;
                    case 3:
                        this.getSelectionManager().cut$foundation_release();
                        break;
                    case 4:
                        commandExecutionContext.collapseLeftOr(new Function1<TextFieldPreparedSelection, Unit>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldPreparedSelection textFieldPreparedSelection) {
                                invoke2(textFieldPreparedSelection);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldPreparedSelection collapseLeftOr) {
                                Intrinsics.checkNotNullParameter(collapseLeftOr, "$this$collapseLeftOr");
                                collapseLeftOr.moveCursorLeft();
                            }
                        });
                        break;
                    case 5:
                        commandExecutionContext.collapseRightOr(new Function1<TextFieldPreparedSelection, Unit>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldPreparedSelection textFieldPreparedSelection) {
                                invoke2(textFieldPreparedSelection);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldPreparedSelection collapseRightOr) {
                                Intrinsics.checkNotNullParameter(collapseRightOr, "$this$collapseRightOr");
                                collapseRightOr.moveCursorRight();
                            }
                        });
                        break;
                    case 6:
                        commandExecutionContext.moveCursorLeftByWord();
                        break;
                    case 7:
                        commandExecutionContext.moveCursorRightByWord();
                        break;
                    case 8:
                        commandExecutionContext.moveCursorPrevByParagraph();
                        break;
                    case 9:
                        commandExecutionContext.moveCursorNextByParagraph();
                        break;
                    case 10:
                        commandExecutionContext.moveCursorUpByLine();
                        break;
                    case 11:
                        commandExecutionContext.moveCursorDownByLine();
                        break;
                    case 12:
                        commandExecutionContext.moveCursorUpByPage();
                        break;
                    case 13:
                        commandExecutionContext.moveCursorDownByPage();
                        break;
                    case 14:
                        commandExecutionContext.moveCursorToLineStart();
                        break;
                    case 15:
                        commandExecutionContext.moveCursorToLineEnd();
                        break;
                    case 16:
                        commandExecutionContext.moveCursorToLineLeftSide();
                        break;
                    case 17:
                        commandExecutionContext.moveCursorToLineRightSide();
                        break;
                    case 18:
                        commandExecutionContext.moveCursorToHome();
                        break;
                    case 19:
                        commandExecutionContext.moveCursorToEnd();
                        break;
                    case 20:
                        List<EditCommand> deleteIfSelectedOr = commandExecutionContext.deleteIfSelectedOr(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final EditCommand invoke(TextFieldPreparedSelection deleteIfSelectedOr2) {
                                Intrinsics.checkNotNullParameter(deleteIfSelectedOr2, "$this$deleteIfSelectedOr");
                                return new DeleteSurroundingTextCommand(TextRange.m3952getEndimpl(deleteIfSelectedOr2.getSelection()) - deleteIfSelectedOr2.getPrecedingCharacterIndex(), 0);
                            }
                        });
                        if (deleteIfSelectedOr != null) {
                            this.apply((List<? extends EditCommand>) deleteIfSelectedOr);
                            break;
                        }
                        break;
                    case 21:
                        List<EditCommand> deleteIfSelectedOr2 = commandExecutionContext.deleteIfSelectedOr(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.4
                            @Override // kotlin.jvm.functions.Function1
                            public final EditCommand invoke(TextFieldPreparedSelection deleteIfSelectedOr3) {
                                Intrinsics.checkNotNullParameter(deleteIfSelectedOr3, "$this$deleteIfSelectedOr");
                                int nextCharacterIndex = deleteIfSelectedOr3.getNextCharacterIndex();
                                if (nextCharacterIndex != -1) {
                                    return new DeleteSurroundingTextCommand(0, nextCharacterIndex - TextRange.m3952getEndimpl(deleteIfSelectedOr3.getSelection()));
                                }
                                return null;
                            }
                        });
                        if (deleteIfSelectedOr2 != null) {
                            this.apply((List<? extends EditCommand>) deleteIfSelectedOr2);
                            break;
                        }
                        break;
                    case 22:
                        List<EditCommand> deleteIfSelectedOr3 = commandExecutionContext.deleteIfSelectedOr(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.5
                            @Override // kotlin.jvm.functions.Function1
                            public final EditCommand invoke(TextFieldPreparedSelection deleteIfSelectedOr4) {
                                DeleteSurroundingTextCommand deleteSurroundingTextCommand;
                                Intrinsics.checkNotNullParameter(deleteIfSelectedOr4, "$this$deleteIfSelectedOr");
                                Integer previousWordOffset = deleteIfSelectedOr4.getPreviousWordOffset();
                                if (previousWordOffset != null) {
                                    int it4 = previousWordOffset.intValue();
                                    deleteSurroundingTextCommand = new DeleteSurroundingTextCommand(TextRange.m3952getEndimpl(deleteIfSelectedOr4.getSelection()) - it4, 0);
                                } else {
                                    deleteSurroundingTextCommand = null;
                                }
                                return deleteSurroundingTextCommand;
                            }
                        });
                        if (deleteIfSelectedOr3 != null) {
                            this.apply((List<? extends EditCommand>) deleteIfSelectedOr3);
                            break;
                        }
                        break;
                    case 23:
                        List<EditCommand> deleteIfSelectedOr4 = commandExecutionContext.deleteIfSelectedOr(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.6
                            @Override // kotlin.jvm.functions.Function1
                            public final EditCommand invoke(TextFieldPreparedSelection deleteIfSelectedOr5) {
                                DeleteSurroundingTextCommand deleteSurroundingTextCommand;
                                Intrinsics.checkNotNullParameter(deleteIfSelectedOr5, "$this$deleteIfSelectedOr");
                                Integer nextWordOffset = deleteIfSelectedOr5.getNextWordOffset();
                                if (nextWordOffset != null) {
                                    int it4 = nextWordOffset.intValue();
                                    deleteSurroundingTextCommand = new DeleteSurroundingTextCommand(0, it4 - TextRange.m3952getEndimpl(deleteIfSelectedOr5.getSelection()));
                                } else {
                                    deleteSurroundingTextCommand = null;
                                }
                                return deleteSurroundingTextCommand;
                            }
                        });
                        if (deleteIfSelectedOr4 != null) {
                            this.apply((List<? extends EditCommand>) deleteIfSelectedOr4);
                            break;
                        }
                        break;
                    case 24:
                        List<EditCommand> deleteIfSelectedOr5 = commandExecutionContext.deleteIfSelectedOr(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.7
                            @Override // kotlin.jvm.functions.Function1
                            public final EditCommand invoke(TextFieldPreparedSelection deleteIfSelectedOr6) {
                                DeleteSurroundingTextCommand deleteSurroundingTextCommand;
                                Intrinsics.checkNotNullParameter(deleteIfSelectedOr6, "$this$deleteIfSelectedOr");
                                Integer lineStartByOffset = deleteIfSelectedOr6.getLineStartByOffset();
                                if (lineStartByOffset != null) {
                                    int it4 = lineStartByOffset.intValue();
                                    deleteSurroundingTextCommand = new DeleteSurroundingTextCommand(TextRange.m3952getEndimpl(deleteIfSelectedOr6.getSelection()) - it4, 0);
                                } else {
                                    deleteSurroundingTextCommand = null;
                                }
                                return deleteSurroundingTextCommand;
                            }
                        });
                        if (deleteIfSelectedOr5 != null) {
                            this.apply((List<? extends EditCommand>) deleteIfSelectedOr5);
                            break;
                        }
                        break;
                    case 25:
                        List<EditCommand> deleteIfSelectedOr6 = commandExecutionContext.deleteIfSelectedOr(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.8
                            @Override // kotlin.jvm.functions.Function1
                            public final EditCommand invoke(TextFieldPreparedSelection deleteIfSelectedOr7) {
                                DeleteSurroundingTextCommand deleteSurroundingTextCommand;
                                Intrinsics.checkNotNullParameter(deleteIfSelectedOr7, "$this$deleteIfSelectedOr");
                                Integer lineEndByOffset = deleteIfSelectedOr7.getLineEndByOffset();
                                if (lineEndByOffset != null) {
                                    int it4 = lineEndByOffset.intValue();
                                    deleteSurroundingTextCommand = new DeleteSurroundingTextCommand(0, it4 - TextRange.m3952getEndimpl(deleteIfSelectedOr7.getSelection()));
                                } else {
                                    deleteSurroundingTextCommand = null;
                                }
                                return deleteSurroundingTextCommand;
                            }
                        });
                        if (deleteIfSelectedOr6 != null) {
                            this.apply((List<? extends EditCommand>) deleteIfSelectedOr6);
                            break;
                        }
                        break;
                    case 26:
                        if (!this.getSingleLine()) {
                            this.apply(new CommitTextCommand("\n", 1));
                            break;
                        } else {
                            consumed.element = false;
                            break;
                        }
                    case 27:
                        if (!this.getSingleLine()) {
                            this.apply(new CommitTextCommand("\t", 1));
                            break;
                        } else {
                            consumed.element = false;
                            break;
                        }
                    case 28:
                        commandExecutionContext.selectAll();
                        break;
                    case 29:
                        commandExecutionContext.moveCursorLeft().selectMovement();
                        break;
                    case 30:
                        commandExecutionContext.moveCursorRight().selectMovement();
                        break;
                    case 31:
                        commandExecutionContext.moveCursorLeftByWord().selectMovement();
                        break;
                    case 32:
                        commandExecutionContext.moveCursorRightByWord().selectMovement();
                        break;
                    case 33:
                        commandExecutionContext.moveCursorPrevByParagraph().selectMovement();
                        break;
                    case 34:
                        commandExecutionContext.moveCursorNextByParagraph().selectMovement();
                        break;
                    case 35:
                        commandExecutionContext.moveCursorToLineStart().selectMovement();
                        break;
                    case 36:
                        commandExecutionContext.moveCursorToLineEnd().selectMovement();
                        break;
                    case 37:
                        commandExecutionContext.moveCursorToLineLeftSide().selectMovement();
                        break;
                    case 38:
                        commandExecutionContext.moveCursorToLineRightSide().selectMovement();
                        break;
                    case 39:
                        commandExecutionContext.moveCursorUpByLine().selectMovement();
                        break;
                    case 40:
                        commandExecutionContext.moveCursorDownByLine().selectMovement();
                        break;
                    case 41:
                        commandExecutionContext.moveCursorUpByPage().selectMovement();
                        break;
                    case 42:
                        commandExecutionContext.moveCursorDownByPage().selectMovement();
                        break;
                    case 43:
                        commandExecutionContext.moveCursorToHome().selectMovement();
                        break;
                    case 44:
                        commandExecutionContext.moveCursorToEnd().selectMovement();
                        break;
                    case 45:
                        commandExecutionContext.deselect();
                        break;
                    case 46:
                        UndoManager undoManager = this.getUndoManager();
                        if (undoManager != null) {
                            undoManager.makeSnapshot(commandExecutionContext.getValue());
                        }
                        UndoManager undoManager2 = this.getUndoManager();
                        if (undoManager2 != null && (it2 = undoManager2.undo()) != null) {
                            function1 = this.onValueChange;
                            function1.invoke(it2);
                            break;
                        }
                        break;
                    case 47:
                        UndoManager undoManager3 = this.getUndoManager();
                        if (undoManager3 != null && (it3 = undoManager3.redo()) != null) {
                            function12 = this.onValueChange;
                            function12.invoke(it3);
                            break;
                        }
                        break;
                    case 48:
                        KeyEventHelpers_androidKt.showCharacterPalette();
                        break;
                }
            }
        });
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
        return consumed.element;
    }

    private final void commandExecutionContext(Function1<? super TextFieldPreparedSelection, Unit> block) {
        TextFieldPreparedSelection preparedSelection = new TextFieldPreparedSelection(this.value, this.offsetMapping, this.state.getLayoutResult(), this.preparedSelectionState);
        block.invoke(preparedSelection);
        if (!TextRange.m3950equalsimpl0(preparedSelection.getSelection(), this.value.getSelection()) || !Intrinsics.areEqual(preparedSelection.getAnnotatedString(), this.value.getText())) {
            this.onValueChange.invoke(preparedSelection.getValue());
        }
    }
}
