package androidx.compose.p000ui.text.font;

import androidx.compose.p000ui.text.font.TypefaceResult;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.YieldKt;

/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
@Metadata(m286d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0011\u0010 \u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u0005H\u0080@ø\u0001\u0000¢\u0006\u0004\b#\u0010$R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, m287d2 = {"Landroidx/compose/ui/text/font/AsyncFontListLoader;", "Landroidx/compose/runtime/State;", "", "fontList", "", "Landroidx/compose/ui/text/font/Font;", "initialType", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "onCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "(Ljava/util/List;Ljava/lang/Object;Landroidx/compose/ui/text/font/TypefaceRequest;Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/font/PlatformFontLoader;)V", "cacheable", "", "getCacheable$ui_text_release", "()Z", "setCacheable$ui_text_release", "(Z)V", "<set-?>", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "load", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadWithTimeoutOrNull", "loadWithTimeoutOrNull$ui_text_release", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AsyncFontListLoader implements State<Object> {
    private final AsyncTypefaceCache asyncTypefaceCache;
    private boolean cacheable;
    private final List<Font> fontList;
    private final Function1<TypefaceResult.Immutable, Unit> onCompletion;
    private final PlatformFontLoader platformFontLoader;
    private final TypefaceRequest typefaceRequest;

    /* renamed from: value$delegate, reason: from kotlin metadata */
    private final MutableState value;

    /* JADX WARN: Multi-variable type inference failed */
    public AsyncFontListLoader(List<? extends Font> fontList, Object initialType, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, Function1<? super TypefaceResult.Immutable, Unit> onCompletion, PlatformFontLoader platformFontLoader) {
        Intrinsics.checkNotNullParameter(fontList, "fontList");
        Intrinsics.checkNotNullParameter(initialType, "initialType");
        Intrinsics.checkNotNullParameter(typefaceRequest, "typefaceRequest");
        Intrinsics.checkNotNullParameter(asyncTypefaceCache, "asyncTypefaceCache");
        Intrinsics.checkNotNullParameter(onCompletion, "onCompletion");
        Intrinsics.checkNotNullParameter(platformFontLoader, "platformFontLoader");
        this.fontList = fontList;
        this.typefaceRequest = typefaceRequest;
        this.asyncTypefaceCache = asyncTypefaceCache;
        this.onCompletion = onCompletion;
        this.platformFontLoader = platformFontLoader;
        this.value = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialType, null, 2, null);
        this.cacheable = true;
    }

    private void setValue(Object obj) {
        MutableState $this$setValue$iv = this.value;
        $this$setValue$iv.setValue(obj);
    }

    @Override // androidx.compose.runtime.State
    public Object getValue() {
        State $this$getValue$iv = this.value;
        return $this$getValue$iv.getValue();
    }

    /* renamed from: getCacheable$ui_text_release, reason: from getter */
    public final boolean getCacheable() {
        return this.cacheable;
    }

    public final void setCacheable$ui_text_release(boolean z) {
        this.cacheable = z;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:0|1|(2:3|(4:5|6|7|8))|70|6|7|8) */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0165, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d4 A[Catch: all -> 0x012c, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x012c, blocks: (B:33:0x00d4, B:48:0x010e), top: B:47:0x010e }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0122 -> B:14:0x0127). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0134 -> B:15:0x013a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object load(Continuation<? super Unit> continuation) {
        AsyncFontListLoader$load$1 asyncFontListLoader$load$1;
        AsyncFontListLoader asyncFontListLoader;
        List $this$fastForEach$iv;
        int $i$f$fastForEach;
        int index$iv;
        int size;
        int i;
        int index$iv2;
        Font font;
        List $this$fastForEach$iv2;
        AsyncFontListLoader asyncFontListLoader2;
        int i2;
        int $i$f$fastForEach2;
        Object $result;
        List $this$fastForEach$iv3;
        Font font2;
        AsyncFontListLoader asyncFontListLoader3;
        Object runCached;
        if (continuation instanceof AsyncFontListLoader$load$1) {
            asyncFontListLoader$load$1 = (AsyncFontListLoader$load$1) continuation;
            if ((asyncFontListLoader$load$1.label & Integer.MIN_VALUE) != 0) {
                asyncFontListLoader$load$1.label -= Integer.MIN_VALUE;
                Object $result2 = asyncFontListLoader$load$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (asyncFontListLoader$load$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        asyncFontListLoader = this;
                        $this$fastForEach$iv = asyncFontListLoader.fontList;
                        $i$f$fastForEach = 0;
                        index$iv = 0;
                        size = $this$fastForEach$iv.size();
                        if (index$iv >= size) {
                            try {
                                Object item$iv = $this$fastForEach$iv.get(index$iv);
                                font2 = (Font) item$iv;
                                i2 = 0;
                            } catch (Throwable th) {
                                th = th;
                            }
                            if (FontLoadingStrategy.m4027equalsimpl0(font2.getLoadingStrategy(), FontLoadingStrategy.INSTANCE.m4031getAsyncPKNRLFQ())) {
                                try {
                                    AsyncTypefaceCache asyncTypefaceCache = asyncFontListLoader.asyncTypefaceCache;
                                    PlatformFontLoader platformFontLoader = asyncFontListLoader.platformFontLoader;
                                    AsyncFontListLoader$load$2$typeface$1 asyncFontListLoader$load$2$typeface$1 = new AsyncFontListLoader$load$2$typeface$1(asyncFontListLoader, font2, null);
                                    asyncFontListLoader$load$1.L$0 = asyncFontListLoader;
                                    asyncFontListLoader$load$1.L$1 = $this$fastForEach$iv;
                                    asyncFontListLoader$load$1.L$2 = font2;
                                    asyncFontListLoader$load$1.I$0 = index$iv;
                                    asyncFontListLoader$load$1.I$1 = size;
                                    asyncFontListLoader$load$1.label = 1;
                                    runCached = asyncTypefaceCache.runCached(font2, platformFontLoader, false, asyncFontListLoader$load$2$typeface$1, asyncFontListLoader$load$1);
                                } catch (Throwable th2) {
                                    th = th2;
                                    asyncFontListLoader = asyncFontListLoader3;
                                }
                                asyncFontListLoader3 = asyncFontListLoader;
                                int i3 = size;
                                if (runCached == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $this$fastForEach$iv2 = $this$fastForEach$iv;
                                index$iv2 = index$iv;
                                i = i3;
                                font = font2;
                                asyncFontListLoader2 = asyncFontListLoader3;
                                $result = $result2;
                                $result2 = runCached;
                                $i$f$fastForEach2 = $i$f$fastForEach;
                                if ($result2 == null) {
                                    asyncFontListLoader2.setValue(FontSynthesis_androidKt.m4059synthesizeTypefaceFxwP2eA(asyncFontListLoader2.typefaceRequest.m4084getFontSynthesisGVVA2EU(), $result2, font, asyncFontListLoader2.typefaceRequest.getFontWeight(), asyncFontListLoader2.typefaceRequest.m4083getFontStyle_LCdwA()));
                                    Unit unit = Unit.INSTANCE;
                                    boolean shouldCache = JobKt.isActive(asyncFontListLoader$load$1.get$context());
                                    asyncFontListLoader2.cacheable = false;
                                    asyncFontListLoader2.onCompletion.invoke(new TypefaceResult.Immutable(asyncFontListLoader2.getValue(), shouldCache));
                                    return unit;
                                }
                                try {
                                    asyncFontListLoader$load$1.L$0 = asyncFontListLoader2;
                                    asyncFontListLoader$load$1.L$1 = $this$fastForEach$iv2;
                                    asyncFontListLoader$load$1.L$2 = null;
                                    asyncFontListLoader$load$1.I$0 = index$iv2;
                                    asyncFontListLoader$load$1.I$1 = i;
                                    asyncFontListLoader$load$1.label = 2;
                                    if (YieldKt.yield(asyncFontListLoader$load$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $result2 = $result;
                                    $this$fastForEach$iv3 = $this$fastForEach$iv2;
                                    asyncFontListLoader = asyncFontListLoader2;
                                    $i$f$fastForEach = $i$f$fastForEach2;
                                    size = i;
                                    index$iv = index$iv2;
                                    $this$fastForEach$iv = $this$fastForEach$iv3;
                                    index$iv++;
                                    if (index$iv >= size) {
                                        boolean shouldCache2 = JobKt.isActive(asyncFontListLoader$load$1.get$context());
                                        asyncFontListLoader.cacheable = false;
                                        asyncFontListLoader.onCompletion.invoke(new TypefaceResult.Immutable(asyncFontListLoader.getValue(), shouldCache2));
                                        return Unit.INSTANCE;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    asyncFontListLoader = asyncFontListLoader2;
                                }
                                th = th3;
                                asyncFontListLoader = asyncFontListLoader2;
                                boolean shouldCache3 = JobKt.isActive(asyncFontListLoader$load$1.get$context());
                                asyncFontListLoader.cacheable = false;
                                asyncFontListLoader.onCompletion.invoke(new TypefaceResult.Immutable(asyncFontListLoader.getValue(), shouldCache3));
                                throw th;
                            }
                            index$iv++;
                            if (index$iv >= size) {
                            }
                        }
                    case 1:
                        i = asyncFontListLoader$load$1.I$1;
                        index$iv2 = asyncFontListLoader$load$1.I$0;
                        font = (Font) asyncFontListLoader$load$1.L$2;
                        $this$fastForEach$iv2 = (List) asyncFontListLoader$load$1.L$1;
                        asyncFontListLoader2 = (AsyncFontListLoader) asyncFontListLoader$load$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result2);
                            i2 = 0;
                            $i$f$fastForEach2 = 0;
                            $result = $result2;
                            if ($result2 == null) {
                            }
                            th = th3;
                            asyncFontListLoader = asyncFontListLoader2;
                        } catch (Throwable th4) {
                            th = th4;
                            asyncFontListLoader = asyncFontListLoader2;
                        }
                        boolean shouldCache32 = JobKt.isActive(asyncFontListLoader$load$1.get$context());
                        asyncFontListLoader.cacheable = false;
                        asyncFontListLoader.onCompletion.invoke(new TypefaceResult.Immutable(asyncFontListLoader.getValue(), shouldCache32));
                        throw th;
                    case 2:
                        $i$f$fastForEach2 = 0;
                        i = asyncFontListLoader$load$1.I$1;
                        index$iv2 = asyncFontListLoader$load$1.I$0;
                        $this$fastForEach$iv3 = (List) asyncFontListLoader$load$1.L$1;
                        asyncFontListLoader = (AsyncFontListLoader) asyncFontListLoader$load$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        $i$f$fastForEach = $i$f$fastForEach2;
                        size = i;
                        index$iv = index$iv2;
                        $this$fastForEach$iv = $this$fastForEach$iv3;
                        index$iv++;
                        if (index$iv >= size) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        asyncFontListLoader$load$1 = new AsyncFontListLoader$load$1(this, continuation);
        Object $result22 = asyncFontListLoader$load$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (asyncFontListLoader$load$1.label) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|1|(2:3|(6:5|6|7|8|15|16))|30|6|7|8|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008b, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0094, code lost:
    
        if (kotlinx.coroutines.JobKt.isActive(r10.getContext()) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0097, code lost:
    
        throw r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
    
        r2 = (kotlinx.coroutines.CoroutineExceptionHandler) r10.getContext().get(kotlinx.coroutines.CoroutineExceptionHandler.INSTANCE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:
    
        if (r2 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        r2.handleException(r10.getContext(), new java.lang.IllegalStateException("Unable to load font " + r9, r1));
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadWithTimeoutOrNull$ui_text_release(Font $this$loadWithTimeoutOrNull, Continuation<Object> continuation) {
        AsyncFontListLoader$loadWithTimeoutOrNull$1 asyncFontListLoader$loadWithTimeoutOrNull$1;
        AsyncFontListLoader$loadWithTimeoutOrNull$1 asyncFontListLoader$loadWithTimeoutOrNull$12;
        if (continuation instanceof AsyncFontListLoader$loadWithTimeoutOrNull$1) {
            asyncFontListLoader$loadWithTimeoutOrNull$1 = (AsyncFontListLoader$loadWithTimeoutOrNull$1) continuation;
            if ((asyncFontListLoader$loadWithTimeoutOrNull$1.label & Integer.MIN_VALUE) != 0) {
                asyncFontListLoader$loadWithTimeoutOrNull$1.label -= Integer.MIN_VALUE;
                asyncFontListLoader$loadWithTimeoutOrNull$12 = asyncFontListLoader$loadWithTimeoutOrNull$1;
                Object $result = asyncFontListLoader$loadWithTimeoutOrNull$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                Object obj = null;
                switch (asyncFontListLoader$loadWithTimeoutOrNull$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        AsyncFontListLoader$loadWithTimeoutOrNull$2 asyncFontListLoader$loadWithTimeoutOrNull$2 = new AsyncFontListLoader$loadWithTimeoutOrNull$2(this, $this$loadWithTimeoutOrNull, null);
                        asyncFontListLoader$loadWithTimeoutOrNull$12.L$0 = $this$loadWithTimeoutOrNull;
                        asyncFontListLoader$loadWithTimeoutOrNull$12.label = 1;
                        obj = TimeoutKt.withTimeoutOrNull(15000L, asyncFontListLoader$loadWithTimeoutOrNull$2, asyncFontListLoader$loadWithTimeoutOrNull$12);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        $this$loadWithTimeoutOrNull = (Font) asyncFontListLoader$loadWithTimeoutOrNull$12.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return obj;
            }
        }
        asyncFontListLoader$loadWithTimeoutOrNull$1 = new AsyncFontListLoader$loadWithTimeoutOrNull$1(this, continuation);
        asyncFontListLoader$loadWithTimeoutOrNull$12 = asyncFontListLoader$loadWithTimeoutOrNull$1;
        Object $result2 = asyncFontListLoader$loadWithTimeoutOrNull$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Object obj2 = null;
        switch (asyncFontListLoader$loadWithTimeoutOrNull$12.label) {
        }
        return obj2;
    }
}
