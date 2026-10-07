package androidx.health.connect.client.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HealthConnectClientUpsideDownImpl.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl", m297f = "HealthConnectClientUpsideDownImpl.kt", m298i = {}, m299l = {386}, m300m = "wrapPlatformException", m301n = {}, m302s = {})
/* loaded from: classes14.dex */
final class HealthConnectClientUpsideDownImpl$wrapPlatformException$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HealthConnectClientUpsideDownImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HealthConnectClientUpsideDownImpl$wrapPlatformException$1(HealthConnectClientUpsideDownImpl healthConnectClientUpsideDownImpl, Continuation<? super HealthConnectClientUpsideDownImpl$wrapPlatformException$1> continuation) {
        super(continuation);
        this.this$0 = healthConnectClientUpsideDownImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object wrapPlatformException;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        wrapPlatformException = this.this$0.wrapPlatformException(null, this);
        return wrapPlatformException;
    }
}
