package androidx.compose.runtime;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.navigation.compose.ComposeNavigator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: Recomposer.kt */
@Metadata(m286d1 = {"\u0000\u009c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 §\u00012\u00020\u0001:\n§\u0001¨\u0001©\u0001ª\u0001«\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020QH\u0002J\u0006\u0010R\u001a\u00020SJ\u0011\u0010T\u001a\u00020NH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u0011\u0010V\u001a\u00020NH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u0006\u0010W\u001a\u00020NJ\u0006\u0010X\u001a\u00020NJ*\u0010Y\u001a\u00020N2\u0006\u0010Z\u001a\u00020\u00172\u0011\u0010[\u001a\r\u0012\u0004\u0012\u00020N0\\¢\u0006\u0002\b]H\u0010¢\u0006\u0004\b^\u0010_J:\u0010`\u001a\u0002Ha\"\u0004\b\u0000\u0010a2\u0006\u0010Z\u001a\u00020\u00172\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010c2\f\u0010d\u001a\b\u0012\u0004\u0012\u0002Ha0\\H\u0082\b¢\u0006\u0002\u0010eJ\u0015\u0010f\u001a\u00020N2\u0006\u0010g\u001a\u00020\u001aH\u0010¢\u0006\u0002\bhJ\u0010\u0010i\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010MH\u0002J\b\u0010j\u001a\u00020NH\u0002J\u0015\u0010k\u001a\u00020N2\u0006\u0010g\u001a\u00020\u001aH\u0010¢\u0006\u0002\blJ\u0015\u0010m\u001a\u00020N2\u0006\u0010Z\u001a\u00020\u0017H\u0010¢\u0006\u0002\bnJ\u0015\u0010o\u001a\u00020N2\u0006\u0010p\u001a\u00020qH\u0010¢\u0006\u0002\brJ\u0011\u0010s\u001a\u00020NH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u001d\u0010t\u001a\u00020N2\u0006\u0010g\u001a\u00020\u001a2\u0006\u0010u\u001a\u00020\u001bH\u0010¢\u0006\u0002\bvJ\u0017\u0010w\u001a\u0004\u0018\u00010\u001b2\u0006\u0010g\u001a\u00020\u001aH\u0010¢\u0006\u0002\bxJ\u0010\u0010y\u001a\u00020N2\u0006\u0010Z\u001a\u00020\u0017H\u0002J,\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00170{2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020\u001a0{2\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010cH\u0002J\"\u0010}\u001a\u0004\u0018\u00010\u00172\u0006\u0010Z\u001a\u00020\u00172\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010cH\u0002J.\u0010~\u001a\u00020N2\f\u0010\u007f\u001a\b0\u0080\u0001j\u0003`\u0081\u00012\u000b\b\u0002\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00172\t\b\u0002\u0010\u0083\u0001\u001a\u00020\u0012H\u0002J\u001e\u0010\u0084\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020N0\u0085\u00012\u0006\u0010Z\u001a\u00020\u0017H\u0002JY\u0010\u0086\u0001\u001a\u00020N2D\u0010d\u001a@\b\u0001\u0012\u0005\u0012\u00030\u0088\u0001\u0012\u0017\u0012\u00150\u0089\u0001¢\u0006\u000f\b\u008a\u0001\u0012\n\b\u008b\u0001\u0012\u0005\b\b(\u008c\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020N0\u008d\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0087\u0001¢\u0006\u0003\b\u008e\u0001H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010\u008f\u0001J\t\u0010\u0090\u0001\u001a\u00020NH\u0002J \u0010\u0090\u0001\u001a\u00020N2\u0014\u0010\u0091\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020N0\u0085\u0001H\u0082\bJ \u0010\u0092\u0001\u001a\u00020N2\u000f\u0010\u0093\u0001\u001a\n\u0012\u0005\u0012\u00030\u0095\u00010\u0094\u0001H\u0010¢\u0006\u0003\b\u0096\u0001J\u0017\u0010\u0097\u0001\u001a\u00020N2\u0006\u0010Z\u001a\u00020\u0017H\u0010¢\u0006\u0003\b\u0098\u0001J\u0012\u0010\u0099\u0001\u001a\u00020N2\u0007\u0010\u009a\u0001\u001a\u00020@H\u0002J\u000b\u0010\u009b\u0001\u001a\u0004\u0018\u00010/H\u0002J\t\u0010\u009c\u0001\u001a\u00020NH\u0002J'\u0010\u009d\u0001\u001a\u00020N2\b\u0010\u008c\u0001\u001a\u00030\u0089\u00012\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010 \u0001J\u0012\u0010¡\u0001\u001a\u00020NH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u001b\u0010¢\u0001\u001a\u00020N2\u0006\u0010;\u001a\u00020\u0003H\u0087@ø\u0001\u0000¢\u0006\u0003\u0010£\u0001J\u0017\u0010¤\u0001\u001a\u00020N2\u0006\u0010Z\u001a\u00020\u0017H\u0010¢\u0006\u0003\b¥\u0001J.\u0010¦\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020N0\u0085\u00012\u0006\u0010Z\u001a\u00020\u00172\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010cH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u001d\u001a\u001c\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00160\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\"8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070'8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010\u0002\u001a\u00020\u0003X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00100\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0014R\u0014\u00103\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0014R\u0011\u00105\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b6\u0010\u0014R\u0014\u00107\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0014R\u000e\u00109\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u00020\u00038PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b<\u0010+R\u0012\u0010=\u001a\u00060>R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u0014R\u001a\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0D0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010E\u001a\b\u0012\u0004\u0012\u00020\u00070F8FX\u0087\u0004¢\u0006\f\u0012\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u000e\u0010K\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010L\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006¬\u0001"}, m287d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$State;", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "<set-?>", "", "changeCount", "getChangeCount", "()J", "closeCause", "", "collectingParameterInformation", "", "getCollectingParameterInformation$runtime_release", "()Z", "compositionInvalidations", "", "Landroidx/compose/runtime/ControlledComposition;", "compositionValueStatesAvailable", "", "Landroidx/compose/runtime/MovableContentStateReference;", "Landroidx/compose/runtime/MovableContentState;", "compositionValuesAwaitingInsert", "compositionValuesRemoved", "Landroidx/compose/runtime/MovableContent;", "", "compositionsAwaitingApply", "compoundHashKey", "", "getCompoundHashKey$runtime_release", "()I", "concurrentCompositionsOutstanding", "currentState", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentState", "()Lkotlinx/coroutines/flow/StateFlow;", "getEffectCoroutineContext$runtime_release", "()Lkotlin/coroutines/CoroutineContext;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "errorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "failedCompositions", "hasConcurrentFrameWorkLocked", "getHasConcurrentFrameWorkLocked", "hasFrameWorkLocked", "getHasFrameWorkLocked", "hasPendingWork", "getHasPendingWork", "hasSchedulingWork", "getHasSchedulingWork", "isClosed", "knownCompositions", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "runnerJob", "Lkotlinx/coroutines/Job;", "shouldKeepRecomposing", "getShouldKeepRecomposing", "snapshotInvalidations", "", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "()V", "getState", "()Lkotlinx/coroutines/flow/Flow;", "stateLock", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "applyAndCheck", "snapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "asRecomposerInfo", "Landroidx/compose/runtime/RecomposerInfo;", "awaitIdle", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitWorkAvailable", "cancel", "close", "composeInitial", "composition", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composing", "T", "modifiedValues", "Landroidx/compose/runtime/collection/IdentityArraySet;", "block", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/collection/IdentityArraySet;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "deletedMovableContent", "reference", "deletedMovableContent$runtime_release", "deriveStateLocked", "discardUnusedValues", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "join", "movableContentStateReleased", "data", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "performInitialMovableContentInserts", "performInsertValues", "", "references", "performRecompose", "processCompositionError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "failedInitialComposition", "recoverable", "readObserverOf", "Lkotlin/Function1;", "recompositionRunner", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "parentFrameClock", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordComposerModificationsLocked", "onEachInvalidComposition", "recordInspectionTable", "table", "", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime_release", "registerComposition", "registerComposition$runtime_release", "registerRunnerJob", "callingJob", "resetErrorState", "retryFailedCompositions", "runFrameLoop", "frameSignal", "Landroidx/compose/runtime/ProduceFrameSignal;", "(Landroidx/compose/runtime/MonotonicFrameClock;Landroidx/compose/runtime/ProduceFrameSignal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runRecomposeAndApplyChanges", "runRecomposeConcurrentlyAndApplyChanges", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterComposition", "unregisterComposition$runtime_release", "writeObserverOf", "Companion", "HotReloadable", "RecomposerErrorState", "RecomposerInfoImpl", "State", "runtime_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class Recomposer extends CompositionContext {
    private final MutableStateFlow<State> _state;
    private final BroadcastFrameClock broadcastFrameClock;
    private long changeCount;
    private Throwable closeCause;
    private final List<ControlledComposition> compositionInvalidations;
    private final Map<MovableContentStateReference, MovableContentState> compositionValueStatesAvailable;
    private final List<MovableContentStateReference> compositionValuesAwaitingInsert;
    private final Map<MovableContent<Object>, List<MovableContentStateReference>> compositionValuesRemoved;
    private final List<ControlledComposition> compositionsAwaitingApply;
    private int concurrentCompositionsOutstanding;
    private final CoroutineContext effectCoroutineContext;
    private final CompletableJob effectJob;
    private RecomposerErrorState errorState;
    private List<ControlledComposition> failedCompositions;
    private boolean isClosed;
    private final List<ControlledComposition> knownCompositions;
    private final RecomposerInfoImpl recomposerInfo;
    private Job runnerJob;
    private final List<Set<Object>> snapshotInvalidations;
    private final Object stateLock;
    private CancellableContinuation<? super Unit> workContinuation;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final MutableStateFlow<PersistentSet<RecomposerInfoImpl>> _runningRecomposers = StateFlowKt.MutableStateFlow(ExtensionsKt.persistentSetOf());
    private static final AtomicReference<Boolean> _hotReloadEnabled = new AtomicReference<>(false);

    /* compiled from: Recomposer.kt */
    @Metadata(m286d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m287d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public enum State {
        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork
    }

    @Deprecated(message = "Replaced by currentState as a StateFlow", replaceWith = @ReplaceWith(expression = "currentState", imports = {}))
    public static /* synthetic */ void getState$annotations() {
    }

    public Recomposer(CoroutineContext effectCoroutineContext) {
        Intrinsics.checkNotNullParameter(effectCoroutineContext, "effectCoroutineContext");
        this.broadcastFrameClock = new BroadcastFrameClock(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$broadcastFrameClock$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CancellableContinuation deriveStateLocked;
                MutableStateFlow mutableStateFlow;
                Throwable th;
                Object lock$iv = Recomposer.this.stateLock;
                Recomposer recomposer = Recomposer.this;
                synchronized (lock$iv) {
                    deriveStateLocked = recomposer.deriveStateLocked();
                    mutableStateFlow = recomposer._state;
                    if (((Recomposer.State) mutableStateFlow.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0) {
                        th = recomposer.closeCause;
                        throw ExceptionsKt.CancellationException("Recomposer shutdown; frame clock awaiter will never resume", th);
                    }
                }
                if (deriveStateLocked != null) {
                    Result.Companion companion = Result.INSTANCE;
                    deriveStateLocked.resumeWith(Result.m4732constructorimpl(Unit.INSTANCE));
                }
            }
        });
        CompletableJob $this$effectJob_u24lambda_u2d0 = JobKt.Job((Job) effectCoroutineContext.get(Job.INSTANCE));
        $this$effectJob_u24lambda_u2d0.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final Throwable throwable) {
                Job runnerJob;
                MutableStateFlow mutableStateFlow;
                MutableStateFlow mutableStateFlow2;
                boolean z;
                CancellableContinuation cancellableContinuation;
                Object obj;
                CancellationException cancellation = ExceptionsKt.CancellationException("Recomposer effect job completed", throwable);
                Object continuationToResume = null;
                Object lock$iv = Recomposer.this.stateLock;
                final Recomposer recomposer = Recomposer.this;
                synchronized (lock$iv) {
                    runnerJob = recomposer.runnerJob;
                    if (runnerJob != null) {
                        mutableStateFlow2 = recomposer._state;
                        mutableStateFlow2.setValue(Recomposer.State.ShuttingDown);
                        z = recomposer.isClosed;
                        if (z) {
                            cancellableContinuation = recomposer.workContinuation;
                            if (cancellableContinuation != null) {
                                obj = recomposer.workContinuation;
                                continuationToResume = obj;
                            }
                        } else {
                            runnerJob.cancel(cancellation);
                        }
                        recomposer.workContinuation = null;
                        runnerJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                invoke2(th);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable runnerJobCause) {
                                MutableStateFlow mutableStateFlow3;
                                Object lock$iv2 = Recomposer.this.stateLock;
                                Recomposer recomposer2 = Recomposer.this;
                                Throwable $this$invoke_u24lambda_u2d3_u24lambda_u2d2 = throwable;
                                synchronized (lock$iv2) {
                                    if ($this$invoke_u24lambda_u2d3_u24lambda_u2d2 == null) {
                                        $this$invoke_u24lambda_u2d3_u24lambda_u2d2 = null;
                                    } else if (runnerJobCause != null) {
                                        Throwable it = runnerJobCause instanceof CancellationException ? null : runnerJobCause;
                                        if (it != null) {
                                            kotlin.ExceptionsKt.addSuppressed($this$invoke_u24lambda_u2d3_u24lambda_u2d2, it);
                                        }
                                    }
                                    recomposer2.closeCause = $this$invoke_u24lambda_u2d3_u24lambda_u2d2;
                                    mutableStateFlow3 = recomposer2._state;
                                    mutableStateFlow3.setValue(Recomposer.State.ShutDown);
                                    Unit unit = Unit.INSTANCE;
                                }
                            }
                        });
                    } else {
                        recomposer.closeCause = cancellation;
                        mutableStateFlow = recomposer._state;
                        mutableStateFlow.setValue(Recomposer.State.ShutDown);
                        Unit unit = Unit.INSTANCE;
                    }
                }
                if (continuationToResume != null) {
                    Result.Companion companion = Result.INSTANCE;
                    ((Continuation) continuationToResume).resumeWith(Result.m4732constructorimpl(Unit.INSTANCE));
                }
            }
        });
        this.effectJob = $this$effectJob_u24lambda_u2d0;
        this.effectCoroutineContext = effectCoroutineContext.plus(this.broadcastFrameClock).plus(this.effectJob);
        this.stateLock = new Object();
        this.knownCompositions = new ArrayList();
        this.snapshotInvalidations = new ArrayList();
        this.compositionInvalidations = new ArrayList();
        this.compositionsAwaitingApply = new ArrayList();
        this.compositionValuesAwaitingInsert = new ArrayList();
        this.compositionValuesRemoved = new LinkedHashMap();
        this.compositionValueStatesAvailable = new LinkedHashMap();
        this._state = StateFlowKt.MutableStateFlow(State.Inactive);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    @Override // androidx.compose.runtime.CompositionContext
    /* renamed from: getEffectCoroutineContext$runtime_release, reason: from getter */
    public CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
        return EmptyCoroutineContext.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CancellableContinuation<Unit> deriveStateLocked() {
        State newState;
        if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
            this.knownCompositions.clear();
            this.snapshotInvalidations.clear();
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.compositionValuesAwaitingInsert.clear();
            this.failedCompositions = null;
            CancellableContinuation<? super Unit> cancellableContinuation = this.workContinuation;
            if (cancellableContinuation != null) {
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, null, 1, null);
            }
            this.workContinuation = null;
            this.errorState = null;
            return null;
        }
        if (this.errorState != null) {
            newState = State.Inactive;
        } else if (this.runnerJob == null) {
            this.snapshotInvalidations.clear();
            this.compositionInvalidations.clear();
            newState = this.broadcastFrameClock.getHasAwaiters() ? State.InactivePendingWork : State.Inactive;
        } else if (!this.compositionInvalidations.isEmpty() || !this.snapshotInvalidations.isEmpty() || !this.compositionsAwaitingApply.isEmpty() || !this.compositionValuesAwaitingInsert.isEmpty() || this.concurrentCompositionsOutstanding > 0 || this.broadcastFrameClock.getHasAwaiters()) {
            newState = State.PendingWork;
        } else {
            newState = State.Idle;
        }
        this._state.setValue(newState);
        if (newState != State.PendingWork) {
            return null;
        }
        CancellableContinuation cancellableContinuation2 = this.workContinuation;
        this.workContinuation = null;
        return cancellableContinuation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldKeepRecomposing() {
        boolean z;
        Sequence $this$any$iv;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            z = this.isClosed;
        }
        if (!z) {
            return true;
        }
        Sequence $this$any$iv2 = this.effectJob.getChildren();
        Iterator<Job> it = $this$any$iv2.iterator();
        while (true) {
            if (it.hasNext()) {
                Object element$iv = it.next();
                Job it2 = (Job) element$iv;
                if (it2.isActive()) {
                    $this$any$iv = 1;
                    break;
                }
            } else {
                $this$any$iv = null;
                break;
            }
        }
        return $this$any$iv != null;
    }

    public final Flow<State> getState() {
        return getCurrentState();
    }

    public final StateFlow<State> getCurrentState() {
        return this._state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Recomposer.kt */
    @Metadata(m286d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001a\u001a\u00020\u0015J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, m287d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", "(Landroidx/compose/runtime/Recomposer;)V", "changeCount", "", "getChangeCount", "()J", "currentError", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentError", "()Landroidx/compose/runtime/RecomposerErrorInfo;", "hasPendingWork", "", "getHasPendingWork", "()Z", "state", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "invalidateGroupsWithKey", "", "key", "", "resetErrorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "retryFailedCompositions", "saveStateAndDisposeForHotReload", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "runtime_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    final class RecomposerInfoImpl implements RecomposerInfo {
        public RecomposerInfoImpl() {
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public Flow<State> getState() {
            return Recomposer.this.getCurrentState();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public boolean getHasPendingWork() {
            return Recomposer.this.getHasPendingWork();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public long getChangeCount() {
            return Recomposer.this.getChangeCount();
        }

        public final RecomposerErrorInfo getCurrentError() {
            RecomposerErrorState recomposerErrorState;
            Object lock$iv = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (lock$iv) {
                recomposerErrorState = recomposer.errorState;
            }
            return recomposerErrorState;
        }

        public final void invalidateGroupsWithKey(int key) {
            List $this$fastMapNotNull$iv;
            Object lock$iv = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (lock$iv) {
                $this$fastMapNotNull$iv = CollectionsKt.toMutableList((Collection) recomposer.knownCompositions);
            }
            List target$iv = new ArrayList($this$fastMapNotNull$iv.size());
            int size = $this$fastMapNotNull$iv.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                Object item$iv$iv = $this$fastMapNotNull$iv.get(index$iv$iv);
                ControlledComposition it = (ControlledComposition) item$iv$iv;
                CompositionImpl compositionImpl = it instanceof CompositionImpl ? (CompositionImpl) it : null;
                if (compositionImpl != null) {
                    target$iv.add(compositionImpl);
                }
            }
            List $this$fastForEach$iv = target$iv;
            int size2 = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size2; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                ((CompositionImpl) item$iv).invalidateGroupsWithKey(key);
            }
        }

        public final List<HotReloadable> saveStateAndDisposeForHotReload() {
            List compositions;
            Object lock$iv = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (lock$iv) {
                compositions = CollectionsKt.toMutableList((Collection) recomposer.knownCompositions);
            }
            List target$iv = new ArrayList(compositions.size());
            int size = compositions.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                Object item$iv$iv = compositions.get(index$iv$iv);
                ControlledComposition it = (ControlledComposition) item$iv$iv;
                CompositionImpl compositionImpl = it instanceof CompositionImpl ? (CompositionImpl) it : null;
                if (compositionImpl != null) {
                    target$iv.add(compositionImpl);
                }
            }
            List $this$fastMap$iv = target$iv;
            List target$iv2 = new ArrayList($this$fastMap$iv.size());
            int size2 = $this$fastMap$iv.size();
            for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                Object item$iv$iv2 = $this$fastMap$iv.get(index$iv$iv2);
                HotReloadable $this$saveStateAndDisposeForHotReload_u24lambda_u2d7_u24lambda_u2d6 = new HotReloadable((CompositionImpl) item$iv$iv2);
                $this$saveStateAndDisposeForHotReload_u24lambda_u2d7_u24lambda_u2d6.clearContent();
                target$iv2.add($this$saveStateAndDisposeForHotReload_u24lambda_u2d7_u24lambda_u2d6);
            }
            return target$iv2;
        }

        public final RecomposerErrorState resetErrorState() {
            return Recomposer.this.resetErrorState();
        }

        public final void retryFailedCompositions() {
            Recomposer.this.retryFailedCompositions();
        }
    }

    /* compiled from: Recomposer.kt */
    @Metadata(m286d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007R\u001b\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m287d2 = {"Landroidx/compose/runtime/Recomposer$HotReloadable;", "", "composition", "Landroidx/compose/runtime/CompositionImpl;", "(Landroidx/compose/runtime/CompositionImpl;)V", ComposeNavigator.NAME, "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "clearContent", "recompose", "resetContent", "runtime_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    private static final class HotReloadable {
        private Function2<? super Composer, ? super Integer, Unit> composable;
        private final CompositionImpl composition;

        public HotReloadable(CompositionImpl composition) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            this.composition = composition;
            this.composable = this.composition.getComposable();
        }

        public final void clearContent() {
            if (this.composition.getIsRoot()) {
                this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.m1627getLambda1$runtime_release());
            }
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }

        public final void recompose() {
            if (this.composition.getIsRoot()) {
                this.composition.setContent(this.composable);
            }
        }
    }

    /* compiled from: Recomposer.kt */
    @Metadata(m286d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m287d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "Landroidx/compose/runtime/RecomposerErrorInfo;", "recoverable", "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(ZLjava/lang/Exception;)V", "getCause", "()Ljava/lang/Exception;", "getRecoverable", "()Z", "runtime_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    private static final class RecomposerErrorState implements RecomposerErrorInfo {
        private final Exception cause;
        private final boolean recoverable;

        public RecomposerErrorState(boolean recoverable, Exception cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            this.recoverable = recoverable;
            this.cause = cause;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public boolean getRecoverable() {
            return this.recoverable;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public Exception getCause() {
            return this.cause;
        }
    }

    public final RecomposerInfo asRecomposerInfo() {
        return this.recomposerInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordComposerModificationsLocked() {
        if (!this.snapshotInvalidations.isEmpty()) {
            List $this$fastForEach$iv = this.snapshotInvalidations;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                Set changes = (Set) item$iv;
                List $this$fastForEach$iv2 = this.knownCompositions;
                int size2 = $this$fastForEach$iv2.size();
                for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                    Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
                    ControlledComposition composition = (ControlledComposition) item$iv2;
                    composition.recordModificationsOf(changes);
                }
            }
            this.snapshotInvalidations.clear();
            if (deriveStateLocked() != null) {
                throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
            }
        }
    }

    private final void recordComposerModificationsLocked(Function1<? super ControlledComposition, Unit> onEachInvalidComposition) {
        if (!this.snapshotInvalidations.isEmpty()) {
            List $this$fastForEach$iv = this.snapshotInvalidations;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                Set changes = (Set) item$iv;
                List $this$fastForEach$iv2 = this.knownCompositions;
                int size2 = $this$fastForEach$iv2.size();
                for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                    Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
                    ControlledComposition composition = (ControlledComposition) item$iv2;
                    composition.recordModificationsOf(changes);
                }
            }
            this.snapshotInvalidations.clear();
        }
        List $this$fastForEach$iv3 = this.compositionInvalidations;
        int size3 = $this$fastForEach$iv3.size();
        for (int index$iv3 = 0; index$iv3 < size3; index$iv3++) {
            Object item$iv3 = $this$fastForEach$iv3.get(index$iv3);
            onEachInvalidComposition.invoke(item$iv3);
        }
        this.compositionInvalidations.clear();
        if (deriveStateLocked() != null) {
            throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerRunnerJob(Job callingJob) {
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            Throwable it = this.closeCause;
            if (it != null) {
                throw it;
            }
            if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down".toString());
            }
            if (this.runnerJob != null) {
                throw new IllegalStateException("Recomposer already running".toString());
            }
            this.runnerJob = callingJob;
            deriveStateLocked();
        }
    }

    public final Object runRecomposeAndApplyChanges(Continuation<? super Unit> continuation) {
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeAndApplyChanges$2(this, null), continuation);
        return recompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? recompositionRunner : Unit.INSTANCE;
    }

    static /* synthetic */ void processCompositionError$default(Recomposer recomposer, Exception exc, ControlledComposition controlledComposition, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            controlledComposition = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        recomposer.processCompositionError(exc, controlledComposition, z);
    }

    private final void processCompositionError(Exception e, ControlledComposition failedInitialComposition, boolean recoverable) {
        Boolean bool = _hotReloadEnabled.get();
        Intrinsics.checkNotNullExpressionValue(bool, "_hotReloadEnabled.get()");
        if (!bool.booleanValue()) {
            throw e;
        }
        if (!(e instanceof ComposeRuntimeError)) {
            Object lock$iv = this.stateLock;
            synchronized (lock$iv) {
                this.compositionsAwaitingApply.clear();
                this.compositionInvalidations.clear();
                this.snapshotInvalidations.clear();
                this.compositionValuesAwaitingInsert.clear();
                this.compositionValuesRemoved.clear();
                this.compositionValueStatesAvailable.clear();
                this.errorState = new RecomposerErrorState(recoverable, e);
                if (failedInitialComposition != null) {
                    List it = this.failedCompositions;
                    if (it == null) {
                        it = new ArrayList();
                        this.failedCompositions = it;
                    }
                    if (!it.contains(failedInitialComposition)) {
                        it.add(failedInitialComposition);
                    }
                    this.knownCompositions.remove(failedInitialComposition);
                }
                deriveStateLocked();
            }
            return;
        }
        throw e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecomposerErrorState resetErrorState() {
        RecomposerErrorState error;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            error = this.errorState;
            if (error != null) {
                this.errorState = null;
                deriveStateLocked();
            }
        }
        return error;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retryFailedCompositions() {
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            List failedCompositions = this.failedCompositions;
            if (failedCompositions == null) {
                return;
            }
            while (!failedCompositions.isEmpty()) {
                ControlledComposition composition = (ControlledComposition) CollectionsKt.removeLast(failedCompositions);
                if (composition instanceof CompositionImpl) {
                    composition.invalidateAll();
                    composition.setContent(((CompositionImpl) composition).getComposable());
                    if (this.errorState != null) {
                        break;
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @ExperimentalComposeApi
    public final Object runRecomposeConcurrentlyAndApplyChanges(CoroutineContext recomposeCoroutineContext, Continuation<? super Unit> continuation) {
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(recomposeCoroutineContext, this, null), continuation);
        return recompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? recompositionRunner : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00af -> B:12:0x0077). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runFrameLoop(MonotonicFrameClock parentFrameClock, ProduceFrameSignal frameSignal, Continuation<? super Unit> continuation) {
        Recomposer$runFrameLoop$1 recomposer$runFrameLoop$1;
        Recomposer$runFrameLoop$1 recomposer$runFrameLoop$12;
        Recomposer recomposer;
        List toRecompose;
        List toApply;
        final List toApply2;
        final List toRecompose2;
        final ProduceFrameSignal frameSignal2;
        MonotonicFrameClock parentFrameClock2;
        final Recomposer recomposer2;
        Function1<Long, CancellableContinuation<? super Unit>> function1;
        Object obj;
        if (continuation instanceof Recomposer$runFrameLoop$1) {
            recomposer$runFrameLoop$1 = (Recomposer$runFrameLoop$1) continuation;
            if ((recomposer$runFrameLoop$1.label & Integer.MIN_VALUE) != 0) {
                recomposer$runFrameLoop$1.label -= Integer.MIN_VALUE;
                recomposer$runFrameLoop$12 = recomposer$runFrameLoop$1;
                Object $result = recomposer$runFrameLoop$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (recomposer$runFrameLoop$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        recomposer = this;
                        toRecompose = new ArrayList();
                        toApply = new ArrayList();
                        obj = recomposer.stateLock;
                        recomposer$runFrameLoop$12.L$0 = recomposer;
                        recomposer$runFrameLoop$12.L$1 = parentFrameClock;
                        recomposer$runFrameLoop$12.L$2 = frameSignal;
                        recomposer$runFrameLoop$12.L$3 = toRecompose;
                        recomposer$runFrameLoop$12.L$4 = toApply;
                        recomposer$runFrameLoop$12.label = 1;
                        if (frameSignal.awaitFrameRequest(obj, recomposer$runFrameLoop$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        List list = toRecompose;
                        parentFrameClock2 = parentFrameClock;
                        toApply2 = toApply;
                        recomposer2 = recomposer;
                        frameSignal2 = frameSignal;
                        toRecompose2 = list;
                        function1 = new Function1<Long, CancellableContinuation<? super Unit>>() { // from class: androidx.compose.runtime.Recomposer$runFrameLoop$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ CancellableContinuation<? super Unit> invoke(Long l) {
                                return invoke(l.longValue());
                            }

                            public final CancellableContinuation<Unit> invoke(long frameTime) {
                                BroadcastFrameClock broadcastFrameClock;
                                List $this$fastForEach$iv;
                                List list2;
                                CancellableContinuation<Unit> deriveStateLocked;
                                ControlledComposition it;
                                IdentityArraySet modifiedValues;
                                BroadcastFrameClock broadcastFrameClock2;
                                broadcastFrameClock = Recomposer.this.broadcastFrameClock;
                                if (broadcastFrameClock.getHasAwaiters()) {
                                    Recomposer recomposer3 = Recomposer.this;
                                    Object token$iv = Trace.INSTANCE.beginSection("Recomposer:animation");
                                    try {
                                        broadcastFrameClock2 = recomposer3.broadcastFrameClock;
                                        try {
                                            broadcastFrameClock2.sendFrame(frameTime);
                                            Snapshot.INSTANCE.sendApplyNotifications();
                                            Unit unit = Unit.INSTANCE;
                                            Trace.INSTANCE.endSection(token$iv);
                                        } catch (Throwable th) {
                                            th = th;
                                            Trace.INSTANCE.endSection(token$iv);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                                Recomposer recomposer4 = Recomposer.this;
                                List $this$fastForEach$iv2 = toRecompose2;
                                List $this$fastForEach$iv3 = toApply2;
                                ProduceFrameSignal produceFrameSignal = frameSignal2;
                                Object token$iv2 = Trace.INSTANCE.beginSection("Recomposer:recompose");
                                try {
                                    Object lock$iv = recomposer4.stateLock;
                                    synchronized (lock$iv) {
                                        try {
                                            try {
                                                recomposer4.recordComposerModificationsLocked();
                                                $this$fastForEach$iv = recomposer4.compositionsAwaitingApply;
                                                int index$iv = 0;
                                                for (int size = $this$fastForEach$iv.size(); index$iv < size; size = size) {
                                                    try {
                                                        Object item$iv = $this$fastForEach$iv.get(index$iv);
                                                        $this$fastForEach$iv3.add((ControlledComposition) item$iv);
                                                        index$iv++;
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        throw th;
                                                    }
                                                }
                                                list2 = recomposer4.compositionsAwaitingApply;
                                                list2.clear();
                                                List $this$fastForEach$iv4 = recomposer4.compositionInvalidations;
                                                int index$iv2 = 0;
                                                int size2 = $this$fastForEach$iv4.size();
                                                while (index$iv2 < size2) {
                                                    Object item$iv2 = $this$fastForEach$iv4.get(index$iv2);
                                                    $this$fastForEach$iv2.add((ControlledComposition) item$iv2);
                                                    index$iv2++;
                                                    $this$fastForEach$iv4 = $this$fastForEach$iv4;
                                                }
                                                recomposer4.compositionInvalidations.clear();
                                                produceFrameSignal.takeFrameRequestLocked();
                                                Unit unit2 = Unit.INSTANCE;
                                                IdentityArraySet modifiedValues2 = new IdentityArraySet();
                                                int index$iv3 = 0;
                                                try {
                                                    int size3 = $this$fastForEach$iv2.size();
                                                    while (index$iv3 < size3) {
                                                        Object item$iv3 = $this$fastForEach$iv2.get(index$iv3);
                                                        ControlledComposition composer = (ControlledComposition) item$iv3;
                                                        it = recomposer4.performRecompose(composer, modifiedValues2);
                                                        if (it == null) {
                                                            modifiedValues = modifiedValues2;
                                                        } else {
                                                            modifiedValues = modifiedValues2;
                                                            try {
                                                                $this$fastForEach$iv3.add(it);
                                                            } catch (Throwable th4) {
                                                                th = th4;
                                                                $this$fastForEach$iv2.clear();
                                                                throw th;
                                                            }
                                                        }
                                                        index$iv3++;
                                                        modifiedValues2 = modifiedValues;
                                                    }
                                                    $this$fastForEach$iv2.clear();
                                                    if (!$this$fastForEach$iv3.isEmpty()) {
                                                        recomposer4.changeCount = recomposer4.getChangeCount() + 1;
                                                    }
                                                    try {
                                                        int size4 = $this$fastForEach$iv3.size();
                                                        for (int index$iv4 = 0; index$iv4 < size4; index$iv4++) {
                                                            Object item$iv4 = $this$fastForEach$iv3.get(index$iv4);
                                                            ControlledComposition composition = (ControlledComposition) item$iv4;
                                                            composition.applyChanges();
                                                        }
                                                        $this$fastForEach$iv3.clear();
                                                        Object lock$iv2 = recomposer4.stateLock;
                                                        synchronized (lock$iv2) {
                                                            deriveStateLocked = recomposer4.deriveStateLocked();
                                                        }
                                                        Trace.INSTANCE.endSection(token$iv2);
                                                        return deriveStateLocked;
                                                    } catch (Throwable th5) {
                                                        $this$fastForEach$iv3.clear();
                                                        throw th5;
                                                    }
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                }
                                            } catch (Throwable th7) {
                                                th = th7;
                                                Trace.INSTANCE.endSection(token$iv2);
                                                throw th;
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                        }
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                }
                            }
                        };
                        recomposer$runFrameLoop$12.L$0 = recomposer2;
                        recomposer$runFrameLoop$12.L$1 = parentFrameClock2;
                        recomposer$runFrameLoop$12.L$2 = frameSignal2;
                        recomposer$runFrameLoop$12.L$3 = toRecompose2;
                        recomposer$runFrameLoop$12.L$4 = toApply2;
                        recomposer$runFrameLoop$12.label = 2;
                        if (parentFrameClock2.withFrameNanos(function1, recomposer$runFrameLoop$12) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Recomposer recomposer3 = recomposer2;
                        toApply = toApply2;
                        parentFrameClock = parentFrameClock2;
                        toRecompose = toRecompose2;
                        frameSignal = frameSignal2;
                        recomposer = recomposer3;
                        obj = recomposer.stateLock;
                        recomposer$runFrameLoop$12.L$0 = recomposer;
                        recomposer$runFrameLoop$12.L$1 = parentFrameClock;
                        recomposer$runFrameLoop$12.L$2 = frameSignal;
                        recomposer$runFrameLoop$12.L$3 = toRecompose;
                        recomposer$runFrameLoop$12.L$4 = toApply;
                        recomposer$runFrameLoop$12.label = 1;
                        if (frameSignal.awaitFrameRequest(obj, recomposer$runFrameLoop$12) == coroutine_suspended) {
                        }
                    case 1:
                        toApply2 = (List) recomposer$runFrameLoop$12.L$4;
                        toRecompose2 = (List) recomposer$runFrameLoop$12.L$3;
                        frameSignal2 = (ProduceFrameSignal) recomposer$runFrameLoop$12.L$2;
                        parentFrameClock2 = (MonotonicFrameClock) recomposer$runFrameLoop$12.L$1;
                        recomposer2 = (Recomposer) recomposer$runFrameLoop$12.L$0;
                        ResultKt.throwOnFailure($result);
                        function1 = new Function1<Long, CancellableContinuation<? super Unit>>() { // from class: androidx.compose.runtime.Recomposer$runFrameLoop$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ CancellableContinuation<? super Unit> invoke(Long l) {
                                return invoke(l.longValue());
                            }

                            public final CancellableContinuation<Unit> invoke(long frameTime) {
                                BroadcastFrameClock broadcastFrameClock;
                                List $this$fastForEach$iv;
                                List list2;
                                CancellableContinuation<Unit> deriveStateLocked;
                                ControlledComposition it;
                                IdentityArraySet modifiedValues;
                                BroadcastFrameClock broadcastFrameClock2;
                                broadcastFrameClock = Recomposer.this.broadcastFrameClock;
                                if (broadcastFrameClock.getHasAwaiters()) {
                                    Recomposer recomposer32 = Recomposer.this;
                                    Object token$iv = Trace.INSTANCE.beginSection("Recomposer:animation");
                                    try {
                                        broadcastFrameClock2 = recomposer32.broadcastFrameClock;
                                        try {
                                            broadcastFrameClock2.sendFrame(frameTime);
                                            Snapshot.INSTANCE.sendApplyNotifications();
                                            Unit unit = Unit.INSTANCE;
                                            Trace.INSTANCE.endSection(token$iv);
                                        } catch (Throwable th) {
                                            th = th;
                                            Trace.INSTANCE.endSection(token$iv);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                                Recomposer recomposer4 = Recomposer.this;
                                List $this$fastForEach$iv2 = toRecompose2;
                                List $this$fastForEach$iv3 = toApply2;
                                ProduceFrameSignal produceFrameSignal = frameSignal2;
                                Object token$iv2 = Trace.INSTANCE.beginSection("Recomposer:recompose");
                                try {
                                    Object lock$iv = recomposer4.stateLock;
                                    synchronized (lock$iv) {
                                        try {
                                            try {
                                                recomposer4.recordComposerModificationsLocked();
                                                $this$fastForEach$iv = recomposer4.compositionsAwaitingApply;
                                                int index$iv = 0;
                                                for (int size = $this$fastForEach$iv.size(); index$iv < size; size = size) {
                                                    try {
                                                        Object item$iv = $this$fastForEach$iv.get(index$iv);
                                                        $this$fastForEach$iv3.add((ControlledComposition) item$iv);
                                                        index$iv++;
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        throw th;
                                                    }
                                                }
                                                list2 = recomposer4.compositionsAwaitingApply;
                                                list2.clear();
                                                List $this$fastForEach$iv4 = recomposer4.compositionInvalidations;
                                                int index$iv2 = 0;
                                                int size2 = $this$fastForEach$iv4.size();
                                                while (index$iv2 < size2) {
                                                    Object item$iv2 = $this$fastForEach$iv4.get(index$iv2);
                                                    $this$fastForEach$iv2.add((ControlledComposition) item$iv2);
                                                    index$iv2++;
                                                    $this$fastForEach$iv4 = $this$fastForEach$iv4;
                                                }
                                                recomposer4.compositionInvalidations.clear();
                                                produceFrameSignal.takeFrameRequestLocked();
                                                Unit unit2 = Unit.INSTANCE;
                                                IdentityArraySet modifiedValues2 = new IdentityArraySet();
                                                int index$iv3 = 0;
                                                try {
                                                    int size3 = $this$fastForEach$iv2.size();
                                                    while (index$iv3 < size3) {
                                                        Object item$iv3 = $this$fastForEach$iv2.get(index$iv3);
                                                        ControlledComposition composer = (ControlledComposition) item$iv3;
                                                        it = recomposer4.performRecompose(composer, modifiedValues2);
                                                        if (it == null) {
                                                            modifiedValues = modifiedValues2;
                                                        } else {
                                                            modifiedValues = modifiedValues2;
                                                            try {
                                                                $this$fastForEach$iv3.add(it);
                                                            } catch (Throwable th4) {
                                                                th = th4;
                                                                $this$fastForEach$iv2.clear();
                                                                throw th;
                                                            }
                                                        }
                                                        index$iv3++;
                                                        modifiedValues2 = modifiedValues;
                                                    }
                                                    $this$fastForEach$iv2.clear();
                                                    if (!$this$fastForEach$iv3.isEmpty()) {
                                                        recomposer4.changeCount = recomposer4.getChangeCount() + 1;
                                                    }
                                                    try {
                                                        int size4 = $this$fastForEach$iv3.size();
                                                        for (int index$iv4 = 0; index$iv4 < size4; index$iv4++) {
                                                            Object item$iv4 = $this$fastForEach$iv3.get(index$iv4);
                                                            ControlledComposition composition = (ControlledComposition) item$iv4;
                                                            composition.applyChanges();
                                                        }
                                                        $this$fastForEach$iv3.clear();
                                                        Object lock$iv2 = recomposer4.stateLock;
                                                        synchronized (lock$iv2) {
                                                            deriveStateLocked = recomposer4.deriveStateLocked();
                                                        }
                                                        Trace.INSTANCE.endSection(token$iv2);
                                                        return deriveStateLocked;
                                                    } catch (Throwable th5) {
                                                        $this$fastForEach$iv3.clear();
                                                        throw th5;
                                                    }
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                }
                                            } catch (Throwable th7) {
                                                th = th7;
                                                Trace.INSTANCE.endSection(token$iv2);
                                                throw th;
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                        }
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                }
                            }
                        };
                        recomposer$runFrameLoop$12.L$0 = recomposer2;
                        recomposer$runFrameLoop$12.L$1 = parentFrameClock2;
                        recomposer$runFrameLoop$12.L$2 = frameSignal2;
                        recomposer$runFrameLoop$12.L$3 = toRecompose2;
                        recomposer$runFrameLoop$12.L$4 = toApply2;
                        recomposer$runFrameLoop$12.label = 2;
                        if (parentFrameClock2.withFrameNanos(function1, recomposer$runFrameLoop$12) != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        List toApply3 = (List) recomposer$runFrameLoop$12.L$4;
                        List toRecompose3 = (List) recomposer$runFrameLoop$12.L$3;
                        ProduceFrameSignal frameSignal3 = (ProduceFrameSignal) recomposer$runFrameLoop$12.L$2;
                        MonotonicFrameClock parentFrameClock3 = (MonotonicFrameClock) recomposer$runFrameLoop$12.L$1;
                        Recomposer recomposer4 = (Recomposer) recomposer$runFrameLoop$12.L$0;
                        ResultKt.throwOnFailure($result);
                        toApply = toApply3;
                        parentFrameClock = parentFrameClock3;
                        toRecompose = toRecompose3;
                        frameSignal = frameSignal3;
                        recomposer = recomposer4;
                        obj = recomposer.stateLock;
                        recomposer$runFrameLoop$12.L$0 = recomposer;
                        recomposer$runFrameLoop$12.L$1 = parentFrameClock;
                        recomposer$runFrameLoop$12.L$2 = frameSignal;
                        recomposer$runFrameLoop$12.L$3 = toRecompose;
                        recomposer$runFrameLoop$12.L$4 = toApply;
                        recomposer$runFrameLoop$12.label = 1;
                        if (frameSignal.awaitFrameRequest(obj, recomposer$runFrameLoop$12) == coroutine_suspended) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        recomposer$runFrameLoop$1 = new Recomposer$runFrameLoop$1(this, continuation);
        recomposer$runFrameLoop$12 = recomposer$runFrameLoop$1;
        Object $result2 = recomposer$runFrameLoop$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (recomposer$runFrameLoop$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasSchedulingWork() {
        boolean z;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            if (this.snapshotInvalidations.isEmpty() && this.compositionInvalidations.isEmpty()) {
                z = this.broadcastFrameClock.getHasAwaiters();
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitWorkAvailable(Continuation<? super Unit> continuation) {
        if (getHasSchedulingWork()) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        CancellableContinuationImpl co = cancellable$iv;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            if (!getHasSchedulingWork()) {
                this.workContinuation = co;
            } else {
                Result.Companion companion = Result.INSTANCE;
                co.resumeWith(Result.m4732constructorimpl(Unit.INSTANCE));
            }
            Unit unit = Unit.INSTANCE;
        }
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object recompositionRunner(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        MonotonicFrameClock parentFrameClock = MonotonicFrameClockKt.getMonotonicFrameClock(continuation.getContext());
        Object withContext = BuildersKt.withContext(this.broadcastFrameClock, new Recomposer$recompositionRunner$2(this, function3, parentFrameClock, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final void cancel() {
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            if (this._state.getValue().compareTo(State.Idle) >= 0) {
                this._state.setValue(State.ShuttingDown);
            }
            Unit unit = Unit.INSTANCE;
        }
        Job.DefaultImpls.cancel$default((Job) this.effectJob, (CancellationException) null, 1, (Object) null);
    }

    public final void close() {
        if (this.effectJob.complete()) {
            Object lock$iv = this.stateLock;
            synchronized (lock$iv) {
                this.isClosed = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final Object join(Continuation<? super Unit> continuation) {
        Object first = FlowKt.first(getCurrentState(), new Recomposer$join$2(null), continuation);
        return first == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? first : Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void composeInitial$runtime_release(ControlledComposition composition, Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(composition, "composition");
        Intrinsics.checkNotNullParameter(content, "content");
        boolean composerWasComposing = composition.isComposing();
        try {
            MutableSnapshot snapshot$iv = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, null));
            try {
                MutableSnapshot this_$iv$iv = snapshot$iv;
                Snapshot previous$iv$iv = this_$iv$iv.makeCurrent();
                try {
                    composition.composeContent(content);
                    Unit unit = Unit.INSTANCE;
                    if (!composerWasComposing) {
                        Snapshot.INSTANCE.notifyObjectsInitialized();
                    }
                    Object lock$iv = this.stateLock;
                    synchronized (lock$iv) {
                        if (this._state.getValue().compareTo(State.ShuttingDown) > 0 && !this.knownCompositions.contains(composition)) {
                            this.knownCompositions.add(composition);
                        }
                        Unit unit2 = Unit.INSTANCE;
                    }
                    try {
                        performInitialMovableContentInserts(composition);
                        try {
                            composition.applyChanges();
                            composition.applyLateChanges();
                            if (!composerWasComposing) {
                                Snapshot.INSTANCE.notifyObjectsInitialized();
                            }
                        } catch (Exception e) {
                            processCompositionError$default(this, e, null, false, 6, null);
                        }
                    } catch (Exception e2) {
                        processCompositionError(e2, composition, true);
                    }
                } finally {
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                }
            } finally {
                applyAndCheck(snapshot$iv);
            }
        } catch (Exception e3) {
            processCompositionError(e3, composition, true);
        }
    }

    private final void performInitialMovableContentInserts(ControlledComposition composition) {
        boolean z;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            int i = 0;
            List $this$fastAny$iv = this.compositionValuesAwaitingInsert;
            int index$iv$iv = 0;
            int size = $this$fastAny$iv.size();
            while (true) {
                if (index$iv$iv < size) {
                    Object item$iv$iv = $this$fastAny$iv.get(index$iv$iv);
                    MovableContentStateReference it = (MovableContentStateReference) item$iv$iv;
                    int i2 = i;
                    if (Intrinsics.areEqual(it.getComposition(), composition)) {
                        z = true;
                        break;
                    } else {
                        index$iv$iv++;
                        i = i2;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                Unit unit = Unit.INSTANCE;
                List toInsert = new ArrayList();
                performInitialMovableContentInserts$fillToInsert(toInsert, this, composition);
                while (!toInsert.isEmpty()) {
                    performInsertValues(toInsert, null);
                    performInitialMovableContentInserts$fillToInsert(toInsert, this, composition);
                }
            }
        }
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<MovableContentStateReference> list, Recomposer this$0, ControlledComposition $composition) {
        list.clear();
        Object lock$iv = this$0.stateLock;
        synchronized (lock$iv) {
            Iterator iterator = this$0.compositionValuesAwaitingInsert.iterator();
            while (iterator.hasNext()) {
                MovableContentStateReference value = iterator.next();
                if (Intrinsics.areEqual(value.getComposition(), $composition)) {
                    list.add(value);
                    iterator.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ControlledComposition performRecompose(final ControlledComposition composition, final IdentityArraySet<Object> modifiedValues) {
        if (composition.isComposing() || composition.getDisposed()) {
            return null;
        }
        MutableSnapshot snapshot$iv = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            MutableSnapshot this_$iv$iv = snapshot$iv;
            Snapshot previous$iv$iv = this_$iv$iv.makeCurrent();
            boolean z = false;
            if (modifiedValues != null) {
                try {
                    if (modifiedValues.isNotEmpty()) {
                        z = true;
                    }
                } catch (Throwable th) {
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                    throw th;
                }
            }
            if (z) {
                composition.prepareCompose(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$performRecompose$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IdentityArraySet this_$iv = modifiedValues;
                        ControlledComposition controlledComposition = composition;
                        int size = this_$iv.size();
                        for (int i$iv = 0; i$iv < size; i$iv++) {
                            Object it = this_$iv.get(i$iv);
                            controlledComposition.recordWriteOf(it);
                        }
                    }
                });
            }
            boolean recompose = composition.recompose();
            this_$iv$iv.restoreCurrent(previous$iv$iv);
            if (recompose) {
                return composition;
            }
            return null;
        } finally {
            applyAndCheck(snapshot$iv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fc, code lost:
    
        r4.insertMovableContent(r1);
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0103, code lost:
    
        r8.restoreCurrent(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0107, code lost:
    
        applyAndCheck(r7);
        r1 = r29;
        r0 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0128, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012f, code lost:
    
        applyAndCheck(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0132, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<ControlledComposition> performInsertValues(List<MovableContentStateReference> references, IdentityArraySet<Object> modifiedValues) {
        Object answer$iv$iv;
        Recomposer recomposer = this;
        Map destination$iv = new HashMap(references.size());
        int size = references.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            MovableContentStateReference movableContentStateReference = references.get(index$iv$iv);
            MovableContentStateReference it = movableContentStateReference;
            ControlledComposition composition = it.getComposition();
            Map $this$getOrPut$iv$iv = destination$iv;
            Object value$iv$iv = $this$getOrPut$iv$iv.get(composition);
            if (value$iv$iv == null) {
                answer$iv$iv = new ArrayList();
                $this$getOrPut$iv$iv.put(composition, answer$iv$iv);
            } else {
                answer$iv$iv = value$iv$iv;
            }
            ArrayList list$iv = (ArrayList) answer$iv$iv;
            list$iv.add(movableContentStateReference);
        }
        Map map = destination$iv;
        Iterator it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            ControlledComposition composition2 = (ControlledComposition) entry.getKey();
            List refs = (List) entry.getValue();
            ComposerKt.runtimeCheck(!composition2.isComposing());
            MutableSnapshot snapshot$iv = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition2), writeObserverOf(composition2, modifiedValues));
            try {
                MutableSnapshot this_$iv$iv = snapshot$iv;
                Snapshot previous$iv$iv = this_$iv$iv.makeCurrent();
                try {
                    Object lock$iv = recomposer.stateLock;
                    synchronized (lock$iv) {
                        Iterator it3 = it2;
                        try {
                            try {
                                List target$iv = new ArrayList(refs.size());
                                List $this$fastForEach$iv$iv = refs;
                                try {
                                    int index$iv$iv2 = 0;
                                    for (int $i$f$composing = $this$fastForEach$iv$iv.size(); index$iv$iv2 < $i$f$composing; $i$f$composing = $i$f$composing) {
                                        Object item$iv$iv = $this$fastForEach$iv$iv.get(index$iv$iv2);
                                        MovableContentStateReference reference = (MovableContentStateReference) item$iv$iv;
                                        target$iv.add(TuplesKt.m294to(reference, RecomposerKt.removeLastMultiValue(recomposer.compositionValuesRemoved, reference.getContent$runtime_release())));
                                        index$iv$iv2++;
                                        recomposer = this;
                                        $this$fastForEach$iv$iv = $this$fastForEach$iv$iv;
                                    }
                                    List pairs = target$iv;
                                    try {
                                    } catch (Throwable th) {
                                        th = th;
                                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                    throw th;
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return CollectionsKt.toList(map.keySet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void discardUnusedValues() {
        ArrayList unusedValues;
        Object lock$iv = this.stateLock;
        int $i$f$synchronized = 0;
        synchronized (lock$iv) {
            int i = 0;
            try {
                try {
                    if (this.compositionValuesRemoved.isEmpty()) {
                        unusedValues = CollectionsKt.emptyList();
                    } else {
                        List references = CollectionsKt.flatten(this.compositionValuesRemoved.values());
                        this.compositionValuesRemoved.clear();
                        ArrayList target$iv = new ArrayList(references.size());
                        int index$iv$iv = 0;
                        int size = references.size();
                        while (index$iv$iv < size) {
                            Object item$iv$iv = references.get(index$iv$iv);
                            MovableContentStateReference it = (MovableContentStateReference) item$iv$iv;
                            int i2 = i;
                            int $i$f$synchronized2 = $i$f$synchronized;
                            target$iv.add(TuplesKt.m294to(it, this.compositionValueStatesAvailable.get(it)));
                            index$iv$iv++;
                            i = i2;
                            $i$f$synchronized = $i$f$synchronized2;
                        }
                        unusedValues = target$iv;
                        this.compositionValueStatesAvailable.clear();
                    }
                    List $this$fastForEach$iv = unusedValues;
                    int size2 = $this$fastForEach$iv.size();
                    for (int index$iv = 0; index$iv < size2; index$iv++) {
                        Object item$iv = $this$fastForEach$iv.get(index$iv);
                        Pair pair = (Pair) item$iv;
                        MovableContentStateReference reference = (MovableContentStateReference) pair.component1();
                        MovableContentState state = (MovableContentState) pair.component2();
                        if (state != null) {
                            reference.getComposition().disposeUnusedMovableContent(state);
                        }
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

    private final Function1<Object, Unit> readObserverOf(final ControlledComposition composition) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer$readObserverOf$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object value) {
                Intrinsics.checkNotNullParameter(value, "value");
                ControlledComposition.this.recordReadOf(value);
            }
        };
    }

    private final Function1<Object, Unit> writeObserverOf(final ControlledComposition composition, final IdentityArraySet<Object> modifiedValues) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer$writeObserverOf$1
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
            public final void invoke2(Object value) {
                Intrinsics.checkNotNullParameter(value, "value");
                ControlledComposition.this.recordWriteOf(value);
                IdentityArraySet<Object> identityArraySet = modifiedValues;
                if (identityArraySet != null) {
                    identityArraySet.add(value);
                }
            }
        };
    }

    private final <T> T composing(ControlledComposition composition, IdentityArraySet<Object> modifiedValues, Function0<? extends T> block) {
        MutableSnapshot snapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            MutableSnapshot this_$iv = snapshot;
            Snapshot previous$iv = this_$iv.makeCurrent();
            try {
                return block.invoke();
            } finally {
                InlineMarker.finallyStart(1);
                this_$iv.restoreCurrent(previous$iv);
                InlineMarker.finallyEnd(1);
            }
        } finally {
            InlineMarker.finallyStart(1);
            applyAndCheck(snapshot);
            InlineMarker.finallyEnd(1);
        }
    }

    private final void applyAndCheck(MutableSnapshot snapshot) {
        try {
            SnapshotApplyResult applyResult = snapshot.apply();
            if (applyResult instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
            }
        } finally {
            snapshot.dispose();
        }
    }

    public final boolean getHasPendingWork() {
        boolean z;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            if (this.snapshotInvalidations.isEmpty() && this.compositionInvalidations.isEmpty() && this.concurrentCompositionsOutstanding <= 0 && this.compositionsAwaitingApply.isEmpty()) {
                z = this.broadcastFrameClock.getHasAwaiters();
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasFrameWorkLocked() {
        return !this.compositionInvalidations.isEmpty() || this.broadcastFrameClock.getHasAwaiters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasConcurrentFrameWorkLocked() {
        return !this.compositionsAwaitingApply.isEmpty() || this.broadcastFrameClock.getHasAwaiters();
    }

    public final Object awaitIdle(Continuation<? super Unit> continuation) {
        Object collect = FlowKt.collect(FlowKt.takeWhile(getCurrentState(), new Recomposer$awaitIdle$2(null)), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public int getCompoundHashKey$runtime_release() {
        return 1000;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingParameterInformation$runtime_release() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void recordInspectionTable$runtime_release(Set<CompositionData> table) {
        Intrinsics.checkNotNullParameter(table, "table");
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void registerComposition$runtime_release(ControlledComposition composition) {
        Intrinsics.checkNotNullParameter(composition, "composition");
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void unregisterComposition$runtime_release(ControlledComposition composition) {
        Intrinsics.checkNotNullParameter(composition, "composition");
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            this.knownCompositions.remove(composition);
            this.compositionInvalidations.remove(composition);
            this.compositionsAwaitingApply.remove(composition);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidate$runtime_release(ControlledComposition composition) {
        CancellableContinuation<Unit> cancellableContinuation;
        Intrinsics.checkNotNullParameter(composition, "composition");
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            if (!this.compositionInvalidations.contains(composition)) {
                this.compositionInvalidations.add(composition);
                cancellableContinuation = deriveStateLocked();
            } else {
                cancellableContinuation = null;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m4732constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidateScope$runtime_release(RecomposeScopeImpl scope) {
        CancellableContinuation<Unit> deriveStateLocked;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            this.snapshotInvalidations.add(SetsKt.setOf(scope));
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            deriveStateLocked.resumeWith(Result.m4732constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void insertMovableContent$runtime_release(MovableContentStateReference reference) {
        CancellableContinuation<Unit> deriveStateLocked;
        Intrinsics.checkNotNullParameter(reference, "reference");
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            this.compositionValuesAwaitingInsert.add(reference);
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            deriveStateLocked.resumeWith(Result.m4732constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void deletedMovableContent$runtime_release(MovableContentStateReference reference) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            RecomposerKt.addMultiValue(this.compositionValuesRemoved, reference.getContent$runtime_release(), reference);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void movableContentStateReleased$runtime_release(MovableContentStateReference reference, MovableContentState data) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        Intrinsics.checkNotNullParameter(data, "data");
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            this.compositionValueStatesAvailable.put(reference, data);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference reference) {
        MovableContentState remove;
        Intrinsics.checkNotNullParameter(reference, "reference");
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            remove = this.compositionValueStatesAvailable.remove(reference);
        }
        return remove;
    }

    /* compiled from: Recomposer.kt */
    @Metadata(m286d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010\u0016\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0017J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\u0015\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\"J\u0014\u0010#\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010$\u001a\u00020\u0001H\u0000¢\u0006\u0002\b%J\u0015\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0005H\u0000¢\u0006\u0002\b(R.\u0010\u0003\u001a\"\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004j\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000bR\u00020\f0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, m287d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", "", "()V", "_hotReloadEnabled", "Ljava/util/concurrent/atomic/AtomicReference;", "", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "runningRecomposers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/compose/runtime/RecomposerInfo;", "getRunningRecomposers", "()Lkotlinx/coroutines/flow/StateFlow;", "addRunning", "", "info", "clearErrors", "clearErrors$runtime_release", "getCurrentErrors", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors$runtime_release", "invalidateGroupsWithKey", "key", "", "invalidateGroupsWithKey$runtime_release", "loadStateAndComposeForHotReload", "token", "loadStateAndComposeForHotReload$runtime_release", "removeRunning", "saveStateAndDisposeForHotReload", "saveStateAndDisposeForHotReload$runtime_release", "setHotReloadEnabled", "value", "setHotReloadEnabled$runtime_release", "runtime_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StateFlow<Set<RecomposerInfo>> getRunningRecomposers() {
            return Recomposer._runningRecomposers;
        }

        public final void setHotReloadEnabled$runtime_release(boolean value) {
            Recomposer._hotReloadEnabled.set(Boolean.valueOf(value));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addRunning(RecomposerInfoImpl info) {
            PersistentSet old;
            PersistentSet add;
            do {
                old = (PersistentSet) Recomposer._runningRecomposers.getValue();
                add = old.add((PersistentSet) info);
                if (old == add) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(old, add));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeRunning(RecomposerInfoImpl info) {
            PersistentSet old;
            PersistentSet remove;
            do {
                old = (PersistentSet) Recomposer._runningRecomposers.getValue();
                remove = old.remove((PersistentSet) info);
                if (old == remove) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(old, remove));
        }

        public final Object saveStateAndDisposeForHotReload$runtime_release() {
            Recomposer._hotReloadEnabled.set(true);
            Iterable $this$flatMap$iv = (Iterable) Recomposer._runningRecomposers.getValue();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$flatMap$iv) {
                RecomposerInfoImpl it = (RecomposerInfoImpl) element$iv$iv;
                Iterable list$iv$iv = it.saveStateAndDisposeForHotReload();
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            return (List) destination$iv$iv;
        }

        public final void loadStateAndComposeForHotReload$runtime_release(Object token) {
            Intrinsics.checkNotNullParameter(token, "token");
            Recomposer._hotReloadEnabled.set(true);
            Iterable $this$forEach$iv = (Iterable) Recomposer._runningRecomposers.getValue();
            for (Object element$iv : $this$forEach$iv) {
                RecomposerInfoImpl it = (RecomposerInfoImpl) element$iv;
                it.resetErrorState();
            }
            List holders = (List) token;
            int size = holders.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = holders.get(index$iv);
                HotReloadable it2 = (HotReloadable) item$iv;
                it2.resetContent();
            }
            int size2 = holders.size();
            for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                Object item$iv2 = holders.get(index$iv2);
                HotReloadable it3 = (HotReloadable) item$iv2;
                it3.recompose();
            }
            Iterable $this$forEach$iv2 = (Iterable) Recomposer._runningRecomposers.getValue();
            for (Object element$iv2 : $this$forEach$iv2) {
                RecomposerInfoImpl it4 = (RecomposerInfoImpl) element$iv2;
                it4.retryFailedCompositions();
            }
        }

        public final void invalidateGroupsWithKey$runtime_release(int key) {
            Recomposer._hotReloadEnabled.set(true);
            Iterable $this$forEach$iv = (Iterable) Recomposer._runningRecomposers.getValue();
            for (Object element$iv : $this$forEach$iv) {
                RecomposerInfoImpl it = (RecomposerInfoImpl) element$iv;
                RecomposerErrorInfo currentError = it.getCurrentError();
                boolean z = false;
                if (currentError != null && !currentError.getRecoverable()) {
                    z = true;
                }
                if (!z) {
                    it.resetErrorState();
                    it.invalidateGroupsWithKey(key);
                    it.retryFailedCompositions();
                }
            }
        }

        public final List<RecomposerErrorInfo> getCurrentErrors$runtime_release() {
            Iterable $this$mapNotNull$iv = (Iterable) Recomposer._runningRecomposers.getValue();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                RecomposerInfoImpl it = (RecomposerInfoImpl) element$iv$iv$iv;
                RecomposerErrorInfo currentError = it.getCurrentError();
                if (currentError != null) {
                    destination$iv$iv.add(currentError);
                }
            }
            return (List) destination$iv$iv;
        }

        public final void clearErrors$runtime_release() {
            Iterable $this$mapNotNull$iv = (Iterable) Recomposer._runningRecomposers.getValue();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                RecomposerInfoImpl it = (RecomposerInfoImpl) element$iv$iv$iv;
                RecomposerErrorState resetErrorState = it.resetErrorState();
                if (resetErrorState != null) {
                    destination$iv$iv.add(resetErrorState);
                }
            }
        }
    }
}
