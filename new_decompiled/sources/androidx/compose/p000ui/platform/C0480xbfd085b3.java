package androidx.compose.p000ui.platform;

import android.view.View;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.Recomposer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WindowRecomposer.android.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.ui.platform.WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1", m297f = "WindowRecomposer.android.kt", m298i = {}, m299l = {233}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* renamed from: androidx.compose.ui.platform.WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1 */
/* loaded from: classes.dex */
final class C0480xbfd085b3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Recomposer $newRecomposer;
    final /* synthetic */ View $rootView;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0480xbfd085b3(Recomposer recomposer, View view, Continuation<? super C0480xbfd085b3> continuation) {
        super(2, continuation);
        this.$newRecomposer = recomposer;
        this.$rootView = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0480xbfd085b3(this.$newRecomposer, this.$rootView, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C0480xbfd085b3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Throwable th;
        C0480xbfd085b3 c0480xbfd085b3;
        CompositionContext viewTagRecomposer;
        CompositionContext viewTagRecomposer2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    this.label = 1;
                    if (this.$newRecomposer.join(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c0480xbfd085b3 = this;
                    viewTagRecomposer2 = WindowRecomposer_androidKt.getCompositionContext(c0480xbfd085b3.$rootView);
                    if (viewTagRecomposer2 == c0480xbfd085b3.$newRecomposer) {
                        WindowRecomposer_androidKt.setCompositionContext(c0480xbfd085b3.$rootView, null);
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    c0480xbfd085b3 = this;
                    viewTagRecomposer = WindowRecomposer_androidKt.getCompositionContext(c0480xbfd085b3.$rootView);
                    if (viewTagRecomposer == c0480xbfd085b3.$newRecomposer) {
                        WindowRecomposer_androidKt.setCompositionContext(c0480xbfd085b3.$rootView, null);
                    }
                    throw th;
                }
            case 1:
                c0480xbfd085b3 = this;
                try {
                    ResultKt.throwOnFailure($result);
                    viewTagRecomposer2 = WindowRecomposer_androidKt.getCompositionContext(c0480xbfd085b3.$rootView);
                    if (viewTagRecomposer2 == c0480xbfd085b3.$newRecomposer) {
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    viewTagRecomposer = WindowRecomposer_androidKt.getCompositionContext(c0480xbfd085b3.$rootView);
                    if (viewTagRecomposer == c0480xbfd085b3.$newRecomposer) {
                    }
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
