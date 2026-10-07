package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
@Metadata(m286d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m287d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes15.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6<T> implements Flow<T> {
    final /* synthetic */ Object[] $this_asFlow$inlined;

    /* compiled from: SafeCollector.common.kt */
    @Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
    @DebugMetadata(m296c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6", m297f = "Builders.kt", m298i = {0, 0}, m299l = {116}, m300m = "collect", m301n = {"$this$asFlow_u24lambda_u2411", "$this$forEach$iv"}, m302s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6$1 */
    public static final class C15921 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C15921(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6.this.collect(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x006b -> B:12:0x006c). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        C15921 c15921;
        C15921 c159212;
        FlowCollector flowCollector2;
        Object[] objArr;
        int length;
        int i;
        FlowCollector flowCollector3;
        if (continuation instanceof C15921) {
            c15921 = (C15921) continuation;
            if ((c15921.label & Integer.MIN_VALUE) != 0) {
                c15921.label -= Integer.MIN_VALUE;
                c159212 = c15921;
                Object obj = c159212.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (c159212.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        Object[] objArr2 = this.$this_asFlow$inlined;
                        flowCollector2 = flowCollector;
                        objArr = objArr2;
                        length = objArr2.length;
                        i = 0;
                        if (i < length) {
                            Object obj2 = objArr[i];
                            c159212.L$0 = flowCollector2;
                            c159212.L$1 = objArr;
                            c159212.I$0 = i;
                            c159212.I$1 = length;
                            c159212.label = 1;
                            if (flowCollector2.emit(obj2, c159212) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            flowCollector3 = flowCollector2;
                            i++;
                            flowCollector2 = flowCollector3;
                            if (i < length) {
                                return Unit.INSTANCE;
                            }
                        }
                    case 1:
                        length = c159212.I$1;
                        i = c159212.I$0;
                        objArr = (Object[]) c159212.L$1;
                        FlowCollector flowCollector4 = (FlowCollector) c159212.L$0;
                        ResultKt.throwOnFailure(obj);
                        flowCollector3 = flowCollector4;
                        i++;
                        flowCollector2 = flowCollector3;
                        if (i < length) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        c15921 = new C15921(continuation);
        c159212 = c15921;
        Object obj3 = c159212.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c159212.label) {
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6(Object[] objArr) {
        this.$this_asFlow$inlined = objArr;
    }
}
