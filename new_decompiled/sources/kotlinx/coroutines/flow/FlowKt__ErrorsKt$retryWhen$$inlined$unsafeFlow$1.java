package kotlinx.coroutines.flow;

import androidx.compose.material.MenuKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
@Metadata(m286d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m287d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes15.dex */
public final class FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function4 $predicate$inlined;
    final /* synthetic */ Flow $this_retryWhen$inlined;

    /* compiled from: SafeCollector.common.kt */
    @Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
    @DebugMetadata(m296c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1", m297f = "Errors.kt", m298i = {0, 0, 0, 0, 1, 1, 1, 1}, m299l = {118, MenuKt.InTransitionDuration}, m300m = "collect", m301n = {"this", "$this$retryWhen_u24lambda_u242", "attempt", "shallRetry", "this", "$this$retryWhen_u24lambda_u242", "cause", "attempt"}, m302s = {"L$0", "L$1", "J$0", "I$0", "L$0", "L$1", "L$2", "J$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1 */
    public static final class C16051 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C16051(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00ab -> B:12:0x00af). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00c5 -> B:15:0x00cc). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        C16051 c16051;
        C16051 c160512;
        int i;
        long attempt;
        FlowCollector<? super T> flowCollector2;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
        int i2;
        Object obj;
        Object $result;
        Throwable cause;
        Throwable cause2;
        FlowCollector<? super T> flowCollector3;
        if (continuation instanceof C16051) {
            c16051 = (C16051) continuation;
            if ((c16051.label & Integer.MIN_VALUE) != 0) {
                c16051.label -= Integer.MIN_VALUE;
                c160512 = c16051;
                Object $result2 = c160512.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (c160512.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = this;
                        int i3 = 0;
                        long attempt2 = 0;
                        i2 = 0;
                        Flow flow = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12.$this_retryWhen$inlined;
                        c160512.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                        c160512.L$1 = flowCollector;
                        c160512.L$2 = null;
                        c160512.J$0 = attempt2;
                        c160512.I$0 = 0;
                        c160512.label = 1;
                        Object catchImpl = FlowKt.catchImpl(flow, flowCollector, c160512);
                        if (catchImpl == $result3) {
                            return $result3;
                        }
                        flowCollector2 = flowCollector;
                        i = i3;
                        attempt = attempt2;
                        Object obj2 = $result3;
                        $result = $result2;
                        $result2 = catchImpl;
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                        obj = obj2;
                        cause = (Throwable) $result2;
                        if (cause == null) {
                            Function4 function4 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.$predicate$inlined;
                            Long boxLong = Boxing.boxLong(attempt);
                            c160512.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                            c160512.L$1 = flowCollector2;
                            c160512.L$2 = cause;
                            c160512.J$0 = attempt;
                            c160512.label = 2;
                            InlineMarker.mark(6);
                            Object invoke = function4.invoke(flowCollector2, cause, boxLong, c160512);
                            InlineMarker.mark(7);
                            if (invoke == obj) {
                                return obj;
                            }
                            FlowCollector<? super T> flowCollector4 = flowCollector2;
                            cause2 = cause;
                            $result2 = invoke;
                            flowCollector3 = flowCollector4;
                            if (((Boolean) $result2).booleanValue()) {
                                throw cause2;
                            }
                            attempt2 = attempt + 1;
                            i3 = i;
                            flowCollector = flowCollector3;
                            i2 = 1;
                            $result2 = $result;
                            $result3 = obj;
                            flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                            if (i2 == 0) {
                                return Unit.INSTANCE;
                            }
                            i2 = 0;
                            Flow flow2 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12.$this_retryWhen$inlined;
                            c160512.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                            c160512.L$1 = flowCollector;
                            c160512.L$2 = null;
                            c160512.J$0 = attempt2;
                            c160512.I$0 = 0;
                            c160512.label = 1;
                            Object catchImpl2 = FlowKt.catchImpl(flow2, flowCollector, c160512);
                            if (catchImpl2 == $result3) {
                            }
                        } else {
                            $result2 = $result;
                            $result3 = obj;
                            flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                            long j = attempt;
                            i3 = i;
                            flowCollector = flowCollector2;
                            attempt2 = j;
                            if (i2 == 0) {
                            }
                            i2 = 0;
                            Flow flow22 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12.$this_retryWhen$inlined;
                            c160512.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                            c160512.L$1 = flowCollector;
                            c160512.L$2 = null;
                            c160512.J$0 = attempt2;
                            c160512.I$0 = 0;
                            c160512.label = 1;
                            Object catchImpl22 = FlowKt.catchImpl(flow22, flowCollector, c160512);
                            if (catchImpl22 == $result3) {
                            }
                        }
                    case 1:
                        i = 0;
                        int i4 = c160512.I$0;
                        attempt = c160512.J$0;
                        flowCollector2 = (FlowCollector) c160512.L$1;
                        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$13 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) c160512.L$0;
                        ResultKt.throwOnFailure($result2);
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$13;
                        i2 = i4;
                        obj = $result3;
                        $result = $result2;
                        cause = (Throwable) $result2;
                        if (cause == null) {
                        }
                        break;
                    case 2:
                        i = 0;
                        long attempt3 = c160512.J$0;
                        Throwable cause3 = (Throwable) c160512.L$2;
                        FlowCollector<? super T> flowCollector5 = (FlowCollector) c160512.L$1;
                        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$14 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) c160512.L$0;
                        ResultKt.throwOnFailure($result2);
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$14;
                        flowCollector3 = flowCollector5;
                        cause2 = cause3;
                        attempt = attempt3;
                        obj = $result3;
                        $result = $result2;
                        if (((Boolean) $result2).booleanValue()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        c16051 = new C16051(continuation);
        c160512 = c16051;
        Object $result22 = c160512.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c160512.label) {
        }
    }

    public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(Flow flow, Function4 function4) {
        this.$this_retryWhen$inlined = flow;
        this.$predicate$inlined = function4;
    }
}
