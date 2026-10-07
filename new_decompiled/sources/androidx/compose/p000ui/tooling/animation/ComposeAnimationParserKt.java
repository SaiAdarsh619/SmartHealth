package androidx.compose.p000ui.tooling.animation;

import android.util.Log;
import androidx.compose.animation.core.Transition;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: ComposeAnimationParser.kt */
@Metadata(m286d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¨\u0006\u0006"}, m287d2 = {"parse", "Landroidx/compose/ui/tooling/animation/TransitionComposeAnimation;", "Landroidx/compose/animation/core/Transition;", "", "parseAnimatedVisibility", "Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;", "ui-tooling_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ComposeAnimationParserKt {
    public static final TransitionComposeAnimation parse(Transition<Object> transition) {
        Set states;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Log.d("ComposeAnimationParser", "Transition subscribed");
        Object initialState = transition.getSegment().getInitialState();
        Object[] enumConstants = initialState.getClass().getEnumConstants();
        if (enumConstants == null || (states = ArraysKt.toSet(enumConstants)) == null) {
            states = SetsKt.setOf(initialState);
        }
        String label = transition.getLabel();
        if (label == null) {
            label = Reflection.getOrCreateKotlinClass(initialState.getClass()).getSimpleName();
        }
        return new TransitionComposeAnimation(transition, states, label);
    }

    public static final AnimatedVisibilityComposeAnimation parseAnimatedVisibility(Transition<Object> transition) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Log.d("ComposeAnimationParser", "AnimatedVisibility transition subscribed");
        String label = transition.getLabel();
        if (label == null) {
            label = "AnimatedVisibility";
        }
        return new AnimatedVisibilityComposeAnimation(transition, label);
    }
}
