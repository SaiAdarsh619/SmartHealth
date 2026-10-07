package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WhileSelect.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 176)
@DebugMetadata(m296c = "kotlinx.coroutines.selects.WhileSelectKt", m297f = "WhileSelect.kt", m298i = {0}, m299l = {41}, m300m = "whileSelect", m301n = {"builder"}, m302s = {"L$0"})
/* loaded from: classes15.dex */
final class WhileSelectKt$whileSelect$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    WhileSelectKt$whileSelect$1(Continuation<? super WhileSelectKt$whileSelect$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WhileSelectKt.whileSelect(null, this);
    }
}
