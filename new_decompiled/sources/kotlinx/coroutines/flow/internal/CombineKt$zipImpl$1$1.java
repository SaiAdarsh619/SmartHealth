package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: Combine.kt */
@Metadata(m286d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H\u008a@"}, m287d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", m297f = "Combine.kt", m298i = {0}, m299l = {126}, m300m = "invokeSuspend", m301n = {"second"}, m302s = {"L$0"})
/* loaded from: classes15.dex */
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T1> $flow;
    final /* synthetic */ Flow<T2> $flow2;
    final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CombineKt$zipImpl$1$1(FlowCollector<? super R> flowCollector, Flow<? extends T2> flow, Flow<? extends T1> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super CombineKt$zipImpl$1$1> continuation) {
        super(2, continuation);
        this.$this_unsafeFlow = flowCollector;
        this.$flow2 = flow;
        this.$flow = flow2;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.$this_unsafeFlow, this.$flow2, this.$flow, this.$transform, continuation);
        combineKt$zipImpl$1$1.L$0 = obj;
        return combineKt$zipImpl$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$zipImpl$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        ReceiveChannel second;
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1;
        final CompletableJob collectJob;
        CoroutineContext scopeContext;
        Object cnt;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    combineKt$zipImpl$1$1 = this;
                    CoroutineScope $this$coroutineScope = (CoroutineScope) combineKt$zipImpl$1$1.L$0;
                    ReceiveChannel second2 = ProduceKt.produce$default($this$coroutineScope, null, 0, new CombineKt$zipImpl$1$1$second$1(combineKt$zipImpl$1$1.$flow2, null), 3, null);
                    collectJob = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
                    Intrinsics.checkNotNull(second2, "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
                    final FlowCollector<R> flowCollector = combineKt$zipImpl$1$1.$this_unsafeFlow;
                    ((SendChannel) second2).invokeOnClose(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable it) {
                            if (CompletableJob.this.isActive()) {
                                CompletableJob.this.cancel((CancellationException) new AbortFlowException(flowCollector));
                            }
                        }
                    });
                    try {
                        scopeContext = $this$coroutineScope.getCoroutineContext();
                        cnt = ThreadContextKt.threadContextElements(scopeContext);
                        combineKt$zipImpl$1$1.L$0 = second2;
                        combineKt$zipImpl$1$1.label = 1;
                    } catch (AbortFlowException e) {
                        e = e;
                        second = second2;
                        FlowExceptions_commonKt.checkOwnership(e, combineKt$zipImpl$1$1.$this_unsafeFlow);
                        ReceiveChannel.DefaultImpls.cancel$default(second, (CancellationException) null, 1, (Object) null);
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        second = second2;
                        ReceiveChannel.DefaultImpls.cancel$default(second, (CancellationException) null, 1, (Object) null);
                        throw th;
                    }
                    if (ChannelFlowKt.withContextUndispatched$default($this$coroutineScope.getCoroutineContext().plus(collectJob), Unit.INSTANCE, null, new C16522(combineKt$zipImpl$1$1.$flow, scopeContext, cnt, second2, combineKt$zipImpl$1$1.$this_unsafeFlow, combineKt$zipImpl$1$1.$transform, null), combineKt$zipImpl$1$1, 4, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    second = second2;
                    ReceiveChannel.DefaultImpls.cancel$default(second, (CancellationException) null, 1, (Object) null);
                    return Unit.INSTANCE;
                case 1:
                    combineKt$zipImpl$1$1 = this;
                    second = (ReceiveChannel) combineKt$zipImpl$1$1.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                    } catch (AbortFlowException e2) {
                        e = e2;
                        FlowExceptions_commonKt.checkOwnership(e, combineKt$zipImpl$1$1.$this_unsafeFlow);
                        ReceiveChannel.DefaultImpls.cancel$default(second, (CancellationException) null, 1, (Object) null);
                        return Unit.INSTANCE;
                    }
                    ReceiveChannel.DefaultImpls.cancel$default(second, (CancellationException) null, 1, (Object) null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* compiled from: Combine.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u008a@"}, m287d2 = {"<anonymous>", "", "T1", "T2", "R", "it"}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
    @DebugMetadata(m296c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", m297f = "Combine.kt", m298i = {}, m299l = {WorkQueueKt.MASK}, m300m = "invokeSuspend", m301n = {}, m302s = {})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2 */
    static final class C16522 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $cnt;
        final /* synthetic */ Flow<T1> $flow;
        final /* synthetic */ CoroutineContext $scopeContext;
        final /* synthetic */ ReceiveChannel<Object> $second;
        final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
        final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C16522(Flow<? extends T1> flow, CoroutineContext coroutineContext, Object obj, ReceiveChannel<? extends Object> receiveChannel, FlowCollector<? super R> flowCollector, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super C16522> continuation) {
            super(2, continuation);
            this.$flow = flow;
            this.$scopeContext = coroutineContext;
            this.$cnt = obj;
            this.$second = receiveChannel;
            this.$this_unsafeFlow = flowCollector;
            this.$transform = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C16522(this.$flow, this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
            return ((C16522) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: Combine.kt */
        @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, m287d2 = {"<anonymous>", "", "T1", "T2", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1, reason: invalid class name */
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ Object $cnt;
            final /* synthetic */ CoroutineContext $scopeContext;
            final /* synthetic */ ReceiveChannel<Object> $second;
            final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
            final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(CoroutineContext coroutineContext, Object obj, ReceiveChannel<? extends Object> receiveChannel, FlowCollector<? super R> flowCollector, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
                this.$scopeContext = coroutineContext;
                this.$cnt = obj;
                this.$second = receiveChannel;
                this.$this_unsafeFlow = flowCollector;
                this.$transform = function3;
            }

            /* compiled from: Combine.kt */
            @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u008a@"}, m287d2 = {"<anonymous>", "", "T1", "T2", "R", "it"}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
            @DebugMetadata(m296c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", m297f = "Combine.kt", m298i = {}, m299l = {129, 132, 132}, m300m = "invokeSuspend", m301n = {}, m302s = {})
            /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1, reason: invalid class name and collision with other inner class name */
            static final class C16831 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
                final /* synthetic */ ReceiveChannel<Object> $second;
                final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
                final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
                final /* synthetic */ T1 $value;
                Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C16831(ReceiveChannel<? extends Object> receiveChannel, FlowCollector<? super R> flowCollector, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, T1 t1, Continuation<? super C16831> continuation) {
                    super(2, continuation);
                    this.$second = receiveChannel;
                    this.$this_unsafeFlow = flowCollector;
                    this.$transform = function3;
                    this.$value = t1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C16831(this.$second, this.$this_unsafeFlow, this.$transform, this.$value, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
                    return ((C16831) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0087 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0088  */
                /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
                /* JADX WARN: Type inference failed for: r4v4, types: [kotlinx.coroutines.flow.FlowCollector] */
                /* JADX WARN: Type inference failed for: r4v5 */
                /* JADX WARN: Type inference failed for: r4v6 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    C16831 c16831;
                    Object mo6237receiveCatchingJP2dKIU;
                    Object obj2;
                    C16831 c168312;
                    ?? r4;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            c16831 = this;
                            c16831.label = 1;
                            mo6237receiveCatchingJP2dKIU = c16831.$second.mo6237receiveCatchingJP2dKIU(c16831);
                            if (mo6237receiveCatchingJP2dKIU == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            FlowCollector flowCollector = c16831.$this_unsafeFlow;
                            if (!(mo6237receiveCatchingJP2dKIU instanceof ChannelResult.Failed)) {
                                Throwable m6247exceptionOrNullimpl = ChannelResult.m6247exceptionOrNullimpl(mo6237receiveCatchingJP2dKIU);
                                if (m6247exceptionOrNullimpl == null) {
                                    throw new AbortFlowException(flowCollector);
                                }
                                throw m6247exceptionOrNullimpl;
                            }
                            Object obj3 = c16831.$this_unsafeFlow;
                            Function3 function3 = c16831.$transform;
                            Object obj4 = c16831.$value;
                            if (mo6237receiveCatchingJP2dKIU == NullSurrogateKt.NULL) {
                                mo6237receiveCatchingJP2dKIU = null;
                            }
                            c16831.L$0 = obj3;
                            c16831.label = 2;
                            Object invoke = function3.invoke(obj4, mo6237receiveCatchingJP2dKIU, c16831);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            C16831 c168313 = c16831;
                            obj2 = obj;
                            obj = invoke;
                            c168312 = c168313;
                            r4 = obj3;
                            c168312.L$0 = null;
                            c168312.label = 3;
                            return r4.emit(obj, c168312) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                        case 1:
                            c16831 = this;
                            ResultKt.throwOnFailure(obj);
                            mo6237receiveCatchingJP2dKIU = ((ChannelResult) obj).getHolder();
                            FlowCollector flowCollector2 = c16831.$this_unsafeFlow;
                            if (!(mo6237receiveCatchingJP2dKIU instanceof ChannelResult.Failed)) {
                            }
                            break;
                        case 2:
                            FlowCollector flowCollector3 = (FlowCollector) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            r4 = flowCollector3;
                            c168312 = this;
                            obj2 = obj;
                            c168312.L$0 = null;
                            c168312.label = 3;
                            if (r4.emit(obj, c168312) != coroutine_suspended) {
                            }
                            break;
                        case 3:
                            ResultKt.throwOnFailure(obj);
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(T1 t1, Continuation<? super Unit> continuation) {
                CombineKt$zipImpl$1$1$2$1$emit$1 combineKt$zipImpl$1$1$2$1$emit$1;
                CombineKt$zipImpl$1$1$2$1$emit$1 combineKt$zipImpl$1$1$2$1$emit$12;
                if (continuation instanceof CombineKt$zipImpl$1$1$2$1$emit$1) {
                    combineKt$zipImpl$1$1$2$1$emit$1 = (CombineKt$zipImpl$1$1$2$1$emit$1) continuation;
                    if ((combineKt$zipImpl$1$1$2$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                        combineKt$zipImpl$1$1$2$1$emit$1.label -= Integer.MIN_VALUE;
                        combineKt$zipImpl$1$1$2$1$emit$12 = combineKt$zipImpl$1$1$2$1$emit$1;
                        Object $result = combineKt$zipImpl$1$1$2$1$emit$12.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (combineKt$zipImpl$1$1$2$1$emit$12.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                CoroutineContext coroutineContext = this.$scopeContext;
                                Unit unit = Unit.INSTANCE;
                                Object obj = this.$cnt;
                                C16831 c16831 = new C16831(this.$second, this.$this_unsafeFlow, this.$transform, t1, null);
                                combineKt$zipImpl$1$1$2$1$emit$12.label = 1;
                                if (ChannelFlowKt.withContextUndispatched(coroutineContext, unit, obj, c16831, combineKt$zipImpl$1$1$2$1$emit$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                break;
                            case 1:
                                ResultKt.throwOnFailure($result);
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return Unit.INSTANCE;
                    }
                }
                combineKt$zipImpl$1$1$2$1$emit$1 = new CombineKt$zipImpl$1$1$2$1$emit$1(this, continuation);
                combineKt$zipImpl$1$1$2$1$emit$12 = combineKt$zipImpl$1$1$2$1$emit$1;
                Object $result2 = combineKt$zipImpl$1$1$2$1$emit$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (combineKt$zipImpl$1$1$2$1$emit$12.label) {
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (this.$flow.collect(new AnonymousClass1(this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform), this) != coroutine_suspended) {
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
}
