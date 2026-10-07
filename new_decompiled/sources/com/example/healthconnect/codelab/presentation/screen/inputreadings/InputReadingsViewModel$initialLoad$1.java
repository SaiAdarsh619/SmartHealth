package com.example.healthconnect.codelab.presentation.screen.inputreadings;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InputReadingsViewModel.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel$initialLoad$1", m297f = "InputReadingsViewModel.kt", m298i = {}, m299l = {106}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes12.dex */
final class InputReadingsViewModel$initialLoad$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InputReadingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InputReadingsViewModel$initialLoad$1(InputReadingsViewModel inputReadingsViewModel, Continuation<? super InputReadingsViewModel$initialLoad$1> continuation) {
        super(2, continuation);
        this.this$0 = inputReadingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InputReadingsViewModel$initialLoad$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InputReadingsViewModel$initialLoad$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: InputReadingsViewModel.kt */
    @Metadata(m286d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m287d2 = {"<anonymous>", ""}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
    @DebugMetadata(m296c = "com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel$initialLoad$1$1", m297f = "InputReadingsViewModel.kt", m298i = {}, m299l = {}, m300m = "invokeSuspend", m301n = {}, m302s = {})
    /* renamed from: com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel$initialLoad$1$1 */
    static final class C09921 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InputReadingsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09921(InputReadingsViewModel inputReadingsViewModel, Continuation<? super C09921> continuation) {
            super(1, continuation);
            this.this$0 = inputReadingsViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C09921(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C09921) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    this.this$0.loadVitals();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object tryWithPermissionsCheck;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                tryWithPermissionsCheck = this.this$0.tryWithPermissionsCheck(new C09921(this.this$0, null), this);
                if (tryWithPermissionsCheck != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
