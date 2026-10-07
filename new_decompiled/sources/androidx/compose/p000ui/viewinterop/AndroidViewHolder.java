package androidx.compose.p000ui.viewinterop;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.DrawModifierKt;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p000ui.graphics.Canvas;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.p000ui.input.pointer.PointerInteropFilter_androidKt;
import androidx.compose.p000ui.layout.IntrinsicMeasurable;
import androidx.compose.p000ui.layout.IntrinsicMeasureScope;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.node.LayoutNode;
import androidx.compose.p000ui.node.Owner;
import androidx.compose.p000ui.platform.AndroidComposeView;
import androidx.compose.p000ui.platform.NestedScrollInteropConnectionKt;
import androidx.compose.p000ui.platform.WindowRecomposer_androidKt;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.DensityKt;
import androidx.compose.p000ui.unit.VelocityKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.google.common.primitives.Ints;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: AndroidViewHolder.android.kt */
@Metadata(m286d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\u0017\b \u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010M\u001a\u00020\u00122\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\n\u0010P\u001a\u0004\u0018\u00010QH\u0016J\b\u0010R\u001a\u00020\u0014H\u0016J\u001e\u0010S\u001a\u0004\u0018\u00010T2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\b\u0010W\u001a\u00020\u0012H\u0016J \u0010X\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\u00142\u0006\u0010[\u001a\u00020\u0014H\u0002J\b\u0010\\\u001a\u00020,H\u0014J\u0018\u0010]\u001a\u00020,2\u0006\u0010^\u001a\u00020G2\u0006\u0010_\u001a\u00020GH\u0016J\b\u0010`\u001a\u00020,H\u0014J0\u0010a\u001a\u00020,2\u0006\u0010b\u001a\u00020\u00122\u0006\u0010c\u001a\u00020\u00142\u0006\u0010d\u001a\u00020\u00142\u0006\u0010e\u001a\u00020\u00142\u0006\u0010f\u001a\u00020\u0014H\u0014J\u0018\u0010g\u001a\u00020,2\u0006\u0010h\u001a\u00020\u00142\u0006\u0010i\u001a\u00020\u0014H\u0014J(\u0010j\u001a\u00020\u00122\u0006\u0010_\u001a\u00020G2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020l2\u0006\u0010n\u001a\u00020\u0012H\u0016J \u0010o\u001a\u00020\u00122\u0006\u0010_\u001a\u00020G2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020lH\u0016J0\u0010p\u001a\u00020,2\u0006\u0010_\u001a\u00020G2\u0006\u0010q\u001a\u00020\u00142\u0006\u0010r\u001a\u00020\u00142\u0006\u0010n\u001a\u00020!2\u0006\u0010s\u001a\u00020\u0014H\u0016J8\u0010t\u001a\u00020,2\u0006\u0010_\u001a\u00020G2\u0006\u0010u\u001a\u00020\u00142\u0006\u0010v\u001a\u00020\u00142\u0006\u0010w\u001a\u00020\u00142\u0006\u0010x\u001a\u00020\u00142\u0006\u0010s\u001a\u00020\u0014H\u0016J@\u0010t\u001a\u00020,2\u0006\u0010_\u001a\u00020G2\u0006\u0010u\u001a\u00020\u00142\u0006\u0010v\u001a\u00020\u00142\u0006\u0010w\u001a\u00020\u00142\u0006\u0010x\u001a\u00020\u00142\u0006\u0010s\u001a\u00020\u00142\u0006\u0010n\u001a\u00020!H\u0016J(\u0010y\u001a\u00020,2\u0006\u0010^\u001a\u00020G2\u0006\u0010_\u001a\u00020G2\u0006\u0010z\u001a\u00020\u00142\u0006\u0010s\u001a\u00020\u0014H\u0016J(\u0010{\u001a\u00020\u00122\u0006\u0010^\u001a\u00020G2\u0006\u0010_\u001a\u00020G2\u0006\u0010z\u001a\u00020\u00142\u0006\u0010s\u001a\u00020\u0014H\u0016J\u0018\u0010|\u001a\u00020,2\u0006\u0010_\u001a\u00020G2\u0006\u0010s\u001a\u00020\u0014H\u0016J\u0010\u0010}\u001a\u00020,2\u0006\u0010~\u001a\u00020\u0014H\u0014J\u0006\u0010\u007f\u001a\u00020,J\u0012\u0010\u0080\u0001\u001a\u00020,2\u0007\u0010\u0081\u0001\u001a\u00020\u0012H\u0016J\t\u0010\u0082\u0001\u001a\u00020\u0012H\u0016R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R(\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\n\u001a\u0004\u0018\u00010\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010#\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\"@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020,0+X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020,\u0018\u00010+X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00102\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020,\u0018\u00010+X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R(\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020,\u0018\u00010+X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020,09X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010;\u001a\u0004\u0018\u00010:2\b\u0010\n\u001a\u0004\u0018\u00010:@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010B\u001a\b\u0012\u0004\u0012\u00020,092\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020,09@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR(\u0010H\u001a\u0004\u0018\u00010G2\b\u0010\n\u001a\u0004\u0018\u00010G@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006\u0083\u0001"}, m287d2 = {"Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroid/view/ViewGroup;", "Landroidx/core/view/NestedScrollingParent3;", "context", "Landroid/content/Context;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "hasUpdateBlock", "", "lastHeightMeasureSpec", "", "lastWidthMeasureSpec", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "location", "", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "nestedScrollingParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "onCommitAffectingUpdate", "Lkotlin/Function1;", "", "onDensityChanged", "getOnDensityChanged$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnDensityChanged$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onModifierChanged", "getOnModifierChanged$ui_release", "setOnModifierChanged$ui_release", "onRequestDisallowInterceptTouchEvent", "getOnRequestDisallowInterceptTouchEvent$ui_release", "setOnRequestDisallowInterceptTouchEvent$ui_release", "runUpdate", "Lkotlin/Function0;", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedStateRegistryOwner", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "setSavedStateRegistryOwner", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "snapshotObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "update", "getUpdate", "()Lkotlin/jvm/functions/Function0;", "setUpdate", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/View;", "view", "getView", "()Landroid/view/View;", "setView$ui_release", "(Landroid/view/View;)V", "gatherTransparentRegion", "region", "Landroid/graphics/Region;", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getNestedScrollAxes", "invalidateChildInParent", "Landroid/view/ViewParent;", "dirty", "Landroid/graphics/Rect;", "isNestedScrollingEnabled", "obtainMeasureSpec", "min", "max", "preferred", "onAttachedToWindow", "onDescendantInvalidated", "child", "target", "onDetachedFromWindow", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedFling", "velocityX", "", "velocityY", "consumed", "onNestedPreFling", "onNestedPreScroll", "dx", "dy", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "axes", "onStartNestedScroll", "onStopNestedScroll", "onWindowVisibilityChanged", "visibility", "remeasure", "requestDisallowInterceptTouchEvent", "disallowIntercept", "shouldDelayChildPressedState", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidViewHolder extends ViewGroup implements NestedScrollingParent3 {
    private Density density;
    private final NestedScrollDispatcher dispatcher;
    private boolean hasUpdateBlock;
    private int lastHeightMeasureSpec;
    private int lastWidthMeasureSpec;
    private final LayoutNode layoutNode;
    private LifecycleOwner lifecycleOwner;
    private final int[] location;
    private Modifier modifier;
    private final NestedScrollingParentHelper nestedScrollingParentHelper;
    private final Function1<AndroidViewHolder, Unit> onCommitAffectingUpdate;
    private Function1<? super Density, Unit> onDensityChanged;
    private Function1<? super Modifier, Unit> onModifierChanged;
    private Function1<? super Boolean, Unit> onRequestDisallowInterceptTouchEvent;
    private final Function0<Unit> runUpdate;
    private SavedStateRegistryOwner savedStateRegistryOwner;
    private final SnapshotStateObserver snapshotObserver;
    private Function0<Unit> update;
    private View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AndroidViewHolder(Context context, CompositionContext compositionContext, NestedScrollDispatcher dispatcher) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        if (compositionContext != null) {
            WindowRecomposer_androidKt.setCompositionContext(this, compositionContext);
        }
        setSaveFromParentEnabled(false);
        this.update = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$update$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        };
        this.modifier = Modifier.INSTANCE;
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, null);
        this.snapshotObserver = new SnapshotStateObserver(new AndroidViewHolder$snapshotObserver$1(this));
        this.onCommitAffectingUpdate = new AndroidViewHolder$onCommitAffectingUpdate$1(this);
        this.runUpdate = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$runUpdate$1
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
                boolean z;
                SnapshotStateObserver snapshotStateObserver;
                Function1 function1;
                z = AndroidViewHolder.this.hasUpdateBlock;
                if (z) {
                    snapshotStateObserver = AndroidViewHolder.this.snapshotObserver;
                    AndroidViewHolder androidViewHolder = AndroidViewHolder.this;
                    function1 = AndroidViewHolder.this.onCommitAffectingUpdate;
                    snapshotStateObserver.observeReads(androidViewHolder, function1, AndroidViewHolder.this.getUpdate());
                }
            }
        };
        this.location = new int[2];
        this.lastWidthMeasureSpec = Integer.MIN_VALUE;
        this.lastHeightMeasureSpec = Integer.MIN_VALUE;
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        final AndroidViewHolder androidViewHolder = this;
        Object[] objArr = 0 == true ? 1 : 0;
        final LayoutNode layoutNode = new LayoutNode(false, objArr, 3, null);
        final Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(DrawModifierKt.drawBehind(PointerInteropFilter_androidKt.pointerInteropFilter(Modifier.INSTANCE, androidViewHolder), new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawBehind) {
                Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
                LayoutNode layoutNode2 = LayoutNode.this;
                AndroidViewHolder androidViewHolder2 = this;
                Canvas canvas = drawBehind.getDrawContext().getCanvas();
                Owner owner = layoutNode2.getOwner();
                AndroidComposeView androidComposeView = owner instanceof AndroidComposeView ? (AndroidComposeView) owner : null;
                if (androidComposeView != null) {
                    androidComposeView.drawAndroidView(androidViewHolder2, AndroidCanvas_androidKt.getNativeCanvas(canvas));
                }
            }
        }), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Intrinsics.checkNotNullParameter(it, "it");
                AndroidViewHolder_androidKt.layoutAccordingTo(AndroidViewHolder.this, layoutNode);
            }
        });
        layoutNode.setModifier(androidViewHolder.modifier.then(onGloballyPositioned));
        androidViewHolder.onModifierChanged = new Function1<Modifier, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier) {
                invoke2(modifier);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Modifier it) {
                Intrinsics.checkNotNullParameter(it, "it");
                LayoutNode.this.setModifier(it.then(onGloballyPositioned));
            }
        };
        layoutNode.setDensity(androidViewHolder.density);
        androidViewHolder.onDensityChanged = new Function1<Density, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Density density) {
                invoke2(density);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Density it) {
                Intrinsics.checkNotNullParameter(it, "it");
                LayoutNode.this.setDensity(it);
            }
        };
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        layoutNode.setOnAttach$ui_release(new Function1<Owner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Owner owner) {
                invoke2(owner);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Owner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                AndroidComposeView androidComposeView = owner instanceof AndroidComposeView ? (AndroidComposeView) owner : null;
                if (androidComposeView != null) {
                    androidComposeView.addAndroidView(AndroidViewHolder.this, layoutNode);
                }
                if (objectRef.element != null) {
                    AndroidViewHolder.this.setView$ui_release(objectRef.element);
                }
            }
        });
        layoutNode.setOnDetach$ui_release(new Function1<Owner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Owner owner) {
                invoke2(owner);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [T, android.view.View] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Owner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                AndroidComposeView androidComposeView = owner instanceof AndroidComposeView ? (AndroidComposeView) owner : null;
                if (androidComposeView != null) {
                    androidComposeView.removeAndroidView(AndroidViewHolder.this);
                }
                objectRef.element = AndroidViewHolder.this.getView();
                AndroidViewHolder.this.setView$ui_release(null);
            }
        });
        layoutNode.setMeasurePolicy(new MeasurePolicy() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5
            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public MeasureResult mo331measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long constraints) {
                int obtainMeasureSpec;
                int obtainMeasureSpec2;
                Intrinsics.checkNotNullParameter(measure, "$this$measure");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                if (Constraints.m4340getMinWidthimpl(constraints) != 0) {
                    AndroidViewHolder.this.getChildAt(0).setMinimumWidth(Constraints.m4340getMinWidthimpl(constraints));
                }
                if (Constraints.m4339getMinHeightimpl(constraints) != 0) {
                    AndroidViewHolder.this.getChildAt(0).setMinimumHeight(Constraints.m4339getMinHeightimpl(constraints));
                }
                AndroidViewHolder androidViewHolder2 = AndroidViewHolder.this;
                AndroidViewHolder androidViewHolder3 = AndroidViewHolder.this;
                int m4340getMinWidthimpl = Constraints.m4340getMinWidthimpl(constraints);
                int m4338getMaxWidthimpl = Constraints.m4338getMaxWidthimpl(constraints);
                ViewGroup.LayoutParams layoutParams = AndroidViewHolder.this.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                obtainMeasureSpec = androidViewHolder3.obtainMeasureSpec(m4340getMinWidthimpl, m4338getMaxWidthimpl, layoutParams.width);
                AndroidViewHolder androidViewHolder4 = AndroidViewHolder.this;
                int m4339getMinHeightimpl = Constraints.m4339getMinHeightimpl(constraints);
                int m4337getMaxHeightimpl = Constraints.m4337getMaxHeightimpl(constraints);
                ViewGroup.LayoutParams layoutParams2 = AndroidViewHolder.this.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2);
                obtainMeasureSpec2 = androidViewHolder4.obtainMeasureSpec(m4339getMinHeightimpl, m4337getMaxHeightimpl, layoutParams2.height);
                androidViewHolder2.measure(obtainMeasureSpec, obtainMeasureSpec2);
                int measuredWidth = AndroidViewHolder.this.getMeasuredWidth();
                int measuredHeight = AndroidViewHolder.this.getMeasuredHeight();
                final AndroidViewHolder androidViewHolder5 = AndroidViewHolder.this;
                final LayoutNode layoutNode2 = layoutNode;
                return MeasureScope.layout$default(measure, measuredWidth, measuredHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5$measure$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope layout) {
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        AndroidViewHolder_androidKt.layoutAccordingTo(AndroidViewHolder.this, layoutNode2);
                    }
                }, 4, null);
            }

            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
                Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return intrinsicWidth(height);
            }

            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
                Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return intrinsicWidth(height);
            }

            private final int intrinsicWidth(int height) {
                int obtainMeasureSpec;
                AndroidViewHolder androidViewHolder2 = AndroidViewHolder.this;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                AndroidViewHolder androidViewHolder3 = AndroidViewHolder.this;
                ViewGroup.LayoutParams layoutParams = AndroidViewHolder.this.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                obtainMeasureSpec = androidViewHolder3.obtainMeasureSpec(0, height, layoutParams.height);
                androidViewHolder2.measure(makeMeasureSpec, obtainMeasureSpec);
                return AndroidViewHolder.this.getMeasuredWidth();
            }

            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
                Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return intrinsicHeight(width);
            }

            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
                Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return intrinsicHeight(width);
            }

            private final int intrinsicHeight(int width) {
                int obtainMeasureSpec;
                AndroidViewHolder androidViewHolder2 = AndroidViewHolder.this;
                AndroidViewHolder androidViewHolder3 = AndroidViewHolder.this;
                ViewGroup.LayoutParams layoutParams = AndroidViewHolder.this.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                obtainMeasureSpec = androidViewHolder3.obtainMeasureSpec(0, width, layoutParams.width);
                androidViewHolder2.measure(obtainMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
                return AndroidViewHolder.this.getMeasuredHeight();
            }
        });
        this.layoutNode = layoutNode;
    }

    public final View getView() {
        return this.view;
    }

    public final void setView$ui_release(View value) {
        if (value != this.view) {
            this.view = value;
            removeAllViewsInLayout();
            if (value != null) {
                addView(value);
                this.runUpdate.invoke();
            }
        }
    }

    public final Function0<Unit> getUpdate() {
        return this.update;
    }

    protected final void setUpdate(Function0<Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.update = value;
        this.hasUpdateBlock = true;
        this.runUpdate.invoke();
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final void setModifier(Modifier value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value != this.modifier) {
            this.modifier = value;
            Function1<? super Modifier, Unit> function1 = this.onModifierChanged;
            if (function1 != null) {
                function1.invoke(value);
            }
        }
    }

    public final Function1<Modifier, Unit> getOnModifierChanged$ui_release() {
        return this.onModifierChanged;
    }

    public final void setOnModifierChanged$ui_release(Function1<? super Modifier, Unit> function1) {
        this.onModifierChanged = function1;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final void setDensity(Density value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value != this.density) {
            this.density = value;
            Function1<? super Density, Unit> function1 = this.onDensityChanged;
            if (function1 != null) {
                function1.invoke(value);
            }
        }
    }

    public final Function1<Density, Unit> getOnDensityChanged$ui_release() {
        return this.onDensityChanged;
    }

    public final void setOnDensityChanged$ui_release(Function1<? super Density, Unit> function1) {
        this.onDensityChanged = function1;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final void setLifecycleOwner(LifecycleOwner value) {
        if (value != this.lifecycleOwner) {
            this.lifecycleOwner = value;
            ViewTreeLifecycleOwner.set(this, value);
        }
    }

    public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
        return this.savedStateRegistryOwner;
    }

    public final void setSavedStateRegistryOwner(SavedStateRegistryOwner value) {
        if (value != this.savedStateRegistryOwner) {
            this.savedStateRegistryOwner = value;
            ViewTreeSavedStateRegistryOwner.set(this, value);
        }
    }

    public final Function1<Boolean, Unit> getOnRequestDisallowInterceptTouchEvent$ui_release() {
        return this.onRequestDisallowInterceptTouchEvent;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(Function1<? super Boolean, Unit> function1) {
        this.onRequestDisallowInterceptTouchEvent = function1;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View view = this.view;
        if (view != null) {
            view.measure(widthMeasureSpec, heightMeasureSpec);
        }
        View view2 = this.view;
        int measuredWidth = view2 != null ? view2.getMeasuredWidth() : 0;
        View view3 = this.view;
        setMeasuredDimension(measuredWidth, view3 != null ? view3.getMeasuredHeight() : 0);
        this.lastWidthMeasureSpec = widthMeasureSpec;
        this.lastHeightMeasureSpec = heightMeasureSpec;
    }

    public final void remeasure() {
        if (this.lastWidthMeasureSpec == Integer.MIN_VALUE || this.lastHeightMeasureSpec == Integer.MIN_VALUE) {
            return;
        }
        measure(this.lastWidthMeasureSpec, this.lastHeightMeasureSpec);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        View view = this.view;
        if (view != null) {
            view.layout(0, 0, r - l, b - t);
        }
    }

    @Override // android.view.View
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams;
        View view = this.view;
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            return layoutParams;
        }
        return new ViewGroup.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        Function1<? super Boolean, Unit> function1 = this.onRequestDisallowInterceptTouchEvent;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(disallowIntercept));
        }
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.snapshotObserver.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.snapshotObserver.stop();
        this.snapshotObserver.clear();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] location, Rect dirty) {
        super.invalidateChildInParent(location, dirty);
        this.layoutNode.invalidateLayer$ui_release();
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View child, View target) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        super.onDescendantInvalidated(child, target);
        this.layoutNode.invalidateLayer$ui_release();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (region == null) {
            return true;
        }
        getLocationInWindow(this.location);
        region.op(this.location[0], this.location[1], this.location[0] + getWidth(), this.location[1] + getHeight(), Region.Op.DIFFERENCE);
        return true;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int obtainMeasureSpec(int min, int max, int preferred) {
        if (preferred >= 0 || min == max) {
            return View.MeasureSpec.makeMeasureSpec(RangesKt.coerceIn(preferred, min, max), Ints.MAX_POWER_OF_TWO);
        }
        if (preferred == -2 && max != Integer.MAX_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(max, Integer.MIN_VALUE);
        }
        if (preferred == -1 && max != Integer.MAX_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(max, Ints.MAX_POWER_OF_TWO);
        }
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View child, View target, int axes, int type) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        return ((axes & 2) == 0 && (axes & 1) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.nestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View child, View target, int axes, int type) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        this.nestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes, type);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View target, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.nestedScrollingParentHelper.onStopNestedScroll(target, type);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        float composeOffset;
        float composeOffset2;
        float composeOffset3;
        float composeOffset4;
        int nestedScrollSource;
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        if (isNestedScrollingEnabled()) {
            NestedScrollDispatcher nestedScrollDispatcher = this.dispatcher;
            composeOffset = AndroidViewHolder_androidKt.toComposeOffset(dxConsumed);
            composeOffset2 = AndroidViewHolder_androidKt.toComposeOffset(dyConsumed);
            long Offset = OffsetKt.Offset(composeOffset, composeOffset2);
            composeOffset3 = AndroidViewHolder_androidKt.toComposeOffset(dxUnconsumed);
            composeOffset4 = AndroidViewHolder_androidKt.toComposeOffset(dyUnconsumed);
            long Offset2 = OffsetKt.Offset(composeOffset3, composeOffset4);
            nestedScrollSource = AndroidViewHolder_androidKt.toNestedScrollSource(type);
            long consumedByParent = nestedScrollDispatcher.m3252dispatchPostScrollDzOQY0M(Offset, Offset2, nestedScrollSource);
            consumed[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1760getXimpl(consumedByParent));
            consumed[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1761getYimpl(consumedByParent));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        float composeOffset;
        float composeOffset2;
        float composeOffset3;
        float composeOffset4;
        int nestedScrollSource;
        Intrinsics.checkNotNullParameter(target, "target");
        if (isNestedScrollingEnabled()) {
            NestedScrollDispatcher nestedScrollDispatcher = this.dispatcher;
            composeOffset = AndroidViewHolder_androidKt.toComposeOffset(dxConsumed);
            composeOffset2 = AndroidViewHolder_androidKt.toComposeOffset(dyConsumed);
            long Offset = OffsetKt.Offset(composeOffset, composeOffset2);
            composeOffset3 = AndroidViewHolder_androidKt.toComposeOffset(dxUnconsumed);
            composeOffset4 = AndroidViewHolder_androidKt.toComposeOffset(dyUnconsumed);
            long Offset2 = OffsetKt.Offset(composeOffset3, composeOffset4);
            nestedScrollSource = AndroidViewHolder_androidKt.toNestedScrollSource(type);
            nestedScrollDispatcher.m3252dispatchPostScrollDzOQY0M(Offset, Offset2, nestedScrollSource);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed, int type) {
        float composeOffset;
        float composeOffset2;
        int nestedScrollSource;
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        if (isNestedScrollingEnabled()) {
            NestedScrollDispatcher nestedScrollDispatcher = this.dispatcher;
            composeOffset = AndroidViewHolder_androidKt.toComposeOffset(dx);
            composeOffset2 = AndroidViewHolder_androidKt.toComposeOffset(dy);
            long Offset = OffsetKt.Offset(composeOffset, composeOffset2);
            nestedScrollSource = AndroidViewHolder_androidKt.toNestedScrollSource(type);
            long consumedByParent = nestedScrollDispatcher.m3254dispatchPreScrollOzD1aCk(Offset, nestedScrollSource);
            consumed[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1760getXimpl(consumedByParent));
            consumed[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1761getYimpl(consumedByParent));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        float composeVelocity;
        float composeVelocity2;
        Intrinsics.checkNotNullParameter(target, "target");
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        composeVelocity = AndroidViewHolder_androidKt.toComposeVelocity(velocityX);
        composeVelocity2 = AndroidViewHolder_androidKt.toComposeVelocity(velocityY);
        long viewVelocity = VelocityKt.Velocity(composeVelocity, composeVelocity2);
        BuildersKt__Builders_commonKt.launch$default(this.dispatcher.getCoroutineScope(), null, null, new AndroidViewHolder$onNestedFling$1(consumed, this, viewVelocity, null), 3, null);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        float composeVelocity;
        float composeVelocity2;
        Intrinsics.checkNotNullParameter(target, "target");
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        composeVelocity = AndroidViewHolder_androidKt.toComposeVelocity(velocityX);
        composeVelocity2 = AndroidViewHolder_androidKt.toComposeVelocity(velocityY);
        long toBeConsumed = VelocityKt.Velocity(composeVelocity, composeVelocity2);
        BuildersKt__Builders_commonKt.launch$default(this.dispatcher.getCoroutineScope(), null, null, new AndroidViewHolder$onNestedPreFling$1(this, toBeConsumed, null), 3, null);
        return false;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        View view = this.view;
        return view != null ? view.isNestedScrollingEnabled() : super.isNestedScrollingEnabled();
    }
}
