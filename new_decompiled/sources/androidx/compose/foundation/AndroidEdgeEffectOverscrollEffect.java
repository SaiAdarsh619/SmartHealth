package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.geometry.SizeKt;
import androidx.compose.p000ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p000ui.graphics.Canvas;
import androidx.compose.p000ui.graphics.ColorKt;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p000ui.input.pointer.PointerId;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p000ui.layout.OnRemeasuredModifierKt;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.IntSizeKt;
import androidx.compose.p000ui.unit.Velocity;
import androidx.compose.p000ui.unit.VelocityKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: AndroidOverscroll.kt */
@Metadata(m286d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00101\u001a\u00020&H\u0002J!\u00102\u001a\u00020&2\u0006\u00103\u001a\u000204H\u0096@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b5\u00106J-\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020*2\u0006\u0010:\u001a\u00020;H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=J!\u0010>\u001a\u0002042\u0006\u00103\u001a\u000204H\u0096@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b?\u00106J%\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020*2\u0006\u0010:\u001a\u00020;H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\b\u0010D\u001a\u00020&H\u0002J%\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020*H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ%\u0010K\u001a\u00020F2\u0006\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020*H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010JJ%\u0010M\u001a\u00020F2\u0006\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020*H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010JJ%\u0010O\u001a\u00020F2\u0006\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020*H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010JJ\u001d\u0010Q\u001a\u00020\u00142\u0006\u0010R\u001a\u00020*H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010TJ\b\u0010U\u001a\u00020\u0014H\u0002J \u0010V\u001a\u00020\u0014*\u00020W2\u0006\u0010X\u001a\u00020\t2\n\u0010Y\u001a\u00060Zj\u0002`[H\u0002J \u0010\\\u001a\u00020\u0014*\u00020W2\u0006\u0010]\u001a\u00020\t2\n\u0010Y\u001a\u00060Zj\u0002`[H\u0002J\n\u0010^\u001a\u00020&*\u00020WJ \u0010_\u001a\u00020\u0014*\u00020W2\u0006\u0010`\u001a\u00020\t2\n\u0010Y\u001a\u00060Zj\u0002`[H\u0002J \u0010a\u001a\u00020\u0014*\u00020W2\u0006\u0010b\u001a\u00020\t2\n\u0010Y\u001a\u00060Zj\u0002`[H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\u00020\rX\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\u00148\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR&\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0018R\u000e\u0010!\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0019\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020&0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006c"}, m287d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "context", "Landroid/content/Context;", "overscrollConfig", "Landroidx/compose/foundation/OverscrollConfiguration;", "(Landroid/content/Context;Landroidx/compose/foundation/OverscrollConfiguration;)V", "allEffects", "", "Landroid/widget/EdgeEffect;", "bottomEffect", "bottomEffectNegation", "containerSize", "Landroidx/compose/ui/geometry/Size;", "J", "effectModifier", "Landroidx/compose/ui/Modifier;", "getEffectModifier", "()Landroidx/compose/ui/Modifier;", "invalidationEnabled", "", "getInvalidationEnabled$foundation_release$annotations", "()V", "getInvalidationEnabled$foundation_release", "()Z", "setInvalidationEnabled$foundation_release", "(Z)V", "value", "isEnabled", "setEnabled", "isEnabledState", "Landroidx/compose/runtime/MutableState;", "isInProgress", "leftEffect", "leftEffectNegation", "onNewSize", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "redrawSignal", "rightEffect", "rightEffectNegation", "scrollCycleInProgress", "topEffect", "topEffectNegation", "animateToRelease", "consumePostFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "consumePostFling-sF-c-tU", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumePostScroll", "initialDragDelta", "overscrollDelta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "consumePostScroll-OMhpSzk", "(JJI)V", "consumePreFling", "consumePreFling-QWom1Mo", "consumePreScroll", "scrollDelta", "consumePreScroll-OzD1aCk", "(JI)J", "invalidateOverscroll", "pullBottom", "", "scroll", "displacement", "pullBottom-0a9Yr6o", "(JJ)F", "pullLeft", "pullLeft-0a9Yr6o", "pullRight", "pullRight-0a9Yr6o", "pullTop", "pullTop-0a9Yr6o", "releaseOppositeOverscroll", "delta", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "stopOverscrollAnimation", "drawBottom", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "bottom", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawLeft", "left", "drawOverscroll", "drawRight", "right", "drawTop", "top", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    private final List<EdgeEffect> allEffects;
    private final EdgeEffect bottomEffect;
    private final EdgeEffect bottomEffectNegation;
    private long containerSize;
    private final Modifier effectModifier;
    private boolean invalidationEnabled;
    private boolean isEnabled;
    private final MutableState<Boolean> isEnabledState;
    private final EdgeEffect leftEffect;
    private final EdgeEffect leftEffectNegation;
    private final Function1<IntSize, Unit> onNewSize;
    private final OverscrollConfiguration overscrollConfig;
    private PointerId pointerId;
    private Offset pointerPosition;
    private final MutableState<Unit> redrawSignal;
    private final EdgeEffect rightEffect;
    private final EdgeEffect rightEffectNegation;
    private boolean scrollCycleInProgress;
    private final EdgeEffect topEffect;
    private final EdgeEffect topEffectNegation;

    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }

    public AndroidEdgeEffectOverscrollEffect(Context context, OverscrollConfiguration overscrollConfig) {
        Modifier modifier;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(overscrollConfig, "overscrollConfig");
        this.overscrollConfig = overscrollConfig;
        this.topEffect = EdgeEffectCompat.INSTANCE.create(context, null);
        this.bottomEffect = EdgeEffectCompat.INSTANCE.create(context, null);
        this.leftEffect = EdgeEffectCompat.INSTANCE.create(context, null);
        this.rightEffect = EdgeEffectCompat.INSTANCE.create(context, null);
        this.allEffects = CollectionsKt.listOf((Object[]) new EdgeEffect[]{this.leftEffect, this.topEffect, this.rightEffect, this.bottomEffect});
        this.topEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        this.bottomEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        this.leftEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        this.rightEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        List $this$fastForEach$iv = this.allEffects;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            EdgeEffect it = (EdgeEffect) item$iv;
            it.setColor(ColorKt.m2051toArgb8_81llA(this.overscrollConfig.getGlowColor()));
        }
        this.redrawSignal = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.INSTANCE.m1838getZeroNHjbRc();
        this.isEnabledState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.onNewSize = new Function1<IntSize, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$onNewSize$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                m491invokeozmzZPI(intSize.getPackedValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-ozmzZPI, reason: not valid java name */
            public final void m491invokeozmzZPI(long size2) {
                long j;
                EdgeEffect edgeEffect;
                EdgeEffect edgeEffect2;
                EdgeEffect edgeEffect3;
                EdgeEffect edgeEffect4;
                EdgeEffect edgeEffect5;
                EdgeEffect edgeEffect6;
                EdgeEffect edgeEffect7;
                EdgeEffect edgeEffect8;
                long m4552toSizeozmzZPI = IntSizeKt.m4552toSizeozmzZPI(size2);
                j = AndroidEdgeEffectOverscrollEffect.this.containerSize;
                boolean differentSize = !Size.m1825equalsimpl0(m4552toSizeozmzZPI, j);
                AndroidEdgeEffectOverscrollEffect.this.containerSize = IntSizeKt.m4552toSizeozmzZPI(size2);
                if (differentSize) {
                    edgeEffect = AndroidEdgeEffectOverscrollEffect.this.topEffect;
                    edgeEffect.setSize(IntSize.m4542getWidthimpl(size2), IntSize.m4541getHeightimpl(size2));
                    edgeEffect2 = AndroidEdgeEffectOverscrollEffect.this.bottomEffect;
                    edgeEffect2.setSize(IntSize.m4542getWidthimpl(size2), IntSize.m4541getHeightimpl(size2));
                    edgeEffect3 = AndroidEdgeEffectOverscrollEffect.this.leftEffect;
                    edgeEffect3.setSize(IntSize.m4541getHeightimpl(size2), IntSize.m4542getWidthimpl(size2));
                    edgeEffect4 = AndroidEdgeEffectOverscrollEffect.this.rightEffect;
                    edgeEffect4.setSize(IntSize.m4541getHeightimpl(size2), IntSize.m4542getWidthimpl(size2));
                    edgeEffect5 = AndroidEdgeEffectOverscrollEffect.this.topEffectNegation;
                    edgeEffect5.setSize(IntSize.m4542getWidthimpl(size2), IntSize.m4541getHeightimpl(size2));
                    edgeEffect6 = AndroidEdgeEffectOverscrollEffect.this.bottomEffectNegation;
                    edgeEffect6.setSize(IntSize.m4542getWidthimpl(size2), IntSize.m4541getHeightimpl(size2));
                    edgeEffect7 = AndroidEdgeEffectOverscrollEffect.this.leftEffectNegation;
                    edgeEffect7.setSize(IntSize.m4541getHeightimpl(size2), IntSize.m4542getWidthimpl(size2));
                    edgeEffect8 = AndroidEdgeEffectOverscrollEffect.this.rightEffectNegation;
                    edgeEffect8.setSize(IntSize.m4541getHeightimpl(size2), IntSize.m4542getWidthimpl(size2));
                }
                if (differentSize) {
                    AndroidEdgeEffectOverscrollEffect.this.invalidateOverscroll();
                    AndroidEdgeEffectOverscrollEffect.this.animateToRelease();
                }
            }
        };
        Modifier.Companion companion = Modifier.INSTANCE;
        modifier = AndroidOverscrollKt.StretchOverscrollNonClippingLayer;
        this.effectModifier = OnRemeasuredModifierKt.onSizeChanged(SuspendingPointerInputFilterKt.pointerInput(companion.then(modifier), Unit.INSTANCE, new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this, null)), this.onNewSize).then(new DrawOverscrollModifier(this, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1
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
                $this$null.setName("overscroll");
                $this$null.setValue(AndroidEdgeEffectOverscrollEffect.this);
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    /* renamed from: getInvalidationEnabled$foundation_release, reason: from getter */
    public final boolean getInvalidationEnabled() {
        return this.invalidationEnabled;
    }

    public final void setInvalidationEnabled$foundation_release(boolean z) {
        this.invalidationEnabled = z;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: consumePreScroll-OzD1aCk, reason: not valid java name */
    public long mo490consumePreScrollOzD1aCk(long scrollDelta, int source) {
        float consumedPixelsY;
        if (Size.m1831isEmptyimpl(this.containerSize)) {
            return Offset.INSTANCE.m1776getZeroF1C5BW0();
        }
        if (!this.scrollCycleInProgress) {
            stopOverscrollAnimation();
            this.scrollCycleInProgress = true;
        }
        Offset offset = this.pointerPosition;
        long pointer = offset != null ? offset.getPackedValue() : SizeKt.m1839getCenteruvyYCjk(this.containerSize);
        float f = 0.0f;
        if (Offset.m1761getYimpl(scrollDelta) == 0.0f) {
            consumedPixelsY = 0.0f;
        } else {
            if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) == 0.0f) {
                if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f)) {
                    consumedPixelsY = m482pullBottom0a9Yr6o(scrollDelta, pointer);
                    if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f) {
                        this.bottomEffect.onRelease();
                    }
                } else {
                    consumedPixelsY = 0.0f;
                }
            } else {
                consumedPixelsY = m485pullTop0a9Yr6o(scrollDelta, pointer);
                if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) == 0.0f) {
                    this.topEffect.onRelease();
                }
            }
        }
        if (!(Offset.m1760getXimpl(scrollDelta) == 0.0f)) {
            if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f) {
                if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f)) {
                    float m484pullRight0a9Yr6o = m484pullRight0a9Yr6o(scrollDelta, pointer);
                    if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f) {
                        this.rightEffect.onRelease();
                    }
                    f = m484pullRight0a9Yr6o;
                }
            } else {
                float m483pullLeft0a9Yr6o = m483pullLeft0a9Yr6o(scrollDelta, pointer);
                if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f) {
                    this.leftEffect.onRelease();
                }
                f = m483pullLeft0a9Yr6o;
            }
        }
        float consumedPixelsX = f;
        long consumedOffset = OffsetKt.Offset(consumedPixelsX, consumedPixelsY);
        if (!Offset.m1757equalsimpl0(consumedOffset, Offset.INSTANCE.m1776getZeroF1C5BW0())) {
            invalidateOverscroll();
        }
        return consumedOffset;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: consumePostScroll-OMhpSzk, reason: not valid java name */
    public void mo488consumePostScrollOMhpSzk(long initialDragDelta, long overscrollDelta, int source) {
        if (Size.m1831isEmptyimpl(this.containerSize)) {
            return;
        }
        boolean needsInvalidation = false;
        boolean z = true;
        if (NestedScrollSource.m3258equalsimpl0(source, NestedScrollSource.INSTANCE.m3263getDragWNlRxjI())) {
            Offset offset = this.pointerPosition;
            long pointer = offset != null ? offset.getPackedValue() : SizeKt.m1839getCenteruvyYCjk(this.containerSize);
            if (Offset.m1760getXimpl(overscrollDelta) > 0.0f) {
                m483pullLeft0a9Yr6o(overscrollDelta, pointer);
            } else if (Offset.m1760getXimpl(overscrollDelta) < 0.0f) {
                m484pullRight0a9Yr6o(overscrollDelta, pointer);
            }
            if (Offset.m1761getYimpl(overscrollDelta) > 0.0f) {
                m485pullTop0a9Yr6o(overscrollDelta, pointer);
            } else if (Offset.m1761getYimpl(overscrollDelta) < 0.0f) {
                m482pullBottom0a9Yr6o(overscrollDelta, pointer);
            }
            needsInvalidation = !Offset.m1757equalsimpl0(overscrollDelta, Offset.INSTANCE.m1776getZeroF1C5BW0());
        }
        if (!m486releaseOppositeOverscrollk4lQ0M(initialDragDelta) && !needsInvalidation) {
            z = false;
        }
        boolean needsInvalidation2 = z;
        if (needsInvalidation2) {
            invalidateOverscroll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a8  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: consumePreFling-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo489consumePreFlingQWom1Mo(long velocity, Continuation<? super Velocity> continuation) {
        float consumedX;
        long consumed;
        if (Size.m1831isEmptyimpl(this.containerSize)) {
            return Velocity.m4598boximpl(Velocity.INSTANCE.m4618getZero9UxMQ8M());
        }
        float consumedY = 0.0f;
        if (Velocity.m4607getXimpl(velocity) > 0.0f) {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f)) {
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.leftEffect, MathKt.roundToInt(Velocity.m4607getXimpl(velocity)));
                consumedX = Velocity.m4607getXimpl(velocity);
                if (Velocity.m4608getYimpl(velocity) > 0.0f) {
                    if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) == 0.0f)) {
                        EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.topEffect, MathKt.roundToInt(Velocity.m4608getYimpl(velocity)));
                        consumedY = Velocity.m4608getYimpl(velocity);
                        consumed = VelocityKt.Velocity(consumedX, consumedY);
                        if (!Velocity.m4606equalsimpl0(consumed, Velocity.INSTANCE.m4618getZero9UxMQ8M())) {
                            invalidateOverscroll();
                        }
                        return Velocity.m4598boximpl(consumed);
                    }
                }
                if (Velocity.m4608getYimpl(velocity) < 0.0f) {
                    if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f)) {
                        EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.bottomEffect, -MathKt.roundToInt(Velocity.m4608getYimpl(velocity)));
                        consumedY = Velocity.m4608getYimpl(velocity);
                    }
                }
                consumed = VelocityKt.Velocity(consumedX, consumedY);
                if (!Velocity.m4606equalsimpl0(consumed, Velocity.INSTANCE.m4618getZero9UxMQ8M())) {
                }
                return Velocity.m4598boximpl(consumed);
            }
        }
        if (Velocity.m4607getXimpl(velocity) < 0.0f) {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f)) {
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.rightEffect, -MathKt.roundToInt(Velocity.m4607getXimpl(velocity)));
                consumedX = Velocity.m4607getXimpl(velocity);
                if (Velocity.m4608getYimpl(velocity) > 0.0f) {
                }
                if (Velocity.m4608getYimpl(velocity) < 0.0f) {
                }
                consumed = VelocityKt.Velocity(consumedX, consumedY);
                if (!Velocity.m4606equalsimpl0(consumed, Velocity.INSTANCE.m4618getZero9UxMQ8M())) {
                }
                return Velocity.m4598boximpl(consumed);
            }
        }
        consumedX = 0.0f;
        if (Velocity.m4608getYimpl(velocity) > 0.0f) {
        }
        if (Velocity.m4608getYimpl(velocity) < 0.0f) {
        }
        consumed = VelocityKt.Velocity(consumedX, consumedY);
        if (!Velocity.m4606equalsimpl0(consumed, Velocity.INSTANCE.m4618getZero9UxMQ8M())) {
        }
        return Velocity.m4598boximpl(consumed);
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: consumePostFling-sF-c-tU, reason: not valid java name */
    public Object mo487consumePostFlingsFctU(long velocity, Continuation<? super Unit> continuation) {
        if (Size.m1831isEmptyimpl(this.containerSize)) {
            return Unit.INSTANCE;
        }
        this.scrollCycleInProgress = false;
        if (Velocity.m4607getXimpl(velocity) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.leftEffect, MathKt.roundToInt(Velocity.m4607getXimpl(velocity)));
        } else if (Velocity.m4607getXimpl(velocity) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.rightEffect, -MathKt.roundToInt(Velocity.m4607getXimpl(velocity)));
        }
        if (Velocity.m4608getYimpl(velocity) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.topEffect, MathKt.roundToInt(Velocity.m4608getYimpl(velocity)));
        } else if (Velocity.m4608getYimpl(velocity) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.bottomEffect, -MathKt.roundToInt(Velocity.m4608getYimpl(velocity)));
        }
        if (!Velocity.m4606equalsimpl0(velocity, Velocity.INSTANCE.m4618getZero9UxMQ8M())) {
            invalidateOverscroll();
        }
        animateToRelease();
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isEnabled() {
        return this.isEnabledState.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public void setEnabled(boolean value) {
        boolean enabledChanged = this.isEnabled != value;
        this.isEnabledState.setValue(Boolean.valueOf(value));
        this.isEnabled = value;
        if (enabledChanged) {
            this.scrollCycleInProgress = false;
            animateToRelease();
        }
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        List $this$fastAny$iv = this.allEffects;
        int index$iv$iv = 0;
        int size = $this$fastAny$iv.size();
        while (true) {
            if (index$iv$iv >= size) {
                return false;
            }
            Object item$iv$iv = $this$fastAny$iv.get(index$iv$iv);
            EdgeEffect it = (EdgeEffect) item$iv$iv;
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(it) == 0.0f)) {
                return true;
            }
            index$iv$iv++;
        }
    }

    private final boolean stopOverscrollAnimation() {
        boolean stopped = false;
        long fakeDisplacement = SizeKt.m1839getCenteruvyYCjk(this.containerSize);
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f)) {
            m483pullLeft0a9Yr6o(Offset.INSTANCE.m1776getZeroF1C5BW0(), fakeDisplacement);
            stopped = true;
        }
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f)) {
            m484pullRight0a9Yr6o(Offset.INSTANCE.m1776getZeroF1C5BW0(), fakeDisplacement);
            stopped = true;
        }
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) == 0.0f)) {
            m485pullTop0a9Yr6o(Offset.INSTANCE.m1776getZeroF1C5BW0(), fakeDisplacement);
            stopped = true;
        }
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f)) {
            m482pullBottom0a9Yr6o(Offset.INSTANCE.m1776getZeroF1C5BW0(), fakeDisplacement);
            return true;
        }
        return stopped;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    public final void drawOverscroll(DrawScope $this$drawOverscroll) {
        Intrinsics.checkNotNullParameter($this$drawOverscroll, "<this>");
        if (Size.m1831isEmptyimpl(this.containerSize)) {
            return;
        }
        Canvas it = $this$drawOverscroll.getDrawContext().getCanvas();
        this.redrawSignal.getValue();
        android.graphics.Canvas canvas = AndroidCanvas_androidKt.getNativeCanvas(it);
        boolean needsInvalidate = false;
        boolean z = true;
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffectNegation) == 0.0f)) {
            drawRight($this$drawOverscroll, this.leftEffectNegation, canvas);
            this.leftEffectNegation.finish();
        }
        if (!this.leftEffect.isFinished()) {
            needsInvalidate = drawLeft($this$drawOverscroll, this.leftEffect, canvas);
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect), 0.0f);
        }
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffectNegation) == 0.0f)) {
            drawBottom($this$drawOverscroll, this.topEffectNegation, canvas);
            this.topEffectNegation.finish();
        }
        if (!this.topEffect.isFinished()) {
            needsInvalidate = drawTop($this$drawOverscroll, this.topEffect, canvas) || needsInvalidate;
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect), 0.0f);
        }
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffectNegation) == 0.0f)) {
            drawLeft($this$drawOverscroll, this.rightEffectNegation, canvas);
            this.rightEffectNegation.finish();
        }
        if (!this.rightEffect.isFinished()) {
            needsInvalidate = drawRight($this$drawOverscroll, this.rightEffect, canvas) || needsInvalidate;
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect), 0.0f);
        }
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffectNegation) == 0.0f)) {
            drawTop($this$drawOverscroll, this.bottomEffectNegation, canvas);
            this.bottomEffectNegation.finish();
        }
        if (!this.bottomEffect.isFinished()) {
            if (!drawBottom($this$drawOverscroll, this.bottomEffect, canvas) && !needsInvalidate) {
                z = false;
            }
            needsInvalidate = z;
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect), 0.0f);
        }
        if (needsInvalidate) {
            invalidateOverscroll();
        }
    }

    private final boolean drawLeft(DrawScope $this$drawLeft, EdgeEffect left, android.graphics.Canvas canvas) {
        int restore = canvas.save();
        canvas.rotate(270.0f);
        canvas.translate(-Size.m1826getHeightimpl(this.containerSize), $this$drawLeft.mo648toPx0680j_4(this.overscrollConfig.getDrawPadding().mo740calculateLeftPaddingu2uoSUM($this$drawLeft.getLayoutDirection())));
        boolean needsInvalidate = left.draw(canvas);
        canvas.restoreToCount(restore);
        return needsInvalidate;
    }

    private final boolean drawTop(DrawScope $this$drawTop, EdgeEffect top, android.graphics.Canvas canvas) {
        int restore = canvas.save();
        canvas.translate(0.0f, $this$drawTop.mo648toPx0680j_4(this.overscrollConfig.getDrawPadding().getTop()));
        boolean needsInvalidate = top.draw(canvas);
        canvas.restoreToCount(restore);
        return needsInvalidate;
    }

    private final boolean drawRight(DrawScope $this$drawRight, EdgeEffect right, android.graphics.Canvas canvas) {
        int restore = canvas.save();
        int width = MathKt.roundToInt(Size.m1829getWidthimpl(this.containerSize));
        float rightPadding = this.overscrollConfig.getDrawPadding().mo741calculateRightPaddingu2uoSUM($this$drawRight.getLayoutDirection());
        canvas.rotate(90.0f);
        canvas.translate(0.0f, (-width) + $this$drawRight.mo648toPx0680j_4(rightPadding));
        boolean needsInvalidate = right.draw(canvas);
        canvas.restoreToCount(restore);
        return needsInvalidate;
    }

    private final boolean drawBottom(DrawScope $this$drawBottom, EdgeEffect bottom, android.graphics.Canvas canvas) {
        int restore = canvas.save();
        canvas.rotate(180.0f);
        float bottomPadding = $this$drawBottom.mo648toPx0680j_4(this.overscrollConfig.getDrawPadding().getBottom());
        canvas.translate(-Size.m1829getWidthimpl(this.containerSize), (-Size.m1826getHeightimpl(this.containerSize)) + bottomPadding);
        boolean needsInvalidate = bottom.draw(canvas);
        canvas.restoreToCount(restore);
        return needsInvalidate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateOverscroll() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateToRelease() {
        boolean needsInvalidation = false;
        List $this$fastForEach$iv = this.allEffects;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            EdgeEffect it = (EdgeEffect) item$iv;
            it.onRelease();
            needsInvalidation = it.isFinished() || needsInvalidation;
        }
        if (needsInvalidation) {
            invalidateOverscroll();
        }
    }

    /* renamed from: releaseOppositeOverscroll-k-4lQ0M, reason: not valid java name */
    private final boolean m486releaseOppositeOverscrollk4lQ0M(long delta) {
        boolean needsInvalidation = false;
        if (!this.leftEffect.isFinished() && Offset.m1760getXimpl(delta) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.leftEffect, Offset.m1760getXimpl(delta));
            needsInvalidation = this.leftEffect.isFinished();
        }
        if (!this.rightEffect.isFinished() && Offset.m1760getXimpl(delta) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.rightEffect, Offset.m1760getXimpl(delta));
            needsInvalidation = needsInvalidation || this.rightEffect.isFinished();
        }
        if (!this.topEffect.isFinished() && Offset.m1761getYimpl(delta) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.topEffect, Offset.m1761getYimpl(delta));
            needsInvalidation = needsInvalidation || this.topEffect.isFinished();
        }
        if (!this.bottomEffect.isFinished() && Offset.m1761getYimpl(delta) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.bottomEffect, Offset.m1761getYimpl(delta));
            return needsInvalidation || this.bottomEffect.isFinished();
        }
        return needsInvalidation;
    }

    /* renamed from: pullTop-0a9Yr6o, reason: not valid java name */
    private final float m485pullTop0a9Yr6o(long scroll, long displacement) {
        float displacementX = Offset.m1760getXimpl(displacement) / Size.m1829getWidthimpl(this.containerSize);
        float pullY = Offset.m1761getYimpl(scroll) / Size.m1826getHeightimpl(this.containerSize);
        return EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffect, pullY, displacementX) * Size.m1826getHeightimpl(this.containerSize);
    }

    /* renamed from: pullBottom-0a9Yr6o, reason: not valid java name */
    private final float m482pullBottom0a9Yr6o(long scroll, long displacement) {
        float displacementX = Offset.m1760getXimpl(displacement) / Size.m1829getWidthimpl(this.containerSize);
        float pullY = Offset.m1761getYimpl(scroll) / Size.m1826getHeightimpl(this.containerSize);
        return (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffect, -pullY, 1 - displacementX)) * Size.m1826getHeightimpl(this.containerSize);
    }

    /* renamed from: pullLeft-0a9Yr6o, reason: not valid java name */
    private final float m483pullLeft0a9Yr6o(long scroll, long displacement) {
        float displacementY = Offset.m1761getYimpl(displacement) / Size.m1826getHeightimpl(this.containerSize);
        float pullX = Offset.m1760getXimpl(scroll) / Size.m1829getWidthimpl(this.containerSize);
        return EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffect, pullX, 1 - displacementY) * Size.m1829getWidthimpl(this.containerSize);
    }

    /* renamed from: pullRight-0a9Yr6o, reason: not valid java name */
    private final float m484pullRight0a9Yr6o(long scroll, long displacement) {
        float displacementY = Offset.m1761getYimpl(displacement) / Size.m1826getHeightimpl(this.containerSize);
        float pullX = Offset.m1760getXimpl(scroll) / Size.m1829getWidthimpl(this.containerSize);
        return (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffect, -pullX, displacementY)) * Size.m1829getWidthimpl(this.containerSize);
    }
}
