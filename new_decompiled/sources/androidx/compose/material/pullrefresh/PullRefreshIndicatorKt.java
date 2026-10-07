package androidx.compose.material.pullrefresh;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.ExperimentalMaterialApi;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.graphics.AndroidPath_androidKt;
import androidx.compose.p000ui.graphics.Path;
import androidx.compose.p000ui.graphics.PathFillType;
import androidx.compose.p000ui.graphics.StrokeCap;
import androidx.compose.p000ui.graphics.drawscope.DrawContext;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.graphics.drawscope.DrawTransform;
import androidx.compose.p000ui.graphics.drawscope.Stroke;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.app.NotificationCompat;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: PullRefreshIndicator.kt */
@Metadata(m286d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0002\u001a-\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aM\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u00162\b\b\u0002\u0010\u001f\u001a\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u001dH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a9\u0010#\u001a\u00020\u0012*\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u000fH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\r\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006,"}, m287d2 = {"ArcRadius", "Landroidx/compose/ui/unit/Dp;", "F", "ArrowHeight", "ArrowWidth", "CrossfadeDurationMs", "", "Elevation", "IndicatorSize", "MaxProgressArc", "", "SpinnerShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "StrokeWidth", "ArrowValues", "Landroidx/compose/material/pullrefresh/ArrowValues;", NotificationCompat.CATEGORY_PROGRESS, "CircularArrowIndicator", "", "state", "Landroidx/compose/material/pullrefresh/PullRefreshState;", "color", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "CircularArrowIndicator-iJQMabo", "(Landroidx/compose/material/pullrefresh/PullRefreshState;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "PullRefreshIndicator", "refreshing", "", "backgroundColor", "contentColor", "scale", "PullRefreshIndicator-jB83MbM", "(ZLandroidx/compose/material/pullrefresh/PullRefreshState;Landroidx/compose/ui/Modifier;JJZLandroidx/compose/runtime/Composer;II)V", "drawArrow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "values", "drawArrow-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JLandroidx/compose/material/pullrefresh/ArrowValues;)V", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class PullRefreshIndicatorKt {
    private static final int CrossfadeDurationMs = 100;
    private static final float MaxProgressArc = 0.8f;
    private static final float IndicatorSize = C0504Dp.m4382constructorimpl(40);
    private static final RoundedCornerShape SpinnerShape = RoundedCornerShapeKt.getCircleShape();
    private static final float ArcRadius = C0504Dp.m4382constructorimpl((float) 7.5d);
    private static final float StrokeWidth = C0504Dp.m4382constructorimpl((float) 2.5d);
    private static final float ArrowWidth = C0504Dp.m4382constructorimpl(10);
    private static final float ArrowHeight = C0504Dp.m4382constructorimpl(5);
    private static final float Elevation = C0504Dp.m4382constructorimpl(6);

    @ExperimentalMaterialApi
    /* renamed from: PullRefreshIndicator-jB83MbM, reason: not valid java name */
    public static final void m1598PullRefreshIndicatorjB83MbM(final boolean refreshing, final PullRefreshState state, Modifier modifier, long backgroundColor, long contentColor, boolean scale, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long backgroundColor2;
        long contentColor2;
        int $dirty;
        boolean scale2;
        Object key1$iv;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer2 = $composer.startRestartGroup(308716636);
        ComposerKt.sourceInformation($composer2, "C(PullRefreshIndicator)P(3,5,2,0:c#ui.graphics.Color,1:c#ui.graphics.Color)75@3228L6,76@3270L32,79@3360L98,83@3464L1047:PullRefreshIndicator.kt#t44y28");
        int $dirty2 = $changed;
        if ((i & 4) != 0) {
            modifier2 = Modifier.INSTANCE;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) == 0) {
            backgroundColor2 = backgroundColor;
        } else {
            long backgroundColor3 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1321getSurface0d7_KjU();
            $dirty2 &= -7169;
            backgroundColor2 = backgroundColor3;
        }
        if ((i & 16) == 0) {
            contentColor2 = contentColor;
            $dirty = $dirty2;
        } else {
            long contentColor3 = ColorsKt.m1335contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 9) & 14);
            $dirty = $dirty2 & (-57345);
            contentColor2 = contentColor3;
        }
        if ((i & 32) == 0) {
            scale2 = scale;
        } else {
            scale2 = false;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(308716636, $dirty, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator (PullRefreshIndicator.kt:71)");
        }
        Object key1$iv2 = Boolean.valueOf(refreshing);
        int i2 = ($dirty & 14) | 64;
        $composer2.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer2.changed(key1$iv2) | $composer2.changed(state);
        Object it$iv$iv = $composer2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            key1$iv = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$showElevation$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(refreshing || state.getPosition$material_release() > 0.5f);
                }
            });
            $composer2.updateRememberedValue(key1$iv);
        } else {
            key1$iv = it$iv$iv;
        }
        $composer2.endReplaceableGroup();
        State showElevation$delegate = (State) key1$iv;
        final int i3 = $dirty;
        final long j = contentColor2;
        SurfaceKt.m1513SurfaceFjzlyU(PullRefreshIndicatorTransformKt.pullRefreshIndicatorTransform(SizeKt.m800size3ABfNKs(modifier2, IndicatorSize), state, scale2), SpinnerShape, backgroundColor2, 0L, null, m1599PullRefreshIndicator_jB83MbM$lambda1(showElevation$delegate) ? Elevation : C0504Dp.m4382constructorimpl(0), ComposableLambdaKt.composableLambda($composer2, -194757728, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer3, int $changed2) {
                ComposerKt.sourceInformation($composer3, "C91@3731L774:PullRefreshIndicator.kt#t44y28");
                if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-194757728, $changed2, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator.<anonymous> (PullRefreshIndicator.kt:90)");
                    }
                    Boolean valueOf = Boolean.valueOf(refreshing);
                    TweenSpec tween$default = AnimationSpecKt.tween$default(100, 0, null, 6, null);
                    final long j2 = j;
                    final int i4 = i3;
                    final PullRefreshState pullRefreshState = state;
                    CrossfadeKt.Crossfade(valueOf, null, tween$default, ComposableLambdaKt.composableLambda($composer3, -2067838016, true, new Function3<Boolean, Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Composer composer, Integer num) {
                            invoke(bool.booleanValue(), composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean refreshing2, Composer $composer4, int $changed3) {
                            float arg0$iv;
                            float other$iv;
                            float f;
                            ComposerKt.sourceInformation($composer4, "C95@3890L605:PullRefreshIndicator.kt#t44y28");
                            int $dirty3 = $changed3;
                            if (($changed3 & 14) == 0) {
                                $dirty3 |= $composer4.changed(refreshing2) ? 4 : 2;
                            }
                            if (($dirty3 & 91) == 18 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2067838016, $changed3, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator.<anonymous>.<anonymous> (PullRefreshIndicator.kt:94)");
                            }
                            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                            long j3 = j2;
                            int i5 = i4;
                            PullRefreshState pullRefreshState2 = pullRefreshState;
                            $composer4.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((54 >> 3) & 14) | ((54 >> 3) & SdkConfig.SDK_VERSION));
                            int $changed$iv$iv = (54 << 3) & SdkConfig.SDK_VERSION;
                            $composer4.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume = $composer4.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            Density density$iv$iv = (Density) consume;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume2 = $composer4.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume3 = $composer4.consume(localViewConfiguration);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                $composer4.createNode(factory$iv$iv$iv);
                            } else {
                                $composer4.useNode();
                            }
                            $composer4.disableReusing();
                            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer4);
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            $composer4.enableReusing();
                            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                            $composer4.startReplaceableGroup(2058660585);
                            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                            $composer4.startReplaceableGroup(-2137368960);
                            ComposerKt.sourceInformation($composer4, "C72@3384L9:Box.kt#2w3rfo");
                            if (($changed$iv & 11) == 2 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                            } else {
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                int $changed4 = ((54 >> 6) & SdkConfig.SDK_VERSION) | 6;
                                Composer $composer5 = $composer4;
                                $composer5.startReplaceableGroup(831079366);
                                ComposerKt.sourceInformation($composer5, "C:PullRefreshIndicator.kt#t44y28");
                                if (($changed4 & 81) == 16 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                } else {
                                    arg0$iv = PullRefreshIndicatorKt.ArcRadius;
                                    other$iv = PullRefreshIndicatorKt.StrokeWidth;
                                    float arg0$iv2 = C0504Dp.m4382constructorimpl(2 * C0504Dp.m4382constructorimpl(arg0$iv + other$iv));
                                    if (refreshing2) {
                                        $composer5.startReplaceableGroup(-2035147616);
                                        ComposerKt.sourceInformation($composer5, "102@4138L208");
                                        f = PullRefreshIndicatorKt.StrokeWidth;
                                        ProgressIndicatorKt.m1455CircularProgressIndicatoraMcp0Q(SizeKt.m800size3ABfNKs(Modifier.INSTANCE, arg0$iv2), j3, f, $composer5, ((i5 >> 9) & SdkConfig.SDK_VERSION) | 390, 0);
                                        $composer5.endReplaceableGroup();
                                        $composer5 = $composer5;
                                    } else {
                                        $composer5.startReplaceableGroup(-2035147362);
                                        ComposerKt.sourceInformation($composer5, "108@4392L71");
                                        PullRefreshIndicatorKt.m1597CircularArrowIndicatoriJQMabo(pullRefreshState2, j3, SizeKt.m800size3ABfNKs(Modifier.INSTANCE, arg0$iv2), $composer5, ((i5 >> 9) & SdkConfig.SDK_VERSION) | 392);
                                        $composer5.endReplaceableGroup();
                                    }
                                }
                                $composer5.endReplaceableGroup();
                            }
                            $composer4.endReplaceableGroup();
                            $composer4.endReplaceableGroup();
                            $composer4.endNode();
                            $composer4.endReplaceableGroup();
                            $composer4.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), $composer3, (i3 & 14) | 3456, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer3.skipToGroupEnd();
            }
        }), $composer2, (($dirty >> 3) & 896) | 1572912, 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = modifier2;
        final boolean scale3 = scale2;
        final long j2 = backgroundColor2;
        final long backgroundColor4 = contentColor2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i4) {
                PullRefreshIndicatorKt.m1598PullRefreshIndicatorjB83MbM(refreshing, state, modifier3, j2, backgroundColor4, scale3, composer, $changed | 1, i);
            }
        });
    }

    /* renamed from: PullRefreshIndicator_jB83MbM$lambda-1, reason: not valid java name */
    private static final boolean m1599PullRefreshIndicator_jB83MbM$lambda1(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalMaterialApi
    /* renamed from: CircularArrowIndicator-iJQMabo, reason: not valid java name */
    public static final void m1597CircularArrowIndicatoriJQMabo(final PullRefreshState state, final long color, final Modifier modifier, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-486016981);
        ComposerKt.sourceInformation($composer2, "C(CircularArrowIndicator)P(2,0:c#ui.graphics.Color)125@4722L61,127@4789L998:PullRefreshIndicator.kt#t44y28");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-486016981, $changed, -1, "androidx.compose.material.pullrefresh.CircularArrowIndicator (PullRefreshIndicator.kt:120)");
        }
        $composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer2.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            Path $this$CircularArrowIndicator_iJQMabo_u24lambda_u2d3_u24lambda_u2d2 = AndroidPath_androidKt.Path();
            $this$CircularArrowIndicator_iJQMabo_u24lambda_u2d3_u24lambda_u2d2.mo1894setFillTypeoQ8Xj4U(PathFillType.INSTANCE.m2239getEvenOddRgk1Os());
            value$iv$iv = $this$CircularArrowIndicator_iJQMabo_u24lambda_u2d3_u24lambda_u2d2;
            $composer2.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer2.endReplaceableGroup();
        final Path path = (Path) value$iv$iv;
        CanvasKt.Canvas(SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semantics) {
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                SemanticsPropertiesKt.setContentDescription(semantics, "Refreshing");
            }
        }, 1, null), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope Canvas) {
                ArrowValues values;
                float f;
                float f2;
                float f3;
                Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                values = PullRefreshIndicatorKt.ArrowValues(PullRefreshState.this.getProgress());
                float degrees$iv = values.getRotation();
                long j = color;
                Path path2 = path;
                long pivot$iv = Canvas.mo2489getCenterF1C5BW0();
                DrawContext $this$withTransform_u24lambda_u2d6$iv$iv = Canvas.getDrawContext();
                long previousSize$iv$iv = $this$withTransform_u24lambda_u2d6$iv$iv.mo2415getSizeNHjbRc();
                $this$withTransform_u24lambda_u2d6$iv$iv.getCanvas().save();
                DrawTransform $this$rotate_Rg1IO4c_u24lambda_u2d0$iv = $this$withTransform_u24lambda_u2d6$iv$iv.getTransform();
                $this$rotate_Rg1IO4c_u24lambda_u2d0$iv.mo2421rotateUv8p0NA(degrees$iv, pivot$iv);
                f = PullRefreshIndicatorKt.ArcRadius;
                float f4 = Canvas.mo648toPx0680j_4(f);
                f2 = PullRefreshIndicatorKt.StrokeWidth;
                float arcRadius = f4 + (Canvas.mo648toPx0680j_4(f2) / 2.0f);
                Rect arcBounds = new Rect(Offset.m1760getXimpl(androidx.compose.p000ui.geometry.SizeKt.m1839getCenteruvyYCjk(Canvas.mo2490getSizeNHjbRc())) - arcRadius, Offset.m1761getYimpl(androidx.compose.p000ui.geometry.SizeKt.m1839getCenteruvyYCjk(Canvas.mo2490getSizeNHjbRc())) - arcRadius, Offset.m1760getXimpl(androidx.compose.p000ui.geometry.SizeKt.m1839getCenteruvyYCjk(Canvas.mo2490getSizeNHjbRc())) + arcRadius, Offset.m1761getYimpl(androidx.compose.p000ui.geometry.SizeKt.m1839getCenteruvyYCjk(Canvas.mo2490getSizeNHjbRc())) + arcRadius);
                float alpha = values.getAlpha();
                float startAngle = values.getStartAngle();
                float endAngle = values.getEndAngle() - values.getStartAngle();
                long m1795getTopLeftF1C5BW0 = arcBounds.m1795getTopLeftF1C5BW0();
                long m1793getSizeNHjbRc = arcBounds.m1793getSizeNHjbRc();
                f3 = PullRefreshIndicatorKt.StrokeWidth;
                DrawScope.m2470drawArcyD3GUKo$default(Canvas, j, startAngle, endAngle, false, m1795getTopLeftF1C5BW0, m1793getSizeNHjbRc, alpha, new Stroke(Canvas.mo648toPx0680j_4(f3), 0.0f, StrokeCap.INSTANCE.m2302getSquareKaPHkGw(), 0, null, 26, null), null, 0, 768, null);
                PullRefreshIndicatorKt.m1602drawArrow42QJj7c(Canvas, path2, arcBounds, j, values);
                $this$withTransform_u24lambda_u2d6$iv$iv.getCanvas().restore();
                $this$withTransform_u24lambda_u2d6$iv$iv.mo2416setSizeuvyYCjk(previousSize$iv$iv);
            }
        }, $composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                PullRefreshIndicatorKt.m1597CircularArrowIndicatoriJQMabo(PullRefreshState.this, color, modifier, composer, $changed | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrowValues ArrowValues(float progress) {
        float adjustedPercent = (Math.max(Math.min(1.0f, progress) - 0.4f, 0.0f) * 5) / 3;
        float overshootPercent = Math.abs(progress) - 1.0f;
        float linearTension = RangesKt.coerceIn(overshootPercent, 0.0f, 2.0f);
        float tensionPercent = linearTension - (((float) Math.pow(linearTension, 2)) / 4);
        float alpha = RangesKt.coerceIn(progress, 0.0f, 1.0f);
        float endTrim = adjustedPercent * MaxProgressArc;
        float rotation = (((0.4f * adjustedPercent) - 0.25f) + tensionPercent) * 0.5f;
        float f = 360;
        float startAngle = rotation * f;
        float endAngle = (rotation + endTrim) * f;
        float scale = Math.min(1.0f, adjustedPercent);
        return new ArrowValues(alpha, rotation, startAngle, endAngle, scale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawArrow-42QJj7c, reason: not valid java name */
    public static final void m1602drawArrow42QJj7c(DrawScope $this$drawArrow_u2d42QJj7c, Path arrow, Rect bounds, long color, ArrowValues values) {
        arrow.reset();
        arrow.moveTo(0.0f, 0.0f);
        arrow.lineTo($this$drawArrow_u2d42QJj7c.mo648toPx0680j_4(ArrowWidth) * values.getScale(), 0.0f);
        arrow.lineTo(($this$drawArrow_u2d42QJj7c.mo648toPx0680j_4(ArrowWidth) * values.getScale()) / 2, $this$drawArrow_u2d42QJj7c.mo648toPx0680j_4(ArrowHeight) * values.getScale());
        float radius = Math.min(bounds.getWidth(), bounds.getHeight()) / 2.0f;
        float inset = ($this$drawArrow_u2d42QJj7c.mo648toPx0680j_4(ArrowWidth) * values.getScale()) / 2.0f;
        arrow.mo1895translatek4lQ0M(OffsetKt.Offset((Offset.m1760getXimpl(bounds.m1790getCenterF1C5BW0()) + radius) - inset, Offset.m1761getYimpl(bounds.m1790getCenterF1C5BW0()) + ($this$drawArrow_u2d42QJj7c.mo648toPx0680j_4(StrokeWidth) / 2.0f)));
        arrow.close();
        float degrees$iv = values.getEndAngle();
        long pivot$iv = $this$drawArrow_u2d42QJj7c.mo2489getCenterF1C5BW0();
        DrawContext $this$withTransform_u24lambda_u2d6$iv$iv = $this$drawArrow_u2d42QJj7c.getDrawContext();
        long previousSize$iv$iv = $this$withTransform_u24lambda_u2d6$iv$iv.mo2415getSizeNHjbRc();
        $this$withTransform_u24lambda_u2d6$iv$iv.getCanvas().save();
        DrawTransform $this$rotate_Rg1IO4c_u24lambda_u2d0$iv = $this$withTransform_u24lambda_u2d6$iv$iv.getTransform();
        $this$rotate_Rg1IO4c_u24lambda_u2d0$iv.mo2421rotateUv8p0NA(degrees$iv, pivot$iv);
        DrawScope.m2481drawPathLG529CI$default($this$drawArrow_u2d42QJj7c, arrow, color, values.getAlpha(), null, null, 0, 56, null);
        $this$withTransform_u24lambda_u2d6$iv$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u2d6$iv$iv.mo2416setSizeuvyYCjk(previousSize$iv$iv);
    }
}
