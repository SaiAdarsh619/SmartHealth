package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.material.MenuKt;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.graphics.ClipOp;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.drawscope.DrawContext;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.graphics.drawscope.DrawTransform;
import androidx.compose.p000ui.util.MathHelpersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* compiled from: RippleAnimation.kt */
@Metadata(m286d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\"\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0011\u0010#\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0011\u0010%\u001a\u00020\u0019H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0011\u0010&\u001a\u00020\u0019H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0006\u0010'\u001a\u00020\u0019J\u001f\u0010(\u001a\u00020\u0019*\u00020)2\u0006\u0010*\u001a\u00020+ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001eR\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u0019\u0010!\u001a\u0004\u0018\u00010\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 \u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, m287d2 = {"Landroidx/compose/material/ripple/RippleAnimation;", "", HttpHeaders.ReferrerPolicyValues.ORIGIN, "Landroidx/compose/ui/geometry/Offset;", "radius", "Landroidx/compose/ui/unit/Dp;", "bounded", "", "(Landroidx/compose/ui/geometry/Offset;FZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "animatedCenterPercent", "animatedRadiusPercent", "<set-?>", "finishRequested", "getFinishRequested", "()Z", "setFinishRequested", "(Z)V", "finishRequested$delegate", "Landroidx/compose/runtime/MutableState;", "finishSignalDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "finishedFadingIn", "getFinishedFadingIn", "setFinishedFadingIn", "finishedFadingIn$delegate", "F", "startRadius", "Ljava/lang/Float;", "targetCenter", "targetRadius", "animate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fadeIn", "fadeOut", "finish", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "color", "Landroidx/compose/ui/graphics/Color;", "draw-4WTKRHQ", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;J)V", "material-ripple_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class RippleAnimation {
    private final Animatable<Float, AnimationVector1D> animatedAlpha;
    private final Animatable<Float, AnimationVector1D> animatedCenterPercent;
    private final Animatable<Float, AnimationVector1D> animatedRadiusPercent;
    private final boolean bounded;

    /* renamed from: finishRequested$delegate, reason: from kotlin metadata */
    private final MutableState finishRequested;
    private final CompletableDeferred<Unit> finishSignalDeferred;

    /* renamed from: finishedFadingIn$delegate, reason: from kotlin metadata */
    private final MutableState finishedFadingIn;
    private Offset origin;
    private final float radius;
    private Float startRadius;
    private Offset targetCenter;
    private Float targetRadius;

    public /* synthetic */ RippleAnimation(Offset offset, float f, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(offset, f, z);
    }

    private RippleAnimation(Offset origin, float radius, boolean bounded) {
        this.origin = origin;
        this.radius = radius;
        this.bounded = bounded;
        this.animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.animatedRadiusPercent = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.animatedCenterPercent = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.finishSignalDeferred = CompletableDeferredKt.CompletableDeferred((Job) null);
        this.finishedFadingIn = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.finishRequested = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    }

    private final boolean getFinishedFadingIn() {
        State $this$getValue$iv = this.finishedFadingIn;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private final void setFinishedFadingIn(boolean z) {
        MutableState $this$setValue$iv = this.finishedFadingIn;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    private final boolean getFinishRequested() {
        State $this$getValue$iv = this.finishRequested;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private final void setFinishRequested(boolean z) {
        MutableState $this$setValue$iv = this.finishRequested;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object animate(Continuation<? super Unit> continuation) {
        RippleAnimation$animate$1 rippleAnimation$animate$1;
        RippleAnimation$animate$1 rippleAnimation$animate$12;
        RippleAnimation rippleAnimation;
        CompletableDeferred<Unit> completableDeferred;
        if (continuation instanceof RippleAnimation$animate$1) {
            rippleAnimation$animate$1 = (RippleAnimation$animate$1) continuation;
            if ((rippleAnimation$animate$1.label & Integer.MIN_VALUE) != 0) {
                rippleAnimation$animate$1.label -= Integer.MIN_VALUE;
                rippleAnimation$animate$12 = rippleAnimation$animate$1;
                Object $result = rippleAnimation$animate$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rippleAnimation$animate$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        rippleAnimation = this;
                        rippleAnimation$animate$12.L$0 = rippleAnimation;
                        rippleAnimation$animate$12.label = 1;
                        if (rippleAnimation.fadeIn(rippleAnimation$animate$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        rippleAnimation.setFinishedFadingIn(true);
                        completableDeferred = rippleAnimation.finishSignalDeferred;
                        rippleAnimation$animate$12.L$0 = rippleAnimation;
                        rippleAnimation$animate$12.label = 2;
                        if (completableDeferred.await(rippleAnimation$animate$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        rippleAnimation$animate$12.L$0 = null;
                        rippleAnimation$animate$12.label = 3;
                        if (rippleAnimation.fadeOut(rippleAnimation$animate$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        rippleAnimation = (RippleAnimation) rippleAnimation$animate$12.L$0;
                        ResultKt.throwOnFailure($result);
                        rippleAnimation.setFinishedFadingIn(true);
                        completableDeferred = rippleAnimation.finishSignalDeferred;
                        rippleAnimation$animate$12.L$0 = rippleAnimation;
                        rippleAnimation$animate$12.label = 2;
                        if (completableDeferred.await(rippleAnimation$animate$12) == coroutine_suspended) {
                        }
                        rippleAnimation$animate$12.L$0 = null;
                        rippleAnimation$animate$12.label = 3;
                        if (rippleAnimation.fadeOut(rippleAnimation$animate$12) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        rippleAnimation = (RippleAnimation) rippleAnimation$animate$12.L$0;
                        ResultKt.throwOnFailure($result);
                        rippleAnimation$animate$12.L$0 = null;
                        rippleAnimation$animate$12.label = 3;
                        if (rippleAnimation.fadeOut(rippleAnimation$animate$12) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 3:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        rippleAnimation$animate$1 = new RippleAnimation$animate$1(this, continuation);
        rippleAnimation$animate$12 = rippleAnimation$animate$1;
        Object $result2 = rippleAnimation$animate$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rippleAnimation$animate$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fadeIn(Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new RippleAnimation$fadeIn$2(this, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fadeOut(Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new RippleAnimation$fadeOut$2(this, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public final void finish() {
        setFinishRequested(true);
        this.finishSignalDeferred.complete(Unit.INSTANCE);
    }

    /* renamed from: draw-4WTKRHQ, reason: not valid java name */
    public final void m1611draw4WTKRHQ(DrawScope draw, long color) {
        long modulatedColor;
        Intrinsics.checkNotNullParameter(draw, "$this$draw");
        if (this.startRadius == null) {
            this.startRadius = Float.valueOf(RippleAnimationKt.m1613getRippleStartRadiusuvyYCjk(draw.mo2490getSizeNHjbRc()));
        }
        if (this.targetRadius == null) {
            float $this$isUnspecified$iv = this.radius;
            this.targetRadius = Float.isNaN($this$isUnspecified$iv) ? Float.valueOf(RippleAnimationKt.m1612getRippleEndRadiuscSwnlzA(draw, this.bounded, draw.mo2490getSizeNHjbRc())) : Float.valueOf(draw.mo648toPx0680j_4(this.radius));
        }
        if (this.origin == null) {
            this.origin = Offset.m1749boximpl(draw.mo2489getCenterF1C5BW0());
        }
        if (this.targetCenter == null) {
            this.targetCenter = Offset.m1749boximpl(OffsetKt.Offset(Size.m1829getWidthimpl(draw.mo2490getSizeNHjbRc()) / 2.0f, Size.m1826getHeightimpl(draw.mo2490getSizeNHjbRc()) / 2.0f));
        }
        float alpha = (!getFinishRequested() || getFinishedFadingIn()) ? this.animatedAlpha.getValue().floatValue() : 1.0f;
        Float f = this.startRadius;
        Intrinsics.checkNotNull(f);
        float floatValue = f.floatValue();
        Float f2 = this.targetRadius;
        Intrinsics.checkNotNull(f2);
        float radius = MathHelpersKt.lerp(floatValue, f2.floatValue(), this.animatedRadiusPercent.getValue().floatValue());
        Offset offset = this.origin;
        Intrinsics.checkNotNull(offset);
        float m1760getXimpl = Offset.m1760getXimpl(offset.getPackedValue());
        Offset offset2 = this.targetCenter;
        Intrinsics.checkNotNull(offset2);
        float lerp = MathHelpersKt.lerp(m1760getXimpl, Offset.m1760getXimpl(offset2.getPackedValue()), this.animatedCenterPercent.getValue().floatValue());
        Offset offset3 = this.origin;
        Intrinsics.checkNotNull(offset3);
        float m1761getYimpl = Offset.m1761getYimpl(offset3.getPackedValue());
        Offset offset4 = this.targetCenter;
        Intrinsics.checkNotNull(offset4);
        long centerOffset = OffsetKt.Offset(lerp, MathHelpersKt.lerp(m1761getYimpl, Offset.m1761getYimpl(offset4.getPackedValue()), this.animatedCenterPercent.getValue().floatValue()));
        modulatedColor = Color.m1994copywmQWz5c(color, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(color) : Color.m1998getAlphaimpl(color) * alpha, (r12 & 2) != 0 ? Color.m2002getRedimpl(color) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(color) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(color) : 0.0f);
        if (!this.bounded) {
            DrawScope.m2472drawCircleVaOC9Bg$default(draw, modulatedColor, radius, centerOffset, 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
            return;
        }
        float right$iv = Size.m1829getWidthimpl(draw.mo2490getSizeNHjbRc());
        float bottom$iv = Size.m1826getHeightimpl(draw.mo2490getSizeNHjbRc());
        int clipOp$iv = ClipOp.INSTANCE.m1985getIntersectrtfAjoo();
        DrawContext $this$withTransform_u24lambda_u2d6$iv$iv = draw.getDrawContext();
        long previousSize$iv$iv = $this$withTransform_u24lambda_u2d6$iv$iv.mo2415getSizeNHjbRc();
        $this$withTransform_u24lambda_u2d6$iv$iv.getCanvas().save();
        DrawTransform $this$clipRect_rOu3jXo_u24lambda_u2d4$iv = $this$withTransform_u24lambda_u2d6$iv$iv.getTransform();
        $this$clipRect_rOu3jXo_u24lambda_u2d4$iv.mo2418clipRectN_I0leg(0.0f, 0.0f, right$iv, bottom$iv, clipOp$iv);
        DrawScope.m2472drawCircleVaOC9Bg$default(draw, modulatedColor, radius, centerOffset, 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
        $this$withTransform_u24lambda_u2d6$iv$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u2d6$iv$iv.mo2416setSizeuvyYCjk(previousSize$iv$iv);
    }
}
