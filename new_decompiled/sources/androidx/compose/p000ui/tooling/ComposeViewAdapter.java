package androidx.compose.p000ui.tooling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.compose.LocalActivityResultRegistryOwner;
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.DecayAnimation;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.ColorKt;
import androidx.compose.p000ui.platform.ComposeView;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewRootForTest;
import androidx.compose.p000ui.text.font.Font;
import androidx.compose.p000ui.text.font.FontFamily;
import androidx.compose.p000ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.p000ui.tooling.animation.PreviewAnimationClock;
import androidx.compose.p000ui.tooling.animation.UnsupportedComposeAnimation;
import androidx.compose.p000ui.tooling.data.Group;
import androidx.compose.p000ui.tooling.data.SlotTreeKt;
import androidx.compose.p000ui.tooling.data.SourceLocation;
import androidx.compose.p000ui.tooling.preview.PreviewParameterProvider;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.core.app.ActivityOptionsCompat;
import androidx.health.platform.client.SdkConfig;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;
import kotlin.text.StringsKt;

/* compiled from: ComposeViewAdapter.kt */
@Metadata(m286d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e*\u0004\u000b\u000e\u0011\u0014\b\u0000\u0018\u00002\u00020\u0001:\r\u007f\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ \u0010L\u001a\u00020(2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)H\u0003¢\u0006\u0002\u0010MJ\u0012\u0010N\u001a\u00020(2\b\u0010O\u001a\u0004\u0018\u00010PH\u0014J\r\u0010Q\u001a\u00020(H\u0000¢\u0006\u0002\bRJ\b\u0010S\u001a\u00020(H\u0002J\b\u0010T\u001a\u00020(H\u0002J4\u0010U\u001a\b\u0012\u0004\u0012\u00020F032\u0006\u0010V\u001a\u00020F2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020.0X2\b\b\u0002\u0010Y\u001a\u00020.H\u0002J\u0006\u0010:\u001a\u00020.J\u0010\u0010Z\u001a\u00020(2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u009d\u0001\u0010Z\u001a\u00020(2\u0006\u0010[\u001a\u00020\u00172\u0006\u0010\\\u001a\u00020\u00172\u0016\b\u0002\u0010]\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030_\u0018\u00010^2\b\b\u0002\u0010`\u001a\u00020\b2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\b\b\u0002\u0010a\u001a\u00020b2\b\b\u0002\u00109\u001a\u00020.2\b\b\u0002\u0010;\u001a\u00020.2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00172\u000e\b\u0002\u0010c\u001a\b\u0012\u0004\u0012\u00020(0'2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020(0'H\u0001¢\u0006\u0002\bdJ\b\u0010e\u001a\u00020(H\u0002J\b\u0010f\u001a\u00020(H\u0014J0\u0010g\u001a\u00020(2\u0006\u0010h\u001a\u00020.2\u0006\u0010i\u001a\u00020\b2\u0006\u0010j\u001a\u00020\b2\u0006\u0010k\u001a\u00020\b2\u0006\u0010l\u001a\u00020\bH\u0014J\b\u0010m\u001a\u00020(H\u0002J\u001a\u0010n\u001a\u00020(2\u0006\u0010o\u001a\u00020B2\b\b\u0002\u0010p\u001a\u00020\bH\u0002J&\u0010q\u001a\b\u0012\u0004\u0012\u00020F03*\u00020F2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020.0XH\u0002J!\u0010r\u001a\b\u0012\u0004\u0012\u0002Hs03\"\u0006\b\u0000\u0010s\u0018\u0001*\b\u0012\u0004\u0012\u00020F0tH\u0082\bJ\"\u0010u\u001a\u0004\u0018\u00010F*\u00020F2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020.0XH\u0002J\u000e\u0010v\u001a\u0004\u0018\u00010w*\u00020xH\u0002J\f\u0010y\u001a\u00020.*\u00020FH\u0002J\u001e\u0010z\u001a\u0004\u0018\u00010\u0017*\u00020x2\u0006\u0010{\u001a\u00020\b2\u0006\u0010|\u001a\u00020\bH\u0002J\f\u0010}\u001a\u00020.*\u00020FH\u0002J\f\u0010~\u001a\u00020B*\u00020FH\u0002R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\u00198\u0000@\u0000X\u0081.¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R%\u0010%\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)0&X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b*\u0010\u001bR\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R \u00102\u001a\b\u0012\u0004\u0012\u00020\u001703X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00108\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020(0'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010=\u001a\r\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)X\u0082\u000e¢\u0006\u0004\n\u0002\u0010>R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010A\u001a\b\u0012\u0004\u0012\u00020B03X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00105\"\u0004\bD\u00107R\u0018\u0010E\u001a\u00020\u0017*\u00020F8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0018\u0010I\u001a\u00020\b*\u00020F8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010K¨\u0006\u0086\u0001"}, m287d2 = {"Landroidx/compose/ui/tooling/ComposeViewAdapter;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "FakeActivityResultRegistryOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeActivityResultRegistryOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeActivityResultRegistryOwner$1;", "FakeOnBackPressedDispatcherOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1;", "FakeSavedStateRegistryOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeSavedStateRegistryOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeSavedStateRegistryOwner$1;", "FakeViewModelStoreOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeViewModelStoreOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeViewModelStoreOwner$1;", "TAG", "", "clock", "Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "getClock$ui_tooling_release$annotations", "()V", "getClock$ui_tooling_release", "()Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "setClock$ui_tooling_release", "(Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;)V", "composableName", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "composition", "Landroidx/compose/runtime/Composition;", "content", "Landroidx/compose/runtime/MutableState;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getContent$annotations", "debugBoundsPaint", "Landroid/graphics/Paint;", "debugPaintBounds", "", "debugViewInfos", "delayedException", "Landroidx/compose/ui/tooling/ThreadSafeException;", "designInfoList", "", "getDesignInfoList$ui_tooling_release", "()Ljava/util/List;", "setDesignInfoList$ui_tooling_release", "(Ljava/util/List;)V", "designInfoProvidersArgument", "forceCompositionInvalidation", "hasAnimations", "lookForDesignInfoProviders", "onDraw", "previewComposition", "Lkotlin/jvm/functions/Function2;", "slotTableRecord", "Landroidx/compose/ui/tooling/CompositionDataRecord;", "viewInfos", "Landroidx/compose/ui/tooling/ViewInfo;", "getViewInfos$ui_tooling_release", "setViewInfos$ui_tooling_release", "fileName", "Landroidx/compose/ui/tooling/data/Group;", "getFileName", "(Landroidx/compose/ui/tooling/data/Group;)Ljava/lang/String;", "lineNumber", "getLineNumber", "(Landroidx/compose/ui/tooling/data/Group;)I", "WrapPreview", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispose", "dispose$ui_tooling_release", "findAndTrackAnimations", "findDesignInfoProviders", "findGroupsThatMatchPredicate", "root", "predicate", "Lkotlin/Function1;", "findOnlyFirst", "init", "className", "methodName", "parameterProvider", "Ljava/lang/Class;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "parameterProviderIndex", "animationClockStartTime", "", "onCommit", "init$ui_tooling_release", "invalidateComposition", "onAttachedToWindow", "onLayout", "changed", "left", "top", "right", "bottom", "processViewInfos", "walkTable", "viewInfo", "indent", "findAll", "findRememberCall", "T", "", "firstOrNull", "getDesignInfoMethodOrNull", "Ljava/lang/reflect/Method;", "", "hasNullSourcePosition", "invokeGetDesignInfo", "x", "y", "isNullGroup", "toViewInfo", "AnimateContentSizeSearch", "AnimateXAsStateSearch", "AnimatedContentSearch", "AnimatedVisibilitySearch", "RememberSearch", "Search", "TransitionSearch", "ui-tooling_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ComposeViewAdapter extends FrameLayout {
    private final ComposeViewAdapter$FakeActivityResultRegistryOwner$1 FakeActivityResultRegistryOwner;
    private final ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1 FakeOnBackPressedDispatcherOwner;
    private final ComposeViewAdapter$FakeSavedStateRegistryOwner$1 FakeSavedStateRegistryOwner;
    private final ComposeViewAdapter$FakeViewModelStoreOwner$1 FakeViewModelStoreOwner;
    private final String TAG;
    public PreviewAnimationClock clock;
    private String composableName;
    private final ComposeView composeView;
    private Composition composition;
    private final MutableState<Function2<Composer, Integer, Unit>> content;
    private final Paint debugBoundsPaint;
    private boolean debugPaintBounds;
    private boolean debugViewInfos;
    private final ThreadSafeException delayedException;
    private List<String> designInfoList;
    private String designInfoProvidersArgument;
    private boolean forceCompositionInvalidation;
    private boolean hasAnimations;
    private boolean lookForDesignInfoProviders;
    private Function0<Unit> onDraw;
    private Function2<? super Composer, ? super Integer, Unit> previewComposition;
    private final CompositionDataRecord slotTableRecord;
    private List<ViewInfo> viewInfos;

    public static /* synthetic */ void getClock$ui_tooling_release$annotations() {
    }

    private static /* synthetic */ void getContent$annotations() {
    }

    public final List<ViewInfo> getViewInfos$ui_tooling_release() {
        return this.viewInfos;
    }

    public final void setViewInfos$ui_tooling_release(List<ViewInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.viewInfos = list;
    }

    public final List<String> getDesignInfoList$ui_tooling_release() {
        return this.designInfoList;
    }

    public final void setDesignInfoList$ui_tooling_release(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.designInfoList = list;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v11, types: [androidx.compose.ui.tooling.ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1] */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1] */
    public ComposeViewAdapter(Context context, AttributeSet attrs) {
        super(context, attrs);
        Function2 function2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.TAG = "ComposeViewAdapter";
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.composeView = new ComposeView(context2, null, 0, 6, null);
        this.viewInfos = CollectionsKt.emptyList();
        this.designInfoList = CollectionsKt.emptyList();
        this.slotTableRecord = CompositionDataRecord.INSTANCE.create();
        this.composableName = "";
        this.delayedException = new ThreadSafeException();
        this.previewComposition = ComposableSingletons$ComposeViewAdapterKt.INSTANCE.m4306getLambda2$ui_tooling_release();
        function2 = ComposeViewAdapterKt.emptyContent;
        this.content = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(function2, null, 2, null);
        this.designInfoProvidersArgument = "";
        this.onDraw = ComposeViewAdapter$onDraw$1.INSTANCE;
        Paint $this$debugBoundsPaint_u24lambda_u2d0 = new Paint();
        $this$debugBoundsPaint_u24lambda_u2d0.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, 0.0f));
        $this$debugBoundsPaint_u24lambda_u2d0.setStyle(Paint.Style.STROKE);
        $this$debugBoundsPaint_u24lambda_u2d0.setColor(ColorKt.m2051toArgb8_81llA(Color.INSTANCE.m2030getRed0d7_KjU()));
        this.debugBoundsPaint = $this$debugBoundsPaint_u24lambda_u2d0;
        this.FakeSavedStateRegistryOwner = new ComposeViewAdapter$FakeSavedStateRegistryOwner$1();
        this.FakeViewModelStoreOwner = new ComposeViewAdapter$FakeViewModelStoreOwner$1();
        this.FakeOnBackPressedDispatcherOwner = new OnBackPressedDispatcherOwner() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1
            private final OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher();

            @Override // androidx.activity.OnBackPressedDispatcherOwner
            public OnBackPressedDispatcher getOnBackPressedDispatcher() {
                return this.onBackPressedDispatcher;
            }

            @Override // androidx.lifecycle.LifecycleOwner
            public LifecycleRegistry getLifecycle() {
                ComposeViewAdapter$FakeSavedStateRegistryOwner$1 composeViewAdapter$FakeSavedStateRegistryOwner$1;
                composeViewAdapter$FakeSavedStateRegistryOwner$1 = ComposeViewAdapter.this.FakeSavedStateRegistryOwner;
                return composeViewAdapter$FakeSavedStateRegistryOwner$1.getLifecycleRegistry();
            }
        };
        this.FakeActivityResultRegistryOwner = new ActivityResultRegistryOwner() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1
            private final C0494x466dc6c4 activityResultRegistry = new ActivityResultRegistry() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1
                @Override // androidx.activity.result.ActivityResultRegistry
                public <I, O> void onLaunch(int requestCode, ActivityResultContract<I, O> contract, I input, ActivityOptionsCompat options) {
                    Intrinsics.checkNotNullParameter(contract, "contract");
                    throw new IllegalStateException("Calling launch() is not supported in Preview");
                }
            };

            @Override // androidx.activity.result.ActivityResultRegistryOwner
            public ActivityResultRegistry getActivityResultRegistry() {
                return this.activityResultRegistry;
            }
        };
        init(attrs);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v11, types: [androidx.compose.ui.tooling.ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1] */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1] */
    public ComposeViewAdapter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Function2 function2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.TAG = "ComposeViewAdapter";
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.composeView = new ComposeView(context2, null, 0, 6, null);
        this.viewInfos = CollectionsKt.emptyList();
        this.designInfoList = CollectionsKt.emptyList();
        this.slotTableRecord = CompositionDataRecord.INSTANCE.create();
        this.composableName = "";
        this.delayedException = new ThreadSafeException();
        this.previewComposition = ComposableSingletons$ComposeViewAdapterKt.INSTANCE.m4306getLambda2$ui_tooling_release();
        function2 = ComposeViewAdapterKt.emptyContent;
        this.content = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(function2, null, 2, null);
        this.designInfoProvidersArgument = "";
        this.onDraw = ComposeViewAdapter$onDraw$1.INSTANCE;
        Paint $this$debugBoundsPaint_u24lambda_u2d0 = new Paint();
        $this$debugBoundsPaint_u24lambda_u2d0.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, 0.0f));
        $this$debugBoundsPaint_u24lambda_u2d0.setStyle(Paint.Style.STROKE);
        $this$debugBoundsPaint_u24lambda_u2d0.setColor(ColorKt.m2051toArgb8_81llA(Color.INSTANCE.m2030getRed0d7_KjU()));
        this.debugBoundsPaint = $this$debugBoundsPaint_u24lambda_u2d0;
        this.FakeSavedStateRegistryOwner = new ComposeViewAdapter$FakeSavedStateRegistryOwner$1();
        this.FakeViewModelStoreOwner = new ComposeViewAdapter$FakeViewModelStoreOwner$1();
        this.FakeOnBackPressedDispatcherOwner = new OnBackPressedDispatcherOwner() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1
            private final OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher();

            @Override // androidx.activity.OnBackPressedDispatcherOwner
            public OnBackPressedDispatcher getOnBackPressedDispatcher() {
                return this.onBackPressedDispatcher;
            }

            @Override // androidx.lifecycle.LifecycleOwner
            public LifecycleRegistry getLifecycle() {
                ComposeViewAdapter$FakeSavedStateRegistryOwner$1 composeViewAdapter$FakeSavedStateRegistryOwner$1;
                composeViewAdapter$FakeSavedStateRegistryOwner$1 = ComposeViewAdapter.this.FakeSavedStateRegistryOwner;
                return composeViewAdapter$FakeSavedStateRegistryOwner$1.getLifecycleRegistry();
            }
        };
        this.FakeActivityResultRegistryOwner = new ActivityResultRegistryOwner() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1
            private final C0494x466dc6c4 activityResultRegistry = new ActivityResultRegistry() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1
                @Override // androidx.activity.result.ActivityResultRegistry
                public <I, O> void onLaunch(int requestCode, ActivityResultContract<I, O> contract, I input, ActivityOptionsCompat options) {
                    Intrinsics.checkNotNullParameter(contract, "contract");
                    throw new IllegalStateException("Calling launch() is not supported in Preview");
                }
            };

            @Override // androidx.activity.result.ActivityResultRegistryOwner
            public ActivityResultRegistry getActivityResultRegistry() {
                return this.activityResultRegistry;
            }
        };
        init(attrs);
    }

    static /* synthetic */ void walkTable$default(ComposeViewAdapter composeViewAdapter, ViewInfo viewInfo, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        composeViewAdapter.walkTable(viewInfo, i);
    }

    private final void walkTable(ViewInfo viewInfo, int indent) {
        Log.d(this.TAG, StringsKt.repeat("|  ", indent) + "|-" + viewInfo);
        Iterable $this$forEach$iv = viewInfo.getChildren();
        for (Object element$iv : $this$forEach$iv) {
            ViewInfo it = (ViewInfo) element$iv;
            walkTable(it, indent + 1);
        }
    }

    private final String getFileName(Group $this$fileName) {
        String sourceFile;
        SourceLocation location = $this$fileName.getLocation();
        return (location == null || (sourceFile = location.getSourceFile()) == null) ? "" : sourceFile;
    }

    private final int getLineNumber(Group $this$lineNumber) {
        SourceLocation location = $this$lineNumber.getLocation();
        if (location != null) {
            return location.getLineNumber();
        }
        return -1;
    }

    private final boolean hasNullSourcePosition(Group $this$hasNullSourcePosition) {
        return (getFileName($this$hasNullSourcePosition).length() == 0) && getLineNumber($this$hasNullSourcePosition) == -1;
    }

    private final boolean isNullGroup(Group $this$isNullGroup) {
        return hasNullSourcePosition($this$isNullGroup) && $this$isNullGroup.getChildren().isEmpty();
    }

    private final ViewInfo toViewInfo(Group $this$toViewInfo) {
        String str;
        if ($this$toViewInfo.getChildren().size() == 1 && hasNullSourcePosition($this$toViewInfo)) {
            return toViewInfo((Group) CollectionsKt.single($this$toViewInfo.getChildren()));
        }
        Iterable $this$filter$iv = $this$toViewInfo.getChildren();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            Group it = (Group) element$iv$iv;
            if (!isNullGroup(it)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Group it2 = (Group) item$iv$iv;
            destination$iv$iv2.add(toViewInfo(it2));
        }
        List childrenViewInfo = (List) destination$iv$iv2;
        SourceLocation location = $this$toViewInfo.getLocation();
        if (location == null || (str = location.getSourceFile()) == null) {
            str = "";
        }
        String str2 = str;
        SourceLocation location2 = $this$toViewInfo.getLocation();
        return new ViewInfo(str2, location2 != null ? location2.getLineNumber() : -1, $this$toViewInfo.getBox(), $this$toViewInfo.getLocation(), childrenViewInfo);
    }

    private final /* synthetic */ <T> List<T> findRememberCall(Collection<? extends Group> collection) {
        int $i$f$findRememberCall;
        List rememberCalls;
        T t;
        int $i$f$findRememberCall2 = 0;
        Collection<? extends Group> $this$mapNotNull$iv = collection;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Group it = (Group) element$iv$iv$iv;
            Group it2 = firstOrNull(it, ComposeViewAdapter$findRememberCall$rememberCalls$1$1.INSTANCE);
            if (it2 != null) {
                destination$iv$iv.add(it2);
            }
        }
        List rememberCalls2 = (List) destination$iv$iv;
        List $this$mapNotNull$iv2 = rememberCalls2;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
            Group it3 = (Group) element$iv$iv$iv2;
            Iterable $this$firstOrNull$iv = it3.getData();
            Iterator<T> it4 = $this$firstOrNull$iv.iterator();
            while (true) {
                $i$f$findRememberCall = $i$f$findRememberCall2;
                if (it4.hasNext()) {
                    t = it4.next();
                    rememberCalls = rememberCalls2;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (t instanceof Object) {
                        break;
                    }
                    $i$f$findRememberCall2 = $i$f$findRememberCall;
                    rememberCalls2 = rememberCalls;
                } else {
                    rememberCalls = rememberCalls2;
                    t = null;
                    break;
                }
            }
            Intrinsics.reifiedOperationMarker(2, "T");
            if (t != null) {
                destination$iv$iv2.add(t);
                $i$f$findRememberCall2 = $i$f$findRememberCall;
                rememberCalls2 = rememberCalls;
            } else {
                $i$f$findRememberCall2 = $i$f$findRememberCall;
                rememberCalls2 = rememberCalls;
            }
        }
        return (List) destination$iv$iv2;
    }

    /* compiled from: ComposeViewAdapter.kt */
    @Metadata(m286d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0006\u0010\u0013\u001a\u00020\u0005R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, m287d2 = {"Landroidx/compose/ui/tooling/ComposeViewAdapter$Search;", "T", "", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "animations", "", "getAnimations", "()Ljava/util/Set;", "getTrackAnimation", "()Lkotlin/jvm/functions/Function1;", "hasAnimations", "", "parse", "treeWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "track", "ui-tooling_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    private static class Search<T> {
        private final Set<T> animations;
        private final Function1<Object, Unit> trackAnimation;

        public Search(Function1<Object, Unit> trackAnimation) {
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
            this.trackAnimation = trackAnimation;
            this.animations = new LinkedHashSet();
        }

        public final Function1<Object, Unit> getTrackAnimation() {
            return this.trackAnimation;
        }

        public final Set<T> getAnimations() {
            return this.animations;
        }

        public void parse(Collection<? extends Group> treeWithLocation) {
            Intrinsics.checkNotNullParameter(treeWithLocation, "treeWithLocation");
        }

        public final boolean hasAnimations() {
            return !this.animations.isEmpty();
        }

        public final void track() {
            Iterable $this$forEach$iv = CollectionsKt.reversed(this.animations);
            for (Object element$iv : $this$forEach$iv) {
                this.trackAnimation.invoke(element$iv);
            }
        }
    }

    /* compiled from: ComposeViewAdapter.kt */
    @Metadata(m286d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0012\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J0\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000f\"\b\b\u0001\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0004R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m287d2 = {"Landroidx/compose/ui/tooling/ComposeViewAdapter$RememberSearch;", "T", "", "Landroidx/compose/ui/tooling/ComposeViewAdapter$Search;", "clazz", "Lkotlin/reflect/KClass;", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)V", "parse", "treeWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "findRememberCallWithType", "", "ui-tooling_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    private static class RememberSearch<T> extends Search<T> {
        private final KClass<T> clazz;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RememberSearch(KClass<T> clazz, Function1<Object, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
            this.clazz = clazz;
        }

        @Override // androidx.compose.ui.tooling.ComposeViewAdapter.Search
        public void parse(Collection<? extends Group> treeWithLocation) {
            Intrinsics.checkNotNullParameter(treeWithLocation, "treeWithLocation");
            getAnimations().addAll(CollectionsKt.toSet(findRememberCallWithType(treeWithLocation, this.clazz)));
        }

        protected final <T> List<T> findRememberCallWithType(Collection<? extends Group> collection, KClass<T> clazz) {
            Object obj;
            Class<?> cls;
            Intrinsics.checkNotNullParameter(collection, "<this>");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Collection<? extends Group> $this$filter$iv = collection;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Group call = (Group) element$iv$iv;
                if (Intrinsics.areEqual(call.getName(), "remember")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable rememberCalls = (List) destination$iv$iv;
            Iterable $this$mapNotNull$iv = rememberCalls;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                Group it = (Group) element$iv$iv$iv;
                Iterable $this$firstOrNull$iv = it.getData();
                Iterator<T> it2 = $this$firstOrNull$iv.iterator();
                while (true) {
                    KClass kClass = null;
                    if (it2.hasNext()) {
                        Object element$iv = it2.next();
                        if (element$iv != null && (cls = element$iv.getClass()) != null) {
                            kClass = JvmClassMappingKt.getKotlinClass(cls);
                        }
                        if (Intrinsics.areEqual(kClass, clazz)) {
                            obj = element$iv;
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                Object it$iv$iv = KClasses.safeCast(clazz, obj);
                if (it$iv$iv != null) {
                    destination$iv$iv2.add(it$iv$iv);
                }
            }
            return (List) destination$iv$iv2;
        }
    }

    /* compiled from: ComposeViewAdapter.kt */
    @Metadata(m286d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, m287d2 = {"Landroidx/compose/ui/tooling/ComposeViewAdapter$AnimateXAsStateSearch;", "Landroidx/compose/ui/tooling/ComposeViewAdapter$Search;", "Landroidx/compose/animation/core/Animatable;", "trackAnimation", "Lkotlin/Function1;", "", "", "(Landroidx/compose/ui/tooling/ComposeViewAdapter;Lkotlin/jvm/functions/Function1;)V", "parse", "treeWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "ui-tooling_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    private final class AnimateXAsStateSearch extends Search<Animatable<?, ?>> {
        final /* synthetic */ ComposeViewAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimateXAsStateSearch(ComposeViewAdapter this$0, Function1<Object, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
            this.this$0 = this$0;
        }

        @Override // androidx.compose.ui.tooling.ComposeViewAdapter.Search
        public void parse(Collection<? extends Group> treeWithLocation) {
            Iterable $this$mapNotNull$iv$iv;
            Object obj;
            Intrinsics.checkNotNullParameter(treeWithLocation, "treeWithLocation");
            Set<Animatable<?, ?>> animations = getAnimations();
            Collection<? extends Group> $this$filter$iv = treeWithLocation;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Group call = (Group) element$iv$iv;
                if (Intrinsics.areEqual(call.getName(), "animateValueAsState")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$mapNotNull$iv = (List) destination$iv$iv;
            ComposeViewAdapter composeViewAdapter = this.this$0;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                Group animateValue = (Group) element$iv$iv$iv;
                Iterable $this$findRememberCall$iv = animateValue.getChildren();
                ComposeViewAdapter this_$iv = composeViewAdapter;
                Collection destination$iv$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv$iv : $this$findRememberCall$iv) {
                    Group it$iv = (Group) element$iv$iv$iv$iv;
                    ComposeViewAdapter composeViewAdapter2 = composeViewAdapter;
                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                    ComposeViewAdapter this_$iv2 = this_$iv;
                    Group it$iv2 = this_$iv2.firstOrNull(it$iv, ComposeViewAdapter$findRememberCall$rememberCalls$1$1.INSTANCE);
                    if (it$iv2 != null) {
                        destination$iv$iv$iv.add(it$iv2);
                        this_$iv = this_$iv2;
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        composeViewAdapter = composeViewAdapter2;
                    } else {
                        this_$iv = this_$iv2;
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        composeViewAdapter = composeViewAdapter2;
                    }
                }
                ComposeViewAdapter composeViewAdapter3 = composeViewAdapter;
                Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                Iterable rememberCalls$iv = (List) destination$iv$iv$iv;
                Iterable $this$mapNotNull$iv$iv2 = rememberCalls$iv;
                int $i$f$mapNotNull = 0;
                Collection destination$iv$iv$iv2 = new ArrayList();
                for (Object element$iv$iv$iv$iv2 : $this$mapNotNull$iv$iv2) {
                    Group it$iv3 = (Group) element$iv$iv$iv$iv2;
                    Iterable $this$firstOrNull$iv$iv = it$iv3.getData();
                    Iterator it = $this$firstOrNull$iv$iv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            $this$mapNotNull$iv$iv = $this$mapNotNull$iv$iv2;
                            obj = null;
                            break;
                        }
                        Object element$iv$iv2 = it.next();
                        $this$mapNotNull$iv$iv = $this$mapNotNull$iv$iv2;
                        if (element$iv$iv2 instanceof Animatable) {
                            obj = element$iv$iv2;
                            break;
                        }
                        $this$mapNotNull$iv$iv2 = $this$mapNotNull$iv$iv;
                    }
                    int $i$f$mapNotNull2 = $i$f$mapNotNull;
                    Animatable animatable = (Animatable) (obj instanceof Animatable ? obj : null);
                    if (animatable != null) {
                        destination$iv$iv$iv2.add(animatable);
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                        $this$mapNotNull$iv$iv2 = $this$mapNotNull$iv$iv;
                    } else {
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                        $this$mapNotNull$iv$iv2 = $this$mapNotNull$iv$iv;
                    }
                }
                Animatable animatable2 = (Animatable) CollectionsKt.firstOrNull((List) destination$iv$iv$iv2);
                if (animatable2 != null) {
                    destination$iv$iv2.add(animatable2);
                    $this$mapNotNull$iv = $this$mapNotNull$iv3;
                    composeViewAdapter = composeViewAdapter3;
                } else {
                    $this$mapNotNull$iv = $this$mapNotNull$iv3;
                    composeViewAdapter = composeViewAdapter3;
                }
            }
            animations.addAll(CollectionsKt.toSet((List) destination$iv$iv2));
        }
    }

    /* compiled from: ComposeViewAdapter.kt */
    @Metadata(m286d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, m287d2 = {"Landroidx/compose/ui/tooling/ComposeViewAdapter$AnimateContentSizeSearch;", "Landroidx/compose/ui/tooling/ComposeViewAdapter$Search;", "", "trackAnimation", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "parse", "treeWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "ui-tooling_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    private static final class AnimateContentSizeSearch extends Search<Object> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimateContentSizeSearch(Function1<Object, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.compose.ui.tooling.ComposeViewAdapter.Search
        public void parse(Collection<? extends Group> treeWithLocation) {
            String str;
            Iterable $this$mapNotNull$iv;
            Class<?> cls;
            Intrinsics.checkNotNullParameter(treeWithLocation, "treeWithLocation");
            Set<Object> animations = getAnimations();
            Collection<? extends Group> $this$filter$iv = treeWithLocation;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Group call = (Group) element$iv$iv;
                if (Intrinsics.areEqual(call.getName(), "remember")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$mapNotNull$iv2 = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv2) {
                Group it = (Group) element$iv$iv$iv;
                Iterable $this$firstOrNull$iv = it.getData();
                Iterator it2 = $this$firstOrNull$iv.iterator();
                while (true) {
                    str = null;
                    if (!it2.hasNext()) {
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        break;
                    }
                    Object next = it2.next();
                    if (next != 0 && (cls = next.getClass()) != null) {
                        str = cls.getName();
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    if (Intrinsics.areEqual(str, "androidx.compose.animation.SizeAnimationModifier")) {
                        str = next;
                        break;
                    }
                    $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                }
                if (str != null) {
                    destination$iv$iv2.add(str);
                    $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                } else {
                    $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                }
            }
            animations.addAll(CollectionsKt.toSet((List) destination$iv$iv2));
        }
    }

    /* compiled from: ComposeViewAdapter.kt */
    @Metadata(m286d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, m287d2 = {"Landroidx/compose/ui/tooling/ComposeViewAdapter$TransitionSearch;", "Landroidx/compose/ui/tooling/ComposeViewAdapter$Search;", "Landroidx/compose/animation/core/Transition;", "", "trackAnimation", "Lkotlin/Function1;", "", "(Landroidx/compose/ui/tooling/ComposeViewAdapter;Lkotlin/jvm/functions/Function1;)V", "parse", "treeWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "ui-tooling_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    private final class TransitionSearch extends Search<Transition<Object>> {
        final /* synthetic */ ComposeViewAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransitionSearch(ComposeViewAdapter this$0, Function1<Object, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
            this.this$0 = this$0;
        }

        @Override // androidx.compose.ui.tooling.ComposeViewAdapter.Search
        public void parse(Collection<? extends Group> treeWithLocation) {
            List rememberCalls$iv;
            Object obj;
            Intrinsics.checkNotNullParameter(treeWithLocation, "treeWithLocation");
            Set<Transition<Object>> animations = getAnimations();
            ComposeViewAdapter this_$iv = this.this$0;
            Collection<? extends Group> $this$filter$iv = treeWithLocation;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Group it = (Group) element$iv$iv;
                if (Intrinsics.areEqual(it.getName(), "updateTransition")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$findRememberCall$iv = (Collection) ((List) destination$iv$iv);
            Collection destination$iv$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv$iv : $this$findRememberCall$iv) {
                Group it$iv = (Group) element$iv$iv$iv$iv;
                Group it$iv2 = this_$iv.firstOrNull(it$iv, ComposeViewAdapter$findRememberCall$rememberCalls$1$1.INSTANCE);
                if (it$iv2 != null) {
                    destination$iv$iv$iv.add(it$iv2);
                }
            }
            List rememberCalls$iv2 = (List) destination$iv$iv$iv;
            List $this$mapNotNull$iv$iv = rememberCalls$iv2;
            Collection destination$iv$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv$iv2 : $this$mapNotNull$iv$iv) {
                Group it$iv3 = (Group) element$iv$iv$iv$iv2;
                Iterator it2 = it$iv3.getData().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        rememberCalls$iv = rememberCalls$iv2;
                        obj = null;
                        break;
                    }
                    Object element$iv$iv2 = it2.next();
                    rememberCalls$iv = rememberCalls$iv2;
                    if (element$iv$iv2 instanceof Transition) {
                        obj = element$iv$iv2;
                        break;
                    }
                    rememberCalls$iv2 = rememberCalls$iv;
                }
                Iterable $this$firstOrNull$iv$iv = $this$mapNotNull$iv$iv;
                Transition transition = (Transition) (obj instanceof Transition ? obj : null);
                if (transition != null) {
                    destination$iv$iv$iv2.add(transition);
                    $this$mapNotNull$iv$iv = $this$firstOrNull$iv$iv;
                    rememberCalls$iv2 = rememberCalls$iv;
                } else {
                    $this$mapNotNull$iv$iv = $this$firstOrNull$iv$iv;
                    rememberCalls$iv2 = rememberCalls$iv;
                }
            }
            animations.addAll((List) destination$iv$iv$iv2);
        }
    }

    /* compiled from: ComposeViewAdapter.kt */
    @Metadata(m286d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, m287d2 = {"Landroidx/compose/ui/tooling/ComposeViewAdapter$AnimatedVisibilitySearch;", "Landroidx/compose/ui/tooling/ComposeViewAdapter$Search;", "Landroidx/compose/animation/core/Transition;", "", "trackAnimation", "Lkotlin/Function1;", "", "(Landroidx/compose/ui/tooling/ComposeViewAdapter;Lkotlin/jvm/functions/Function1;)V", "parse", "treeWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "ui-tooling_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    private final class AnimatedVisibilitySearch extends Search<Transition<Object>> {
        final /* synthetic */ ComposeViewAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimatedVisibilitySearch(ComposeViewAdapter this$0, Function1<Object, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
            this.this$0 = this$0;
        }

        @Override // androidx.compose.ui.tooling.ComposeViewAdapter.Search
        public void parse(Collection<? extends Group> treeWithLocation) {
            List rememberCalls$iv;
            Object obj;
            Object obj2;
            Intrinsics.checkNotNullParameter(treeWithLocation, "treeWithLocation");
            Set<Transition<Object>> animations = getAnimations();
            ComposeViewAdapter this_$iv = this.this$0;
            Collection<? extends Group> $this$filter$iv = treeWithLocation;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Group it = (Group) element$iv$iv;
                if (Intrinsics.areEqual(it.getName(), "AnimatedVisibility")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$mapNotNull$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                Group it2 = (Group) element$iv$iv$iv;
                Iterable $this$firstOrNull$iv = it2.getChildren();
                Iterator it3 = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    Object element$iv = it3.next();
                    Group updateTransitionCall = (Group) element$iv;
                    if (Intrinsics.areEqual(updateTransitionCall.getName(), "updateTransition")) {
                        obj2 = element$iv;
                        break;
                    }
                }
                Group group = (Group) obj2;
                if (group != null) {
                    destination$iv$iv2.add(group);
                }
            }
            Collection $this$findRememberCall$iv = (List) destination$iv$iv2;
            Collection destination$iv$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv$iv : $this$findRememberCall$iv) {
                Collection $this$findRememberCall$iv2 = $this$findRememberCall$iv;
                Group it$iv = (Group) element$iv$iv$iv$iv;
                Group it$iv2 = this_$iv.firstOrNull(it$iv, ComposeViewAdapter$findRememberCall$rememberCalls$1$1.INSTANCE);
                if (it$iv2 != null) {
                    destination$iv$iv$iv.add(it$iv2);
                    $this$findRememberCall$iv = $this$findRememberCall$iv2;
                } else {
                    $this$findRememberCall$iv = $this$findRememberCall$iv2;
                }
            }
            List rememberCalls$iv2 = (List) destination$iv$iv$iv;
            List $this$mapNotNull$iv$iv = rememberCalls$iv2;
            Collection destination$iv$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv$iv2 : $this$mapNotNull$iv$iv) {
                Group it$iv3 = (Group) element$iv$iv$iv$iv2;
                Iterator it4 = it$iv3.getData().iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        rememberCalls$iv = rememberCalls$iv2;
                        obj = null;
                        break;
                    }
                    Object element$iv$iv2 = it4.next();
                    rememberCalls$iv = rememberCalls$iv2;
                    if (element$iv$iv2 instanceof Transition) {
                        obj = element$iv$iv2;
                        break;
                    }
                    rememberCalls$iv2 = rememberCalls$iv;
                }
                Iterable $this$firstOrNull$iv$iv = $this$mapNotNull$iv$iv;
                if (!(obj instanceof Transition)) {
                    obj = null;
                }
                Transition transition = (Transition) obj;
                if (transition != null) {
                    destination$iv$iv$iv2.add(transition);
                    $this$mapNotNull$iv$iv = $this$firstOrNull$iv$iv;
                    rememberCalls$iv2 = rememberCalls$iv;
                } else {
                    $this$mapNotNull$iv$iv = $this$firstOrNull$iv$iv;
                    rememberCalls$iv2 = rememberCalls$iv;
                }
            }
            animations.addAll((List) destination$iv$iv$iv2);
        }
    }

    /* compiled from: ComposeViewAdapter.kt */
    @Metadata(m286d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, m287d2 = {"Landroidx/compose/ui/tooling/ComposeViewAdapter$AnimatedContentSearch;", "Landroidx/compose/ui/tooling/ComposeViewAdapter$Search;", "Landroidx/compose/animation/core/Transition;", "", "trackAnimation", "Lkotlin/Function1;", "", "(Landroidx/compose/ui/tooling/ComposeViewAdapter;Lkotlin/jvm/functions/Function1;)V", "parse", "treeWithLocation", "", "Landroidx/compose/ui/tooling/data/Group;", "ui-tooling_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    private final class AnimatedContentSearch extends Search<Transition<Object>> {
        final /* synthetic */ ComposeViewAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimatedContentSearch(ComposeViewAdapter this$0, Function1<Object, Unit> trackAnimation) {
            super(trackAnimation);
            Intrinsics.checkNotNullParameter(trackAnimation, "trackAnimation");
            this.this$0 = this$0;
        }

        @Override // androidx.compose.ui.tooling.ComposeViewAdapter.Search
        public void parse(Collection<? extends Group> treeWithLocation) {
            List rememberCalls$iv;
            Object obj;
            Object obj2;
            Intrinsics.checkNotNullParameter(treeWithLocation, "treeWithLocation");
            Set<Transition<Object>> animations = getAnimations();
            ComposeViewAdapter this_$iv = this.this$0;
            Collection<? extends Group> $this$filter$iv = treeWithLocation;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Group it = (Group) element$iv$iv;
                if (Intrinsics.areEqual(it.getName(), "AnimatedContent")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$mapNotNull$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                Group it2 = (Group) element$iv$iv$iv;
                Iterable $this$firstOrNull$iv = it2.getChildren();
                Iterator it3 = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    Object element$iv = it3.next();
                    Group updateTransitionCall = (Group) element$iv;
                    if (Intrinsics.areEqual(updateTransitionCall.getName(), "updateTransition")) {
                        obj2 = element$iv;
                        break;
                    }
                }
                Group group = (Group) obj2;
                if (group != null) {
                    destination$iv$iv2.add(group);
                }
            }
            Collection $this$findRememberCall$iv = (List) destination$iv$iv2;
            Collection destination$iv$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv$iv : $this$findRememberCall$iv) {
                Collection $this$findRememberCall$iv2 = $this$findRememberCall$iv;
                Group it$iv = (Group) element$iv$iv$iv$iv;
                Group it$iv2 = this_$iv.firstOrNull(it$iv, ComposeViewAdapter$findRememberCall$rememberCalls$1$1.INSTANCE);
                if (it$iv2 != null) {
                    destination$iv$iv$iv.add(it$iv2);
                    $this$findRememberCall$iv = $this$findRememberCall$iv2;
                } else {
                    $this$findRememberCall$iv = $this$findRememberCall$iv2;
                }
            }
            List rememberCalls$iv2 = (List) destination$iv$iv$iv;
            List $this$mapNotNull$iv$iv = rememberCalls$iv2;
            Collection destination$iv$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv$iv2 : $this$mapNotNull$iv$iv) {
                Group it$iv3 = (Group) element$iv$iv$iv$iv2;
                Iterator it4 = it$iv3.getData().iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        rememberCalls$iv = rememberCalls$iv2;
                        obj = null;
                        break;
                    }
                    Object element$iv$iv2 = it4.next();
                    rememberCalls$iv = rememberCalls$iv2;
                    if (element$iv$iv2 instanceof Transition) {
                        obj = element$iv$iv2;
                        break;
                    }
                    rememberCalls$iv2 = rememberCalls$iv;
                }
                Iterable $this$firstOrNull$iv$iv = $this$mapNotNull$iv$iv;
                if (!(obj instanceof Transition)) {
                    obj = null;
                }
                Transition transition = (Transition) obj;
                if (transition != null) {
                    destination$iv$iv$iv2.add(transition);
                    $this$mapNotNull$iv$iv = $this$firstOrNull$iv$iv;
                    rememberCalls$iv2 = rememberCalls$iv;
                } else {
                    $this$mapNotNull$iv$iv = $this$firstOrNull$iv$iv;
                    rememberCalls$iv2 = rememberCalls$iv;
                }
            }
            animations.addAll((List) destination$iv$iv$iv2);
        }
    }

    private final void processViewInfos() {
        Iterable $this$map$iv = this.slotTableRecord.getStore();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            CompositionData it = (CompositionData) item$iv$iv;
            destination$iv$iv.add(SlotTreeKt.asTree(it));
        }
        Iterable $this$map$iv2 = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            Group it2 = (Group) item$iv$iv2;
            destination$iv$iv2.add(toViewInfo(it2));
        }
        this.viewInfos = CollectionsKt.toList((List) destination$iv$iv2);
        if (this.debugViewInfos) {
            Iterable $this$forEach$iv = this.viewInfos;
            for (Object element$iv : $this$forEach$iv) {
                ViewInfo it3 = (ViewInfo) element$iv;
                walkTable$default(this, it3, 0, 2, null);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.delayedException.throwIfPresent();
        processViewInfos();
        if (this.composableName.length() > 0) {
            findAndTrackAnimations();
            if (this.lookForDesignInfoProviders) {
                findDesignInfoProviders();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        ViewTreeLifecycleOwner.set(this.composeView.getRootView(), this.FakeSavedStateRegistryOwner);
        super.onAttachedToWindow();
    }

    private final void findAndTrackAnimations() {
        boolean z;
        Iterable $this$map$iv = this.slotTableRecord.getStore();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            CompositionData it = (CompositionData) item$iv$iv;
            destination$iv$iv.add(SlotTreeKt.asTree(it));
        }
        List slotTrees = (List) destination$iv$iv;
        TransitionSearch transitionSearch = new TransitionSearch(this, new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$transitionSearch$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                ComposeViewAdapter.this.getClock$ui_tooling_release().trackTransition((Transition) it2);
            }
        });
        AnimatedContentSearch animatedContentSearch = new AnimatedContentSearch(this, new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$animatedContentSearch$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                ComposeViewAdapter.this.getClock$ui_tooling_release().trackAnimatedContent((Transition) it2);
            }
        });
        AnimatedVisibilitySearch animatedVisibilitySearch = new AnimatedVisibilitySearch(this, new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$animatedVisibilitySearch$1
            {
                super(1);
            }

            /* compiled from: ComposeViewAdapter.kt */
            @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            /* renamed from: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$animatedVisibilitySearch$1$1, reason: invalid class name */
            /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
                AnonymousClass1(Object obj) {
                    super(0, obj, ComposeViewAdapter.class, "requestLayout", "requestLayout()V", 0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ((ComposeViewAdapter) this.receiver).requestLayout();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                ComposeViewAdapter.this.getClock$ui_tooling_release().trackAnimatedVisibility((Transition) it2, new AnonymousClass1(ComposeViewAdapter.this));
            }
        });
        Set supportedSearch = SetsKt.setOf((Object[]) new Search[]{transitionSearch, animatedVisibilitySearch});
        Collection extraSearch = UnsupportedComposeAnimation.INSTANCE.getApiAvailable() ? SetsKt.setOf((Object[]) new Search[]{animatedContentSearch, new AnimateXAsStateSearch(this, new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$extraSearch$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                ComposeViewAdapter.this.getClock$ui_tooling_release().trackAnimateXAsState((Animatable) it2);
            }
        }), new AnimateContentSizeSearch(new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$extraSearch$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                ComposeViewAdapter.this.getClock$ui_tooling_release().trackAnimateContentSize(it2);
            }
        }), new RememberSearch(Reflection.getOrCreateKotlinClass(TargetBasedAnimation.class), new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$extraSearch$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                ComposeViewAdapter.this.getClock$ui_tooling_release().trackTargetBasedAnimations((TargetBasedAnimation) it2);
            }
        }), new RememberSearch(Reflection.getOrCreateKotlinClass(DecayAnimation.class), new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$extraSearch$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                ComposeViewAdapter.this.getClock$ui_tooling_release().trackDecayAnimations((DecayAnimation) it2);
            }
        }), new RememberSearch(Reflection.getOrCreateKotlinClass(InfiniteTransition.class), new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$extraSearch$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                ComposeViewAdapter.this.getClock$ui_tooling_release().trackInfiniteTransition((InfiniteTransition) it2);
            }
        })}) : CollectionsKt.emptyList();
        Set setToTrack = SetsKt.plus(supportedSearch, (Iterable) extraSearch);
        Iterable setToSearch = SetsKt.plus(setToTrack, (Iterable) SetsKt.setOf(animatedContentSearch));
        List $this$forEach$iv = slotTrees;
        for (Object element$iv : $this$forEach$iv) {
            Group tree = (Group) element$iv;
            List treeWithLocation = findAll(tree, new Function1<Group, Boolean>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$1$treeWithLocation$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Group it2) {
                    Intrinsics.checkNotNullParameter(it2, "it");
                    return Boolean.valueOf(it2.getLocation() != null);
                }
            });
            Iterable $this$forEach$iv2 = setToSearch;
            for (Object element$iv2 : $this$forEach$iv2) {
                Search it2 = (Search) element$iv2;
                it2.parse(treeWithLocation);
                slotTrees = slotTrees;
            }
            transitionSearch.getAnimations().removeAll(animatedVisibilitySearch.getAnimations());
            transitionSearch.getAnimations().removeAll(animatedContentSearch.getAnimations());
            slotTrees = slotTrees;
        }
        Set $this$any$iv = setToTrack;
        if (!($this$any$iv instanceof Collection) || !$this$any$iv.isEmpty()) {
            Iterator it3 = $this$any$iv.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    z = false;
                    break;
                }
                Object element$iv3 = it3.next();
                Search it4 = (Search) element$iv3;
                if (it4.hasAnimations()) {
                    z = true;
                    break;
                }
            }
        } else {
            z = false;
        }
        this.hasAnimations = z;
        if (this.clock != null) {
            Set $this$forEach$iv3 = setToTrack;
            for (Object element$iv4 : $this$forEach$iv3) {
                Search it5 = (Search) element$iv4;
                it5.track();
            }
        }
    }

    private final void findDesignInfoProviders() {
        String str;
        Object slotTrees;
        Iterable $this$flatMap$iv;
        int $i$f$flatMap;
        Iterable $this$map$iv = this.slotTableRecord.getStore();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(SlotTreeKt.asTree((CompositionData) item$iv$iv));
        }
        Object it = (List) destination$iv$iv;
        Iterable $this$flatMap$iv2 = (Iterable) it;
        int $i$f$flatMap2 = 0;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv2) {
            Group rootGroup = (Group) element$iv$iv;
            Iterable $this$mapNotNull$iv = findAll(rootGroup, new Function1<Group, Boolean>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findDesignInfoProviders$1$1
                {
                    super(1);
                }

                /* JADX WARN: Removed duplicated region for block: B:22:0x0085 A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:24:? A[LOOP:0: B:9:0x0027->B:24:?, LOOP_END, SYNTHETIC] */
                @Override // kotlin.jvm.functions.Function1
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Boolean invoke(Group group) {
                    boolean z;
                    Iterable $this$any$iv;
                    Intrinsics.checkNotNullParameter(group, "group");
                    Iterable $this$any$iv2 = group.getChildren();
                    ComposeViewAdapter composeViewAdapter = ComposeViewAdapter.this;
                    boolean z2 = false;
                    if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                        Iterator it2 = $this$any$iv2.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Group child = (Group) it2.next();
                            if (Intrinsics.areEqual(child.getName(), "remember")) {
                                Iterable $this$any$iv3 = child.getData();
                                if (!($this$any$iv3 instanceof Collection) || !((Collection) $this$any$iv3).isEmpty()) {
                                    Iterator it3 = $this$any$iv3.iterator();
                                    while (true) {
                                        if (!it3.hasNext()) {
                                            $this$any$iv = null;
                                            break;
                                        }
                                        Object element$iv = it3.next();
                                        Object it4 = (element$iv != null ? composeViewAdapter.getDesignInfoMethodOrNull(element$iv) : null) != null ? 1 : null;
                                        if (it4 != null) {
                                            $this$any$iv = 1;
                                            break;
                                        }
                                    }
                                } else {
                                    $this$any$iv = null;
                                }
                                if ($this$any$iv != null) {
                                    z = true;
                                    if (!z) {
                                        z2 = true;
                                        break;
                                    }
                                }
                            }
                            z = false;
                            if (!z) {
                            }
                        }
                    }
                    return Boolean.valueOf(z2);
                }
            });
            Collection destination$iv$iv3 = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                Group group = (Group) element$iv$iv$iv;
                Iterable $this$forEach$iv = group.getChildren();
                Iterator it2 = $this$forEach$iv.iterator();
                while (true) {
                    str = null;
                    if (it2.hasNext()) {
                        Group child = (Group) it2.next();
                        Iterable $this$forEach$iv2 = child.getData();
                        Iterator it3 = $this$forEach$iv2.iterator();
                        while (it3.hasNext()) {
                            Object element$iv = it3.next();
                            slotTrees = it;
                            if ((element$iv != null ? getDesignInfoMethodOrNull(element$iv) : null) != null) {
                                $this$flatMap$iv = $this$flatMap$iv2;
                                int left = group.getBox().getLeft();
                                $i$f$flatMap = $i$f$flatMap2;
                                int $i$f$flatMap3 = group.getBox().getTop();
                                str = invokeGetDesignInfo(element$iv, left, $i$f$flatMap3);
                                break;
                            }
                            it = slotTrees;
                        }
                    } else {
                        slotTrees = it;
                        $this$flatMap$iv = $this$flatMap$iv2;
                        $i$f$flatMap = $i$f$flatMap2;
                        break;
                    }
                }
                if (str != null) {
                    destination$iv$iv3.add(str);
                    $this$flatMap$iv2 = $this$flatMap$iv;
                    it = slotTrees;
                    $i$f$flatMap2 = $i$f$flatMap;
                } else {
                    $this$flatMap$iv2 = $this$flatMap$iv;
                    it = slotTrees;
                    $i$f$flatMap2 = $i$f$flatMap;
                }
            }
            Object slotTrees2 = it;
            Iterable list$iv$iv = (List) destination$iv$iv3;
            CollectionsKt.addAll(destination$iv$iv2, list$iv$iv);
            it = slotTrees2;
        }
        this.designInfoList = (List) destination$iv$iv2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Method getDesignInfoMethodOrNull(Object $this$getDesignInfoMethodOrNull) {
        try {
            return $this$getDesignInfoMethodOrNull.getClass().getDeclaredMethod("getDesignInfo", Integer.TYPE, Integer.TYPE, String.class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private final String invokeGetDesignInfo(Object $this$invokeGetDesignInfo, int x, int y) {
        Method designInfoMethod = getDesignInfoMethodOrNull($this$invokeGetDesignInfo);
        if (designInfoMethod == null) {
            return null;
        }
        try {
            Object result = designInfoMethod.invoke($this$invokeGetDesignInfo, Integer.valueOf(x), Integer.valueOf(y), this.designInfoProvidersArgument);
            Intrinsics.checkNotNull(result, "null cannot be cast to non-null type kotlin.String");
            String str = (String) result;
            if (str.length() == 0) {
                str = null;
            }
            return str;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Group firstOrNull(Group $this$firstOrNull, Function1<? super Group, Boolean> function1) {
        return (Group) CollectionsKt.firstOrNull((List) findGroupsThatMatchPredicate($this$firstOrNull, function1, true));
    }

    private final List<Group> findAll(Group $this$findAll, Function1<? super Group, Boolean> function1) {
        return findGroupsThatMatchPredicate$default(this, $this$findAll, function1, false, 4, null);
    }

    static /* synthetic */ List findGroupsThatMatchPredicate$default(ComposeViewAdapter composeViewAdapter, Group group, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return composeViewAdapter.findGroupsThatMatchPredicate(group, function1, z);
    }

    private final List<Group> findGroupsThatMatchPredicate(Group root, Function1<? super Group, Boolean> predicate, boolean findOnlyFirst) {
        List result = new ArrayList();
        List stack = CollectionsKt.mutableListOf(root);
        while (!stack.isEmpty()) {
            Group current = (Group) CollectionsKt.removeLast(stack);
            if (predicate.invoke(current).booleanValue()) {
                if (findOnlyFirst) {
                    return CollectionsKt.listOf(current);
                }
                result.add(current);
            }
            stack.addAll(current.getChildren());
        }
        return result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void invalidateComposition() {
        this.content.setValue(ComposableSingletons$ComposeViewAdapterKt.INSTANCE.m4307getLambda3$ui_tooling_release());
        this.content.setValue(this.previewComposition);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.forceCompositionInvalidation) {
            invalidateComposition();
        }
        this.onDraw.invoke();
        if (!this.debugPaintBounds) {
            return;
        }
        Iterable $this$flatMap$iv = this.viewInfos;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            ViewInfo it = (ViewInfo) element$iv$iv;
            Iterable list$iv$iv = CollectionsKt.plus((Collection) CollectionsKt.listOf(it), (Iterable) it.allChildren());
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        for (Object element$iv : $this$forEach$iv) {
            ViewInfo it2 = (ViewInfo) element$iv;
            if (it2.hasBounds() && canvas != null) {
                Rect pxBounds = new Rect(it2.getBounds().getLeft(), it2.getBounds().getTop(), it2.getBounds().getRight(), it2.getBounds().getBottom());
                canvas.drawRect(pxBounds, this.debugBoundsPaint);
            }
        }
    }

    public final PreviewAnimationClock getClock$ui_tooling_release() {
        PreviewAnimationClock previewAnimationClock = this.clock;
        if (previewAnimationClock != null) {
            return previewAnimationClock;
        }
        Intrinsics.throwUninitializedPropertyAccessException("clock");
        return null;
    }

    public final void setClock$ui_tooling_release(PreviewAnimationClock previewAnimationClock) {
        Intrinsics.checkNotNullParameter(previewAnimationClock, "<set-?>");
        this.clock = previewAnimationClock;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void WrapPreview(final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(493526445);
        ComposerKt.sourceInformation($composer2, "C(WrapPreview)644@25685L428:ComposeViewAdapter.kt#hevd2p");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(493526445, $changed, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.WrapPreview (ComposeViewAdapter.kt:639)");
        }
        ProvidableCompositionLocal<Font.ResourceLoader> localFontLoader = CompositionLocalsKt.getLocalFontLoader();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{localFontLoader.provides(new LayoutlibFontResourceLoader(context)), localFontFamilyResolver.provides(FontFamilyResolver_androidKt.createFontFamilyResolver(context2)), LocalOnBackPressedDispatcherOwner.INSTANCE.provides(this.FakeOnBackPressedDispatcherOwner), LocalActivityResultRegistryOwner.INSTANCE.provides(this.FakeActivityResultRegistryOwner)}, ComposableLambdaKt.composableLambda($composer2, -1966112531, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$WrapPreview$1
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

            public final void invoke(Composer $composer3, int $changed2) {
                CompositionDataRecord compositionDataRecord;
                ComposerKt.sourceInformation($composer3, "C650@26066L37:ComposeViewAdapter.kt#hevd2p");
                if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1966112531, $changed2, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.WrapPreview.<anonymous> (ComposeViewAdapter.kt:649)");
                    }
                    compositionDataRecord = ComposeViewAdapter.this.slotTableRecord;
                    InspectableKt.Inspectable(compositionDataRecord, function2, $composer3, ($changed << 3) & SdkConfig.SDK_VERSION);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer3.skipToGroupEnd();
            }
        }), $composer2, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$WrapPreview$2
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

            public final void invoke(Composer composer, int i) {
                ComposeViewAdapter.this.WrapPreview(function2, composer, $changed | 1);
            }
        });
    }

    public static /* synthetic */ void init$ui_tooling_release$default(ComposeViewAdapter composeViewAdapter, String str, String str2, Class cls, int i, boolean z, boolean z2, long j, boolean z3, boolean z4, String str3, Function0 function0, Function0 function02, int i2, Object obj) {
        composeViewAdapter.init$ui_tooling_release(str, str2, (i2 & 4) != 0 ? null : cls, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? false : z2, (i2 & 64) != 0 ? -1L : j, (i2 & 128) != 0 ? false : z3, (i2 & 256) != 0 ? false : z4, (i2 & 512) != 0 ? null : str3, (i2 & 1024) != 0 ? new Function0<Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$init$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        } : function0, (i2 & 2048) != 0 ? new Function0<Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$init$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        } : function02);
    }

    public final void init$ui_tooling_release(final String className, final String methodName, final Class<? extends PreviewParameterProvider<?>> parameterProvider, final int parameterProviderIndex, boolean debugPaintBounds, boolean debugViewInfos, final long animationClockStartTime, boolean forceCompositionInvalidation, boolean lookForDesignInfoProviders, String designInfoProvidersArgument, final Function0<Unit> onCommit, Function0<Unit> onDraw) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(onCommit, "onCommit");
        Intrinsics.checkNotNullParameter(onDraw, "onDraw");
        this.debugPaintBounds = debugPaintBounds;
        this.debugViewInfos = debugViewInfos;
        this.composableName = methodName;
        this.forceCompositionInvalidation = forceCompositionInvalidation;
        this.lookForDesignInfoProviders = lookForDesignInfoProviders;
        this.designInfoProvidersArgument = designInfoProvidersArgument == null ? "" : designInfoProvidersArgument;
        this.onDraw = onDraw;
        this.previewComposition = ComposableLambdaKt.composableLambdaInstance(-1704541905, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$init$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "C701@28697L20,703@28731L2532:ComposeViewAdapter.kt#hevd2p");
                if (($changed & 11) != 2 || !$composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1704541905, $changed, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.init.<anonymous> (ComposeViewAdapter.kt:700)");
                    }
                    EffectsKt.SideEffect(onCommit, $composer, 0);
                    ComposeViewAdapter composeViewAdapter = this;
                    final long j = animationClockStartTime;
                    final ComposeViewAdapter composeViewAdapter2 = this;
                    final String str = className;
                    final String str2 = methodName;
                    final Class<? extends PreviewParameterProvider<?>> cls = parameterProvider;
                    final int i = parameterProviderIndex;
                    composeViewAdapter.WrapPreview(ComposableLambdaKt.composableLambda($composer, 1938351266, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$init$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final Composer $composer2, int $changed2) {
                            ComposerKt.sourceInformation($composer2, "C:ComposeViewAdapter.kt#hevd2p");
                            if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1938351266, $changed2, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.init.<anonymous>.<anonymous> (ComposeViewAdapter.kt:703)");
                                }
                                final String str3 = str;
                                final String str4 = str2;
                                final Class<? extends PreviewParameterProvider<?>> cls2 = cls;
                                final int i2 = i;
                                final ComposeViewAdapter composeViewAdapter3 = composeViewAdapter2;
                                Function0 composable = new Function0<Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$init$3$1$composable$1
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
                                        ThreadSafeException threadSafeException;
                                        Throwable cause;
                                        try {
                                            ComposableInvoker composableInvoker = ComposableInvoker.INSTANCE;
                                            String str5 = str3;
                                            String str6 = str4;
                                            Composer composer = $composer2;
                                            Object[] previewProviderParameters = PreviewUtilsKt.getPreviewProviderParameters(cls2, i2);
                                            composableInvoker.invokeComposable(str5, str6, composer, Arrays.copyOf(previewProviderParameters, previewProviderParameters.length));
                                        } catch (Throwable t) {
                                            Throwable exception = t;
                                            while ((exception instanceof ReflectiveOperationException) && (cause = exception.getCause()) != null) {
                                                exception = cause;
                                            }
                                            threadSafeException = composeViewAdapter3.delayedException;
                                            threadSafeException.set(exception);
                                            throw t;
                                        }
                                    }
                                };
                                if (j >= 0) {
                                    ComposeViewAdapter composeViewAdapter4 = composeViewAdapter2;
                                    final ComposeViewAdapter composeViewAdapter5 = composeViewAdapter2;
                                    composeViewAdapter4.setClock$ui_tooling_release(new PreviewAnimationClock(new Function0<Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter.init.3.1.1
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
                                            View childAt = ComposeViewAdapter.this.getChildAt(0);
                                            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.compose.ui.platform.ComposeView");
                                            ComposeView composeView = (ComposeView) childAt;
                                            KeyEvent.Callback childAt2 = composeView.getChildAt(0);
                                            ViewRootForTest viewRootForTest = childAt2 instanceof ViewRootForTest ? (ViewRootForTest) childAt2 : null;
                                            if (viewRootForTest != null) {
                                                viewRootForTest.invalidateDescendants();
                                            }
                                            Snapshot.INSTANCE.sendApplyNotifications();
                                        }
                                    }));
                                }
                                composable.invoke();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer2.skipToGroupEnd();
                        }
                    }), $composer, 70);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        });
        this.composeView.setContent(this.previewComposition);
        invalidate();
    }

    public final void dispose$ui_tooling_release() {
        this.composeView.disposeComposition();
        if (this.clock != null) {
            getClock$ui_tooling_release().dispose();
        }
        this.FakeSavedStateRegistryOwner.getLifecycleRegistry().setCurrentState(Lifecycle.State.DESTROYED);
        this.FakeViewModelStoreOwner.getViewModelStore().clear();
    }

    /* renamed from: hasAnimations, reason: from getter */
    public final boolean getHasAnimations() {
        return this.hasAnimations;
    }

    private final void init(AttributeSet attrs) {
        long animationClockStartTime;
        ViewTreeLifecycleOwner.set(this, this.FakeSavedStateRegistryOwner);
        ViewTreeSavedStateRegistryOwner.set(this, this.FakeSavedStateRegistryOwner);
        ViewTreeViewModelStoreOwner.set(this, this.FakeViewModelStoreOwner);
        addView(this.composeView);
        String composableName = attrs.getAttributeValue("http://schemas.android.com/tools", "composableName");
        if (composableName == null) {
            return;
        }
        String className = StringsKt.substringBeforeLast$default(composableName, '.', (String) null, 2, (Object) null);
        String methodName = StringsKt.substringAfterLast$default(composableName, '.', (String) null, 2, (Object) null);
        int parameterProviderIndex = attrs.getAttributeIntValue("http://schemas.android.com/tools", "parameterProviderIndex", 0);
        String attributeValue = attrs.getAttributeValue("http://schemas.android.com/tools", "parameterProviderClass");
        Class parameterProviderClass = attributeValue != null ? PreviewUtilsKt.asPreviewProviderClass(attributeValue) : null;
        try {
            String attributeValue2 = attrs.getAttributeValue("http://schemas.android.com/tools", "animationClockStartTime");
            Intrinsics.checkNotNullExpressionValue(attributeValue2, "attrs.getAttributeValue(…animationClockStartTime\")");
            animationClockStartTime = Long.parseLong(attributeValue2);
        } catch (Exception e) {
            animationClockStartTime = -1;
        }
        boolean forceCompositionInvalidation = attrs.getAttributeBooleanValue("http://schemas.android.com/tools", "forceCompositionInvalidation", false);
        init$ui_tooling_release$default(this, className, methodName, parameterProviderClass, parameterProviderIndex, attrs.getAttributeBooleanValue("http://schemas.android.com/tools", "paintBounds", this.debugPaintBounds), attrs.getAttributeBooleanValue("http://schemas.android.com/tools", "printViewInfos", this.debugViewInfos), animationClockStartTime, forceCompositionInvalidation, attrs.getAttributeBooleanValue("http://schemas.android.com/tools", "findDesignInfoProviders", this.lookForDesignInfoProviders), attrs.getAttributeValue("http://schemas.android.com/tools", "designInfoProvidersArgument"), null, null, 3072, null);
    }
}
