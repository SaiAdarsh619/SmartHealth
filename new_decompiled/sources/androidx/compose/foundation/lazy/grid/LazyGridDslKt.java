package androidx.compose.foundation.lazy.grid;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.gestures.FlingBehavior;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyGridDsl.kt */
@Metadata(m286d1 = {"\u0000\u009a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a~\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001a\u001a&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0002\u001aE\u0010!\u001a\u001f\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\"¢\u0006\u0002\b\u00162\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010%\u001aE\u0010&\u001a\u001f\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\"¢\u0006\u0002\b\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010'\u001aá\u0001\u0010(\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0*2%\b\n\u0010+\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\u001420\b\n\u00100\u001a*\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010\"¢\u0006\u0002\b\u00162%\b\n\u00103\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\u001423\b\u0004\u00104\u001a-\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u00107\u001aá\u0001\u0010(\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0\u001c2%\b\n\u0010+\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\u001420\b\n\u00100\u001a*\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010\"¢\u0006\u0002\b\u00162%\b\n\u00103\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\u001423\b\u0004\u00104\u001a-\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u00108\u001aµ\u0002\u00109\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0*2:\b\n\u0010+\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\"2E\b\n\u00100\u001a?\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010;¢\u0006\u0002\b\u00162:\b\u0006\u00103\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\"2H\b\u0004\u00104\u001aB\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010<\u001aµ\u0002\u00109\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0\u001c2:\b\n\u0010+\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\"2E\b\n\u00100\u001a?\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010;¢\u0006\u0002\b\u00162:\b\u0006\u00103\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\"2H\b\u0004\u00104\u001aB\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010=\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006>"}, m287d2 = {"LazyHorizontalGrid", "", "rows", "Landroidx/compose/foundation/lazy/grid/GridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalGrid", "columns", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "calculateCellsCrossAxisSizeImpl", "", "", "gridSize", "slotCount", "spacing", "rememberColumnWidthSums", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "items", "T", "", "key", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "item", "", "span", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "itemContent", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LazyGridDslKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyVerticalGrid(final GridCells columns, Modifier modifier, LazyGridState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, FlingBehavior flingBehavior, boolean userScrollEnabled, final Function1<? super LazyGridScope, Unit> content, Composer $composer, final int $changed, final int i) {
        PaddingValues contentPadding2;
        boolean reverseLayout2;
        Arrangement.Vertical verticalArrangement2;
        Arrangement.Horizontal horizontalArrangement2;
        LazyGridState state2;
        Modifier modifier2;
        FlingBehavior flingBehavior2;
        Modifier modifier3;
        boolean userScrollEnabled2;
        int $dirty;
        FlingBehavior flingBehavior3;
        boolean reverseLayout3;
        Arrangement.Vertical verticalArrangement3;
        Modifier modifier4;
        boolean reverseLayout4;
        Arrangement.Vertical verticalArrangement4;
        LazyGridState state3;
        FlingBehavior flingBehavior4;
        boolean userScrollEnabled3;
        PaddingValues contentPadding3;
        Arrangement.Horizontal horizontalArrangement3;
        ScopeUpdateScope endRestartGroup;
        int i2;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(columns, "columns");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(1485410512);
        ComposerKt.sourceInformation($composer2, "C(LazyVerticalGrid)P(!1,5,7,2,6,9,4,3,8)65@3041L23,71@3401L15,75@3523L71,76@3599L431:LazyGridDsl.kt#7791vq");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(columns) ? 4 : 2;
        }
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty2 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0 && $composer2.changed(state)) {
                i5 = 256;
                $dirty2 |= i5;
            }
            i5 = 128;
            $dirty2 |= i5;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            contentPadding2 = contentPadding;
        } else if (($changed & 7168) == 0) {
            contentPadding2 = contentPadding;
            $dirty2 |= $composer2.changed(contentPadding2) ? 2048 : 1024;
        } else {
            contentPadding2 = contentPadding;
        }
        int i8 = i & 16;
        if (i8 != 0) {
            $dirty2 |= 24576;
            reverseLayout2 = reverseLayout;
        } else if (($changed & 57344) == 0) {
            reverseLayout2 = reverseLayout;
            $dirty2 |= $composer2.changed(reverseLayout2) ? 16384 : 8192;
        } else {
            reverseLayout2 = reverseLayout;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                verticalArrangement2 = verticalArrangement;
                if ($composer2.changed(verticalArrangement2)) {
                    i4 = 131072;
                    $dirty2 |= i4;
                }
            } else {
                verticalArrangement2 = verticalArrangement;
            }
            i4 = 65536;
            $dirty2 |= i4;
        } else {
            verticalArrangement2 = verticalArrangement;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty2 |= 1572864;
            horizontalArrangement2 = horizontalArrangement;
        } else if (($changed & 3670016) == 0) {
            horizontalArrangement2 = horizontalArrangement;
            $dirty2 |= $composer2.changed(horizontalArrangement2) ? 1048576 : 524288;
        } else {
            horizontalArrangement2 = horizontalArrangement;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0 && $composer2.changed(flingBehavior)) {
                i3 = 8388608;
                $dirty2 |= i3;
            }
            i3 = 4194304;
            $dirty2 |= i3;
        }
        int i10 = i & 256;
        if (i10 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer2.changed(userScrollEnabled) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 512) == 0) {
            i2 = ($changed & 1879048192) == 0 ? $composer2.changed(content) ? 536870912 : 268435456 : 805306368;
            if ((1533916891 & $dirty2) == 306783378 || !$composer2.getSkipping()) {
                $composer2.startDefaults();
                if (($changed & 1) != 0 || $composer2.getDefaultsInvalid()) {
                    Modifier.Companion modifier5 = i6 == 0 ? Modifier.INSTANCE : modifier;
                    if ((i & 4) == 0) {
                        state2 = LazyGridStateKt.rememberLazyGridState(0, 0, $composer2, 0, 3);
                        $dirty2 &= -897;
                    } else {
                        state2 = state;
                    }
                    if (i7 == 0) {
                        modifier2 = modifier5;
                        contentPadding2 = PaddingKt.m752PaddingValues0680j_4(C0504Dp.m4382constructorimpl(0));
                    } else {
                        modifier2 = modifier5;
                    }
                    if (i8 != 0) {
                        reverseLayout2 = false;
                    }
                    if ((i & 32) != 0) {
                        Arrangement arrangement = Arrangement.INSTANCE;
                        $dirty2 &= -458753;
                        verticalArrangement2 = !reverseLayout2 ? arrangement.getTop() : arrangement.getBottom();
                    }
                    if (i9 != 0) {
                        horizontalArrangement2 = Arrangement.INSTANCE.getStart();
                    }
                    if ((i & 128) == 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior($composer2, 6);
                        $dirty2 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 == 0) {
                        userScrollEnabled2 = true;
                        $dirty = $dirty2;
                        flingBehavior3 = flingBehavior2;
                        reverseLayout3 = reverseLayout2;
                        verticalArrangement3 = verticalArrangement2;
                        modifier3 = modifier2;
                    } else {
                        modifier3 = modifier2;
                        userScrollEnabled2 = userScrollEnabled;
                        $dirty = $dirty2;
                        flingBehavior3 = flingBehavior2;
                        reverseLayout3 = reverseLayout2;
                        verticalArrangement3 = verticalArrangement2;
                    }
                } else {
                    $composer2.skipToGroupEnd();
                    if ((i & 4) != 0) {
                        $dirty2 &= -897;
                    }
                    if ((i & 32) != 0) {
                        $dirty2 &= -458753;
                    }
                    if ((i & 128) != 0) {
                        state2 = state;
                        flingBehavior3 = flingBehavior;
                        userScrollEnabled2 = userScrollEnabled;
                        $dirty = (-29360129) & $dirty2;
                        reverseLayout3 = reverseLayout2;
                        verticalArrangement3 = verticalArrangement2;
                        modifier3 = modifier;
                    } else {
                        modifier3 = modifier;
                        state2 = state;
                        flingBehavior3 = flingBehavior;
                        userScrollEnabled2 = userScrollEnabled;
                        $dirty = $dirty2;
                        reverseLayout3 = reverseLayout2;
                        verticalArrangement3 = verticalArrangement2;
                    }
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, $dirty, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:62)");
                }
                Function2 slotSizesSums = rememberColumnWidthSums(columns, horizontalArrangement2, contentPadding2, $composer2, ($dirty & 14) | (($dirty >> 15) & SdkConfig.SDK_VERSION) | (($dirty >> 3) & 896));
                LazyGridKt.LazyGrid(modifier3, state2, slotSizesSums, contentPadding2, reverseLayout3, true, flingBehavior3, userScrollEnabled2, verticalArrangement3, horizontalArrangement2, content, $composer2, (($dirty >> 3) & 14) | 196608 | (($dirty >> 3) & SdkConfig.SDK_VERSION) | ($dirty & 7168) | (57344 & $dirty) | (($dirty >> 3) & 3670016) | (($dirty >> 3) & 29360128) | (($dirty << 9) & 234881024) | (($dirty << 9) & 1879048192), ($dirty >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                reverseLayout4 = reverseLayout3;
                verticalArrangement4 = verticalArrangement3;
                state3 = state2;
                flingBehavior4 = flingBehavior3;
                userScrollEnabled3 = userScrollEnabled2;
                contentPadding3 = contentPadding2;
                horizontalArrangement3 = horizontalArrangement2;
            } else {
                $composer2.skipToGroupEnd();
                flingBehavior4 = flingBehavior;
                userScrollEnabled3 = userScrollEnabled;
                contentPadding3 = contentPadding2;
                horizontalArrangement3 = horizontalArrangement2;
                reverseLayout4 = reverseLayout2;
                verticalArrangement4 = verticalArrangement2;
                modifier4 = modifier;
                state3 = state;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Modifier modifier6 = modifier4;
            final LazyGridState lazyGridState = state3;
            final PaddingValues paddingValues = contentPadding3;
            final boolean z = reverseLayout4;
            final Arrangement.Vertical vertical = verticalArrangement4;
            final Arrangement.Horizontal horizontal = horizontalArrangement3;
            final FlingBehavior flingBehavior5 = flingBehavior4;
            final boolean z2 = userScrollEnabled3;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyVerticalGrid$1
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

                public final void invoke(Composer composer, int i11) {
                    LazyGridDslKt.LazyVerticalGrid(GridCells.this, modifier6, lazyGridState, paddingValues, z, vertical, horizontal, flingBehavior5, z2, content, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty2 |= i2;
        if ((1533916891 & $dirty2) == 306783378) {
        }
        $composer2.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i6 == 0) {
        }
        if ((i & 4) == 0) {
        }
        if (i7 == 0) {
        }
        if (i8 != 0) {
        }
        if ((i & 32) != 0) {
        }
        if (i9 != 0) {
        }
        if ((i & 128) == 0) {
        }
        if (i10 == 0) {
        }
        $composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Function2 slotSizesSums2 = rememberColumnWidthSums(columns, horizontalArrangement2, contentPadding2, $composer2, ($dirty & 14) | (($dirty >> 15) & SdkConfig.SDK_VERSION) | (($dirty >> 3) & 896));
        LazyGridKt.LazyGrid(modifier3, state2, slotSizesSums2, contentPadding2, reverseLayout3, true, flingBehavior3, userScrollEnabled2, verticalArrangement3, horizontalArrangement2, content, $composer2, (($dirty >> 3) & 14) | 196608 | (($dirty >> 3) & SdkConfig.SDK_VERSION) | ($dirty & 7168) | (57344 & $dirty) | (($dirty >> 3) & 3670016) | (($dirty >> 3) & 29360128) | (($dirty << 9) & 234881024) | (($dirty << 9) & 1879048192), ($dirty >> 27) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        reverseLayout4 = reverseLayout3;
        verticalArrangement4 = verticalArrangement3;
        state3 = state2;
        flingBehavior4 = flingBehavior3;
        userScrollEnabled3 = userScrollEnabled2;
        contentPadding3 = contentPadding2;
        horizontalArrangement3 = horizontalArrangement2;
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyHorizontalGrid(final GridCells rows, Modifier modifier, LazyGridState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, FlingBehavior flingBehavior, boolean userScrollEnabled, final Function1<? super LazyGridScope, Unit> content, Composer $composer, final int $changed, final int i) {
        PaddingValues contentPadding2;
        boolean reverseLayout2;
        Arrangement.Horizontal horizontalArrangement2;
        Arrangement.Vertical verticalArrangement2;
        LazyGridState state2;
        Modifier modifier2;
        FlingBehavior flingBehavior2;
        Modifier modifier3;
        boolean userScrollEnabled2;
        int $dirty;
        FlingBehavior flingBehavior3;
        boolean reverseLayout3;
        Arrangement.Horizontal horizontalArrangement3;
        Modifier modifier4;
        boolean reverseLayout4;
        Arrangement.Horizontal horizontalArrangement4;
        LazyGridState state3;
        FlingBehavior flingBehavior4;
        boolean userScrollEnabled3;
        PaddingValues contentPadding3;
        Arrangement.Vertical verticalArrangement3;
        ScopeUpdateScope endRestartGroup;
        int i2;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(rows, "rows");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(2123608858);
        ComposerKt.sourceInformation($composer2, "C(LazyHorizontalGrid)P(6,4,7,1,5,3,9,2,8)119@5584L23,125@5941L15,129@6063L64,130@6132L432:LazyGridDsl.kt#7791vq");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(rows) ? 4 : 2;
        }
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty2 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0 && $composer2.changed(state)) {
                i5 = 256;
                $dirty2 |= i5;
            }
            i5 = 128;
            $dirty2 |= i5;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            contentPadding2 = contentPadding;
        } else if (($changed & 7168) == 0) {
            contentPadding2 = contentPadding;
            $dirty2 |= $composer2.changed(contentPadding2) ? 2048 : 1024;
        } else {
            contentPadding2 = contentPadding;
        }
        int i8 = i & 16;
        if (i8 != 0) {
            $dirty2 |= 24576;
            reverseLayout2 = reverseLayout;
        } else if (($changed & 57344) == 0) {
            reverseLayout2 = reverseLayout;
            $dirty2 |= $composer2.changed(reverseLayout2) ? 16384 : 8192;
        } else {
            reverseLayout2 = reverseLayout;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                horizontalArrangement2 = horizontalArrangement;
                if ($composer2.changed(horizontalArrangement2)) {
                    i4 = 131072;
                    $dirty2 |= i4;
                }
            } else {
                horizontalArrangement2 = horizontalArrangement;
            }
            i4 = 65536;
            $dirty2 |= i4;
        } else {
            horizontalArrangement2 = horizontalArrangement;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty2 |= 1572864;
            verticalArrangement2 = verticalArrangement;
        } else if (($changed & 3670016) == 0) {
            verticalArrangement2 = verticalArrangement;
            $dirty2 |= $composer2.changed(verticalArrangement2) ? 1048576 : 524288;
        } else {
            verticalArrangement2 = verticalArrangement;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0 && $composer2.changed(flingBehavior)) {
                i3 = 8388608;
                $dirty2 |= i3;
            }
            i3 = 4194304;
            $dirty2 |= i3;
        }
        int i10 = i & 256;
        if (i10 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer2.changed(userScrollEnabled) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 512) == 0) {
            i2 = ($changed & 1879048192) == 0 ? $composer2.changed(content) ? 536870912 : 268435456 : 805306368;
            if ((1533916891 & $dirty2) == 306783378 || !$composer2.getSkipping()) {
                $composer2.startDefaults();
                if (($changed & 1) != 0 || $composer2.getDefaultsInvalid()) {
                    Modifier.Companion modifier5 = i6 == 0 ? Modifier.INSTANCE : modifier;
                    if ((i & 4) == 0) {
                        state2 = LazyGridStateKt.rememberLazyGridState(0, 0, $composer2, 0, 3);
                        $dirty2 &= -897;
                    } else {
                        state2 = state;
                    }
                    if (i7 == 0) {
                        modifier2 = modifier5;
                        contentPadding2 = PaddingKt.m752PaddingValues0680j_4(C0504Dp.m4382constructorimpl(0));
                    } else {
                        modifier2 = modifier5;
                    }
                    if (i8 != 0) {
                        reverseLayout2 = false;
                    }
                    if ((i & 32) != 0) {
                        Arrangement arrangement = Arrangement.INSTANCE;
                        $dirty2 &= -458753;
                        horizontalArrangement2 = !reverseLayout2 ? arrangement.getStart() : arrangement.getEnd();
                    }
                    if (i9 != 0) {
                        verticalArrangement2 = Arrangement.INSTANCE.getTop();
                    }
                    if ((i & 128) == 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior($composer2, 6);
                        $dirty2 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 == 0) {
                        userScrollEnabled2 = true;
                        $dirty = $dirty2;
                        flingBehavior3 = flingBehavior2;
                        reverseLayout3 = reverseLayout2;
                        horizontalArrangement3 = horizontalArrangement2;
                        modifier3 = modifier2;
                    } else {
                        modifier3 = modifier2;
                        userScrollEnabled2 = userScrollEnabled;
                        $dirty = $dirty2;
                        flingBehavior3 = flingBehavior2;
                        reverseLayout3 = reverseLayout2;
                        horizontalArrangement3 = horizontalArrangement2;
                    }
                } else {
                    $composer2.skipToGroupEnd();
                    if ((i & 4) != 0) {
                        $dirty2 &= -897;
                    }
                    if ((i & 32) != 0) {
                        $dirty2 &= -458753;
                    }
                    if ((i & 128) != 0) {
                        state2 = state;
                        flingBehavior3 = flingBehavior;
                        userScrollEnabled2 = userScrollEnabled;
                        $dirty = (-29360129) & $dirty2;
                        reverseLayout3 = reverseLayout2;
                        horizontalArrangement3 = horizontalArrangement2;
                        modifier3 = modifier;
                    } else {
                        modifier3 = modifier;
                        state2 = state;
                        flingBehavior3 = flingBehavior;
                        userScrollEnabled2 = userScrollEnabled;
                        $dirty = $dirty2;
                        reverseLayout3 = reverseLayout2;
                        horizontalArrangement3 = horizontalArrangement2;
                    }
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2123608858, $dirty, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:116)");
                }
                Function2 slotSizesSums = rememberRowHeightSums(rows, verticalArrangement2, contentPadding2, $composer2, ($dirty & 14) | (($dirty >> 15) & SdkConfig.SDK_VERSION) | (($dirty >> 3) & 896));
                LazyGridKt.LazyGrid(modifier3, state2, slotSizesSums, contentPadding2, reverseLayout3, false, flingBehavior3, userScrollEnabled2, verticalArrangement2, horizontalArrangement3, content, $composer2, (($dirty >> 3) & 14) | 196608 | (($dirty >> 3) & SdkConfig.SDK_VERSION) | ($dirty & 7168) | (57344 & $dirty) | (($dirty >> 3) & 3670016) | (($dirty >> 3) & 29360128) | (($dirty << 6) & 234881024) | (($dirty << 12) & 1879048192), ($dirty >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                reverseLayout4 = reverseLayout3;
                horizontalArrangement4 = horizontalArrangement3;
                state3 = state2;
                flingBehavior4 = flingBehavior3;
                userScrollEnabled3 = userScrollEnabled2;
                contentPadding3 = contentPadding2;
                verticalArrangement3 = verticalArrangement2;
            } else {
                $composer2.skipToGroupEnd();
                flingBehavior4 = flingBehavior;
                userScrollEnabled3 = userScrollEnabled;
                contentPadding3 = contentPadding2;
                verticalArrangement3 = verticalArrangement2;
                reverseLayout4 = reverseLayout2;
                horizontalArrangement4 = horizontalArrangement2;
                modifier4 = modifier;
                state3 = state;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Modifier modifier6 = modifier4;
            final LazyGridState lazyGridState = state3;
            final PaddingValues paddingValues = contentPadding3;
            final boolean z = reverseLayout4;
            final Arrangement.Horizontal horizontal = horizontalArrangement4;
            final Arrangement.Vertical vertical = verticalArrangement3;
            final FlingBehavior flingBehavior5 = flingBehavior4;
            final boolean z2 = userScrollEnabled3;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyHorizontalGrid$1
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

                public final void invoke(Composer composer, int i11) {
                    LazyGridDslKt.LazyHorizontalGrid(GridCells.this, modifier6, lazyGridState, paddingValues, z, horizontal, vertical, flingBehavior5, z2, content, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty2 |= i2;
        if ((1533916891 & $dirty2) == 306783378) {
        }
        $composer2.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i6 == 0) {
        }
        if ((i & 4) == 0) {
        }
        if (i7 == 0) {
        }
        if (i8 != 0) {
        }
        if ((i & 32) != 0) {
        }
        if (i9 != 0) {
        }
        if ((i & 128) == 0) {
        }
        if (i10 == 0) {
        }
        $composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Function2 slotSizesSums2 = rememberRowHeightSums(rows, verticalArrangement2, contentPadding2, $composer2, ($dirty & 14) | (($dirty >> 15) & SdkConfig.SDK_VERSION) | (($dirty >> 3) & 896));
        LazyGridKt.LazyGrid(modifier3, state2, slotSizesSums2, contentPadding2, reverseLayout3, false, flingBehavior3, userScrollEnabled2, verticalArrangement2, horizontalArrangement3, content, $composer2, (($dirty >> 3) & 14) | 196608 | (($dirty >> 3) & SdkConfig.SDK_VERSION) | ($dirty & 7168) | (57344 & $dirty) | (($dirty >> 3) & 3670016) | (($dirty >> 3) & 29360128) | (($dirty << 6) & 234881024) | (($dirty << 12) & 1879048192), ($dirty >> 27) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        reverseLayout4 = reverseLayout3;
        horizontalArrangement4 = horizontalArrangement3;
        state3 = state2;
        flingBehavior4 = flingBehavior3;
        userScrollEnabled3 = userScrollEnabled2;
        contentPadding3 = contentPadding2;
        verticalArrangement3 = verticalArrangement2;
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final Function2<Density, Constraints, List<Integer>> rememberColumnWidthSums(final GridCells columns, final Arrangement.Horizontal horizontalArrangement, final PaddingValues contentPadding, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(-1355301804);
        ComposerKt.sourceInformation($composer, "C(rememberColumnWidthSums)P(!1,2)152@6816L830:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1355301804, $changed, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:148)");
        }
        int i = ($changed & 14) | ($changed & SdkConfig.SDK_VERSION) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(columns) | $composer.changed(horizontalArrangement) | $composer.changed(contentPadding);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = (Function2) new Function2<Density, Constraints, List<Integer>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$rememberColumnWidthSums$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ List<Integer> invoke(Density density, Constraints constraints) {
                    return m915invoke0kLqBqw(density, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final List<Integer> m915invoke0kLqBqw(Density $this$null, long constraints) {
                    Intrinsics.checkNotNullParameter($this$null, "$this$null");
                    if (!(Constraints.m4338getMaxWidthimpl(constraints) != Integer.MAX_VALUE)) {
                        throw new IllegalArgumentException("LazyVerticalGrid's width should be bound by parent.".toString());
                    }
                    float arg0$iv = PaddingKt.calculateStartPadding(PaddingValues.this, LayoutDirection.Ltr);
                    float other$iv = PaddingKt.calculateEndPadding(PaddingValues.this, LayoutDirection.Ltr);
                    int gridWidth = Constraints.m4338getMaxWidthimpl(constraints) - $this$null.mo642roundToPx0680j_4(C0504Dp.m4382constructorimpl(arg0$iv + other$iv));
                    GridCells $this$invoke_0kLqBqw_u24lambda_u2d2 = columns;
                    List $this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1 = CollectionsKt.toMutableList((Collection) $this$invoke_0kLqBqw_u24lambda_u2d2.calculateCrossAxisCellSizes($this$null, gridWidth, $this$null.mo642roundToPx0680j_4(horizontalArrangement.getSpacing())));
                    int size = $this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1.size();
                    for (int i2 = 1; i2 < size; i2++) {
                        $this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1.set(i2, Integer.valueOf($this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1.get(i2).intValue() + $this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1.get(i2 - 1).intValue()));
                    }
                    return $this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1;
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function2<Density, Constraints, List<Integer>> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }

    private static final Function2<Density, Constraints, List<Integer>> rememberRowHeightSums(final GridCells rows, final Arrangement.Vertical verticalArrangement, final PaddingValues contentPadding, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(239683573);
        ComposerKt.sourceInformation($composer, "C(rememberRowHeightSums)P(1,2)184@7885L786:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(239683573, $changed, -1, "androidx.compose.foundation.lazy.grid.rememberRowHeightSums (LazyGridDsl.kt:180)");
        }
        int i = ($changed & 14) | ($changed & SdkConfig.SDK_VERSION) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(rows) | $composer.changed(verticalArrangement) | $composer.changed(contentPadding);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = (Function2) new Function2<Density, Constraints, List<Integer>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$rememberRowHeightSums$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ List<Integer> invoke(Density density, Constraints constraints) {
                    return m916invoke0kLqBqw(density, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final List<Integer> m916invoke0kLqBqw(Density $this$null, long constraints) {
                    Intrinsics.checkNotNullParameter($this$null, "$this$null");
                    if (!(Constraints.m4337getMaxHeightimpl(constraints) != Integer.MAX_VALUE)) {
                        throw new IllegalArgumentException("LazyHorizontalGrid's height should be bound by parent.".toString());
                    }
                    float arg0$iv = PaddingValues.this.getTop();
                    float other$iv = PaddingValues.this.getBottom();
                    int gridHeight = Constraints.m4337getMaxHeightimpl(constraints) - $this$null.mo642roundToPx0680j_4(C0504Dp.m4382constructorimpl(arg0$iv + other$iv));
                    GridCells $this$invoke_0kLqBqw_u24lambda_u2d2 = rows;
                    List $this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1 = CollectionsKt.toMutableList((Collection) $this$invoke_0kLqBqw_u24lambda_u2d2.calculateCrossAxisCellSizes($this$null, gridHeight, $this$null.mo642roundToPx0680j_4(verticalArrangement.getSpacing())));
                    int size = $this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1.size();
                    for (int i2 = 1; i2 < size; i2++) {
                        $this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1.set(i2, Integer.valueOf($this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1.get(i2).intValue() + $this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1.get(i2 - 1).intValue()));
                    }
                    return $this$invoke_0kLqBqw_u24lambda_u2d2_u24lambda_u2d1;
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function2<Density, Constraints, List<Integer>> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Integer> calculateCellsCrossAxisSizeImpl(int gridSize, int slotCount, int spacing) {
        int gridSizeWithoutSpacing = gridSize - ((slotCount - 1) * spacing);
        int slotSize = gridSizeWithoutSpacing / slotCount;
        int remainingPixels = gridSizeWithoutSpacing % slotCount;
        ArrayList arrayList = new ArrayList(slotCount);
        for (int i = 0; i < slotCount; i++) {
            int it = i;
            arrayList.add(Integer.valueOf((it < remainingPixels ? 1 : 0) + slotSize));
        }
        return arrayList;
    }

    public static /* synthetic */ void items$default(LazyGridScope $this$items_u24default, List items, Function1 key, Function2 span, Function1 contentType, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            span = null;
        }
        if ((i & 8) != 0) {
            Function1 contentType2 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke((LazyGridDslKt$items$1) p1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }
            };
            contentType = contentType2;
        }
        Intrinsics.checkNotNullParameter($this$items_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$items_u24default.items(items.size(), key != null ? new LazyGridDslKt$items$2(key, items) : null, span != null ? new LazyGridDslKt$items$3(span, items) : null, new LazyGridDslKt$items$4(contentType, items), ComposableLambdaKt.composableLambdaInstance(699646206, true, new LazyGridDslKt$items$5(itemContent, items)));
    }

    public static final <T> void items(LazyGridScope $this$items, List<? extends T> items, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> contentType, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$items.items(items.size(), function1 != null ? new LazyGridDslKt$items$2(function1, items) : null, function2 != null ? new LazyGridDslKt$items$3(function2, items) : null, new LazyGridDslKt$items$4(contentType, items), ComposableLambdaKt.composableLambdaInstance(699646206, true, new LazyGridDslKt$items$5(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope $this$itemsIndexed_u24default, List items, Function2 key, Function3 span, Function2 contentType, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            span = null;
        }
        if ((i & 8) != 0) {
            Function2 contentType2 = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    return invoke(((Number) p1).intValue(), (int) p2);
                }

                public final Void invoke(int i2, T t) {
                    return null;
                }
            };
            contentType = contentType2;
        }
        Intrinsics.checkNotNullParameter($this$itemsIndexed_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$itemsIndexed_u24default.items(items.size(), key != null ? new LazyGridDslKt$itemsIndexed$2(key, items) : null, span != null ? new LazyGridDslKt$itemsIndexed$3(span, items) : null, new LazyGridDslKt$itemsIndexed$4(contentType, items), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new LazyGridDslKt$itemsIndexed$5(itemContent, items)));
    }

    public static final <T> void itemsIndexed(LazyGridScope $this$itemsIndexed, List<? extends T> items, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> contentType, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$itemsIndexed.items(items.size(), function2 != null ? new LazyGridDslKt$itemsIndexed$2(function2, items) : null, function3 != null ? new LazyGridDslKt$itemsIndexed$3(function3, items) : null, new LazyGridDslKt$itemsIndexed$4(contentType, items), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new LazyGridDslKt$itemsIndexed$5(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyGridScope $this$items_u24default, Object[] items, Function1 key, Function2 span, Function1 contentType, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            span = null;
        }
        if ((i & 8) != 0) {
            Function1 contentType2 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$6
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke((LazyGridDslKt$items$6) p1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }
            };
            contentType = contentType2;
        }
        Intrinsics.checkNotNullParameter($this$items_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$items_u24default.items(items.length, key != null ? new LazyGridDslKt$items$7(key, items) : null, span != null ? new LazyGridDslKt$items$8(span, items) : null, new LazyGridDslKt$items$9(contentType, items), ComposableLambdaKt.composableLambdaInstance(407562193, true, new LazyGridDslKt$items$10(itemContent, items)));
    }

    public static final <T> void items(LazyGridScope $this$items, T[] items, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> contentType, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$items.items(items.length, function1 != null ? new LazyGridDslKt$items$7(function1, items) : null, function2 != null ? new LazyGridDslKt$items$8(function2, items) : null, new LazyGridDslKt$items$9(contentType, items), ComposableLambdaKt.composableLambdaInstance(407562193, true, new LazyGridDslKt$items$10(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope $this$itemsIndexed_u24default, Object[] items, Function2 key, Function3 span, Function2 contentType, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            span = null;
        }
        if ((i & 8) != 0) {
            Function2 contentType2 = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    return invoke(((Number) p1).intValue(), (int) p2);
                }

                public final Void invoke(int i2, T t) {
                    return null;
                }
            };
            contentType = contentType2;
        }
        Intrinsics.checkNotNullParameter($this$itemsIndexed_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$itemsIndexed_u24default.items(items.length, key != null ? new LazyGridDslKt$itemsIndexed$7(key, items) : null, span != null ? new LazyGridDslKt$itemsIndexed$8(span, items) : null, new LazyGridDslKt$itemsIndexed$9(contentType, items), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new LazyGridDslKt$itemsIndexed$10(itemContent, items)));
    }

    public static final <T> void itemsIndexed(LazyGridScope $this$itemsIndexed, T[] items, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> contentType, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$itemsIndexed.items(items.length, function2 != null ? new LazyGridDslKt$itemsIndexed$7(function2, items) : null, function3 != null ? new LazyGridDslKt$itemsIndexed$8(function3, items) : null, new LazyGridDslKt$itemsIndexed$9(contentType, items), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new LazyGridDslKt$itemsIndexed$10(itemContent, items)));
    }
}
