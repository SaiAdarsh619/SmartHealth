package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.core.app.NotificationCompat;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: SwipeableV2.kt */
@Metadata(m286d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0001\u0018\u0000 f*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001fBB\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\b\u0002\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0002\u0010\rJ#\u0010S\u001a\u00020T2\u0006\u0010I\u001a\u00028\u00002\b\b\u0002\u0010U\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010VJe\u0010W\u001a\u00028\u00002\u0006\u00109\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00028\u000026\u0010X\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(>\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u00060=2\u0006\u0010U\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010YJ\u000e\u0010Z\u001a\u00020\u00062\u0006\u0010[\u001a\u00020\u0006J\u0013\u0010\\\u001a\u00020\f2\u0006\u0010]\u001a\u00028\u0000¢\u0006\u0002\u0010^J\u0019\u0010_\u001a\u00020T2\u0006\u0010U\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010`J\u0019\u0010a\u001a\u00020T2\u0006\u0010I\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010bJ!\u0010c\u001a\u00020T2\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u000fH\u0000¢\u0006\u0002\beRC\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u000f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u000f8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R,\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR+\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0016\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R+\u0010'\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0016\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R+\u0010,\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0016\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00102\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b3\u0010.R\u001b\u00106\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00105\u001a\u0004\b7\u0010.R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u008b\u0001\u0010@\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(>\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u00060=26\u0010\u000e\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(>\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u00060=8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010\u0016\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001b\u0010F\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u00105\u001a\u0004\bG\u0010.R\u001b\u0010I\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u00105\u001a\u0004\bJ\u0010\u001dR\u001b\u0010L\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u00105\u001a\u0004\bM\u0010.R+\u0010O\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bR\u0010\u0016\u001a\u0004\bP\u0010.\"\u0004\bQ\u00100\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006g"}, m287d2 = {"Landroidx/compose/material/SwipeableV2State;", "T", "", "initialState", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "<set-?>", "", "anchors", "getAnchors$material_release", "()Ljava/util/Map;", "setAnchors$material_release", "(Ljava/util/Map;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getConfirmStateChange", "()Lkotlin/jvm/functions/Function1;", "currentState", "getCurrentState", "()Ljava/lang/Object;", "setCurrentState", "(Ljava/lang/Object;)V", "currentState$delegate", "dragPosition", "Landroidx/compose/runtime/MutableState;", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$material_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "isAnimationRunning", "()Z", "setAnimationRunning", "(Z)V", "isAnimationRunning$delegate", "lastVelocity", "getLastVelocity", "()F", "setLastVelocity", "(F)V", "lastVelocity$delegate", "maxBound", "getMaxBound", "maxBound$delegate", "Landroidx/compose/runtime/State;", "minBound", "getMinBound", "minBound$delegate", "offset", "Landroidx/compose/runtime/State;", "getOffset", "()Landroidx/compose/runtime/State;", "Lkotlin/Function2;", "lower", "upper", "positionalThresholds", "getPositionalThresholds", "()Lkotlin/jvm/functions/Function2;", "setPositionalThresholds", "(Lkotlin/jvm/functions/Function2;)V", "positionalThresholds$delegate", NotificationCompat.CATEGORY_PROGRESS, "getProgress", "progress$delegate", "targetState", "getTargetState", "targetState$delegate", "unsafeOffset", "getUnsafeOffset", "unsafeOffset$delegate", "velocityThreshold", "getVelocityThreshold", "setVelocityThreshold", "velocityThreshold$delegate", "animateTo", "", "velocity", "(Ljava/lang/Object;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "thresholds", "(FLjava/lang/Object;Lkotlin/jvm/functions/Function2;FF)Ljava/lang/Object;", "dispatchRawDelta", "delta", "hasAnchorForState", "state", "(Ljava/lang/Object;)Z", "settle", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAnchors", "newAnchors", "updateAnchors$material_release", "Companion", "material_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
@ExperimentalMaterialApi
/* loaded from: classes.dex */
public final class SwipeableV2State<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: anchors$delegate, reason: from kotlin metadata */
    private final MutableState anchors;
    private final AnimationSpec<Float> animationSpec;
    private final Function1<T, Boolean> confirmStateChange;

    /* renamed from: currentState$delegate, reason: from kotlin metadata */
    private final MutableState currentState;
    private final MutableState<Float> dragPosition;
    private final DraggableState draggableState;

    /* renamed from: isAnimationRunning$delegate, reason: from kotlin metadata */
    private final MutableState isAnimationRunning;

    /* renamed from: lastVelocity$delegate, reason: from kotlin metadata */
    private final MutableState lastVelocity;

    /* renamed from: maxBound$delegate, reason: from kotlin metadata */
    private final State maxBound;

    /* renamed from: minBound$delegate, reason: from kotlin metadata */
    private final State minBound;
    private final State<Float> offset;

    /* renamed from: positionalThresholds$delegate, reason: from kotlin metadata */
    private final MutableState positionalThresholds;

    /* renamed from: progress$delegate, reason: from kotlin metadata */
    private final State progress;

    /* renamed from: targetState$delegate, reason: from kotlin metadata */
    private final State targetState;

    /* renamed from: unsafeOffset$delegate, reason: from kotlin metadata */
    private final State unsafeOffset;

    /* renamed from: velocityThreshold$delegate, reason: from kotlin metadata */
    private final MutableState velocityThreshold;

    /* JADX WARN: Multi-variable type inference failed */
    public SwipeableV2State(T t, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmStateChange) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        this.animationSpec = animationSpec;
        this.confirmStateChange = confirmStateChange;
        this.currentState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.targetState = SnapshotStateKt.derivedStateOf(new Function0<T>(this) { // from class: androidx.compose.material.SwipeableV2State$targetState$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                float unsafeOffset;
                float unsafeOffset2;
                Object closestState;
                unsafeOffset = this.this$0.getUnsafeOffset();
                if (Float.isNaN(unsafeOffset)) {
                    return this.this$0.getCurrentState();
                }
                Map<T, Float> anchors$material_release = this.this$0.getAnchors$material_release();
                unsafeOffset2 = this.this$0.getUnsafeOffset();
                closestState = SwipeableV2Kt.closestState(anchors$material_release, unsafeOffset2);
                return (T) closestState;
            }
        });
        this.offset = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.SwipeableV2State$offset$1
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                float unsafeOffset;
                float unsafeOffset2;
                unsafeOffset = this.this$0.getUnsafeOffset();
                if (!Float.isNaN(unsafeOffset)) {
                    unsafeOffset2 = this.this$0.getUnsafeOffset();
                    return Float.valueOf(unsafeOffset2);
                }
                throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
            }
        });
        this.isAnimationRunning = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.progress = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.SwipeableV2State$progress$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Float f = (Float) this.this$0.getAnchors$material_release().get(this.this$0.getCurrentState());
                float f2 = 0.0f;
                float a = f != null ? f.floatValue() : 0.0f;
                Float f3 = (Float) this.this$0.getAnchors$material_release().get(this.this$0.getTargetState());
                float b = f3 != null ? f3.floatValue() : 0.0f;
                float distance = Math.abs(b - a);
                if (distance > 1.0E-6f) {
                    float progress = (this.this$0.getOffset().getValue().floatValue() - a) / (b - a);
                    if (progress >= 1.0E-6f) {
                        f2 = progress > 0.999999f ? 1.0f : progress;
                    }
                } else {
                    f2 = 1.0f;
                }
                return Float.valueOf(f2);
            }
        });
        Float valueOf = Float.valueOf(0.0f);
        this.lastVelocity = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, null, 2, null);
        this.dragPosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(Float.NaN), null, 2, null);
        this.unsafeOffset = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.SwipeableV2State$unsafeOffset$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                MutableState mutableState;
                float minBound;
                float maxBound;
                mutableState = ((SwipeableV2State) this.this$0).dragPosition;
                float floatValue = ((Number) mutableState.getValue()).floatValue();
                minBound = this.this$0.getMinBound();
                maxBound = this.this$0.getMaxBound();
                return Float.valueOf(RangesKt.coerceIn(floatValue, minBound, maxBound));
            }
        });
        this.minBound = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.SwipeableV2State$minBound$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Float minOrNull;
                minOrNull = SwipeableV2Kt.minOrNull(this.this$0.getAnchors$material_release());
                return Float.valueOf(minOrNull != null ? minOrNull.floatValue() : Float.NEGATIVE_INFINITY);
            }
        });
        this.maxBound = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.SwipeableV2State$maxBound$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Float maxOrNull;
                maxOrNull = SwipeableV2Kt.maxOrNull(this.this$0.getAnchors$material_release());
                return Float.valueOf(maxOrNull != null ? maxOrNull.floatValue() : Float.POSITIVE_INFINITY);
            }
        });
        this.positionalThresholds = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Function2<T, T, Float>() { // from class: androidx.compose.material.SwipeableV2State$positionalThresholds$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function2
            public final Float invoke(T t2, T t3) {
                return Float.valueOf(0.0f);
            }
        }, null, 2, null);
        this.velocityThreshold = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, null, 2, null);
        this.draggableState = DraggableKt.DraggableState(new Function1<Float, Unit>(this) { // from class: androidx.compose.material.SwipeableV2State$draggableState$1
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                invoke(f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float it) {
                MutableState mutableState;
                MutableState mutableState2;
                mutableState = ((SwipeableV2State) this.this$0).dragPosition;
                mutableState2 = ((SwipeableV2State) this.this$0).dragPosition;
                mutableState.setValue(Float.valueOf(((Number) mutableState2.getValue()).floatValue() + it));
            }
        });
        this.anchors = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), null, 2, null);
    }

    public /* synthetic */ SwipeableV2State(Object obj, SpringSpec<Float> springSpec, C03671 c03671, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : springSpec, (i & 4) != 0 ? new Function1<T, Boolean>() { // from class: androidx.compose.material.SwipeableV2State.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(T t) {
                return true;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object p1) {
                return invoke((C03671) p1);
            }
        } : c03671);
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public final Function1<T, Boolean> getConfirmStateChange() {
        return this.confirmStateChange;
    }

    private final void setCurrentState(T t) {
        MutableState $this$setValue$iv = this.currentState;
        $this$setValue$iv.setValue(t);
    }

    public final T getCurrentState() {
        State $this$getValue$iv = this.currentState;
        return $this$getValue$iv.getValue();
    }

    public final T getTargetState() {
        return (T) this.targetState.getValue();
    }

    public final State<Float> getOffset() {
        return this.offset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationRunning(boolean z) {
        MutableState $this$setValue$iv = this.isAnimationRunning;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    public final boolean isAnimationRunning() {
        State $this$getValue$iv = this.isAnimationRunning;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final float getProgress() {
        State $this$getValue$iv = this.progress;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLastVelocity(float f) {
        MutableState $this$setValue$iv = this.lastVelocity;
        $this$setValue$iv.setValue(Float.valueOf(f));
    }

    public final float getLastVelocity() {
        State $this$getValue$iv = this.lastVelocity;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getUnsafeOffset() {
        State $this$getValue$iv = this.unsafeOffset;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getMinBound() {
        State $this$getValue$iv = this.minBound;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getMaxBound() {
        State $this$getValue$iv = this.maxBound;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    private final Function2<T, T, Float> getPositionalThresholds() {
        State $this$getValue$iv = this.positionalThresholds;
        return (Function2) $this$getValue$iv.getValue();
    }

    private final void setPositionalThresholds(Function2<? super T, ? super T, Float> function2) {
        MutableState $this$setValue$iv = this.positionalThresholds;
        $this$setValue$iv.setValue(function2);
    }

    private final float getVelocityThreshold() {
        State $this$getValue$iv = this.velocityThreshold;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    private final void setVelocityThreshold(float f) {
        MutableState $this$setValue$iv = this.velocityThreshold;
        $this$setValue$iv.setValue(Float.valueOf(f));
    }

    /* renamed from: getDraggableState$material_release, reason: from getter */
    public final DraggableState getDraggableState() {
        return this.draggableState;
    }

    public final Map<T, Float> getAnchors$material_release() {
        State $this$getValue$iv = this.anchors;
        return (Map) $this$getValue$iv.getValue();
    }

    public final void setAnchors$material_release(Map<T, Float> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        MutableState $this$setValue$iv = this.anchors;
        $this$setValue$iv.setValue(map);
    }

    public final void updateAnchors$material_release(Map<T, Float> newAnchors) {
        float requireAnchor;
        Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
        boolean previousAnchorsEmpty = getAnchors$material_release().isEmpty();
        setAnchors$material_release(newAnchors);
        if (previousAnchorsEmpty) {
            MutableState<Float> mutableState = this.dragPosition;
            requireAnchor = SwipeableV2Kt.requireAnchor(getAnchors$material_release(), getCurrentState());
            mutableState.setValue(Float.valueOf(requireAnchor));
        }
    }

    public final boolean hasAnchorForState(T state) {
        return getAnchors$material_release().containsKey(state);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object snapTo(T t, Continuation<? super Unit> continuation) {
        SwipeableV2State$snapTo$1 swipeableV2State$snapTo$1;
        SwipeableV2State$snapTo$1 swipeableV2State$snapTo$12;
        float requireAnchor;
        SwipeableV2State<T> swipeableV2State;
        if (continuation instanceof SwipeableV2State$snapTo$1) {
            swipeableV2State$snapTo$1 = (SwipeableV2State$snapTo$1) continuation;
            if ((swipeableV2State$snapTo$1.label & Integer.MIN_VALUE) != 0) {
                swipeableV2State$snapTo$1.label -= Integer.MIN_VALUE;
                swipeableV2State$snapTo$12 = swipeableV2State$snapTo$1;
                Object obj = swipeableV2State$snapTo$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (swipeableV2State$snapTo$12.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        requireAnchor = SwipeableV2Kt.requireAnchor(getAnchors$material_release(), t);
                        DraggableState draggableState = this.draggableState;
                        SwipeableV2State$snapTo$2 swipeableV2State$snapTo$2 = new SwipeableV2State$snapTo$2(requireAnchor, this, null);
                        swipeableV2State$snapTo$12.L$0 = this;
                        swipeableV2State$snapTo$12.L$1 = t;
                        swipeableV2State$snapTo$12.label = 1;
                        if (DraggableState.drag$default(draggableState, null, swipeableV2State$snapTo$2, swipeableV2State$snapTo$12, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        swipeableV2State = this;
                        break;
                    case 1:
                        t = (T) swipeableV2State$snapTo$12.L$1;
                        swipeableV2State = (SwipeableV2State) swipeableV2State$snapTo$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                swipeableV2State.setCurrentState(t);
                return Unit.INSTANCE;
            }
        }
        swipeableV2State$snapTo$1 = new SwipeableV2State$snapTo$1(this, continuation);
        swipeableV2State$snapTo$12 = swipeableV2State$snapTo$1;
        Object obj2 = swipeableV2State$snapTo$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (swipeableV2State$snapTo$12.label) {
        }
        swipeableV2State.setCurrentState(t);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(SwipeableV2State swipeableV2State, Object obj, float f, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = swipeableV2State.getLastVelocity();
        }
        return swipeableV2State.animateTo(obj, f, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object animateTo(T t, float f, Continuation<? super Unit> continuation) {
        SwipeableV2State$animateTo$1 swipeableV2State$animateTo$1;
        float requireAnchor;
        SwipeableV2State swipeableV2State;
        Iterator<T> it;
        T t2;
        Object key;
        Iterator<T> it2;
        T t3;
        Object key2;
        if (continuation instanceof SwipeableV2State$animateTo$1) {
            swipeableV2State$animateTo$1 = (SwipeableV2State$animateTo$1) continuation;
            if ((swipeableV2State$animateTo$1.label & Integer.MIN_VALUE) != 0) {
                swipeableV2State$animateTo$1.label -= Integer.MIN_VALUE;
                Object obj = swipeableV2State$animateTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (swipeableV2State$animateTo$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        requireAnchor = SwipeableV2Kt.requireAnchor(getAnchors$material_release(), t);
                        try {
                            DraggableState draggableState = this.draggableState;
                            SwipeableV2State$animateTo$2 swipeableV2State$animateTo$2 = new SwipeableV2State$animateTo$2(this, requireAnchor, f, null);
                            swipeableV2State$animateTo$1.L$0 = this;
                            swipeableV2State$animateTo$1.label = 1;
                            if (DraggableState.drag$default(draggableState, null, swipeableV2State$animateTo$2, swipeableV2State$animateTo$1, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            swipeableV2State = this;
                            swipeableV2State.setLastVelocity(0.0f);
                            float floatValue = swipeableV2State.dragPosition.getValue().floatValue();
                            it2 = swipeableV2State.getAnchors$material_release().entrySet().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    t3 = null;
                                } else {
                                    t3 = it2.next();
                                    if (Math.abs(((Number) ((Map.Entry) t3).getValue()).floatValue() - floatValue) < 0.5f) {
                                    }
                                }
                            }
                            Map.Entry entry = (Map.Entry) t3;
                            key2 = entry != null ? entry.getKey() : null;
                            if (key2 == null) {
                                key2 = swipeableV2State.getCurrentState();
                            }
                            swipeableV2State.setCurrentState(key2);
                            return Unit.INSTANCE;
                        } catch (Throwable th) {
                            th = th;
                            swipeableV2State = this;
                            float floatValue2 = swipeableV2State.dragPosition.getValue().floatValue();
                            it = swipeableV2State.getAnchors$material_release().entrySet().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                }
                            }
                            Map.Entry entry2 = (Map.Entry) t2;
                            key = entry2 != null ? entry2.getKey() : null;
                            if (key == null) {
                            }
                            swipeableV2State.setCurrentState(key);
                            throw th;
                        }
                    case 1:
                        swipeableV2State = (SwipeableV2State) swipeableV2State$animateTo$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            swipeableV2State = swipeableV2State;
                            swipeableV2State.setLastVelocity(0.0f);
                            float floatValue3 = swipeableV2State.dragPosition.getValue().floatValue();
                            it2 = swipeableV2State.getAnchors$material_release().entrySet().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                }
                            }
                            Map.Entry entry3 = (Map.Entry) t3;
                            key2 = entry3 != null ? entry3.getKey() : null;
                            if (key2 == null) {
                            }
                            swipeableV2State.setCurrentState(key2);
                            return Unit.INSTANCE;
                        } catch (Throwable th2) {
                            th = th2;
                            float floatValue22 = swipeableV2State.dragPosition.getValue().floatValue();
                            it = swipeableV2State.getAnchors$material_release().entrySet().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    t2 = null;
                                } else {
                                    t2 = it.next();
                                    if (Math.abs(((Number) ((Map.Entry) t2).getValue()).floatValue() - floatValue22) < 0.5f) {
                                    }
                                }
                            }
                            Map.Entry entry22 = (Map.Entry) t2;
                            key = entry22 != null ? entry22.getKey() : null;
                            if (key == null) {
                                key = swipeableV2State.getCurrentState();
                            }
                            swipeableV2State.setCurrentState(key);
                            throw th;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        swipeableV2State$animateTo$1 = new SwipeableV2State$animateTo$1(this, continuation);
        Object obj2 = swipeableV2State$animateTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (swipeableV2State$animateTo$1.label) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object settle(float f, Continuation<? super Unit> continuation) {
        Object currentState = getCurrentState();
        Object computeTarget = computeTarget(this.offset.getValue().floatValue(), currentState, getPositionalThresholds(), f, getVelocityThreshold());
        if (((Boolean) this.confirmStateChange.invoke(computeTarget)).booleanValue()) {
            Object animateTo = animateTo(computeTarget, f, continuation);
            return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
        }
        Object animateTo2 = animateTo(currentState, f, continuation);
        return animateTo2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo2 : Unit.INSTANCE;
    }

    public final float dispatchRawDelta(float delta) {
        float potentiallyConsumed = this.dragPosition.getValue().floatValue() + delta;
        float clamped = RangesKt.coerceIn(potentiallyConsumed, getMinBound(), getMaxBound());
        float deltaToConsume = clamped - this.dragPosition.getValue().floatValue();
        if (Math.abs(deltaToConsume) > 0.0f) {
            this.draggableState.dispatchRawDelta(deltaToConsume);
        }
        return deltaToConsume;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v8, types: [T, java.lang.Object] */
    private final T computeTarget(float offset, T currentState, Function2<? super T, ? super T, Float> thresholds, float velocity, float velocityThreshold) {
        float requireAnchor;
        Object closestState;
        Object closestState2;
        Object closestState3;
        Object closestState4;
        Map<T, Float> anchors$material_release = getAnchors$material_release();
        requireAnchor = SwipeableV2Kt.requireAnchor(anchors$material_release, currentState);
        if (requireAnchor <= offset) {
            if (velocity >= velocityThreshold) {
                closestState4 = SwipeableV2Kt.closestState(anchors$material_release, offset, true);
                return (T) closestState4;
            }
            closestState3 = SwipeableV2Kt.closestState(anchors$material_release, offset, true);
            ?? r1 = (Object) closestState3;
            if (offset >= thresholds.invoke(currentState, r1).floatValue()) {
                return r1;
            }
        } else {
            if (velocity <= (-velocityThreshold)) {
                closestState2 = SwipeableV2Kt.closestState(anchors$material_release, offset, false);
                return (T) closestState2;
            }
            closestState = SwipeableV2Kt.closestState(anchors$material_release, offset, false);
            ?? r12 = (Object) closestState;
            if (offset <= thresholds.invoke(currentState, r12).floatValue()) {
                return r12;
            }
        }
        return currentState;
    }

    /* compiled from: SwipeableV2.kt */
    @Metadata(m286d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"}, m287d2 = {"Landroidx/compose/material/SwipeableV2State$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/SwipeableV2State;", "T", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "", "material_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> Saver<SwipeableV2State<T>, T> Saver(final AnimationSpec<Float> animationSpec, final Function1<? super T, Boolean> confirmStateChange) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
            return SaverKt.Saver(new Function2<SaverScope, SwipeableV2State<T>, T>() { // from class: androidx.compose.material.SwipeableV2State$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public final T invoke(SaverScope Saver, SwipeableV2State<T> it) {
                    Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getCurrentState();
                }
            }, new Function1<T, SwipeableV2State<T>>() { // from class: androidx.compose.material.SwipeableV2State$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((SwipeableV2State$Companion$Saver$2<T>) obj);
                }

                @Override // kotlin.jvm.functions.Function1
                public final SwipeableV2State<T> invoke(T it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new SwipeableV2State<>(it, animationSpec, confirmStateChange);
                }
            });
        }
    }
}
