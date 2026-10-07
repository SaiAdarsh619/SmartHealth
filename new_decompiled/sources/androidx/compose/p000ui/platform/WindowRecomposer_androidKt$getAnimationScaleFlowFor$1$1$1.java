package androidx.compose.p000ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: WindowRecomposer.android.kt */
@Metadata(m286d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1", m297f = "WindowRecomposer.android.kt", m298i = {0, 1}, m299l = {116, 122}, m300m = "invokeSuspend", m301n = {"$this$flow", "$this$flow"}, m302s = {"L$0", "L$0"})
/* loaded from: classes.dex */
final class WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 extends SuspendLambda implements Function2<FlowCollector<? super Float>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $animationScaleUri;
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ Channel<Unit> $channel;
    final /* synthetic */ C0485x23580bd9 $contentObserver;
    final /* synthetic */ ContentResolver $resolver;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(ContentResolver contentResolver, Uri uri, C0485x23580bd9 c0485x23580bd9, Channel<Unit> channel, Context context, Continuation<? super WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1> continuation) {
        super(2, continuation);
        this.$resolver = contentResolver;
        this.$animationScaleUri = uri;
        this.$contentObserver = c0485x23580bd9;
        this.$channel = channel;
        this.$applicationContext = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 = new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(this.$resolver, this.$animationScaleUri, this.$contentObserver, this.$channel, this.$applicationContext, continuation);
        windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.L$0 = obj;
        return windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Float> flowCollector, Continuation<? super Unit> continuation) {
        return ((WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f A[Catch: all -> 0x00a9, TRY_LEAVE, TryCatch #0 {all -> 0x00a9, blocks: (B:15:0x0067, B:17:0x006f), top: B:14:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009c  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0097 -> B:10:0x0050). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        ChannelIterator<Unit> it;
        FlowCollector flowCollector2;
        WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1;
        Object obj2;
        Object obj3;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Continuation<? super Boolean> continuation = this.label;
        try {
            switch (continuation) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$12 = this;
                    flowCollector = (FlowCollector) windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$12.L$0;
                    windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$12.$resolver.registerContentObserver(windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$12.$animationScaleUri, false, windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$12.$contentObserver);
                    it = windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$12.$channel.iterator();
                    continuation = windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$12;
                    continuation.L$0 = flowCollector;
                    continuation.L$1 = it;
                    continuation.label = 1;
                    hasNext = it.hasNext(continuation);
                    if (hasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj4 = coroutine_suspended;
                    obj3 = obj;
                    obj = hasNext;
                    flowCollector2 = flowCollector;
                    windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 = continuation;
                    obj2 = obj4;
                    try {
                        if (((Boolean) obj).booleanValue()) {
                            windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.$resolver.unregisterContentObserver(windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.$contentObserver);
                            return Unit.INSTANCE;
                        }
                        it.next();
                        windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.L$0 = flowCollector2;
                        windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.L$1 = it;
                        windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.label = 2;
                        if (flowCollector2.emit(Boxing.boxFloat(Settings.Global.getFloat(windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.$applicationContext.getContentResolver(), "animator_duration_scale", 1.0f)), windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1) == obj2) {
                            return obj2;
                        }
                        obj = obj3;
                        coroutine_suspended = obj2;
                        continuation = windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1;
                        flowCollector = flowCollector2;
                        continuation.L$0 = flowCollector;
                        continuation.L$1 = it;
                        continuation.label = 1;
                        hasNext = it.hasNext(continuation);
                        if (hasNext == coroutine_suspended) {
                        }
                    } catch (Throwable th) {
                        continuation = windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1;
                        th = th;
                        continuation.$resolver.unregisterContentObserver(continuation.$contentObserver);
                        throw th;
                    }
                case 1:
                    ChannelIterator<Unit> channelIterator = (ChannelIterator) this.L$1;
                    FlowCollector flowCollector3 = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    flowCollector2 = flowCollector3;
                    it = channelIterator;
                    windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 = this;
                    obj2 = coroutine_suspended;
                    obj3 = obj;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    break;
                case 2:
                    WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$13 = this;
                    ChannelIterator<Unit> channelIterator2 = (ChannelIterator) windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$13.L$1;
                    FlowCollector flowCollector4 = (FlowCollector) windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$13.L$0;
                    ResultKt.throwOnFailure(obj);
                    it = channelIterator2;
                    flowCollector = flowCollector4;
                    continuation = windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$13;
                    continuation.L$0 = flowCollector;
                    continuation.L$1 = it;
                    continuation.label = 1;
                    hasNext = it.hasNext(continuation);
                    if (hasNext == coroutine_suspended) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
