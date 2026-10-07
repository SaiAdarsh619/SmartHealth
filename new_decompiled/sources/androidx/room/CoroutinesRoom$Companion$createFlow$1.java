package androidx.room;

import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: CoroutinesRoom.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\r\u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u00040\u0003H\u008a@"}, m287d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/jvm/JvmSuppressWildcards;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", m297f = "CoroutinesRoom.kt", m298i = {}, m299l = {110}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes14.dex */
final class CoroutinesRoom$Companion$createFlow$1<R> extends SuspendLambda implements Function2<FlowCollector<R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Callable<R> $callable;
    final /* synthetic */ RoomDatabase $db;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ String[] $tableNames;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoroutinesRoom$Companion$createFlow$1(boolean z, RoomDatabase roomDatabase, String[] strArr, Callable<R> callable, Continuation<? super CoroutinesRoom$Companion$createFlow$1> continuation) {
        super(2, continuation);
        this.$inTransaction = z;
        this.$db = roomDatabase;
        this.$tableNames = strArr;
        this.$callable = callable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CoroutinesRoom$Companion$createFlow$1 coroutinesRoom$Companion$createFlow$1 = new CoroutinesRoom$Companion$createFlow$1(this.$inTransaction, this.$db, this.$tableNames, this.$callable, continuation);
        coroutinesRoom$Companion$createFlow$1.L$0 = obj;
        return coroutinesRoom$Companion$createFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<R> flowCollector, Continuation<? super Unit> continuation) {
        return ((CoroutinesRoom$Companion$createFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: CoroutinesRoom.kt */
    @Metadata(m286d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m287d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", m297f = "CoroutinesRoom.kt", m298i = {}, m299l = {136}, m300m = "invokeSuspend", m301n = {}, m302s = {})
    /* renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1 */
    static final class C08561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlowCollector<R> $$this$flow;
        final /* synthetic */ Callable<R> $callable;
        final /* synthetic */ RoomDatabase $db;
        final /* synthetic */ boolean $inTransaction;
        final /* synthetic */ String[] $tableNames;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08561(boolean z, RoomDatabase roomDatabase, FlowCollector<R> flowCollector, String[] strArr, Callable<R> callable, Continuation<? super C08561> continuation) {
            super(2, continuation);
            this.$inTransaction = z;
            this.$db = roomDatabase;
            this.$$this$flow = flowCollector;
            this.$tableNames = strArr;
            this.$callable = callable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08561 c08561 = new C08561(this.$inTransaction, this.$db, this.$$this$flow, this.$tableNames, this.$callable, continuation);
            c08561.L$0 = obj;
            return c08561;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r13v0, types: [androidx.room.CoroutinesRoom$Companion$createFlow$1$1$observer$1] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            CoroutineDispatcher transactionDispatcher;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    final Channel observerChannel = ChannelKt.Channel$default(-1, null, null, 6, null);
                    final String[] strArr = this.$tableNames;
                    ?? r13 = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$observer$1
                        @Override // androidx.room.InvalidationTracker.Observer
                        public void onInvalidated(Set<String> tables) {
                            Intrinsics.checkNotNullParameter(tables, "tables");
                            observerChannel.mo6233trySendJP2dKIU(Unit.INSTANCE);
                        }
                    };
                    observerChannel.mo6233trySendJP2dKIU(Unit.INSTANCE);
                    TransactionElement transactionElement = (TransactionElement) $this$coroutineScope.getCoroutineContext().get(TransactionElement.INSTANCE);
                    if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher()) == null) {
                        transactionDispatcher = this.$inTransaction ? CoroutinesRoomKt.getTransactionDispatcher(this.$db) : CoroutinesRoomKt.getQueryDispatcher(this.$db);
                    }
                    ContinuationInterceptor queryContext = transactionDispatcher;
                    Channel resultChannel = ChannelKt.Channel$default(0, null, null, 7, null);
                    BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, queryContext, null, new AnonymousClass1(this.$db, r13, observerChannel, this.$callable, resultChannel, null), 2, null);
                    this.label = 1;
                    if (FlowKt.emitAll(this.$$this$flow, resultChannel, this) != coroutine_suspended) {
                        break;
                    } else {
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

        /* compiled from: CoroutinesRoom.kt */
        @Metadata(m286d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m287d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
        @DebugMetadata(m296c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1", m297f = "CoroutinesRoom.kt", m298i = {}, m299l = {WorkQueueKt.MASK, 129}, m300m = "invokeSuspend", m301n = {}, m302s = {})
        /* renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Callable<R> $callable;
            final /* synthetic */ RoomDatabase $db;
            final /* synthetic */ CoroutinesRoom$Companion$createFlow$1$1$observer$1 $observer;
            final /* synthetic */ Channel<Unit> $observerChannel;
            final /* synthetic */ Channel<R> $resultChannel;
            Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(RoomDatabase roomDatabase, CoroutinesRoom$Companion$createFlow$1$1$observer$1 coroutinesRoom$Companion$createFlow$1$1$observer$1, Channel<Unit> channel, Callable<R> callable, Channel<R> channel2, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$db = roomDatabase;
                this.$observer = coroutinesRoom$Companion$createFlow$1$1$observer$1;
                this.$observerChannel = channel;
                this.$callable = callable;
                this.$resultChannel = channel2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$db, this.$observer, this.$observerChannel, this.$callable, this.$resultChannel, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:11:0x004e A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x005d A[Catch: all -> 0x008d, TRY_LEAVE, TryCatch #1 {all -> 0x008d, blocks: (B:14:0x0055, B:16:0x005d), top: B:13:0x0055 }] */
            /* JADX WARN: Removed duplicated region for block: B:20:0x007c  */
            /* JADX WARN: Type inference failed for: r1v0, types: [int] */
            /* JADX WARN: Type inference failed for: r1v11, types: [androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1] */
            /* JADX WARN: Type inference failed for: r1v14 */
            /* JADX WARN: Type inference failed for: r1v15 */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0077 -> B:9:0x0040). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                ChannelIterator<Unit> it;
                ChannelIterator<Unit> channelIterator;
                AnonymousClass1 anonymousClass1;
                Object obj2;
                Object obj3;
                Object hasNext;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                Continuation<? super Boolean> continuation = this.label;
                try {
                    switch (continuation) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            AnonymousClass1 anonymousClass12 = this;
                            anonymousClass12.$db.getInvalidationTracker().addObserver(anonymousClass12.$observer);
                            it = anonymousClass12.$observerChannel.iterator();
                            continuation = anonymousClass12;
                            continuation.L$0 = it;
                            continuation.label = 1;
                            hasNext = it.hasNext(continuation);
                            if (hasNext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Object obj4 = coroutine_suspended;
                            obj3 = obj;
                            obj = hasNext;
                            channelIterator = it;
                            anonymousClass1 = continuation;
                            obj2 = obj4;
                            try {
                                if (!((Boolean) obj).booleanValue()) {
                                    channelIterator.next();
                                    R call = anonymousClass1.$callable.call();
                                    anonymousClass1.L$0 = channelIterator;
                                    anonymousClass1.label = 2;
                                    if (anonymousClass1.$resultChannel.send(call, anonymousClass1) == obj2) {
                                        return obj2;
                                    }
                                    obj = obj3;
                                    coroutine_suspended = obj2;
                                    continuation = anonymousClass1;
                                    it = channelIterator;
                                    continuation.L$0 = it;
                                    continuation.label = 1;
                                    hasNext = it.hasNext(continuation);
                                    if (hasNext == coroutine_suspended) {
                                    }
                                } else {
                                    anonymousClass1.$db.getInvalidationTracker().removeObserver(anonymousClass1.$observer);
                                    return Unit.INSTANCE;
                                }
                            } catch (Throwable th) {
                                continuation = anonymousClass1;
                                th = th;
                                continuation.$db.getInvalidationTracker().removeObserver(continuation.$observer);
                                throw th;
                            }
                        case 1:
                            ChannelIterator<Unit> channelIterator2 = (ChannelIterator) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            channelIterator = channelIterator2;
                            anonymousClass1 = this;
                            obj2 = coroutine_suspended;
                            obj3 = obj;
                            if (!((Boolean) obj).booleanValue()) {
                            }
                            break;
                        case 2:
                            AnonymousClass1 anonymousClass13 = this;
                            it = (ChannelIterator) anonymousClass13.L$0;
                            ResultKt.throwOnFailure(obj);
                            continuation = anonymousClass13;
                            continuation.L$0 = it;
                            continuation.label = 1;
                            hasNext = it.hasNext(continuation);
                            if (hasNext == coroutine_suspended) {
                            }
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                FlowCollector $this$flow = (FlowCollector) this.L$0;
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(new C08561(this.$inTransaction, this.$db, $this$flow, this.$tableNames, this.$callable, null), this) != coroutine_suspended) {
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
