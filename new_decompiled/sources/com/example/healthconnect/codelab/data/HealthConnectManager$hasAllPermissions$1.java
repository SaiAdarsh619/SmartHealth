package com.example.healthconnect.codelab.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HealthConnectManager.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "com.example.healthconnect.codelab.data.HealthConnectManager", m297f = "HealthConnectManager.kt", m298i = {0}, m299l = {130}, m300m = "hasAllPermissions", m301n = {"permissions"}, m302s = {"L$0"})
/* loaded from: classes8.dex */
final class HealthConnectManager$hasAllPermissions$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HealthConnectManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HealthConnectManager$hasAllPermissions$1(HealthConnectManager healthConnectManager, Continuation<? super HealthConnectManager$hasAllPermissions$1> continuation) {
        super(continuation);
        this.this$0 = healthConnectManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.hasAllPermissions(null, this);
    }
}
