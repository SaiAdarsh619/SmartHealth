package androidx.health.connect.client.impl;

import androidx.health.connect.client.records.Record;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HealthConnectClientImpl.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "androidx.health.connect.client.impl.HealthConnectClientImpl", m297f = "HealthConnectClientImpl.kt", m298i = {}, m299l = {225}, m300m = "readRecords", m301n = {}, m302s = {})
/* loaded from: classes14.dex */
final class HealthConnectClientImpl$readRecords$1<T extends Record> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HealthConnectClientImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HealthConnectClientImpl$readRecords$1(HealthConnectClientImpl healthConnectClientImpl, Continuation<? super HealthConnectClientImpl$readRecords$1> continuation) {
        super(continuation);
        this.this$0 = healthConnectClientImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.readRecords(null, this);
    }
}
