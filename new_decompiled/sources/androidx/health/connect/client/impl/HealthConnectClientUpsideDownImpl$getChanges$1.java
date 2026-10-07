package androidx.health.connect.client.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HealthConnectClientUpsideDownImpl.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl", m297f = "HealthConnectClientUpsideDownImpl.kt", m298i = {0, 0}, m299l = {393}, m300m = "getChanges", m301n = {"this", "changesToken"}, m302s = {"L$0", "L$1"})
/* loaded from: classes14.dex */
final class HealthConnectClientUpsideDownImpl$getChanges$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HealthConnectClientUpsideDownImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HealthConnectClientUpsideDownImpl$getChanges$1(HealthConnectClientUpsideDownImpl healthConnectClientUpsideDownImpl, Continuation<? super HealthConnectClientUpsideDownImpl$getChanges$1> continuation) {
        super(continuation);
        this.this$0 = healthConnectClientUpsideDownImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getChanges(null, this);
    }
}
