package androidx.compose.p000ui.text.font;

import androidx.compose.p000ui.text.ExperimentalTextApi;
import androidx.compose.p000ui.text.font.AsyncTypefaceCache;
import androidx.compose.p000ui.text.platform.SynchronizedObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
@Metadata(m286d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\fH\u0003¨\u0006\r"}, m287d2 = {"firstImmediatelyAvailable", "Lkotlin/Pair;", "", "Landroidx/compose/ui/text/font/Font;", "", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "createDefaultTypeface", "Lkotlin/Function1;", "ui-text_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class FontListFontFamilyTypefaceAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalTextApi
    public static final Pair<List<Font>, Object> firstImmediatelyAvailable(List<? extends Font> list, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, PlatformFontLoader platformFontLoader, Function1<? super TypefaceRequest, ? extends Object> function1) {
        Object result;
        Object it$iv;
        Object obj;
        int size = list.size();
        List asyncFontsToLoad = null;
        for (int idx = 0; idx < size; idx++) {
            Font font = list.get(idx);
            int loadingStrategy = font.getLoadingStrategy();
            if (!FontLoadingStrategy.m4027equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m4032getBlockingPKNRLFQ())) {
                if (!FontLoadingStrategy.m4027equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m4033getOptionalLocalPKNRLFQ())) {
                    if (!FontLoadingStrategy.m4027equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m4031getAsyncPKNRLFQ())) {
                        throw new IllegalStateException("Unknown font type " + font);
                    }
                    AsyncTypefaceCache.AsyncTypefaceResult cacheResult = asyncTypefaceCache.m3997get1ASDuI8(font, platformFontLoader);
                    if (cacheResult == null) {
                        if (asyncFontsToLoad == null) {
                            asyncFontsToLoad = CollectionsKt.mutableListOf(font);
                        } else {
                            asyncFontsToLoad.add(font);
                        }
                    } else if (!AsyncTypefaceCache.AsyncTypefaceResult.m4003isPermanentFailureimpl(cacheResult.m4005unboximpl()) && cacheResult.m4005unboximpl() != null) {
                        return TuplesKt.m294to(asyncFontsToLoad, FontSynthesis_androidKt.m4059synthesizeTypefaceFxwP2eA(typefaceRequest.m4084getFontSynthesisGVVA2EU(), cacheResult.m4005unboximpl(), font, typefaceRequest.getFontWeight(), typefaceRequest.m4083getFontStyle_LCdwA()));
                    }
                } else {
                    SynchronizedObject lock$iv$iv = asyncTypefaceCache.cacheLock;
                    synchronized (lock$iv$iv) {
                        AsyncTypefaceCache.Key key$iv = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                        AsyncTypefaceCache.AsyncTypefaceResult priorResult$iv = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key$iv);
                        if (priorResult$iv == null) {
                            priorResult$iv = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key$iv);
                        }
                        if (priorResult$iv == null) {
                            Unit unit = Unit.INSTANCE;
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                it$iv = Result.m4732constructorimpl(platformFontLoader.loadBlocking(font));
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.INSTANCE;
                                it$iv = Result.m4732constructorimpl(ResultKt.createFailure(th));
                            }
                            if (Result.m4738isFailureimpl(it$iv)) {
                                it$iv = null;
                            }
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, it$iv, false, 8, null);
                            obj = it$iv;
                        } else {
                            obj = priorResult$iv.m4005unboximpl();
                        }
                    }
                    Object result2 = obj;
                    if (result2 != null) {
                        return TuplesKt.m294to(asyncFontsToLoad, FontSynthesis_androidKt.m4059synthesizeTypefaceFxwP2eA(typefaceRequest.m4084getFontSynthesisGVVA2EU(), result2, font, typefaceRequest.getFontWeight(), typefaceRequest.m4083getFontStyle_LCdwA()));
                    }
                }
            } else {
                SynchronizedObject lock$iv$iv2 = asyncTypefaceCache.cacheLock;
                synchronized (lock$iv$iv2) {
                    AsyncTypefaceCache.Key key$iv2 = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                    AsyncTypefaceCache.AsyncTypefaceResult priorResult$iv2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key$iv2);
                    if (priorResult$iv2 == null) {
                        priorResult$iv2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key$iv2);
                    }
                    if (priorResult$iv2 == null) {
                        Unit unit2 = Unit.INSTANCE;
                        try {
                            Object it$iv2 = platformFontLoader.loadBlocking(font);
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, it$iv2, false, 8, null);
                            result = it$iv2;
                        } catch (Exception cause) {
                            throw new IllegalStateException("Unable to load font " + font, cause);
                        }
                    } else {
                        result = priorResult$iv2.m4005unboximpl();
                    }
                }
                if (result == null) {
                    throw new IllegalStateException("Unable to load font " + font);
                }
                return TuplesKt.m294to(asyncFontsToLoad, FontSynthesis_androidKt.m4059synthesizeTypefaceFxwP2eA(typefaceRequest.m4084getFontSynthesisGVVA2EU(), result, font, typefaceRequest.getFontWeight(), typefaceRequest.m4083getFontStyle_LCdwA()));
            }
        }
        Object fallbackTypeface = function1.invoke(typefaceRequest);
        return TuplesKt.m294to(asyncFontsToLoad, fallbackTypeface);
    }
}
