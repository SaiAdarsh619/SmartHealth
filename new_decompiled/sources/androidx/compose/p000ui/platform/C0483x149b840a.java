package androidx.compose.p000ui.platform;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.lifecycle.LifecycleOwner;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: WindowRecomposer.android.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1", m297f = "WindowRecomposer.android.kt", m298i = {0}, m299l = {391}, m300m = "invokeSuspend", m301n = {"durationScaleJob"}, m302s = {"L$0"})
/* renamed from: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 */
/* loaded from: classes.dex */
final class C0483x149b840a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ Recomposer $recomposer;
    final /* synthetic */ C0482xff837ba9 $self;
    final /* synthetic */ Ref.ObjectRef<MotionDurationScaleImpl> $systemDurationScaleSettingConsumer;
    final /* synthetic */ View $this_createLifecycleAwareWindowRecomposer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0483x149b840a(Ref.ObjectRef<MotionDurationScaleImpl> objectRef, Recomposer recomposer, LifecycleOwner lifecycleOwner, C0482xff837ba9 c0482xff837ba9, View view, Continuation<? super C0483x149b840a> continuation) {
        super(2, continuation);
        this.$systemDurationScaleSettingConsumer = objectRef;
        this.$recomposer = recomposer;
        this.$lifecycleOwner = lifecycleOwner;
        this.$self = c0482xff837ba9;
        this.$this_createLifecycleAwareWindowRecomposer = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C0483x149b840a c0483x149b840a = new C0483x149b840a(this.$systemDurationScaleSettingConsumer, this.$recomposer, this.$lifecycleOwner, this.$self, this.$this_createLifecycleAwareWindowRecomposer, continuation);
        c0483x149b840a.L$0 = obj;
        return c0483x149b840a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C0483x149b840a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x008d  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Job job;
        Job job2;
        StateFlow animationScaleFlowFor;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        C0483x149b840a c0483x149b840a = this.label;
        try {
            switch (c0483x149b840a) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    c0483x149b840a = this;
                    CoroutineScope coroutineScope = (CoroutineScope) c0483x149b840a.L$0;
                    Job job3 = (Job) null;
                    try {
                        MotionDurationScaleImpl motionDurationScaleImpl = c0483x149b840a.$systemDurationScaleSettingConsumer.element;
                        if (motionDurationScaleImpl != null) {
                            Context applicationContext = c0483x149b840a.$this_createLifecycleAwareWindowRecomposer.getContext().getApplicationContext();
                            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                            animationScaleFlowFor = WindowRecomposer_androidKt.getAnimationScaleFlowFor(applicationContext);
                            motionDurationScaleImpl.setScaleFactor(((Number) animationScaleFlowFor.getValue()).floatValue());
                            job2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C0484x93d788e4(animationScaleFlowFor, motionDurationScaleImpl, null), 3, null);
                        } else {
                            job2 = null;
                        }
                        job = job2;
                        c0483x149b840a.L$0 = job;
                        c0483x149b840a.label = 1;
                        Object runRecomposeAndApplyChanges = c0483x149b840a.$recomposer.runRecomposeAndApplyChanges(c0483x149b840a);
                        c0483x149b840a = c0483x149b840a;
                        if (runRecomposeAndApplyChanges == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (job != null) {
                            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        }
                        c0483x149b840a.$lifecycleOwner.getLifecycle().removeObserver(c0483x149b840a.$self);
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        job = job3;
                        if (job != null) {
                            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        }
                        c0483x149b840a.$lifecycleOwner.getLifecycle().removeObserver(c0483x149b840a.$self);
                        throw th;
                    }
                case 1:
                    C0483x149b840a c0483x149b840a2 = this;
                    job = (Job) c0483x149b840a2.L$0;
                    ResultKt.throwOnFailure(obj);
                    c0483x149b840a = c0483x149b840a2;
                    if (job != null) {
                    }
                    c0483x149b840a.$lifecycleOwner.getLifecycle().removeObserver(c0483x149b840a.$self);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
