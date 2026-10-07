package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SnapshotFlow.kt */
@Metadata(m286d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, m287d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1", m297f = "SnapshotFlow.kt", m298i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, m299l = {134, 138, 160}, m300m = "invokeSuspend", m301n = {"$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "found", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue"}, m302s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: classes.dex */
final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T> $block;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(Function0<? extends T> function0, Continuation<? super SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1> continuation) {
        super(2, continuation);
        this.$block = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1 snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = new SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(this.$block, continuation);
        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = obj;
        return snapshotStateKt__SnapshotFlowKt$snapshotFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return ((SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e6, code lost:
    
        r4 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r12;
        r3 = 1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0101 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0112 A[Catch: all -> 0x0199, TryCatch #4 {all -> 0x0199, blocks: (B:15:0x010d, B:17:0x0112, B:21:0x011c, B:26:0x012b, B:35:0x014c, B:37:0x0158, B:49:0x0188, B:50:0x018b, B:29:0x013a, B:34:0x0147, B:45:0x0183, B:46:0x0186, B:32:0x0141), top: B:14:0x010d, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0196 A[LOOP:0: B:16:0x0110->B:23:0x0196, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0129 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v3, types: [kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0172 -> B:9:0x017c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ObserverHandle observerHandle;
        SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1<T> snapshotStateKt__SnapshotFlowKt$snapshotFlow$1;
        Object obj2;
        ?? r10;
        final LinkedHashSet linkedHashSet;
        Function1<Object, Unit> function1;
        final Channel Channel$default;
        Object obj3;
        Object obj4;
        Object obj5;
        ObserverHandle observerHandle2;
        Channel channel;
        Function1<Object, Unit> function12;
        Set set;
        FlowCollector flowCollector;
        int i;
        Object obj6;
        Set set2;
        int i2;
        Snapshot takeSnapshot;
        Snapshot makeCurrent;
        boolean intersects$SnapshotStateKt__SnapshotFlowKt;
        Object receive;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = 1;
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = this;
                    obj2 = obj;
                    r10 = (FlowCollector) snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0;
                    linkedHashSet = new LinkedHashSet();
                    function1 = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                            invoke2(p1);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Object it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            linkedHashSet.add(it);
                        }
                    };
                    Channel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
                    observerHandle = Snapshot.INSTANCE.registerApplyObserver(new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set3, Snapshot snapshot) {
                            invoke2(set3, snapshot);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Set<? extends Object> changed, Snapshot snapshot) {
                            Intrinsics.checkNotNullParameter(changed, "changed");
                            Intrinsics.checkNotNullParameter(snapshot, "<anonymous parameter 1>");
                            Channel$default.mo6233trySendJP2dKIU(changed);
                        }
                    });
                    Snapshot takeSnapshot2 = Snapshot.INSTANCE.takeSnapshot(function1);
                    Function0<T> function0 = snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.$block;
                    try {
                        Snapshot makeCurrent2 = takeSnapshot2.makeCurrent();
                        try {
                            T invoke = function0.invoke();
                            takeSnapshot2.restoreCurrent(makeCurrent2);
                            takeSnapshot2.dispose();
                            obj3 = invoke;
                            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = r10;
                            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$1 = linkedHashSet;
                            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$2 = function1;
                            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$3 = Channel$default;
                            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$4 = observerHandle;
                            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$5 = obj3;
                            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.label = 1;
                            if (r10.emit(obj3, snapshotStateKt__SnapshotFlowKt$snapshotFlow$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            i = 0;
                            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = r10;
                            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$1 = linkedHashSet;
                            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$2 = function1;
                            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$3 = Channel$default;
                            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$4 = observerHandle;
                            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$5 = obj3;
                            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.I$0 = 0;
                            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.label = 2;
                            receive = Channel$default.receive(snapshotStateKt__SnapshotFlowKt$snapshotFlow$1);
                            if (receive == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Object obj7 = obj3;
                            obj6 = obj2;
                            obj4 = receive;
                            flowCollector = r10;
                            set = linkedHashSet;
                            function12 = function1;
                            channel = Channel$default;
                            observerHandle2 = observerHandle;
                            obj5 = obj7;
                            try {
                                set2 = (Set) obj4;
                                while (true) {
                                    if (i == 0) {
                                        intersects$SnapshotStateKt__SnapshotFlowKt = SnapshotStateKt__SnapshotFlowKt.intersects$SnapshotStateKt__SnapshotFlowKt(set, set2);
                                        if (!intersects$SnapshotStateKt__SnapshotFlowKt) {
                                            i2 = 0;
                                            i = i2;
                                            set2 = (Set) ChannelResult.m6248getOrNullimpl(channel.mo6238tryReceivePtdJZtk());
                                            if (set2 != null) {
                                                i3 = 1;
                                            } else {
                                                if (i != 0) {
                                                    try {
                                                        try {
                                                            set.clear();
                                                            takeSnapshot = Snapshot.INSTANCE.takeSnapshot(function12);
                                                            Function0<T> function02 = snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.$block;
                                                            makeCurrent = takeSnapshot.makeCurrent();
                                                            T invoke2 = function02.invoke();
                                                            takeSnapshot.dispose();
                                                            if (!Intrinsics.areEqual(invoke2, obj5)) {
                                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = flowCollector;
                                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$1 = set;
                                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$2 = function12;
                                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$3 = channel;
                                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$4 = observerHandle2;
                                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$5 = invoke2;
                                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.label = 3;
                                                                if (flowCollector.emit(invoke2, snapshotStateKt__SnapshotFlowKt$snapshotFlow$1) == coroutine_suspended) {
                                                                    return coroutine_suspended;
                                                                }
                                                                observerHandle = observerHandle2;
                                                                Channel$default = channel;
                                                                function1 = function12;
                                                                linkedHashSet = set;
                                                                r10 = flowCollector;
                                                                Object obj8 = obj6;
                                                                obj3 = invoke2;
                                                                obj2 = obj8;
                                                                i3 = 1;
                                                                i = 0;
                                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = r10;
                                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$1 = linkedHashSet;
                                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$2 = function1;
                                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$3 = Channel$default;
                                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$4 = observerHandle;
                                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$5 = obj3;
                                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.I$0 = 0;
                                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.label = 2;
                                                                receive = Channel$default.receive(snapshotStateKt__SnapshotFlowKt$snapshotFlow$1);
                                                                if (receive == coroutine_suspended) {
                                                                }
                                                            }
                                                        } finally {
                                                        }
                                                    } finally {
                                                        takeSnapshot.restoreCurrent(makeCurrent);
                                                    }
                                                }
                                                obj2 = obj6;
                                                obj3 = obj5;
                                                observerHandle = observerHandle2;
                                                Channel$default = channel;
                                                function1 = function12;
                                                linkedHashSet = set;
                                                r10 = flowCollector;
                                                i3 = 1;
                                                i = 0;
                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = r10;
                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$1 = linkedHashSet;
                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$2 = function1;
                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$3 = Channel$default;
                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$4 = observerHandle;
                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$5 = obj3;
                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.I$0 = 0;
                                                snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.label = 2;
                                                receive = Channel$default.receive(snapshotStateKt__SnapshotFlowKt$snapshotFlow$1);
                                                if (receive == coroutine_suspended) {
                                                }
                                            }
                                        }
                                    }
                                    i2 = i3;
                                    i = i2;
                                    set2 = (Set) ChannelResult.m6248getOrNullimpl(channel.mo6238tryReceivePtdJZtk());
                                    if (set2 != null) {
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                observerHandle = observerHandle2;
                                observerHandle.dispose();
                                throw th;
                            }
                        } finally {
                            takeSnapshot2.restoreCurrent(makeCurrent2);
                        }
                    } finally {
                    }
                    break;
                case 1:
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = this;
                    obj2 = obj;
                    obj3 = snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$5;
                    observerHandle = (ObserverHandle) snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$4;
                    Channel$default = (Channel) snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$3;
                    function1 = (Function1) snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$2;
                    linkedHashSet = (Set) snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$1;
                    r10 = (FlowCollector) snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    i = 0;
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = r10;
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$1 = linkedHashSet;
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$2 = function1;
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$3 = Channel$default;
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$4 = observerHandle;
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$5 = obj3;
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.I$0 = 0;
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.label = 2;
                    receive = Channel$default.receive(snapshotStateKt__SnapshotFlowKt$snapshotFlow$1);
                    if (receive == coroutine_suspended) {
                    }
                    break;
                case 2:
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = this;
                    obj4 = obj;
                    int i4 = snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.I$0;
                    obj5 = snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$5;
                    observerHandle2 = (ObserverHandle) snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$4;
                    channel = (Channel) snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$3;
                    function12 = (Function1) snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$2;
                    set = (Set) snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$1;
                    FlowCollector flowCollector2 = (FlowCollector) snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj4);
                        flowCollector = flowCollector2;
                        i = i4;
                        obj6 = obj4;
                        set2 = (Set) obj4;
                        while (true) {
                            if (i == 0) {
                            }
                            i2 = i3;
                            i = i2;
                            set2 = (Set) ChannelResult.m6248getOrNullimpl(channel.mo6238tryReceivePtdJZtk());
                            if (set2 != null) {
                            }
                            i3 = 1;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        observerHandle = observerHandle2;
                        observerHandle.dispose();
                        throw th;
                    }
                    break;
                case 3:
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = this;
                    obj2 = obj;
                    obj3 = snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$5;
                    observerHandle = (ObserverHandle) snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$4;
                    Channel$default = (Channel) snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$3;
                    function1 = (Function1) snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$2;
                    linkedHashSet = (Set) snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$1;
                    FlowCollector flowCollector3 = (FlowCollector) snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    r10 = flowCollector3;
                    i3 = 1;
                    i = 0;
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = r10;
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$1 = linkedHashSet;
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$2 = function1;
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$3 = Channel$default;
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$4 = observerHandle;
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$5 = obj3;
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.I$0 = 0;
                    snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.label = 2;
                    receive = Channel$default.receive(snapshotStateKt__SnapshotFlowKt$snapshotFlow$1);
                    if (receive == coroutine_suspended) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th3) {
            th = th3;
            observerHandle.dispose();
            throw th;
        }
    }
}
