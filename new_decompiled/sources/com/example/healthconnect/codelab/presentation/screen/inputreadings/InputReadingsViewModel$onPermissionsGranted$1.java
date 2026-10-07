package com.example.healthconnect.codelab.presentation.screen.inputreadings;

import androidx.compose.runtime.MutableState;
import com.example.healthconnect.codelab.data.HealthConnectManager;
import com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel;
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
@DebugMetadata(m296c = "com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel$onPermissionsGranted$1", m297f = "InputReadingsViewModel.kt", m298i = {}, m299l = {95}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes12.dex */
final class InputReadingsViewModel$onPermissionsGranted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ InputReadingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InputReadingsViewModel$onPermissionsGranted$1(InputReadingsViewModel inputReadingsViewModel, Continuation<? super InputReadingsViewModel$onPermissionsGranted$1> continuation) {
        super(2, continuation);
        this.this$0 = inputReadingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InputReadingsViewModel$onPermissionsGranted$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InputReadingsViewModel$onPermissionsGranted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        InputReadingsViewModel$onPermissionsGranted$1 inputReadingsViewModel$onPermissionsGranted$1;
        MutableState permissionsGranted;
        HealthConnectManager healthConnectManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                inputReadingsViewModel$onPermissionsGranted$1 = this;
                permissionsGranted = inputReadingsViewModel$onPermissionsGranted$1.this$0.getPermissionsGranted();
                healthConnectManager = inputReadingsViewModel$onPermissionsGranted$1.this$0.healthConnectManager;
                inputReadingsViewModel$onPermissionsGranted$1.L$0 = permissionsGranted;
                inputReadingsViewModel$onPermissionsGranted$1.label = 1;
                Object hasAllPermissions = healthConnectManager.hasAllPermissions(inputReadingsViewModel$onPermissionsGranted$1.this$0.getPermissions(), inputReadingsViewModel$onPermissionsGranted$1);
                if (hasAllPermissions != coroutine_suspended) {
                    $result = hasAllPermissions;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                MutableState mutableState = (MutableState) this.L$0;
                ResultKt.throwOnFailure($result);
                permissionsGranted = mutableState;
                inputReadingsViewModel$onPermissionsGranted$1 = this;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        permissionsGranted.setValue($result);
        if (inputReadingsViewModel$onPermissionsGranted$1.this$0.getPermissionsGranted().getValue().booleanValue()) {
            inputReadingsViewModel$onPermissionsGranted$1.this$0.setUiState(InputReadingsViewModel.UiState.Done.INSTANCE);
            inputReadingsViewModel$onPermissionsGranted$1.this$0.loadVitals();
        }
        return Unit.INSTANCE;
    }
}
