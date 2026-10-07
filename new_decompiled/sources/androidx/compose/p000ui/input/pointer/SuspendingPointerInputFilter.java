package androidx.compose.p000ui.input.pointer;

import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.geometry.SizeKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.DensityKt;
import androidx.compose.p000ui.unit.DpRect;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.runtime.collection.MutableVector;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* compiled from: SuspendingPointerInputFilter.kt */
@Metadata(m286d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001cB\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ@\u0010/\u001a\u0002H0\"\u0004\b\u0000\u001002'\u00101\u001a#\b\u0001\u0012\u0004\u0012\u000203\u0012\n\u0012\b\u0012\u0004\u0012\u0002H004\u0012\u0006\u0012\u0004\u0018\u00010502¢\u0006\u0002\b6H\u0096@ø\u0001\u0000¢\u0006\u0002\u00107J\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<H\u0002J-\u0010=\u001a\u0002092\u0006\u0010;\u001a\u00020<2\u001a\u00101\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u00030\u001bR\u00020\u0000\u0012\u0004\u0012\u0002090>H\u0082\bJ\b\u0010?\u001a\u000209H\u0016J-\u0010@\u001a\u0002092\u0006\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<2\u0006\u0010A\u001a\u00020\nH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\u001a\u0010D\u001a\u00020E*\u00020FH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u001a\u0010D\u001a\u00020E*\u00020IH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ\u001a\u0010L\u001a\u00020F*\u00020IH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ\u001d\u0010L\u001a\u00020F*\u00020\u0016H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001d\u0010L\u001a\u00020F*\u00020EH\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010QJ\u001a\u0010R\u001a\u00020S*\u00020\u001dH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\u001a\u0010V\u001a\u00020\u0016*\u00020FH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010PJ\u001a\u0010V\u001a\u00020\u0016*\u00020IH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010NJ\r\u0010Y\u001a\u00020Z*\u00020[H\u0097\u0001J\u001a\u0010\\\u001a\u00020\u001d*\u00020SH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b]\u0010UJ\u001a\u0010^\u001a\u00020I*\u00020FH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b_\u0010`J\u001d\u0010^\u001a\u00020I*\u00020\u0016H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\ba\u0010`J\u001d\u0010^\u001a\u00020I*\u00020EH\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\ba\u0010bR\u0019\u0010\t\u001a\u00020\nX\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR \u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00168\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u001bR\u00020\u00000\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00168\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\u0018R\u001a\u0010\"\u001a\u00020#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u001bR\u00020\u00000\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006d"}, m287d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilter;", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "Landroidx/compose/ui/input/pointer/PointerInputModifier;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Landroidx/compose/ui/unit/Density;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "density", "(Landroidx/compose/ui/platform/ViewConfiguration;Landroidx/compose/ui/unit/Density;)V", "boundsSize", "Landroidx/compose/ui/unit/IntSize;", "J", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$annotations", "()V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "", "getDensity", "()F", "dispatchingPointerHandlers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilter$PointerEventHandlerCoroutine;", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "fontScale", "getFontScale", "interceptOutOfBoundsChildEvents", "", "getInterceptOutOfBoundsChildEvents", "()Z", "setInterceptOutOfBoundsChildEvents", "(Z)V", "lastPointerEvent", "pointerHandlers", "pointerInputFilter", "getPointerInputFilter", "()Landroidx/compose/ui/input/pointer/PointerInputFilter;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEventScope", "R", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPointerEvent", "", "pointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "forEachCurrentPointerHandler", "Lkotlin/Function1;", "onCancel", "onPointerEvent", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "PointerEventHandlerCoroutine", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SuspendingPointerInputFilter extends PointerInputFilter implements PointerInputModifier, PointerInputScope, Density {
    private final /* synthetic */ Density $$delegate_0;
    private long boundsSize;
    private CoroutineScope coroutineScope;
    private PointerEvent currentEvent;
    private final MutableVector<PointerEventHandlerCoroutine<?>> dispatchingPointerHandlers;
    private boolean interceptOutOfBoundsChildEvents;
    private PointerEvent lastPointerEvent;
    private final MutableVector<PointerEventHandlerCoroutine<?>> pointerHandlers;
    private final ViewConfiguration viewConfiguration;

    /* compiled from: SuspendingPointerInputFilter.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PointerEventPass.values().length];
            iArr[PointerEventPass.Initial.ordinal()] = 1;
            iArr[PointerEventPass.Final.ordinal()] = 2;
            iArr[PointerEventPass.Main.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getCoroutineScope$annotations() {
    }

    @Override // androidx.compose.p000ui.unit.Density
    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.p000ui.unit.Density
    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: roundToPx--R2X_6o */
    public int mo641roundToPxR2X_6o(long j) {
        return this.$$delegate_0.mo641roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: roundToPx-0680j_4 */
    public int mo642roundToPx0680j_4(float f) {
        return this.$$delegate_0.mo642roundToPx0680j_4(f);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toDp-GaN1DYA */
    public float mo643toDpGaN1DYA(long j) {
        return this.$$delegate_0.mo643toDpGaN1DYA(j);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo644toDpu2uoSUM(float f) {
        return this.$$delegate_0.mo644toDpu2uoSUM(f);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo645toDpu2uoSUM(int i) {
        return this.$$delegate_0.mo645toDpu2uoSUM(i);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public long mo646toDpSizekrfVVM(long j) {
        return this.$$delegate_0.mo646toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toPx--R2X_6o */
    public float mo647toPxR2X_6o(long j) {
        return this.$$delegate_0.mo647toPxR2X_6o(j);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toPx-0680j_4 */
    public float mo648toPx0680j_4(float f) {
        return this.$$delegate_0.mo648toPx0680j_4(f);
    }

    @Override // androidx.compose.p000ui.unit.Density
    public Rect toRect(DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.$$delegate_0.toRect(dpRect);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public long mo649toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.mo649toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toSp-0xMU5do */
    public long mo650toSp0xMU5do(float f) {
        return this.$$delegate_0.mo650toSp0xMU5do(f);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public long mo651toSpkPz2Gy4(float f) {
        return this.$$delegate_0.mo651toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public long mo652toSpkPz2Gy4(int i) {
        return this.$$delegate_0.mo652toSpkPz2Gy4(i);
    }

    public /* synthetic */ SuspendingPointerInputFilter(ViewConfiguration viewConfiguration, Density density, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewConfiguration, (i & 2) != 0 ? DensityKt.Density$default(1.0f, 0.0f, 2, null) : density);
    }

    @Override // androidx.compose.p000ui.input.pointer.PointerInputScope
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public SuspendingPointerInputFilter(ViewConfiguration viewConfiguration, Density density) {
        PointerEvent pointerEvent;
        Intrinsics.checkNotNullParameter(viewConfiguration, "viewConfiguration");
        Intrinsics.checkNotNullParameter(density, "density");
        this.viewConfiguration = viewConfiguration;
        this.$$delegate_0 = density;
        pointerEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
        this.currentEvent = pointerEvent;
        this.pointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
        this.dispatchingPointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
        this.boundsSize = IntSize.INSTANCE.m4547getZeroYbymL2g();
        this.coroutineScope = GlobalScope.INSTANCE;
    }

    @Override // androidx.compose.p000ui.input.pointer.PointerInputModifier
    public PointerInputFilter getPointerInputFilter() {
        return this;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final void setCoroutineScope(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<set-?>");
        this.coroutineScope = coroutineScope;
    }

    @Override // androidx.compose.p000ui.input.pointer.PointerInputScope
    /* renamed from: getExtendedTouchPadding-NH-jbRc */
    public long mo3399getExtendedTouchPaddingNHjbRc() {
        long minimumTouchTargetSize = mo649toSizeXkaWNTQ(getViewConfiguration().mo3625getMinimumTouchTargetSizeMYxV2XQ());
        long size = m3384getSizeYbymL2g();
        float horizontal = Math.max(0.0f, Size.m1829getWidthimpl(minimumTouchTargetSize) - IntSize.m4542getWidthimpl(size)) / 2.0f;
        float vertical = Math.max(0.0f, Size.m1826getHeightimpl(minimumTouchTargetSize) - IntSize.m4541getHeightimpl(size)) / 2.0f;
        return SizeKt.Size(horizontal, vertical);
    }

    @Override // androidx.compose.p000ui.input.pointer.PointerInputFilter, androidx.compose.p000ui.input.pointer.PointerInputScope
    public boolean getInterceptOutOfBoundsChildEvents() {
        return this.interceptOutOfBoundsChildEvents;
    }

    @Override // androidx.compose.p000ui.input.pointer.PointerInputScope
    public void setInterceptOutOfBoundsChildEvents(boolean z) {
        this.interceptOutOfBoundsChildEvents = z;
    }

    private final void forEachCurrentPointerHandler(PointerEventPass pass, Function1<? super PointerEventHandlerCoroutine<?>, Unit> block) {
        Object lock$iv = this.pointerHandlers;
        synchronized (lock$iv) {
            try {
                MutableVector this_$iv = this.dispatchingPointerHandlers;
                MutableVector elements$iv = this.pointerHandlers;
                this_$iv.addAll(this_$iv.getSize(), elements$iv);
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        try {
            switch (WhenMappings.$EnumSwitchMapping$0[pass.ordinal()]) {
                case 1:
                case 2:
                    MutableVector this_$iv2 = this.dispatchingPointerHandlers;
                    int size$iv = this_$iv2.getSize();
                    if (size$iv > 0) {
                        int i$iv = 0;
                        Object[] content$iv = this_$iv2.getContent();
                        Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                        do {
                            block.invoke(content$iv[i$iv]);
                            i$iv++;
                        } while (i$iv < size$iv);
                    }
                    break;
                case 3:
                    MutableVector this_$iv3 = this.dispatchingPointerHandlers;
                    int size$iv2 = this_$iv3.getSize();
                    if (size$iv2 > 0) {
                        int i$iv2 = size$iv2 - 1;
                        Object[] content$iv2 = this_$iv3.getContent();
                        Intrinsics.checkNotNull(content$iv2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                        do {
                            block.invoke(content$iv2[i$iv2]);
                            i$iv2--;
                        } while (i$iv2 >= 0);
                    }
                    break;
            }
        } finally {
            InlineMarker.finallyStart(1);
            this.dispatchingPointerHandlers.clear();
            InlineMarker.finallyEnd(1);
        }
    }

    private final void dispatchPointerEvent(PointerEvent pointerEvent, PointerEventPass pass) {
        Object lock$iv$iv = this.pointerHandlers;
        synchronized (lock$iv$iv) {
            MutableVector this_$iv$iv = this.dispatchingPointerHandlers;
            MutableVector elements$iv$iv = this.pointerHandlers;
            this_$iv$iv.addAll(this_$iv$iv.getSize(), elements$iv$iv);
        }
        try {
            switch (WhenMappings.$EnumSwitchMapping$0[pass.ordinal()]) {
                case 1:
                case 2:
                    MutableVector this_$iv$iv2 = this.dispatchingPointerHandlers;
                    int size$iv$iv = this_$iv$iv2.getSize();
                    if (size$iv$iv > 0) {
                        int i$iv$iv = 0;
                        Object[] content$iv$iv = this_$iv$iv2.getContent();
                        Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                        do {
                            PointerEventHandlerCoroutine it = (PointerEventHandlerCoroutine) content$iv$iv[i$iv$iv];
                            it.offerPointerEvent(pointerEvent, pass);
                            i$iv$iv++;
                        } while (i$iv$iv < size$iv$iv);
                    }
                    break;
                case 3:
                    MutableVector this_$iv$iv3 = this.dispatchingPointerHandlers;
                    int size$iv$iv2 = this_$iv$iv3.getSize();
                    if (size$iv$iv2 > 0) {
                        int i$iv$iv2 = size$iv$iv2 - 1;
                        Object[] content$iv$iv2 = this_$iv$iv3.getContent();
                        Intrinsics.checkNotNull(content$iv$iv2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                        do {
                            PointerEventHandlerCoroutine it2 = (PointerEventHandlerCoroutine) content$iv$iv2[i$iv$iv2];
                            it2.offerPointerEvent(pointerEvent, pass);
                            i$iv$iv2--;
                        } while (i$iv$iv2 >= 0);
                    }
                    break;
            }
        } finally {
            this.dispatchingPointerHandlers.clear();
        }
    }

    @Override // androidx.compose.p000ui.input.pointer.PointerInputFilter
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo3385onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        boolean z;
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pass, "pass");
        this.boundsSize = bounds;
        if (pass == PointerEventPass.Initial) {
            this.currentEvent = pointerEvent;
        }
        dispatchPointerEvent(pointerEvent, pass);
        List $this$fastAll$iv = pointerEvent.getChanges();
        int index$iv$iv = 0;
        int size = $this$fastAll$iv.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = $this$fastAll$iv.get(index$iv$iv);
                PointerInputChange it = (PointerInputChange) item$iv$iv;
                if (!PointerEventKt.changedToUpIgnoreConsumed(it)) {
                    z = false;
                    break;
                }
                index$iv$iv++;
            } else {
                z = true;
                break;
            }
        }
        this.lastPointerEvent = !z ? pointerEvent : null;
    }

    @Override // androidx.compose.p000ui.input.pointer.PointerInputFilter
    public void onCancel() {
        boolean z;
        PointerEvent lastEvent = this.lastPointerEvent;
        if (lastEvent == null) {
            return;
        }
        List $this$fastAll$iv = lastEvent.getChanges();
        int index$iv$iv = 0;
        int size = $this$fastAll$iv.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = $this$fastAll$iv.get(index$iv$iv);
                PointerInputChange it = (PointerInputChange) item$iv$iv;
                if (it.getPressed()) {
                    z = false;
                    break;
                }
                index$iv$iv++;
            } else {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        List $this$fastMapNotNull$iv = lastEvent.getChanges();
        List target$iv = new ArrayList($this$fastMapNotNull$iv.size());
        int size2 = $this$fastMapNotNull$iv.size();
        for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
            Object item$iv$iv2 = $this$fastMapNotNull$iv.get(index$iv$iv2);
            PointerInputChange old = (PointerInputChange) item$iv$iv2;
            long id = old.getId();
            long position = old.getPosition();
            List list = target$iv;
            list.add(new PointerInputChange(id, old.getUptimeMillis(), position, false, old.getPressure(), old.getUptimeMillis(), old.getPosition(), old.getPressed(), old.getPressed(), 0, 0L, 1536, (DefaultConstructorMarker) null));
        }
        List newChanges = target$iv;
        PointerEvent cancelEvent = new PointerEvent(newChanges);
        this.currentEvent = cancelEvent;
        dispatchPointerEvent(cancelEvent, PointerEventPass.Initial);
        dispatchPointerEvent(cancelEvent, PointerEventPass.Main);
        dispatchPointerEvent(cancelEvent, PointerEventPass.Final);
        this.lastPointerEvent = null;
    }

    @Override // androidx.compose.p000ui.input.pointer.PointerInputScope
    public <R> Object awaitPointerEventScope(Function2<? super AwaitPointerEventScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        CancellableContinuationImpl continuation2 = cancellable$iv;
        final PointerEventHandlerCoroutine handlerCoroutine = new PointerEventHandlerCoroutine(this, continuation2);
        Object lock$iv = this.pointerHandlers;
        synchronized (lock$iv) {
            MutableVector this_$iv = this.pointerHandlers;
            this_$iv.add(handlerCoroutine);
            Continuation<Unit> createCoroutine = ContinuationKt.createCoroutine(function2, handlerCoroutine, handlerCoroutine);
            Result.Companion companion = Result.INSTANCE;
            createCoroutine.resumeWith(Result.m4732constructorimpl(Unit.INSTANCE));
            Unit unit = Unit.INSTANCE;
        }
        continuation2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$awaitPointerEventScope$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                handlerCoroutine.cancel(it);
            }
        });
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuspendingPointerInputFilter.kt */
    @Metadata(m286d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0006J\u0019\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*J\u0016\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\bJ\u001e\u0010-\u001a\u00020(2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0016ø\u0001\u0000¢\u0006\u0002\u00100JH\u00101\u001a\u0002H2\"\u0004\b\u0001\u001022\u0006\u00103\u001a\u0002042'\u00105\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H20\u0004\u0012\u0006\u0012\u0004\u0018\u00010706¢\u0006\u0002\b8H\u0096@ø\u0001\u0000¢\u0006\u0002\u00109JJ\u0010:\u001a\u0004\u0018\u0001H2\"\u0004\b\u0001\u001022\u0006\u00103\u001a\u0002042'\u00105\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H20\u0004\u0012\u0006\u0012\u0004\u0018\u00010706¢\u0006\u0002\b8H\u0096@ø\u0001\u0000¢\u0006\u0002\u00109J\u001a\u0010;\u001a\u00020<*\u00020=H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u001a\u0010;\u001a\u00020<*\u00020@H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u001a\u0010C\u001a\u00020=*\u00020@H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u001d\u0010C\u001a\u00020=*\u00020\u0012H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001d\u0010C\u001a\u00020=*\u00020<H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010HJ\u001a\u0010I\u001a\u00020J*\u00020\u0016H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u001a\u0010M\u001a\u00020\u0012*\u00020=H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010GJ\u001a\u0010M\u001a\u00020\u0012*\u00020@H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010EJ\r\u0010P\u001a\u00020Q*\u00020RH\u0097\u0001J\u001a\u0010S\u001a\u00020\u0016*\u00020JH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010LJ\u001a\u0010U\u001a\u00020@*\u00020=H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\u001d\u0010U\u001a\u00020@*\u00020\u0012H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010WJ\u001d\u0010U\u001a\u00020@*\u00020<H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010YR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0018R\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, m287d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilter$PointerEventHandlerCoroutine;", "R", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/coroutines/Continuation;", "completion", "(Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilter;Lkotlin/coroutines/Continuation;)V", "awaitPass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "getCurrentEvent", "()Landroidx/compose/ui/input/pointer/PointerEvent;", "density", "", "getDensity", "()F", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "fontScale", "getFontScale", "pointerAwaiter", "Lkotlinx/coroutines/CancellableContinuation;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEvent", "pass", "(Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "cause", "", "offerPointerEvent", NotificationCompat.CATEGORY_EVENT, "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "withTimeout", "T", "timeMillis", "", "block", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    final class PointerEventHandlerCoroutine<R> implements AwaitPointerEventScope, Density, Continuation<R> {
        private final /* synthetic */ SuspendingPointerInputFilter $$delegate_0;
        private PointerEventPass awaitPass;
        private final Continuation<R> completion;
        private final CoroutineContext context;
        private CancellableContinuation<? super PointerEvent> pointerAwaiter;
        final /* synthetic */ SuspendingPointerInputFilter this$0;

        @Override // androidx.compose.p000ui.unit.Density
        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        @Override // androidx.compose.p000ui.unit.Density
        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        @Override // androidx.compose.p000ui.unit.Density
        /* renamed from: roundToPx--R2X_6o */
        public int mo641roundToPxR2X_6o(long j) {
            return this.$$delegate_0.mo641roundToPxR2X_6o(j);
        }

        @Override // androidx.compose.p000ui.unit.Density
        /* renamed from: roundToPx-0680j_4 */
        public int mo642roundToPx0680j_4(float f) {
            return this.$$delegate_0.mo642roundToPx0680j_4(f);
        }

        @Override // androidx.compose.p000ui.unit.Density
        /* renamed from: toDp-GaN1DYA */
        public float mo643toDpGaN1DYA(long j) {
            return this.$$delegate_0.mo643toDpGaN1DYA(j);
        }

        @Override // androidx.compose.p000ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public float mo644toDpu2uoSUM(float f) {
            return this.$$delegate_0.mo644toDpu2uoSUM(f);
        }

        @Override // androidx.compose.p000ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public float mo645toDpu2uoSUM(int i) {
            return this.$$delegate_0.mo645toDpu2uoSUM(i);
        }

        @Override // androidx.compose.p000ui.unit.Density
        /* renamed from: toDpSize-k-rfVVM */
        public long mo646toDpSizekrfVVM(long j) {
            return this.$$delegate_0.mo646toDpSizekrfVVM(j);
        }

        @Override // androidx.compose.p000ui.unit.Density
        /* renamed from: toPx--R2X_6o */
        public float mo647toPxR2X_6o(long j) {
            return this.$$delegate_0.mo647toPxR2X_6o(j);
        }

        @Override // androidx.compose.p000ui.unit.Density
        /* renamed from: toPx-0680j_4 */
        public float mo648toPx0680j_4(float f) {
            return this.$$delegate_0.mo648toPx0680j_4(f);
        }

        @Override // androidx.compose.p000ui.unit.Density
        public Rect toRect(DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "<this>");
            return this.$$delegate_0.toRect(dpRect);
        }

        @Override // androidx.compose.p000ui.unit.Density
        /* renamed from: toSize-XkaWNTQ */
        public long mo649toSizeXkaWNTQ(long j) {
            return this.$$delegate_0.mo649toSizeXkaWNTQ(j);
        }

        @Override // androidx.compose.p000ui.unit.Density
        /* renamed from: toSp-0xMU5do */
        public long mo650toSp0xMU5do(float f) {
            return this.$$delegate_0.mo650toSp0xMU5do(f);
        }

        @Override // androidx.compose.p000ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public long mo651toSpkPz2Gy4(float f) {
            return this.$$delegate_0.mo651toSpkPz2Gy4(f);
        }

        @Override // androidx.compose.p000ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public long mo652toSpkPz2Gy4(int i) {
            return this.$$delegate_0.mo652toSpkPz2Gy4(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PointerEventHandlerCoroutine(SuspendingPointerInputFilter this$0, Continuation<? super R> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            this.this$0 = this$0;
            this.completion = completion;
            this.$$delegate_0 = this.this$0;
            this.awaitPass = PointerEventPass.Main;
            this.context = EmptyCoroutineContext.INSTANCE;
        }

        @Override // androidx.compose.p000ui.input.pointer.AwaitPointerEventScope
        public PointerEvent getCurrentEvent() {
            return this.this$0.currentEvent;
        }

        @Override // androidx.compose.p000ui.input.pointer.AwaitPointerEventScope
        /* renamed from: getSize-YbymL2g */
        public long mo3280getSizeYbymL2g() {
            return this.this$0.boundsSize;
        }

        @Override // androidx.compose.p000ui.input.pointer.AwaitPointerEventScope
        public ViewConfiguration getViewConfiguration() {
            return this.this$0.getViewConfiguration();
        }

        @Override // androidx.compose.p000ui.input.pointer.AwaitPointerEventScope
        /* renamed from: getExtendedTouchPadding-NH-jbRc */
        public long mo3279getExtendedTouchPaddingNHjbRc() {
            return this.this$0.mo3399getExtendedTouchPaddingNHjbRc();
        }

        public final void offerPointerEvent(PointerEvent event, PointerEventPass pass) {
            CancellableContinuation $this$offerPointerEvent_u24lambda_u2d0;
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(pass, "pass");
            if (pass == this.awaitPass && ($this$offerPointerEvent_u24lambda_u2d0 = this.pointerAwaiter) != null) {
                this.pointerAwaiter = null;
                Result.Companion companion = Result.INSTANCE;
                $this$offerPointerEvent_u24lambda_u2d0.resumeWith(Result.m4732constructorimpl(event));
            }
        }

        public final void cancel(Throwable cause) {
            CancellableContinuation<? super PointerEvent> cancellableContinuation = this.pointerAwaiter;
            if (cancellableContinuation != null) {
                cancellableContinuation.cancel(cause);
            }
            this.pointerAwaiter = null;
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.context;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object result) {
            Object lock$iv = this.this$0.pointerHandlers;
            SuspendingPointerInputFilter suspendingPointerInputFilter = this.this$0;
            synchronized (lock$iv) {
                MutableVector this_$iv = suspendingPointerInputFilter.pointerHandlers;
                this_$iv.remove(this);
                Unit unit = Unit.INSTANCE;
            }
            this.completion.resumeWith(result);
        }

        @Override // androidx.compose.p000ui.input.pointer.AwaitPointerEventScope
        public Object awaitPointerEvent(PointerEventPass pass, Continuation<? super PointerEvent> continuation) {
            CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellable$iv.initCancellability();
            CancellableContinuationImpl continuation2 = cancellable$iv;
            this.awaitPass = pass;
            this.pointerAwaiter = continuation2;
            Object result = cancellable$iv.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x002e A[Catch: PointerEventTimeoutCancellationException -> 0x0033, TRY_ENTER, TRY_LEAVE, TryCatch #0 {PointerEventTimeoutCancellationException -> 0x0033, blocks: (B:12:0x002e, B:18:0x003b), top: B:7:0x0022 }] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
        @Override // androidx.compose.p000ui.input.pointer.AwaitPointerEventScope
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public <T> Object withTimeoutOrNull(long timeMillis, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
            C0428x7456dd52 c0428x7456dd52;
            C0428x7456dd52 c0428x7456dd522;
            Object withTimeout;
            try {
                if (continuation instanceof C0428x7456dd52) {
                    c0428x7456dd52 = (C0428x7456dd52) continuation;
                    if ((c0428x7456dd52.label & Integer.MIN_VALUE) != 0) {
                        c0428x7456dd52.label -= Integer.MIN_VALUE;
                        c0428x7456dd522 = c0428x7456dd52;
                        Object $result = c0428x7456dd522.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (c0428x7456dd522.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                c0428x7456dd522.label = 1;
                                withTimeout = withTimeout(timeMillis, function2, c0428x7456dd522);
                                if (withTimeout == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                break;
                            case 1:
                                ResultKt.throwOnFailure($result);
                                withTimeout = $result;
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return withTimeout;
                    }
                }
                switch (c0428x7456dd522.label) {
                }
                return withTimeout;
            } catch (PointerEventTimeoutCancellationException e) {
                return null;
            }
            c0428x7456dd52 = new C0428x7456dd52(this, continuation);
            c0428x7456dd522 = c0428x7456dd52;
            Object $result2 = c0428x7456dd522.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
        @Override // androidx.compose.p000ui.input.pointer.AwaitPointerEventScope
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public <T> Object withTimeout(long timeMillis, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
            C0426xffebe5e8 c0426xffebe5e8;
            Job job;
            Job job2;
            Object invoke;
            CancellableContinuation<? super PointerEvent> cancellableContinuation;
            if (continuation instanceof C0426xffebe5e8) {
                c0426xffebe5e8 = (C0426xffebe5e8) continuation;
                if ((c0426xffebe5e8.label & Integer.MIN_VALUE) != 0) {
                    c0426xffebe5e8.label -= Integer.MIN_VALUE;
                    Object $result = c0426xffebe5e8.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (c0426xffebe5e8.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            if (timeMillis <= 0 && (cancellableContinuation = this.pointerAwaiter) != null) {
                                Result.Companion companion = Result.INSTANCE;
                                cancellableContinuation.resumeWith(Result.m4732constructorimpl(ResultKt.createFailure(new PointerEventTimeoutCancellationException(timeMillis))));
                            }
                            job = BuildersKt__Builders_commonKt.launch$default(this.this$0.getCoroutineScope(), null, null, new C0427xbd8dd741(timeMillis, this, null), 3, null);
                            try {
                                c0426xffebe5e8.L$0 = job;
                                c0426xffebe5e8.label = 1;
                                invoke = function2.invoke(this, c0426xffebe5e8);
                                if (invoke == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                job2 = job;
                                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                                return invoke;
                            } catch (Throwable th) {
                                th = th;
                                job2 = job;
                                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                                throw th;
                            }
                        case 1:
                            job2 = (Job) c0426xffebe5e8.L$0;
                            try {
                                ResultKt.throwOnFailure($result);
                                invoke = $result;
                                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                                return invoke;
                            } catch (Throwable th2) {
                                th = th2;
                                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                                throw th;
                            }
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            c0426xffebe5e8 = new C0426xffebe5e8(this, continuation);
            Object $result2 = c0426xffebe5e8.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (c0426xffebe5e8.label) {
            }
        }
    }
}
