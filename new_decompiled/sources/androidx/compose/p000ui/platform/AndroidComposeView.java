package androidx.compose.p000ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.autofill.AndroidAutofill;
import androidx.compose.p000ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.p000ui.autofill.Autofill;
import androidx.compose.p000ui.autofill.AutofillCallback;
import androidx.compose.p000ui.autofill.AutofillTree;
import androidx.compose.p000ui.focus.FocusDirection;
import androidx.compose.p000ui.focus.FocusManager;
import androidx.compose.p000ui.focus.FocusManagerImpl;
import androidx.compose.p000ui.focus.FocusModifier;
import androidx.compose.p000ui.focus.FocusTraversalKt;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.graphics.CanvasHolder;
import androidx.compose.p000ui.graphics.Matrix;
import androidx.compose.p000ui.hapticfeedback.HapticFeedback;
import androidx.compose.p000ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.p000ui.input.InputMode;
import androidx.compose.p000ui.input.InputModeManager;
import androidx.compose.p000ui.input.InputModeManagerImpl;
import androidx.compose.p000ui.input.key.Key;
import androidx.compose.p000ui.input.key.KeyEvent;
import androidx.compose.p000ui.input.key.KeyEventType;
import androidx.compose.p000ui.input.key.KeyEvent_androidKt;
import androidx.compose.p000ui.input.key.KeyInputModifier;
import androidx.compose.p000ui.input.pointer.MotionEventAdapter;
import androidx.compose.p000ui.input.pointer.PointerIcon;
import androidx.compose.p000ui.input.pointer.PointerIconDefaults;
import androidx.compose.p000ui.input.pointer.PointerIconService;
import androidx.compose.p000ui.input.pointer.PointerInputEvent;
import androidx.compose.p000ui.input.pointer.PointerInputEventData;
import androidx.compose.p000ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.p000ui.input.pointer.PointerInputEventProcessorKt;
import androidx.compose.p000ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.p000ui.input.pointer.PositionCalculator;
import androidx.compose.p000ui.input.pointer.ProcessResult;
import androidx.compose.p000ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.p000ui.input.rotary.RotaryScrollEvent;
import androidx.compose.p000ui.layout.RootMeasurePolicy;
import androidx.compose.p000ui.modifier.ModifierLocalManager;
import androidx.compose.p000ui.node.LayoutNode;
import androidx.compose.p000ui.node.LayoutNodeDrawScope;
import androidx.compose.p000ui.node.MeasureAndLayoutDelegate;
import androidx.compose.p000ui.node.OwnedLayer;
import androidx.compose.p000ui.node.Owner;
import androidx.compose.p000ui.node.OwnerSnapshotObserver;
import androidx.compose.p000ui.node.RootForTest;
import androidx.compose.p000ui.node.SemanticsModifierNode;
import androidx.compose.p000ui.semantics.SemanticsModifierCore;
import androidx.compose.p000ui.semantics.SemanticsNode;
import androidx.compose.p000ui.semantics.SemanticsNodeKt;
import androidx.compose.p000ui.semantics.SemanticsOwner;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.text.font.Font;
import androidx.compose.p000ui.text.font.FontFamily;
import androidx.compose.p000ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.p000ui.text.input.TextInputService;
import androidx.compose.p000ui.text.input.TextInputServiceAndroid;
import androidx.compose.p000ui.unit.AndroidDensity_androidKt;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.IntOffsetKt;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.p000ui.viewinterop.AndroidViewHolder;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.core.app.NotificationCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.primitives.Ints;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.math.MathKt;

/* compiled from: AndroidComposeView.android.kt */
@Metadata(m286d1 = {"\u0000Ê\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0018*\u0002\u009b\u0001\b\u0001\u0018\u0000 \u0081\u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004\u0081\u0003\u0082\u0003B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010ë\u0001\u001a\u00020-2\b\u0010Î\u0001\u001a\u00030ì\u00012\b\u0010í\u0001\u001a\u00030\u009e\u0001J\u0019\u0010\u001c\u001a\u00020-2\u000f\u0010î\u0001\u001a\n\u0012\u0005\u0012\u00030ð\u00010ï\u0001H\u0016J\t\u0010ñ\u0001\u001a\u00020TH\u0002J\u0013\u0010ò\u0001\u001a\u00020-H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010ó\u0001J!\u0010ô\u0001\u001a\u00020m2\u0007\u0010õ\u0001\u001a\u00020mH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bö\u0001\u0010÷\u0001J!\u0010ø\u0001\u001a\u00020m2\u0007\u0010ù\u0001\u001a\u00020mH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bú\u0001\u0010÷\u0001J\u0012\u0010û\u0001\u001a\u00020T2\u0007\u0010ü\u0001\u001a\u000203H\u0016J\u0012\u0010ý\u0001\u001a\u00020T2\u0007\u0010ü\u0001\u001a\u000203H\u0016J\u0012\u0010þ\u0001\u001a\u00020-2\u0007\u0010ÿ\u0001\u001a\u00020\u0001H\u0002J\u001f\u0010\u0080\u0002\u001a\u000f\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u0002030\u0081\u00022\u0007\u0010\u0082\u0002\u001a\u000203H\u0002J.\u0010\u0083\u0002\u001a\u00020=2\u0014\u0010\u0084\u0002\u001a\u000f\u0012\u0005\u0012\u00030\u0085\u0002\u0012\u0004\u0012\u00020-0+2\r\u0010\u0086\u0002\u001a\b\u0012\u0004\u0012\u00020-0@H\u0016J\u0013\u0010\u0087\u0002\u001a\u00020-2\b\u0010\u0088\u0002\u001a\u00030\u0089\u0002H\u0014J\u0013\u0010\u008a\u0002\u001a\u00020T2\b\u0010\u008b\u0002\u001a\u00030\u0097\u0001H\u0016J\u0013\u0010\u008c\u0002\u001a\u00020T2\b\u0010\u008b\u0002\u001a\u00030\u0097\u0001H\u0016J\u0013\u0010\u008d\u0002\u001a\u00020T2\b\u0010\u008b\u0002\u001a\u00030\u008e\u0002H\u0016J\u0013\u0010\u008f\u0002\u001a\u00020T2\b\u0010\u0090\u0002\u001a\u00030\u0097\u0001H\u0016J\u001b\u0010\u0091\u0002\u001a\u00020-2\b\u0010Î\u0001\u001a\u00030ì\u00012\b\u0010\u0088\u0002\u001a\u00030\u0089\u0002J\u001f\u0010\u0092\u0002\u001a\u0005\u0018\u00010Ï\u00012\u0007\u0010\u0093\u0002\u001a\u0002032\b\u0010\u0094\u0002\u001a\u00030Ï\u0001H\u0002J\u0013\u0010\u0095\u0002\u001a\u0005\u0018\u00010Ï\u00012\u0007\u0010\u0093\u0002\u001a\u000203J\u0013\u0010\u0096\u0002\u001a\u00020-2\b\u0010í\u0001\u001a\u00030\u009e\u0001H\u0016J%\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0098\u00022\b\u0010\u0099\u0002\u001a\u00030\u009a\u0002H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u009b\u0002\u0010\u009c\u0002J\u0013\u0010\u009d\u0002\u001a\u00020-2\b\u0010\u009e\u0002\u001a\u00030\u009f\u0002H\u0016J&\u0010 \u0002\u001a\u00030¡\u00022\b\u0010\u0090\u0002\u001a\u00030\u0097\u0001H\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¢\u0002\u0010£\u0002J\u0013\u0010¤\u0002\u001a\u00020T2\b\u0010\u008b\u0002\u001a\u00030\u0097\u0001H\u0002J\u001d\u0010¥\u0002\u001a\u00020T2\b\u0010\u008b\u0002\u001a\u00030\u0097\u00012\b\u0010¦\u0002\u001a\u00030\u0097\u0001H\u0002J\t\u0010§\u0002\u001a\u00020-H\u0016J\u0013\u0010¨\u0002\u001a\u00020-2\b\u0010©\u0002\u001a\u00030\u009e\u0001H\u0002J\u0013\u0010ª\u0002\u001a\u00020-2\b\u0010©\u0002\u001a\u00030\u009e\u0001H\u0002J\u0013\u0010«\u0002\u001a\u00020T2\b\u0010\u008b\u0002\u001a\u00030\u0097\u0001H\u0002J\u0013\u0010¬\u0002\u001a\u00020T2\b\u0010\u008b\u0002\u001a\u00030\u0097\u0001H\u0002J\u0013\u0010\u00ad\u0002\u001a\u00020T2\b\u0010\u0090\u0002\u001a\u00030\u0097\u0001H\u0002J\u0013\u0010®\u0002\u001a\u00020T2\b\u0010\u008b\u0002\u001a\u00030\u0097\u0001H\u0002J\u0013\u0010¯\u0002\u001a\u00020-H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010ó\u0001J!\u0010°\u0002\u001a\u00020m2\u0007\u0010ù\u0001\u001a\u00020mH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b±\u0002\u0010÷\u0001J,\u0010²\u0002\u001a\u00020-2\b\u0010í\u0001\u001a\u00030\u009e\u00012\b\u0010³\u0002\u001a\u00030\u008c\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b´\u0002\u0010µ\u0002J\u0012\u0010²\u0002\u001a\u00020-2\u0007\u0010¶\u0002\u001a\u00020TH\u0016J!\u0010·\u0002\u001a\u00020-2\u0007\u0010¸\u0002\u001a\u00020=2\u0007\u0010¹\u0002\u001a\u00020TH\u0000¢\u0006\u0003\bº\u0002J\u0013\u0010»\u0002\u001a\u00020-2\b\u0010©\u0002\u001a\u00030\u009e\u0001H\u0016J\t\u0010¼\u0002\u001a\u00020-H\u0014J\t\u0010½\u0002\u001a\u00020TH\u0016J\u0012\u0010¾\u0002\u001a\u00020-2\u0007\u0010¿\u0002\u001a\u00020,H\u0014J\u0016\u0010À\u0002\u001a\u0005\u0018\u00010Á\u00022\b\u0010Â\u0002\u001a\u00030Ã\u0002H\u0016J\u0013\u0010Ä\u0002\u001a\u00020-2\b\u0010©\u0002\u001a\u00030\u009e\u0001H\u0016J\t\u0010Å\u0002\u001a\u00020-H\u0014J\u0013\u0010Æ\u0002\u001a\u00020-2\b\u0010\u0088\u0002\u001a\u00030\u0089\u0002H\u0014J\t\u0010Ç\u0002\u001a\u00020-H\u0016J'\u0010È\u0002\u001a\u00020-2\u0007\u0010É\u0002\u001a\u00020T2\u0007\u0010ü\u0001\u001a\u0002032\n\u0010Ê\u0002\u001a\u0005\u0018\u00010\u009f\u0002H\u0014J6\u0010Ë\u0002\u001a\u00020-2\u0007\u0010Ì\u0002\u001a\u00020T2\u0007\u0010Í\u0002\u001a\u0002032\u0007\u0010Î\u0002\u001a\u0002032\u0007\u0010Ï\u0002\u001a\u0002032\u0007\u0010Ð\u0002\u001a\u000203H\u0014J\u0013\u0010Ñ\u0002\u001a\u00020-2\b\u0010í\u0001\u001a\u00030\u009e\u0001H\u0016J\u001b\u0010Ò\u0002\u001a\u00020-2\u0007\u0010Ó\u0002\u001a\u0002032\u0007\u0010Ô\u0002\u001a\u000203H\u0014J\u001e\u0010Õ\u0002\u001a\u00020-2\n\u0010Ö\u0002\u001a\u0005\u0018\u00010×\u00022\u0007\u0010Ø\u0002\u001a\u000203H\u0016J%\u0010Ù\u0002\u001a\u00020-2\b\u0010í\u0001\u001a\u00030\u009e\u00012\u0007\u0010Ú\u0002\u001a\u00020T2\u0007\u0010Û\u0002\u001a\u00020TH\u0016J%\u0010Ü\u0002\u001a\u00020-2\b\u0010í\u0001\u001a\u00030\u009e\u00012\u0007\u0010Ú\u0002\u001a\u00020T2\u0007\u0010Û\u0002\u001a\u00020TH\u0016J\u0013\u0010Ý\u0002\u001a\u00020-2\b\u0010Þ\u0002\u001a\u00030ß\u0002H\u0016J\u0011\u0010à\u0002\u001a\u00020-2\u0006\u0010x\u001a\u000203H\u0016J\t\u0010á\u0002\u001a\u00020-H\u0016J\u0012\u0010â\u0002\u001a\u00020-2\u0007\u0010ã\u0002\u001a\u00020TH\u0016J\t\u0010ä\u0002\u001a\u00020-H\u0002J\u0013\u0010ä\u0002\u001a\u00020-2\b\u0010\u0090\u0002\u001a\u00030\u0097\u0001H\u0002J\t\u0010å\u0002\u001a\u00020-H\u0002J\u0018\u0010æ\u0002\u001a\u00020T2\u0007\u0010¸\u0002\u001a\u00020=H\u0000¢\u0006\u0003\bç\u0002J\u0018\u0010è\u0002\u001a\u00020-2\r\u0010é\u0002\u001a\b\u0012\u0004\u0012\u00020-0@H\u0016J\u0013\u0010ê\u0002\u001a\u00020-2\b\u0010é\u0002\u001a\u00030ë\u0002H\u0016J\u0011\u0010ì\u0002\u001a\u00020-2\b\u0010Î\u0001\u001a\u00030ì\u0001J\u0007\u0010í\u0002\u001a\u00020-J\u0013\u0010î\u0002\u001a\u00020-2\b\u0010í\u0001\u001a\u00030\u009e\u0001H\u0016J\u0017\u0010ï\u0002\u001a\u00020-2\f\b\u0002\u0010ð\u0002\u001a\u0005\u0018\u00010\u009e\u0001H\u0002J!\u0010ñ\u0002\u001a\u00020m2\u0007\u0010ò\u0002\u001a\u00020mH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bó\u0002\u0010÷\u0001J\"\u0010ô\u0002\u001a\u00020T2\b\u0010\u0099\u0002\u001a\u00030\u009a\u0002H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bõ\u0002\u0010ö\u0002J&\u0010÷\u0002\u001a\u00030¡\u00022\b\u0010\u0090\u0002\u001a\u00030\u0097\u0001H\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bø\u0002\u0010£\u0002J0\u0010ù\u0002\u001a\u00020-2\b\u0010\u0090\u0002\u001a\u00030\u0097\u00012\u0007\u0010ú\u0002\u001a\u0002032\u0007\u0010û\u0002\u001a\u00020o2\t\b\u0002\u0010ü\u0002\u001a\u00020TH\u0002J\u001d\u0010ý\u0002\u001a\u00020-2\u0014\u0010þ\u0002\u001a\u000f\u0012\u0005\u0012\u00030\u008e\u0001\u0012\u0004\u0012\u00020-0+J\t\u0010ÿ\u0002\u001a\u00020TH\u0016J\t\u0010\u0080\u0003\u001a\u00020-H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020'X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R&\u0010*\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00106\u001a\u0002052\u0006\u00104\u001a\u000205@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010>\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020-\u0018\u00010@0?X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\u00020B8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR+\u0010F\u001a\u00020E2\u0006\u00104\u001a\u00020E8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010M\u001a\u00020N8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u000e\u0010S\u001a\u00020TX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010W\u001a\u00020XX\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010YR\u0014\u0010Z\u001a\u00020[X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0014\u0010^\u001a\u00020T8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u000e\u0010a\u001a\u00020TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010b\u001a\u00020c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR\u000e\u0010f\u001a\u00020TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010g\u001a\u00020T8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bg\u0010`R\u000e\u0010h\u001a\u00020TX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020jX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010l\u001a\u00020mX\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010YR$\u0010n\u001a\u00020o8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bp\u0010P\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u0014\u0010u\u001a\b\u0012\u0004\u0012\u00020=0vX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010x\u001a\u00020w2\u0006\u00104\u001a\u00020w8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b}\u0010L\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u000e\u0010~\u001a\u00020\u007fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0080\u0001\u001a\u00030\u0081\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0082\u0001\u001a\u00020o8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010rR\u0018\u0010\u0084\u0001\u001a\u00030\u0085\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0010\u0010\u0088\u0001\u001a\u00030\u0089\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u008a\u0001\u001a\u00020TX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u001e\u0010\u008d\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u008e\u0001\u0012\u0004\u0012\u00020-\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0010\u0010\u0093\u0001\u001a\u00030\u0094\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0095\u0001\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0098\u0001\u001a\u00020oX\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020-0@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u009a\u0001\u001a\u00030\u009b\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009c\u0001R\u0018\u0010\u009d\u0001\u001a\u00030\u009e\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u0018\u0010¡\u0001\u001a\u00030¢\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b£\u0001\u0010¤\u0001R\u0010\u0010¥\u0001\u001a\u00030¦\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010§\u0001\u001a\u00030¨\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010©\u0001\u001a\u00030ª\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010«\u0001\u001a\u00030¬\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u00ad\u0001\u0010®\u0001R\u0010\u0010¯\u0001\u001a\u00030°\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010±\u0001\u001a\u00030²\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b³\u0001\u0010´\u0001R%\u0010µ\u0001\u001a\u00020TX\u0096\u000e¢\u0006\u0018\n\u0000\u0012\u0005\b¶\u0001\u0010P\u001a\u0005\b·\u0001\u0010`\"\u0006\b¸\u0001\u0010¹\u0001R\u0018\u0010º\u0001\u001a\u00030»\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b¼\u0001\u0010½\u0001R\u000f\u0010¾\u0001\u001a\u00020TX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010¿\u0001\u001a\u00030À\u0001X\u0096\u0004¢\u0006\u0011\n\u0000\u0012\u0005\bÁ\u0001\u0010P\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u0010\u0010Ä\u0001\u001a\u00030Å\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Æ\u0001\u001a\u00030Ç\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÈ\u0001\u0010É\u0001R\u0010\u0010Ê\u0001\u001a\u00030Ë\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ì\u0001\u001a\u00030Í\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Î\u0001\u001a\u00030Ï\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÐ\u0001\u0010Ñ\u0001R\u0018\u0010Ò\u0001\u001a\u00030Ó\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÔ\u0001\u0010Õ\u0001R\u0012\u0010Ö\u0001\u001a\u0005\u0018\u00010×\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010Ø\u0001\u001a\u00030Ù\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0005\n\u0003\u0010Ú\u0001R7\u0010Û\u0001\u001a\u0005\u0018\u00010\u008e\u00012\t\u00104\u001a\u0005\u0018\u00010\u008e\u00018F@BX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\bà\u0001\u0010L\u001a\u0006\bÜ\u0001\u0010Ý\u0001\"\u0006\bÞ\u0001\u0010ß\u0001R\u000f\u0010á\u0001\u001a\u00020TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010â\u0001\u001a\u00030ã\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bä\u0001\u0010å\u0001R\u001a\u0010æ\u0001\u001a\u00020mX\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010YR\u001c\u0010ç\u0001\u001a\u00030Ù\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0005\n\u0003\u0010Ú\u0001R\u001b\u0010è\u0001\u001a\u000203*\u00020,8BX\u0082\u0004¢\u0006\b\u001a\u0006\bé\u0001\u0010ê\u0001\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0083\u0003"}, m287d2 = {"Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/ViewGroup;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_androidViewsHandler", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "_autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "_focusManager", "Landroidx/compose/ui/focus/FocusManagerImpl;", "_inputModeManager", "Landroidx/compose/ui/input/InputModeManagerImpl;", "_windowInfo", "Landroidx/compose/ui/platform/WindowInfoImpl;", "accessibilityDelegate", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "accessibilityManager", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "androidViewsHandler", "getAndroidViewsHandler$ui_release", "()Landroidx/compose/ui/platform/AndroidViewsHandler;", "autofill", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/AndroidClipboardManager;", "configurationChangeObserver", "Lkotlin/Function1;", "Landroid/content/res/Configuration;", "", "getConfigurationChangeObserver", "()Lkotlin/jvm/functions/Function1;", "setConfigurationChangeObserver", "(Lkotlin/jvm/functions/Function1;)V", "currentFontWeightAdjustment", "", "<set-?>", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "desiredPointerIcon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "dirtyLayers", "", "Landroidx/compose/ui/node/OwnedLayer;", "endApplyChangesListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function0;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "getFocusManager", "()Landroidx/compose/ui/focus/FocusManager;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "fontFamilyResolver$delegate", "Landroidx/compose/runtime/MutableState;", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader$annotations", "()V", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "forceUseMatrixCache", "", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "hoverExitReceived", "inputModeManager", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "isDrawingContent", "isLifecycleInResumedState", "isRenderNodeCompatible", "keyInputModifier", "Landroidx/compose/ui/input/key/KeyInputModifier;", "keyboardModifiersRequireUpdate", "lastDownPointerPosition", "Landroidx/compose/ui/geometry/Offset;", "lastMatrixRecalculationAnimationTime", "", "getLastMatrixRecalculationAnimationTime$ui_release$annotations", "getLastMatrixRecalculationAnimationTime$ui_release", "()J", "setLastMatrixRecalculationAnimationTime$ui_release", "(J)V", "layerCache", "Landroidx/compose/ui/platform/WeakCache;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "matrixToWindow", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "measureAndLayoutDelegate", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "measureIteration", "getMeasureIteration", "modifierLocalManager", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "getModifierLocalManager", "()Landroidx/compose/ui/modifier/ModifierLocalManager;", "motionEventAdapter", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "observationClearRequested", "onMeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "onViewTreeOwnersAvailable", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "pointerInputEventProcessor", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "postponedDirtyLayers", "previousMotionEvent", "Landroid/view/MotionEvent;", "relayoutTime", "resendMotionEventOnLayout", "resendMotionEventRunnable", "androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "Landroidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1;", "root", "Landroidx/compose/ui/node/LayoutNode;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "rotaryInputModifier", "Landroidx/compose/ui/Modifier;", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "semanticsModifier", "Landroidx/compose/ui/semantics/SemanticsModifierCore;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "sendHoverExitEvent", "Ljava/lang/Runnable;", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "superclassInitComplete", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService$annotations", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "textInputServiceAndroid", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "tmpPositionArray", "", "touchModeChangeListener", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "viewLayersContainer", "Landroidx/compose/ui/platform/DrawChildContainer;", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "viewTreeOwners", "getViewTreeOwners", "()Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "setViewTreeOwners", "(Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;)V", "viewTreeOwners$delegate", "wasMeasuredWithMultipleConstraints", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "windowPosition", "windowToViewMatrix", "fontWeightAdjustmentCompat", "getFontWeightAdjustmentCompat", "(Landroid/content/res/Configuration;)I", "addAndroidView", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "layoutNode", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "autofillSupported", "boundsUpdatesEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateLocalPosition", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "(J)J", "calculatePositionInWindow", "localPosition", "calculatePositionInWindow-MK-Hz9U", "canScrollHorizontally", "direction", "canScrollVertically", "clearChildInvalidObservations", "viewGroup", "convertMeasureSpec", "Lkotlin/Pair;", "measureSpec", "createLayer", "drawBlock", "Landroidx/compose/ui/graphics/Canvas;", "invalidateParentLayer", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchGenericMotionEvent", NotificationCompat.CATEGORY_EVENT, "dispatchHoverEvent", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "motionEvent", "drawAndroidView", "findViewByAccessibilityIdRootedAtCurrentView", "accessibilityId", "currentView", "findViewByAccessibilityIdTraversal", "forceMeasureTheSubtree", "getFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "getFocusDirection-P8AzH3I", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "getFocusedRect", "rect", "Landroid/graphics/Rect;", "handleMotionEvent", "Landroidx/compose/ui/input/pointer/ProcessResult;", "handleMotionEvent-8iAsVTc", "(Landroid/view/MotionEvent;)I", "handleRotaryEvent", "hasChangedDevices", "lastEvent", "invalidateDescendants", "invalidateLayers", "node", "invalidateLayoutNodeMeasurement", "isBadMotionEvent", "isDevicePressEvent", "isInBounds", "isPositionChanged", "keyboardVisibilityEventLoop", "localToScreen", "localToScreen-MK-Hz9U", "measureAndLayout", "constraints", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "sendPointerUpdate", "notifyLayerIsDirty", "layer", "isDirty", "notifyLayerIsDirty$ui_release", "onAttach", "onAttachedToWindow", "onCheckIsTextEditor", "onConfigurationChanged", "newConfig", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onDetach", "onDetachedFromWindow", "onDraw", "onEndApplyChanges", "onFocusChanged", "gainFocus", "previouslyFocusedRect", "onLayout", "changed", "l", "t", "r", "b", "onLayoutChange", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onProvideAutofillVirtualStructure", "structure", "Landroid/view/ViewStructure;", "flags", "onRequestMeasure", "affectsLookahead", "forceRequest", "onRequestRelayout", "onResume", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onRtlPropertiesChanged", "onSemanticsChange", "onWindowFocusChanged", "hasWindowFocus", "recalculateWindowPosition", "recalculateWindowViewTransforms", "recycle", "recycle$ui_release", "registerOnEndApplyChangesListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "registerOnLayoutCompletedListener", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "removeAndroidView", "requestClearInvalidObservations", "requestOnPositionedCallback", "scheduleMeasureAndLayout", "nodeToRemeasure", "screenToLocal", "positionOnScreen", "screenToLocal-MK-Hz9U", "sendKeyEvent", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "sendMotionEvent", "sendMotionEvent-8iAsVTc", "sendSimulatedEvent", "action", "eventTime", "forceHover", "setOnViewTreeOwnersAvailable", "callback", "shouldDelayChildPressedState", "updatePositionCacheAndDispatch", "Companion", "ViewTreeOwners", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AndroidComposeView extends ViewGroup implements Owner, ViewRootForTest, PositionCalculator, DefaultLifecycleObserver {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String FocusTag = "Compose Focus";
    private static final int MaximumLayerCacheSize = 10;
    private static Method getBooleanMethod;
    private static Class<?> systemPropertiesClass;
    private AndroidViewsHandler _androidViewsHandler;
    private final AndroidAutofill _autofill;
    private final FocusManagerImpl _focusManager;
    private final InputModeManagerImpl _inputModeManager;
    private final WindowInfoImpl _windowInfo;
    private final AndroidComposeViewAccessibilityDelegateCompat accessibilityDelegate;
    private final AndroidAccessibilityManager accessibilityManager;
    private final AutofillTree autofillTree;
    private final CanvasHolder canvasHolder;
    private final AndroidClipboardManager clipboardManager;
    private Function1<? super Configuration, Unit> configurationChangeObserver;
    private int currentFontWeightAdjustment;
    private Density density;
    private PointerIcon desiredPointerIcon;
    private final List<OwnedLayer> dirtyLayers;
    private final MutableVector<Function0<Unit>> endApplyChangesListeners;

    /* renamed from: fontFamilyResolver$delegate, reason: from kotlin metadata */
    private final MutableState fontFamilyResolver;
    private final Font.ResourceLoader fontLoader;
    private boolean forceUseMatrixCache;
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private long globalPosition;
    private final HapticFeedback hapticFeedBack;
    private boolean hoverExitReceived;
    private boolean isDrawingContent;
    private boolean isRenderNodeCompatible;
    private final KeyInputModifier keyInputModifier;
    private boolean keyboardModifiersRequireUpdate;
    private long lastDownPointerPosition;
    private long lastMatrixRecalculationAnimationTime;
    private final WeakCache<OwnedLayer> layerCache;

    /* renamed from: layoutDirection$delegate, reason: from kotlin metadata */
    private final MutableState layoutDirection;
    private final CalculateMatrixToWindow matrixToWindow;
    private final MeasureAndLayoutDelegate measureAndLayoutDelegate;
    private final ModifierLocalManager modifierLocalManager;
    private final MotionEventAdapter motionEventAdapter;
    private boolean observationClearRequested;
    private Constraints onMeasureConstraints;
    private Function1<? super ViewTreeOwners, Unit> onViewTreeOwnersAvailable;
    private final PointerIconService pointerIconService;
    private final PointerInputEventProcessor pointerInputEventProcessor;
    private List<OwnedLayer> postponedDirtyLayers;
    private MotionEvent previousMotionEvent;
    private long relayoutTime;
    private final Function0<Unit> resendMotionEventOnLayout;
    private final AndroidComposeView$resendMotionEventRunnable$1 resendMotionEventRunnable;
    private final LayoutNode root;
    private final RootForTest rootForTest;
    private final Modifier rotaryInputModifier;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final SemanticsModifierCore semanticsModifier;
    private final SemanticsOwner semanticsOwner;
    private final Runnable sendHoverExitEvent;
    private final LayoutNodeDrawScope sharedDrawScope;
    private boolean showLayoutBounds;
    private final OwnerSnapshotObserver snapshotObserver;
    private boolean superclassInitComplete;
    private final TextInputService textInputService;
    private final TextInputServiceAndroid textInputServiceAndroid;
    private final TextToolbar textToolbar;
    private final int[] tmpPositionArray;
    private final ViewTreeObserver.OnTouchModeChangeListener touchModeChangeListener;
    private final ViewConfiguration viewConfiguration;
    private DrawChildContainer viewLayersContainer;
    private final float[] viewToWindowMatrix;

    /* renamed from: viewTreeOwners$delegate, reason: from kotlin metadata */
    private final MutableState viewTreeOwners;
    private boolean wasMeasuredWithMultipleConstraints;
    private long windowPosition;
    private final float[] windowToViewMatrix;

    @Deprecated(message = "fontLoader is deprecated, use fontFamilyResolver", replaceWith = @ReplaceWith(expression = "fontFamilyResolver", imports = {}))
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    public static /* synthetic */ void getTextInputService$annotations() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v46, types: [androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1] */
    public AndroidComposeView(Context context) {
        super(context);
        CalculateMatrixToWindowApi21 calculateMatrixToWindowApi21;
        Intrinsics.checkNotNullParameter(context, "context");
        this.lastDownPointerPosition = Offset.INSTANCE.m1775getUnspecifiedF1C5BW0();
        int i = 1;
        this.superclassInitComplete = true;
        this.sharedDrawScope = new LayoutNodeDrawScope(null, i, 0 == true ? 1 : 0);
        this.density = AndroidDensity_androidKt.Density(context);
        this.semanticsModifier = new SemanticsModifierCore(false, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$semanticsModifier$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver $receiver) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
            }
        }, null, 8, null);
        this._focusManager = new FocusManagerImpl(0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        this._windowInfo = new WindowInfoImpl();
        this.keyInputModifier = new KeyInputModifier(new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m3750invokeZmokQxo(keyEvent.m3219unboximpl());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m3750invokeZmokQxo(android.view.KeyEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                FocusDirection focusDirection = AndroidComposeView.this.mo3723getFocusDirectionP8AzH3I(it);
                if (focusDirection == null || !KeyEventType.m3223equalsimpl0(KeyEvent_androidKt.m3231getTypeZmokQxo(it), KeyEventType.INSTANCE.m3227getKeyDownCS__XNY())) {
                    return false;
                }
                return Boolean.valueOf(AndroidComposeView.this.getFocusManager().mo1703moveFocus3ESFkO8(focusDirection.getValue()));
            }
        }, null);
        this.rotaryInputModifier = RotaryInputModifierKt.onRotaryScrollEvent(Modifier.INSTANCE, new Function1<RotaryScrollEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$rotaryInputModifier$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(RotaryScrollEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return false;
            }
        });
        this.canvasHolder = new CanvasHolder();
        LayoutNode layoutNode = new LayoutNode(false, 0, 3, null);
        layoutNode.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        layoutNode.setDensity(getDensity());
        layoutNode.setModifier(Modifier.INSTANCE.then(this.semanticsModifier).then(this.rotaryInputModifier).then(this._focusManager.getModifier()).then(this.keyInputModifier));
        this.root = layoutNode;
        this.rootForTest = this;
        this.semanticsOwner = new SemanticsOwner(getRoot());
        this.accessibilityDelegate = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.autofillTree = new AutofillTree();
        this.dirtyLayers = new ArrayList();
        this.motionEventAdapter = new MotionEventAdapter();
        this.pointerInputEventProcessor = new PointerInputEventProcessor(getRoot());
        this.configurationChangeObserver = new Function1<Configuration, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$configurationChangeObserver$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Configuration configuration) {
                invoke2(configuration);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Configuration it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }
        };
        this._autofill = autofillSupported() ? new AndroidAutofill(this, getAutofillTree()) : null;
        this.clipboardManager = new AndroidClipboardManager(context);
        this.accessibilityManager = new AndroidAccessibilityManager(context);
        this.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(this));
        this.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(getRoot());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        Intrinsics.checkNotNullExpressionValue(viewConfiguration, "get(context)");
        this.viewConfiguration = new AndroidViewConfiguration(viewConfiguration);
        this.globalPosition = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.tmpPositionArray = new int[]{0, 0};
        this.viewToWindowMatrix = Matrix.m2190constructorimpl$default(null, 1, null);
        this.windowToViewMatrix = Matrix.m2190constructorimpl$default(null, 1, null);
        this.lastMatrixRecalculationAnimationTime = -1L;
        this.windowPosition = Offset.INSTANCE.m1774getInfiniteF1C5BW0();
        this.isRenderNodeCompatible = true;
        this.viewTreeOwners = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                AndroidComposeView.m3743globalLayoutListener$lambda1(AndroidComposeView.this);
            }
        };
        this.scrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                AndroidComposeView.m3745scrollChangedListener$lambda2(AndroidComposeView.this);
            }
        };
        this.touchModeChangeListener = new ViewTreeObserver.OnTouchModeChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
            public final void onTouchModeChanged(boolean z) {
                AndroidComposeView.m3748touchModeChangeListener$lambda3(AndroidComposeView.this, z);
            }
        };
        this.textInputServiceAndroid = new TextInputServiceAndroid(this);
        this.textInputService = AndroidComposeView_androidKt.getTextInputServiceFactory().invoke(this.textInputServiceAndroid);
        this.fontLoader = new AndroidFontResourceLoader(context);
        this.fontFamilyResolver = SnapshotStateKt.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(context), SnapshotStateKt.referentialEqualityPolicy());
        Configuration configuration = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "context.resources.configuration");
        this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(configuration);
        Configuration configuration2 = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration2, "context.resources.configuration");
        this.layoutDirection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AndroidComposeView_androidKt.getLocaleLayoutDirection(configuration2), null, 2, null);
        this.hapticFeedBack = new PlatformHapticFeedback(this);
        this._inputModeManager = new InputModeManagerImpl(isInTouchMode() ? InputMode.INSTANCE.m2628getTouchaOaMEAU() : InputMode.INSTANCE.m2627getKeyboardaOaMEAU(), new Function1<InputMode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$_inputModeManager$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(InputMode inputMode) {
                return m3749invokeiuPiT84(inputMode.getValue());
            }

            /* renamed from: invoke-iuPiT84, reason: not valid java name */
            public final Boolean m3749invokeiuPiT84(int it) {
                boolean z;
                if (InputMode.m2623equalsimpl0(it, InputMode.INSTANCE.m2628getTouchaOaMEAU())) {
                    z = AndroidComposeView.this.isInTouchMode();
                } else if (InputMode.m2623equalsimpl0(it, InputMode.INSTANCE.m2627getKeyboardaOaMEAU())) {
                    z = AndroidComposeView.this.isInTouchMode() ? AndroidComposeView.this.requestFocusFromTouch() : true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }, null);
        this.modifierLocalManager = new ModifierLocalManager(this);
        this.textToolbar = new AndroidTextToolbar(this);
        this.layerCache = new WeakCache<>();
        this.endApplyChangesListeners = new MutableVector<>(new Function0[16], 0);
        this.resendMotionEventRunnable = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                MotionEvent lastMotionEvent;
                int newAction;
                long j;
                AndroidComposeView.this.removeCallbacks(this);
                lastMotionEvent = AndroidComposeView.this.previousMotionEvent;
                if (lastMotionEvent != null) {
                    boolean z = false;
                    boolean wasMouseEvent = lastMotionEvent.getToolType(0) == 3;
                    int action = lastMotionEvent.getActionMasked();
                    if (wasMouseEvent) {
                        if (action != 10 && action != 1) {
                            z = true;
                        }
                    } else if (action != 1) {
                        z = true;
                    }
                    boolean resend = z;
                    if (resend) {
                        switch (action) {
                            case 7:
                            case 9:
                                newAction = 7;
                                break;
                            case 8:
                            default:
                                newAction = 2;
                                break;
                        }
                        AndroidComposeView androidComposeView = AndroidComposeView.this;
                        j = AndroidComposeView.this.relayoutTime;
                        androidComposeView.sendSimulatedEvent(lastMotionEvent, newAction, j, false);
                    }
                }
            }
        };
        this.sendHoverExitEvent = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeView.m3746sendHoverExitEvent$lambda5(AndroidComposeView.this);
            }
        };
        this.resendMotionEventOnLayout = new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventOnLayout$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MotionEvent lastEvent;
                AndroidComposeView$resendMotionEventRunnable$1 androidComposeView$resendMotionEventRunnable$1;
                lastEvent = AndroidComposeView.this.previousMotionEvent;
                if (lastEvent != null) {
                    switch (lastEvent.getActionMasked()) {
                        case 7:
                        case 9:
                            AndroidComposeView.this.relayoutTime = SystemClock.uptimeMillis();
                            AndroidComposeView androidComposeView = AndroidComposeView.this;
                            androidComposeView$resendMotionEventRunnable$1 = AndroidComposeView.this.resendMotionEventRunnable;
                            androidComposeView.post(androidComposeView$resendMotionEventRunnable$1);
                            break;
                    }
                }
            }
        };
        if (Build.VERSION.SDK_INT >= 29) {
            calculateMatrixToWindowApi21 = new CalculateMatrixToWindowApi29();
        } else {
            calculateMatrixToWindowApi21 = new CalculateMatrixToWindowApi21();
        }
        this.matrixToWindow = calculateMatrixToWindowApi21;
        setWillNotDraw(false);
        setFocusable(true);
        AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(this, 1, false);
        setFocusableInTouchMode(true);
        setClipChildren(false);
        setTransitionGroup(true);
        ViewCompat.setAccessibilityDelegate(this, this.accessibilityDelegate);
        Function1<ViewRootForTest, Unit> onViewCreatedCallback = ViewRootForTest.INSTANCE.getOnViewCreatedCallback();
        if (onViewCreatedCallback != null) {
            onViewCreatedCallback.invoke(this);
        }
        getRoot().attach$ui_release(this);
        if (Build.VERSION.SDK_INT >= 29) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(this);
        }
        this.pointerIconService = new PointerIconService() { // from class: androidx.compose.ui.platform.AndroidComposeView$pointerIconService$1
            @Override // androidx.compose.p000ui.input.pointer.PointerIconService
            public PointerIcon getCurrent() {
                PointerIcon pointerIcon;
                pointerIcon = AndroidComposeView.this.desiredPointerIcon;
                return pointerIcon == null ? PointerIconDefaults.INSTANCE.getDefault() : pointerIcon;
            }

            @Override // androidx.compose.p000ui.input.pointer.PointerIconService
            public void setCurrent(PointerIcon value) {
                Intrinsics.checkNotNullParameter(value, "value");
                AndroidComposeView.this.desiredPointerIcon = value;
            }
        };
    }

    @Override // androidx.compose.p000ui.node.Owner
    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    @Override // androidx.compose.p000ui.platform.ViewRootForTest
    public View getView() {
        return this;
    }

    @Override // androidx.compose.p000ui.node.Owner, androidx.compose.p000ui.node.RootForTest
    public Density getDensity() {
        return this.density;
    }

    @Override // androidx.compose.p000ui.node.Owner
    public FocusManager getFocusManager() {
        return this._focusManager;
    }

    @Override // androidx.compose.p000ui.node.Owner
    public WindowInfo getWindowInfo() {
        return this._windowInfo;
    }

    @Override // androidx.compose.p000ui.node.Owner
    public LayoutNode getRoot() {
        return this.root;
    }

    @Override // androidx.compose.p000ui.node.Owner
    public RootForTest getRootForTest() {
        return this.rootForTest;
    }

    @Override // androidx.compose.p000ui.node.RootForTest
    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    @Override // androidx.compose.p000ui.node.Owner
    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.configurationChangeObserver;
    }

    public final void setConfigurationChangeObserver(Function1<? super Configuration, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.configurationChangeObserver = function1;
    }

    @Override // androidx.compose.p000ui.node.Owner
    public Autofill getAutofill() {
        return this._autofill;
    }

    @Override // androidx.compose.p000ui.node.Owner
    public AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    @Override // androidx.compose.p000ui.node.Owner
    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    @Override // androidx.compose.p000ui.node.Owner
    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    @Override // androidx.compose.p000ui.node.Owner
    public boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    @Override // androidx.compose.p000ui.node.Owner
    public void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this._androidViewsHandler == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this._androidViewsHandler = new AndroidViewsHandler(context);
            addView(this._androidViewsHandler);
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        Intrinsics.checkNotNull(androidViewsHandler);
        return androidViewsHandler;
    }

    @Override // androidx.compose.p000ui.node.Owner
    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.getMeasureIteration();
    }

    @Override // androidx.compose.p000ui.node.Owner
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    @Override // androidx.compose.p000ui.platform.ViewRootForTest
    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout();
    }

    /* renamed from: getLastMatrixRecalculationAnimationTime$ui_release, reason: from getter */
    public final long getLastMatrixRecalculationAnimationTime() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j) {
        this.lastMatrixRecalculationAnimationTime = j;
    }

    private final void setViewTreeOwners(ViewTreeOwners viewTreeOwners) {
        MutableState $this$setValue$iv = this.viewTreeOwners;
        $this$setValue$iv.setValue(viewTreeOwners);
    }

    public final ViewTreeOwners getViewTreeOwners() {
        State $this$getValue$iv = this.viewTreeOwners;
        return (ViewTreeOwners) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: globalLayoutListener$lambda-1, reason: not valid java name */
    public static final void m3743globalLayoutListener$lambda1(AndroidComposeView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updatePositionCacheAndDispatch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: scrollChangedListener$lambda-2, reason: not valid java name */
    public static final void m3745scrollChangedListener$lambda2(AndroidComposeView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updatePositionCacheAndDispatch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: touchModeChangeListener$lambda-3, reason: not valid java name */
    public static final void m3748touchModeChangeListener$lambda3(AndroidComposeView this$0, boolean touchMode) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InputModeManagerImpl inputModeManagerImpl = this$0._inputModeManager;
        InputMode.Companion companion = InputMode.INSTANCE;
        inputModeManagerImpl.m2631setInputModeiuPiT84(touchMode ? companion.m2628getTouchaOaMEAU() : companion.m2627getKeyboardaOaMEAU());
        this$0._focusManager.fetchUpdatedFocusProperties();
    }

    @Override // androidx.compose.p000ui.node.Owner, androidx.compose.p000ui.node.RootForTest
    public TextInputService getTextInputService() {
        return this.textInputService;
    }

    @Override // androidx.compose.p000ui.node.Owner
    public Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    private void setFontFamilyResolver(FontFamily.Resolver resolver) {
        MutableState $this$setValue$iv = this.fontFamilyResolver;
        $this$setValue$iv.setValue(resolver);
    }

    @Override // androidx.compose.p000ui.node.Owner
    public FontFamily.Resolver getFontFamilyResolver() {
        State $this$getValue$iv = this.fontFamilyResolver;
        return (FontFamily.Resolver) $this$getValue$iv.getValue();
    }

    private final int getFontWeightAdjustmentCompat(Configuration $this$fontWeightAdjustmentCompat) {
        if (Build.VERSION.SDK_INT >= 31) {
            return $this$fontWeightAdjustmentCompat.fontWeightAdjustment;
        }
        return 0;
    }

    private void setLayoutDirection(LayoutDirection layoutDirection) {
        MutableState $this$setValue$iv = this.layoutDirection;
        $this$setValue$iv.setValue(layoutDirection);
    }

    @Override // android.view.View, android.view.ViewParent, androidx.compose.p000ui.node.Owner
    public LayoutDirection getLayoutDirection() {
        State $this$getValue$iv = this.layoutDirection;
        return (LayoutDirection) $this$getValue$iv.getValue();
    }

    @Override // androidx.compose.p000ui.node.Owner
    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    @Override // androidx.compose.p000ui.node.Owner
    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    @Override // androidx.compose.p000ui.node.Owner
    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    @Override // androidx.compose.p000ui.node.Owner
    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendHoverExitEvent$lambda-5, reason: not valid java name */
    public static final void m3746sendHoverExitEvent$lambda5(AndroidComposeView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hoverExitReceived = false;
        MotionEvent lastEvent = this$0.previousMotionEvent;
        Intrinsics.checkNotNull(lastEvent);
        if (!(lastEvent.getActionMasked() == 10)) {
            throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.".toString());
        }
        this$0.m3747sendMotionEvent8iAsVTc(lastEvent);
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        Unit unit;
        androidx.compose.p000ui.geometry.Rect it;
        Intrinsics.checkNotNullParameter(rect, "rect");
        FocusModifier activeFocusModifier$ui_release = this._focusManager.getActiveFocusModifier$ui_release();
        if (activeFocusModifier$ui_release == null || (it = FocusTraversalKt.focusRect(activeFocusModifier$ui_release)) == null) {
            unit = null;
        } else {
            rect.left = MathKt.roundToInt(it.getLeft());
            rect.top = MathKt.roundToInt(it.getTop());
            rect.right = MathKt.roundToInt(it.getRight());
            rect.bottom = MathKt.roundToInt(it.getBottom());
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            super.getFocusedRect(rect);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        setShowLayoutBounds(INSTANCE.getIsShowingLayoutBounds());
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        Log.d(FocusTag, "Owner FocusChanged(" + gainFocus + ')');
        FocusManagerImpl $this$onFocusChanged_u24lambda_u2d7 = this._focusManager;
        if (gainFocus) {
            $this$onFocusChanged_u24lambda_u2d7.takeFocus();
        } else {
            $this$onFocusChanged_u24lambda_u2d7.releaseFocus();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        boolean newShowLayoutBounds;
        this._windowInfo.setWindowFocused(hasWindowFocus);
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus && getShowLayoutBounds() != (newShowLayoutBounds = INSTANCE.getIsShowingLayoutBounds())) {
            setShowLayoutBounds(newShowLayoutBounds);
            invalidateDescendants();
        }
    }

    @Override // androidx.compose.p000ui.node.RootForTest
    /* renamed from: sendKeyEvent-ZmokQxo */
    public boolean mo3725sendKeyEventZmokQxo(android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        return this.keyInputModifier.m3237processKeyInputZmokQxo(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (isFocused()) {
            this._windowInfo.m3814setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m3426constructorimpl(event.getMetaState()));
            return mo3725sendKeyEventZmokQxo(KeyEvent.m3214constructorimpl(event));
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // androidx.compose.p000ui.node.Owner
    public void onAttach(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
    }

    @Override // androidx.compose.p000ui.node.Owner
    public void onDetach(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.measureAndLayoutDelegate.onNodeDetached(node);
        requestClearInvalidObservations();
    }

    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    @Override // androidx.compose.p000ui.node.Owner
    public void onEndApplyChanges() {
        if (this.observationClearRequested) {
            getSnapshotObserver().clearInvalidObservations$ui_release();
            this.observationClearRequested = false;
        }
        AndroidViewsHandler childAndroidViews = this._androidViewsHandler;
        if (childAndroidViews != null) {
            clearChildInvalidObservations(childAndroidViews);
        }
        while (this.endApplyChangesListeners.isNotEmpty()) {
            int size = this.endApplyChangesListeners.getSize();
            for (int i = 0; i < size; i++) {
                MutableVector this_$iv = this.endApplyChangesListeners;
                Function0<Unit> listener = this_$iv.getContent()[i];
                this.endApplyChangesListeners.set(i, null);
                if (listener != null) {
                    listener.invoke();
                }
            }
            this.endApplyChangesListeners.removeRange(0, size);
        }
    }

    @Override // androidx.compose.p000ui.node.Owner
    public void registerOnEndApplyChangesListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.endApplyChangesListeners.contains(listener)) {
            MutableVector this_$iv = this.endApplyChangesListeners;
            this_$iv.add(listener);
        }
    }

    private final void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = viewGroup.getChildAt(i);
            if (child instanceof AndroidComposeView) {
                ((AndroidComposeView) child).onEndApplyChanges();
            } else if (child instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) child);
            }
        }
    }

    public final void addAndroidView(AndroidViewHolder view, final LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(view, layoutNode);
        getAndroidViewsHandler$ui_release().addView(view);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, view);
        ViewCompat.setImportantForAccessibility(view, 1);
        ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat() { // from class: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(LayoutNode.this);
                Intrinsics.checkNotNull(outerSemantics);
                SemanticsNode parent = new SemanticsNode(outerSemantics, false, null, 4, null).getParent();
                Intrinsics.checkNotNull(parent);
                int parentId = parent.getId();
                if (parentId == thisView.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
                    parentId = -1;
                }
                info.setParent(thisView, parentId);
            }
        });
    }

    public final void removeAndroidView(final AndroidViewHolder view) {
        Intrinsics.checkNotNullParameter(view, "view");
        registerOnEndApplyChangesListener(new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$removeAndroidView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AndroidComposeView.this.getAndroidViewsHandler$ui_release().removeViewInLayout(view);
                HashMap<LayoutNode, AndroidViewHolder> layoutNodeToHolder = AndroidComposeView.this.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder();
                TypeIntrinsics.asMutableMap(layoutNodeToHolder).remove(AndroidComposeView.this.getAndroidViewsHandler$ui_release().getHolderToLayoutNode().remove(view));
                ViewCompat.setImportantForAccessibility(view, 0);
            }
        });
    }

    public final void drawAndroidView(AndroidViewHolder view, Canvas canvas) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getAndroidViewsHandler$ui_release().drawView(view, canvas);
    }

    static /* synthetic */ void scheduleMeasureAndLayout$default(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.scheduleMeasureAndLayout(layoutNode);
    }

    private final void scheduleMeasureAndLayout(LayoutNode nodeToRemeasure) {
        if (!isLayoutRequested() && isAttachedToWindow()) {
            if (this.wasMeasuredWithMultipleConstraints && nodeToRemeasure != null) {
                LayoutNode node = nodeToRemeasure;
                while (node != null && node.getMeasuredByParent() == LayoutNode.UsageByParent.InMeasureBlock) {
                    node = node.getParent$ui_release();
                }
                if (node == getRoot()) {
                    requestLayout();
                    return;
                }
            }
            if (getWidth() == 0 || getHeight() == 0) {
                requestLayout();
            } else {
                invalidate();
            }
        }
    }

    @Override // androidx.compose.p000ui.node.Owner
    public void measureAndLayout(boolean sendPointerUpdate) {
        Function0 resend;
        Trace.beginSection("AndroidOwner:measureAndLayout");
        if (!sendPointerUpdate) {
            resend = null;
        } else {
            try {
                resend = this.resendMotionEventOnLayout;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        boolean rootNodeResized = this.measureAndLayoutDelegate.measureAndLayout(resend);
        if (rootNodeResized) {
            requestLayout();
        }
        MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
        Unit unit = Unit.INSTANCE;
        Trace.endSection();
    }

    @Override // androidx.compose.p000ui.node.Owner
    /* renamed from: measureAndLayout-0kLqBqw */
    public void mo3724measureAndLayout0kLqBqw(LayoutNode layoutNode, long constraints) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.measureAndLayoutDelegate.m3650measureAndLayout0kLqBqw(layoutNode, constraints);
            MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.compose.p000ui.node.Owner
    public void forceMeasureTheSubtree(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode);
    }

    @Override // androidx.compose.p000ui.node.Owner
    public void onRequestMeasure(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, forceRequest)) {
                scheduleMeasureAndLayout(layoutNode);
            }
        } else if (this.measureAndLayoutDelegate.requestRemeasure(layoutNode, forceRequest)) {
            scheduleMeasureAndLayout(layoutNode);
        }
    }

    @Override // androidx.compose.p000ui.node.Owner
    public void onRequestRelayout(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, forceRequest)) {
                scheduleMeasureAndLayout$default(this, null, 1, null);
            }
        } else if (this.measureAndLayoutDelegate.requestRelayout(layoutNode, forceRequest)) {
            scheduleMeasureAndLayout$default(this, null, 1, null);
        }
    }

    @Override // androidx.compose.p000ui.node.Owner
    public void requestOnPositionedCallback(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.measureAndLayoutDelegate.requestOnPositionedCallback(layoutNode);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            Pair<Integer, Integer> convertMeasureSpec = convertMeasureSpec(widthMeasureSpec);
            int minWidth = convertMeasureSpec.component1().intValue();
            int maxWidth = convertMeasureSpec.component2().intValue();
            Pair<Integer, Integer> convertMeasureSpec2 = convertMeasureSpec(heightMeasureSpec);
            int minHeight = convertMeasureSpec2.component1().intValue();
            int maxHeight = convertMeasureSpec2.component2().intValue();
            long constraints = ConstraintsKt.Constraints(minWidth, maxWidth, minHeight, maxHeight);
            if (this.onMeasureConstraints == null) {
                this.onMeasureConstraints = Constraints.m4326boximpl(constraints);
                this.wasMeasuredWithMultipleConstraints = false;
            } else {
                Constraints constraints2 = this.onMeasureConstraints;
                if (!(constraints2 != null ? Constraints.m4331equalsimpl0(constraints2.getValue(), constraints) : false)) {
                    this.wasMeasuredWithMultipleConstraints = true;
                }
            }
            this.measureAndLayoutDelegate.m3651updateRootConstraintsBRTryo0(constraints);
            this.measureAndLayoutDelegate.measureOnly();
            setMeasuredDimension(getRoot().getWidth(), getRoot().getHeight());
            if (this._androidViewsHandler != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().getWidth(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(getRoot().getHeight(), Ints.MAX_POWER_OF_TWO));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    private final Pair<Integer, Integer> convertMeasureSpec(int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        switch (mode) {
            case Integer.MIN_VALUE:
                return TuplesKt.m294to(0, Integer.valueOf(size));
            case 0:
                return TuplesKt.m294to(0, Integer.MAX_VALUE);
            case Ints.MAX_POWER_OF_TWO /* 1073741824 */:
                return TuplesKt.m294to(Integer.valueOf(size), Integer.valueOf(size));
            default:
                throw new IllegalStateException();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
        this.onMeasureConstraints = null;
        updatePositionCacheAndDispatch();
        if (this._androidViewsHandler != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, r - l, b - t);
        }
    }

    private final void updatePositionCacheAndDispatch() {
        boolean positionChanged = false;
        getLocationOnScreen(this.tmpPositionArray);
        long j = this.globalPosition;
        int globalX = IntOffset.m4492component1impl(j);
        int globalY = IntOffset.m4493component2impl(j);
        if (globalX != this.tmpPositionArray[0] || globalY != this.tmpPositionArray[1]) {
            this.globalPosition = IntOffsetKt.IntOffset(this.tmpPositionArray[0], this.tmpPositionArray[1]);
            if (globalX != Integer.MAX_VALUE && globalY != Integer.MAX_VALUE) {
                positionChanged = true;
                getRoot().getLayoutDelegate().getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
            }
        }
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(positionChanged);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
    }

    @Override // androidx.compose.p000ui.node.Owner
    public OwnedLayer createLayer(Function1<? super androidx.compose.p000ui.graphics.Canvas, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        ViewLayerContainer viewLayerContainer;
        Intrinsics.checkNotNullParameter(drawBlock, "drawBlock");
        Intrinsics.checkNotNullParameter(invalidateParentLayer, "invalidateParentLayer");
        OwnedLayer layer = this.layerCache.pop();
        if (layer != null) {
            layer.reuseLayer(drawBlock, invalidateParentLayer);
            return layer;
        }
        if (isHardwareAccelerated() && this.isRenderNodeCompatible) {
            try {
                return new RenderNodeLayer(this, drawBlock, invalidateParentLayer);
            } catch (Throwable th) {
                this.isRenderNodeCompatible = false;
            }
        }
        if (this.viewLayersContainer == null) {
            if (!ViewLayer.INSTANCE.getHasRetrievedMethod()) {
                ViewLayer.INSTANCE.updateDisplayList(new View(getContext()));
            }
            if (ViewLayer.INSTANCE.getShouldUseDispatchDraw()) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                viewLayerContainer = new DrawChildContainer(context);
            } else {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                viewLayerContainer = new ViewLayerContainer(context2);
            }
            this.viewLayersContainer = viewLayerContainer;
            addView(this.viewLayersContainer);
        }
        DrawChildContainer drawChildContainer = this.viewLayersContainer;
        Intrinsics.checkNotNull(drawChildContainer);
        return new ViewLayer(this, drawChildContainer, drawBlock, invalidateParentLayer);
    }

    public final boolean recycle$ui_release(OwnedLayer layer) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        if (this.viewLayersContainer == null || !ViewLayer.INSTANCE.getShouldUseDispatchDraw()) {
        }
        if (1 != 0) {
            this.layerCache.push(layer);
        }
        return true;
    }

    @Override // androidx.compose.p000ui.node.Owner
    public void onSemanticsChange() {
        this.accessibilityDelegate.onSemanticsChange$ui_release();
    }

    @Override // androidx.compose.p000ui.node.Owner
    public void onLayoutChange(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.accessibilityDelegate.onLayoutChange$ui_release(layoutNode);
    }

    @Override // androidx.compose.p000ui.node.Owner
    public void registerOnLayoutCompletedListener(Owner.OnLayoutCompletedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.measureAndLayoutDelegate.registerOnLayoutCompletedListener(listener);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    @Override // androidx.compose.p000ui.node.Owner
    /* renamed from: getFocusDirection-P8AzH3I */
    public FocusDirection mo3723getFocusDirectionP8AzH3I(android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        long m3230getKeyZmokQxo = KeyEvent_androidKt.m3230getKeyZmokQxo(keyEvent);
        if (Key.m2635equalsimpl0(m3230getKeyZmokQxo, Key.INSTANCE.m3158getTabEK5gGoQ())) {
            return FocusDirection.m1682boximpl(KeyEvent_androidKt.m3236isShiftPressedZmokQxo(keyEvent) ? FocusDirection.INSTANCE.m1700getPreviousdhqQ8s() : FocusDirection.INSTANCE.m1698getNextdhqQ8s());
        }
        if (Key.m2635equalsimpl0(m3230getKeyZmokQxo, Key.INSTANCE.m2999getDirectionRightEK5gGoQ())) {
            return FocusDirection.m1682boximpl(FocusDirection.INSTANCE.m1701getRightdhqQ8s());
        }
        if (Key.m2635equalsimpl0(m3230getKeyZmokQxo, Key.INSTANCE.m2998getDirectionLeftEK5gGoQ())) {
            return FocusDirection.m1682boximpl(FocusDirection.INSTANCE.m1697getLeftdhqQ8s());
        }
        if (Key.m2635equalsimpl0(m3230getKeyZmokQxo, Key.INSTANCE.m3000getDirectionUpEK5gGoQ())) {
            return FocusDirection.m1682boximpl(FocusDirection.INSTANCE.m1702getUpdhqQ8s());
        }
        if (Key.m2635equalsimpl0(m3230getKeyZmokQxo, Key.INSTANCE.m2995getDirectionDownEK5gGoQ())) {
            return FocusDirection.m1682boximpl(FocusDirection.INSTANCE.m1693getDowndhqQ8s());
        }
        if (Key.m2635equalsimpl0(m3230getKeyZmokQxo, Key.INSTANCE.m2994getDirectionCenterEK5gGoQ()) ? true : Key.m2635equalsimpl0(m3230getKeyZmokQxo, Key.INSTANCE.m3008getEnterEK5gGoQ()) ? true : Key.m2635equalsimpl0(m3230getKeyZmokQxo, Key.INSTANCE.m3100getNumPadEnterEK5gGoQ())) {
            return FocusDirection.m1682boximpl(FocusDirection.INSTANCE.m1694getEnterdhqQ8s());
        }
        if (Key.m2635equalsimpl0(m3230getKeyZmokQxo, Key.INSTANCE.m2937getBackEK5gGoQ()) ? true : Key.m2635equalsimpl0(m3230getKeyZmokQxo, Key.INSTANCE.m3011getEscapeEK5gGoQ())) {
            return FocusDirection.m1682boximpl(FocusDirection.INSTANCE.m1695getExitdhqQ8s());
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        Owner.measureAndLayout$default(this, false, 1, null);
        this.isDrawingContent = true;
        CanvasHolder this_$iv = this.canvasHolder;
        Canvas previousCanvas$iv = this_$iv.getAndroidCanvas().getInternalCanvas();
        this_$iv.getAndroidCanvas().setInternalCanvas(canvas);
        androidx.compose.p000ui.graphics.Canvas $this$dispatchDraw_u24lambda_u2d12 = this_$iv.getAndroidCanvas();
        getRoot().draw$ui_release($this$dispatchDraw_u24lambda_u2d12);
        this_$iv.getAndroidCanvas().setInternalCanvas(previousCanvas$iv);
        if (!this.dirtyLayers.isEmpty()) {
            int size = this.dirtyLayers.size();
            for (int i = 0; i < size; i++) {
                OwnedLayer layer = this.dirtyLayers.get(i);
                layer.updateDisplayList();
            }
        }
        if (ViewLayer.INSTANCE.getShouldUseDispatchDraw()) {
            int saveCount = canvas.save();
            canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(saveCount);
        }
        this.dirtyLayers.clear();
        this.isDrawingContent = false;
        if (this.postponedDirtyLayers != null) {
            List postponed = this.postponedDirtyLayers;
            Intrinsics.checkNotNull(postponed);
            this.dirtyLayers.addAll(postponed);
            postponed.clear();
        }
    }

    public final void notifyLayerIsDirty$ui_release(OwnedLayer layer, boolean isDirty) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        if (!isDirty) {
            if (!this.isDrawingContent && !this.dirtyLayers.remove(layer)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            if (!this.isDrawingContent) {
                this.dirtyLayers.add(layer);
                return;
            }
            List it = this.postponedDirtyLayers;
            if (it == null) {
                it = new ArrayList();
                this.postponedDirtyLayers = it;
            }
            it.add(layer);
        }
    }

    public final void setOnViewTreeOwnersAvailable(Function1<? super ViewTreeOwners, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            callback.invoke(viewTreeOwners);
        }
        if (!isAttachedToWindow()) {
            this.onViewTreeOwnersAvailable = callback;
        }
    }

    public final Object boundsUpdatesEventLoop(Continuation<? super Unit> continuation) {
        Object boundsUpdatesEventLoop = this.accessibilityDelegate.boundsUpdatesEventLoop(continuation);
        return boundsUpdatesEventLoop == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? boundsUpdatesEventLoop : Unit.INSTANCE;
    }

    public final Object keyboardVisibilityEventLoop(Continuation<? super Unit> continuation) {
        Object textInputCommandEventLoop = this.textInputServiceAndroid.textInputCommandEventLoop(continuation);
        return textInputCommandEventLoop == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? textInputCommandEventLoop : Unit.INSTANCE;
    }

    private final void invalidateLayoutNodeMeasurement(LayoutNode node) {
        MeasureAndLayoutDelegate.requestRemeasure$default(this.measureAndLayoutDelegate, node, false, 2, null);
        MutableVector this_$iv$iv = node.get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv <= 0) {
            return;
        }
        int i$iv$iv = 0;
        Object[] content$iv$iv = this_$iv$iv.getContent();
        Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        do {
            LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
            invalidateLayoutNodeMeasurement(it);
            i$iv$iv++;
        } while (i$iv$iv < size$iv$iv);
    }

    private final void invalidateLayers(LayoutNode node) {
        node.invalidateLayers$ui_release();
        MutableVector this_$iv$iv = node.get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv <= 0) {
            return;
        }
        int i$iv$iv = 0;
        Object[] content$iv$iv = this_$iv$iv.getContent();
        Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        do {
            LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
            invalidateLayers(it);
            i$iv$iv++;
        } while (i$iv$iv < size$iv$iv);
    }

    @Override // androidx.compose.p000ui.platform.ViewRootForTest
    public void invalidateDescendants() {
        invalidateLayers(getRoot());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        AndroidAutofill it;
        super.onAttachedToWindow();
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().startObserving$ui_release();
        if (autofillSupported() && (it = this._autofill) != null) {
            AutofillCallback.INSTANCE.register(it);
        }
        LifecycleOwner lifecycleOwner2 = ViewTreeLifecycleOwner.get(this);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(this);
        ViewTreeOwners oldViewTreeOwners = getViewTreeOwners();
        boolean resetViewTreeOwner = oldViewTreeOwners == null || !(lifecycleOwner2 == null || savedStateRegistryOwner == null || (lifecycleOwner2 == oldViewTreeOwners.getLifecycleOwner() && savedStateRegistryOwner == oldViewTreeOwners.getLifecycleOwner()));
        if (resetViewTreeOwner) {
            if (lifecycleOwner2 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            }
            if (savedStateRegistryOwner == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
            if (oldViewTreeOwners != null && (lifecycleOwner = oldViewTreeOwners.getLifecycleOwner()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                lifecycle.removeObserver(this);
            }
            lifecycleOwner2.getLifecycle().addObserver(this);
            ViewTreeOwners viewTreeOwners = new ViewTreeOwners(lifecycleOwner2, savedStateRegistryOwner);
            setViewTreeOwners(viewTreeOwners);
            Function1<? super ViewTreeOwners, Unit> function1 = this.onViewTreeOwnersAvailable;
            if (function1 != null) {
                function1.invoke(viewTreeOwners);
            }
            this.onViewTreeOwnersAvailable = null;
        }
        ViewTreeOwners viewTreeOwners2 = getViewTreeOwners();
        Intrinsics.checkNotNull(viewTreeOwners2);
        viewTreeOwners2.getLifecycleOwner().getLifecycle().addObserver(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().addOnTouchModeChangeListener(this.touchModeChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AndroidAutofill it;
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        super.onDetachedFromWindow();
        getSnapshotObserver().stopObserving$ui_release();
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null && (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
        if (autofillSupported() && (it = this._autofill) != null) {
            AutofillCallback.INSTANCE.unregister(it);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().removeOnTouchModeChangeListener(this.touchModeChangeListener);
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure structure, int flags) {
        AndroidAutofill androidAutofill;
        if (!autofillSupported() || structure == null || (androidAutofill = this._autofill) == null) {
            return;
        }
        AndroidAutofill_androidKt.populateViewStructure(androidAutofill, structure);
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> values) {
        AndroidAutofill androidAutofill;
        Intrinsics.checkNotNullParameter(values, "values");
        if (!autofillSupported() || (androidAutofill = this._autofill) == null) {
            return;
        }
        AndroidAutofill_androidKt.performAutofill(androidAutofill, values);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getActionMasked() == 8) {
            if (event.isFromSource(4194304)) {
                return handleRotaryEvent(event);
            }
            if (isBadMotionEvent(event) || !isAttachedToWindow()) {
                return super.dispatchGenericMotionEvent(event);
            }
            return ProcessResult.m3451getDispatchedToAPointerInputModifierimpl(m3744handleMotionEvent8iAsVTc(event));
        }
        return super.dispatchGenericMotionEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            MotionEvent lastEvent = this.previousMotionEvent;
            Intrinsics.checkNotNull(lastEvent);
            if (motionEvent.getActionMasked() != 0 || hasChangedDevices(motionEvent, lastEvent)) {
                this.sendHoverExitEvent.run();
            } else {
                this.hoverExitReceived = false;
            }
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && !isPositionChanged(motionEvent)) {
            return false;
        }
        int processResult = m3744handleMotionEvent8iAsVTc(motionEvent);
        if (ProcessResult.m3450getAnyMovementConsumedimpl(processResult)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return ProcessResult.m3451getDispatchedToAPointerInputModifierimpl(processResult);
    }

    private final boolean handleRotaryEvent(MotionEvent event) {
        ViewConfiguration config = ViewConfiguration.get(getContext());
        float axisValue = -event.getAxisValue(26);
        RotaryScrollEvent rotaryEvent = new RotaryScrollEvent(ViewConfigurationCompat.getScaledVerticalScrollFactor(config, getContext()) * axisValue, ViewConfigurationCompat.getScaledHorizontalScrollFactor(config, getContext()) * axisValue, event.getEventTime());
        FocusModifier activeFocusModifier$ui_release = this._focusManager.getActiveFocusModifier$ui_release();
        if (activeFocusModifier$ui_release != null) {
            return activeFocusModifier$ui_release.propagateRotaryEvent(rotaryEvent);
        }
        return false;
    }

    /* renamed from: handleMotionEvent-8iAsVTc, reason: not valid java name */
    private final int m3744handleMotionEvent8iAsVTc(MotionEvent motionEvent) {
        boolean z;
        int i;
        MotionEvent lastEvent;
        removeCallbacks(this.resendMotionEventRunnable);
        try {
            recalculateWindowPosition(motionEvent);
            this.forceUseMatrixCache = true;
            measureAndLayout(false);
            this.desiredPointerIcon = null;
            Trace.beginSection("AndroidOwner:onTouch");
            try {
                int action = motionEvent.getActionMasked();
                MotionEvent lastEvent2 = this.previousMotionEvent;
                if (lastEvent2 == null || lastEvent2.getToolType(0) != 3) {
                    z = false;
                } else {
                    z = true;
                }
                boolean wasMouseEvent = z;
                if (lastEvent2 == null) {
                    i = 3;
                    lastEvent = lastEvent2;
                } else if (!hasChangedDevices(motionEvent, lastEvent2)) {
                    i = 3;
                    lastEvent = lastEvent2;
                } else if (isDevicePressEvent(lastEvent2)) {
                    this.pointerInputEventProcessor.processCancel();
                    i = 3;
                    lastEvent = lastEvent2;
                } else if (lastEvent2.getActionMasked() != 10 && wasMouseEvent) {
                    i = 3;
                    lastEvent = lastEvent2;
                    sendSimulatedEvent$default(this, lastEvent2, 10, lastEvent2.getEventTime(), false, 8, null);
                } else {
                    i = 3;
                    lastEvent = lastEvent2;
                }
                boolean isMouseEvent = motionEvent.getToolType(0) == i;
                if (!wasMouseEvent && isMouseEvent && action != i && action != 9 && isInBounds(motionEvent)) {
                    sendSimulatedEvent$default(this, motionEvent, 9, motionEvent.getEventTime(), false, 8, null);
                }
                if (lastEvent != null) {
                    lastEvent.recycle();
                }
                this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                int m3747sendMotionEvent8iAsVTc = m3747sendMotionEvent8iAsVTc(motionEvent);
                Trace.endSection();
                AndroidComposeViewVerificationHelperMethodsN.INSTANCE.setPointerIcon(this, this.desiredPointerIcon);
                return m3747sendMotionEvent8iAsVTc;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } finally {
            this.forceUseMatrixCache = false;
        }
    }

    private final boolean hasChangedDevices(MotionEvent event, MotionEvent lastEvent) {
        return (lastEvent.getSource() == event.getSource() && lastEvent.getToolType(0) == event.getToolType(0)) ? false : true;
    }

    private final boolean isDevicePressEvent(MotionEvent event) {
        if (event.getButtonState() != 0) {
            return true;
        }
        switch (event.getActionMasked()) {
            case 0:
            case 2:
            case 6:
                break;
        }
        return true;
    }

    /* renamed from: sendMotionEvent-8iAsVTc, reason: not valid java name */
    private final int m3747sendMotionEvent8iAsVTc(MotionEvent motionEvent) {
        Object element$iv;
        if (this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = false;
            this._windowInfo.m3814setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m3426constructorimpl(motionEvent.getMetaState()));
        }
        PointerInputEvent pointerInputEvent = this.motionEventAdapter.convertToPointerInputEvent$ui_release(motionEvent, this);
        if (pointerInputEvent == null) {
            this.pointerInputEventProcessor.processCancel();
            return PointerInputEventProcessorKt.ProcessResult(false, false);
        }
        List $this$lastOrNull$iv = pointerInputEvent.getPointers();
        ListIterator iterator$iv = $this$lastOrNull$iv.listIterator($this$lastOrNull$iv.size());
        while (true) {
            if (!iterator$iv.hasPrevious()) {
                element$iv = null;
                break;
            }
            element$iv = iterator$iv.previous();
            PointerInputEventData it = (PointerInputEventData) element$iv;
            if (it.getDown()) {
                break;
            }
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) element$iv;
        if (pointerInputEventData != null) {
            long it2 = pointerInputEventData.m3378getPositionF1C5BW0();
            this.lastDownPointerPosition = it2;
        }
        int result = this.pointerInputEventProcessor.m3383processBIzXfog(pointerInputEvent, this, isInBounds(motionEvent));
        int action = motionEvent.getActionMasked();
        if ((action != 0 && action != 5) || ProcessResult.m3451getDispatchedToAPointerInputModifierimpl(result)) {
            return result;
        }
        this.motionEventAdapter.endStream(motionEvent.getPointerId(motionEvent.getActionIndex()));
        return result;
    }

    static /* synthetic */ void sendSimulatedEvent$default(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i, long j, boolean z, int i2, Object obj) {
        boolean z2;
        if ((i2 & 8) == 0) {
            z2 = z;
        } else {
            z2 = true;
        }
        androidComposeView.sendSimulatedEvent(motionEvent, i, j, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendSimulatedEvent(MotionEvent motionEvent, int action, long eventTime, boolean forceHover) {
        long downTime;
        int oldAction = motionEvent.getActionMasked();
        int upIndex = -1;
        switch (oldAction) {
            case 1:
                switch (action) {
                    case 9:
                    case 10:
                        break;
                    default:
                        upIndex = 0;
                        break;
                }
            case 6:
                upIndex = motionEvent.getActionIndex();
                break;
        }
        int pointerCount = motionEvent.getPointerCount() - (upIndex >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerProperties = new MotionEvent.PointerProperties[pointerCount];
        for (int i = 0; i < pointerCount; i++) {
            pointerProperties[i] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoords = new MotionEvent.PointerCoords[pointerCount];
        for (int i2 = 0; i2 < pointerCount; i2++) {
            pointerCoords[i2] = new MotionEvent.PointerCoords();
        }
        int i3 = 0;
        while (i3 < pointerCount) {
            int sourceIndex = ((upIndex < 0 || i3 < upIndex) ? 0 : 1) + i3;
            motionEvent.getPointerProperties(sourceIndex, pointerProperties[i3]);
            MotionEvent.PointerCoords coords = pointerCoords[i3];
            motionEvent.getPointerCoords(sourceIndex, coords);
            long localPosition = OffsetKt.Offset(coords.x, coords.y);
            long screenPosition = mo3444localToScreenMKHz9U(localPosition);
            coords.x = Offset.m1760getXimpl(screenPosition);
            coords.y = Offset.m1761getYimpl(screenPosition);
            i3++;
        }
        int buttonState = forceHover ? 0 : motionEvent.getButtonState();
        if (motionEvent.getDownTime() == motionEvent.getEventTime()) {
            downTime = eventTime;
        } else {
            downTime = motionEvent.getDownTime();
        }
        MotionEvent event = MotionEvent.obtain(downTime, eventTime, action, pointerCount, pointerProperties, pointerCoords, motionEvent.getMetaState(), buttonState, motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        MotionEventAdapter motionEventAdapter = this.motionEventAdapter;
        Intrinsics.checkNotNullExpressionValue(event, "event");
        PointerInputEvent pointerInputEvent = motionEventAdapter.convertToPointerInputEvent$ui_release(event, this);
        Intrinsics.checkNotNull(pointerInputEvent);
        this.pointerInputEventProcessor.m3383processBIzXfog(pointerInputEvent, this, true);
        event.recycle();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        return this.accessibilityDelegate.m3755canScroll0AR0LA0$ui_release(false, direction, this.lastDownPointerPosition);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        return this.accessibilityDelegate.m3755canScroll0AR0LA0$ui_release(true, direction, this.lastDownPointerPosition);
    }

    private final boolean isInBounds(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (0.0f <= x && x <= ((float) getWidth())) {
            if (0.0f <= y && y <= ((float) getHeight())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.p000ui.input.pointer.PositionCalculator
    /* renamed from: localToScreen-MK-Hz9U */
    public long mo3444localToScreenMKHz9U(long localPosition) {
        recalculateWindowPosition();
        long local = Matrix.m2196mapMKHz9U(this.viewToWindowMatrix, localPosition);
        return OffsetKt.Offset(Offset.m1760getXimpl(local) + Offset.m1760getXimpl(this.windowPosition), Offset.m1761getYimpl(local) + Offset.m1761getYimpl(this.windowPosition));
    }

    @Override // androidx.compose.p000ui.input.pointer.PositionCalculator
    /* renamed from: screenToLocal-MK-Hz9U */
    public long mo3445screenToLocalMKHz9U(long positionOnScreen) {
        recalculateWindowPosition();
        float x = Offset.m1760getXimpl(positionOnScreen) - Offset.m1760getXimpl(this.windowPosition);
        float y = Offset.m1761getYimpl(positionOnScreen) - Offset.m1761getYimpl(this.windowPosition);
        return Matrix.m2196mapMKHz9U(this.windowToViewMatrix, OffsetKt.Offset(x, y));
    }

    private final void recalculateWindowPosition() {
        if (!this.forceUseMatrixCache) {
            long animationTime = AnimationUtils.currentAnimationTimeMillis();
            if (animationTime != this.lastMatrixRecalculationAnimationTime) {
                this.lastMatrixRecalculationAnimationTime = animationTime;
                recalculateWindowViewTransforms();
                ViewParent viewParent = getParent();
                AndroidComposeView view = this;
                while (viewParent instanceof ViewGroup) {
                    view = (View) viewParent;
                    viewParent = ((ViewGroup) view).getParent();
                }
                view.getLocationOnScreen(this.tmpPositionArray);
                float screenX = this.tmpPositionArray[0];
                float screenY = this.tmpPositionArray[1];
                view.getLocationInWindow(this.tmpPositionArray);
                float windowX = this.tmpPositionArray[0];
                float windowY = this.tmpPositionArray[1];
                this.windowPosition = OffsetKt.Offset(screenX - windowX, screenY - windowY);
            }
        }
    }

    private final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        recalculateWindowViewTransforms();
        long positionInWindow = Matrix.m2196mapMKHz9U(this.viewToWindowMatrix, OffsetKt.Offset(motionEvent.getX(), motionEvent.getY()));
        this.windowPosition = OffsetKt.Offset(motionEvent.getRawX() - Offset.m1760getXimpl(positionInWindow), motionEvent.getRawY() - Offset.m1761getYimpl(positionInWindow));
    }

    private final void recalculateWindowViewTransforms() {
        this.matrixToWindow.mo3763calculateMatrixToWindowEL8BTi8(this, this.viewToWindowMatrix);
        InvertMatrixKt.m3780invertToJiSxe2E(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return this.textInputServiceAndroid.getEditorHasFocus();
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        return this.textInputServiceAndroid.createInputConnection(outAttrs);
    }

    @Override // androidx.compose.p000ui.node.Owner
    /* renamed from: calculateLocalPosition-MK-Hz9U */
    public long mo3721calculateLocalPositionMKHz9U(long positionInWindow) {
        recalculateWindowPosition();
        return Matrix.m2196mapMKHz9U(this.windowToViewMatrix, positionInWindow);
    }

    @Override // androidx.compose.p000ui.node.Owner
    /* renamed from: calculatePositionInWindow-MK-Hz9U */
    public long mo3722calculatePositionInWindowMKHz9U(long localPosition) {
        recalculateWindowPosition();
        return Matrix.m2196mapMKHz9U(this.viewToWindowMatrix, localPosition);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.density = AndroidDensity_androidKt.Density(context);
        if (getFontWeightAdjustmentCompat(newConfig) != this.currentFontWeightAdjustment) {
            this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(newConfig);
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            setFontFamilyResolver(FontFamilyResolver_androidKt.createFontFamilyResolver(context2));
        }
        this.configurationChangeObserver.invoke(newConfig);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        LayoutDirection it;
        if (this.superclassInitComplete) {
            it = AndroidComposeView_androidKt.layoutDirectionFromInt(layoutDirection);
            setLayoutDirection(it);
            this._focusManager.setLayoutDirection(it);
        }
    }

    private final boolean autofillSupported() {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }
        if (isBadMotionEvent(event) || !isAttachedToWindow()) {
            return false;
        }
        if (event.isFromSource(InputDeviceCompat.SOURCE_TOUCHSCREEN) && event.getToolType(0) == 1) {
            return this.accessibilityDelegate.dispatchHoverEvent(event);
        }
        switch (event.getActionMasked()) {
            case 7:
                if (!isPositionChanged(event)) {
                    return false;
                }
                break;
            case 10:
                if (isInBounds(event)) {
                    if (event.getToolType(0) != 3) {
                        MotionEvent motionEvent = this.previousMotionEvent;
                        if (motionEvent != null) {
                            motionEvent.recycle();
                        }
                        this.previousMotionEvent = MotionEvent.obtainNoHistory(event);
                        this.hoverExitReceived = true;
                        post(this.sendHoverExitEvent);
                        return false;
                    }
                    if (event.getButtonState() != 0) {
                        return false;
                    }
                }
                break;
        }
        int result = m3744handleMotionEvent8iAsVTc(event);
        return ProcessResult.m3451getDispatchedToAPointerInputModifierimpl(result);
    }

    private final boolean isBadMotionEvent(MotionEvent event) {
        float x = event.getX();
        if (!((Float.isInfinite(x) || Float.isNaN(x)) ? false : true)) {
            return true;
        }
        float y = event.getY();
        if (!((Float.isInfinite(y) || Float.isNaN(y)) ? false : true)) {
            return true;
        }
        float rawX = event.getRawX();
        if (!((Float.isInfinite(rawX) || Float.isNaN(rawX)) ? false : true)) {
            return true;
        }
        float rawY = event.getRawY();
        return !(!Float.isInfinite(rawY) && !Float.isNaN(rawY));
    }

    private final boolean isPositionChanged(MotionEvent event) {
        MotionEvent lastEvent;
        if (event.getPointerCount() != 1 || (lastEvent = this.previousMotionEvent) == null) {
            return true;
        }
        if (event.getRawX() == lastEvent.getRawX()) {
            return !((event.getRawY() > lastEvent.getRawY() ? 1 : (event.getRawY() == lastEvent.getRawY() ? 0 : -1)) == 0);
        }
        return true;
    }

    private final View findViewByAccessibilityIdRootedAtCurrentView(int accessibilityId, View currentView) {
        if (Build.VERSION.SDK_INT < 29) {
            Method getAccessibilityViewIdMethod = View.class.getDeclaredMethod("getAccessibilityViewId", new Class[0]);
            getAccessibilityViewIdMethod.setAccessible(true);
            if (Intrinsics.areEqual(getAccessibilityViewIdMethod.invoke(currentView, new Object[0]), Integer.valueOf(accessibilityId))) {
                return currentView;
            }
            if (currentView instanceof ViewGroup) {
                int childCount = ((ViewGroup) currentView).getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = ((ViewGroup) currentView).getChildAt(i);
                    Intrinsics.checkNotNullExpressionValue(childAt, "currentView.getChildAt(i)");
                    View foundView = findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, childAt);
                    if (foundView != null) {
                        return foundView;
                    }
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // androidx.compose.p000ui.node.Owner
    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    public final View findViewByAccessibilityIdTraversal(int accessibilityId) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                Method findViewByAccessibilityIdTraversalMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
                findViewByAccessibilityIdTraversalMethod.setAccessible(true);
                Object invoke = findViewByAccessibilityIdTraversalMethod.invoke(this, Integer.valueOf(accessibilityId));
                if (invoke instanceof View) {
                    return (View) invoke;
                }
                return null;
            }
            return findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, this);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    @Override // androidx.compose.p000ui.platform.ViewRootForTest
    public boolean isLifecycleInResumedState() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        return ((viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? null : lifecycle.getCurrentState()) == Lifecycle.State.RESUMED;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* compiled from: AndroidComposeView.android.kt */
    @Metadata(m286d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m287d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$Companion;", "", "()V", "FocusTag", "", "MaximumLayerCacheSize", "", "getBooleanMethod", "Ljava/lang/reflect/Method;", "systemPropertiesClass", "Ljava/lang/Class;", "getIsShowingLayoutBounds", "", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getIsShowingLayoutBounds() {
            try {
                if (AndroidComposeView.systemPropertiesClass == null) {
                    AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                    Class cls = AndroidComposeView.systemPropertiesClass;
                    AndroidComposeView.getBooleanMethod = cls != null ? cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE) : null;
                }
                Method method = AndroidComposeView.getBooleanMethod;
                Object invoke = method != null ? method.invoke(null, "debug.layout", false) : null;
                Boolean bool = invoke instanceof Boolean ? (Boolean) invoke : null;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
    }

    /* compiled from: AndroidComposeView.android.kt */
    @Metadata(m286d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m287d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public static final class ViewTreeOwners {
        public static final int $stable = 8;
        private final LifecycleOwner lifecycleOwner;
        private final SavedStateRegistryOwner savedStateRegistryOwner;

        public ViewTreeOwners(LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "savedStateRegistryOwner");
            this.lifecycleOwner = lifecycleOwner;
            this.savedStateRegistryOwner = savedStateRegistryOwner;
        }

        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
            return this.savedStateRegistryOwner;
        }
    }
}
