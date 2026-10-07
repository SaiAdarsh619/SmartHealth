package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DerivedState.kt */
@Metadata(m286d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001+B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!J:\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010$\u001a\u00020%2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J\b\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010*\u001a\u00020'H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u0004\u0018\u00018\u00008G¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000b¨\u0006,"}, m287d2 = {"Landroidx/compose/runtime/DerivedSnapshotState;", "T", "Landroidx/compose/runtime/snapshots/StateObject;", "Landroidx/compose/runtime/DerivedState;", "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "()V", "getDebuggerDisplayValue", "dependencies", "", "", "getDependencies", "()[Ljava/lang/Object;", "first", "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "value", "getValue", "current", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "currentRecord", "readable", "forceDependencyReads", "", "displayValue", "", "prependStateRecord", "", "toString", "ResultRecord", "runtime_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* renamed from: androidx.compose.runtime.DerivedSnapshotState, reason: from toString */
/* loaded from: classes.dex */
final class DerivedState<T> implements StateObject, androidx.compose.runtime.DerivedState<T> {
    private final Function0<T> calculation;
    private ResultRecord<T> first;
    private final SnapshotMutationPolicy<T> policy;

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DerivedState(Function0<? extends T> calculation, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        this.calculation = calculation;
        this.policy = snapshotMutationPolicy;
        this.first = new ResultRecord<>();
    }

    @Override // androidx.compose.runtime.DerivedState
    public SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    /* compiled from: DerivedState.kt */
    @Metadata(m286d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \"*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0001\"B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\u001f\u001a\u00020 J\u001a\u0010!\u001a\u00020\u00072\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\u001f\u001a\u00020 R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006#"}, m287d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "()V", "dependencies", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/snapshots/StateObject;", "", "getDependencies", "()Landroidx/compose/runtime/collection/IdentityArrayMap;", "setDependencies", "(Landroidx/compose/runtime/collection/IdentityArrayMap;)V", "result", "", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "resultHash", "getResultHash", "()I", "setResultHash", "(I)V", "assign", "", "value", "create", "isValid", "", "derivedState", "Landroidx/compose/runtime/DerivedState;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readableHash", "Companion", "runtime_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    /* renamed from: androidx.compose.runtime.DerivedSnapshotState$ResultRecord */
    public static final class ResultRecord<T> extends StateRecord {
        private IdentityArrayMap<StateObject, Integer> dependencies;
        private Object result = Unset;
        private int resultHash;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;
        private static final Object Unset = new Object();

        /* compiled from: DerivedState.kt */
        @Metadata(m286d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m287d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord$Companion;", "", "()V", "Unset", "getUnset", "()Ljava/lang/Object;", "runtime_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
        /* renamed from: androidx.compose.runtime.DerivedSnapshotState$ResultRecord$Companion, reason: from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Object getUnset() {
                return ResultRecord.Unset;
            }
        }

        public final IdentityArrayMap<StateObject, Integer> getDependencies() {
            return this.dependencies;
        }

        public final void setDependencies(IdentityArrayMap<StateObject, Integer> identityArrayMap) {
            this.dependencies = identityArrayMap;
        }

        public final Object getResult() {
            return this.result;
        }

        public final void setResult(Object obj) {
            this.result = obj;
        }

        public final int getResultHash() {
            return this.resultHash;
        }

        public final void setResultHash(int i) {
            this.resultHash = i;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ResultRecord other = (ResultRecord) value;
            this.dependencies = other.dependencies;
            this.result = other.result;
            this.resultHash = other.resultHash;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new ResultRecord();
        }

        public final boolean isValid(androidx.compose.runtime.DerivedState<?> derivedState, Snapshot snapshot) {
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            return this.result != Unset && this.resultHash == readableHash(derivedState, snapshot);
        }

        public final int readableHash(androidx.compose.runtime.DerivedState<?> derivedState, Snapshot snapshot) {
            IdentityArrayMap dependencies;
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            int hash = 7;
            Object lock$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv) {
                dependencies = this.dependencies;
            }
            if (dependencies != null) {
                MutableVector this_$iv$iv = (MutableVector) SnapshotStateKt__DerivedStateKt.derivedStateObservers.get();
                if (this_$iv$iv == null) {
                    this_$iv$iv = new MutableVector(new Pair[0], 0);
                }
                MutableVector observers$iv = this_$iv$iv;
                int size$iv$iv = this_$iv$iv.getSize();
                int i = 1;
                if (size$iv$iv > 0) {
                    int i$iv$iv = 0;
                    Object[] content$iv$iv = this_$iv$iv.getContent();
                    Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                    do {
                        Function1 start$iv = (Function1) ((Pair) content$iv$iv[i$iv$iv]).component1();
                        start$iv.invoke(derivedState);
                        i$iv$iv++;
                    } while (i$iv$iv < size$iv$iv);
                }
                int index$iv = 0;
                try {
                    int size = dependencies.getSize();
                    while (index$iv < size) {
                        Object obj = dependencies.getKeys()[index$iv];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                        int readLevel = ((Number) dependencies.getValues()[index$iv]).intValue();
                        StateObject stateObject = (StateObject) obj;
                        if (readLevel == i) {
                            StateRecord record = stateObject instanceof DerivedState ? ((DerivedState) stateObject).current(snapshot) : SnapshotKt.current(stateObject.getFirstStateRecord(), snapshot);
                            hash = (((hash * 31) + ActualJvm_jvmKt.identityHashCode(record)) * 31) + record.getSnapshotId();
                        }
                        index$iv++;
                        i = 1;
                    }
                    Unit unit = Unit.INSTANCE;
                    int size$iv$iv2 = observers$iv.getSize();
                    if (size$iv$iv2 > 0) {
                        int i$iv$iv2 = 0;
                        Object[] content$iv$iv2 = observers$iv.getContent();
                        Intrinsics.checkNotNull(content$iv$iv2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                        do {
                            Function1 done$iv = (Function1) ((Pair) content$iv$iv2[i$iv$iv2]).component2();
                            done$iv.invoke(derivedState);
                            i$iv$iv2++;
                        } while (i$iv$iv2 < size$iv$iv2);
                    }
                } catch (Throwable th) {
                    int size$iv$iv3 = observers$iv.getSize();
                    if (size$iv$iv3 > 0) {
                        int i$iv$iv3 = 0;
                        Object[] content$iv$iv3 = observers$iv.getContent();
                        Intrinsics.checkNotNull(content$iv$iv3, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                        do {
                            Function1 done$iv2 = (Function1) ((Pair) content$iv$iv3[i$iv$iv3]).component2();
                            done$iv2.invoke(derivedState);
                            i$iv$iv3++;
                        } while (i$iv$iv3 < size$iv$iv3);
                    }
                    throw th;
                }
            }
            return hash;
        }
    }

    public final StateRecord current(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshot), snapshot, false, this.calculation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ResultRecord<T> currentRecord(ResultRecord<T> readable, Snapshot snapshot, boolean forceDependencyReads, Function0<? extends T> calculation) {
        SnapshotThreadLocal snapshotThreadLocal;
        SnapshotThreadLocal snapshotThreadLocal2;
        SnapshotThreadLocal snapshotThreadLocal3;
        ResultRecord<T> resultRecord;
        SnapshotThreadLocal snapshotThreadLocal4;
        SnapshotThreadLocal snapshotThreadLocal5;
        SnapshotThreadLocal snapshotThreadLocal6;
        if (readable.isValid(this, snapshot)) {
            if (forceDependencyReads) {
                MutableVector mutableVector = (MutableVector) SnapshotStateKt__DerivedStateKt.derivedStateObservers.get();
                if (mutableVector == null) {
                    mutableVector = new MutableVector(new Pair[0], 0);
                }
                MutableVector mutableVector2 = mutableVector;
                int size = mutableVector.getSize();
                if (size > 0) {
                    int i = 0;
                    Object[] content = mutableVector.getContent();
                    Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                    do {
                        ((Function1) ((Pair) content[i]).component1()).invoke(this);
                        i++;
                    } while (i < size);
                }
                int i2 = 0;
                try {
                    IdentityArrayMap<StateObject, Integer> dependencies = readable.getDependencies();
                    snapshotThreadLocal4 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                    Integer num = (Integer) snapshotThreadLocal4.get();
                    int intValue = num != null ? num.intValue() : 0;
                    if (dependencies != null) {
                        int i3 = 0;
                        int size2 = dependencies.getSize();
                        while (i3 < size2) {
                            Object obj = dependencies.getKeys()[i3];
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                            int intValue2 = ((Number) dependencies.getValues()[i3]).intValue();
                            StateObject stateObject = (StateObject) obj;
                            snapshotThreadLocal6 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                            int i4 = i2;
                            snapshotThreadLocal6.set(Integer.valueOf(intValue2 + intValue));
                            Function1<Object, Unit> readObserver$runtime_release = snapshot.getReadObserver$runtime_release();
                            if (readObserver$runtime_release != null) {
                                readObserver$runtime_release.invoke(stateObject);
                            }
                            i3++;
                            i2 = i4;
                        }
                    }
                    snapshotThreadLocal5 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                    snapshotThreadLocal5.set(Integer.valueOf(intValue));
                    Unit unit = Unit.INSTANCE;
                    int size3 = mutableVector2.getSize();
                    if (size3 > 0) {
                        int i5 = 0;
                        Object[] content2 = mutableVector2.getContent();
                        Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                        do {
                            ((Function1) ((Pair) content2[i5]).component2()).invoke(this);
                            i5++;
                        } while (i5 < size3);
                    }
                } finally {
                    int size4 = mutableVector2.getSize();
                    if (size4 > 0) {
                        int i6 = 0;
                        Object[] content3 = mutableVector2.getContent();
                        Intrinsics.checkNotNull(content3, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                        do {
                            ((Function1) ((Pair) content3[i6]).component2()).invoke(this);
                            i6++;
                        } while (i6 < size4);
                    }
                }
            }
            return readable;
        }
        snapshotThreadLocal = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
        Integer num2 = (Integer) snapshotThreadLocal.get();
        final int intValue3 = num2 != null ? num2.intValue() : 0;
        final IdentityArrayMap<StateObject, Integer> identityArrayMap = new IdentityArrayMap<>(0, 1, null);
        MutableVector mutableVector3 = (MutableVector) SnapshotStateKt__DerivedStateKt.derivedStateObservers.get();
        if (mutableVector3 == null) {
            mutableVector3 = new MutableVector(new Pair[0], 0);
        }
        MutableVector mutableVector4 = mutableVector3;
        int size5 = mutableVector3.getSize();
        if (size5 > 0) {
            int i7 = 0;
            Object[] content4 = mutableVector3.getContent();
            Intrinsics.checkNotNull(content4, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                ((Function1) ((Pair) content4[i7]).component1()).invoke(this);
                i7++;
            } while (i7 < size5);
        }
        try {
            snapshotThreadLocal2 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
            snapshotThreadLocal2.set(Integer.valueOf(intValue3 + 1));
            try {
                Object observe = Snapshot.INSTANCE.observe(new Function1<Object, Unit>(this) { // from class: androidx.compose.runtime.DerivedSnapshotState$currentRecord$result$1$result$1
                    final /* synthetic */ DerivedState<T> this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                        invoke2(p1);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object it) {
                        SnapshotThreadLocal snapshotThreadLocal7;
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (it == this.this$0) {
                            throw new IllegalStateException("A derived state calculation cannot read itself".toString());
                        }
                        if (it instanceof StateObject) {
                            snapshotThreadLocal7 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                            Object obj2 = snapshotThreadLocal7.get();
                            Intrinsics.checkNotNull(obj2);
                            int readNestedLevel = ((Number) obj2).intValue();
                            IdentityArrayMap<StateObject, Integer> identityArrayMap2 = identityArrayMap;
                            int i8 = readNestedLevel - intValue3;
                            Integer num3 = identityArrayMap.get(it);
                            identityArrayMap2.set(it, Integer.valueOf(Math.min(i8, num3 != null ? num3.intValue() : Integer.MAX_VALUE)));
                        }
                    }
                }, null, calculation);
                snapshotThreadLocal3 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                snapshotThreadLocal3.set(Integer.valueOf(intValue3));
                MutableVector mutableVector5 = mutableVector4;
                int size6 = mutableVector5.getSize();
                if (size6 > 0) {
                    int i8 = 0;
                    Object[] content5 = mutableVector5.getContent();
                    Intrinsics.checkNotNull(content5, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                    while (true) {
                        MutableVector mutableVector6 = mutableVector5;
                        ((Function1) ((Pair) content5[i8]).component2()).invoke(this);
                        i8++;
                        if (i8 >= size6) {
                            break;
                        }
                        mutableVector5 = mutableVector6;
                    }
                }
                synchronized (SnapshotKt.getLock()) {
                    Snapshot current = Snapshot.INSTANCE.getCurrent();
                    if (readable.getResult() != ResultRecord.INSTANCE.getUnset()) {
                        SnapshotMutationPolicy<T> policy = getPolicy();
                        if (policy != 0 ? policy.equivalent(observe, readable.getResult()) : false) {
                            readable.setDependencies(identityArrayMap);
                            readable.setResultHash(readable.readableHash(this, current));
                            resultRecord = readable;
                        }
                    }
                    resultRecord = (ResultRecord) SnapshotKt.newWritableRecord(this.first, this, current);
                    resultRecord.setDependencies(identityArrayMap);
                    resultRecord.setResultHash(resultRecord.readableHash(this, current));
                    resultRecord.setResult(observe);
                }
                ResultRecord<T> resultRecord2 = resultRecord;
                if (intValue3 == 0) {
                    Snapshot.INSTANCE.notifyObjectsInitialized();
                }
                return resultRecord2;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.first = (ResultRecord) value;
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        Function1<Object, Unit> readObserver$runtime_release = Snapshot.INSTANCE.getCurrent().getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(this);
        }
        return (T) currentRecord((ResultRecord) SnapshotKt.current(this.first), Snapshot.INSTANCE.getCurrent(), true, this.calculation).getResult();
    }

    @Override // androidx.compose.runtime.DerivedState
    public T getCurrentValue() {
        return (T) currentRecord((ResultRecord) SnapshotKt.current(this.first), Snapshot.INSTANCE.getCurrent(), false, this.calculation).getResult();
    }

    @Override // androidx.compose.runtime.DerivedState
    public Object[] getDependencies() {
        Object[] keys;
        StateRecord $this$withCurrent$iv = this.first;
        ResultRecord<T> it = (ResultRecord) SnapshotKt.current($this$withCurrent$iv);
        ResultRecord<T> record = currentRecord(it, Snapshot.INSTANCE.getCurrent(), false, this.calculation);
        IdentityArrayMap<StateObject, Integer> dependencies = record.getDependencies();
        if (dependencies != null && (keys = dependencies.getKeys()) != null) {
            return keys;
        }
        return new Object[0];
    }

    public String toString() {
        StateRecord $this$withCurrent$iv = this.first;
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }

    public final T getDebuggerDisplayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        if (resultRecord.isValid(this, Snapshot.INSTANCE.getCurrent())) {
            return (T) resultRecord.getResult();
        }
        return null;
    }

    private final String displayValue() {
        StateRecord $this$withCurrent$iv = this.first;
        ResultRecord it = (ResultRecord) SnapshotKt.current($this$withCurrent$iv);
        if (it.isValid(this, Snapshot.INSTANCE.getCurrent())) {
            return String.valueOf(it.getResult());
        }
        return "<Not calculated>";
    }
}
