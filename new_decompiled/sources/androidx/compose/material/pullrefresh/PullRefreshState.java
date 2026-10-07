package androidx.compose.material.pullrefresh;

import androidx.compose.material.ExperimentalMaterialApi;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* compiled from: PullRefreshState.kt */
@Metadata(m286d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B3\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\tH\u0002J\b\u0010-\u001a\u00020\tH\u0002J\u0015\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tH\u0000¢\u0006\u0002\b0J\r\u00101\u001a\u00020\u0007H\u0000¢\u0006\u0002\b2J\u0015\u00103\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0014H\u0000¢\u0006\u0002\b4R+\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u00148B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001c\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u001f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0013\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u000fR\u0011\u0010%\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b&\u0010\u000fR\u0014\u0010'\u001a\u00020\u00148@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0017R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000f¨\u00065"}, m287d2 = {"Landroidx/compose/material/pullrefresh/PullRefreshState;", "", "animationScope", "Lkotlinx/coroutines/CoroutineScope;", "onRefreshState", "Landroidx/compose/runtime/State;", "Lkotlin/Function0;", "", "refreshingOffset", "", "threshold", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/State;FF)V", "<set-?>", "_position", "get_position", "()F", "set_position", "(F)V", "_position$delegate", "Landroidx/compose/runtime/MutableState;", "", "_refreshing", "get_refreshing", "()Z", "set_refreshing", "(Z)V", "_refreshing$delegate", "adjustedDistancePulled", "getAdjustedDistancePulled", "adjustedDistancePulled$delegate", "Landroidx/compose/runtime/State;", "distancePulled", "getDistancePulled", "setDistancePulled", "distancePulled$delegate", "position", "getPosition$material_release", NotificationCompat.CATEGORY_PROGRESS, "getProgress", "refreshing", "getRefreshing$material_release", "getThreshold$material_release", "animateIndicatorTo", "Lkotlinx/coroutines/Job;", "offset", "calculateIndicatorPosition", "onPull", "pullDelta", "onPull$material_release", "onRelease", "onRelease$material_release", "setRefreshing", "setRefreshing$material_release", "material_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
@ExperimentalMaterialApi
/* loaded from: classes.dex */
public final class PullRefreshState {
    public static final int $stable = 8;

    /* renamed from: _position$delegate, reason: from kotlin metadata */
    private final MutableState _position;

    /* renamed from: _refreshing$delegate, reason: from kotlin metadata */
    private final MutableState _refreshing;

    /* renamed from: adjustedDistancePulled$delegate, reason: from kotlin metadata */
    private final State adjustedDistancePulled;
    private final CoroutineScope animationScope;

    /* renamed from: distancePulled$delegate, reason: from kotlin metadata */
    private final MutableState distancePulled;
    private final State<Function0<Unit>> onRefreshState;
    private final float refreshingOffset;
    private final float threshold;

    /* JADX WARN: Multi-variable type inference failed */
    public PullRefreshState(CoroutineScope animationScope, State<? extends Function0<Unit>> onRefreshState, float refreshingOffset, float threshold) {
        Intrinsics.checkNotNullParameter(animationScope, "animationScope");
        Intrinsics.checkNotNullParameter(onRefreshState, "onRefreshState");
        this.animationScope = animationScope;
        this.onRefreshState = onRefreshState;
        this.refreshingOffset = refreshingOffset;
        this.threshold = threshold;
        this.adjustedDistancePulled = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.compose.material.pullrefresh.PullRefreshState$adjustedDistancePulled$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                float distancePulled;
                distancePulled = PullRefreshState.this.getDistancePulled();
                return Float.valueOf(distancePulled * 0.5f);
            }
        });
        this._refreshing = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        Float valueOf = Float.valueOf(0.0f);
        this._position = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, null, 2, null);
        this.distancePulled = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, null, 2, null);
    }

    /* renamed from: getThreshold$material_release, reason: from getter */
    public final float getThreshold() {
        return this.threshold;
    }

    public final float getProgress() {
        return getAdjustedDistancePulled() / this.threshold;
    }

    public final boolean getRefreshing$material_release() {
        return get_refreshing();
    }

    public final float getPosition$material_release() {
        return get_position();
    }

    private final float getAdjustedDistancePulled() {
        State $this$getValue$iv = this.adjustedDistancePulled;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    private final boolean get_refreshing() {
        State $this$getValue$iv = this._refreshing;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private final void set_refreshing(boolean z) {
        MutableState $this$setValue$iv = this._refreshing;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float get_position() {
        State $this$getValue$iv = this._position;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void set_position(float f) {
        MutableState $this$setValue$iv = this._position;
        $this$setValue$iv.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getDistancePulled() {
        State $this$getValue$iv = this.distancePulled;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    private final void setDistancePulled(float f) {
        MutableState $this$setValue$iv = this.distancePulled;
        $this$setValue$iv.setValue(Float.valueOf(f));
    }

    public final float onPull$material_release(float pullDelta) {
        if (get_refreshing()) {
            return 0.0f;
        }
        float newOffset = RangesKt.coerceAtLeast(getDistancePulled() + pullDelta, 0.0f);
        float dragConsumed = newOffset - getDistancePulled();
        setDistancePulled(newOffset);
        set_position(calculateIndicatorPosition());
        return dragConsumed;
    }

    public final void onRelease$material_release() {
        if (!get_refreshing()) {
            if (getAdjustedDistancePulled() > this.threshold) {
                this.onRefreshState.getValue().invoke();
            } else {
                animateIndicatorTo(0.0f);
            }
        }
        setDistancePulled(0.0f);
    }

    public final void setRefreshing$material_release(boolean refreshing) {
        if (get_refreshing() != refreshing) {
            set_refreshing(refreshing);
            setDistancePulled(0.0f);
            animateIndicatorTo(refreshing ? this.refreshingOffset : 0.0f);
        }
    }

    private final Job animateIndicatorTo(float offset) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.animationScope, null, null, new PullRefreshState$animateIndicatorTo$1(this, offset, null), 3, null);
        return launch$default;
    }

    private final float calculateIndicatorPosition() {
        if (getAdjustedDistancePulled() > this.threshold) {
            float overshootPercent = Math.abs(getProgress()) - 1.0f;
            float linearTension = RangesKt.coerceIn(overshootPercent, 0.0f, 2.0f);
            float tensionPercent = linearTension - (((float) Math.pow(linearTension, 2)) / 4);
            float extraOffset = this.threshold * tensionPercent;
            float overshootPercent2 = this.threshold + extraOffset;
            return overshootPercent2;
        }
        float overshootPercent3 = getAdjustedDistancePulled();
        return overshootPercent3;
    }
}
