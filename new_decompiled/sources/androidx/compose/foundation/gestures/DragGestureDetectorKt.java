package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerEventKt;
import androidx.compose.p000ui.input.pointer.PointerEventPass;
import androidx.compose.p000ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.p000ui.input.pointer.PointerId;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.input.pointer.PointerType;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.unit.C0504Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: DragGestureDetector.kt */
@Metadata(m286d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a;\u0010\u0013\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00160\u0015H\u0082Hø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0019\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0012\u001ag\u0010\u001b\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d26\u0010\u001e\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH\u0080@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a_\u0010'\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001026\u0010(\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a'\u0010+\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b,\u0010\u0012\u001a]\u0010-\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010.\u001a\u00020\u00012\b\b\u0002\u0010/\u001a\u00020\u00162\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u001fH\u0080Hø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a_\u00103\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001026\u0010(\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u001100¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b4\u0010*\u001a'\u00105\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b6\u0010\u0012\u001ag\u00107\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d26\u0010(\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH\u0080@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b8\u0010&\u001a_\u00109\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001026\u0010(\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b:\u0010*\u001a\u0086\u0001\u0010;\u001a\u00020$*\u00020<2\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u00152\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020$0?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020$0?26\u0010A\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u001100¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020$0\u001fH\u0086@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010C\u001a\u0086\u0001\u0010D\u001a\u00020$*\u00020<2\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u00152\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020$0?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020$0?26\u0010A\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u001100¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020$0\u001fH\u0086@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010C\u001a\u0086\u0001\u0010E\u001a\u00020$*\u00020<2\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u00152\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020$0?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020$0?26\u0010F\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020$0\u001fH\u0086@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010C\u001a\u0086\u0001\u0010G\u001a\u00020$*\u00020<2\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u00152\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020$0?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020$0?26\u0010H\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020$0\u001fH\u0086@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010C\u001a9\u0010I\u001a\u00020\u0016*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0\u0015H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bJ\u0010\u0018\u001aa\u0010I\u001a\u00020\u0016*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0\u00152\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u00152\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00160\u0015H\u0082Hø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a9\u0010O\u001a\u00020\u0016*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0\u0015H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bP\u0010\u0018\u001a!\u0010Q\u001a\u00020\u0016*\u00020R2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a!\u0010U\u001a\u00020\u000b*\u00020V2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010X\u001a\f\u0010Y\u001a\u00020\u0001*\u00020ZH\u0000\u001a9\u0010[\u001a\u00020\u0016*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0\u0015H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\\\u0010\u0018\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0013\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\b\"\u0013\u0010\t\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\b\"\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006]"}, m287d2 = {"HorizontalPointerDirectionConfig", "Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "getHorizontalPointerDirectionConfig", "()Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "VerticalPointerDirectionConfig", "getVerticalPointerDirectionConfig", "defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitDragOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrUp", "hasDragged", "Lkotlin/Function1;", "", "awaitDragOrUp-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalDragOrCancellation", "awaitHorizontalDragOrCancellation-rnUCldI", "awaitHorizontalPointerSlopOrCancellation", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalTouchSlopOrCancellation", "onTouchSlopReached", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation", "awaitLongPressOrCancellation-rnUCldI", "awaitPointerSlopOrCancellation", "pointerDirectionConfig", "triggerOnMainAxisSlop", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-wtdNQyU", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILandroidx/compose/foundation/gestures/PointerDirectionConfig;ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitTouchSlopOrCancellation", "awaitTouchSlopOrCancellation-jO51t88", "awaitVerticalDragOrCancellation", "awaitVerticalDragOrCancellation-rnUCldI", "awaitVerticalPointerSlopOrCancellation", "awaitVerticalPointerSlopOrCancellation-gDDlDlE", "awaitVerticalTouchSlopOrCancellation", "awaitVerticalTouchSlopOrCancellation-jO51t88", "detectDragGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "onDrag", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "detectHorizontalDragGestures", "onHorizontalDrag", "detectVerticalDragGestures", "onVerticalDrag", "drag", "drag-jO51t88", "motionFromChange", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "horizontalDrag", "horizontalDrag-jO51t88", "isPointerUp", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "toPointerDirectionConfig", "Landroidx/compose/foundation/gestures/Orientation;", "verticalDrag", "verticalDrag-jO51t88", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class DragGestureDetectorKt {
    private static final float mouseToTouchSlopRatio;
    private static final PointerDirectionConfig HorizontalPointerDirectionConfig = new PointerDirectionConfig() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$HorizontalPointerDirectionConfig$1
        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* renamed from: mainAxisDelta-k-4lQ0M, reason: not valid java name */
        public float mo598mainAxisDeltak4lQ0M(long offset) {
            return Offset.m1760getXimpl(offset);
        }

        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* renamed from: crossAxisDelta-k-4lQ0M, reason: not valid java name */
        public float mo597crossAxisDeltak4lQ0M(long offset) {
            return Offset.m1761getYimpl(offset);
        }

        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* renamed from: offsetFromChanges-dBAh8RU, reason: not valid java name */
        public long mo599offsetFromChangesdBAh8RU(float mainChange, float crossChange) {
            return OffsetKt.Offset(mainChange, crossChange);
        }
    };
    private static final PointerDirectionConfig VerticalPointerDirectionConfig = new PointerDirectionConfig() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$VerticalPointerDirectionConfig$1
        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* renamed from: mainAxisDelta-k-4lQ0M */
        public float mo598mainAxisDeltak4lQ0M(long offset) {
            return Offset.m1761getYimpl(offset);
        }

        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* renamed from: crossAxisDelta-k-4lQ0M */
        public float mo597crossAxisDeltak4lQ0M(long offset) {
            return Offset.m1760getXimpl(offset);
        }

        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* renamed from: offsetFromChanges-dBAh8RU */
        public long mo599offsetFromChangesdBAh8RU(float mainChange, float crossChange) {
            return OffsetKt.Offset(crossChange, mainChange);
        }
    };
    private static final float mouseSlop = C0504Dp.m4382constructorimpl((float) 0.125d);
    private static final float defaultTouchSlop = C0504Dp.m4382constructorimpl(18);

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01f8 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0127 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0182 -> B:17:0x00ba). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01e7 -> B:12:0x01f2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x023b -> B:17:0x00ba). Please report as a decompilation issue!!! */
    /* renamed from: awaitTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m587awaitTouchSlopOrCancellationjO51t88(AwaitPointerEventScope awaitPointerEventScope, long pointerId, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
        DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitTouchSlopOrCancellation$12;
        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv;
        Function2 onTouchSlopReached;
        PointerDirectionConfig pointerDirectionConfig;
        int i;
        int i2;
        float touchSlop$iv;
        float totalMainPositionChange$iv;
        float totalCrossPositionChange$iv;
        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv2;
        Ref.LongRef pointer$iv;
        int i3;
        int i4;
        Object obj;
        Object $result;
        List $this$fastForEach$iv$iv$iv;
        int $i$f$fastFirstOrNull;
        int size;
        int index$iv$iv$iv;
        Object obj2;
        Object it$iv$iv;
        PointerInputChange dragEvent$iv;
        long offset$iv;
        PointerInputChange dragEvent$iv2;
        PointerDirectionConfig pointerDirectionConfig2;
        Object it$iv$iv2;
        List $this$fastForEach$iv$iv$iv2;
        int $i$f$fastFirstOrNull2;
        int i5;
        Object awaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitTouchSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$1 = (DragGestureDetectorKt$awaitTouchSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label -= Integer.MIN_VALUE;
                dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
                Object $result2 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                PointerEventPass pointerEventPass = null;
                switch (dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv = awaitPointerEventScope;
                        onTouchSlopReached = function2;
                        int m3442getTouchT8wyACA = PointerType.INSTANCE.m3442getTouchT8wyACA();
                        pointerDirectionConfig = HorizontalPointerDirectionConfig;
                        i = 0;
                        i2 = 0;
                        if (m594isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv.getCurrentEvent(), pointerId)) {
                            return null;
                        }
                        touchSlop$iv = m595pointerSlopE8SPZFQ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv.getViewConfiguration(), m3442getTouchT8wyACA);
                        Ref.LongRef pointer$iv2 = new Ref.LongRef();
                        pointer$iv2.element = pointerId;
                        totalMainPositionChange$iv = 0.0f;
                        totalCrossPositionChange$iv = 0.0f;
                        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = onTouchSlopReached;
                        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv;
                        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = pointer$iv2;
                        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = pointerEventPass;
                        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.I$0 = i;
                        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = touchSlop$iv;
                        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$2 = totalCrossPositionChange$iv;
                        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = 1;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv, pointerEventPass, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, 1, pointerEventPass);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj3 = coroutine_suspended;
                        $result = $result2;
                        $result2 = awaitPointerEvent$default;
                        pointer$iv = pointer$iv2;
                        i4 = i2;
                        i3 = i;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv;
                        obj = obj3;
                        PointerEvent event$iv = (PointerEvent) $result2;
                        $this$fastForEach$iv$iv$iv = event$iv.getChanges();
                        $i$f$fastFirstOrNull = 0;
                        size = $this$fastForEach$iv$iv$iv.size();
                        Object $result3 = $result;
                        index$iv$iv$iv = 0;
                        while (true) {
                            if (index$iv$iv$iv >= size) {
                                Object item$iv$iv$iv = $this$fastForEach$iv$iv$iv.get(index$iv$iv$iv);
                                it$iv$iv = item$iv$iv$iv;
                                PointerInputChange it$iv = (PointerInputChange) it$iv$iv;
                                $this$fastForEach$iv$iv$iv2 = $this$fastForEach$iv$iv$iv;
                                $i$f$fastFirstOrNull2 = $i$f$fastFirstOrNull;
                                obj2 = obj;
                                i5 = size;
                                if (!PointerId.m3349equalsimpl0(it$iv.getId(), pointer$iv.element)) {
                                    index$iv$iv$iv++;
                                    $i$f$fastFirstOrNull = $i$f$fastFirstOrNull2;
                                    $this$fastForEach$iv$iv$iv = $this$fastForEach$iv$iv$iv2;
                                    obj = obj2;
                                    size = i5;
                                }
                            } else {
                                obj2 = obj;
                                it$iv$iv = null;
                            }
                        }
                        dragEvent$iv = (PointerInputChange) it$iv$iv;
                        if (dragEvent$iv != null && !dragEvent$iv.isConsumed()) {
                            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                                long currentPosition$iv = dragEvent$iv.getPosition();
                                long previousPosition$iv = dragEvent$iv.getPreviousPosition();
                                float mainPositionChange$iv = pointerDirectionConfig.mo598mainAxisDeltak4lQ0M(currentPosition$iv) - pointerDirectionConfig.mo598mainAxisDeltak4lQ0M(previousPosition$iv);
                                float crossPositionChange$iv = pointerDirectionConfig.mo597crossAxisDeltak4lQ0M(currentPosition$iv) - pointerDirectionConfig.mo597crossAxisDeltak4lQ0M(previousPosition$iv);
                                totalMainPositionChange$iv += mainPositionChange$iv;
                                totalCrossPositionChange$iv += crossPositionChange$iv;
                                float inDirection$iv = i3 != 0 ? Math.abs(totalMainPositionChange$iv) : Offset.m1758getDistanceimpl(pointerDirectionConfig.mo599offsetFromChangesdBAh8RU(totalMainPositionChange$iv, totalCrossPositionChange$iv));
                                if (inDirection$iv < touchSlop$iv) {
                                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = onTouchSlopReached;
                                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv2;
                                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = pointer$iv;
                                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = dragEvent$iv;
                                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.I$0 = i3;
                                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = touchSlop$iv;
                                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$2 = totalCrossPositionChange$iv;
                                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = 2;
                                    Object obj4 = obj2;
                                    if ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv2.awaitPointerEvent(pointerEventPass2, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12) == obj4) {
                                        return obj4;
                                    }
                                    $result2 = $result3;
                                    PointerDirectionConfig pointerDirectionConfig3 = pointerDirectionConfig;
                                    dragEvent$iv2 = dragEvent$iv;
                                    coroutine_suspended = obj4;
                                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv2;
                                    i = i3;
                                    i2 = i4;
                                    pointerDirectionConfig2 = pointerDirectionConfig3;
                                    if (!dragEvent$iv2.isConsumed()) {
                                        return null;
                                    }
                                    pointerDirectionConfig = pointerDirectionConfig2;
                                    pointer$iv2 = pointer$iv;
                                    pointerEventPass = null;
                                } else {
                                    Object obj5 = obj2;
                                    if (i3 != 0) {
                                        float finalMainPositionChange$iv = totalMainPositionChange$iv - (Math.signum(totalMainPositionChange$iv) * touchSlop$iv);
                                        offset$iv = pointerDirectionConfig.mo599offsetFromChangesdBAh8RU(finalMainPositionChange$iv, totalCrossPositionChange$iv);
                                    } else {
                                        long offset$iv2 = pointerDirectionConfig.mo599offsetFromChangesdBAh8RU(totalMainPositionChange$iv, totalCrossPositionChange$iv);
                                        long touchSlopOffset$iv = Offset.m1767timestuRUvjQ(Offset.m1755divtuRUvjQ(offset$iv2, inDirection$iv), touchSlop$iv);
                                        offset$iv = Offset.m1764minusMKHz9U(offset$iv2, touchSlopOffset$iv);
                                    }
                                    onTouchSlopReached.invoke(dragEvent$iv, Offset.m1749boximpl(offset$iv));
                                    if (dragEvent$iv.isConsumed()) {
                                        return dragEvent$iv;
                                    }
                                    totalMainPositionChange$iv = 0.0f;
                                    totalCrossPositionChange$iv = 0.0f;
                                    $result2 = $result3;
                                    coroutine_suspended = obj5;
                                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv2;
                                    i = i3;
                                    i2 = i4;
                                    pointer$iv2 = pointer$iv;
                                    pointerEventPass = null;
                                }
                            } else {
                                List $this$fastForEach$iv$iv$iv3 = event$iv.getChanges();
                                int index$iv$iv$iv2 = 0;
                                int size2 = $this$fastForEach$iv$iv$iv3.size();
                                while (true) {
                                    if (index$iv$iv$iv2 < size2) {
                                        Object item$iv$iv$iv2 = $this$fastForEach$iv$iv$iv3.get(index$iv$iv$iv2);
                                        it$iv$iv2 = item$iv$iv$iv2;
                                        PointerInputChange it$iv2 = (PointerInputChange) it$iv$iv2;
                                        if (!it$iv2.getPressed()) {
                                            index$iv$iv$iv2++;
                                        }
                                    } else {
                                        it$iv$iv2 = null;
                                    }
                                }
                                PointerInputChange otherDown$iv = (PointerInputChange) it$iv$iv2;
                                if (otherDown$iv == null) {
                                    return null;
                                }
                                pointer$iv.element = otherDown$iv.getId();
                                $result2 = $result3;
                                coroutine_suspended = obj2;
                                $this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv2;
                                i = i3;
                                i2 = i4;
                                pointer$iv2 = pointer$iv;
                                pointerEventPass = null;
                            }
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = onTouchSlopReached;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = pointer$iv2;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = pointerEventPass;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.I$0 = i;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = touchSlop$iv;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$2 = totalCrossPositionChange$iv;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = 1;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv, pointerEventPass, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, 1, pointerEventPass);
                            if (awaitPointerEvent$default == coroutine_suspended) {
                            }
                        }
                        return null;
                    case 1:
                        totalCrossPositionChange$iv = dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$2;
                        totalMainPositionChange$iv = dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$1;
                        float touchSlop$iv2 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0;
                        int i6 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.I$0;
                        Ref.LongRef pointer$iv3 = (Ref.LongRef) dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv2 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2;
                        PointerDirectionConfig pointerDirectionConfig4 = (PointerDirectionConfig) dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1;
                        Function2 onTouchSlopReached2 = (Function2) dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        pointer$iv = pointer$iv3;
                        pointerDirectionConfig = pointerDirectionConfig4;
                        i3 = i6;
                        touchSlop$iv = touchSlop$iv2;
                        onTouchSlopReached = onTouchSlopReached2;
                        i4 = 0;
                        obj = coroutine_suspended;
                        $result = $result2;
                        PointerEvent event$iv2 = (PointerEvent) $result2;
                        $this$fastForEach$iv$iv$iv = event$iv2.getChanges();
                        $i$f$fastFirstOrNull = 0;
                        size = $this$fastForEach$iv$iv$iv.size();
                        Object $result32 = $result;
                        index$iv$iv$iv = 0;
                        while (true) {
                            if (index$iv$iv$iv >= size) {
                            }
                            index$iv$iv$iv++;
                            $i$f$fastFirstOrNull = $i$f$fastFirstOrNull2;
                            $this$fastForEach$iv$iv$iv = $this$fastForEach$iv$iv$iv2;
                            obj = obj2;
                            size = i5;
                        }
                        dragEvent$iv = (PointerInputChange) it$iv$iv;
                        if (dragEvent$iv != null) {
                            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                            }
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = onTouchSlopReached;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = pointer$iv2;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = pointerEventPass;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.I$0 = i;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = touchSlop$iv;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$2 = totalCrossPositionChange$iv;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = 1;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv, pointerEventPass, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, 1, pointerEventPass);
                            if (awaitPointerEvent$default == coroutine_suspended) {
                            }
                            break;
                        } else {
                            return null;
                        }
                        break;
                    case 2:
                        totalCrossPositionChange$iv = dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$2;
                        totalMainPositionChange$iv = dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$1;
                        float touchSlop$iv3 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0;
                        int i7 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.I$0;
                        dragEvent$iv2 = (PointerInputChange) dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4;
                        Ref.LongRef pointer$iv4 = (Ref.LongRef) dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3;
                        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2;
                        pointerDirectionConfig2 = (PointerDirectionConfig) dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1;
                        Function2 onTouchSlopReached3 = (Function2) dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        i2 = 0;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU$iv3;
                        touchSlop$iv = touchSlop$iv3;
                        onTouchSlopReached = onTouchSlopReached3;
                        pointer$iv = pointer$iv4;
                        i = i7;
                        if (!dragEvent$iv2.isConsumed()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$1 = new DragGestureDetectorKt$awaitTouchSlopOrCancellation$1(continuation);
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
        Object $result22 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        PointerEventPass pointerEventPass3 = null;
        switch (dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0050 -> B:12:0x0053). Please report as a decompilation issue!!! */
    /* renamed from: drag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m592dragjO51t88(AwaitPointerEventScope $this$drag_u2djO51t88, long pointerId, Function1<? super PointerInputChange, Unit> function1, Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$drag$1 dragGestureDetectorKt$drag$1;
        DragGestureDetectorKt$drag$1 dragGestureDetectorKt$drag$12;
        AwaitPointerEventScope $this$drag_u2djO51t882;
        Function1 onDrag;
        Object $result;
        PointerInputChange change;
        if (continuation instanceof DragGestureDetectorKt$drag$1) {
            dragGestureDetectorKt$drag$1 = (DragGestureDetectorKt$drag$1) continuation;
            if ((dragGestureDetectorKt$drag$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$drag$1.label -= Integer.MIN_VALUE;
                dragGestureDetectorKt$drag$12 = dragGestureDetectorKt$drag$1;
                Object $result2 = dragGestureDetectorKt$drag$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dragGestureDetectorKt$drag$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        long pointer = pointerId;
                        $this$drag_u2djO51t882 = $this$drag_u2djO51t88;
                        onDrag = function1;
                        dragGestureDetectorKt$drag$12.L$0 = $this$drag_u2djO51t882;
                        dragGestureDetectorKt$drag$12.L$1 = onDrag;
                        dragGestureDetectorKt$drag$12.label = 1;
                        Object m578awaitDragOrCancellationrnUCldI = m578awaitDragOrCancellationrnUCldI($this$drag_u2djO51t882, pointer, dragGestureDetectorKt$drag$12);
                        if (m578awaitDragOrCancellationrnUCldI != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj = $result2;
                        $result2 = m578awaitDragOrCancellationrnUCldI;
                        $result = obj;
                        change = (PointerInputChange) $result2;
                        if (change == null) {
                            return Boxing.boxBoolean(false);
                        }
                        if (PointerEventKt.changedToUpIgnoreConsumed(change)) {
                            return Boxing.boxBoolean(true);
                        }
                        onDrag.invoke(change);
                        pointer = change.getId();
                        $result2 = $result;
                        dragGestureDetectorKt$drag$12.L$0 = $this$drag_u2djO51t882;
                        dragGestureDetectorKt$drag$12.L$1 = onDrag;
                        dragGestureDetectorKt$drag$12.label = 1;
                        Object m578awaitDragOrCancellationrnUCldI2 = m578awaitDragOrCancellationrnUCldI($this$drag_u2djO51t882, pointer, dragGestureDetectorKt$drag$12);
                        if (m578awaitDragOrCancellationrnUCldI2 != coroutine_suspended) {
                        }
                    case 1:
                        onDrag = (Function1) dragGestureDetectorKt$drag$12.L$1;
                        $this$drag_u2djO51t882 = (AwaitPointerEventScope) dragGestureDetectorKt$drag$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        $result = $result2;
                        change = (PointerInputChange) $result2;
                        if (change == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$drag$1 = new DragGestureDetectorKt$drag$1(continuation);
        dragGestureDetectorKt$drag$12 = dragGestureDetectorKt$drag$1;
        Object $result22 = dragGestureDetectorKt$drag$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dragGestureDetectorKt$drag$12.label) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00fe, code lost:
    
        if (androidx.compose.p000ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r2) != false) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0112 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0070 -> B:12:0x0079). Please report as a decompilation issue!!! */
    /* renamed from: awaitDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m578awaitDragOrCancellationrnUCldI(AwaitPointerEventScope $this$awaitDragOrCancellation_u2drnUCldI, long pointerId, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitDragOrCancellation$1 dragGestureDetectorKt$awaitDragOrCancellation$1;
        DragGestureDetectorKt$awaitDragOrCancellation$1 dragGestureDetectorKt$awaitDragOrCancellation$12;
        Object $result;
        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv;
        Ref.LongRef pointer$iv;
        AwaitPointerEventScope awaitPointerEventScope;
        Object obj;
        int index$iv$iv$iv;
        int size;
        Object $result2;
        Object obj2;
        Object it$iv$iv;
        PointerInputChange pointerInputChange;
        PointerInputChange dragEvent$iv;
        Object it$iv$iv2;
        PointerInputChange change;
        if (continuation instanceof DragGestureDetectorKt$awaitDragOrCancellation$1) {
            dragGestureDetectorKt$awaitDragOrCancellation$1 = (DragGestureDetectorKt$awaitDragOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitDragOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitDragOrCancellation$1.label -= Integer.MIN_VALUE;
                dragGestureDetectorKt$awaitDragOrCancellation$12 = dragGestureDetectorKt$awaitDragOrCancellation$1;
                Object $result3 = dragGestureDetectorKt$awaitDragOrCancellation$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = 1;
                PointerEventPass pointerEventPass = null;
                switch (dragGestureDetectorKt$awaitDragOrCancellation$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result3);
                        if (m594isPointerUpDmW0f2w($this$awaitDragOrCancellation_u2drnUCldI.getCurrentEvent(), pointerId)) {
                            return null;
                        }
                        Ref.LongRef pointer$iv2 = new Ref.LongRef();
                        pointer$iv2.element = pointerId;
                        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv2 = $this$awaitDragOrCancellation_u2drnUCldI;
                        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv3 = null;
                        Ref.LongRef pointer$iv3 = pointer$iv2;
                        dragGestureDetectorKt$awaitDragOrCancellation$12.L$0 = $this$awaitDragOrUp_u2djO51t88$iv2;
                        dragGestureDetectorKt$awaitDragOrCancellation$12.L$1 = pointer$iv3;
                        dragGestureDetectorKt$awaitDragOrCancellation$12.label = i;
                        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88$iv2, pointerEventPass, dragGestureDetectorKt$awaitDragOrCancellation$12, i, pointerEventPass);
                        if (awaitPointerEvent$default != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj3 = coroutine_suspended;
                        $result = $result3;
                        $result3 = awaitPointerEvent$default;
                        $this$awaitDragOrUp_u2djO51t88$iv = $this$awaitDragOrUp_u2djO51t88$iv2;
                        pointer$iv = pointer$iv3;
                        awaitPointerEventScope = $this$awaitDragOrUp_u2djO51t88$iv3;
                        obj = obj3;
                        PointerEvent event$iv = (PointerEvent) $result3;
                        List $this$fastForEach$iv$iv$iv = event$iv.getChanges();
                        index$iv$iv$iv = 0;
                        size = $this$fastForEach$iv$iv$iv.size();
                        while (true) {
                            if (index$iv$iv$iv >= size) {
                                Object item$iv$iv$iv = $this$fastForEach$iv$iv$iv.get(index$iv$iv$iv);
                                it$iv$iv = item$iv$iv$iv;
                                PointerInputChange it$iv = (PointerInputChange) it$iv$iv;
                                $result2 = $result;
                                obj2 = obj;
                                if (!PointerId.m3349equalsimpl0(it$iv.getId(), pointer$iv.element)) {
                                    index$iv$iv$iv++;
                                    $result = $result2;
                                    obj = obj2;
                                }
                            } else {
                                $result2 = $result;
                                obj2 = obj;
                                it$iv$iv = null;
                            }
                        }
                        pointerInputChange = (PointerInputChange) it$iv$iv;
                        if (pointerInputChange != null) {
                            dragEvent$iv = null;
                        } else {
                            dragEvent$iv = pointerInputChange;
                            if (!PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                                break;
                            } else {
                                List $this$fastForEach$iv$iv$iv2 = event$iv.getChanges();
                                int index$iv$iv$iv2 = 0;
                                int size2 = $this$fastForEach$iv$iv$iv2.size();
                                while (true) {
                                    if (index$iv$iv$iv2 < size2) {
                                        Object item$iv$iv$iv2 = $this$fastForEach$iv$iv$iv2.get(index$iv$iv$iv2);
                                        it$iv$iv2 = item$iv$iv$iv2;
                                        PointerInputChange it$iv2 = (PointerInputChange) it$iv$iv2;
                                        if (!it$iv2.getPressed()) {
                                            index$iv$iv$iv2++;
                                        }
                                    } else {
                                        it$iv$iv2 = null;
                                    }
                                }
                                PointerInputChange otherDown$iv = (PointerInputChange) it$iv$iv2;
                                if (otherDown$iv != null) {
                                    pointer$iv.element = otherDown$iv.getId();
                                    $result3 = $result2;
                                    coroutine_suspended = obj2;
                                    $this$awaitDragOrUp_u2djO51t88$iv3 = awaitPointerEventScope;
                                    pointer$iv3 = pointer$iv;
                                    $this$awaitDragOrUp_u2djO51t88$iv2 = $this$awaitDragOrUp_u2djO51t88$iv;
                                    i = 1;
                                    pointerEventPass = null;
                                }
                            }
                            dragGestureDetectorKt$awaitDragOrCancellation$12.L$0 = $this$awaitDragOrUp_u2djO51t88$iv2;
                            dragGestureDetectorKt$awaitDragOrCancellation$12.L$1 = pointer$iv3;
                            dragGestureDetectorKt$awaitDragOrCancellation$12.label = i;
                            Object awaitPointerEvent$default2 = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88$iv2, pointerEventPass, dragGestureDetectorKt$awaitDragOrCancellation$12, i, pointerEventPass);
                            if (awaitPointerEvent$default2 != coroutine_suspended) {
                            }
                        }
                        change = dragEvent$iv;
                        if (change == null && !change.isConsumed()) {
                            return null;
                        }
                        return change;
                    case 1:
                        Ref.LongRef pointer$iv4 = (Ref.LongRef) dragGestureDetectorKt$awaitDragOrCancellation$12.L$1;
                        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitDragOrCancellation$12.L$0;
                        ResultKt.throwOnFailure($result3);
                        $this$awaitDragOrUp_u2djO51t88$iv = $this$awaitDragOrUp_u2djO51t88$iv4;
                        pointer$iv = pointer$iv4;
                        awaitPointerEventScope = null;
                        obj = coroutine_suspended;
                        $result = $result3;
                        PointerEvent event$iv2 = (PointerEvent) $result3;
                        List $this$fastForEach$iv$iv$iv3 = event$iv2.getChanges();
                        index$iv$iv$iv = 0;
                        size = $this$fastForEach$iv$iv$iv3.size();
                        while (true) {
                            if (index$iv$iv$iv >= size) {
                            }
                            index$iv$iv$iv++;
                            $result = $result2;
                            obj = obj2;
                        }
                        pointerInputChange = (PointerInputChange) it$iv$iv;
                        if (pointerInputChange != null) {
                        }
                        change = dragEvent$iv;
                        if (change == null) {
                            break;
                        }
                        if (change == null && !change.isConsumed()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$awaitDragOrCancellation$1 = new DragGestureDetectorKt$awaitDragOrCancellation$1(continuation);
        dragGestureDetectorKt$awaitDragOrCancellation$12 = dragGestureDetectorKt$awaitDragOrCancellation$1;
        Object $result32 = dragGestureDetectorKt$awaitDragOrCancellation$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = 1;
        PointerEventPass pointerEventPass2 = null;
        switch (dragGestureDetectorKt$awaitDragOrCancellation$12.label) {
        }
    }

    public static final Object detectDragGestures(PointerInputScope $this$detectDragGestures, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture($this$detectDragGestures, new DragGestureDetectorKt$detectDragGestures$5(function1, function2, function02, function0, null), continuation);
        return forEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    public static final Object detectDragGesturesAfterLongPress(PointerInputScope $this$detectDragGesturesAfterLongPress, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture($this$detectDragGesturesAfterLongPress, new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(function02, function1, function0, function2, null), continuation);
        return forEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01f9 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0183 -> B:17:0x00bb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01e8 -> B:12:0x01f3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0248 -> B:17:0x00bb). Please report as a decompilation issue!!! */
    /* renamed from: awaitVerticalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m590awaitVerticalTouchSlopOrCancellationjO51t88(AwaitPointerEventScope awaitPointerEventScope, long pointerId, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
        DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12;
        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
        Function2 onTouchSlopReached;
        PointerDirectionConfig pointerDirectionConfig;
        int i;
        int i2;
        float touchSlop$iv;
        float totalMainPositionChange$iv;
        float totalCrossPositionChange$iv;
        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
        Ref.LongRef pointer$iv;
        int i3;
        int i4;
        Object obj;
        Object $result;
        List $this$fastForEach$iv$iv$iv;
        int $i$f$fastFirstOrNull;
        int size;
        int index$iv$iv$iv;
        Object obj2;
        Object it$iv$iv;
        PointerInputChange dragEvent$iv;
        long offset$iv;
        PointerInputChange dragEvent$iv2;
        PointerDirectionConfig pointerDirectionConfig2;
        Object it$iv$iv2;
        List $this$fastForEach$iv$iv$iv2;
        int $i$f$fastFirstOrNull2;
        int i5;
        Object awaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 = (DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label -= Integer.MIN_VALUE;
                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
                Object $result2 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                PointerEventPass pointerEventPass = null;
                switch (dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = awaitPointerEventScope;
                        onTouchSlopReached = function2;
                        int m3442getTouchT8wyACA = PointerType.INSTANCE.m3442getTouchT8wyACA();
                        pointerDirectionConfig = VerticalPointerDirectionConfig;
                        i = 1;
                        i2 = 0;
                        if (m594isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv.getCurrentEvent(), pointerId)) {
                            return null;
                        }
                        touchSlop$iv = m595pointerSlopE8SPZFQ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv.getViewConfiguration(), m3442getTouchT8wyACA);
                        Ref.LongRef pointer$iv2 = new Ref.LongRef();
                        pointer$iv2.element = pointerId;
                        totalMainPositionChange$iv = 0.0f;
                        totalCrossPositionChange$iv = 0.0f;
                        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = onTouchSlopReached;
                        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = pointer$iv2;
                        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass;
                        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.I$0 = i;
                        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = touchSlop$iv;
                        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$2 = totalCrossPositionChange$iv;
                        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = 1;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, pointerEventPass, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, 1, pointerEventPass);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj3 = coroutine_suspended;
                        $result = $result2;
                        $result2 = awaitPointerEvent$default;
                        pointer$iv = pointer$iv2;
                        i4 = i2;
                        i3 = i;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                        obj = obj3;
                        PointerEvent event$iv = (PointerEvent) $result2;
                        $this$fastForEach$iv$iv$iv = event$iv.getChanges();
                        $i$f$fastFirstOrNull = 0;
                        size = $this$fastForEach$iv$iv$iv.size();
                        Object $result3 = $result;
                        index$iv$iv$iv = 0;
                        while (true) {
                            if (index$iv$iv$iv >= size) {
                                Object item$iv$iv$iv = $this$fastForEach$iv$iv$iv.get(index$iv$iv$iv);
                                it$iv$iv = item$iv$iv$iv;
                                PointerInputChange it$iv = (PointerInputChange) it$iv$iv;
                                $this$fastForEach$iv$iv$iv2 = $this$fastForEach$iv$iv$iv;
                                $i$f$fastFirstOrNull2 = $i$f$fastFirstOrNull;
                                obj2 = obj;
                                i5 = size;
                                if (!PointerId.m3349equalsimpl0(it$iv.getId(), pointer$iv.element)) {
                                    index$iv$iv$iv++;
                                    $i$f$fastFirstOrNull = $i$f$fastFirstOrNull2;
                                    $this$fastForEach$iv$iv$iv = $this$fastForEach$iv$iv$iv2;
                                    obj = obj2;
                                    size = i5;
                                }
                            } else {
                                obj2 = obj;
                                it$iv$iv = null;
                            }
                        }
                        dragEvent$iv = (PointerInputChange) it$iv$iv;
                        if (dragEvent$iv != null && !dragEvent$iv.isConsumed()) {
                            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                                long currentPosition$iv = dragEvent$iv.getPosition();
                                long previousPosition$iv = dragEvent$iv.getPreviousPosition();
                                float mainPositionChange$iv = pointerDirectionConfig.mo598mainAxisDeltak4lQ0M(currentPosition$iv) - pointerDirectionConfig.mo598mainAxisDeltak4lQ0M(previousPosition$iv);
                                float crossPositionChange$iv = pointerDirectionConfig.mo597crossAxisDeltak4lQ0M(currentPosition$iv) - pointerDirectionConfig.mo597crossAxisDeltak4lQ0M(previousPosition$iv);
                                totalMainPositionChange$iv += mainPositionChange$iv;
                                totalCrossPositionChange$iv += crossPositionChange$iv;
                                float inDirection$iv = i3 != 0 ? Math.abs(totalMainPositionChange$iv) : Offset.m1758getDistanceimpl(pointerDirectionConfig.mo599offsetFromChangesdBAh8RU(totalMainPositionChange$iv, totalCrossPositionChange$iv));
                                if (inDirection$iv < touchSlop$iv) {
                                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = onTouchSlopReached;
                                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = pointer$iv;
                                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = dragEvent$iv;
                                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.I$0 = i3;
                                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = touchSlop$iv;
                                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$2 = totalCrossPositionChange$iv;
                                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = 2;
                                    Object obj4 = obj2;
                                    if ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2.awaitPointerEvent(pointerEventPass2, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12) == obj4) {
                                        return obj4;
                                    }
                                    $result2 = $result3;
                                    PointerDirectionConfig pointerDirectionConfig3 = pointerDirectionConfig;
                                    dragEvent$iv2 = dragEvent$iv;
                                    coroutine_suspended = obj4;
                                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                    i = i3;
                                    i2 = i4;
                                    pointerDirectionConfig2 = pointerDirectionConfig3;
                                    if (!dragEvent$iv2.isConsumed()) {
                                        return null;
                                    }
                                    pointerDirectionConfig = pointerDirectionConfig2;
                                    pointer$iv2 = pointer$iv;
                                    pointerEventPass = null;
                                } else {
                                    Object obj5 = obj2;
                                    if (i3 != 0) {
                                        float finalMainPositionChange$iv = totalMainPositionChange$iv - (Math.signum(totalMainPositionChange$iv) * touchSlop$iv);
                                        offset$iv = pointerDirectionConfig.mo599offsetFromChangesdBAh8RU(finalMainPositionChange$iv, totalCrossPositionChange$iv);
                                    } else {
                                        long offset$iv2 = pointerDirectionConfig.mo599offsetFromChangesdBAh8RU(totalMainPositionChange$iv, totalCrossPositionChange$iv);
                                        long touchSlopOffset$iv = Offset.m1767timestuRUvjQ(Offset.m1755divtuRUvjQ(offset$iv2, inDirection$iv), touchSlop$iv);
                                        offset$iv = Offset.m1764minusMKHz9U(offset$iv2, touchSlopOffset$iv);
                                    }
                                    long overSlop = offset$iv;
                                    DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$13 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12;
                                    onTouchSlopReached.invoke(dragEvent$iv, Boxing.boxFloat(Offset.m1761getYimpl(overSlop)));
                                    if (dragEvent$iv.isConsumed()) {
                                        return dragEvent$iv;
                                    }
                                    totalMainPositionChange$iv = 0.0f;
                                    totalCrossPositionChange$iv = 0.0f;
                                    $result2 = $result3;
                                    coroutine_suspended = obj5;
                                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                    i = i3;
                                    i2 = i4;
                                    pointer$iv2 = pointer$iv;
                                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$13;
                                    pointerEventPass = null;
                                }
                            } else {
                                List $this$fastForEach$iv$iv$iv3 = event$iv.getChanges();
                                int index$iv$iv$iv2 = 0;
                                int size2 = $this$fastForEach$iv$iv$iv3.size();
                                while (true) {
                                    if (index$iv$iv$iv2 < size2) {
                                        Object item$iv$iv$iv2 = $this$fastForEach$iv$iv$iv3.get(index$iv$iv$iv2);
                                        it$iv$iv2 = item$iv$iv$iv2;
                                        PointerInputChange it$iv2 = (PointerInputChange) it$iv$iv2;
                                        if (!it$iv2.getPressed()) {
                                            index$iv$iv$iv2++;
                                        }
                                    } else {
                                        it$iv$iv2 = null;
                                    }
                                }
                                PointerInputChange otherDown$iv = (PointerInputChange) it$iv$iv2;
                                if (otherDown$iv == null) {
                                    return null;
                                }
                                pointer$iv.element = otherDown$iv.getId();
                                $result2 = $result3;
                                coroutine_suspended = obj2;
                                $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                i = i3;
                                i2 = i4;
                                pointer$iv2 = pointer$iv;
                                pointerEventPass = null;
                            }
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = onTouchSlopReached;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = pointer$iv2;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.I$0 = i;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = touchSlop$iv;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$2 = totalCrossPositionChange$iv;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = 1;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, pointerEventPass, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, 1, pointerEventPass);
                            if (awaitPointerEvent$default == coroutine_suspended) {
                            }
                        }
                        return null;
                    case 1:
                        totalCrossPositionChange$iv = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$2;
                        totalMainPositionChange$iv = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$1;
                        float touchSlop$iv2 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0;
                        int i6 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.I$0;
                        Ref.LongRef pointer$iv3 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2;
                        PointerDirectionConfig pointerDirectionConfig4 = (PointerDirectionConfig) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1;
                        Function2 onTouchSlopReached2 = (Function2) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        pointer$iv = pointer$iv3;
                        pointerDirectionConfig = pointerDirectionConfig4;
                        i3 = i6;
                        touchSlop$iv = touchSlop$iv2;
                        onTouchSlopReached = onTouchSlopReached2;
                        i4 = 0;
                        obj = coroutine_suspended;
                        $result = $result2;
                        PointerEvent event$iv2 = (PointerEvent) $result2;
                        $this$fastForEach$iv$iv$iv = event$iv2.getChanges();
                        $i$f$fastFirstOrNull = 0;
                        size = $this$fastForEach$iv$iv$iv.size();
                        Object $result32 = $result;
                        index$iv$iv$iv = 0;
                        while (true) {
                            if (index$iv$iv$iv >= size) {
                            }
                            index$iv$iv$iv++;
                            $i$f$fastFirstOrNull = $i$f$fastFirstOrNull2;
                            $this$fastForEach$iv$iv$iv = $this$fastForEach$iv$iv$iv2;
                            obj = obj2;
                            size = i5;
                        }
                        dragEvent$iv = (PointerInputChange) it$iv$iv;
                        if (dragEvent$iv != null) {
                            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                            }
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = onTouchSlopReached;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = pointer$iv2;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.I$0 = i;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = touchSlop$iv;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$2 = totalCrossPositionChange$iv;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = 1;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, pointerEventPass, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, 1, pointerEventPass);
                            if (awaitPointerEvent$default == coroutine_suspended) {
                            }
                            break;
                        } else {
                            return null;
                        }
                        break;
                    case 2:
                        totalCrossPositionChange$iv = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$2;
                        totalMainPositionChange$iv = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$1;
                        float touchSlop$iv3 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0;
                        int i7 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.I$0;
                        dragEvent$iv2 = (PointerInputChange) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4;
                        Ref.LongRef pointer$iv4 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3;
                        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2;
                        pointerDirectionConfig2 = (PointerDirectionConfig) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1;
                        Function2 onTouchSlopReached3 = (Function2) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        i2 = 0;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv3;
                        touchSlop$iv = touchSlop$iv3;
                        onTouchSlopReached = onTouchSlopReached3;
                        pointer$iv = pointer$iv4;
                        i = i7;
                        if (!dragEvent$iv2.isConsumed()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 = new DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1(continuation);
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
        Object $result22 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        PointerEventPass pointerEventPass3 = null;
        switch (dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01f1 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x017c -> B:17:0x00b4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01e2 -> B:12:0x01eb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0240 -> B:17:0x00b4). Please report as a decompilation issue!!! */
    /* renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m589awaitVerticalPointerSlopOrCancellationgDDlDlE(AwaitPointerEventScope awaitPointerEventScope, long pointerId, int pointerType, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1;
        DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12;
        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
        Function2 onTouchSlopReached;
        PointerDirectionConfig pointerDirectionConfig;
        int i;
        int i2;
        float touchSlop$iv;
        float totalMainPositionChange$iv;
        float touchSlop$iv2;
        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
        Ref.LongRef pointer$iv;
        int i3;
        int i4;
        Object obj;
        Object $result;
        List $this$fastForEach$iv$iv$iv;
        int $i$f$fastFirstOrNull;
        int size;
        int index$iv$iv$iv;
        Object obj2;
        Object it$iv$iv;
        PointerInputChange dragEvent$iv;
        long postSlopOffset$iv;
        PointerDirectionConfig pointerDirectionConfig2;
        PointerInputChange dragEvent$iv2;
        Object it$iv$iv2;
        List $this$fastForEach$iv$iv$iv2;
        int $i$f$fastFirstOrNull2;
        int i5;
        Object awaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 = (DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label -= Integer.MIN_VALUE;
                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1;
                Object $result2 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                PointerEventPass pointerEventPass = null;
                switch (dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = awaitPointerEventScope;
                        onTouchSlopReached = function2;
                        pointerDirectionConfig = VerticalPointerDirectionConfig;
                        i = 1;
                        i2 = 0;
                        if (m594isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv.getCurrentEvent(), pointerId)) {
                            return null;
                        }
                        touchSlop$iv = m595pointerSlopE8SPZFQ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv.getViewConfiguration(), pointerType);
                        Ref.LongRef pointer$iv2 = new Ref.LongRef();
                        pointer$iv2.element = pointerId;
                        totalMainPositionChange$iv = 0.0f;
                        touchSlop$iv2 = 0.0f;
                        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$0 = onTouchSlopReached;
                        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$3 = pointer$iv2;
                        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$4 = pointerEventPass;
                        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.I$0 = i;
                        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$0 = touchSlop$iv;
                        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$2 = touchSlop$iv2;
                        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.label = 1;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, pointerEventPass, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12, 1, pointerEventPass);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj3 = coroutine_suspended;
                        $result = $result2;
                        $result2 = awaitPointerEvent$default;
                        pointer$iv = pointer$iv2;
                        i4 = i2;
                        i3 = i;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                        obj = obj3;
                        PointerEvent event$iv = (PointerEvent) $result2;
                        $this$fastForEach$iv$iv$iv = event$iv.getChanges();
                        $i$f$fastFirstOrNull = 0;
                        size = $this$fastForEach$iv$iv$iv.size();
                        Object $result3 = $result;
                        index$iv$iv$iv = 0;
                        while (true) {
                            if (index$iv$iv$iv >= size) {
                                Object item$iv$iv$iv = $this$fastForEach$iv$iv$iv.get(index$iv$iv$iv);
                                it$iv$iv = item$iv$iv$iv;
                                PointerInputChange it$iv = (PointerInputChange) it$iv$iv;
                                $this$fastForEach$iv$iv$iv2 = $this$fastForEach$iv$iv$iv;
                                $i$f$fastFirstOrNull2 = $i$f$fastFirstOrNull;
                                obj2 = obj;
                                i5 = size;
                                if (!PointerId.m3349equalsimpl0(it$iv.getId(), pointer$iv.element)) {
                                    index$iv$iv$iv++;
                                    $i$f$fastFirstOrNull = $i$f$fastFirstOrNull2;
                                    $this$fastForEach$iv$iv$iv = $this$fastForEach$iv$iv$iv2;
                                    obj = obj2;
                                    size = i5;
                                }
                            } else {
                                obj2 = obj;
                                it$iv$iv = null;
                            }
                        }
                        dragEvent$iv = (PointerInputChange) it$iv$iv;
                        if (dragEvent$iv != null && !dragEvent$iv.isConsumed()) {
                            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                                long currentPosition$iv = dragEvent$iv.getPosition();
                                long previousPosition$iv = dragEvent$iv.getPreviousPosition();
                                float mainPositionChange$iv = pointerDirectionConfig.mo598mainAxisDeltak4lQ0M(currentPosition$iv) - pointerDirectionConfig.mo598mainAxisDeltak4lQ0M(previousPosition$iv);
                                float crossPositionChange$iv = pointerDirectionConfig.mo597crossAxisDeltak4lQ0M(currentPosition$iv) - pointerDirectionConfig.mo597crossAxisDeltak4lQ0M(previousPosition$iv);
                                totalMainPositionChange$iv += mainPositionChange$iv;
                                float mainPositionChange$iv2 = touchSlop$iv2 + crossPositionChange$iv;
                                float inDirection$iv = i3 != 0 ? Math.abs(totalMainPositionChange$iv) : Offset.m1758getDistanceimpl(pointerDirectionConfig.mo599offsetFromChangesdBAh8RU(totalMainPositionChange$iv, mainPositionChange$iv2));
                                if (inDirection$iv < touchSlop$iv) {
                                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$0 = onTouchSlopReached;
                                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$3 = pointer$iv;
                                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$4 = dragEvent$iv;
                                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.I$0 = i3;
                                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$0 = touchSlop$iv;
                                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$2 = mainPositionChange$iv2;
                                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.label = 2;
                                    Object obj4 = obj2;
                                    if ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2.awaitPointerEvent(pointerEventPass2, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12) == obj4) {
                                        return obj4;
                                    }
                                    touchSlop$iv2 = mainPositionChange$iv2;
                                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                    i = i3;
                                    i2 = i4;
                                    $result2 = $result3;
                                    pointerDirectionConfig2 = pointerDirectionConfig;
                                    dragEvent$iv2 = dragEvent$iv;
                                    coroutine_suspended = obj4;
                                    if (!dragEvent$iv2.isConsumed()) {
                                        return null;
                                    }
                                    pointerDirectionConfig = pointerDirectionConfig2;
                                    pointer$iv2 = pointer$iv;
                                    pointerEventPass = null;
                                } else {
                                    Object obj5 = obj2;
                                    if (i3 != 0) {
                                        float finalMainPositionChange$iv = totalMainPositionChange$iv - (Math.signum(totalMainPositionChange$iv) * touchSlop$iv);
                                        postSlopOffset$iv = pointerDirectionConfig.mo599offsetFromChangesdBAh8RU(finalMainPositionChange$iv, mainPositionChange$iv2);
                                    } else {
                                        long offset$iv = pointerDirectionConfig.mo599offsetFromChangesdBAh8RU(totalMainPositionChange$iv, mainPositionChange$iv2);
                                        long touchSlopOffset$iv = Offset.m1767timestuRUvjQ(Offset.m1755divtuRUvjQ(offset$iv, inDirection$iv), touchSlop$iv);
                                        postSlopOffset$iv = Offset.m1764minusMKHz9U(offset$iv, touchSlopOffset$iv);
                                    }
                                    long overSlop = postSlopOffset$iv;
                                    DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$13 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12;
                                    onTouchSlopReached.invoke(dragEvent$iv, Boxing.boxFloat(Offset.m1761getYimpl(overSlop)));
                                    if (dragEvent$iv.isConsumed()) {
                                        return dragEvent$iv;
                                    }
                                    touchSlop$iv2 = 0.0f;
                                    $result2 = $result3;
                                    totalMainPositionChange$iv = 0.0f;
                                    coroutine_suspended = obj5;
                                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                    i = i3;
                                    i2 = i4;
                                    pointer$iv2 = pointer$iv;
                                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$13;
                                    pointerEventPass = null;
                                }
                            } else {
                                List $this$fastForEach$iv$iv$iv3 = event$iv.getChanges();
                                int index$iv$iv$iv2 = 0;
                                int size2 = $this$fastForEach$iv$iv$iv3.size();
                                while (true) {
                                    if (index$iv$iv$iv2 < size2) {
                                        Object item$iv$iv$iv2 = $this$fastForEach$iv$iv$iv3.get(index$iv$iv$iv2);
                                        it$iv$iv2 = item$iv$iv$iv2;
                                        PointerInputChange it$iv2 = (PointerInputChange) it$iv$iv2;
                                        if (!it$iv2.getPressed()) {
                                            index$iv$iv$iv2++;
                                        }
                                    } else {
                                        it$iv$iv2 = null;
                                    }
                                }
                                PointerInputChange otherDown$iv = (PointerInputChange) it$iv$iv2;
                                if (otherDown$iv == null) {
                                    return null;
                                }
                                pointer$iv.element = otherDown$iv.getId();
                                $result2 = $result3;
                                coroutine_suspended = obj2;
                                $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                i = i3;
                                i2 = i4;
                                pointer$iv2 = pointer$iv;
                                pointerEventPass = null;
                            }
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$0 = onTouchSlopReached;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$3 = pointer$iv2;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$4 = pointerEventPass;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.I$0 = i;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$0 = touchSlop$iv;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$2 = touchSlop$iv2;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.label = 1;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, pointerEventPass, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12, 1, pointerEventPass);
                            if (awaitPointerEvent$default == coroutine_suspended) {
                            }
                        }
                        return null;
                    case 1:
                        float totalCrossPositionChange$iv = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$2;
                        totalMainPositionChange$iv = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$1;
                        float touchSlop$iv3 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$0;
                        int i6 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.I$0;
                        Ref.LongRef pointer$iv3 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$3;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$2;
                        PointerDirectionConfig pointerDirectionConfig3 = (PointerDirectionConfig) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$1;
                        Function2 onTouchSlopReached2 = (Function2) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        pointer$iv = pointer$iv3;
                        pointerDirectionConfig = pointerDirectionConfig3;
                        i3 = i6;
                        touchSlop$iv = touchSlop$iv3;
                        touchSlop$iv2 = totalCrossPositionChange$iv;
                        onTouchSlopReached = onTouchSlopReached2;
                        i4 = 0;
                        obj = coroutine_suspended;
                        $result = $result2;
                        PointerEvent event$iv2 = (PointerEvent) $result2;
                        $this$fastForEach$iv$iv$iv = event$iv2.getChanges();
                        $i$f$fastFirstOrNull = 0;
                        size = $this$fastForEach$iv$iv$iv.size();
                        Object $result32 = $result;
                        index$iv$iv$iv = 0;
                        while (true) {
                            if (index$iv$iv$iv >= size) {
                            }
                            index$iv$iv$iv++;
                            $i$f$fastFirstOrNull = $i$f$fastFirstOrNull2;
                            $this$fastForEach$iv$iv$iv = $this$fastForEach$iv$iv$iv2;
                            obj = obj2;
                            size = i5;
                        }
                        dragEvent$iv = (PointerInputChange) it$iv$iv;
                        if (dragEvent$iv != null) {
                            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                            }
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$0 = onTouchSlopReached;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$3 = pointer$iv2;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$4 = pointerEventPass;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.I$0 = i;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$0 = touchSlop$iv;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$2 = touchSlop$iv2;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.label = 1;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, pointerEventPass, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12, 1, pointerEventPass);
                            if (awaitPointerEvent$default == coroutine_suspended) {
                            }
                            break;
                        } else {
                            return null;
                        }
                        break;
                    case 2:
                        float totalCrossPositionChange$iv2 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$2;
                        totalMainPositionChange$iv = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$1;
                        float touchSlop$iv4 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$0;
                        int i7 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.I$0;
                        dragEvent$iv2 = (PointerInputChange) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$4;
                        Ref.LongRef pointer$iv4 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$3;
                        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$2;
                        pointerDirectionConfig2 = (PointerDirectionConfig) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$1;
                        Function2 onTouchSlopReached3 = (Function2) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        i2 = 0;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv3;
                        touchSlop$iv2 = totalCrossPositionChange$iv2;
                        onTouchSlopReached = onTouchSlopReached3;
                        pointer$iv = pointer$iv4;
                        i = i7;
                        touchSlop$iv = touchSlop$iv4;
                        if (!dragEvent$iv2.isConsumed()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 = new DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1(continuation);
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1;
        Object $result22 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        PointerEventPass pointerEventPass3 = null;
        switch (dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0092 -> B:12:0x009e). Please report as a decompilation issue!!! */
    /* renamed from: verticalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m596verticalDragjO51t88(AwaitPointerEventScope awaitPointerEventScope, long pointerId, Function1<? super PointerInputChange, Unit> function1, Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$1;
        DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$12;
        Object $result;
        Function1 onDrag;
        AwaitPointerEventScope $this$drag_u2dVnAYq1g$iv;
        AwaitPointerEventScope $this$drag_u2dVnAYq1g$iv2;
        Ref.LongRef pointer$iv$iv;
        int i;
        int i2;
        Object obj;
        int size;
        int index$iv$iv$iv$iv;
        Object $result2;
        Object obj2;
        Object it$iv$iv$iv;
        PointerInputChange pointerInputChange;
        PointerInputChange dragEvent$iv$iv;
        boolean z;
        int i3;
        Object it$iv$iv$iv2;
        int i4;
        if (continuation instanceof DragGestureDetectorKt$verticalDrag$1) {
            dragGestureDetectorKt$verticalDrag$1 = (DragGestureDetectorKt$verticalDrag$1) continuation;
            if ((dragGestureDetectorKt$verticalDrag$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$verticalDrag$1.label -= Integer.MIN_VALUE;
                dragGestureDetectorKt$verticalDrag$12 = dragGestureDetectorKt$verticalDrag$1;
                Object $result3 = dragGestureDetectorKt$verticalDrag$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                PointerEventPass pointerEventPass = null;
                int i5 = 1;
                switch (dragGestureDetectorKt$verticalDrag$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result3);
                        AwaitPointerEventScope $this$drag_u2dVnAYq1g$iv3 = awaitPointerEventScope;
                        Function1 onDrag2 = function1;
                        int i6 = 0;
                        if (m594isPointerUpDmW0f2w($this$drag_u2dVnAYq1g$iv3.getCurrentEvent(), pointerId)) {
                            return Boxing.boxBoolean(false);
                        }
                        long pointer$iv = pointerId;
                        Ref.LongRef pointer$iv$iv2 = new Ref.LongRef();
                        pointer$iv$iv2.element = pointer$iv;
                        Function1 onDrag3 = onDrag2;
                        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv$iv = $this$drag_u2dVnAYq1g$iv3;
                        int i7 = 0;
                        Ref.LongRef pointer$iv$iv3 = pointer$iv$iv2;
                        int i8 = i6;
                        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv$iv2 = $this$drag_u2dVnAYq1g$iv3;
                        int i9 = i8;
                        dragGestureDetectorKt$verticalDrag$12.L$0 = onDrag3;
                        dragGestureDetectorKt$verticalDrag$12.L$1 = $this$awaitDragOrUp_u2djO51t88$iv$iv2;
                        dragGestureDetectorKt$verticalDrag$12.L$2 = $this$awaitDragOrUp_u2djO51t88$iv$iv;
                        dragGestureDetectorKt$verticalDrag$12.L$3 = pointer$iv$iv3;
                        dragGestureDetectorKt$verticalDrag$12.label = i5;
                        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88$iv$iv, pointerEventPass, dragGestureDetectorKt$verticalDrag$12, i5, pointerEventPass);
                        if (awaitPointerEvent$default != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj3 = coroutine_suspended;
                        $result = $result3;
                        $result3 = awaitPointerEvent$default;
                        onDrag = onDrag3;
                        $this$drag_u2dVnAYq1g$iv = $this$awaitDragOrUp_u2djO51t88$iv$iv2;
                        $this$drag_u2dVnAYq1g$iv2 = $this$awaitDragOrUp_u2djO51t88$iv$iv;
                        pointer$iv$iv = pointer$iv$iv3;
                        i = i7;
                        i2 = i9;
                        obj = obj3;
                        PointerEvent event$iv$iv = (PointerEvent) $result3;
                        List $this$fastForEach$iv$iv$iv$iv = event$iv$iv.getChanges();
                        size = $this$fastForEach$iv$iv$iv$iv.size();
                        index$iv$iv$iv$iv = 0;
                        while (true) {
                            if (index$iv$iv$iv$iv < size) {
                                Object item$iv$iv$iv$iv = $this$fastForEach$iv$iv$iv$iv.get(index$iv$iv$iv$iv);
                                it$iv$iv$iv = item$iv$iv$iv$iv;
                                PointerInputChange it$iv$iv = (PointerInputChange) it$iv$iv$iv;
                                i4 = size;
                                $result2 = $result;
                                obj2 = obj;
                                if (!PointerId.m3349equalsimpl0(it$iv$iv.getId(), pointer$iv$iv.element)) {
                                    index$iv$iv$iv$iv++;
                                    size = i4;
                                    $result = $result2;
                                    obj = obj2;
                                }
                            } else {
                                $result2 = $result;
                                obj2 = obj;
                                it$iv$iv$iv = null;
                            }
                        }
                        pointerInputChange = (PointerInputChange) it$iv$iv$iv;
                        if (pointerInputChange == null) {
                            dragEvent$iv$iv = null;
                        } else {
                            dragEvent$iv$iv = pointerInputChange;
                            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv$iv)) {
                                List $this$fastForEach$iv$iv$iv$iv2 = event$iv$iv.getChanges();
                                int index$iv$iv$iv$iv2 = 0;
                                int size2 = $this$fastForEach$iv$iv$iv$iv2.size();
                                while (true) {
                                    if (index$iv$iv$iv$iv2 < size2) {
                                        Object item$iv$iv$iv$iv2 = $this$fastForEach$iv$iv$iv$iv2.get(index$iv$iv$iv$iv2);
                                        it$iv$iv$iv2 = item$iv$iv$iv$iv2;
                                        PointerInputChange it$iv$iv2 = (PointerInputChange) it$iv$iv$iv2;
                                        if (!it$iv$iv2.getPressed()) {
                                            index$iv$iv$iv$iv2++;
                                        }
                                    } else {
                                        it$iv$iv$iv2 = null;
                                    }
                                }
                                PointerInputChange otherDown$iv$iv = (PointerInputChange) it$iv$iv$iv2;
                                if (otherDown$iv$iv != null) {
                                    pointer$iv$iv.element = otherDown$iv$iv.getId();
                                    z = false;
                                    i3 = 1;
                                    $result3 = $result2;
                                    coroutine_suspended = obj2;
                                    i5 = i3;
                                    pointerEventPass = null;
                                    i9 = i2;
                                    i7 = i;
                                    pointer$iv$iv3 = pointer$iv$iv;
                                    $this$awaitDragOrUp_u2djO51t88$iv$iv = $this$drag_u2dVnAYq1g$iv2;
                                    $this$awaitDragOrUp_u2djO51t88$iv$iv2 = $this$drag_u2dVnAYq1g$iv;
                                    onDrag3 = onDrag;
                                    dragGestureDetectorKt$verticalDrag$12.L$0 = onDrag3;
                                    dragGestureDetectorKt$verticalDrag$12.L$1 = $this$awaitDragOrUp_u2djO51t88$iv$iv2;
                                    dragGestureDetectorKt$verticalDrag$12.L$2 = $this$awaitDragOrUp_u2djO51t88$iv$iv;
                                    dragGestureDetectorKt$verticalDrag$12.L$3 = pointer$iv$iv3;
                                    dragGestureDetectorKt$verticalDrag$12.label = i5;
                                    Object awaitPointerEvent$default2 = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88$iv$iv, pointerEventPass, dragGestureDetectorKt$verticalDrag$12, i5, pointerEventPass);
                                    if (awaitPointerEvent$default2 != coroutine_suspended) {
                                    }
                                }
                            } else {
                                if (Offset.m1761getYimpl(PointerEventKt.positionChangeIgnoreConsumed(dragEvent$iv$iv)) == 0.0f) {
                                    z = false;
                                    i3 = 1;
                                    $result3 = $result2;
                                    coroutine_suspended = obj2;
                                    i5 = i3;
                                    pointerEventPass = null;
                                    i9 = i2;
                                    i7 = i;
                                    pointer$iv$iv3 = pointer$iv$iv;
                                    $this$awaitDragOrUp_u2djO51t88$iv$iv = $this$drag_u2dVnAYq1g$iv2;
                                    $this$awaitDragOrUp_u2djO51t88$iv$iv2 = $this$drag_u2dVnAYq1g$iv;
                                    onDrag3 = onDrag;
                                    dragGestureDetectorKt$verticalDrag$12.L$0 = onDrag3;
                                    dragGestureDetectorKt$verticalDrag$12.L$1 = $this$awaitDragOrUp_u2djO51t88$iv$iv2;
                                    dragGestureDetectorKt$verticalDrag$12.L$2 = $this$awaitDragOrUp_u2djO51t88$iv$iv;
                                    dragGestureDetectorKt$verticalDrag$12.L$3 = pointer$iv$iv3;
                                    dragGestureDetectorKt$verticalDrag$12.label = i5;
                                    Object awaitPointerEvent$default22 = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88$iv$iv, pointerEventPass, dragGestureDetectorKt$verticalDrag$12, i5, pointerEventPass);
                                    if (awaitPointerEvent$default22 != coroutine_suspended) {
                                    }
                                }
                            }
                            PointerEvent event$iv$iv2 = (PointerEvent) $result3;
                            List $this$fastForEach$iv$iv$iv$iv3 = event$iv$iv2.getChanges();
                            size = $this$fastForEach$iv$iv$iv$iv3.size();
                            index$iv$iv$iv$iv = 0;
                            while (true) {
                                if (index$iv$iv$iv$iv < size) {
                                }
                                index$iv$iv$iv$iv++;
                                size = i4;
                                $result = $result2;
                                obj = obj2;
                            }
                            pointerInputChange = (PointerInputChange) it$iv$iv$iv;
                            if (pointerInputChange == null) {
                            }
                        }
                        if (dragEvent$iv$iv != null) {
                            return Boxing.boxBoolean(false);
                        }
                        PointerInputChange change$iv = dragEvent$iv$iv;
                        if (dragEvent$iv$iv.isConsumed()) {
                            return Boxing.boxBoolean(false);
                        }
                        if (PointerEventKt.changedToUpIgnoreConsumed(change$iv)) {
                            return Boxing.boxBoolean(true);
                        }
                        onDrag.invoke(change$iv);
                        i5 = 1;
                        i6 = i2;
                        onDrag2 = onDrag;
                        pointerEventPass = null;
                        $this$drag_u2dVnAYq1g$iv3 = $this$drag_u2dVnAYq1g$iv;
                        pointer$iv = change$iv.getId();
                        $result3 = $result2;
                        coroutine_suspended = obj2;
                        Ref.LongRef pointer$iv$iv22 = new Ref.LongRef();
                        pointer$iv$iv22.element = pointer$iv;
                        Function1 onDrag32 = onDrag2;
                        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv$iv3 = $this$drag_u2dVnAYq1g$iv3;
                        int i72 = 0;
                        Ref.LongRef pointer$iv$iv32 = pointer$iv$iv22;
                        int i82 = i6;
                        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv$iv22 = $this$drag_u2dVnAYq1g$iv3;
                        int i92 = i82;
                        dragGestureDetectorKt$verticalDrag$12.L$0 = onDrag32;
                        dragGestureDetectorKt$verticalDrag$12.L$1 = $this$awaitDragOrUp_u2djO51t88$iv$iv22;
                        dragGestureDetectorKt$verticalDrag$12.L$2 = $this$awaitDragOrUp_u2djO51t88$iv$iv3;
                        dragGestureDetectorKt$verticalDrag$12.L$3 = pointer$iv$iv32;
                        dragGestureDetectorKt$verticalDrag$12.label = i5;
                        Object awaitPointerEvent$default222 = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88$iv$iv3, pointerEventPass, dragGestureDetectorKt$verticalDrag$12, i5, pointerEventPass);
                        if (awaitPointerEvent$default222 != coroutine_suspended) {
                        }
                    case 1:
                        Ref.LongRef pointer$iv$iv4 = (Ref.LongRef) dragGestureDetectorKt$verticalDrag$12.L$3;
                        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv$iv4 = (AwaitPointerEventScope) dragGestureDetectorKt$verticalDrag$12.L$2;
                        AwaitPointerEventScope $this$drag_u2dVnAYq1g$iv4 = (AwaitPointerEventScope) dragGestureDetectorKt$verticalDrag$12.L$1;
                        Function1 onDrag4 = (Function1) dragGestureDetectorKt$verticalDrag$12.L$0;
                        ResultKt.throwOnFailure($result3);
                        onDrag = onDrag4;
                        $this$drag_u2dVnAYq1g$iv = $this$drag_u2dVnAYq1g$iv4;
                        $this$drag_u2dVnAYq1g$iv2 = $this$awaitDragOrUp_u2djO51t88$iv$iv4;
                        pointer$iv$iv = pointer$iv$iv4;
                        i = 0;
                        i2 = 0;
                        obj = coroutine_suspended;
                        $result = $result3;
                        PointerEvent event$iv$iv22 = (PointerEvent) $result3;
                        List $this$fastForEach$iv$iv$iv$iv32 = event$iv$iv22.getChanges();
                        size = $this$fastForEach$iv$iv$iv$iv32.size();
                        index$iv$iv$iv$iv = 0;
                        while (true) {
                            if (index$iv$iv$iv$iv < size) {
                            }
                            index$iv$iv$iv$iv++;
                            size = i4;
                            $result = $result2;
                            obj = obj2;
                        }
                        pointerInputChange = (PointerInputChange) it$iv$iv$iv;
                        if (pointerInputChange == null) {
                        }
                        if (dragEvent$iv$iv != null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$verticalDrag$1 = new DragGestureDetectorKt$verticalDrag$1(continuation);
        dragGestureDetectorKt$verticalDrag$12 = dragGestureDetectorKt$verticalDrag$1;
        Object $result32 = dragGestureDetectorKt$verticalDrag$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        PointerEventPass pointerEventPass2 = null;
        int i52 = 1;
        switch (dragGestureDetectorKt$verticalDrag$12.label) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x010b, code lost:
    
        if (r1 == false) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x011e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0070 -> B:12:0x0079). Please report as a decompilation issue!!! */
    /* renamed from: awaitVerticalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m588awaitVerticalDragOrCancellationrnUCldI(AwaitPointerEventScope $this$awaitVerticalDragOrCancellation_u2drnUCldI, long pointerId, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 dragGestureDetectorKt$awaitVerticalDragOrCancellation$1;
        DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 dragGestureDetectorKt$awaitVerticalDragOrCancellation$12;
        Object $result;
        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv;
        Ref.LongRef pointer$iv;
        AwaitPointerEventScope awaitPointerEventScope;
        Object obj;
        int index$iv$iv$iv;
        int size;
        Object $result2;
        Object obj2;
        Object it$iv$iv;
        PointerInputChange pointerInputChange;
        PointerInputChange dragEvent$iv;
        boolean z;
        Object it$iv$iv2;
        PointerInputChange change;
        if (continuation instanceof DragGestureDetectorKt$awaitVerticalDragOrCancellation$1) {
            dragGestureDetectorKt$awaitVerticalDragOrCancellation$1 = (DragGestureDetectorKt$awaitVerticalDragOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label -= Integer.MIN_VALUE;
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$12 = dragGestureDetectorKt$awaitVerticalDragOrCancellation$1;
                Object $result3 = dragGestureDetectorKt$awaitVerticalDragOrCancellation$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = 1;
                PointerEventPass pointerEventPass = null;
                switch (dragGestureDetectorKt$awaitVerticalDragOrCancellation$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result3);
                        if (m594isPointerUpDmW0f2w($this$awaitVerticalDragOrCancellation_u2drnUCldI.getCurrentEvent(), pointerId)) {
                            return null;
                        }
                        Ref.LongRef pointer$iv2 = new Ref.LongRef();
                        pointer$iv2.element = pointerId;
                        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv2 = $this$awaitVerticalDragOrCancellation_u2drnUCldI;
                        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv3 = null;
                        Ref.LongRef pointer$iv3 = pointer$iv2;
                        dragGestureDetectorKt$awaitVerticalDragOrCancellation$12.L$0 = $this$awaitDragOrUp_u2djO51t88$iv2;
                        dragGestureDetectorKt$awaitVerticalDragOrCancellation$12.L$1 = pointer$iv3;
                        dragGestureDetectorKt$awaitVerticalDragOrCancellation$12.label = i;
                        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88$iv2, pointerEventPass, dragGestureDetectorKt$awaitVerticalDragOrCancellation$12, i, pointerEventPass);
                        if (awaitPointerEvent$default != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj3 = coroutine_suspended;
                        $result = $result3;
                        $result3 = awaitPointerEvent$default;
                        $this$awaitDragOrUp_u2djO51t88$iv = $this$awaitDragOrUp_u2djO51t88$iv2;
                        pointer$iv = pointer$iv3;
                        awaitPointerEventScope = $this$awaitDragOrUp_u2djO51t88$iv3;
                        obj = obj3;
                        PointerEvent event$iv = (PointerEvent) $result3;
                        List $this$fastForEach$iv$iv$iv = event$iv.getChanges();
                        index$iv$iv$iv = 0;
                        size = $this$fastForEach$iv$iv$iv.size();
                        while (true) {
                            if (index$iv$iv$iv >= size) {
                                Object item$iv$iv$iv = $this$fastForEach$iv$iv$iv.get(index$iv$iv$iv);
                                it$iv$iv = item$iv$iv$iv;
                                PointerInputChange it$iv = (PointerInputChange) it$iv$iv;
                                $result2 = $result;
                                obj2 = obj;
                                if (!PointerId.m3349equalsimpl0(it$iv.getId(), pointer$iv.element)) {
                                    index$iv$iv$iv++;
                                    $result = $result2;
                                    obj = obj2;
                                }
                            } else {
                                $result2 = $result;
                                obj2 = obj;
                                it$iv$iv = null;
                            }
                        }
                        pointerInputChange = (PointerInputChange) it$iv$iv;
                        if (pointerInputChange != null) {
                            dragEvent$iv = null;
                        } else {
                            dragEvent$iv = pointerInputChange;
                            if (!PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                                if (Offset.m1761getYimpl(PointerEventKt.positionChangeIgnoreConsumed(dragEvent$iv)) != 0.0f) {
                                    z = false;
                                    break;
                                } else {
                                    z = true;
                                    break;
                                }
                            } else {
                                List $this$fastForEach$iv$iv$iv2 = event$iv.getChanges();
                                int index$iv$iv$iv2 = 0;
                                int size2 = $this$fastForEach$iv$iv$iv2.size();
                                while (true) {
                                    if (index$iv$iv$iv2 < size2) {
                                        Object item$iv$iv$iv2 = $this$fastForEach$iv$iv$iv2.get(index$iv$iv$iv2);
                                        it$iv$iv2 = item$iv$iv$iv2;
                                        PointerInputChange it$iv2 = (PointerInputChange) it$iv$iv2;
                                        if (!it$iv2.getPressed()) {
                                            index$iv$iv$iv2++;
                                        }
                                    } else {
                                        it$iv$iv2 = null;
                                    }
                                }
                                PointerInputChange otherDown$iv = (PointerInputChange) it$iv$iv2;
                                if (otherDown$iv != null) {
                                    pointer$iv.element = otherDown$iv.getId();
                                    $result3 = $result2;
                                    coroutine_suspended = obj2;
                                    $this$awaitDragOrUp_u2djO51t88$iv3 = awaitPointerEventScope;
                                    pointer$iv3 = pointer$iv;
                                    $this$awaitDragOrUp_u2djO51t88$iv2 = $this$awaitDragOrUp_u2djO51t88$iv;
                                    i = 1;
                                    pointerEventPass = null;
                                }
                            }
                            dragGestureDetectorKt$awaitVerticalDragOrCancellation$12.L$0 = $this$awaitDragOrUp_u2djO51t88$iv2;
                            dragGestureDetectorKt$awaitVerticalDragOrCancellation$12.L$1 = pointer$iv3;
                            dragGestureDetectorKt$awaitVerticalDragOrCancellation$12.label = i;
                            Object awaitPointerEvent$default2 = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88$iv2, pointerEventPass, dragGestureDetectorKt$awaitVerticalDragOrCancellation$12, i, pointerEventPass);
                            if (awaitPointerEvent$default2 != coroutine_suspended) {
                            }
                        }
                        change = dragEvent$iv;
                        if (change == null && !change.isConsumed()) {
                            return null;
                        }
                        return change;
                    case 1:
                        Ref.LongRef pointer$iv4 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalDragOrCancellation$12.L$1;
                        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalDragOrCancellation$12.L$0;
                        ResultKt.throwOnFailure($result3);
                        $this$awaitDragOrUp_u2djO51t88$iv = $this$awaitDragOrUp_u2djO51t88$iv4;
                        pointer$iv = pointer$iv4;
                        awaitPointerEventScope = null;
                        obj = coroutine_suspended;
                        $result = $result3;
                        PointerEvent event$iv2 = (PointerEvent) $result3;
                        List $this$fastForEach$iv$iv$iv3 = event$iv2.getChanges();
                        index$iv$iv$iv = 0;
                        size = $this$fastForEach$iv$iv$iv3.size();
                        while (true) {
                            if (index$iv$iv$iv >= size) {
                            }
                            index$iv$iv$iv++;
                            $result = $result2;
                            obj = obj2;
                        }
                        pointerInputChange = (PointerInputChange) it$iv$iv;
                        if (pointerInputChange != null) {
                        }
                        change = dragEvent$iv;
                        if (change == null) {
                            break;
                        }
                        if (change == null && !change.isConsumed()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$awaitVerticalDragOrCancellation$1 = new DragGestureDetectorKt$awaitVerticalDragOrCancellation$1(continuation);
        dragGestureDetectorKt$awaitVerticalDragOrCancellation$12 = dragGestureDetectorKt$awaitVerticalDragOrCancellation$1;
        Object $result32 = dragGestureDetectorKt$awaitVerticalDragOrCancellation$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = 1;
        PointerEventPass pointerEventPass2 = null;
        switch (dragGestureDetectorKt$awaitVerticalDragOrCancellation$12.label) {
        }
    }

    public static final Object detectVerticalDragGestures(PointerInputScope $this$detectVerticalDragGestures, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture($this$detectVerticalDragGestures, new DragGestureDetectorKt$detectVerticalDragGestures$5(function1, function2, function0, function02, null), continuation);
        return forEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01f9 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0183 -> B:17:0x00bb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01e8 -> B:12:0x01f3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0248 -> B:17:0x00bb). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m582awaitHorizontalTouchSlopOrCancellationjO51t88(AwaitPointerEventScope awaitPointerEventScope, long pointerId, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
        DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12;
        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
        Function2 onTouchSlopReached;
        PointerDirectionConfig pointerDirectionConfig;
        int i;
        int i2;
        float touchSlop$iv;
        float totalMainPositionChange$iv;
        float totalCrossPositionChange$iv;
        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
        Ref.LongRef pointer$iv;
        int i3;
        int i4;
        Object obj;
        Object $result;
        List $this$fastForEach$iv$iv$iv;
        int $i$f$fastFirstOrNull;
        int size;
        int index$iv$iv$iv;
        Object obj2;
        Object it$iv$iv;
        PointerInputChange dragEvent$iv;
        long offset$iv;
        PointerInputChange dragEvent$iv2;
        PointerDirectionConfig pointerDirectionConfig2;
        Object it$iv$iv2;
        List $this$fastForEach$iv$iv$iv2;
        int $i$f$fastFirstOrNull2;
        int i5;
        Object awaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 = (DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label -= Integer.MIN_VALUE;
                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
                Object $result2 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                PointerEventPass pointerEventPass = null;
                switch (dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = awaitPointerEventScope;
                        onTouchSlopReached = function2;
                        int m3442getTouchT8wyACA = PointerType.INSTANCE.m3442getTouchT8wyACA();
                        pointerDirectionConfig = HorizontalPointerDirectionConfig;
                        i = 1;
                        i2 = 0;
                        if (m594isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv.getCurrentEvent(), pointerId)) {
                            return null;
                        }
                        touchSlop$iv = m595pointerSlopE8SPZFQ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv.getViewConfiguration(), m3442getTouchT8wyACA);
                        Ref.LongRef pointer$iv2 = new Ref.LongRef();
                        pointer$iv2.element = pointerId;
                        totalMainPositionChange$iv = 0.0f;
                        totalCrossPositionChange$iv = 0.0f;
                        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = onTouchSlopReached;
                        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = pointer$iv2;
                        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass;
                        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.I$0 = i;
                        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = touchSlop$iv;
                        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$2 = totalCrossPositionChange$iv;
                        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = 1;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, pointerEventPass, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, 1, pointerEventPass);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj3 = coroutine_suspended;
                        $result = $result2;
                        $result2 = awaitPointerEvent$default;
                        pointer$iv = pointer$iv2;
                        i4 = i2;
                        i3 = i;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                        obj = obj3;
                        PointerEvent event$iv = (PointerEvent) $result2;
                        $this$fastForEach$iv$iv$iv = event$iv.getChanges();
                        $i$f$fastFirstOrNull = 0;
                        size = $this$fastForEach$iv$iv$iv.size();
                        Object $result3 = $result;
                        index$iv$iv$iv = 0;
                        while (true) {
                            if (index$iv$iv$iv >= size) {
                                Object item$iv$iv$iv = $this$fastForEach$iv$iv$iv.get(index$iv$iv$iv);
                                it$iv$iv = item$iv$iv$iv;
                                PointerInputChange it$iv = (PointerInputChange) it$iv$iv;
                                $this$fastForEach$iv$iv$iv2 = $this$fastForEach$iv$iv$iv;
                                $i$f$fastFirstOrNull2 = $i$f$fastFirstOrNull;
                                obj2 = obj;
                                i5 = size;
                                if (!PointerId.m3349equalsimpl0(it$iv.getId(), pointer$iv.element)) {
                                    index$iv$iv$iv++;
                                    $i$f$fastFirstOrNull = $i$f$fastFirstOrNull2;
                                    $this$fastForEach$iv$iv$iv = $this$fastForEach$iv$iv$iv2;
                                    obj = obj2;
                                    size = i5;
                                }
                            } else {
                                obj2 = obj;
                                it$iv$iv = null;
                            }
                        }
                        dragEvent$iv = (PointerInputChange) it$iv$iv;
                        if (dragEvent$iv != null && !dragEvent$iv.isConsumed()) {
                            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                                long currentPosition$iv = dragEvent$iv.getPosition();
                                long previousPosition$iv = dragEvent$iv.getPreviousPosition();
                                float mainPositionChange$iv = pointerDirectionConfig.mo598mainAxisDeltak4lQ0M(currentPosition$iv) - pointerDirectionConfig.mo598mainAxisDeltak4lQ0M(previousPosition$iv);
                                float crossPositionChange$iv = pointerDirectionConfig.mo597crossAxisDeltak4lQ0M(currentPosition$iv) - pointerDirectionConfig.mo597crossAxisDeltak4lQ0M(previousPosition$iv);
                                totalMainPositionChange$iv += mainPositionChange$iv;
                                totalCrossPositionChange$iv += crossPositionChange$iv;
                                float inDirection$iv = i3 != 0 ? Math.abs(totalMainPositionChange$iv) : Offset.m1758getDistanceimpl(pointerDirectionConfig.mo599offsetFromChangesdBAh8RU(totalMainPositionChange$iv, totalCrossPositionChange$iv));
                                if (inDirection$iv < touchSlop$iv) {
                                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = onTouchSlopReached;
                                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = pointer$iv;
                                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = dragEvent$iv;
                                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.I$0 = i3;
                                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = touchSlop$iv;
                                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$2 = totalCrossPositionChange$iv;
                                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = 2;
                                    Object obj4 = obj2;
                                    if ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2.awaitPointerEvent(pointerEventPass2, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12) == obj4) {
                                        return obj4;
                                    }
                                    $result2 = $result3;
                                    PointerDirectionConfig pointerDirectionConfig3 = pointerDirectionConfig;
                                    dragEvent$iv2 = dragEvent$iv;
                                    coroutine_suspended = obj4;
                                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                    i = i3;
                                    i2 = i4;
                                    pointerDirectionConfig2 = pointerDirectionConfig3;
                                    if (!dragEvent$iv2.isConsumed()) {
                                        return null;
                                    }
                                    pointerDirectionConfig = pointerDirectionConfig2;
                                    pointer$iv2 = pointer$iv;
                                    pointerEventPass = null;
                                } else {
                                    Object obj5 = obj2;
                                    if (i3 != 0) {
                                        float finalMainPositionChange$iv = totalMainPositionChange$iv - (Math.signum(totalMainPositionChange$iv) * touchSlop$iv);
                                        offset$iv = pointerDirectionConfig.mo599offsetFromChangesdBAh8RU(finalMainPositionChange$iv, totalCrossPositionChange$iv);
                                    } else {
                                        long offset$iv2 = pointerDirectionConfig.mo599offsetFromChangesdBAh8RU(totalMainPositionChange$iv, totalCrossPositionChange$iv);
                                        long touchSlopOffset$iv = Offset.m1767timestuRUvjQ(Offset.m1755divtuRUvjQ(offset$iv2, inDirection$iv), touchSlop$iv);
                                        offset$iv = Offset.m1764minusMKHz9U(offset$iv2, touchSlopOffset$iv);
                                    }
                                    long overSlop = offset$iv;
                                    DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$13 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12;
                                    onTouchSlopReached.invoke(dragEvent$iv, Boxing.boxFloat(Offset.m1760getXimpl(overSlop)));
                                    if (dragEvent$iv.isConsumed()) {
                                        return dragEvent$iv;
                                    }
                                    totalMainPositionChange$iv = 0.0f;
                                    totalCrossPositionChange$iv = 0.0f;
                                    $result2 = $result3;
                                    coroutine_suspended = obj5;
                                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                    i = i3;
                                    i2 = i4;
                                    pointer$iv2 = pointer$iv;
                                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$13;
                                    pointerEventPass = null;
                                }
                            } else {
                                List $this$fastForEach$iv$iv$iv3 = event$iv.getChanges();
                                int index$iv$iv$iv2 = 0;
                                int size2 = $this$fastForEach$iv$iv$iv3.size();
                                while (true) {
                                    if (index$iv$iv$iv2 < size2) {
                                        Object item$iv$iv$iv2 = $this$fastForEach$iv$iv$iv3.get(index$iv$iv$iv2);
                                        it$iv$iv2 = item$iv$iv$iv2;
                                        PointerInputChange it$iv2 = (PointerInputChange) it$iv$iv2;
                                        if (!it$iv2.getPressed()) {
                                            index$iv$iv$iv2++;
                                        }
                                    } else {
                                        it$iv$iv2 = null;
                                    }
                                }
                                PointerInputChange otherDown$iv = (PointerInputChange) it$iv$iv2;
                                if (otherDown$iv == null) {
                                    return null;
                                }
                                pointer$iv.element = otherDown$iv.getId();
                                $result2 = $result3;
                                coroutine_suspended = obj2;
                                $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                i = i3;
                                i2 = i4;
                                pointer$iv2 = pointer$iv;
                                pointerEventPass = null;
                            }
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = onTouchSlopReached;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = pointer$iv2;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.I$0 = i;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = touchSlop$iv;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$2 = totalCrossPositionChange$iv;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = 1;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, pointerEventPass, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, 1, pointerEventPass);
                            if (awaitPointerEvent$default == coroutine_suspended) {
                            }
                        }
                        return null;
                    case 1:
                        totalCrossPositionChange$iv = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$2;
                        totalMainPositionChange$iv = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$1;
                        float touchSlop$iv2 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0;
                        int i6 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.I$0;
                        Ref.LongRef pointer$iv3 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2;
                        PointerDirectionConfig pointerDirectionConfig4 = (PointerDirectionConfig) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1;
                        Function2 onTouchSlopReached2 = (Function2) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        pointer$iv = pointer$iv3;
                        pointerDirectionConfig = pointerDirectionConfig4;
                        i3 = i6;
                        touchSlop$iv = touchSlop$iv2;
                        onTouchSlopReached = onTouchSlopReached2;
                        i4 = 0;
                        obj = coroutine_suspended;
                        $result = $result2;
                        PointerEvent event$iv2 = (PointerEvent) $result2;
                        $this$fastForEach$iv$iv$iv = event$iv2.getChanges();
                        $i$f$fastFirstOrNull = 0;
                        size = $this$fastForEach$iv$iv$iv.size();
                        Object $result32 = $result;
                        index$iv$iv$iv = 0;
                        while (true) {
                            if (index$iv$iv$iv >= size) {
                            }
                            index$iv$iv$iv++;
                            $i$f$fastFirstOrNull = $i$f$fastFirstOrNull2;
                            $this$fastForEach$iv$iv$iv = $this$fastForEach$iv$iv$iv2;
                            obj = obj2;
                            size = i5;
                        }
                        dragEvent$iv = (PointerInputChange) it$iv$iv;
                        if (dragEvent$iv != null) {
                            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                            }
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = onTouchSlopReached;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = pointer$iv2;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.I$0 = i;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = touchSlop$iv;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$2 = totalCrossPositionChange$iv;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = 1;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, pointerEventPass, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, 1, pointerEventPass);
                            if (awaitPointerEvent$default == coroutine_suspended) {
                            }
                            break;
                        } else {
                            return null;
                        }
                        break;
                    case 2:
                        totalCrossPositionChange$iv = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$2;
                        totalMainPositionChange$iv = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$1;
                        float touchSlop$iv3 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0;
                        int i7 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.I$0;
                        dragEvent$iv2 = (PointerInputChange) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4;
                        Ref.LongRef pointer$iv4 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3;
                        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2;
                        pointerDirectionConfig2 = (PointerDirectionConfig) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1;
                        Function2 onTouchSlopReached3 = (Function2) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        i2 = 0;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv3;
                        touchSlop$iv = touchSlop$iv3;
                        onTouchSlopReached = onTouchSlopReached3;
                        pointer$iv = pointer$iv4;
                        i = i7;
                        if (!dragEvent$iv2.isConsumed()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 = new DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1(continuation);
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
        Object $result22 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        PointerEventPass pointerEventPass3 = null;
        switch (dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01f1 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x017c -> B:17:0x00b4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01e2 -> B:12:0x01eb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0240 -> B:17:0x00b4). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m581awaitHorizontalPointerSlopOrCancellationgDDlDlE(AwaitPointerEventScope awaitPointerEventScope, long pointerId, int pointerType, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1;
        DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12;
        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
        Function2 onPointerSlopReached;
        PointerDirectionConfig pointerDirectionConfig;
        int i;
        int i2;
        float touchSlop$iv;
        float totalMainPositionChange$iv;
        float touchSlop$iv2;
        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
        Ref.LongRef pointer$iv;
        int i3;
        int i4;
        Object obj;
        Object $result;
        List $this$fastForEach$iv$iv$iv;
        int $i$f$fastFirstOrNull;
        int size;
        int index$iv$iv$iv;
        Object obj2;
        Object it$iv$iv;
        PointerInputChange dragEvent$iv;
        long postSlopOffset$iv;
        PointerDirectionConfig pointerDirectionConfig2;
        PointerInputChange dragEvent$iv2;
        Object it$iv$iv2;
        List $this$fastForEach$iv$iv$iv2;
        int $i$f$fastFirstOrNull2;
        int i5;
        Object awaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 = (DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label -= Integer.MIN_VALUE;
                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1;
                Object $result2 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                PointerEventPass pointerEventPass = null;
                switch (dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = awaitPointerEventScope;
                        onPointerSlopReached = function2;
                        pointerDirectionConfig = HorizontalPointerDirectionConfig;
                        i = 1;
                        i2 = 0;
                        if (m594isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv.getCurrentEvent(), pointerId)) {
                            return null;
                        }
                        touchSlop$iv = m595pointerSlopE8SPZFQ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv.getViewConfiguration(), pointerType);
                        Ref.LongRef pointer$iv2 = new Ref.LongRef();
                        pointer$iv2.element = pointerId;
                        totalMainPositionChange$iv = 0.0f;
                        touchSlop$iv2 = 0.0f;
                        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$0 = onPointerSlopReached;
                        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$3 = pointer$iv2;
                        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$4 = pointerEventPass;
                        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.I$0 = i;
                        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$0 = touchSlop$iv;
                        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$2 = touchSlop$iv2;
                        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.label = 1;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, pointerEventPass, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12, 1, pointerEventPass);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj3 = coroutine_suspended;
                        $result = $result2;
                        $result2 = awaitPointerEvent$default;
                        pointer$iv = pointer$iv2;
                        i4 = i2;
                        i3 = i;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                        obj = obj3;
                        PointerEvent event$iv = (PointerEvent) $result2;
                        $this$fastForEach$iv$iv$iv = event$iv.getChanges();
                        $i$f$fastFirstOrNull = 0;
                        size = $this$fastForEach$iv$iv$iv.size();
                        Object $result3 = $result;
                        index$iv$iv$iv = 0;
                        while (true) {
                            if (index$iv$iv$iv >= size) {
                                Object item$iv$iv$iv = $this$fastForEach$iv$iv$iv.get(index$iv$iv$iv);
                                it$iv$iv = item$iv$iv$iv;
                                PointerInputChange it$iv = (PointerInputChange) it$iv$iv;
                                $this$fastForEach$iv$iv$iv2 = $this$fastForEach$iv$iv$iv;
                                $i$f$fastFirstOrNull2 = $i$f$fastFirstOrNull;
                                obj2 = obj;
                                i5 = size;
                                if (!PointerId.m3349equalsimpl0(it$iv.getId(), pointer$iv.element)) {
                                    index$iv$iv$iv++;
                                    $i$f$fastFirstOrNull = $i$f$fastFirstOrNull2;
                                    $this$fastForEach$iv$iv$iv = $this$fastForEach$iv$iv$iv2;
                                    obj = obj2;
                                    size = i5;
                                }
                            } else {
                                obj2 = obj;
                                it$iv$iv = null;
                            }
                        }
                        dragEvent$iv = (PointerInputChange) it$iv$iv;
                        if (dragEvent$iv != null && !dragEvent$iv.isConsumed()) {
                            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                                long currentPosition$iv = dragEvent$iv.getPosition();
                                long previousPosition$iv = dragEvent$iv.getPreviousPosition();
                                float mainPositionChange$iv = pointerDirectionConfig.mo598mainAxisDeltak4lQ0M(currentPosition$iv) - pointerDirectionConfig.mo598mainAxisDeltak4lQ0M(previousPosition$iv);
                                float crossPositionChange$iv = pointerDirectionConfig.mo597crossAxisDeltak4lQ0M(currentPosition$iv) - pointerDirectionConfig.mo597crossAxisDeltak4lQ0M(previousPosition$iv);
                                totalMainPositionChange$iv += mainPositionChange$iv;
                                float mainPositionChange$iv2 = touchSlop$iv2 + crossPositionChange$iv;
                                float inDirection$iv = i3 != 0 ? Math.abs(totalMainPositionChange$iv) : Offset.m1758getDistanceimpl(pointerDirectionConfig.mo599offsetFromChangesdBAh8RU(totalMainPositionChange$iv, mainPositionChange$iv2));
                                if (inDirection$iv < touchSlop$iv) {
                                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$0 = onPointerSlopReached;
                                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$3 = pointer$iv;
                                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$4 = dragEvent$iv;
                                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.I$0 = i3;
                                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$0 = touchSlop$iv;
                                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$2 = mainPositionChange$iv2;
                                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.label = 2;
                                    Object obj4 = obj2;
                                    if ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2.awaitPointerEvent(pointerEventPass2, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12) == obj4) {
                                        return obj4;
                                    }
                                    touchSlop$iv2 = mainPositionChange$iv2;
                                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                    i = i3;
                                    i2 = i4;
                                    $result2 = $result3;
                                    pointerDirectionConfig2 = pointerDirectionConfig;
                                    dragEvent$iv2 = dragEvent$iv;
                                    coroutine_suspended = obj4;
                                    if (!dragEvent$iv2.isConsumed()) {
                                        return null;
                                    }
                                    pointerDirectionConfig = pointerDirectionConfig2;
                                    pointer$iv2 = pointer$iv;
                                    pointerEventPass = null;
                                } else {
                                    Object obj5 = obj2;
                                    if (i3 != 0) {
                                        float finalMainPositionChange$iv = totalMainPositionChange$iv - (Math.signum(totalMainPositionChange$iv) * touchSlop$iv);
                                        postSlopOffset$iv = pointerDirectionConfig.mo599offsetFromChangesdBAh8RU(finalMainPositionChange$iv, mainPositionChange$iv2);
                                    } else {
                                        long offset$iv = pointerDirectionConfig.mo599offsetFromChangesdBAh8RU(totalMainPositionChange$iv, mainPositionChange$iv2);
                                        long touchSlopOffset$iv = Offset.m1767timestuRUvjQ(Offset.m1755divtuRUvjQ(offset$iv, inDirection$iv), touchSlop$iv);
                                        postSlopOffset$iv = Offset.m1764minusMKHz9U(offset$iv, touchSlopOffset$iv);
                                    }
                                    long overSlop = postSlopOffset$iv;
                                    DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$13 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12;
                                    onPointerSlopReached.invoke(dragEvent$iv, Boxing.boxFloat(Offset.m1760getXimpl(overSlop)));
                                    if (dragEvent$iv.isConsumed()) {
                                        return dragEvent$iv;
                                    }
                                    touchSlop$iv2 = 0.0f;
                                    $result2 = $result3;
                                    totalMainPositionChange$iv = 0.0f;
                                    coroutine_suspended = obj5;
                                    $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                    i = i3;
                                    i2 = i4;
                                    pointer$iv2 = pointer$iv;
                                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$13;
                                    pointerEventPass = null;
                                }
                            } else {
                                List $this$fastForEach$iv$iv$iv3 = event$iv.getChanges();
                                int index$iv$iv$iv2 = 0;
                                int size2 = $this$fastForEach$iv$iv$iv3.size();
                                while (true) {
                                    if (index$iv$iv$iv2 < size2) {
                                        Object item$iv$iv$iv2 = $this$fastForEach$iv$iv$iv3.get(index$iv$iv$iv2);
                                        it$iv$iv2 = item$iv$iv$iv2;
                                        PointerInputChange it$iv2 = (PointerInputChange) it$iv$iv2;
                                        if (!it$iv2.getPressed()) {
                                            index$iv$iv$iv2++;
                                        }
                                    } else {
                                        it$iv$iv2 = null;
                                    }
                                }
                                PointerInputChange otherDown$iv = (PointerInputChange) it$iv$iv2;
                                if (otherDown$iv == null) {
                                    return null;
                                }
                                pointer$iv.element = otherDown$iv.getId();
                                $result2 = $result3;
                                coroutine_suspended = obj2;
                                $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2;
                                i = i3;
                                i2 = i4;
                                pointer$iv2 = pointer$iv;
                                pointerEventPass = null;
                            }
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$0 = onPointerSlopReached;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$3 = pointer$iv2;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$4 = pointerEventPass;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.I$0 = i;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$0 = touchSlop$iv;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$2 = touchSlop$iv2;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.label = 1;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, pointerEventPass, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12, 1, pointerEventPass);
                            if (awaitPointerEvent$default == coroutine_suspended) {
                            }
                        }
                        return null;
                    case 1:
                        float totalCrossPositionChange$iv = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$2;
                        totalMainPositionChange$iv = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$1;
                        float touchSlop$iv3 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$0;
                        int i6 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.I$0;
                        Ref.LongRef pointer$iv3 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$3;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv2 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$2;
                        PointerDirectionConfig pointerDirectionConfig3 = (PointerDirectionConfig) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$1;
                        Function2 onPointerSlopReached2 = (Function2) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        pointer$iv = pointer$iv3;
                        pointerDirectionConfig = pointerDirectionConfig3;
                        i3 = i6;
                        touchSlop$iv = touchSlop$iv3;
                        touchSlop$iv2 = totalCrossPositionChange$iv;
                        onPointerSlopReached = onPointerSlopReached2;
                        i4 = 0;
                        obj = coroutine_suspended;
                        $result = $result2;
                        PointerEvent event$iv2 = (PointerEvent) $result2;
                        $this$fastForEach$iv$iv$iv = event$iv2.getChanges();
                        $i$f$fastFirstOrNull = 0;
                        size = $this$fastForEach$iv$iv$iv.size();
                        Object $result32 = $result;
                        index$iv$iv$iv = 0;
                        while (true) {
                            if (index$iv$iv$iv >= size) {
                            }
                            index$iv$iv$iv++;
                            $i$f$fastFirstOrNull = $i$f$fastFirstOrNull2;
                            $this$fastForEach$iv$iv$iv = $this$fastForEach$iv$iv$iv2;
                            obj = obj2;
                            size = i5;
                        }
                        dragEvent$iv = (PointerInputChange) it$iv$iv;
                        if (dragEvent$iv != null) {
                            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                            }
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$0 = onPointerSlopReached;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$3 = pointer$iv2;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$4 = pointerEventPass;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.I$0 = i;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$0 = touchSlop$iv;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$1 = totalMainPositionChange$iv;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$2 = touchSlop$iv2;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.label = 1;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv, pointerEventPass, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12, 1, pointerEventPass);
                            if (awaitPointerEvent$default == coroutine_suspended) {
                            }
                            break;
                        } else {
                            return null;
                        }
                        break;
                    case 2:
                        float totalCrossPositionChange$iv2 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$2;
                        totalMainPositionChange$iv = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$1;
                        float touchSlop$iv4 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$0;
                        int i7 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.I$0;
                        dragEvent$iv2 = (PointerInputChange) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$4;
                        Ref.LongRef pointer$iv4 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$3;
                        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$2;
                        pointerDirectionConfig2 = (PointerDirectionConfig) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$1;
                        Function2 onPointerSlopReached3 = (Function2) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        i2 = 0;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv3;
                        touchSlop$iv2 = totalCrossPositionChange$iv2;
                        onPointerSlopReached = onPointerSlopReached3;
                        pointer$iv = pointer$iv4;
                        i = i7;
                        touchSlop$iv = touchSlop$iv4;
                        if (!dragEvent$iv2.isConsumed()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 = new DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1(continuation);
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1;
        Object $result22 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        PointerEventPass pointerEventPass3 = null;
        switch (dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0092 -> B:12:0x009e). Please report as a decompilation issue!!! */
    /* renamed from: horizontalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m593horizontalDragjO51t88(AwaitPointerEventScope awaitPointerEventScope, long pointerId, Function1<? super PointerInputChange, Unit> function1, Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$1;
        DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$12;
        Object $result;
        Function1 onDrag;
        AwaitPointerEventScope $this$drag_u2dVnAYq1g$iv;
        AwaitPointerEventScope $this$drag_u2dVnAYq1g$iv2;
        Ref.LongRef pointer$iv$iv;
        int i;
        int i2;
        Object obj;
        int size;
        int index$iv$iv$iv$iv;
        Object $result2;
        Object obj2;
        Object it$iv$iv$iv;
        PointerInputChange pointerInputChange;
        PointerInputChange dragEvent$iv$iv;
        boolean z;
        int i3;
        Object it$iv$iv$iv2;
        int i4;
        if (continuation instanceof DragGestureDetectorKt$horizontalDrag$1) {
            dragGestureDetectorKt$horizontalDrag$1 = (DragGestureDetectorKt$horizontalDrag$1) continuation;
            if ((dragGestureDetectorKt$horizontalDrag$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$horizontalDrag$1.label -= Integer.MIN_VALUE;
                dragGestureDetectorKt$horizontalDrag$12 = dragGestureDetectorKt$horizontalDrag$1;
                Object $result3 = dragGestureDetectorKt$horizontalDrag$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                PointerEventPass pointerEventPass = null;
                int i5 = 1;
                switch (dragGestureDetectorKt$horizontalDrag$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result3);
                        AwaitPointerEventScope $this$drag_u2dVnAYq1g$iv3 = awaitPointerEventScope;
                        Function1 onDrag2 = function1;
                        int i6 = 0;
                        if (m594isPointerUpDmW0f2w($this$drag_u2dVnAYq1g$iv3.getCurrentEvent(), pointerId)) {
                            return Boxing.boxBoolean(false);
                        }
                        long pointer$iv = pointerId;
                        Ref.LongRef pointer$iv$iv2 = new Ref.LongRef();
                        pointer$iv$iv2.element = pointer$iv;
                        Function1 onDrag3 = onDrag2;
                        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv$iv = $this$drag_u2dVnAYq1g$iv3;
                        int i7 = 0;
                        Ref.LongRef pointer$iv$iv3 = pointer$iv$iv2;
                        int i8 = i6;
                        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv$iv2 = $this$drag_u2dVnAYq1g$iv3;
                        int i9 = i8;
                        dragGestureDetectorKt$horizontalDrag$12.L$0 = onDrag3;
                        dragGestureDetectorKt$horizontalDrag$12.L$1 = $this$awaitDragOrUp_u2djO51t88$iv$iv2;
                        dragGestureDetectorKt$horizontalDrag$12.L$2 = $this$awaitDragOrUp_u2djO51t88$iv$iv;
                        dragGestureDetectorKt$horizontalDrag$12.L$3 = pointer$iv$iv3;
                        dragGestureDetectorKt$horizontalDrag$12.label = i5;
                        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88$iv$iv, pointerEventPass, dragGestureDetectorKt$horizontalDrag$12, i5, pointerEventPass);
                        if (awaitPointerEvent$default != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj3 = coroutine_suspended;
                        $result = $result3;
                        $result3 = awaitPointerEvent$default;
                        onDrag = onDrag3;
                        $this$drag_u2dVnAYq1g$iv = $this$awaitDragOrUp_u2djO51t88$iv$iv2;
                        $this$drag_u2dVnAYq1g$iv2 = $this$awaitDragOrUp_u2djO51t88$iv$iv;
                        pointer$iv$iv = pointer$iv$iv3;
                        i = i7;
                        i2 = i9;
                        obj = obj3;
                        PointerEvent event$iv$iv = (PointerEvent) $result3;
                        List $this$fastForEach$iv$iv$iv$iv = event$iv$iv.getChanges();
                        size = $this$fastForEach$iv$iv$iv$iv.size();
                        index$iv$iv$iv$iv = 0;
                        while (true) {
                            if (index$iv$iv$iv$iv < size) {
                                Object item$iv$iv$iv$iv = $this$fastForEach$iv$iv$iv$iv.get(index$iv$iv$iv$iv);
                                it$iv$iv$iv = item$iv$iv$iv$iv;
                                PointerInputChange it$iv$iv = (PointerInputChange) it$iv$iv$iv;
                                i4 = size;
                                $result2 = $result;
                                obj2 = obj;
                                if (!PointerId.m3349equalsimpl0(it$iv$iv.getId(), pointer$iv$iv.element)) {
                                    index$iv$iv$iv$iv++;
                                    size = i4;
                                    $result = $result2;
                                    obj = obj2;
                                }
                            } else {
                                $result2 = $result;
                                obj2 = obj;
                                it$iv$iv$iv = null;
                            }
                        }
                        pointerInputChange = (PointerInputChange) it$iv$iv$iv;
                        if (pointerInputChange == null) {
                            dragEvent$iv$iv = null;
                        } else {
                            dragEvent$iv$iv = pointerInputChange;
                            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv$iv)) {
                                List $this$fastForEach$iv$iv$iv$iv2 = event$iv$iv.getChanges();
                                int index$iv$iv$iv$iv2 = 0;
                                int size2 = $this$fastForEach$iv$iv$iv$iv2.size();
                                while (true) {
                                    if (index$iv$iv$iv$iv2 < size2) {
                                        Object item$iv$iv$iv$iv2 = $this$fastForEach$iv$iv$iv$iv2.get(index$iv$iv$iv$iv2);
                                        it$iv$iv$iv2 = item$iv$iv$iv$iv2;
                                        PointerInputChange it$iv$iv2 = (PointerInputChange) it$iv$iv$iv2;
                                        if (!it$iv$iv2.getPressed()) {
                                            index$iv$iv$iv$iv2++;
                                        }
                                    } else {
                                        it$iv$iv$iv2 = null;
                                    }
                                }
                                PointerInputChange otherDown$iv$iv = (PointerInputChange) it$iv$iv$iv2;
                                if (otherDown$iv$iv != null) {
                                    pointer$iv$iv.element = otherDown$iv$iv.getId();
                                    z = false;
                                    i3 = 1;
                                    $result3 = $result2;
                                    coroutine_suspended = obj2;
                                    i5 = i3;
                                    pointerEventPass = null;
                                    i9 = i2;
                                    i7 = i;
                                    pointer$iv$iv3 = pointer$iv$iv;
                                    $this$awaitDragOrUp_u2djO51t88$iv$iv = $this$drag_u2dVnAYq1g$iv2;
                                    $this$awaitDragOrUp_u2djO51t88$iv$iv2 = $this$drag_u2dVnAYq1g$iv;
                                    onDrag3 = onDrag;
                                    dragGestureDetectorKt$horizontalDrag$12.L$0 = onDrag3;
                                    dragGestureDetectorKt$horizontalDrag$12.L$1 = $this$awaitDragOrUp_u2djO51t88$iv$iv2;
                                    dragGestureDetectorKt$horizontalDrag$12.L$2 = $this$awaitDragOrUp_u2djO51t88$iv$iv;
                                    dragGestureDetectorKt$horizontalDrag$12.L$3 = pointer$iv$iv3;
                                    dragGestureDetectorKt$horizontalDrag$12.label = i5;
                                    Object awaitPointerEvent$default2 = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88$iv$iv, pointerEventPass, dragGestureDetectorKt$horizontalDrag$12, i5, pointerEventPass);
                                    if (awaitPointerEvent$default2 != coroutine_suspended) {
                                    }
                                }
                            } else {
                                if (Offset.m1760getXimpl(PointerEventKt.positionChangeIgnoreConsumed(dragEvent$iv$iv)) == 0.0f) {
                                    z = false;
                                    i3 = 1;
                                    $result3 = $result2;
                                    coroutine_suspended = obj2;
                                    i5 = i3;
                                    pointerEventPass = null;
                                    i9 = i2;
                                    i7 = i;
                                    pointer$iv$iv3 = pointer$iv$iv;
                                    $this$awaitDragOrUp_u2djO51t88$iv$iv = $this$drag_u2dVnAYq1g$iv2;
                                    $this$awaitDragOrUp_u2djO51t88$iv$iv2 = $this$drag_u2dVnAYq1g$iv;
                                    onDrag3 = onDrag;
                                    dragGestureDetectorKt$horizontalDrag$12.L$0 = onDrag3;
                                    dragGestureDetectorKt$horizontalDrag$12.L$1 = $this$awaitDragOrUp_u2djO51t88$iv$iv2;
                                    dragGestureDetectorKt$horizontalDrag$12.L$2 = $this$awaitDragOrUp_u2djO51t88$iv$iv;
                                    dragGestureDetectorKt$horizontalDrag$12.L$3 = pointer$iv$iv3;
                                    dragGestureDetectorKt$horizontalDrag$12.label = i5;
                                    Object awaitPointerEvent$default22 = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88$iv$iv, pointerEventPass, dragGestureDetectorKt$horizontalDrag$12, i5, pointerEventPass);
                                    if (awaitPointerEvent$default22 != coroutine_suspended) {
                                    }
                                }
                            }
                            PointerEvent event$iv$iv2 = (PointerEvent) $result3;
                            List $this$fastForEach$iv$iv$iv$iv3 = event$iv$iv2.getChanges();
                            size = $this$fastForEach$iv$iv$iv$iv3.size();
                            index$iv$iv$iv$iv = 0;
                            while (true) {
                                if (index$iv$iv$iv$iv < size) {
                                }
                                index$iv$iv$iv$iv++;
                                size = i4;
                                $result = $result2;
                                obj = obj2;
                            }
                            pointerInputChange = (PointerInputChange) it$iv$iv$iv;
                            if (pointerInputChange == null) {
                            }
                        }
                        if (dragEvent$iv$iv != null) {
                            return Boxing.boxBoolean(false);
                        }
                        PointerInputChange change$iv = dragEvent$iv$iv;
                        if (dragEvent$iv$iv.isConsumed()) {
                            return Boxing.boxBoolean(false);
                        }
                        if (PointerEventKt.changedToUpIgnoreConsumed(change$iv)) {
                            return Boxing.boxBoolean(true);
                        }
                        onDrag.invoke(change$iv);
                        i5 = 1;
                        i6 = i2;
                        onDrag2 = onDrag;
                        pointerEventPass = null;
                        $this$drag_u2dVnAYq1g$iv3 = $this$drag_u2dVnAYq1g$iv;
                        pointer$iv = change$iv.getId();
                        $result3 = $result2;
                        coroutine_suspended = obj2;
                        Ref.LongRef pointer$iv$iv22 = new Ref.LongRef();
                        pointer$iv$iv22.element = pointer$iv;
                        Function1 onDrag32 = onDrag2;
                        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv$iv3 = $this$drag_u2dVnAYq1g$iv3;
                        int i72 = 0;
                        Ref.LongRef pointer$iv$iv32 = pointer$iv$iv22;
                        int i82 = i6;
                        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv$iv22 = $this$drag_u2dVnAYq1g$iv3;
                        int i92 = i82;
                        dragGestureDetectorKt$horizontalDrag$12.L$0 = onDrag32;
                        dragGestureDetectorKt$horizontalDrag$12.L$1 = $this$awaitDragOrUp_u2djO51t88$iv$iv22;
                        dragGestureDetectorKt$horizontalDrag$12.L$2 = $this$awaitDragOrUp_u2djO51t88$iv$iv3;
                        dragGestureDetectorKt$horizontalDrag$12.L$3 = pointer$iv$iv32;
                        dragGestureDetectorKt$horizontalDrag$12.label = i5;
                        Object awaitPointerEvent$default222 = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88$iv$iv3, pointerEventPass, dragGestureDetectorKt$horizontalDrag$12, i5, pointerEventPass);
                        if (awaitPointerEvent$default222 != coroutine_suspended) {
                        }
                    case 1:
                        Ref.LongRef pointer$iv$iv4 = (Ref.LongRef) dragGestureDetectorKt$horizontalDrag$12.L$3;
                        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv$iv4 = (AwaitPointerEventScope) dragGestureDetectorKt$horizontalDrag$12.L$2;
                        AwaitPointerEventScope $this$drag_u2dVnAYq1g$iv4 = (AwaitPointerEventScope) dragGestureDetectorKt$horizontalDrag$12.L$1;
                        Function1 onDrag4 = (Function1) dragGestureDetectorKt$horizontalDrag$12.L$0;
                        ResultKt.throwOnFailure($result3);
                        onDrag = onDrag4;
                        $this$drag_u2dVnAYq1g$iv = $this$drag_u2dVnAYq1g$iv4;
                        $this$drag_u2dVnAYq1g$iv2 = $this$awaitDragOrUp_u2djO51t88$iv$iv4;
                        pointer$iv$iv = pointer$iv$iv4;
                        i = 0;
                        i2 = 0;
                        obj = coroutine_suspended;
                        $result = $result3;
                        PointerEvent event$iv$iv22 = (PointerEvent) $result3;
                        List $this$fastForEach$iv$iv$iv$iv32 = event$iv$iv22.getChanges();
                        size = $this$fastForEach$iv$iv$iv$iv32.size();
                        index$iv$iv$iv$iv = 0;
                        while (true) {
                            if (index$iv$iv$iv$iv < size) {
                            }
                            index$iv$iv$iv$iv++;
                            size = i4;
                            $result = $result2;
                            obj = obj2;
                        }
                        pointerInputChange = (PointerInputChange) it$iv$iv$iv;
                        if (pointerInputChange == null) {
                        }
                        if (dragEvent$iv$iv != null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$horizontalDrag$1 = new DragGestureDetectorKt$horizontalDrag$1(continuation);
        dragGestureDetectorKt$horizontalDrag$12 = dragGestureDetectorKt$horizontalDrag$1;
        Object $result32 = dragGestureDetectorKt$horizontalDrag$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        PointerEventPass pointerEventPass2 = null;
        int i52 = 1;
        switch (dragGestureDetectorKt$horizontalDrag$12.label) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x010b, code lost:
    
        if (r1 == false) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x011e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0070 -> B:12:0x0079). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m580awaitHorizontalDragOrCancellationrnUCldI(AwaitPointerEventScope $this$awaitHorizontalDragOrCancellation_u2drnUCldI, long pointerId, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1;
        DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 dragGestureDetectorKt$awaitHorizontalDragOrCancellation$12;
        Object $result;
        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv;
        Ref.LongRef pointer$iv;
        AwaitPointerEventScope awaitPointerEventScope;
        Object obj;
        int index$iv$iv$iv;
        int size;
        Object $result2;
        Object obj2;
        Object it$iv$iv;
        PointerInputChange pointerInputChange;
        PointerInputChange dragEvent$iv;
        boolean z;
        Object it$iv$iv2;
        PointerInputChange change;
        if (continuation instanceof DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1) {
            dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 = (DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label -= Integer.MIN_VALUE;
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1;
                Object $result3 = dragGestureDetectorKt$awaitHorizontalDragOrCancellation$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = 1;
                PointerEventPass pointerEventPass = null;
                switch (dragGestureDetectorKt$awaitHorizontalDragOrCancellation$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result3);
                        if (m594isPointerUpDmW0f2w($this$awaitHorizontalDragOrCancellation_u2drnUCldI.getCurrentEvent(), pointerId)) {
                            return null;
                        }
                        Ref.LongRef pointer$iv2 = new Ref.LongRef();
                        pointer$iv2.element = pointerId;
                        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv2 = $this$awaitHorizontalDragOrCancellation_u2drnUCldI;
                        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv3 = null;
                        Ref.LongRef pointer$iv3 = pointer$iv2;
                        dragGestureDetectorKt$awaitHorizontalDragOrCancellation$12.L$0 = $this$awaitDragOrUp_u2djO51t88$iv2;
                        dragGestureDetectorKt$awaitHorizontalDragOrCancellation$12.L$1 = pointer$iv3;
                        dragGestureDetectorKt$awaitHorizontalDragOrCancellation$12.label = i;
                        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88$iv2, pointerEventPass, dragGestureDetectorKt$awaitHorizontalDragOrCancellation$12, i, pointerEventPass);
                        if (awaitPointerEvent$default != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj3 = coroutine_suspended;
                        $result = $result3;
                        $result3 = awaitPointerEvent$default;
                        $this$awaitDragOrUp_u2djO51t88$iv = $this$awaitDragOrUp_u2djO51t88$iv2;
                        pointer$iv = pointer$iv3;
                        awaitPointerEventScope = $this$awaitDragOrUp_u2djO51t88$iv3;
                        obj = obj3;
                        PointerEvent event$iv = (PointerEvent) $result3;
                        List $this$fastForEach$iv$iv$iv = event$iv.getChanges();
                        index$iv$iv$iv = 0;
                        size = $this$fastForEach$iv$iv$iv.size();
                        while (true) {
                            if (index$iv$iv$iv >= size) {
                                Object item$iv$iv$iv = $this$fastForEach$iv$iv$iv.get(index$iv$iv$iv);
                                it$iv$iv = item$iv$iv$iv;
                                PointerInputChange it$iv = (PointerInputChange) it$iv$iv;
                                $result2 = $result;
                                obj2 = obj;
                                if (!PointerId.m3349equalsimpl0(it$iv.getId(), pointer$iv.element)) {
                                    index$iv$iv$iv++;
                                    $result = $result2;
                                    obj = obj2;
                                }
                            } else {
                                $result2 = $result;
                                obj2 = obj;
                                it$iv$iv = null;
                            }
                        }
                        pointerInputChange = (PointerInputChange) it$iv$iv;
                        if (pointerInputChange != null) {
                            dragEvent$iv = null;
                        } else {
                            dragEvent$iv = pointerInputChange;
                            if (!PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                                if (Offset.m1760getXimpl(PointerEventKt.positionChangeIgnoreConsumed(dragEvent$iv)) != 0.0f) {
                                    z = false;
                                    break;
                                } else {
                                    z = true;
                                    break;
                                }
                            } else {
                                List $this$fastForEach$iv$iv$iv2 = event$iv.getChanges();
                                int index$iv$iv$iv2 = 0;
                                int size2 = $this$fastForEach$iv$iv$iv2.size();
                                while (true) {
                                    if (index$iv$iv$iv2 < size2) {
                                        Object item$iv$iv$iv2 = $this$fastForEach$iv$iv$iv2.get(index$iv$iv$iv2);
                                        it$iv$iv2 = item$iv$iv$iv2;
                                        PointerInputChange it$iv2 = (PointerInputChange) it$iv$iv2;
                                        if (!it$iv2.getPressed()) {
                                            index$iv$iv$iv2++;
                                        }
                                    } else {
                                        it$iv$iv2 = null;
                                    }
                                }
                                PointerInputChange otherDown$iv = (PointerInputChange) it$iv$iv2;
                                if (otherDown$iv != null) {
                                    pointer$iv.element = otherDown$iv.getId();
                                    $result3 = $result2;
                                    coroutine_suspended = obj2;
                                    $this$awaitDragOrUp_u2djO51t88$iv3 = awaitPointerEventScope;
                                    pointer$iv3 = pointer$iv;
                                    $this$awaitDragOrUp_u2djO51t88$iv2 = $this$awaitDragOrUp_u2djO51t88$iv;
                                    i = 1;
                                    pointerEventPass = null;
                                }
                            }
                            dragGestureDetectorKt$awaitHorizontalDragOrCancellation$12.L$0 = $this$awaitDragOrUp_u2djO51t88$iv2;
                            dragGestureDetectorKt$awaitHorizontalDragOrCancellation$12.L$1 = pointer$iv3;
                            dragGestureDetectorKt$awaitHorizontalDragOrCancellation$12.label = i;
                            Object awaitPointerEvent$default2 = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88$iv2, pointerEventPass, dragGestureDetectorKt$awaitHorizontalDragOrCancellation$12, i, pointerEventPass);
                            if (awaitPointerEvent$default2 != coroutine_suspended) {
                            }
                        }
                        change = dragEvent$iv;
                        if (change == null && !change.isConsumed()) {
                            return null;
                        }
                        return change;
                    case 1:
                        Ref.LongRef pointer$iv4 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalDragOrCancellation$12.L$1;
                        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalDragOrCancellation$12.L$0;
                        ResultKt.throwOnFailure($result3);
                        $this$awaitDragOrUp_u2djO51t88$iv = $this$awaitDragOrUp_u2djO51t88$iv4;
                        pointer$iv = pointer$iv4;
                        awaitPointerEventScope = null;
                        obj = coroutine_suspended;
                        $result = $result3;
                        PointerEvent event$iv2 = (PointerEvent) $result3;
                        List $this$fastForEach$iv$iv$iv3 = event$iv2.getChanges();
                        index$iv$iv$iv = 0;
                        size = $this$fastForEach$iv$iv$iv3.size();
                        while (true) {
                            if (index$iv$iv$iv >= size) {
                            }
                            index$iv$iv$iv++;
                            $result = $result2;
                            obj = obj2;
                        }
                        pointerInputChange = (PointerInputChange) it$iv$iv;
                        if (pointerInputChange != null) {
                        }
                        change = dragEvent$iv;
                        if (change == null) {
                            break;
                        }
                        if (change == null && !change.isConsumed()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 = new DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1(continuation);
        dragGestureDetectorKt$awaitHorizontalDragOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1;
        Object $result32 = dragGestureDetectorKt$awaitHorizontalDragOrCancellation$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = 1;
        PointerEventPass pointerEventPass2 = null;
        switch (dragGestureDetectorKt$awaitHorizontalDragOrCancellation$12.label) {
        }
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope $this$detectHorizontalDragGestures, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture($this$detectHorizontalDragGestures, new DragGestureDetectorKt$detectHorizontalDragGestures$5(function1, function2, function0, function02, null), continuation);
        return forEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    /* renamed from: drag-VnAYq1g, reason: not valid java name */
    private static final Object m591dragVnAYq1g(AwaitPointerEventScope $this$drag_u2dVnAYq1g, long pointerId, Function1<? super PointerInputChange, Unit> function1, Function1<? super PointerInputChange, Float> function12, Function1<? super PointerInputChange, Boolean> function13, Continuation<? super Boolean> continuation) {
        int i;
        AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv;
        Object it$iv$iv;
        PointerInputChange dragEvent$iv;
        Object obj;
        int i2 = 0;
        int i3 = 0;
        if (m594isPointerUpDmW0f2w($this$drag_u2dVnAYq1g.getCurrentEvent(), pointerId)) {
            return false;
        }
        long pointer = pointerId;
        while (true) {
            AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88$iv2 = $this$drag_u2dVnAYq1g;
            long pointer$iv = pointer;
            while (true) {
                InlineMarker.mark(i3);
                Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88$iv2, null, continuation, 1, null);
                InlineMarker.mark(1);
                PointerEvent event$iv = (PointerEvent) awaitPointerEvent$default;
                List $this$fastForEach$iv$iv$iv = event$iv.getChanges();
                int size = $this$fastForEach$iv$iv$iv.size();
                int index$iv$iv$iv = 0;
                while (true) {
                    if (index$iv$iv$iv >= size) {
                        i = i2;
                        $this$awaitDragOrUp_u2djO51t88$iv = $this$awaitDragOrUp_u2djO51t88$iv2;
                        it$iv$iv = null;
                        break;
                    }
                    List $this$fastForEach$iv$iv$iv2 = $this$fastForEach$iv$iv$iv;
                    it$iv$iv = $this$fastForEach$iv$iv$iv2.get(index$iv$iv$iv);
                    PointerInputChange it$iv = (PointerInputChange) it$iv$iv;
                    i = i2;
                    $this$awaitDragOrUp_u2djO51t88$iv = $this$awaitDragOrUp_u2djO51t88$iv2;
                    if (PointerId.m3349equalsimpl0(it$iv.getId(), pointer$iv)) {
                        break;
                    }
                    index$iv$iv$iv++;
                    $this$fastForEach$iv$iv$iv = $this$fastForEach$iv$iv$iv2;
                    i2 = i;
                    $this$awaitDragOrUp_u2djO51t88$iv2 = $this$awaitDragOrUp_u2djO51t88$iv;
                }
                PointerInputChange pointerInputChange = (PointerInputChange) it$iv$iv;
                if (pointerInputChange == null) {
                    dragEvent$iv = null;
                    break;
                }
                dragEvent$iv = pointerInputChange;
                if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                    List $this$fastFirstOrNull$iv$iv = event$iv.getChanges();
                    int index$iv$iv$iv2 = 0;
                    int size2 = $this$fastFirstOrNull$iv$iv.size();
                    while (true) {
                        if (index$iv$iv$iv2 >= size2) {
                            obj = null;
                            break;
                        }
                        Object item$iv$iv$iv = $this$fastFirstOrNull$iv$iv.get(index$iv$iv$iv2);
                        PointerInputChange it$iv2 = (PointerInputChange) item$iv$iv$iv;
                        if (it$iv2.getPressed()) {
                            obj = item$iv$iv$iv;
                            break;
                        }
                        index$iv$iv$iv2++;
                    }
                    PointerInputChange otherDown$iv = (PointerInputChange) obj;
                    if (otherDown$iv == null) {
                        break;
                    }
                    pointer$iv = otherDown$iv.getId();
                    i2 = i;
                    $this$awaitDragOrUp_u2djO51t88$iv2 = $this$awaitDragOrUp_u2djO51t88$iv;
                    i3 = 0;
                } else {
                    if (!(function12.invoke(dragEvent$iv).floatValue() == 0.0f)) {
                        break;
                    }
                    i2 = i;
                    $this$awaitDragOrUp_u2djO51t88$iv2 = $this$awaitDragOrUp_u2djO51t88$iv;
                    i3 = 0;
                }
            }
            if (dragEvent$iv == null || function13.invoke(dragEvent$iv).booleanValue()) {
                return false;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent$iv)) {
                return true;
            }
            function1.invoke(dragEvent$iv);
            pointer = dragEvent$iv.getId();
            i2 = i;
            i3 = 0;
        }
    }

    /* renamed from: awaitDragOrUp-jO51t88, reason: not valid java name */
    private static final Object m579awaitDragOrUpjO51t88(AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88, long pointerId, Function1<? super PointerInputChange, Boolean> function1, Continuation<? super PointerInputChange> continuation) {
        PointerEvent event;
        Object it$iv;
        Object it$iv2;
        long pointer = pointerId;
        while (true) {
            InlineMarker.mark(0);
            Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitDragOrUp_u2djO51t88, null, continuation, 1, null);
            InlineMarker.mark(1);
            PointerEvent event2 = (PointerEvent) awaitPointerEvent$default;
            List $this$fastFirstOrNull$iv = event2.getChanges();
            int index$iv$iv = 0;
            int size = $this$fastFirstOrNull$iv.size();
            while (true) {
                if (index$iv$iv >= size) {
                    event = event2;
                    it$iv = null;
                    break;
                }
                Object item$iv$iv = $this$fastFirstOrNull$iv.get(index$iv$iv);
                it$iv = item$iv$iv;
                PointerInputChange it = (PointerInputChange) it$iv;
                event = event2;
                if (PointerId.m3349equalsimpl0(it.getId(), pointer)) {
                    break;
                }
                index$iv$iv++;
                event2 = event;
            }
            PointerInputChange dragEvent = (PointerInputChange) it$iv;
            if (dragEvent == null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent)) {
                List $this$fastFirstOrNull$iv2 = event.getChanges();
                int index$iv$iv2 = 0;
                int size2 = $this$fastFirstOrNull$iv2.size();
                while (true) {
                    if (index$iv$iv2 >= size2) {
                        it$iv2 = null;
                        break;
                    }
                    Object item$iv$iv2 = $this$fastFirstOrNull$iv2.get(index$iv$iv2);
                    it$iv2 = item$iv$iv2;
                    PointerInputChange it2 = (PointerInputChange) it$iv2;
                    if (it2.getPressed()) {
                        break;
                    }
                    index$iv$iv2++;
                }
                PointerInputChange otherDown = (PointerInputChange) it$iv2;
                if (otherDown == null) {
                    return dragEvent;
                }
                pointer = otherDown.getId();
            } else if (function1.invoke(dragEvent).booleanValue()) {
                return dragEvent;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01e5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x016f -> B:17:0x00b2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x01d3 -> B:12:0x01df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0226 -> B:17:0x00b2). Please report as a decompilation issue!!! */
    /* renamed from: awaitPointerSlopOrCancellation-wtdNQyU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m584awaitPointerSlopOrCancellationwtdNQyU(AwaitPointerEventScope awaitPointerEventScope, long pointerId, int pointerType, PointerDirectionConfig pointerDirectionConfig, boolean z, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitPointerSlopOrCancellation$1;
        DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitPointerSlopOrCancellation$12;
        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU;
        Function2 onPointerSlopReached;
        PointerDirectionConfig pointerDirectionConfig2;
        boolean triggerOnMainAxisSlop;
        float touchSlop;
        Ref.LongRef pointer;
        float touchSlop2;
        float totalCrossPositionChange;
        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU2;
        Ref.LongRef pointer2;
        Object obj;
        Object $result;
        List $this$fastForEach$iv$iv;
        int $i$f$fastFirstOrNull;
        int size;
        int index$iv$iv;
        Object obj2;
        Object it$iv;
        PointerInputChange dragEvent;
        long postSlopOffset;
        float touchSlop3;
        PointerInputChange dragEvent2;
        Object it$iv2;
        List $this$fastForEach$iv$iv2;
        int $i$f$fastFirstOrNull2;
        int i;
        Object awaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitPointerSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$1 = (DragGestureDetectorKt$awaitPointerSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.label -= Integer.MIN_VALUE;
                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1;
                Object $result2 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                PointerEventPass pointerEventPass = null;
                switch (dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU = awaitPointerEventScope;
                        onPointerSlopReached = function2;
                        pointerDirectionConfig2 = pointerDirectionConfig;
                        triggerOnMainAxisSlop = z;
                        if (m594isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dwtdNQyU.getCurrentEvent(), pointerId)) {
                            return null;
                        }
                        touchSlop = m595pointerSlopE8SPZFQ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU.getViewConfiguration(), pointerType);
                        pointer = new Ref.LongRef();
                        pointer.element = pointerId;
                        touchSlop2 = 0.0f;
                        totalCrossPositionChange = 0.0f;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig2;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = onPointerSlopReached;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = pointer;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = pointerEventPass;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.Z$0 = triggerOnMainAxisSlop;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = touchSlop;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$1 = touchSlop2;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$2 = totalCrossPositionChange;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = 1;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU, pointerEventPass, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12, 1, pointerEventPass);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj3 = coroutine_suspended;
                        $result = $result2;
                        $result2 = awaitPointerEvent$default;
                        pointer2 = pointer;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU2 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU;
                        obj = obj3;
                        PointerEvent event = (PointerEvent) $result2;
                        $this$fastForEach$iv$iv = event.getChanges();
                        $i$f$fastFirstOrNull = 0;
                        size = $this$fastForEach$iv$iv.size();
                        Object $result3 = $result;
                        index$iv$iv = 0;
                        while (true) {
                            if (index$iv$iv >= size) {
                                Object item$iv$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
                                it$iv = item$iv$iv;
                                PointerInputChange it = (PointerInputChange) it$iv;
                                $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                                $i$f$fastFirstOrNull2 = $i$f$fastFirstOrNull;
                                obj2 = obj;
                                i = size;
                                if (!PointerId.m3349equalsimpl0(it.getId(), pointer2.element)) {
                                    index$iv$iv++;
                                    $i$f$fastFirstOrNull = $i$f$fastFirstOrNull2;
                                    $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                                    obj = obj2;
                                    size = i;
                                }
                            } else {
                                obj2 = obj;
                                it$iv = null;
                            }
                        }
                        dragEvent = (PointerInputChange) it$iv;
                        if (dragEvent == null || dragEvent.isConsumed()) {
                            return null;
                        }
                        if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent)) {
                            long currentPosition = dragEvent.getPosition();
                            long previousPosition = dragEvent.getPreviousPosition();
                            float mainPositionChange = pointerDirectionConfig2.mo598mainAxisDeltak4lQ0M(currentPosition) - pointerDirectionConfig2.mo598mainAxisDeltak4lQ0M(previousPosition);
                            float crossPositionChange = pointerDirectionConfig2.mo597crossAxisDeltak4lQ0M(currentPosition) - pointerDirectionConfig2.mo597crossAxisDeltak4lQ0M(previousPosition);
                            float totalMainPositionChange = touchSlop2 + mainPositionChange;
                            float totalCrossPositionChange2 = crossPositionChange + totalCrossPositionChange;
                            float inDirection = triggerOnMainAxisSlop ? Math.abs(totalMainPositionChange) : Offset.m1758getDistanceimpl(pointerDirectionConfig2.mo599offsetFromChangesdBAh8RU(totalMainPositionChange, totalCrossPositionChange2));
                            if (inDirection < touchSlop) {
                                PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU2;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig2;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = onPointerSlopReached;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = pointer2;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = dragEvent;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.Z$0 = triggerOnMainAxisSlop;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = touchSlop;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$1 = totalMainPositionChange;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$2 = totalCrossPositionChange2;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = 2;
                                Object obj4 = obj2;
                                if ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU2.awaitPointerEvent(pointerEventPass2, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12) == obj4) {
                                    return obj4;
                                }
                                totalCrossPositionChange = totalCrossPositionChange2;
                                touchSlop3 = touchSlop;
                                $result2 = $result3;
                                dragEvent2 = dragEvent;
                                $this$awaitPointerSlopOrCancellation_u2dwtdNQyU = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU2;
                                pointer = pointer2;
                                touchSlop2 = totalMainPositionChange;
                                coroutine_suspended = obj4;
                                if (!dragEvent2.isConsumed()) {
                                    return null;
                                }
                                touchSlop = touchSlop3;
                                pointerEventPass = null;
                            } else {
                                Object obj5 = obj2;
                                if (triggerOnMainAxisSlop) {
                                    float finalMainPositionChange = totalMainPositionChange - (Math.signum(totalMainPositionChange) * touchSlop);
                                    postSlopOffset = pointerDirectionConfig2.mo599offsetFromChangesdBAh8RU(finalMainPositionChange, totalCrossPositionChange2);
                                } else {
                                    long offset = pointerDirectionConfig2.mo599offsetFromChangesdBAh8RU(totalMainPositionChange, totalCrossPositionChange2);
                                    long touchSlopOffset = Offset.m1767timestuRUvjQ(Offset.m1755divtuRUvjQ(offset, inDirection), touchSlop);
                                    postSlopOffset = Offset.m1764minusMKHz9U(offset, touchSlopOffset);
                                }
                                onPointerSlopReached.invoke(dragEvent, Offset.m1749boximpl(postSlopOffset));
                                if (dragEvent.isConsumed()) {
                                    return dragEvent;
                                }
                                totalCrossPositionChange = 0.0f;
                                $result2 = $result3;
                                coroutine_suspended = obj5;
                                pointerEventPass = null;
                                touchSlop2 = 0.0f;
                                $this$awaitPointerSlopOrCancellation_u2dwtdNQyU = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU2;
                                pointer = pointer2;
                            }
                        } else {
                            List $this$fastForEach$iv$iv3 = event.getChanges();
                            int index$iv$iv2 = 0;
                            int size2 = $this$fastForEach$iv$iv3.size();
                            while (true) {
                                if (index$iv$iv2 < size2) {
                                    Object item$iv$iv2 = $this$fastForEach$iv$iv3.get(index$iv$iv2);
                                    it$iv2 = item$iv$iv2;
                                    PointerInputChange it2 = (PointerInputChange) it$iv2;
                                    if (!it2.getPressed()) {
                                        index$iv$iv2++;
                                    }
                                } else {
                                    it$iv2 = null;
                                }
                            }
                            PointerInputChange otherDown = (PointerInputChange) it$iv2;
                            if (otherDown == null) {
                                return null;
                            }
                            pointer2.element = otherDown.getId();
                            $result2 = $result3;
                            coroutine_suspended = obj2;
                            $this$awaitPointerSlopOrCancellation_u2dwtdNQyU = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU2;
                            pointer = pointer2;
                            pointerEventPass = null;
                        }
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig2;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = onPointerSlopReached;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = pointer;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = pointerEventPass;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.Z$0 = triggerOnMainAxisSlop;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = touchSlop;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$1 = touchSlop2;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$2 = totalCrossPositionChange;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = 1;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU, pointerEventPass, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12, 1, pointerEventPass);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                        }
                        break;
                    case 1:
                        float totalCrossPositionChange3 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$2;
                        float totalMainPositionChange2 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$1;
                        float touchSlop4 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0;
                        boolean triggerOnMainAxisSlop2 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.Z$0;
                        Ref.LongRef pointer3 = (Ref.LongRef) dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3;
                        Function2 onPointerSlopReached2 = (Function2) dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2;
                        PointerDirectionConfig pointerDirectionConfig3 = (PointerDirectionConfig) dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU2 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        pointer2 = pointer3;
                        touchSlop = touchSlop4;
                        touchSlop2 = totalMainPositionChange2;
                        pointerDirectionConfig2 = pointerDirectionConfig3;
                        obj = coroutine_suspended;
                        $result = $result2;
                        totalCrossPositionChange = totalCrossPositionChange3;
                        onPointerSlopReached = onPointerSlopReached2;
                        triggerOnMainAxisSlop = triggerOnMainAxisSlop2;
                        PointerEvent event2 = (PointerEvent) $result2;
                        $this$fastForEach$iv$iv = event2.getChanges();
                        $i$f$fastFirstOrNull = 0;
                        size = $this$fastForEach$iv$iv.size();
                        Object $result32 = $result;
                        index$iv$iv = 0;
                        while (true) {
                            if (index$iv$iv >= size) {
                            }
                            index$iv$iv++;
                            $i$f$fastFirstOrNull = $i$f$fastFirstOrNull2;
                            $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                            obj = obj2;
                            size = i;
                        }
                        dragEvent = (PointerInputChange) it$iv;
                        if (dragEvent == null) {
                            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent)) {
                            }
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig2;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = onPointerSlopReached;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = pointer;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = pointerEventPass;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.Z$0 = triggerOnMainAxisSlop;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = touchSlop;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$1 = touchSlop2;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$2 = totalCrossPositionChange;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = 1;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dwtdNQyU, pointerEventPass, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12, 1, pointerEventPass);
                            if (awaitPointerEvent$default == coroutine_suspended) {
                            }
                            break;
                        } else {
                            return null;
                        }
                        break;
                    case 2:
                        float totalCrossPositionChange4 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$2;
                        float totalMainPositionChange3 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$1;
                        float touchSlop5 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0;
                        boolean triggerOnMainAxisSlop3 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.Z$0;
                        dragEvent2 = (PointerInputChange) dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4;
                        Ref.LongRef pointer4 = (Ref.LongRef) dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3;
                        Function2 onPointerSlopReached3 = (Function2) dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2;
                        PointerDirectionConfig pointerDirectionConfig4 = (PointerDirectionConfig) dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1;
                        AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        touchSlop3 = touchSlop5;
                        touchSlop2 = totalMainPositionChange3;
                        pointerDirectionConfig2 = pointerDirectionConfig4;
                        pointer = pointer4;
                        triggerOnMainAxisSlop = triggerOnMainAxisSlop3;
                        totalCrossPositionChange = totalCrossPositionChange4;
                        onPointerSlopReached = onPointerSlopReached3;
                        $this$awaitPointerSlopOrCancellation_u2dwtdNQyU = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU3;
                        if (!dragEvent2.isConsumed()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$1 = new DragGestureDetectorKt$awaitPointerSlopOrCancellation$1(continuation);
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1;
        Object $result22 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        PointerEventPass pointerEventPass3 = null;
        switch (dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label) {
        }
    }

    /* renamed from: awaitPointerSlopOrCancellation-wtdNQyU$default, reason: not valid java name */
    public static /* synthetic */ Object m586awaitPointerSlopOrCancellationwtdNQyU$default(AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default, long pointerId, int pointerType, PointerDirectionConfig pointerDirectionConfig, boolean triggerOnMainAxisSlop, Function2 onPointerSlopReached, Continuation $completion, int i, Object obj) {
        Object it$iv;
        Object it$iv2;
        long offset;
        AwaitPointerEventScope awaitPointerEventScope = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default;
        Continuation continuation = $completion;
        PointerDirectionConfig pointerDirectionConfig2 = (i & 4) != 0 ? getHorizontalPointerDirectionConfig() : pointerDirectionConfig;
        boolean triggerOnMainAxisSlop2 = (i & 8) != 0 ? true : triggerOnMainAxisSlop;
        float inDirection = 0.0f;
        PointerEventPass pointerEventPass = null;
        if (m594isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default.getCurrentEvent(), pointerId)) {
            return null;
        }
        float touchSlop = m595pointerSlopE8SPZFQ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default.getViewConfiguration(), pointerType);
        long pointer = pointerId;
        float totalMainPositionChange = 0.0f;
        float totalCrossPositionChange = 0.0f;
        while (true) {
            InlineMarker.mark(0);
            Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, pointerEventPass, continuation, 1, pointerEventPass);
            InlineMarker.mark(1);
            PointerEvent event = (PointerEvent) awaitPointerEvent$default;
            List $this$fastForEach$iv$iv = event.getChanges();
            int size = $this$fastForEach$iv$iv.size();
            int index$iv$iv = 0;
            while (true) {
                if (index$iv$iv >= size) {
                    it$iv = null;
                    break;
                }
                List $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                Object item$iv$iv = $this$fastForEach$iv$iv2.get(index$iv$iv);
                it$iv = item$iv$iv;
                PointerInputChange it = (PointerInputChange) it$iv;
                if (PointerId.m3349equalsimpl0(it.getId(), pointer)) {
                    break;
                }
                index$iv$iv++;
                $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
            }
            PointerInputChange dragEvent = (PointerInputChange) it$iv;
            if (dragEvent == null || dragEvent.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent)) {
                List $this$fastFirstOrNull$iv = event.getChanges();
                float f = inDirection;
                int size2 = $this$fastFirstOrNull$iv.size();
                int index$iv$iv2 = 0;
                while (true) {
                    if (index$iv$iv2 >= size2) {
                        it$iv2 = null;
                        break;
                    }
                    Object item$iv$iv2 = $this$fastFirstOrNull$iv.get(index$iv$iv2);
                    it$iv2 = item$iv$iv2;
                    PointerInputChange it2 = (PointerInputChange) it$iv2;
                    if (it2.getPressed()) {
                        break;
                    }
                    index$iv$iv2++;
                }
                PointerInputChange otherDown = (PointerInputChange) it$iv2;
                if (otherDown == null) {
                    return null;
                }
                pointer = otherDown.getId();
                inDirection = f;
                pointerEventPass = null;
            } else {
                float f2 = inDirection;
                long currentPosition = dragEvent.getPosition();
                long previousPosition = dragEvent.getPreviousPosition();
                float mainPositionChange = pointerDirectionConfig2.mo598mainAxisDeltak4lQ0M(currentPosition) - pointerDirectionConfig2.mo598mainAxisDeltak4lQ0M(previousPosition);
                float crossPositionChange = pointerDirectionConfig2.mo597crossAxisDeltak4lQ0M(currentPosition) - pointerDirectionConfig2.mo597crossAxisDeltak4lQ0M(previousPosition);
                totalMainPositionChange += mainPositionChange;
                totalCrossPositionChange += crossPositionChange;
                float inDirection2 = triggerOnMainAxisSlop2 ? Math.abs(totalMainPositionChange) : Offset.m1758getDistanceimpl(pointerDirectionConfig2.mo599offsetFromChangesdBAh8RU(totalMainPositionChange, totalCrossPositionChange));
                if (inDirection2 < touchSlop) {
                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                    InlineMarker.mark(0);
                    awaitPointerEventScope.awaitPointerEvent(pointerEventPass2, continuation);
                    InlineMarker.mark(1);
                    if (dragEvent.isConsumed()) {
                        return null;
                    }
                    inDirection = f2;
                    pointerEventPass = null;
                } else {
                    if (triggerOnMainAxisSlop2) {
                        float finalMainPositionChange = totalMainPositionChange - (Math.signum(totalMainPositionChange) * touchSlop);
                        offset = pointerDirectionConfig2.mo599offsetFromChangesdBAh8RU(finalMainPositionChange, totalCrossPositionChange);
                    } else {
                        long offset2 = pointerDirectionConfig2.mo599offsetFromChangesdBAh8RU(totalMainPositionChange, totalCrossPositionChange);
                        long touchSlopOffset = Offset.m1767timestuRUvjQ(Offset.m1755divtuRUvjQ(offset2, inDirection2), touchSlop);
                        offset = Offset.m1764minusMKHz9U(offset2, touchSlopOffset);
                    }
                    long touchSlopOffset2 = offset;
                    onPointerSlopReached.invoke(dragEvent, Offset.m1749boximpl(touchSlopOffset2));
                    if (dragEvent.isConsumed()) {
                        return dragEvent;
                    }
                    totalMainPositionChange = 0.0f;
                    totalCrossPositionChange = 0.0f;
                    awaitPointerEventScope = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default;
                    inDirection = f2;
                    continuation = $completion;
                    pointerEventPass = null;
                }
            }
        }
    }

    /* renamed from: awaitPointerSlopOrCancellation-wtdNQyU$$forInline, reason: not valid java name */
    private static final Object m585awaitPointerSlopOrCancellationwtdNQyU$$forInline(AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dwtdNQyU, long pointerId, int pointerType, PointerDirectionConfig pointerDirectionConfig, boolean triggerOnMainAxisSlop, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        Object it$iv;
        Object it$iv2;
        long offset;
        AwaitPointerEventScope awaitPointerEventScope = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU;
        PointerDirectionConfig pointerDirectionConfig2 = pointerDirectionConfig;
        float inDirection = 0.0f;
        PointerEventPass pointerEventPass = null;
        if (m594isPointerUpDmW0f2w($this$awaitPointerSlopOrCancellation_u2dwtdNQyU.getCurrentEvent(), pointerId)) {
            return null;
        }
        float touchSlop = m595pointerSlopE8SPZFQ($this$awaitPointerSlopOrCancellation_u2dwtdNQyU.getViewConfiguration(), pointerType);
        long pointer = pointerId;
        float totalMainPositionChange = 0.0f;
        float totalCrossPositionChange = 0.0f;
        while (true) {
            InlineMarker.mark(0);
            Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, pointerEventPass, continuation, 1, pointerEventPass);
            InlineMarker.mark(1);
            PointerEvent event = (PointerEvent) awaitPointerEvent$default;
            List $this$fastForEach$iv$iv = event.getChanges();
            int size = $this$fastForEach$iv$iv.size();
            int index$iv$iv = 0;
            while (true) {
                if (index$iv$iv >= size) {
                    it$iv = null;
                    break;
                }
                List $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                Object item$iv$iv = $this$fastForEach$iv$iv2.get(index$iv$iv);
                it$iv = item$iv$iv;
                PointerInputChange it = (PointerInputChange) it$iv;
                if (PointerId.m3349equalsimpl0(it.getId(), pointer)) {
                    break;
                }
                index$iv$iv++;
                $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
            }
            PointerInputChange dragEvent = (PointerInputChange) it$iv;
            if (dragEvent == null || dragEvent.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(dragEvent)) {
                List $this$fastFirstOrNull$iv = event.getChanges();
                float f = inDirection;
                int size2 = $this$fastFirstOrNull$iv.size();
                int index$iv$iv2 = 0;
                while (true) {
                    if (index$iv$iv2 >= size2) {
                        it$iv2 = null;
                        break;
                    }
                    Object item$iv$iv2 = $this$fastFirstOrNull$iv.get(index$iv$iv2);
                    it$iv2 = item$iv$iv2;
                    PointerInputChange it2 = (PointerInputChange) it$iv2;
                    if (it2.getPressed()) {
                        break;
                    }
                    index$iv$iv2++;
                }
                PointerInputChange otherDown = (PointerInputChange) it$iv2;
                if (otherDown == null) {
                    return null;
                }
                pointer = otherDown.getId();
                inDirection = f;
                pointerEventPass = null;
            } else {
                float f2 = inDirection;
                long currentPosition = dragEvent.getPosition();
                long previousPosition = dragEvent.getPreviousPosition();
                float mainPositionChange = pointerDirectionConfig2.mo598mainAxisDeltak4lQ0M(currentPosition) - pointerDirectionConfig2.mo598mainAxisDeltak4lQ0M(previousPosition);
                float crossPositionChange = pointerDirectionConfig2.mo597crossAxisDeltak4lQ0M(currentPosition) - pointerDirectionConfig2.mo597crossAxisDeltak4lQ0M(previousPosition);
                totalMainPositionChange += mainPositionChange;
                totalCrossPositionChange += crossPositionChange;
                float inDirection2 = triggerOnMainAxisSlop ? Math.abs(totalMainPositionChange) : Offset.m1758getDistanceimpl(pointerDirectionConfig2.mo599offsetFromChangesdBAh8RU(totalMainPositionChange, totalCrossPositionChange));
                if (inDirection2 < touchSlop) {
                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                    InlineMarker.mark(0);
                    awaitPointerEventScope.awaitPointerEvent(pointerEventPass2, continuation);
                    InlineMarker.mark(1);
                    if (dragEvent.isConsumed()) {
                        return null;
                    }
                    inDirection = f2;
                    pointerEventPass = null;
                } else {
                    if (triggerOnMainAxisSlop) {
                        float finalMainPositionChange = totalMainPositionChange - (Math.signum(totalMainPositionChange) * touchSlop);
                        offset = pointerDirectionConfig2.mo599offsetFromChangesdBAh8RU(finalMainPositionChange, totalCrossPositionChange);
                    } else {
                        long offset2 = pointerDirectionConfig2.mo599offsetFromChangesdBAh8RU(totalMainPositionChange, totalCrossPositionChange);
                        long touchSlopOffset = Offset.m1767timestuRUvjQ(Offset.m1755divtuRUvjQ(offset2, inDirection2), touchSlop);
                        offset = Offset.m1764minusMKHz9U(offset2, touchSlopOffset);
                    }
                    long touchSlopOffset2 = offset;
                    function2.invoke(dragEvent, Offset.m1749boximpl(touchSlopOffset2));
                    if (dragEvent.isConsumed()) {
                        return dragEvent;
                    }
                    totalMainPositionChange = 0.0f;
                    totalCrossPositionChange = 0.0f;
                    awaitPointerEventScope = $this$awaitPointerSlopOrCancellation_u2dwtdNQyU;
                    pointerDirectionConfig2 = pointerDirectionConfig;
                    inDirection = f2;
                    pointerEventPass = null;
                }
            }
        }
    }

    static {
        float arg0$iv = mouseSlop;
        float other$iv = defaultTouchSlop;
        mouseToTouchSlopRatio = arg0$iv / other$iv;
    }

    public static final PointerDirectionConfig getHorizontalPointerDirectionConfig() {
        return HorizontalPointerDirectionConfig;
    }

    public static final PointerDirectionConfig getVerticalPointerDirectionConfig() {
        return VerticalPointerDirectionConfig;
    }

    public static final PointerDirectionConfig toPointerDirectionConfig(Orientation $this$toPointerDirectionConfig) {
        Intrinsics.checkNotNullParameter($this$toPointerDirectionConfig, "<this>");
        return $this$toPointerDirectionConfig == Orientation.Vertical ? VerticalPointerDirectionConfig : HorizontalPointerDirectionConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.ui.input.pointer.PointerInputChange] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* renamed from: awaitLongPressOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m583awaitLongPressOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$1 dragGestureDetectorKt$awaitLongPressOrCancellation$1;
        PointerInputChange pointerInputChange;
        Object obj;
        Ref.ObjectRef objectRef;
        if (continuation instanceof DragGestureDetectorKt$awaitLongPressOrCancellation$1) {
            dragGestureDetectorKt$awaitLongPressOrCancellation$1 = (DragGestureDetectorKt$awaitLongPressOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitLongPressOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj2 = dragGestureDetectorKt$awaitLongPressOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dragGestureDetectorKt$awaitLongPressOrCancellation$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj2);
                        if (m594isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                            return null;
                        }
                        List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                        int i = 0;
                        int i2 = 0;
                        int size = changes.size();
                        while (true) {
                            if (i2 < size) {
                                pointerInputChange = changes.get(i2);
                                List<PointerInputChange> list = changes;
                                int i3 = i;
                                if (!PointerId.m3349equalsimpl0(pointerInputChange.getId(), j)) {
                                    i2++;
                                    i = i3;
                                    changes = list;
                                }
                            } else {
                                pointerInputChange = null;
                            }
                        }
                        PointerInputChange pointerInputChange2 = pointerInputChange;
                        if (pointerInputChange2 == null) {
                            return null;
                        }
                        obj = pointerInputChange2;
                        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                        objectRef3.element = obj;
                        long longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
                        try {
                            DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(objectRef3, objectRef2, null);
                            dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0 = obj;
                            dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1 = objectRef2;
                            dragGestureDetectorKt$awaitLongPressOrCancellation$1.label = 1;
                            if (awaitPointerEventScope.withTimeout(longPressTimeoutMillis, dragGestureDetectorKt$awaitLongPressOrCancellation$2, dragGestureDetectorKt$awaitLongPressOrCancellation$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            objectRef = objectRef2;
                            obj = obj;
                            return null;
                        } catch (PointerEventTimeoutCancellationException e) {
                            objectRef = objectRef2;
                            PointerInputChange pointerInputChange3 = (PointerInputChange) objectRef.element;
                            return pointerInputChange3 != null ? obj : pointerInputChange3;
                        }
                    case 1:
                        objectRef = (Ref.ObjectRef) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1;
                        obj = (PointerInputChange) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            obj = obj;
                            return null;
                        } catch (PointerEventTimeoutCancellationException e2) {
                            PointerInputChange pointerInputChange32 = (PointerInputChange) objectRef.element;
                            if (pointerInputChange32 != null) {
                            }
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$awaitLongPressOrCancellation$1 = new DragGestureDetectorKt$awaitLongPressOrCancellation$1(continuation);
        Object obj22 = dragGestureDetectorKt$awaitLongPressOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dragGestureDetectorKt$awaitLongPressOrCancellation$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    public static final boolean m594isPointerUpDmW0f2w(PointerEvent $this$isPointerUp_u2dDmW0f2w, long pointerId) {
        Object it$iv;
        List $this$fastFirstOrNull$iv = $this$isPointerUp_u2dDmW0f2w.getChanges();
        int index$iv$iv = 0;
        int size = $this$fastFirstOrNull$iv.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = $this$fastFirstOrNull$iv.get(index$iv$iv);
                it$iv = item$iv$iv;
                PointerInputChange it = (PointerInputChange) it$iv;
                if (PointerId.m3349equalsimpl0(it.getId(), pointerId)) {
                    break;
                }
                index$iv$iv++;
            } else {
                it$iv = null;
                break;
            }
        }
        PointerInputChange pointerInputChange = (PointerInputChange) it$iv;
        boolean z = false;
        if (pointerInputChange != null && pointerInputChange.getPressed()) {
            z = true;
        }
        return !z;
    }

    /* renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m595pointerSlopE8SPZFQ(ViewConfiguration pointerSlop, int pointerType) {
        Intrinsics.checkNotNullParameter(pointerSlop, "$this$pointerSlop");
        return PointerType.m3435equalsimpl0(pointerType, PointerType.INSTANCE.m3440getMouseT8wyACA()) ? pointerSlop.getTouchSlop() * mouseToTouchSlopRatio : pointerSlop.getTouchSlop();
    }
}
