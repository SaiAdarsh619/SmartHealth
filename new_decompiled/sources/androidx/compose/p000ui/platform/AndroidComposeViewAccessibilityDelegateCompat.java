package androidx.compose.p000ui.platform;

import android.R;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.collection.ArraySet;
import androidx.collection.SparseArrayCompat;
import androidx.compose.p000ui.C0407R;
import androidx.compose.p000ui.TempListUtilsKt;
import androidx.compose.p000ui.focus.FocusManager;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.RectKt;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.graphics.RectHelper_androidKt;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.LayoutCoordinatesKt;
import androidx.compose.p000ui.node.DelegatableNodeKt;
import androidx.compose.p000ui.node.HitTestResult;
import androidx.compose.p000ui.node.LayoutNode;
import androidx.compose.p000ui.node.NodeCoordinator;
import androidx.compose.p000ui.node.Owner;
import androidx.compose.p000ui.node.SemanticsModifierNode;
import androidx.compose.p000ui.node.SemanticsModifierNodeKt;
import androidx.compose.p000ui.platform.AccessibilityIterators;
import androidx.compose.p000ui.platform.AndroidComposeView;
import androidx.compose.p000ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.p000ui.platform.accessibility.CollectionInfoKt;
import androidx.compose.p000ui.semantics.AccessibilityAction;
import androidx.compose.p000ui.semantics.CustomAccessibilityAction;
import androidx.compose.p000ui.semantics.LiveRegionMode;
import androidx.compose.p000ui.semantics.ProgressBarRangeInfo;
import androidx.compose.p000ui.semantics.Role;
import androidx.compose.p000ui.semantics.ScrollAxisRange;
import androidx.compose.p000ui.semantics.SemanticsActions;
import androidx.compose.p000ui.semantics.SemanticsConfiguration;
import androidx.compose.p000ui.semantics.SemanticsConfigurationKt;
import androidx.compose.p000ui.semantics.SemanticsNode;
import androidx.compose.p000ui.semantics.SemanticsNodeKt;
import androidx.compose.p000ui.semantics.SemanticsProperties;
import androidx.compose.p000ui.semantics.SemanticsPropertiesAndroid;
import androidx.compose.p000ui.semantics.SemanticsPropertyKey;
import androidx.compose.p000ui.state.ToggleableState;
import androidx.compose.p000ui.text.AnnotatedString;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.p000ui.text.TextRange;
import androidx.compose.p000ui.text.font.FontFamily;
import androidx.compose.p000ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.p000ui.unit.IntSizeKt;
import androidx.compose.p000ui.viewinterop.AndroidViewHolder;
import androidx.core.app.NotificationCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;

/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
@Metadata(m286d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 µ\u00012\u00020\u0001:\f³\u0001´\u0001µ\u0001¶\u0001·\u0001¸\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010B\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J\u0011\u0010J\u001a\u00020\u0014H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010KJ-\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020PH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJ;\u0010L\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180S2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020PH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\b\u0010V\u001a\u00020\u0014H\u0002J\u0010\u0010W\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u0006H\u0002J\u001d\u0010X\u001a\u00020Y2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0006H\u0001¢\u0006\u0002\b[J\u0012\u0010\\\u001a\u0004\u0018\u00010E2\u0006\u0010C\u001a\u00020\u0006H\u0002J=\u0010]\u001a\u00020Y2\u0006\u0010C\u001a\u00020\u00062\b\u0010^\u001a\u0004\u0018\u00010\u00062\b\u0010_\u001a\u0004\u0018\u00010\u00062\b\u0010`\u001a\u0004\u0018\u00010\u00062\b\u0010a\u001a\u0004\u0018\u00010GH\u0002¢\u0006\u0002\u0010bJ\u000e\u0010c\u001a\u00020\b2\u0006\u0010d\u001a\u00020eJ\u0010\u0010f\u001a\u00020'2\u0006\u0010g\u001a\u00020hH\u0016J\u0010\u0010i\u001a\u00020\u00062\u0006\u0010j\u001a\u00020kH\u0002J\u0010\u0010l\u001a\u00020\u00062\u0006\u0010j\u001a\u00020kH\u0002J\u0014\u0010m\u001a\u0004\u0018\u00010G2\b\u0010j\u001a\u0004\u0018\u00010kH\u0002J\u001c\u0010n\u001a\u0004\u0018\u00010o2\b\u0010j\u001a\u0004\u0018\u00010k2\u0006\u0010p\u001a\u00020\u0006H\u0002J\u001d\u0010q\u001a\u00020\u00062\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020sH\u0001¢\u0006\u0002\buJ\u0010\u0010v\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u0006H\u0002J\u0010\u0010w\u001a\u00020\b2\u0006\u0010j\u001a\u00020kH\u0002J\u0010\u0010x\u001a\u00020\u00142\u0006\u0010y\u001a\u00020?H\u0002J\u0015\u0010z\u001a\u00020\u00142\u0006\u0010y\u001a\u00020?H\u0000¢\u0006\u0002\b{J\r\u0010|\u001a\u00020\u0014H\u0000¢\u0006\u0002\b}J\"\u0010~\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020\u00062\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J#\u0010\u0080\u0001\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u00062\u0007\u0010D\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020kH\u0007J\"\u0010\u0083\u0001\u001a\u00020\b2\u0007\u0010\u0084\u0001\u001a\u00020\u00062\u000e\u0010\u0085\u0001\u001a\t\u0012\u0004\u0012\u0002090\u0086\u0001H\u0002J\u0011\u0010\u0087\u0001\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u0006H\u0002J\u0012\u0010\u0088\u0001\u001a\u00020\u00062\u0007\u0010\u0084\u0001\u001a\u00020\u0006H\u0002J\u0011\u0010\u0089\u0001\u001a\u00020\b2\u0006\u0010d\u001a\u00020YH\u0002J@\u0010\u008a\u0001\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u00062\u000b\b\u0002\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\u008c\u0001\u001a\u000b\u0012\u0004\u0012\u00020G\u0018\u00010\u0086\u0001H\u0002¢\u0006\u0003\u0010\u008d\u0001J&\u0010\u008e\u0001\u001a\u00020\u00142\u0007\u0010\u008f\u0001\u001a\u00020\u00062\u0007\u0010\u008b\u0001\u001a\u00020\u00062\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010GH\u0002J\u0012\u0010\u0091\u0001\u001a\u00020\u00142\u0007\u0010\u008f\u0001\u001a\u00020\u0006H\u0002J\u0012\u0010\u0092\u0001\u001a\u00020\u00142\u0007\u0010\u0093\u0001\u001a\u000209H\u0002J$\u0010\u0094\u0001\u001a\u00020\u00142\u0013\u0010\u0095\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00180\u0017H\u0001¢\u0006\u0003\b\u0096\u0001J\u001b\u0010\u0097\u0001\u001a\u00020\u00142\u0007\u0010\u0098\u0001\u001a\u00020k2\u0007\u0010\u0099\u0001\u001a\u00020.H\u0002J \u0010\u009a\u0001\u001a\u00020\u00142\u0006\u0010y\u001a\u00020?2\r\u0010\u009b\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060)H\u0002J,\u0010\u009c\u0001\u001a\u00020\b2\u0006\u0010j\u001a\u00020k2\u0007\u0010\u009d\u0001\u001a\u00020\u00062\u0007\u0010\u009e\u0001\u001a\u00020\u00062\u0007\u0010\u009f\u0001\u001a\u00020\bH\u0002J\u001a\u0010 \u0001\u001a\u00020\u00142\u0006\u0010j\u001a\u00020k2\u0007\u0010D\u001a\u00030\u0081\u0001H\u0002J\u001a\u0010¡\u0001\u001a\u00020\u00142\u0006\u0010j\u001a\u00020k2\u0007\u0010D\u001a\u00030\u0081\u0001H\u0002J!\u0010¢\u0001\u001a\u0005\u0018\u00010£\u00012\t\u0010¤\u0001\u001a\u0004\u0018\u00010k2\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0002J+\u0010§\u0001\u001a\u00020\b2\u0006\u0010j\u001a\u00020k2\u0006\u0010p\u001a\u00020\u00062\u0007\u0010¨\u0001\u001a\u00020\b2\u0007\u0010©\u0001\u001a\u00020\bH\u0002J3\u0010ª\u0001\u001a\u0005\u0018\u0001H«\u0001\"\t\b\u0000\u0010«\u0001*\u00020\u00112\t\u0010a\u001a\u0005\u0018\u0001H«\u00012\t\b\u0001\u0010¬\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0011\u0010®\u0001\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u0006H\u0002J\t\u0010¯\u0001\u001a\u00020\u0014H\u0002J\u0011\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001*\u00030²\u0001H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00180\u00178BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\nR \u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u00170\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020.0-8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b/\u00100\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u00103R\u000e\u00104\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00105\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u00106R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020908X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00140=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020?0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010A\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006¹\u0001"}, m287d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/core/view/AccessibilityDelegateCompat;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "accessibilityCursorPosition", "", "accessibilityForceEnabledForTesting", "", "getAccessibilityForceEnabledForTesting$ui_release", "()Z", "setAccessibilityForceEnabledForTesting$ui_release", "(Z)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "actionIdToLabel", "Landroidx/collection/SparseArrayCompat;", "", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "checkingForSemanticsChanges", "currentSemanticsNodes", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes", "()Ljava/util/Map;", "currentSemanticsNodesInvalidated", "focusedVirtualViewId", "handler", "Landroid/os/Handler;", "hoveredVirtualViewId", "getHoveredVirtualViewId$ui_release", "()I", "setHoveredVirtualViewId$ui_release", "(I)V", "isAccessibilityEnabled", "labelToActionId", "nodeProvider", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "paneDisplayed", "Landroidx/collection/ArraySet;", "pendingTextTraversedEvent", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "previousSemanticsNodes", "", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "getPreviousSemanticsNodes$ui_release$annotations", "()V", "getPreviousSemanticsNodes$ui_release", "setPreviousSemanticsNodes$ui_release", "(Ljava/util/Map;)V", "previousSemanticsRoot", "previousTraversedNode", "Ljava/lang/Integer;", "scrollObservationScopes", "", "Landroidx/compose/ui/platform/ScrollObservationScope;", "semanticsChangeChecker", "Ljava/lang/Runnable;", "sendScrollEventIfNeededLambda", "Lkotlin/Function1;", "subtreeChangedLayoutNodes", "Landroidx/compose/ui/node/LayoutNode;", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "arguments", "Landroid/os/Bundle;", "boundsUpdatesEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canScroll", "vertical", "direction", "position", "Landroidx/compose/ui/geometry/Offset;", "canScroll-0AR0LA0$ui_release", "(ZIJ)Z", "", "canScroll-moWRBKg$ui_release", "(Ljava/util/Collection;ZIJ)Z", "checkForSemanticsChanges", "clearAccessibilityFocus", "createEvent", "Landroid/view/accessibility/AccessibilityEvent;", "eventType", "createEvent$ui_release", "createNodeInfo", "createTextSelectionChangedEvent", "fromIndex", "toIndex", "itemCount", "text", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Landroid/view/accessibility/AccessibilityEvent;", "dispatchHoverEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "getAccessibilityNodeProvider", "host", "Landroid/view/View;", "getAccessibilitySelectionEnd", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "getAccessibilitySelectionStart", "getIterableTextForAccessibility", "getIteratorForGranularity", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "granularity", "hitTestSemanticsAt", "x", "", "y", "hitTestSemanticsAt$ui_release", "isAccessibilityFocused", "isAccessibilitySelectionExtendable", "notifySubtreeAccessibilityStateChangedIfNeeded", "layoutNode", "onLayoutChange", "onLayoutChange$ui_release", "onSemanticsChange", "onSemanticsChange$ui_release", "performActionHelper", "action", "populateAccessibilityNodeInfoProperties", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "registerScrollingId", "id", "oldScrollObservationScopes", "", "requestAccessibilityFocus", "semanticsNodeIdToAccessibilityVirtualNodeId", "sendEvent", "sendEventForVirtualView", "contentChangeType", "contentDescription", "(IILjava/lang/Integer;Ljava/util/List;)Z", "sendPaneChangeEvents", "semanticsNodeId", "title", "sendPendingTextTraversedAtGranularityEvent", "sendScrollEventIfNeeded", "scrollObservationScope", "sendSemanticsPropertyChangeEvents", "newSemanticsNodes", "sendSemanticsPropertyChangeEvents$ui_release", "sendSemanticsStructureChangeEvents", "newNode", "oldNode", "sendSubtreeChangeAccessibilityEvents", "subtreeChangedSemanticsNodesIds", "setAccessibilitySelection", "start", "end", "traversalMode", "setContentInvalid", "setText", "toScreenCoords", "Landroid/graphics/RectF;", "textNode", "bounds", "Landroidx/compose/ui/geometry/Rect;", "traverseAtGranularity", "forward", "extendSelection", "trimToSize", "T", "size", "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "updateHoveredVirtualView", "updateSemanticsNodesCopyAndPanes", "getTextForTextField", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "Api24Impl", "Api28Impl", "Companion", "MyNodeProvider", "PendingTextTraversedEvent", "SemanticsNodeCopy", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    public static final int AccessibilityCursorPositionUndefined = -1;
    public static final int AccessibilitySliderStepsCount = 20;
    public static final String ClassName = "android.view.View";
    public static final String ExtraDataTestTagKey = "androidx.compose.ui.semantics.testTag";
    public static final int InvalidId = Integer.MIN_VALUE;
    public static final String LogTag = "AccessibilityDelegate";
    public static final int ParcelSafeTextLength = 100000;
    public static final long SendRecurringAccessibilityEventsIntervalMillis = 100;
    public static final long TextTraversedEventTimeoutMillis = 1000;
    private int accessibilityCursorPosition;
    private boolean accessibilityForceEnabledForTesting;
    private final AccessibilityManager accessibilityManager;
    private SparseArrayCompat<SparseArrayCompat<CharSequence>> actionIdToLabel;
    private final Channel<Unit> boundsUpdateChannel;
    private boolean checkingForSemanticsChanges;
    private Map<Integer, SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    private int focusedVirtualViewId;
    private final Handler handler;
    private int hoveredVirtualViewId;
    private SparseArrayCompat<Map<CharSequence, Integer>> labelToActionId;
    private AccessibilityNodeProviderCompat nodeProvider;
    private ArraySet<Integer> paneDisplayed;
    private PendingTextTraversedEvent pendingTextTraversedEvent;
    private Map<Integer, SemanticsNodeCopy> previousSemanticsNodes;
    private SemanticsNodeCopy previousSemanticsRoot;
    private Integer previousTraversedNode;
    private final List<ScrollObservationScope> scrollObservationScopes;
    private final Runnable semanticsChangeChecker;
    private final Function1<ScrollObservationScope, Unit> sendScrollEventIfNeededLambda;
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    private final AndroidComposeView view;
    private static final int[] AccessibilityActionsResourceIds = {C0407R.id.accessibility_custom_action_0, C0407R.id.accessibility_custom_action_1, C0407R.id.accessibility_custom_action_2, C0407R.id.accessibility_custom_action_3, C0407R.id.accessibility_custom_action_4, C0407R.id.accessibility_custom_action_5, C0407R.id.accessibility_custom_action_6, C0407R.id.accessibility_custom_action_7, C0407R.id.accessibility_custom_action_8, C0407R.id.accessibility_custom_action_9, C0407R.id.accessibility_custom_action_10, C0407R.id.accessibility_custom_action_11, C0407R.id.accessibility_custom_action_12, C0407R.id.accessibility_custom_action_13, C0407R.id.accessibility_custom_action_14, C0407R.id.accessibility_custom_action_15, C0407R.id.accessibility_custom_action_16, C0407R.id.accessibility_custom_action_17, C0407R.id.accessibility_custom_action_18, C0407R.id.accessibility_custom_action_19, C0407R.id.accessibility_custom_action_20, C0407R.id.accessibility_custom_action_21, C0407R.id.accessibility_custom_action_22, C0407R.id.accessibility_custom_action_23, C0407R.id.accessibility_custom_action_24, C0407R.id.accessibility_custom_action_25, C0407R.id.accessibility_custom_action_26, C0407R.id.accessibility_custom_action_27, C0407R.id.accessibility_custom_action_28, C0407R.id.accessibility_custom_action_29, C0407R.id.accessibility_custom_action_30, C0407R.id.accessibility_custom_action_31};

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            iArr[ToggleableState.On.ordinal()] = 1;
            iArr[ToggleableState.Off.ordinal()] = 2;
            iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getPreviousSemanticsNodes$ui_release$annotations() {
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.hoveredVirtualViewId = Integer.MIN_VALUE;
        Object systemService = this.view.getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.accessibilityManager = (AccessibilityManager) systemService;
        this.handler = new Handler(Looper.getMainLooper());
        this.nodeProvider = new AccessibilityNodeProviderCompat(new MyNodeProvider());
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.actionIdToLabel = new SparseArrayCompat<>();
        this.labelToActionId = new SparseArrayCompat<>();
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet<>();
        this.boundsUpdateChannel = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.currentSemanticsNodesInvalidated = true;
        this.currentSemanticsNodes = MapsKt.emptyMap();
        this.paneDisplayed = new ArraySet<>();
        this.previousSemanticsNodes = new LinkedHashMap();
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), MapsKt.emptyMap());
        this.view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                Intrinsics.checkNotNullParameter(view2, "view");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                Intrinsics.checkNotNullParameter(view2, "view");
                AndroidComposeViewAccessibilityDelegateCompat.this.handler.removeCallbacks(AndroidComposeViewAccessibilityDelegateCompat.this.semanticsChangeChecker);
            }
        });
        this.semanticsChangeChecker = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeViewAccessibilityDelegateCompat.m3754semanticsChangeChecker$lambda26(AndroidComposeViewAccessibilityDelegateCompat.this);
            }
        };
        this.scrollObservationScopes = new ArrayList();
        this.sendScrollEventIfNeededLambda = new Function1<ScrollObservationScope, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeededLambda$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScrollObservationScope scrollObservationScope) {
                invoke2(scrollObservationScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ScrollObservationScope it) {
                Intrinsics.checkNotNullParameter(it, "it");
                AndroidComposeViewAccessibilityDelegateCompat.this.sendScrollEventIfNeeded(it);
            }
        };
    }

    /* renamed from: getHoveredVirtualViewId$ui_release, reason: from getter */
    public final int getHoveredVirtualViewId() {
        return this.hoveredVirtualViewId;
    }

    public final void setHoveredVirtualViewId$ui_release(int i) {
        this.hoveredVirtualViewId = i;
    }

    /* renamed from: getAccessibilityForceEnabledForTesting$ui_release, reason: from getter */
    public final boolean getAccessibilityForceEnabledForTesting() {
        return this.accessibilityForceEnabledForTesting;
    }

    public final void setAccessibilityForceEnabledForTesting$ui_release(boolean z) {
        this.accessibilityForceEnabledForTesting = z;
    }

    private final boolean isAccessibilityEnabled() {
        return this.accessibilityForceEnabledForTesting || (this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled());
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(m286d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m287d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "action", "", "granularity", "fromIndex", "toIndex", "traverseTime", "", "(Landroidx/compose/ui/semantics/SemanticsNode;IIIIJ)V", "getAction", "()I", "getFromIndex", "getGranularity", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getToIndex", "getTraverseTime", "()J", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    private static final class PendingTextTraversedEvent {
        private final int action;
        private final int fromIndex;
        private final int granularity;
        private final SemanticsNode node;
        private final int toIndex;
        private final long traverseTime;

        public PendingTextTraversedEvent(SemanticsNode node, int action, int granularity, int fromIndex, int toIndex, long traverseTime) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.node = node;
            this.action = action;
            this.granularity = granularity;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
            this.traverseTime = traverseTime;
        }

        public final SemanticsNode getNode() {
            return this.node;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getGranularity() {
            return this.granularity;
        }

        public final int getFromIndex() {
            return this.fromIndex;
        }

        public final int getToIndex() {
            return this.toIndex;
        }

        public final long getTraverseTime() {
            return this.traverseTime;
        }
    }

    private final Map<Integer, SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodes = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getAllUncoveredSemanticsNodesToMap(this.view.getSemanticsOwner());
            this.currentSemanticsNodesInvalidated = false;
        }
        return this.currentSemanticsNodes;
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(m286d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, m287d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "currentSemanticsNodes", "", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "(Landroidx/compose/ui/semantics/SemanticsNode;Ljava/util/Map;)V", "children", "", "getChildren", "()Ljava/util/Set;", "unmergedConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getUnmergedConfig", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "hasPaneTitle", "", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public static final class SemanticsNodeCopy {
        private final Set<Integer> children;
        private final SemanticsConfiguration unmergedConfig;

        public SemanticsNodeCopy(SemanticsNode semanticsNode, Map<Integer, SemanticsNodeWithAdjustedBounds> currentSemanticsNodes) {
            Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
            Intrinsics.checkNotNullParameter(currentSemanticsNodes, "currentSemanticsNodes");
            this.unmergedConfig = semanticsNode.getUnmergedConfig();
            this.children = new LinkedHashSet();
            List $this$fastForEach$iv = semanticsNode.getReplacedChildren$ui_release();
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                SemanticsNode child = (SemanticsNode) item$iv;
                if (currentSemanticsNodes.containsKey(Integer.valueOf(child.getId()))) {
                    this.children.add(Integer.valueOf(child.getId()));
                }
            }
        }

        public final SemanticsConfiguration getUnmergedConfig() {
            return this.unmergedConfig;
        }

        public final Set<Integer> getChildren() {
            return this.children;
        }

        public final boolean hasPaneTitle() {
            return this.unmergedConfig.contains(SemanticsProperties.INSTANCE.getPaneTitle());
        }
    }

    public final Map<Integer, SemanticsNodeCopy> getPreviousSemanticsNodes$ui_release() {
        return this.previousSemanticsNodes;
    }

    public final void setPreviousSemanticsNodes$ui_release(Map<Integer, SemanticsNodeCopy> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.previousSemanticsNodes = map;
    }

    /* renamed from: canScroll-0AR0LA0$ui_release, reason: not valid java name */
    public final boolean m3755canScroll0AR0LA0$ui_release(boolean vertical, int direction, long position) {
        return m3756canScrollmoWRBKg$ui_release(getCurrentSemanticsNodes().values(), vertical, direction, position);
    }

    /* renamed from: canScroll-moWRBKg$ui_release, reason: not valid java name */
    public final boolean m3756canScrollmoWRBKg$ui_release(Collection<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes, boolean vertical, int direction, long position) {
        SemanticsPropertyKey scrollRangeProperty;
        boolean z;
        Intrinsics.checkNotNullParameter(currentSemanticsNodes, "currentSemanticsNodes");
        if (Offset.m1757equalsimpl0(position, Offset.INSTANCE.m1775getUnspecifiedF1C5BW0()) || !Offset.m1763isValidimpl(position)) {
            return false;
        }
        if (vertical) {
            scrollRangeProperty = SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
        } else {
            if (vertical) {
                throw new NoWhenBranchMatchedException();
            }
            scrollRangeProperty = SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
        }
        Collection<SemanticsNodeWithAdjustedBounds> $this$any$iv = currentSemanticsNodes;
        if ($this$any$iv.isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            SemanticsNodeWithAdjustedBounds node = (SemanticsNodeWithAdjustedBounds) element$iv;
            if (!RectHelper_androidKt.toComposeRect(node.getAdjustedBounds()).m1786containsk4lQ0M(position)) {
                z = false;
            } else {
                ScrollAxisRange scrollRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(node.getSemanticsNode().getConfig(), scrollRangeProperty);
                if (scrollRange == null) {
                    z = false;
                } else {
                    int actualDirection = scrollRange.getReverseScrolling() ? -direction : direction;
                    if (direction == 0 && scrollRange.getReverseScrolling()) {
                        actualDirection = -1;
                    }
                    z = actualDirection < 0 ? scrollRange.getValue().invoke().floatValue() > 0.0f : scrollRange.getValue().invoke().floatValue() < scrollRange.getMaxValue().invoke().floatValue();
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AccessibilityNodeInfo createNodeInfo(int virtualViewId) {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        AndroidComposeView.ViewTreeOwners viewTreeOwners = this.view.getViewTreeOwners();
        if (((viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? null : lifecycle.getCurrentState()) == Lifecycle.State.DESTROYED) {
            return null;
        }
        AccessibilityNodeInfoCompat info = AccessibilityNodeInfoCompat.obtain();
        Intrinsics.checkNotNullExpressionValue(info, "obtain()");
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(Integer.valueOf(virtualViewId));
        if (semanticsNodeWithAdjustedBounds == null) {
            info.recycle();
            return null;
        }
        SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode();
        if (virtualViewId == -1) {
            Object parentForAccessibility = ViewCompat.getParentForAccessibility(this.view);
            info.setParent(parentForAccessibility instanceof View ? (View) parentForAccessibility : null);
        } else if (semanticsNode.getParent() != null) {
            SemanticsNode parent = semanticsNode.getParent();
            Intrinsics.checkNotNull(parent);
            int parentId = parent.getId();
            if (parentId == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
                parentId = -1;
            }
            info.setParent(this.view, parentId);
        } else {
            throw new IllegalStateException("semanticsNode " + virtualViewId + " has null parent");
        }
        info.setSource(this.view, virtualViewId);
        Rect boundsInRoot = semanticsNodeWithAdjustedBounds.getAdjustedBounds();
        long topLeftInScreen = this.view.mo3444localToScreenMKHz9U(OffsetKt.Offset(boundsInRoot.left, boundsInRoot.top));
        long bottomRightInScreen = this.view.mo3444localToScreenMKHz9U(OffsetKt.Offset(boundsInRoot.right, boundsInRoot.bottom));
        info.setBoundsInScreen(new Rect((int) Math.floor(Offset.m1760getXimpl(topLeftInScreen)), (int) Math.floor(Offset.m1761getYimpl(topLeftInScreen)), (int) Math.ceil(Offset.m1760getXimpl(bottomRightInScreen)), (int) Math.ceil(Offset.m1761getYimpl(bottomRightInScreen))));
        populateAccessibilityNodeInfoProperties(virtualViewId, info, semanticsNode);
        return info.unwrap();
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x05a1  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0673  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0696  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0858  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0873  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x087d  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x092e  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0b90  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0821  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0285  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void populateAccessibilityNodeInfoProperties(int virtualViewId, AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
        boolean isUnmergedLeafNode;
        Role role;
        boolean isTextField;
        int index$iv;
        int size;
        ToggleableState toggleState;
        Boolean bool;
        String testTag;
        boolean isPassword;
        boolean isTextField2;
        boolean enabled;
        NodeCoordinator wrapperToCheckTransparency;
        LiveRegionMode liveRegionMode;
        AccessibilityAction it;
        AccessibilityAction it2;
        AccessibilityAction it3;
        boolean enabled2;
        String str;
        List extraDataKeys;
        CharSequence text;
        ProgressBarRangeInfo rangeInfo;
        ScrollAxisRange xScrollState;
        ScrollAxisRange yScrollState;
        boolean enabled3;
        ProgressBarRangeInfo rangeInfo2;
        AccessibilityAction scrollAction;
        boolean enabled4;
        boolean enabled5;
        boolean isRtl;
        boolean isRtl2;
        boolean enabled6;
        boolean excludeLineAndPageGranularities;
        boolean enabled7;
        boolean enabled8;
        LayoutNode findClosestParentNode;
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
        if (!semanticsNode.getIsFake() && semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
            findClosestParentNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(semanticsNode.getLayoutNode(), new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$populateAccessibilityNodeInfoProperties$isUnmergedLeafNode$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(LayoutNode it4) {
                    SemanticsConfiguration collapsedSemanticsConfiguration;
                    Intrinsics.checkNotNullParameter(it4, "it");
                    SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(it4);
                    boolean z = false;
                    if (outerSemantics != null && (collapsedSemanticsConfiguration = SemanticsModifierNodeKt.collapsedSemanticsConfiguration(outerSemantics)) != null && collapsedSemanticsConfiguration.getIsMergingSemanticsOfDescendants()) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            });
            if (findClosestParentNode == null) {
                isUnmergedLeafNode = true;
                info.setClassName(ClassName);
                role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
                if (role != null) {
                    int it4 = role.getValue();
                    if (semanticsNode.getIsFake() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
                        if (Role.m3828equalsimpl0(role.getValue(), Role.INSTANCE.m3837getTabo7Vup1c())) {
                            info.setRoleDescription(this.view.getContext().getResources().getString(C0407R.string.tab));
                        } else {
                            String className = Role.m3828equalsimpl0(it4, Role.INSTANCE.m3832getButtono7Vup1c()) ? "android.widget.Button" : Role.m3828equalsimpl0(it4, Role.INSTANCE.m3833getCheckboxo7Vup1c()) ? "android.widget.CheckBox" : Role.m3828equalsimpl0(it4, Role.INSTANCE.m3836getSwitcho7Vup1c()) ? "android.widget.Switch" : Role.m3828equalsimpl0(it4, Role.INSTANCE.m3835getRadioButtono7Vup1c()) ? "android.widget.RadioButton" : Role.m3828equalsimpl0(it4, Role.INSTANCE.m3834getImageo7Vup1c()) ? "android.widget.ImageView" : null;
                            if (!Role.m3828equalsimpl0(role.getValue(), Role.INSTANCE.m3834getImageo7Vup1c()) || isUnmergedLeafNode || semanticsNode.getUnmergedConfig().getIsMergingSemanticsOfDescendants()) {
                                info.setClassName(className);
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
                isTextField = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode);
                if (isTextField) {
                    info.setClassName("android.widget.EditText");
                }
                if (semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getText())) {
                    info.setClassName("android.widget.TextView");
                }
                info.setPackageName(this.view.getContext().getPackageName());
                info.setImportantForAccessibility(true);
                List $this$fastForEach$iv = semanticsNode.getReplacedChildrenSortedByBounds$ui_release();
                size = $this$fastForEach$iv.size();
                for (index$iv = 0; index$iv < size; index$iv++) {
                    Object item$iv = $this$fastForEach$iv.get(index$iv);
                    SemanticsNode child = (SemanticsNode) item$iv;
                    if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(child.getId()))) {
                        AndroidViewHolder holder = this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(child.getLayoutNode());
                        if (holder != null) {
                            info.addChild(holder);
                        } else {
                            info.addChild(this.view, child.getId());
                        }
                    }
                }
                if (this.focusedVirtualViewId != virtualViewId) {
                    info.setAccessibilityFocused(true);
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                } else {
                    info.setAccessibilityFocused(false);
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
                }
                setText(semanticsNode, info);
                setContentInvalid(semanticsNode, info);
                info.setStateDescription((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getStateDescription()));
                toggleState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getToggleableState());
                if (toggleState != null) {
                    info.setCheckable(true);
                    switch (WhenMappings.$EnumSwitchMapping$0[toggleState.ordinal()]) {
                        case 1:
                            info.setChecked(true);
                            if ((role == null ? false : Role.m3828equalsimpl0(role.getValue(), Role.INSTANCE.m3836getSwitcho7Vup1c())) && info.getStateDescription() == null) {
                                info.setStateDescription(this.view.getContext().getResources().getString(C0407R.string.f49on));
                                break;
                            }
                            break;
                        case 2:
                            info.setChecked(false);
                            if ((role == null ? false : Role.m3828equalsimpl0(role.getValue(), Role.INSTANCE.m3836getSwitcho7Vup1c())) && info.getStateDescription() == null) {
                                info.setStateDescription(this.view.getContext().getResources().getString(C0407R.string.off));
                                break;
                            }
                            break;
                        case 3:
                            if (info.getStateDescription() == null) {
                                info.setStateDescription(this.view.getContext().getResources().getString(C0407R.string.indeterminate));
                                break;
                            }
                            break;
                    }
                    Unit unit3 = Unit.INSTANCE;
                    Unit unit4 = Unit.INSTANCE;
                }
                bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected());
                if (bool != null) {
                    boolean it5 = bool.booleanValue();
                    if (role == null ? false : Role.m3828equalsimpl0(role.getValue(), Role.INSTANCE.m3837getTabo7Vup1c())) {
                        info.setSelected(it5);
                    } else {
                        info.setCheckable(true);
                        info.setChecked(it5);
                        if (info.getStateDescription() == null) {
                            info.setStateDescription(it5 ? this.view.getContext().getResources().getString(C0407R.string.selected) : this.view.getContext().getResources().getString(C0407R.string.not_selected));
                        }
                    }
                    Unit unit5 = Unit.INSTANCE;
                    Unit unit6 = Unit.INSTANCE;
                }
                if (semanticsNode.getUnmergedConfig().getIsMergingSemanticsOfDescendants() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
                    List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getContentDescription());
                    info.setContentDescription(list == null ? (String) CollectionsKt.firstOrNull(list) : null);
                }
                testTag = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getTestTag());
                if (testTag != null) {
                    boolean testTagsAsResourceId = false;
                    SemanticsNode current = semanticsNode;
                    while (true) {
                        if (current != null) {
                            if (current.getUnmergedConfig().contains(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())) {
                                testTagsAsResourceId = ((Boolean) current.getUnmergedConfig().get(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())).booleanValue();
                            } else {
                                current = current.getParent();
                            }
                        }
                    }
                    if (testTagsAsResourceId) {
                        info.setViewIdResourceName(testTag);
                    }
                }
                if (((Unit) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHeading())) != null) {
                    info.setHeading(true);
                    Unit it6 = Unit.INSTANCE;
                    Unit unit7 = Unit.INSTANCE;
                }
                isPassword = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(semanticsNode);
                info.setPassword(isPassword);
                isTextField2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode);
                info.setEditable(isTextField2);
                enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
                info.setEnabled(enabled);
                info.setFocusable(semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getFocused()));
                int i = 2;
                if (info.isFocusable()) {
                    info.setFocused(((Boolean) semanticsNode.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getFocused())).booleanValue());
                    if (info.isFocused()) {
                        info.addAction(2);
                    } else {
                        info.addAction(1);
                    }
                }
                if (semanticsNode.getIsFake()) {
                    wrapperToCheckTransparency = semanticsNode.findCoordinatorToGetBounds$ui_release();
                } else {
                    SemanticsNode parent = semanticsNode.getParent();
                    wrapperToCheckTransparency = parent != null ? parent.findCoordinatorToGetBounds$ui_release() : null;
                }
                boolean isTransparent = wrapperToCheckTransparency == null ? wrapperToCheckTransparency.isTransparent() : false;
                info.setVisibleToUser(isTransparent && SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getInvisibleToUser()) == null);
                liveRegionMode = (LiveRegionMode) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getLiveRegion());
                if (liveRegionMode != null) {
                    int it7 = liveRegionMode.getValue();
                    if (LiveRegionMode.m3819equalsimpl0(it7, LiveRegionMode.INSTANCE.m3824getPolite0phEisY())) {
                        i = 1;
                    } else if (!LiveRegionMode.m3819equalsimpl0(it7, LiveRegionMode.INSTANCE.m3823getAssertive0phEisY())) {
                        i = 1;
                    }
                    info.setLiveRegion(i);
                    Unit unit8 = Unit.INSTANCE;
                    Unit unit9 = Unit.INSTANCE;
                }
                info.setClickable(false);
                it = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnClick());
                if (it != null) {
                    boolean isSelected = Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected()), (Object) true);
                    info.setClickable(!isSelected);
                    enabled8 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
                    if (enabled8 && !isSelected) {
                        info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, it.getLabel()));
                    }
                    Unit unit10 = Unit.INSTANCE;
                    Unit unit11 = Unit.INSTANCE;
                }
                info.setLongClickable(false);
                it2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnLongClick());
                if (it2 != null) {
                    info.setLongClickable(true);
                    enabled7 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
                    if (enabled7) {
                        info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, it2.getLabel()));
                    }
                    Unit unit12 = Unit.INSTANCE;
                    Unit unit13 = Unit.INSTANCE;
                }
                it3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCopyText());
                if (it3 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, it3.getLabel()));
                    Unit unit14 = Unit.INSTANCE;
                    Unit unit15 = Unit.INSTANCE;
                }
                enabled2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
                if (enabled2) {
                    AccessibilityAction it8 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetText());
                    if (it8 != null) {
                        info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, it8.getLabel()));
                        Unit unit16 = Unit.INSTANCE;
                        Unit unit17 = Unit.INSTANCE;
                    }
                    AccessibilityAction it9 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCutText());
                    if (it9 != null) {
                        info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, it9.getLabel()));
                        Unit unit18 = Unit.INSTANCE;
                        Unit unit19 = Unit.INSTANCE;
                    }
                    AccessibilityAction it10 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPasteText());
                    if (it10 != null) {
                        if (info.isFocused() && this.view.getClipboardManager().hasText()) {
                            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, it10.getLabel()));
                        }
                        Unit unit20 = Unit.INSTANCE;
                        Unit unit21 = Unit.INSTANCE;
                    }
                }
                String text2 = getIterableTextForAccessibility(semanticsNode);
                str = text2;
                if (!(str != null || str.length() == 0)) {
                    info.setTextSelection(getAccessibilitySelectionStart(semanticsNode), getAccessibilitySelectionEnd(semanticsNode));
                    AccessibilityAction setSelectionAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetSelection());
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, setSelectionAction != null ? setSelectionAction.getLabel() : null));
                    info.addAction(256);
                    info.addAction(512);
                    info.setMovementGranularities(11);
                    List contentDescription = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getContentDescription());
                    List list2 = contentDescription;
                    if ((list2 == null || list2.isEmpty()) && semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                        excludeLineAndPageGranularities = AndroidComposeViewAccessibilityDelegateCompat_androidKt.excludeLineAndPageGranularities(semanticsNode);
                        if (!excludeLineAndPageGranularities) {
                            info.setMovementGranularities(16 | info.getMovementGranularities() | 4);
                        }
                    }
                }
                extraDataKeys = new ArrayList();
                text = info.getText();
                if (!(text != null || text.length() == 0) && semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                    extraDataKeys.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
                }
                if (semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTestTag())) {
                    extraDataKeys.add(ExtraDataTestTagKey);
                }
                if (!extraDataKeys.isEmpty()) {
                    AccessibilityNodeInfoVerificationHelperMethods accessibilityNodeInfoVerificationHelperMethods = AccessibilityNodeInfoVerificationHelperMethods.INSTANCE;
                    AccessibilityNodeInfo unwrap = info.unwrap();
                    Intrinsics.checkNotNullExpressionValue(unwrap, "info.unwrap()");
                    accessibilityNodeInfoVerificationHelperMethods.setAvailableExtraData(unwrap, extraDataKeys);
                }
                rangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
                if (rangeInfo != null) {
                    if (semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetProgress())) {
                        info.setClassName("android.widget.SeekBar");
                    } else {
                        info.setClassName("android.widget.ProgressBar");
                    }
                    if (rangeInfo != ProgressBarRangeInfo.INSTANCE.getIndeterminate()) {
                        info.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, rangeInfo.getRange().getStart().floatValue(), rangeInfo.getRange().getEndInclusive().floatValue(), rangeInfo.getCurrent()));
                        if (info.getStateDescription() == null) {
                            ClosedFloatingPointRange valueRange = rangeInfo.getRange();
                            float progress = RangesKt.coerceIn(((valueRange.getEndInclusive().floatValue() - valueRange.getStart().floatValue()) > 0.0f ? 1 : ((valueRange.getEndInclusive().floatValue() - valueRange.getStart().floatValue()) == 0.0f ? 0 : -1)) == 0 ? 0.0f : (rangeInfo.getCurrent() - valueRange.getStart().floatValue()) / (valueRange.getEndInclusive().floatValue() - valueRange.getStart().floatValue()), 0.0f, 1.0f);
                            int percent = progress == 0.0f ? 0 : (progress > 1.0f ? 1 : (progress == 1.0f ? 0 : -1)) == 0 ? 100 : RangesKt.coerceIn(MathKt.roundToInt(100 * progress), 1, 99);
                            info.setStateDescription(this.view.getContext().getResources().getString(C0407R.string.template_percent, Integer.valueOf(percent)));
                        }
                    } else if (info.getStateDescription() == null) {
                        info.setStateDescription(this.view.getContext().getResources().getString(C0407R.string.in_progress));
                    }
                    if (semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetProgress())) {
                        enabled6 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
                        if (enabled6) {
                            if (rangeInfo.getCurrent() < RangesKt.coerceAtLeast(rangeInfo.getRange().getEndInclusive().floatValue(), rangeInfo.getRange().getStart().floatValue())) {
                                info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                            }
                            if (rangeInfo.getCurrent() > RangesKt.coerceAtMost(rangeInfo.getRange().getStart().floatValue(), rangeInfo.getRange().getEndInclusive().floatValue())) {
                                info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                            }
                        }
                    }
                }
                Api24Impl.addSetProgressAction(info, semanticsNode);
                CollectionInfoKt.setCollectionInfo(semanticsNode, info);
                CollectionInfoKt.setCollectionItemInfo(semanticsNode, info);
                xScrollState = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
                AccessibilityAction scrollAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getScrollBy());
                if (xScrollState != null && scrollAction2 != null) {
                    if (!CollectionInfoKt.hasCollectionInfo(semanticsNode)) {
                        info.setClassName("android.widget.HorizontalScrollView");
                    }
                    if (xScrollState.getMaxValue().invoke().floatValue() > 0.0f) {
                        info.setScrollable(true);
                    }
                    enabled5 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
                    if (enabled5) {
                        if (populateAccessibilityNodeInfoProperties$canScrollForward(xScrollState)) {
                            info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                            isRtl2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode);
                            info.addAction(!isRtl2 ? AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT : AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT);
                        }
                        if (populateAccessibilityNodeInfoProperties$canScrollBackward(xScrollState)) {
                            info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                            isRtl = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode);
                            info.addAction(!isRtl ? AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT : AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT);
                        }
                    }
                }
                yScrollState = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
                if (yScrollState == null && scrollAction2 != null) {
                    if (!CollectionInfoKt.hasCollectionInfo(semanticsNode)) {
                        info.setClassName("android.widget.ScrollView");
                    }
                    if (yScrollState.getMaxValue().invoke().floatValue() > 0.0f) {
                        info.setScrollable(true);
                    }
                    enabled4 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
                    if (enabled4) {
                        if (populateAccessibilityNodeInfoProperties$canScrollForward(yScrollState)) {
                            info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                            info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                        }
                        if (populateAccessibilityNodeInfoProperties$canScrollBackward(yScrollState)) {
                            info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                            info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                        }
                    }
                }
                info.setPaneTitle((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getPaneTitle()));
                enabled3 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
                if (enabled3) {
                    AccessibilityAction it11 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getExpand());
                    if (it11 != null) {
                        info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, it11.getLabel()));
                        Unit unit22 = Unit.INSTANCE;
                        Unit unit23 = Unit.INSTANCE;
                    }
                    AccessibilityAction it12 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCollapse());
                    if (it12 != null) {
                        info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, it12.getLabel()));
                        Unit unit24 = Unit.INSTANCE;
                        Unit unit25 = Unit.INSTANCE;
                    }
                    AccessibilityAction it13 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getDismiss());
                    if (it13 != null) {
                        info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, it13.getLabel()));
                        Unit unit26 = Unit.INSTANCE;
                        Unit unit27 = Unit.INSTANCE;
                    }
                    if (semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getCustomActions())) {
                        List customActions = (List) semanticsNode.getUnmergedConfig().get(SemanticsActions.INSTANCE.getCustomActions());
                        if (customActions.size() >= AccessibilityActionsResourceIds.length) {
                            throw new IllegalStateException("Can't have more than " + AccessibilityActionsResourceIds.length + " custom actions for one widget");
                        }
                        SparseArrayCompat currentActionIdToLabel = new SparseArrayCompat();
                        Map currentLabelToActionId = new LinkedHashMap();
                        if (this.labelToActionId.containsKey(virtualViewId)) {
                            Map oldLabelToActionId = this.labelToActionId.get(virtualViewId);
                            List availableIds = ArraysKt.toMutableList(AccessibilityActionsResourceIds);
                            List unassignedActions = new ArrayList();
                            List $this$fastForEach$iv2 = customActions;
                            int size2 = $this$fastForEach$iv2.size();
                            int index$iv2 = 0;
                            while (index$iv2 < size2) {
                                int i2 = size2;
                                List $this$fastForEach$iv3 = $this$fastForEach$iv2;
                                Object item$iv2 = $this$fastForEach$iv3.get(index$iv2);
                                CustomAccessibilityAction action = (CustomAccessibilityAction) item$iv2;
                                Intrinsics.checkNotNull(oldLabelToActionId);
                                boolean isTransparent2 = isTransparent;
                                if (oldLabelToActionId.containsKey(action.getLabel())) {
                                    Integer actionId = oldLabelToActionId.get(action.getLabel());
                                    Intrinsics.checkNotNull(actionId);
                                    rangeInfo2 = rangeInfo;
                                    scrollAction = scrollAction2;
                                    currentActionIdToLabel.put(actionId.intValue(), action.getLabel());
                                    currentLabelToActionId.put(action.getLabel(), actionId);
                                    availableIds.remove(actionId);
                                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(actionId.intValue(), action.getLabel()));
                                } else {
                                    rangeInfo2 = rangeInfo;
                                    scrollAction = scrollAction2;
                                    unassignedActions.add(action);
                                }
                                index$iv2++;
                                size2 = i2;
                                $this$fastForEach$iv2 = $this$fastForEach$iv3;
                                isTransparent = isTransparent2;
                                rangeInfo = rangeInfo2;
                                scrollAction2 = scrollAction;
                            }
                            List $this$fastForEachIndexed$iv = unassignedActions;
                            int $i$f$fastForEachIndexed = 0;
                            int index$iv3 = 0;
                            int size3 = $this$fastForEachIndexed$iv.size();
                            while (index$iv3 < size3) {
                                Object item$iv3 = $this$fastForEachIndexed$iv.get(index$iv3);
                                CustomAccessibilityAction action2 = (CustomAccessibilityAction) item$iv3;
                                int index = index$iv3;
                                List unassignedActions2 = unassignedActions;
                                int actionId2 = availableIds.get(index).intValue();
                                currentActionIdToLabel.put(actionId2, action2.getLabel());
                                currentLabelToActionId.put(action2.getLabel(), Integer.valueOf(actionId2));
                                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(actionId2, action2.getLabel()));
                                index$iv3++;
                                $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv;
                                unassignedActions = unassignedActions2;
                                $i$f$fastForEachIndexed = $i$f$fastForEachIndexed;
                            }
                        } else {
                            List $this$fastForEachIndexed$iv2 = customActions;
                            int $i$f$fastForEachIndexed2 = 0;
                            int index$iv4 = 0;
                            int size4 = $this$fastForEachIndexed$iv2.size();
                            while (index$iv4 < size4) {
                                Object item$iv4 = $this$fastForEachIndexed$iv2.get(index$iv4);
                                CustomAccessibilityAction action3 = (CustomAccessibilityAction) item$iv4;
                                int index2 = index$iv4;
                                List customActions2 = customActions;
                                int actionId3 = AccessibilityActionsResourceIds[index2];
                                currentActionIdToLabel.put(actionId3, action3.getLabel());
                                currentLabelToActionId.put(action3.getLabel(), Integer.valueOf(actionId3));
                                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(actionId3, action3.getLabel()));
                                index$iv4++;
                                $this$fastForEachIndexed$iv2 = $this$fastForEachIndexed$iv2;
                                customActions = customActions2;
                                $i$f$fastForEachIndexed2 = $i$f$fastForEachIndexed2;
                            }
                        }
                        this.actionIdToLabel.put(virtualViewId, currentActionIdToLabel);
                        this.labelToActionId.put(virtualViewId, currentLabelToActionId);
                    }
                }
                boolean isSpeakingNode = (info.getContentDescription() != null && info.getText() == null && info.getHintText() == null && info.getStateDescription() == null && !info.isCheckable()) ? false : true;
                info.setScreenReaderFocusable(!semanticsNode.getUnmergedConfig().getIsMergingSemanticsOfDescendants() || (isUnmergedLeafNode && isSpeakingNode));
            }
        }
        isUnmergedLeafNode = false;
        info.setClassName(ClassName);
        role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
        if (role != null) {
        }
        isTextField = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode);
        if (isTextField) {
        }
        if (semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getText())) {
        }
        info.setPackageName(this.view.getContext().getPackageName());
        info.setImportantForAccessibility(true);
        List $this$fastForEach$iv4 = semanticsNode.getReplacedChildrenSortedByBounds$ui_release();
        size = $this$fastForEach$iv4.size();
        while (index$iv < size) {
        }
        if (this.focusedVirtualViewId != virtualViewId) {
        }
        setText(semanticsNode, info);
        setContentInvalid(semanticsNode, info);
        info.setStateDescription((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getStateDescription()));
        toggleState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getToggleableState());
        if (toggleState != null) {
        }
        bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
        }
        if (semanticsNode.getUnmergedConfig().getIsMergingSemanticsOfDescendants()) {
        }
        List list3 = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getContentDescription());
        info.setContentDescription(list3 == null ? (String) CollectionsKt.firstOrNull(list3) : null);
        testTag = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getTestTag());
        if (testTag != null) {
        }
        if (((Unit) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHeading())) != null) {
        }
        isPassword = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(semanticsNode);
        info.setPassword(isPassword);
        isTextField2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode);
        info.setEditable(isTextField2);
        enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
        info.setEnabled(enabled);
        info.setFocusable(semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getFocused()));
        int i3 = 2;
        if (info.isFocusable()) {
        }
        if (semanticsNode.getIsFake()) {
        }
        if (wrapperToCheckTransparency == null) {
        }
        info.setVisibleToUser(isTransparent && SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getInvisibleToUser()) == null);
        liveRegionMode = (LiveRegionMode) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getLiveRegion());
        if (liveRegionMode != null) {
        }
        info.setClickable(false);
        it = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnClick());
        if (it != null) {
        }
        info.setLongClickable(false);
        it2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnLongClick());
        if (it2 != null) {
        }
        it3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCopyText());
        if (it3 != null) {
        }
        enabled2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
        if (enabled2) {
        }
        String text22 = getIterableTextForAccessibility(semanticsNode);
        str = text22;
        if (!(str != null || str.length() == 0)) {
        }
        extraDataKeys = new ArrayList();
        text = info.getText();
        if (!(text != null || text.length() == 0)) {
            extraDataKeys.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
        }
        if (semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTestTag())) {
        }
        if (!extraDataKeys.isEmpty()) {
        }
        rangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if (rangeInfo != null) {
        }
        Api24Impl.addSetProgressAction(info, semanticsNode);
        CollectionInfoKt.setCollectionInfo(semanticsNode, info);
        CollectionInfoKt.setCollectionItemInfo(semanticsNode, info);
        xScrollState = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
        AccessibilityAction scrollAction22 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getScrollBy());
        if (xScrollState != null) {
            if (!CollectionInfoKt.hasCollectionInfo(semanticsNode)) {
            }
            if (xScrollState.getMaxValue().invoke().floatValue() > 0.0f) {
            }
            enabled5 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled5) {
            }
        }
        yScrollState = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        if (yScrollState == null) {
        }
        info.setPaneTitle((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getPaneTitle()));
        enabled3 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
        if (enabled3) {
        }
        boolean isSpeakingNode2 = (info.getContentDescription() != null && info.getText() == null && info.getHintText() == null && info.getStateDescription() == null && !info.isCheckable()) ? false : true;
        info.setScreenReaderFocusable(!semanticsNode.getUnmergedConfig().getIsMergingSemanticsOfDescendants() || (isUnmergedLeafNode && isSpeakingNode2));
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange $this$populateAccessibilityNodeInfoProperties_u24canScrollForward) {
        return ($this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getValue().invoke().floatValue() < $this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getMaxValue().invoke().floatValue() && !$this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getReverseScrolling()) || ($this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getValue().invoke().floatValue() > 0.0f && $this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getReverseScrolling());
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward) {
        return ($this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getValue().invoke().floatValue() > 0.0f && !$this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getReverseScrolling()) || ($this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getValue().invoke().floatValue() < $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getMaxValue().invoke().floatValue() && $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getReverseScrolling());
    }

    private final void setContentInvalid(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getError())) {
            info.setContentInvalid(true);
            info.setError((CharSequence) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getError()));
        }
    }

    private final void setText(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        AnnotatedString annotatedString;
        FontFamily.Resolver fontFamilyResolver = this.view.getFontFamilyResolver();
        AnnotatedString textForTextField = getTextForTextField(node.getUnmergedConfig());
        SpannableString spannableString = null;
        SpannableString editableTextToAssign = (SpannableString) trimToSize(textForTextField != null ? AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(textForTextField, this.view.getDensity(), fontFamilyResolver) : null, ParcelSafeTextLength);
        List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
        if (list != null && (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) != null) {
            spannableString = AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(annotatedString, this.view.getDensity(), fontFamilyResolver);
        }
        SpannableString textToAssign = (SpannableString) trimToSize(spannableString, ParcelSafeTextLength);
        info.setText(editableTextToAssign != null ? editableTextToAssign : textToAssign);
    }

    private final boolean isAccessibilityFocused(int virtualViewId) {
        return this.focusedVirtualViewId == virtualViewId;
    }

    private final boolean requestAccessibilityFocus(int virtualViewId) {
        if (!isAccessibilityEnabled() || isAccessibilityFocused(virtualViewId)) {
            return false;
        }
        if (this.focusedVirtualViewId != Integer.MIN_VALUE) {
            sendEventForVirtualView$default(this, this.focusedVirtualViewId, 65536, null, null, 12, null);
        }
        this.focusedVirtualViewId = virtualViewId;
        this.view.invalidate();
        sendEventForVirtualView$default(this, virtualViewId, 32768, null, null, 12, null);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i, int i2, Integer num, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i, i2, num, list);
    }

    private final boolean sendEventForVirtualView(int virtualViewId, int eventType, Integer contentChangeType, List<String> contentDescription) {
        if (virtualViewId == Integer.MIN_VALUE || !isAccessibilityEnabled()) {
            return false;
        }
        AccessibilityEvent event = createEvent$ui_release(virtualViewId, eventType);
        if (contentChangeType != null) {
            event.setContentChangeTypes(contentChangeType.intValue());
        }
        if (contentDescription != null) {
            event.setContentDescription(TempListUtilsKt.fastJoinToString$default(contentDescription, ",", null, null, 0, null, null, 62, null));
        }
        return sendEvent(event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean sendEvent(AccessibilityEvent event) {
        if (!isAccessibilityEnabled()) {
            return false;
        }
        return this.view.getParent().requestSendAccessibilityEvent(this.view, event);
    }

    public final AccessibilityEvent createEvent$ui_release(int virtualViewId, int eventType) {
        boolean isPassword;
        AccessibilityEvent event = AccessibilityEvent.obtain(eventType);
        Intrinsics.checkNotNullExpressionValue(event, "obtain(eventType)");
        event.setEnabled(true);
        event.setClassName(ClassName);
        event.setPackageName(this.view.getContext().getPackageName());
        event.setSource(this.view, virtualViewId);
        SemanticsNodeWithAdjustedBounds it = getCurrentSemanticsNodes().get(Integer.valueOf(virtualViewId));
        if (it != null) {
            isPassword = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(it.getSemanticsNode());
            event.setPassword(isPassword);
        }
        return event;
    }

    private final AccessibilityEvent createTextSelectionChangedEvent(int virtualViewId, Integer fromIndex, Integer toIndex, Integer itemCount, String text) {
        AccessibilityEvent $this$createTextSelectionChangedEvent_u24lambda_u2d24 = createEvent$ui_release(virtualViewId, 8192);
        if (fromIndex != null) {
            int it = fromIndex.intValue();
            $this$createTextSelectionChangedEvent_u24lambda_u2d24.setFromIndex(it);
        }
        if (toIndex != null) {
            int it2 = toIndex.intValue();
            $this$createTextSelectionChangedEvent_u24lambda_u2d24.setToIndex(it2);
        }
        if (itemCount != null) {
            int it3 = itemCount.intValue();
            $this$createTextSelectionChangedEvent_u24lambda_u2d24.setItemCount(it3);
        }
        if (text != null) {
            $this$createTextSelectionChangedEvent_u24lambda_u2d24.getText().add(text);
        }
        return $this$createTextSelectionChangedEvent_u24lambda_u2d24;
    }

    private final boolean clearAccessibilityFocus(int virtualViewId) {
        if (isAccessibilityFocused(virtualViewId)) {
            this.focusedVirtualViewId = Integer.MIN_VALUE;
            this.view.invalidate();
            sendEventForVirtualView$default(this, virtualViewId, 65536, null, null, 12, null);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean performActionHelper(int virtualViewId, int action, Bundle arguments) {
        SemanticsNode semanticsNode;
        boolean enabled;
        Function0 function0;
        boolean isRtl;
        boolean isRtl2;
        boolean z;
        SemanticsConfiguration config;
        SemanticsConfiguration config2;
        AccessibilityAction accessibilityAction;
        CharSequence charSequence;
        List list;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(Integer.valueOf(virtualViewId));
        if (semanticsNodeWithAdjustedBounds != null && (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) != null) {
            switch (action) {
                case 64:
                    break;
                case 128:
                    break;
                case 256:
                case 512:
                    if (arguments != null) {
                        break;
                    }
                    break;
                case 16384:
                    AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCopyText());
                    if (accessibilityAction2 != null && (r0 = (Function0) accessibilityAction2.getAction()) != null) {
                        break;
                    }
                    break;
                case 131072:
                    boolean accessibilitySelection = setAccessibilitySelection(semanticsNode, arguments != null ? arguments.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT, -1) : -1, arguments != null ? arguments.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT, -1) : -1, false);
                    if (accessibilitySelection) {
                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode.getId()), 0, null, null, 12, null);
                        break;
                    }
                    break;
                default:
                    enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
                    if (enabled) {
                        Boolean bool = null;
                        bool = null;
                        switch (action) {
                            case 1:
                                AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getRequestFocus());
                                if (accessibilityAction3 != null && (r0 = (Function0) accessibilityAction3.getAction()) != null) {
                                    break;
                                }
                                break;
                            case 2:
                                if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getFocused()), (Object) true)) {
                                    FocusManager.clearFocus$default(this.view.getFocusManager(), false, 1, null);
                                    break;
                                }
                                break;
                            case 16:
                                AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnClick());
                                if (accessibilityAction4 != null && (function0 = (Function0) accessibilityAction4.getAction()) != null) {
                                    bool = (Boolean) function0.invoke();
                                }
                                Boolean bool2 = bool;
                                sendEventForVirtualView$default(this, virtualViewId, 1, null, null, 12, null);
                                if (bool2 != null) {
                                    break;
                                }
                                break;
                            case 32:
                                AccessibilityAction accessibilityAction5 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnLongClick());
                                if (accessibilityAction5 != null && (r0 = (Function0) accessibilityAction5.getAction()) != null) {
                                    break;
                                }
                                break;
                            case 4096:
                            case 8192:
                            case R.id.accessibilityActionScrollUp:
                            case R.id.accessibilityActionScrollLeft:
                            case R.id.accessibilityActionScrollDown:
                            case R.id.accessibilityActionScrollRight:
                                boolean z2 = action == 4096;
                                boolean z3 = action == 8192;
                                boolean z4 = action == 16908345;
                                boolean z5 = action == 16908347;
                                boolean z6 = action == 16908344;
                                boolean z7 = action == 16908346;
                                boolean z8 = z4 || z5 || z2 || z3;
                                boolean z9 = z6 || z7 || z2 || z3;
                                if (z2 || z3) {
                                    ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
                                    AccessibilityAction accessibilityAction6 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetProgress());
                                    if (progressBarRangeInfo != null && accessibilityAction6 != null) {
                                        float coerceAtLeast = RangesKt.coerceAtLeast(progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getRange().getStart().floatValue());
                                        float coerceAtMost = RangesKt.coerceAtMost(progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue());
                                        float steps = progressBarRangeInfo.getSteps() > 0 ? (coerceAtLeast - coerceAtMost) / (progressBarRangeInfo.getSteps() + 1) : (coerceAtLeast - coerceAtMost) / 20;
                                        if (z3) {
                                            steps = -steps;
                                        }
                                        Function1 function1 = (Function1) accessibilityAction6.getAction();
                                        if (function1 != null) {
                                            break;
                                        } else {
                                            break;
                                        }
                                    }
                                }
                                long m1793getSizeNHjbRc = LayoutCoordinatesKt.boundsInParent(semanticsNode.getLayoutInfo().getCoordinates()).m1793getSizeNHjbRc();
                                AccessibilityAction accessibilityAction7 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getScrollBy());
                                if (accessibilityAction7 != null) {
                                    ScrollAxisRange scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
                                    if (scrollAxisRange != null && z8) {
                                        float m1829getWidthimpl = Size.m1829getWidthimpl(m1793getSizeNHjbRc);
                                        if (z4 || z3) {
                                            m1829getWidthimpl = -m1829getWidthimpl;
                                        }
                                        if (scrollAxisRange.getReverseScrolling()) {
                                            m1829getWidthimpl = -m1829getWidthimpl;
                                        }
                                        isRtl = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode);
                                        if (isRtl && (z4 || z5)) {
                                            m1829getWidthimpl = -m1829getWidthimpl;
                                        }
                                        if (performActionHelper$canScroll(scrollAxisRange, m1829getWidthimpl)) {
                                            Function2 function2 = (Function2) accessibilityAction7.getAction();
                                            if (function2 != null) {
                                                break;
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    ScrollAxisRange scrollAxisRange2 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
                                    if (scrollAxisRange2 == null || !z9) {
                                        break;
                                    } else {
                                        float m1826getHeightimpl = Size.m1826getHeightimpl(m1793getSizeNHjbRc);
                                        if (z6 || z3) {
                                            m1826getHeightimpl = -m1826getHeightimpl;
                                        }
                                        if (scrollAxisRange2.getReverseScrolling()) {
                                            m1826getHeightimpl = -m1826getHeightimpl;
                                        }
                                        if (performActionHelper$canScroll(scrollAxisRange2, m1826getHeightimpl) && (r14 = (Function2) accessibilityAction7.getAction()) != null) {
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 32768:
                                AccessibilityAction accessibilityAction8 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPasteText());
                                if (accessibilityAction8 != null && (r0 = (Function0) accessibilityAction8.getAction()) != null) {
                                    break;
                                }
                                break;
                            case 65536:
                                AccessibilityAction accessibilityAction9 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCutText());
                                if (accessibilityAction9 != null && (r0 = (Function0) accessibilityAction9.getAction()) != null) {
                                    break;
                                }
                                break;
                            case 262144:
                                AccessibilityAction accessibilityAction10 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getExpand());
                                if (accessibilityAction10 != null && (r0 = (Function0) accessibilityAction10.getAction()) != null) {
                                    break;
                                }
                                break;
                            case 524288:
                                AccessibilityAction accessibilityAction11 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCollapse());
                                if (accessibilityAction11 != null && (r0 = (Function0) accessibilityAction11.getAction()) != null) {
                                    break;
                                }
                                break;
                            case 1048576:
                                AccessibilityAction accessibilityAction12 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getDismiss());
                                if (accessibilityAction12 != null && (r0 = (Function0) accessibilityAction12.getAction()) != null) {
                                    break;
                                }
                                break;
                            case 2097152:
                                String string = arguments != null ? arguments.getString(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE) : null;
                                AccessibilityAction accessibilityAction13 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetText());
                                if (accessibilityAction13 != null && (r1 = (Function1) accessibilityAction13.getAction()) != null) {
                                    break;
                                }
                                break;
                            case R.id.accessibilityActionShowOnScreen:
                                SemanticsNode parent = semanticsNode.getParent();
                                AccessibilityAction accessibilityAction14 = (parent == null || (config2 = parent.getConfig()) == null) ? null : (AccessibilityAction) SemanticsConfigurationKt.getOrNull(config2, SemanticsActions.INSTANCE.getScrollBy());
                                while (parent != null && accessibilityAction14 == null) {
                                    parent = parent.getParent();
                                    accessibilityAction14 = (parent == null || (config = parent.getConfig()) == null) ? null : (AccessibilityAction) SemanticsConfigurationKt.getOrNull(config, SemanticsActions.INSTANCE.getScrollBy());
                                }
                                if (parent != null) {
                                    androidx.compose.p000ui.geometry.Rect boundsInParent = LayoutCoordinatesKt.boundsInParent(parent.getLayoutInfo().getCoordinates());
                                    LayoutCoordinates parentLayoutCoordinates = parent.getLayoutInfo().getCoordinates().getParentLayoutCoordinates();
                                    androidx.compose.p000ui.geometry.Rect m1797translatek4lQ0M = boundsInParent.m1797translatek4lQ0M(parentLayoutCoordinates != null ? LayoutCoordinatesKt.positionInRoot(parentLayoutCoordinates) : Offset.INSTANCE.m1776getZeroF1C5BW0());
                                    androidx.compose.p000ui.geometry.Rect m1800Recttz77jQw = RectKt.m1800Recttz77jQw(semanticsNode.m3839getPositionInRootF1C5BW0(), IntSizeKt.m4552toSizeozmzZPI(semanticsNode.m3841getSizeYbymL2g()));
                                    ScrollAxisRange scrollAxisRange3 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(parent.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
                                    ScrollAxisRange scrollAxisRange4 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(parent.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
                                    float performActionHelper$scrollDelta = performActionHelper$scrollDelta(m1800Recttz77jQw.getLeft() - m1797translatek4lQ0M.getLeft(), m1800Recttz77jQw.getRight() - m1797translatek4lQ0M.getRight());
                                    if (scrollAxisRange3 != null && scrollAxisRange3.getReverseScrolling()) {
                                        performActionHelper$scrollDelta = -performActionHelper$scrollDelta;
                                    }
                                    isRtl2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode);
                                    if (isRtl2) {
                                        performActionHelper$scrollDelta = -performActionHelper$scrollDelta;
                                    }
                                    float performActionHelper$scrollDelta2 = performActionHelper$scrollDelta(m1800Recttz77jQw.getTop() - m1797translatek4lQ0M.getTop(), m1800Recttz77jQw.getBottom() - m1797translatek4lQ0M.getBottom());
                                    if (scrollAxisRange4 != null && scrollAxisRange4.getReverseScrolling()) {
                                        z = true;
                                        if (z) {
                                            performActionHelper$scrollDelta2 = -performActionHelper$scrollDelta2;
                                        }
                                        if (accessibilityAction14 != null || (r1 = (Function2) accessibilityAction14.getAction()) == null) {
                                            break;
                                        } else {
                                            break;
                                        }
                                    }
                                    z = false;
                                    if (z) {
                                    }
                                    if (accessibilityAction14 != null) {
                                    }
                                }
                                break;
                            case R.id.accessibilityActionSetProgress:
                                if (arguments != null && arguments.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetProgress())) != null && (r1 = (Function1) accessibilityAction.getAction()) != null) {
                                    break;
                                }
                                break;
                            default:
                                SparseArrayCompat<CharSequence> sparseArrayCompat = this.actionIdToLabel.get(virtualViewId);
                                if (sparseArrayCompat != null && (charSequence = sparseArrayCompat.get(action)) != null && (list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCustomActions())) != null) {
                                    int size = list.size();
                                    for (int i = 0; i < size; i++) {
                                        CustomAccessibilityAction customAccessibilityAction = (CustomAccessibilityAction) list.get(i);
                                        if (Intrinsics.areEqual(customAccessibilityAction.getLabel(), charSequence)) {
                                            break;
                                        }
                                    }
                                    break;
                                }
                                break;
                        }
                    }
                    break;
            }
            return false;
        }
        return false;
    }

    private static final boolean performActionHelper$canScroll(ScrollAxisRange $this$performActionHelper_u24canScroll, float amount) {
        return (amount < 0.0f && $this$performActionHelper_u24canScroll.getValue().invoke().floatValue() > 0.0f) || (amount > 0.0f && $this$performActionHelper_u24canScroll.getValue().invoke().floatValue() < $this$performActionHelper_u24canScroll.getMaxValue().invoke().floatValue());
    }

    private static final float performActionHelper$scrollDelta(float a, float b) {
        if (Math.signum(a) == Math.signum(b)) {
            return Math.abs(a) < Math.abs(b) ? a : b;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey, Bundle arguments) {
        SemanticsNode node;
        String testTag;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(Integer.valueOf(virtualViewId));
        if (semanticsNodeWithAdjustedBounds == null || (node = semanticsNodeWithAdjustedBounds.getSemanticsNode()) == null) {
            return;
        }
        String text = getIterableTextForAccessibility(node);
        if (node.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && arguments != null && Intrinsics.areEqual(extraDataKey, "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
            int positionInfoStartIndex = arguments.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
            int positionInfoLength = arguments.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
            if (positionInfoLength > 0 && positionInfoStartIndex >= 0) {
                if (positionInfoStartIndex < (text != null ? text.length() : Integer.MAX_VALUE)) {
                    ArrayList arrayList = new ArrayList();
                    Function1 function1 = (Function1) ((AccessibilityAction) node.getUnmergedConfig().get(SemanticsActions.INSTANCE.getGetTextLayoutResult())).getAction();
                    Boolean getLayoutResult = function1 != null ? (Boolean) function1.invoke(arrayList) : null;
                    if (Intrinsics.areEqual((Object) getLayoutResult, (Object) true)) {
                        TextLayoutResult textLayoutResult = (TextLayoutResult) arrayList.get(0);
                        List boundingRects = new ArrayList();
                        for (int i = 0; i < positionInfoLength; i++) {
                            if (positionInfoStartIndex + i >= textLayoutResult.getLayoutInput().getText().length()) {
                                boundingRects.add(null);
                            } else {
                                androidx.compose.p000ui.geometry.Rect bounds = textLayoutResult.getBoundingBox(positionInfoStartIndex + i);
                                RectF boundsOnScreen = toScreenCoords(node, bounds);
                                boundingRects.add(boundsOnScreen);
                            }
                        }
                        Bundle extras = info.getExtras();
                        List $this$toTypedArray$iv = boundingRects;
                        Object[] array = $this$toTypedArray$iv.toArray(new RectF[0]);
                        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        extras.putParcelableArray(extraDataKey, (Parcelable[]) array);
                        return;
                    }
                    return;
                }
            }
            Log.e(LogTag, "Invalid arguments for accessibility character locations");
            return;
        }
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTestTag()) && arguments != null && Intrinsics.areEqual(extraDataKey, ExtraDataTestTagKey) && (testTag = (String) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getTestTag())) != null) {
            info.getExtras().putCharSequence(extraDataKey, testTag);
        }
    }

    private final RectF toScreenCoords(SemanticsNode textNode, androidx.compose.p000ui.geometry.Rect bounds) {
        androidx.compose.p000ui.geometry.Rect visibleBounds;
        if (textNode == null) {
            return null;
        }
        androidx.compose.p000ui.geometry.Rect boundsInRoot = bounds.m1797translatek4lQ0M(textNode.m3839getPositionInRootF1C5BW0());
        androidx.compose.p000ui.geometry.Rect textNodeBoundsInRoot = textNode.getBoundsInRoot();
        if (boundsInRoot.overlaps(textNodeBoundsInRoot)) {
            visibleBounds = boundsInRoot.intersect(textNodeBoundsInRoot);
        } else {
            visibleBounds = null;
        }
        if (visibleBounds != null) {
            long topLeftInScreen = this.view.mo3444localToScreenMKHz9U(OffsetKt.Offset(visibleBounds.getLeft(), visibleBounds.getTop()));
            long bottomRightInScreen = this.view.mo3444localToScreenMKHz9U(OffsetKt.Offset(visibleBounds.getRight(), visibleBounds.getBottom()));
            return new RectF(Offset.m1760getXimpl(topLeftInScreen), Offset.m1761getYimpl(topLeftInScreen), Offset.m1760getXimpl(bottomRightInScreen), Offset.m1761getYimpl(bottomRightInScreen));
        }
        return null;
    }

    public final boolean dispatchHoverEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isAccessibilityEnabled()) {
            return false;
        }
        switch (event.getAction()) {
            case 7:
            case 9:
                int virtualViewId = hitTestSemanticsAt$ui_release(event.getX(), event.getY());
                boolean handled = this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
                updateHoveredVirtualView(virtualViewId);
                if (virtualViewId == Integer.MIN_VALUE) {
                    break;
                }
                break;
            case 10:
                if (this.hoveredVirtualViewId == Integer.MIN_VALUE) {
                    break;
                } else {
                    updateHoveredVirtualView(Integer.MIN_VALUE);
                    break;
                }
        }
        return false;
    }

    public final int hitTestSemanticsAt$ui_release(float x, float y) {
        LayoutNode requireLayoutNode;
        SemanticsModifierNode semanticsModifierNode = null;
        Owner.measureAndLayout$default(this.view, false, 1, null);
        HitTestResult hitSemanticsEntities = new HitTestResult();
        LayoutNode.m3618hitTestSemanticsM_7yMNQ$ui_release$default(this.view.getRoot(), OffsetKt.Offset(x, y), hitSemanticsEntities, false, false, 12, null);
        SemanticsModifierNode semanticsModifierNode2 = (SemanticsModifierNode) CollectionsKt.lastOrNull((List) hitSemanticsEntities);
        if (semanticsModifierNode2 != null && (requireLayoutNode = DelegatableNodeKt.requireLayoutNode(semanticsModifierNode2)) != null) {
            semanticsModifierNode = SemanticsNodeKt.getOuterSemantics(requireLayoutNode);
        }
        SemanticsModifierNode wrapper = semanticsModifierNode;
        if (wrapper == null) {
            return Integer.MIN_VALUE;
        }
        SemanticsNode semanticsNode = new SemanticsNode(wrapper, false, null, 4, null);
        NodeCoordinator wrapperToCheckAlpha = semanticsNode.findCoordinatorToGetBounds$ui_release();
        if (semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getInvisibleToUser()) || wrapperToCheckAlpha.isTransparent()) {
            return Integer.MIN_VALUE;
        }
        LayoutNode layoutNode = DelegatableNodeKt.requireLayoutNode(wrapper);
        AndroidViewHolder androidView = this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(layoutNode);
        if (androidView != null) {
            return Integer.MIN_VALUE;
        }
        int virtualViewId = semanticsNodeIdToAccessibilityVirtualNodeId(layoutNode.getSemanticsId());
        return virtualViewId;
    }

    private final void updateHoveredVirtualView(int virtualViewId) {
        if (this.hoveredVirtualViewId == virtualViewId) {
            return;
        }
        int previousVirtualViewId = this.hoveredVirtualViewId;
        this.hoveredVirtualViewId = virtualViewId;
        sendEventForVirtualView$default(this, virtualViewId, 128, null, null, 12, null);
        sendEventForVirtualView$default(this, previousVirtualViewId, 256, null, null, 12, null);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        Intrinsics.checkNotNullParameter(host, "host");
        return this.nodeProvider;
    }

    private final <T extends CharSequence> T trimToSize(T text, int size) {
        boolean z = true;
        if (!(size > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i = size;
        if (text != null && text.length() != 0) {
            z = false;
        }
        if (z || text.length() <= size) {
            return text;
        }
        if (Character.isHighSurrogate(text.charAt(size - 1)) && Character.isLowSurrogate(text.charAt(size))) {
            i = size - 1;
        }
        T t = (T) text.subSequence(0, i);
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: semanticsChangeChecker$lambda-26, reason: not valid java name */
    public static final void m3754semanticsChangeChecker$lambda26(AndroidComposeViewAccessibilityDelegateCompat this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Owner.measureAndLayout$default(this$0.view, false, 1, null);
        this$0.checkForSemanticsChanges();
        this$0.checkingForSemanticsChanges = false;
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (isAccessibilityEnabled() && !this.checkingForSemanticsChanges) {
            this.checkingForSemanticsChanges = true;
            this.handler.post(this.semanticsChangeChecker);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0085 A[Catch: all -> 0x00df, TryCatch #1 {all -> 0x00df, blocks: (B:20:0x007d, B:22:0x0085, B:24:0x008e, B:26:0x0098, B:28:0x00aa, B:30:0x00b1, B:31:0x00ba), top: B:19:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00d1 -> B:15:0x0068). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object boundsUpdatesEventLoop(Continuation<? super Unit> continuation) {
        C0452x3d3eeeed c0452x3d3eeeed;
        C0452x3d3eeeed c0452x3d3eeeed2;
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat;
        ArraySet subtreeChangedSemanticsNodesIds;
        ChannelIterator<Unit> it;
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat2;
        ArraySet subtreeChangedSemanticsNodesIds2;
        Object obj;
        Object $result;
        Object hasNext;
        try {
            if (continuation instanceof C0452x3d3eeeed) {
                c0452x3d3eeeed = (C0452x3d3eeeed) continuation;
                if ((c0452x3d3eeeed.label & Integer.MIN_VALUE) != 0) {
                    c0452x3d3eeeed.label -= Integer.MIN_VALUE;
                    c0452x3d3eeeed2 = c0452x3d3eeeed;
                    Object $result2 = c0452x3d3eeeed2.result;
                    Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (c0452x3d3eeeed2.label) {
                        case 0:
                            ResultKt.throwOnFailure($result2);
                            androidComposeViewAccessibilityDelegateCompat = this;
                            subtreeChangedSemanticsNodesIds = new ArraySet();
                            it = androidComposeViewAccessibilityDelegateCompat.boundsUpdateChannel.iterator();
                            c0452x3d3eeeed2.L$0 = androidComposeViewAccessibilityDelegateCompat;
                            c0452x3d3eeeed2.L$1 = subtreeChangedSemanticsNodesIds;
                            c0452x3d3eeeed2.L$2 = it;
                            c0452x3d3eeeed2.label = 1;
                            hasNext = it.hasNext(c0452x3d3eeeed2);
                            if (hasNext == $result3) {
                                return $result3;
                            }
                            Object obj2 = $result3;
                            $result = $result2;
                            $result2 = hasNext;
                            androidComposeViewAccessibilityDelegateCompat2 = androidComposeViewAccessibilityDelegateCompat;
                            subtreeChangedSemanticsNodesIds2 = subtreeChangedSemanticsNodesIds;
                            obj = obj2;
                            try {
                                if (((Boolean) $result2).booleanValue()) {
                                    androidComposeViewAccessibilityDelegateCompat2.subtreeChangedLayoutNodes.clear();
                                    return Unit.INSTANCE;
                                }
                                it.next();
                                if (androidComposeViewAccessibilityDelegateCompat2.isAccessibilityEnabled()) {
                                    int size = androidComposeViewAccessibilityDelegateCompat2.subtreeChangedLayoutNodes.size();
                                    for (int i = 0; i < size; i++) {
                                        LayoutNode valueAt = androidComposeViewAccessibilityDelegateCompat2.subtreeChangedLayoutNodes.valueAt(i);
                                        Intrinsics.checkNotNull(valueAt);
                                        androidComposeViewAccessibilityDelegateCompat2.sendSubtreeChangeAccessibilityEvents(valueAt, subtreeChangedSemanticsNodesIds2);
                                    }
                                    subtreeChangedSemanticsNodesIds2.clear();
                                    if (!androidComposeViewAccessibilityDelegateCompat2.checkingForSemanticsChanges) {
                                        androidComposeViewAccessibilityDelegateCompat2.checkingForSemanticsChanges = true;
                                        androidComposeViewAccessibilityDelegateCompat2.handler.post(androidComposeViewAccessibilityDelegateCompat2.semanticsChangeChecker);
                                    }
                                }
                                androidComposeViewAccessibilityDelegateCompat2.subtreeChangedLayoutNodes.clear();
                                c0452x3d3eeeed2.L$0 = androidComposeViewAccessibilityDelegateCompat2;
                                c0452x3d3eeeed2.L$1 = subtreeChangedSemanticsNodesIds2;
                                c0452x3d3eeeed2.L$2 = it;
                                c0452x3d3eeeed2.label = 2;
                                if (DelayKt.delay(100L, c0452x3d3eeeed2) == obj) {
                                    return obj;
                                }
                                $result2 = $result;
                                $result3 = obj;
                                subtreeChangedSemanticsNodesIds = subtreeChangedSemanticsNodesIds2;
                                androidComposeViewAccessibilityDelegateCompat = androidComposeViewAccessibilityDelegateCompat2;
                                c0452x3d3eeeed2.L$0 = androidComposeViewAccessibilityDelegateCompat;
                                c0452x3d3eeeed2.L$1 = subtreeChangedSemanticsNodesIds;
                                c0452x3d3eeeed2.L$2 = it;
                                c0452x3d3eeeed2.label = 1;
                                hasNext = it.hasNext(c0452x3d3eeeed2);
                                if (hasNext == $result3) {
                                }
                            } catch (Throwable th) {
                                androidComposeViewAccessibilityDelegateCompat = androidComposeViewAccessibilityDelegateCompat2;
                                th = th;
                                androidComposeViewAccessibilityDelegateCompat.subtreeChangedLayoutNodes.clear();
                                throw th;
                            }
                        case 1:
                            ChannelIterator<Unit> channelIterator = (ChannelIterator) c0452x3d3eeeed2.L$2;
                            ArraySet subtreeChangedSemanticsNodesIds3 = (ArraySet) c0452x3d3eeeed2.L$1;
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat3 = (AndroidComposeViewAccessibilityDelegateCompat) c0452x3d3eeeed2.L$0;
                            ResultKt.throwOnFailure($result2);
                            androidComposeViewAccessibilityDelegateCompat2 = androidComposeViewAccessibilityDelegateCompat3;
                            subtreeChangedSemanticsNodesIds2 = subtreeChangedSemanticsNodesIds3;
                            it = channelIterator;
                            obj = $result3;
                            $result = $result2;
                            if (((Boolean) $result2).booleanValue()) {
                            }
                            break;
                        case 2:
                            ChannelIterator<Unit> channelIterator2 = (ChannelIterator) c0452x3d3eeeed2.L$2;
                            ArraySet subtreeChangedSemanticsNodesIds4 = (ArraySet) c0452x3d3eeeed2.L$1;
                            androidComposeViewAccessibilityDelegateCompat = (AndroidComposeViewAccessibilityDelegateCompat) c0452x3d3eeeed2.L$0;
                            ResultKt.throwOnFailure($result2);
                            it = channelIterator2;
                            subtreeChangedSemanticsNodesIds = subtreeChangedSemanticsNodesIds4;
                            c0452x3d3eeeed2.L$0 = androidComposeViewAccessibilityDelegateCompat;
                            c0452x3d3eeeed2.L$1 = subtreeChangedSemanticsNodesIds;
                            c0452x3d3eeeed2.L$2 = it;
                            c0452x3d3eeeed2.label = 1;
                            hasNext = it.hasNext(c0452x3d3eeeed2);
                            if (hasNext == $result3) {
                            }
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (c0452x3d3eeeed2.label) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
        c0452x3d3eeeed = new C0452x3d3eeeed(this, continuation);
        c0452x3d3eeeed2 = c0452x3d3eeeed;
        Object $result22 = c0452x3d3eeeed2.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public final void onLayoutChange$ui_release(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.currentSemanticsNodesInvalidated = true;
        if (!isAccessibilityEnabled()) {
            return;
        }
        notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
    }

    private final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.mo6233trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
    
        r1 = androidx.compose.p000ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(r11, androidx.compose.p000ui.platform.C0456x7245ac5.INSTANCE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void sendSubtreeChangeAccessibilityEvents(LayoutNode layoutNode, ArraySet<Integer> subtreeChangedSemanticsNodesIds) {
        LayoutNode findClosestParentNode;
        SemanticsModifierNode it;
        LayoutNode findClosestParentNode2;
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(layoutNode);
            if (outerSemantics == null) {
                findClosestParentNode2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsWrapper$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(LayoutNode it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        return Boolean.valueOf(SemanticsNodeKt.getOuterSemantics(it2) != null);
                    }
                });
                outerSemantics = findClosestParentNode2 != null ? SemanticsNodeKt.getOuterSemantics(findClosestParentNode2) : null;
                if (outerSemantics == null) {
                    return;
                }
            }
            SemanticsModifierNode it2 = outerSemantics;
            if (!SemanticsModifierNodeKt.collapsedSemanticsConfiguration(it2).getIsMergingSemanticsOfDescendants() && findClosestParentNode != null && (it = SemanticsNodeKt.getOuterSemantics(findClosestParentNode)) != null) {
                it2 = it;
            }
            int id = DelegatableNodeKt.requireLayoutNode(it2).getSemanticsId();
            if (subtreeChangedSemanticsNodesIds.add(Integer.valueOf(id))) {
                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 1, null, 8, null);
            }
        }
    }

    private final void checkForSemanticsChanges() {
        sendSemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
        sendSemanticsPropertyChangeEvents$ui_release(getCurrentSemanticsNodes());
        updateSemanticsNodesCopyAndPanes();
    }

    private final void updateSemanticsNodesCopyAndPanes() {
        boolean hasPaneTitle;
        SemanticsConfiguration unmergedConfig;
        boolean hasPaneTitle2;
        Iterator<Integer> it = this.paneDisplayed.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(id);
            String str = null;
            SemanticsNode currentNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
            if (currentNode != null) {
                hasPaneTitle2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.hasPaneTitle(currentNode);
                if (!hasPaneTitle2) {
                }
            }
            this.paneDisplayed.remove(id);
            Intrinsics.checkNotNullExpressionValue(id, "id");
            int intValue = id.intValue();
            SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(id);
            if (semanticsNodeCopy != null && (unmergedConfig = semanticsNodeCopy.getUnmergedConfig()) != null) {
                str = (String) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsProperties.INSTANCE.getPaneTitle());
            }
            sendPaneChangeEvents(intValue, 32, str);
        }
        this.previousSemanticsNodes.clear();
        for (Map.Entry entry : getCurrentSemanticsNodes().entrySet()) {
            hasPaneTitle = AndroidComposeViewAccessibilityDelegateCompat_androidKt.hasPaneTitle(entry.getValue().getSemanticsNode());
            if (hasPaneTitle && this.paneDisplayed.add(entry.getKey())) {
                sendPaneChangeEvents(entry.getKey().intValue(), 16, (String) entry.getValue().getSemanticsNode().getUnmergedConfig().get(SemanticsProperties.INSTANCE.getPaneTitle()));
            }
            this.previousSemanticsNodes.put(entry.getKey(), new SemanticsNodeCopy(entry.getValue().getSemanticsNode(), getCurrentSemanticsNodes()));
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes());
    }

    public final void sendSemanticsPropertyChangeEvents$ui_release(Map<Integer, SemanticsNodeWithAdjustedBounds> newSemanticsNodes) {
        boolean newlyObservingScroll;
        boolean isTextField;
        int endCount;
        String text;
        boolean accessibilityEquals;
        Map<Integer, SemanticsNodeWithAdjustedBounds> newSemanticsNodes2 = newSemanticsNodes;
        Intrinsics.checkNotNullParameter(newSemanticsNodes2, "newSemanticsNodes");
        ArrayList oldScrollObservationScopes = new ArrayList(this.scrollObservationScopes);
        this.scrollObservationScopes.clear();
        Iterator<Integer> it = newSemanticsNodes.keySet().iterator();
        while (it.hasNext()) {
            int id = it.next().intValue();
            SemanticsNodeCopy oldNode = this.previousSemanticsNodes.get(Integer.valueOf(id));
            if (oldNode != null) {
                SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = newSemanticsNodes2.get(Integer.valueOf(id));
                SemanticsNode newNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                Intrinsics.checkNotNull(newNode);
                Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> it2 = newNode.getUnmergedConfig().iterator();
                boolean propertyChanged = false;
                while (true) {
                    boolean propertyChanged2 = it2.hasNext();
                    if (!propertyChanged2) {
                        break;
                    }
                    Map.Entry entry = it2.next();
                    if (Intrinsics.areEqual(entry.getKey(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()) || Intrinsics.areEqual(entry.getKey(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange())) {
                        boolean newlyObservingScroll2 = registerScrollingId(id, oldScrollObservationScopes);
                        newlyObservingScroll = newlyObservingScroll2;
                    } else {
                        newlyObservingScroll = false;
                    }
                    if (newlyObservingScroll || !Intrinsics.areEqual(entry.getValue(), SemanticsConfigurationKt.getOrNull(oldNode.getUnmergedConfig(), entry.getKey()))) {
                        SemanticsPropertyKey<?> key = entry.getKey();
                        if (Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getPaneTitle())) {
                            Object value = entry.getValue();
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
                            String paneTitle = (String) value;
                            if (oldNode.hasPaneTitle()) {
                                sendPaneChangeEvents(id, 8, paneTitle);
                            }
                        } else if (Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getStateDescription()) ? true : Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getToggleableState())) {
                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 64, null, 8, null);
                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 0, null, 8, null);
                        } else if (Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getProgressBarRangeInfo())) {
                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 64, null, 8, null);
                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 0, null, 8, null);
                        } else if (Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getSelected())) {
                            Role role = (Role) SemanticsConfigurationKt.getOrNull(newNode.getConfig(), SemanticsProperties.INSTANCE.getRole());
                            if (!(role == null ? false : Role.m3828equalsimpl0(role.getValue(), Role.INSTANCE.m3837getTabo7Vup1c()))) {
                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 64, null, 8, null);
                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 0, null, 8, null);
                            } else if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(newNode.getConfig(), SemanticsProperties.INSTANCE.getSelected()), (Object) true)) {
                                AccessibilityEvent event = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(id), 4);
                                SemanticsNode mergedNode = new SemanticsNode(newNode.getOuterSemanticsNode(), true, null, 4, null);
                                List list = (List) SemanticsConfigurationKt.getOrNull(mergedNode.getConfig(), SemanticsProperties.INSTANCE.getContentDescription());
                                String contentDescription = list != null ? TempListUtilsKt.fastJoinToString$default(list, ",", null, null, 0, null, null, 62, null) : null;
                                List list2 = (List) SemanticsConfigurationKt.getOrNull(mergedNode.getConfig(), SemanticsProperties.INSTANCE.getText());
                                String text2 = list2 != null ? TempListUtilsKt.fastJoinToString$default(list2, ",", null, null, 0, null, null, 62, null) : null;
                                if (contentDescription != null) {
                                    String it3 = contentDescription;
                                    event.setContentDescription(it3);
                                    Unit unit = Unit.INSTANCE;
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                if (text2 != null) {
                                    String it4 = text2;
                                    Boolean.valueOf(event.getText().add(it4));
                                }
                                sendEvent(event);
                            } else {
                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 0, null, 8, null);
                            }
                        } else if (Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getContentDescription())) {
                            int semanticsNodeIdToAccessibilityVirtualNodeId = semanticsNodeIdToAccessibilityVirtualNodeId(id);
                            Object value2 = entry.getValue();
                            Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            sendEventForVirtualView(semanticsNodeIdToAccessibilityVirtualNodeId, 2048, 4, (List) value2);
                        } else {
                            String str = "";
                            if (Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getEditableText())) {
                                isTextField = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(newNode);
                                if (isTextField) {
                                    AnnotatedString textForTextField = getTextForTextField(oldNode.getUnmergedConfig());
                                    String oldText = textForTextField != null ? textForTextField : "";
                                    AnnotatedString textForTextField2 = getTextForTextField(newNode.getUnmergedConfig());
                                    String newText = textForTextField2 != null ? textForTextField2 : "";
                                    int startCount = 0;
                                    int endCount2 = 0;
                                    int oldTextLen = oldText.length();
                                    int newTextLen = newText.length();
                                    int minLength = RangesKt.coerceAtMost(oldTextLen, newTextLen);
                                    while (true) {
                                        if (startCount >= minLength) {
                                            endCount = endCount2;
                                            break;
                                        }
                                        int charAt = oldText.charAt(startCount);
                                        endCount = endCount2;
                                        int endCount3 = newText.charAt(startCount);
                                        if (charAt != endCount3) {
                                            break;
                                        }
                                        startCount++;
                                        endCount2 = endCount;
                                    }
                                    int endCount4 = endCount;
                                    while (endCount4 < minLength - startCount && oldText.charAt((oldTextLen - 1) - endCount4) == newText.charAt((newTextLen - 1) - endCount4)) {
                                        endCount4++;
                                    }
                                    int removedCount = (oldTextLen - endCount4) - startCount;
                                    int addedCount = (newTextLen - endCount4) - startCount;
                                    int endCount5 = semanticsNodeIdToAccessibilityVirtualNodeId(id);
                                    AccessibilityEvent textChangeEvent = createEvent$ui_release(endCount5, 16);
                                    textChangeEvent.setFromIndex(startCount);
                                    textChangeEvent.setRemovedCount(removedCount);
                                    textChangeEvent.setAddedCount(addedCount);
                                    textChangeEvent.setBeforeText(oldText);
                                    textChangeEvent.getText().add(trimToSize(newText, ParcelSafeTextLength));
                                    sendEvent(textChangeEvent);
                                } else {
                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 2, null, 8, null);
                                }
                            } else if (Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getTextSelectionRange())) {
                                AnnotatedString textForTextField3 = getTextForTextField(newNode.getUnmergedConfig());
                                if (textForTextField3 != null && (text = textForTextField3.getText()) != null) {
                                    str = text;
                                }
                                String newText2 = str;
                                long textRange = ((TextRange) newNode.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue();
                                sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(id), Integer.valueOf(TextRange.m3957getStartimpl(textRange)), Integer.valueOf(TextRange.m3952getEndimpl(textRange)), Integer.valueOf(newText2.length()), (String) trimToSize(newText2, ParcelSafeTextLength)));
                                sendPendingTextTraversedAtGranularityEvent(newNode.getId());
                            } else if (Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()) ? true : Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getVerticalScrollAxisRange())) {
                                notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode());
                                ScrollObservationScope scope = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findById(this.scrollObservationScopes, id);
                                Intrinsics.checkNotNull(scope);
                                scope.setHorizontalScrollAxisRange((ScrollAxisRange) SemanticsConfigurationKt.getOrNull(newNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()));
                                scope.setVerticalScrollAxisRange((ScrollAxisRange) SemanticsConfigurationKt.getOrNull(newNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange()));
                                sendScrollEventIfNeeded(scope);
                            } else if (Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getFocused())) {
                                Object value3 = entry.getValue();
                                Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type kotlin.Boolean");
                                if (((Boolean) value3).booleanValue()) {
                                    sendEvent(createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(newNode.getId()), 8));
                                }
                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(newNode.getId()), 2048, 0, null, 8, null);
                            } else if (Intrinsics.areEqual(key, SemanticsActions.INSTANCE.getCustomActions())) {
                                List actions = (List) newNode.getUnmergedConfig().get(SemanticsActions.INSTANCE.getCustomActions());
                                List oldActions = (List) SemanticsConfigurationKt.getOrNull(oldNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCustomActions());
                                if (oldActions != null) {
                                    Set labels = new LinkedHashSet();
                                    int size = actions.size();
                                    for (int index$iv = 0; index$iv < size; index$iv++) {
                                        Object item$iv = actions.get(index$iv);
                                        CustomAccessibilityAction action = (CustomAccessibilityAction) item$iv;
                                        labels.add(action.getLabel());
                                    }
                                    Set oldLabels = new LinkedHashSet();
                                    int index$iv2 = 0;
                                    int size2 = oldActions.size();
                                    while (index$iv2 < size2) {
                                        Object item$iv2 = oldActions.get(index$iv2);
                                        CustomAccessibilityAction action2 = (CustomAccessibilityAction) item$iv2;
                                        oldLabels.add(action2.getLabel());
                                        index$iv2++;
                                        oldActions = oldActions;
                                    }
                                    propertyChanged = (labels.containsAll(oldLabels) && oldLabels.containsAll(labels)) ? false : true;
                                } else if (!actions.isEmpty()) {
                                    propertyChanged = true;
                                }
                            } else if (entry.getValue() instanceof AccessibilityAction) {
                                Object value4 = entry.getValue();
                                Intrinsics.checkNotNull(value4, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                                accessibilityEquals = AndroidComposeViewAccessibilityDelegateCompat_androidKt.accessibilityEquals((AccessibilityAction) value4, SemanticsConfigurationKt.getOrNull(oldNode.getUnmergedConfig(), entry.getKey()));
                                propertyChanged = !accessibilityEquals;
                            } else {
                                propertyChanged = true;
                            }
                        }
                    }
                }
                if (!propertyChanged) {
                    propertyChanged = AndroidComposeViewAccessibilityDelegateCompat_androidKt.propertiesDeleted(newNode, oldNode);
                }
                if (propertyChanged) {
                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 0, null, 8, null);
                    newSemanticsNodes2 = newSemanticsNodes;
                } else {
                    newSemanticsNodes2 = newSemanticsNodes;
                }
            }
        }
    }

    private final boolean registerScrollingId(int id, List<ScrollObservationScope> oldScrollObservationScopes) {
        ScrollObservationScope scrollObservationScope;
        boolean newlyObservingScroll = false;
        ScrollObservationScope oldScope = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findById(oldScrollObservationScopes, id);
        if (oldScope != null) {
            scrollObservationScope = oldScope;
        } else {
            newlyObservingScroll = true;
            scrollObservationScope = new ScrollObservationScope(id, this.scrollObservationScopes, null, null, null, null);
        }
        ScrollObservationScope newScope = scrollObservationScope;
        this.scrollObservationScopes.add(newScope);
        return newlyObservingScroll;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendScrollEventIfNeeded(final ScrollObservationScope scrollObservationScope) {
        if (!scrollObservationScope.isValid()) {
            return;
        }
        this.view.getSnapshotObserver().observeReads$ui_release(scrollObservationScope, this.sendScrollEventIfNeededLambda, new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeeded$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:15:0x005f, code lost:
            
                if ((r7 == 0.0f) == false) goto L21;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                float deltaX;
                float deltaY;
                int virtualNodeId;
                ScrollAxisRange newXState = ScrollObservationScope.this.getHorizontalScrollAxisRange();
                ScrollAxisRange newYState = ScrollObservationScope.this.getVerticalScrollAxisRange();
                Float oldXValue = ScrollObservationScope.this.getOldXValue();
                Float oldYValue = ScrollObservationScope.this.getOldYValue();
                if (newXState != null && oldXValue != null) {
                    deltaX = newXState.getValue().invoke().floatValue() - oldXValue.floatValue();
                } else {
                    deltaX = 0.0f;
                }
                if (newYState != null && oldYValue != null) {
                    deltaY = newYState.getValue().invoke().floatValue() - oldYValue.floatValue();
                } else {
                    deltaY = 0.0f;
                }
                if (deltaX == 0.0f) {
                }
                virtualNodeId = this.semanticsNodeIdToAccessibilityVirtualNodeId(ScrollObservationScope.this.getSemanticsNodeId());
                AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(this, virtualNodeId, 2048, 1, null, 8, null);
                AccessibilityEvent event = this.createEvent$ui_release(virtualNodeId, 4096);
                if (newXState != null) {
                    event.setScrollX((int) newXState.getValue().invoke().floatValue());
                    event.setMaxScrollX((int) newXState.getMaxValue().invoke().floatValue());
                }
                if (newYState != null) {
                    event.setScrollY((int) newYState.getValue().invoke().floatValue());
                    event.setMaxScrollY((int) newYState.getMaxValue().invoke().floatValue());
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    AndroidComposeViewAccessibilityDelegateCompat.Api28Impl.setScrollEventDelta(event, (int) deltaX, (int) deltaY);
                }
                this.sendEvent(event);
                if (newXState != null) {
                    ScrollObservationScope.this.setOldXValue(newXState.getValue().invoke());
                }
                if (newYState != null) {
                    ScrollObservationScope.this.setOldYValue(newYState.getValue().invoke());
                }
            }
        });
    }

    private final void sendPaneChangeEvents(int semanticsNodeId, int contentChangeType, String title) {
        AccessibilityEvent event = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNodeId), 32);
        event.setContentChangeTypes(contentChangeType);
        if (title != null) {
            event.getText().add(title);
        }
        sendEvent(event);
    }

    private final void sendSemanticsStructureChangeEvents(SemanticsNode newNode, SemanticsNodeCopy oldNode) {
        Set newChildren = new LinkedHashSet();
        List $this$fastForEach$iv = newNode.getReplacedChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            SemanticsNode child = (SemanticsNode) item$iv;
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(child.getId()))) {
                if (!oldNode.getChildren().contains(Integer.valueOf(child.getId()))) {
                    notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode());
                    return;
                }
                newChildren.add(Integer.valueOf(child.getId()));
            }
        }
        Iterator<Integer> it = oldNode.getChildren().iterator();
        while (it.hasNext()) {
            if (!newChildren.contains(Integer.valueOf(it.next().intValue()))) {
                notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode());
                return;
            }
        }
        List $this$fastForEach$iv2 = newNode.getReplacedChildren$ui_release();
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
            SemanticsNode child2 = (SemanticsNode) item$iv2;
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(child2.getId()))) {
                SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(Integer.valueOf(child2.getId()));
                Intrinsics.checkNotNull(semanticsNodeCopy);
                sendSemanticsStructureChangeEvents(child2, semanticsNodeCopy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int id) {
        if (id == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            return -1;
        }
        return id;
    }

    private final boolean traverseAtGranularity(SemanticsNode node, int granularity, boolean forward, boolean extendSelection) {
        AccessibilityIterators.TextSegmentIterator iterator;
        int selectionEnd;
        int selectionStart;
        int action;
        int id = node.getId();
        Integer num = this.previousTraversedNode;
        if (num == null || id != num.intValue()) {
            this.accessibilityCursorPosition = -1;
            this.previousTraversedNode = Integer.valueOf(node.getId());
        }
        String text = getIterableTextForAccessibility(node);
        String str = text;
        if ((str == null || str.length() == 0) || (iterator = getIteratorForGranularity(node, granularity)) == null) {
            return false;
        }
        int current = getAccessibilitySelectionEnd(node);
        if (current == -1) {
            current = forward ? 0 : text.length();
        }
        int[] range = forward ? iterator.following(current) : iterator.preceding(current);
        if (range == null) {
            return false;
        }
        int segmentStart = range[0];
        int segmentEnd = range[1];
        if (extendSelection && isAccessibilitySelectionExtendable(node)) {
            int selectionStart2 = getAccessibilitySelectionStart(node);
            if (selectionStart2 == -1) {
                selectionStart2 = forward ? segmentStart : segmentEnd;
            }
            selectionEnd = forward ? segmentEnd : segmentStart;
            selectionStart = selectionStart2;
        } else {
            selectionEnd = forward ? segmentEnd : segmentStart;
            int selectionStart3 = selectionEnd;
            selectionStart = selectionStart3;
        }
        if (forward) {
            action = 256;
        } else {
            action = 512;
        }
        this.pendingTextTraversedEvent = new PendingTextTraversedEvent(node, action, granularity, segmentStart, segmentEnd, SystemClock.uptimeMillis());
        setAccessibilitySelection(node, selectionStart, selectionEnd, true);
        return true;
    }

    private final void sendPendingTextTraversedAtGranularityEvent(int semanticsNodeId) {
        PendingTextTraversedEvent it = this.pendingTextTraversedEvent;
        if (it != null) {
            if (semanticsNodeId != it.getNode().getId()) {
                return;
            }
            if (SystemClock.uptimeMillis() - it.getTraverseTime() <= 1000) {
                AccessibilityEvent event = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(it.getNode().getId()), 131072);
                event.setFromIndex(it.getFromIndex());
                event.setToIndex(it.getToIndex());
                event.setAction(it.getAction());
                event.setMovementGranularity(it.getGranularity());
                event.getText().add(getIterableTextForAccessibility(it.getNode()));
                sendEvent(event);
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    private final boolean setAccessibilitySelection(SemanticsNode node, int start, int end, boolean traversalMode) {
        String text;
        int i;
        boolean enabled;
        if (node.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetSelection())) {
            enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(node);
            if (enabled) {
                Function3 function3 = (Function3) ((AccessibilityAction) node.getUnmergedConfig().get(SemanticsActions.INSTANCE.getSetSelection())).getAction();
                if (function3 != null) {
                    return ((Boolean) function3.invoke(Integer.valueOf(start), Integer.valueOf(end), Boolean.valueOf(traversalMode))).booleanValue();
                }
                return false;
            }
        }
        if ((start == end && end == this.accessibilityCursorPosition) || (text = getIterableTextForAccessibility(node)) == null) {
            return false;
        }
        if (start >= 0 && start == end && end <= text.length()) {
            i = start;
        } else {
            i = -1;
        }
        this.accessibilityCursorPosition = i;
        boolean nonEmptyText = text.length() > 0;
        AccessibilityEvent event = createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(node.getId()), nonEmptyText ? Integer.valueOf(this.accessibilityCursorPosition) : null, nonEmptyText ? Integer.valueOf(this.accessibilityCursorPosition) : null, nonEmptyText ? Integer.valueOf(text.length()) : null, text);
        sendEvent(event);
        sendPendingTextTraversedAtGranularityEvent(node.getId());
        return true;
    }

    private final int getAccessibilitySelectionStart(SemanticsNode node) {
        if (!node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return TextRange.m3957getStartimpl(((TextRange) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue());
        }
        return this.accessibilityCursorPosition;
    }

    private final int getAccessibilitySelectionEnd(SemanticsNode node) {
        if (!node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return TextRange.m3952getEndimpl(((TextRange) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue());
        }
        return this.accessibilityCursorPosition;
    }

    private final boolean isAccessibilitySelectionExtendable(SemanticsNode node) {
        return !node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText());
    }

    private final AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(SemanticsNode node, int granularity) {
        AccessibilityIterators.AbstractTextSegmentIterator iterator;
        if (node == null) {
            return null;
        }
        String text = getIterableTextForAccessibility(node);
        String str = text;
        if (str == null || str.length() == 0) {
            return null;
        }
        switch (granularity) {
            case 1:
                AccessibilityIterators.CharacterTextSegmentIterator.Companion companion = AccessibilityIterators.CharacterTextSegmentIterator.INSTANCE;
                Locale locale = this.view.getContext().getResources().getConfiguration().locale;
                Intrinsics.checkNotNullExpressionValue(locale, "view.context.resources.configuration.locale");
                iterator = companion.getInstance(locale);
                iterator.initialize(text);
                break;
            case 2:
                AccessibilityIterators.WordTextSegmentIterator.Companion companion2 = AccessibilityIterators.WordTextSegmentIterator.INSTANCE;
                Locale locale2 = this.view.getContext().getResources().getConfiguration().locale;
                Intrinsics.checkNotNullExpressionValue(locale2, "view.context.resources.configuration.locale");
                iterator = companion2.getInstance(locale2);
                iterator.initialize(text);
                break;
            case 4:
            case 16:
                if (!node.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                Function1 function1 = (Function1) ((AccessibilityAction) node.getUnmergedConfig().get(SemanticsActions.INSTANCE.getGetTextLayoutResult())).getAction();
                Boolean getLayoutResult = function1 != null ? (Boolean) function1.invoke(arrayList) : null;
                if (!Intrinsics.areEqual((Object) getLayoutResult, (Object) true)) {
                    return null;
                }
                TextLayoutResult textLayoutResult = (TextLayoutResult) arrayList.get(0);
                if (granularity == 4) {
                    AccessibilityIterators.AbstractTextSegmentIterator iterator2 = AccessibilityIterators.LineTextSegmentIterator.INSTANCE.getInstance();
                    ((AccessibilityIterators.LineTextSegmentIterator) iterator2).initialize(text, textLayoutResult);
                    iterator = iterator2;
                    break;
                } else {
                    AccessibilityIterators.AbstractTextSegmentIterator iterator3 = AccessibilityIterators.PageTextSegmentIterator.INSTANCE.getInstance();
                    ((AccessibilityIterators.PageTextSegmentIterator) iterator3).initialize(text, textLayoutResult, node);
                    iterator = iterator3;
                    break;
                }
            case 8:
                iterator = AccessibilityIterators.ParagraphTextSegmentIterator.INSTANCE.getInstance();
                iterator.initialize(text);
                break;
            default:
                return null;
        }
        return iterator;
    }

    private final String getIterableTextForAccessibility(SemanticsNode node) {
        boolean isTextField;
        AnnotatedString annotatedString;
        if (node == null) {
            return null;
        }
        if (!node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription())) {
            isTextField = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(node);
            if (isTextField) {
                AnnotatedString textForTextField = getTextForTextField(node.getUnmergedConfig());
                if (textForTextField != null) {
                    return textForTextField.getText();
                }
                return null;
            }
            List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
            if (list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) == null) {
                return null;
            }
            return annotatedString.getText();
        }
        return TempListUtilsKt.fastJoinToString$default((List) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getContentDescription()), ",", null, null, 0, null, null, 62, null);
    }

    private final AnnotatedString getTextForTextField(SemanticsConfiguration $this$getTextForTextField) {
        return (AnnotatedString) SemanticsConfigurationKt.getOrNull($this$getTextForTextField, SemanticsProperties.INSTANCE.getEditableText());
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(m286d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u0011"}, m287d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$MyNodeProvider;", "Landroid/view/accessibility/AccessibilityNodeProvider;", "(Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;)V", "addExtraDataToAccessibilityNodeInfo", "", "virtualViewId", "", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "arguments", "Landroid/os/Bundle;", "createAccessibilityNodeInfo", "performAction", "", "action", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public final class MyNodeProvider extends AccessibilityNodeProvider {
        public MyNodeProvider() {
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.createNodeInfo(virtualViewId);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.performActionHelper(virtualViewId, action, arguments);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey, Bundle arguments) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(extraDataKey, "extraDataKey");
            AndroidComposeViewAccessibilityDelegateCompat.this.addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, info, extraDataKey, arguments);
        }
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(m286d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, m287d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api24Impl;", "", "()V", "addSetProgressAction", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    private static final class Api24Impl {
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @JvmStatic
        public static final void addSetProgressAction(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            boolean enabled;
            AccessibilityAction it;
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
            enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled && (it = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetProgress())) != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionSetProgress, it.getLabel()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(m286d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¨\u0006\n"}, m287d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api28Impl;", "", "()V", "setScrollEventDelta", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/accessibility/AccessibilityEvent;", "deltaX", "", "deltaY", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    static final class Api28Impl {
        public static final Api28Impl INSTANCE = new Api28Impl();

        private Api28Impl() {
        }

        @JvmStatic
        public static final void setScrollEventDelta(AccessibilityEvent event, int deltaX, int deltaY) {
            Intrinsics.checkNotNullParameter(event, "event");
            event.setScrollDeltaX(deltaX);
            event.setScrollDeltaY(deltaY);
        }
    }
}
