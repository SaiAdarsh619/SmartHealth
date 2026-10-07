package androidx.compose.foundation;

import androidx.health.connect.client.records.ExerciseSessionRecord;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Hoverable.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.HoverableKt$hoverable$2", m297f = "Hoverable.kt", m298i = {0}, m299l = {ExerciseSessionRecord.EXERCISE_TYPE_STRENGTH_TRAINING}, m300m = "invoke$emitExit", m301n = {"hoverInteraction$delegate"}, m302s = {"L$0"})
/* loaded from: classes.dex */
final class HoverableKt$hoverable$2$invoke$emitExit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    HoverableKt$hoverable$2$invoke$emitExit$1(Continuation<? super HoverableKt$hoverable$2$invoke$emitExit$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HoverableKt$hoverable$2.invoke$emitExit(null, null, this);
    }
}
