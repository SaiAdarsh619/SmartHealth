package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.health.platform.client.SdkConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyStaggeredGridDsl.kt */
@Metadata(m286d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001at\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001at\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a?\u0010\u0019\u001a\u0019\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001a¢\u0006\u0002\b\u00152\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a?\u0010\u001f\u001a\u0019\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001a¢\u0006\u0002\b\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010 \u001a¦\u0001\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"*\u00020\u00142\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\"0#2%\b\u0002\u0010$\u001a\u001f\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(\u0018\u00010\u00132%\b\u0002\u0010)\u001a\u001f\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0006\u0012\u0004\u0018\u00010(0\u001321\u0010*\u001a-\u0012\u0004\u0012\u00020+\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b,¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010-\u001a¦\u0001\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"*\u00020\u00142\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\"0.2%\b\u0002\u0010$\u001a\u001f\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(\u0018\u00010\u00132%\b\u0002\u0010)\u001a\u001f\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0006\u0012\u0004\u0018\u00010(0\u001321\u0010*\u001a-\u0012\u0004\u0012\u00020+\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b,¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010/\u001aå\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"*\u00020\u00142\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\"0#2:\b\u0002\u0010$\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(\u0018\u00010\u001a2:\b\u0002\u0010)\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0006\u0012\u0004\u0018\u00010(0\u001a2F\u0010*\u001aB\u0012\u0004\u0012\u00020+\u0012\u0013\u0012\u001101¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b,¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u00104\u001aå\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"*\u00020\u00142\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\"0.2:\b\u0002\u0010$\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(\u0018\u00010\u001a2:\b\u0002\u0010)\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0006\u0012\u0004\u0018\u00010(0\u001a2F\u0010*\u001aB\u0012\u0004\u0012\u00020+\u0012\u0013\u0012\u001101¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\"¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b,¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u00105\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, m287d2 = {"LazyHorizontalStaggeredGrid", "", "rows", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalStaggeredGrid", "columns", "rememberColumnWidthSums", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "items", "T", "", "key", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "item", "", "contentType", "itemContent", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridDslKt {
    /* JADX WARN: Removed duplicated region for block: B:43:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0182  */
    @ExperimentalFoundationApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyVerticalStaggeredGrid(final StaggeredGridCells columns, Modifier modifier, LazyStaggeredGridState state, PaddingValues contentPadding, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, FlingBehavior flingBehavior, boolean userScrollEnabled, final Function1<? super LazyStaggeredGridScope, Unit> content, Composer $composer, final int $changed, final int i) {
        PaddingValues paddingValues;
        Arrangement.Vertical vertical;
        Arrangement.Horizontal horizontal;
        Modifier.Companion modifier2;
        LazyStaggeredGridState state2;
        PaddingValues contentPadding2;
        Arrangement.HorizontalOrVertical verticalArrangement2;
        Arrangement.HorizontalOrVertical horizontalArrangement2;
        FlingBehavior flingBehavior2;
        boolean userScrollEnabled2;
        Modifier modifier3;
        LazyStaggeredGridState state3;
        boolean userScrollEnabled3;
        PaddingValues contentPadding3;
        Arrangement.Vertical verticalArrangement3;
        Arrangement.Horizontal horizontalArrangement3;
        FlingBehavior flingBehavior3;
        ScopeUpdateScope endRestartGroup;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(columns, "columns");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-228373416);
        ComposerKt.sourceInformation($composer2, "C(LazyVerticalStaggeredGrid)P(!1,5,6,2,8,4,3,7)58@2819L32,62@3120L15,75@3603L71,66@3231L476:LazyStaggeredGridDsl.kt#fzvcnm");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(columns) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
            paddingValues = contentPadding;
        } else if (($changed & 7168) == 0) {
            paddingValues = contentPadding;
            $dirty |= $composer2.changed(paddingValues) ? 2048 : 1024;
        } else {
            paddingValues = contentPadding;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
            vertical = verticalArrangement;
        } else if (($changed & 57344) == 0) {
            vertical = verticalArrangement;
            $dirty |= $composer2.changed(vertical) ? 16384 : 8192;
        } else {
            vertical = verticalArrangement;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= 196608;
            horizontal = horizontalArrangement;
        } else if (($changed & 458752) == 0) {
            horizontal = horizontalArrangement;
            $dirty |= $composer2.changed(horizontal) ? 131072 : 65536;
        } else {
            horizontal = horizontalArrangement;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0 && $composer2.changed(flingBehavior)) {
                i3 = 1048576;
                $dirty |= i3;
            }
            i3 = 524288;
            $dirty |= i3;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer2.changed(userScrollEnabled) ? 8388608 : 4194304;
        }
        if ((i & 256) == 0) {
            i2 = ($changed & 234881024) == 0 ? $composer2.changed(content) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432 : 100663296;
            if (i5 != 4 && (191739611 & $dirty) == 38347922 && $composer2.getSkipping()) {
                $composer2.skipToGroupEnd();
                modifier3 = modifier;
                flingBehavior3 = flingBehavior;
                userScrollEnabled3 = userScrollEnabled;
                horizontalArrangement3 = horizontal;
                verticalArrangement3 = vertical;
                state3 = state;
                contentPadding3 = paddingValues;
            } else {
                $composer2.startDefaults();
                if (($changed & 1) != 0 || $composer2.getDefaultsInvalid()) {
                    modifier2 = i4 == 0 ? Modifier.INSTANCE : modifier;
                    if (i5 == 0) {
                        state2 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, $composer2, 0, 3);
                        $dirty &= -897;
                    } else {
                        state2 = state;
                    }
                    contentPadding2 = i6 == 0 ? PaddingKt.m752PaddingValues0680j_4(C0504Dp.m4382constructorimpl(0)) : paddingValues;
                    verticalArrangement2 = i7 == 0 ? Arrangement.INSTANCE.m704spacedBy0680j_4(C0504Dp.m4382constructorimpl(0)) : vertical;
                    horizontalArrangement2 = i8 == 0 ? Arrangement.INSTANCE.m704spacedBy0680j_4(C0504Dp.m4382constructorimpl(0)) : horizontal;
                    if ((i & 64) == 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior($composer2, 6);
                        $dirty &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    userScrollEnabled2 = i9 == 0 ? true : userScrollEnabled;
                } else {
                    $composer2.skipToGroupEnd();
                    if (i5 != 0) {
                        $dirty &= -897;
                    }
                    if ((i & 64) != 0) {
                        state2 = state;
                        userScrollEnabled2 = userScrollEnabled;
                        $dirty &= -3670017;
                        contentPadding2 = paddingValues;
                        horizontalArrangement2 = horizontal;
                        verticalArrangement2 = vertical;
                        modifier2 = modifier;
                        flingBehavior2 = flingBehavior;
                    } else {
                        modifier2 = modifier;
                        state2 = state;
                        userScrollEnabled2 = userScrollEnabled;
                        contentPadding2 = paddingValues;
                        horizontalArrangement2 = horizontal;
                        verticalArrangement2 = vertical;
                        flingBehavior2 = flingBehavior;
                    }
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-228373416, $dirty, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:55)");
                }
                LazyStaggeredGridKt.LazyStaggeredGrid(state2, Orientation.Vertical, rememberColumnWidthSums(columns, horizontalArrangement2, contentPadding2, $composer2, ($dirty & 14) | (($dirty >> 12) & SdkConfig.SDK_VERSION) | (($dirty >> 3) & 896)), modifier2, contentPadding2, false, flingBehavior2, userScrollEnabled2, verticalArrangement2, horizontalArrangement2, content, $composer2, (($dirty << 6) & 7168) | 56 | (($dirty << 3) & 57344) | ($dirty & 3670016) | ($dirty & 29360128) | (($dirty << 12) & 234881024) | (($dirty << 12) & 1879048192), ($dirty >> 24) & 14, 32);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                state3 = state2;
                userScrollEnabled3 = userScrollEnabled2;
                contentPadding3 = contentPadding2;
                verticalArrangement3 = verticalArrangement2;
                horizontalArrangement3 = horizontalArrangement2;
                flingBehavior3 = flingBehavior2;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Modifier modifier4 = modifier3;
            final LazyStaggeredGridState lazyStaggeredGridState = state3;
            final PaddingValues paddingValues2 = contentPadding3;
            final Arrangement.Vertical vertical2 = verticalArrangement3;
            final Arrangement.Horizontal horizontal2 = horizontalArrangement3;
            final FlingBehavior flingBehavior4 = flingBehavior3;
            final boolean z = userScrollEnabled3;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i10) {
                    LazyStaggeredGridDslKt.LazyVerticalStaggeredGrid(StaggeredGridCells.this, modifier4, lazyStaggeredGridState, paddingValues2, vertical2, horizontal2, flingBehavior4, z, content, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty |= i2;
        if (i5 != 4) {
        }
        $composer2.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i4 == 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
        if ((i & 64) == 0) {
        }
        if (i9 == 0) {
        }
        $composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        LazyStaggeredGridKt.LazyStaggeredGrid(state2, Orientation.Vertical, rememberColumnWidthSums(columns, horizontalArrangement2, contentPadding2, $composer2, ($dirty & 14) | (($dirty >> 12) & SdkConfig.SDK_VERSION) | (($dirty >> 3) & 896)), modifier2, contentPadding2, false, flingBehavior2, userScrollEnabled2, verticalArrangement2, horizontalArrangement2, content, $composer2, (($dirty << 6) & 7168) | 56 | (($dirty << 3) & 57344) | ($dirty & 3670016) | ($dirty & 29360128) | (($dirty << 12) & 234881024) | (($dirty << 12) & 1879048192), ($dirty >> 24) & 14, 32);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        state3 = state2;
        userScrollEnabled3 = userScrollEnabled2;
        contentPadding3 = contentPadding2;
        verticalArrangement3 = verticalArrangement2;
        horizontalArrangement3 = horizontalArrangement2;
        flingBehavior3 = flingBehavior2;
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final Function2<Density, Constraints, int[]> rememberColumnWidthSums(final StaggeredGridCells columns, final Arrangement.Horizontal horizontalArrangement, final PaddingValues contentPadding, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(1426908594);
        ComposerKt.sourceInformation($composer, "C(rememberColumnWidthSums)P(!1,2)87@3996L920:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1426908594, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberColumnWidthSums (LazyStaggeredGridDsl.kt:83)");
        }
        int i = ($changed & 14) | ($changed & SdkConfig.SDK_VERSION) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(columns) | $composer.changed(horizontalArrangement) | $composer.changed(contentPadding);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = (Function2) new Function2<Density, Constraints, int[]>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$rememberColumnWidthSums$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ int[] invoke(Density density, Constraints constraints) {
                    return m968invoke0kLqBqw(density, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final int[] m968invoke0kLqBqw(Density $this$null, long constraints) {
                    Intrinsics.checkNotNullParameter($this$null, "$this$null");
                    if (!(Constraints.m4338getMaxWidthimpl(constraints) != Integer.MAX_VALUE)) {
                        throw new IllegalArgumentException("LazyVerticalStaggeredGrid's width should be bound by parent.".toString());
                    }
                    float arg0$iv = PaddingKt.calculateStartPadding(PaddingValues.this, LayoutDirection.Ltr);
                    float other$iv = PaddingKt.calculateEndPadding(PaddingValues.this, LayoutDirection.Ltr);
                    int gridWidth = Constraints.m4338getMaxWidthimpl(constraints) - $this$null.mo642roundToPx0680j_4(C0504Dp.m4382constructorimpl(arg0$iv + other$iv));
                    StaggeredGridCells $this$invoke_0kLqBqw_u24lambda_u2d2 = columns;
                    List $this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1 = $this$invoke_0kLqBqw_u24lambda_u2d2.calculateCrossAxisCellSizes($this$null, gridWidth, $this$null.mo642roundToPx0680j_4(horizontalArrangement.getSpacing()));
                    int size = $this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1.size();
                    int[] result = new int[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        result[i2] = $this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1.get(i2).intValue();
                    }
                    int size2 = $this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1.size();
                    for (int i3 = 1; i3 < size2; i3++) {
                        result[i3] = result[i3] + result[i3 - 1];
                    }
                    return result;
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function2<Density, Constraints, int[]> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0182  */
    @ExperimentalFoundationApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyHorizontalStaggeredGrid(final StaggeredGridCells rows, Modifier modifier, LazyStaggeredGridState state, PaddingValues contentPadding, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, FlingBehavior flingBehavior, boolean userScrollEnabled, final Function1<? super LazyStaggeredGridScope, Unit> content, Composer $composer, final int $changed, final int i) {
        PaddingValues paddingValues;
        Arrangement.Vertical vertical;
        Arrangement.Horizontal horizontal;
        Modifier.Companion modifier2;
        LazyStaggeredGridState state2;
        PaddingValues contentPadding2;
        Arrangement.HorizontalOrVertical verticalArrangement2;
        Arrangement.HorizontalOrVertical horizontalArrangement2;
        FlingBehavior flingBehavior2;
        boolean userScrollEnabled2;
        Modifier modifier3;
        LazyStaggeredGridState state3;
        boolean userScrollEnabled3;
        PaddingValues contentPadding3;
        Arrangement.Vertical verticalArrangement3;
        Arrangement.Horizontal horizontalArrangement3;
        FlingBehavior flingBehavior3;
        ScopeUpdateScope endRestartGroup;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(rows, "rows");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-1591874454);
        ComposerKt.sourceInformation($composer2, "C(LazyHorizontalStaggeredGrid)P(5,4,6,1,8,3,2,7)140@6303L32,144@6604L15,157@7089L64,148@6715L471:LazyStaggeredGridDsl.kt#fzvcnm");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(rows) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
            paddingValues = contentPadding;
        } else if (($changed & 7168) == 0) {
            paddingValues = contentPadding;
            $dirty |= $composer2.changed(paddingValues) ? 2048 : 1024;
        } else {
            paddingValues = contentPadding;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
            vertical = verticalArrangement;
        } else if (($changed & 57344) == 0) {
            vertical = verticalArrangement;
            $dirty |= $composer2.changed(vertical) ? 16384 : 8192;
        } else {
            vertical = verticalArrangement;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= 196608;
            horizontal = horizontalArrangement;
        } else if (($changed & 458752) == 0) {
            horizontal = horizontalArrangement;
            $dirty |= $composer2.changed(horizontal) ? 131072 : 65536;
        } else {
            horizontal = horizontalArrangement;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0 && $composer2.changed(flingBehavior)) {
                i3 = 1048576;
                $dirty |= i3;
            }
            i3 = 524288;
            $dirty |= i3;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer2.changed(userScrollEnabled) ? 8388608 : 4194304;
        }
        if ((i & 256) == 0) {
            i2 = ($changed & 234881024) == 0 ? $composer2.changed(content) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432 : 100663296;
            if (i5 != 4 && (191739611 & $dirty) == 38347922 && $composer2.getSkipping()) {
                $composer2.skipToGroupEnd();
                modifier3 = modifier;
                flingBehavior3 = flingBehavior;
                userScrollEnabled3 = userScrollEnabled;
                horizontalArrangement3 = horizontal;
                verticalArrangement3 = vertical;
                state3 = state;
                contentPadding3 = paddingValues;
            } else {
                $composer2.startDefaults();
                if (($changed & 1) != 0 || $composer2.getDefaultsInvalid()) {
                    modifier2 = i4 == 0 ? Modifier.INSTANCE : modifier;
                    if (i5 == 0) {
                        state2 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, $composer2, 0, 3);
                        $dirty &= -897;
                    } else {
                        state2 = state;
                    }
                    contentPadding2 = i6 == 0 ? PaddingKt.m752PaddingValues0680j_4(C0504Dp.m4382constructorimpl(0)) : paddingValues;
                    verticalArrangement2 = i7 == 0 ? Arrangement.INSTANCE.m704spacedBy0680j_4(C0504Dp.m4382constructorimpl(0)) : vertical;
                    horizontalArrangement2 = i8 == 0 ? Arrangement.INSTANCE.m704spacedBy0680j_4(C0504Dp.m4382constructorimpl(0)) : horizontal;
                    if ((i & 64) == 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior($composer2, 6);
                        $dirty &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    userScrollEnabled2 = i9 == 0 ? true : userScrollEnabled;
                } else {
                    $composer2.skipToGroupEnd();
                    if (i5 != 0) {
                        $dirty &= -897;
                    }
                    if ((i & 64) != 0) {
                        state2 = state;
                        userScrollEnabled2 = userScrollEnabled;
                        $dirty &= -3670017;
                        contentPadding2 = paddingValues;
                        horizontalArrangement2 = horizontal;
                        verticalArrangement2 = vertical;
                        modifier2 = modifier;
                        flingBehavior2 = flingBehavior;
                    } else {
                        modifier2 = modifier;
                        state2 = state;
                        userScrollEnabled2 = userScrollEnabled;
                        contentPadding2 = paddingValues;
                        horizontalArrangement2 = horizontal;
                        verticalArrangement2 = vertical;
                        flingBehavior2 = flingBehavior;
                    }
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1591874454, $dirty, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:137)");
                }
                LazyStaggeredGridKt.LazyStaggeredGrid(state2, Orientation.Horizontal, rememberRowHeightSums(rows, verticalArrangement2, contentPadding2, $composer2, ($dirty & 14) | (($dirty >> 9) & SdkConfig.SDK_VERSION) | (($dirty >> 3) & 896)), modifier2, contentPadding2, false, flingBehavior2, userScrollEnabled2, verticalArrangement2, horizontalArrangement2, content, $composer2, (($dirty << 6) & 7168) | 56 | (($dirty << 3) & 57344) | ($dirty & 3670016) | ($dirty & 29360128) | (($dirty << 12) & 234881024) | (($dirty << 12) & 1879048192), ($dirty >> 24) & 14, 32);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                state3 = state2;
                userScrollEnabled3 = userScrollEnabled2;
                contentPadding3 = contentPadding2;
                verticalArrangement3 = verticalArrangement2;
                horizontalArrangement3 = horizontalArrangement2;
                flingBehavior3 = flingBehavior2;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Modifier modifier4 = modifier3;
            final LazyStaggeredGridState lazyStaggeredGridState = state3;
            final PaddingValues paddingValues2 = contentPadding3;
            final Arrangement.Vertical vertical2 = verticalArrangement3;
            final Arrangement.Horizontal horizontal2 = horizontalArrangement3;
            final FlingBehavior flingBehavior4 = flingBehavior3;
            final boolean z = userScrollEnabled3;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i10) {
                    LazyStaggeredGridDslKt.LazyHorizontalStaggeredGrid(StaggeredGridCells.this, modifier4, lazyStaggeredGridState, paddingValues2, vertical2, horizontal2, flingBehavior4, z, content, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty |= i2;
        if (i5 != 4) {
        }
        $composer2.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i4 == 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
        if ((i & 64) == 0) {
        }
        if (i9 == 0) {
        }
        $composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        LazyStaggeredGridKt.LazyStaggeredGrid(state2, Orientation.Horizontal, rememberRowHeightSums(rows, verticalArrangement2, contentPadding2, $composer2, ($dirty & 14) | (($dirty >> 9) & SdkConfig.SDK_VERSION) | (($dirty >> 3) & 896)), modifier2, contentPadding2, false, flingBehavior2, userScrollEnabled2, verticalArrangement2, horizontalArrangement2, content, $composer2, (($dirty << 6) & 7168) | 56 | (($dirty << 3) & 57344) | ($dirty & 3670016) | ($dirty & 29360128) | (($dirty << 12) & 234881024) | (($dirty << 12) & 1879048192), ($dirty >> 24) & 14, 32);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        state3 = state2;
        userScrollEnabled3 = userScrollEnabled2;
        contentPadding3 = contentPadding2;
        verticalArrangement3 = verticalArrangement2;
        horizontalArrangement3 = horizontalArrangement2;
        flingBehavior3 = flingBehavior2;
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final Function2<Density, Constraints, int[]> rememberRowHeightSums(final StaggeredGridCells rows, final Arrangement.Vertical verticalArrangement, final PaddingValues contentPadding, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(-1665208491);
        ComposerKt.sourceInformation($composer, "C(rememberRowHeightSums)P(1,2)169@7463L860:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1665208491, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberRowHeightSums (LazyStaggeredGridDsl.kt:165)");
        }
        int i = ($changed & 14) | ($changed & SdkConfig.SDK_VERSION) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(rows) | $composer.changed(verticalArrangement) | $composer.changed(contentPadding);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = (Function2) new Function2<Density, Constraints, int[]>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$rememberRowHeightSums$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ int[] invoke(Density density, Constraints constraints) {
                    return m969invoke0kLqBqw(density, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final int[] m969invoke0kLqBqw(Density $this$null, long constraints) {
                    Intrinsics.checkNotNullParameter($this$null, "$this$null");
                    if (!(Constraints.m4337getMaxHeightimpl(constraints) != Integer.MAX_VALUE)) {
                        throw new IllegalArgumentException("LazyHorizontalStaggeredGrid's height should be bound by parent.".toString());
                    }
                    float arg0$iv = PaddingValues.this.getTop();
                    float other$iv = PaddingValues.this.getBottom();
                    int gridHeight = Constraints.m4337getMaxHeightimpl(constraints) - $this$null.mo642roundToPx0680j_4(C0504Dp.m4382constructorimpl(arg0$iv + other$iv));
                    StaggeredGridCells $this$invoke_0kLqBqw_u24lambda_u2d2 = rows;
                    List $this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1 = $this$invoke_0kLqBqw_u24lambda_u2d2.calculateCrossAxisCellSizes($this$null, gridHeight, $this$null.mo642roundToPx0680j_4(verticalArrangement.getSpacing()));
                    int size = $this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1.size();
                    int[] result = new int[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        result[i2] = $this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1.get(i2).intValue();
                    }
                    int size2 = $this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1.size();
                    for (int i3 = 1; i3 < size2; i3++) {
                        result[i3] = result[i3] + result[i3 - 1];
                    }
                    return result;
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function2<Density, Constraints, int[]> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope lazyStaggeredGridScope, List list, Function1 function1, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke((LazyStaggeredGridDslKt$items$1) p1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }
            };
        }
        items(lazyStaggeredGridScope, list, function1, function12, function4);
    }

    @ExperimentalFoundationApi
    public static final <T> void items(LazyStaggeredGridScope $this$items, final List<? extends T> items, final Function1<? super T, ? extends Object> function1, final Function1<? super T, ? extends Object> contentType, final Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$items.items(items.size(), function1 != null ? new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final Object invoke(int index) {
                return function1.invoke(items.get(index));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }
        } : null, new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return contentType.invoke(items.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-666084403, true, new Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyStaggeredGridItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyStaggeredGridItemScope items2, int index, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(items2, "$this$items");
                ComposerKt.sourceInformation($composer, "C291@12510L25:LazyStaggeredGridDsl.kt#fzvcnm");
                int $dirty = $changed;
                if (($changed & 14) == 0) {
                    $dirty |= $composer.changed(items2) ? 4 : 2;
                }
                if (($changed & SdkConfig.SDK_VERSION) == 0) {
                    $dirty |= $composer.changed(index) ? 32 : 16;
                }
                if (($dirty & 731) == 146 && $composer.getSkipping()) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-666084403, $dirty, -1, "androidx.compose.foundation.lazy.staggeredgrid.items.<anonymous> (LazyStaggeredGridDsl.kt:291)");
                }
                itemContent.invoke(items2, items.get(index), $composer, Integer.valueOf($dirty & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope lazyStaggeredGridScope, List list, Function2 function2, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    return invoke(((Number) p1).intValue(), (int) p2);
                }

                public final Void invoke(int i2, T t) {
                    return null;
                }
            };
        }
        itemsIndexed(lazyStaggeredGridScope, list, function2, function22, function5);
    }

    @ExperimentalFoundationApi
    public static final <T> void itemsIndexed(LazyStaggeredGridScope $this$itemsIndexed, final List<? extends T> items, final Function2<? super Integer, ? super T, ? extends Object> function2, final Function2<? super Integer, ? super T, ? extends Object> contentType, final Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$itemsIndexed.items(items.size(), function2 != null ? new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final Object invoke(int index) {
                return function2.invoke(Integer.valueOf(index), items.get(index));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }
        } : null, new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return contentType.invoke(Integer.valueOf(index), items.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(330414727, true, new Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyStaggeredGridItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyStaggeredGridItemScope items2, int index, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(items2, "$this$items");
                ComposerKt.sourceInformation($composer, "C325@14020L32:LazyStaggeredGridDsl.kt#fzvcnm");
                int $dirty = $changed;
                if (($changed & 14) == 0) {
                    $dirty |= $composer.changed(items2) ? 4 : 2;
                }
                if (($changed & SdkConfig.SDK_VERSION) == 0) {
                    $dirty |= $composer.changed(index) ? 32 : 16;
                }
                if (($dirty & 731) == 146 && $composer.getSkipping()) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(330414727, $dirty, -1, "androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed.<anonymous> (LazyStaggeredGridDsl.kt:325)");
                }
                itemContent.invoke(items2, Integer.valueOf(index), items.get(index), $composer, Integer.valueOf(($dirty & 14) | ($dirty & SdkConfig.SDK_VERSION)));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope lazyStaggeredGridScope, Object[] objArr, Function1 function1, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$5
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke((LazyStaggeredGridDslKt$items$5) p1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }
            };
        }
        items(lazyStaggeredGridScope, objArr, function1, function12, function4);
    }

    @ExperimentalFoundationApi
    public static final <T> void items(LazyStaggeredGridScope $this$items, final T[] items, final Function1<? super T, ? extends Object> function1, final Function1<? super T, ? extends Object> contentType, final Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$items.items(items.length, function1 != null ? new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$6$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final Object invoke(int index) {
                return function1.invoke(items[index]);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }
        } : null, new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return contentType.invoke(items[index]);
            }
        }, ComposableLambdaKt.composableLambdaInstance(-301024882, true, new Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyStaggeredGridItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyStaggeredGridItemScope items2, int index, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(items2, "$this$items");
                ComposerKt.sourceInformation($composer, "C359@15451L25:LazyStaggeredGridDsl.kt#fzvcnm");
                int $dirty = $changed;
                if (($changed & 14) == 0) {
                    $dirty |= $composer.changed(items2) ? 4 : 2;
                }
                if (($changed & SdkConfig.SDK_VERSION) == 0) {
                    $dirty |= $composer.changed(index) ? 32 : 16;
                }
                if (($dirty & 731) == 146 && $composer.getSkipping()) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-301024882, $dirty, -1, "androidx.compose.foundation.lazy.staggeredgrid.items.<anonymous> (LazyStaggeredGridDsl.kt:359)");
                }
                itemContent.invoke(items2, items[index], $composer, Integer.valueOf($dirty & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope lazyStaggeredGridScope, Object[] objArr, Function2 function2, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    return invoke(((Number) p1).intValue(), (int) p2);
                }

                public final Void invoke(int i2, T t) {
                    return null;
                }
            };
        }
        itemsIndexed(lazyStaggeredGridScope, objArr, function2, function22, function5);
    }

    @ExperimentalFoundationApi
    public static final <T> void itemsIndexed(LazyStaggeredGridScope $this$itemsIndexed, final T[] items, final Function2<? super Integer, ? super T, ? extends Object> function2, final Function2<? super Integer, ? super T, ? extends Object> contentType, final Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$itemsIndexed.items(items.length, function2 != null ? new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$6$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final Object invoke(int index) {
                return function2.invoke(Integer.valueOf(index), items[index]);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }
        } : null, new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return contentType.invoke(Integer.valueOf(index), items[index]);
            }
        }, ComposableLambdaKt.composableLambdaInstance(-730083922, true, new Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyStaggeredGridItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyStaggeredGridItemScope items2, int index, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(items2, "$this$items");
                ComposerKt.sourceInformation($composer, "C393@16965L32:LazyStaggeredGridDsl.kt#fzvcnm");
                int $dirty = $changed;
                if (($changed & 14) == 0) {
                    $dirty |= $composer.changed(items2) ? 4 : 2;
                }
                if (($changed & SdkConfig.SDK_VERSION) == 0) {
                    $dirty |= $composer.changed(index) ? 32 : 16;
                }
                if (($dirty & 731) == 146 && $composer.getSkipping()) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-730083922, $dirty, -1, "androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed.<anonymous> (LazyStaggeredGridDsl.kt:393)");
                }
                itemContent.invoke(items2, Integer.valueOf(index), items[index], $composer, Integer.valueOf(($dirty & 14) | ($dirty & SdkConfig.SDK_VERSION)));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }
}
