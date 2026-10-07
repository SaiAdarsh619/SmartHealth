package androidx.compose.p000ui.text.input;

import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: TextInputServiceAndroid.android.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.ui.text.input.TextInputServiceAndroid", m297f = "TextInputServiceAndroid.android.kt", m298i = {0}, m299l = {ComposerKt.providerMapsKey}, m300m = "textInputCommandEventLoop", m301n = {"this"}, m302s = {"L$0"})
/* loaded from: classes.dex */
final class TextInputServiceAndroid$textInputCommandEventLoop$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TextInputServiceAndroid this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextInputServiceAndroid$textInputCommandEventLoop$1(TextInputServiceAndroid textInputServiceAndroid, Continuation<? super TextInputServiceAndroid$textInputCommandEventLoop$1> continuation) {
        super(continuation);
        this.this$0 = textInputServiceAndroid;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.textInputCommandEventLoop(this);
    }
}
