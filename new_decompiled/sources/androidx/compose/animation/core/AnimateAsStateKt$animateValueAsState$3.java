package androidx.compose.animation.core;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelResult;

/* compiled from: AnimateAsState.kt */
@Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3", m297f = "AnimateAsState.kt", m298i = {0}, m299l = {417}, m300m = "invokeSuspend", m301n = {"$this$LaunchedEffect"}, m302s = {"L$0"})
/* loaded from: classes.dex */
final class AnimateAsStateKt$animateValueAsState$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<AnimationSpec<T>> $animSpec$delegate;
    final /* synthetic */ Animatable<T, V> $animatable;
    final /* synthetic */ Channel<T> $channel;
    final /* synthetic */ State<Function1<T, Unit>> $listener$delegate;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AnimateAsStateKt$animateValueAsState$3(Channel<T> channel, Animatable<T, V> animatable, State<? extends AnimationSpec<T>> state, State<? extends Function1<? super T, Unit>> state2, Continuation<? super AnimateAsStateKt$animateValueAsState$3> continuation) {
        super(2, continuation);
        this.$channel = channel;
        this.$animatable = animatable;
        this.$animSpec$delegate = state;
        this.$listener$delegate = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AnimateAsStateKt$animateValueAsState$3 animateAsStateKt$animateValueAsState$3 = new AnimateAsStateKt$animateValueAsState$3(this.$channel, this.$animatable, this.$animSpec$delegate, this.$listener$delegate, continuation);
        animateAsStateKt$animateValueAsState$3.L$0 = obj;
        return animateAsStateKt$animateValueAsState$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnimateAsStateKt$animateValueAsState$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: AnimateAsState.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1", m297f = "AnimateAsState.kt", m298i = {}, m299l = {426}, m300m = "invokeSuspend", m301n = {}, m302s = {})
    /* renamed from: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1 */
    static final class C00451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ State<AnimationSpec<T>> $animSpec$delegate;
        final /* synthetic */ Animatable<T, V> $animatable;
        final /* synthetic */ State<Function1<T, Unit>> $listener$delegate;
        final /* synthetic */ T $newTarget;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C00451(T t, Animatable<T, V> animatable, State<? extends AnimationSpec<T>> state, State<? extends Function1<? super T, Unit>> state2, Continuation<? super C00451> continuation) {
            super(2, continuation);
            this.$newTarget = t;
            this.$animatable = animatable;
            this.$animSpec$delegate = state;
            this.$listener$delegate = state2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00451(this.$newTarget, this.$animatable, this.$animSpec$delegate, this.$listener$delegate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C00451) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x004e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            AnimationSpec m430animateValueAsState$lambda5;
            Object animateTo;
            C00451 c00451;
            Function1 m429animateValueAsState$lambda3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (!Intrinsics.areEqual(this.$newTarget, this.$animatable.getTargetValue())) {
                        Animatable<T, V> animatable = this.$animatable;
                        T t = this.$newTarget;
                        m430animateValueAsState$lambda5 = AnimateAsStateKt.m430animateValueAsState$lambda5(this.$animSpec$delegate);
                        this.label = 1;
                        animateTo = animatable.animateTo(t, (r12 & 2) != 0 ? animatable.defaultSpringSpec : m430animateValueAsState$lambda5, (r12 & 4) != 0 ? animatable.getVelocity() : null, (r12 & 8) != 0 ? null : null, this);
                        if (animateTo != coroutine_suspended) {
                            c00451 = this;
                            m429animateValueAsState$lambda3 = AnimateAsStateKt.m429animateValueAsState$lambda3(c00451.$listener$delegate);
                            if (m429animateValueAsState$lambda3 != null) {
                                m429animateValueAsState$lambda3.invoke(c00451.$animatable.getValue());
                            }
                        } else {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    c00451 = this;
                    ResultKt.throwOnFailure($result);
                    m429animateValueAsState$lambda3 = AnimateAsStateKt.m429animateValueAsState$lambda3(c00451.$listener$delegate);
                    if (m429animateValueAsState$lambda3 != null) {
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004e -> B:7:0x0052). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AnimateAsStateKt$animateValueAsState$3 animateAsStateKt$animateValueAsState$3;
        CoroutineScope $this$LaunchedEffect;
        ChannelIterator channelIterator;
        Object $result;
        Object $result2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                animateAsStateKt$animateValueAsState$3 = this;
                Object $result3 = obj;
                CoroutineScope $this$LaunchedEffect2 = (CoroutineScope) animateAsStateKt$animateValueAsState$3.L$0;
                CoroutineScope $this$LaunchedEffect3 = $this$LaunchedEffect2;
                ChannelIterator it = animateAsStateKt$animateValueAsState$3.$channel.iterator();
                animateAsStateKt$animateValueAsState$3.L$0 = $this$LaunchedEffect3;
                animateAsStateKt$animateValueAsState$3.L$1 = it;
                animateAsStateKt$animateValueAsState$3.label = 1;
                Object hasNext = it.hasNext(animateAsStateKt$animateValueAsState$3);
                if (hasNext == coroutine_suspended) {
                    $this$LaunchedEffect = $this$LaunchedEffect3;
                    channelIterator = it;
                    $result = $result3;
                    $result2 = hasNext;
                    if (!((Boolean) $result2).booleanValue()) {
                        Object target = channelIterator.next();
                        Object m6248getOrNullimpl = ChannelResult.m6248getOrNullimpl(animateAsStateKt$animateValueAsState$3.$channel.mo6238tryReceivePtdJZtk());
                        Object newTarget = m6248getOrNullimpl == null ? target : m6248getOrNullimpl;
                        BuildersKt__Builders_commonKt.launch$default($this$LaunchedEffect, null, null, new C00451(newTarget, animateAsStateKt$animateValueAsState$3.$animatable, animateAsStateKt$animateValueAsState$3.$animSpec$delegate, animateAsStateKt$animateValueAsState$3.$listener$delegate, null), 3, null);
                        $result3 = $result;
                        it = channelIterator;
                        $this$LaunchedEffect3 = $this$LaunchedEffect;
                        animateAsStateKt$animateValueAsState$3.L$0 = $this$LaunchedEffect3;
                        animateAsStateKt$animateValueAsState$3.L$1 = it;
                        animateAsStateKt$animateValueAsState$3.label = 1;
                        Object hasNext2 = it.hasNext(animateAsStateKt$animateValueAsState$3);
                        if (hasNext2 == coroutine_suspended) {
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                } else {
                    return coroutine_suspended;
                }
            case 1:
                animateAsStateKt$animateValueAsState$3 = this;
                $result2 = obj;
                ChannelIterator channelIterator2 = (ChannelIterator) animateAsStateKt$animateValueAsState$3.L$1;
                CoroutineScope $this$LaunchedEffect4 = (CoroutineScope) animateAsStateKt$animateValueAsState$3.L$0;
                ResultKt.throwOnFailure($result2);
                $this$LaunchedEffect = $this$LaunchedEffect4;
                channelIterator = channelIterator2;
                $result = $result2;
                if (!((Boolean) $result2).booleanValue()) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
