package androidx.compose.p000ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComposeAnimationParser.kt */
@Metadata(m286d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038F¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0096\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, m287d2 = {"Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;", "Landroidx/compose/animation/tooling/ComposeAnimation;", "parent", "Landroidx/compose/animation/core/Transition;", "", "parentLabel", "", "(Landroidx/compose/animation/core/Transition;Ljava/lang/String;)V", "animationObject", "getAnimationObject", "()Landroidx/compose/animation/core/Transition;", "childTransition", "getChildTransition$annotations", "()V", "getChildTransition", "label", "getLabel", "()Ljava/lang/String;", "states", "", "Landroidx/compose/ui/tooling/animation/AnimatedVisibilityState;", "getStates", "()Ljava/util/Set;", "type", "Landroidx/compose/animation/tooling/ComposeAnimationType;", "getType", "()Landroidx/compose/animation/tooling/ComposeAnimationType;", "ui-tooling_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AnimatedVisibilityComposeAnimation implements ComposeAnimation {
    private final Transition<Object> animationObject;
    private final String label;
    private final Set<AnimatedVisibilityState> states;
    private final ComposeAnimationType type;

    public static /* synthetic */ void getChildTransition$annotations() {
    }

    public AnimatedVisibilityComposeAnimation(Transition<Object> parent, String parentLabel) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.type = ComposeAnimationType.ANIMATED_VISIBILITY;
        this.animationObject = parent;
        this.states = SetsKt.setOf((Object[]) new AnimatedVisibilityState[]{AnimatedVisibilityState.m4310boximpl(AnimatedVisibilityState.INSTANCE.m4317getEnterq9NwIk0()), AnimatedVisibilityState.m4310boximpl(AnimatedVisibilityState.INSTANCE.m4318getExitq9NwIk0())});
        this.label = parentLabel;
    }

    public ComposeAnimationType getType() {
        return this.type;
    }

    /* renamed from: getAnimationObject, reason: merged with bridge method [inline-methods] */
    public Transition<Object> m4309getAnimationObject() {
        return this.animationObject;
    }

    public Set<AnimatedVisibilityState> getStates() {
        return this.states;
    }

    public String getLabel() {
        return this.label;
    }

    public final Transition<Object> getChildTransition() {
        Object orNull = CollectionsKt.getOrNull(m4309getAnimationObject().getTransitions(), 0);
        if (orNull instanceof Transition) {
            return (Transition) orNull;
        }
        return null;
    }
}
