package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.layout.LayoutModifierKt;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.Velocity;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidOverscroll.kt */
@Metadata(m286d1 = {"\u0000\u0017\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0001\u001a\r\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\t\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\n\n\u0002\u0010\u0004\u0012\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m287d2 = {"NoOpOverscrollEffect", "androidx/compose/foundation/AndroidOverscrollKt$NoOpOverscrollEffect$1", "getNoOpOverscrollEffect$annotations", "()V", "Landroidx/compose/foundation/AndroidOverscrollKt$NoOpOverscrollEffect$1;", "StretchOverscrollNonClippingLayer", "Landroidx/compose/ui/Modifier;", "rememberOverscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/OverscrollEffect;", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AndroidOverscrollKt {
    private static final AndroidOverscrollKt$NoOpOverscrollEffect$1 NoOpOverscrollEffect = new OverscrollEffect() { // from class: androidx.compose.foundation.AndroidOverscrollKt$NoOpOverscrollEffect$1
        private boolean isEnabled;

        @Override // androidx.compose.foundation.OverscrollEffect
        /* renamed from: consumePreScroll-OzD1aCk */
        public long mo490consumePreScrollOzD1aCk(long scrollDelta, int source) {
            return Offset.INSTANCE.m1776getZeroF1C5BW0();
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        /* renamed from: consumePostScroll-OMhpSzk */
        public void mo488consumePostScrollOMhpSzk(long initialDragDelta, long overscrollDelta, int source) {
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        /* renamed from: consumePreFling-QWom1Mo */
        public Object mo489consumePreFlingQWom1Mo(long velocity, Continuation<? super Velocity> continuation) {
            return Velocity.m4598boximpl(Velocity.INSTANCE.m4618getZero9UxMQ8M());
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        /* renamed from: consumePostFling-sF-c-tU */
        public Object mo487consumePostFlingsFctU(long velocity, Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        /* renamed from: isEnabled, reason: from getter */
        public boolean getIsEnabled() {
            return this.isEnabled;
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        public void setEnabled(boolean z) {
            this.isEnabled = z;
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        public boolean isInProgress() {
            return false;
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        public Modifier getEffectModifier() {
            return Modifier.INSTANCE;
        }
    };
    private static final Modifier StretchOverscrollNonClippingLayer;

    private static /* synthetic */ void getNoOpOverscrollEffect$annotations() {
    }

    public static final OverscrollEffect rememberOverscrollEffect(Composer $composer, int $changed) {
        AndroidOverscrollKt$NoOpOverscrollEffect$1 androidOverscrollKt$NoOpOverscrollEffect$1;
        Object value$iv$iv;
        $composer.startReplaceableGroup(-81138291);
        ComposerKt.sourceInformation($composer, "C(rememberOverscrollEffect)63@2802L7,64@2856L7,65@2875L186:AndroidOverscroll.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-81138291, $changed, -1, "androidx.compose.foundation.rememberOverscrollEffect (AndroidOverscroll.kt:62)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Context context = (Context) consume;
        ProvidableCompositionLocal<OverscrollConfiguration> localOverscrollConfiguration = OverscrollConfigurationKt.getLocalOverscrollConfiguration();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer.consume(localOverscrollConfiguration);
        ComposerKt.sourceInformationMarkerEnd($composer);
        OverscrollConfiguration config = (OverscrollConfiguration) consume2;
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(context) | $composer.changed(config);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            if (config == null) {
                androidOverscrollKt$NoOpOverscrollEffect$1 = NoOpOverscrollEffect;
            } else {
                androidOverscrollKt$NoOpOverscrollEffect$1 = new AndroidEdgeEffectOverscrollEffect(context, config);
            }
            value$iv$iv = androidOverscrollKt$NoOpOverscrollEffect$1;
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        OverscrollEffect overscrollEffect = (OverscrollEffect) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return overscrollEffect;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.foundation.AndroidOverscrollKt$NoOpOverscrollEffect$1] */
    static {
        Modifier.Companion companion;
        if (Build.VERSION.SDK_INT >= 31) {
            companion = LayoutModifierKt.layout(LayoutModifierKt.layout(Modifier.INSTANCE, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                    return m492invoke3p2s80s(measureScope, measurable, constraints.getValue());
                }

                /* renamed from: invoke-3p2s80s, reason: not valid java name */
                public final MeasureResult m492invoke3p2s80s(MeasureScope layout, Measurable measurable, long constraints) {
                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                    Intrinsics.checkNotNullParameter(measurable, "measurable");
                    final Placeable placeable = measurable.mo3492measureBRTryo0(constraints);
                    float arg0$iv = ClipScrollableContainerKt.getMaxSupportedElevation();
                    final int extraSizePx = layout.mo642roundToPx0680j_4(C0504Dp.m4382constructorimpl(2 * arg0$iv));
                    return MeasureScope.layout$default(layout, placeable.getMeasuredWidth() - extraSizePx, placeable.getMeasuredHeight() - extraSizePx, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1.1
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
                        public final void invoke2(Placeable.PlacementScope layout2) {
                            Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                            Placeable.PlacementScope.placeWithLayer$default(layout2, Placeable.this, ((-extraSizePx) / 2) - ((Placeable.this.getWidth() - Placeable.this.getMeasuredWidth()) / 2), ((-extraSizePx) / 2) - ((Placeable.this.getHeight() - Placeable.this.getMeasuredHeight()) / 2), 0.0f, null, 12, null);
                        }
                    }, 4, null);
                }
            }), new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                    return m493invoke3p2s80s(measureScope, measurable, constraints.getValue());
                }

                /* renamed from: invoke-3p2s80s, reason: not valid java name */
                public final MeasureResult m493invoke3p2s80s(MeasureScope layout, Measurable measurable, long constraints) {
                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                    Intrinsics.checkNotNullParameter(measurable, "measurable");
                    final Placeable placeable = measurable.mo3492measureBRTryo0(constraints);
                    float arg0$iv = ClipScrollableContainerKt.getMaxSupportedElevation();
                    final int extraSizePx = layout.mo642roundToPx0680j_4(C0504Dp.m4382constructorimpl(2 * arg0$iv));
                    int width = placeable.getWidth() + extraSizePx;
                    int height = placeable.getHeight() + extraSizePx;
                    return MeasureScope.layout$default(layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2.1
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
                        public final void invoke2(Placeable.PlacementScope layout2) {
                            Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                            Placeable.PlacementScope.place$default(layout2, Placeable.this, extraSizePx / 2, extraSizePx / 2, 0.0f, 4, null);
                        }
                    }, 4, null);
                }
            });
        } else {
            companion = Modifier.INSTANCE;
        }
        StretchOverscrollNonClippingLayer = companion;
    }
}
