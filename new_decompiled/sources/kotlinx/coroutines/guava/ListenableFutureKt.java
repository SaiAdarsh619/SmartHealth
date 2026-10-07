package kotlinx.coroutines.guava;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause1;

/* compiled from: ListenableFuture.kt */
@Metadata(m286d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a!\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a[\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000e¢\u0006\u0002\b\u0011ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\f\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, m287d2 = {"asDeferred", "Lkotlinx/coroutines/Deferred;", "T", "Lcom/google/common/util/concurrent/ListenableFuture;", "asListenableFuture", "await", "(Lcom/google/common/util/concurrent/ListenableFuture;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "future", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lcom/google/common/util/concurrent/ListenableFuture;", "nonNullCause", "", "Ljava/util/concurrent/ExecutionException;", "kotlinx-coroutines-guava"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes15.dex */
public final class ListenableFutureKt {
    public static /* synthetic */ ListenableFuture future$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return future(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final <T> ListenableFuture<T> future(CoroutineScope $this$future, CoroutineContext context, CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        if (start.isLazy()) {
            throw new IllegalArgumentException((start + " start is not supported").toString());
        }
        CoroutineContext newContext = CoroutineContextKt.newCoroutineContext($this$future, context);
        ListenableFutureCoroutine coroutine = new ListenableFutureCoroutine(newContext);
        coroutine.start(start, coroutine, function2);
        return coroutine.future;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Deferred<T> asDeferred(final ListenableFuture<T> listenableFuture) {
        Throwable t;
        if ((listenableFuture instanceof InternalFutureFailureAccess) && (t = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) listenableFuture)) != null) {
            CompletableDeferred it = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            it.completeExceptionally(t);
            return it;
        }
        if (listenableFuture.isDone()) {
            try {
                return CompletableDeferredKt.CompletableDeferred(Uninterruptibles.getUninterruptibly(listenableFuture));
            } catch (CancellationException e) {
                CompletableDeferred it2 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                it2.cancel(e);
                return it2;
            } catch (ExecutionException e2) {
                CompletableDeferred it3 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                it3.completeExceptionally(nonNullCause(e2));
                return it3;
            }
        }
        final CompletableDeferred deferred = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Futures.addCallback(listenableFuture, new FutureCallback<T>() { // from class: kotlinx.coroutines.guava.ListenableFutureKt$asDeferred$4
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(T result) {
                Object m4732constructorimpl;
                CompletableDeferred<T> completableDeferred = deferred;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    ListenableFutureKt$asDeferred$4<T> listenableFutureKt$asDeferred$4 = this;
                    m4732constructorimpl = Result.m4732constructorimpl(Boolean.valueOf(completableDeferred.complete(result)));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m4732constructorimpl = Result.m4732constructorimpl(ResultKt.createFailure(th));
                }
                Throwable it4 = Result.m4735exceptionOrNullimpl(m4732constructorimpl);
                if (it4 != null) {
                    CoroutineExceptionHandlerKt.handleCoroutineException(EmptyCoroutineContext.INSTANCE, it4);
                }
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable t2) {
                Object m4732constructorimpl;
                CompletableDeferred<T> completableDeferred = deferred;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    ListenableFutureKt$asDeferred$4<T> listenableFutureKt$asDeferred$4 = this;
                    m4732constructorimpl = Result.m4732constructorimpl(Boolean.valueOf(completableDeferred.completeExceptionally(t2)));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m4732constructorimpl = Result.m4732constructorimpl(ResultKt.createFailure(th));
                }
                Throwable it4 = Result.m4735exceptionOrNullimpl(m4732constructorimpl);
                if (it4 != null) {
                    CoroutineExceptionHandlerKt.handleCoroutineException(EmptyCoroutineContext.INSTANCE, it4);
                }
            }
        }, MoreExecutors.directExecutor());
        deferred.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.guava.ListenableFutureKt$asDeferred$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it4) {
                listenableFuture.cancel(false);
            }
        });
        return new Deferred<T>() { // from class: kotlinx.coroutines.guava.ListenableFutureKt$asDeferred$6
            @Override // kotlinx.coroutines.Job
            public ChildHandle attachChild(ChildJob child) {
                return deferred.attachChild(child);
            }

            @Override // kotlinx.coroutines.Deferred
            public Object await(Continuation<? super T> continuation) {
                return deferred.await(continuation);
            }

            @Override // kotlinx.coroutines.Job
            @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
            public /* synthetic */ void cancel() {
                deferred.cancel();
            }

            @Override // kotlinx.coroutines.Job
            public void cancel(CancellationException cause) {
                deferred.cancel(cause);
            }

            @Override // kotlinx.coroutines.Job
            @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
            public /* synthetic */ boolean cancel(Throwable cause) {
                return deferred.cancel(cause);
            }

            @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
            public <R> R fold(R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
                return (R) deferred.fold(initial, operation);
            }

            @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
            public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
                return (E) deferred.get(key);
            }

            @Override // kotlinx.coroutines.Job
            public CancellationException getCancellationException() {
                return deferred.getCancellationException();
            }

            @Override // kotlinx.coroutines.Job
            public Sequence<Job> getChildren() {
                return deferred.getChildren();
            }

            @Override // kotlinx.coroutines.Deferred
            public T getCompleted() {
                return deferred.getCompleted();
            }

            @Override // kotlinx.coroutines.Deferred
            public Throwable getCompletionExceptionOrNull() {
                return deferred.getCompletionExceptionOrNull();
            }

            @Override // kotlin.coroutines.CoroutineContext.Element
            public CoroutineContext.Key<?> getKey() {
                return deferred.getKey();
            }

            @Override // kotlinx.coroutines.Deferred
            public SelectClause1<T> getOnAwait() {
                return deferred.getOnAwait();
            }

            @Override // kotlinx.coroutines.Job
            public SelectClause0 getOnJoin() {
                return deferred.getOnJoin();
            }

            @Override // kotlinx.coroutines.Job
            public Job getParent() {
                return deferred.getParent();
            }

            @Override // kotlinx.coroutines.Job
            public DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> handler) {
                return deferred.invokeOnCompletion(handler);
            }

            @Override // kotlinx.coroutines.Job
            public DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, Unit> handler) {
                return deferred.invokeOnCompletion(onCancelling, invokeImmediately, handler);
            }

            @Override // kotlinx.coroutines.Job
            public boolean isActive() {
                return deferred.isActive();
            }

            @Override // kotlinx.coroutines.Job
            public boolean isCancelled() {
                return deferred.isCancelled();
            }

            @Override // kotlinx.coroutines.Job
            public boolean isCompleted() {
                return deferred.isCompleted();
            }

            @Override // kotlinx.coroutines.Job
            public Object join(Continuation<? super Unit> continuation) {
                return deferred.join(continuation);
            }

            @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
            public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
                return deferred.minusKey(key);
            }

            @Override // kotlin.coroutines.CoroutineContext
            public CoroutineContext plus(CoroutineContext context) {
                return deferred.plus(context);
            }

            @Override // kotlinx.coroutines.Job
            @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
            public Job plus(Job other) {
                return deferred.plus(other);
            }

            @Override // kotlinx.coroutines.Job
            public boolean start() {
                return deferred.start();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable nonNullCause(ExecutionException $this$nonNullCause) {
        Throwable cause = $this$nonNullCause.getCause();
        Intrinsics.checkNotNull(cause);
        return cause;
    }

    public static final <T> ListenableFuture<T> asListenableFuture(final Deferred<? extends T> deferred) {
        final JobListenableFuture listenableFuture = new JobListenableFuture(deferred);
        deferred.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.guava.ListenableFutureKt$asListenableFuture$1
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
            public final void invoke2(Throwable throwable) {
                if (throwable == null) {
                    listenableFuture.complete(deferred.getCompleted());
                } else {
                    listenableFuture.completeExceptionallyOrCancel(throwable);
                }
            }
        });
        return listenableFuture;
    }

    public static final <T> Object await(final ListenableFuture<T> listenableFuture, Continuation<? super T> continuation) {
        try {
            if (listenableFuture.isDone()) {
                return Uninterruptibles.getUninterruptibly(listenableFuture);
            }
            CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellable$iv.initCancellability();
            CancellableContinuationImpl cont = cancellable$iv;
            listenableFuture.addListener(new ToContinuation(listenableFuture, cont), MoreExecutors.directExecutor());
            cont.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.guava.ListenableFutureKt$await$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    listenableFuture.cancel(false);
                }
            });
            Object result = cancellable$iv.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        } catch (ExecutionException e) {
            throw nonNullCause(e);
        }
    }
}
