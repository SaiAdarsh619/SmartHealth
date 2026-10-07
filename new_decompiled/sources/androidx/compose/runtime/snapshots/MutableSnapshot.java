package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
@Metadata(m286d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b \b\u0017\u0018\u00002\u00020\u0001BC\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\b\u0010.\u001a\u00020\tH\u0002J\r\u0010/\u001a\u00020\tH\u0000¢\u0006\u0002\b0J'\u0010/\u001a\u0002H1\"\u0004\b\u0000\u001012\f\u00102\u001a\b\u0012\u0004\u0012\u0002H103H\u0080\bø\u0001\u0000¢\u0006\u0004\b0\u00104J\b\u00105\u001a\u000206H\u0016J\r\u00107\u001a\u00020\tH\u0010¢\u0006\u0002\b8J\b\u00109\u001a\u00020\tH\u0016J\b\u0010:\u001a\u00020\rH\u0016J3\u0010;\u001a\u0002062\u0006\u0010<\u001a\u00020\u00032\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020?\u0018\u00010>2\u0006\u0010@\u001a\u00020\u0005H\u0000¢\u0006\u0002\bAJ\u0015\u0010B\u001a\u00020\t2\u0006\u0010C\u001a\u00020\u0001H\u0010¢\u0006\u0002\bDJ\u0015\u0010E\u001a\u00020\t2\u0006\u0010C\u001a\u00020\u0001H\u0010¢\u0006\u0002\bFJ\r\u0010G\u001a\u00020\tH\u0010¢\u0006\u0002\bHJ\u0015\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u0014H\u0010¢\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bMJ\u0015\u0010N\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u0005H\u0000¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bQJ\u0015\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020 H\u0000¢\u0006\u0002\bTJ\r\u0010U\u001a\u00020\tH\u0010¢\u0006\u0002\bVJ\r\u0010W\u001a\u00020\tH\u0000¢\u0006\u0002\bXJ8\u0010Y\u001a\u00020\u00002\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\u001e\u0010Z\u001a\u00020\u00012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\r\u0010[\u001a\u00020\tH\u0000¢\u0006\u0002\b\\J\r\u0010]\u001a\u00020\tH\u0000¢\u0006\u0002\b^R\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R4\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013@VX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u000fR\u0014\u0010)\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010&\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006_"}, m287d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "applied", "", "getApplied$runtime_release", "()Z", "setApplied$runtime_release", "(Z)V", "<set-?>", "", "Landroidx/compose/runtime/snapshots/StateObject;", "modified", "getModified$runtime_release", "()Ljava/util/Set;", "setModified", "(Ljava/util/Set;)V", "previousIds", "getPreviousIds$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setPreviousIds$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "previousPinnedSnapshots", "", "getPreviousPinnedSnapshots$runtime_release", "()[I", "setPreviousPinnedSnapshots$runtime_release", "([I)V", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "snapshots", "getWriteObserver$runtime_release", "abandon", "advance", "advance$runtime_release", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "closeLocked", "closeLocked$runtime_release", "dispose", "hasPendingChanges", "innerApplyLocked", "snapshotId", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/StateRecord;", "invalidSnapshots", "innerApplyLocked$runtime_release", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "recordPrevious", "recordPrevious$runtime_release", "recordPreviousList", "recordPreviousList$runtime_release", "recordPreviousPinnedSnapshot", "recordPreviousPinnedSnapshot$runtime_release", "recordPreviousPinnedSnapshots", "handles", "recordPreviousPinnedSnapshots$runtime_release", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "releasePreviouslyPinnedSnapshotsLocked", "releasePreviouslyPinnedSnapshotsLocked$runtime_release", "takeNestedMutableSnapshot", "takeNestedSnapshot", "validateNotApplied", "validateNotApplied$runtime_release", "validateNotAppliedOrPinned", "validateNotAppliedOrPinned$runtime_release", "runtime_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public class MutableSnapshot extends Snapshot {
    public static final int $stable = 8;
    private boolean applied;
    private Set<StateObject> modified;
    private SnapshotIdSet previousIds;
    private int[] previousPinnedSnapshots;
    private final Function1<Object, Unit> readObserver;
    private int snapshots;
    private final Function1<Object, Unit> writeObserver;

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1<Object, Unit> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableSnapshot(int id, SnapshotIdSet invalid, Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        super(id, invalid, null);
        Intrinsics.checkNotNullParameter(invalid, "invalid");
        this.readObserver = function1;
        this.writeObserver = function12;
        this.previousIds = SnapshotIdSet.INSTANCE.getEMPTY();
        this.previousPinnedSnapshots = new int[0];
        this.snapshots = 1;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        Set<StateObject> modified$runtime_release = getModified$runtime_release();
        return modified$runtime_release != null && (modified$runtime_release.isEmpty() ^ true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MutableSnapshot takeNestedMutableSnapshot$default(MutableSnapshot mutableSnapshot, Function1 function1, Function1 function12, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedMutableSnapshot");
        }
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function12 = null;
        }
        return mutableSnapshot.takeNestedMutableSnapshot(function1, function12);
    }

    public MutableSnapshot takeNestedMutableSnapshot(Function1<Object, Unit> readObserver, Function1<Object, Unit> writeObserver) {
        int newId;
        SnapshotIdSet snapshotIdSet;
        Function1 mergedWriteObserver;
        int i;
        SnapshotIdSet snapshotIdSet2;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned$runtime_release();
        recordPrevious$runtime_release(getId());
        Object lock$iv$iv = SnapshotKt.getLock();
        synchronized (lock$iv$iv) {
            try {
                newId = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = newId + 1;
                snapshotIdSet = SnapshotKt.openSnapshots;
                SnapshotKt.openSnapshots = snapshotIdSet.set(newId);
                SnapshotIdSet currentInvalid = getInvalid();
                try {
                    setInvalid$runtime_release(currentInvalid.set(newId));
                    SnapshotIdSet addRange = SnapshotKt.addRange(currentInvalid, getId() + 1, newId);
                    Function1 mergedReadObserver$default = SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver$runtime_release(), false, 4, null);
                    mergedWriteObserver = SnapshotKt.mergedWriteObserver(writeObserver, getWriteObserver$runtime_release());
                    NestedMutableSnapshot nestedMutableSnapshot = new NestedMutableSnapshot(newId, addRange, mergedReadObserver$default, mergedWriteObserver, this);
                    if (!getApplied() && !getDisposed()) {
                        int previousId$iv = getId();
                        Object lock$iv$iv$iv = SnapshotKt.getLock();
                        synchronized (lock$iv$iv$iv) {
                            i = SnapshotKt.nextSnapshotId;
                            SnapshotKt.nextSnapshotId = i + 1;
                            setId$runtime_release(i);
                            snapshotIdSet2 = SnapshotKt.openSnapshots;
                            SnapshotKt.openSnapshots = snapshotIdSet2.set(getId());
                            Unit unit = Unit.INSTANCE;
                        }
                        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), previousId$iv + 1, getId()));
                    }
                    return nestedMutableSnapshot;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x010d A[LOOP:0: B:25:0x010b->B:26:0x010d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0132 A[LOOP:1: B:32:0x0130->B:33:0x0132, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SnapshotApplyResult apply() {
        Map optimisticMerges;
        AtomicReference atomicReference;
        Function1 function1;
        Pair m294to;
        List list;
        List observers;
        Set globalModified;
        Object lock$iv$iv;
        int index$iv;
        int size;
        int index$iv2;
        int size2;
        AtomicReference atomicReference2;
        int i;
        SnapshotIdSet snapshotIdSet;
        Function1 function12;
        List list2;
        AtomicReference atomicReference3;
        SnapshotIdSet snapshotIdSet2;
        AtomicReference atomicReference4;
        Set modified = getModified$runtime_release();
        if (modified != null) {
            atomicReference3 = SnapshotKt.currentGlobalSnapshot;
            Object obj = atomicReference3.get();
            Intrinsics.checkNotNullExpressionValue(obj, "currentGlobalSnapshot.get()");
            snapshotIdSet2 = SnapshotKt.openSnapshots;
            atomicReference4 = SnapshotKt.currentGlobalSnapshot;
            optimisticMerges = SnapshotKt.optimisticMerges((MutableSnapshot) obj, this, snapshotIdSet2.clear(((GlobalSnapshot) atomicReference4.get()).getId()));
        } else {
            optimisticMerges = null;
        }
        Object lock$iv$iv2 = SnapshotKt.getLock();
        synchronized (lock$iv$iv2) {
            SnapshotKt.validateOpen(this);
            if (modified != null && modified.size() != 0) {
                atomicReference2 = SnapshotKt.currentGlobalSnapshot;
                GlobalSnapshot previousGlobalSnapshot = (GlobalSnapshot) atomicReference2.get();
                i = SnapshotKt.nextSnapshotId;
                snapshotIdSet = SnapshotKt.openSnapshots;
                SnapshotApplyResult result = innerApplyLocked$runtime_release(i, optimisticMerges, snapshotIdSet.clear(previousGlobalSnapshot.getId()));
                if (!Intrinsics.areEqual(result, SnapshotApplyResult.Success.INSTANCE)) {
                    return result;
                }
                closeLocked$runtime_release();
                Intrinsics.checkNotNullExpressionValue(previousGlobalSnapshot, "previousGlobalSnapshot");
                function12 = SnapshotKt.emptyLambda;
                SnapshotKt.takeNewGlobalSnapshot(previousGlobalSnapshot, function12);
                Set globalModified2 = previousGlobalSnapshot.getModified$runtime_release();
                setModified(null);
                previousGlobalSnapshot.setModified(null);
                list2 = SnapshotKt.applyObservers;
                m294to = TuplesKt.m294to(CollectionsKt.toMutableList((Collection) list2), globalModified2);
                observers = (List) m294to.component1();
                globalModified = (Set) m294to.component2();
                this.applied = true;
                if (globalModified != null && !globalModified.isEmpty()) {
                    size2 = observers.size();
                    for (index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                        Object item$iv = observers.get(index$iv2);
                        Function2 it = (Function2) item$iv;
                        it.invoke(globalModified, this);
                    }
                }
                if (modified != null && !modified.isEmpty()) {
                    size = observers.size();
                    for (index$iv = 0; index$iv < size; index$iv++) {
                        Object item$iv2 = observers.get(index$iv);
                        Function2 it2 = (Function2) item$iv2;
                        it2.invoke(modified, this);
                    }
                }
                lock$iv$iv = SnapshotKt.getLock();
                synchronized (lock$iv$iv) {
                    releasePinnedSnapshotsForCloseLocked$runtime_release();
                    Unit unit = Unit.INSTANCE;
                }
                return SnapshotApplyResult.Success.INSTANCE;
            }
            closeLocked$runtime_release();
            atomicReference = SnapshotKt.currentGlobalSnapshot;
            GlobalSnapshot previousGlobalSnapshot2 = (GlobalSnapshot) atomicReference.get();
            Intrinsics.checkNotNullExpressionValue(previousGlobalSnapshot2, "previousGlobalSnapshot");
            function1 = SnapshotKt.emptyLambda;
            SnapshotKt.takeNewGlobalSnapshot(previousGlobalSnapshot2, function1);
            Set globalModified3 = previousGlobalSnapshot2.getModified$runtime_release();
            if (globalModified3 != null && !globalModified3.isEmpty()) {
                list = SnapshotKt.applyObservers;
                m294to = TuplesKt.m294to(CollectionsKt.toMutableList((Collection) list), globalModified3);
            } else {
                m294to = TuplesKt.m294to(CollectionsKt.emptyList(), null);
            }
            observers = (List) m294to.component1();
            globalModified = (Set) m294to.component2();
            this.applied = true;
            if (globalModified != null) {
                size2 = observers.size();
                while (index$iv2 < size2) {
                }
            }
            if (modified != null) {
                size = observers.size();
                while (index$iv < size) {
                }
            }
            lock$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv) {
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot getRoot() {
        return this;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (!getDisposed()) {
            super.dispose();
            mo1654nestedDeactivated$runtime_release(this);
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(Function1<Object, Unit> readObserver) {
        int readonlyId;
        SnapshotIdSet snapshotIdSet;
        NestedReadonlySnapshot nestedReadonlySnapshot;
        int i;
        SnapshotIdSet snapshotIdSet2;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned$runtime_release();
        int previousId = getId();
        recordPrevious$runtime_release(getId());
        Object lock$iv$iv = SnapshotKt.getLock();
        synchronized (lock$iv$iv) {
            readonlyId = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = readonlyId + 1;
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(readonlyId);
            nestedReadonlySnapshot = new NestedReadonlySnapshot(readonlyId, SnapshotKt.addRange(getInvalid(), previousId + 1, readonlyId), readObserver, this);
        }
        if (!getApplied() && !getDisposed()) {
            int previousId$iv = getId();
            Object lock$iv$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv$iv) {
                i = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i + 1;
                setId$runtime_release(i);
                snapshotIdSet2 = SnapshotKt.openSnapshots;
                SnapshotKt.openSnapshots = snapshotIdSet2.set(getId());
                Unit unit = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), previousId$iv + 1, getId()));
        }
        return nestedReadonlySnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedActivated$runtime_release */
    public void mo1653nestedActivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedDeactivated$runtime_release */
    public void mo1654nestedDeactivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        if (!(this.snapshots > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this.snapshots--;
        if (this.snapshots == 0 && !this.applied) {
            abandon();
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        if (this.applied || getDisposed()) {
            return;
        }
        advance$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void closeLocked$runtime_release() {
        SnapshotIdSet snapshotIdSet;
        snapshotIdSet = SnapshotKt.openSnapshots;
        SnapshotKt.openSnapshots = snapshotIdSet.clear(getId()).andNot(this.previousIds);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePreviouslyPinnedSnapshotsLocked$runtime_release();
        super.releasePinnedSnapshotsForCloseLocked$runtime_release();
    }

    public final void validateNotApplied$runtime_release() {
        if (this.applied) {
            throw new IllegalStateException("Unsupported operation on a snapshot that has been applied".toString());
        }
    }

    public final void validateNotAppliedOrPinned$runtime_release() {
        boolean z = true;
        if (this.applied) {
            MutableSnapshot this_$iv = this;
            Snapshot this_$iv2 = ((Snapshot) this_$iv).pinningTrackingHandle >= 0 ? 1 : null;
            if (this_$iv2 == null) {
                z = false;
            }
        }
        if (!z) {
            throw new IllegalStateException("Unsupported operation on a disposed or applied snapshot".toString());
        }
    }

    private final void abandon() {
        Set modified = getModified$runtime_release();
        if (modified != null) {
            validateNotApplied$runtime_release();
            setModified(null);
            int id = getId();
            for (StateObject state : modified) {
                for (StateRecord current = state.getFirstStateRecord(); current != null; current = current.getNext()) {
                    if (current.getSnapshotId() == id || CollectionsKt.contains(this.previousIds, Integer.valueOf(current.getSnapshotId()))) {
                        current.setSnapshotId$runtime_release(0);
                    }
                }
            }
        }
        closeAndReleasePinning$runtime_release();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0047, code lost:
    
        r12 = androidx.compose.runtime.snapshots.SnapshotKt.readable(r9, getId(), r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SnapshotApplyResult innerApplyLocked$runtime_release(int snapshotId, Map<StateRecord, ? extends StateRecord> optimisticMerges, SnapshotIdSet invalidSnapshots) {
        StateRecord current;
        StateRecord previous;
        StateRecord applied;
        StateRecord merged;
        List list;
        List list2;
        List list3;
        MutableSnapshot mutableSnapshot = this;
        Intrinsics.checkNotNullParameter(invalidSnapshots, "invalidSnapshots");
        SnapshotIdSet start = getInvalid().set(getId()).m10or(mutableSnapshot.previousIds);
        Set modified = getModified$runtime_release();
        Intrinsics.checkNotNull(modified);
        List it = null;
        List list4 = null;
        for (StateObject state : modified) {
            StateRecord first = state.getFirstStateRecord();
            current = SnapshotKt.readable(first, snapshotId, invalidSnapshots);
            if (current != null && previous != null && !Intrinsics.areEqual(current, previous)) {
                applied = SnapshotKt.readable(first, getId(), getInvalid());
                if (applied == null) {
                    SnapshotKt.readError();
                    throw new KotlinNothingValueException();
                }
                if (optimisticMerges == null || (merged = optimisticMerges.get(current)) == null) {
                    merged = state.mergeRecords(previous, current, applied);
                }
                if (merged == null) {
                    return new SnapshotApplyResult.Failure(mutableSnapshot);
                }
                if (!Intrinsics.areEqual(merged, applied)) {
                    if (Intrinsics.areEqual(merged, current)) {
                        if (list4 == null) {
                            List it2 = new ArrayList();
                            list = it2;
                            list4 = it2;
                        } else {
                            list = list4;
                        }
                        list4.add(TuplesKt.m294to(state, current.create()));
                        if (it == null) {
                            List it3 = new ArrayList();
                            it = it3;
                            list2 = it3;
                        } else {
                            list2 = it;
                        }
                        it.add(state);
                        it = list2;
                        list4 = list;
                        mutableSnapshot = this;
                    } else {
                        if (list4 == null) {
                            List it4 = new ArrayList();
                            list4 = it4;
                            list3 = it4;
                        } else {
                            list3 = list4;
                        }
                        list4.add(!Intrinsics.areEqual(merged, previous) ? TuplesKt.m294to(state, merged) : TuplesKt.m294to(state, previous.create()));
                        list4 = list3;
                        mutableSnapshot = this;
                    }
                }
            }
            mutableSnapshot = this;
        }
        if (list4 != null) {
            List it5 = list4;
            advance$runtime_release();
            int size = it5.size();
            int index$iv = 0;
            while (index$iv < size) {
                Object item$iv = it5.get(index$iv);
                Pair merged2 = (Pair) item$iv;
                List it6 = it5;
                StateObject state2 = (StateObject) merged2.component1();
                StateRecord stateRecord = (StateRecord) merged2.component2();
                stateRecord.setSnapshotId$runtime_release(getId());
                Object lock$iv$iv = SnapshotKt.getLock();
                synchronized (lock$iv$iv) {
                    stateRecord.setNext$runtime_release(state2.getFirstStateRecord());
                    state2.prependStateRecord(stateRecord);
                    Unit unit = Unit.INSTANCE;
                }
                index$iv++;
                it5 = it6;
            }
        }
        if (it != null) {
            modified.removeAll(it);
        }
        return SnapshotApplyResult.Success.INSTANCE;
    }

    public final <T> T advance$runtime_release(Function0<? extends T> block) {
        int i;
        SnapshotIdSet snapshotIdSet;
        Intrinsics.checkNotNullParameter(block, "block");
        recordPrevious$runtime_release(getId());
        T invoke = block.invoke();
        if (!getApplied() && !getDisposed()) {
            int previousId = getId();
            Object lock$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv) {
                try {
                    i = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = i + 1;
                    setId$runtime_release(i);
                    snapshotIdSet = SnapshotKt.openSnapshots;
                    SnapshotKt.openSnapshots = snapshotIdSet.set(getId());
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), previousId + 1, getId()));
        }
        return invoke;
    }

    public final void advance$runtime_release() {
        int i;
        SnapshotIdSet snapshotIdSet;
        recordPrevious$runtime_release(getId());
        Unit unit = Unit.INSTANCE;
        if (getApplied() || getDisposed()) {
            return;
        }
        int previousId$iv = getId();
        Object lock$iv$iv$iv = SnapshotKt.getLock();
        synchronized (lock$iv$iv$iv) {
            i = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i + 1;
            setId$runtime_release(i);
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(getId());
            Unit unit2 = Unit.INSTANCE;
        }
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), previousId$iv + 1, getId()));
    }

    public final void recordPrevious$runtime_release(int id) {
        Object lock$iv$iv = SnapshotKt.getLock();
        synchronized (lock$iv$iv) {
            this.previousIds = this.previousIds.set(id);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousPinnedSnapshot$runtime_release(int id) {
        if (id >= 0) {
            this.previousPinnedSnapshots = ArraysKt.plus(this.previousPinnedSnapshots, id);
        }
    }

    public final void recordPreviousPinnedSnapshots$runtime_release(int[] handles) {
        Intrinsics.checkNotNullParameter(handles, "handles");
        if (handles.length == 0) {
            return;
        }
        int[] pinned = this.previousPinnedSnapshots;
        if (!(pinned.length == 0)) {
            this.previousPinnedSnapshots = ArraysKt.plus(pinned, handles);
        } else {
            this.previousPinnedSnapshots = handles;
        }
    }

    public final void releasePreviouslyPinnedSnapshotsLocked$runtime_release() {
        int length = this.previousPinnedSnapshots.length;
        for (int index = 0; index < length; index++) {
            SnapshotKt.releasePinningLocked(this.previousPinnedSnapshots[index]);
        }
    }

    public final void recordPreviousList$runtime_release(SnapshotIdSet snapshots) {
        Intrinsics.checkNotNullParameter(snapshots, "snapshots");
        Object lock$iv$iv = SnapshotKt.getLock();
        synchronized (lock$iv$iv) {
            this.previousIds = this.previousIds.m10or(snapshots);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: recordModified$runtime_release */
    public void mo1655recordModified$runtime_release(StateObject state) {
        Intrinsics.checkNotNullParameter(state, "state");
        HashSet modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release == null) {
            HashSet it = new HashSet();
            setModified(it);
            modified$runtime_release = it;
        }
        modified$runtime_release.add(state);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Set<StateObject> getModified$runtime_release() {
        return this.modified;
    }

    public void setModified(Set<StateObject> set) {
        this.modified = set;
    }

    /* renamed from: getPreviousIds$runtime_release, reason: from getter */
    public final SnapshotIdSet getPreviousIds() {
        return this.previousIds;
    }

    public final void setPreviousIds$runtime_release(SnapshotIdSet snapshotIdSet) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "<set-?>");
        this.previousIds = snapshotIdSet;
    }

    /* renamed from: getPreviousPinnedSnapshots$runtime_release, reason: from getter */
    public final int[] getPreviousPinnedSnapshots() {
        return this.previousPinnedSnapshots;
    }

    public final void setPreviousPinnedSnapshots$runtime_release(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.previousPinnedSnapshots = iArr;
    }

    /* renamed from: getApplied$runtime_release, reason: from getter */
    public final boolean getApplied() {
        return this.applied;
    }

    public final void setApplied$runtime_release(boolean z) {
        this.applied = z;
    }
}
