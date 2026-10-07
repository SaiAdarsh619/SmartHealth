package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Limit.kt */
@Metadata(m286d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, m287d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes15.dex */
public final class FlowKt__ReduceKt$first$$inlined$collectWhile$2<T> implements FlowCollector<T> {
    final /* synthetic */ Function2 $predicate$inlined;
    final /* synthetic */ Ref.ObjectRef $result$inlined;

    /* compiled from: Limit.kt */
    @Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
    @DebugMetadata(m296c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2", m297f = "Reduce.kt", m298i = {0, 0}, m299l = {142}, m300m = "emit", m301n = {"this", "it"}, m302s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2$1 */
    public static final class C16121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C16121(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ReduceKt$first$$inlined$collectWhile$2.this.emit(null, this);
        }
    }

    public FlowKt__ReduceKt$first$$inlined$collectWhile$2(Function2 function2, Ref.ObjectRef objectRef) {
        this.$predicate$inlined = function2;
        this.$result$inlined = objectRef;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(T t, Continuation<? super Unit> continuation) {
        C16121 c16121;
        C16121 c161212;
        boolean z;
        FlowKt__ReduceKt$first$$inlined$collectWhile$2<T> flowKt__ReduceKt$first$$inlined$collectWhile$2;
        Object invoke;
        T t2;
        if (continuation instanceof C16121) {
            c16121 = (C16121) continuation;
            if ((c16121.label & Integer.MIN_VALUE) != 0) {
                c16121.label -= Integer.MIN_VALUE;
                c161212 = c16121;
                Object obj = c161212.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                z = true;
                switch (c161212.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        flowKt__ReduceKt$first$$inlined$collectWhile$2 = this;
                        Function2 function2 = flowKt__ReduceKt$first$$inlined$collectWhile$2.$predicate$inlined;
                        c161212.L$0 = flowKt__ReduceKt$first$$inlined$collectWhile$2;
                        c161212.L$1 = t;
                        c161212.label = 1;
                        InlineMarker.mark(6);
                        invoke = function2.invoke(t, c161212);
                        InlineMarker.mark(7);
                        if (invoke != coroutine_suspended) {
                            t2 = t;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        t2 = (T) c161212.L$1;
                        flowKt__ReduceKt$first$$inlined$collectWhile$2 = (FlowKt__ReduceKt$first$$inlined$collectWhile$2) c161212.L$0;
                        ResultKt.throwOnFailure(obj);
                        invoke = obj;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((Boolean) invoke).booleanValue()) {
                    flowKt__ReduceKt$first$$inlined$collectWhile$2.$result$inlined.element = t2;
                    z = false;
                }
                if (z) {
                    throw new AbortFlowException(flowKt__ReduceKt$first$$inlined$collectWhile$2);
                }
                return Unit.INSTANCE;
            }
        }
        c16121 = new C16121(continuation);
        c161212 = c16121;
        Object obj2 = c161212.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        z = true;
        switch (c161212.label) {
        }
        if (((Boolean) invoke).booleanValue()) {
        }
        if (z) {
        }
    }
}
