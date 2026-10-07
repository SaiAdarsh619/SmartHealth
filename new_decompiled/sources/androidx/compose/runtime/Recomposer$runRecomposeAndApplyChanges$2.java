package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Recomposer.kt */
@Metadata(m286d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", m297f = "Recomposer.kt", m298i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, m299l = {485, 503}, m300m = "invokeSuspend", m301n = {"parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete"}, m302s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: classes.dex */
final class Recomposer$runRecomposeAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeAndApplyChanges$2(Recomposer recomposer, Continuation<? super Recomposer$runRecomposeAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.this$0 = recomposer;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$2 = new Recomposer$runRecomposeAndApplyChanges$2(this.this$0, continuation);
        recomposer$runRecomposeAndApplyChanges$2.L$0 = monotonicFrameClock;
        return recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00e6 -> B:8:0x0099). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x011d -> B:7:0x0121). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$2;
        MonotonicFrameClock parentFrameClock;
        List toRecompose;
        List toApply;
        List toInsert;
        Set toLateApply;
        Set toComplete;
        Set toComplete2;
        Set toLateApply2;
        List toApply2;
        List toInsert2;
        List toRecompose2;
        Object lock$iv;
        boolean hasFrameWorkLocked;
        int i;
        boolean hasFrameWorkLocked2;
        boolean shouldKeepRecomposing;
        Object awaitWorkAvailable;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = 1;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                recomposer$runRecomposeAndApplyChanges$2 = this;
                parentFrameClock = (MonotonicFrameClock) recomposer$runRecomposeAndApplyChanges$2.L$0;
                toRecompose = new ArrayList();
                toApply = new ArrayList();
                toInsert = new ArrayList();
                toLateApply = new LinkedHashSet();
                toComplete = new LinkedHashSet();
                shouldKeepRecomposing = recomposer$runRecomposeAndApplyChanges$2.this$0.getShouldKeepRecomposing();
                if (!shouldKeepRecomposing) {
                    recomposer$runRecomposeAndApplyChanges$2.L$0 = parentFrameClock;
                    recomposer$runRecomposeAndApplyChanges$2.L$1 = toRecompose;
                    recomposer$runRecomposeAndApplyChanges$2.L$2 = toApply;
                    recomposer$runRecomposeAndApplyChanges$2.L$3 = toInsert;
                    recomposer$runRecomposeAndApplyChanges$2.L$4 = toLateApply;
                    recomposer$runRecomposeAndApplyChanges$2.L$5 = toComplete;
                    recomposer$runRecomposeAndApplyChanges$2.label = i2;
                    awaitWorkAvailable = recomposer$runRecomposeAndApplyChanges$2.this$0.awaitWorkAvailable(recomposer$runRecomposeAndApplyChanges$2);
                    if (awaitWorkAvailable == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    toRecompose2 = toRecompose;
                    toInsert2 = toApply;
                    toApply2 = toInsert;
                    toLateApply2 = toLateApply;
                    toComplete2 = toComplete;
                    lock$iv = recomposer$runRecomposeAndApplyChanges$2.this$0.stateLock;
                    Recomposer recomposer = recomposer$runRecomposeAndApplyChanges$2.this$0;
                    synchronized (lock$iv) {
                        hasFrameWorkLocked = recomposer.getHasFrameWorkLocked();
                        i = 0;
                        if (!hasFrameWorkLocked) {
                            recomposer.recordComposerModificationsLocked();
                            hasFrameWorkLocked2 = recomposer.getHasFrameWorkLocked();
                            if (!hasFrameWorkLocked2) {
                                i = i2;
                            }
                        }
                    }
                    if (i != 0) {
                        toComplete = toComplete2;
                        toLateApply = toLateApply2;
                        toRecompose = toRecompose2;
                        toApply = toInsert2;
                        toInsert = toApply2;
                        shouldKeepRecomposing = recomposer$runRecomposeAndApplyChanges$2.this$0.getShouldKeepRecomposing();
                        if (!shouldKeepRecomposing) {
                            return Unit.INSTANCE;
                        }
                    } else {
                        final Recomposer recomposer2 = recomposer$runRecomposeAndApplyChanges$2.this$0;
                        final List list = toRecompose2;
                        final List list2 = toInsert2;
                        final Set set = toLateApply2;
                        final Set toComplete3 = toComplete2;
                        final List list3 = toApply2;
                        Set toLateApply3 = toLateApply2;
                        recomposer$runRecomposeAndApplyChanges$2.L$0 = parentFrameClock;
                        recomposer$runRecomposeAndApplyChanges$2.L$1 = toRecompose2;
                        recomposer$runRecomposeAndApplyChanges$2.L$2 = toInsert2;
                        recomposer$runRecomposeAndApplyChanges$2.L$3 = toApply2;
                        recomposer$runRecomposeAndApplyChanges$2.L$4 = toLateApply3;
                        toComplete = toComplete3;
                        recomposer$runRecomposeAndApplyChanges$2.L$5 = toComplete;
                        recomposer$runRecomposeAndApplyChanges$2.label = 2;
                        if (parentFrameClock.withFrameNanos(new Function1<Long, Unit>() { // from class: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                invoke(l.longValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            /* JADX WARN: Type inference failed for: r0v78, types: [androidx.compose.runtime.Trace] */
                            /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.runtime.Trace] */
                            /* JADX WARN: Type inference failed for: r6v0 */
                            /* JADX WARN: Type inference failed for: r6v1 */
                            /* JADX WARN: Type inference failed for: r6v11 */
                            /* JADX WARN: Type inference failed for: r6v12 */
                            /* JADX WARN: Type inference failed for: r6v13 */
                            /* JADX WARN: Type inference failed for: r6v14 */
                            /* JADX WARN: Type inference failed for: r6v15 */
                            /* JADX WARN: Type inference failed for: r6v16, types: [java.lang.Object] */
                            /* JADX WARN: Type inference failed for: r6v19 */
                            /* JADX WARN: Type inference failed for: r6v2 */
                            /* JADX WARN: Type inference failed for: r6v20 */
                            /* JADX WARN: Type inference failed for: r6v21 */
                            /* JADX WARN: Type inference failed for: r6v26 */
                            /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object] */
                            /* JADX WARN: Type inference failed for: r6v4 */
                            /* JADX WARN: Type inference failed for: r6v7 */
                            /* JADX WARN: Type inference failed for: r6v8 */
                            /* JADX WARN: Type inference failed for: r6v9 */
                            public final void invoke(long j) {
                                BroadcastFrameClock broadcastFrameClock;
                                ?? r6;
                                Object obj;
                                Exception exc;
                                Collection collection;
                                List performInsertValues;
                                Collection collection2;
                                ControlledComposition performRecompose;
                                List<ControlledComposition> list4;
                                int i3;
                                BroadcastFrameClock broadcastFrameClock2;
                                broadcastFrameClock = Recomposer.this.broadcastFrameClock;
                                if (broadcastFrameClock.getHasAwaiters()) {
                                    Recomposer recomposer3 = Recomposer.this;
                                    Object beginSection = Trace.INSTANCE.beginSection("Recomposer:animation");
                                    try {
                                        broadcastFrameClock2 = recomposer3.broadcastFrameClock;
                                        long j2 = j;
                                        try {
                                            broadcastFrameClock2.sendFrame(j2);
                                            Snapshot.INSTANCE.sendApplyNotifications();
                                            Unit unit = Unit.INSTANCE;
                                            Trace.INSTANCE.endSection(beginSection);
                                            r6 = j2;
                                        } catch (Throwable th) {
                                            th = th;
                                            Trace.INSTANCE.endSection(beginSection);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } else {
                                    r6 = j;
                                }
                                String str = "Recomposer:recompose";
                                Recomposer recomposer4 = Recomposer.this;
                                List<ControlledComposition> list5 = list;
                                List<MovableContentStateReference> list6 = list2;
                                Set<ControlledComposition> set2 = set;
                                List<ControlledComposition> list7 = list3;
                                Set<ControlledComposition> set3 = toComplete3;
                                Object beginSection2 = Trace.INSTANCE.beginSection("Recomposer:recompose");
                                try {
                                    synchronized (recomposer4.stateLock) {
                                        try {
                                            try {
                                                recomposer4.recordComposerModificationsLocked();
                                                List list8 = recomposer4.compositionInvalidations;
                                                int size = list8.size();
                                                int i4 = 0;
                                                while (i4 < size) {
                                                    try {
                                                        int i5 = size;
                                                        String str2 = str;
                                                        try {
                                                            list5.add((ControlledComposition) list8.get(i4));
                                                            i4++;
                                                            size = i5;
                                                            str = str2;
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            throw th;
                                                        }
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                    }
                                                }
                                                try {
                                                    recomposer4.compositionInvalidations.clear();
                                                    Unit unit2 = Unit.INSTANCE;
                                                    try {
                                                        IdentityArraySet identityArraySet = new IdentityArraySet();
                                                        Collection identityArraySet2 = new IdentityArraySet();
                                                        while (true) {
                                                            if (!list5.isEmpty()) {
                                                                r6 = beginSection2;
                                                            } else if (list6.isEmpty()) {
                                                                break;
                                                            } else {
                                                                r6 = beginSection2;
                                                            }
                                                            List<ControlledComposition> list9 = list5;
                                                            int i6 = 0;
                                                            int i7 = 0;
                                                            try {
                                                                int size2 = list9.size();
                                                                while (i7 < size2) {
                                                                    try {
                                                                        ControlledComposition controlledComposition = list9.get(i7);
                                                                        identityArraySet2.add(controlledComposition);
                                                                        performRecompose = recomposer4.performRecompose(controlledComposition, identityArraySet);
                                                                        if (performRecompose != null) {
                                                                            list4 = list9;
                                                                            i3 = i6;
                                                                            list7.add(performRecompose);
                                                                            Unit unit3 = Unit.INSTANCE;
                                                                            Unit unit4 = Unit.INSTANCE;
                                                                        } else {
                                                                            list4 = list9;
                                                                            i3 = i6;
                                                                        }
                                                                        i7++;
                                                                        list9 = list4;
                                                                        i6 = i3;
                                                                    } catch (Exception e) {
                                                                        exc = e;
                                                                        try {
                                                                            Recomposer.processCompositionError$default(recomposer4, exc, null, true, 2, null);
                                                                            Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(list5, list6, list7, set2, set3);
                                                                            list5.clear();
                                                                            obj = r6;
                                                                            Trace.INSTANCE.endSection(obj);
                                                                            return;
                                                                        } catch (Throwable th5) {
                                                                            th = th5;
                                                                            list5.clear();
                                                                            throw th;
                                                                        }
                                                                    } catch (Throwable th6) {
                                                                        th = th6;
                                                                        list5.clear();
                                                                        throw th;
                                                                    }
                                                                }
                                                                list5.clear();
                                                                if (identityArraySet.isNotEmpty()) {
                                                                    synchronized (recomposer4.stateLock) {
                                                                        int i8 = 0;
                                                                        try {
                                                                            List list10 = recomposer4.knownCompositions;
                                                                            int i9 = 0;
                                                                            int size3 = list10.size();
                                                                            while (i9 < size3) {
                                                                                ControlledComposition controlledComposition2 = (ControlledComposition) list10.get(i9);
                                                                                int i10 = i8;
                                                                                if (identityArraySet2.contains(controlledComposition2)) {
                                                                                    collection2 = identityArraySet2;
                                                                                } else {
                                                                                    collection2 = identityArraySet2;
                                                                                    try {
                                                                                        if (controlledComposition2.observesAnyOf(identityArraySet)) {
                                                                                            list5.add(controlledComposition2);
                                                                                        }
                                                                                    } catch (Throwable th7) {
                                                                                        th = th7;
                                                                                        throw th;
                                                                                    }
                                                                                }
                                                                                i9++;
                                                                                identityArraySet2 = collection2;
                                                                                i8 = i10;
                                                                            }
                                                                            collection = identityArraySet2;
                                                                            Unit unit5 = Unit.INSTANCE;
                                                                        } catch (Throwable th8) {
                                                                            th = th8;
                                                                        }
                                                                    }
                                                                } else {
                                                                    collection = identityArraySet2;
                                                                }
                                                                if (list5.isEmpty()) {
                                                                    try {
                                                                        Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$fillToInsert(list6, recomposer4);
                                                                        while (!list6.isEmpty()) {
                                                                            performInsertValues = recomposer4.performInsertValues(list6, identityArraySet);
                                                                            CollectionsKt.addAll(set2, performInsertValues);
                                                                            Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$fillToInsert(list6, recomposer4);
                                                                        }
                                                                        beginSection2 = r6;
                                                                        identityArraySet2 = collection;
                                                                        r6 = j;
                                                                    } catch (Exception e2) {
                                                                        Recomposer.processCompositionError$default(recomposer4, e2, null, true, 2, null);
                                                                        Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(list5, list6, list7, set2, set3);
                                                                        obj = r6;
                                                                        Trace.INSTANCE.endSection(obj);
                                                                        return;
                                                                    }
                                                                } else {
                                                                    beginSection2 = r6;
                                                                    identityArraySet2 = collection;
                                                                    r6 = j;
                                                                }
                                                            } catch (Exception e3) {
                                                                exc = e3;
                                                            } catch (Throwable th9) {
                                                                th = th9;
                                                            }
                                                        }
                                                        if (list7.isEmpty()) {
                                                            r6 = beginSection2;
                                                        } else {
                                                            recomposer4.changeCount = recomposer4.getChangeCount() + 1;
                                                            try {
                                                                CollectionsKt.addAll(set3, list7);
                                                                int size4 = list7.size();
                                                                for (int i11 = 0; i11 < size4; i11++) {
                                                                    list7.get(i11).applyChanges();
                                                                }
                                                                try {
                                                                    list7.clear();
                                                                    r6 = beginSection2;
                                                                } catch (Throwable th10) {
                                                                    th = th10;
                                                                    r6 = beginSection2;
                                                                    Trace.INSTANCE.endSection(r6);
                                                                    throw th;
                                                                }
                                                            } catch (Exception e4) {
                                                                obj = beginSection2;
                                                                try {
                                                                    Recomposer.processCompositionError$default(recomposer4, e4, null, false, 6, null);
                                                                    Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(list5, list6, list7, set2, set3);
                                                                    list7.clear();
                                                                    Trace.INSTANCE.endSection(obj);
                                                                    return;
                                                                } catch (Throwable th11) {
                                                                    th = th11;
                                                                    list7.clear();
                                                                    throw th;
                                                                }
                                                            } catch (Throwable th12) {
                                                                th = th12;
                                                                list7.clear();
                                                                throw th;
                                                            }
                                                        }
                                                        if (!set2.isEmpty()) {
                                                            try {
                                                                try {
                                                                    CollectionsKt.addAll(set3, set2);
                                                                    Iterator it = set2.iterator();
                                                                    while (it.hasNext()) {
                                                                        ((ControlledComposition) it.next()).applyLateChanges();
                                                                    }
                                                                } catch (Exception e5) {
                                                                    Recomposer.processCompositionError$default(recomposer4, e5, null, false, 6, null);
                                                                    Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(list5, list6, list7, set2, set3);
                                                                    set2.clear();
                                                                    obj = r6;
                                                                    Trace.INSTANCE.endSection(obj);
                                                                    return;
                                                                }
                                                            } finally {
                                                                set2.clear();
                                                            }
                                                        }
                                                        if (!set3.isEmpty()) {
                                                            try {
                                                                try {
                                                                    Iterator it2 = set3.iterator();
                                                                    while (it2.hasNext()) {
                                                                        ((ControlledComposition) it2.next()).changesApplied();
                                                                    }
                                                                } catch (Exception e6) {
                                                                    Recomposer.processCompositionError$default(recomposer4, e6, null, false, 6, null);
                                                                    Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$clearRecompositionState(list5, list6, list7, set2, set3);
                                                                    set3.clear();
                                                                    obj = r6;
                                                                    Trace.INSTANCE.endSection(obj);
                                                                    return;
                                                                }
                                                            } finally {
                                                                set3.clear();
                                                            }
                                                        }
                                                        synchronized (recomposer4.stateLock) {
                                                            recomposer4.deriveStateLocked();
                                                        }
                                                        Trace.INSTANCE.endSection(r6);
                                                    } catch (Throwable th13) {
                                                        th = th13;
                                                        r6 = beginSection2;
                                                    }
                                                } catch (Throwable th14) {
                                                    th = th14;
                                                    throw th;
                                                }
                                            } catch (Throwable th15) {
                                                th = th15;
                                            }
                                        } catch (Throwable th16) {
                                            th = th16;
                                            Trace.INSTANCE.endSection(r6);
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th17) {
                                    th = th17;
                                    r6 = beginSection2;
                                }
                            }
                        }, recomposer$runRecomposeAndApplyChanges$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        toLateApply = toLateApply3;
                        toRecompose = toRecompose2;
                        toApply = toInsert2;
                        toInsert = toApply2;
                        recomposer$runRecomposeAndApplyChanges$2.this$0.discardUnusedValues();
                        i2 = 1;
                        shouldKeepRecomposing = recomposer$runRecomposeAndApplyChanges$2.this$0.getShouldKeepRecomposing();
                        if (!shouldKeepRecomposing) {
                        }
                    }
                }
            case 1:
                recomposer$runRecomposeAndApplyChanges$2 = this;
                Set toComplete4 = (Set) recomposer$runRecomposeAndApplyChanges$2.L$5;
                Set toLateApply4 = (Set) recomposer$runRecomposeAndApplyChanges$2.L$4;
                List toApply3 = (List) recomposer$runRecomposeAndApplyChanges$2.L$3;
                List toInsert3 = (List) recomposer$runRecomposeAndApplyChanges$2.L$2;
                List toRecompose3 = (List) recomposer$runRecomposeAndApplyChanges$2.L$1;
                MonotonicFrameClock parentFrameClock2 = (MonotonicFrameClock) recomposer$runRecomposeAndApplyChanges$2.L$0;
                ResultKt.throwOnFailure($result);
                toComplete2 = toComplete4;
                toLateApply2 = toLateApply4;
                toApply2 = toApply3;
                toInsert2 = toInsert3;
                toRecompose2 = toRecompose3;
                parentFrameClock = parentFrameClock2;
                lock$iv = recomposer$runRecomposeAndApplyChanges$2.this$0.stateLock;
                Recomposer recomposer3 = recomposer$runRecomposeAndApplyChanges$2.this$0;
                synchronized (lock$iv) {
                }
                break;
            case 2:
                recomposer$runRecomposeAndApplyChanges$2 = this;
                Set toComplete5 = (Set) recomposer$runRecomposeAndApplyChanges$2.L$5;
                Set toLateApply5 = (Set) recomposer$runRecomposeAndApplyChanges$2.L$4;
                List toApply4 = (List) recomposer$runRecomposeAndApplyChanges$2.L$3;
                List toInsert4 = (List) recomposer$runRecomposeAndApplyChanges$2.L$2;
                List toRecompose4 = (List) recomposer$runRecomposeAndApplyChanges$2.L$1;
                MonotonicFrameClock parentFrameClock3 = (MonotonicFrameClock) recomposer$runRecomposeAndApplyChanges$2.L$0;
                ResultKt.throwOnFailure($result);
                toComplete = toComplete5;
                parentFrameClock = parentFrameClock3;
                toLateApply = toLateApply5;
                toRecompose = toRecompose4;
                toInsert = toApply4;
                toApply = toInsert4;
                recomposer$runRecomposeAndApplyChanges$2.this$0.discardUnusedValues();
                i2 = 1;
                shouldKeepRecomposing = recomposer$runRecomposeAndApplyChanges$2.this$0.getShouldKeepRecomposing();
                if (!shouldKeepRecomposing) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$clearRecompositionState(List<ControlledComposition> list, List<MovableContentStateReference> list2, List<ControlledComposition> list3, Set<ControlledComposition> set, Set<ControlledComposition> set2) {
        list.clear();
        list2.clear();
        list3.clear();
        set.clear();
        set2.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> list, Recomposer this$0) {
        List $this$fastForEach$iv;
        List $this$fastForEach$iv2;
        list.clear();
        Object lock$iv = this$0.stateLock;
        synchronized (lock$iv) {
            $this$fastForEach$iv = this$0.compositionValuesAwaitingInsert;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                MovableContentStateReference it = (MovableContentStateReference) item$iv;
                list.add(it);
            }
            $this$fastForEach$iv2 = this$0.compositionValuesAwaitingInsert;
            $this$fastForEach$iv2.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
