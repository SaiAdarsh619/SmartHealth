package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ScrollExtensions.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.gestures.ScrollExtensionsKt", m297f = "ScrollExtensions.kt", m298i = {0}, m299l = {40}, m300m = "animateScrollBy", m301n = {"previousValue"}, m302s = {"L$0"})
/* loaded from: classes.dex */
final class ScrollExtensionsKt$animateScrollBy$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    ScrollExtensionsKt$animateScrollBy$1(Continuation<? super ScrollExtensionsKt$animateScrollBy$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ScrollExtensionsKt.animateScrollBy(null, 0.0f, null, this);
    }
}
