package com.example.healthconnect.codelab.presentation.screen.inputreadings;

import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InputReadingsScreen.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsScreenKt$InputReadingsScreen$5", m297f = "InputReadingsScreen.kt", m298i = {}, m299l = {}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes12.dex */
final class InputReadingsScreenKt$InputReadingsScreen$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Unit> $onPermissionsResult;
    final /* synthetic */ ManagedActivityResultLauncher<String[], Map<String, Boolean>> $permissionsLauncher;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InputReadingsScreenKt$InputReadingsScreen$5(ManagedActivityResultLauncher<String[], Map<String, Boolean>> managedActivityResultLauncher, Function0<Unit> function0, Context context, Continuation<? super InputReadingsScreenKt$InputReadingsScreen$5> continuation) {
        super(2, continuation);
        this.$permissionsLauncher = managedActivityResultLauncher;
        this.$onPermissionsResult = function0;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InputReadingsScreenKt$InputReadingsScreen$5(this.$permissionsLauncher, this.$onPermissionsResult, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InputReadingsScreenKt$InputReadingsScreen$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Context context = this.$context;
                Collection destination$iv$iv = new ArrayList();
                for (String str : new String[]{"android.permission.SEND_SMS", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}) {
                    String it = ContextCompat.checkSelfPermission(context, str) != 0 ? 1 : null;
                    if (it != null) {
                        destination$iv$iv.add(str);
                    }
                }
                Collection missingPermissions = (List) destination$iv$iv;
                if (!missingPermissions.isEmpty()) {
                    Collection $this$toTypedArray$iv = missingPermissions;
                    this.$permissionsLauncher.launch($this$toTypedArray$iv.toArray(new String[0]));
                }
                this.$onPermissionsResult.invoke();
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
