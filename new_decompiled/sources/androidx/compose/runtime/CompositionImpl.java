package androidx.compose.runtime;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.navigation.compose.ComposeNavigator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: Composition.kt */
@Metadata(m286d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0091\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010T\u001a\u00020\u001bH\u0002J\u001e\u0010U\u001a\u00020\u001b2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020.0W2\u0006\u0010X\u001a\u00020\u000fH\u0002J\b\u0010Y\u001a\u00020\u001bH\u0016Jc\u0010Z\u001a\u00020\u001b2Y\u0010\u0012\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0014j\u0002`\u001c0\u0013H\u0002J\b\u0010[\u001a\u00020\u001bH\u0016J\b\u0010\\\u001a\u00020\u001bH\u0016J\b\u0010]\u001a\u00020\u001bH\u0002J \u0010^\u001a\u00020\u001b2\u0011\u0010_\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001e¢\u0006\u0002\b\u001fH\u0016¢\u0006\u0002\u0010#J3\u0010`\u001a\u0002Ha\"\u0004\b\u0000\u0010a2\b\u0010b\u001a\u0004\u0018\u00010\u00012\u0006\u0010c\u001a\u00020:2\f\u0010d\u001a\b\u0012\u0004\u0012\u0002Ha0\u001eH\u0016¢\u0006\u0002\u0010eJ\b\u0010f\u001a\u00020\u001bH\u0016J\u0010\u0010g\u001a\u00020\u001b2\u0006\u0010h\u001a\u00020iH\u0016J\b\u0010j\u001a\u00020\u001bH\u0002J\b\u0010k\u001a\u00020\u001bH\u0002J\"\u0010l\u001a\u0002Hm\"\u0004\b\u0000\u0010m2\f\u0010d\u001a\b\u0012\u0004\u0012\u0002Hm0\u001eH\u0082\b¢\u0006\u0002\u0010nJK\u0010o\u001a\u0002Hm\"\u0004\b\u0000\u0010m25\u0010d\u001a1\u0012'\u0012%\u0012\u0004\u0012\u00020)\u0012\f\u0012\n\u0012\u0004\u0012\u00020.\u0018\u00010=0<¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002Hm0pH\u0082\b¢\u0006\u0002\u0010qJ$\u0010r\u001a\u00020\u001b2\u001a\u0010s\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020u\u0012\u0006\u0012\u0004\u0018\u00010u0t0(H\u0016J\u0018\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020)2\b\u0010y\u001a\u0004\u0018\u00010.J\b\u0010z\u001a\u00020\u001bH\u0016J\"\u0010{\u001a\u00020w2\u0006\u0010x\u001a\u00020)2\u0006\u0010|\u001a\u00020}2\b\u0010y\u001a\u0004\u0018\u00010.H\u0002J\u000e\u0010~\u001a\u00020\u001b2\u0006\u0010\u007f\u001a\u00020:J\u0012\u0010\u0080\u0001\u001a\u00020\u001b2\u0007\u0010\u0081\u0001\u001a\u00020.H\u0002J\u0017\u0010\u0082\u0001\u001a\u00020\u000f2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020.0WH\u0016J\u0017\u0010\u0083\u0001\u001a\u00020\u001b2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001eH\u0016J\t\u0010\u0084\u0001\u001a\u00020\u000fH\u0016J\u0017\u0010\u0085\u0001\u001a\u00020\u001b2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020.0WH\u0016J\u0012\u0010\u0086\u0001\u001a\u00020\u001b2\u0007\u0010\u0081\u0001\u001a\u00020.H\u0016J\u0012\u0010\u0087\u0001\u001a\u00020\u001b2\u0007\u0010\u0081\u0001\u001a\u00020.H\u0016J\u001b\u0010\u0088\u0001\u001a\u00020\u001b2\n\u0010h\u001a\u0006\u0012\u0002\b\u000302H\u0000¢\u0006\u0003\b\u0089\u0001J\u001f\u0010\u008a\u0001\u001a\u00020\u001b2\u0006\u0010y\u001a\u00020.2\u0006\u0010x\u001a\u00020)H\u0000¢\u0006\u0003\b\u008b\u0001J!\u0010\u008c\u0001\u001a\u00020\u001b2\u0011\u0010_\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001e¢\u0006\u0002\b\u001fH\u0016¢\u0006\u0002\u0010#J\u001d\u0010\u008d\u0001\u001a\u0016\u0012\u0004\u0012\u00020)\u0012\f\u0012\n\u0012\u0004\u0012\u00020.\u0018\u00010=0<H\u0002J#\u0010\u008e\u0001\u001a\u0002Hm\"\u0004\b\u0000\u0010m2\f\u0010d\u001a\b\u0012\u0004\u0012\u0002Hm0\u001eH\u0082\b¢\u0006\u0002\u0010nJ\u0011\u0010\u008f\u0001\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020QH\u0002J\t\u0010\u0090\u0001\u001a\u00020\u001bH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011Ra\u0010\u0012\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0014j\u0002`\u001c0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001e¢\u0006\u0002\b\u001fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001e\u0010,\u001a\u0012\u0012\u0004\u0012\u00020)0\u000bj\b\u0012\u0004\u0012\u00020)`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020.0(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b/\u0010+R\u0018\u00100\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0011R\u0014\u00106\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0011R\u0010\u00108\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010;\u001a\u0016\u0012\u0004\u0012\u00020)\u0012\f\u0012\n\u0012\u0004\u0012\u00020.\u0018\u00010=0<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0011R\u0014\u0010?\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0011R\u0011\u0010@\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0011Ra\u0010A\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0014j\u0002`\u001c0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020)01X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020)01X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020.0(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bF\u0010+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010G\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0011\"\u0004\bI\u0010JR\"\u0010K\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010.0Lj\n\u0012\u0006\u0012\u0004\u0018\u00010.`MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010P\u001a\u00020QX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010S¨\u0006\u0092\u0001"}, m287d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "parent", "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "recomposeContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "_recomposeContext", "abandonSet", "Ljava/util/HashSet;", "Landroidx/compose/runtime/RememberObserver;", "Lkotlin/collections/HashSet;", "areChildrenComposing", "", "getAreChildrenComposing", "()Z", "changes", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", ComposeNavigator.NAME, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "conditionalScopes", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getConditionalScopes$runtime_release", "()Ljava/util/List;", "conditionallyInvalidatedScopes", "derivedStateDependencies", "", "getDerivedStateDependencies$runtime_release", "derivedStates", "Landroidx/compose/runtime/collection/IdentityScopeMap;", "Landroidx/compose/runtime/DerivedState;", "disposed", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges", "invalidationDelegate", "invalidationDelegateGroup", "", "invalidations", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "isComposing", "isDisposed", "isRoot", "lateChanges", "lock", "observations", "observationsProcessed", "observedObjects", "getObservedObjects$runtime_release", "pendingInvalidScopes", "getPendingInvalidScopes$runtime_release", "setPendingInvalidScopes$runtime_release", "(Z)V", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "getRecomposeContext", "()Lkotlin/coroutines/CoroutineContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "abandonChanges", "addPendingInvalidationsLocked", "values", "", "forgetConditionalScopes", "applyChanges", "applyChangesInLocked", "applyLateChanges", "changesApplied", "cleanUpDerivedStateObservations", "composeContent", "content", "delegateInvalidations", "R", "to", "groupIndex", "block", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "dispose", "disposeUnusedMovableContent", "state", "Landroidx/compose/runtime/MovableContentState;", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "guardChanges", "T", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "guardInvalidationsLocked", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "insertMovableContent", "references", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "invalidateAll", "invalidateChecked", "anchor", "Landroidx/compose/runtime/Anchor;", "invalidateGroupsWithKey", "key", "invalidateScopeOfLocked", "value", "observesAnyOf", "prepareCompose", "recompose", "recordModificationsOf", "recordReadOf", "recordWriteOf", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime_release", "removeObservation", "removeObservation$runtime_release", "setContent", "takeInvalidations", "trackAbandonedValues", "validateRecomposeScopeAnchors", "verifyConsistent", "RememberEventDispatcher", "runtime_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class CompositionImpl implements ControlledComposition {
    private final CoroutineContext _recomposeContext;
    private final HashSet<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final ComposerImpl composer;
    private final HashSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final IdentityScopeMap<DerivedState<?>> derivedStates;
    private boolean disposed;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidations;
    private final boolean isRoot;
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> lateChanges;
    private final Object lock;
    private final IdentityScopeMap<RecomposeScopeImpl> observations;
    private final IdentityScopeMap<RecomposeScopeImpl> observationsProcessed;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private final SlotTable slotTable;

    public CompositionImpl(CompositionContext parent, Applier<?> applier, CoroutineContext recomposeContext) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(applier, "applier");
        this.parent = parent;
        this.applier = applier;
        this.pendingModifications = new AtomicReference<>(null);
        this.lock = new Object();
        this.abandonSet = new HashSet<>();
        this.slotTable = new SlotTable();
        this.observations = new IdentityScopeMap<>();
        this.conditionallyInvalidatedScopes = new HashSet<>();
        this.derivedStates = new IdentityScopeMap<>();
        this.changes = new ArrayList();
        this.lateChanges = new ArrayList();
        this.observationsProcessed = new IdentityScopeMap<>();
        this.invalidations = new IdentityArrayMap<>(0, 1, null);
        ComposerImpl it = new ComposerImpl(this.applier, this.parent, this.slotTable, this.abandonSet, this.changes, this.lateChanges, this);
        this.parent.registerComposer$runtime_release(it);
        this.composer = it;
        this._recomposeContext = recomposeContext;
        this.isRoot = this.parent instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m1625getLambda1$runtime_release();
    }

    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier, (i & 4) != 0 ? null : coroutineContext);
    }

    /* renamed from: getSlotTable$runtime_release, reason: from getter */
    public final SlotTable getSlotTable() {
        return this.slotTable;
    }

    public final List<Object> getObservedObjects$runtime_release() {
        return ArraysKt.filterNotNull(this.observations.getValues());
    }

    public final List<Object> getDerivedStateDependencies$runtime_release() {
        return ArraysKt.filterNotNull(this.derivedStates.getValues());
    }

    public final List<RecomposeScopeImpl> getConditionalScopes$runtime_release() {
        return CollectionsKt.toList(this.conditionallyInvalidatedScopes);
    }

    /* renamed from: getPendingInvalidScopes$runtime_release, reason: from getter */
    public final boolean getPendingInvalidScopes() {
        return this.pendingInvalidScopes;
    }

    public final void setPendingInvalidScopes$runtime_release(boolean z) {
        this.pendingInvalidScopes = z;
    }

    public final CoroutineContext getRecomposeContext() {
        CoroutineContext coroutineContext = this._recomposeContext;
        return coroutineContext == null ? this.parent.getRecomposeCoroutineContext$runtime_release() : coroutineContext;
    }

    /* renamed from: isRoot, reason: from getter */
    public final boolean getIsRoot() {
        return this.isRoot;
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    public final void setComposable(Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.composable = function2;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.getIsComposing();
    }

    @Override // androidx.compose.runtime.Composition
    /* renamed from: isDisposed, reason: from getter */
    public boolean getDisposed() {
        return this.disposed;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime_release;
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            hasPendingChanges$runtime_release = this.composer.getHasPendingChanges$runtime_release();
        }
        return hasPendingChanges$runtime_release;
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (this.disposed) {
            throw new IllegalStateException("The composition is disposed".toString());
        }
        this.composable = content;
        this.parent.composeInitial$runtime_release(this, this.composable);
    }

    public final void invalidateGroupsWithKey(int key) {
        boolean forceComposition;
        boolean z;
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            try {
                try {
                    List scopesToInvalidate = this.slotTable.invalidateGroupsWithKey$runtime_release(key);
                    if (scopesToInvalidate != null) {
                        int index$iv$iv = 0;
                        int size = scopesToInvalidate.size();
                        while (true) {
                            if (index$iv$iv < size) {
                                Object item$iv$iv = scopesToInvalidate.get(index$iv$iv);
                                RecomposeScopeImpl it = (RecomposeScopeImpl) item$iv$iv;
                                if (it.invalidateForResult(null) == InvalidationResult.IGNORED) {
                                    z = true;
                                    break;
                                }
                                index$iv$iv++;
                            } else {
                                z = false;
                                break;
                            }
                        }
                        if (!z) {
                            forceComposition = false;
                            if (!forceComposition && this.composer.forceRecomposeScopes$runtime_release()) {
                                this.parent.invalidate$runtime_release(this);
                                return;
                            }
                        }
                    }
                    forceComposition = true;
                    if (!forceComposition) {
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object obj;
        Object obj2;
        AtomicReference<Object> atomicReference = this.pendingModifications;
        obj = CompositionKt.PendingApplyNoModifications;
        Object toRecord = atomicReference.getAndSet(obj);
        if (toRecord != null) {
            obj2 = CompositionKt.PendingApplyNoModifications;
            if (Intrinsics.areEqual(toRecord, obj2)) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                throw new KotlinNothingValueException();
            }
            if (toRecord instanceof Set) {
                addPendingInvalidationsLocked((Set) toRecord, true);
                return;
            }
            if (!(toRecord instanceof Object[])) {
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
                throw new KotlinNothingValueException();
            }
            for (Set changed : (Set[]) toRecord) {
                addPendingInvalidationsLocked(changed, true);
            }
        }
    }

    private final void drainPendingModificationsLocked() {
        Object obj;
        Object toRecord = this.pendingModifications.getAndSet(null);
        obj = CompositionKt.PendingApplyNoModifications;
        if (!Intrinsics.areEqual(toRecord, obj)) {
            if (toRecord instanceof Set) {
                addPendingInvalidationsLocked((Set) toRecord, false);
                return;
            }
            if (!(toRecord instanceof Object[])) {
                if (toRecord == null) {
                    ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
                    throw new KotlinNothingValueException();
                }
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
                throw new KotlinNothingValueException();
            }
            for (Set changed : (Set[]) toRecord) {
                addPendingInvalidationsLocked(changed, false);
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            Object lock$iv = this.lock;
            synchronized (lock$iv) {
                try {
                    try {
                        drainPendingModificationsForCompositionLocked();
                        IdentityArrayMap invalidations$iv = takeInvalidations();
                        try {
                            try {
                                this.composer.composeContent$runtime_release(invalidations$iv, content);
                                Unit unit = Unit.INSTANCE;
                                Unit unit2 = Unit.INSTANCE;
                                Unit unit3 = Unit.INSTANCE;
                            } catch (Throwable th) {
                                e$iv = th;
                                throw e$iv;
                            }
                        } catch (Exception e$iv) {
                            this.invalidations = invalidations$iv;
                            throw e$iv;
                        }
                    } catch (Throwable th2) {
                        e$iv = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (0 == 0) {
                        try {
                            if (!this.abandonSet.isEmpty()) {
                                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                            }
                        } catch (Exception e$iv2) {
                            abandonChanges();
                            throw e$iv2;
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            if (!this.disposed) {
                boolean nonEmptySlotTable = true;
                this.disposed = true;
                this.composable = ComposableSingletons$CompositionKt.INSTANCE.m1626getLambda2$runtime_release();
                List deferredChanges = this.composer.getDeferredChanges$runtime_release();
                if (deferredChanges != null) {
                    applyChangesInLocked(deferredChanges);
                }
                if (this.slotTable.getGroupsSize() <= 0) {
                    nonEmptySlotTable = false;
                }
                if (nonEmptySlotTable || !this.abandonSet.isEmpty()) {
                    RememberEventDispatcher manager = new RememberEventDispatcher(this.abandonSet);
                    if (nonEmptySlotTable) {
                        SlotTable this_$iv = this.slotTable;
                        SlotWriter writer$iv = this_$iv.openWriter();
                        try {
                            ComposerKt.removeCurrentGroup(writer$iv, manager);
                            Unit unit = Unit.INSTANCE;
                            writer$iv.close();
                            this.applier.clear();
                            manager.dispatchRememberObservers();
                        } catch (Throwable th) {
                            writer$iv.close();
                            throw th;
                        }
                    }
                    manager.dispatchAbandons();
                }
                this.composer.dispose$runtime_release();
            }
            Unit unit2 = Unit.INSTANCE;
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        boolean z;
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            z = this.invalidations.getSize() > 0;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.util.Set[]] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object[]] */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(Set<? extends Object> values) {
        Object obj;
        Object obj2;
        boolean areEqual;
        Set<? extends Object> set;
        Intrinsics.checkNotNullParameter(values, "values");
        do {
            obj = this.pendingModifications.get();
            if (obj != null) {
                obj2 = CompositionKt.PendingApplyNoModifications;
                areEqual = Intrinsics.areEqual(obj, obj2);
            } else {
                areEqual = true;
            }
            if (areEqual) {
                set = values;
            } else if (obj instanceof Set) {
                set = new Set[]{(Set) obj, values};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                set = ArraysKt.plus((Set<? extends Object>[]) obj, values);
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m5m(this.pendingModifications, obj, set));
        if (obj == null) {
            synchronized (this.lock) {
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean observesAnyOf(Set<? extends Object> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        for (Object value : values) {
            if (this.observations.contains(value) || this.derivedStates.contains(value)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.composer.prepareCompose$runtime_release(block);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void addPendingInvalidationsLocked(Set<? extends Object> values, boolean forgetConditionalScopes) {
        Ref.ObjectRef invalidated = new Ref.ObjectRef();
        for (Object value : values) {
            if (value instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) value).invalidateForResult(null);
            } else {
                addPendingInvalidationsLocked$invalidate(this, forgetConditionalScopes, invalidated, value);
                IdentityScopeMap this_$iv = this.derivedStates;
                int index$iv = this_$iv.find(value);
                if (index$iv >= 0) {
                    IdentityArraySet this_$iv$iv = this_$iv.scopeSetAt(index$iv);
                    int size = this_$iv$iv.size();
                    for (int i$iv$iv = 0; i$iv$iv < size; i$iv$iv++) {
                        addPendingInvalidationsLocked$invalidate(this, forgetConditionalScopes, invalidated, (DerivedState) this_$iv$iv.get(i$iv$iv));
                    }
                }
            }
        }
        String str = "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet";
        if (forgetConditionalScopes && !this.conditionallyInvalidatedScopes.isEmpty()) {
            IdentityScopeMap this_$iv2 = this.observations;
            int $i$f$removeValueIf = 0;
            int $i$f$removingScopes = 0;
            int destinationIndex$iv$iv = 0;
            int i$iv$iv2 = 0;
            int size2 = this_$iv2.getSize();
            while (i$iv$iv2 < size2) {
                int valueIndex$iv$iv = this_$iv2.getValueOrder()[i$iv$iv2];
                IdentityArraySet set$iv$iv = this_$iv2.getScopeSets()[valueIndex$iv$iv];
                Intrinsics.checkNotNull(set$iv$iv);
                int size3 = set$iv$iv.size();
                int destinationIndex$iv$iv2 = 0;
                IdentityScopeMap this_$iv3 = this_$iv2;
                int i$iv$iv3 = 0;
                while (i$iv$iv3 < size3) {
                    int i = size3;
                    Object item$iv$iv = set$iv$iv.getValues()[i$iv$iv3];
                    Intrinsics.checkNotNull(item$iv$iv, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    int $i$f$removeValueIf2 = $i$f$removeValueIf;
                    RecomposeScopeImpl scope = (RecomposeScopeImpl) item$iv$iv;
                    int $i$f$removingScopes2 = $i$f$removingScopes;
                    int i2 = size2;
                    boolean z = true;
                    if (!this.conditionallyInvalidatedScopes.contains(scope)) {
                        HashSet it = (HashSet) invalidated.element;
                        if (!(it != null && it.contains(scope))) {
                            z = false;
                        }
                    }
                    if (!z) {
                        if (destinationIndex$iv$iv2 != i$iv$iv3) {
                            set$iv$iv.getValues()[destinationIndex$iv$iv2] = item$iv$iv;
                        }
                        destinationIndex$iv$iv2++;
                    }
                    i$iv$iv3++;
                    $i$f$removeValueIf = $i$f$removeValueIf2;
                    size3 = i;
                    $i$f$removingScopes = $i$f$removingScopes2;
                    size2 = i2;
                }
                int $i$f$removeValueIf3 = $i$f$removeValueIf;
                int $i$f$removingScopes3 = $i$f$removingScopes;
                int i3 = size2;
                int size4 = set$iv$iv.size();
                for (int i$iv$iv4 = destinationIndex$iv$iv2; i$iv$iv4 < size4; i$iv$iv4++) {
                    set$iv$iv.getValues()[i$iv$iv4] = null;
                }
                set$iv$iv.setSize(destinationIndex$iv$iv2);
                if (set$iv$iv.size() > 0) {
                    if (destinationIndex$iv$iv != i$iv$iv2) {
                        int destinationKeyOrder$iv$iv = this_$iv2.getValueOrder()[destinationIndex$iv$iv];
                        this_$iv2.getValueOrder()[destinationIndex$iv$iv] = valueIndex$iv$iv;
                        this_$iv2.getValueOrder()[i$iv$iv2] = destinationKeyOrder$iv$iv;
                    }
                    destinationIndex$iv$iv++;
                }
                i$iv$iv2++;
                this_$iv2 = this_$iv3;
                $i$f$removeValueIf = $i$f$removeValueIf3;
                $i$f$removingScopes = $i$f$removingScopes3;
                size2 = i3;
            }
            int size5 = this_$iv2.getSize();
            for (int i$iv$iv5 = destinationIndex$iv$iv; i$iv$iv5 < size5; i$iv$iv5++) {
                this_$iv2.getValues()[this_$iv2.getValueOrder()[i$iv$iv5]] = null;
            }
            this_$iv2.setSize(destinationIndex$iv$iv);
            cleanUpDerivedStateObservations();
            this.conditionallyInvalidatedScopes.clear();
            return;
        }
        HashSet it2 = (HashSet) invalidated.element;
        if (it2 != null) {
            int i4 = 0;
            IdentityScopeMap this_$iv4 = this.observations;
            int destinationIndex$iv$iv3 = 0;
            int i$iv$iv6 = 0;
            int size6 = this_$iv4.getSize();
            while (i$iv$iv6 < size6) {
                int valueIndex$iv$iv2 = this_$iv4.getValueOrder()[i$iv$iv6];
                IdentityArraySet set$iv$iv2 = this_$iv4.getScopeSets()[valueIndex$iv$iv2];
                Intrinsics.checkNotNull(set$iv$iv2);
                int size7 = set$iv$iv2.size();
                Ref.ObjectRef invalidated2 = invalidated;
                int destinationIndex$iv$iv4 = 0;
                int destinationIndex$iv$iv5 = i4;
                int i$iv$iv7 = 0;
                while (i$iv$iv7 < size7) {
                    int i5 = size7;
                    Object item$iv$iv2 = set$iv$iv2.getValues()[i$iv$iv7];
                    Intrinsics.checkNotNull(item$iv$iv2, str);
                    String str2 = str;
                    if (!it2.contains((RecomposeScopeImpl) item$iv$iv2)) {
                        if (destinationIndex$iv$iv4 != i$iv$iv7) {
                            set$iv$iv2.getValues()[destinationIndex$iv$iv4] = item$iv$iv2;
                        }
                        destinationIndex$iv$iv4++;
                    }
                    i$iv$iv7++;
                    str = str2;
                    size7 = i5;
                }
                String str3 = str;
                int size8 = set$iv$iv2.size();
                for (int i$iv$iv8 = destinationIndex$iv$iv4; i$iv$iv8 < size8; i$iv$iv8++) {
                    set$iv$iv2.getValues()[i$iv$iv8] = null;
                }
                set$iv$iv2.setSize(destinationIndex$iv$iv4);
                if (set$iv$iv2.size() > 0) {
                    if (destinationIndex$iv$iv3 != i$iv$iv6) {
                        int destinationKeyOrder$iv$iv2 = this_$iv4.getValueOrder()[destinationIndex$iv$iv3];
                        this_$iv4.getValueOrder()[destinationIndex$iv$iv3] = valueIndex$iv$iv2;
                        this_$iv4.getValueOrder()[i$iv$iv6] = destinationKeyOrder$iv$iv2;
                    }
                    destinationIndex$iv$iv3++;
                }
                i$iv$iv6++;
                i4 = destinationIndex$iv$iv5;
                str = str3;
                invalidated = invalidated2;
            }
            int size9 = this_$iv4.getSize();
            for (int i$iv$iv9 = destinationIndex$iv$iv3; i$iv$iv9 < size9; i$iv$iv9++) {
                this_$iv4.getValues()[this_$iv4.getValueOrder()[i$iv$iv9]] = null;
            }
            this_$iv4.setSize(destinationIndex$iv$iv3);
            cleanUpDerivedStateObservations();
        }
    }

    /* JADX WARN: Type inference failed for: r9v7, types: [T, java.util.HashSet] */
    private static final void addPendingInvalidationsLocked$invalidate(CompositionImpl compositionImpl, boolean z, Ref.ObjectRef<HashSet<RecomposeScopeImpl>> objectRef, Object obj) {
        IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = compositionImpl.observations;
        int find = identityScopeMap.find(obj);
        if (find >= 0) {
            IdentityArraySet scopeSetAt = identityScopeMap.scopeSetAt(find);
            int size = scopeSetAt.size();
            for (int i = 0; i < size; i++) {
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) scopeSetAt.get(i);
                if (!compositionImpl.observationsProcessed.remove(obj, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(obj) != InvalidationResult.IGNORED) {
                    if (recomposeScopeImpl.isConditional() && !z) {
                        compositionImpl.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                    } else {
                        HashSet<RecomposeScopeImpl> hashSet = objectRef.element;
                        HashSet<RecomposeScopeImpl> hashSet2 = hashSet;
                        if (hashSet == null) {
                            ?? hashSet3 = new HashSet();
                            objectRef.element = hashSet3;
                            hashSet2 = hashSet3;
                        }
                        hashSet2.add(recomposeScopeImpl);
                    }
                }
            }
        }
    }

    private final void cleanUpDerivedStateObservations() {
        IdentityScopeMap this_$iv = this.derivedStates;
        int $i$f$removeValueIf = 0;
        int $i$f$removingScopes = 0;
        int destinationIndex$iv$iv = 0;
        int i$iv$iv = 0;
        int size = this_$iv.getSize();
        while (i$iv$iv < size) {
            int valueIndex$iv$iv = this_$iv.getValueOrder()[i$iv$iv];
            IdentityArraySet set$iv$iv = this_$iv.getScopeSets()[valueIndex$iv$iv];
            Intrinsics.checkNotNull(set$iv$iv);
            int destinationIndex$iv$iv2 = 0;
            int size2 = set$iv$iv.size();
            IdentityScopeMap this_$iv2 = this_$iv;
            int i$iv$iv2 = 0;
            while (i$iv$iv2 < size2) {
                int $i$f$removeValueIf2 = $i$f$removeValueIf;
                Object item$iv$iv = set$iv$iv.getValues()[i$iv$iv2];
                int $i$f$removingScopes2 = $i$f$removingScopes;
                Intrinsics.checkNotNull(item$iv$iv, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                DerivedState derivedValue = (DerivedState) item$iv$iv;
                int i = size;
                if (this.observations.contains(derivedValue)) {
                    if (destinationIndex$iv$iv2 != i$iv$iv2) {
                        set$iv$iv.getValues()[destinationIndex$iv$iv2] = item$iv$iv;
                    }
                    destinationIndex$iv$iv2++;
                }
                i$iv$iv2++;
                $i$f$removingScopes = $i$f$removingScopes2;
                $i$f$removeValueIf = $i$f$removeValueIf2;
                size = i;
            }
            int $i$f$removeValueIf3 = $i$f$removeValueIf;
            int $i$f$removingScopes3 = $i$f$removingScopes;
            int i2 = size;
            int size3 = set$iv$iv.size();
            for (int i$iv$iv3 = destinationIndex$iv$iv2; i$iv$iv3 < size3; i$iv$iv3++) {
                set$iv$iv.getValues()[i$iv$iv3] = null;
            }
            set$iv$iv.setSize(destinationIndex$iv$iv2);
            if (set$iv$iv.size() > 0) {
                if (destinationIndex$iv$iv != i$iv$iv) {
                    int destinationKeyOrder$iv$iv = this_$iv.getValueOrder()[destinationIndex$iv$iv];
                    this_$iv.getValueOrder()[destinationIndex$iv$iv] = valueIndex$iv$iv;
                    this_$iv.getValueOrder()[i$iv$iv] = destinationKeyOrder$iv$iv;
                }
                destinationIndex$iv$iv++;
            }
            i$iv$iv++;
            this_$iv = this_$iv2;
            $i$f$removingScopes = $i$f$removingScopes3;
            $i$f$removeValueIf = $i$f$removeValueIf3;
            size = i2;
        }
        int size4 = this_$iv.getSize();
        for (int i$iv$iv4 = destinationIndex$iv$iv; i$iv$iv4 < size4; i$iv$iv4++) {
            this_$iv.getValues()[this_$iv.getValueOrder()[i$iv$iv4]] = null;
        }
        this_$iv.setSize(destinationIndex$iv$iv);
        HashSet $this$removeValueIf$iv = this.conditionallyInvalidatedScopes;
        Iterator iter$iv = $this$removeValueIf$iv.iterator();
        Intrinsics.checkNotNullExpressionValue(iter$iv, "iterator()");
        while (iter$iv.hasNext()) {
            RecomposeScopeImpl scope = iter$iv.next();
            if (!scope.isConditional()) {
                iter$iv.remove();
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void recordReadOf(Object value) {
        RecomposeScopeImpl it;
        Intrinsics.checkNotNullParameter(value, "value");
        if (!getAreChildrenComposing() && (it = this.composer.getCurrentRecomposeScope$runtime_release()) != null) {
            it.setUsed(true);
            this.observations.add(value, it);
            if (value instanceof DerivedState) {
                this.derivedStates.removeScope(value);
                for (Object dependency : ((DerivedState) value).getDependencies()) {
                    if (dependency == null) {
                        break;
                    }
                    this.derivedStates.add(dependency, value);
                }
            }
            it.recordRead(value);
        }
    }

    private final void invalidateScopeOfLocked(Object value) {
        IdentityScopeMap this_$iv = this.observations;
        int index$iv = this_$iv.find(value);
        if (index$iv >= 0) {
            IdentityArraySet this_$iv$iv = this_$iv.scopeSetAt(index$iv);
            int size = this_$iv$iv.size();
            for (int i$iv$iv = 0; i$iv$iv < size; i$iv$iv++) {
                RecomposeScopeImpl scope = (RecomposeScopeImpl) this_$iv$iv.get(i$iv$iv);
                if (scope.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                    this.observationsProcessed.add(value, scope);
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void recordWriteOf(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            invalidateScopeOfLocked(value);
            IdentityScopeMap this_$iv = this.derivedStates;
            int index$iv = this_$iv.find(value);
            if (index$iv >= 0) {
                IdentityArraySet this_$iv$iv = this_$iv.scopeSetAt(index$iv);
                int size = this_$iv$iv.size();
                for (int i$iv$iv = 0; i$iv$iv < size; i$iv$iv++) {
                    DerivedState it = (DerivedState) this_$iv$iv.get(i$iv$iv);
                    invalidateScopeOfLocked(it);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        boolean shouldDrain;
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            drainPendingModificationsForCompositionLocked();
            try {
                IdentityArrayMap invalidations$iv = takeInvalidations();
                try {
                    shouldDrain = this.composer.recompose$runtime_release(invalidations$iv);
                    if (!shouldDrain) {
                        drainPendingModificationsLocked();
                    }
                } catch (Exception e$iv) {
                    this.invalidations = invalidations$iv;
                    throw e$iv;
                }
            } finally {
            }
        }
        return shouldDrain;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        boolean z;
        Intrinsics.checkNotNullParameter(references, "references");
        int index$iv$iv = 0;
        int size = references.size();
        while (true) {
            if (index$iv$iv < size) {
                Pair item$iv$iv = references.get(index$iv$iv);
                Pair it = item$iv$iv;
                if (!Intrinsics.areEqual(it.getFirst().getComposition(), this)) {
                    z = false;
                    break;
                }
                index$iv$iv++;
            } else {
                z = true;
                break;
            }
        }
        ComposerKt.runtimeCheck(z);
        try {
            this.composer.insertMovableContentReferences(references);
            Unit unit = Unit.INSTANCE;
        } finally {
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(MovableContentState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        RememberEventDispatcher manager = new RememberEventDispatcher(this.abandonSet);
        SlotTable slotTable = state.getSlotTable();
        SlotWriter writer$iv = slotTable.openWriter();
        try {
            ComposerKt.removeCurrentGroup(writer$iv, manager);
            Unit unit = Unit.INSTANCE;
            writer$iv.close();
            manager.dispatchRememberObservers();
        } catch (Throwable th) {
            writer$iv.close();
            throw th;
        }
    }

    private final void applyChangesInLocked(List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes) {
        boolean isEmpty;
        RememberEventDispatcher manager = new RememberEventDispatcher(this.abandonSet);
        try {
            if (changes.isEmpty()) {
                if (isEmpty) {
                    return;
                } else {
                    return;
                }
            }
            Object token$iv = Trace.INSTANCE.beginSection("Compose:applyChanges");
            try {
                this.applier.onBeginChanges();
                SlotWriter writer$iv = this.slotTable.openWriter();
                try {
                    try {
                        Applier applier = this.applier;
                        int index$iv = 0;
                        try {
                            for (int size = changes.size(); index$iv < size; size = size) {
                                Function3 item$iv = changes.get(index$iv);
                                Function3 change = item$iv;
                                change.invoke(applier, writer$iv, manager);
                                index$iv++;
                            }
                            changes.clear();
                            Unit unit = Unit.INSTANCE;
                            writer$iv.close();
                            this.applier.onEndChanges();
                            Unit unit2 = Unit.INSTANCE;
                            Trace.INSTANCE.endSection(token$iv);
                            manager.dispatchRememberObservers();
                            manager.dispatchSideEffects();
                            if (this.pendingInvalidScopes) {
                                String sectionName$iv = "Compose:unobserve";
                                int $i$f$trace = 0;
                                Object token$iv2 = Trace.INSTANCE.beginSection(sectionName$iv);
                                int i = 0;
                                try {
                                    this.pendingInvalidScopes = false;
                                    IdentityScopeMap this_$iv = this.observations;
                                    int destinationIndex$iv$iv = 0;
                                    int i$iv$iv = 0;
                                    int size2 = this_$iv.getSize();
                                    while (i$iv$iv < size2) {
                                        int valueIndex$iv$iv = this_$iv.getValueOrder()[i$iv$iv];
                                        IdentityArraySet set$iv$iv = this_$iv.getScopeSets()[valueIndex$iv$iv];
                                        Intrinsics.checkNotNull(set$iv$iv);
                                        int size3 = set$iv$iv.size();
                                        int i2 = i;
                                        int destinationIndex$iv$iv2 = 0;
                                        String sectionName$iv2 = sectionName$iv;
                                        int i$iv$iv2 = 0;
                                        while (i$iv$iv2 < size3) {
                                            try {
                                                int $i$f$trace2 = $i$f$trace;
                                                try {
                                                    Object item$iv$iv = set$iv$iv.getValues()[i$iv$iv2];
                                                    IdentityScopeMap this_$iv2 = this_$iv;
                                                    Intrinsics.checkNotNull(item$iv$iv, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                                    RecomposeScopeImpl scope = (RecomposeScopeImpl) item$iv$iv;
                                                    if (scope.getValid()) {
                                                        if (destinationIndex$iv$iv2 != i$iv$iv2) {
                                                            set$iv$iv.getValues()[destinationIndex$iv$iv2] = item$iv$iv;
                                                        }
                                                        destinationIndex$iv$iv2++;
                                                    }
                                                    i$iv$iv2++;
                                                    this_$iv = this_$iv2;
                                                    $i$f$trace = $i$f$trace2;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    Trace.INSTANCE.endSection(token$iv2);
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                Trace.INSTANCE.endSection(token$iv2);
                                                throw th;
                                            }
                                        }
                                        int $i$f$trace3 = $i$f$trace;
                                        IdentityScopeMap this_$iv3 = this_$iv;
                                        int size4 = set$iv$iv.size();
                                        for (int i$iv$iv3 = destinationIndex$iv$iv2; i$iv$iv3 < size4; i$iv$iv3++) {
                                            set$iv$iv.getValues()[i$iv$iv3] = null;
                                        }
                                        set$iv$iv.setSize(destinationIndex$iv$iv2);
                                        if (set$iv$iv.size() > 0) {
                                            if (destinationIndex$iv$iv != i$iv$iv) {
                                                int destinationKeyOrder$iv$iv = this_$iv.getValueOrder()[destinationIndex$iv$iv];
                                                this_$iv.getValueOrder()[destinationIndex$iv$iv] = valueIndex$iv$iv;
                                                this_$iv.getValueOrder()[i$iv$iv] = destinationKeyOrder$iv$iv;
                                            }
                                            destinationIndex$iv$iv++;
                                        }
                                        i$iv$iv++;
                                        sectionName$iv = sectionName$iv2;
                                        this_$iv = this_$iv3;
                                        i = i2;
                                        $i$f$trace = $i$f$trace3;
                                    }
                                    int size5 = this_$iv.getSize();
                                    for (int i$iv$iv4 = destinationIndex$iv$iv; i$iv$iv4 < size5; i$iv$iv4++) {
                                        this_$iv.getValues()[this_$iv.getValueOrder()[i$iv$iv4]] = null;
                                    }
                                    this_$iv.setSize(destinationIndex$iv$iv);
                                    cleanUpDerivedStateObservations();
                                    Unit unit3 = Unit.INSTANCE;
                                    Trace.INSTANCE.endSection(token$iv2);
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                            if (this.lateChanges.isEmpty()) {
                                manager.dispatchAbandons();
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            writer$iv.close();
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    Trace.INSTANCE.endSection(token$iv);
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } finally {
            if (this.lateChanges.isEmpty()) {
                manager.dispatchAbandons();
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } finally {
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            try {
                if (!this.lateChanges.isEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } finally {
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            try {
                this.composer.changesApplied$runtime_release();
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } finally {
            }
        }
    }

    private final <T> T guardInvalidationsLocked(Function1<? super IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>>, ? extends T> block) {
        IdentityArrayMap invalidations = takeInvalidations();
        try {
            return block.invoke(invalidations);
        } catch (Exception e) {
            this.invalidations = invalidations;
            throw e;
        }
    }

    private final <T> T guardChanges(Function0<? extends T> block) {
        try {
            try {
                T invoke = block.invoke();
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                return invoke;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                if (0 == 0 && !this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } catch (Exception e) {
            abandonChanges();
            throw e;
        }
    }

    private final void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        this.abandonSet.clear();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            Object[] $this$forEach$iv = this.slotTable.getSlots();
            for (Object element$iv : $this$forEach$iv) {
                RecomposeScopeImpl recomposeScopeImpl = element$iv instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) element$iv : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.invalidate();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void verifyConsistent() {
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            if (!isComposing()) {
                this.composer.verifyConsistent$runtime_release();
                this.slotTable.verifyWellFormed();
                validateRecomposeScopeAnchors(this.slotTable);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public <R> R delegateInvalidations(ControlledComposition to, int groupIndex, Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (to != null && !Intrinsics.areEqual(to, this) && groupIndex >= 0) {
            this.invalidationDelegate = (CompositionImpl) to;
            this.invalidationDelegateGroup = groupIndex;
            try {
                return block.invoke();
            } finally {
                this.invalidationDelegate = null;
                this.invalidationDelegateGroup = 0;
            }
        }
        return block.invoke();
    }

    public final InvalidationResult invalidate(RecomposeScopeImpl scope, Object instance) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (scope.getDefaultsInScope()) {
            scope.setDefaultsInvalid(true);
        }
        Anchor anchor = scope.getAnchor();
        if (anchor == null || !this.slotTable.ownsAnchor(anchor) || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (!anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (!scope.getCanRecompose()) {
            return InvalidationResult.IGNORED;
        }
        return invalidateChecked(scope, anchor, instance);
    }

    private final InvalidationResult invalidateChecked(RecomposeScopeImpl scope, Anchor anchor, Object instance) {
        CompositionImpl compositionImpl;
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            CompositionImpl changeDelegate = this.invalidationDelegate;
            if (changeDelegate == null) {
                compositionImpl = null;
            } else if (this.slotTable.groupContainsAnchor(this.invalidationDelegateGroup, anchor)) {
                compositionImpl = changeDelegate;
            } else {
                compositionImpl = null;
            }
            CompositionImpl delegate = compositionImpl;
            if (delegate == null) {
                if (isComposing() && this.composer.tryImminentInvalidation$runtime_release(scope, instance)) {
                    return InvalidationResult.IMMINENT;
                }
                if (instance != null) {
                    CompositionKt.addValue(this.invalidations, scope, instance);
                } else {
                    this.invalidations.set(scope, null);
                }
            }
            if (delegate != null) {
                return delegate.invalidateChecked(scope, anchor, instance);
            }
            this.parent.invalidate$runtime_release(this);
            return isComposing() ? InvalidationResult.DEFERRED : InvalidationResult.SCHEDULED;
        }
    }

    public final void removeObservation$runtime_release(Object instance, RecomposeScopeImpl scope) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.observations.remove(instance, scope);
    }

    public final void removeDerivedStateObservation$runtime_release(DerivedState<?> state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (!this.observations.contains(state)) {
            this.derivedStates.removeScope(state);
        }
    }

    private final IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations() {
        IdentityArrayMap invalidations = this.invalidations;
        this.invalidations = new IdentityArrayMap<>(0, 1, null);
        return invalidations;
    }

    private final void validateRecomposeScopeAnchors(SlotTable slotTable) {
        Object[] $this$mapNotNull$iv = slotTable.getSlots();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            RecomposeScopeImpl recomposeScopeImpl = element$iv$iv$iv instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) element$iv$iv$iv : null;
            if (recomposeScopeImpl != null) {
                destination$iv$iv.add(recomposeScopeImpl);
            }
        }
        List scopes = (List) destination$iv$iv;
        int size = scopes.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = scopes.get(index$iv);
            RecomposeScopeImpl scope = (RecomposeScopeImpl) item$iv;
            Anchor anchor = scope.getAnchor();
            if (anchor != null && !slotTable.slotsOf$runtime_release(anchor.toIndexFor(slotTable)).contains(scope)) {
                int dataIndex = ArraysKt.indexOf((RecomposeScopeImpl[]) slotTable.getSlots(), scope);
                throw new IllegalStateException(("Misaligned anchor " + anchor + " in scope " + scope + " encountered, scope found at " + dataIndex).toString());
            }
        }
    }

    private final <T> T trackAbandonedValues(Function0<? extends T> block) {
        try {
            T invoke = block.invoke();
            InlineMarker.finallyStart(1);
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            if (0 == 0 && !this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    /* compiled from: Composition.kt */
    @Metadata(m286d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0010\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0016\u0010\u0010\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m287d2 = {"Landroidx/compose/runtime/CompositionImpl$RememberEventDispatcher;", "Landroidx/compose/runtime/RememberManager;", "abandoning", "", "Landroidx/compose/runtime/RememberObserver;", "(Ljava/util/Set;)V", "forgetting", "", "remembering", "sideEffects", "Lkotlin/Function0;", "", "dispatchAbandons", "dispatchRememberObservers", "dispatchSideEffects", "instance", "sideEffect", "effect", "runtime_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    private static final class RememberEventDispatcher implements RememberManager {
        private final Set<RememberObserver> abandoning;
        private final List<RememberObserver> forgetting;
        private final List<RememberObserver> remembering;
        private final List<Function0<Unit>> sideEffects;

        public RememberEventDispatcher(Set<RememberObserver> abandoning) {
            Intrinsics.checkNotNullParameter(abandoning, "abandoning");
            this.abandoning = abandoning;
            this.remembering = new ArrayList();
            this.forgetting = new ArrayList();
            this.sideEffects = new ArrayList();
        }

        @Override // androidx.compose.runtime.RememberManager
        public void remembering(RememberObserver instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            int index = this.forgetting.lastIndexOf(instance);
            if (index >= 0) {
                this.forgetting.remove(index);
                this.abandoning.remove(instance);
            } else {
                this.remembering.add(instance);
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public void forgetting(RememberObserver instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            int index = this.remembering.lastIndexOf(instance);
            if (index >= 0) {
                this.remembering.remove(index);
                this.abandoning.remove(instance);
            } else {
                this.forgetting.add(instance);
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public void sideEffect(Function0<Unit> effect) {
            Intrinsics.checkNotNullParameter(effect, "effect");
            this.sideEffects.add(effect);
        }

        public final void dispatchRememberObservers() {
            Object token$iv;
            if (!this.forgetting.isEmpty()) {
                token$iv = Trace.INSTANCE.beginSection("Compose:onForgotten");
                try {
                    for (int i = this.forgetting.size() - 1; -1 < i; i--) {
                        RememberObserver instance = this.forgetting.get(i);
                        if (!this.abandoning.contains(instance)) {
                            instance.onForgotten();
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                }
            }
            if (!this.remembering.isEmpty()) {
                token$iv = Trace.INSTANCE.beginSection("Compose:onRemembered");
                try {
                    List $this$fastForEach$iv = this.remembering;
                    int size = $this$fastForEach$iv.size();
                    for (int index$iv = 0; index$iv < size; index$iv++) {
                        Object item$iv = $this$fastForEach$iv.get(index$iv);
                        RememberObserver instance2 = (RememberObserver) item$iv;
                        this.abandoning.remove(instance2);
                        instance2.onRemembered();
                    }
                    Unit unit2 = Unit.INSTANCE;
                } finally {
                }
            }
        }

        public final void dispatchSideEffects() {
            if (!this.sideEffects.isEmpty()) {
                Object token$iv = Trace.INSTANCE.beginSection("Compose:sideeffects");
                try {
                    List $this$fastForEach$iv = this.sideEffects;
                    int size = $this$fastForEach$iv.size();
                    for (int index$iv = 0; index$iv < size; index$iv++) {
                        Object item$iv = $this$fastForEach$iv.get(index$iv);
                        Function0 sideEffect = (Function0) item$iv;
                        sideEffect.invoke();
                    }
                    this.sideEffects.clear();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(token$iv);
                }
            }
        }

        public final void dispatchAbandons() {
            if (!this.abandoning.isEmpty()) {
                Object token$iv = Trace.INSTANCE.beginSection("Compose:abandons");
                try {
                    Iterator iterator = this.abandoning.iterator();
                    while (iterator.hasNext()) {
                        RememberObserver instance = iterator.next();
                        iterator.remove();
                        instance.onAbandoned();
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(token$iv);
                }
            }
        }
    }
}
