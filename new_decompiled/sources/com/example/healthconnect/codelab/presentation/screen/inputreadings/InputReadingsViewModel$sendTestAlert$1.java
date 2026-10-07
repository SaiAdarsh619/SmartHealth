package com.example.healthconnect.codelab.presentation.screen.inputreadings;

import com.example.healthconnect.codelab.data.EmergencyContactsManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InputReadingsViewModel.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel$sendTestAlert$1", m297f = "InputReadingsViewModel.kt", m298i = {}, m299l = {}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes12.dex */
final class InputReadingsViewModel$sendTestAlert$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InputReadingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InputReadingsViewModel$sendTestAlert$1(InputReadingsViewModel inputReadingsViewModel, Continuation<? super InputReadingsViewModel$sendTestAlert$1> continuation) {
        super(2, continuation);
        this.this$0 = inputReadingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InputReadingsViewModel$sendTestAlert$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InputReadingsViewModel$sendTestAlert$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        EmergencyContactsManager emergencyContactsManager;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                emergencyContactsManager = this.this$0.contactsManager;
                List contacts = emergencyContactsManager.getContacts();
                if (contacts.isEmpty()) {
                    return Unit.INSTANCE;
                }
                this.this$0.sendSmsToContacts("TEST ALERT: This is a test from Health Connect App.", true);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
