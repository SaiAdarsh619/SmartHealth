package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BringIntoViewRequester.kt */
@ExperimentalFoundationApi
@Metadata(m286d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m287d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewRequesterImpl;", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "()V", "modifiers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/relocation/BringIntoViewRequesterModifier;", "getModifiers", "()Landroidx/compose/runtime/collection/MutableVector;", "bringIntoView", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class BringIntoViewRequesterImpl implements BringIntoViewRequester {
    private final MutableVector<BringIntoViewRequesterModifier> modifiers = new MutableVector<>(new BringIntoViewRequesterModifier[16], 0);

    public final MutableVector<BringIntoViewRequesterModifier> getModifiers() {
        return this.modifiers;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0075 -> B:12:0x0076). Please report as a decompilation issue!!! */
    @Override // androidx.compose.foundation.relocation.BringIntoViewRequester
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object bringIntoView(Rect rect, Continuation<? super Unit> continuation) {
        BringIntoViewRequesterImpl$bringIntoView$1 bringIntoViewRequesterImpl$bringIntoView$1;
        BringIntoViewRequesterImpl$bringIntoView$1 bringIntoViewRequesterImpl$bringIntoView$12;
        int size$iv;
        Rect rect2;
        Rect rect3;
        int i$iv;
        Object[] content$iv;
        BringIntoViewRequesterModifier it;
        if (continuation instanceof BringIntoViewRequesterImpl$bringIntoView$1) {
            bringIntoViewRequesterImpl$bringIntoView$1 = (BringIntoViewRequesterImpl$bringIntoView$1) continuation;
            if ((bringIntoViewRequesterImpl$bringIntoView$1.label & Integer.MIN_VALUE) != 0) {
                bringIntoViewRequesterImpl$bringIntoView$1.label -= Integer.MIN_VALUE;
                bringIntoViewRequesterImpl$bringIntoView$12 = bringIntoViewRequesterImpl$bringIntoView$1;
                Object $result = bringIntoViewRequesterImpl$bringIntoView$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (bringIntoViewRequesterImpl$bringIntoView$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        MutableVector this_$iv = this.modifiers;
                        size$iv = this_$iv.getSize();
                        if (size$iv > 0) {
                            BringIntoViewRequesterModifier[] content = this_$iv.getContent();
                            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                            rect2 = rect;
                            rect3 = null;
                            i$iv = 0;
                            content$iv = content;
                            it = (BringIntoViewRequesterModifier) content$iv[i$iv];
                            bringIntoViewRequesterImpl$bringIntoView$12.L$0 = rect2;
                            bringIntoViewRequesterImpl$bringIntoView$12.L$1 = content$iv;
                            bringIntoViewRequesterImpl$bringIntoView$12.I$0 = size$iv;
                            bringIntoViewRequesterImpl$bringIntoView$12.I$1 = i$iv;
                            bringIntoViewRequesterImpl$bringIntoView$12.label = 1;
                            if (it.bringIntoView(rect2, bringIntoViewRequesterImpl$bringIntoView$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            i$iv++;
                            if (i$iv >= size$iv) {
                            }
                            it = (BringIntoViewRequesterModifier) content$iv[i$iv];
                            bringIntoViewRequesterImpl$bringIntoView$12.L$0 = rect2;
                            bringIntoViewRequesterImpl$bringIntoView$12.L$1 = content$iv;
                            bringIntoViewRequesterImpl$bringIntoView$12.I$0 = size$iv;
                            bringIntoViewRequesterImpl$bringIntoView$12.I$1 = i$iv;
                            bringIntoViewRequesterImpl$bringIntoView$12.label = 1;
                            if (it.bringIntoView(rect2, bringIntoViewRequesterImpl$bringIntoView$12) == coroutine_suspended) {
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        rect3 = null;
                        i$iv = bringIntoViewRequesterImpl$bringIntoView$12.I$1;
                        size$iv = bringIntoViewRequesterImpl$bringIntoView$12.I$0;
                        content$iv = (Object[]) bringIntoViewRequesterImpl$bringIntoView$12.L$1;
                        rect2 = (Rect) bringIntoViewRequesterImpl$bringIntoView$12.L$0;
                        ResultKt.throwOnFailure($result);
                        i$iv++;
                        if (i$iv >= size$iv) {
                        }
                        it = (BringIntoViewRequesterModifier) content$iv[i$iv];
                        bringIntoViewRequesterImpl$bringIntoView$12.L$0 = rect2;
                        bringIntoViewRequesterImpl$bringIntoView$12.L$1 = content$iv;
                        bringIntoViewRequesterImpl$bringIntoView$12.I$0 = size$iv;
                        bringIntoViewRequesterImpl$bringIntoView$12.I$1 = i$iv;
                        bringIntoViewRequesterImpl$bringIntoView$12.label = 1;
                        if (it.bringIntoView(rect2, bringIntoViewRequesterImpl$bringIntoView$12) == coroutine_suspended) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        bringIntoViewRequesterImpl$bringIntoView$1 = new BringIntoViewRequesterImpl$bringIntoView$1(this, continuation);
        bringIntoViewRequesterImpl$bringIntoView$12 = bringIntoViewRequesterImpl$bringIntoView$1;
        Object $result2 = bringIntoViewRequesterImpl$bringIntoView$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (bringIntoViewRequesterImpl$bringIntoView$12.label) {
        }
    }
}
