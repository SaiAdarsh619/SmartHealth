package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
@Metadata(m286d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m287d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes15.dex */
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function3 $action$inlined;
    final /* synthetic */ Flow $this_onCompletion$inlined;

    /* compiled from: SafeCollector.common.kt */
    @Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
    @DebugMetadata(m296c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", m297f = "Emitters.kt", m298i = {0, 0, 1, 2}, m299l = {115, 122, 129}, m300m = "collect", m301n = {"this", "$this$onCompletion_u24lambda_u242", "e", "sc"}, m302s = {"L$0", "L$1", "L$0", "L$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 */
    public static final class C15991 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C15991(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        C15991 c15991;
        C15991 c159912;
        Object coroutine_suspended;
        Object invokeSafely$FlowKt__EmittersKt;
        FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
        FlowCollector $this$onCompletion_u24lambda_u242;
        SafeCollector sc;
        Throwable th;
        SafeCollector sc2;
        Object invoke;
        try {
            if (continuation instanceof C15991) {
                c15991 = (C15991) continuation;
                if ((c15991.label & Integer.MIN_VALUE) != 0) {
                    c15991.label -= Integer.MIN_VALUE;
                    c159912 = c15991;
                    Object $result = c159912.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (c159912.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                            $this$onCompletion_u24lambda_u242 = flowCollector;
                            Flow flow = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$this_onCompletion$inlined;
                            c159912.L$0 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
                            c159912.L$1 = $this$onCompletion_u24lambda_u242;
                            c159912.label = 1;
                            if (flow.collect($this$onCompletion_u24lambda_u242, c159912) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            sc = new SafeCollector($this$onCompletion_u24lambda_u242, c159912.getContext());
                            try {
                                Function3 function3 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                                c159912.L$0 = sc;
                                c159912.L$1 = null;
                                c159912.label = 3;
                                InlineMarker.mark(6);
                                invoke = function3.invoke(sc, null, c159912);
                                InlineMarker.mark(7);
                                if (invoke != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                sc2 = sc;
                                sc2.releaseIntercepted();
                                return Unit.INSTANCE;
                            } catch (Throwable th2) {
                                th = th2;
                                sc2 = sc;
                                sc2.releaseIntercepted();
                                throw th;
                            }
                        case 1:
                            $this$onCompletion_u24lambda_u242 = (FlowCollector) c159912.L$1;
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) c159912.L$0;
                            ResultKt.throwOnFailure($result);
                            sc = new SafeCollector($this$onCompletion_u24lambda_u242, c159912.getContext());
                            Function3 function32 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                            c159912.L$0 = sc;
                            c159912.L$1 = null;
                            c159912.label = 3;
                            InlineMarker.mark(6);
                            invoke = function32.invoke(sc, null, c159912);
                            InlineMarker.mark(7);
                            if (invoke != coroutine_suspended) {
                            }
                            break;
                        case 2:
                            Throwable e = (Throwable) c159912.L$0;
                            ResultKt.throwOnFailure($result);
                            throw e;
                        case 3:
                            sc2 = (SafeCollector) c159912.L$0;
                            try {
                                ResultKt.throwOnFailure($result);
                                sc2.releaseIntercepted();
                                return Unit.INSTANCE;
                            } catch (Throwable th3) {
                                th = th3;
                                sc2.releaseIntercepted();
                                throw th;
                            }
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (c159912.label) {
            }
        } catch (Throwable e2) {
            ThrowingCollector throwingCollector = new ThrowingCollector(e2);
            Function3 function33 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
            c159912.L$0 = e2;
            c159912.L$1 = null;
            c159912.label = 2;
            invokeSafely$FlowKt__EmittersKt = FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(throwingCollector, function33, e2, c159912);
            if (invokeSafely$FlowKt__EmittersKt == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw e2;
        }
        c15991 = new C15991(continuation);
        c159912 = c15991;
        Object $result2 = c159912.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.$this_onCompletion$inlined = flow;
        this.$action$inlined = function3;
    }
}
