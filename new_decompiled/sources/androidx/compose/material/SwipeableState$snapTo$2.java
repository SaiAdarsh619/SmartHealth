package androidx.compose.material;

import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Swipeable.kt */
@Metadata(m286d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, m287d2 = {"<anonymous>", "", "T", "anchors", "", ""}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class SwipeableState$snapTo$2<T> implements FlowCollector<Map<Float, ? extends T>> {
    final /* synthetic */ T $targetValue;
    final /* synthetic */ SwipeableState<T> this$0;

    SwipeableState$snapTo$2(T t, SwipeableState<T> swipeableState) {
        this.$targetValue = t;
        this.this$0 = swipeableState;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
        return emit((Map) value, (Continuation<? super Unit>) $completion);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Map<Float, ? extends T> map, Continuation<? super Unit> continuation) {
        SwipeableState$snapTo$2$emit$1 swipeableState$snapTo$2$emit$1;
        SwipeableState$snapTo$2$emit$1 swipeableState$snapTo$2$emit$12;
        Float targetOffset;
        Object snapInternalToOffset;
        SwipeableState$snapTo$2 swipeableState$snapTo$2;
        if (continuation instanceof SwipeableState$snapTo$2$emit$1) {
            swipeableState$snapTo$2$emit$1 = (SwipeableState$snapTo$2$emit$1) continuation;
            if ((swipeableState$snapTo$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                swipeableState$snapTo$2$emit$1.label -= Integer.MIN_VALUE;
                swipeableState$snapTo$2$emit$12 = swipeableState$snapTo$2$emit$1;
                Object $result = swipeableState$snapTo$2$emit$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (swipeableState$snapTo$2$emit$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        targetOffset = SwipeableKt.getOffset(map, this.$targetValue);
                        if (targetOffset == null) {
                            throw new IllegalArgumentException("The target value must have an associated anchor.".toString());
                        }
                        SwipeableState<T> swipeableState = this.this$0;
                        float floatValue = targetOffset.floatValue();
                        swipeableState$snapTo$2$emit$12.L$0 = this;
                        swipeableState$snapTo$2$emit$12.label = 1;
                        snapInternalToOffset = swipeableState.snapInternalToOffset(floatValue, swipeableState$snapTo$2$emit$12);
                        if (snapInternalToOffset == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        swipeableState$snapTo$2 = this;
                        break;
                    case 1:
                        swipeableState$snapTo$2 = (SwipeableState$snapTo$2) swipeableState$snapTo$2$emit$12.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                swipeableState$snapTo$2.this$0.setCurrentValue(swipeableState$snapTo$2.$targetValue);
                return Unit.INSTANCE;
            }
        }
        swipeableState$snapTo$2$emit$1 = new SwipeableState$snapTo$2$emit$1(this, continuation);
        swipeableState$snapTo$2$emit$12 = swipeableState$snapTo$2$emit$1;
        Object $result2 = swipeableState$snapTo$2$emit$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (swipeableState$snapTo$2$emit$12.label) {
        }
        swipeableState$snapTo$2.this$0.setCurrentValue(swipeableState$snapTo$2.$targetValue);
        return Unit.INSTANCE;
    }
}
