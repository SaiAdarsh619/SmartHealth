package kotlinx.coroutines.stream;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: Stream.kt */
@Metadata(m286d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u001f\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\fR\t\u0010\u0006\u001a\u00020\u0007X\u0082\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m287d2 = {"Lkotlinx/coroutines/stream/StreamFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "stream", "Ljava/util/stream/Stream;", "(Ljava/util/stream/Stream;)V", "consumed", "Lkotlinx/atomicfu/AtomicBoolean;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes15.dex */
final class StreamFlow<T> implements Flow<T> {
    private static final AtomicIntegerFieldUpdater consumed$FU = AtomicIntegerFieldUpdater.newUpdater(StreamFlow.class, "consumed");

    @Volatile
    private volatile int consumed = 0;
    private final Stream<T> stream;

    public StreamFlow(Stream<T> stream) {
        this.stream = stream;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005b A[Catch: all -> 0x0078, TRY_LEAVE, TryCatch #0 {all -> 0x0078, blocks: (B:13:0x003a, B:15:0x0055, B:17:0x005b, B:28:0x004c), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        StreamFlow$collect$1 streamFlow$collect$1;
        StreamFlow$collect$1 streamFlow$collect$12;
        StreamFlow streamFlow;
        FlowCollector collector;
        Iterator<T> it;
        try {
            if (continuation instanceof StreamFlow$collect$1) {
                streamFlow$collect$1 = (StreamFlow$collect$1) continuation;
                if ((streamFlow$collect$1.label & Integer.MIN_VALUE) != 0) {
                    streamFlow$collect$1.label -= Integer.MIN_VALUE;
                    streamFlow$collect$12 = streamFlow$collect$1;
                    Object $result = streamFlow$collect$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (streamFlow$collect$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            streamFlow = this;
                            if (!consumed$FU.compareAndSet(streamFlow, 0, 1)) {
                                throw new IllegalStateException("Stream.consumeAsFlow can be collected only once".toString());
                            }
                            collector = flowCollector;
                            it = streamFlow.stream.iterator();
                            break;
                        case 1:
                            it = (Iterator) streamFlow$collect$12.L$2;
                            collector = (FlowCollector) streamFlow$collect$12.L$1;
                            streamFlow = (StreamFlow) streamFlow$collect$12.L$0;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    while (it.hasNext()) {
                        T next = it.next();
                        streamFlow$collect$12.L$0 = streamFlow;
                        streamFlow$collect$12.L$1 = collector;
                        streamFlow$collect$12.L$2 = it;
                        streamFlow$collect$12.label = 1;
                        if (collector.emit(next, streamFlow$collect$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    streamFlow.stream.close();
                    return Unit.INSTANCE;
                }
            }
            switch (streamFlow$collect$12.label) {
            }
            while (it.hasNext()) {
            }
            streamFlow.stream.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            streamFlow.stream.close();
            throw th;
        }
        streamFlow$collect$1 = new StreamFlow$collect$1(this, continuation);
        streamFlow$collect$12 = streamFlow$collect$1;
        Object $result2 = streamFlow$collect$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
}
