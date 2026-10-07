package com.example.healthconnect.codelab.telemetry;

import android.util.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TelemetryManager.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "com.example.healthconnect.codelab.telemetry.TelemetryManager$send$1", m297f = "TelemetryManager.kt", m298i = {}, m299l = {}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes6.dex */
final class TelemetryManager$send$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TelemetrySnapshot $snapshot;
    int label;
    final /* synthetic */ TelemetryManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TelemetryManager$send$1(TelemetryManager telemetryManager, TelemetrySnapshot telemetrySnapshot, Continuation<? super TelemetryManager$send$1> continuation) {
        super(2, continuation);
        this.this$0 = telemetryManager;
        this.$snapshot = telemetrySnapshot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TelemetryManager$send$1(this.this$0, this.$snapshot, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TelemetryManager$send$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                StringBuilder append = new StringBuilder().append("IO Coroutine started for POST to ");
                str = this.this$0.endpointUrl;
                Log.d("Telemetry", append.append(str).toString());
                try {
                    this.this$0.postData(this.$snapshot.toJson());
                } catch (Exception e) {
                    Log.e("Telemetry", "Exception during send: " + e.getMessage(), e);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
