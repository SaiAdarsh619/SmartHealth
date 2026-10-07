package androidx.compose.foundation.relocation;

import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BringIntoViewResponder.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.foundation.relocation.BringIntoViewResponderModifier$dispatchRequest$2", m297f = "BringIntoViewResponder.kt", m298i = {}, m299l = {284}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes.dex */
final class BringIntoViewResponderModifier$dispatchRequest$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LayoutCoordinates $layoutCoordinates;
    final /* synthetic */ Rect $localRect;
    final /* synthetic */ Rect $parentRect;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BringIntoViewResponderModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BringIntoViewResponderModifier$dispatchRequest$2(BringIntoViewResponderModifier bringIntoViewResponderModifier, LayoutCoordinates layoutCoordinates, Rect rect, Rect rect2, Continuation<? super BringIntoViewResponderModifier$dispatchRequest$2> continuation) {
        super(2, continuation);
        this.this$0 = bringIntoViewResponderModifier;
        this.$layoutCoordinates = layoutCoordinates;
        this.$localRect = rect;
        this.$parentRect = rect2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BringIntoViewResponderModifier$dispatchRequest$2 bringIntoViewResponderModifier$dispatchRequest$2 = new BringIntoViewResponderModifier$dispatchRequest$2(this.this$0, this.$layoutCoordinates, this.$localRect, this.$parentRect, continuation);
        bringIntoViewResponderModifier$dispatchRequest$2.L$0 = obj;
        return bringIntoViewResponderModifier$dispatchRequest$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BringIntoViewResponderModifier$dispatchRequest$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, null, new C02201(this.this$0, this.$localRect, null), 3, null);
                BringIntoViewParent parent = this.this$0.getParent();
                LayoutCoordinates layoutCoordinates = this.$layoutCoordinates;
                final Rect rect = this.$parentRect;
                this.label = 1;
                if (parent.bringChildIntoView(layoutCoordinates, new Function0<Rect>() { // from class: androidx.compose.foundation.relocation.BringIntoViewResponderModifier$dispatchRequest$2.2
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Rect invoke() {
                        return Rect.this;
                    }
                }, this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* compiled from: BringIntoViewResponder.kt */
    @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    @DebugMetadata(m296c = "androidx.compose.foundation.relocation.BringIntoViewResponderModifier$dispatchRequest$2$1", m297f = "BringIntoViewResponder.kt", m298i = {}, m299l = {278}, m300m = "invokeSuspend", m301n = {}, m302s = {})
    /* renamed from: androidx.compose.foundation.relocation.BringIntoViewResponderModifier$dispatchRequest$2$1 */
    static final class C02201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Rect $localRect;
        int label;
        final /* synthetic */ BringIntoViewResponderModifier this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02201(BringIntoViewResponderModifier bringIntoViewResponderModifier, Rect rect, Continuation<? super C02201> continuation) {
            super(2, continuation);
            this.this$0 = bringIntoViewResponderModifier;
            this.$localRect = rect;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02201(this.this$0, this.$localRect, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    BringIntoViewResponder responder = this.this$0.getResponder();
                    final Rect rect = this.$localRect;
                    this.label = 1;
                    if (responder.bringChildIntoView(new Function0<Rect>() { // from class: androidx.compose.foundation.relocation.BringIntoViewResponderModifier.dispatchRequest.2.1.1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Rect invoke() {
                            return Rect.this;
                        }
                    }, this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }
}
