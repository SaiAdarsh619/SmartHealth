package androidx.compose.foundation.lazy.grid;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.p000ui.layout.Remeasurement;
import androidx.compose.p000ui.layout.RemeasurementModifier;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.DensityKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyGridState.kt */
@Metadata(m286d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u008d\u00012\u00020\u0001:\u0002\u008d\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J#\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00032\b\b\u0002\u0010n\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010oJ\u0015\u0010p\u001a\u00020l2\u0006\u0010q\u001a\u00020rH\u0000¢\u0006\u0002\bsJ\u0010\u0010t\u001a\u00020l2\u0006\u0010u\u001a\u00020/H\u0002J\u0010\u0010v\u001a\u00020`2\u0006\u0010w\u001a\u00020`H\u0016J\u0010\u0010x\u001a\u00020l2\u0006\u0010w\u001a\u00020`H\u0002J\u0015\u0010y\u001a\u00020`2\u0006\u0010z\u001a\u00020`H\u0000¢\u0006\u0002\b{JH\u0010|\u001a\u00020l2\u0006\u0010}\u001a\u00020~2,\u0010\u007f\u001a(\b\u0001\u0012\u0005\u0012\u00030\u0081\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020l0\u0082\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0083\u00010\u0080\u0001¢\u0006\u0003\b\u0084\u0001H\u0096@ø\u0001\u0000¢\u0006\u0003\u0010\u0085\u0001J$\u0010\u0086\u0001\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00032\b\b\u0002\u0010n\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010oJ\u001f\u0010\u0087\u0001\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00032\u0006\u0010n\u001a\u00020\u0003H\u0000¢\u0006\u0003\b\u0088\u0001J\u0019\u0010\u0089\u0001\u001a\u00020l2\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0000¢\u0006\u0003\b\u008c\u0001R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00158@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0011R+\u0010)\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010\u001c\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010,R\u0011\u0010.\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020/03X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00105\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001eR/\u00108\u001a\u0004\u0018\u0001072\b\u0010\u000e\u001a\u0004\u0018\u0001078@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010\u001c\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0088\u0001\u0010F\u001a/\u0012\u0013\u0012\u00110?¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020E0D0C0>23\u0010\u000e\u001a/\u0012\u0013\u0012\u00110?¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020E0D0C0>8@@@X\u0080\u008e\u0002ø\u0001\u0000¢\u0006\u0012\n\u0004\bK\u0010\u001c\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020MX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0011\"\u0004\bR\u0010,R/\u0010T\u001a\u0004\u0018\u00010S2\b\u0010\u000e\u001a\u0004\u0018\u00010S8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bY\u0010\u001c\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0014\u0010Z\u001a\u00020[X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u000e\u0010^\u001a\u00020_X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010a\u001a\u00020`2\u0006\u0010\u000e\u001a\u00020`@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u000e\u0010d\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010e\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bi\u0010\u001c\u001a\u0004\bf\u0010\u001e\"\u0004\bg\u0010hR\u000e\u0010j\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u008e\u0001"}, m287d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "firstVisibleItemIndex", "", "firstVisibleItemScrollOffset", "(II)V", "animateScrollScope", "Landroidx/compose/foundation/lazy/grid/LazyGridAnimateScrollScope;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/AwaitFirstLayoutModifier;", "canScrollBackward", "", "<set-?>", "canScrollForward", "getCanScrollForward$foundation_release", "()Z", "currentLinePrefetchHandles", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "density$delegate", "Landroidx/compose/runtime/MutableState;", "getFirstVisibleItemIndex", "()I", "getFirstVisibleItemScrollOffset", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isScrollInProgress", "isVertical", "isVertical$foundation_release", "setVertical$foundation_release", "(Z)V", "isVertical$delegate", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "lineToPrefetch", "numMeasurePasses", "getNumMeasurePasses$foundation_release", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "placementAnimator", "getPlacementAnimator$foundation_release", "()Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "setPlacementAnimator$foundation_release", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;)V", "placementAnimator$delegate", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LineIndex;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "line", "", "Lkotlin/Pair;", "Landroidx/compose/ui/unit/Constraints;", "prefetchInfoRetriever", "getPrefetchInfoRetriever$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setPrefetchInfoRetriever$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "prefetchInfoRetriever$delegate", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement", "()Landroidx/compose/ui/layout/Remeasurement;", "setRemeasurement", "(Landroidx/compose/ui/layout/Remeasurement;)V", "remeasurement$delegate", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "scrollPosition", "Landroidx/compose/foundation/lazy/grid/LazyGridScrollPosition;", "", "scrollToBeConsumed", "getScrollToBeConsumed$foundation_release", "()F", "scrollableState", "slotsPerLine", "getSlotsPerLine$foundation_release", "setSlotsPerLine$foundation_release", "(I)V", "slotsPerLine$delegate", "wasScrollingForward", "animateScrollToItem", "", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMeasureResult", "result", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "applyMeasureResult$foundation_release", "cancelPrefetchIfVisibleItemsChanged", "info", "dispatchRawDelta", "delta", "notifyPrefetch", "onScroll", "distance", "onScroll$foundation_release", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToItem", "snapToItemIndexInternal", "snapToItemIndexInternal$foundation_release", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "updateScrollPositionIfTheFirstItemWasMoved$foundation_release", "Companion", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyGridState implements ScrollableState {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<LazyGridState, ?> Saver = ListSaverKt.listSaver(new Function2<SaverScope, LazyGridState, List<? extends Integer>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final List<Integer> invoke(SaverScope listSaver, LazyGridState it) {
            Intrinsics.checkNotNullParameter(listSaver, "$this$listSaver");
            Intrinsics.checkNotNullParameter(it, "it");
            return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(it.getFirstVisibleItemIndex()), Integer.valueOf(it.getFirstVisibleItemScrollOffset())});
        }
    }, new Function1<List<? extends Integer>, LazyGridState>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ LazyGridState invoke(List<? extends Integer> list) {
            return invoke2((List<Integer>) list);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final LazyGridState invoke2(List<Integer> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new LazyGridState(it.get(0).intValue(), it.get(1).intValue());
        }
    });
    private final LazyGridAnimateScrollScope animateScrollScope;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private boolean canScrollBackward;
    private boolean canScrollForward;
    private final MutableVector<LazyLayoutPrefetchState.PrefetchHandle> currentLinePrefetchHandles;

    /* renamed from: density$delegate, reason: from kotlin metadata */
    private final MutableState density;
    private final MutableInteractionSource internalInteractionSource;

    /* renamed from: isVertical$delegate, reason: from kotlin metadata */
    private final MutableState isVertical;
    private final MutableState<LazyGridLayoutInfo> layoutInfoState;
    private int lineToPrefetch;
    private int numMeasurePasses;

    /* renamed from: placementAnimator$delegate, reason: from kotlin metadata */
    private final MutableState placementAnimator;

    /* renamed from: prefetchInfoRetriever$delegate, reason: from kotlin metadata */
    private final MutableState prefetchInfoRetriever;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;

    /* renamed from: remeasurement$delegate, reason: from kotlin metadata */
    private final MutableState remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final LazyGridScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;

    /* renamed from: slotsPerLine$delegate, reason: from kotlin metadata */
    private final MutableState slotsPerLine;
    private boolean wasScrollingForward;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LazyGridState() {
        this(r2, r2, 3, null);
        int i = 0;
    }

    public LazyGridState(int firstVisibleItemIndex, int firstVisibleItemScrollOffset) {
        this.scrollPosition = new LazyGridScrollPosition(firstVisibleItemIndex, firstVisibleItemScrollOffset);
        this.layoutInfoState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(EmptyLazyGridLayoutInfo.INSTANCE, null, 2, null);
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.slotsPerLine = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.density = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DensityKt.Density(1.0f, 1.0f), null, 2, null);
        this.isVertical = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.scrollableState = ScrollableStateKt.ScrollableState(new Function1<Float, Float>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$scrollableState$1
            {
                super(1);
            }

            public final Float invoke(float it) {
                return Float.valueOf(-LazyGridState.this.onScroll$foundation_release(-it));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f) {
                return invoke(f.floatValue());
            }
        });
        this.prefetchingEnabled = true;
        this.lineToPrefetch = -1;
        this.currentLinePrefetchHandles = new MutableVector<>(new LazyLayoutPrefetchState.PrefetchHandle[16], 0);
        this.remeasurement = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.remeasurementModifier = new RemeasurementModifier() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$remeasurementModifier$1
            @Override // androidx.compose.p000ui.layout.RemeasurementModifier
            public void onRemeasurementAvailable(Remeasurement remeasurement) {
                Intrinsics.checkNotNullParameter(remeasurement, "remeasurement");
                LazyGridState.this.setRemeasurement(remeasurement);
            }
        };
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.prefetchInfoRetriever = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Function1<LineIndex, List<? extends Pair<? extends Integer, ? extends Constraints>>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$prefetchInfoRetriever$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ List<? extends Pair<? extends Integer, ? extends Constraints>> invoke(LineIndex lineIndex) {
                return m939invokebKFJvoY(lineIndex.m958unboximpl());
            }

            /* renamed from: invoke-bKFJvoY, reason: not valid java name */
            public final List<Pair<Integer, Constraints>> m939invokebKFJvoY(int it) {
                return CollectionsKt.emptyList();
            }
        }, null, 2, null);
        this.placementAnimator = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.animateScrollScope = new LazyGridAnimateScrollScope(this);
        this.prefetchState = new LazyLayoutPrefetchState();
    }

    public /* synthetic */ LazyGridState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.m936getIndexVZbfaAc();
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.getScrollOffset();
    }

    public final LazyGridLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    /* renamed from: getInternalInteractionSource$foundation_release, reason: from getter */
    public final MutableInteractionSource getInternalInteractionSource() {
        return this.internalInteractionSource;
    }

    /* renamed from: getScrollToBeConsumed$foundation_release, reason: from getter */
    public final float getScrollToBeConsumed() {
        return this.scrollToBeConsumed;
    }

    public final int getSlotsPerLine$foundation_release() {
        State $this$getValue$iv = this.slotsPerLine;
        return ((Number) $this$getValue$iv.getValue()).intValue();
    }

    public final void setSlotsPerLine$foundation_release(int i) {
        MutableState $this$setValue$iv = this.slotsPerLine;
        $this$setValue$iv.setValue(Integer.valueOf(i));
    }

    public final Density getDensity$foundation_release() {
        State $this$getValue$iv = this.density;
        return (Density) $this$getValue$iv.getValue();
    }

    public final void setDensity$foundation_release(Density density) {
        Intrinsics.checkNotNullParameter(density, "<set-?>");
        MutableState $this$setValue$iv = this.density;
        $this$setValue$iv.setValue(density);
    }

    public final boolean isVertical$foundation_release() {
        State $this$getValue$iv = this.isVertical;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setVertical$foundation_release(boolean z) {
        MutableState $this$setValue$iv = this.isVertical;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    /* renamed from: getNumMeasurePasses$foundation_release, reason: from getter */
    public final int getNumMeasurePasses() {
        return this.numMeasurePasses;
    }

    /* renamed from: getPrefetchingEnabled$foundation_release, reason: from getter */
    public final boolean getPrefetchingEnabled() {
        return this.prefetchingEnabled;
    }

    public final void setPrefetchingEnabled$foundation_release(boolean z) {
        this.prefetchingEnabled = z;
    }

    private final Remeasurement getRemeasurement() {
        State $this$getValue$iv = this.remeasurement;
        return (Remeasurement) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRemeasurement(Remeasurement remeasurement) {
        MutableState $this$setValue$iv = this.remeasurement;
        $this$setValue$iv.setValue(remeasurement);
    }

    /* renamed from: getRemeasurementModifier$foundation_release, reason: from getter */
    public final RemeasurementModifier getRemeasurementModifier() {
        return this.remeasurementModifier;
    }

    /* renamed from: getAwaitLayoutModifier$foundation_release, reason: from getter */
    public final AwaitFirstLayoutModifier getAwaitLayoutModifier() {
        return this.awaitLayoutModifier;
    }

    public final Function1<LineIndex, List<Pair<Integer, Constraints>>> getPrefetchInfoRetriever$foundation_release() {
        State $this$getValue$iv = this.prefetchInfoRetriever;
        return (Function1) $this$getValue$iv.getValue();
    }

    public final void setPrefetchInfoRetriever$foundation_release(Function1<? super LineIndex, ? extends List<Pair<Integer, Constraints>>> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        MutableState $this$setValue$iv = this.prefetchInfoRetriever;
        $this$setValue$iv.setValue(function1);
    }

    public final LazyGridItemPlacementAnimator getPlacementAnimator$foundation_release() {
        State $this$getValue$iv = this.placementAnimator;
        return (LazyGridItemPlacementAnimator) $this$getValue$iv.getValue();
    }

    public final void setPlacementAnimator$foundation_release(LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator) {
        MutableState $this$setValue$iv = this.placementAnimator;
        $this$setValue$iv.setValue(lazyGridItemPlacementAnimator);
    }

    public static /* synthetic */ Object scrollToItem$default(LazyGridState lazyGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyGridState.scrollToItem(i, i2, continuation);
    }

    public final Object scrollToItem(int index, int scrollOffset, Continuation<? super Unit> continuation) {
        Object scroll$default = ScrollableState.scroll$default(this, null, new LazyGridState$scrollToItem$2(this, index, scrollOffset, null), continuation, 1, null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }

    public final void snapToItemIndexInternal$foundation_release(int index, int scrollOffset) {
        this.scrollPosition.m937requestPositionyO3Fmg4(ItemIndex.m898constructorimpl(index), scrollOffset);
        LazyGridItemPlacementAnimator placementAnimator$foundation_release = getPlacementAnimator$foundation_release();
        if (placementAnimator$foundation_release != null) {
            placementAnimator$foundation_release.reset();
        }
        Remeasurement remeasurement = getRemeasurement();
        if (remeasurement != null) {
            remeasurement.forceRemeasure();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object scroll(MutatePriority scrollPriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        LazyGridState$scroll$1 lazyGridState$scroll$1;
        LazyGridState$scroll$1 lazyGridState$scroll$12;
        LazyGridState lazyGridState;
        MutatePriority scrollPriority2;
        Function2 block;
        ScrollableState scrollableState;
        if (continuation instanceof LazyGridState$scroll$1) {
            lazyGridState$scroll$1 = (LazyGridState$scroll$1) continuation;
            if ((lazyGridState$scroll$1.label & Integer.MIN_VALUE) != 0) {
                lazyGridState$scroll$1.label -= Integer.MIN_VALUE;
                lazyGridState$scroll$12 = lazyGridState$scroll$1;
                Object $result = lazyGridState$scroll$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (lazyGridState$scroll$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        lazyGridState = this;
                        AwaitFirstLayoutModifier awaitFirstLayoutModifier = lazyGridState.awaitLayoutModifier;
                        lazyGridState$scroll$12.L$0 = lazyGridState;
                        lazyGridState$scroll$12.L$1 = scrollPriority;
                        lazyGridState$scroll$12.L$2 = function2;
                        lazyGridState$scroll$12.label = 1;
                        if (awaitFirstLayoutModifier.waitForFirstLayout(lazyGridState$scroll$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        scrollPriority2 = scrollPriority;
                        block = function2;
                        scrollableState = lazyGridState.scrollableState;
                        lazyGridState$scroll$12.L$0 = null;
                        lazyGridState$scroll$12.L$1 = null;
                        lazyGridState$scroll$12.L$2 = null;
                        lazyGridState$scroll$12.label = 2;
                        if (scrollableState.scroll(scrollPriority2, block, lazyGridState$scroll$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        block = (Function2) lazyGridState$scroll$12.L$2;
                        scrollPriority2 = (MutatePriority) lazyGridState$scroll$12.L$1;
                        lazyGridState = (LazyGridState) lazyGridState$scroll$12.L$0;
                        ResultKt.throwOnFailure($result);
                        scrollableState = lazyGridState.scrollableState;
                        lazyGridState$scroll$12.L$0 = null;
                        lazyGridState$scroll$12.L$1 = null;
                        lazyGridState$scroll$12.L$2 = null;
                        lazyGridState$scroll$12.label = 2;
                        if (scrollableState.scroll(scrollPriority2, block, lazyGridState$scroll$12) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        lazyGridState$scroll$1 = new LazyGridState$scroll$1(this, continuation);
        lazyGridState$scroll$12 = lazyGridState$scroll$1;
        Object $result2 = lazyGridState$scroll$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (lazyGridState$scroll$12.label) {
        }
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float delta) {
        return this.scrollableState.dispatchRawDelta(delta);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    /* renamed from: getCanScrollForward$foundation_release, reason: from getter */
    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final float onScroll$foundation_release(float distance) {
        if ((distance < 0.0f && !this.canScrollForward) || (distance > 0.0f && !this.canScrollBackward)) {
            return 0.0f;
        }
        if (!(Math.abs(this.scrollToBeConsumed) <= 0.5f)) {
            throw new IllegalStateException(("entered drag with non-zero pending scroll: " + this.scrollToBeConsumed).toString());
        }
        this.scrollToBeConsumed += distance;
        if (Math.abs(this.scrollToBeConsumed) > 0.5f) {
            float preScrollToBeConsumed = this.scrollToBeConsumed;
            Remeasurement remeasurement = getRemeasurement();
            if (remeasurement != null) {
                remeasurement.forceRemeasure();
            }
            if (this.prefetchingEnabled) {
                notifyPrefetch(preScrollToBeConsumed - this.scrollToBeConsumed);
            }
        }
        float preScrollToBeConsumed2 = this.scrollToBeConsumed;
        if (Math.abs(preScrollToBeConsumed2) <= 0.5f) {
            return distance;
        }
        float scrollConsumed = distance - this.scrollToBeConsumed;
        this.scrollToBeConsumed = 0.0f;
        return scrollConsumed;
    }

    private final void notifyPrefetch(float delta) {
        int lineToPrefetch;
        int closestNextItemToPrefetch;
        MutableVector this_$iv;
        int size$iv;
        LazyLayoutPrefetchState prefetchState = this.prefetchState;
        if (!this.prefetchingEnabled) {
            return;
        }
        LazyGridLayoutInfo info = getLayoutInfo();
        if (!info.getVisibleItemsInfo().isEmpty()) {
            boolean z = false;
            boolean scrollingForward = delta < 0.0f;
            if (scrollingForward) {
                LazyGridItemInfo it = (LazyGridItemInfo) CollectionsKt.last((List) info.getVisibleItemsInfo());
                lineToPrefetch = (isVertical$foundation_release() ? it.getRow() : it.getColumn()) + 1;
                closestNextItemToPrefetch = ((LazyGridItemInfo) CollectionsKt.last((List) info.getVisibleItemsInfo())).getIndex() + 1;
            } else {
                LazyGridItemInfo it2 = (LazyGridItemInfo) CollectionsKt.first((List) info.getVisibleItemsInfo());
                lineToPrefetch = (isVertical$foundation_release() ? it2.getRow() : it2.getColumn()) - 1;
                closestNextItemToPrefetch = ((LazyGridItemInfo) CollectionsKt.first((List) info.getVisibleItemsInfo())).getIndex() - 1;
            }
            int closestNextItemToPrefetch2 = this.lineToPrefetch;
            if (lineToPrefetch != closestNextItemToPrefetch2) {
                if (closestNextItemToPrefetch >= 0 && closestNextItemToPrefetch < info.getTotalItemsCount()) {
                    z = true;
                }
                if (z) {
                    if (this.wasScrollingForward != scrollingForward && (size$iv = (this_$iv = this.currentLinePrefetchHandles).getSize()) > 0) {
                        int i$iv = 0;
                        Object[] content$iv = this_$iv.getContent();
                        Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                        do {
                            ((LazyLayoutPrefetchState.PrefetchHandle) content$iv[i$iv]).cancel();
                            i$iv++;
                        } while (i$iv < size$iv);
                    }
                    this.wasScrollingForward = scrollingForward;
                    this.lineToPrefetch = lineToPrefetch;
                    this.currentLinePrefetchHandles.clear();
                    List $this$fastForEach$iv = getPrefetchInfoRetriever$foundation_release().invoke(LineIndex.m946boximpl(LineIndex.m948constructorimpl(lineToPrefetch)));
                    int index$iv = 0;
                    int size = $this$fastForEach$iv.size();
                    while (index$iv < size) {
                        Object item$iv = $this$fastForEach$iv.get(index$iv);
                        Pair it3 = (Pair) item$iv;
                        this.currentLinePrefetchHandles.add(prefetchState.m963schedulePrefetch0kLqBqw(it3.getFirst().intValue(), it3.getSecond().getValue()));
                        index$iv++;
                        info = info;
                        scrollingForward = scrollingForward;
                    }
                }
            }
        }
    }

    private final void cancelPrefetchIfVisibleItemsChanged(LazyGridLayoutInfo info) {
        int row;
        if (this.lineToPrefetch != -1 && !info.getVisibleItemsInfo().isEmpty()) {
            if (this.wasScrollingForward) {
                LazyGridItemInfo it = (LazyGridItemInfo) CollectionsKt.last((List) info.getVisibleItemsInfo());
                row = (isVertical$foundation_release() ? it.getRow() : it.getColumn()) + 1;
            } else {
                LazyGridItemInfo it2 = (LazyGridItemInfo) CollectionsKt.first((List) info.getVisibleItemsInfo());
                row = (isVertical$foundation_release() ? it2.getRow() : it2.getColumn()) - 1;
            }
            int expectedLineToPrefetch = row;
            if (this.lineToPrefetch != expectedLineToPrefetch) {
                this.lineToPrefetch = -1;
                MutableVector this_$iv = this.currentLinePrefetchHandles;
                int size$iv = this_$iv.getSize();
                if (size$iv > 0) {
                    int i$iv = 0;
                    Object[] content$iv = this_$iv.getContent();
                    Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                    do {
                        ((LazyLayoutPrefetchState.PrefetchHandle) content$iv[i$iv]).cancel();
                        i$iv++;
                    } while (i$iv < size$iv);
                }
                this.currentLinePrefetchHandles.clear();
            }
        }
    }

    /* renamed from: getPrefetchState$foundation_release, reason: from getter */
    public final LazyLayoutPrefetchState getPrefetchState() {
        return this.prefetchState;
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyGridState lazyGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyGridState.animateScrollToItem(i, i2, continuation);
    }

    public final Object animateScrollToItem(int index, int scrollOffset, Continuation<? super Unit> continuation) {
        Object animateScrollToItem = LazyAnimateScrollKt.animateScrollToItem(this.animateScrollScope, index, scrollOffset, continuation);
        return animateScrollToItem == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToItem : Unit.INSTANCE;
    }

    public final void applyMeasureResult$foundation_release(LazyGridMeasureResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.scrollPosition.updateFromMeasureResult(result);
        this.scrollToBeConsumed -= result.getConsumedScroll();
        this.layoutInfoState.setValue(result);
        this.canScrollForward = result.getCanScrollForward();
        LazyMeasuredLine firstVisibleLine = result.getFirstVisibleLine();
        this.canScrollBackward = ((firstVisibleLine != null ? firstVisibleLine.getIndex() : 0) == 0 && result.getFirstVisibleLineScrollOffset() == 0) ? false : true;
        this.numMeasurePasses++;
        cancelPrefetchIfVisibleItemsChanged(result);
    }

    public final void updateScrollPositionIfTheFirstItemWasMoved$foundation_release(LazyGridItemProvider itemProvider) {
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(itemProvider);
    }

    /* compiled from: LazyGridState.kt */
    @Metadata(m286d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m287d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<LazyGridState, ?> getSaver() {
            return LazyGridState.Saver;
        }
    }
}
