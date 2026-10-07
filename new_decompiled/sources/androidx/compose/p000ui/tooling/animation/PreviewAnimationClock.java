package androidx.compose.p000ui.tooling.animation;

import android.util.Log;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.DecayAnimation;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.RepeatableSpec;
import androidx.compose.animation.core.SnapSpec;
import androidx.compose.animation.core.StartOffset;
import androidx.compose.animation.core.StartOffsetType;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec;
import androidx.compose.animation.tooling.ComposeAnimatedProperty;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import androidx.compose.animation.tooling.TransitionInfo;
import androidx.health.connect.client.records.CervicalMucusRecord;
import androidx.health.connect.client.records.Vo2MaxRecord;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;

/* compiled from: PreviewAnimationClock.kt */
@Metadata(m286d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001:\u0002pqB\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u00103\u001a\u00020\u0004J\u0014\u00104\u001a\b\u0012\u0004\u0012\u000206052\u0006\u00107\u001a\u000208J\u001e\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020!ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020>J\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020A052\u0006\u00107\u001a\u0002082\u0006\u0010B\u001a\u00020>J\u0010\u0010C\u001a\u00020>2\u0006\u0010D\u001a\u00020>H\u0002J\u0010\u0010E\u001a\u00020>2\u0006\u0010F\u001a\u00020>H\u0002J\u0010\u0010G\u001a\u00020\u00042\u0006\u00107\u001a\u000208H\u0015J\u0010\u0010H\u001a\u00020\u00042\u0006\u00107\u001a\u000208H\u0015J\u000e\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020>J\u001a\u0010K\u001a\u00020\u00042\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020>0MJ\u000e\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u0001J\u0016\u0010P\u001a\u00020\u00042\u000e\u0010Q\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\rJ\u0012\u0010R\u001a\u00020\u00042\n\u0010S\u001a\u0006\u0012\u0002\b\u00030\u000fJ$\u0010T\u001a\u00020\u00042\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\u000e\b\u0002\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0016\u0010W\u001a\u00020\u00042\u000e\u0010X\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001aJ\u000e\u0010Y\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u001cJ\u0016\u0010[\u001a\u00020\u00042\u000e\u0010\\\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001eJ\u0014\u0010]\u001a\u00020\u00042\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fJ\u0016\u0010_\u001a\u00020\u00042\u0006\u0010:\u001a\u00020!2\u0006\u0010`\u001a\u00020\u0001J\u001e\u0010a\u001a\u00020\u00042\u0006\u0010:\u001a\u0002082\u0006\u0010b\u001a\u00020\u00012\u0006\u0010c\u001a\u00020\u0001J&\u0010d\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u00030eR\u0006\u0012\u0002\b\u00030\u000f05*\u0006\u0012\u0002\b\u00030\u000fH\u0002JB\u0010f\u001a\u00020A\"\u0004\b\u0000\u0010g\"\b\b\u0001\u0010h*\u00020i\"\u0004\b\u0002\u0010j*\u0018\u0012\u0004\u0012\u0002Hg\u0012\u0004\u0012\u0002Hh0eR\b\u0012\u0004\u0012\u0002Hj0\u000f2\b\b\u0002\u0010k\u001a\u00020>H\u0002J%\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070m*\u00020\u0012H\u0002ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\bn\u0010oR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u00010\u000bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r0\u000bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000RG\u0010\u0010\u001a*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000f\u0012\u0004\u0012\u00020\u00120\u0011j\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000f\u0012\u0004\u0012\u00020\u0012`\u00138\u0000X\u0081\u0004ø\u0001\u0000¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0019\u001a\u0014\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001a0\u000bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001b\u001a\f\u0012\u0004\u0012\u00020\u001c0\u000bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001d\u001a\u0014\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001e0\u000bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010%R,\u0010&\u001a\u0012\u0012\u0004\u0012\u00020'0 j\b\u0012\u0004\u0012\u00020'`\"8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0015\u001a\u0004\b)\u0010%R,\u0010*\u001a\u0012\u0012\u0004\u0012\u00020+0 j\b\u0012\u0004\u0012\u00020+`\"8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0015\u001a\u0004\b-\u0010%RD\u0010.\u001a*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000f\u0012\u0004\u0012\u00020/0\u0011j\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000f\u0012\u0004\u0012\u00020/`\u00138\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u0015\u001a\u0004\b1\u0010\u0017R\u000e\u00102\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006r"}, m287d2 = {"Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "", "setAnimationsTimeCallback", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "DEBUG", "", "TAG", "", "animateContentSizeSubscriber", "Landroidx/compose/ui/tooling/animation/PreviewAnimationClock$UnsupportedComposeAnimationSubscriber;", "animateXAsStateSubscriber", "Landroidx/compose/animation/core/Animatable;", "animatedContentSubscriber", "Landroidx/compose/animation/core/Transition;", "animatedVisibilityStates", "Ljava/util/HashMap;", "Landroidx/compose/ui/tooling/animation/AnimatedVisibilityState;", "Lkotlin/collections/HashMap;", "getAnimatedVisibilityStates$ui_tooling_release$annotations", "()V", "getAnimatedVisibilityStates$ui_tooling_release", "()Ljava/util/HashMap;", "animatedVisibilityStatesLock", "decayAnimationSubscriber", "Landroidx/compose/animation/core/DecayAnimation;", "infiniteTransitionSubscriber", "Landroidx/compose/animation/core/InfiniteTransition;", "targetBasedAnimationSubscriber", "Landroidx/compose/animation/core/TargetBasedAnimation;", "trackedAnimatedVisibility", "Ljava/util/LinkedHashSet;", "Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;", "Lkotlin/collections/LinkedHashSet;", "getTrackedAnimatedVisibility$ui_tooling_release$annotations", "getTrackedAnimatedVisibility$ui_tooling_release", "()Ljava/util/LinkedHashSet;", "trackedTransitions", "Landroidx/compose/ui/tooling/animation/TransitionComposeAnimation;", "getTrackedTransitions$ui_tooling_release$annotations", "getTrackedTransitions$ui_tooling_release", "trackedUnsupported", "Landroidx/compose/ui/tooling/animation/UnsupportedComposeAnimation;", "getTrackedUnsupported$ui_tooling_release$annotations", "getTrackedUnsupported$ui_tooling_release", "transitionStates", "Landroidx/compose/ui/tooling/animation/PreviewAnimationClock$TransitionState;", "getTransitionStates$ui_tooling_release$annotations", "getTransitionStates$ui_tooling_release", "transitionStatesLock", "dispose", "getAnimatedProperties", "", "Landroidx/compose/animation/tooling/ComposeAnimatedProperty;", "animation", "Landroidx/compose/animation/tooling/ComposeAnimation;", "getAnimatedVisibilityState", "composeAnimation", "getAnimatedVisibilityState-zrx7VqY", "(Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;)Ljava/lang/String;", "getMaxDuration", "", "getMaxDurationPerIteration", "getTransitions", "Landroidx/compose/animation/tooling/TransitionInfo;", "stepMillis", "millisToNanos", "timeMs", "nanosToMillis", "timeNs", "notifySubscribe", "notifyUnsubscribe", "setClockTime", "animationTimeMs", "setClockTimes", "animationTimeMillis", "", "trackAnimateContentSize", "sizeAnimationModifier", "trackAnimateXAsState", "animatable", "trackAnimatedContent", "animatedContent", "trackAnimatedVisibility", "parent", "onSeek", "trackDecayAnimations", "decayAnimation", "trackInfiniteTransition", "infiniteTransition", "trackTargetBasedAnimations", "targetBasedAnimation", "trackTransition", "transition", "updateAnimatedVisibilityState", "state", "updateFromAndToStates", "fromState", "toState", "allAnimations", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "createTransitionInfo", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "S", "stepMs", "toCurrentTargetPair", "Lkotlin/Pair;", "toCurrentTargetPair-RvB7uIg", "(Ljava/lang/String;)Lkotlin/Pair;", "TransitionState", "UnsupportedComposeAnimationSubscriber", "ui-tooling_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public class PreviewAnimationClock {
    private final boolean DEBUG;
    private final String TAG;
    private final UnsupportedComposeAnimationSubscriber<Object> animateContentSizeSubscriber;
    private final UnsupportedComposeAnimationSubscriber<Animatable<?, ?>> animateXAsStateSubscriber;
    private final UnsupportedComposeAnimationSubscriber<Transition<?>> animatedContentSubscriber;
    private final HashMap<Transition<Object>, AnimatedVisibilityState> animatedVisibilityStates;
    private final Object animatedVisibilityStatesLock;
    private final UnsupportedComposeAnimationSubscriber<DecayAnimation<?, ?>> decayAnimationSubscriber;
    private final UnsupportedComposeAnimationSubscriber<InfiniteTransition> infiniteTransitionSubscriber;
    private final Function0<Unit> setAnimationsTimeCallback;
    private final UnsupportedComposeAnimationSubscriber<TargetBasedAnimation<?, ?>> targetBasedAnimationSubscriber;
    private final LinkedHashSet<AnimatedVisibilityComposeAnimation> trackedAnimatedVisibility;
    private final LinkedHashSet<TransitionComposeAnimation> trackedTransitions;
    private final LinkedHashSet<UnsupportedComposeAnimation> trackedUnsupported;
    private final HashMap<Transition<Object>, TransitionState> transitionStates;
    private final Object transitionStatesLock;

    /* JADX WARN: Multi-variable type inference failed */
    public PreviewAnimationClock() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void getAnimatedVisibilityStates$ui_tooling_release$annotations() {
    }

    public static /* synthetic */ void getTrackedAnimatedVisibility$ui_tooling_release$annotations() {
    }

    public static /* synthetic */ void getTrackedTransitions$ui_tooling_release$annotations() {
    }

    public static /* synthetic */ void getTrackedUnsupported$ui_tooling_release$annotations() {
    }

    public static /* synthetic */ void getTransitionStates$ui_tooling_release$annotations() {
    }

    public PreviewAnimationClock(Function0<Unit> setAnimationsTimeCallback) {
        Intrinsics.checkNotNullParameter(setAnimationsTimeCallback, "setAnimationsTimeCallback");
        this.setAnimationsTimeCallback = setAnimationsTimeCallback;
        this.TAG = "PreviewAnimationClock";
        this.trackedTransitions = new LinkedHashSet<>();
        this.trackedAnimatedVisibility = new LinkedHashSet<>();
        this.trackedUnsupported = new LinkedHashSet<>();
        this.transitionStates = new HashMap<>();
        this.transitionStatesLock = new Object();
        this.animatedVisibilityStates = new HashMap<>();
        this.animatedVisibilityStatesLock = new Object();
        this.animateXAsStateSubscriber = new UnsupportedComposeAnimationSubscriber<>();
        this.animateContentSizeSubscriber = new UnsupportedComposeAnimationSubscriber<>();
        this.targetBasedAnimationSubscriber = new UnsupportedComposeAnimationSubscriber<>();
        this.decayAnimationSubscriber = new UnsupportedComposeAnimationSubscriber<>();
        this.animatedContentSubscriber = new UnsupportedComposeAnimationSubscriber<>();
        this.infiniteTransitionSubscriber = new UnsupportedComposeAnimationSubscriber<>();
    }

    public /* synthetic */ PreviewAnimationClock(C05011 c05011, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function0<Unit>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock.1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        } : c05011);
    }

    public final LinkedHashSet<TransitionComposeAnimation> getTrackedTransitions$ui_tooling_release() {
        return this.trackedTransitions;
    }

    public final LinkedHashSet<AnimatedVisibilityComposeAnimation> getTrackedAnimatedVisibility$ui_tooling_release() {
        return this.trackedAnimatedVisibility;
    }

    public final LinkedHashSet<UnsupportedComposeAnimation> getTrackedUnsupported$ui_tooling_release() {
        return this.trackedUnsupported;
    }

    public final HashMap<Transition<Object>, TransitionState> getTransitionStates$ui_tooling_release() {
        return this.transitionStates;
    }

    public final HashMap<Transition<Object>, AnimatedVisibilityState> getAnimatedVisibilityStates$ui_tooling_release() {
        return this.animatedVisibilityStates;
    }

    /* compiled from: PreviewAnimationClock.kt */
    @Metadata(m286d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u001b\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m287d2 = {"Landroidx/compose/ui/tooling/animation/PreviewAnimationClock$UnsupportedComposeAnimationSubscriber;", "T", "", "(Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;)V", "animations", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "lock", CervicalMucusRecord.Appearance.CLEAR, "", "trackAnimation", "animation", "label", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "ui-tooling_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    private final class UnsupportedComposeAnimationSubscriber<T> {
        private final LinkedHashSet<T> animations = new LinkedHashSet<>();
        private final Object lock = new Object();

        public UnsupportedComposeAnimationSubscriber() {
        }

        public final void trackAnimation(T animation, String label) {
            Intrinsics.checkNotNullParameter(label, "label");
            if (UnsupportedComposeAnimation.INSTANCE.getApiAvailable()) {
                Object obj = this.lock;
                PreviewAnimationClock previewAnimationClock = PreviewAnimationClock.this;
                synchronized (obj) {
                    if (this.animations.contains(animation)) {
                        if (previewAnimationClock.DEBUG) {
                            Log.d(previewAnimationClock.TAG, "Animation " + animation + " is already being tracked");
                        }
                        return;
                    }
                    this.animations.add(animation);
                    if (PreviewAnimationClock.this.DEBUG) {
                        Log.d(PreviewAnimationClock.this.TAG, "Animation " + animation + " is now tracked");
                    }
                    UnsupportedComposeAnimation it = UnsupportedComposeAnimation.INSTANCE.create(label);
                    if (it != null) {
                        PreviewAnimationClock previewAnimationClock2 = PreviewAnimationClock.this;
                        previewAnimationClock2.getTrackedUnsupported$ui_tooling_release().add(it);
                        previewAnimationClock2.notifySubscribe(it);
                    }
                }
            }
        }

        public final void clear() {
            this.animations.clear();
        }
    }

    public final void trackTransition(Transition<Object> transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        synchronized (this.transitionStatesLock) {
            if (this.transitionStates.containsKey(transition)) {
                if (this.DEBUG) {
                    Log.d(this.TAG, "Transition " + transition + " is already being tracked");
                }
                return;
            }
            this.transitionStates.put(transition, new TransitionState(transition.getCurrentState(), transition.getTargetState()));
            Unit unit = Unit.INSTANCE;
            if (this.DEBUG) {
                Log.d(this.TAG, "Transition " + transition + " is now tracked");
            }
            TransitionComposeAnimation composeAnimation = ComposeAnimationParserKt.parse(transition);
            this.trackedTransitions.add(composeAnimation);
            notifySubscribe(composeAnimation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackAnimatedVisibility$default(PreviewAnimationClock previewAnimationClock, Transition transition, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackAnimatedVisibility");
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$trackAnimatedVisibility$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            };
        }
        previewAnimationClock.trackAnimatedVisibility(transition, function0);
    }

    public final void trackAnimatedVisibility(Transition<Object> parent, Function0<Unit> onSeek) {
        String m4317getEnterq9NwIk0;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(onSeek, "onSeek");
        synchronized (this.animatedVisibilityStatesLock) {
            if (this.animatedVisibilityStates.containsKey(parent)) {
                if (this.DEBUG) {
                    Log.d(this.TAG, "AnimatedVisibility transition " + parent + " is already being tracked");
                }
                return;
            }
            HashMap<Transition<Object>, AnimatedVisibilityState> hashMap = this.animatedVisibilityStates;
            Object currentState = parent.getCurrentState();
            Intrinsics.checkNotNull(currentState, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) currentState).booleanValue()) {
                m4317getEnterq9NwIk0 = AnimatedVisibilityState.INSTANCE.m4318getExitq9NwIk0();
            } else {
                m4317getEnterq9NwIk0 = AnimatedVisibilityState.INSTANCE.m4317getEnterq9NwIk0();
            }
            hashMap.put(parent, AnimatedVisibilityState.m4310boximpl(m4317getEnterq9NwIk0));
            Unit unit = Unit.INSTANCE;
            if (this.DEBUG) {
                Log.d(this.TAG, "AnimatedVisibility transition " + parent + " is now tracked");
            }
            AnimatedVisibilityComposeAnimation composeAnimation = ComposeAnimationParserKt.parseAnimatedVisibility(parent);
            AnimatedVisibilityState animatedVisibilityState = this.animatedVisibilityStates.get(parent);
            Intrinsics.checkNotNull(animatedVisibilityState);
            Pair<Boolean, Boolean> m4322toCurrentTargetPairRvB7uIg = m4322toCurrentTargetPairRvB7uIg(animatedVisibilityState.m4316unboximpl());
            boolean current = m4322toCurrentTargetPairRvB7uIg.component1().booleanValue();
            boolean target = m4322toCurrentTargetPairRvB7uIg.component2().booleanValue();
            parent.seek(Boolean.valueOf(current), Boolean.valueOf(target), 0L);
            onSeek.invoke();
            this.trackedAnimatedVisibility.add(composeAnimation);
            notifySubscribe(composeAnimation);
        }
    }

    public final void trackAnimateXAsState(Animatable<?, ?> animatable) {
        Intrinsics.checkNotNullParameter(animatable, "animatable");
        this.animateXAsStateSubscriber.trackAnimation(animatable, animatable.getLabel());
    }

    public final void trackAnimateContentSize(Object sizeAnimationModifier) {
        Intrinsics.checkNotNullParameter(sizeAnimationModifier, "sizeAnimationModifier");
        this.animateContentSizeSubscriber.trackAnimation(sizeAnimationModifier, "animateContentSize");
    }

    public final void trackTargetBasedAnimations(TargetBasedAnimation<?, ?> targetBasedAnimation) {
        Intrinsics.checkNotNullParameter(targetBasedAnimation, "targetBasedAnimation");
        this.targetBasedAnimationSubscriber.trackAnimation(targetBasedAnimation, "TargetBasedAnimation");
    }

    public final void trackDecayAnimations(DecayAnimation<?, ?> decayAnimation) {
        Intrinsics.checkNotNullParameter(decayAnimation, "decayAnimation");
        this.decayAnimationSubscriber.trackAnimation(decayAnimation, "DecayAnimation");
    }

    public final void trackAnimatedContent(Transition<?> animatedContent) {
        Intrinsics.checkNotNullParameter(animatedContent, "animatedContent");
        this.animatedContentSubscriber.trackAnimation(animatedContent, "AnimatedContent");
    }

    public final void trackInfiniteTransition(InfiniteTransition infiniteTransition) {
        Intrinsics.checkNotNullParameter(infiniteTransition, "infiniteTransition");
        this.infiniteTransitionSubscriber.trackAnimation(infiniteTransition, "InfiniteTransition");
    }

    protected void notifySubscribe(ComposeAnimation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    protected void notifyUnsubscribe(ComposeAnimation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    public final void updateFromAndToStates(ComposeAnimation composeAnimation, Object fromState, Object toState) {
        Intrinsics.checkNotNullParameter(composeAnimation, "composeAnimation");
        Intrinsics.checkNotNullParameter(fromState, "fromState");
        Intrinsics.checkNotNullParameter(toState, "toState");
        if (composeAnimation.getType() == ComposeAnimationType.TRANSITION_ANIMATION && CollectionsKt.contains(this.trackedTransitions, composeAnimation)) {
            TransitionComposeAnimation transitionComposeAnimation = (TransitionComposeAnimation) composeAnimation;
            synchronized (this.transitionStatesLock) {
                this.transitionStates.put(transitionComposeAnimation.m4324getAnimationObject(), new TransitionState(fromState, toState));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void updateAnimatedVisibilityState(AnimatedVisibilityComposeAnimation composeAnimation, Object state) {
        Intrinsics.checkNotNullParameter(composeAnimation, "composeAnimation");
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.trackedAnimatedVisibility.contains(composeAnimation)) {
            synchronized (this.animatedVisibilityStatesLock) {
                this.animatedVisibilityStates.put(composeAnimation.m4309getAnimationObject(), (AnimatedVisibilityState) state);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* renamed from: getAnimatedVisibilityState-zrx7VqY, reason: not valid java name */
    public final String m4323getAnimatedVisibilityStatezrx7VqY(AnimatedVisibilityComposeAnimation composeAnimation) {
        Intrinsics.checkNotNullParameter(composeAnimation, "composeAnimation");
        AnimatedVisibilityState animatedVisibilityState = this.animatedVisibilityStates.get(composeAnimation.m4309getAnimationObject());
        String m4316unboximpl = animatedVisibilityState != null ? animatedVisibilityState.m4316unboximpl() : null;
        if (m4316unboximpl != null) {
            return m4316unboximpl;
        }
        return AnimatedVisibilityState.INSTANCE.m4317getEnterq9NwIk0();
    }

    public final long getMaxDuration() {
        Iterable $this$map$iv = this.trackedTransitions;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            TransitionComposeAnimation composeAnimation = (TransitionComposeAnimation) item$iv$iv;
            destination$iv$iv.add(Long.valueOf(nanosToMillis(composeAnimation.m4324getAnimationObject().getTotalDurationNanos())));
        }
        Long l = (Long) CollectionsKt.maxOrNull(destination$iv$iv);
        long transitionsDuration = l != null ? l.longValue() : -1L;
        Iterable $this$map$iv2 = this.trackedAnimatedVisibility;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            AnimatedVisibilityComposeAnimation composeAnimation2 = (AnimatedVisibilityComposeAnimation) item$iv$iv2;
            Transition<Object> childTransition = composeAnimation2.getChildTransition();
            destination$iv$iv2.add(Long.valueOf(childTransition != null ? nanosToMillis(childTransition.getTotalDurationNanos()) : -1L));
        }
        Long l2 = (Long) CollectionsKt.maxOrNull(destination$iv$iv2);
        long animatedVisibilityDuration = l2 != null ? l2.longValue() : -1L;
        return Math.max(transitionsDuration, animatedVisibilityDuration);
    }

    public final long getMaxDurationPerIteration() {
        Iterable $this$map$iv = this.trackedTransitions;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            TransitionComposeAnimation composeAnimation = (TransitionComposeAnimation) item$iv$iv;
            destination$iv$iv.add(Long.valueOf(nanosToMillis(composeAnimation.m4324getAnimationObject().getTotalDurationNanos())));
        }
        Long l = (Long) CollectionsKt.maxOrNull(destination$iv$iv);
        long transitionsDuration = l != null ? l.longValue() : -1L;
        Iterable $this$map$iv2 = this.trackedAnimatedVisibility;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            AnimatedVisibilityComposeAnimation composeAnimation2 = (AnimatedVisibilityComposeAnimation) item$iv$iv2;
            Transition<Object> childTransition = composeAnimation2.getChildTransition();
            destination$iv$iv2.add(Long.valueOf(childTransition != null ? nanosToMillis(childTransition.getTotalDurationNanos()) : -1L));
        }
        Long l2 = (Long) CollectionsKt.maxOrNull(destination$iv$iv2);
        long animatedVisibilityDuration = l2 != null ? l2.longValue() : -1L;
        return Math.max(transitionsDuration, animatedVisibilityDuration);
    }

    public final List<ComposeAnimatedProperty> getAnimatedProperties(ComposeAnimation animation) {
        Transition<Object> child;
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (CollectionsKt.contains(this.trackedTransitions, animation)) {
            Transition<Object> transition = ((TransitionComposeAnimation) animation).m4324getAnimationObject();
            Iterable $this$mapNotNull$iv = allAnimations(transition);
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                Transition.TransitionAnimationState it = (Transition.TransitionAnimationState) element$iv$iv$iv;
                String label = it.getLabel();
                Transition<Object> transition2 = transition;
                Object value = it.getValue();
                Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                ComposeAnimatedProperty composeAnimatedProperty = value == null ? null : new ComposeAnimatedProperty(label, value);
                if (composeAnimatedProperty != null) {
                    destination$iv$iv.add(composeAnimatedProperty);
                    transition = transition2;
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                } else {
                    transition = transition2;
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                }
            }
            return (List) destination$iv$iv;
        }
        if (CollectionsKt.contains(this.trackedAnimatedVisibility, animation) && (child = ((AnimatedVisibilityComposeAnimation) animation).getChildTransition()) != null) {
            Iterable $this$mapNotNull$iv3 = allAnimations(child);
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv2 : $this$mapNotNull$iv3) {
                Transition.TransitionAnimationState it2 = (Transition.TransitionAnimationState) element$iv$iv$iv2;
                String label2 = it2.getLabel();
                Object value2 = it2.getValue();
                Transition<Object> child2 = child;
                ComposeAnimatedProperty composeAnimatedProperty2 = value2 == null ? null : new ComposeAnimatedProperty(label2, value2);
                if (composeAnimatedProperty2 != null) {
                    destination$iv$iv2.add(composeAnimatedProperty2);
                    child = child2;
                } else {
                    child = child2;
                }
            }
            return (List) destination$iv$iv2;
        }
        return CollectionsKt.emptyList();
    }

    public final List<TransitionInfo> getTransitions(ComposeAnimation animation, long stepMillis) {
        Transition<Object> child;
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (CollectionsKt.contains(this.trackedTransitions, animation)) {
            Transition<Object> transition = ((TransitionComposeAnimation) animation).m4324getAnimationObject();
            Iterable $this$map$iv = allAnimations(transition);
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Transition.TransitionAnimationState it = (Transition.TransitionAnimationState) item$iv$iv;
                destination$iv$iv.add(createTransitionInfo(it, stepMillis));
            }
            return (List) destination$iv$iv;
        }
        if (CollectionsKt.contains(this.trackedAnimatedVisibility, animation) && (child = ((AnimatedVisibilityComposeAnimation) animation).getChildTransition()) != null) {
            Iterable $this$map$iv2 = allAnimations(child);
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                Transition.TransitionAnimationState it2 = (Transition.TransitionAnimationState) item$iv$iv2;
                destination$iv$iv2.add(createTransitionInfo(it2, stepMillis));
            }
            return (List) destination$iv$iv2;
        }
        return CollectionsKt.emptyList();
    }

    public final void setClockTime(long animationTimeMs) {
        Iterable $this$associateWith$iv = SetsKt.plus((Set) this.trackedTransitions, (Iterable) this.trackedAnimatedVisibility);
        LinkedHashMap result$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv, 10)), 16));
        for (Object element$iv$iv : $this$associateWith$iv) {
            result$iv.put(element$iv$iv, Long.valueOf(animationTimeMs));
        }
        setClockTimes(result$iv);
    }

    public final void setClockTimes(Map<ComposeAnimation, Long> animationTimeMillis) {
        Map $this$forEach$iv;
        Intrinsics.checkNotNullParameter(animationTimeMillis, "animationTimeMillis");
        Map $this$forEach$iv2 = animationTimeMillis;
        for (Map.Entry element$iv : $this$forEach$iv2.entrySet()) {
            ComposeAnimation composeAnimation = element$iv.getKey();
            long millis = element$iv.getValue().longValue();
            long timeNs = TimeUnit.MILLISECONDS.toNanos(millis);
            if (CollectionsKt.contains(this.trackedTransitions, composeAnimation)) {
                Intrinsics.checkNotNull(composeAnimation, "null cannot be cast to non-null type androidx.compose.ui.tooling.animation.TransitionComposeAnimation");
                Transition it = ((TransitionComposeAnimation) composeAnimation).m4324getAnimationObject();
                TransitionState states = this.transitionStates.get(it);
                if (states == null) {
                    $this$forEach$iv = $this$forEach$iv2;
                } else {
                    Intrinsics.checkNotNullExpressionValue(states, "transitionStates[it] ?: return@let");
                    $this$forEach$iv = $this$forEach$iv2;
                    it.seek(states.getCurrent(), states.getTarget(), timeNs);
                }
            } else {
                $this$forEach$iv = $this$forEach$iv2;
                if (CollectionsKt.contains(this.trackedAnimatedVisibility, composeAnimation)) {
                    Intrinsics.checkNotNull(composeAnimation, "null cannot be cast to non-null type androidx.compose.ui.tooling.animation.AnimatedVisibilityComposeAnimation");
                    Transition it2 = ((AnimatedVisibilityComposeAnimation) composeAnimation).m4309getAnimationObject();
                    AnimatedVisibilityState animatedVisibilityState = this.animatedVisibilityStates.get(it2);
                    String m4316unboximpl = animatedVisibilityState != null ? animatedVisibilityState.m4316unboximpl() : null;
                    if (m4316unboximpl != null) {
                        Intrinsics.checkNotNullExpressionValue(m4316unboximpl != null ? AnimatedVisibilityState.m4310boximpl(m4316unboximpl) : null, "animatedVisibilityStates[it]");
                        Pair<Boolean, Boolean> m4322toCurrentTargetPairRvB7uIg = m4322toCurrentTargetPairRvB7uIg(m4316unboximpl);
                        if (m4322toCurrentTargetPairRvB7uIg != null) {
                            boolean current = m4322toCurrentTargetPairRvB7uIg.component1().booleanValue();
                            boolean target = m4322toCurrentTargetPairRvB7uIg.component2().booleanValue();
                            it2.seek(Boolean.valueOf(current), Boolean.valueOf(target), timeNs);
                        }
                    }
                }
            }
            $this$forEach$iv2 = $this$forEach$iv;
        }
        this.setAnimationsTimeCallback.invoke();
    }

    public final void dispose() {
        Iterable $this$forEach$iv = this.trackedTransitions;
        for (Object element$iv : $this$forEach$iv) {
            TransitionComposeAnimation it = (TransitionComposeAnimation) element$iv;
            notifyUnsubscribe(it);
        }
        Iterable $this$forEach$iv2 = this.trackedAnimatedVisibility;
        for (Object element$iv2 : $this$forEach$iv2) {
            AnimatedVisibilityComposeAnimation it2 = (AnimatedVisibilityComposeAnimation) element$iv2;
            notifyUnsubscribe(it2);
        }
        Iterable $this$forEach$iv3 = this.trackedUnsupported;
        for (Object element$iv3 : $this$forEach$iv3) {
            UnsupportedComposeAnimation it3 = (UnsupportedComposeAnimation) element$iv3;
            notifyUnsubscribe(it3);
        }
        this.trackedAnimatedVisibility.clear();
        this.trackedTransitions.clear();
        this.animatedVisibilityStates.clear();
        this.transitionStates.clear();
        this.trackedUnsupported.clear();
        this.animatedContentSubscriber.clear();
        this.animateXAsStateSubscriber.clear();
        this.targetBasedAnimationSubscriber.clear();
        this.decayAnimationSubscriber.clear();
        this.animateContentSizeSubscriber.clear();
        this.infiniteTransitionSubscriber.clear();
    }

    /* compiled from: PreviewAnimationClock.kt */
    @Metadata(m286d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0001HÆ\u0003J\t\u0010\t\u001a\u00020\u0001HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0006¨\u0006\u0012"}, m287d2 = {"Landroidx/compose/ui/tooling/animation/PreviewAnimationClock$TransitionState;", "", "current", "target", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getCurrent", "()Ljava/lang/Object;", "getTarget", "component1", "component2", "copy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "toString", "", "ui-tooling_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public static final /* data */ class TransitionState {
        private final Object current;
        private final Object target;

        public static /* synthetic */ TransitionState copy$default(TransitionState transitionState, Object obj, Object obj2, int i, Object obj3) {
            if ((i & 1) != 0) {
                obj = transitionState.current;
            }
            if ((i & 2) != 0) {
                obj2 = transitionState.target;
            }
            return transitionState.copy(obj, obj2);
        }

        /* renamed from: component1, reason: from getter */
        public final Object getCurrent() {
            return this.current;
        }

        /* renamed from: component2, reason: from getter */
        public final Object getTarget() {
            return this.target;
        }

        public final TransitionState copy(Object current, Object target) {
            Intrinsics.checkNotNullParameter(current, "current");
            Intrinsics.checkNotNullParameter(target, "target");
            return new TransitionState(current, target);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TransitionState)) {
                return false;
            }
            TransitionState transitionState = (TransitionState) other;
            return Intrinsics.areEqual(this.current, transitionState.current) && Intrinsics.areEqual(this.target, transitionState.target);
        }

        public int hashCode() {
            return (this.current.hashCode() * 31) + this.target.hashCode();
        }

        public String toString() {
            return "TransitionState(current=" + this.current + ", target=" + this.target + ')';
        }

        public TransitionState(Object current, Object target) {
            Intrinsics.checkNotNullParameter(current, "current");
            Intrinsics.checkNotNullParameter(target, "target");
            this.current = current;
            this.target = target;
        }

        public final Object getCurrent() {
            return this.current;
        }

        public final Object getTarget() {
            return this.target;
        }
    }

    static /* synthetic */ TransitionInfo createTransitionInfo$default(PreviewAnimationClock previewAnimationClock, Transition.TransitionAnimationState transitionAnimationState, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createTransitionInfo");
        }
        if ((i & 1) != 0) {
            j = 1;
        }
        return previewAnimationClock.createTransitionInfo(transitionAnimationState, j);
    }

    private final <T, V extends AnimationVector, S> TransitionInfo createTransitionInfo(final Transition<S>.TransitionAnimationState<T, V> transitionAnimationState, final long stepMs) {
        final long endTimeMs = nanosToMillis(transitionAnimationState.getAnimation().getDurationNanos());
        final Lazy startTimeMs$delegate = LazyKt.lazy(new Function0<Long>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$createTransitionInfo$startTimeMs$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                Number valueOf;
                AnimationSpec animationSpec = transitionAnimationState.getAnimationSpec();
                if (animationSpec instanceof TweenSpec) {
                    valueOf = Integer.valueOf(((TweenSpec) animationSpec).getDelay());
                } else if (animationSpec instanceof SnapSpec) {
                    valueOf = Integer.valueOf(((SnapSpec) animationSpec).getDelay());
                } else if (animationSpec instanceof KeyframesSpec) {
                    valueOf = Integer.valueOf(((KeyframesSpec) animationSpec).getConfig().getDelayMillis());
                } else if (animationSpec instanceof RepeatableSpec) {
                    if (StartOffsetType.m464equalsimpl0(StartOffset.m457getOffsetTypeEo1U57Q(((RepeatableSpec) animationSpec).getInitialStartOffset()), StartOffsetType.INSTANCE.m468getDelayEo1U57Q())) {
                        valueOf = Integer.valueOf(StartOffset.m456getOffsetMillisimpl(((RepeatableSpec) animationSpec).getInitialStartOffset()));
                    } else {
                        valueOf = 0L;
                    }
                } else if (animationSpec instanceof InfiniteRepeatableSpec) {
                    if (StartOffsetType.m464equalsimpl0(StartOffset.m457getOffsetTypeEo1U57Q(((InfiniteRepeatableSpec) animationSpec).getInitialStartOffset()), StartOffsetType.INSTANCE.m468getDelayEo1U57Q())) {
                        valueOf = Integer.valueOf(StartOffset.m456getOffsetMillisimpl(((InfiniteRepeatableSpec) animationSpec).getInitialStartOffset()));
                    } else {
                        valueOf = 0L;
                    }
                } else {
                    valueOf = animationSpec instanceof VectorizedDurationBasedAnimationSpec ? Integer.valueOf(((VectorizedDurationBasedAnimationSpec) animationSpec).getDelayMillis()) : 0L;
                }
                return Long.valueOf(valueOf.longValue());
            }
        });
        Lazy values$delegate = LazyKt.lazy(new Function0<Map<Long, T>>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$createTransitionInfo$values$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<Long, T> invoke() {
                long m4320createTransitionInfo$lambda21;
                long m4320createTransitionInfo$lambda212;
                long millisToNanos;
                long millisToNanos2;
                long m4320createTransitionInfo$lambda213;
                long millisToNanos3;
                Map values = new LinkedHashMap();
                m4320createTransitionInfo$lambda21 = PreviewAnimationClock.m4320createTransitionInfo$lambda21(startTimeMs$delegate);
                Long valueOf = Long.valueOf(m4320createTransitionInfo$lambda21);
                TargetBasedAnimation animation = transitionAnimationState.getAnimation();
                PreviewAnimationClock previewAnimationClock = this;
                m4320createTransitionInfo$lambda212 = PreviewAnimationClock.m4320createTransitionInfo$lambda21(startTimeMs$delegate);
                millisToNanos = previewAnimationClock.millisToNanos(m4320createTransitionInfo$lambda212);
                values.put(valueOf, animation.getValueFromNanos(millisToNanos));
                Long valueOf2 = Long.valueOf(endTimeMs);
                TargetBasedAnimation animation2 = transitionAnimationState.getAnimation();
                millisToNanos2 = this.millisToNanos(endTimeMs);
                values.put(valueOf2, animation2.getValueFromNanos(millisToNanos2));
                m4320createTransitionInfo$lambda213 = PreviewAnimationClock.m4320createTransitionInfo$lambda21(startTimeMs$delegate);
                if (stepMs <= 0) {
                    throw new IllegalArgumentException("Step must be positive, was: " + stepMs + '.');
                }
                long millis = m4320createTransitionInfo$lambda213;
                long progressionLastElement = ProgressionUtilKt.getProgressionLastElement(m4320createTransitionInfo$lambda213, endTimeMs, stepMs);
                if (millis <= progressionLastElement) {
                    while (true) {
                        Long valueOf3 = Long.valueOf(millis);
                        TargetBasedAnimation animation3 = transitionAnimationState.getAnimation();
                        millisToNanos3 = this.millisToNanos(millis);
                        values.put(valueOf3, animation3.getValueFromNanos(millisToNanos3));
                        if (millis == progressionLastElement) {
                            break;
                        }
                        millis += stepMs;
                    }
                }
                return values;
            }
        });
        String label = transitionAnimationState.getLabel();
        String name = transitionAnimationState.getAnimationSpec().getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "this.animationSpec.javaClass.name");
        return new TransitionInfo(label, name, m4320createTransitionInfo$lambda21(startTimeMs$delegate), endTimeMs, m4321createTransitionInfo$lambda22(values$delegate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createTransitionInfo$lambda-21, reason: not valid java name */
    public static final long m4320createTransitionInfo$lambda21(Lazy<Long> lazy) {
        return lazy.getValue().longValue();
    }

    /* renamed from: createTransitionInfo$lambda-22, reason: not valid java name */
    private static final <T> Map<Long, T> m4321createTransitionInfo$lambda22(Lazy<? extends Map<Long, T>> lazy) {
        return lazy.getValue();
    }

    private final long nanosToMillis(long timeNs) {
        return (999999 + timeNs) / DurationKt.NANOS_IN_MILLIS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long millisToNanos(long timeMs) {
        return AnimationKt.MillisToNanos * timeMs;
    }

    /* renamed from: toCurrentTargetPair-RvB7uIg, reason: not valid java name */
    private final Pair<Boolean, Boolean> m4322toCurrentTargetPairRvB7uIg(String $this$toCurrentTargetPair_u2dRvB7uIg) {
        return AnimatedVisibilityState.m4313equalsimpl0($this$toCurrentTargetPair_u2dRvB7uIg, AnimatedVisibilityState.INSTANCE.m4317getEnterq9NwIk0()) ? TuplesKt.m294to(false, true) : TuplesKt.m294to(true, false);
    }

    private final List<Transition<?>.TransitionAnimationState<?, ?>> allAnimations(Transition<?> transition) {
        Iterable $this$flatMap$iv = transition.getTransitions();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            Transition it = (Transition) element$iv$iv;
            Iterable list$iv$iv = allAnimations(it);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        List descendantAnimations = (List) destination$iv$iv;
        return CollectionsKt.plus((Collection) transition.getAnimations(), (Iterable) descendantAnimations);
    }
}
