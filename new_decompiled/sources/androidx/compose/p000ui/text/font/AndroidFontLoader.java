package androidx.compose.p000ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.p000ui.text.font.AndroidFont;
import androidx.compose.p000ui.text.font.FontVariation;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidFontLoader.android.kt */
@Metadata(m286d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\n \t*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, m287d2 = {"Landroidx/compose/ui/text/font/AndroidFontLoader;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/Object;", "kotlin.jvm.PlatformType", "awaitLoad", "Landroid/graphics/Typeface;", "font", "Landroidx/compose/ui/text/font/Font;", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBlocking", "ui-text_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AndroidFontLoader implements PlatformFontLoader {
    private final Object cacheKey;
    private final Context context;

    public AndroidFontLoader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context.getApplicationContext();
    }

    @Override // androidx.compose.p000ui.text.font.PlatformFontLoader
    public Typeface loadBlocking(Font font) {
        Object m4732constructorimpl;
        Typeface typeface;
        Typeface load;
        Intrinsics.checkNotNullParameter(font, "font");
        if (font instanceof AndroidFont) {
            AndroidFont.TypefaceLoader typefaceLoader = ((AndroidFont) font).getTypefaceLoader();
            Context context = this.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            return typefaceLoader.loadBlocking(context, (AndroidFont) font);
        }
        if (!(font instanceof ResourceFont)) {
            return null;
        }
        int loadingStrategy = font.getLoadingStrategy();
        if (FontLoadingStrategy.m4027equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m4032getBlockingPKNRLFQ())) {
            Context context2 = this.context;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            typeface = AndroidFontLoader_androidKt.load((ResourceFont) font, context2);
        } else if (FontLoadingStrategy.m4027equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m4033getOptionalLocalPKNRLFQ())) {
            try {
                Result.Companion companion = Result.INSTANCE;
                AndroidFontLoader $this$loadBlocking_u24lambda_u2d0 = this;
                Context context3 = $this$loadBlocking_u24lambda_u2d0.context;
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                load = AndroidFontLoader_androidKt.load((ResourceFont) font, context3);
                m4732constructorimpl = Result.m4732constructorimpl(load);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m4732constructorimpl = Result.m4732constructorimpl(ResultKt.createFailure(th));
            }
            typeface = (Typeface) (Result.m4738isFailureimpl(m4732constructorimpl) ? null : m4732constructorimpl);
        } else {
            if (FontLoadingStrategy.m4027equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m4031getAsyncPKNRLFQ())) {
                throw new UnsupportedOperationException("Unsupported Async font load path");
            }
            throw new IllegalArgumentException("Unknown loading type " + ((Object) FontLoadingStrategy.m4029toStringimpl(font.getLoadingStrategy())));
        }
        FontVariation.Settings variationSettings = ((ResourceFont) font).getVariationSettings();
        Context context4 = this.context;
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        return PlatformTypefacesKt.setFontVariationSettings(typeface, variationSettings, context4);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // androidx.compose.p000ui.text.font.PlatformFontLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object awaitLoad(Font font, Continuation<? super Typeface> continuation) {
        AndroidFontLoader$awaitLoad$1 androidFontLoader$awaitLoad$1;
        AndroidFontLoader$awaitLoad$1 androidFontLoader$awaitLoad$12;
        Object loadAsync;
        AndroidFontLoader androidFontLoader;
        if (continuation instanceof AndroidFontLoader$awaitLoad$1) {
            androidFontLoader$awaitLoad$1 = (AndroidFontLoader$awaitLoad$1) continuation;
            if ((androidFontLoader$awaitLoad$1.label & Integer.MIN_VALUE) != 0) {
                androidFontLoader$awaitLoad$1.label -= Integer.MIN_VALUE;
                androidFontLoader$awaitLoad$12 = androidFontLoader$awaitLoad$1;
                Object $result = androidFontLoader$awaitLoad$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (androidFontLoader$awaitLoad$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (font instanceof AndroidFont) {
                            AndroidFont.TypefaceLoader typefaceLoader = ((AndroidFont) font).getTypefaceLoader();
                            Context context = this.context;
                            Intrinsics.checkNotNullExpressionValue(context, "context");
                            androidFontLoader$awaitLoad$12.label = 1;
                            Object awaitLoad = typefaceLoader.awaitLoad(context, (AndroidFont) font, androidFontLoader$awaitLoad$12);
                            return awaitLoad == coroutine_suspended ? coroutine_suspended : awaitLoad;
                        }
                        if (!(font instanceof ResourceFont)) {
                            throw new IllegalArgumentException("Unknown font type: " + font);
                        }
                        Context context2 = this.context;
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        androidFontLoader$awaitLoad$12.L$0 = this;
                        androidFontLoader$awaitLoad$12.L$1 = font;
                        androidFontLoader$awaitLoad$12.label = 2;
                        loadAsync = AndroidFontLoader_androidKt.loadAsync((ResourceFont) font, context2, androidFontLoader$awaitLoad$12);
                        if (loadAsync != coroutine_suspended) {
                            androidFontLoader = this;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    case 2:
                        font = (Font) androidFontLoader$awaitLoad$12.L$1;
                        androidFontLoader = (AndroidFontLoader) androidFontLoader$awaitLoad$12.L$0;
                        ResultKt.throwOnFailure($result);
                        loadAsync = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                FontVariation.Settings variationSettings = ((ResourceFont) font).getVariationSettings();
                Context context3 = androidFontLoader.context;
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                return PlatformTypefacesKt.setFontVariationSettings((Typeface) loadAsync, variationSettings, context3);
            }
        }
        androidFontLoader$awaitLoad$1 = new AndroidFontLoader$awaitLoad$1(this, continuation);
        androidFontLoader$awaitLoad$12 = androidFontLoader$awaitLoad$1;
        Object $result2 = androidFontLoader$awaitLoad$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (androidFontLoader$awaitLoad$12.label) {
        }
        FontVariation.Settings variationSettings2 = ((ResourceFont) font).getVariationSettings();
        Context context32 = androidFontLoader.context;
        Intrinsics.checkNotNullExpressionValue(context32, "context");
        return PlatformTypefacesKt.setFontVariationSettings((Typeface) loadAsync, variationSettings2, context32);
    }

    @Override // androidx.compose.p000ui.text.font.PlatformFontLoader
    public Object getCacheKey() {
        return this.cacheKey;
    }
}
