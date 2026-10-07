package com.example.healthconnect.codelab.presentation.screen.inputreadings;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InputReadingsViewModel.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel", m297f = "InputReadingsViewModel.kt", m298i = {0}, m299l = {283, 291}, m300m = "getLastLocation", m301n = {"this"}, m302s = {"L$0"})
/* loaded from: classes12.dex */
final class InputReadingsViewModel$getLastLocation$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InputReadingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InputReadingsViewModel$getLastLocation$1(InputReadingsViewModel inputReadingsViewModel, Continuation<? super InputReadingsViewModel$getLastLocation$1> continuation) {
        super(continuation);
        this.this$0 = inputReadingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object lastLocation;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        lastLocation = this.this$0.getLastLocation(this);
        return lastLocation;
    }
}
