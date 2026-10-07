package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerEventType;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerType;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p000ui.modifier.ModifierLocalKt;
import androidx.compose.p000ui.modifier.ProvidableModifierLocal;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Scrollable.kt */
@Metadata(m286d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u0002H\u0002\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\"\u0010\u0011\u001a\u00020\u0012*\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001aO\u0010\u0016\u001a\u00020\u0012*\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\f\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010\"\u001aR\u0010#\u001a\u00020\u0012*\u00020\u00122\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007\u001aF\u0010#\u001a\u00020\u0012*\u00020\u00122\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, m287d2 = {"ModifierLocalScrollableContainer", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "", "getModifierLocalScrollableContainer", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "NoOpScrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "scrollableNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "scrollLogic", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "enabled", "awaitScrollEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseWheelScroll", "Landroidx/compose/ui/Modifier;", "scrollingLogicState", "mouseWheelScrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "pointerScrollable", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "controller", "Landroidx/compose/foundation/gestures/ScrollableState;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/OverscrollEffect;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "scrollable", "state", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ScrollableKt {
    private static final ScrollScope NoOpScrollScope = new ScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollableKt$NoOpScrollScope$1
        @Override // androidx.compose.foundation.gestures.ScrollScope
        public float scrollBy(float pixels) {
            return pixels;
        }
    };
    private static final ProvidableModifierLocal<Boolean> ModifierLocalScrollableContainer = ModifierLocalKt.modifierLocalOf(new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.ScrollableKt$ModifierLocalScrollableContainer$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return false;
        }
    });

    public static final Modifier scrollable(Modifier $this$scrollable, ScrollableState state, Orientation orientation, boolean enabled, boolean reverseDirection, FlingBehavior flingBehavior, MutableInteractionSource interactionSource) {
        Intrinsics.checkNotNullParameter($this$scrollable, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return scrollable($this$scrollable, state, orientation, null, enabled, reverseDirection, flingBehavior, interactionSource);
    }

    @ExperimentalFoundationApi
    public static final Modifier scrollable(Modifier $this$scrollable, final ScrollableState state, final Orientation orientation, final OverscrollEffect overscrollEffect, final boolean enabled, final boolean reverseDirection, final FlingBehavior flingBehavior, final MutableInteractionSource interactionSource) {
        Intrinsics.checkNotNullParameter($this$scrollable, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return ComposedModifierKt.composed($this$scrollable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.gestures.ScrollableKt$scrollable$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("scrollable");
                $this$null.getProperties().set("orientation", Orientation.this);
                $this$null.getProperties().set("state", state);
                $this$null.getProperties().set("overscrollEffect", overscrollEffect);
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
                $this$null.getProperties().set("reverseDirection", Boolean.valueOf(reverseDirection));
                $this$null.getProperties().set("flingBehavior", flingBehavior);
                $this$null.getProperties().set("interactionSource", interactionSource);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.gestures.ScrollableKt$scrollable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x010b  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x011c  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x010e  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Object value$iv$iv$iv;
                Object value$iv$iv;
                Modifier pointerScrollable;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(-629830927);
                ComposerKt.sourceInformation($composer, "C154@7368L24,156@7450L170,163@7737L242:Scrollable.kt#8bwon0");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-629830927, $changed, -1, "androidx.compose.foundation.gestures.scrollable.<anonymous> (Scrollable.kt:153)");
                }
                $composer.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation($composer, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv$iv = $composer.rememberedValue();
                if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
                    $composer.updateRememberedValue(value$iv$iv$iv);
                } else {
                    value$iv$iv$iv = it$iv$iv$iv;
                }
                $composer.endReplaceableGroup();
                CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                CoroutineScope coroutineScope = wrapper$iv.getCoroutineScope();
                $composer.endReplaceableGroup();
                Object[] keys$iv = {coroutineScope, Orientation.this, state, Boolean.valueOf(reverseDirection)};
                Orientation orientation2 = Orientation.this;
                ScrollableState scrollableState = state;
                boolean z = reverseDirection;
                $composer.startReplaceableGroup(-568225417);
                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv = false;
                for (Object key$iv : keys$iv) {
                    invalid$iv |= $composer.changed(key$iv);
                }
                Object it$iv$iv = $composer.rememberedValue();
                if (!invalid$iv && it$iv$iv != Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = it$iv$iv;
                    $composer.endReplaceableGroup();
                    ContentInViewModifier keepFocusedChildInViewModifier = (ContentInViewModifier) value$iv$iv;
                    pointerScrollable = ScrollableKt.pointerScrollable(FocusableKt.focusGroup(Modifier.INSTANCE).then(keepFocusedChildInViewModifier.getModifier()), interactionSource, Orientation.this, reverseDirection, state, flingBehavior, overscrollEffect, enabled, $composer, 0);
                    Modifier then = pointerScrollable.then(!enabled ? ModifierLocalScrollableContainerProvider.INSTANCE : Modifier.INSTANCE);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer.endReplaceableGroup();
                    return then;
                }
                value$iv$iv = new ContentInViewModifier(coroutineScope, orientation2, scrollableState, z);
                $composer.updateRememberedValue(value$iv$iv);
                $composer.endReplaceableGroup();
                ContentInViewModifier keepFocusedChildInViewModifier2 = (ContentInViewModifier) value$iv$iv;
                pointerScrollable = ScrollableKt.pointerScrollable(FocusableKt.focusGroup(Modifier.INSTANCE).then(keepFocusedChildInViewModifier2.getModifier()), interactionSource, Orientation.this, reverseDirection, state, flingBehavior, overscrollEffect, enabled, $composer, 0);
                Modifier then2 = pointerScrollable.then(!enabled ? ModifierLocalScrollableContainerProvider.INSTANCE : Modifier.INSTANCE);
                if (ComposerKt.isTraceInProgress()) {
                }
                $composer.endReplaceableGroup();
                return then2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier pointerScrollable(Modifier $this$pointerScrollable, MutableInteractionSource interactionSource, Orientation orientation, boolean reverseDirection, ScrollableState controller, FlingBehavior flingBehavior, OverscrollEffect overscrollEffect, boolean enabled, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Object value$iv$iv4;
        ScrollableKt$pointerScrollable$3$1 value$iv$iv5;
        Modifier draggable;
        $composer.startReplaceableGroup(-2012025036);
        ComposerKt.sourceInformation($composer, "C(pointerScrollable)P(3,4,6!1,2,5)249@10545L53,250@10621L224,260@10879L88,263@10993L46,264@11063L22,272@11307L47,273@11380L160:Scrollable.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2012025036, $changed, -1, "androidx.compose.foundation.gestures.pointerScrollable (Scrollable.kt:239)");
        }
        $composer.startReplaceableGroup(-1730186366);
        ComposerKt.sourceInformation($composer, "248@10496L15");
        FlingBehavior fling = flingBehavior == null ? ScrollableDefaults.INSTANCE.flingBehavior($composer, 6) : flingBehavior;
        $composer.endReplaceableGroup();
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new NestedScrollDispatcher(), null, 2, null);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        MutableState nestedScrollDispatcher = (MutableState) value$iv$iv;
        final State scrollLogic = SnapshotStateKt.rememberUpdatedState(new ScrollingLogic(orientation, reverseDirection, nestedScrollDispatcher, controller, fling, overscrollEffect), $composer, 0);
        Object key1$iv = Boolean.valueOf(enabled);
        int i = ($changed >> 21) & 14;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(key1$iv);
        Object it$iv$iv2 = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv2 = scrollableNestedScrollConnection(scrollLogic, enabled);
            $composer.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        Object key1$iv2 = value$iv$iv2;
        NestedScrollConnection nestedScrollConnection = (NestedScrollConnection) key1$iv2;
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv3 = $composer.rememberedValue();
        if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv3 = new ScrollDraggableState(scrollLogic);
            $composer.updateRememberedValue(value$iv$iv3);
        } else {
            value$iv$iv3 = it$iv$iv3;
        }
        $composer.endReplaceableGroup();
        ScrollDraggableState draggableState = (ScrollDraggableState) value$iv$iv3;
        ScrollConfig scrollConfig = AndroidScrollable_androidKt.platformScrollConfig($composer, 0);
        ScrollDraggableState scrollDraggableState = draggableState;
        ScrollableKt$pointerScrollable$1 scrollableKt$pointerScrollable$1 = new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PointerInputChange down) {
                Intrinsics.checkNotNullParameter(down, "down");
                return Boolean.valueOf(!PointerType.m3435equalsimpl0(down.getType(), PointerType.INSTANCE.m3440getMouseT8wyACA()));
            }
        };
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = $composer.changed(scrollLogic);
        Object it$iv$iv4 = $composer.rememberedValue();
        if (invalid$iv$iv2 || it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv4 = (Function0) new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(scrollLogic.getValue().shouldScrollImmediately());
                }
            };
            $composer.updateRememberedValue(value$iv$iv4);
        } else {
            value$iv$iv4 = it$iv$iv4;
        }
        $composer.endReplaceableGroup();
        Function0 function0 = (Function0) value$iv$iv4;
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv3 = $composer.changed(nestedScrollDispatcher) | $composer.changed(scrollLogic);
        Object it$iv$iv5 = $composer.rememberedValue();
        if (invalid$iv$iv3 || it$iv$iv5 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv5 = new ScrollableKt$pointerScrollable$3$1(nestedScrollDispatcher, scrollLogic, null);
            $composer.updateRememberedValue(value$iv$iv5);
        } else {
            value$iv$iv5 = it$iv$iv5;
        }
        $composer.endReplaceableGroup();
        draggable = DraggableKt.draggable($this$pointerScrollable, scrollDraggableState, scrollableKt$pointerScrollable$1, orientation, (r22 & 8) != 0 ? true : enabled, (r22 & 16) != 0 ? null : interactionSource, function0, (r22 & 64) != 0 ? new DraggableKt$draggable$6(null) : null, (r22 & 128) != 0 ? new DraggableKt$draggable$7(null) : (Function3) value$iv$iv5, (r22 & 256) != 0 ? false : false);
        Modifier nestedScroll = NestedScrollModifierKt.nestedScroll(mouseWheelScroll(draggable, scrollLogic, scrollConfig), nestedScrollConnection, (NestedScrollDispatcher) nestedScrollDispatcher.getValue());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return nestedScroll;
    }

    private static final Modifier mouseWheelScroll(Modifier $this$mouseWheelScroll, State<ScrollingLogic> state, ScrollConfig mouseWheelScrollConfig) {
        return SuspendingPointerInputFilterKt.pointerInput($this$mouseWheelScroll, state, mouseWheelScrollConfig, new ScrollableKt$mouseWheelScroll$1(mouseWheelScrollConfig, state, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0048 -> B:12:0x004c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitScrollEvent(AwaitPointerEventScope $this$awaitScrollEvent, Continuation<? super PointerEvent> continuation) {
        ScrollableKt$awaitScrollEvent$1 scrollableKt$awaitScrollEvent$1;
        ScrollableKt$awaitScrollEvent$1 scrollableKt$awaitScrollEvent$12;
        Object $result;
        Object obj;
        PointerEvent event;
        if (continuation instanceof ScrollableKt$awaitScrollEvent$1) {
            scrollableKt$awaitScrollEvent$1 = (ScrollableKt$awaitScrollEvent$1) continuation;
            if ((scrollableKt$awaitScrollEvent$1.label & Integer.MIN_VALUE) != 0) {
                scrollableKt$awaitScrollEvent$1.label -= Integer.MIN_VALUE;
                scrollableKt$awaitScrollEvent$12 = scrollableKt$awaitScrollEvent$1;
                Object $result2 = scrollableKt$awaitScrollEvent$12.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (scrollableKt$awaitScrollEvent$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        scrollableKt$awaitScrollEvent$12.L$0 = $this$awaitScrollEvent;
                        scrollableKt$awaitScrollEvent$12.label = 1;
                        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitScrollEvent, null, scrollableKt$awaitScrollEvent$12, 1, null);
                        if (awaitPointerEvent$default != $result3) {
                            return $result3;
                        }
                        Object obj2 = $result3;
                        $result = $result2;
                        $result2 = awaitPointerEvent$default;
                        obj = obj2;
                        event = (PointerEvent) $result2;
                        if (!PointerEventType.m3316equalsimpl0(event.getType(), PointerEventType.INSTANCE.m3325getScroll7fucELk())) {
                            return event;
                        }
                        $result2 = $result;
                        $result3 = obj;
                        scrollableKt$awaitScrollEvent$12.L$0 = $this$awaitScrollEvent;
                        scrollableKt$awaitScrollEvent$12.label = 1;
                        Object awaitPointerEvent$default2 = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitScrollEvent, null, scrollableKt$awaitScrollEvent$12, 1, null);
                        if (awaitPointerEvent$default2 != $result3) {
                        }
                    case 1:
                        $this$awaitScrollEvent = (AwaitPointerEventScope) scrollableKt$awaitScrollEvent$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        obj = $result3;
                        $result = $result2;
                        event = (PointerEvent) $result2;
                        if (!PointerEventType.m3316equalsimpl0(event.getType(), PointerEventType.INSTANCE.m3325getScroll7fucELk())) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        scrollableKt$awaitScrollEvent$1 = new ScrollableKt$awaitScrollEvent$1(continuation);
        scrollableKt$awaitScrollEvent$12 = scrollableKt$awaitScrollEvent$1;
        Object $result22 = scrollableKt$awaitScrollEvent$12.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (scrollableKt$awaitScrollEvent$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollConnection scrollableNestedScrollConnection(State<ScrollingLogic> state, boolean enabled) {
        return new ScrollableKt$scrollableNestedScrollConnection$1(state, enabled);
    }

    public static final ProvidableModifierLocal<Boolean> getModifierLocalScrollableContainer() {
        return ModifierLocalScrollableContainer;
    }
}
