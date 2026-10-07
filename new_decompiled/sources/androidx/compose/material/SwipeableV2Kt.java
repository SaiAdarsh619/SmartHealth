package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableKt$draggable$1;
import androidx.compose.foundation.gestures.DraggableKt$draggable$2;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.layout.OnRemeasuredModifierKt;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwipeableV2.kt */
@Metadata(m286d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001aZ\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062#\b\u0002\u0010\b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tH\u0001¢\u0006\u0002\u0010\u000e\u001a-\u0010\u000f\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0012\u001a7\u0010\u000f\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0015\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u0010H\u0002¢\u0006\u0002\u0010\u0016\u001a%\u0010\u0017\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u0010H\u0002¢\u0006\u0002\u0010\u0016\u001a+\u0010\u0018\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u00102\u0006\u0010\u0019\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u0010\u001a\u001a¿\u0001\u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002*\u00020\u001c2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001e2R\b\u0002\u0010\u001f\u001aL\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(!\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#\u0018\u00010 28\u0010$\u001a4\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110%¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(&\u0012\u0006\u0012\u0004\u0018\u00010\u00070 H\u0001ø\u0001\u0000\u001aH\u0010'\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002*\u00020\u001c2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\r2\b\b\u0002\u0010+\u001a\u00020\r2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-H\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, m287d2 = {"rememberSwipeableV2State", "Landroidx/compose/material/SwipeableV2State;", "T", "", "initialState", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/SwipeableV2State;", "closestState", "", "offset", "(Ljava/util/Map;F)Ljava/lang/Object;", "searchUpwards", "(Ljava/util/Map;FZ)Ljava/lang/Object;", "maxOrNull", "(Ljava/util/Map;)Ljava/lang/Float;", "minOrNull", "requireAnchor", "state", "(Ljava/util/Map;Ljava/lang/Object;)F", "swipeAnchors", "Landroidx/compose/ui/Modifier;", "possibleStates", "", "anchorsChanged", "Lkotlin/Function2;", "oldAnchors", "newAnchors", "", "calculateAnchor", "Landroidx/compose/ui/unit/IntSize;", "layoutSize", "swipeableV2", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SwipeableV2Kt {
    @ExperimentalMaterialApi
    public static final <T> Modifier swipeableV2(Modifier $this$swipeableV2, SwipeableV2State<T> state, Orientation orientation, boolean enabled, boolean reverseDirection, MutableInteractionSource interactionSource) {
        Modifier draggable;
        Intrinsics.checkNotNullParameter($this$swipeableV2, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        draggable = DraggableKt.draggable($this$swipeableV2, state.getDraggableState(), orientation, (r20 & 4) != 0 ? true : enabled, (r20 & 8) != 0 ? null : interactionSource, (r20 & 16) != 0 ? false : state.isAnimationRunning(), (r20 & 32) != 0 ? new DraggableKt$draggable$1(null) : null, (r20 & 64) != 0 ? new DraggableKt$draggable$2(null) : new SwipeableV2Kt$swipeableV2$1(state, null), (r20 & 128) != 0 ? false : reverseDirection);
        return draggable;
    }

    public static /* synthetic */ Modifier swipeAnchors$default(Modifier modifier, SwipeableV2State swipeableV2State, Set set, Function2 function2, Function2 function22, int i, Object obj) {
        if ((i & 4) != 0) {
            function2 = null;
        }
        return swipeAnchors(modifier, swipeableV2State, set, function2, function22);
    }

    @ExperimentalMaterialApi
    public static final <T> Modifier swipeAnchors(Modifier $this$swipeAnchors, final SwipeableV2State<T> state, final Set<? extends T> possibleStates, final Function2<? super Map<T, Float>, ? super Map<T, Float>, Unit> function2, final Function2<? super T, ? super IntSize, Float> calculateAnchor) {
        Intrinsics.checkNotNullParameter($this$swipeAnchors, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(possibleStates, "possibleStates");
        Intrinsics.checkNotNullParameter(calculateAnchor, "calculateAnchor");
        return OnRemeasuredModifierKt.onSizeChanged($this$swipeAnchors, new Function1<IntSize, Unit>() { // from class: androidx.compose.material.SwipeableV2Kt$swipeAnchors$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                m1525invokeozmzZPI(intSize.getPackedValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-ozmzZPI, reason: not valid java name */
            public final void m1525invokeozmzZPI(long layoutSize) {
                Function2<Map<T, Float>, Map<T, Float>, Unit> function22;
                Map previousAnchors = state.getAnchors$material_release();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterable $this$forEach$iv = possibleStates;
                Function2<T, IntSize, Float> function23 = calculateAnchor;
                for (Object element$iv : $this$forEach$iv) {
                    Float anchorValue = function23.invoke(element$iv, IntSize.m4534boximpl(layoutSize));
                    if (anchorValue != null) {
                        linkedHashMap.put(element$iv, anchorValue);
                    }
                }
                if (Intrinsics.areEqual(previousAnchors, linkedHashMap)) {
                    return;
                }
                state.updateAnchors$material_release(linkedHashMap);
                if (previousAnchors.isEmpty() || (function22 = function2) == 0) {
                    return;
                }
                function22.invoke(previousAnchors, linkedHashMap);
            }
        });
    }

    @ExperimentalMaterialApi
    public static final <T> SwipeableV2State<T> rememberSwipeableV2State(final T initialState, final AnimationSpec<Float> animationSpec, final Function1<? super T, Boolean> function1, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        $composer.startReplaceableGroup(-1791789117);
        ComposerKt.sourceInformation($composer, "C(rememberSwipeableV2State)P(2)371@14229L348:SwipeableV2.kt#jmzs0o");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
            animationSpec = animationSpec2;
        }
        if ((i & 4) != 0) {
            Function1 confirmStateChange = new Function1<T, Boolean>() { // from class: androidx.compose.material.SwipeableV2Kt$rememberSwipeableV2State$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(T it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                    return invoke((SwipeableV2Kt$rememberSwipeableV2State$1<T>) obj);
                }
            };
            function1 = confirmStateChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1791789117, $changed, -1, "androidx.compose.material.rememberSwipeableV2State (SwipeableV2.kt:366)");
        }
        SwipeableV2State<T> swipeableV2State = (SwipeableV2State) RememberSaveableKt.m1652rememberSaveable(new Object[0], (Saver) SwipeableV2State.INSTANCE.Saver(animationSpec, function1), (String) null, (Function0) new Function0<SwipeableV2State<T>>() { // from class: androidx.compose.material.SwipeableV2Kt$rememberSwipeableV2State$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SwipeableV2State<T> invoke() {
                return new SwipeableV2State<>(initialState, animationSpec, function1);
            }
        }, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return swipeableV2State;
    }

    static /* synthetic */ Object closestState$default(Map map, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        return closestState(map, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T closestState(Map<T, Float> map, float f) {
        if (map.isEmpty()) {
            throw new IllegalArgumentException("The anchors were empty when trying to find the closest state".toString());
        }
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        if (it.hasNext()) {
            float abs = Math.abs(((Number) ((Map.Entry) next).getValue()).floatValue() - f);
            do {
                T next2 = it.next();
                float abs2 = Math.abs(((Number) ((Map.Entry) next2).getValue()).floatValue() - f);
                if (Float.compare(abs, abs2) > 0) {
                    next = next2;
                    abs = abs2;
                }
            } while (it.hasNext());
        }
        return (T) ((Map.Entry) next).getKey();
    }

    static /* synthetic */ Object closestState$default(Map map, float f, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return closestState(map, f, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T closestState(Map<T, Float> map, float f, boolean z) {
        if (map.isEmpty()) {
            throw new IllegalArgumentException("The anchors were empty when trying to find the closest state".toString());
        }
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        if (it.hasNext()) {
            float floatValue = ((Number) ((Map.Entry) next).getValue()).floatValue();
            float f2 = z ? floatValue - f : f - floatValue;
            if (f2 < 0.0f) {
                f2 = Float.POSITIVE_INFINITY;
            }
            do {
                T next2 = it.next();
                float floatValue2 = ((Number) ((Map.Entry) next2).getValue()).floatValue();
                float f3 = z ? floatValue2 - f : f - floatValue2;
                if (f3 < 0.0f) {
                    f3 = Float.POSITIVE_INFINITY;
                }
                if (Float.compare(f2, f3) > 0) {
                    next = next2;
                    f2 = f3;
                }
            } while (it.hasNext());
        }
        return (T) ((Map.Entry) next).getKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Float minOrNull(Map<T, Float> map) {
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Float maxOrNull(Map<T, Float> map) {
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> float requireAnchor(Map<T, Float> map, T t) {
        Float f = map.get(t);
        if (f != null) {
            return f.floatValue();
        }
        throw new IllegalArgumentException(("Required anchor " + t + " was not found in anchors. Current anchors: " + MapsKt.toMap(map)).toString());
    }
}
