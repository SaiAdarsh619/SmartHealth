package androidx.compose.foundation.gestures;

import androidx.compose.foundation.FocusedBoundsKt;
import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.foundation.relocation.BringIntoViewResponderKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.geometry.RectKt;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.OnPlacedModifier;
import androidx.compose.p000ui.layout.OnRemeasuredModifier;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.IntSizeKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonCancellable;

/* compiled from: ContentInViewModifier.kt */
@Metadata(m286d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ!\u0010\"\u001a\u00020#2\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120%H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0012H\u0016J%\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020!H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001d\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020!H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101J%\u00102\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104J!\u00105\u001a\u00020#2\u0006\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u00108J \u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020:H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006>"}, m287d2 = {"Landroidx/compose/foundation/gestures/ContentInViewModifier;", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "Landroidx/compose/ui/layout/OnRemeasuredModifier;", "Landroidx/compose/ui/layout/OnPlacedModifier;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "reverseDirection", "", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/ScrollableState;Z)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "focusAnimationJob", "Lkotlinx/coroutines/Job;", "<set-?>", "Landroidx/compose/ui/geometry/Rect;", "focusTargetBounds", "getFocusTargetBounds", "()Landroidx/compose/ui/geometry/Rect;", "setFocusTargetBounds", "(Landroidx/compose/ui/geometry/Rect;)V", "focusTargetBounds$delegate", "Landroidx/compose/runtime/MutableState;", "focusedChild", "focusedChildBeingAnimated", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "oldSize", "Landroidx/compose/ui/unit/IntSize;", "bringChildIntoView", "", "localRect", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateRectForParent", "computeDestination", "childBounds", "containerSize", "computeDestination-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/Rect;", "onPlaced", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "onSizeChanged", "onSizeChanged-O0kMr_c", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)V", "performBringIntoView", "source", "destination", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "relocationDistance", "", "leadingEdge", "trailingEdge", "parentSize", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ContentInViewModifier implements BringIntoViewResponder, OnRemeasuredModifier, OnPlacedModifier {
    private LayoutCoordinates coordinates;
    private Job focusAnimationJob;

    /* renamed from: focusTargetBounds$delegate, reason: from kotlin metadata */
    private final MutableState focusTargetBounds;
    private LayoutCoordinates focusedChild;
    private LayoutCoordinates focusedChildBeingAnimated;
    private final Modifier modifier;
    private IntSize oldSize;
    private final Orientation orientation;
    private final boolean reverseDirection;
    private final CoroutineScope scope;
    private final ScrollableState scrollableState;

    /* compiled from: ContentInViewModifier.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            iArr[Orientation.Vertical.ordinal()] = 1;
            iArr[Orientation.Horizontal.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ContentInViewModifier(CoroutineScope scope, Orientation orientation, ScrollableState scrollableState, boolean reverseDirection) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(scrollableState, "scrollableState");
        this.scope = scope;
        this.orientation = orientation;
        this.scrollableState = scrollableState;
        this.reverseDirection = reverseDirection;
        this.focusTargetBounds = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.modifier = BringIntoViewResponderKt.bringIntoViewResponder(FocusedBoundsKt.onFocusedBoundsChanged(this, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewModifier$modifier$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates it) {
                ContentInViewModifier.this.focusedChild = it;
            }
        }), this);
    }

    private final Rect getFocusTargetBounds() {
        State $this$getValue$iv = this.focusTargetBounds;
        return (Rect) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFocusTargetBounds(Rect rect) {
        MutableState $this$setValue$iv = this.focusTargetBounds;
        $this$setValue$iv.setValue(rect);
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.p000ui.layout.OnRemeasuredModifier
    /* renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    public void mo572onRemeasuredozmzZPI(long size) {
        LayoutCoordinates coordinates = this.coordinates;
        IntSize oldSize = this.oldSize;
        if (oldSize != null && !IntSize.m4540equalsimpl0(oldSize.getPackedValue(), size)) {
            boolean z = false;
            if (coordinates != null && coordinates.isAttached()) {
                z = true;
            }
            if (z) {
                m571onSizeChangedO0kMr_c(coordinates, oldSize.getPackedValue());
            }
        }
        this.oldSize = IntSize.m4534boximpl(size);
    }

    @Override // androidx.compose.p000ui.layout.OnPlacedModifier
    public void onPlaced(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        this.coordinates = coordinates;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Rect calculateRectForParent(Rect localRect) {
        Intrinsics.checkNotNullParameter(localRect, "localRect");
        IntSize intSize = this.oldSize;
        if (intSize == null) {
            throw new IllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.".toString());
        }
        long oldSize = intSize.getPackedValue();
        return m570computeDestinationO0kMr_c(localRect, oldSize);
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Object bringChildIntoView(Function0<Rect> function0, Continuation<? super Unit> continuation) {
        Object performBringIntoView;
        Rect localRect = function0.invoke();
        return (localRect != null && (performBringIntoView = performBringIntoView(localRect, calculateRectForParent(localRect), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? performBringIntoView : Unit.INSTANCE;
    }

    /* renamed from: onSizeChanged-O0kMr_c, reason: not valid java name */
    private final void m571onSizeChangedO0kMr_c(LayoutCoordinates coordinates, long oldSize) {
        LayoutCoordinates focusedChild;
        Rect eventualFocusedBounds;
        boolean z = true;
        if (this.orientation == Orientation.Horizontal) {
            if (IntSize.m4542getWidthimpl(coordinates.mo3497getSizeYbymL2g()) >= IntSize.m4542getWidthimpl(oldSize)) {
                z = false;
            }
        } else if (IntSize.m4541getHeightimpl(coordinates.mo3497getSizeYbymL2g()) >= IntSize.m4541getHeightimpl(oldSize)) {
            z = false;
        }
        boolean containerShrunk = z;
        if (containerShrunk && (focusedChild = this.focusedChild) != null) {
            Rect focusedBounds = coordinates.localBoundingBoxOf(focusedChild, false);
            if (focusedChild == this.focusedChildBeingAnimated) {
                eventualFocusedBounds = getFocusTargetBounds();
                if (eventualFocusedBounds == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            } else {
                eventualFocusedBounds = focusedBounds;
            }
            Rect myOldBounds = RectKt.m1800Recttz77jQw(Offset.INSTANCE.m1776getZeroF1C5BW0(), IntSizeKt.m4552toSizeozmzZPI(oldSize));
            if (!myOldBounds.overlaps(eventualFocusedBounds)) {
                return;
            }
            Rect targetBounds = m570computeDestinationO0kMr_c(eventualFocusedBounds, coordinates.mo3497getSizeYbymL2g());
            if (Intrinsics.areEqual(targetBounds, eventualFocusedBounds)) {
                return;
            }
            this.focusedChildBeingAnimated = focusedChild;
            setFocusTargetBounds(targetBounds);
            BuildersKt__Builders_commonKt.launch$default(this.scope, NonCancellable.INSTANCE, null, new ContentInViewModifier$onSizeChanged$1(this, focusedBounds, targetBounds, null), 2, null);
        }
    }

    /* renamed from: computeDestination-O0kMr_c, reason: not valid java name */
    private final Rect m570computeDestinationO0kMr_c(Rect childBounds, long containerSize) {
        long size = IntSizeKt.m4552toSizeozmzZPI(containerSize);
        switch (WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()]) {
            case 1:
                return childBounds.translate(0.0f, -relocationDistance(childBounds.getTop(), childBounds.getBottom(), Size.m1826getHeightimpl(size)));
            case 2:
                return childBounds.translate(-relocationDistance(childBounds.getLeft(), childBounds.getRight(), Size.m1829getWidthimpl(size)), 0.0f);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performBringIntoView(Rect source, Rect destination, Continuation<? super Unit> continuation) {
        float offset;
        switch (WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()]) {
            case 1:
                offset = destination.getTop() - source.getTop();
                break;
            case 2:
                offset = destination.getLeft() - source.getLeft();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        float scrollDelta = this.reverseDirection ? -offset : offset;
        Object animateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(this.scrollableState, scrollDelta, null, continuation, 2, null);
        return animateScrollBy$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollBy$default : Unit.INSTANCE;
    }

    private final float relocationDistance(float leadingEdge, float trailingEdge, float parentSize) {
        if (leadingEdge >= 0.0f && trailingEdge <= parentSize) {
            return 0.0f;
        }
        if (leadingEdge >= 0.0f || trailingEdge <= parentSize) {
            return Math.abs(leadingEdge) < Math.abs(trailingEdge - parentSize) ? leadingEdge : trailingEdge - parentSize;
        }
        return 0.0f;
    }
}
