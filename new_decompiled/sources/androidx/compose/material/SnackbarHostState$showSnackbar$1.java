package androidx.compose.material;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SnackbarHost.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.material.SnackbarHostState", m297f = "SnackbarHost.kt", m298i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, m299l = {379, 382}, m300m = "showSnackbar", m301n = {"this", "message", "actionLabel", "duration", "$this$withLock_u24default$iv", "this", "message", "actionLabel", "duration", "$this$withLock_u24default$iv", "$completion$iv"}, m302s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: classes.dex */
final class SnackbarHostState$showSnackbar$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SnackbarHostState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnackbarHostState$showSnackbar$1(SnackbarHostState snackbarHostState, Continuation<? super SnackbarHostState$showSnackbar$1> continuation) {
        super(continuation);
        this.this$0 = snackbarHostState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.showSnackbar(null, null, null, this);
    }
}
