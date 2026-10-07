package androidx.compose.p000ui.text.input;

import android.content.Context;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.p000ui.text.TextRange;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

/* compiled from: TextInputServiceAndroid.android.kt */
@Metadata(m286d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001:\u0001>B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,J\b\u0010-\u001a\u00020\u001cH\u0016J\u0006\u0010.\u001a\u00020\u000fJ\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u000201H\u0017J\b\u00102\u001a\u00020\u001cH\u0002J\u0010\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u000fH\u0002J\b\u00105\u001a\u00020\u001cH\u0016JI\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00172\u0018\u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020\u001c0\u00192\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c0\u0019H\u0016ø\u0001\u0000J\b\u00108\u001a\u00020\u001cH\u0016J\u0011\u00109\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010:J\u001a\u0010;\u001a\u00020\u001c2\b\u0010<\u001a\u0004\u0018\u00010 2\u0006\u0010=\u001a\u00020 H\u0016R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020\u001c0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c0\u0019X\u0082\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 @BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, m287d2 = {"Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "inputMethodManager", "Landroidx/compose/ui/text/input/InputMethodManager;", "(Landroid/view/View;Landroidx/compose/ui/text/input/InputMethodManager;)V", "baseInputConnection", "Landroid/view/inputmethod/BaseInputConnection;", "getBaseInputConnection", "()Landroid/view/inputmethod/BaseInputConnection;", "baseInputConnection$delegate", "Lkotlin/Lazy;", "editorHasFocus", "", "focusedRect", "Landroid/graphics/Rect;", "ics", "", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/text/input/RecordingInputConnection;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onEditCommand", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/input/EditCommand;", "", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "<set-?>", "Landroidx/compose/ui/text/input/TextFieldValue;", "state", "getState$ui_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "textInputCommandChannel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/ui/text/input/TextInputServiceAndroid$TextInputCommand;", "getView", "()Landroid/view/View;", "createInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "hideSoftwareKeyboard", "isEditorFocused", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "restartInputImmediately", "setKeyboardVisibleImmediately", "visible", "showSoftwareKeyboard", "startInput", "value", "stopInput", "textInputCommandEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateState", "oldValue", "newValue", "TextInputCommand", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TextInputServiceAndroid implements PlatformTextInputService {

    /* renamed from: baseInputConnection$delegate, reason: from kotlin metadata */
    private final Lazy baseInputConnection;
    private boolean editorHasFocus;
    private Rect focusedRect;
    private List<WeakReference<RecordingInputConnection>> ics;
    private ImeOptions imeOptions;
    private final InputMethodManager inputMethodManager;
    private Function1<? super List<? extends EditCommand>, Unit> onEditCommand;
    private Function1<? super ImeAction, Unit> onImeActionPerformed;
    private TextFieldValue state;
    private final Channel<TextInputCommand> textInputCommandChannel;
    private final View view;

    /* compiled from: TextInputServiceAndroid.android.kt */
    @Metadata(m286d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m287d2 = {"Landroidx/compose/ui/text/input/TextInputServiceAndroid$TextInputCommand;", "", "(Ljava/lang/String;I)V", "StartInput", "StopInput", "ShowKeyboard", "HideKeyboard", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    private enum TextInputCommand {
        StartInput,
        StopInput,
        ShowKeyboard,
        HideKeyboard
    }

    /* compiled from: TextInputServiceAndroid.android.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextInputCommand.values().length];
            iArr[TextInputCommand.StartInput.ordinal()] = 1;
            iArr[TextInputCommand.StopInput.ordinal()] = 2;
            iArr[TextInputCommand.ShowKeyboard.ordinal()] = 3;
            iArr[TextInputCommand.HideKeyboard.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TextInputServiceAndroid(View view, InputMethodManager inputMethodManager) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(inputMethodManager, "inputMethodManager");
        this.view = view;
        this.inputMethodManager = inputMethodManager;
        this.onEditCommand = new Function1<List<? extends EditCommand>, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$onEditCommand$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends EditCommand> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends EditCommand> it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }
        };
        this.onImeActionPerformed = new Function1<ImeAction, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$onImeActionPerformed$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ImeAction imeAction) {
                m4143invokeKlQnJC8(imeAction.getValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-KlQnJC8, reason: not valid java name */
            public final void m4143invokeKlQnJC8(int it) {
            }
        };
        this.state = new TextFieldValue("", TextRange.INSTANCE.m3962getZerod9O1mEE(), (TextRange) null, 4, (DefaultConstructorMarker) null);
        this.imeOptions = ImeOptions.INSTANCE.getDefault();
        this.ics = new ArrayList();
        this.baseInputConnection = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<BaseInputConnection>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$baseInputConnection$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BaseInputConnection invoke() {
                return new BaseInputConnection(TextInputServiceAndroid.this.getView(), false);
            }
        });
        this.textInputCommandChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    }

    public final View getView() {
        return this.view;
    }

    /* renamed from: getState$ui_release, reason: from getter */
    public final TextFieldValue getState() {
        return this.state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseInputConnection getBaseInputConnection() {
        return (BaseInputConnection) this.baseInputConnection.getValue();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextInputServiceAndroid(View view) {
        this(view, new InputMethodManagerImpl(r1));
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
    }

    public final InputConnection createInputConnection(EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        if (!this.editorHasFocus) {
            return null;
        }
        TextInputServiceAndroid_androidKt.update(outAttrs, this.imeOptions, this.state);
        RecordingInputConnection it = new RecordingInputConnection(this.state, new InputEventCallback2() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$createInputConnection$1
            @Override // androidx.compose.p000ui.text.input.InputEventCallback2
            public void onEditCommands(List<? extends EditCommand> editCommands) {
                Function1 function1;
                Intrinsics.checkNotNullParameter(editCommands, "editCommands");
                function1 = TextInputServiceAndroid.this.onEditCommand;
                function1.invoke(editCommands);
            }

            @Override // androidx.compose.p000ui.text.input.InputEventCallback2
            /* renamed from: onImeAction-KlQnJC8 */
            public void mo4109onImeActionKlQnJC8(int imeAction) {
                Function1 function1;
                function1 = TextInputServiceAndroid.this.onImeActionPerformed;
                function1.invoke(ImeAction.m4088boximpl(imeAction));
            }

            @Override // androidx.compose.p000ui.text.input.InputEventCallback2
            public void onKeyEvent(KeyEvent event) {
                BaseInputConnection baseInputConnection;
                Intrinsics.checkNotNullParameter(event, "event");
                baseInputConnection = TextInputServiceAndroid.this.getBaseInputConnection();
                baseInputConnection.sendKeyEvent(event);
            }

            @Override // androidx.compose.p000ui.text.input.InputEventCallback2
            public void onConnectionClosed(RecordingInputConnection ic) {
                List list;
                List list2;
                List list3;
                Intrinsics.checkNotNullParameter(ic, "ic");
                list = TextInputServiceAndroid.this.ics;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list2 = TextInputServiceAndroid.this.ics;
                    if (Intrinsics.areEqual(((WeakReference) list2.get(i)).get(), ic)) {
                        list3 = TextInputServiceAndroid.this.ics;
                        list3.remove(i);
                        return;
                    }
                }
            }
        }, this.imeOptions.getAutoCorrect());
        this.ics.add(new WeakReference<>(it));
        return it;
    }

    /* renamed from: isEditorFocused, reason: from getter */
    public final boolean getEditorHasFocus() {
        return this.editorHasFocus;
    }

    @Override // androidx.compose.p000ui.text.input.PlatformTextInputService
    public void startInput(TextFieldValue value, ImeOptions imeOptions, Function1<? super List<? extends EditCommand>, Unit> onEditCommand, Function1<? super ImeAction, Unit> onImeActionPerformed) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
        Intrinsics.checkNotNullParameter(onEditCommand, "onEditCommand");
        Intrinsics.checkNotNullParameter(onImeActionPerformed, "onImeActionPerformed");
        this.editorHasFocus = true;
        this.state = value;
        this.imeOptions = imeOptions;
        this.onEditCommand = onEditCommand;
        this.onImeActionPerformed = onImeActionPerformed;
        this.textInputCommandChannel.mo6233trySendJP2dKIU(TextInputCommand.StartInput);
    }

    @Override // androidx.compose.p000ui.text.input.PlatformTextInputService
    public void stopInput() {
        this.editorHasFocus = false;
        this.onEditCommand = new Function1<List<? extends EditCommand>, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$stopInput$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends EditCommand> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends EditCommand> it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }
        };
        this.onImeActionPerformed = new Function1<ImeAction, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$stopInput$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ImeAction imeAction) {
                m4144invokeKlQnJC8(imeAction.getValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-KlQnJC8, reason: not valid java name */
            public final void m4144invokeKlQnJC8(int it) {
            }
        };
        this.focusedRect = null;
        this.textInputCommandChannel.mo6233trySendJP2dKIU(TextInputCommand.StopInput);
    }

    @Override // androidx.compose.p000ui.text.input.PlatformTextInputService
    public void showSoftwareKeyboard() {
        this.textInputCommandChannel.mo6233trySendJP2dKIU(TextInputCommand.ShowKeyboard);
    }

    @Override // androidx.compose.p000ui.text.input.PlatformTextInputService
    public void hideSoftwareKeyboard() {
        this.textInputCommandChannel.mo6233trySendJP2dKIU(TextInputCommand.HideKeyboard);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0059 -> B:12:0x005f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object textInputCommandEventLoop(Continuation<? super Unit> continuation) {
        TextInputServiceAndroid$textInputCommandEventLoop$1 textInputServiceAndroid$textInputCommandEventLoop$1;
        TextInputServiceAndroid$textInputCommandEventLoop$1 textInputServiceAndroid$textInputCommandEventLoop$12;
        Object $result;
        TextInputServiceAndroid textInputServiceAndroid;
        ChannelIterator<TextInputCommand> channelIterator;
        Object obj;
        Object command;
        if (continuation instanceof TextInputServiceAndroid$textInputCommandEventLoop$1) {
            textInputServiceAndroid$textInputCommandEventLoop$1 = (TextInputServiceAndroid$textInputCommandEventLoop$1) continuation;
            if ((textInputServiceAndroid$textInputCommandEventLoop$1.label & Integer.MIN_VALUE) != 0) {
                textInputServiceAndroid$textInputCommandEventLoop$1.label -= Integer.MIN_VALUE;
                textInputServiceAndroid$textInputCommandEventLoop$12 = textInputServiceAndroid$textInputCommandEventLoop$1;
                Object $result2 = textInputServiceAndroid$textInputCommandEventLoop$12.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (textInputServiceAndroid$textInputCommandEventLoop$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        TextInputServiceAndroid textInputServiceAndroid2 = this;
                        ChannelIterator<TextInputCommand> it = this.textInputCommandChannel.iterator();
                        textInputServiceAndroid$textInputCommandEventLoop$12.L$0 = textInputServiceAndroid2;
                        textInputServiceAndroid$textInputCommandEventLoop$12.L$1 = it;
                        textInputServiceAndroid$textInputCommandEventLoop$12.label = 1;
                        Object hasNext = it.hasNext(textInputServiceAndroid$textInputCommandEventLoop$12);
                        if (hasNext != $result3) {
                            return $result3;
                        }
                        Object obj2 = $result3;
                        $result = $result2;
                        $result2 = hasNext;
                        textInputServiceAndroid = textInputServiceAndroid2;
                        channelIterator = it;
                        obj = obj2;
                        if (!((Boolean) $result2).booleanValue()) {
                            TextInputCommand initialCommand = channelIterator.next();
                            if (!textInputServiceAndroid.view.isFocused()) {
                                do {
                                    command = textInputServiceAndroid.textInputCommandChannel.mo6238tryReceivePtdJZtk();
                                } while (ChannelResult.m6253isSuccessimpl(command));
                            } else {
                                Ref.ObjectRef startInput = new Ref.ObjectRef();
                                Ref.ObjectRef showKeyboard = new Ref.ObjectRef();
                                for (TextInputCommand command2 = initialCommand; command2 != null; command2 = (TextInputCommand) ChannelResult.m6248getOrNullimpl(textInputServiceAndroid.textInputCommandChannel.mo6238tryReceivePtdJZtk())) {
                                    textInputCommandEventLoop$applyToState(command2, startInput, showKeyboard);
                                }
                                if (Intrinsics.areEqual(startInput.element, Boxing.boxBoolean(true))) {
                                    textInputServiceAndroid.restartInputImmediately();
                                }
                                Boolean bool = (Boolean) showKeyboard.element;
                                if (bool != null) {
                                    boolean p0 = bool.booleanValue();
                                    boolean p02 = p0;
                                    textInputServiceAndroid.setKeyboardVisibleImmediately(p02);
                                }
                                if (Intrinsics.areEqual(startInput.element, Boxing.boxBoolean(false))) {
                                    textInputServiceAndroid.restartInputImmediately();
                                }
                            }
                            $result2 = $result;
                            $result3 = obj;
                            it = channelIterator;
                            textInputServiceAndroid2 = textInputServiceAndroid;
                            textInputServiceAndroid$textInputCommandEventLoop$12.L$0 = textInputServiceAndroid2;
                            textInputServiceAndroid$textInputCommandEventLoop$12.L$1 = it;
                            textInputServiceAndroid$textInputCommandEventLoop$12.label = 1;
                            Object hasNext2 = it.hasNext(textInputServiceAndroid$textInputCommandEventLoop$12);
                            if (hasNext2 != $result3) {
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                    case 1:
                        ChannelIterator<TextInputCommand> channelIterator2 = (ChannelIterator) textInputServiceAndroid$textInputCommandEventLoop$12.L$1;
                        TextInputServiceAndroid textInputServiceAndroid3 = (TextInputServiceAndroid) textInputServiceAndroid$textInputCommandEventLoop$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        textInputServiceAndroid = textInputServiceAndroid3;
                        channelIterator = channelIterator2;
                        obj = $result3;
                        $result = $result2;
                        if (!((Boolean) $result2).booleanValue()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        textInputServiceAndroid$textInputCommandEventLoop$1 = new TextInputServiceAndroid$textInputCommandEventLoop$1(this, continuation);
        textInputServiceAndroid$textInputCommandEventLoop$12 = textInputServiceAndroid$textInputCommandEventLoop$1;
        Object $result22 = textInputServiceAndroid$textInputCommandEventLoop$12.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (textInputServiceAndroid$textInputCommandEventLoop$12.label) {
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, java.lang.Boolean, java.lang.Object] */
    private static final void textInputCommandEventLoop$applyToState(TextInputCommand $this$textInputCommandEventLoop_u24applyToState, Ref.ObjectRef<Boolean> objectRef, Ref.ObjectRef<Boolean> objectRef2) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$textInputCommandEventLoop_u24applyToState.ordinal()]) {
            case 1:
                objectRef.element = true;
                objectRef2.element = true;
                break;
            case 2:
                objectRef.element = false;
                objectRef2.element = false;
                break;
            case 3:
            case 4:
                if (!Intrinsics.areEqual((Object) objectRef.element, (Object) false)) {
                    objectRef2.element = Boolean.valueOf($this$textInputCommandEventLoop_u24applyToState == TextInputCommand.ShowKeyboard);
                    break;
                }
                break;
        }
    }

    @Override // androidx.compose.p000ui.text.input.PlatformTextInputService
    public void updateState(TextFieldValue oldValue, TextFieldValue newValue) {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        boolean restartInput = false;
        boolean needUpdateSelection = (TextRange.m3950equalsimpl0(this.state.getSelection(), newValue.getSelection()) && Intrinsics.areEqual(this.state.getComposition(), newValue.getComposition())) ? false : true;
        this.state = newValue;
        int size = this.ics.size();
        for (int i = 0; i < size; i++) {
            RecordingInputConnection recordingInputConnection = this.ics.get(i).get();
            if (recordingInputConnection != null) {
                recordingInputConnection.setMTextFieldValue$ui_release(newValue);
            }
        }
        if (Intrinsics.areEqual(oldValue, newValue)) {
            if (needUpdateSelection) {
                InputMethodManager inputMethodManager = this.inputMethodManager;
                View view = this.view;
                int m3955getMinimpl = TextRange.m3955getMinimpl(newValue.getSelection());
                int m3954getMaximpl = TextRange.m3954getMaximpl(newValue.getSelection());
                TextRange composition = this.state.getComposition();
                int m3955getMinimpl2 = composition != null ? TextRange.m3955getMinimpl(composition.getPackedValue()) : -1;
                TextRange composition2 = this.state.getComposition();
                inputMethodManager.updateSelection(view, m3955getMinimpl, m3954getMaximpl, m3955getMinimpl2, composition2 != null ? TextRange.m3954getMaximpl(composition2.getPackedValue()) : -1);
                return;
            }
            return;
        }
        if (oldValue != null && (!Intrinsics.areEqual(oldValue.getText(), newValue.getText()) || (TextRange.m3950equalsimpl0(oldValue.getSelection(), newValue.getSelection()) && !Intrinsics.areEqual(oldValue.getComposition(), newValue.getComposition())))) {
            restartInput = true;
        }
        if (restartInput) {
            restartInputImmediately();
            return;
        }
        int size2 = this.ics.size();
        for (int i2 = 0; i2 < size2; i2++) {
            RecordingInputConnection recordingInputConnection2 = this.ics.get(i2).get();
            if (recordingInputConnection2 != null) {
                recordingInputConnection2.updateInputState(this.state, this.inputMethodManager, this.view);
            }
        }
    }

    @Override // androidx.compose.p000ui.text.input.PlatformTextInputService
    @Deprecated(message = "This method should not be called, used BringIntoViewRequester instead.")
    public void notifyFocusedRect(androidx.compose.p000ui.geometry.Rect rect) {
        Rect it;
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.focusedRect = new Rect(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()), MathKt.roundToInt(rect.getRight()), MathKt.roundToInt(rect.getBottom()));
        if (this.ics.isEmpty() && (it = this.focusedRect) != null) {
            this.view.requestRectangleOnScreen(new Rect(it));
        }
    }

    private final void restartInputImmediately() {
        this.inputMethodManager.restartInput(this.view);
    }

    private final void setKeyboardVisibleImmediately(boolean visible) {
        if (visible) {
            this.inputMethodManager.showSoftInput(this.view);
        } else {
            this.inputMethodManager.hideSoftInputFromWindow(this.view.getWindowToken());
        }
    }
}
