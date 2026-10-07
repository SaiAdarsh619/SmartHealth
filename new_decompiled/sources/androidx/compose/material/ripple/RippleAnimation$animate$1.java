package androidx.compose.material.ripple;

import androidx.health.connect.client.records.ExerciseSessionRecord;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: RippleAnimation.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.material.ripple.RippleAnimation", m297f = "RippleAnimation.kt", m298i = {0, 1}, m299l = {ExerciseSessionRecord.EXERCISE_TYPE_WATER_POLO, ExerciseSessionRecord.EXERCISE_TYPE_WHEELCHAIR, ExerciseSessionRecord.EXERCISE_TYPE_YOGA}, m300m = "animate", m301n = {"this", "this"}, m302s = {"L$0", "L$0"})
/* loaded from: classes.dex */
final class RippleAnimation$animate$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RippleAnimation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RippleAnimation$animate$1(RippleAnimation rippleAnimation, Continuation<? super RippleAnimation$animate$1> continuation) {
        super(continuation);
        this.this$0 = rippleAnimation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.animate(this);
    }
}
