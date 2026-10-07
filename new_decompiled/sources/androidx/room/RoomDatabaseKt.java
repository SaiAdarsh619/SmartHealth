package androidx.room;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.ThreadContextElement;
import kotlinx.coroutines.ThreadContextElementKt;

/* compiled from: RoomDatabaseExt.kt */
@Metadata(m286d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a9\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\u00020\b2\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, m287d2 = {"acquireTransactionThread", "Lkotlin/coroutines/ContinuationInterceptor;", "Ljava/util/concurrent/Executor;", "controlJob", "Lkotlinx/coroutines/Job;", "(Ljava/util/concurrent/Executor;Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createTransactionContext", "Lkotlin/coroutines/CoroutineContext;", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTransaction", "R", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-ktx_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes14.dex */
public final class RoomDatabaseKt {
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object withTransaction(RoomDatabase $this$withTransaction, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        RoomDatabaseKt$withTransaction$1 roomDatabaseKt$withTransaction$1;
        RoomDatabaseKt$withTransaction$1 roomDatabaseKt$withTransaction$12;
        Object createTransactionContext;
        RoomDatabase $this$withTransaction2;
        Function1<? super Continuation<? super R>, ? extends Object> function12;
        ContinuationInterceptor transactionDispatcher;
        ContinuationInterceptor transactionContext;
        if (continuation instanceof RoomDatabaseKt$withTransaction$1) {
            roomDatabaseKt$withTransaction$1 = (RoomDatabaseKt$withTransaction$1) continuation;
            if ((roomDatabaseKt$withTransaction$1.label & Integer.MIN_VALUE) != 0) {
                roomDatabaseKt$withTransaction$1.label -= Integer.MIN_VALUE;
                roomDatabaseKt$withTransaction$12 = roomDatabaseKt$withTransaction$1;
                Object $result = roomDatabaseKt$withTransaction$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (roomDatabaseKt$withTransaction$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        TransactionElement transactionElement = (TransactionElement) roomDatabaseKt$withTransaction$12.getContext().get(TransactionElement.INSTANCE);
                        if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher()) == null) {
                            roomDatabaseKt$withTransaction$12.L$0 = $this$withTransaction;
                            roomDatabaseKt$withTransaction$12.L$1 = function1;
                            roomDatabaseKt$withTransaction$12.label = 1;
                            createTransactionContext = createTransactionContext($this$withTransaction, roomDatabaseKt$withTransaction$12);
                            if (createTransactionContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$withTransaction2 = $this$withTransaction;
                            function12 = function1;
                            transactionContext = (CoroutineContext) createTransactionContext;
                            RoomDatabase roomDatabase = $this$withTransaction2;
                            function1 = function12;
                            $this$withTransaction = roomDatabase;
                            RoomDatabaseKt$withTransaction$2 roomDatabaseKt$withTransaction$2 = new RoomDatabaseKt$withTransaction$2($this$withTransaction, function1, null);
                            roomDatabaseKt$withTransaction$12.L$0 = null;
                            roomDatabaseKt$withTransaction$12.L$1 = null;
                            roomDatabaseKt$withTransaction$12.label = 2;
                            Object withContext = BuildersKt.withContext(transactionContext, roomDatabaseKt$withTransaction$2, roomDatabaseKt$withTransaction$12);
                            return withContext == coroutine_suspended ? coroutine_suspended : withContext;
                        }
                        transactionContext = transactionDispatcher;
                        RoomDatabaseKt$withTransaction$2 roomDatabaseKt$withTransaction$22 = new RoomDatabaseKt$withTransaction$2($this$withTransaction, function1, null);
                        roomDatabaseKt$withTransaction$12.L$0 = null;
                        roomDatabaseKt$withTransaction$12.L$1 = null;
                        roomDatabaseKt$withTransaction$12.label = 2;
                        Object withContext2 = BuildersKt.withContext(transactionContext, roomDatabaseKt$withTransaction$22, roomDatabaseKt$withTransaction$12);
                        if (withContext2 == coroutine_suspended) {
                        }
                        break;
                    case 1:
                        function12 = (Function1) roomDatabaseKt$withTransaction$12.L$1;
                        $this$withTransaction2 = (RoomDatabase) roomDatabaseKt$withTransaction$12.L$0;
                        ResultKt.throwOnFailure($result);
                        createTransactionContext = $result;
                        transactionContext = (CoroutineContext) createTransactionContext;
                        RoomDatabase roomDatabase2 = $this$withTransaction2;
                        function1 = function12;
                        $this$withTransaction = roomDatabase2;
                        RoomDatabaseKt$withTransaction$2 roomDatabaseKt$withTransaction$222 = new RoomDatabaseKt$withTransaction$2($this$withTransaction, function1, null);
                        roomDatabaseKt$withTransaction$12.L$0 = null;
                        roomDatabaseKt$withTransaction$12.L$1 = null;
                        roomDatabaseKt$withTransaction$12.label = 2;
                        Object withContext22 = BuildersKt.withContext(transactionContext, roomDatabaseKt$withTransaction$222, roomDatabaseKt$withTransaction$12);
                        if (withContext22 == coroutine_suspended) {
                        }
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        roomDatabaseKt$withTransaction$1 = new RoomDatabaseKt$withTransaction$1(continuation);
        roomDatabaseKt$withTransaction$12 = roomDatabaseKt$withTransaction$1;
        Object $result2 = roomDatabaseKt$withTransaction$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (roomDatabaseKt$withTransaction$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object createTransactionContext(RoomDatabase $this$createTransactionContext, Continuation<? super CoroutineContext> continuation) {
        RoomDatabaseKt$createTransactionContext$1 roomDatabaseKt$createTransactionContext$1;
        RoomDatabaseKt$createTransactionContext$1 roomDatabaseKt$createTransactionContext$12;
        final CompletableJob controlJob;
        Object acquireTransactionThread;
        RoomDatabase $this$createTransactionContext2;
        CompletableJob controlJob2;
        if (continuation instanceof RoomDatabaseKt$createTransactionContext$1) {
            roomDatabaseKt$createTransactionContext$1 = (RoomDatabaseKt$createTransactionContext$1) continuation;
            if ((roomDatabaseKt$createTransactionContext$1.label & Integer.MIN_VALUE) != 0) {
                roomDatabaseKt$createTransactionContext$1.label -= Integer.MIN_VALUE;
                roomDatabaseKt$createTransactionContext$12 = roomDatabaseKt$createTransactionContext$1;
                Object $result = roomDatabaseKt$createTransactionContext$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (roomDatabaseKt$createTransactionContext$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        controlJob = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
                        Job job = (Job) roomDatabaseKt$createTransactionContext$12.getContext().get(Job.INSTANCE);
                        if (job != null) {
                            job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.room.RoomDatabaseKt$createTransactionContext$2
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
                                    Job.DefaultImpls.cancel$default((Job) CompletableJob.this, (CancellationException) null, 1, (Object) null);
                                }
                            });
                        }
                        roomDatabaseKt$createTransactionContext$12.L$0 = $this$createTransactionContext;
                        roomDatabaseKt$createTransactionContext$12.L$1 = controlJob;
                        roomDatabaseKt$createTransactionContext$12.label = 1;
                        acquireTransactionThread = acquireTransactionThread($this$createTransactionContext.getTransactionExecutor(), controlJob, roomDatabaseKt$createTransactionContext$12);
                        if (acquireTransactionThread == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$createTransactionContext2 = $this$createTransactionContext;
                        controlJob2 = controlJob;
                        break;
                    case 1:
                        controlJob2 = (CompletableJob) roomDatabaseKt$createTransactionContext$12.L$1;
                        $this$createTransactionContext2 = (RoomDatabase) roomDatabaseKt$createTransactionContext$12.L$0;
                        ResultKt.throwOnFailure($result);
                        acquireTransactionThread = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ContinuationInterceptor dispatcher = (ContinuationInterceptor) acquireTransactionThread;
                TransactionElement transactionElement = new TransactionElement(controlJob2, dispatcher);
                ThreadContextElement threadLocalElement = ThreadContextElementKt.asContextElement($this$createTransactionContext2.getSuspendingTransactionId(), Boxing.boxInt(System.identityHashCode(controlJob2)));
                return dispatcher.plus(transactionElement).plus(threadLocalElement);
            }
        }
        roomDatabaseKt$createTransactionContext$1 = new RoomDatabaseKt$createTransactionContext$1(continuation);
        roomDatabaseKt$createTransactionContext$12 = roomDatabaseKt$createTransactionContext$1;
        Object $result2 = roomDatabaseKt$createTransactionContext$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (roomDatabaseKt$createTransactionContext$12.label) {
        }
        ContinuationInterceptor dispatcher2 = (ContinuationInterceptor) acquireTransactionThread;
        TransactionElement transactionElement2 = new TransactionElement(controlJob2, dispatcher2);
        ThreadContextElement threadLocalElement2 = ThreadContextElementKt.asContextElement($this$createTransactionContext2.getSuspendingTransactionId(), Boxing.boxInt(System.identityHashCode(controlJob2)));
        return dispatcher2.plus(transactionElement2).plus(threadLocalElement2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object acquireTransactionThread(Executor $this$acquireTransactionThread, final Job controlJob, Continuation<? super ContinuationInterceptor> continuation) {
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        final CancellableContinuationImpl continuation2 = cancellable$iv;
        continuation2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$1
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
                Job.DefaultImpls.cancel$default(Job.this, (CancellationException) null, 1, (Object) null);
            }
        });
        try {
            $this$acquireTransactionThread.execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2

                /* compiled from: RoomDatabaseExt.kt */
                @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                @DebugMetadata(m296c = "androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2$1", m297f = "RoomDatabaseExt.kt", m298i = {}, m299l = {125}, m300m = "invokeSuspend", m301n = {}, m302s = {})
                /* renamed from: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2$1 */
                static final class C08601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CancellableContinuation<ContinuationInterceptor> $continuation;
                    final /* synthetic */ Job $controlJob;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C08601(CancellableContinuation<? super ContinuationInterceptor> cancellableContinuation, Job job, Continuation<? super C08601> continuation) {
                        super(2, continuation);
                        this.$continuation = cancellableContinuation;
                        this.$controlJob = job;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C08601 c08601 = new C08601(this.$continuation, this.$controlJob, continuation);
                        c08601.L$0 = obj;
                        return c08601;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C08601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                                CancellableContinuation<ContinuationInterceptor> cancellableContinuation = this.$continuation;
                                Result.Companion companion = Result.INSTANCE;
                                CoroutineContext.Element element = coroutineScope.getCoroutineContext().get(ContinuationInterceptor.INSTANCE);
                                Intrinsics.checkNotNull(element);
                                cancellableContinuation.resumeWith(Result.m4732constructorimpl(element));
                                this.label = 1;
                                if (this.$controlJob.join(this) != coroutine_suspended) {
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

                @Override // java.lang.Runnable
                public final void run() {
                    BuildersKt__BuildersKt.runBlocking$default(null, new C08601(continuation2, controlJob, null), 1, null);
                }
            });
        } catch (RejectedExecutionException ex) {
            continuation2.cancel(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", ex));
        }
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
