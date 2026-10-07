package androidx.compose.p000ui.window;

import androidx.compose.p000ui.platform.InfiniteAnimationPolicyKt;
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
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: AndroidPopup.android.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5", m297f = "AndroidPopup.android.kt", m298i = {0}, m299l = {299}, m300m = "invokeSuspend", m301n = {"$this$LaunchedEffect"}, m302s = {"L$0"})
/* loaded from: classes.dex */
final class AndroidPopup_androidKt$Popup$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PopupLayout $popupLayout;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidPopup_androidKt$Popup$5(PopupLayout popupLayout, Continuation<? super AndroidPopup_androidKt$Popup$5> continuation) {
        super(2, continuation);
        this.$popupLayout = popupLayout;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidPopup_androidKt$Popup$5 androidPopup_androidKt$Popup$5 = new AndroidPopup_androidKt$Popup$5(this.$popupLayout, continuation);
        androidPopup_androidKt$Popup$5.L$0 = obj;
        return androidPopup_androidKt$Popup$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidPopup_androidKt$Popup$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0039 -> B:7:0x003c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        AndroidPopup_androidKt$Popup$5 androidPopup_androidKt$Popup$5;
        CoroutineScope $this$LaunchedEffect;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                androidPopup_androidKt$Popup$5 = this;
                $this$LaunchedEffect = (CoroutineScope) androidPopup_androidKt$Popup$5.L$0;
                if (CoroutineScopeKt.isActive($this$LaunchedEffect)) {
                    androidPopup_androidKt$Popup$5.L$0 = $this$LaunchedEffect;
                    androidPopup_androidKt$Popup$5.label = 1;
                    if (InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(new Function1<Long, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                            invoke(l.longValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(long it) {
                        }
                    }, androidPopup_androidKt$Popup$5) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    androidPopup_androidKt$Popup$5.$popupLayout.pollForLocationOnScreenChange();
                    if (CoroutineScopeKt.isActive($this$LaunchedEffect)) {
                        return Unit.INSTANCE;
                    }
                }
            case 1:
                androidPopup_androidKt$Popup$5 = this;
                $this$LaunchedEffect = (CoroutineScope) androidPopup_androidKt$Popup$5.L$0;
                ResultKt.throwOnFailure($result);
                androidPopup_androidKt$Popup$5.$popupLayout.pollForLocationOnScreenChange();
                if (CoroutineScopeKt.isActive($this$LaunchedEffect)) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
