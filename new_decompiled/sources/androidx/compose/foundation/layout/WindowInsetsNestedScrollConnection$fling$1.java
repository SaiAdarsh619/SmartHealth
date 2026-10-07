package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WindowInsetsConnection.android.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection", m297f = "WindowInsetsConnection.android.kt", m298i = {0, 0, 0, 1, 1, 1, 2, 2}, m299l = {304, 330, 355}, m300m = "fling-huYlsQE", m301n = {"this", "available", "flingAmount", "this", "endVelocity", "available", "this", "available"}, m302s = {"L$0", "J$0", "F$0", "L$0", "L$1", "J$0", "L$0", "J$0"})
/* loaded from: classes.dex */
final class WindowInsetsNestedScrollConnection$fling$1 extends ContinuationImpl {
    float F$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WindowInsetsNestedScrollConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowInsetsNestedScrollConnection$fling$1(WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, Continuation<? super WindowInsetsNestedScrollConnection$fling$1> continuation) {
        super(continuation);
        this.this$0 = windowInsetsNestedScrollConnection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m819flinghuYlsQE;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m819flinghuYlsQE = this.this$0.m819flinghuYlsQE(0L, 0.0f, false, this);
        return m819flinghuYlsQE;
    }
}
