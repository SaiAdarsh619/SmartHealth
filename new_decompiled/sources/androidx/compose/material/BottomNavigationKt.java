package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationConstants;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.AlphaKt;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.ColorKt;
import androidx.compose.p000ui.layout.AlignmentLineKt;
import androidx.compose.p000ui.layout.LayoutIdKt;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.semantics.Role;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.style.TextAlign;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.health.platform.client.SdkConfig;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: BottomNavigation.kt */
@Metadata(m286d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a[\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0014H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a=\u0010\u0017\u001a\u00020\t2\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\t0\u0019¢\u0006\u0002\b\u00132\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019¢\u0006\u0002\b\u00132\u0006\u0010\u001b\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010\u001c\u001aU\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2&\u0010\u0010\u001a\"\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0013H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u0095\u0001\u0010'\u001a\u00020\t*\u00020\u00122\u0006\u0010 \u001a\u00020!2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\u00192\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\t0\u0019¢\u0006\u0002\b\u00132\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020!2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019¢\u0006\u0002\b\u00132\b\b\u0002\u0010*\u001a\u00020!2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\r2\b\b\u0002\u0010.\u001a\u00020\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a)\u00101\u001a\u000202*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a9\u0010:\u001a\u000202*\u0002032\u0006\u0010;\u001a\u0002052\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010\u001b\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0007\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006>"}, m287d2 = {"BottomNavigationAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomNavigationHeight", "Landroidx/compose/ui/unit/Dp;", "F", "BottomNavigationItemHorizontalPadding", "CombinedItemTextBaseline", "BottomNavigation", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomNavigation-PEIptTM", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomNavigationItemBaselineLayout", "icon", "Lkotlin/Function0;", "label", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "BottomNavigationTransition", "activeColor", "inactiveColor", "selected", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "animationProgress", "BottomNavigationTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "BottomNavigationItem", "onClick", "enabled", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "BottomNavigationItem-jY6E1Zs", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;III)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class BottomNavigationKt {
    private static final TweenSpec<Float> BottomNavigationAnimationSpec = new TweenSpec<>(AnimationConstants.DefaultDurationMillis, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    private static final float BottomNavigationHeight = C0504Dp.m4382constructorimpl(56);
    private static final float BottomNavigationItemHorizontalPadding = C0504Dp.m4382constructorimpl(12);
    private static final float CombinedItemTextBaseline = C0504Dp.m4382constructorimpl(12);

    /* renamed from: BottomNavigation-PEIptTM, reason: not valid java name */
    public static final void m1248BottomNavigationPEIptTM(Modifier modifier, long backgroundColor, long contentColor, float elevation, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long contentColor2;
        float f;
        Modifier.Companion modifier3;
        long backgroundColor2;
        float elevation2;
        Modifier modifier4;
        long backgroundColor3;
        float elevation3;
        long contentColor3;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(456489494);
        ComposerKt.sourceInformation($composer2, "C(BottomNavigation)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)91@4097L6,92@4146L32,96@4289L403:BottomNavigation.kt#jmzs0o");
        final int $dirty = $changed;
        int i4 = i & 1;
        if (i4 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            if ((i & 2) == 0) {
                j = backgroundColor;
                if ($composer2.changed(j)) {
                    i3 = 32;
                    $dirty |= i3;
                }
            } else {
                j = backgroundColor;
            }
            i3 = 16;
            $dirty |= i3;
        } else {
            j = backgroundColor;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                contentColor2 = contentColor;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            f = elevation;
        } else if (($changed & 7168) == 0) {
            f = elevation;
            $dirty |= $composer2.changed(f) ? 2048 : 1024;
        } else {
            f = elevation;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changed(content) ? 16384 : 8192;
        }
        if ((46811 & $dirty) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            backgroundColor3 = j;
            contentColor3 = contentColor2;
            elevation3 = f;
            modifier4 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer2, 6));
                    $dirty &= -113;
                } else {
                    backgroundColor2 = j;
                }
                if ((i & 4) != 0) {
                    long contentColor4 = ColorsKt.m1335contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty >> 3) & 14);
                    $dirty &= -897;
                    contentColor2 = contentColor4;
                }
                elevation2 = i5 != 0 ? BottomNavigationDefaults.INSTANCE.m1247getElevationD9Ej5fM() : f;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier3 = modifier2;
                backgroundColor2 = j;
                elevation2 = f;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(456489494, $dirty, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:89)");
            }
            SurfaceKt.m1513SurfaceFjzlyU(modifier3, null, backgroundColor2, contentColor2, null, elevation2, ComposableLambdaKt.composableLambda($composer2, 678339930, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigation$1
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
                    float f2;
                    ComposerKt.sourceInformation($composer3, "C102@4443L243:BottomNavigation.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(678339930, $changed2, -1, "androidx.compose.material.BottomNavigation.<anonymous> (BottomNavigation.kt:101)");
                        }
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        f2 = BottomNavigationKt.BottomNavigationHeight;
                        Modifier modifier$iv = SelectableGroupKt.selectableGroup(SizeKt.m786height3ABfNKs(fillMaxWidth$default, f2));
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
                        Function3 content$iv = content;
                        int $changed$iv = (($dirty >> 3) & 7168) | 48;
                        $composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation($composer3, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & SdkConfig.SDK_VERSION));
                        int $changed$iv$iv = ($changed$iv << 3) & SdkConfig.SDK_VERSION;
                        $composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume = $composer3.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Density density$iv$iv = (Density) consume;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume2 = $composer3.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume3 = $composer3.consume(localViewConfiguration);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                        Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(factory$iv$iv$iv);
                        } else {
                            $composer3.useNode();
                        }
                        $composer3.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer3);
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer3.enableReusing();
                        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                        $composer3.startReplaceableGroup(2058660585);
                        $composer3.startReplaceableGroup(-678309503);
                        ComposerKt.sourceInformation($composer3, "C80@3988L9:Row.kt#2w3rfo");
                        if ((($changed$iv$iv$iv >> 9) & 14 & 11) == 2 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                        } else {
                            content$iv.invoke(RowScopeInstance.INSTANCE, $composer3, Integer.valueOf((($changed$iv >> 6) & SdkConfig.SDK_VERSION) | 6));
                        }
                        $composer3.endReplaceableGroup();
                        $composer3.endReplaceableGroup();
                        $composer3.endNode();
                        $composer3.endReplaceableGroup();
                        $composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, ($dirty & 14) | 1572864 | (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 6) & 458752), 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            backgroundColor3 = backgroundColor2;
            elevation3 = elevation2;
            contentColor3 = contentColor2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier4;
        final long j2 = backgroundColor3;
        final long j3 = contentColor3;
        final float f2 = elevation3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigation$2
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

            public final void invoke(Composer composer, int i6) {
                BottomNavigationKt.m1248BottomNavigationPEIptTM(Modifier.this, j2, j3, f2, content, composer, $changed | 1, i);
            }
        });
    }

    /* renamed from: BottomNavigationItem-jY6E1Zs, reason: not valid java name */
    public static final void m1249BottomNavigationItemjY6E1Zs(final RowScope BottomNavigationItem, final boolean selected, final Function0<Unit> onClick, final Function2<? super Composer, ? super Integer, Unit> icon, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function2, boolean alwaysShowLabel, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, Composer $composer, final int $changed, final int $changed1, final int i) {
        long j;
        final Function2 label;
        Modifier modifier2;
        boolean enabled2;
        MutableInteractionSource interactionSource2;
        long selectedContentColor2;
        long unselectedContentColor2;
        final int $dirty;
        int $dirty1;
        final boolean alwaysShowLabel2;
        MutableInteractionSource interactionSource3;
        boolean enabled3;
        Object value$iv$iv;
        Function2 label2;
        final Function2 styledLabel;
        boolean enabled4;
        MutableInteractionSource interactionSource4;
        boolean alwaysShowLabel3;
        long selectedContentColor3;
        boolean alwaysShowLabel4;
        Function2 label3;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(BottomNavigationItem, "$this$BottomNavigationItem");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Composer $composer2 = $composer.startRestartGroup(-1473735525);
        ComposerKt.sourceInformation($composer2, "C(BottomNavigationItem)P(7,6,2,5,1,4!2,8:c#ui.graphics.Color,9:c#ui.graphics.Color)154@7016L39,155@7109L7,156@7201L6,167@7704L61,169@7771L804:BottomNavigation.kt#jmzs0o");
        int $dirty2 = $changed;
        int $dirty12 = $changed1;
        if ((Integer.MIN_VALUE & i) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(BottomNavigationItem) ? 4 : 2;
        }
        if ((i & 1) != 0) {
            $dirty2 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer2.changed(selected) ? 32 : 16;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changed(onClick) ? 256 : 128;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer2.changed(icon) ? 2048 : 1024;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 24576;
        } else if ((57344 & $changed) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 16384 : 8192;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 458752) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 131072 : 65536;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty2 |= $composer2.changed(function2) ? 1048576 : 524288;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty2 |= $composer2.changed(alwaysShowLabel) ? 8388608 : 4194304;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer2.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 1879048192) == 0) {
            if ((i & 512) == 0 && $composer2.changed(selectedContentColor)) {
                i3 = 536870912;
                $dirty2 |= i3;
            }
            i3 = 268435456;
            $dirty2 |= i3;
        }
        if (($changed1 & 14) == 0) {
            if ((i & 1024) == 0) {
                j = unselectedContentColor;
                if ($composer2.changed(j)) {
                    i2 = 4;
                    $dirty12 |= i2;
                }
            } else {
                j = unselectedContentColor;
            }
            i2 = 2;
            $dirty12 |= i2;
        } else {
            j = unselectedContentColor;
        }
        if ((1533916891 & $dirty2) == 306783378 && ($dirty12 & 11) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            enabled4 = enabled;
            label3 = function2;
            alwaysShowLabel4 = alwaysShowLabel;
            interactionSource4 = interactionSource;
            selectedContentColor3 = selectedContentColor;
            unselectedContentColor2 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled5 = i5 != 0 ? true : enabled;
                label = i6 != 0 ? null : function2;
                boolean alwaysShowLabel5 = i7 != 0 ? true : alwaysShowLabel;
                if (i8 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer2.rememberedValue();
                    modifier2 = modifier3;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        enabled2 = enabled5;
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        enabled2 = enabled5;
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    modifier2 = modifier3;
                    enabled2 = enabled5;
                    interactionSource2 = interactionSource;
                }
                if ((i & 256) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    selectedContentColor2 = ((Color) consume).m2006unboximpl();
                    $dirty2 &= -1879048193;
                } else {
                    selectedContentColor2 = selectedContentColor;
                }
                if ((i & 512) != 0) {
                    unselectedContentColor2 = Color.m1994copywmQWz5c(r27, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(r27) : ContentAlpha.INSTANCE.getMedium($composer2, 6), (r12 & 2) != 0 ? Color.m2002getRedimpl(r27) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(r27) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(selectedContentColor2) : 0.0f);
                    $dirty = $dirty2;
                    $dirty1 = $dirty12 & (-15);
                    alwaysShowLabel2 = alwaysShowLabel5;
                    interactionSource3 = interactionSource2;
                    enabled3 = enabled2;
                } else {
                    unselectedContentColor2 = unselectedContentColor;
                    $dirty = $dirty2;
                    $dirty1 = $dirty12;
                    alwaysShowLabel2 = alwaysShowLabel5;
                    interactionSource3 = interactionSource2;
                    enabled3 = enabled2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 256) != 0) {
                    $dirty2 &= -1879048193;
                }
                if ((i & 512) != 0) {
                    $dirty12 &= -15;
                }
                modifier2 = modifier;
                enabled3 = enabled;
                label = function2;
                selectedContentColor2 = selectedContentColor;
                unselectedContentColor2 = unselectedContentColor;
                $dirty = $dirty2;
                $dirty1 = $dirty12;
                alwaysShowLabel2 = alwaysShowLabel;
                interactionSource3 = interactionSource;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1473735525, $dirty, $dirty1, "androidx.compose.material.BottomNavigationItem (BottomNavigation.kt:146)");
            }
            if (label != null) {
                label2 = label;
                styledLabel = ComposableLambdaKt.composableLambda($composer2, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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
                        ComposerKt.sourceInformation($composer3, "C160@7335L10,161@7401L40:BottomNavigation.kt#jmzs0o");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1343298261, $changed2, -1, "androidx.compose.material.BottomNavigationItem.<anonymous>.<anonymous> (BottomNavigation.kt:159)");
                            }
                            TextStyle style = TextStyle.m3965copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography($composer3, 6).getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, TextAlign.m4261boximpl(TextAlign.INSTANCE.m4268getCentere0LSkKk()), null, 0L, null, 245759, null);
                            TextKt.ProvideTextStyle(style, label, $composer3, ($dirty >> 15) & SdkConfig.SDK_VERSION);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                });
            } else {
                label2 = label;
                styledLabel = null;
            }
            Indication ripple = RippleKt.m1618rememberRipple9IZ8Weo(false, 0.0f, selectedContentColor2, $composer2, (($dirty >> 21) & 896) | 6, 2);
            Modifier modifier$iv = RowScope.weight$default(BottomNavigationItem, SelectableKt.m980selectableO2vRcR0(modifier2, selected, interactionSource3, ripple, enabled3, Role.m3825boximpl(Role.INSTANCE.m3837getTabo7Vup1c()), onClick), 1.0f, false, 2, null);
            Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
            enabled4 = enabled3;
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            interactionSource4 = interactionSource3;
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((48 >> 3) & 14) | ((48 >> 3) & SdkConfig.SDK_VERSION));
            int $changed$iv$iv = (48 << 3) & SdkConfig.SDK_VERSION;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume2;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer2.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer2);
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
            $composer2.startReplaceableGroup(2058660585);
            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
            $composer2.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation($composer2, "C72@3384L9:Box.kt#2w3rfo");
            if (($changed$iv & 11) == 2 && $composer2.getSkipping()) {
                $composer2.skipToGroupEnd();
                alwaysShowLabel3 = alwaysShowLabel2;
            } else {
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int $changed2 = ((48 >> 6) & SdkConfig.SDK_VERSION) | 6;
                $composer2.startReplaceableGroup(-1538530399);
                ComposerKt.sourceInformation($composer2, "C182@8148L421:BottomNavigation.kt#jmzs0o");
                if (($changed2 & 81) == 16 && $composer2.getSkipping()) {
                    $composer2.skipToGroupEnd();
                    alwaysShowLabel3 = alwaysShowLabel2;
                } else {
                    alwaysShowLabel3 = alwaysShowLabel2;
                    m1250BottomNavigationTransitionKlgxPg(selectedContentColor2, unselectedContentColor2, selected, ComposableLambdaKt.composableLambda($composer2, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer, Integer num) {
                            invoke(f.floatValue(), composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float progress, Composer $composer3, int $changed3) {
                            ComposerKt.sourceInformation($composer3, "C189@8378L181:BottomNavigation.kt#jmzs0o");
                            int $dirty3 = $changed3;
                            if (($changed3 & 14) == 0) {
                                $dirty3 |= $composer3.changed(progress) ? 4 : 2;
                            }
                            if (($dirty3 & 91) != 18 || !$composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1411872801, $changed3, -1, "androidx.compose.material.BottomNavigationItem.<anonymous>.<anonymous> (BottomNavigation.kt:186)");
                                }
                                float animationProgress = alwaysShowLabel2 ? 1.0f : progress;
                                BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, styledLabel, animationProgress, $composer3, ($dirty >> 9) & 14);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer3.skipToGroupEnd();
                        }
                    }), $composer2, (($dirty >> 27) & 14) | 3072 | (($dirty1 << 3) & SdkConfig.SDK_VERSION) | (($dirty << 3) & 896));
                }
                $composer2.endReplaceableGroup();
            }
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            selectedContentColor3 = selectedContentColor2;
            alwaysShowLabel4 = alwaysShowLabel3;
            label3 = label2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier2;
        final boolean z = enabled4;
        final Function2 function22 = label3;
        final boolean z2 = alwaysShowLabel4;
        final MutableInteractionSource mutableInteractionSource = interactionSource4;
        final long j2 = selectedContentColor3;
        final long j3 = unselectedContentColor2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

            public final void invoke(Composer composer, int i9) {
                BottomNavigationKt.m1249BottomNavigationItemjY6E1Zs(RowScope.this, selected, onClick, icon, modifier4, z, function22, z2, mutableInteractionSource, j2, j3, composer, $changed | 1, $changed1, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomNavigationTransition-Klgx-Pg, reason: not valid java name */
    public static final void m1250BottomNavigationTransitionKlgxPg(final long activeColor, final long inactiveColor, final boolean selected, final Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed) {
        long m1994copywmQWz5c;
        final int $dirty;
        Composer $composer2 = $composer.startRestartGroup(-985175058);
        ComposerKt.sourceInformation($composer2, "C(BottomNavigationTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)227@9693L128,234@9896L181:BottomNavigation.kt#jmzs0o");
        int $dirty2 = $changed;
        if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(activeColor) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer2.changed(inactiveColor) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changed(selected) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty2 |= $composer2.changed(function3) ? 2048 : 1024;
        }
        int $dirty3 = $dirty2;
        if (($dirty3 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-985175058, $dirty3, -1, "androidx.compose.material.BottomNavigationTransition (BottomNavigation.kt:221)");
            }
            final State animationProgress$delegate = AnimateAsStateKt.animateFloatAsState(selected ? 1.0f : 0.0f, BottomNavigationAnimationSpec, 0.0f, null, $composer2, 48, 12);
            long color = ColorKt.m2048lerpjxsXWHM(inactiveColor, activeColor, m1251BottomNavigationTransition_Klgx_Pg$lambda3(animationProgress$delegate));
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            m1994copywmQWz5c = Color.m1994copywmQWz5c(color, (r12 & 1) != 0 ? Color.m1998getAlphaimpl(color) : 1.0f, (r12 & 2) != 0 ? Color.m2002getRedimpl(color) : 0.0f, (r12 & 4) != 0 ? Color.m2001getGreenimpl(color) : 0.0f, (r12 & 8) != 0 ? Color.m1999getBlueimpl(color) : 0.0f);
            $dirty = $dirty3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{localContentColor.provides(Color.m1986boximpl(m1994copywmQWz5c)), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1998getAlphaimpl(color)))}, ComposableLambdaKt.composableLambda($composer2, -138092754, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationTransition$1
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
                    float m1251BottomNavigationTransition_Klgx_Pg$lambda3;
                    ComposerKt.sourceInformation($composer3, "C238@10045L26:BottomNavigation.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-138092754, $changed2, -1, "androidx.compose.material.BottomNavigationTransition.<anonymous> (BottomNavigation.kt:237)");
                        }
                        Function3<Float, Composer, Integer, Unit> function32 = function3;
                        m1251BottomNavigationTransition_Klgx_Pg$lambda3 = BottomNavigationKt.m1251BottomNavigationTransition_Klgx_Pg$lambda3(animationProgress$delegate);
                        function32.invoke(Float.valueOf(m1251BottomNavigationTransition_Klgx_Pg$lambda3), $composer3, Integer.valueOf(($dirty >> 6) & SdkConfig.SDK_VERSION));
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
        } else {
            $composer2.skipToGroupEnd();
            $dirty = $dirty3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationTransition$2
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
                BottomNavigationKt.m1250BottomNavigationTransitionKlgxPg(activeColor, inactiveColor, selected, function3, composer, $changed | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomNavigationTransition_Klgx_Pg$lambda-3, reason: not valid java name */
    public static final float m1251BottomNavigationTransition_Klgx_Pg$lambda3(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BottomNavigationItemBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final float iconPositionAnimationProgress, Composer $composer, final int $changed) {
        Function0 factory$iv$iv;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-1162995092);
        ComposerKt.sourceInformation($composer3, "C(BottomNavigationItemBaselineLayout)P(!1,2)259@10750L1203:BottomNavigation.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(function2) ? 4 : 2;
        }
        if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer3.changed(function22) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(iconPositionAnimationProgress) ? 256 : 128;
        }
        if (($dirty & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1162995092, $dirty, -1, "androidx.compose.material.BottomNavigationItemBaselineLayout (BottomNavigation.kt:253)");
            }
            MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItemBaselineLayout$2
                @Override // androidx.compose.p000ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo331measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long constraints) {
                    Placeable placeable;
                    MeasureResult m1257placeLabelAndIconDIyivk0;
                    MeasureResult m1256placeIcon3p2s80s;
                    long m4328copyZbe2FdA;
                    long j = constraints;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    List<? extends Measurable> $this$first$iv = measurables;
                    for (Object element$iv : $this$first$iv) {
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv), "icon")) {
                            Placeable iconPlaceable = ((Measurable) element$iv).mo3492measureBRTryo0(j);
                            Function2 it = function22;
                            if (it != null) {
                                List<? extends Measurable> $this$first$iv2 = measurables;
                                for (Object element$iv2 : $this$first$iv2) {
                                    Function2 it2 = it;
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv2), "label")) {
                                        m4328copyZbe2FdA = Constraints.m4328copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m4340getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m4338getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m4339getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m4337getMaxHeightimpl(constraints) : 0);
                                        placeable = ((Measurable) element$iv2).mo3492measureBRTryo0(m4328copyZbe2FdA);
                                    } else {
                                        it = it2;
                                    }
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            placeable = null;
                            Placeable labelPlaceable = placeable;
                            if (function22 == null) {
                                m1256placeIcon3p2s80s = BottomNavigationKt.m1256placeIcon3p2s80s(Layout, iconPlaceable, j);
                                return m1256placeIcon3p2s80s;
                            }
                            Intrinsics.checkNotNull(labelPlaceable);
                            m1257placeLabelAndIconDIyivk0 = BottomNavigationKt.m1257placeLabelAndIconDIyivk0(Layout, labelPlaceable, iconPlaceable, constraints, iconPositionAnimationProgress);
                            return m1257placeLabelAndIconDIyivk0;
                        }
                        j = constraints;
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            };
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.INSTANCE;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv = (Density) consume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            Function0 factory$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv = factory$iv$iv2;
                $composer3.createNode(factory$iv$iv);
            } else {
                factory$iv$iv = factory$iv$iv2;
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv = Updater.m1639constructorimpl($composer3);
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, density$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, layoutDirection$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv, viewConfiguration$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer3.enableReusing();
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & SdkConfig.SDK_VERSION));
            $composer3.startReplaceableGroup(2058660585);
            $composer3.startReplaceableGroup(395677717);
            ComposerKt.sourceInformation($composer3, "C261@10780L41,263@10871L253:BottomNavigation.kt#jmzs0o");
            if ((($changed$iv$iv >> 9) & 14 & 11) == 2 && $composer3.getSkipping()) {
                $composer3.skipToGroupEnd();
                $composer2 = $composer3;
            } else {
                Modifier modifier$iv2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "icon");
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & SdkConfig.SDK_VERSION));
                int $changed$iv$iv2 = (6 << 3) & SdkConfig.SDK_VERSION;
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer3.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv = (Density) consume4;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = $composer3.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume5;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = $composer3.consume(localViewConfiguration2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume6;
                Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv2);
                int $changed$iv$iv$iv = (($changed$iv$iv2 << 9) & 7168) | 6;
                $composer2 = $composer3;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(factory$iv$iv$iv);
                } else {
                    $composer3.useNode();
                }
                $composer3.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m1639constructorimpl($composer3);
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer3.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & SdkConfig.SDK_VERSION));
                $composer3.startReplaceableGroup(2058660585);
                int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                $composer3.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation($composer3, "C72@3384L9:Box.kt#2w3rfo");
                if (($changed$iv & 11) == 2 && $composer3.getSkipping()) {
                    $composer3.skipToGroupEnd();
                } else {
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int $changed2 = ((6 >> 6) & SdkConfig.SDK_VERSION) | 6;
                    $composer3.startReplaceableGroup(-1943403697);
                    ComposerKt.sourceInformation($composer3, "C261@10813L6:BottomNavigation.kt#jmzs0o");
                    if (($changed2 & 81) == 16 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                    } else {
                        function2.invoke($composer3, Integer.valueOf($dirty & 14));
                    }
                    $composer3.endReplaceableGroup();
                }
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
                if (function22 != null) {
                    Modifier modifier$iv3 = PaddingKt.m761paddingVpY3zN4$default(AlphaKt.alpha(LayoutIdKt.layoutId(Modifier.INSTANCE, "label"), iconPositionAnimationProgress), BottomNavigationItemHorizontalPadding, 0.0f, 2, null);
                    $composer3.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & SdkConfig.SDK_VERSION));
                    int $changed$iv$iv3 = (0 << 3) & SdkConfig.SDK_VERSION;
                    $composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume7 = $composer3.consume(localDensity3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Density density$iv$iv2 = (Density) consume7;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume8 = $composer3.consume(localLayoutDirection3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume8;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume9 = $composer3.consume(localViewConfiguration3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume9;
                    Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv3);
                    int $changed$iv$iv$iv2 = (($changed$iv$iv3 << 9) & 7168) | 6;
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        $composer3.createNode(factory$iv$iv$iv2);
                    } else {
                        $composer3.useNode();
                    }
                    $composer3.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m1639constructorimpl($composer3);
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                    Updater.m1646setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                    $composer3.enableReusing();
                    skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m1629boximpl(SkippableUpdater.m1630constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & SdkConfig.SDK_VERSION));
                    $composer3.startReplaceableGroup(2058660585);
                    int $changed$iv2 = ($changed$iv$iv$iv2 >> 9) & 14;
                    $composer3.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer3, "C72@3384L9:Box.kt#2w3rfo");
                    if (($changed$iv2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                    } else {
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        int $changed3 = ((0 >> 6) & SdkConfig.SDK_VERSION) | 6;
                        $composer3.startReplaceableGroup(150842644);
                        ComposerKt.sourceInformation($composer3, "C268@11115L7:BottomNavigation.kt#jmzs0o");
                        if (($changed3 & 81) == 16 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                        } else {
                            function22.invoke($composer3, Integer.valueOf(($dirty >> 3) & 14));
                        }
                        $composer3.endReplaceableGroup();
                    }
                    $composer3.endReplaceableGroup();
                    $composer3.endReplaceableGroup();
                    $composer3.endNode();
                    $composer3.endReplaceableGroup();
                    $composer3.endReplaceableGroup();
                }
            }
            $composer3.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItemBaselineLayout$3
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
                BottomNavigationKt.BottomNavigationItemBaselineLayout(function2, function22, iconPositionAnimationProgress, composer, $changed | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeIcon-3p2s80s, reason: not valid java name */
    public static final MeasureResult m1256placeIcon3p2s80s(MeasureScope $this$placeIcon_u2d3p2s80s, final Placeable iconPlaceable, long constraints) {
        int height = Constraints.m4337getMaxHeightimpl(constraints);
        final int iconY = (height - iconPlaceable.getHeight()) / 2;
        return MeasureScope.layout$default($this$placeIcon_u2d3p2s80s, iconPlaceable.getWidth(), height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$placeIcon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable.PlacementScope.placeRelative$default(layout, Placeable.this, 0, iconY, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-DIyivk0, reason: not valid java name */
    public static final MeasureResult m1257placeLabelAndIconDIyivk0(MeasureScope $this$placeLabelAndIcon_u2dDIyivk0, final Placeable labelPlaceable, final Placeable iconPlaceable, long constraints, final float iconPositionAnimationProgress) {
        int height = Constraints.m4337getMaxHeightimpl(constraints);
        int baseline = labelPlaceable.get(AlignmentLineKt.getLastBaseline());
        int baselineOffset = $this$placeLabelAndIcon_u2dDIyivk0.mo642roundToPx0680j_4(CombinedItemTextBaseline);
        final int labelY = (height - baseline) - baselineOffset;
        int unselectedIconY = (height - iconPlaceable.getHeight()) / 2;
        final int selectedIconY = (height - (baselineOffset * 2)) - iconPlaceable.getHeight();
        int containerWidth = Math.max(labelPlaceable.getWidth(), iconPlaceable.getWidth());
        final int labelX = (containerWidth - labelPlaceable.getWidth()) / 2;
        final int iconX = (containerWidth - iconPlaceable.getWidth()) / 2;
        int iconDistance = unselectedIconY - selectedIconY;
        final int offset = MathKt.roundToInt(iconDistance * (1 - iconPositionAnimationProgress));
        return MeasureScope.layout$default($this$placeLabelAndIcon_u2dDIyivk0, containerWidth, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$placeLabelAndIcon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                if (!(iconPositionAnimationProgress == 0.0f)) {
                    Placeable.PlacementScope.placeRelative$default(layout, labelPlaceable, labelX, labelY + offset, 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(layout, iconPlaceable, iconX, selectedIconY + offset, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
