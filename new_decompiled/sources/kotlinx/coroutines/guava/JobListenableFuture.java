package kotlinx.coroutines.guava;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: ListenableFuture.kt */
@Metadata(m286d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0013\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aJ\r\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0096\u0002¢\u0006\u0002\u0010!J\u0017\u0010\"\u001a\u00028\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\u000bH\u0016J\b\u0010%\u001a\u00020\u000bH\u0016J\b\u0010&\u001a\u00020'H\u0016R&\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b \t*\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, m287d2 = {"Lkotlinx/coroutines/guava/JobListenableFuture;", "T", "Lcom/google/common/util/concurrent/ListenableFuture;", "jobToCancel", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "auxFuture", "Lcom/google/common/util/concurrent/SettableFuture;", "", "kotlin.jvm.PlatformType", "auxFutureIsFailed", "", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "executor", "Ljava/util/concurrent/Executor;", "cancel", "mayInterruptIfRunning", "complete", "result", "(Ljava/lang/Object;)Z", "completeExceptionallyOrCancel", "t", "", "get", "()Ljava/lang/Object;", "timeout", "", "unit", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "getInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "isCancelled", "isDone", "toString", "", "kotlinx-coroutines-guava"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes15.dex */
final class JobListenableFuture<T> implements ListenableFuture<T> {
    private final SettableFuture<Object> auxFuture = SettableFuture.create();
    private boolean auxFutureIsFailed;
    private final Job jobToCancel;

    public JobListenableFuture(Job jobToCancel) {
        this.jobToCancel = jobToCancel;
    }

    public final boolean complete(T result) {
        return this.auxFuture.set(result);
    }

    public final boolean completeExceptionallyOrCancel(Throwable t) {
        if (t instanceof CancellationException) {
            return this.auxFuture.set(new Cancelled((CancellationException) t));
        }
        boolean it = this.auxFuture.setException(t);
        if (!it) {
            return it;
        }
        this.auxFutureIsFailed = true;
        return it;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        boolean z;
        if (this.auxFuture.isCancelled()) {
            return true;
        }
        if (isDone() && !this.auxFutureIsFailed) {
            try {
                z = Uninterruptibles.getUninterruptibly(this.auxFuture) instanceof Cancelled;
            } catch (CancellationException e) {
                z = true;
            } catch (ExecutionException e2) {
                this.auxFutureIsFailed = true;
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        return getInternal(this.auxFuture.get());
    }

    @Override // java.util.concurrent.Future
    public T get(long timeout, TimeUnit unit) {
        return getInternal(this.auxFuture.get(timeout, unit));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final T getInternal(Object result) {
        if (result instanceof Cancelled) {
            throw new CancellationException().initCause(((Cancelled) result).exception);
        }
        return result;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable listener, Executor executor) {
        this.auxFuture.addListener(listener, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.auxFuture.isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        if (this.auxFuture.cancel(mayInterruptIfRunning)) {
            Job.DefaultImpls.cancel$default(this.jobToCancel, (CancellationException) null, 1, (Object) null);
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder $this$toString_u24lambda_u241 = new StringBuilder();
        $this$toString_u24lambda_u241.append(super.toString());
        $this$toString_u24lambda_u241.append("[status=");
        if (isDone()) {
            try {
                Object result = Uninterruptibles.getUninterruptibly(this.auxFuture);
                if (result instanceof Cancelled) {
                    $this$toString_u24lambda_u241.append("CANCELLED, cause=[" + ((Cancelled) result).exception + ']');
                } else {
                    $this$toString_u24lambda_u241.append("SUCCESS, result=[" + result + ']');
                }
            } catch (CancellationException e) {
                $this$toString_u24lambda_u241.append("CANCELLED");
            } catch (ExecutionException e2) {
                $this$toString_u24lambda_u241.append("FAILURE, cause=[" + e2.getCause() + ']');
            } catch (Throwable t) {
                $this$toString_u24lambda_u241.append("UNKNOWN, cause=[" + t.getClass() + " thrown from get()]");
            }
        } else {
            $this$toString_u24lambda_u241.append("PENDING, delegate=[" + this.auxFuture + ']');
        }
        $this$toString_u24lambda_u241.append(']');
        String sb = $this$toString_u24lambda_u241.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }
}
