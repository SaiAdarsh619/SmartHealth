package androidx.compose.p000ui.focus;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusOrderModifier.kt */
@Metadata(m286d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\t\u001a\u00020\n*\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0007\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0001H\u0007\u001a-\u0010\t\u001a\u00020\n*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00012\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, m287d2 = {"customFocusSearch", "Landroidx/compose/ui/focus/FocusRequester;", "Landroidx/compose/ui/focus/FocusModifier;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "customFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusModifier;ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/focus/FocusRequester;", "focusOrder", "Landroidx/compose/ui/Modifier;", "focusOrderReceiver", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusOrder;", "", "Lkotlin/ExtensionFunctionType;", "focusRequester", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class FocusOrderModifierKt {

    /* compiled from: FocusOrderModifier.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Deprecated(message = "Use focusProperties() instead", replaceWith = @ReplaceWith(expression = "this.focusProperties(focusOrderReceiver)", imports = {"androidx.compose.ui.focus.focusProperties"}))
    public static final Modifier focusOrder(Modifier $this$focusOrder, Function1<? super FocusOrder, Unit> focusOrderReceiver) {
        Intrinsics.checkNotNullParameter($this$focusOrder, "<this>");
        Intrinsics.checkNotNullParameter(focusOrderReceiver, "focusOrderReceiver");
        return FocusPropertiesKt.focusProperties($this$focusOrder, new FocusOrderToProperties(focusOrderReceiver));
    }

    @Deprecated(message = "Use focusRequester() instead", replaceWith = @ReplaceWith(expression = "this.focusRequester(focusRequester)", imports = {"androidx.compose.ui.focus.focusRequester"}))
    public static final Modifier focusOrder(Modifier $this$focusOrder, FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter($this$focusOrder, "<this>");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        return FocusRequesterModifierKt.focusRequester($this$focusOrder, focusRequester);
    }

    @Deprecated(message = "Use focusProperties() and focusRequester() instead", replaceWith = @ReplaceWith(expression = "this.focusRequester(focusRequester).focusProperties(focusOrderReceiver)", imports = {"androidx.compose.ui.focus.focusProperties, androidx.compose.ui.focus.focusRequester"}))
    public static final Modifier focusOrder(Modifier $this$focusOrder, FocusRequester focusRequester, Function1<? super FocusOrder, Unit> focusOrderReceiver) {
        Intrinsics.checkNotNullParameter($this$focusOrder, "<this>");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        Intrinsics.checkNotNullParameter(focusOrderReceiver, "focusOrderReceiver");
        return FocusPropertiesKt.focusProperties(FocusRequesterModifierKt.focusRequester($this$focusOrder, focusRequester), new FocusOrderToProperties(focusOrderReceiver));
    }

    /* renamed from: customFocusSearch--OM-vw8, reason: not valid java name */
    public static final FocusRequester m1705customFocusSearchOMvw8(FocusModifier customFocusSearch, int focusDirection, LayoutDirection layoutDirection) {
        FocusRequester end;
        FocusRequester start;
        Intrinsics.checkNotNullParameter(customFocusSearch, "$this$customFocusSearch");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (FocusDirection.m1685equalsimpl0(focusDirection, FocusDirection.INSTANCE.m1698getNextdhqQ8s())) {
            return customFocusSearch.getFocusProperties().getNext();
        }
        if (FocusDirection.m1685equalsimpl0(focusDirection, FocusDirection.INSTANCE.m1700getPreviousdhqQ8s())) {
            return customFocusSearch.getFocusProperties().getPrevious();
        }
        if (FocusDirection.m1685equalsimpl0(focusDirection, FocusDirection.INSTANCE.m1702getUpdhqQ8s())) {
            return customFocusSearch.getFocusProperties().getUp();
        }
        if (FocusDirection.m1685equalsimpl0(focusDirection, FocusDirection.INSTANCE.m1693getDowndhqQ8s())) {
            return customFocusSearch.getFocusProperties().getDown();
        }
        if (FocusDirection.m1685equalsimpl0(focusDirection, FocusDirection.INSTANCE.m1697getLeftdhqQ8s())) {
            switch (WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()]) {
                case 1:
                    start = customFocusSearch.getFocusProperties().getStart();
                    break;
                case 2:
                    start = customFocusSearch.getFocusProperties().getEnd();
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            FocusRequester it = start;
            if (Intrinsics.areEqual(it, FocusRequester.INSTANCE.getDefault())) {
                start = null;
            }
            if (start != null) {
                return start;
            }
            return customFocusSearch.getFocusProperties().getLeft();
        }
        if (FocusDirection.m1685equalsimpl0(focusDirection, FocusDirection.INSTANCE.m1701getRightdhqQ8s())) {
            switch (WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()]) {
                case 1:
                    end = customFocusSearch.getFocusProperties().getEnd();
                    break;
                case 2:
                    end = customFocusSearch.getFocusProperties().getStart();
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            FocusRequester it2 = end;
            if (Intrinsics.areEqual(it2, FocusRequester.INSTANCE.getDefault())) {
                end = null;
            }
            if (end != null) {
                return end;
            }
            return customFocusSearch.getFocusProperties().getRight();
        }
        if (FocusDirection.m1685equalsimpl0(focusDirection, FocusDirection.INSTANCE.m1694getEnterdhqQ8s())) {
            return customFocusSearch.getFocusProperties().getEnter().invoke(FocusDirection.m1682boximpl(focusDirection));
        }
        if (FocusDirection.m1685equalsimpl0(focusDirection, FocusDirection.INSTANCE.m1695getExitdhqQ8s())) {
            return customFocusSearch.getFocusProperties().getExit().invoke(FocusDirection.m1682boximpl(focusDirection));
        }
        throw new IllegalStateException("invalid FocusDirection".toString());
    }
}
