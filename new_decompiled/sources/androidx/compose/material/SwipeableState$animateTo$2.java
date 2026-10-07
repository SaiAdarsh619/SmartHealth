package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.MutableState;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Swipeable.kt */
@Metadata(m286d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, m287d2 = {"<anonymous>", "", "T", "anchors", "", ""}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class SwipeableState$animateTo$2<T> implements FlowCollector<Map<Float, ? extends T>> {
    final /* synthetic */ AnimationSpec<Float> $anim;
    final /* synthetic */ T $targetValue;
    final /* synthetic */ SwipeableState<T> this$0;

    SwipeableState$animateTo$2(T t, SwipeableState<T> swipeableState, AnimationSpec<Float> animationSpec) {
        this.$targetValue = t;
        this.this$0 = swipeableState;
        this.$anim = animationSpec;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
        return emit((Map) value, (Continuation<? super Unit>) $completion);
    }

    /* JADX WARN: Failed to calculate best type for var: r8v0 androidx.compose.material.SwipeableState$animateTo$2
    jadx.core.utils.exceptions.JadxRuntimeException: Can't change type for register without SSA variable: (r8 I:androidx.compose.material.SwipeableState$animateTo$2 A[D('this' androidx.compose.material.SwipeableState$animateTo$2)])
    	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:50)
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.lambda$applyUpdates$1(TypeUpdateInfo.java:49)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
    	at java.base/java.util.stream.SortedOps$SizedRefSortingSink.end(SortedOps.java:357)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:510)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:151)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:174)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596)
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.applyUpdates(TypeUpdateInfo.java:49)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:95)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:145)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:123)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:101)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertCasts(FixTypesVisitor.java:363)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00ec: IGET (r9 I:androidx.compose.material.SwipeableState<T>) = 
      (r8 I:androidx.compose.material.SwipeableState$animateTo$2 A[D('this' androidx.compose.material.SwipeableState$animateTo$2)])
     androidx.compose.material.SwipeableState$animateTo$2.this$0 androidx.compose.material.SwipeableState, block:B:43:0x00ec */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    /* JADX WARN: Type inference failed for: r4v0, types: [int, java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.compose.material.SwipeableState, androidx.compose.material.SwipeableState<T>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Map<Float, ? extends T> map, Continuation<? super Unit> continuation) {
        SwipeableState$animateTo$2$emit$1 swipeableState$animateTo$2$emit$1;
        ?? r4;
        ?? r9;
        MutableState mutableState;
        SwipeableState$animateTo$2<T> swipeableState$animateTo$2;
        Map<Float, ? extends T> map2;
        Float offset;
        Object animateInternalToOffset;
        MutableState mutableState2;
        Object firstOrNull;
        try {
            if (continuation instanceof SwipeableState$animateTo$2$emit$1) {
                swipeableState$animateTo$2$emit$1 = (SwipeableState$animateTo$2$emit$1) continuation;
                if ((swipeableState$animateTo$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                    swipeableState$animateTo$2$emit$1.label -= Integer.MIN_VALUE;
                    Object obj = swipeableState$animateTo$2$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    r4 = swipeableState$animateTo$2$emit$1.label;
                    switch (r4) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            swipeableState$animateTo$2 = this;
                            map2 = map;
                            offset = SwipeableKt.getOffset(map2, swipeableState$animateTo$2.$targetValue);
                            if (offset == null) {
                                throw new IllegalArgumentException("The target value must have an associated anchor.".toString());
                            }
                            SwipeableState<T> swipeableState = swipeableState$animateTo$2.this$0;
                            float floatValue = offset.floatValue();
                            AnimationSpec<Float> animationSpec = swipeableState$animateTo$2.$anim;
                            swipeableState$animateTo$2$emit$1.L$0 = swipeableState$animateTo$2;
                            swipeableState$animateTo$2$emit$1.L$1 = map2;
                            swipeableState$animateTo$2$emit$1.label = 1;
                            animateInternalToOffset = swipeableState.animateInternalToOffset(floatValue, animationSpec, swipeableState$animateTo$2$emit$1);
                            if (animateInternalToOffset == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            map2 = (Map) swipeableState$animateTo$2$emit$1.L$1;
                            swipeableState$animateTo$2 = (SwipeableState$animateTo$2) swipeableState$animateTo$2$emit$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutableState2 = ((SwipeableState) swipeableState$animateTo$2.this$0).absoluteOffset;
                    float floatValue2 = ((Number) mutableState2.getValue()).floatValue();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<Float, ? extends T> entry : map2.entrySet()) {
                        if (Math.abs(entry.getKey().floatValue() - floatValue2) < 0.5f) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    firstOrNull = CollectionsKt.firstOrNull(linkedHashMap.values());
                    if (firstOrNull == null) {
                        firstOrNull = swipeableState$animateTo$2.this$0.getCurrentValue();
                    }
                    swipeableState$animateTo$2.this$0.setCurrentValue(firstOrNull);
                    return Unit.INSTANCE;
                }
            }
            switch (r4) {
            }
            mutableState2 = ((SwipeableState) swipeableState$animateTo$2.this$0).absoluteOffset;
            float floatValue22 = ((Number) mutableState2.getValue()).floatValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            while (r4.hasNext()) {
            }
            firstOrNull = CollectionsKt.firstOrNull(linkedHashMap2.values());
            if (firstOrNull == null) {
            }
            swipeableState$animateTo$2.this$0.setCurrentValue(firstOrNull);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            SwipeableState$animateTo$2 swipeableState$animateTo$22 = (SwipeableState<T>) r8.this$0;
            mutableState = ((SwipeableState) r9).absoluteOffset;
            float floatValue3 = ((Number) mutableState.getValue()).floatValue();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry2 : r4.entrySet()) {
                if (Math.abs(((Number) entry2.getKey()).floatValue() - floatValue3) < 0.5f) {
                    linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                }
            }
            Object firstOrNull2 = CollectionsKt.firstOrNull(linkedHashMap3.values());
            if (firstOrNull2 == null) {
                firstOrNull2 = swipeableState$animateTo$22.this$0.getCurrentValue();
            }
            swipeableState$animateTo$22.this$0.setCurrentValue(firstOrNull2);
            throw th;
        }
        swipeableState$animateTo$2$emit$1 = new SwipeableState$animateTo$2$emit$1(this, continuation);
        Object obj2 = swipeableState$animateTo$2$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r4 = swipeableState$animateTo$2$emit$1.label;
    }
}
