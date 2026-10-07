package androidx.compose.foundation.layout;

import android.graphics.Insets;
import android.os.CancellationSignal;
import android.view.View;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.Velocity;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* compiled from: WindowInsetsConnection.android.kt */
@Metadata(m286d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020!H\u0002J\u0006\u0010$\u001a\u00020!J1\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0017H\u0082@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001a\u0004\u0018\u00010\rH\u0082@ø\u0001\u0001¢\u0006\u0002\u0010-J\u0012\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u00100\u001a\u00020!2\u0006\u0010/\u001a\u00020\rH\u0016J)\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b3\u00104J-\u00105\u001a\u0002062\u0006\u00102\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:J!\u0010;\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b<\u0010=J%\u0010>\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010@J\u0018\u0010A\u001a\u00020!2\u0006\u0010/\u001a\u00020\r2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020!H\u0002J%\u0010E\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u0010F\u001a\u00020\u0019H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010HR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006I"}, m287d2 = {"Landroidx/compose/foundation/layout/WindowInsetsNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroid/view/WindowInsetsAnimationControlListener;", "windowInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "view", "Landroid/view/View;", "sideCalculator", "Landroidx/compose/foundation/layout/SideCalculator;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/layout/AndroidWindowInsets;Landroid/view/View;Landroidx/compose/foundation/layout/SideCalculator;Landroidx/compose/ui/unit/Density;)V", "animationController", "Landroid/view/WindowInsetsAnimationController;", "animationJob", "Lkotlinx/coroutines/Job;", "cancellationSignal", "Landroid/os/CancellationSignal;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "isControllerRequested", "", "partialConsumption", "", "getSideCalculator", "()Landroidx/compose/foundation/layout/SideCalculator;", "getView", "()Landroid/view/View;", "getWindowInsets", "()Landroidx/compose/foundation/layout/AndroidWindowInsets;", "adjustInsets", "", "inset", "animationEnded", "dispose", "fling", "Landroidx/compose/ui/unit/Velocity;", "available", "flingAmount", "towardShown", "fling-huYlsQE", "(JFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnimationController", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCancelled", "controller", "onFinished", "onPostFling", "consumed", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "onReady", "types", "", "requestAnimationController", "scroll", "scrollAmount", "scroll-8S9VItk", "(JF)J", "foundation-layout_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class WindowInsetsNestedScrollConnection implements NestedScrollConnection, WindowInsetsAnimationControlListener {
    private WindowInsetsAnimationController animationController;
    private Job animationJob;
    private final CancellationSignal cancellationSignal;
    private CancellableContinuation<? super WindowInsetsAnimationController> continuation;
    private final Density density;
    private boolean isControllerRequested;
    private float partialConsumption;
    private final SideCalculator sideCalculator;
    private final View view;
    private final AndroidWindowInsets windowInsets;

    public WindowInsetsNestedScrollConnection(AndroidWindowInsets windowInsets, View view, SideCalculator sideCalculator, Density density) {
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(sideCalculator, "sideCalculator");
        Intrinsics.checkNotNullParameter(density, "density");
        this.windowInsets = windowInsets;
        this.view = view;
        this.sideCalculator = sideCalculator;
        this.density = density;
        this.cancellationSignal = new CancellationSignal();
    }

    public final AndroidWindowInsets getWindowInsets() {
        return this.windowInsets;
    }

    public final View getView() {
        return this.view;
    }

    public final SideCalculator getSideCalculator() {
        return this.sideCalculator;
    }

    public final Density getDensity() {
        return this.density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestAnimationController() {
        if (!this.isControllerRequested) {
            this.isControllerRequested = true;
            WindowInsetsController windowInsetsController = this.view.getWindowInsetsController();
            if (windowInsetsController != null) {
                windowInsetsController.controlWindowInsetsAnimation(this.windowInsets.getType(), -1L, null, this.cancellationSignal, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getAnimationController(Continuation<? super WindowInsetsAnimationController> continuation) {
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (windowInsetsAnimationController != null) {
            return windowInsetsAnimationController;
        }
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        CancellableContinuationImpl continuation2 = cancellable$iv;
        this.continuation = continuation2;
        requestAnimationController();
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo656onPreScrollOzD1aCk(long available, int source) {
        return m820scroll8S9VItk(available, this.sideCalculator.hideMotion(Offset.m1760getXimpl(available), Offset.m1761getYimpl(available)));
    }

    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo655onPostScrollDzOQY0M(long consumed, long available, int source) {
        return m820scroll8S9VItk(available, this.sideCalculator.showMotion(Offset.m1760getXimpl(available), Offset.m1761getYimpl(available)));
    }

    /* renamed from: scroll-8S9VItk, reason: not valid java name */
    private final long m820scroll8S9VItk(long available, float scrollAmount) {
        Job it = this.animationJob;
        if (it != null) {
            Job.DefaultImpls.cancel$default(it, (CancellationException) null, 1, (Object) null);
            this.animationJob = null;
        }
        WindowInsetsAnimationController animationController = this.animationController;
        if (!(scrollAmount == 0.0f)) {
            if (this.windowInsets.isVisible() != (scrollAmount > 0.0f) || animationController != null) {
                if (animationController == null) {
                    this.partialConsumption = 0.0f;
                    requestAnimationController();
                    return this.sideCalculator.mo781consumedOffsetsMKHz9U(available);
                }
                SideCalculator sideCalculator = this.sideCalculator;
                Insets hiddenStateInsets = animationController.getHiddenStateInsets();
                Intrinsics.checkNotNullExpressionValue(hiddenStateInsets, "animationController.hiddenStateInsets");
                int hidden = sideCalculator.valueOf(hiddenStateInsets);
                SideCalculator sideCalculator2 = this.sideCalculator;
                Insets shownStateInsets = animationController.getShownStateInsets();
                Intrinsics.checkNotNullExpressionValue(shownStateInsets, "animationController.shownStateInsets");
                int shown = sideCalculator2.valueOf(shownStateInsets);
                Insets currentInsets = animationController.getCurrentInsets();
                Intrinsics.checkNotNullExpressionValue(currentInsets, "animationController.currentInsets");
                int current = this.sideCalculator.valueOf(currentInsets);
                int target = scrollAmount > 0.0f ? shown : hidden;
                if (current == target) {
                    this.partialConsumption = 0.0f;
                    return Offset.INSTANCE.m1776getZeroF1C5BW0();
                }
                float total = current + scrollAmount + this.partialConsumption;
                int next = RangesKt.coerceIn(MathKt.roundToInt(total), hidden, shown);
                this.partialConsumption = total - MathKt.roundToInt(total);
                if (next != current) {
                    animationController.setInsetsAndAlpha(this.sideCalculator.adjustInsets(currentInsets, next), 1.0f, 0.0f);
                }
                return this.sideCalculator.mo781consumedOffsetsMKHz9U(available);
            }
        }
        return Offset.INSTANCE.m1776getZeroF1C5BW0();
    }

    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public Object mo821onPreFlingQWom1Mo(long available, Continuation<? super Velocity> continuation) {
        return m819flinghuYlsQE(available, this.sideCalculator.hideMotion(Velocity.m4607getXimpl(available), Velocity.m4608getYimpl(available)), false, continuation);
    }

    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    public Object mo654onPostFlingRZ2iAVY(long consumed, long available, Continuation<? super Velocity> continuation) {
        return m819flinghuYlsQE(available, this.sideCalculator.showMotion(Velocity.m4607getXimpl(available), Velocity.m4608getYimpl(available)), true, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /* renamed from: fling-huYlsQE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m819flinghuYlsQE(long j, float flingAmount, boolean towardShown, Continuation<? super Velocity> continuation) {
        WindowInsetsNestedScrollConnection$fling$1 windowInsetsNestedScrollConnection$fling$1;
        long available;
        WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection;
        float flingAmount2;
        Object obj;
        WindowInsetsAnimationController animationController;
        int current;
        WindowInsetsAnimationController animationController2;
        Ref.FloatRef endVelocity;
        WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection2;
        long available2;
        WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection3;
        long available3;
        if (continuation instanceof WindowInsetsNestedScrollConnection$fling$1) {
            WindowInsetsNestedScrollConnection$fling$1 windowInsetsNestedScrollConnection$fling$12 = (WindowInsetsNestedScrollConnection$fling$1) continuation;
            if ((windowInsetsNestedScrollConnection$fling$12.label & Integer.MIN_VALUE) != 0) {
                windowInsetsNestedScrollConnection$fling$12.label -= Integer.MIN_VALUE;
                windowInsetsNestedScrollConnection$fling$1 = windowInsetsNestedScrollConnection$fling$12;
                Object $result = windowInsetsNestedScrollConnection$fling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (windowInsetsNestedScrollConnection$fling$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        available = j;
                        Job job = this.animationJob;
                        if (job != null) {
                            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        }
                        this.animationJob = null;
                        this.partialConsumption = 0.0f;
                        if (((flingAmount == 0.0f) && !towardShown) || (this.animationController == null && this.windowInsets.isVisible() == towardShown)) {
                            return Velocity.m4598boximpl(Velocity.INSTANCE.m4618getZero9UxMQ8M());
                        }
                        windowInsetsNestedScrollConnection$fling$1.L$0 = this;
                        windowInsetsNestedScrollConnection$fling$1.J$0 = available;
                        windowInsetsNestedScrollConnection$fling$1.F$0 = flingAmount;
                        windowInsetsNestedScrollConnection$fling$1.label = 1;
                        Object animationController3 = getAnimationController(windowInsetsNestedScrollConnection$fling$1);
                        if (animationController3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        windowInsetsNestedScrollConnection = this;
                        flingAmount2 = flingAmount;
                        obj = animationController3;
                        animationController = (WindowInsetsAnimationController) obj;
                        if (animationController != null) {
                            return Velocity.m4598boximpl(Velocity.INSTANCE.m4618getZero9UxMQ8M());
                        }
                        SideCalculator sideCalculator = windowInsetsNestedScrollConnection.sideCalculator;
                        Insets hiddenStateInsets = animationController.getHiddenStateInsets();
                        Intrinsics.checkNotNullExpressionValue(hiddenStateInsets, "animationController.hiddenStateInsets");
                        int hidden = sideCalculator.valueOf(hiddenStateInsets);
                        SideCalculator sideCalculator2 = windowInsetsNestedScrollConnection.sideCalculator;
                        Insets shownStateInsets = animationController.getShownStateInsets();
                        Intrinsics.checkNotNullExpressionValue(shownStateInsets, "animationController.shownStateInsets");
                        int shown = sideCalculator2.valueOf(shownStateInsets);
                        Insets currentInsets = animationController.getCurrentInsets();
                        Intrinsics.checkNotNullExpressionValue(currentInsets, "animationController.currentInsets");
                        int current2 = windowInsetsNestedScrollConnection.sideCalculator.valueOf(currentInsets);
                        if ((flingAmount2 <= 0.0f && current2 == hidden) || (flingAmount2 >= 0.0f && current2 == shown)) {
                            animationController.finish(current2 == shown);
                            windowInsetsNestedScrollConnection.animationController = null;
                            return Velocity.m4598boximpl(Velocity.INSTANCE.m4618getZero9UxMQ8M());
                        }
                        SplineBasedFloatDecayAnimationSpec spec = new SplineBasedFloatDecayAnimationSpec(windowInsetsNestedScrollConnection.density);
                        float distance = current2 + spec.flingDistance(flingAmount2);
                        float endPercent = (distance - hidden) / (shown - hidden);
                        boolean targetShown = endPercent > 0.5f;
                        int target = targetShown ? shown : hidden;
                        if (distance > shown) {
                            current = current2;
                            animationController2 = animationController;
                        } else {
                            if (distance >= hidden) {
                                WindowInsetsNestedScrollConnection$fling$3 windowInsetsNestedScrollConnection$fling$3 = new WindowInsetsNestedScrollConnection$fling$3(windowInsetsNestedScrollConnection, current2, target, flingAmount2, animationController, targetShown, null);
                                windowInsetsNestedScrollConnection$fling$1.L$0 = windowInsetsNestedScrollConnection;
                                windowInsetsNestedScrollConnection$fling$1.J$0 = available;
                                windowInsetsNestedScrollConnection$fling$1.label = 3;
                                if (CoroutineScopeKt.coroutineScope(windowInsetsNestedScrollConnection$fling$3, windowInsetsNestedScrollConnection$fling$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                windowInsetsNestedScrollConnection3 = windowInsetsNestedScrollConnection;
                                available3 = available;
                                return Velocity.m4598boximpl(windowInsetsNestedScrollConnection3.sideCalculator.mo782consumedVelocityQWom1Mo(available3, 0.0f));
                            }
                            current = current2;
                            animationController2 = animationController;
                        }
                        Ref.FloatRef endVelocity2 = new Ref.FloatRef();
                        WindowInsetsNestedScrollConnection$fling$2 windowInsetsNestedScrollConnection$fling$2 = new WindowInsetsNestedScrollConnection$fling$2(windowInsetsNestedScrollConnection, current, flingAmount2, spec, hidden, shown, endVelocity2, animationController2, targetShown, null);
                        windowInsetsNestedScrollConnection$fling$1.L$0 = windowInsetsNestedScrollConnection;
                        windowInsetsNestedScrollConnection$fling$1.L$1 = endVelocity2;
                        windowInsetsNestedScrollConnection$fling$1.J$0 = available;
                        windowInsetsNestedScrollConnection$fling$1.label = 2;
                        if (CoroutineScopeKt.coroutineScope(windowInsetsNestedScrollConnection$fling$2, windowInsetsNestedScrollConnection$fling$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        endVelocity = endVelocity2;
                        windowInsetsNestedScrollConnection2 = windowInsetsNestedScrollConnection;
                        available2 = available;
                        return Velocity.m4598boximpl(windowInsetsNestedScrollConnection2.sideCalculator.mo782consumedVelocityQWom1Mo(available2, endVelocity.element));
                    case 1:
                        flingAmount2 = windowInsetsNestedScrollConnection$fling$1.F$0;
                        long available4 = windowInsetsNestedScrollConnection$fling$1.J$0;
                        WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection4 = (WindowInsetsNestedScrollConnection) windowInsetsNestedScrollConnection$fling$1.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        windowInsetsNestedScrollConnection = windowInsetsNestedScrollConnection4;
                        available = available4;
                        animationController = (WindowInsetsAnimationController) obj;
                        if (animationController != null) {
                        }
                        break;
                    case 2:
                        available2 = windowInsetsNestedScrollConnection$fling$1.J$0;
                        endVelocity = (Ref.FloatRef) windowInsetsNestedScrollConnection$fling$1.L$1;
                        windowInsetsNestedScrollConnection2 = (WindowInsetsNestedScrollConnection) windowInsetsNestedScrollConnection$fling$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return Velocity.m4598boximpl(windowInsetsNestedScrollConnection2.sideCalculator.mo782consumedVelocityQWom1Mo(available2, endVelocity.element));
                    case 3:
                        available3 = windowInsetsNestedScrollConnection$fling$1.J$0;
                        windowInsetsNestedScrollConnection3 = (WindowInsetsNestedScrollConnection) windowInsetsNestedScrollConnection$fling$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return Velocity.m4598boximpl(windowInsetsNestedScrollConnection3.sideCalculator.mo782consumedVelocityQWom1Mo(available3, 0.0f));
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        windowInsetsNestedScrollConnection$fling$1 = new WindowInsetsNestedScrollConnection$fling$1(this, continuation);
        Object $result2 = windowInsetsNestedScrollConnection$fling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (windowInsetsNestedScrollConnection$fling$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustInsets(float inset) {
        WindowInsetsAnimationController it = this.animationController;
        if (it != null) {
            Insets currentInsets = it.getCurrentInsets();
            Intrinsics.checkNotNullExpressionValue(currentInsets, "it.currentInsets");
            Insets nextInsets = this.sideCalculator.adjustInsets(currentInsets, MathKt.roundToInt(inset));
            it.setInsetsAndAlpha(nextInsets, 1.0f, 0.0f);
        }
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onReady(WindowInsetsAnimationController controller, int types) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.animationController = controller;
        this.isControllerRequested = false;
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume(controller, new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$onReady$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            });
        }
        this.continuation = null;
    }

    public final void dispose() {
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume(null, new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$dispose$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            });
        }
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        WindowInsetsAnimationController animationController = this.animationController;
        if (animationController != null) {
            boolean visible = !Intrinsics.areEqual(animationController.getCurrentInsets(), animationController.getHiddenStateInsets());
            animationController.finish(visible);
        }
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onFinished(WindowInsetsAnimationController controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        animationEnded();
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onCancelled(WindowInsetsAnimationController controller) {
        animationEnded();
    }

    private final void animationEnded() {
        WindowInsetsAnimationController windowInsetsAnimationController;
        WindowInsetsAnimationController windowInsetsAnimationController2 = this.animationController;
        if ((windowInsetsAnimationController2 != null && windowInsetsAnimationController2.isReady()) && (windowInsetsAnimationController = this.animationController) != null) {
            windowInsetsAnimationController.finish(this.windowInsets.isVisible());
        }
        this.animationController = null;
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume(null, new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$animationEnded$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            });
        }
        this.continuation = null;
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.animationJob = null;
        this.partialConsumption = 0.0f;
        this.isControllerRequested = false;
    }
}
