package androidx.health.platform.client.impl.ipc.internal;

import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes14.dex */
public class DefaultExecutionTracker implements ExecutionTracker {
    private final Set<SettableFuture<?>> mFuturesInProgress = new HashSet();

    @Override // androidx.health.platform.client.impl.ipc.internal.ExecutionTracker
    public void track(final SettableFuture<?> future) {
        synchronized (this.mFuturesInProgress) {
            this.mFuturesInProgress.add(future);
            future.addListener(new Runnable() { // from class: androidx.health.platform.client.impl.ipc.internal.DefaultExecutionTracker$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultExecutionTracker.this.m49x59c09430(future);
                }
            }, MoreExecutors.directExecutor());
        }
    }

    /* renamed from: lambda$track$0$androidx-health-platform-client-impl-ipc-internal-DefaultExecutionTracker */
    /* synthetic */ void m49x59c09430(SettableFuture future) {
        synchronized (this.mFuturesInProgress) {
            this.mFuturesInProgress.remove(future);
        }
    }

    @Override // androidx.health.platform.client.impl.ipc.internal.ExecutionTracker
    public void cancelPendingFutures(Throwable throwable) {
        Set<SettableFuture<?>> futuresInProgressCopy;
        synchronized (this.mFuturesInProgress) {
            futuresInProgressCopy = new HashSet<>(this.mFuturesInProgress);
            this.mFuturesInProgress.clear();
        }
        for (SettableFuture<?> future : futuresInProgressCopy) {
            future.setException(throwable);
        }
    }
}
