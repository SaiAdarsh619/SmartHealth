package androidx.compose.p000ui.platform;

import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* compiled from: GlobalSnapshotManager.android.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1", m297f = "GlobalSnapshotManager.android.kt", m298i = {0}, m299l = {63}, m300m = "invokeSuspend", m301n = {"$this$consume$iv$iv"}, m302s = {"L$0"})
/* loaded from: classes.dex */
final class GlobalSnapshotManager$ensureStarted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Unit> $channel;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlobalSnapshotManager$ensureStarted$1(Channel<Unit> channel, Continuation<? super GlobalSnapshotManager$ensureStarted$1> continuation) {
        super(2, continuation);
        this.$channel = channel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlobalSnapshotManager$ensureStarted$1(this.$channel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GlobalSnapshotManager$ensureStarted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0069 A[Catch: all -> 0x0089, TRY_LEAVE, TryCatch #1 {all -> 0x0089, blocks: (B:11:0x0061, B:13:0x0069), top: B:10:0x0061 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0055 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0080  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0056 -> B:10:0x0061). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object e$iv) {
        ReceiveChannel $this$consume$iv$iv;
        Object $result;
        ReceiveChannel $this$consume$iv$iv2;
        Throwable cause$iv$iv;
        ChannelIterator channelIterator;
        ReceiveChannel receiveChannel;
        int $i$f$consume;
        int $i$f$consume2;
        GlobalSnapshotManager$ensureStarted$1 globalSnapshotManager$ensureStarted$1;
        Object obj;
        Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(e$iv);
                GlobalSnapshotManager$ensureStarted$1 globalSnapshotManager$ensureStarted$12 = this;
                ReceiveChannel $this$consumeEach$iv = globalSnapshotManager$ensureStarted$12.$channel;
                $this$consume$iv$iv = $this$consumeEach$iv;
                Throwable cause$iv$iv2 = null;
                try {
                    ReceiveChannel $this$consumeEach_u24lambda_u2d1$iv = null;
                    ChannelIterator it = $this$consume$iv$iv.iterator();
                    int $i$f$consumeEach = 0;
                    int $i$f$consume3 = 0;
                    globalSnapshotManager$ensureStarted$12.L$0 = $this$consume$iv$iv;
                    globalSnapshotManager$ensureStarted$12.L$1 = it;
                    globalSnapshotManager$ensureStarted$12.label = 1;
                    Object hasNext = it.hasNext(globalSnapshotManager$ensureStarted$12);
                    if (hasNext != $result2) {
                        return $result2;
                    }
                    Object obj2 = $result2;
                    $result = e$iv;
                    e$iv = hasNext;
                    $this$consume$iv$iv2 = $this$consume$iv$iv;
                    cause$iv$iv = cause$iv$iv2;
                    channelIterator = it;
                    receiveChannel = $this$consumeEach_u24lambda_u2d1$iv;
                    $i$f$consume = $i$f$consumeEach;
                    $i$f$consume2 = $i$f$consume3;
                    globalSnapshotManager$ensureStarted$1 = globalSnapshotManager$ensureStarted$12;
                    obj = obj2;
                    try {
                        if (((Boolean) e$iv).booleanValue()) {
                            ChannelsKt.cancelConsumed($this$consume$iv$iv2, cause$iv$iv);
                            return Unit.INSTANCE;
                        }
                        Snapshot.INSTANCE.sendApplyNotifications();
                        e$iv = $result;
                        $result2 = obj;
                        globalSnapshotManager$ensureStarted$12 = globalSnapshotManager$ensureStarted$1;
                        $i$f$consume3 = $i$f$consume2;
                        $i$f$consumeEach = $i$f$consume;
                        $this$consumeEach_u24lambda_u2d1$iv = receiveChannel;
                        it = channelIterator;
                        cause$iv$iv2 = cause$iv$iv;
                        $this$consume$iv$iv = $this$consume$iv$iv2;
                        globalSnapshotManager$ensureStarted$12.L$0 = $this$consume$iv$iv;
                        globalSnapshotManager$ensureStarted$12.L$1 = it;
                        globalSnapshotManager$ensureStarted$12.label = 1;
                        Object hasNext2 = it.hasNext(globalSnapshotManager$ensureStarted$12);
                        if (hasNext2 != $result2) {
                        }
                    } catch (Throwable th) {
                        $this$consume$iv$iv = $this$consume$iv$iv2;
                        e$iv$iv = th;
                        Throwable cause$iv$iv3 = e$iv$iv;
                        try {
                            throw e$iv$iv;
                        } catch (Throwable e$iv$iv) {
                            ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv3);
                            throw e$iv$iv;
                        }
                    }
                } catch (Throwable th2) {
                    e$iv$iv = th2;
                    Throwable cause$iv$iv32 = e$iv$iv;
                    throw e$iv$iv;
                }
            case 1:
                ChannelIterator channelIterator2 = (ChannelIterator) this.L$1;
                $this$consume$iv$iv = (ReceiveChannel) this.L$0;
                try {
                    ResultKt.throwOnFailure(e$iv);
                    $this$consume$iv$iv2 = $this$consume$iv$iv;
                    cause$iv$iv = null;
                    channelIterator = channelIterator2;
                    receiveChannel = null;
                    $i$f$consume = 0;
                    $i$f$consume2 = 0;
                    globalSnapshotManager$ensureStarted$1 = this;
                    obj = $result2;
                    $result = e$iv;
                    if (((Boolean) e$iv).booleanValue()) {
                    }
                } catch (Throwable th3) {
                    e$iv$iv = th3;
                    Throwable cause$iv$iv322 = e$iv$iv;
                    throw e$iv$iv;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
